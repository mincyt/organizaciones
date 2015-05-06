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
@RooJpaEntity(identifierField = "paisid", schema = "organizaciones")
@RooPlural("Paises")
public class Pais {

    /**
     */
	@NotNull
    private String denominacion;

    /**
     */
	@NotNull
    private String codigoISO2;

    /**
     */
	@NotNull
    private String codigoISO3;

    /**
     */
	@NotNull
    private String nombreISO;

    /**
     */
	@NotNull
    private String gentilicio;

    /**
     */
	@NotNull
    @ManyToOne
    @JoinColumn(name = "estadoid")
    private Estado estado;
}
