package clashroyale.Iservice;

import java.util.List;
import clashroyale.entidades.Peleador;

public interface PeleadorIservice {
    public List<Peleador> findAllPeleadores();
    public Peleador savePeleador(Peleador peleador);
    public Peleador findPeleadorById(Long id);
    public void deletePeleador(Long id);
}