package com.jackson.shoppingcart.config;

import com.jackson.shoppingcart.config.ApplicationProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * Properties specific to Shopping Cart.
 * <p>
 * Properties are configured in the application.yml file.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)

public class ApplicationProperties {
        private final com.jackson.shoppingcart.config.ApplicationProperties.Async async = new com.jackson.shoppingcart.config.ApplicationProperties.Async();
        private final com.jackson.shoppingcart.config.ApplicationProperties.Http http = new com.jackson.shoppingcart.config.ApplicationProperties.Http();
        private final com.jackson.shoppingcart.config.ApplicationProperties.Cache cache = new com.jackson.shoppingcart.config.ApplicationProperties.Cache();
        private final com.jackson.shoppingcart.config.ApplicationProperties.Mail mail = new com.jackson.shoppingcart.config.ApplicationProperties.Mail();
        private final com.jackson.shoppingcart.config.ApplicationProperties.Security security = new com.jackson.shoppingcart.config.ApplicationProperties.Security();
        private final com.jackson.shoppingcart.config.ApplicationProperties.Swagger swagger = new com.jackson.shoppingcart.config.ApplicationProperties.Swagger();
        private final com.jackson.shoppingcart.config.ApplicationProperties.Metrics metrics = new com.jackson.shoppingcart.config.ApplicationProperties.Metrics();
        private final com.jackson.shoppingcart.config.ApplicationProperties.Logging logging = new com.jackson.shoppingcart.config.ApplicationProperties.Logging();
        private final CorsConfiguration cors = new CorsConfiguration();
        private final com.jackson.shoppingcart.config.ApplicationProperties.Social social = new com.jackson.shoppingcart.config.ApplicationProperties.Social();
        private final com.jackson.shoppingcart.config.ApplicationProperties.Gateway gateway = new com.jackson.shoppingcart.config.ApplicationProperties.Gateway();
        private final com.jackson.shoppingcart.config.ApplicationProperties.Ribbon ribbon = new com.jackson.shoppingcart.config.ApplicationProperties.Ribbon();
        private final com.jackson.shoppingcart.config.ApplicationProperties.Registry registry = new com.jackson.shoppingcart.config.ApplicationProperties.Registry();

        public ApplicationProperties() {
        }

        public com.jackson.shoppingcart.config.ApplicationProperties.Async getAsync() {
            return this.async;
        }

        public com.jackson.shoppingcart.config.ApplicationProperties.Http getHttp() {
            return this.http;
        }

        public com.jackson.shoppingcart.config.ApplicationProperties.Cache getCache() {
            return this.cache;
        }

        public com.jackson.shoppingcart.config.ApplicationProperties.Mail getMail() {
            return this.mail;
        }

        public com.jackson.shoppingcart.config.ApplicationProperties.Registry getRegistry() {
            return this.registry;
        }

        public com.jackson.shoppingcart.config.ApplicationProperties.Security getSecurity() {
            return this.security;
        }

        public com.jackson.shoppingcart.config.ApplicationProperties.Swagger getSwagger() {
            return this.swagger;
        }

        public com.jackson.shoppingcart.config.ApplicationProperties.Metrics getMetrics() {
            return this.metrics;
        }

        public com.jackson.shoppingcart.config.ApplicationProperties.Logging getLogging() {
            return this.logging;
        }

        public CorsConfiguration getCors() {
            return this.cors;
        }

        public com.jackson.shoppingcart.config.ApplicationProperties.Social getSocial() {
            return this.social;
        }

        public com.jackson.shoppingcart.config.ApplicationProperties.Gateway getGateway() {
            return this.gateway;
        }

        public com.jackson.shoppingcart.config.ApplicationProperties.Ribbon getRibbon() {
            return this.ribbon;
        }

        public static class Registry {
            private String password;

            public Registry() {
                this.password = io.github.jhipster.config.JHipsterDefaults.Registry.password;
            }

            public String getPassword() {
                return this.password;
            }

