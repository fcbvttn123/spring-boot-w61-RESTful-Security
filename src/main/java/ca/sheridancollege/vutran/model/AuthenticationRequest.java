package ca.sheridancollege.vutran.model;

import ca.sheridancollege.vutran.beans.Role;
import ca.sheridancollege.vutran.beans.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {
	private String email;
	private String password;
}
