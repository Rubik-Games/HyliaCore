package net.swofty.lobby.command.commands;

import net.swofty.lobby.command.CommandParameters;
import net.swofty.lobby.command.CommandSource;

import org.bukkit.entity.Player;

import net.swofty.lobby.command.AbstractCommand;

@CommandParameters(usage = "/<command> <args>", permission = "rank.admin", description = "Changes your fly mode", inGameOnly = true)
public class Command_fly extends AbstractCommand {

    @Override
    public void run(CommandSource sender, String[] args) {
        boolean isFlying = sender.getPlayer().isFlying();

        sender.getPlayer().setAllowFlight(!isFlying);
        sender.getPlayer().setFlying(!isFlying);

        if(isFlying)
            send("Flying disabled.");
        else
            send("Flying enabled.");
    }
}