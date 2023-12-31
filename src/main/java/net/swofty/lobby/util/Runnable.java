package net.swofty.lobby.util;

import com.comphenix.protocol.PacketType;
import net.swofty.lobby.Data;
import net.swofty.lobby.Loader;
import net.swofty.lobby.manager.PlayerManager;
import net.swofty.lobby.npc.npcs.TutorialNPC;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Runnable {

    public static void asyncSecond() {

        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "weather clear");
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "time set day");

            }
        }.runTaskTimer(Loader.getInstance(), 1200, 3600);

        new BukkitRunnable() {
            @Override
            public void run() {

                for (Player player : Bukkit.getOnlinePlayers()) {

                        org.bukkit.scoreboard.ScoreboardManager scoreboardManager = Loader.getInstance().getServer().getScoreboardManager();
                        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
                        Objective objective = scoreboard.registerNewObjective("Test", "Dummy");

                        objective.getScore(Util.colorize(" ")).setScore(9);

                        if (new PlayerManager(player).getRank().equals("default")) {
                            objective.getScore(Util.colorize("Rango: &7Normal")).setScore(8);
                        } else {
                            objective.getScore(Util.colorize("Rango: " + new PlayerManager(player).getRankPrefix().replace("[", "").replace("]", ""))).setScore(8);
                        }
                        objective.getScore(Util.colorize("Polvos: &a" + Data.getData(player, "mystery-dust"))).setScore(7);
                        objective.getScore(Util.colorize("Logros: &a" + Data.getData(player, "achievements"))).setScore(6);
                        objective.getScore(Util.colorize("Nivel: &a" + Data.getData(player, "level"))).setScore(5);
                        objective.getScore(Util.colorize("   ")).setScore(4);
                        objective.getScore(Util.colorize("Lobby: &a#1")).setScore(3);
                        objective.getScore(Util.colorize("Jugadores: &a" + Bukkit.getOnlinePlayers().size())).setScore(2);
                        objective.getScore(Util.colorize("  ")).setScore(1);
                        objective.getScore(Util.colorize("&ewww.hyliamc.net")).setScore(1);

                        Team zero = scoreboard.registerNewTeam("zero");

                        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                        objective.setDisplayName(Util.colorize("&e&lHYLIA"));
                        player.setScoreboard(scoreboard);
                }
            }
        }.runTaskTimer(Loader.getInstance(), 0, 40);

        new BukkitRunnable() {
            @Override
            public void run() {

                for (Player player : TutorialNPC.tutorial1) {
                    player.teleport(new Location(Bukkit.getWorld("world"), 22.5, 87.7, 12, 72, 0));
                }

                for (Player player : TutorialNPC.tutorial2) {
                    player.teleport(new Location(Bukkit.getWorld("world"), 20, 85, 31, 130, 20));
                }

                for (Player player : TutorialNPC.tutorial3) {
                    player.teleport(new Location(Bukkit.getWorld("world"), 20.5, 80, 4.5, -180, 0));
                }

                for (Player player : TutorialNPC.tutorial4) {
                    player.teleport(new Location(Bukkit.getWorld("world"), 21, 90, 22.5, 90, 90));
                }

                for (Player player : TutorialNPC.tutorial5) {
                    player.teleport(new Location(Bukkit.getWorld("world"), 38.5, 87, 22.5, 90, 0));
                }

                for (Player player : Bukkit.getOnlinePlayers()) {

                    if (player.getLocation().getX() >= 41 && player.getLocation().getX() <= 42 && player.getLocation().getZ() >= 55 && player.getLocation().getZ() <= 56) {

                        if (Data.getData(player, "parkour").equals("none")) {
                            Items.giveParkourItems(player, Boolean.valueOf(Data.getData(player, "hidden-players")));
                            player.sendMessage("§a§lParkour challenge started!");
                            player.sendMessage("§aUse §e/parkour checkpoint §ato teleport to the last checkpoint or §e/parkour cancel §ato cancel!");
                            Data.editData(player, "parkour", String.valueOf(System.currentTimeMillis()));
                            Data.editData(player, "checkpoint", "1");
                        } else {

                            boolean time2 = System.currentTimeMillis() % 2 == 0;
                            if (time2) {
                                player.getPlayer().sendMessage("§a§lReset your timer to 00:00! Get to the finish line!");
                                Data.editData(player.getPlayer(), "parkour", String.valueOf(System.currentTimeMillis()));
                                Data.editData(player, "checkpoint", "1");
                            }
                        }
                    }

                    if (player.getLocation().getY() > 88 && player.getLocation().getX() >= 74 && player.getLocation().getX() <= 75 && player.getLocation().getZ() >= 113 && player.getLocation().getZ() <= 114) {

                        if (!Data.getData(player, "parkour").equals("none") && Data.getData(player, "checkpoint").equals("1")) {
                            long millis = System.currentTimeMillis() - Long.parseLong(Data.getData(player, "parkour"));
                            SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
                            String formatted = sdf.format(new Date(millis));

                            player.sendMessage("§a§lYou reached §e§lCheckpoint #1 §a§lafter §e§l" + formatted);
                            Data.editData(player, "checkpoint", "2");
                            Data.editData(player, "parkour-cp1", String.valueOf(System.currentTimeMillis()));

                            if (Data.getData(player, "parkour-cp1-best").equals("0")) {
                                player.sendMessage("§7You finished this part of the parkour in §6" + formatted);
                                Data.editData(player, "parkour-cp1-best", String.valueOf(System.currentTimeMillis() - Long.parseLong(Data.getData(player, "parkour"))));
                            } else if (!((Long.parseLong(Data.getData(player, "parkour-cp1-best"))) < (millis))) {
                                long millis2 = Long.parseLong(Data.getData(player, "parkour-cp1-best"));
                                SimpleDateFormat sdf2 = new SimpleDateFormat("mm:ss.SSS");
                                String formatted2 = sdf2.format(new Date(millis2));
                                player.sendMessage("§7You finished this part of the parkour in §6" + formatted + " §7and beat your personal best of " + formatted2);
                                Data.editData(player, "parkour-cp1-best", String.valueOf(millis));
                            } else {
                                long millis2 = Long.parseLong(Data.getData(player, "parkour-cp1-best"));
                                SimpleDateFormat sdf2 = new SimpleDateFormat("mm:ss.SSS");
                                String formatted2 = sdf2.format(new Date(millis2));
                                player.sendMessage("§7You finished this part of the parkour in " + formatted + " §7(personal best: " + formatted2 + ").");
                            }

                        }
                    }

                    if (player.getLocation().getX() >= -8 && player.getLocation().getX() <= -7 && player.getLocation().getZ() >= 118 && player.getLocation().getZ() <= 119) {

                        if (!Data.getData(player, "parkour").equals("none") && Data.getData(player, "checkpoint").equals("2")) {
                            long millis = System.currentTimeMillis() - Long.parseLong(Data.getData(player, "parkour"));
                            SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
                            String formatted = sdf.format(new Date(millis));

                            long millis2 = System.currentTimeMillis() - Long.parseLong(Data.getData(player, "parkour-cp1"));
                            SimpleDateFormat sdf2 = new SimpleDateFormat("mm:ss.SSS");
                            String formatted2 = sdf2.format(new Date(millis2));

                            player.sendMessage("§a§lYou reached §e§lCheckpoint #2 §a§lafter §e§l" + formatted);
                            Data.editData(player, "checkpoint", "3");
                            Data.editData(player, "parkour-cp2", String.valueOf(System.currentTimeMillis()));

                            if (Data.getData(player, "parkour-cp2-best").equals("0")) {
                                player.sendMessage("§7You finished this part of the parkour in §6" + formatted2);
                                Data.editData(player, "parkour-cp2-best", String.valueOf(millis2));
                            } else if (!(Long.parseLong(Data.getData(player, "parkour-cp2-best")) < (millis2))) {
                                long millis3 = Long.parseLong(Data.getData(player, "parkour-cp2-best"));
                                SimpleDateFormat sdf3 = new SimpleDateFormat("mm:ss.SSS");
                                String formatted3 = sdf3.format(new Date(millis3));
                                player.sendMessage("§7You finished this part of the parkour in §6" + formatted2 + " §7and beat your personal best of " + formatted3);
                                Data.editData(player, "parkour-cp2-best", String.valueOf(millis2));
                            } else {
                                long millis3 = Long.parseLong(Data.getData(player, "parkour-cp2-best"));
                                SimpleDateFormat sdf3 = new SimpleDateFormat("mm:ss.SSS");
                                String formatted3 = sdf3.format(new Date(millis3));
                                player.sendMessage("§7You finished this part of the parkour in " + formatted2 + " §7(personal best: " + formatted3 + ").");
                            }
                        }
                    }

                    if (player.getLocation().getX() >= -19 && player.getLocation().getX() <= -18 && player.getLocation().getZ() >= 118 && player.getLocation().getZ() <= 119) {

                        if (!Data.getData(player, "parkour").equals("none") && Data.getData(player, "checkpoint").equals("3")) {
                            long millis = System.currentTimeMillis() - Long.parseLong(Data.getData(player, "parkour"));
                            SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
                            String formatted = sdf.format(new Date(millis));

                            if (Data.getData(player, "parkour-best").equals("0")) {
                                player.sendMessage("§a§lYour got a time of §e§l" + formatted + "§a§l! Try again to get an even faster time");
                                Data.editData(player, "parkour-best", String.valueOf(millis));
                                Data.editData(player, "checkpoint", "1");
                                Data.editData(player, "parkour", "none");
                            } else

                            if (millis < Long.parseLong(Data.getData(player, "parkour-best"))) {
                                long millis2 = Long.parseLong(Data.getData(player, "parkour-best"));
                                SimpleDateFormat sdf2 = new SimpleDateFormat("mm:ss.SSS");
                                String formatted2 = sdf2.format(new Date(millis2));
                                player.sendMessage("§a§lYour time of §e§l" + formatted + " §a§lbeat your previous record of §e§l" + formatted2);
                                Data.editData(player, "checkpoint", "1");
                                Data.editData(player, "parkour", "none");
                                Data.editData(player, "parkour-best", String.valueOf(millis));
                                Items.giveSpawnItems(player, Boolean.valueOf(Data.getData(player, "hidden-items")));
                            } else {
                                long millis2 = Long.parseLong(Data.getData(player, "parkour-best"));
                                SimpleDateFormat sdf2 = new SimpleDateFormat("mm:ss.SSS");
                                String formatted2 = sdf2.format(new Date(millis2));
                                player.sendMessage("§a§lYour time of §e§l" + formatted + " §a§ldid not beat your previous record of §e§l" + formatted2 + "§a§l! Try again to beat your old record!");
                                Data.editData(player, "checkpoint", "1");
                                Data.editData(player, "parkour", "none");
                                Items.giveSpawnItems(player, Boolean.valueOf(Data.getData(player, "hidden-items")));
                            }

                            long millis2 = (System.currentTimeMillis() - Long.parseLong(Data.getData(player, "parkour-cp2")));
                            SimpleDateFormat sdf2 = new SimpleDateFormat("mm:ss.SSS");
                            String formatted2 = sdf2.format(new Date(millis2));

                            if (Data.getData(player, "parkour-cp3-best").equals("0")) {
                                player.sendMessage("§7You finished this part of the parkour in §6" + formatted2);
                                Data.editData(player, "parkour-cp3-best", String.valueOf(millis2));
                            } else if (!(Long.parseLong(Data.getData(player, "parkour-cp3-best")) < (millis2))) {
                                long millis3 = Long.parseLong(Data.getData(player, "parkour-cp3-best"));
                                SimpleDateFormat sdf3 = new SimpleDateFormat("mm:ss.SSS");
                                String formatted3 = sdf3.format(new Date(millis3));
                                player.sendMessage("§7You finished this part of the parkour in §6" + formatted2 + " §7and beat your personal best of " + formatted3);
                                Data.editData(player, "parkour-cp3-best", String.valueOf(millis2));
                            } else {
                                long millis3 = Long.parseLong(Data.getData(player, "parkour-cp3-best"));
                                SimpleDateFormat sdf3 = new SimpleDateFormat("mm:ss.SSS");
                                String formatted3 = sdf3.format(new Date(millis3));
                                player.sendMessage("§7You finished this part of the parkour in " + formatted2 + " §7(personal best: " + formatted3 + ").");
                            }

                            Data.editData(player, "parkour-cp1", "0");
                            Data.editData(player, "parkour-cp2", "0");
                            Data.editData(player, "parkour-cp3", "0");

                        } else {
                            boolean time2 = System.currentTimeMillis() % 2 == 0;
                            if (time2) {
                                player.sendMessage("§a§lThis is the finish line for the parkour! Get to the start line and climb back up here!");
                            }
                        }
                    }

                }
            }
        }.runTaskTimerAsynchronously(Loader.getInstance(), 0, 2);
    }
}
