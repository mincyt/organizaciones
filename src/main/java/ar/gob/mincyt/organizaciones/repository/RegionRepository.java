package ar.gob.mincyt.organizaciones.repository;
import ar.gob.mincyt.organizaciones.domain.Region;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Region.class)
public interface RegionRepository {
}
