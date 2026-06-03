package clashroyale.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import clashroyale.entidades.Ataque;

@Repository
public interface AtaqueRepository extends JpaRepository<Ataque, Long> {
}
