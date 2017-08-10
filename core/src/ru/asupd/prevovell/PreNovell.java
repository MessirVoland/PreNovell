package ru.asupd.prevovell;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import ru.asupd.prevovell.states.GameStateManager;
import ru.asupd.prevovell.states.MenuState;

public class PreNovell extends ApplicationAdapter {
	Texture img;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 480;

//	public static final int WIDTH = 1280;
//	public static final int HEIGHT = 1024;

	public static final String TITLE = "Novell";
	private GameStateManager gsm;
	private SpriteBatch batch;
//	final String FONT_CHARS = "абвгдежзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
//	BitmapFont font1;

	@Override
	public void create () {
		/*batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		//Gdx.files.internal("font.ttf");
		final String FONT_PATH = "a_OldTyperNr.ttf";
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(FONT_PATH));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.characters = FONT_CHARS;
		parameter.size = 15;
		parameter.color = Color.BLACK;
		font1 = generator.generateFont(parameter);
		generator.dispose();*/
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));
	}



	@Override
	public void render () {
		/*Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		font1.draw(batch, "First font! фыва фыва жождлолдо джллож лол жо ", 50, 350);
		batch.draw(img, 0, 0);
		batch.end();*/
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
