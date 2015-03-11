package com.asci.tallerLibGDX.Dia2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class InpusAndCamera extends ApplicationAdapter{
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private ShapeRenderer sr;
	
	float width=680, height=680;
	
	@Override
	public void create() {
		super.create();
		
		batch = new SpriteBatch();
		camera = new OrthographicCamera(width, height);
		sr = new ShapeRenderer();
	}
	
	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		
		drawPlane();
		
		checkoutControls();
		
		camera.update();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		sr.dispose();
	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		camera.setToOrtho(false, this.width, this.height);
	}
	
	/**
	 * Valida las Entradas del Teclado
	 */
	public void checkoutControls(){
		int move = 2;
		
		boolean Up = Gdx.input.isKeyPressed(Keys.W) || Gdx.input.isKeyPressed(Keys.UP);
		boolean Down = Gdx.input.isKeyPressed(Keys.S) || Gdx.input.isKeyPressed(Keys.DOWN);
		boolean Left = Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.LEFT);
		boolean Right = Gdx.input.isKeyPressed(Keys.D) || Gdx.input.isKeyPressed(Keys.RIGHT);
		
		if (Left && !Right) {
			camera.translate(-move, 0);
		}
		if (Right && !Left) {
			camera.translate(move, 0);
		}
		
		if (Up && !Down) {
			camera.translate(0, move);
		}
		if (Down && !Up) {
			camera.translate(0, -move);
		}
		
		if(Gdx.input.isKeyPressed(Keys.Z)){
			camera.zoom-=0.02;
		}
		if (Gdx.input.isKeyPressed(Keys.Q)) {
			camera.zoom+=0.02;
		}
	}
	
	private void drawPlane(){
		int start = -200, end = 200;
		
		sr.setProjectionMatrix(camera.combined);
		
		sr.begin(ShapeType.Line);
		sr.line(start, 0, end, 0);
		sr.line(0, start, 0, end);
		for (int x = start; x < end; x+=10) {
			sr.line(x, -10, x, 10);
			sr.line(-10, x, 10, x);
		}
		sr.end();
	}

}
