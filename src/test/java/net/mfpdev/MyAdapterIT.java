package net.mfpdev;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyAdapterIT.class)
@Configuration
@PropertySource("classpath:/defaults.properties")
public class MyAdapterIT {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Value("${mfp-runtime-url}/api/adapters/adapterWithAutoTests")
    String adapterURL;

    @Test
    public void testUnprotectedResource(){
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(adapterURL+"/resource/unprotected/name", String.class);
        Assert.assertEquals("Hello: name", response);
    }
}