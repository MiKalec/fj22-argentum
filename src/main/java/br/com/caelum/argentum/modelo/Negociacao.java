package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public final class Negociacao {
    private final double preco;
    private final int quantidade;
    private final Calendar data;

    public Negociacao(double preco, int quantidade, Calendar data) {
        if(data == null){
            throw new IllegalArgumentException("Data nao pode ser null");
        }
        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
    }

    public double getPreco() {
        //para garantir imutabilidade
        double precoClone = preco;
        return precoClone;
    }

    public int getQuantidade() {
        //para garantir imutabilidade
        int quantidadeClone = quantidade;
        return quantidadeClone;
    }

    public Calendar getData() {
        //para garantir imutabilidade
        return (Calendar) data.clone();
    }

    public double getVolume(){
        return preco * quantidade;
    }

    public boolean isMesmoDia(Calendar outraData) {
        return this.data.get(Calendar.DAY_OF_MONTH) == outraData.get(Calendar.DAY_OF_MONTH)
                && this.data.get(Calendar.MONTH) == outraData.get(Calendar.MONTH)
                && this.data.get(Calendar.YEAR) == outraData.get(Calendar.YEAR);
    }
}
