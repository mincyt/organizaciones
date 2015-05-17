package organizaciones.domain

class Localizacion {

	String sumario
	Estado estado
	Organizacion organizacion

	static hasMany = [
		puntosDeContacto: PuntoDeContacto
	]
		
	static mapping = {
		id column: 'localizacionid'
		estado column: 'estadoid'
		organizacion column: 'organizacionid'
		version false
		autoTimestamp false

	}
	
}
