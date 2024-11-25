package co.kr.metacoding.backendtest.repository;

import co.kr.metacoding.backendtest.dto.UserDTO;
import co.kr.metacoding.backendtest.entity.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class UserRepository {

    @Autowired
    private EntityManager em;


    public void postUser(User user) {
        System.out.println(user.getName());
        em.persist(user);
    }

    public Optional<User> findByUserId(int id) {
        return Optional.ofNullable(em.find(User.class, id ));
    }

}
