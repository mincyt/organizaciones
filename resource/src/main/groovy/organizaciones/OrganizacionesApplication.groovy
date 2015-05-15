package organizaciones

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@SpringBootApplication
class OrganizacionesApplication {

	static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run OrganizacionesApplication, args

    }

	@Configuration
	@Order(-10)
	protected static class ResourceServerConfiguration extends
			ResourceServerConfigurerAdapter {
	
		def void configure(HttpSecurity http) throws Exception {
			http
				.anonymous().and()
				.authorizeRequests()
				.antMatchers("/public/**").permitAll()
				.antMatchers("/management/**").authenticated()
				;
		}
	}
}
