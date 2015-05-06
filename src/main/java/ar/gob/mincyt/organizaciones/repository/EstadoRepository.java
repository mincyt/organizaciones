package ar.gob.mincyt.organizaciones.repository;
import ar.gob.mincyt.organizaciones.domain.Estado;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Estado.class)
public interface EstadoRepository {
}
