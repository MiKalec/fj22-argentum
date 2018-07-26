package br.com.caelum.argentum.testes;

import br.com.caelum.argentum.factory.CandlestickFactory;
import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.Negociacao;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class TesteCandlestickFactorySemNegociacao {
    public static void main(String[] args) {
        Calendar hoje = Calendar.getInstance();

        List<Negociacao> negociacoes = Arrays.asList();

        CandlestickFactory factory = new CandlestickFactory();
        Candlestick candlestick = factory.constoiCandleParaData(hoje, negociacoes);

        System.out.println(candlestick);
    }

}
