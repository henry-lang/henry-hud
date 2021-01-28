package net.henrylang.henryhud.hud.elements;

import net.henrylang.henryhud.hud.HudElement;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumFacing;

public class HudFacing extends HudElement {
	public HudFacing() {
		prefix = "Facing";
	}
	
	@Override
	public String getValue() {
		String dir;
		EnumFacing rot = Minecraft.getMinecraft().thePlayer.getHorizontalFacing();
		
		if(rot == EnumFacing.NORTH) {
			return "North (-Z)";
		}
		if(rot == EnumFacing.SOUTH) {
			return "South (+Z)";
		}
		if(rot == EnumFacing.EAST) {
			return "East (+X)";
		}
		if(rot == EnumFacing.WEST) {
			return "West (-X)";
		}
		
		return "Unknown (?)";
	}
}
