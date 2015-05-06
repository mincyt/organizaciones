package ar.gob.mincyt.organizaciones.repository;
import ar.gob.mincyt.organizaciones.domain.Idioma;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Idioma.class)
public interface IdiomaRepository {
}
