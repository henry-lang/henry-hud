package net.henrylang.henryhud.presence;

import net.minecraft.client.Minecraft;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientDisconnectionFromServerEvent;

public class PresenceEvents {
	@SubscribeEvent
	public void onJoinGame(ClientConnectedToServerEvent event) {
		if(Minecraft.getMinecraft().isSingleplayer()) {
			Presence.update("Playing Minecraft", "In Single Player World");
		} else {
			Presence.update("Playing Minecraft", "Connected to " + Minecraft.getMinecraft().getCurrentServerData().serverIP);
		}
	}
	
	@SubscribeEvent
	public void onLeaveGame(ClientDisconnectionFromServerEvent event) {
		Presence.update("Playing Minecraft", "In the Menus");
	}
}