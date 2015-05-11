// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ar.gob.mincyt.organizaciones.web.converter;

import ar.gob.mincyt.organizaciones.domain.Estado;
import ar.gob.mincyt.organizaciones.web.converter.EstadoConverter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

privileged aspect EstadoConverter_Roo_Converter {
    
    declare @type: EstadoConverter: @FacesConverter("ar.gob.mincyt.organizaciones.web.converter.EstadoConverter");
    
    public Object EstadoConverter.getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        Long id = Long.parseLong(value);
        return Estado.findEstado(id);
    }
    
    public String EstadoConverter.getAsString(FacesContext context, UIComponent component, Object value) {
        return value instanceof Estado ? ((Estado) value).getEstadoid().toString() : "";
    }
    
}
