package organizaciones.resource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.security.oauth2.resource.EnableOAuth2Resource
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import organizaciones.repository.IdiomaRepository

@RestController
@EnableOAuth2Resource
@RequestMapping('/management/idioma')
class IdiomaResource {

	@Autowired
	IdiomaRepository idiomaRepository;
		
	@RequestMapping(value='/{id}',method=RequestMethod.GET)
	def buscarPorId(def @PathVariable('id') long id) {
		idiomaRepository.findOne(id)
	}
	
	@RequestMapping(value='',method=RequestMethod.GET)
	def todos(
		@RequestParam(value='start',required=false, defaultValue='0') int start,
		@RequestParam(value='rows',required=false, defaultValue='5') int rows) {
		//nombreDeO
		idiomaRepository.findAll(new PageRequest(start, rows))
	}

}
