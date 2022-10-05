package me.dio.sacola.resource;

import lombok.RequiredArgsConstructor;
import me.dio.sacola.model.Item;
import me.dio.sacola.model.Sacola;
import me.dio.sacola.resource.dto.ItemDto;
import me.dio.sacola.service.SacolaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ifood-dev-week/sacola")
@RequiredArgsConstructor
public class SacolaResource {

    private final SacolaService sacolaService;

    @PostMapping
    public Item inserirItemSacola(@RequestBody ItemDto itemDto){
        return sacolaService.inserirItemSacola(itemDto);
    }

    @GetMapping("/{sacolaId}")
    public Sacola verSacola(@PathVariable("sacolaId") Long sacolaId){
        return sacolaService.verSacola(sacolaId);
    }

    @PatchMapping("/fechar-sacola/{sacolaId}")
    public Sacola fecharSacola(@PathVariable("sacolaId") Long sacolaId, @RequestParam("formaPagamento") int formaPagamento){
        return sacolaService.fecharSacola(sacolaId, formaPagamento);
    }

}
