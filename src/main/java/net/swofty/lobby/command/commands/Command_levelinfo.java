package net.swofty.lobby.command.commands;

import net.swofty.lobby.Data;
import net.swofty.lobby.command.AbstractCommand;
import net.swofty.lobby.command.CommandParameters;
import net.swofty.lobby.command.CommandSource;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandParameters(usage = "/<command> <args>", permission = "rank.admin", description = "Debug comand for admins", inGameOnly = true)
public class Command_levelinfo extends AbstractCommand {
    @Override
    public void run(CommandSource sender, String[] args) {

        if (args.length == 1) {
            if (Bukkit.getPlayer(args[0]) == null) {
                send("&cNo se ha encontrado a '" + args[0] + "'");
                return;
            }

            Player target = Bukkit.getPlayer(args[0]);
            send("&e&lINFORMACION SOBRE " + target.getName() + " SU NIVEL;");
            send("Nivel actual: " + Data.getData(target, "level"));
            send("XP actual: " + Data.getData(target, "xp"));
            send("XP necesario para subir de nivel: " + (Integer.parseInt(Data.getData(target, "level")) + 5000 + (Integer.parseInt(Data.getData(target, "level")) * 750)));
            send("&7nivel + 5000 + (level * 750)");
            return;
        }
        send("&e&lINFORMACION SOBRE TU NIVEL;");
        send("Nivel actual: " + Data.getData(sender.getPlayer(), "level"));
        send("XP actual: " + Data.getData(sender.getPlayer(), "xp"));
        send("XP necesario para subir de nivel: " + (Integer.parseInt(Data.getData(sender.getPlayer(), "level")) + 5000 + (Integer.parseInt(Data.getData(sender.getPlayer(), "level")) * 750)));
        send("&7nivel + 5000 + (level * 750)");
    }
}
