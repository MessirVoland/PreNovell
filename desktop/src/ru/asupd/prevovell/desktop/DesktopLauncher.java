package ru.asupd.prevovell.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

import ru.asupd.prevovell.PreNovell;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height=PreNovell.HEIGHT;
		config.width=PreNovell.WIDTH;
		config.title=PreNovell.TITLE;
	//	TexturePacker.process("input_folder","Output_folder","atlas_first");
		new LwjglApplication(new PreNovell(), config);
	}
}
