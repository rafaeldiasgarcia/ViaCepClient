import br.com.viacep.Endereco;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnderecoTest {

    private final String CEP_TESTE = "12345-678";
    private final String LOGRADOURO_TESTE = "Rua Teste Unitário";
    private final String BAIRRO_TESTE = "Bairro Teste";
    private final String LOCALIDADE_TESTE = "Cidade Teste";
    private final String UF_TESTE = "TS";
    private final String DDD_TESTE = "99";
    private final String COMPLEMENTO_TESTE = "Apto 101";

    @Test
    void deveRetornarGettersESetters() {
        // AAA: ARRANGE (Preparar: Criar a instância da classe Endereco e definir os valores)
        Endereco endereco = new Endereco();
        endereco.setCep(CEP_TESTE);
        endereco.setLogradouro(LOGRADOURO_TESTE);
        endereco.setBairro(BAIRRO_TESTE);
        endereco.setLocalidade(LOCALIDADE_TESTE);
        endereco.setUf(UF_TESTE);
        endereco.setDdd(DDD_TESTE);
        endereco.setComplemento(COMPLEMENTO_TESTE);
        endereco.setErro(false);

        // AAA: ASSERT (Verificar: Comparar os valores recuperados com os valores definidos)
        assertEquals(CEP_TESTE, endereco.getCep(), "O CEP deve ser recuperado corretamente.");
        assertEquals(LOGRADOURO_TESTE, endereco.getLogradouro(), "O Logradouro deve ser recuperado corretamente.");
        assertEquals(BAIRRO_TESTE, endereco.getBairro(), "O Bairro deve ser recuperado corretamente.");
        assertEquals(LOCALIDADE_TESTE, endereco.getLocalidade(), "A Localidade deve ser recuperada corretamente.");
        assertEquals(UF_TESTE, endereco.getUf(), "A UF deve ser recuperada corretamente.");
        assertEquals(DDD_TESTE, endereco.getDdd(), "O DDD deve ser recuperado corretamente.");
        assertEquals(COMPLEMENTO_TESTE, endereco.getComplemento(), "O Complemento deve ser recuperado corretamente.");
        assertFalse(endereco.isErro(), "O status de erro deve ser false.");
    }

    @Test
    void deveRetornarToStringCompleto() {
        // AAA: ARRANGE (Preparar: Criar a instância e preencher todos os campos)
        Endereco endereco = new Endereco();
        endereco.setCep(CEP_TESTE);
        endereco.setLogradouro(LOGRADOURO_TESTE);
        endereco.setComplemento(COMPLEMENTO_TESTE);
        endereco.setBairro(BAIRRO_TESTE);
        endereco.setLocalidade(LOCALIDADE_TESTE);
        endereco.setUf(UF_TESTE);
        endereco.setDdd(DDD_TESTE);

        // AAA: ACT (Agir: Chamar o método toString())
        String resultado = endereco.toString();

        // AAA: ASSERT (Verificar: Checar se o string resultante contém as informações chave)
        assertTrue(resultado.contains(CEP_TESTE), "O toString deve conter o CEP.");
        assertTrue(resultado.contains(LOGRADOURO_TESTE), "O toString deve conter o Logradouro.");
        assertTrue(resultado.contains(LOCALIDADE_TESTE + "/" + UF_TESTE), "O toString deve conter Cidade/UF.");
        assertTrue(resultado.contains(COMPLEMENTO_TESTE), "O toString deve conter o Complemento.");
    }

    @Test
    void testeToStringComplementoVazio() {
        // AAA: ARRANGE (Preparar: Criar a instância e deixar o Complemento como String vazia)
        Endereco endereco = new Endereco();
        endereco.setCep(CEP_TESTE);
        endereco.setComplemento(""); // Complemento Vazio
        endereco.setLocalidade(LOCALIDADE_TESTE);
        endereco.setUf(UF_TESTE);

        // AAA: ACT (Agir: Chamar o método toString())
        String resultado = endereco.toString();

        // AAA: ASSERT (Verificar: O toString deve substituir o valor vazio por "N/A" conforme a lógica da classe)
        assertTrue(resultado.contains("Complemento: N/A"), "O toString deve tratar o complemento vazio como 'N/A'.");
        assertFalse(resultado.contains(COMPLEMENTO_TESTE), "O toString não deve conter o complemento completo.");
    }

    @Test
    void testeAtribuicaoErro() {
        // AAA: ARRANGE (Preparar: Criar a instância e definir a flag de erro)
        Endereco endereco = new Endereco();

        // AAA: ACT (Agir: Definir a flag como true)
        endereco.setErro(true);

        // AAA: ASSERT (Verificar: O getter deve retornar true)
        assertTrue(endereco.isErro(), "A flag de erro deve ser true após ser definida.");
    }

    @Test
    void testeValoresIniciais() {
        // AAA: ARRANGE (Preparar: Instanciar a classe sem usar setters)
        Endereco endereco = new Endereco();

        // AAA: ACT (Não há ação, o foco é o estado inicial)

        // AAA: ASSERT (Verificar: As Strings devem ser nulas, e o booleano false - padrão do Java)
        assertNull(endereco.getCep(), "O CEP deve ser null por padrão.");
        assertNull(endereco.getBairro(), "O Bairro deve ser null por padrão.");
        assertFalse(endereco.isErro(), "A flag de erro deve ser false por padrão.");
    }
}