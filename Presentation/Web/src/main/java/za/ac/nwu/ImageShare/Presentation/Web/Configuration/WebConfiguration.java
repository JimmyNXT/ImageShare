package za.ac.nwu.ImageShare.Presentation.Web.Configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.ImageShare.Logic.Service.Configuration.ServiceConfiguration;

@Import({ServiceConfiguration.class})
@Configuration
@ComponentScan({"za.ac.nwu.ImageShare.Presentation.Web.Controller", "za.ac.nwu.ImageShare.Presentation.Web.Filter"})
public class WebConfiguration {
}
