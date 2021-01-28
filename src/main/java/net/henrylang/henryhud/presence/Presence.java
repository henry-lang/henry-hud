package net.henrylang.henryhud.presence;

import java.util.logging.Logger;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

public class Presence {
	static boolean updating = true;
	static long started = 0;
	
	public static void load() {
		started = System.currentTimeMillis();
		
		DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback() {
			@Override
			public void apply(DiscordUser user) {
				while(updating) {
					DiscordRPC.discordRunCallbacks();
				}
			}
		}).build();
		
		DiscordRPC.discordInitialize("804419966010523720", handlers, true);
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println("Stopping Discord Presence!");
				Presence.stop();
			}
		});
	}
	
	public static void update(String state, String details) {
		DiscordRichPresence.Builder builder = new DiscordRichPresence.Builder(details);
		builder.setBigImage("particles_small", "");
		builder.setDetails(state);
		builder.setStartTimestamps(started);

		DiscordRPC.discordUpdatePresence(builder.build());
	}
	
	public static void stop() {
		updating = false;
		DiscordRPC.discordShutdown();
	}
}
