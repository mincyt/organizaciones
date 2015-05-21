package organizaciones.resource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.security.oauth2.resource.EnableOAuth2Resource
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import organizaciones.repository.NombreDeOrganizacionRepository
import organizaciones.repository.OrganizacionRepository

@RestController
@EnableOAuth2Resource
@RequestMapping('/public')
class OrganizacionController {
	
	@Autowired
	OrganizacionRepository organizacionRepository;
	
	@Autowired
	NombreDeOrganizacionRepository nombreDeOrganizacionRepository;
	
	@RequestMapping('/cuantas')
	def cuantas() {
		organizacionRepository.count();
	}
	
	@RequestMapping(value='/buscar')
	def buscar(def @RequestParam('q') String q, 
		@RequestParam(value='start',required=false, defaultValue='0') int start, 
		@RequestParam(value='rows',required=false, defaultValue='5') int rows) {
		if (q.size() < 3) {
			//throw new MethodArgumentNotValidException("q lenght should be greater than 3")	
		}
		//nombreDeOrganizacionRepository.findByDenominacionLikeIgnoreCase('%'+q+'%', new PageRequest(start, rows))
		organizacionRepository.findByNombresDenominacionLikeIgnoreCase('%'+q+'%', new PageRequest(start, rows))
	}

	@RequestMapping('/:id')
	def buscarPorId(def @RequestParam('id') id) {
		organizacionRepository.find(id)
	}
	
	@RequestMapping('/todas')
	def todas(
		@RequestParam(value='start',required=false, defaultValue='0') int start, 
		@RequestParam(value='rows',required=false, defaultValue='5') int rows) {
		//nombreDeO
		organizacionRepository.findAll(new PageRequest(start, rows))
	}

}
