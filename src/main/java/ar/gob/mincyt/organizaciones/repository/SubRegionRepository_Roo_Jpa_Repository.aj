// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ar.gob.mincyt.organizaciones.repository;

import ar.gob.mincyt.organizaciones.domain.SubRegion;
import ar.gob.mincyt.organizaciones.repository.SubRegionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

privileged aspect SubRegionRepository_Roo_Jpa_Repository {
    
    declare parents: SubRegionRepository extends JpaRepository<SubRegion, Long>;
    
    declare parents: SubRegionRepository extends JpaSpecificationExecutor<SubRegion>;
    
    declare @type: SubRegionRepository: @Repository;
    
}
