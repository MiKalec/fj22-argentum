import br.com.caelum.argentum.factory.CandlestickFactory;
import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.Negociacao;
import static org.junit.Assert.*; //import static -> serve para importar os métodos static da classe

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CandlestickFactoryTest {
    @Test
    public void sequenciaSimplesDeNegociacoes(){
        Calendar hoje = Calendar.getInstance();

        Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
        Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
        Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
        Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);

        List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);

        CandlestickFactory factory = new CandlestickFactory();
        Candlestick candlestick = factory.constoiCandleParaData(hoje, negociacoes);

        assertEquals(40.5, candlestick.getAbertura(), 0.00001);
        assertEquals(42.3, candlestick.getFechamento(), 0.00001);
        assertEquals(39.8, candlestick.getMinimo(), 0.00001);
        assertEquals(45.0, candlestick.getMaximo(), 0.00001);
        assertEquals(16760.0, candlestick.getVolume(), 0.00001);
    }

    @Test
    public void semNegociacaoGeraZeros(){
        Calendar hoje = Calendar.getInstance();

        List<Negociacao> negociacoes = Arrays.asList();

        CandlestickFactory factory = new CandlestickFactory();
        Candlestick candlestick = factory.constoiCandleParaData(hoje, negociacoes);

        assertEquals(0.0, candlestick.getAbertura(), 0.00001);
        assertEquals(0.0, candlestick.getFechamento(), 0.00001);
        assertEquals(0.0, candlestick.getMinimo(), 0.00001);
        assertEquals(0.0, candlestick.getMaximo(), 0.00001);
        assertEquals(0.0, candlestick.getVolume(), 0.00001);
    }

    @Test
    public void apenasUmaNegociacao(){
        Calendar hoje = Calendar.getInstance();

        Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);

        List<Negociacao> negociacoes = Arrays.asList(negociacao1);

        CandlestickFactory factory = new CandlestickFactory();
        Candlestick candlestick = factory.constoiCandleParaData(hoje, negociacoes);
        assertEquals(40.5, candlestick.getAbertura(), 0.00001);
        assertEquals(40.5, candlestick.getFechamento(), 0.00001);
        assertEquals(40.5, candlestick.getMinimo(), 0.00001);
        assertEquals(40.5, candlestick.getMaximo(), 0.00001);
        assertEquals(4050.0, candlestick.getVolume(), 0.00001);
    }

    @Test
    public void negociacoesOrdemCrescente(){
        Calendar hoje = Calendar.getInstance();

        Negociacao negociacao1 = new Negociacao(39.8, 100, hoje);
        Negociacao negociacao2 = new Negociacao(40.5, 100, hoje);
        Negociacao negociacao3 = new Negociacao(42.3, 100, hoje);
        Negociacao negociacao4 = new Negociacao(45.0, 100, hoje);

        List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);

        CandlestickFactory factory = new CandlestickFactory();
        Candlestick candlestick = factory.constoiCandleParaData(hoje, negociacoes);

        assertEquals(39.8, candlestick.getAbertura(), 0.00001);
        assertEquals(45.0, candlestick.getFechamento(), 0.00001);
        assertEquals(39.8, candlestick.getMinimo(), 0.00001);
        assertEquals(45.0, candlestick.getMaximo(), 0.00001);
        assertEquals(16760.0, candlestick.getVolume(), 0.00001);
    }

    @Test
    public void negociacoesOrdemDecrescente(){
        Calendar hoje = Calendar.getInstance();

        Negociacao negociacao1 = new Negociacao(45.0, 100, hoje);
        Negociacao negociacao2 = new Negociacao(42.3, 100, hoje);
        Negociacao negociacao3 = new Negociacao(40.5, 100, hoje);
        Negociacao negociacao4 = new Negociacao(39.8, 100, hoje);


        List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);

        CandlestickFactory factory = new CandlestickFactory();
        Candlestick candlestick = factory.constoiCandleParaData(hoje, negociacoes);

        assertEquals(45.0, candlestick.getAbertura(), 0.00001);
        assertEquals(39.8, candlestick.getFechamento(), 0.00001);
        assertEquals(39.8, candlestick.getMinimo(), 0.00001);
        assertEquals(45.0, candlestick.getMaximo(), 0.00001);
        assertEquals(16760.0, candlestick.getVolume(), 0.00001);
    }

    @Test
    public void paraNegociacoesDeTresDiasGeraTreCandles(){
        Calendar hoje = Calendar.getInstance();

        Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
        Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
        Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
        Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);

        Calendar amanha = (Calendar) hoje.clone();
        amanha.add(Calendar.DAY_OF_MONTH, 1);

        Negociacao negociacao5 = new Negociacao(48.8, 100, amanha);
        Negociacao negociacao6 = new Negociacao(49.3, 100, amanha);

        Calendar depois = (Calendar) amanha.clone();
        depois.add(Calendar.DAY_OF_MONTH, 1);

        Negociacao negociacao7 = new Negociacao(51.8, 100, depois);
        Negociacao negociacao8 = new Negociacao(52.3, 100, depois);

        List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3,
                negociacao4, negociacao5, negociacao6, negociacao7, negociacao8);

        CandlestickFactory factory = new CandlestickFactory();

        List<Candlestick> candlesticks = factory.constoiCandles(negociacoes);

        Assert.assertEquals(3, candlesticks.size());
        Assert.assertEquals(40.5, candlesticks.get(0).getAbertura(), 0.00001);
        Assert.assertEquals(42.3, candlesticks.get(0).getFechamento(), 0.00001);
        Assert.assertEquals(48.8, candlesticks.get(1).getAbertura(), 0.00001);
        Assert.assertEquals(49.3, candlesticks.get(1).getFechamento(), 0.00001);
        Assert.assertEquals(51.8, candlesticks.get(2).getAbertura(), 0.00001);
        Assert.assertEquals(52.3, candlesticks.get(2).getFechamento(), 0.00001);
    }

    @Test(expected = IllegalStateException.class)
    public void naoPermiteListaDesordenada(){
        Calendar hoje = Calendar.getInstance();

        Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
        Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
        Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
        Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);

        Calendar amanha = (Calendar) hoje.clone();
        amanha.add(Calendar.DAY_OF_MONTH, 1);

        Negociacao negociacao5 = new Negociacao(48.8, 100, amanha);
        Negociacao negociacao6 = new Negociacao(49.3, 100, amanha);

        Calendar depois = (Calendar) amanha.clone();
        depois.add(Calendar.DAY_OF_MONTH, 1);

        Negociacao negociacao7 = new Negociacao(51.8, 100, depois);
        Negociacao negociacao8 = new Negociacao(52.3, 100, depois);

        List<Negociacao> negociacoes = Arrays.asList(negociacao5, negociacao7, negociacao3,
                negociacao4, negociacao1, negociacao6, negociacao2, negociacao8);

        CandlestickFactory factory = new CandlestickFactory();

        List<Candlestick> candlesticks = factory.constoiCandles(negociacoes);


    }
}
