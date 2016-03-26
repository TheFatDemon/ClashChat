package com.clashnia.clashchat.tags;

import com.demigodsrpg.chitchat.tag.NameTag;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

/**
 * Created by Mario on 3/25/2016.
 */
public class ClashNameTag extends NameTag {

    @Override
    public TextComponent getComponentFor(Player tagSource) {
        TextComponent nameComponent = super.getComponentFor(tagSource);

        nameComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder("Click to Message").color(ChatColor.AQUA).create()));

        nameComponent.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/msg " + tagSource.getName() + " "));

        return nameComponent;
    }
}