            public void setPassword(String password) {
                this.password = password;
            }
        }

        public static class Ribbon {
            private String[] displayOnActiveProfiles;

            public Ribbon() {
                this.displayOnActiveProfiles = io.github.jhipster.config.JHipsterDefaults.Ribbon.displayOnActiveProfiles;
            }

            public String[] getDisplayOnActiveProfiles() {
                return this.displayOnActiveProfiles;
            }

            public void setDisplayOnActiveProfiles(String[] displayOnActiveProfiles) {
                this.displayOnActiveProfiles = displayOnActiveProfiles;
            }
        }

        public static class Gateway {
            private final com.jackson.shoppingcart.config.ApplicationProperties.Gateway.RateLimiting rateLimiting = new com.jackson.shoppingcart.config.ApplicationProperties.Gateway.RateLimiting();
            private Map<String, List<String>> authorizedMicroservicesEndpoints;

            public Gateway() {
                this.authorizedMicroservicesEndpoints = io.github.jhipster.config.JHipsterDefaults.Gateway.authorizedMicroservicesEndpoints;
            }

            public com.jackson.shoppingcart.config.ApplicationProperties.Gateway.RateLimiting getRateLimiting() {
                return this.rateLimiting;
            }

            public Map<String, List<String>> getAuthorizedMicroservicesEndpoints() {
                return this.authorizedMicroservicesEndpoints;
            }

            public void setAuthorizedMicroservicesEndpoints(Map<String, List<String>> authorizedMicroservicesEndpoints) {
                this.authorizedMicroservicesEndpoints = authorizedMicroservicesEndpoints;
            }

            public static class RateLimiting {
                private boolean enabled = false;
                private long limit = 100000L;
                private int durationInSeconds = 3600;

                public RateLimiting() {
                }

                public boolean isEnabled() {
                    return this.enabled;
                }

                public void setEnabled(boolean enabled) {
                    this.enabled = enabled;
                }

                public long getLimit() {
                    return this.limit;
                }

                public void setLimit(long limit) {
                    this.limit = limit;
                }

                public int getDurationInSeconds() {
                    return this.durationInSeconds;
                }

                public void setDurationInSeconds(int durationInSeconds) {
                    this.durationInSeconds = durationInSeconds;
                }
            }
        }

        public static class Social {
            private String redirectAfterSignIn = "/#/home";

            public Social() {
            }

            public String getRedirectAfterSignIn() {
                return this.redirectAfterSignIn;
            }

            public void setRedirectAfterSignIn(String redirectAfterSignIn) {
                this.redirectAfterSignIn = redirectAfterSignIn;
            }
        }

        public static class Logging {
            private final com.jackson.shoppingcart.config.ApplicationProperties.Logging.Logstash logstash = new com.jackson.shoppingcart.config.ApplicationProperties.Logging.Logstash();
            private final com.jackson.shoppingcart.config.ApplicationProperties.Logging.SpectatorMetrics spectatorMetrics = new com.jackson.shoppingcart.config.ApplicationProperties.Logging.SpectatorMetrics();

            public Logging() {
            }

            public com.jackson.shoppingcart.config.ApplicationProperties.Logging.Logstash getLogstash() {
                return this.logstash;
            }

            public com.jackson.shoppingcart.config.ApplicationProperties.Logging.SpectatorMetrics getSpectatorMetrics() {
                return this.spectatorMetrics;
            }

            public static class SpectatorMetrics {
                private boolean enabled = false;

                public SpectatorMetrics() {
                }

                public boolean isEnabled() {
                    return this.enabled;
                }

                public void setEnabled(boolean enabled) {
                    this.enabled = enabled;
                }
            }

            public static class Logstash {
                private boolean enabled = false;
                private String host = "localhost";
                private int port = 5000;
                private int queueSize = 512;

                public Logstash() {
                }

                public boolean isEnabled() {
                    return this.enabled;
                }

                public void setEnabled(boolean enabled) {
                    this.enabled = enabled;
                }

                public String getHost() {
                    return this.host;
                }

