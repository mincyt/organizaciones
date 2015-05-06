package ar.gob.mincyt.organizaciones.web;
import ar.gob.mincyt.organizaciones.domain.TipoDeCategoria;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tiposdecategorias")
@Controller
@RooWebScaffold(path = "tiposdecategorias", formBackingObject = TipoDeCategoria.class)
public class TipoDeCategoriaController {
}
