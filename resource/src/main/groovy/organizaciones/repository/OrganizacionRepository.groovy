package organizaciones.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import organizaciones.domain.NombreDeOrganizacion
import organizaciones.domain.Organizacion




interface OrganizacionRepository extends PagingAndSortingRepository<Organizacion, Long> {

	Page<NombreDeOrganizacion> findByNombresDenominacionLikeIgnoreCase(String denominacion, Pageable pageable);
	
	@Query(value="""WITH RECURSIVE ancestros(distancia, origen, relacionada) AS 
        (
			SELECT 1 as distancia, organizacionorigenid as origen,organizacionrelacionadaid as relacionada 
				FROM organizaciones.relacionorganizacion r 
				INNER JOIN organizaciones.tipoderelacion tr ON tr.tipoderelacionid = r.tiporelacionid AND tr.denominacion = :relacion
				where organizacionorigenid=:organizacionid 
			UNION 
		    SELECT ancestros.distancia + 1, p.organizacionorigenid, p.organizacionrelacionadaid 
				FROM organizaciones.relacionorganizacion p 
				INNER JOIN ancestros ON ancestros.relacionada = p.organizacionorigenid 
				WHERE p.organizacionorigenid = ancestros.relacionada 
		) 
		SELECT b.* from ancestros 
		INNER JOIN organizaciones.organizacion b ON b.organizacionid = relacionada
		ORDER BY distancia desc""",
		nativeQuery = true)
	List<Organizacion> ancestros(@Param("relacion") String relacion,
                                 @Param("organizacionid") Long organizacionid)
}