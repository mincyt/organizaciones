package ar.gob.mincyt.organizaciones.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.plural.RooPlural;
import org.springframework.roo.addon.tostring.RooToString;

import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;

@RooJavaBean
@RooToString
@RooJpaEntity(identifierField = "nombredeorganizacionid", schema = "organizaciones")
@RooPlural("NombresDeOrganizacion")
public class NombreDeOrganizacion {

    /**
     */
    @NotNull
    private String denominacion;

    /**
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "organizacionid")
    private Organizacion organizacion;

    /**
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "idiomaid")
    private Idioma idioma;

    /**
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "estadoid")
    private Estado estado;

    /**
     */
    @NotNull
    @Column(name = "essigla")
    private Boolean esSigla;

    /**
     */
    @NotNull
    @Column(name = "esdenominacionpreferida")
    private Boolean esDenominacionPreferida;
}
