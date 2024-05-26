package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = {"repositories", "services", "proxies"})
@Configuration
public class ProjConf {



}
