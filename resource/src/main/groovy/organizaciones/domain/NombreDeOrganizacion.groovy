package organizaciones.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators

@Entity
@Table(name="nombredeorganizacion")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator,
	property = "nombredeorganizacionid")
class NombreDeOrganizacion {

	@Id
	@GeneratedValue
	@Column(name="nombredeorganizacionid")
	@JsonIgnore
	Long id

	String denominacion
	@Column(name="essigla")
	Boolean esSigla
	@Column(name="esdenominacionpreferida")
	Boolean esDenominacionPreferida
	@ManyToOne
	@JoinColumn(name="organizacionid")
	Organizacion organizacion
	@ManyToOne
	@JoinColumn(name="idiomaid")
	Idioma idioma
	@ManyToOne
	@JoinColumn(name="estadoid")
	Estado estado


	static constraints = {
	}

	static mapping = {
		table 'nombredeorganizacion'
		id column: 'nombredeorganizacionid', generator: 'sequence', params: [sequence:"seq_nombredeorganizacion"]
		esSigla column: 'essigla'
		estado column: 'estadoid'
		idioma column: 'idiomaid'
		organizacion column: 'organizacionid'
		esDenominacionPreferida column: 'esdenominacionpreferida'
		version false
		autoTimestamp false
	}

	def String toString() {
		denominacion
	}	
}
