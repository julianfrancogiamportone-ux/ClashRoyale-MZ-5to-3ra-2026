package clashroyale.Iservice;

import java.util.List;
import clashroyale.entidades.Ataque;

public interface AtaqueIservice {
    public List<Ataque> findAllAtaques();
    public Ataque saveAtaque(Ataque ataque);
    public Ataque findAtaqueById(Long id);
    public void deleteAtaque(Long id);
}