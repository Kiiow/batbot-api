package org.kio.batbot.dal;

import org.kio.batbot.bo.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Long> {
}
