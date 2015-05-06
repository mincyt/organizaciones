package ar.gob.mincyt.organizaciones.repository;
import ar.gob.mincyt.organizaciones.domain.SubRegion;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = SubRegion.class)
public interface SubRegionRepository {
}
