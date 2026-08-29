package clashroyale.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import clashroyale.Iservice.AtaqueIservice;
import clashroyale.entidades.Ataque;

@RestController
@CrossOrigin (origins="*")
@RequestMapping("/api/ataques")
public class AtaqueController {

    @Autowired
    private AtaqueIservice ataqueService;

    @GetMapping
    public List<Ataque> getAllAtaques() {
        return ataqueService.findAllAtaques();
    }

    @GetMapping("/{id}")
    public Ataque getAtaqueById(@PathVariable Long id) {
        return ataqueService.findAtaqueById(id);
    }

    @PostMapping
    public Ataque createAtaque(@RequestBody Ataque ataque) {
        return ataqueService.saveAtaque(ataque);
    }

    @DeleteMapping("/{id}")
    public void deleteAtaque(@PathVariable Long id) {
        ataqueService.deleteAtaque(id);
    }
}