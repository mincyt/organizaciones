package ar.gob.mincyt.organizaciones.repository;
import ar.gob.mincyt.organizaciones.domain.NombreDeOrganizacion;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = NombreDeOrganizacion.class)
public interface NombreDeOrganizacionRepository {
}
