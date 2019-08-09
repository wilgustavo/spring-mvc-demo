package com.ma.app.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ma.app.model.Pelicula;
import com.ma.app.service.PeliculaService;
import com.ma.app.util.FechaUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:webapp/WEB-INF/spring/dispatcher-servlet.xml", "file:webapp/WEB-INF/spring/root-context.xml"})
public class PeliculaControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PeliculaService peliculaService;

    @InjectMocks
    private PeliculaController peliculaController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(peliculaController).build();
    }

    @Test
    public void deberia_guardar_una_pelicula() throws Exception {
        mockMvc.perform(post("/peliculas/save").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("titulo", "Terminator 2")
                .param("duracion", "123")
                .param("clasificacion", "B")
                .param("genero", "Accion")
                .param("estatus", "Activa")
                .param("fechaEstreno", "2019-08-18"))
        .andExpect(status().isOk());

        verify(peliculaService, times(1))
            .insertar(new Pelicula.Builder()
                    .titulo("Terminator 2")
                    .duracion(123)
                    .clasificacion("B")
                    .genero("Accion")
                    .estatus("Activa")
                    .fechaEstreno(FechaUtil.getISODate("2019-08-18"))
                    .build());
    }

}
