package com.asci.tallerLibGDX.Dia3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class PantallaSplash extends AbstractScreen {
	
	private Texture splash;

	public PantallaSplash(UsoDeScreens game) {
		super(game);
		
	}

	@Override
	public void show() {
		splash = new Texture("splash.png");
		Gdx.input.setInputProcessor(new ChangeScreenListener(game, 1));
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		
		game.batch.begin();
		game.batch.draw(splash, 0, 0);
		game.batch.end();
		
		if(Gdx.input.isTouched()){
			game.setScreen(game.MENU_SCREEN);
		}
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void dispose() {
		splash.dispose();
	}

}
