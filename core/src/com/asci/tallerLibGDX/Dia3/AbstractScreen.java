package com.asci.tallerLibGDX.Dia3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Esta es una clase abstracta que nos servira como un puente entre nuestra clase principal {@link UsoDeScreens} y 
 * nuestras pantallas ya que con nuestro atrubuto {@code game} vamos a tener referencia a todas nuestras pantallas 
 * y asi poder movernos a travez de ellas.
 * debe implementar de Screen porque el metodo setScreen lo que recibe es un objeto de dicha interfaz
 * @author kenystev
 */
public abstract class AbstractScreen implements Screen {
	
	/*
	 * tenemos un atributo de nuestra clase principal con el identificador protected para poder heredarlo en las pantallas
	 * que ya esten definidas como PantallaGame, PantallaMenu y PantallaSplash ya que por medio deeste atributo llamaremos
	 * al metodo setScreen a la hora que necesitemos cambiar de pantalla.
	 */
	protected UsoDeScreens game;
	
	/*
	 * Igual con la camara la declaramos aqui para tenerla disponible 
	 * en todas las clases que hereden de AbstractScreen
	 */
	protected OrthographicCamera camera;

	public AbstractScreen(UsoDeScreens game) {
		this.game=game;
		camera = new OrthographicCamera();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(.5f, 0, 0, 1);	
		
		camera.update();
	}

	@Override
	public void resize(int width, int height) {
		camera.setToOrtho(false, width, height);
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

}
