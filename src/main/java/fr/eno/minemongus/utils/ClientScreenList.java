package fr.eno.minemongus.utils;

import java.util.Arrays;
import java.util.List;

import fr.eno.minemongus.screen.DownloadScreen;
import net.minecraft.client.gui.screen.Screen;

public class ClientScreenList
{
	private static final Screen DOWNLOAD_SCREEN = new DownloadScreen();
	private static final List<Screen> SCREENS = Arrays.asList(DOWNLOAD_SCREEN);
	
	public static final Screen getScreen(long screenId)
	{
		return screenId > SCREENS.size() - 1 ? SCREENS.get(0) : SCREENS.get(Long.valueOf(screenId).intValue());
	}
}
