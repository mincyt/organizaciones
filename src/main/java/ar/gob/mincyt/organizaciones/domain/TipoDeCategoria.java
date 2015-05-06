package ar.gob.mincyt.organizaciones.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.plural.RooPlural;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaEntity(identifierField = "tipodecategoriaid", schema = "organizaciones")
@RooPlural("TiposDeCategorias")
public class TipoDeCategoria {

    /**
     */
    @NotNull
    @Column(unique = true)
    private String denominacion;

    /**
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "estadoid")
    private Estado estado;
}
