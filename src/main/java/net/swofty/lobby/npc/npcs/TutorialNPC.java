package net.swofty.lobby.npc.npcs;

import net.swofty.lobby.Data;
import net.swofty.lobby.Loader;
import net.swofty.lobby.manager.PlayerManager;
import net.swofty.lobby.npc.NPC;
import net.swofty.lobby.npc.NPCParameters;
import net.swofty.lobby.util.BookGUI;
import net.swofty.lobby.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;

@NPCParameters(
        idname = "[NPC] Tutorial",
        name = "§7",
        id = 5,
        signature = "M1A0td65NW1G9HY+jDjqezxqSEbA6Gou7nJ/u9mA4m1lhdPSJgFRJ2w9xpZDw9A1r2y0jojqCAIjCz4RzCsLpfdvQZJfIKhjNC27G6HFCJ8zTFsEuLTD+wlnYu29wEm8f7FSFftEgLlDfw8ICzGzNsSAYSQH8IbqTzfKgSodnqOMTJkvxtosZvie87ZmZLCt4podKMAqGJLByzB02EKm9u1XoljlIfScJGvgGzGizeTq3MIpByE3+Qrw3M9vk0vnwrY2ctT1Hn3t0RfxKVzSL3NWvcgiC6XHEFejiuIPvwcAb21Z8CL5pPpXigL8na66hoy8+v5Iwqd22gP4D5BDnYGa6vLQNrzaMqC6SzN/ZpMWor2V/RlYZrtz36fKe0lFfFYKa4m2b+cyjRyii+AbcIynDS0oy54FBaFB4qMn6K9wX4XLR+Zhloqz+cRdhHlosEQk1GkAA+v9bsZbHOuGbuS+vko2/teG5COwZcPzp/+dUTFzKTjnGg58dvjm2cNilicXVHUtGXZA66X9vagrMSi21p21XANLFOeI0aH/A/AObcUMJdbAFnr9sSzw6gCBnripSkXZOzyrHh7bYyKzoepQ5/MZRMRmSH2x9KS8d78VAAkqR/dajNMTwG66mePwpVjnsTlzLEpH7OELo7pJ+cq1EedYMgyLGZ8NT5AnQ9Y=",
        texture = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDZlNDQzOGJkMjM3ZGIzMjU5YmUxZTdkM2YxZTVkMjg0YTVjYmNmZjgzNDJjOTkzMDk1YTJmZTVhODc5OGQxZCJ9fX0=",

        world = "world",
        x = 13.5,
        y = 72.5,
        z = 17.5,

        looking = true
)
public class TutorialNPC extends NPC {

    public static ArrayList<Player> tutorial1 = new ArrayList<>();
    public static ArrayList<Player> tutorial2 = new ArrayList<>();
    public static ArrayList<Player> tutorial3 = new ArrayList<>();
    public static ArrayList<Player> tutorial4 = new ArrayList<>();
    public static ArrayList<Player> tutorial5 = new ArrayList<>();


    @Override
    public void onClick(PlayerClickNPCEvent event) {

        event.getPlayer().setGameMode(GameMode.SPECTATOR);
        tutorial1.add(event.getPlayer());
        event.getPlayer().sendMessage(" ");
        event.getPlayer().sendMessage("§e§lBienvenido a Hylia,");
        event.getPlayer().sendMessage("§bdale a la brujula para jugar.");
        event.getPlayer().sendMessage(" ");

        event.getPlayer().sendTitle("§e§lBienvenido a Hylia,", "§bdale a la brujula para jugar.");

        new BukkitRunnable() {
            @Override
            public void run() {

                tutorial1.remove(event.getPlayer());
                tutorial2.add(event.getPlayer());
                event.getPlayer().sendMessage("§e§lTambien puedes");
                event.getPlayer().sendMessage("§bdarle click-derecho a los npcs.");
                event.getPlayer().sendMessage(" ");


                event.getPlayer().sendTitle("§e§lTambien puedes", "§bdarle click-derecho a los npcs.");

                new BukkitRunnable() {
                    @Override
                    public void run() {

                        tutorial2.remove(event.getPlayer());
                        tutorial3.add(event.getPlayer());
                        event.getPlayer().sendMessage("§e§lMira tu inventario.");
                        event.getPlayer().sendMessage("§bTienes logros, cosmeticos y mas!");
                        event.getPlayer().sendMessage(" ");

                        event.getPlayer().sendTitle("§e§lMira tu inventario.", "§bTienes logros, cosmeticos y mas!");

                        new BukkitRunnable() {
                            @Override
                            public void run() {

                                tutorial3.remove(event.getPlayer());
                                tutorial4.add(event.getPlayer());
                                event.getPlayer().sendMessage("§e§lVisita nuestra web!");
                                event.getPlayer().sendMessage("§bwww.hyliamc.net - Noticias, discusiones y mas!");
                                event.getPlayer().sendMessage(" ");

                                event.getPlayer().sendTitle("§e§lVisita nuestra web!", "§bwww.hyliamc.net - Noticias, discusiones y mas!");

                                new BukkitRunnable() {
                                    @Override
                                    public void run() {

                                        tutorial4.remove(event.getPlayer());
                                        tutorial5.add(event.getPlayer());
                                        event.getPlayer().sendMessage("§e§lEso es todo!");
                                        event.getPlayer().sendMessage("§bPasalo bien en el servidor!");
                                        event.getPlayer().sendMessage(" ");

                                        event.getPlayer().sendTitle("§e§lEso es todo!", "§bPasalo bien en el servidor!");

                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {

                                                tutorial5.remove(event.getPlayer());
                                                event.getPlayer().setGameMode(GameMode.SURVIVAL);
                                                event.getPlayer().resetTitle();

                                            }
                                        }.runTaskLater(Loader.getInstance(), 60);

                                    }
                                }.runTaskLaterAsynchronously(Loader.getInstance(), 80);

                            }
                        }.runTaskLaterAsynchronously(Loader.getInstance(), 80);

                    }
                }.runTaskLaterAsynchronously(Loader.getInstance(), 80);

            }
        }.runTaskLaterAsynchronously(Loader.getInstance(), 80);

    }
}
