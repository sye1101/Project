package umc.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Missions;

public interface MissionRepository extends JpaRepository<Missions, Long> {
}
