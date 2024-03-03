package restexamen.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restexamen.modelo.entities.Proyecto;
import restexamen.repository.ProyectoRepository;

@Service
public class ProyectoServiceImplMy8 implements ProyectoService {
	
	@Autowired
	private ProyectoRepository prepo;

	@Override
	public Proyecto insertOne(Proyecto proyecto) {
		return prepo.save(proyecto);
	}

	@Override
	public Proyecto updateOne(Proyecto proyecto) {
		try {
			return prepo.save(proyecto);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean deleteOne(int idProyecto) {
		try {
			if (buscarUno(idProyecto) != null) {
				prepo.deleteById(idProyecto);
				return true;
			}else
				return false;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Proyecto buscarUno(int idProyecto) {
		return prepo.findById(idProyecto).orElse(null);
	}

	@Override
	public List<Proyecto> buscarTodos() {
		return prepo.findAll();
	}

}
