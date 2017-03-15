package com.microsip.synch.persistence;

import com.microsip.synch.models.GrupodeLinea;
import com.microsip.synch.models.Linea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * Technogi 2016. Todos los derechos reservados
 * Created by carlos_technogi on 3/13/17.
 */
public interface LineaRepo extends MongoRepository<Linea,String> {

  //Page<Linea> findByGrupoId(String id, Pageable pageable);
}
