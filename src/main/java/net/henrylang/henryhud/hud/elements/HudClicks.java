package net.henrylang.henryhud.hud.elements;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;

import com.google.gson.stream.JsonReader;

import net.henrylang.henryhud.hud.HudElement;
import net.minecraft.client.Minecraft;

public class HudClicks extends HudElement {
	
	boolean leftDown = false;
	boolean rightDown = false;
	
	ArrayList<Long> left = new ArrayList<Long>();
	ArrayList<Long> right = new ArrayList<Long>();
	
	public HudClicks() {
		needUpdate = true;
		prefix = "Mouse";
	}
	
	@Override
	public void update() {
		final long millis = System.currentTimeMillis();
		
		if(Mouse.isButtonDown(0) && !leftDown) {
			left.add(millis);
		}
		
		if(Mouse.isButtonDown(1) && !rightDown) {
			right.add(millis);
		}
		
		left.removeIf(click -> click + 1000 < millis);
		right.removeIf(click -> click + 1000 < millis);
		
		leftDown = Mouse.isButtonDown(0);
		rightDown = Mouse.isButtonDown(1);
	}
	
	@Override
	public String getValue() {
		return "" + left.size() + " | " + right.size();
	}
}
