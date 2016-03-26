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
public class DonorTag extends PlayerTag {

    final TextComponent proComponent;
    final TextComponent sexyComponent;
    final TextComponent godlyComponent;
    final TextComponent emptyComponent = new TextComponent("");

    public DonorTag() {

        proComponent = new TextComponent("[PRO]");
        proComponent.setColor(ChatColor.GOLD);
        proComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder("Pro Clashnian").color(ChatColor.WHITE).create()));

        sexyComponent = new TextComponent("[SEXY]");
        sexyComponent.setColor(ChatColor.LIGHT_PURPLE);
        sexyComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder("Sexy Clashnian").color(ChatColor.WHITE).create()));

        godlyComponent = new TextComponent("[GOD]");
        godlyComponent.setColor(ChatColor.RED);
        godlyComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder("GOD").color(ChatColor.WHITE).create()));

    }

    @Override
    public TextComponent getComponentFor(Player tagSource) {

        if (tagSource.hasPermission("clashchat.godly")) {
            return godlyComponent;
        } else if (tagSource.hasPermission("clashchat.sexy")) {
            return sexyComponent;
        } else if (tagSource.hasPermission("clashchat.pro")) {
            return proComponent;
        }

        return emptyComponent;
    }

    @Override
    public String getName() {
        return "DonorTag";
    }

    @Override
    public int getPriority() {
        return 2;
    }
}
