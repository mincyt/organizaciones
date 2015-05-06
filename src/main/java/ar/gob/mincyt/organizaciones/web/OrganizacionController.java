package ar.gob.mincyt.organizaciones.web;
import ar.gob.mincyt.organizaciones.domain.Organizacion;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/organizaciones")
@Controller
@RooWebScaffold(path = "organizaciones", formBackingObject = Organizacion.class)
public class OrganizacionController {
}
