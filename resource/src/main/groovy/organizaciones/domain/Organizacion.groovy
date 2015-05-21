package organizaciones.domain


import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.validation.constraints.NotNull

import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator, 
                  property = "organizacionid")
class Organizacion {

	@Id
	@GeneratedValue
	@Column(name="organizacionid")
	@JsonIgnore
	Long id
	
	@Column(name="fechadefinalizacion")
	Date fechaDeFinalizacion
	@Column(name="fechadeinicio")
	Date fechaDeInicio
	Boolean vigente = true
	
	@ManyToOne
	@JoinColumn(name="tipodecategoriaid")
	TipoDeCategoria tipoDeCategoria
	
	@ManyToOne
	@JoinColumn(name="estadoid")
	Estado estado
	
	@NotNull
	@Column(name="nombrecorto")
	String nombreCorto
	
	@OneToMany(mappedBy="organizacion", fetch=FetchType.EAGER)
	Set<NombreDeOrganizacion> nombres
	
	static hasMany = [
		escalafones : Escalafon,
		tiposDeOrganizacion : TipoDeOrganizacion,
		jerarquiasSuperiores : JerarquiaSuperior,
		nombres : NombreDeOrganizacion,
		comentarios : OrganizacionComentario,
		localizaciones : Localizacion
	]

	static constraints = {
		nombreCorto matches:'[a-z]+(-[a-z]+)*', unique: true
		fechaDeInicio()
		fechaDeFinalizacion nullable:true
		vigente()
		nombres()
		tiposDeOrganizacion()
		comentarios()
		escalafones nullable: true
		jerarquiasSuperiores  nullable: true
		estado()
	}
	
	static mapping = {
		id column:'organizacionid', generator: 'sequence', params: [sequence:"seq_organizacion"]
		estado column: 'estadoid'
		tipoDeCategoria column: 'tipodecategoriaid'
		fechaDeInicio column: 'fechadeinicio'
		fechaDeFinalizacion column: 'fechadefinalizacion'
		escalafones	joinTable: [	
			name: 'organizaciontieneescalafon',
			column : 'escalafonid',
			key : 'organizacionid'
		]
		tiposDeOrganizacion joinTable: [
			name: 'organizaciontienetipodeorganizacion',
			column : 'tipodeorganizacionid',
			key : 'organizacionid'
		]
		jerarquiasSuperiores joinTable: [	
			name: 'organizacionutilizajerarquiasuperior',
			column : 'jerarquiasuperiorid',
			key : 'organizacionid'

		]
		dateCreated column: 'creadocuando'
		lastUpdated column: 'modificadocuando'
	}
	
	@JsonGetter
	def String nombrePreferido() {
		nombres.find{ n -> n.esDenominacionPreferida}?.denominacion
	}

	//@JsonIdentityReference	
	def String toString() {
		nombrePreferido()?nombrePreferido()+"{"+nombreCorto+"}":nombreCorto
	}
	
}
