package clashroyale.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import clashroyale.Iservice.ArmaIservice;
import clashroyale.Repository.ArmaRepository;
import clashroyale.entidades.Arma;

@Service
public class ArmaService implements ArmaIservice {

    @Autowired
    private ArmaRepository armaRepository;

    @Override
    public List<Arma> findAllArmas() {
        return armaRepository.findAll();
    }

    @Override
    public Arma saveArma(Arma arma) {
        return armaRepository.save(arma);
    }

    @Override
    public Arma findArmaById(Long id) {
        return armaRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteArma(Long id) {
        armaRepository.deleteById(id);
    }
}