package gravador;

import br.ufpb.dcx.ayla.quiz.Pergunta;
import itensartesanato.ItemDeArtesanato;

import java.io.*;
import java.util.List;
import java.util.Map;

public class Gravador {
    public static final String ARQUIVO_ARTESANATOS = "artesanatos.dat";
    public static final String ARQUIVO_QUIZ = "quiz.dat";


    public Map<String, ItemDeArtesanato> recuperaItensDeArtesanato() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_ARTESANATOS))) {
            return (Map<String, ItemDeArtesanato>) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
    }


    public void salvarItensDeArtesantos(Map<String, ItemDeArtesanato> map) throws IOException {
        try (ObjectOutputStream in = new ObjectOutputStream(new FileOutputStream(ARQUIVO_ARTESANATOS))) {
            in.writeObject(map);
        } catch(IOException e){
            throw new IOException(e);
        }

    }

    public List<Pergunta> recuperaListaDePerguntas() throws IOException{
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_QUIZ))){
            return (List<Pergunta>) in.readObject();
        }catch(ClassNotFoundException e){
            throw new IOException(e);
        }
    }

    public void gravarListaDePerguntas(List<Pergunta> lista) throws IOException{
        try(ObjectOutputStream in = new ObjectOutputStream(new FileOutputStream(ARQUIVO_QUIZ))){
            in.writeObject(lista);
        }catch(IOException e){
            throw new IOException(e);
        }
    }
}
