package me.dio.sacola.service;

import me.dio.sacola.model.Item;
import me.dio.sacola.model.Sacola;
import me.dio.sacola.resource.dto.ItemDto;

public interface SacolaService {

    Item inserirItemSacola(ItemDto itemDto);

    Sacola verSacola(Long sacolaId);

    Sacola fecharSacola(Long id, int formaPagamento);

}
