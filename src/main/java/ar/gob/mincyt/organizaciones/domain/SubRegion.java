package ar.gob.mincyt.organizaciones.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaEntity(identifierField = "subregionid", schema = "organizaciones", table = "subregion")
public class SubRegion {

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
    @JoinColumn(name = "regionid")
    private Region region;
}
