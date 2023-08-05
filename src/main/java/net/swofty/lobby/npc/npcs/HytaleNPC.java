package net.swofty.lobby.npc.npcs;

import net.swofty.lobby.npc.NPC;
import net.swofty.lobby.npc.NPCParameters;
import net.swofty.lobby.util.BookGUI;

@NPCParameters(
        idname = "[NPC] Hytale",
        name = "§7",
        id = 2,
        signature = "M1A0td65NW1G9HY+jDjqezxqSEbA6Gou7nJ/u9mA4m1lhdPSJgFRJ2w9xpZDw9A1r2y0jojqCAIjCz4RzCsLpfdvQZJfIKhjNC27G6HFCJ8zTFsEuLTD+wlnYu29wEm8f7FSFftEgLlDfw8ICzGzNsSAYSQH8IbqTzfKgSodnqOMTJkvxtosZvie87ZmZLCt4podKMAqGJLByzB02EKm9u1XoljlIfScJGvgGzGizeTq3MIpByE3+Qrw3M9vk0vnwrY2ctT1Hn3t0RfxKVzSL3NWvcgiC6XHEFejiuIPvwcAb21Z8CL5pPpXigL8na66hoy8+v5Iwqd22gP4D5BDnYGa6vLQNrzaMqC6SzN/ZpMWor2V/RlYZrtz36fKe0lFfFYKa4m2b+cyjRyii+AbcIynDS0oy54FBaFB4qMn6K9wX4XLR+Zhloqz+cRdhHlosEQk1GkAA+v9bsZbHOuGbuS+vko2/teG5COwZcPzp/+dUTFzKTjnGg58dvjm2cNilicXVHUtGXZA66X9vagrMSi21p21XANLFOeI0aH/A/AObcUMJdbAFnr9sSzw6gCBnripSkXZOzyrHh7bYyKzoepQ5/MZRMRmSH2x9KS8d78VAAkqR/dajNMTwG66mePwpVjnsTlzLEpH7OELo7pJ+cq1EedYMgyLGZ8NT5AnQ9Y=",
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
