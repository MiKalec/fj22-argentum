import br.com.caelum.argentum.builder.CandleBuilder;
import org.junit.Test;

public class CandleBuilderTest {
    @Test(expected = IllegalStateException.class)
    public void geracaoDeCandleDeveTerTodosOsDadosNecessarios(){
        new CandleBuilder().geraCandle();
    }
}
