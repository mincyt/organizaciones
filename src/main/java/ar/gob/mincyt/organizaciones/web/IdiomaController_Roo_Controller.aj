// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ar.gob.mincyt.organizaciones.web;

import ar.gob.mincyt.organizaciones.domain.Estado;
import ar.gob.mincyt.organizaciones.domain.Idioma;
import ar.gob.mincyt.organizaciones.web.IdiomaController;
import java.io.UnsupportedEncodingException;
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

privileged aspect IdiomaController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String IdiomaController.create(@Valid Idioma idioma, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, idioma);
            return "idiomas/create";
        }
        uiModel.asMap().clear();
        idioma.persist();
        return "redirect:/idiomas/" + encodeUrlPathSegment(idioma.getIdiomaid().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String IdiomaController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Idioma());
        return "idiomas/create";
    }
    
    @RequestMapping(value = "/{idiomaid}", produces = "text/html")
    public String IdiomaController.show(@PathVariable("idiomaid") Long idiomaid, Model uiModel) {
        uiModel.addAttribute("idioma", Idioma.findIdioma(idiomaid));
        uiModel.addAttribute("itemId", idiomaid);
        return "idiomas/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String IdiomaController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("idiomas", Idioma.findIdiomaEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Idioma.countIdiomas() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("idiomas", Idioma.findAllIdiomas(sortFieldName, sortOrder));
        }
        return "idiomas/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String IdiomaController.update(@Valid Idioma idioma, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, idioma);
            return "idiomas/update";
        }
        uiModel.asMap().clear();
        idioma.merge();
        return "redirect:/idiomas/" + encodeUrlPathSegment(idioma.getIdiomaid().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{idiomaid}", params = "form", produces = "text/html")
    public String IdiomaController.updateForm(@PathVariable("idiomaid") Long idiomaid, Model uiModel) {
        populateEditForm(uiModel, Idioma.findIdioma(idiomaid));
        return "idiomas/update";
    }
    
    @RequestMapping(value = "/{idiomaid}", method = RequestMethod.DELETE, produces = "text/html")
    public String IdiomaController.delete(@PathVariable("idiomaid") Long idiomaid, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Idioma idioma = Idioma.findIdioma(idiomaid);
        idioma.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/idiomas";
    }
    
    void IdiomaController.populateEditForm(Model uiModel, Idioma idioma) {
        uiModel.addAttribute("idioma", idioma);
        uiModel.addAttribute("estadoes", Estado.findAllEstadoes());
    }
    
    String IdiomaController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
