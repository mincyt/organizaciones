// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ar.gob.mincyt.organizaciones.service;

import ar.gob.mincyt.organizaciones.domain.NombreDeOrganizacion;
import ar.gob.mincyt.organizaciones.repository.NombreDeOrganizacionRepository;
import ar.gob.mincyt.organizaciones.service.NombreDeOrganizacionServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect NombreDeOrganizacionServiceImpl_Roo_Service {
    
    declare @type: NombreDeOrganizacionServiceImpl: @Service;
    
    declare @type: NombreDeOrganizacionServiceImpl: @Transactional;
    
    @Autowired
    NombreDeOrganizacionRepository NombreDeOrganizacionServiceImpl.nombreDeOrganizacionRepository;
    
    public long NombreDeOrganizacionServiceImpl.countAllNombresDeOrganizacion() {
        return nombreDeOrganizacionRepository.count();
    }
    
    public void NombreDeOrganizacionServiceImpl.deleteNombreDeOrganizacion(NombreDeOrganizacion nombreDeOrganizacion) {
        nombreDeOrganizacionRepository.delete(nombreDeOrganizacion);
    }
    
    public NombreDeOrganizacion NombreDeOrganizacionServiceImpl.findNombreDeOrganizacion(Long id) {
        return nombreDeOrganizacionRepository.findOne(id);
    }
    
    public List<NombreDeOrganizacion> NombreDeOrganizacionServiceImpl.findAllNombresDeOrganizacion() {
        return nombreDeOrganizacionRepository.findAll();
    }
    
    public List<NombreDeOrganizacion> NombreDeOrganizacionServiceImpl.findNombreDeOrganizacionEntries(int firstResult, int maxResults) {
        return nombreDeOrganizacionRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }
    
    public void NombreDeOrganizacionServiceImpl.saveNombreDeOrganizacion(NombreDeOrganizacion nombreDeOrganizacion) {
        nombreDeOrganizacionRepository.save(nombreDeOrganizacion);
    }
    
    public NombreDeOrganizacion NombreDeOrganizacionServiceImpl.updateNombreDeOrganizacion(NombreDeOrganizacion nombreDeOrganizacion) {
        return nombreDeOrganizacionRepository.save(nombreDeOrganizacion);
    }
    
}
