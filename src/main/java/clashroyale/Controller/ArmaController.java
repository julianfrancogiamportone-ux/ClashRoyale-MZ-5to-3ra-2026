package clashroyale.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import clashroyale.Iservice.ArmaIservice;
import clashroyale.entidades.Arma;

@RestController
@RequestMapping("/api/armas")
public class ArmaController {

    @Autowired
    private ArmaIservice armaService;

    @GetMapping
    public List<Arma> getAllArmas() {
        return armaService.findAllArmas();
    }

    @GetMapping("/{id}")
    public Arma getArmaById(@PathVariable Long id) {
        return armaService.findArmaById(id);
    }

    @PostMapping
    public Arma createArma(@RequestBody Arma arma) {
        return armaService.saveArma(arma);
    }

    @DeleteMapping("/{id}")
    public void deleteArma(@PathVariable Long id) {
        armaService.deleteArma(id);
    }
}
