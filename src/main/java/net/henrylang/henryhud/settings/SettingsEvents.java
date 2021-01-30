package net.henrylang.henryhud.settings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptions;
import net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SettingsEvents {
	SettingsMenu currentHudMenu;
	
	@SubscribeEvent
	public void onActionPerformed(ActionPerformedEvent.Post event) {
		boolean inMinecraftSettings = Minecraft.getMinecraft().currentScreen instanceof GuiOptions;
		boolean inHudSettings = Minecraft.getMinecraft().currentScreen instanceof SettingsMenu;
		
		if(event.button.id == SettingsButtons.OPEN_SETTINGS.getID() && inMinecraftSettings) {
			Minecraft.getMinecraft().displayGuiScreen(currentHudMenu = new SettingsMenu(event.gui));
		} else if(event.button.id == SettingsButtons.DONE.getID() && inHudSettings) {
			Minecraft.getMinecraft().displayGuiScreen(currentHudMenu.parent);
		} else if(event.button.id == SettingsButtons.ACCENT_COLOR.getID() && inHudSettings) {
			currentHudMenu.buttonAccentColor
		}
	}
	
	@SubscribeEvent
	public void onInitGui(InitGuiEvent.Post event) {
		if(event.gui instanceof GuiOptions) {
			int x = 0;
			int y = 0;
			for (Object button : event.buttonList) {
				if (button instanceof GuiButton) {
					if (((GuiButton) button).id == SettingsButtons.SKIN_CUSTOMIZATION_VANILLA.getID()) {
						x = ((GuiButton) button).xPosition;
						y = ((GuiButton) button).yPosition;
					}
				}
			}
			
			event.buttonList.add(new GuiButton(SettingsButtons.OPEN_SETTINGS.getID(), x, y - 24, 150, 20, "Henry\'s Hud"));
		}
	}
}
