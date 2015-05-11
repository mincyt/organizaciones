// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ar.gob.mincyt.organizaciones.domain;

import ar.gob.mincyt.organizaciones.domain.Organizacion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Organizacion_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Organizacion.entityManager;
    
    public static final List<String> Organizacion.fieldNames4OrderClauseFilter = java.util.Arrays.asList("vigente", "tipoDeCategoria", "estado", "fechaDeInicio", "fechaDeFinalizacion", "nombreDeOrganizacions");
    
    public static final EntityManager Organizacion.entityManager() {
        EntityManager em = new Organizacion().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Organizacion.countOrganizacions() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Organizacion o", Long.class).getSingleResult();
    }
    
    public static List<Organizacion> Organizacion.findAllOrganizacions() {
        return entityManager().createQuery("SELECT o FROM Organizacion o", Organizacion.class).getResultList();
    }
    
    public static List<Organizacion> Organizacion.findAllOrganizacions(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Organizacion o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Organizacion.class).getResultList();
    }
    
    public static Organizacion Organizacion.findOrganizacion(Long organizacionid) {
        if (organizacionid == null) return null;
        return entityManager().find(Organizacion.class, organizacionid);
    }
    
    public static List<Organizacion> Organizacion.findOrganizacionEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Organizacion o", Organizacion.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Organizacion> Organizacion.findOrganizacionEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Organizacion o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Organizacion.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Organizacion.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Organizacion.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Organizacion attached = Organizacion.findOrganizacion(this.organizacionid);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Organizacion.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Organizacion.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Organizacion Organizacion.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Organizacion merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}