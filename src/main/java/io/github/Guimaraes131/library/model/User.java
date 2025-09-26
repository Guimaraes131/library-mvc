package io.github.Guimaraes131.library.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "tb_user")
@EqualsAndHashCode(callSuper = true)
public class User extends DefaultOAuth2User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Column(name = "avatar")
    private String avatarUrl;

    public User(OAuth2User principal){
        super(
                List.of(new SimpleGrantedAuthority("USER")),
                principal.getAttributes(),
                "name"
        );
        this.name = principal.getAttribute("name");
        this.email = principal.getAttribute("email");
        this.avatarUrl = principal.getAttribute("picture") != null ?
                principal.getAttribute("picture").toString() :
                principal.getAttribute("avatar_url").toString();

    }

    public User(){
        super(
                List.of(new SimpleGrantedAuthority("USER")),
                Map.of("name", "unknown"),
                "name"
        );
    }
}
