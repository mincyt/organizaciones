package ar.gob.mincyt.organizaciones.web.converter;
import ar.gob.mincyt.organizaciones.domain.Estado;
import javax.faces.convert.Converter;
import org.springframework.roo.addon.jsf.converter.RooJsfConverter;

@RooJsfConverter(entity = Estado.class)
public class EstadoConverter implements Converter {
}
