package net.swofty.lobby.command.commands;

import net.swofty.lobby.command.AbstractCommand;
import net.swofty.lobby.command.CommandParameters;
import net.swofty.lobby.command.CommandSource;
import net.swofty.lobby.manager.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

@CommandParameters(usage = "/<command> <args>", permission = "rank.admin", description = "Changes your gamemode", inGameOnly = true)
public class Command_gm extends AbstractCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        if (args.length == 0) {
            send("&cUsa: /gm (creative / survival / adventure / spectator)");
            return;
        }

        switch (args[0]) {
            case "0":
            case "survival":
            case "s":
                sender.getPlayer().setGameMode(GameMode.SURVIVAL);
                send("&aAhora estas en SURVIVAL");
                return;

            case "1":
            case "creative":
            case "c":
                sender.getPlayer().setGameMode(GameMode.CREATIVE);
                send("&aAhora estas en CREATIVO");
                return;

            case "2":
            case "adventure":
            case "a":
                sender.getPlayer().setGameMode(GameMode.ADVENTURE);
                send("&aAhora estas en AVENTURA");
                return;

            case "3":
            case "spectator":
            case "sp":
                sender.getPlayer().setGameMode(GameMode.SPECTATOR);
                send("&aAhora estas en ESPECTADOR");
                return;
        }

        send("&cUsa: /gm (creative / survival / adventure / spectator)");
    }
}
