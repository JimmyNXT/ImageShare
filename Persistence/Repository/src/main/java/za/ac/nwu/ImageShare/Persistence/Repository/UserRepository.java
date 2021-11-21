package za.ac.nwu.ImageShare.Persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ImageShare.Domain.Persistence.User;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(value =
            "SELECT " +
            "us " +
            "FROM " +
            "User " +
            "us " +
            "WHERE us.userName = :username")
    User getByUsername(String username);
}
