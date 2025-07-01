package com.medua.apostlesbridgenext.events;

import com.medua.apostlesbridgenext.config.Config;
import com.medua.apostlesbridgenext.handler.MessageHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ServerInfo;

public class PlayerJoinEvent {
    private static String lastServerIP = "";

    public static void onPlayerJoin() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) { return; }

        ServerInfo serverInfo = mc.getCurrentServerEntry();
        String serverIP = serverInfo != null ? serverInfo.address : "singleplayer";

        if (!serverIP.equals(lastServerIP)) {
            lastServerIP = serverIP;
            if (Config.getGuild().isEmpty() && Config.getURL().isEmpty() && Config.getToken().isEmpty()) {
                MessageHandler.sendSpacerMessage();
                MessageHandler.sendMessage("§c§lATTENTION", false);
                MessageHandler.sendMessage("§cThere is no info set for Apostles Bridge.", false);
                MessageHandler.sendMessage("§cUse §4/apostles §cor §4/bridge §cto set one", false);
                MessageHandler.sendSpacerMessage();
            }
        }
    }
}
