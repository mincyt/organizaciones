// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ar.gob.mincyt.organizaciones.service;

import ar.gob.mincyt.organizaciones.domain.Organizacion;
import ar.gob.mincyt.organizaciones.service.OrganizacionService;
import java.util.List;

privileged aspect OrganizacionService_Roo_Service {
    
    public abstract long OrganizacionService.countAllOrganizaciones();    
    public abstract void OrganizacionService.deleteOrganizacion(Organizacion organizacion);    
    public abstract Organizacion OrganizacionService.findOrganizacion(Long id);    
    public abstract List<Organizacion> OrganizacionService.findAllOrganizaciones();    
    public abstract List<Organizacion> OrganizacionService.findOrganizacionEntries(int firstResult, int maxResults);    
    public abstract void OrganizacionService.saveOrganizacion(Organizacion organizacion);    
    public abstract Organizacion OrganizacionService.updateOrganizacion(Organizacion organizacion);    
}