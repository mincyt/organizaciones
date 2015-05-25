package organizaciones

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.orm.jpa.EntityScan
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
@EntityScan
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
