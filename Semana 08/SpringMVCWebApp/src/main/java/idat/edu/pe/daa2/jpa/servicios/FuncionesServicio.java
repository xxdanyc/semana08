package idat.edu.pe.daa2.jpa.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.Funciones;
import idat.edu.pe.daa2.jpa.repositorios.FuncionesRepositorio;

@Service
@Transactional
public class FuncionesServicio {

	@Autowired
	public FuncionesRepositorio repositorio;

	public FuncionesServicio() {

	}

	public Funciones crear(Funciones funciones) {
		return repositorio.save(funciones);
	}

	public List<Funciones> buscarTodo() {
		return (ArrayList<Funciones>) repositorio.findAll();
	}

	public Funciones actualizar(Funciones funcionesActualizar) {
		Funciones funcionesActual = repositorio.findById(funcionesActualizar.getIdFunciones()).get();
		funcionesActual.setIdFunciones(funcionesActualizar.getIdFunciones());
		funcionesActual.setHoraInicio(funcionesActualizar.getHoraInicio());
		;
		funcionesActual.setHoraFin(funcionesActualizar.getHoraFin());
		;
		Funciones funcionesActualizado = repositorio.save(funcionesActual);
		return funcionesActualizado;
	}

	public Funciones buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}

	public void actualizar(int id, Funciones funcion) {
		// TODO Auto-generated method stub
		Funciones funcionesActual = repositorio.findById(id).get();
		funcionesActual.setHoraInicio(funcion.getHoraInicio());
		funcionesActual.setHoraFin(funcion.getHoraFin());
		funcionesActual.setPelicula(funcion.getPelicula());
		funcionesActual.setPrecio(funcion.getPrecio());
		funcionesActual.setSala(funcion.getSala());
		 repositorio.save(funcionesActual);
		
	}
}