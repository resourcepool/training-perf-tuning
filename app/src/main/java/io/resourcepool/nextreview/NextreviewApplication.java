package io.resourcepool.nextreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

@EnableJpaRepositories(basePackages = "io.resourcepool.nextreview.persistence")
@SpringBootApplication
public class NextreviewApplication {

  public static void main(String[] args) {
    SpringApplication.run(NextreviewApplication.class, args);
  }

  @Bean
  public LocaleResolver localeResolver() {
    Locale defaultLocale = Locale.ENGLISH;
    CookieLocaleResolver clr = new CookieLocaleResolver();
    clr.setDefaultLocale(defaultLocale);
    return clr;
  }

  @Bean
  public LocaleChangeInterceptor localeChangeInterceptor() {
    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
    lci.setParamName("lang");
    return lci;
  }
}
