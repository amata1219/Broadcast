package amata1219.broadcast;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public class Broadcast extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerCommand(this, new Command("bbc", "broadcast.bbc", new String[0]) {
            public void execute(CommandSender sender, String[] args) {
                if (args.length == 0) {
                    sender.sendMessage(new TextComponent(ChatColor.RED + "メッセージを入力して下さい。"));
                } else {
                    TextComponent component = new TextComponent(String.join("", args));
                    Broadcast.this.getProxy().getPlayers().forEach((player) -> player.sendMessage(component));
                }
            }
        });
    }

    @Override
    public void onDisable() {

    }

}
