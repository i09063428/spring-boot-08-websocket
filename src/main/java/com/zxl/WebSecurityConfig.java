package com.zxl;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * websocket点对点消息传播
 * @author zxl16
 * @Date 2019/9/29.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
               //对login路径不拦截
               .antMatchers("/","/login").permitAll()
               .anyRequest().authenticated()
               .and()
               .formLogin()
               //设置登录访问路径为login
               .loginPage("/login")
               .defaultSuccessUrl("/chat")
               .permitAll()
               .and()
               .logout()
               .permitAll();

    }

    /**
     * 设置两个用户 zxl,wyf
     * Spring boot 2.0.3引用的security 依赖是 spring security 5.X版本，此版本需要提供一个PasswordEncorder的实例.否则验证密码会报错
     * passwordEncoder(new SocketPasswordEncoder()) 密码以明文的方式进行匹配。
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new SocketPasswordEncoder())
                .withUser("zxl").password("zxl").roles("USER")
                .and()
                .withUser("wyf").password("wyf").roles("USER");
    }

    /**
     * resources/static下的静态资源不拦截
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");
    }
}
