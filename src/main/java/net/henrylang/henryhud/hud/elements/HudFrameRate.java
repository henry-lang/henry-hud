package net.henrylang.henryhud.hud.elements;

import net.henrylang.henryhud.hud.HudElement;
import net.minecraft.client.Minecraft;

public class HudFrameRate extends HudElement {
	public HudFrameRate() {
		prefix = "FPS";
	}
	
	@Override
	public String getValue() {
		return Integer.toString((Minecraft.getDebugFPS()));
	}
}
