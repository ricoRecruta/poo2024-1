package br.ufpb.dcx.ayla.quiz;

import java.util.Collections;
import java.util.List;
import java.util.Vector;
public class Teste {
    public static void main(String[] args) {
        Pergunta pergunta = new PerguntaDissertativa();
        System.out.println(pergunta.toString());

        Pergunta pergunta2 = new PerguntaDissertativa("Quem descobriu o Brasil ? ", "4");
        Pergunta pergunta3 = new PerguntaDissertativa("Quanto é 1 + 1 ? ", "2");

        List<Pergunta> perguntaList = new Vector();

        perguntaList.add(pergunta);
        perguntaList.add(pergunta2);
        perguntaList.add(pergunta3);

        Collections.sort(perguntaList);

        for(Pergunta p: perguntaList){
            System.out.println(p.getEnunciado());
        }

    }

}
