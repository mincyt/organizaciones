package ar.gob.mincyt.organizaciones.web;
import ar.gob.mincyt.organizaciones.domain.Idioma;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/idiomas")
@Controller
@RooWebScaffold(path = "idiomas", formBackingObject = Idioma.class)
public class IdiomaController {
}
