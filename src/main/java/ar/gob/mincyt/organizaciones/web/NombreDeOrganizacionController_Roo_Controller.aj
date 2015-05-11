// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ar.gob.mincyt.organizaciones.web;

import ar.gob.mincyt.organizaciones.domain.Estado;
import ar.gob.mincyt.organizaciones.domain.Idioma;
import ar.gob.mincyt.organizaciones.domain.NombreDeOrganizacion;
import ar.gob.mincyt.organizaciones.domain.Organizacion;
import ar.gob.mincyt.organizaciones.web.NombreDeOrganizacionController;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect NombreDeOrganizacionController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String NombreDeOrganizacionController.create(@Valid NombreDeOrganizacion nombreDeOrganizacion, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, nombreDeOrganizacion);
            return "nombredeorganizacions/create";
        }
        uiModel.asMap().clear();
        nombreDeOrganizacion.persist();
        return "redirect:/nombredeorganizacions/" + encodeUrlPathSegment(nombreDeOrganizacion.getNombredeorganizacionid().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String NombreDeOrganizacionController.createForm(Model uiModel) {
        populateEditForm(uiModel, new NombreDeOrganizacion());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (Organizacion.countOrganizacions() == 0) {
            dependencies.add(new String[] { "organizacion", "organizacions" });
        }
        if (Idioma.countIdiomas() == 0) {
            dependencies.add(new String[] { "idioma", "idiomas" });
        }
        if (Estado.countEstadoes() == 0) {
            dependencies.add(new String[] { "estado", "estadoes" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "nombredeorganizacions/create";
    }
    
    @RequestMapping(value = "/{nombredeorganizacionid}", produces = "text/html")
    public String NombreDeOrganizacionController.show(@PathVariable("nombredeorganizacionid") Long nombredeorganizacionid, Model uiModel) {
        uiModel.addAttribute("nombredeorganizacion", NombreDeOrganizacion.findNombreDeOrganizacion(nombredeorganizacionid));
        uiModel.addAttribute("itemId", nombredeorganizacionid);
        return "nombredeorganizacions/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String NombreDeOrganizacionController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("nombredeorganizacions", NombreDeOrganizacion.findNombreDeOrganizacionEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) NombreDeOrganizacion.countNombreDeOrganizacions() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("nombredeorganizacions", NombreDeOrganizacion.findAllNombreDeOrganizacions(sortFieldName, sortOrder));
        }
        return "nombredeorganizacions/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String NombreDeOrganizacionController.update(@Valid NombreDeOrganizacion nombreDeOrganizacion, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, nombreDeOrganizacion);
            return "nombredeorganizacions/update";
        }
        uiModel.asMap().clear();
        nombreDeOrganizacion.merge();
        return "redirect:/nombredeorganizacions/" + encodeUrlPathSegment(nombreDeOrganizacion.getNombredeorganizacionid().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{nombredeorganizacionid}", params = "form", produces = "text/html")
    public String NombreDeOrganizacionController.updateForm(@PathVariable("nombredeorganizacionid") Long nombredeorganizacionid, Model uiModel) {
        populateEditForm(uiModel, NombreDeOrganizacion.findNombreDeOrganizacion(nombredeorganizacionid));
        return "nombredeorganizacions/update";
    }
    
    @RequestMapping(value = "/{nombredeorganizacionid}", method = RequestMethod.DELETE, produces = "text/html")
    public String NombreDeOrganizacionController.delete(@PathVariable("nombredeorganizacionid") Long nombredeorganizacionid, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        NombreDeOrganizacion nombreDeOrganizacion = NombreDeOrganizacion.findNombreDeOrganizacion(nombredeorganizacionid);
        nombreDeOrganizacion.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/nombredeorganizacions";
    }
    
    void NombreDeOrganizacionController.populateEditForm(Model uiModel, NombreDeOrganizacion nombreDeOrganizacion) {
        uiModel.addAttribute("nombreDeOrganizacion", nombreDeOrganizacion);
        uiModel.addAttribute("estadoes", Estado.findAllEstadoes());
        uiModel.addAttribute("idiomas", Idioma.findAllIdiomas());
        uiModel.addAttribute("organizacions", Organizacion.findAllOrganizacions());
    }
    
    String NombreDeOrganizacionController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}