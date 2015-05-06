package ar.gob.mincyt.organizaciones.repository;
import ar.gob.mincyt.organizaciones.domain.Pais;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Pais.class)
public interface PaisRepository {
}
