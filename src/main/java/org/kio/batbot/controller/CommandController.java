package org.kio.batbot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.kio.batbot.bo.Command;
import org.kio.batbot.dal.ICommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Command", description = "Get Discord bot commands informations")
public class CommandController {

    @Autowired
    private ICommandRepository iCommandRepository;

    @GetMapping(path = "/commands")
    @Operation(summary = "Get all commands informations")
    public List<Command> getAllCommands() {
        List<Command> commandsList = iCommandRepository.findAllByOrderById();
        return commandsList;
    }
}
