package za.ac.nwu.ImageShare.Persistence.FileStorage;

import java.util.UUID;

public interface FileStorage {
    boolean uploadFile(UUID fileID, byte[] fileContent);
    byte[] downloadFile(UUID fileID);
}
