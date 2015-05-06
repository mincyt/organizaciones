package ar.gob.mincyt.organizaciones.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaEntity(identifierField = "regionid", schema = "organizaciones")
public class Region {

    /**
     */
    private String denominacion;

    /**
     */
    private String codigoISO;

    /**
     */
    private String nombreISO;

    /**
     */
    @ManyToOne
    @JoinColumn(name = "estadoid")
    private Estado estado;

    /**
     */
    @ManyToOne
    @JoinColumn(name = "paisid")
    private Pais pais;
}
