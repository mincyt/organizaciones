package organizaciones.repository

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository

import organizaciones.domain.NombreDeOrganizacion;
import organizaciones.domain.Organizacion;


interface OrganizacionRepository extends PagingAndSortingRepository<Organizacion, Long> {

	Page<NombreDeOrganizacion> findByNombresDenominacionLikeIgnoreCase(String denominacion, Pageable pageable);
	
}