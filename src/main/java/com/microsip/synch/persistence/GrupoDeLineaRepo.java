package com.microsip.synch.persistence;

import com.microsip.synch.models.GrupodeLinea;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Technogi 2016. Todos los derechos reservados
 * Created by carlos_technogi on 3/13/17.
 */
public interface GrupoDeLineaRepo extends MongoRepository<GrupodeLinea,String> {
}
