package ar.gob.mincyt.organizaciones.web.converter;
import ar.gob.mincyt.organizaciones.domain.TipoDeCategoria;
import javax.faces.convert.Converter;
import org.springframework.roo.addon.jsf.converter.RooJsfConverter;

@RooJsfConverter(entity = TipoDeCategoria.class)
public class TipoDeCategoriaConverter implements Converter {
}
