package za.ac.nwu.ImageShare.Persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    @Modifying
    @Query("" +
            "UPDATE " +
            "User u " +
            "SET " +
            "u.userName = :username, " +
            "u.email = :email, " +
            "u.password = :password " +
            "WHERE u.ID = :userID")
    int updateUser(UUID userID, String username, String email, String password);


}
