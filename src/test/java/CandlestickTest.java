import br.com.caelum.argentum.modelo.Candlestick;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Calendar;

public class CandlestickTest {
    @Test(expected = IllegalArgumentException.class)
    public void precoMaximoNaoPodeSerMenorQueMinimo(){
        new Candlestick(40.0, 38.0, 40.0,
                38.0, 20000.0, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void valorAberturaNegativo(){
        new Candlestick(-40.0, 38.0, 40.0,
                38.0, 20000.0, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void valorFechamentoNegativo(){
        new Candlestick(40.0, -38.0, 40.0,
                38.0, 20000.0, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void valorMinimoNegativo(){
        new Candlestick(40.0, 38.0, -40.0,
                38.0, 20000.0, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void valorMaximoNegativo(){
        new Candlestick(40.0, 38.0, 40.0,
                -38.0, 20000.0, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void valorVolumeNegativo(){
        new Candlestick(40.0, 38.0, 40.0,
                38.0, -20000.0, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void dataNulla(){
        new Candlestick(40.0, 38.0, 40.0,
                38.0, -20000.0, null);
    }

    @Test
    public void aberturaIgualFechamentoEhAlta(){
        Candlestick candle = new Candlestick(40.0, 40.0,
                40.0, 45.0, 2310.0, Calendar.getInstance());

        assertTrue(candle.isAlta());
    }
}
