package com.asci.tallerLibGDX.Dia2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class InpusAndCamera extends ApplicationAdapter {
	
	/*
	 * Nuestra camara nos va a servir para saber que es lo que se mostrara en la pantalla de nuestro programa
	 * en este caso para juegos 2D usaremos la OrthographicCamera.
	 */
	private OrthographicCamera camera;
	
	private SpriteBatch batch;
	private ShapeRenderer sr;
	private Texture texture;
	
	float width=680, height=680;
	
	@Override
	public void create() {
		super.create();
		
		/*
		 * Inizializamos nuestra camara con el ancho y el alto que tendra nuestro viewport.
		 * 
		 * los metodos Gdx.graphics.getWidth() y Gdx.graphics.getHeight() son metodos que nos
		 * devuelven el ancho y alto respectivamente de la ventana donde esta corriendo nuestra aplicacion 
		 */
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		batch = new SpriteBatch();
		sr = new ShapeRenderer();
		
		texture = new Texture("vehiculos/Car.png");
		
		/*
		 * con setInputProcessor cambiamos el encargado de controlar el procesador de entrada de nuetra app.
		 * en este caso le mandamos un objeto de nuestro procesador de entrada DesktopListener 
		 * con nuestro atributo camara
		 */
		Gdx.input.setInputProcessor(new DesktopListener(this.camera));
	}
	
	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		
		drawPlane();
		
		checkoutControls();
		
		/*
		 * simpre que se le hace una modificacion a nuestra camara debemos darle un update
		 * y como eso pasa casi siempre en la mayoria de los casos, por eso la mandamos a llamar en el render.
		 */
		camera.update();
		
		/*
		 * con setProjectionMatrix se indicamos a nustro spritebatch que matriz va a usar para mostrar los assets
		 * en este caso la matriz combined que tiene la camara para que se mueva junto con la camara.
		 */
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(texture, 100, 100);
		batch.end();
		
		/*
		 * con Gdx.input.isKeyJustPressed verificamos de forma directa si un boton esta siendo presionado.
		 * muy bueno para hacer debugs pero no recomendado para manejar los controladores de nuestro juego.
		 */
		if(Gdx.input.isKeyJustPressed(Keys.B)){
			System.out.println("Fue Presionada B");
		}
		
	}
	
	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		sr.dispose();
		texture.dispose();
	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		camera.setToOrtho(false, width, height);
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
		
		/*
		 * verficamos cual esta siendo presionado y actualizamos la posicion de nuestra camara respectivamente
		 * hacia la derecha, izquierda, arriba ,abajo, aumentarZoom y disminuirZoom.
		 */
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
