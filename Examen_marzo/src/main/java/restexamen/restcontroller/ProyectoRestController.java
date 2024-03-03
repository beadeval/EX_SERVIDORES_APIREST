package restexamen.restcontroller;

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

import restexamen.modelo.dto.ProyectoDto;
import restexamen.modelo.entities.Empleado;
import restexamen.modelo.entities.Proyecto;
import restexamen.servicies.EmpleadoService;
import restexamen.servicies.ProyectoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/proyectos")
public class ProyectoRestController {
	
	@Autowired
	private ProyectoService proyectoService;
	
	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private ModelMapper modelMapper;
	
	 // Método para obtener un comercial por su ID o ver detalle
    @GetMapping("/uno/{idProyecto}")
    public Proyecto verProyecto(@PathVariable int idProyecto){
        return proyectoService.buscarUno(idProyecto);

    }
    
    // Modificar proyecto
    @PutMapping("/modificar")
	public Proyecto modificarProyecto(@RequestBody Proyecto proyecto) {
		return proyectoService.updateOne(proyecto);
	}
    
	
    // Método para eliminar un proyecto por su ID
    @DeleteMapping("/eliminar/{idProyecto}")
    public String eliminarProyectol(@PathVariable int idProyecto){
        if (proyectoService.deleteOne(idProyecto))
            return "Proyecto eliminado correctamente";
        else
            return "Proyecto no se ha podido eliminar";

    }

    // Ver todos los proyectos
    @GetMapping("/")
	public List<Proyecto> todosProyectos(){
		return proyectoService.buscarTodos();
		
	}
    
    // Dar de alta un proyecto sin DTO
    @PostMapping("/alta")
	public Proyecto altaProyecto(@RequestBody Proyecto proyecto) {
		return proyectoService.insertOne(proyecto);
	}
    
    // Dar de alta un proyecto con DTO
    @PostMapping("/altaDto")
	public Proyecto altaProyectoDto(@RequestBody ProyectoDto proyectoDto) {
		Proyecto proyecto = new Proyecto();
		
		modelMapper.map(proyectoDto, proyecto);
		Empleado director = empleadoService.buscarUno(proyectoDto.getIdEmpleado());
		    
		// Asignar el empleado como director del proyecto
		    proyecto.setDirector(director);
		    
		return proyectoService.insertOne(proyecto);
	}
    
    // Mostrar directos de un proyecto
    @GetMapping("/mostrarDirector/{idProyecto}")
	public Empleado mostrarDirector(@PathVariable int idProyecto) {
    	
		return empleadoService.findDirectoresPorProyecto(idProyecto);
	}
    
    // CRUD de cualquiera
    
    // Asignar empleados a un proyecto  HECHO
 
    // Mostrar empleados de un proyecto  HECHO
    
    // Mostrar director de un proyecto  HECHO
    
    // Mostrar proyectos por empleado ¿?
    
    // Mostrar proyectos por director ¿?
    
    // Ver proyectos sin empleado   ¿?
    
    // Modificar director de un proyecto ¿?
    
    
}
