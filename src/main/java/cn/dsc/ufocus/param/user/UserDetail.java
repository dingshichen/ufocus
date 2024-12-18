package cn.dsc.ufocus.param.user;

import cn.dsc.ufocus.param.Base;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * 带有认证信息的用户详情
 * @author ding.shichen
 */
@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail extends Base implements UserDetails {

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否锁定标志
     */
    private Boolean lockFlag;

    /**
     * 授权
     */
    private List<GrantedAuthority> authorities;

    public UserDetail(Long id, String email, String password, Boolean lockFlag, List<GrantedAuthority> authorities) {
        super(id);
        this.email = email;
        this.password = password;
        this.lockFlag = lockFlag;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !lockFlag;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
