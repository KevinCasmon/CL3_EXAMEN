package com.CL3_examen.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CL3_examen.modelo.Mascota;
import com.CL3_examen.repositorio.IMascotaRepository;

@Service
public class MascotaServiceImpl implements IMascotaService {

	@Autowired
	IMascotaRepository librorepo;
	
	@Override
	public void guardar(Mascota libro) {
		librorepo.save(libro);
		
	}

	@Override
	public List<Mascota> obtenerLibros() {
		return librorepo.findAll();
	}

}
