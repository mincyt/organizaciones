package ar.gob.mincyt.organizaciones.web;
import ar.gob.mincyt.organizaciones.domain.Barrio;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/barrios")
@Controller
@RooWebScaffold(path = "barrios", formBackingObject = Barrio.class)
public class BarrioController {
}
