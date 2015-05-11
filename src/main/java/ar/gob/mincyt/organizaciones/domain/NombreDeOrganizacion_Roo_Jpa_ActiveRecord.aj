// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ar.gob.mincyt.organizaciones.domain;

import ar.gob.mincyt.organizaciones.domain.NombreDeOrganizacion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect NombreDeOrganizacion_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager NombreDeOrganizacion.entityManager;
    
    public static final List<String> NombreDeOrganizacion.fieldNames4OrderClauseFilter = java.util.Arrays.asList("denominacion", "esSigla", "esDenominacionPreferida", "organizacion", "idioma", "estado");
    
    public static final EntityManager NombreDeOrganizacion.entityManager() {
        EntityManager em = new NombreDeOrganizacion().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long NombreDeOrganizacion.countNombreDeOrganizacions() {
        return entityManager().createQuery("SELECT COUNT(o) FROM NombreDeOrganizacion o", Long.class).getSingleResult();
    }
    
    public static List<NombreDeOrganizacion> NombreDeOrganizacion.findAllNombreDeOrganizacions() {
        return entityManager().createQuery("SELECT o FROM NombreDeOrganizacion o", NombreDeOrganizacion.class).getResultList();
    }
    
    public static List<NombreDeOrganizacion> NombreDeOrganizacion.findAllNombreDeOrganizacions(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM NombreDeOrganizacion o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, NombreDeOrganizacion.class).getResultList();
    }
    
    public static NombreDeOrganizacion NombreDeOrganizacion.findNombreDeOrganizacion(Long nombredeorganizacionid) {
        if (nombredeorganizacionid == null) return null;
        return entityManager().find(NombreDeOrganizacion.class, nombredeorganizacionid);
    }
    
    public static List<NombreDeOrganizacion> NombreDeOrganizacion.findNombreDeOrganizacionEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM NombreDeOrganizacion o", NombreDeOrganizacion.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<NombreDeOrganizacion> NombreDeOrganizacion.findNombreDeOrganizacionEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM NombreDeOrganizacion o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, NombreDeOrganizacion.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void NombreDeOrganizacion.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void NombreDeOrganizacion.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            NombreDeOrganizacion attached = NombreDeOrganizacion.findNombreDeOrganizacion(this.nombredeorganizacionid);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void NombreDeOrganizacion.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void NombreDeOrganizacion.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public NombreDeOrganizacion NombreDeOrganizacion.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        NombreDeOrganizacion merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}