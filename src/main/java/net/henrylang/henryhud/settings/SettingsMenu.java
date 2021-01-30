package net.henrylang.henryhud.settings;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class SettingsMenu extends GuiScreen {
	GuiScreen parent;
	
	public SettingsMenu(GuiScreen parent) {
		this.parent = parent;
	}
	
	public void initGui() {
		super.initGui();
		
		this.buttonList.add(new GuiButton(SettingsButtons.POOP.getID(), width / 2, height / 2, 100, 100, "Poop"));
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
}
