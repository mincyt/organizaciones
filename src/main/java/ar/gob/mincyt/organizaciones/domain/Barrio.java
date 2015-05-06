package ar.gob.mincyt.organizaciones.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.plural.RooPlural;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooJpaEntity(identifierField = "barrioid", schema = "organizaciones")
@RooPlural("Barrios")
public class Barrio {

    /**
     */
	@NotNull
    private String denominacion;

    /**
     */
	@NotNull
    @ManyToOne
    @JoinColumn(name = "estadoid")
    private Estado estado;

    /**
     */
    @ManyToOne
    @JoinColumn(name = "ciudadid")
    private Ciudad ciudad;
}
