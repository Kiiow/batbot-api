package org.kio.batbot.dal;

import org.kio.batbot.bo.Command;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommandRepository extends CrudRepository<Command, Integer> {
}
