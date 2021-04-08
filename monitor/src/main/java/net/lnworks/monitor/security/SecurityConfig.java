package net.lnworks.monitor.security;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Log
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;
    ZerockUserService zerockUserService;

    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider();
    }
    */

    @Override
    // js, css, image 설정은 보안 설정의 영향 밖에 있도록 만들어주는 설정.
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Override
    protected  void configure(HttpSecurity http) throws  Exception {
        log.info("security config........");

        http.authorizeRequests()
                .antMatchers("/accounts/**", "/aemonitorapi/**")
                .permitAll();

        http.authorizeRequests()
                .antMatchers("/aemonitor/**")
                .hasRole("M");

        http.authorizeRequests()
                .and()
                .formLogin()
                .loginPage("/accounts/login")
                .defaultSuccessUrl("/aemonitor/examlist");

        http.authorizeRequests()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/accounts/accessDenied");

        http.authorizeRequests()
                .and()
                .logout()
                .logoutUrl("/accounts/logout")
                .invalidateHttpSession(true);

        http.rememberMe()
                .key("zerock")
                .userDetailsService(zerockUserService)
                .tokenRepository(getTokenSeries())
                .tokenValiditySeconds(60*60*24);

        //http.cors().and();
        //http.csrf().disable();
    }

    private PersistentTokenRepository getTokenSeries() {
        JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
        repo.setDataSource(dataSource);
        return repo;
    }

    /*
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        log.info("build Auth global........");

        auth.inMemoryAuthentication()
                .withUser("manager")
                .password("{noop}1111")
                .roles("MANAGER");
    }
    */
}
