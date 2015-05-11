package ar.gob.mincyt.organizaciones.web.converter;
import ar.gob.mincyt.organizaciones.domain.Idioma;
import javax.faces.convert.Converter;
import org.springframework.roo.addon.jsf.converter.RooJsfConverter;

@RooJsfConverter(entity = Idioma.class)
public class IdiomaConverter implements Converter {
}
