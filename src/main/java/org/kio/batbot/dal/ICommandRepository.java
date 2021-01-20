package org.kio.batbot.dal;

import org.kio.batbot.bo.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommandRepository extends JpaRepository<Command, Integer> {
    List<Command> findAllByOrderById();
}
