package me.dio.sacola.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.sacola.enumeration.FormaPagamento;
import me.dio.sacola.model.Item;
import me.dio.sacola.model.Restaurante;
import me.dio.sacola.model.Sacola;
import me.dio.sacola.repository.ItemRepository;
import me.dio.sacola.repository.ProdutoRepository;
import me.dio.sacola.repository.SacolaRepository;
import me.dio.sacola.resource.dto.ItemDto;
import me.dio.sacola.service.SacolaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //Cria o construtor para o final.
public class SacolaServiceImpl implements SacolaService {

    private final SacolaRepository sacolaRepository;
    private final ProdutoRepository produtoRepository;
    private final ItemRepository itemRepository;

    @Override
    public Item inserirItemSacola(ItemDto itemDto){
        Sacola sacola = verSacola(itemDto.getSacolaId());

        if(sacola.isFechada()){
            throw new RuntimeException("Essa sacola está fechada");
        }

       Item item = Item.builder()
                .quantidade(itemDto.getQuantidade())
                .sacola(sacola)
                .produto(produtoRepository
                        .findById(itemDto
                        .getProdutoId())
                        .<RuntimeException>orElseThrow(() -> {
                            throw new RuntimeException("Esse produto não foi encontrado.");
                        }))
                .build();
        List<Item> itensSacola = sacola.getItens();
        if(itensSacola.isEmpty()) {
            itensSacola.add(item);
        } else {
            Restaurante restauranteSacola = itensSacola.get(0).getProduto().getRestaurante();
            Restaurante restauranteComparar = item.getProduto().getRestaurante();
            if(restauranteSacola.equals(restauranteComparar)) {
                itensSacola.add(item);
            } else {
                throw new RuntimeException("Sacola já contém produtos de outro restaurante, não é possivel colocar produtos de dois restaurantes diferentes na mesma sacola de compras.");
            }
        }
        sacolaRepository.save(sacola);

        return itemRepository.save(item);
    }
    @Override
    public Sacola verSacola(Long sacolaId){
        return sacolaRepository
                .findById(sacolaId)
                .<RuntimeException>orElseThrow(
                () -> {
                    throw new RuntimeException("A sacola não foi encontrada");
                }
        );
    }
    @Override
    public Sacola fecharSacola(Long sacolaId, int formaPagamentoId){
        Sacola sacola = verSacola(sacolaId);
        if (sacola
                .getItens()
                .isEmpty()) {
            throw new RuntimeException("Insira itens na sacola.");
        }
        FormaPagamento formaPagamento =
                formaPagamentoId == 0 ?
                        FormaPagamento.DINHEIRO : FormaPagamento.MAQUINETA;
        sacola.setFormaPagamento(formaPagamento);
        sacola.setFechada(true);
        return sacolaRepository.save(sacola);
    }
}
