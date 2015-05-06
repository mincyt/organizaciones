// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ar.gob.mincyt.organizaciones.web;

import ar.gob.mincyt.organizaciones.domain.SubRegion;
import ar.gob.mincyt.organizaciones.service.EstadoService;
import ar.gob.mincyt.organizaciones.service.RegionService;
import ar.gob.mincyt.organizaciones.service.SubRegionService;
import ar.gob.mincyt.organizaciones.web.SubRegionController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect SubRegionController_Roo_Controller {
    
    @Autowired
    SubRegionService SubRegionController.subRegionService;
    
    @Autowired
    EstadoService SubRegionController.estadoService;
    
    @Autowired
    RegionService SubRegionController.regionService;
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String SubRegionController.create(@Valid SubRegion subRegion, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, subRegion);
            return "subregiones/create";
        }
        uiModel.asMap().clear();
        subRegionService.saveSubRegion(subRegion);
        return "redirect:/subregiones/" + encodeUrlPathSegment(subRegion.getSubregionid().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String SubRegionController.createForm(Model uiModel) {
        populateEditForm(uiModel, new SubRegion());
        return "subregiones/create";
    }
    
    @RequestMapping(value = "/{subregionid}", produces = "text/html")
    public String SubRegionController.show(@PathVariable("subregionid") Long subregionid, Model uiModel) {
        uiModel.addAttribute("subregion", subRegionService.findSubRegion(subregionid));
        uiModel.addAttribute("itemId", subregionid);
        return "subregiones/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String SubRegionController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("subregiones", subRegionService.findSubRegionEntries(firstResult, sizeNo));
            float nrOfPages = (float) subRegionService.countAllSubRegiones() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("subregiones", subRegionService.findAllSubRegiones());
        }
        return "subregiones/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String SubRegionController.update(@Valid SubRegion subRegion, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, subRegion);
            return "subregiones/update";
        }
        uiModel.asMap().clear();
        subRegionService.updateSubRegion(subRegion);
        return "redirect:/subregiones/" + encodeUrlPathSegment(subRegion.getSubregionid().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{subregionid}", params = "form", produces = "text/html")
    public String SubRegionController.updateForm(@PathVariable("subregionid") Long subregionid, Model uiModel) {
        populateEditForm(uiModel, subRegionService.findSubRegion(subregionid));
        return "subregiones/update";
    }
    
    @RequestMapping(value = "/{subregionid}", method = RequestMethod.DELETE, produces = "text/html")
    public String SubRegionController.delete(@PathVariable("subregionid") Long subregionid, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        SubRegion subRegion = subRegionService.findSubRegion(subregionid);
        subRegionService.deleteSubRegion(subRegion);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/subregiones";
    }
    
    void SubRegionController.populateEditForm(Model uiModel, SubRegion subRegion) {
        uiModel.addAttribute("subRegion", subRegion);
        uiModel.addAttribute("estados", estadoService.findAllEstados());
        uiModel.addAttribute("regiones", regionService.findAllRegiones());
    }
    
    String SubRegionController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
