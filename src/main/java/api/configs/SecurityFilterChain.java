package api.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityFilterChain {
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(customFilter(), BasicAuthenticationFilter.class)
//                .authorizeHttpRequests(Customizer.withDefaults())
                .authorizeRequests()
                .accessDecisionManager(accessDecisionManager());
    }
    @Bean
    public CustomFilter customFilter() {
        return new CustomFilter(new AntPathRequestMatcher("/your-url-pattern"));
    }
    @Bean
    public AccessDecisionManager accessDecisionManager() {
        List<AccessDecisionVoter<? extends Object>> decisionVoters = Arrays.asList(new CustomAccessDecisionVoter());
        return new AffirmativeBased(decisionVoters);
    }
}