                public void setHost(String host) {
                    this.host = host;
                }

                public int getPort() {
                    return this.port;
                }

                public void setPort(int port) {
                    this.port = port;
                }

                public int getQueueSize() {
                    return this.queueSize;
                }

                public void setQueueSize(int queueSize) {
                    this.queueSize = queueSize;
                }
            }
        }

        public static class Metrics {
            private final com.jackson.shoppingcart.config.ApplicationProperties.Metrics.Jmx jmx = new com.jackson.shoppingcart.config.ApplicationProperties.Metrics.Jmx();
            private final com.jackson.shoppingcart.config.ApplicationProperties.Metrics.Graphite graphite = new com.jackson.shoppingcart.config.ApplicationProperties.Metrics.Graphite();
            private final com.jackson.shoppingcart.config.ApplicationProperties.Metrics.Prometheus prometheus = new com.jackson.shoppingcart.config.ApplicationProperties.Metrics.Prometheus();
            private final com.jackson.shoppingcart.config.ApplicationProperties.Metrics.Logs logs = new com.jackson.shoppingcart.config.ApplicationProperties.Metrics.Logs();

            public Metrics() {
            }

            public com.jackson.shoppingcart.config.ApplicationProperties.Metrics.Jmx getJmx() {
                return this.jmx;
            }

            public com.jackson.shoppingcart.config.ApplicationProperties.Metrics.Graphite getGraphite() {
                return this.graphite;
            }

            public com.jackson.shoppingcart.config.ApplicationProperties.Metrics.Prometheus getPrometheus() {
                return this.prometheus;
            }

            public com.jackson.shoppingcart.config.ApplicationProperties.Metrics.Logs getLogs() {
                return this.logs;
            }

            public static class Logs {
                private boolean enabled = false;
                private long reportFrequency = 60L;

                public Logs() {
                }

                public boolean isEnabled() {
                    return this.enabled;
                }

                public void setEnabled(boolean enabled) {
                    this.enabled = enabled;
                }

                public long getReportFrequency() {
                    return this.reportFrequency;
                }

                public void setReportFrequency(long reportFrequency) {
                    this.reportFrequency = reportFrequency;
                }
            }

            public static class Prometheus {
                private boolean enabled = false;
                private String endpoint = "/prometheusMetrics";

                public Prometheus() {
                }

                public boolean isEnabled() {
                    return this.enabled;
                }

                public void setEnabled(boolean enabled) {
                    this.enabled = enabled;
                }

                public String getEndpoint() {
                    return this.endpoint;
                }

                public void setEndpoint(String endpoint) {
                    this.endpoint = endpoint;
                }
            }

            public static class Graphite {
                private boolean enabled = false;
                private String host = "localhost";
                private int port = 2003;
                private String prefix = "jhipsterApplication";

                public Graphite() {
                }

                public boolean isEnabled() {
                    return this.enabled;
                }

                public void setEnabled(boolean enabled) {
                    this.enabled = enabled;
                }

                public String getHost() {
                    return this.host;
                }

                public void setHost(String host) {
                    this.host = host;
                }

                public int getPort() {
                    return this.port;
                }

                public void setPort(int port) {
                    this.port = port;
                }

                public String getPrefix() {
                    return this.prefix;
                }

                public void setPrefix(String prefix) {
                    this.prefix = prefix;
                }
            }

            public static class Jmx {
                private boolean enabled = true;

                public Jmx() {
                }

                public boolean isEnabled() {
                    return this.enabled;
                }

                public void setEnabled(boolean enabled) {
                    this.enabled = enabled;
                }
            }
        }

        public static class Swagger {
            private String title = "Application API";
            private String description = "API documentation";
            private String version = "0.0.1";
            private String termsOfServiceUrl;
            private String contactName;
            private String contactUrl;
            private String contactEmail;
            private String license;
            private String licenseUrl;
            private String defaultIncludePattern;
            private String host;
            private String[] protocols;

