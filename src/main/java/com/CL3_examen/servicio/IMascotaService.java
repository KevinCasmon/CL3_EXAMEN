package com.CL3_examen.servicio;

import java.util.List;

import com.CL3_examen.modelo.Mascota;


public interface IMascotaService {
	void guardar(Mascota libro);
	List<Mascota> obtenerLibros();

}
