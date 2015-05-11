package ar.gob.mincyt.organizaciones.web;
import ar.gob.mincyt.organizaciones.domain.Organizacion;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.gvnix.addon.web.mvc.addon.jquery.GvNIXWebJQuery;
import ar.gob.mincyt.organizaciones.domain.OrganizacionBatchService;
import org.gvnix.addon.web.mvc.addon.batch.GvNIXWebJpaBatch;

@RequestMapping("/organizacions")
@Controller
@RooWebScaffold(path = "organizacions", formBackingObject = Organizacion.class)
@GvNIXWebJQuery
@GvNIXWebJpaBatch(service = OrganizacionBatchService.class)
public class OrganizacionController {
}
