package organizaciones.domain

class RelacionOrganizacion {

	Boolean esPersonal
	Boolean esVigente = true
	Date fechaFin
	Date fechaInicio
	Integer precedenciaGeneral = 0
	Organizacion organizacionOrigen
	Organizacion organizacionRelacionada
	TaxonomiaOrganizacional taxonomiaOrganizacional
	Estado estado
	TipoDeRelacion tipoDeRelacion
		
    static constraints = {
		organizacionOrigen ()
		organizacionRelacionada validator: {
			val, obj ->
			! obj.organizacionRelacionada.equals(obj.organizacionOrigen)
		}
		tipoDeRelacion()
		esVigente()
		fechaInicio()
		fechaFin nullable:true
    }
	
	static hasMany = [ comentarios: RelacionTieneComentario ]

	static mapping = {
		table 'relacionorganizacion'
		id column: 'relacionorganizacionid'
		esPersonal column: 'espersonal'
		esVigente column: 'esvigente'
		fechaFin column: 'fechafin'
		fechaInicio column: 'fechainicio'
		precedenciaGeneral column: 'precedenciageneral'
		organizacionOrigen column: 'organizacionorigenid'
		organizacionRelacionada column: 'organizacionrelacionadaid'
		taxonomiaOrganizacional column: 'taxonomiaorganizacionalid'
		tipoDeRelacion column: 'tiporelacionid'
		estado column: 'estadoid'
		version false
		autoTimestamp false
	}	
}
