package br.com.caelum.argentum.factory;

import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.Negociacao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {

    public Candlestick constoiCandleParaData(Calendar data, List<Negociacao> negociacoes){
        double maximo = 0;
        double minimo = Double.MAX_VALUE;
        double volume = 0;

        for(Negociacao negociacao: negociacoes){
            volume += negociacao.getVolume();

            if(negociacao.getPreco() > maximo){
                maximo = negociacao.getPreco();
            }

            if(negociacao.getPreco() < minimo){
                minimo = negociacao.getPreco();
            }
        }

        if(negociacoes.isEmpty()){
            minimo = 0.0;
        }

        double abertura = negociacoes.isEmpty() ? 0
                : negociacoes.get(0).getPreco();
        double fechamento = negociacoes.isEmpty() ? 0
                : negociacoes.get(negociacoes.size() - 1).getPreco();

        return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
    }

    public List<Candlestick> constoiCandles(List<Negociacao> negociacoes) {
        List<Candlestick> candles = new ArrayList<>();

        List<Negociacao> negociacoesDoDia = new ArrayList<>();
        Calendar dataAtual = negociacoes.get(0).getData();

        for(Negociacao negociacao : negociacoes){
            if(negociacao.getData().before(dataAtual)){
                throw new IllegalStateException("Negociações em ordem errada");
            }
            if(!negociacao.isMesmoDia(dataAtual)){
                Candlestick candleDoDia = constoiCandleParaData(dataAtual, negociacoesDoDia);
                candles.add(candleDoDia);
                negociacoesDoDia = new ArrayList<>();
                dataAtual = negociacao.getData();
            }
            negociacoesDoDia.add(negociacao);
        }
        Candlestick candleDoDia = constoiCandleParaData(dataAtual, negociacoesDoDia);
        candles.add(candleDoDia);
        return candles;
    }
}
