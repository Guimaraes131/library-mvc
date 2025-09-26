package io.github.Guimaraes131.library.repository;

import io.github.Guimaraes131.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
