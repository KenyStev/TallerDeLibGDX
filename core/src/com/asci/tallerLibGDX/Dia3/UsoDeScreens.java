package com.asci.tallerLibGDX.Dia3;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Esta es la Clase principal de nuestro juego. es la clase que el proyecto DesktopLauncher va a ejecutar
 * hereda de {@link Game} porque Game nos provee un metodo especial llamado setScren que es para cambiar de pantalla.
 * este metodo recibe un objeto de la Interfaz Screen.
 * @author kenystev
 *
 */
public class UsoDeScreens extends Game{
	public SpriteBatch batch;
	
	/*
	 * Skin es como una configuracion de estilos para la parte de la Scene2D de la Lib.
	 */
	public Skin skin;
	
	/*
	 * estas seran las que va a controlar nuestro juego
	 * MENU_SCREEN es la pantalla del menu
	 * GAME_SCREEN es la pantalla donde ira toda la logica del juego
	 * SPLASH_SCREEN es una simple pantalla que muestra una imagen splash al iniciar el juego
	 * inicializamos las tres en el constructor, son static para poder accederlas desde cualquier parte de nuestro juegoS
	 * como desde las pantallas
	 */
	public static AbstractScreen MENU_SCREEN, GAME_SCREEN, SPLASH_SCREEN;
	
	public UsoDeScreens() {
		SPLASH_SCREEN = new PantallaSplash(this);
		MENU_SCREEN = new PantallaMenu(this);
		GAME_SCREEN = new PantallaGame(this);
	}

	@Override
	public void create() {
		batch = new SpriteBatch();
		skin = new Skin(Gdx.files.internal("Skin/uiskin.json"));
		
		/*
		 * cuando el juego se crea, mandamos a llamar la primer pantalla que es la de splash
		 */
		setScreen(SPLASH_SCREEN);
	}
	
	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
	}
}
