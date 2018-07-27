package br.com.caelum.argentum.builder;

import br.com.caelum.argentum.modelo.Candlestick;

import java.util.Calendar;

public class CandleBuilder {
    private double abertura;
    private double fechamento;
    private double minimo;
    private double maximo;
    private double volume;
    private Calendar data;

    boolean aberturaTest;
    boolean fechamentoTest;
    boolean minimoTest;
    boolean maximoTest;
    boolean volumeTest;
    boolean dataTest;

    public CandleBuilder comAbertura(double abertura){
        this.abertura = abertura;
        this.aberturaTest = true;
        return this;
    }

    public CandleBuilder comFechamento(double fechamento){
        this.fechamento = fechamento;
        this.fechamentoTest = true;
        return this;
    }

    public CandleBuilder comMinima(double minimo){
        this.minimo = minimo;
        this.minimoTest = true;
        return this;
    }

    public CandleBuilder comMaxima(double maximo){
        this.maximo = maximo;
        this.maximoTest = true;
        return this;
    }

    public CandleBuilder comVolume(double volume){
        this.volume = volume;
        this.volumeTest = true;
        return this;
    }

    public CandleBuilder comData(Calendar data){
        this.data = data;
        this.dataTest = true;
        return this;
    }

    public Candlestick geraCandle(){
        if(!aberturaTest || !fechamentoTest || !minimoTest
                || !maximoTest || !volumeTest || !dataTest){
            throw new IllegalStateException("Todos os dados necessários não foram passados");
        }

        return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
    }
}
