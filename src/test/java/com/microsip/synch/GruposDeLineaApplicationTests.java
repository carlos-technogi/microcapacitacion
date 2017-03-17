package com.microsip.synch;

import com.microsip.synch.models.GrupodeLinea;
import com.microsip.synch.persistence.GrupoDeLineaRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GruposDeLineaApplicationTests {

  @Autowired
  private TestRestTemplate restTemplate;

  @MockBean
  GrupoDeLineaRepo repo;

  @Test
  public void prueba4() {
    assertThat("test1").isNotBlank();
  }

  @Test
  public void prueba3() {
    assertThat(new LinkedList<String>()).isEmpty();
  }

  @Test
  public void prueba2() {
    given(this.repo.count()).willReturn(0L);
    assertThat(this.repo.count()).isEqualTo(0L);
  }

  @Test
  public void prueba1() {

    Pageable pageable = new PageRequest(0, 10);

    given(repo.findAll(pageable)).willReturn(new PageImpl<>(Collections.emptyList(), pageable, 0));
    GetResponse body = this.restTemplate.getForObject("/api/grupos?page=0&size=10", GetResponse.class);
    System.out.println(body);
    assertThat(body.getTotalElements()).isEqualTo(0);
  }


}
