package ar.com.trilla.demo.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
            throws
            Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(CsrfConfigurer::disable)
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwtAuthenticationConverter(jwtAuthenticationConverter())
                        )
                )
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/actuator/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                );

        return http.build();
    }

    private Converter<Jwt, AbstractAuthenticationToken> jwtAuthenticationConverter() {
        JwtAuthenticationConverter authenticationConverter = new JwtAuthenticationConverter();
        authenticationConverter.setJwtGrantedAuthoritiesConverter(new CustomKeycloakGrantedAuthoritiesConverter());
        return authenticationConverter;
    }

    private static class CustomKeycloakGrantedAuthoritiesConverter
            implements Converter<Jwt, Collection<GrantedAuthority>> {
        private static final String REALM_ACCESS = "realm_access";
        private static final String ROLES_CLAIM = "roles";
        private static final String AUTHORITY_PREFIX = "ROLE_";

        @Override
        public Collection<GrantedAuthority> convert(final Jwt jwt) {
            Map<String, Object> realmAccess = jwt.getClaim(REALM_ACCESS);
            if (realmAccess == null || !realmAccess.containsKey(ROLES_CLAIM)) {
                return Collections.emptyList();
            }
            Object rolesObject = realmAccess.get(ROLES_CLAIM);
            if (!(rolesObject instanceof final Collection<?> roles)) {
                return Collections.emptyList();
            }

            return roles.stream()
                        .filter(String.class::isInstance)
                        .map(Object::toString)
                        .map(roleName -> new SimpleGrantedAuthority(AUTHORITY_PREFIX + roleName))
                        .collect(Collectors.toList());
        }
    }
}