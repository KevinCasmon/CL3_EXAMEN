package com.CL3_examen.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CL3_examen.modelo.Tema;

@Service
public interface ITemaService {

	void guardartema(Tema tema);
	List<Tema> listarTemas();
}
