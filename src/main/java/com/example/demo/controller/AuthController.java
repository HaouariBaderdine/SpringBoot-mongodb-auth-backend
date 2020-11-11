/*
 * /api/auth/signup :
 * vérifier existant username/email
 * créer un nouveau User(avec ROLE_USERsinon spécifier le rôle)
 * enregistrer Userdans la base de données en utilisantUserRepository
 */

/* /api/auth/signin:
 * authentifier {nom d'utilisateur, mot de passe}
 * mise SecurityContextà jour à l' aide d'un Authenticationobjet
 * produire JWT
 * obtenir UserDetailsde l' Authenticationobjet
 * réponse contient JWTet UserDetailsdonnées
 */

package com.example.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ERole;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.payload.request.LoginRequest;
import com.example.demo.payload.request.SignupRequest;
import com.example.demo.payload.response.JwtResponse;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.security.services.UserDetailsImpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	/* ************************************************************************************** */
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
			
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getNom(),
                userDetails.getPrenom(),
                userDetails.getAdresse(),
                userDetails.getNumtel(),
                userDetails.getIdCollege(),
                userDetails.getMat(),
                roles
                ));
	}
	
	/* *************************************************************************************** */

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
        User user = new User(
        		signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getNom(),
                signUpRequest.getPrenom(),
                signUpRequest.getAdresse(),
                signUpRequest.getNumtel(),
                signUpRequest.getIdCollege()
                );
		
		String mat = signUpRequest.getMat();

		Set<String> strRoles = signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();

		if (strRoles != null) {
			
			strRoles.forEach(role -> {
				switch (role) {
				case "professeur":
					Role parentRole = roleRepository.findByName(ERole.ROLE_PROFESSEUR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(parentRole);
					user.setMat(mat);

					break;
				case "parent":
					Role ParentRole = roleRepository.findByName(ERole.ROLE_PARENT)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(ParentRole);

					break;
				case "serveillante":
					Role serveillanteRole = roleRepository.findByName(ERole.ROLE_SERVEUILLANTE)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(serveillanteRole);

					break;
				case "generale":
					Role serveillante_generaleRole = roleRepository.findByName(ERole.ROLE_SERVEUILLANTE_GENERALE)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(serveillante_generaleRole);

					break;
				case "secretaria":
					Role secretariaRole = roleRepository.findByName(ERole.ROLE_SECRETARIA)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(secretariaRole);

					break;
				
				}
			});
		}

		user.setRoles(roles);
		
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	/* ************************************************************************************** */
	
	@PostMapping("/logout")
	@PreAuthorize("hasRole('PARENT') or hasRole('PROFESSEUR')  or hasRole('SERVEUILLANTE')   or hasRole('SERVEUILLANTE_GENERALE')  or hasRole('SECRETARIA')")
	public ResponseEntity<MessageResponse> logoutUser() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(null);
		return ResponseEntity.ok(new MessageResponse("logout successful"));
	}
	
}
