package za.ac.nwu.ImageShare.Logic.Translator.Configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.ImageShare.Persistence.FileStorage.Configuration.FileStorageConfiguration;
import za.ac.nwu.ImageShare.Persistence.FileStorage.FileStorage;
import za.ac.nwu.ImageShare.Persistence.Repository.Configuration.RepositoryConfiguration;

@Import({RepositoryConfiguration.class, FileStorageConfiguration.class})
@Configuration
@ComponentScan({"za.ac.nwu.ImageShare.Logic.Translator"})
public class TranslatorConfiguration {
}
