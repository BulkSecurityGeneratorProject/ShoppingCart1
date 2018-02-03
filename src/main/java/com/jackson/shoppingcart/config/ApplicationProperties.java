package com.jackson.shoppingcart.config;

import io.github.jhipster.config.JHipsterProperties;
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
        private final io.github.jhipster.config.JHipsterProperties.Async async = new io.github.jhipster.config.JHipsterProperties.Async();
        private final io.github.jhipster.config.JHipsterProperties.Http http = new io.github.jhipster.config.JHipsterProperties.Http();
        private final io.github.jhipster.config.JHipsterProperties.Cache cache = new io.github.jhipster.config.JHipsterProperties.Cache();
        private final io.github.jhipster.config.JHipsterProperties.Mail mail = new io.github.jhipster.config.JHipsterProperties.Mail();
        private final io.github.jhipster.config.JHipsterProperties.Security security = new io.github.jhipster.config.JHipsterProperties.Security();
        private final io.github.jhipster.config.JHipsterProperties.Swagger swagger = new io.github.jhipster.config.JHipsterProperties.Swagger();
        private final io.github.jhipster.config.JHipsterProperties.Metrics metrics = new io.github.jhipster.config.JHipsterProperties.Metrics();
        private final io.github.jhipster.config.JHipsterProperties.Logging logging = new io.github.jhipster.config.JHipsterProperties.Logging();
        private final CorsConfiguration cors = new CorsConfiguration();
        private final io.github.jhipster.config.JHipsterProperties.Social social = new io.github.jhipster.config.JHipsterProperties.Social();
        private final io.github.jhipster.config.JHipsterProperties.Gateway gateway = new io.github.jhipster.config.JHipsterProperties.Gateway();
        private final io.github.jhipster.config.JHipsterProperties.Ribbon ribbon = new io.github.jhipster.config.JHipsterProperties.Ribbon();
        private final io.github.jhipster.config.JHipsterProperties.Registry registry = new io.github.jhipster.config.JHipsterProperties.Registry();

        public ApplicationProperties() {
        }

        public io.github.jhipster.config.JHipsterProperties.Async getAsync() {
            return this.async;
        }

        public io.github.jhipster.config.JHipsterProperties.Http getHttp() {
            return this.http;
        }

        public io.github.jhipster.config.JHipsterProperties.Cache getCache() {
            return this.cache;
        }

        public io.github.jhipster.config.JHipsterProperties.Mail getMail() {
            return this.mail;
        }

        public io.github.jhipster.config.JHipsterProperties.Registry getRegistry() {
            return this.registry;
        }

        public io.github.jhipster.config.JHipsterProperties.Security getSecurity() {
            return this.security;
        }

        public io.github.jhipster.config.JHipsterProperties.Swagger getSwagger() {
            return this.swagger;
        }

        public io.github.jhipster.config.JHipsterProperties.Metrics getMetrics() {
            return this.metrics;
        }

        public io.github.jhipster.config.JHipsterProperties.Logging getLogging() {
            return this.logging;
        }

        public CorsConfiguration getCors() {
            return this.cors;
        }

        public io.github.jhipster.config.JHipsterProperties.Social getSocial() {
            return this.social;
        }

        public io.github.jhipster.config.JHipsterProperties.Gateway getGateway() {
            return this.gateway;
        }

        public io.github.jhipster.config.JHipsterProperties.Ribbon getRibbon() {
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
            private final io.github.jhipster.config.JHipsterProperties.Gateway.RateLimiting rateLimiting = new io.github.jhipster.config.JHipsterProperties.Gateway.RateLimiting();
            private Map<String, List<String>> authorizedMicroservicesEndpoints;

            public Gateway() {
                this.authorizedMicroservicesEndpoints = io.github.jhipster.config.JHipsterDefaults.Gateway.authorizedMicroservicesEndpoints;
            }

            public io.github.jhipster.config.JHipsterProperties.Gateway.RateLimiting getRateLimiting() {
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
            private final io.github.jhipster.config.JHipsterProperties.Logging.Logstash logstash = new io.github.jhipster.config.JHipsterProperties.Logging.Logstash();
            private final io.github.jhipster.config.JHipsterProperties.Logging.SpectatorMetrics spectatorMetrics = new io.github.jhipster.config.JHipsterProperties.Logging.SpectatorMetrics();

            public Logging() {
            }

            public io.github.jhipster.config.JHipsterProperties.Logging.Logstash getLogstash() {
                return this.logstash;
            }

            public io.github.jhipster.config.JHipsterProperties.Logging.SpectatorMetrics getSpectatorMetrics() {
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
            private final io.github.jhipster.config.JHipsterProperties.Metrics.Jmx jmx = new io.github.jhipster.config.JHipsterProperties.Metrics.Jmx();
            private final io.github.jhipster.config.JHipsterProperties.Metrics.Graphite graphite = new io.github.jhipster.config.JHipsterProperties.Metrics.Graphite();
            private final io.github.jhipster.config.JHipsterProperties.Metrics.Prometheus prometheus = new io.github.jhipster.config.JHipsterProperties.Metrics.Prometheus();
            private final io.github.jhipster.config.JHipsterProperties.Metrics.Logs logs = new io.github.jhipster.config.JHipsterProperties.Metrics.Logs();

            public Metrics() {
            }

            public io.github.jhipster.config.JHipsterProperties.Metrics.Jmx getJmx() {
                return this.jmx;
            }

            public io.github.jhipster.config.JHipsterProperties.Metrics.Graphite getGraphite() {
                return this.graphite;
            }

            public io.github.jhipster.config.JHipsterProperties.Metrics.Prometheus getPrometheus() {
                return this.prometheus;
            }

            public io.github.jhipster.config.JHipsterProperties.Metrics.Logs getLogs() {
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
            private final io.github.jhipster.config.JHipsterProperties.Security.ClientAuthorization clientAuthorization = new io.github.jhipster.config.JHipsterProperties.Security.ClientAuthorization();
            private final io.github.jhipster.config.JHipsterProperties.Security.Authentication authentication = new io.github.jhipster.config.JHipsterProperties.Security.Authentication();
            private final io.github.jhipster.config.JHipsterProperties.Security.RememberMe rememberMe = new io.github.jhipster.config.JHipsterProperties.Security.RememberMe();

            public Security() {
            }

            public io.github.jhipster.config.JHipsterProperties.Security.ClientAuthorization getClientAuthorization() {
                return this.clientAuthorization;
            }

            public io.github.jhipster.config.JHipsterProperties.Security.Authentication getAuthentication() {
                return this.authentication;
            }

            public io.github.jhipster.config.JHipsterProperties.Security.RememberMe getRememberMe() {
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
                private final io.github.jhipster.config.JHipsterProperties.Security.Authentication.Jwt jwt = new io.github.jhipster.config.JHipsterProperties.Security.Authentication.Jwt();

                public Authentication() {
                }

                public io.github.jhipster.config.JHipsterProperties.Security.Authentication.Jwt getJwt() {
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
            private final io.github.jhipster.config.JHipsterProperties.Cache.Hazelcast hazelcast = new io.github.jhipster.config.JHipsterProperties.Cache.Hazelcast();
            private final io.github.jhipster.config.JHipsterProperties.Cache.Ehcache ehcache = new io.github.jhipster.config.JHipsterProperties.Cache.Ehcache();
            private final io.github.jhipster.config.JHipsterProperties.Cache.Infinispan infinispan = new io.github.jhipster.config.JHipsterProperties.Cache.Infinispan();

            public Cache() {
            }

            public io.github.jhipster.config.JHipsterProperties.Cache.Hazelcast getHazelcast() {
                return this.hazelcast;
            }

            public io.github.jhipster.config.JHipsterProperties.Cache.Ehcache getEhcache() {
                return this.ehcache;
            }

            public io.github.jhipster.config.JHipsterProperties.Cache.Infinispan getInfinispan() {
                return this.infinispan;
            }

            public static class Infinispan {
                private String configFile = "default-configs/default-jgroups-tcp.xml";
                private boolean statsEnabled = false;
                private final io.github.jhipster.config.JHipsterProperties.Cache.Infinispan.Local local = new io.github.jhipster.config.JHipsterProperties.Cache.Infinispan.Local();
                private final io.github.jhipster.config.JHipsterProperties.Cache.Infinispan.Distributed distributed = new io.github.jhipster.config.JHipsterProperties.Cache.Infinispan.Distributed();
                private final io.github.jhipster.config.JHipsterProperties.Cache.Infinispan.Replicated replicated = new io.github.jhipster.config.JHipsterProperties.Cache.Infinispan.Replicated();

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

                public io.github.jhipster.config.JHipsterProperties.Cache.Infinispan.Local getLocal() {
                    return this.local;
                }

                public io.github.jhipster.config.JHipsterProperties.Cache.Infinispan.Distributed getDistributed() {
                    return this.distributed;
                }

                public io.github.jhipster.config.JHipsterProperties.Cache.Infinispan.Replicated getReplicated() {
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
                private final io.github.jhipster.config.JHipsterProperties.Cache.Hazelcast.ManagementCenter managementCenter = new io.github.jhipster.config.JHipsterProperties.Cache.Hazelcast.ManagementCenter();

                public Hazelcast() {
                }

                public io.github.jhipster.config.JHipsterProperties.Cache.Hazelcast.ManagementCenter getManagementCenter() {
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
            private final io.github.jhipster.config.JHipsterProperties.Http.Cache cache = new io.github.jhipster.config.JHipsterProperties.Http.Cache();
            public io.github.jhipster.config.JHipsterProperties.Http.Version version;

            public Http() {
                this.version = io.github.jhipster.config.JHipsterDefaults.Http.version;
            }

            public io.github.jhipster.config.JHipsterProperties.Http.Cache getCache() {
                return this.cache;
            }

            public io.github.jhipster.config.JHipsterProperties.Http.Version getVersion() {
                return this.version;
            }

            public void setVersion(io.github.jhipster.config.JHipsterProperties.Http.Version version) {
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
