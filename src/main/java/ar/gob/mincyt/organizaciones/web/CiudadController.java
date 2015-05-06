package ar.gob.mincyt.organizaciones.web;
import ar.gob.mincyt.organizaciones.domain.Ciudad;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ciudades")
@Controller
@RooWebScaffold(path = "ciudades", formBackingObject = Ciudad.class)
public class CiudadController {
}
