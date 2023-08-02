package net.swofty.lobby.command;

import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Getter
public class CommandSource
{
    private final CommandSender sender;
    private final Player player;

    public CommandSource(CommandSender sender) {
        this.sender = sender;
        this.player = sender instanceof Player ? (Player) sender : null;
    }

    public void sendTranslated(String s) {
        sender.sendMessage(s.replaceAll("&", "§"));
    }
}
