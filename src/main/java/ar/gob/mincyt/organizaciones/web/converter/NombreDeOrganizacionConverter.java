package ar.gob.mincyt.organizaciones.web.converter;
import ar.gob.mincyt.organizaciones.domain.NombreDeOrganizacion;
import javax.faces.convert.Converter;
import org.springframework.roo.addon.jsf.converter.RooJsfConverter;

@RooJsfConverter(entity = NombreDeOrganizacion.class)
public class NombreDeOrganizacionConverter implements Converter {
}
