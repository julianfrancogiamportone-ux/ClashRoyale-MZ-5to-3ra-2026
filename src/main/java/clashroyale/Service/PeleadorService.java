package clashroyale.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import clashroyale.Iservice.PeleadorIservice;
import clashroyale.Repository.PeleadorRepository;
import clashroyale.entidades.Peleador;

@Service
public class PeleadorService implements PeleadorIservice {

    @Autowired
    private PeleadorRepository peleadorRepository;

    @Override
    public List<Peleador> findAllPeleadores() {
        return peleadorRepository.findAll();
    }

    @Override
    public Peleador savePeleador(Peleador peleador) {
        return peleadorRepository.save(peleador);
    }

    @Override
    public Peleador findPeleadorById(Long id) {
        return peleadorRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePeleador(Long id) {
        peleadorRepository.deleteById(id);
    }
}