package itensartesanato;


import javax.imageio.IIOException;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class ProgramaArtesanatoRioTinto {
    public static void main(String[] args) {
        boolean continuar = true;
        SistemaFeiraArtesanatoRioTinto sistema = new SistemaFeiraArtesanatoRioTinto();
        sistema.recuperaItensDeArtesanato();

        while(continuar){
            String opcao = JOptionPane.showInputDialog("Digite uma opção\n 1.Cadastrar item\n 2.Pesquisar item pelo nome\n 3.pesquisar item pelo codigo\n 4.Sair ");

            if(opcao.equals("1")){
                //Cadastrar

                String tipoDeItem = JOptionPane.showInputDialog("Qual o tipo de item \n 1. roupa \n");

                if(tipoDeItem.equals("1")){
                    String tamanho = JOptionPane.showInputDialog("Qual o tamanho da Roupa");
                    String codigo = JOptionPane.showInputDialog("Qual o código");
                    String nome = JOptionPane.showInputDialog("Qual o nome? ");
                    Double preco = Double.parseDouble(JOptionPane.showInputDialog("Qual o preco"));
                    ItemDeArtesanato item = new Roupa(codigo,nome,preco);



                    try{
                        sistema.cadastraItem(item);
                        JOptionPane.showMessageDialog(null,"Item cadastrado com sucesso"+ item.toString());
                    } catch(Exception e){
                        JOptionPane.showMessageDialog(null,e.getMessage());
                        e.printStackTrace();
                    }
                    //vai agora

                }




            } else if (opcao.equals("2")){
                String nomeItemAPesquisar = JOptionPane.showInputDialog("Digite o nome do item a pesquisar: (início do nome)");
                List<ItemDeArtesanato> itensPorNome = sistema.pesquisaItensPeloNome(nomeItemAPesquisar);
                if(itensPorNome.size() == 0){
                    JOptionPane.showMessageDialog(null,"Não existe nenhum item com esse nome");
                } else {
                    JOptionPane.showMessageDialog(null,"Itens achados");
                    for(ItemDeArtesanato i: itensPorNome){
                        JOptionPane.showMessageDialog(null,i.toString());
                    }
                }
            } else if(opcao.equals("3")){
                try{
                    String codigoPesq = JOptionPane.showInputDialog("Mostre o codigo do item a pesquisar");
                    ItemDeArtesanato itemAchado = sistema.pesquisaItemPeloCodigo(codigoPesq);
                    JOptionPane.showMessageDialog(null,"Item achado:"+itemAchado.toString());
                } catch(ItemInexistenteExcepition i){
                    JOptionPane.showMessageDialog(null,"Não foi encontrado item com o código");
                    System.err.println(i.getMessage());
                    i.printStackTrace();
                }
            } else if(opcao.equals("4")){
                continuar = false;
                JOptionPane.showMessageDialog(null,"Saindo do sitema");
            }

        }
        sistema.gravarItensDeArtesanato();

    }
}
