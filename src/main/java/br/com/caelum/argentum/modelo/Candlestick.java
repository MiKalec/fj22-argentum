package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class Candlestick {
    private final double abertura;  //preço primeira negociação do dia
    private final double fechamento;    //preço última negociação do dia
    private final double minimo;    //preço mínimo da negociação do dia
    private final double maximo;    //preço máximo da negociação do dia
    private final double volume;    //quantidade de dinheiro que passou pelas negociações do dia
    private final Calendar data;    //dia em questão

    public Candlestick(double abertura, double fechamento, double minimo, double maximo, double volume, Calendar data) {
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.minimo = minimo;
        this.maximo = maximo;
        this.volume = volume;
        this.data = data;
    }

    public double getAbertura() {
        return abertura;
    }

    public double getFechamento() {
        return fechamento;
    }

    public double getMinimo() {
        return minimo;
    }

    public double getMaximo() {
        return maximo;
    }

    public double getVolume() {
        return volume;
    }

    public Calendar getData() {
        return data;
    }

    public boolean isAlta(){
        return abertura < fechamento;
    }

    public boolean isBaixa(){
        return abertura > fechamento;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = data.getTime();

        return "Candlestick [" +
                "Abertura = " + abertura +
                ", Fechamento = " + fechamento +
                ", Mínima = " + minimo +
                ", Máxima = " + maximo +
                ", Volume = " + volume +
                ", Data = " + format.format(date) +
                ']';
    }
}
