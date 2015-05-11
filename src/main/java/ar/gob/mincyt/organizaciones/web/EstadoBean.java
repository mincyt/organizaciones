package ar.gob.mincyt.organizaciones.web;
import ar.gob.mincyt.organizaciones.domain.Estado;
import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = Estado.class, beanName = "estadoBean")
public class EstadoBean {
}
