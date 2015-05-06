package ar.gob.mincyt.organizaciones.domain;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.plural.RooPlural;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaEntity(identifierField = "estadoid", schema = "organizaciones")	
@RooPlural("Estados")
public class Estado {

    /**
     */
    @NotNull
    @Column(unique = true)
    private String denominacion;
}
