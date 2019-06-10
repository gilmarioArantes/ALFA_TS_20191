package br.com.gilmar;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AvaliacaoTeste {

    private Avaliacao avaliacao;

    double nota1;
    double nota2;
    int faltas;
    int cargaHoraria;




    @BeforeTest
    public void setup(){
        avaliacao = new Avaliacao();
    }
/*
    //CT01
    @Test
    public void testaQuantidadeParametrosMenorQuatro(){
        String resultado = avaliacao.avalia(7.0, 6.0, 5);
    }

    //CT02
    @Test
    public void testaQuantidadeParametrosMaiorQuatro(){
        String resultado = avaliacao.avalia(7.0, 6.0, 5, 96, 48);
    }
 */

    //CT03
    @Test(expectedExceptions = ValoresInvalidosException.class)
    public void testaNota1MenorZero() throws ValoresInvalidosException{

        nota1 = -7.0;
        nota2 = 6.0;
        faltas = 5;
        cargaHoraria = 96;
        String resultado = avaliacao.avalia(nota1, nota2, faltas, cargaHoraria);

    }

    //CT04
    @Test(expectedExceptions = ValoresInvalidosException.class)
    public void testaNota1MaiorDez() throws ValoresInvalidosException{

        String resultado = avaliacao.avalia(11.0, 6.0, 5, 96);

    }

    //CT05
    @Test(expectedExceptions = ValoresInvalidosException.class)
    public void testaNota2MenorZero() throws ValoresInvalidosException{

        String resultado = avaliacao.avalia(8.0, -1.0, 5,96);

    }

    //CT06
    @Test(expectedExceptions = ValoresInvalidosException.class)
    public void testaNota2MaiorDez() throws ValoresInvalidosException{

        String resultado = avaliacao.avalia(8.0, 11.0, 5,96);

    }

    //CT07
    @Test(expectedExceptions = ValoresInvalidosException.class)
    public void testaQuantidadeFaltasMenorZero() throws ValoresInvalidosException{

        String resultado = avaliacao.avalia(8.0, 7.0, -3,96);

    }

    //CT08
    @Test(expectedExceptions = ValoresInvalidosException.class)
    public void testaQuantidadeFaltasMaiorCargaHoraria() throws ValoresInvalidosException{

        String resultado = avaliacao.avalia(8.0, 7.0, 97, 96);

    }

    //CT09
    @Test(expectedExceptions = ValoresInvalidosException.class)
    public void testaCargaHorariaMenorZero() throws ValoresInvalidosException{

        String resultado = avaliacao.avalia(8.0, 7.0, 16, -1);

    }

    //CT10
    @Test
    public void testaReprovacaoPorFalta() {
        try{
            String resultado = avaliacao.avalia(8.0, 7.0, 28, 96);
            Assert.assertTrue(resultado.equals("Reprovado por Falta."));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //CT11
    @Test
    public void testaReprovacaoPorMedia(){
        try{
            String resultado = avaliacao.avalia(2.0, 3.0, 15, 96);
            Assert.assertTrue(resultado.equals("Reprovado por Média."));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //CT12
    @Test
    public void testaSegundaChamada(){
        try{
            String resultado = avaliacao.avalia(4.0, 5.0, 15, 96);
            Assert.assertTrue(resultado.equals("Prova Extra."));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //CT13
    @Test
    public void testaAprovacao(){
        try{
            String resultado = avaliacao.avalia(7.0, 8.0, 15, 96);
            Assert.assertTrue(resultado.equals("Aprovado."));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test(expectedExceptions = ValoresInvalidosException.class)
    public void testaExcecao() throws ValoresInvalidosException{

        String resultado = avaliacao.avalia(7.0, 8.0, 15, 96);

    }


}
