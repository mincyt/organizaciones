package organizaciones.domain

class TipoDePuntoDeContacto {

	String denominacion
	Estado estado

	static constraints = {
	}

	static mapping = {
		table 'tipodepuntodecontacto'
		id column:'tipodepuntodecontactoid'
		estado column: 'estadoid'
		version false
		autoTimestamp false
	}
}
