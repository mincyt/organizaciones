package organizaciones.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

import com.fasterxml.jackson.annotation.JsonProperty

@Entity
@Table(name="relacionorganizacion")
class RelacionOrganizacion {

	@Id
	@GeneratedValue
	@Column(name="relacionorganizacionid")
	@JsonProperty("relacionorganizacionId")
	Long id
	@Column(name="espersonal")
	Boolean esPersonal
	@Column(name="esvigente")
	Boolean esVigente = true
	@Column(name="fechafin")
	Date fechaFin
	@Column(name="fechainicio")
	Date fechaInicio
	@Column(name="precedenciageneral")
	Integer precedenciaGeneral = 0
	@ManyToOne
	@JoinColumn(name="organizacionorigenid")
	Organizacion organizacionOrigen
	@ManyToOne
	@JoinColumn(name="organizacionrelacionadaid")
	Organizacion organizacionRelacionada
	// TaxonomiaOrganizacional taxonomiaOrganizacional

	@ManyToOne
	@JoinColumn(name="estadoid")
	Estado estado

	@ManyToOne
	@JoinColumn(name="tiporelacionid")
	TipoDeRelacion tipoDeRelacion
		
//    static constraints = {
//		organizacionOrigen ()
//		organizacionRelacionada validator: {
//			val, obj ->
//			! obj.organizacionRelacionada.equals(obj.organizacionOrigen)
//		}
//		tipoDeRelacion()
//		esVigente()
//		fechaInicio()
//		fechaFin nullable:true
//    }
//	
//	static hasMany = [ comentarios: RelacionTieneComentario ]
//
//	static mapping = {
//		table 'relacionorganizacion'
//		id column: 'relacionorganizacionid'
//		esPersonal column: 'espersonal'
//		esVigente column: 'esvigente'
//		fechaFin column: 'fechafin'
//		fechaInicio column: 'fechainicio'
//		precedenciaGeneral column: 'precedenciageneral'
//		organizacionOrigen column: 'organizacionorigenid'
//		organizacionRelacionada column: 'organizacionrelacionadaid'
//		taxonomiaOrganizacional column: 'taxonomiaorganizacionalid'
//		tipoDeRelacion column: 'tiporelacionid'
//		estado column: 'estadoid'
//		version false
//		autoTimestamp false
//	}	
}
