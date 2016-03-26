package com.clashnia.clashchat;

import com.clashnia.clashchat.tags.ClashNameTag;
import com.clashnia.clashchat.tags.DonorTag;
import com.clashnia.clashchat.tags.StaffTag;
import com.clashnia.clashchat.tags.WorldTag;
import com.demigodsrpg.chitchat.Chitchat;
import com.demigodsrpg.chitchat.format.ChatFormat;
import com.demigodsrpg.chitchat.tag.NameTag;
import com.demigodsrpg.chitchat.tag.SpecificPlayerTag;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Mario on 3/24/2016.
 */
public class ClashChat extends JavaPlugin {

    @Override
    public void onEnable() {
        ChatFormat format = Chitchat.getChatFormat();

        StaffTag staffTag = new StaffTag();
        format.add(staffTag);

        WorldTag worldTag = new WorldTag();
        format.add(worldTag);

        TextComponent ownerComponent = new TextComponent("[O]");
        ownerComponent.setColor(ChatColor.DARK_GRAY);
        ownerComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder("Owner").color(ChatColor.DARK_RED).create()));

        SpecificPlayerTag demonTag = new SpecificPlayerTag("DemonTag", "TheFatDemon", ownerComponent, 5);
        SpecificPlayerTag blueTag = new SpecificPlayerTag("BlueTag", "Blue___Moon", ownerComponent, 5);

        format.add(demonTag);
        format.add(blueTag);

        TextComponent hqmComponent = new TextComponent("[F]");
        hqmComponent.setColor(ChatColor.DARK_PURPLE);
        hqmComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder("Founder").color(ChatColor.DARK_RED).create()));

        SpecificPlayerTag hqmTag = new SpecificPlayerTag("HQMTag", "HQM", hqmComponent, 5);
        SpecificPlayerTag alexTag = new SpecificPlayerTag("AlexTag", "_Alex", hqmComponent, 5);

        format.add(hqmTag);
        format.add(alexTag);

        DonorTag donorTag = new DonorTag();

        format.add(donorTag);

        NameTag nameTag = new ClashNameTag();

        format.add(nameTag);
    }
}
