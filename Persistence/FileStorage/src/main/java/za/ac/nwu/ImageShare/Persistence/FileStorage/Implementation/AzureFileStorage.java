package za.ac.nwu.ImageShare.Persistence.FileStorage.Implementation;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.blob.*;
import org.springframework.stereotype.Component;
import za.ac.nwu.ImageShare.Persistence.FileStorage.FileStorage;

import java.io.File;
import java.util.UUID;

@Component
public class AzureFileStorage implements FileStorage {
    public static final String storageConnectionString =
            "DefaultEndpointsProtocol=https;" +
                    "AccountName=imagesharejimmynxt;" +
                    "AccountKey=C0Cb7wr+nKGOA37S3StNGekn00cx9KlE8dUG1zWyZEl+GO+PDtWCUrhg9+wLDnORSM1X7RwBqz0xGiVX0qcplA==";

    private CloudStorageAccount storageAccount;
    private CloudBlobClient blobClient;
    private CloudBlobContainer container;


    public AzureFileStorage() {
        try {
            this.storageAccount = CloudStorageAccount.parse(storageConnectionString);
            this.blobClient = storageAccount.createCloudBlobClient();
            this.container = blobClient.getContainerReference("quickstartcontainer");
        } catch (Exception e) {
            //TODO: Throw custom exception
        }
    }

    public boolean uploadFile(UUID fileID, byte[] fileContent) {
        try {
            container.createIfNotExists(BlobContainerPublicAccessType.CONTAINER, new BlobRequestOptions(), new OperationContext());
            CloudBlockBlob blob = container.getBlockBlobReference(fileID.toString());
            blob.uploadFromByteArray(fileContent, 0, fileContent.length);
            return true;
        } catch (Exception e) {
            //TODO: Throw custom exception
        }
        return false;
    }

    public byte[] downloadFile(UUID fileID) {
        try {
            container.createIfNotExists(BlobContainerPublicAccessType.CONTAINER, new BlobRequestOptions(), new OperationContext());
            CloudBlockBlob blob = container.getBlockBlobReference(fileID.toString());
            byte[] byteBuffer = new byte[(int) blob.getProperties().getLength()];
            blob.downloadToByteArray(byteBuffer, 0);
            return byteBuffer;
        } catch (Exception e) {
            //TODO: Throw custom exception
        }
        return null;
    }
}
