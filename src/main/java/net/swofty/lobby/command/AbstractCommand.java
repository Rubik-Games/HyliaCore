package net.swofty.lobby.command;

import net.swofty.lobby.Loader;
import net.swofty.lobby.command.exception.CommandArgumentException;
import net.swofty.lobby.command.exception.PlayerNotFoundException;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractCommand implements CommandExecutor, TabCompleter {
        public static final String COMMAND_PREFIX = "Command_";
        protected static final Loader plugin = Loader.getInstance();

        private final CommandParameters params;
        private final String name;
        private final String description;
        private final String usage;
        private final List<String> aliases;
        private final String permission;
        private final DECommand command;

        private CommandSource sender;

    protected AbstractCommand() {
        this.params = this.getClass().getAnnotation(CommandParameters.class);
        this.name = this.getClass().getSimpleName().replace(COMMAND_PREFIX, "").toLowerCase();
        this.description = this.params.description();
        this.usage = this.params.usage().replace("<command>", this.name);
        this.aliases = Arrays.asList(this.params.aliases());
        this.permission = this.params.permission();
        this.command = new DECommand(this);
    }

        public abstract void run(CommandSource sender, String[] args);
        public List<String> tabCompleters() {
        return null;
    }

        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }

        @Override
        public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }

        public void register() {
        plugin.commandMap.register("", this.command);
    }

        private final static class DECommand extends Command {
            private final AbstractCommand cmd;

            public DECommand(AbstractCommand cmd) {
                super(cmd.name, cmd.description, cmd.usage, cmd.aliases);
                this.setPermission(cmd.permission);
                this.setPermissionMessage("§cDebes de ser admin o superior para hacer eso!");
                this.cmd = cmd;
            }

            @Override
            public boolean execute(CommandSender commandSender, String s, String[] strings) {
                cmd.sender = new CommandSource(commandSender);

                if(cmd.params.inGameOnly() && commandSender instanceof ConsoleCommandSender) {
                    commandSender.sendMessage("§cSolo jugadores!");
                    return true;
                }

                if(commandSender.hasPermission(cmd.permission)) {
                    try {
                        cmd.run(cmd.sender, strings);
                    }catch (CommandArgumentException ex) {
                        commandSender.sendMessage(cmd.usage);
                        return true;
                    }catch (PlayerNotFoundException ex) {
                        commandSender.sendMessage("§cJugador no encontrado.");
                        return true;
                    }catch (Exception ex) {
                        commandSender.sendMessage("§cHa ocurrido un error: " + ex.getMessage());
                        ex.printStackTrace();
                        return true;
                    }
                } else {
                    commandSender.sendMessage("§cDebes de ser ADMIN o superior para hacer eso!");
                }
                return false;
            }

            @Override
            public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
                List<String> tc = cmd.onTabComplete(sender, this, alias, args);
                if (tc != null)
                    return tc;
                return null;
            }
        }

        public void send(String msg, CommandSource sender) {
        sender.sendTranslated(msg);
    }

        public void send(String msg) {
        send(msg, sender);
    }

        public void send(String msg, Player player) {
        player.sendMessage(msg.replaceAll("&", "§"));
    }
}
