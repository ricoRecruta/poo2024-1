package br.ufpb.dcx.ayla.quiz;

public abstract class Pergunta implements Comparable<Pergunta> {
    private String enunciado;
    private String respostaCorreta;

    public Pergunta(String enunciado, String respostaCorreta){
        this.enunciado = enunciado;
        this.respostaCorreta = respostaCorreta;
    }

    public Pergunta(){
        this("","");
    }

    public int compareTo(Pergunta pergunta2){
        return this.enunciado.compareTo(pergunta2.enunciado);
    }


    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(String respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    public abstract boolean estahCorretaResposta(String resposta);

}
