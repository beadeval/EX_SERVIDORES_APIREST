package restexamen.restcontroller;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import restexamen.modelo.entities.Empleado;
import restexamen.modelo.entities.Proyecto;
import restexamen.servicies.EmpleadoService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/empleados")
public class EmpleadoRestController {
	
	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private ModelMapper modelMapper;
	
	 // Método para obtener un empleado por su ID o ver detalle
    @GetMapping("/uno/{idEmpleado}")
    public Empleado verEmpleado(@PathVariable int idEmpleado){
        return empleadoService.buscarUno(idEmpleado);

    }
    
    // Modificar proyecto
    @PutMapping("/modificar")
	public Empleado modificarEmpleado(@RequestBody Empleado empleado) {
		return empleadoService.updateOne(empleado);
	}
	
    // Método para eliminar un empleado por su ID
    @DeleteMapping("/eliminar/{idEmpleado}")
    public String eliminarEmpleado(@PathVariable int idEmpleado){
        if (empleadoService.deleteOne(idEmpleado))
            return "Empleado eliminado correctamente";
        else
            return "Empleado no se ha podido eliminar";

    }

    // Ver todos los empleados
    @GetMapping("/")
	public List<Empleado> todosEmpleados(){
		return empleadoService.buscarTodos();
		
	}
    
    // Dar de alta un empleado (director) sin DTO
    @PostMapping("/alta")
	public Empleado altaEmpleado(@RequestBody Empleado empleado) {
		return empleadoService.insertOne(empleado);
	}
    
    // Ver empleados sin proyecto
    @GetMapping("/mostrarSinProyecto")
	public List<Empleado> mostrarSinProyecto(){
		return empleadoService.findEmpleadosSinProyecto();
	}
    


}
