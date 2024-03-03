package restexamen.modelo.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Indica que esta clase es una entidad JPA
@Table(name="Empleados_en_proyecto") // Especifica el nombre de la tabla en la base de datos
@Data // Anotación de Lombok para generar automáticamente getters, setters, toString, etc.
@NoArgsConstructor // Constructor sin argumentos generado automáticamente por Lombok

public class EmpleadoProyecto {
	@Id // Indica que este campo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática de valores para la clave primaria
    @Column(name="id_entrada") // Especifica el nombre de la columna en la base de datos
    private int idEntrada; // Identificador único del cliente
    @ManyToOne
	@JoinColumn(name="id_proyecto")
    private Proyecto proyecto;
    @ManyToOne
  	@JoinColumn(name="id_empleado")
    private Empleado empleado;
	@Column(name="dias_previstos")
    private int diasPrevistos;
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_incorporacion")
    private Date fechaIncorporacion;
	
	
	
   

}
