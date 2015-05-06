package ar.gob.mincyt.organizaciones.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.plural.RooPlural;
import org.springframework.roo.addon.tostring.RooToString;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString
@RooJpaEntity(identifierField = "organizacionid", schema = "organizaciones")
@RooPlural("Organizaciones")
public class Organizacion {

    /**
     */
    @NotNull
    @Value("true")
    private Boolean vigente;

    /**
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "tipodecategoriaid")
    private TipoDeCategoria tipoDeCategoria;

    /**
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "estadoid")
    private Estado estado;

    /**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaDeInicio;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaDeFinalizacion;
}
