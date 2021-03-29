package net.lnworks.monitor.security;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Log
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;
    ZerockUserService zerockUserService;

    @Override
    protected  void configure(HttpSecurity http) throws  Exception {
        log.info("security config........");

        http.authorizeRequests().antMatchers("/test/**").permitAll();
        http.authorizeRequests().antMatchers("/apt/**").hasRole("M");
        http.authorizeRequests().antMatchers("/admin/**").hasRole("A");

        http.formLogin().loginPage("/member/login");
        http.exceptionHandling().accessDeniedPage("/member/accessDenied");
        http.logout().logoutUrl("/member/logout").invalidateHttpSession(true);
        http.rememberMe()
                .key("zerock")
                .userDetailsService(zerockUserService)
        .tokenRepository(getTokenSeries())
        .tokenValiditySeconds(60*60*24);
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
