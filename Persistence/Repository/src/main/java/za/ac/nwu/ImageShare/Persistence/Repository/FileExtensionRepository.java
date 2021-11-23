package za.ac.nwu.ImageShare.Persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import za.ac.nwu.ImageShare.Domain.Persistence.FileExtension;

public interface FileExtensionRepository extends JpaRepository<FileExtension, Integer> {
    @Query("select f from FileExtension f where f.extension = :extension")
    FileExtension findByExtension(String extension);
}
