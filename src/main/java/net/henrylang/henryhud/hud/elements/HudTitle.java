package net.henrylang.henryhud.hud.elements;

import net.henrylang.henryhud.hud.HudElement;

public class HudTitle extends HudElement {
	public HudTitle(String title) {
		prefix = title;
	}
	
	@Override
	public String getValue() {
		return "";
	}
}
