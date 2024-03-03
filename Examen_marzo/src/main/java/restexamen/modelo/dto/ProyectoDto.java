package restexamen.modelo.dto;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import restexamen.modelo.entities.Empleado;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ProyectoDto {
	    private int idProyecto; 
	    private String descripcion;
	    private Date fechaInicio;
	    private int diasPrevistos;
	    private int idEmpleado;
	    private String estado;

}
