package ar.gob.mincyt.organizaciones.repository;
import ar.gob.mincyt.organizaciones.domain.Organizacion;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Organizacion.class)
public interface OrganizacionRepository {
}
