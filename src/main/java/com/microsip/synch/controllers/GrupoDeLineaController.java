/**
 * LICENCIADO PARA MICROSIP
 */
package com.microsip.synch.controllers;

import com.microsip.synch.exceptions.InvalidRequestException;
import com.microsip.synch.models.GrupodeLinea;
import com.microsip.synch.models.Linea;
import com.microsip.synch.persistence.GrupoDeLineaRepo;
import com.microsip.synch.persistence.LineaRepo;
import com.microsip.synch.services.CatalogsService;
import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Clase de controlador de Grupos de linea
 */
@RestController
@RequestMapping("/api/grupos")
public class GrupoDeLineaController {

  final GrupoDeLineaRepo repo;
  final CatalogsService service;
  final LineaRepo lineaRepo;

  @Autowired
  public GrupoDeLineaController(
      GrupoDeLineaRepo repo, CatalogsService service, LineaRepo lineaRepo) {
    this.repo = repo;
    this.service = service;
    this.lineaRepo = lineaRepo;
  }

  @PostConstruct
  private void onInit() {
    System.out.println("==================");
    System.out.println(repo.count());

    if (repo.count() == 0) {
      System.out.println("salvando");

      List<GrupodeLinea> grupos = Arrays.asList(
          new GrupodeLinea("1L", "Grupo A"),
          new GrupodeLinea("2L", "Grupo B"),
          new GrupodeLinea("3L", "Grupo C"),
          new GrupodeLinea("4L", "Grupo D"),
          new GrupodeLinea("5L", "Grupo E"),
          new GrupodeLinea("6L", "Grupo f")
      );

      repo.save(grupos);
    }
  }

  @RequestMapping(method = RequestMethod.GET)
  Page<GrupodeLinea> listGrupos(@PageableDefault(size = 10) Pageable pageable) {
    return repo.findAll(pageable);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  GrupodeLinea getGrupo(@PathVariable("id")String id){
    return repo.findOne(id);
  }

  @RequestMapping(value = "/{id}/lineas", method = RequestMethod.GET)
  Set<Linea> get(@PathVariable("id")String id, @PageableDefault Pageable pageable){
    return repo.findOne(id).getLineas();
  }

  @RequestMapping(method = RequestMethod.POST)
  GrupodeLinea saveGrupo(@Valid @RequestBody final GrupodeLinea grupo, HttpServletResponse response, HttpServletRequest req) throws InvalidRequestException {
    if(grupo.getLineas()!=null){
      List<Linea> savedLines = lineaRepo.save(grupo.getLineas());
      grupo.setLineas(new HashSet<>(savedLines));
    }else{
      grupo.setLineas(new HashSet<>());
    }
    GrupodeLinea savedGrupo = repo.save(grupo);
    response.setStatus(HttpServletResponse.SC_CREATED);
    return savedGrupo;
  }

}
