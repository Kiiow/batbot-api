package org.kio.batbot.dal;

import org.kio.batbot.bo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface IUserRepository extends CrudRepository<User, String> {
    List<User> findAllByOrderByXpDesc();

    @Modifying
    @Query("UPDATE User U SET U.xp = :xp, U.level = :level, U.ts_last_xp = CURRENT_TIMESTAMP WHERE U.id = :id")
    @Transactional
    int updateUserXp(@Param("xp") int xp, @Param("level") int level, @Param("id") String id);
}
