package pl.mwisniewski.barber_app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.jdbcAuthentication()
               .dataSource(dataSource)
               .passwordEncoder(passwordEncoder())
               .usersByUsernameQuery("SELECT email, password, true FROM users WHERE email = ?")
               .authoritiesByUsernameQuery("SELECT u.email, ur.role FROM users_roles ur JOIN users u " +
                       "ON u.id = ur.user_id WHERE u.email = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/", true)
                .and()
                .authorizeRequests()
                .antMatchers("/register").anonymous()
                .antMatchers("/login").anonymous()
                .antMatchers("/contact").permitAll()
                .antMatchers("/about").permitAll()
                .antMatchers("/order/add").anonymous()
                .antMatchers("/allservices").permitAll()
                .antMatchers("/","/home").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");
    }
}
