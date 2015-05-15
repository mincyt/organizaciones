package organizaciones.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

import org.hibernate.annotations.Filter
import org.hibernate.annotations.Filters

@Entity
@Table(name="nombredeorganizacion")
class NombreDeOrganizacion {

	@Id
	@GeneratedValue
	@Column(name="nombredeorganizacionid")
	Long id

		String denominacion
	@Column(name="essigla")
	Boolean esSigla
	@Column(name="esdenominacionpreferida")
	Boolean esDenominacionPreferida
	@ManyToOne
	@JoinColumn(name="organizacionid")
	Organizacion organizacion
	//Idioma idioma
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
