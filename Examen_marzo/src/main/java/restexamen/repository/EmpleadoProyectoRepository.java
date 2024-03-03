package restexamen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import restexamen.modelo.entities.Empleado;
import restexamen.modelo.entities.EmpleadoProyecto;

public interface EmpleadoProyectoRepository extends JpaRepository <EmpleadoProyecto, Integer>{

	 //Empleados de un proyecto pasado por idProyecto
	 @Query("select ep.empleado from EmpleadoProyecto ep where ep.proyecto.idProyecto = ?1")
	 public List<Empleado> findEmpleadoPorProyecto(int idProyecto);
	 
	 /*Empleados sin proyecto
	 @Query("select ep.empleado from EmpleadoProyecto ep where ep.proyecto.idProyecto = ?1")
	 public List<Empleado> findEmpleadoSinProyecto();*/
}
