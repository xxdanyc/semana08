package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import idat.edu.pe.daa2.jpa.modelo.Cine;

import idat.edu.pe.daa2.jpa.repositorios.CineRepositorio;

@Service
@Transactional
public class CineServicio {
	

		@Autowired
		private CineRepositorio repositorio;

		public CineServicio() {  
			// TODO Auto-generated constructor stub
		}

		public List<Cine> buscarTodo() {
			return (List<Cine>) repositorio.findAll();  
		}

		public Cine crear(Cine cine) {
			return repositorio.save(cine);
		}

		public Cine actualizar(Cine cineActualizar) {
			Cine cineActual = repositorio.findById(cineActualizar.getIdCine()).get();
			cineActual.setIdCine(cineActualizar.getIdCine());
			cineActual.setRazonSocial(cineActualizar.getRazonSocial());;
			cineActual.setNombre(cineActualizar.getNombre());;
			Cine cineActualizado = repositorio.save(cineActual);
			return cineActualizado;
		}

		public Cine buscarPorID(Integer id) {
			return repositorio.findById(id).get();
		}

		public void borrarPorID(Integer id) {
			repositorio.deleteById(id);
		}
}
