package ar.gob.mincyt.organizaciones.web;
import ar.gob.mincyt.organizaciones.domain.TipoDeCategoria;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.gvnix.addon.web.mvc.addon.jquery.GvNIXWebJQuery;
import ar.gob.mincyt.organizaciones.domain.TipoDeCategoriaBatchService;
import org.gvnix.addon.web.mvc.addon.batch.GvNIXWebJpaBatch;

@RequestMapping("/tipodecategorias")
@Controller
@RooWebScaffold(path = "tipodecategorias", formBackingObject = TipoDeCategoria.class)
@GvNIXWebJQuery
@GvNIXWebJpaBatch(service = TipoDeCategoriaBatchService.class)
public class TipoDeCategoriaController {
}
