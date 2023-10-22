package cn.dsc.ufocus.param.user;

import cn.dsc.ufocus.param.Base;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 带有认证信息的用户详情
 * @author ding.shichen
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail extends Base implements UserDetails {

    /**
     * 电子邮箱地址
     */
    private String emailAddress;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否锁定标志
     */
    private Boolean isLockFlag;

    public UserDetail(Long id, String emailAddress, String password, Boolean isLockFlag) {
        super(id);
        this.emailAddress = emailAddress;
        this.password = password;
        this.isLockFlag = isLockFlag;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return emailAddress;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLockFlag;
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
