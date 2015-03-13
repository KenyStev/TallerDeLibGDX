package com.asci.tallerLibGDX.Dia3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class PantallaMenu extends AbstractScreen {
	
	private Stage stage;
	private TextButton btnPlay, btnExit;
	private Table table;

	public PantallaMenu(UsoDeScreens game) {
		super(game);
		
	}

	@Override
	public void show() {
		stage = new Stage(new FitViewport(512, 512, camera), game.batch);
		stage.getViewport().update(512, 512);
		Gdx.input.setInputProcessor(stage);
		
		table = new Table().center().pad(20);
		table.setFillParent(true);
		
		btnPlay = new TextButton("Play",game.skin);
		btnPlay.addListener(new ChangeScreenListener(game, 2));
		btnExit = new TextButton("Exit", game.skin);
		btnExit.addListener(new ChangeScreenListener(game, -1));
		
		table.add(btnPlay);
		table.add(btnExit);
		stage.addActor(table);
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		
		game.batch.begin();
//		table.draw(game.batch, 1);
		game.batch.end();
		
		stage.act();
		stage.draw();
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void dispose() {
		stage.dispose();
	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		stage.getViewport().update(512, 512);
	}

}
