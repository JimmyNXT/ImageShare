package za.ac.nwu.ImageShare.Logic.Service.Configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.ImageShare.Logic.Translator.Configuration.TranslatorConfiguration;

@Import({TranslatorConfiguration.class})
@Configuration
@ComponentScan({"za.ac.nwu.ImageShare.Logic.Service"})
public class ServiceConfiguration {
}
