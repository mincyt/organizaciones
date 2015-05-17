package organizaciones.domain

import java.util.Date;

class IdentificadorExternoAsignado {

	Organizacion autoridaddedesignacion
	String denominacion
	Date fechaDeFinalizacion
	Date fechaDeInicio
	String valor
	Organizacion organizacion
	IdentificadorExterno identificadorexterno
	Estado estado

	static hasMany = [
		comentarios : Comentario,
	]
	static constraints = {
	}

	static mapping = {
		table 'identificadorexternoasignado'
		id column:'identificadorexternoasignadoid'
		estado column: 'estadoid'
		organizacion column: 'organizacionid'
		identificadorexterno column: 'identificadorexternoid'
		fechaDeInicio column: 'fechadeinicio'
		fechaDeFinalizacion column: 'fechadefinalizacion'
		comentarios	joinTable: [
			name: 'identificadorexternotienecomentario',
			column : 'comentarioid',
			key : 'identificadorexternoid'
		]
		dateCreated column: 'creadocuando'
		lastUpdated column: 'modificadocuando'
	}

	def String toString() {
		denominacion
	}
}
