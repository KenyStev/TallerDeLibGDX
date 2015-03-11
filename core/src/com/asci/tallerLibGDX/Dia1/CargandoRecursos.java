package com.asci.tallerLibGDX.Dia1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CargandoRecursos extends ApplicationAdapter{
	private Texture texture;
	private SpriteBatch batch;
	
	@Override
	public void create() {
		super.create();
		batch = new SpriteBatch();
		texture = new Texture("Car.png");
	}
	
	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		
		batch.begin();
		batch.draw(texture, 100, 100);
		batch.end();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		texture.dispose();
	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

}
