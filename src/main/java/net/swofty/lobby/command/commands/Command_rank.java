package net.swofty.lobby.command.commands;

import net.swofty.lobby.command.AbstractCommand;
import net.swofty.lobby.command.CommandParameters;
import net.swofty.lobby.command.CommandSource;
import net.swofty.lobby.manager.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandParameters(usage = "/<command> <args>", permission = "rank.admin", description = "Set a players rank")
public class Command_rank extends AbstractCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        if (args.length == 0 || args.length == 1) {
            send("&cUsa: /rank <jugador> <rango>");
            return;
        }

        if (Bukkit.getPlayer(args[0]) == null) {
            send("&cNo se ha encontrado a '" + args[0] + "'");
            return;
        }

        Player target = Bukkit.getPlayer(args[0]);

        switch (args[1]) {
            case "default":
                new PlayerManager(target).setRank("default");
                send("&aSe ha colocado a " + target.getName() + " el rango " + args[1].toUpperCase());
                return;

            case "vip":
                new PlayerManager(target).setRank("vip");
                send("&aSe ha colocado a " + target.getName() + " el rango " + args[1].toUpperCase());
                return;

            case "vip+":
                new PlayerManager(target).setRank("vip+");
                send("&aSe ha colocado a " + target.getName() + " el rango " + args[1].toUpperCase());
                return;

            case "mvp":
                new PlayerManager(target).setRank("mvp");
                send("&aSe ha colocado a " + target.getName() + " el rango " + args[1].toUpperCase());
                return;

            case "mvp+":
                new PlayerManager(target).setRank("mvp+");
                send("&aSe ha colocado a " + target.getName() + " el rango " + args[1].toUpperCase());
                return;

            case "mvp++":
                new PlayerManager(target).setRank("mvp++");
                send("&aSe ha colocado a " + target.getName() + " el rango " + args[1].toUpperCase());
                return;

            case "events":
                new PlayerManager(target).setRank("events");
                send("&aSe ha colocado a " + target.getName() + " el rango " + args[1].toUpperCase());
                return;

            case "mojang":
                new PlayerManager(target).setRank("mojang");
                send("&aSe ha colocado a " + target.getName() + " el rango " + args[1].toUpperCase());
                return;

            case "yt":
                new PlayerManager(target).setRank("yt");
                send("&aSe ha colocado a " + target.getName() + " el rango " + args[1].toUpperCase());
                return;

            case "youtube":
                new PlayerManager(target).setRank("youtube");
                send("&aSe ha colocado a " + target.getName() + " el rango " + args[1].toUpperCase());
                return;

            case "builder":
                new PlayerManager(target).setRank("builder");
                send("&aSe ha colocado a " + target.getName() + " el rango " + args[1].toUpperCase());
                return;

            case "helper":
                new PlayerManager(target).setRank("helper");
                send("&aSe ha colocado a " + target.getName() + " el rango " + args[1].toUpperCase());
                return;

            case "mod":
                new PlayerManager(target).setRank("mod");
                send("&aSe ha colocado a " + target.getName() + " el rango " + args[1].toUpperCase());
                return;

            case "gamemaster":
                new PlayerManager(target).setRank("gamemaster");
                send("&aSe ha colocado a " + target.getName() + " el rango " + args[1].toUpperCase());
                return;

            case "admin":
                send("&aSe ha colocado a " + target.getName() + " el rango " + args[1].toUpperCase());
                new PlayerManager(target).setRank("admin");
                return;

            case "owner":
                send("&aSe ha colocado a " + target.getName() + " el rango " + args[1].toUpperCase());
                new PlayerManager(target).setRank("owner");
                return;
        }

        send("&c'" + args[1] + "' no es un rango valido");
    }
}
