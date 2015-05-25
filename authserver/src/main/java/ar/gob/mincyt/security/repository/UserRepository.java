package ar.gob.mincyt.security.repository;

import org.springframework.data.repository.CrudRepository;

import ar.gob.mincyt.security.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);

}
