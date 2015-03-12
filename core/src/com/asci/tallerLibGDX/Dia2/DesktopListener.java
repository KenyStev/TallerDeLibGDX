package com.asci.tallerLibGDX.Dia2;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector3;

/**
 * Esta clase es la forma recomendada para validar entradar del teclado y controlar eventos.
 * ya que no se esta validando constantemente en nuestro programa sino que esta esperando a que un evento se active.
 * 
 * no ofrece varios metodos dependiendo el tipo de evento que queremos verificar.
 * existen otros tipos de Listeners como {@link GestureListener} para eventos espaciales para movil	
 * @author kenystev
 *
 */
public class DesktopListener implements InputProcessor{

	OrthographicCamera camera;
	
	public DesktopListener(OrthographicCamera camera) {
		this.camera = camera;
	}

	@Override
	public boolean keyDown(int keycode) {
		if(keycode==Keys.SPACE)
			System.out.println("Hola Mundo by Listener Space");
		if(keycode==Keys.M)
			System.out.println("Hola Mundo by Listener M");
		if(keycode==Keys.P)
			System.out.println("Hola Mundo by Listener P");
		
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		System.out.println("X: " + screenX + " Y: " + screenY);
		Vector3 v3 = new Vector3(screenX, screenY, 0);
		camera.unproject(v3);
		
		System.out.println("Unprojected: " + "X: " + v3.x + "  Y: " + v3.y);
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		
		return false;
	}

}