            public Swagger() {
                this.termsOfServiceUrl = io.github.jhipster.config.JHipsterDefaults.Swagger.termsOfServiceUrl;
                this.contactName = io.github.jhipster.config.JHipsterDefaults.Swagger.contactName;
                this.contactUrl = io.github.jhipster.config.JHipsterDefaults.Swagger.contactUrl;
                this.contactEmail = io.github.jhipster.config.JHipsterDefaults.Swagger.contactEmail;
                this.license = io.github.jhipster.config.JHipsterDefaults.Swagger.license;
                this.licenseUrl = io.github.jhipster.config.JHipsterDefaults.Swagger.licenseUrl;
                this.defaultIncludePattern = "/api/.*";
                this.host = io.github.jhipster.config.JHipsterDefaults.Swagger.host;
                this.protocols = io.github.jhipster.config.JHipsterDefaults.Swagger.protocols;
            }

            public String getTitle() {
                return this.title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return this.description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getVersion() {
                return this.version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public String getTermsOfServiceUrl() {
                return this.termsOfServiceUrl;
            }

            public void setTermsOfServiceUrl(String termsOfServiceUrl) {
                this.termsOfServiceUrl = termsOfServiceUrl;
            }

            public String getContactName() {
                return this.contactName;
            }

            public void setContactName(String contactName) {
                this.contactName = contactName;
            }

            public String getContactUrl() {
                return this.contactUrl;
            }

            public void setContactUrl(String contactUrl) {
                this.contactUrl = contactUrl;
            }

            public String getContactEmail() {
                return this.contactEmail;
            }

            public void setContactEmail(String contactEmail) {
                this.contactEmail = contactEmail;
            }

            public String getLicense() {
                return this.license;
            }

            public void setLicense(String license) {
                this.license = license;
            }

            public String getLicenseUrl() {
                return this.licenseUrl;
            }

            public void setLicenseUrl(String licenseUrl) {
                this.licenseUrl = licenseUrl;
            }

            public String getDefaultIncludePattern() {
                return this.defaultIncludePattern;
            }

            public void setDefaultIncludePattern(String defaultIncludePattern) {
                this.defaultIncludePattern = defaultIncludePattern;
            }

            public String getHost() {
                return this.host;
            }

            public void setHost(String host) {
                this.host = host;
            }

            public String[] getProtocols() {
                return this.protocols;
            }

            public void setProtocols(String[] protocols) {
                this.protocols = protocols;
            }
        }

        public static class Security {
            private final com.jackson.shoppingcart.config.ApplicationProperties.Security.ClientAuthorization clientAuthorization = new com.jackson.shoppingcart.config.ApplicationProperties.Security.ClientAuthorization();
            private final com.jackson.shoppingcart.config.ApplicationProperties.Security.Authentication authentication = new com.jackson.shoppingcart.config.ApplicationProperties.Security.Authentication();
            private final com.jackson.shoppingcart.config.ApplicationProperties.Security.RememberMe rememberMe = new com.jackson.shoppingcart.config.ApplicationProperties.Security.RememberMe();

            public Security() {
            }

            public com.jackson.shoppingcart.config.ApplicationProperties.Security.ClientAuthorization getClientAuthorization() {
                return this.clientAuthorization;
            }

            public com.jackson.shoppingcart.config.ApplicationProperties.Security.Authentication getAuthentication() {
                return this.authentication;
            }

            public com.jackson.shoppingcart.config.ApplicationProperties.Security.RememberMe getRememberMe() {
                return this.rememberMe;
            }

            public static class RememberMe {
                @NotNull
                private String key;

                public RememberMe() {
                    this.key = io.github.jhipster.config.JHipsterDefaults.Security.RememberMe.key;
                }

                public String getKey() {
                    return this.key;
                }

                public void setKey(String key) {
                    this.key = key;
                }
            }

            public static class Authentication {
                private final com.jackson.shoppingcart.config.ApplicationProperties.Security.Authentication.Jwt jwt = new com.jackson.shoppingcart.config.ApplicationProperties.Security.Authentication.Jwt();

                public Authentication() {
                }

                public com.jackson.shoppingcart.config.ApplicationProperties.Security.Authentication.Jwt getJwt() {
                    return this.jwt;
                }

                public static class Jwt {
                    private String secret;
                    private long tokenValidityInSeconds;
                    private long tokenValidityInSecondsForRememberMe;

                    public Jwt() {
                        this.secret = io.github.jhipster.config.JHipsterDefaults.Security.Authentication.Jwt.secret;
                        this.tokenValidityInSeconds = 1800L;
                        this.tokenValidityInSecondsForRememberMe = 2592000L;
                    }

                    public String getSecret() {
                        return this.secret;
                    }

                    public void setSecret(String secret) {
                        this.secret = secret;
                    }

                    public long getTokenValidityInSeconds() {
                        return this.tokenValidityInSeconds;
                    }

                    public void setTokenValidityInSeconds(long tokenValidityInSeconds) {
                        this.tokenValidityInSeconds = tokenValidityInSeconds;
                    }

                    public long getTokenValidityInSecondsForRememberMe() {
                        return this.tokenValidityInSecondsForRememberMe;
                    }

                    public void setTokenValidityInSecondsForRememberMe(long tokenValidityInSecondsForRememberMe) {
                        this.tokenValidityInSecondsForRememberMe = tokenValidityInSecondsForRememberMe;
                    }
                }
            }

            public static class ClientAuthorization {
                private String accessTokenUri;
                private String tokenServiceId;
                private String clientId;
                private String clientSecret;

                public ClientAuthorization() {
                    this.accessTokenUri = io.github.jhipster.config.JHipsterDefaults.Security.ClientAuthorization.accessTokenUri;
                    this.tokenServiceId = io.github.jhipster.config.JHipsterDefaults.Security.ClientAuthorization.tokenServiceId;
                    this.clientId = io.github.jhipster.config.JHipsterDefaults.Security.ClientAuthorization.clientId;
                    this.clientSecret = io.github.jhipster.config.JHipsterDefaults.Security.ClientAuthorization.clientSecret;
                }

                public String getAccessTokenUri() {
                    return this.accessTokenUri;
                }

                public void setAccessTokenUri(String accessTokenUri) {
                    this.accessTokenUri = accessTokenUri;
                }

                public String getTokenServiceId() {
                    return this.tokenServiceId;
                }

                public void setTokenServiceId(String tokenServiceId) {
                    this.tokenServiceId = tokenServiceId;
                }

                public String getClientId() {
                    return this.clientId;
                }

                public void setClientId(String clientId) {
                    this.clientId = clientId;
                }

                public String getClientSecret() {
                    return this.clientSecret;
                }

                public void setClientSecret(String clientSecret) {
                    this.clientSecret = clientSecret;
                }
            }
        }

        public static class Mail {
            private String from = "";
            private String baseUrl = "";

            public Mail() {
            }

            public String getFrom() {
                return this.from;
            }

            public void setFrom(String from) {
                this.from = from;
            }

            public String getBaseUrl() {
                return this.baseUrl;
            }

            public void setBaseUrl(String baseUrl) {
                this.baseUrl = baseUrl;
            }
        }

        public static class Cache {
            private final com.jackson.shoppingcart.config.ApplicationProperties.Cache.Hazelcast hazelcast = new com.jackson.shoppingcart.config.ApplicationProperties.Cache.Hazelcast();
            private final com.jackson.shoppingcart.config.ApplicationProperties.Cache.Ehcache ehcache = new com.jackson.shoppingcart.config.ApplicationProperties.Cache.Ehcache();
            private final com.jackson.shoppingcart.config.ApplicationProperties.Cache.Infinispan infinispan = new com.jackson.shoppingcart.config.ApplicationProperties.Cache.Infinispan();

            public Cache() {
            }

            public com.jackson.shoppingcart.config.ApplicationProperties.Cache.Hazelcast getHazelcast() {
                return this.hazelcast;
            }

            public com.jackson.shoppingcart.config.ApplicationProperties.Cache.Ehcache getEhcache() {
                return this.ehcache;
            }

            public com.jackson.shoppingcart.config.ApplicationProperties.Cache.Infinispan getInfinispan() {
                return this.infinispan;
            }

            public static class Infinispan {
                private String configFile = "default-configs/default-jgroups-tcp.xml";
                private boolean statsEnabled = false;
                private final com.jackson.shoppingcart.config.ApplicationProperties.Cache.Infinispan.Local local = new com.jackson.shoppingcart.config.ApplicationProperties.Cache.Infinispan.Local();
                private final com.jackson.shoppingcart.config.ApplicationProperties.Cache.Infinispan.Distributed distributed = new com.jackson.shoppingcart.config.ApplicationProperties.Cache.Infinispan.Distributed();
                private final com.jackson.shoppingcart.config.ApplicationProperties.Cache.Infinispan.Replicated replicated = new com.jackson.shoppingcart.config.ApplicationProperties.Cache.Infinispan.Replicated();

                public Infinispan() {
                }

                public String getConfigFile() {
                    return this.configFile;
                }

                public void setConfigFile(String configFile) {
                    this.configFile = configFile;
                }

                public boolean isStatsEnabled() {
                    return this.statsEnabled;
                }

                public void setStatsEnabled(boolean statsEnabled) {
                    this.statsEnabled = statsEnabled;
                }

                public com.jackson.shoppingcart.config.ApplicationProperties.Cache.Infinispan.Local getLocal() {
                    return this.local;
                }

                public com.jackson.shoppingcart.config.ApplicationProperties.Cache.Infinispan.Distributed getDistributed() {
                    return this.distributed;
                }

                public com.jackson.shoppingcart.config.ApplicationProperties.Cache.Infinispan.Replicated getReplicated() {
                    return this.replicated;
                }

                public static class Replicated {
                    private long timeToLiveSeconds = 60L;
                    private long maxEntries = 100L;

                    public Replicated() {
                    }

                    public long getTimeToLiveSeconds() {
                        return this.timeToLiveSeconds;
                    }

                    public void setTimeToLiveSeconds(long timeToLiveSeconds) {
                        this.timeToLiveSeconds = timeToLiveSeconds;
                    }

                    public long getMaxEntries() {
                        return this.maxEntries;
                    }

                    public void setMaxEntries(long maxEntries) {
                        this.maxEntries = maxEntries;
                    }
                }

                public static class Distributed {
                    private long timeToLiveSeconds = 60L;
                    private long maxEntries = 100L;
                    private int instanceCount = 1;

                    public Distributed() {
                    }

                    public long getTimeToLiveSeconds() {
                        return this.timeToLiveSeconds;
                    }

                    public void setTimeToLiveSeconds(long timeToLiveSeconds) {
                        this.timeToLiveSeconds = timeToLiveSeconds;
                    }

                    public long getMaxEntries() {
                        return this.maxEntries;
                    }

                    public void setMaxEntries(long maxEntries) {
                        this.maxEntries = maxEntries;
                    }

                    public int getInstanceCount() {
                        return this.instanceCount;
                    }

                    public void setInstanceCount(int instanceCount) {
                        this.instanceCount = instanceCount;
                    }
                }

                public static class Local {
                    private long timeToLiveSeconds = 60L;
                    private long maxEntries = 100L;

                    public Local() {
                    }

                    public long getTimeToLiveSeconds() {
                        return this.timeToLiveSeconds;
                    }

                    public void setTimeToLiveSeconds(long timeToLiveSeconds) {
                        this.timeToLiveSeconds = timeToLiveSeconds;
                    }

                    public long getMaxEntries() {
                        return this.maxEntries;
                    }

                    public void setMaxEntries(long maxEntries) {
                        this.maxEntries = maxEntries;
                    }
                }
            }

            public static class Ehcache {
                private int timeToLiveSeconds = 3600;
                private long maxEntries = 100L;

                public Ehcache() {
                }

                public int getTimeToLiveSeconds() {
                    return this.timeToLiveSeconds;
                }

                public void setTimeToLiveSeconds(int timeToLiveSeconds) {
                    this.timeToLiveSeconds = timeToLiveSeconds;
                }

                public long getMaxEntries() {
                    return this.maxEntries;
                }

                public void setMaxEntries(long maxEntries) {
                    this.maxEntries = maxEntries;
                }
            }

            public static class Hazelcast {
                private int timeToLiveSeconds = 3600;
                private int backupCount = 1;
                private final com.jackson.shoppingcart.config.ApplicationProperties.Cache.Hazelcast.ManagementCenter managementCenter = new com.jackson.shoppingcart.config.ApplicationProperties.Cache.Hazelcast.ManagementCenter();

                public Hazelcast() {
                }

                public com.jackson.shoppingcart.config.ApplicationProperties.Cache.Hazelcast.ManagementCenter getManagementCenter() {
                    return this.managementCenter;
                }

                public int getTimeToLiveSeconds() {
                    return this.timeToLiveSeconds;
                }

                public void setTimeToLiveSeconds(int timeToLiveSeconds) {
                    this.timeToLiveSeconds = timeToLiveSeconds;
                }

                public int getBackupCount() {
                    return this.backupCount;
                }

                public void setBackupCount(int backupCount) {
                    this.backupCount = backupCount;
                }

                public static class ManagementCenter {
                    private boolean enabled = false;
                    private int updateInterval = 3;
                    private String url = "";

                    public ManagementCenter() {
                    }

                    public boolean isEnabled() {
                        return this.enabled;
                    }

                    public void setEnabled(boolean enabled) {
                        this.enabled = enabled;
                    }

                    public int getUpdateInterval() {
                        return this.updateInterval;
                    }

                    public void setUpdateInterval(int updateInterval) {
                        this.updateInterval = updateInterval;
                    }

                    public String getUrl() {
                        return this.url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }
            }
        }

        public static class Http {
            private final com.jackson.shoppingcart.config.ApplicationProperties.Http.Cache cache = new com.jackson.shoppingcart.config.ApplicationProperties.Http.Cache();
            public com.jackson.shoppingcart.config.ApplicationProperties.Http.Version version;

            public Http() {
                this.version = com.jackson.shoppingcart.config.ApplicationDefaults.Http.version;
            }

            public com.jackson.shoppingcart.config.ApplicationProperties.Http.Cache getCache() {
                return this.cache;
            }

            public com.jackson.shoppingcart.config.ApplicationProperties.Http.Version getVersion() {
                return this.version;
            }

            public void setVersion(com.jackson.shoppingcart.config.ApplicationProperties.Http.Version version) {
                this.version = version;
            }

            public static class Cache {
                private int timeToLiveInDays = 1461;

                public Cache() {
                }

                public int getTimeToLiveInDays() {
                    return this.timeToLiveInDays;
                }

                public void setTimeToLiveInDays(int timeToLiveInDays) {
                    this.timeToLiveInDays = timeToLiveInDays;
                }
            }

            public static enum Version {
                V_1_1,
                V_2_0;

                private Version() {
                }
            }
        }

        public static class Async {
            private int corePoolSize = 2;
            private int maxPoolSize = 50;
            private int queueCapacity = 10000;

            public Async() {
            }

            public int getCorePoolSize() {
                return this.corePoolSize;
            }

            public void setCorePoolSize(int corePoolSize) {
                this.corePoolSize = corePoolSize;
            }

            public int getMaxPoolSize() {
                return this.maxPoolSize;
            }

            public void setMaxPoolSize(int maxPoolSize) {
                this.maxPoolSize = maxPoolSize;
            }

            public int getQueueCapacity() {
                return this.queueCapacity;
            }

            public void setQueueCapacity(int queueCapacity) {
                this.queueCapacity = queueCapacity;
            }
        }

}
