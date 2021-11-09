package za.ac.nwu.ImageShare.Persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.ImageShare.Domain.Persistence.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
