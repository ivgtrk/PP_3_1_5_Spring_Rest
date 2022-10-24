package web.Spring_Rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.Spring_Rest.model.User;

import java.util.Optional;


@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    @Query("select c from User c join fetch c.roles where c.username = :username")
    Optional<User> findByUsername(@Param("username") String username);
}
