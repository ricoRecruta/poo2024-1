package br.ufpb.dcx.ayla.artesanato;

import java.util.List;

/**
 * Sistema para gerenciar itens de artesanato
 */

public interface SistemaFeiraArtesanato {
    /**
     * Cadastra novo item no sistema.
     * @param item O item a ser adicionado
     * @return true se o item foi cdastrado, ou false caso ele já exista no sitema.
     */
    public boolean cadastraItem(ItemDeArtesanato item);

    /**
     * Pesquisa todos os itens cuja o nome começa com o nome passado como parâmetro
     * @param nome O nome a pesquisar
     * @return Um lista contendo os itens cuja  nome começa com o parâmetro passado
     */
    public List<ItemDeArtesanato> pesquisaItensPeloNome(String nome);

    /**
     * Pesquisa os itens cuja o preço é menor ou igual ao valor passado no parâmetro
     * @param preco O valor dos itens a pesquisar
     * @return Uma lista de  itens cuja o preço é menor ou igual ao valor passado no parâmetro
     */
    public List<ItemDeArtesanato> pesquisaItensAbaixoDoPreco(double preco);

    /**
     * Pesquisa o item cuja o código é passado por parâmetro
     * @param codigo Codigo do item a pesquisar
     * @return O item encontrado
     * @throws ItemInexistenteExcepition Se não for encontrado nenhum item com o código passado.
     */
    public ItemDeArtesanato pesquisaItemPeloCodigo(String codigo) throws ItemInexistenteExcepition;



}
