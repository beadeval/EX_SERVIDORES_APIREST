package restexamen.restcontroller;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restexamen.modelo.dto.EmpleadoProyectoDto;
import restexamen.modelo.entities.Empleado;
import restexamen.modelo.entities.EmpleadoProyecto;
import restexamen.modelo.entities.Proyecto;
import restexamen.servicies.EmpleadoProyectoService;
import restexamen.servicies.EmpleadoService;
import restexamen.servicies.ProyectoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/empleadosProyecto")
public class EmpleadoProyectoRestController {
	
	@Autowired
	private EmpleadoProyectoService empleadoProyectoService;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ProyectoService proyectoService;
	@Autowired
	private EmpleadoService empleadoService;
	
	
	//Asignar empleado a un proyecto (no mapea bien, sale a Null los objetos)
	@PostMapping("/asignar")
   	public EmpleadoProyecto altaEmpleado(@RequestBody EmpleadoProyectoDto empleadoProyectoDto) {
   		EmpleadoProyecto empleadoProyecto = new EmpleadoProyecto();
   		
   		modelMapper.map(empleadoProyectoDto, empleadoProyecto);	    
   		return empleadoProyectoService.insertOne(empleadoProyecto);
   	}

	  //Asignar empleado a un proyecto (con DTO)
		@PostMapping("/asignarEmpleado")
	   	public EmpleadoProyecto altaEmpleadoProyecto(@RequestBody EmpleadoProyectoDto empleadoProyectoDto) {
	   		EmpleadoProyecto empleado = new EmpleadoProyecto();
	   		empleado.setDiasPrevistos(proyectoService.buscarUno(empleadoProyectoDto.getIdProyecto()).getDiasPrevistos());
			empleado.setFechaIncorporacion(new Date());
			empleado.setEmpleado(empleadoService.buscarUno(empleadoProyectoDto.getIdEmpleado()));
			empleado.setProyecto(proyectoService.buscarUno(empleadoProyectoDto.getIdProyecto()));
	   		 		    
	   		return empleadoProyectoService.insertOne(empleado);
	   	}
		

	    // Mostrar empleados de un proyecto 
	    @GetMapping("/mostrarPorProyecto/{idProyecto}")
	    public List <Empleado> listarEmpleadosPorProyecto(@PathVariable int idProyecto){
	        return empleadoProyectoService.findEmpleadoPorProyecto(idProyecto);

	    }

}
