package ar.gob.mincyt.security;

import java.io.IOException;
import java.security.KeyPair;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@Controller
@SessionAttributes("authorizationRequest")
@EnableResourceServer
@EntityScan
public class AuthserverApplication extends WebMvcConfigurerAdapter {

	@RequestMapping("/user")
	@ResponseBody
	public Principal user(Principal user) {
		return user;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/oauth/confirm_access").setViewName("authorize");
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(AuthserverApplication.class, args);
//		UserRepository userRepository = (UserRepository)ctx.getBean(UserRepository.class);
//		PasswordEncoder cuds = (PasswordEncoder) ctx.getBean(PasswordEncoder.class);
//		cuds.encode("admin")
//		cuds.createUser("mcarboni", "mcarboni@mincyt.gob.ar", "mcarboni");
//		User admin = userRepository.findByUsername("Administrador");
//		admin.setEmail("mcarboni@mincyt.gob.ar");
//		admin.setPassword(cuds.encode("admin"));
//		userRepository.save(admin);
	}

	@Configuration
	@Order(-10)
	protected static class LoginConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		private AuthenticationManager authenticationManager;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http
				.formLogin().loginPage("/login").permitAll()
			.and()
				.requestMatchers().antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access", "/")
			.and()
				.authorizeRequests().anyRequest().authenticated()
			.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login");
			// @formatter:on
		}

		private static PasswordEncoder encoder;

	    @Autowired
	    private UserDetailsService customUserDetailsService;

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			// auth.parentAuthenticationManager(authenticationManager);
			auth.userDetailsService(customUserDetailsService).passwordEncoder(
					passwordEncoder());
		}

		@Bean
	    public PasswordEncoder passwordEncoder() {
	        if(encoder == null) {
	            encoder = new BCryptPasswordEncoder();
	        }

	        return encoder;
	    }}

	@Configuration
	@EnableAuthorizationServer
	protected static class OAuth2AuthorizationConfig extends
			AuthorizationServerConfigurerAdapter {

		@Autowired
		private AuthenticationManager authenticationManager;

		@Bean
		public JwtAccessTokenConverter jwtAccessTokenConverter() {
			JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
			KeyPair keyPair = new KeyStoreKeyFactory(
					new ClassPathResource("keystore.jks"), "foobar".toCharArray())
					.getKeyPair("test");
			converter.setKeyPair(keyPair);
			return converter;
		}
		
		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			clients.inMemory()
					.withClient("organizaciones")
					.secret("organizacionessecret")
					.authorizedGrantTypes("authorization_code", "refresh_token",
							"password")
							.scopes("openid")
							.autoApprove(true)
							;
		}

		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints)
				throws Exception {
			endpoints.authenticationManager(authenticationManager).accessTokenConverter(
					jwtAccessTokenConverter());
		}

		@Override
		public void configure(AuthorizationServerSecurityConfigurer oauthServer)
				throws Exception {
			oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess(
					"isAuthenticated()");
		}

	}
}
