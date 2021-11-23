package za.ac.nwu.ImageShare.Persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import za.ac.nwu.ImageShare.Domain.Persistence.Album;
import za.ac.nwu.ImageShare.Domain.Persistence.User;

import java.util.Set;
import java.util.UUID;

public interface AlbumRepository extends JpaRepository<Album, UUID> {
    @Query("select a from Album a where a.owner = :owner")
    Set<Album> findByOwner(User owner);

    @Query("select a from Album a where a.name = :name and a.owner = :owner")
    Album findByNameAndOwner(String name, User owner);

}
