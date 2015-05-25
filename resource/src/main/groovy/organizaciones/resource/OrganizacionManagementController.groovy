package organizaciones.resource

import org.springframework.cloud.security.oauth2.resource.EnableOAuth2Resource
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@EnableOAuth2Resource
@RequestMapping('/management/organizacion')
class OrganizacionManagementController {

	@RequestMapping('/nope')
    @Secured(["ROLE_USER"])
	def nope() {
		[id: UUID.randomUUID().toString(), content: 'Ups']
	}

}
