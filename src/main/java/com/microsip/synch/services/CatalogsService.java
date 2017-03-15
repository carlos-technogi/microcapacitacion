package com.microsip.synch.services;

import com.microsip.synch.models.GrupodeLinea;

import java.util.Optional;

/**
 * Technogi 2016. Todos los derechos reservados
 * Created by carlos_technogi on 3/13/17.
 */
public interface CatalogsService {

  Optional<GrupodeLinea> findById(String id);
  String getConfig();
}
