package organizaciones.resource

import org.springframework.cloud.security.oauth2.resource.EnableOAuth2Resource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@EnableOAuth2Resource
@RequestMapping('/management/organizacion')
class OrganizacionManagementController {

	@RequestMapping('/nope')
	def nope() {
		[id: UUID.randomUUID().toString(), content: 'Ups']
	}

}
