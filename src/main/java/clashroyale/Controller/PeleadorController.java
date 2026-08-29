package clashroyale.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import clashroyale.Iservice.PeleadorIservice;
import clashroyale.entidades.Peleador;

@RestController
@RequestMapping("/api/peleadores")
@CrossOrigin (origins="*")
public class PeleadorController {

    @Autowired
    private PeleadorIservice peleadorService;

    @GetMapping
    public List<Peleador> getAllPeleadores() {
        return peleadorService.findAllPeleadores();
    }

    @GetMapping("/{id}")
    public Peleador getPeleadorById(@PathVariable Long id) {
        return peleadorService.findPeleadorById(id);
    }

    @PostMapping
    public Peleador createPeleador(@RequestBody Peleador peleador) {
        return peleadorService.savePeleador(peleador);
    }

    @DeleteMapping("/{id}")
    public void deletePeleador(@PathVariable Long id) {
        peleadorService.deletePeleador(id);
    }
}
