package ar.gob.mincyt.organizaciones.web.converter;
import ar.gob.mincyt.organizaciones.domain.Organizacion;
import javax.faces.convert.Converter;
import org.springframework.roo.addon.jsf.converter.RooJsfConverter;

@RooJsfConverter(entity = Organizacion.class)
public class OrganizacionConverter implements Converter {
}
