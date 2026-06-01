package clashroyale.Iservice;

import java.util.List;
import clashroyale.entidades.Arma;

public interface ArmaIservice {
    public List<Arma> findAllArmas();
    public Arma saveArma(Arma arma);
    public Arma findArmaById(Long id);
    public void deleteArma(Long id);
}