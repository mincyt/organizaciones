package organizaciones.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import organizaciones.domain.RelacionOrganizacion

interface RelacionOrganizacionRepository extends PagingAndSortingRepository<RelacionOrganizacion, Long>{
	Page<RelacionOrganizacion> findByOrganizacionOrigenId(Long id, Pageable pageable);
	Page<RelacionOrganizacion> findByOrganizacionRelacionadaId(Long id, Pageable pageable);
}
