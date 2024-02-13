package ca.sheridancollege.vutran.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.vutran.beans.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
