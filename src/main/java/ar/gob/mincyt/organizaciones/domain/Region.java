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
@RooJpaEntity(identifierField = "regionid", schema = "organizaciones")
@RooPlural("Regiones")
public class Region {

    /**
     */
	@NotNull
    private String denominacion;

    /**
     */
	@NotNull
    private String codigoISO;

    /**
     */
	@NotNull
    private String nombreISO;

    /**
     */
    @ManyToOne
    @JoinColumn(name = "estadoid")
    @NotNull
    private Estado estado;

    /**
     */
    @ManyToOne
    @JoinColumn(name = "paisid")
    @NotNull
    private Pais pais;
}
