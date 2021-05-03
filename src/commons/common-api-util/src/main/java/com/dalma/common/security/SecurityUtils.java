package com.dalma.common.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class SecurityUtils {
	private SecurityUtils() {
	}

	public static Optional<String> getCurrentUsername() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();

		if (authentication != null && authentication.getPrincipal() instanceof User) {
			var user = (User) authentication.getPrincipal();
			return Optional.ofNullable(user.getUsername());
		}

		return Optional.empty();
	}

	public static Optional<UserDetails> getCurrentUserDetails() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();

		if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
			return Optional.of((UserDetails) authentication.getPrincipal());
		}

		return Optional.empty();
	}

	/**
	 * If the current user has a specific security role.
	 *
	 * @param role represents the role of the user
	 * @return true if user is in role, false otherwise
	 */
	public static boolean isUserInRole(String role) {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		if (authentication != null) {
			if (authentication.getPrincipal() instanceof UserDetails) {
				UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
				return isUserInRole(springSecurityUser, role);
			} else {
				return authentication.getAuthorities().contains(new SimpleGrantedAuthority(role));
			}
		}
		return false;
	}

	public static boolean isUserInRole(UserDetails user, String role) {
		return user.getAuthorities().contains(new SimpleGrantedAuthority(role));
	}
}
