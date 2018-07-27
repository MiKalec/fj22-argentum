import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.reader.LeitorXML;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class LeitorXMLTest {

    @Test
    public void carregaXMLComUmaNegociacaoEmListaUnitaria(){
        String xmlTeste = "<list>" +
                            "<negociacao>" +
                                "<preco>43.5</preco>" +
                                "<quantidade>1000</quantidade>" +
                                "<data>" +
                                    "<time>1322233344455</time>" +
                                "</data>" +
                            "</negociacao>" +
                          "</list>";

        LeitorXML leitor = new LeitorXML();
        InputStream xml = new ByteArrayInputStream(xmlTeste.getBytes());
        List<Negociacao> negociacoes = leitor.carrega(xml);

        Assert.assertEquals(1, negociacoes.size());
        Assert.assertEquals(1000, negociacoes.get(0).getQuantidade());
        Assert.assertEquals(43.5, negociacoes.get(0).getPreco(), 0.00001);
    }

    @Test
    public void carregaXMLSemNegociacao(){
        String xmlTeste = "<list>" +
                          "</list>";

        LeitorXML leitor = new LeitorXML();
        InputStream xml = new ByteArrayInputStream(xmlTeste.getBytes());
        List<Negociacao> negociacoes = leitor.carrega(xml);

        Assert.assertEquals(0, negociacoes.size());
        Assert.assertTrue(negociacoes.isEmpty());
    }

    @Test
    public void carregaXMLComPrecoFaltando(){
        String xmlTeste = "<list>" +
                            "<negociacao>" +
                                "<quantidade>1000</quantidade>" +
                                "<data>" +
                                    "<time>1322233344455</time>" +
                                "</data>" +
                            "</negociacao>" +
                          "</list>";

        LeitorXML leitor = new LeitorXML();
        InputStream xml = new ByteArrayInputStream(xmlTeste.getBytes());
        List<Negociacao> negociacoes = leitor.carrega(xml);

        Assert.assertEquals(0.0, negociacoes.get(0).getPreco(), 0.00001);
    }
    @Test
    public void carregaXMLComQuantidadeFaltando(){
        String xmlTeste = "<list>" +
                            "<negociacao>" +
                                "<preco>43.5</preco>" +
                                "<data>" +
                                    "<time>1322233344455</time>" +
                                "</data>" +
                            "</negociacao>" +
                          "</list>";

        LeitorXML leitor = new LeitorXML();
        InputStream xml = new ByteArrayInputStream(xmlTeste.getBytes());
        List<Negociacao> negociacoes = leitor.carrega(xml);

        Assert.assertEquals(0, negociacoes.get(0).getQuantidade());
    }
}
