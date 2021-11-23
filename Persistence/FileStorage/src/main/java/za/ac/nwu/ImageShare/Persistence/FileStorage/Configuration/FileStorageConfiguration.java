package za.ac.nwu.ImageShare.Persistence.FileStorage.Configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:application.properties")
@ComponentScan({"za.ac.nwu.ImageShare.Persistence.FileStorage"})
public class FileStorageConfiguration {
}
