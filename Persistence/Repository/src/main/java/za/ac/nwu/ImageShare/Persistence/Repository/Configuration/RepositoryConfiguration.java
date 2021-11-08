package za.ac.nwu.ImageShare.Persistence.Repository.Configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories({"za.ac.nwu.ImageShare.Persistence.Repository.Persistence"})
@EntityScan({"za.ac.nwu.ImageShare.Domain.Persistence"})
@PropertySource(value = "classpath:application-db.properties")
public class RepositoryConfiguration {
}
