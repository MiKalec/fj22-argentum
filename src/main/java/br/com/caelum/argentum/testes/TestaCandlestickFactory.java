package br.com.caelum.argentum.testes;

import br.com.caelum.argentum.factory.CandlestickFactory;
import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.Negociacao;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class TestaCandlestickFactory {
    public static void main(String[] args){
        Calendar hoje = Calendar.getInstance();

        Negociacao negociacao1 = new Negociacao(38.5, 100, hoje);
        Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
        Negociacao negociacao3 = new Negociacao(49.8, 100, hoje);
        Negociacao negociacao4 = new Negociacao(52.3, 100, hoje);

        List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);

        CandlestickFactory factory = new CandlestickFactory();
        Candlestick candlestick = factory.constoiCandleParaData(hoje, negociacoes);

        System.out.println(candlestick);

        /*  linha acima substitui tudo isso aqui
         *
         *  System.out.println(candlestick.getAbertura());
         *  System.out.println(candlestick.getFechamento());
         *  System.out.println(candlestick.getMinimo());
         *  System.out.println(candlestick.getMaximo());
         *  System.out.println(candlestick.getVolume());
         */
    }
}
