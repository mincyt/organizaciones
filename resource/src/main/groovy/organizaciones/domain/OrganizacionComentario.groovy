package organizaciones.domain

import org.hibernate.mapping.DenormalizedTable;

/**
 * OrganizacionComentario
 * A domain class describes the data object and it's mapping to the database
 */
class OrganizacionComentario extends Comentario {
	
	
	static	belongsTo	= [organizacion : Organizacion ]	// tells GORM to cascade commands: e.g., delete this object if the "parent" is deleted.
	
    static	mapping = {
		table 'organizaciontienecomentario'
		id column: 'comentarioid'
		organizacion column: 'organizacionid'
    }
    
	static	constraints = {
    }
	
}
