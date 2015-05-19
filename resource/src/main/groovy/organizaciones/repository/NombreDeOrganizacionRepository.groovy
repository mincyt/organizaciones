package organizaciones.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import organizaciones.domain.NombreDeOrganizacion

interface NombreDeOrganizacionRepository extends PagingAndSortingRepository<NombreDeOrganizacion, Long> {

	List<NombreDeOrganizacion> findByDenominacion(String denominacion)
	
	List<NombreDeOrganizacion> findByDenominacionLikeIgnoreCase(String denominacion)
	
	Page<NombreDeOrganizacion> findByDenominacionLikeIgnoreCase(String denominacion, Pageable pageable);
	
}
