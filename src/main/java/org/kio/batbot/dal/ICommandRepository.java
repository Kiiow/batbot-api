package org.kio.batbot.dal;

import org.kio.batbot.bo.Command;
import org.springframework.data.repository.CrudRepository;

public interface ICommandRepository extends CrudRepository<Command, Integer> {
}
