package ar.gob.mincyt.organizaciones.web;
import ar.gob.mincyt.organizaciones.domain.Estado;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.gvnix.addon.web.mvc.addon.jquery.GvNIXWebJQuery;
import ar.gob.mincyt.organizaciones.domain.EstadoBatchService;
import org.gvnix.addon.web.mvc.addon.batch.GvNIXWebJpaBatch;

@RequestMapping("/estadoes")
@Controller
@RooWebScaffold(path = "estadoes", formBackingObject = Estado.class)
@GvNIXWebJQuery
@GvNIXWebJpaBatch(service = EstadoBatchService.class)
public class EstadoController {
}
