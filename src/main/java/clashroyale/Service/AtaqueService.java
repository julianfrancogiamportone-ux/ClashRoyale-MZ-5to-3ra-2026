package clashroyale.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import clashroyale.Iservice.AtaqueIservice;
import clashroyale.Repository.AtaqueRepository;
import clashroyale.entidades.Ataque;

@Service
public class AtaqueService implements AtaqueIservice {

    @Autowired
    private AtaqueRepository ataqueRepository;

    @Override
    public List<Ataque> findAllAtaques() {
        return ataqueRepository.findAll();
    }

    @Override
    public Ataque saveAtaque(Ataque ataque) {
        return ataqueRepository.save(ataque);
    }

    @Override
    public Ataque findAtaqueById(Long id) {
        return ataqueRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAtaque(Long id) {
        ataqueRepository.deleteById(id);
    }
}