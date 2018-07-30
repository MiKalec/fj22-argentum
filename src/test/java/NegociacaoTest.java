import br.com.caelum.argentum.modelo.Negociacao;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

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

    @Test
    public void mesmoMsEhMesmoDia(){
        Calendar agora = Calendar.getInstance();
        Calendar mesmoMomento = (Calendar) agora.clone();

        Negociacao negociacao = new Negociacao(40.0, 100, agora);
        Assert.assertTrue(negociacao.isMesmoDia(mesmoMomento));
    }

    @Test
    public void horarioDiferenteMesmoDia(){
        Calendar manha = new GregorianCalendar(2018, 10, 20, 8, 30);
        Calendar tarde = new GregorianCalendar(2018, 10, 20, 15, 30);

        Negociacao negociacao = new Negociacao(40.0, 100, manha);
        Assert.assertTrue(negociacao.isMesmoDia(tarde));
    }

    @Test
    public void mesmoDiaMesDiferenteNaoSaoMesmaData(){
        Calendar data1 = new GregorianCalendar(2018, 10, 20, 8, 30);
        Calendar data2 = new GregorianCalendar(2018, 12, 20, 8, 30);

        Negociacao negociacao = new Negociacao(40.0, 100, data1);
        Assert.assertFalse(negociacao.isMesmoDia(data2));
    }

    @Test
    public void mesmoDiaEMesMasAnoDiferente(){
        Calendar data1 = new GregorianCalendar(2018, 10, 20, 8, 30);
        Calendar data2 = new GregorianCalendar(2017, 10, 20, 8, 30);

        Negociacao negociacao = new Negociacao(40.0, 100, data1);
        Assert.assertFalse(negociacao.isMesmoDia(data2));
    }
}
