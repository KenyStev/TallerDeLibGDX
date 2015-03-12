package com.asci.tallerLibGDX.Dia1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * para poder ejecutar nuestro juego, este debe implementar {@link ApplicationListener} o 
 * heredar de {@link ApplicationAdapter} que ya implementa ApplicationListener, o para controlar
 * multipantalla: heredar de {@link Game} que ya implementa ApplicationListener.
 * @author kenystev
 *
 */
public class CargandoRecursos extends ApplicationAdapter{
	private Texture texture;
	private SpriteBatch batch;
	
	/**
	 * en este metodo create es donde inizializamos nuestros recursos ya que solo se llama
	 * la primera vez que se corre el programa o en su defecto la pantalla.
	 */
	@Override
	public void create() {
		super.create();
		
		/*
		 * el SpriteBatch es el que nos va a ayudar a dibujar texturas en nuestra pantala
		 * utilizando cualquiera de los metodos 'draw' que nos ofrece SpriteBatch
		 */
		batch = new SpriteBatch();
		
		/*
		 * para cargar una textura (Imagen .png o .jpg) esta debe estar dentro de la carpta assets
		 * del proyecto de android, y si esta dentro de otra carpeta dentro de dicha carpeta, entonces debe indicarse
		 * como en este ejemplo: vehiculos/Car.png
		 */
		texture = new Texture("vehiculos/Car.png");
	}
	
	/**
	 * en el metodo render es donde se estara actualizando nuestro juego.
	 * asi que aqui es donde pondremos nuestra logica del juego
	 */
	@Override
	public void render() {
		/*
		 * con estos dos metodos limpiamos la pantalla
		 */
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		
		/*
		 * siempre que vallamos a dibujar algo usando el metodo draw de nuestro spritbatch
		 * este debe estar dentro de batch.begin(); y batch.end();
		 */
		batch.begin();
		batch.draw(texture, 100, 100);
		batch.end();
	}
	
	/**
	 * Dispose es un metodo para liberar recursos del GPU y la ram
	 */
	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		texture.dispose();
	}
	
	/**
	 * resize se llama automaticamente cada vez que nuestra ventana del juego cambia sus dimensiones
	 */
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

}
