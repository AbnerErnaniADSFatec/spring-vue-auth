package auth.apiauth.model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import auth.apiauth.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u from User u where u.nome like :nome%")
    public List<User> findOneByName(@Param("nome") String nome);

    @Query("select u from User u where u.codigo = :codigo")
    public List<User> findOneByCode(@Param("codigo") Long codigo);

}