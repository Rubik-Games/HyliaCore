package net.swofty.lobby.command.commands;

import net.swofty.lobby.Data;
import net.swofty.lobby.command.AbstractCommand;
import net.swofty.lobby.command.CommandParameters;
import net.swofty.lobby.command.CommandSource;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;

@CommandParameters(usage = "/<command> <args>", permission = "rank.admin", description = "Deletes your statistics", inGameOnly = true)
public class Command_wipestats extends AbstractCommand {

    public static ArrayList<Player> isSure = new ArrayList<>();

    @Override
    public void run(CommandSource sender, String[] args) {

        if (isSure.contains(sender.getPlayer())) {

            sender.getPlayer().kickPlayer("§cVuelve a unirte para finalizar el proceso de reinicio de estadisticas.");
            File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("HypixelLobby").getDataFolder(), File.separator + "PlayerDatabase");
            File f = new File(userdata, File.separator + sender.getPlayer().getUniqueId() + ".yml");
            f.delete();
            isSure.remove(sender.getPlayer());

        } else {

            isSure.add(sender.getPlayer());
            send("&c&lESTO ES PERMANENTE, VUELVE A PONER EL COMANDO PARA CONFIRMAR");
            send("&7(Excepto tu rango, volvera a re-sincronizarse)");

        }
    }
}