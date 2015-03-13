package com.asci.tallerLibGDX.Dia3;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
/**
 * Esta es la clase donde ira toda la logica de juego de nuestro juego
 * @author kenystev
 *
 */
public class PantallaGame extends AbstractScreen implements InputProcessor{

	private ArrayList<Sprite> balls;
	
	public PantallaGame(UsoDeScreens game) {
		super(game);
		
	}

	@Override
	public void show() {
		balls = new ArrayList<Sprite>();
		Gdx.input.setInputProcessor(this);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		drawBalls();
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void dispose() {
		
	}
	
	public void winer(int x, int y){
		System.out.println("Balls: "+balls.size());
		for (Sprite b : balls) {
			double dis = Math.sqrt(Math.pow(x-b.getX(), 2) + Math.pow(y-b.getY(), 2));
			System.out.println("Distance: "+dis);
			if(dis<64){
				game.setScreen(game.MENU_SCREEN);
			}
		}
	}
	
	private void drawBalls(){
		game.batch.setProjectionMatrix(camera.combined);
		game.batch.begin();
		
		for (Sprite ball : balls) {
			ball.draw(game.batch);
		}
		game.batch.end();
	}
	
	private void creatBall(int x, int y){
		Vector3 v3 = new Vector3(x, y, 0);
		camera.unproject(v3);
		
		Sprite ball = new Sprite(new Texture("Poke-Ball.png"));
		ball.setBounds(v3.x-32, v3.y-32, 64, 64);
		winer(x, y);
		balls.add(ball);
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		creatBall(screenX, screenY);
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
