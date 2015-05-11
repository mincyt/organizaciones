package ar.gob.mincyt.organizaciones.web;
import ar.gob.mincyt.organizaciones.domain.NombreDeOrganizacion;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.gvnix.addon.web.mvc.addon.jquery.GvNIXWebJQuery;
import ar.gob.mincyt.organizaciones.domain.NombreDeOrganizacionBatchService;
import org.gvnix.addon.web.mvc.addon.batch.GvNIXWebJpaBatch;

@RequestMapping("/nombredeorganizacions")
@Controller
@RooWebScaffold(path = "nombredeorganizacions", formBackingObject = NombreDeOrganizacion.class)
@GvNIXWebJQuery
@GvNIXWebJpaBatch(service = NombreDeOrganizacionBatchService.class)
public class NombreDeOrganizacionController {
}
