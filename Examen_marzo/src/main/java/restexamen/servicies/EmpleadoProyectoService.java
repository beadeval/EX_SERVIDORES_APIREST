package restexamen.servicies;

import java.util.List;

import restexamen.modelo.entities.Empleado;
import restexamen.modelo.entities.EmpleadoProyecto;



public interface EmpleadoProyectoService {
	EmpleadoProyecto insertOne(EmpleadoProyecto empleadoProyecto);
	EmpleadoProyecto updateOne(EmpleadoProyecto empleadoProyecto);
	boolean deleteOne(int idEntrada);
	EmpleadoProyecto buscarUno(int idEntrada);
	List<EmpleadoProyecto> buscarTodos();
	List<Empleado> findEmpleadoPorProyecto(int idProyecto);

}
