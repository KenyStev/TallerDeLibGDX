package com.asci.tallerLibGDX.Dia3;

import sun.font.TextLabel;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Este es un listener que nos sirve para controlar los eventos de los elementos de Scene2D y los de InputProcessor
 * para otro tipo de elementos como {@link Actor} y hasta el mismo {@link ApplicationAdapter} y {@link Game}.
 * los metodos que reciben de parametro un {@link InputEvent} son los que nos ayudaran para los elementos de Scene2D como
 * {@link TextButton}, {@link TextLabel}, {@link Table} etc y los que no los tengan nos serviran para las otras, 
 * esta forma de diferenciar es porque se llaman casi similar algunos metodos. 
 * @author kenystev
 *
 */
public class ChangeScreenListener extends InputListener  implements InputProcessor{
	private UsoDeScreens game;
	private int toChange;

	public ChangeScreenListener(UsoDeScreens game, int tChange) {
		this.game=game;
		toChange=tChange;
	}

	@Override
	public boolean keyDown(int keycode) {
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch(toChange){
		case -1: Gdx.app.exit();break;
		case 1: game.setScreen(UsoDeScreens.MENU_SCREEN);break;
		case 2: game.setScreen(UsoDeScreens.GAME_SCREEN);break;
		}
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		return false;
	}
	
	@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer,
			int button) {
		
		return true;
	}
	
	@Override
	public void touchUp(InputEvent event, float x, float y, int pointer,
			int button) {
		switch(toChange){
		case -1: Gdx.app.exit();break;
		case 1: game.setScreen(UsoDeScreens.MENU_SCREEN);break;
		case 2: game.setScreen(UsoDeScreens.GAME_SCREEN);break;
		}
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
			
		return true;
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
