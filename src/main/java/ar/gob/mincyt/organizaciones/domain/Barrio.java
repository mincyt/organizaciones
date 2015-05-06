package ar.gob.mincyt.organizaciones.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaEntity(identifierField = "barrioid", schema = "organizaciones")
public class Barrio {

    /**
     */
    private String denominacion;

    /**
     */
    @ManyToOne
    @JoinColumn(name = "estadoid")
    private Estado estado;

    /**
     */
    @ManyToOne
    @JoinColumn(name = "ciudadid")
    private Ciudad ciudad;
}
