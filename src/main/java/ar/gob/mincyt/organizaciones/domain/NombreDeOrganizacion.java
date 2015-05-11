package ar.gob.mincyt.organizaciones.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierField = "nombredeorganizacionid", schema = "organizaciones")
public class NombreDeOrganizacion {

    /**
     */
    @NotNull
    private String denominacion;

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
}
