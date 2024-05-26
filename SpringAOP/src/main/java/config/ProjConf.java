package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(basePackages = {"repositories", "services", "proxies"})
@Configuration
@EnableAspectJAutoProxy
public class ProjConf {



}
