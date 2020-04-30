package org.tutorial.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

//要 extends  WebSecurityConfigurerAdapter
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    // spring Security 提供
//    @Autowired
//    private AccessDeniedHandler accessDeniedHandler;

    // 拦截请求
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 设置哪些url允许被某种角色访问
        // 存取必須通過驗證
        http.authorizeRequests()
                .antMatchers("/css/**").permitAll()// 資料夾靜態資料可匿名存取permitAll()則代表可以匿名存取
//                 .anyRequest()//對象為所有網址
                //拿掉anyReqest()，改用antMatchers()方法來指定需要認證的URL
                .antMatchers("/index")
                .authenticated() // 存取必須通過驗證
            .and()
            .formLogin()// 若未不符合authorize條件，則產生預設login表單
//                .loginPage("/login")// loginPage則產生自訂login表單
                .defaultSuccessUrl("/index")
                .failureUrl("/loginerror")
                .permitAll();

    }

    // create two users admin and user
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()// 自訂Runtime時的使用者帳號
                .withUser("user")// 新增user
                .password(encoder.encode("user123456"))// 指定密碼
                .roles("USER")// 指派權限群組
                .and()
                .withUser("admin")
                .password(encoder.encode("admin123456"))
                .roles("ADMIN", "USER");
    }

}
