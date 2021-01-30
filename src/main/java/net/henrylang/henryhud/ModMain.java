package net.henrylang.henryhud;

import net.henrylang.henryhud.hud.HudManager;
import net.henrylang.henryhud.presence.Presence;
import net.henrylang.henryhud.presence.PresenceEvents;
import net.henrylang.henryhud.settings.SettingsEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModMain.MODID, version = ModMain.VERSION)
public class ModMain {
    public static final String MODID = "henryhud";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	MinecraftForge.EVENT_BUS.register(new HudManager());
    	MinecraftForge.EVENT_BUS.register(new PresenceEvents());
    	MinecraftForge.EVENT_BUS.register(new SettingsEvents());
    	
    	Presence.load();
//    	Config.load(event.getModConfigurationDirectory().getPath());
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("Henry's Hud Mod Loaded!");
        HudManager.populateElements();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	Presence.update("Playing Minecraft", "In the Menus");
    }
}
