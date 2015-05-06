package ar.gob.mincyt.organizaciones.repository;
import ar.gob.mincyt.organizaciones.domain.TipoDeCategoria;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = TipoDeCategoria.class)
public interface TipoDeCategoriaRepository {
}
