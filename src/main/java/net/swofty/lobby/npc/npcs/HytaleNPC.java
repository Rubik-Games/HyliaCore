package net.swofty.lobby.npc.npcs;

import net.swofty.lobby.npc.NPC;
import net.swofty.lobby.npc.NPCParameters;
import net.swofty.lobby.util.BookGUI;

@NPCParameters(
        idname = "[NPC] Hytale",
        name = "§7",
        id = 2,
        signature = "ll34a/xBZd5jX9qxHns+A00RwUAbyrapBd4JcfSqfHfeWWp1Ko1FzYi42I6iLihJDn5v3pCoV0/pDG++ih4rmhBrT47H7LmrN7ZHCUfrU2kMTqMNJo9NJAWtm90lrGfi8D5uMBDO83wxXi/BJBgIAj8uNFSmNis03TBxz6ORmkkNj8P7sec56AzW+4Cir86VyHyn5w7ZN/hbBAYvZBwYzoUS2b+8FraRfrDz5D1znl5Cosy78q8q/wPVWJh2ZbW4fgFalqxdx6yiSUfmV+BoN2/0z5WJM2F5QDe1zzB8JgaBHq74CqQvcacmQxJpl/hqet9ShDJdGVhj1u4T4LOMxfV7PykDoF/5/utgeyNhzIYnJQUn/FwKgbSLszfqBkMqsxrqsXQeofqRfelx/CFFtsuG9U7g9Gn+uUgCSJI53jP9qbosZKevEvSzVd7Ons59rvwoQQAeVR0hxal87ABTlmU17z98hJ8zB08gIw/jzMxERT32x7L6cM21+DKBINA/ELmdkxAymHyW8rFtvHt71PuyQykzEbE/OUKWpjMg85EbuT67QP9PSAPUMPvf+H49KJh6zVFEbWDfHFGqavNOdqPJEqZIM4xzRWYSYxjvWKoWpmaDWxQmJC+2iEzlmwaMf6eiIxviU2RviIbe2703iXVivQOd0jVPFnt/92kTIUU=",
        texture = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDZlNDQzOGJkMjM3ZGIzMjU5YmUxZTdkM2YxZTVkMjg0YTVjYmNmZjgzNDJjOTkzMDk1YTJmZTVhODc5OGQxZCJ9fX0=",

        world = "world",
        x = 18.5,
        y = 72,
        z = 9.5,

        looking = true
)
public class HytaleNPC extends NPC {
    @Override
    public void onClick(PlayerClickNPCEvent event) {
        BookGUI.openBook(BookGUI.getHytaleBook(), event.getPlayer());
    }
}
