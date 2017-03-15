package com.microsip.synch.services.impl;

import com.microsip.synch.models.GrupodeLinea;
import com.microsip.synch.persistence.GrupoDeLineaRepo;
import com.microsip.synch.services.CatalogsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Technogi 2016. Todos los derechos reservados
 * Created by carlos_technogi on 3/13/17.
 */
@Service
public class CatalogsServiceImpl implements CatalogsService {

  final Logger loger = LoggerFactory.getLogger(CatalogsServiceImpl.class);

  @Value("${config.cong1}")
  private String conf1;

  final private GrupoDeLineaRepo repo;

  @Autowired
  public CatalogsServiceImpl(GrupoDeLineaRepo repo) {
    this.repo = repo;
  }

  @Override
  public Optional<GrupodeLinea> findById(String id) {
    return Optional.ofNullable(repo.findOne(id));
  }

  public String getConfig(){
    loger.trace("Tracing");
    loger.debug("Debug");
    loger.info("Info");
    loger.warn("Warn");
    loger.error("Error");
    return conf1;
  }
}
