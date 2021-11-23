package za.ac.nwu.ImageShare.Persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ImageShare.Domain.Persistence.Image;

import java.util.UUID;
@Repository
public interface ImageRepository extends JpaRepository<Image, UUID> {
}
