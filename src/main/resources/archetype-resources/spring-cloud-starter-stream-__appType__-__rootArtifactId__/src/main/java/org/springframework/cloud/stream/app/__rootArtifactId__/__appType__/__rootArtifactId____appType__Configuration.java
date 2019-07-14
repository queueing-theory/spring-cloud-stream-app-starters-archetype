package ${groupId}.${packagePath};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.${appInterface};

@EnableBinding(${ccAppType}.class)
@EnableConfigurationProperties(${ccAppName}${ccAppType}Properties.class)
public class ${ccAppName}${ccAppType}Configuration {
    @Autowired
    private ${ccAppName}${ccAppType}Properties properties;

}

