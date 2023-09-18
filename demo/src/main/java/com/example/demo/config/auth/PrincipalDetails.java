package com.example.demo.config.auth;


import com.example.demo.domain.dto.UserDto;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PrincipalDetails implements UserDetails , OAuth2User {

	@Getter
	private UserDto user;

	//OAUTH2 ----------------------------------------------------------------
	private Map<String, Object> attributes;
	private String accessToken;
	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	@Override
	public String getName() {
		return null;
	}
	//OAUTH2 ----------------------------------------------------------------


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collection = new ArrayList();

		collection.add(new GrantedAuthority(){
			@Override
			public String getAuthority() {

				return user.getRole();
			}

		} );

		return collection;
	}

	@Override
	public String getPassword() {

		return user.getPassword();
	}

//	@Override
//	public String getEmail() {
//		return user.getEmail();
//	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}