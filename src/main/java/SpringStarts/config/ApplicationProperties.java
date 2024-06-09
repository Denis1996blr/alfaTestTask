package SpringStarts.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix = "appium")
public class ApplicationProperties {

    private Platform platform;

    private String app;

    private String host;
}
