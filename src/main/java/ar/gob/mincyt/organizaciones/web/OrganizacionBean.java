package ar.gob.mincyt.organizaciones.web;
import ar.gob.mincyt.organizaciones.domain.Organizacion;
import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = Organizacion.class, beanName = "organizacionBean")
public class OrganizacionBean {
}
