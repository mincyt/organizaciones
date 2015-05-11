package ar.gob.mincyt.organizaciones.web;
import ar.gob.mincyt.organizaciones.domain.Idioma;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.gvnix.addon.web.mvc.addon.jquery.GvNIXWebJQuery;
import ar.gob.mincyt.organizaciones.domain.IdiomaBatchService;
import org.gvnix.addon.web.mvc.addon.batch.GvNIXWebJpaBatch;

@RequestMapping("/idiomas")
@Controller
@RooWebScaffold(path = "idiomas", formBackingObject = Idioma.class)
@GvNIXWebJQuery
@GvNIXWebJpaBatch(service = IdiomaBatchService.class)
public class IdiomaController {
}
