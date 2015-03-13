package com.asci.tallerLibGDX.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.asci.tallerLibGDX.MyGdxGame;
import com.asci.tallerLibGDX.Dia1.CargandoRecursos;
import com.asci.tallerLibGDX.Dia2.InpusAndCamera;
import com.asci.tallerLibGDX.Dia3.UsoDeScreens;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=512;
		config.height=512;
		new LwjglApplication(new UsoDeScreens(), config);
	}
}
