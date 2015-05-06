package ar.gob.mincyt.organizaciones.web;
import ar.gob.mincyt.organizaciones.domain.NombreDeOrganizacion;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/nombresdeorganizacion")
@Controller
@RooWebScaffold(path = "nombresdeorganizacion", formBackingObject = NombreDeOrganizacion.class)
public class NombreDeOrganizacionController {
}
