package organizaciones.domain

class PuntoDeContacto {

	Integer precedenciaEmail
	Integer precedenciaGeneral
	Integer precedenciaTelefonica
	Estado estado
	CasillaPostal casillaPostal
	Email email
	Lugar lugar
	Localizacion localizacion
	SitioWeb sitioWeb
	Telefono telefono
	TipoDePuntoDeContacto tipoDePuntoDeContacto
	
    static constraints = {
    }
	
	static mapping = {
		table 'puntodecontacto'
		id column: 'puntodecontactoid'
		precedenciaEmail column: 'precedenciaemail'
		precedenciaGeneral column: 'precedenciageneral'
		precedenciaTelefonica column: 'precedenciatelefonica'
		estado column: 'estadoid'
		casillaPostal column: 'casillapostalid'
		email column: 'emailid'
		lugar column: 'lugarid'
		localizacion column: 'localizacionid'
		sitioWeb column: 'sitiowebid'
		telefono column: 'telefonoid'
		tipoDePuntoDeContacto column: 'tipodepuntodecontactoid'
		version false
		autoTimestamp false
	}

}
