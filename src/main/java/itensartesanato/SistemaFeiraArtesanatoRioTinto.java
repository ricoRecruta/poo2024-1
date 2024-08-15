package itensartesanato;

import gravador.Gravador;

import java.io.IOException;
import java.util.*;

public class SistemaFeiraArtesanatoRioTinto implements SistemaFeiraArtesanato{

    private Map<String,ItemDeArtesanato> itensDeArtesanato;

    public static final String PREFIXO_CODIGO = "COD";
    Gravador gravador = new Gravador();

    public SistemaFeiraArtesanatoRioTinto(){
        this.itensDeArtesanato = new HashMap<>();
    }


    @Override
    public void cadastraItem(ItemDeArtesanato item) throws CodigoInvalidoException,ItemJaExisteException{

        if(itensDeArtesanato.containsKey(item.getCodigo())){
            throw new ItemJaExisteException("Ja existe item com o código"+item.getCodigo());
        } else{
            if(item.getCodigo().startsWith(PREFIXO_CODIGO)){
                this.itensDeArtesanato.put(item.getCodigo(), item);
            } else {
                throw new CodigoInvalidoException("Comece seu código com "+ PREFIXO_CODIGO);
            }
        }
    }

    @Override
    public List<ItemDeArtesanato> pesquisaItensPeloNome(String nome) {
        List<ItemDeArtesanato> itensPeloNome = new LinkedList<>();
        for(ItemDeArtesanato item : this.itensDeArtesanato.values()){
            if(item.getNome().startsWith(nome)){
                itensPeloNome.add(item);
            }
        }
        Collections.sort(itensPeloNome);
        return itensPeloNome;
    }

    @Override
    public List<ItemDeArtesanato> pesquisaItensAbaixoDoPreco(double preco) {

        List<ItemDeArtesanato> itensPorPreco = new LinkedList<>();
        for(ItemDeArtesanato item: this.itensDeArtesanato.values()){
            if(item.getPreco() <= preco){
                itensPorPreco.add(item);
            }
        }
        Collections.sort(itensPorPreco);
        return itensPorPreco;
    }

    @Override
    public ItemDeArtesanato pesquisaItemPeloCodigo(String codigo) throws ItemInexistenteExcepition {

        ItemDeArtesanato item = this.itensDeArtesanato.get(codigo);

        if(item == null){
            throw new ItemInexistenteExcepition("Não existe item com o código:"+codigo);
        } else {
            return item;
        }

    }

    public void gravarItensDeArtesanato()  {
        try {
            gravador.salvarItensDeArtesantos(this.itensDeArtesanato);
        } catch(IOException e){
            System.err.println(e);
        }
    }

    public void recuperaItensDeArtesanato(){
        try {
            gravador.recuperaItensDeArtesanato();
        } catch(IOException e){
            System.err.println(e);
            this.itensDeArtesanato = new HashMap<>();
        }


    }
}
