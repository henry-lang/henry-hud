package net.henrylang.henryhud.settings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;

public class SettingsMenu extends GuiScreen {
	public GuiButton buttonDone;
	public GuiButton buttonAccentColor;
	public GuiScreen parent;
	
	public SettingsMenu(GuiScreen parent) {
		this.parent = parent;
	}
	
	public void initGui() {
		super.initGui();
		
		this.buttonList.add(buttonAccentColor = new GuiButton(SettingsButtons.ACCENT_COLOR.getID(), width / 2 - 155, height / 6, 150, 20, "Accent Color: Gold"));
		this.buttonList.add(buttonDone = new GuiButton(SettingsButtons.DONE.getID(), width / 2 - 100, height / 6 + 168, 200, 20, "Done"));
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		this.drawCenteredString(this.fontRendererObj, "Henry\'s Hud Options", this.width / 2, 25, 0xffffff);
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	public void cycleAccent() {
		EnumChatFormatting[] order = {
			
		}
	}
}
