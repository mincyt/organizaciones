// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ar.gob.mincyt.organizaciones.domain;

import ar.gob.mincyt.organizaciones.domain.Idioma;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

privileged aspect Idioma_Roo_Jpa_Entity {
    
    declare @type: Idioma: @Entity;
    
    declare @type: Idioma: @Table(schema = "organizaciones");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idiomaid")
    private Long Idioma.idiomaid;
    
    @Version
    @Column(name = "version")
    private Integer Idioma.version;
    
    public Long Idioma.getIdiomaid() {
        return this.idiomaid;
    }
    
    public void Idioma.setIdiomaid(Long id) {
        this.idiomaid = id;
    }
    
    public Integer Idioma.getVersion() {
        return this.version;
    }
    
    public void Idioma.setVersion(Integer version) {
        this.version = version;
    }
    
}
