package com.CL3_examen.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CL3_examen.modelo.Tema;
import com.CL3_examen.repositorio.ITemaRepository;

@Service
public class TemaServiceImpl implements ITemaService {

	@Autowired
	ITemaRepository temarepo;
	
	@Override
	public void guardartema(Tema tema) {
		temarepo.save(tema);
	}

	@Override
	public List<Tema> listarTemas() {
		return temarepo.findAll();
	}

}
