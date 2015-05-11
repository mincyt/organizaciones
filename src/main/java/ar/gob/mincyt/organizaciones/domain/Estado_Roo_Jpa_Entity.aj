// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ar.gob.mincyt.organizaciones.domain;

import ar.gob.mincyt.organizaciones.domain.Estado;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

privileged aspect Estado_Roo_Jpa_Entity {
    
    declare @type: Estado: @Entity;
    
    declare @type: Estado: @Table(schema = "organizaciones");
    
    @Id
    @SequenceGenerator(name = "estadoGen", sequenceName = "ESTADO_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "estadoGen")
    @Column(name = "estadoid")
    private Long Estado.estadoid;
    
    @Version
    @Column(name = "version")
    private Integer Estado.version;
    
    public Long Estado.getEstadoid() {
        return this.estadoid;
    }
    
    public void Estado.setEstadoid(Long id) {
        this.estadoid = id;
    }
    
    public Integer Estado.getVersion() {
        return this.version;
    }
    
    public void Estado.setVersion(Integer version) {
        this.version = version;
    }
    
}
