package br.com.marcoslsouza.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.marcoslsouza.tdd.modelo.Funcionario;
import br.com.marcoslsouza.tdd.service.BonusService;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		//BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
		//assertEquals(new BigDecimal("0.00"), bonus);
		
		// Segundo argumento lambda com o método a ser chamado
		assertThrows(IllegalArgumentException.class, 
			() -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));
		
		/*try {
			service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
			fail("Nao deu a exception!");
		} catch(Exception e) {
			// Verifica se esta vindo com a mensagem de exception experada.
			assertEquals("Funcionario com salario maior que R$ 10000 nao pode receber bonus!", e.getMessage());
		}*/
	}

	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500"))); // Retorna 250
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000"))); // Retorna 1000
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}
}
