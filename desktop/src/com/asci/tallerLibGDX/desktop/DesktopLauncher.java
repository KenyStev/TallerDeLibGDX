package com.asci.tallerLibGDX.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.asci.tallerLibGDX.MyGdxGame;
import com.asci.tallerLibGDX.Dia2.InpusAndCamera;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new InpusAndCamera(), config);
	}
}
