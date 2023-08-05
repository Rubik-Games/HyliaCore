package net.swofty.lobby.listener;

import net.swofty.lobby.manager.PlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandPreProcess implements Listener {
    @EventHandler
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {

        if (((event.getMessage().contains("/l") || event.getMessage().contains("/p")) && (event.getMessage().contains("lp") || event.getMessage().contains("luckperms") || event.getMessage().contains("perm"))) || (event.getMessage().contains(":") && !event.getMessage().contains("::"))) {
            if (!new PlayerManager(event.getPlayer()).getRank().equals("admin") && !new PlayerManager(event.getPlayer()).getRank().equals("owner")) {
                // No permission
                event.getPlayer().sendMessage("Unknown command. Type \"help\" for help.");
                event.setCancelled(true);
                return;
            }
        }


        switch (event.getMessage().toLowerCase()) {

            case "/help":
            case "/?":
                event.getPlayer().sendMessage(" ");
                event.getPlayer().sendMessage("§e§lHYLIA");
                event.getPlayer().sendMessage("§eClick para seleccionar la opcion...");
                event.getPlayer().sendMessage(" ");
                event.getPlayer().sendMessage(" §c* §bMinijuegos de Hylia");
                event.getPlayer().sendMessage(" §c* §bEncontrado un bug/problema");
                event.getPlayer().sendMessage(" §c* §bReportar un tramposo");
                event.getPlayer().sendMessage(" §c* §bTienda");
                event.getPlayer().sendMessage(" §c* §bSoporte");
                event.getPlayer().sendMessage(" §c* §bModificaciones admitidas");
                event.getPlayer().sendMessage(" §c* §bHylia Reglas y Politica");
                event.getPlayer().sendMessage(" §c* §bJugabilidad/Servidor General");
                event.getPlayer().sendMessage(" ");
                event.getPlayer().sendMessage("§eNecesitas mas ayuda? Visita §bnuestros foros§e.");
                event.getPlayer().sendMessage(" ");
                event.setCancelled(true);
                break;

            case "/plugins":
            case "/pl":
                if (!new PlayerManager(event.getPlayer()).getRank().equals("admin") && !new PlayerManager(event.getPlayer()).getRank().equals("owner")) {
                    // No permission
                    event.getPlayer().sendMessage("§cNo puedes hacer esto!");
                    event.setCancelled(true);
                } else {
                    event.getPlayer().sendMessage("§eHyliaCore core is §afunctional§e. Use §a/test §efor more info.");
                    event.setCancelled(true);
                }
                break;

            case "/ver":
            case "/version":
            case "/about":
                event.getPlayer().sendMessage("§eThis server is running §aSpigot Fork by KarmaDev (MC: 1.8.8) (Implementing API version 1.8.8-R0.1-SNAPSHOT");
                event.setCancelled(true);
                break;

            case "/luckperms":
            case "/lp":
            case "/tps":
                if (!new PlayerManager(event.getPlayer()).getRank().equals("admin") && !new PlayerManager(event.getPlayer()).getRank().equals("owner")) {
                    // No permission
                    event.getPlayer().sendMessage("Unknown command. Type \"help\" for help.");
                    event.setCancelled(true);
                }
                break;
        }
    }
}
