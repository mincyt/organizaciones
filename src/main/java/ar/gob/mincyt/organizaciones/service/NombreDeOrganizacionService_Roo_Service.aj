// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ar.gob.mincyt.organizaciones.service;

import ar.gob.mincyt.organizaciones.domain.NombreDeOrganizacion;
import ar.gob.mincyt.organizaciones.service.NombreDeOrganizacionService;
import java.util.List;

privileged aspect NombreDeOrganizacionService_Roo_Service {
    
    public abstract long NombreDeOrganizacionService.countAllNombresDeOrganizacion();    
    public abstract void NombreDeOrganizacionService.deleteNombreDeOrganizacion(NombreDeOrganizacion nombreDeOrganizacion);    
    public abstract NombreDeOrganizacion NombreDeOrganizacionService.findNombreDeOrganizacion(Long id);    
    public abstract List<NombreDeOrganizacion> NombreDeOrganizacionService.findAllNombresDeOrganizacion();    
    public abstract List<NombreDeOrganizacion> NombreDeOrganizacionService.findNombreDeOrganizacionEntries(int firstResult, int maxResults);    
    public abstract void NombreDeOrganizacionService.saveNombreDeOrganizacion(NombreDeOrganizacion nombreDeOrganizacion);    
    public abstract NombreDeOrganizacion NombreDeOrganizacionService.updateNombreDeOrganizacion(NombreDeOrganizacion nombreDeOrganizacion);    
}
