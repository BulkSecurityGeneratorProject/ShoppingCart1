package com.jackson.shoppingcart.config;

import com.jackson.shoppingcart.config.ApplicationProperties;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;
import org.ehcache.jsr107.Eh107Configuration;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
@AutoConfigureAfter(value = { MetricsConfiguration.class })
@AutoConfigureBefore(value = { WebConfigurer.class, DatabaseConfiguration.class })
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(ApplicationProperties applicationProperties) {
        ApplicationProperties.Cache.Ehcache ehcache =
            applicationProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(Expirations.timeToLiveExpiration(Duration.of(ehcache.getTimeToLiveSeconds(), TimeUnit.SECONDS)))
                .build());
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            cm.createCache(com.jackson.shoppingcart.repository.UserRepository.USERS_BY_LOGIN_CACHE, jcacheConfiguration);
            cm.createCache(com.jackson.shoppingcart.repository.UserRepository.USERS_BY_EMAIL_CACHE, jcacheConfiguration);
            cm.createCache(com.jackson.shoppingcart.domain.User.class.getName(), jcacheConfiguration);
            cm.createCache(com.jackson.shoppingcart.domain.Authority.class.getName(), jcacheConfiguration);
            cm.createCache(com.jackson.shoppingcart.domain.User.class.getName() + ".authorities", jcacheConfiguration);
            cm.createCache(com.jackson.shoppingcart.domain.Category.class.getName(), jcacheConfiguration);
            cm.createCache(com.jackson.shoppingcart.domain.Category.class.getName() + ".products", jcacheConfiguration);
            cm.createCache(com.jackson.shoppingcart.domain.Product.class.getName(), jcacheConfiguration);
            cm.createCache(com.jackson.shoppingcart.domain.Product.class.getName() + ".categories", jcacheConfiguration);
            cm.createCache(com.jackson.shoppingcart.domain.Customer.class.getName(), jcacheConfiguration);
            cm.createCache(com.jackson.shoppingcart.domain.Customer.class.getName() + ".addresses", jcacheConfiguration);
            cm.createCache(com.jackson.shoppingcart.domain.Customer.class.getName() + ".carts", jcacheConfiguration);
            cm.createCache(com.jackson.shoppingcart.domain.Address.class.getName(), jcacheConfiguration);
            cm.createCache(com.jackson.shoppingcart.domain.Cart.class.getName(), jcacheConfiguration);
            cm.createCache(com.jackson.shoppingcart.domain.Cart.class.getName() + ".products", jcacheConfiguration);
            // jhipster-needle-ehcache-add-entry
        };
    }
}
