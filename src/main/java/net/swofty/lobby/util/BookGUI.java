package net.swofty.lobby.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lombok.SneakyThrows;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.chat.ComponentSerializer;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketDataSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutCustomPayload;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftMetaBook;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.List;

public class BookGUI {
    public static void openBook(ItemStack book, Player p) {
        int slot = p.getInventory().getHeldItemSlot();
        ItemStack old = p.getInventory().getItem(slot);
        p.getInventory().setItem(slot, book);

        ByteBuf buf = Unpooled.buffer(256);
        buf.setByte(0, (byte)0);
        buf.writerIndex(1);

        PacketPlayOutCustomPayload packet = new PacketPlayOutCustomPayload("MC|BOpen", new PacketDataSerializer(buf));
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
        p.getInventory().setItem(slot, old);
    }

    @SuppressWarnings("unchecked")
    @SneakyThrows
    public static ItemStack getRankChangeBook(String rank) {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta meta = (BookMeta) book.getItemMeta();

        List<IChatBaseComponent> pages = (List<IChatBaseComponent>) CraftMetaBook.class.getDeclaredField("pages").get(meta);
        TextComponent text = new TextComponent("Tu rango ha cambiado, porfavor, vuelve a unirte para los cambios.\n\n");
        TextComponent log_out = new TextComponent(new ComponentBuilder("§a§lSALIR").event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/simulateevent rank::book_confirm")).create());
        IChatBaseComponent page = IChatBaseComponent.ChatSerializer.a(ComponentSerializer.toString(text, log_out));
        pages.add(page);
        meta.setTitle("Cambio de Rango");
        meta.setAuthor("Server");
        book.setItemMeta(meta);

        return book;
    }

    @SuppressWarnings("unchecked")
    @SneakyThrows
    public static ItemStack getRulesBook() {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta meta = (BookMeta) book.getItemMeta();

        List<IChatBaseComponent> pages = (List<IChatBaseComponent>) CraftMetaBook.class.getDeclaredField("pages").get(meta);
        TextComponent text = new TextComponent(Util.colorize("&6&lHYLIA NETWORK RULES\n\n1. Bad/inappropriate skins are bannable."));
        IChatBaseComponent page = IChatBaseComponent.ChatSerializer.a(ComponentSerializer.toString(new BaseComponent[] {text}));
        pages.add(page);
        meta.setTitle("Reglas");
        meta.setAuthor("Server");
        book.setItemMeta(meta);

        return book;
    }

    @SuppressWarnings("unchecked")
    @SneakyThrows
    public static ItemStack getHytaleBook() {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta meta = (BookMeta) book.getItemMeta();

        List<IChatBaseComponent> pages = (List<IChatBaseComponent>) CraftMetaBook.class.getDeclaredField("pages").get(meta);
        TextComponent text = new TextComponent(Util.colorize("&3&l  HYLIA STUDIOS\n\nHylia es una\nempresa de juegos\ndonde estan haciendo\neste servidor.\n\nPuedes visitar\nla web de Hylia!\n\n"));
        TextComponent log_out = new TextComponent(new ComponentBuilder("  §d§lCLICK PARA IR").event(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://hyliamc.net")).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§8(Redireccion al foro)").create())).create());
        IChatBaseComponent page = IChatBaseComponent.ChatSerializer.a(ComponentSerializer.toString(text, log_out));
        pages.add(page);
        meta.setTitle("Hytale");
        meta.setAuthor("Server");
        book.setItemMeta(meta);

        return book;
    }

    @SneakyThrows
    public static ItemStack getSocialMediasBook() {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta meta = (BookMeta) book.getItemMeta();

        List<IChatBaseComponent> pages = (List<IChatBaseComponent>) CraftMetaBook.class.getDeclaredField("pages").get(meta);
        TextComponent text = new TextComponent(Util.colorize("\nMantente con noticias\nde Hylia y obten &6&l4X\n&6&lBoosters de Moneda &rpor\nseguirnos!\n\nClick para seguirnos:\n- &9&lFacebook\n- &d&lInstagram\n- &c&lYouTube\n- &3&lTwitter\n\nPuedes reclamar estas\nrecompensas cuando quieras!\nthe Delivery Man"));
        IChatBaseComponent page = IChatBaseComponent.ChatSerializer.a(ComponentSerializer.toString(text));
        pages.add(page);
        meta.setTitle("Social Rewards");
        meta.setAuthor("Server");
        book.setItemMeta(meta);

        return book;
    }

    @SuppressWarnings("unchecked")
    @SneakyThrows
    public static ItemStack getErrorBook() {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta meta = (BookMeta) book.getItemMeta();

        List<IChatBaseComponent> pages = (List<IChatBaseComponent>) CraftMetaBook.class.getDeclaredField("pages").get(meta);
        TextComponent text = new TextComponent("An error has occurred while loading your data or connecting to the databases, please try re-logging again later.\n\nError: ATC7\n\n\n");
        TextComponent log_out = new TextComponent(new ComponentBuilder("§c§l          [QUIT]").event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/kickme err atc7")).create());
        log_out.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Util.colorize("&cClick to log out")).create()));
        IChatBaseComponent page = IChatBaseComponent.ChatSerializer.a(ComponentSerializer.toString(text, log_out));
        pages.add(page);
        meta.setTitle("Rank Changes");
        meta.setAuthor("Server");
        book.setItemMeta(meta);

        return book;
    }

    @SuppressWarnings("unchecked")
    @SneakyThrows
    public static ItemStack getDiscordBook() {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta meta = (BookMeta) book.getItemMeta();

        List<IChatBaseComponent> pages = (List<IChatBaseComponent>) CraftMetaBook.class.getDeclaredField("pages").get(meta);
        TextComponent text = new TextComponent(Util.colorize("Unete a nuestro discord y haz amigos. Tambien entrate de nuestras noticias y novedades!\n\n"));
        TextComponent join = new TextComponent(new ComponentBuilder("§9§lCLICK TO JOIN!").event(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.hyliamc.net")).create());
        join.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click para unirte:\n§bdiscord.hyliamc.net").create()));
        IChatBaseComponent page = IChatBaseComponent.ChatSerializer.a(ComponentSerializer.toString(text, join));
        pages.add(page);
        meta.setTitle("Rules");
        meta.setAuthor("Server");
        book.setItemMeta(meta);

        return book;
    }
}
