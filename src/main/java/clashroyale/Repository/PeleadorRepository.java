package clashroyale.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import clashroyale.entidades.Peleador;

@Repository
public interface PeleadorRepository extends JpaRepository<Peleador, Long> {
}