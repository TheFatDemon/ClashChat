package com.clashnia.clashchat.tags;

import com.demigodsrpg.chitchat.tag.PlayerTag;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

/**
 * Created by Mario on 3/24/2016.
 */
public class WorldTag extends PlayerTag {

    TextComponent worldComponent;

    public WorldTag() {
        worldComponent = new TextComponent();
        worldComponent.setColor(ChatColor.GREEN);
        worldComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder("Current World").color(ChatColor.GREEN).create()));
    }

    @Override
    public TextComponent getComponentFor(Player tagSource) {

        String worldName = tagSource.getWorld().getName();

        worldComponent.setText("[" + worldName.toUpperCase() + "]");

        return worldComponent;
    }

    @Override
    public String getName() {
        return "WorldTag";
    }

    @Override
    public int getPriority() {
        return 0;
    }
}
