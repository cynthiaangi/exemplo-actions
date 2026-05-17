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
        // Arrange
        CalculadoraService calculadoraService = new CalculadoraService();
        double a = 10;
        double b = 0;
        var expectedMessage = "400 BAD_REQUEST \"Divisão por zero não permitida\"";

        // Assert
        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> {
                    // Act
                    calculadoraService.dividir(a, b);
                }
        );

        // Assert
        assertEquals(expectedMessage, exception.getMessage());
    }
}

