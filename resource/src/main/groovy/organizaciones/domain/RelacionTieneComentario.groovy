package organizaciones.domain

/**
 * RelacionTieneComentario
 * A domain class describes the data object and it's mapping to the database
 */
class RelacionTieneComentario extends Comentario {
	
	static	belongsTo	= [relacion : RelacionOrganizacion ]	// tells GORM to cascade commands: e.g., delete this object if the "parent" is deleted.
	
	static	mapping = {
		table 'relaciondeorganizaciontienecomentario'
		id column: 'comentarioid'
		relacion column: 'relaciondeorganizacionid'
	}
	
	static	constraints = {
	}

}
