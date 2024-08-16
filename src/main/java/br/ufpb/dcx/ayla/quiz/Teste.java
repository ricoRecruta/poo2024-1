package br.ufpb.dcx.ayla.quiz;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Teste {
    public static void main(String[] args) {
        SistemaQuizAyla sistema = new SistemaQuizAyla();
        sistema.recuperaArquivo();



        boolean continuar = true;

        while (continuar) {
            String j = JOptionPane.showInputDialog("Digite S ou N");
            switch (j) {
                case "S":
                    JOptionPane.showMessageDialog(null, "Cadastre uma pergunta");
                    String enunciado = JOptionPane.showInputDialog("Digite o enunciado da questão");
                    Pergunta per = new PerguntaDissertativa(enunciado, "Sem resposta");
                    sistema.cadastraPergunta(per);
                    for(Pergunta p: sistema.getTodasAsPerguntas()){
                        System.out.println(p.getEnunciado());
                    }

                    break;
                case "N":
                    continuar = false;
                    break;
            }
        }


        sistema.gravarArquivo();

    }

}
