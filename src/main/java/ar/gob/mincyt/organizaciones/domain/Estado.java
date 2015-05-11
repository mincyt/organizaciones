package ar.gob.mincyt.organizaciones.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(sequenceName = "ESTADO_SEQ", identifierField = "estadoid", schema = "organizaciones")
public class Estado {

    /**
     */
    @NotNull
    @Column(unique = true)
    private String denominacion;
}
