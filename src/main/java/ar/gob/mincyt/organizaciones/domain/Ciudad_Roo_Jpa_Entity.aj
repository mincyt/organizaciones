// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ar.gob.mincyt.organizaciones.domain;

import ar.gob.mincyt.organizaciones.domain.Ciudad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

privileged aspect Ciudad_Roo_Jpa_Entity {
    
    declare @type: Ciudad: @Entity;
    
    declare @type: Ciudad: @Table(schema = "organizaciones");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ciudadid")
    private Long Ciudad.ciudadid;
    
    @Version
    @Column(name = "version")
    private Integer Ciudad.version;
    
    public Long Ciudad.getCiudadid() {
        return this.ciudadid;
    }
    
    public void Ciudad.setCiudadid(Long id) {
        this.ciudadid = id;
    }
    
    public Integer Ciudad.getVersion() {
        return this.version;
    }
    
    public void Ciudad.setVersion(Integer version) {
        this.version = version;
    }
    
}
