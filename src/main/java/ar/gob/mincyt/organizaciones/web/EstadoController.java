package ar.gob.mincyt.organizaciones.web;
import ar.gob.mincyt.organizaciones.domain.Estado;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/estados")
@Controller
@RooWebScaffold(path = "estados", formBackingObject = Estado.class)
public class EstadoController {
}
