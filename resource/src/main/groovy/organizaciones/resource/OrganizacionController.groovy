package organizaciones.resource

import org.springframework.cloud.security.oauth2.resource.EnableOAuth2Resource
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@EnableOAuth2Resource
class OrganizacionController {
	
	@RequestMapping('/public/bleh')
	def home() {
		[id: UUID.randomUUID().toString(), content: 'Hello World']
	}

	@RequestMapping('/management/nope')
	def nope() {
		[id: UUID.randomUUID().toString(), content: 'Ups']
	}
}
