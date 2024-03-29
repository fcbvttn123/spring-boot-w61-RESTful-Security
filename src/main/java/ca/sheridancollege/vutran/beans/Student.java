package ca.sheridancollege.vutran.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String name;
}
