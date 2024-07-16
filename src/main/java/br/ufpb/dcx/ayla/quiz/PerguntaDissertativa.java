package br.ufpb.dcx.ayla.quiz;

public class PerguntaDissertativa extends Pergunta {

    public PerguntaDissertativa(String enunciado, String respostaCorreta){
        super(enunciado, respostaCorreta);
    }

    public PerguntaDissertativa(){
        super();
    }


    @Override
    public boolean estahCorretaResposta(String resposta) {

        return false;
    }
}
