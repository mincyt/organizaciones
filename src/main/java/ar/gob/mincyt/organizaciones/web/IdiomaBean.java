package ar.gob.mincyt.organizaciones.web;
import ar.gob.mincyt.organizaciones.domain.Idioma;
import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = Idioma.class, beanName = "idiomaBean")
public class IdiomaBean {
}
