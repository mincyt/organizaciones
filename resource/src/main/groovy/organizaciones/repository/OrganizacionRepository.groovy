package organizaciones.repository

import org.springframework.data.repository.PagingAndSortingRepository
import organizaciones.domain.Organizacion;


interface OrganizacionRepository extends PagingAndSortingRepository<Organizacion, Long> {
	
}