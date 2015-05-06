package ar.gob.mincyt.organizaciones.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaEntity(identifierField = "idiomaid", schema = "organizaciones")
public class Idioma {

    /**
     */
    @NotNull
    @Column(unique = true)
    private String denominacion;

    /**
     */
    @NotNull
    @Column(unique = true)
    private String identificadorISO;

    /**
     */
    @NotNull
    @Column(unique = true)
    private String nombreISO;

    /**
     */
    @ManyToOne
    @JoinColumn(name = "estadoid")
    private Estado estado;
}
