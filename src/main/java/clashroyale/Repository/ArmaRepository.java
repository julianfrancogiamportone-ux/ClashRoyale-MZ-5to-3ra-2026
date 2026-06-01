package clashroyale.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import clashroyale.entidades.Arma;

@Repository
public interface ArmaRepository extends JpaRepository<Arma, Long> {
}
