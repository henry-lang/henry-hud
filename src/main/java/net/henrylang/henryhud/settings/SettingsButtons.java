package net.henrylang.henryhud.settings;

public enum SettingsButtons {
	SKIN_CUSTOMIZATION_VANILLA (110),
	OPEN_SETTINGS (300),
	ACCENT_COLOR (301),
	DONE (302);
	
	
	public final int id;
	
	SettingsButtons(int id) {
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
}
