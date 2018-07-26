package br.com.caelum.argentum.testes;

import br.com.caelum.argentum.factory.CandlestickFactory;
import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.Negociacao;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TesteImutavel {
    public static void main(String[] args){
        Calendar hoje = Calendar.getInstance();

        Negociacao petrobras = new Negociacao(30, 32, hoje);

        List<Negociacao> negociacoes = Arrays.asList(petrobras);

        CandlestickFactory factory = new CandlestickFactory();
        Candlestick candlestick = factory.constoiCandleParaData(hoje, negociacoes);
        candlestick.getData().setTime(new Date(119 /*+ 1900 que bizarro*/,
                02, 16));

        System.out.println(candlestick);
    }
}
