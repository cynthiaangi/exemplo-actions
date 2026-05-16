package sptech.school.exemplo_actions.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.web.server.ResponseStatusException;

class CalculadoraServiceTests {

    private final CalculadoraService service = new CalculadoraService();

    @Test
    void deveDividirValores() {
        double resultado = service.dividir(10, 2);
        assertEquals(5.0, resultado, 1e-9);
    }

    @Test
    void deveLancarAoDividirPorZero() {
        ResponseStatusException ex = assertThrows(ResponseStatusException.class, () -> service.dividir(10, 0));
        assertEquals("Divisão por zero não permitida", ex.getReason());
    }
}

