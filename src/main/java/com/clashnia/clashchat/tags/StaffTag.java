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
public class StaffTag extends PlayerTag {

    final TextComponent guestComponent;
    final TextComponent memberComponent;
    final TextComponent trustedComponent;
    final TextComponent helperComponent;
    final TextComponent modComponent;
    final TextComponent adminComponent;

    public StaffTag() {
        guestComponent = new TextComponent("[G]");
        guestComponent.setColor(ChatColor.WHITE);
        guestComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder("Guest").color(ChatColor.WHITE).create()));

        memberComponent = new TextComponent("[M]");
        memberComponent.setColor(ChatColor.AQUA);
        memberComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder("Member").color(ChatColor.AQUA).create()));

        trustedComponent = new TextComponent("[T]");
        trustedComponent.setColor(ChatColor.DARK_AQUA);
        trustedComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder("Trusted").color(ChatColor.DARK_AQUA).create()));

        helperComponent = new TextComponent("[H]");
        helperComponent.setColor(ChatColor.YELLOW);
        helperComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder("Helper").color(ChatColor.YELLOW).create()));

        modComponent = new TextComponent("[M]");
        modComponent.setColor(ChatColor.DARK_GREEN);
        modComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder("Moderator").color(ChatColor.DARK_GREEN).create()));

        adminComponent  = new TextComponent("[A]");
        adminComponent.setColor(ChatColor.DARK_RED);
        adminComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder("Administrator").color(ChatColor.DARK_RED).create()));

    }

    @Override
    public TextComponent getComponentFor(Player tagSource) {

        if (tagSource.hasPermission("clashchat.admin")) {
            return adminComponent;
        } else if (tagSource.hasPermission("clashchat.mod")) {
            return modComponent;
        } else if (tagSource.hasPermission("clashchat.helper")) {
            return helperComponent;
        } else if (tagSource.hasPermission("clashchat.trusted")) {
            return trustedComponent;
        } else if (tagSource.hasPermission("clashchat.member")) {
            return memberComponent;
        }
        return guestComponent;
    }

    @Override
    public String getName() {
        return "Staff";
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
