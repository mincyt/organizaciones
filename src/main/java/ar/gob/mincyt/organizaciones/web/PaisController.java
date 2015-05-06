package ar.gob.mincyt.organizaciones.web;
import ar.gob.mincyt.organizaciones.domain.Pais;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/paises")
@Controller
@RooWebScaffold(path = "paises", formBackingObject = Pais.class)
public class PaisController {
}
