package br.com.caelum.argentum.generator;

import br.com.caelum.argentum.modelo.Negociacao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class GeradorAleatorioDeXML {
    public static void main(String[] args) throws IOException{
        Calendar data = Calendar.getInstance();
        Random random = new Random(123);
        List<Negociacao> negociacoes = new ArrayList<>();

        double valor = 40;
        int quantidade = 1000;

        for(int dias = 0; dias < 30; dias++){
            int quantidadeNegociacoesDoDia = random.nextInt(20);

            for(int negociacao = 0; negociacao < quantidadeNegociacoesDoDia; negociacao++){
                valor += (random.nextInt(200) - 100) / 100.0;
                if(valor < 5.0){
                    valor = 5.0;
                }

                quantidade += 1000 - random.nextInt(500);

                Negociacao n = new Negociacao(valor, quantidade, data);
                negociacoes.add(n);
                quantidade = 1000;
            }
            data = (Calendar) data.clone();
            data.add(Calendar.DAY_OF_MONTH, 1);
        }

        XStream stream = new XStream(new DomDriver());
        stream.alias("negociacao", Negociacao.class);
        stream.setMode(XStream.NO_REFERENCES);

        PrintStream out = new PrintStream(new File("negociacoes.xml"));
        out.println(stream.toXML(negociacoes));
    }
}
