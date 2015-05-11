package ar.gob.mincyt.organizaciones.web;
import ar.gob.mincyt.organizaciones.domain.NombreDeOrganizacion;
import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = NombreDeOrganizacion.class, beanName = "nombreDeOrganizacionBean")
public class NombreDeOrganizacionBean {
}
