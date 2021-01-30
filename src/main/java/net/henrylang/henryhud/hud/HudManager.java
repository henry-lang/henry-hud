package net.henrylang.henryhud.hud;

import java.util.ArrayList;

import net.henrylang.henryhud.hud.elements.*;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HudManager {
	public static String seperatorColor = EnumChatFormatting.WHITE.toString();
	public static String mainColor = EnumChatFormatting.WHITE.toString();
	public static String highlightColor = EnumChatFormatting.GOLD.toString();
	
	public static char openSeperator = '[';
	public static char closeSeperator = ']';
	
	public static int sidePadding = 5;
	public static int sepPadding = 10;
	
	static ArrayList<HudElement> elements = new ArrayList<HudElement>();
	
	public static void populateElements() {
		elements.add(new HudTitle("Henry's Hud"));
		elements.add(new HudSpacing());
		elements.add(new HudFrameRate());
		elements.add(new HudClicks());
		elements.add(new HudFacing());
	}
	
	@SubscribeEvent
	public void onRenderEvent(RenderGameOverlayEvent.Text event) {
		for(int i = 0; i < elements.size(); i++) {
			HudElement element = elements.get(i);
			
			if(element.needUpdate) element.update();
			
			String prefixText;
			if(element.prefix == null) prefixText = "";
			else prefixText = seperatorColor + openSeperator + highlightColor + element.prefix + seperatorColor + closeSeperator + " ";
			
			String valueText = mainColor + element.getValue();
			
			Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(prefixText + valueText, sidePadding, sidePadding + 10 * i, 0xffffff);
		}
	}
}
