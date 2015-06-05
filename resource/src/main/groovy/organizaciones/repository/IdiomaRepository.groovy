package organizaciones.repository

import org.springframework.data.repository.PagingAndSortingRepository

import organizaciones.domain.Idioma
import organizaciones.domain.Organizacion;

interface IdiomaRepository extends PagingAndSortingRepository<Idioma, Long>  {

}
