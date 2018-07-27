import br.com.caelum.argentum.modelo.Negociacao;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Calendar;

public class NegociacaoTest {

    @Test
    public void dataDaNegociacaoImutavel(){
        Calendar data = Calendar.getInstance();
        data.set(Calendar.DAY_OF_MONTH, 15);
        Negociacao negociacao = new Negociacao(10, 5, data);

        negociacao.getData().set(Calendar.DAY_OF_MONTH, 20);

        assertEquals(15, negociacao.getData().get(Calendar.DAY_OF_MONTH));
    }

    @Test(expected = IllegalArgumentException.class) //para o teste passar, a operação dentro do método deve lançar essa exeption
    public void naoCriaNegociacaoComDataNulla(){
        new Negociacao(10,5,null);
    }
}
