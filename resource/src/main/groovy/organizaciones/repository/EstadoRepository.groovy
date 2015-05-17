package organizaciones.repository

import org.springframework.data.repository.PagingAndSortingRepository
import organizaciones.domain.Estado

interface EstadoRepository extends PagingAndSortingRepository<Estado, Long> {

}
