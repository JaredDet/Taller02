import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
class Taller02Test{

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    @DisplayName("Test para eliminar espacios vacíos")
    void eliminarEspaciosVacios() {

        assertEquals("lateleletal", Taller02.formatearTexto("la tele letal"));
        assertEquals("alagordadrogala", Taller02.formatearTexto("a la gorda drogala"));
    }

    @Test
    @DisplayName("Test para eliminar tildes")
    void eliminarTildes() {

        assertEquals("raton", Taller02.formatearTexto("ratón"));
        assertEquals("arbol", Taller02.formatearTexto("Árbol"));
    }

    @Test
    @DisplayName("Test para eliminar guiones")
    void eliminarGuiones() {

        assertEquals("cancerbero", Taller02.formatearTexto("cancer_bero"));
    }

    @Test
    @DisplayName("Test para eliminar mayúsculas")
    void eliminarMayusculas() {

        assertEquals("enmivida", Taller02.formatearTexto("ENMIVIDA"));
    }

    @Test
    @DisplayName("Test para verificar que necesariamente tenga más de un caracter")
    void validarCaracteres() {

        assertFalse(Taller02.verificarLargo("a"));
    }

    @Test
    @DisplayName("Test para verificar que necesariamente tenga más de un dígito")
    void validarDigitos() {

        assertFalse(Taller02.verificarLargo("5"));
    }

    @Test
    @DisplayName("Test para invalidar la entrada vacía")
    void invalidarEntradaVacia() {

        assertFalse(Taller02.verificarLargo(""));
    }

    @Test
    @DisplayName("Test para invalidar un archivo que no existe")
    void archivoNoExistente() {

        assertFalse(Taller02.validarArchivo("C:\\Users\\user\\Downloads/HolaNoExisto.txt"));
    }
}
