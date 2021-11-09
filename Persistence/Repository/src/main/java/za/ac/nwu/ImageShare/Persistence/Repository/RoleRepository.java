package za.ac.nwu.ImageShare.Persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.ImageShare.Domain.Persistence.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
