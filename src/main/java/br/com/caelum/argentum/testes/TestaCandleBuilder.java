package br.com.caelum.argentum.testes;

import br.com.caelum.argentum.builder.CandleBuilder;
import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.Negociacao;

import java.util.Calendar;

public class TestaCandleBuilder {
    public static void main(String[] args){
        Calendar hoje = Calendar.getInstance();

        Candlestick candlestick = new CandleBuilder()
                .comAbertura(40.5)
                .comFechamento(42.3)
                .comMinima(39.8)
                .comMaxima(45.0)
                .comVolume(145324.30)
                .comData(hoje)
                .geraCandle();

        System.out.println(candlestick);
    }

}
