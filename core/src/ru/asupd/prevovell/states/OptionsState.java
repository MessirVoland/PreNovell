package ru.asupd.prevovell.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import ru.asupd.prevovell.PreNovell;
import sun.rmi.runtime.Log;
import sun.security.action.OpenFileInputStreamAction;

/**
 * Created by Asup.D on 04.07.2016.
 */
public class OptionsState extends State {
    TextButton button_back,button_test;
    Stage stage2;
    BitmapFont font2;



    public OptionsState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false,800,480);
        stage2 = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage2);
        font2= new BitmapFont();

        TextButton.TextButtonStyle style_Button_Sec;
        style_Button_Sec = new TextButton.TextButtonStyle(null,null,null,font2);
        style_Button_Sec.downFontColor= Color.BLUE;
        style_Button_Sec.fontColor=Color.WHITE;
        TextButton.TextButtonStyle style_Button_Sec2;

        style_Button_Sec2 = new TextButton.TextButtonStyle(null,null,null,font2);
        style_Button_Sec2.downFontColor= Color.BLUE;
        style_Button_Sec2.fontColor=Color.WHITE;

        button_back = new TextButton("BACK",style_Button_Sec);
        button_back.setPosition(PreNovell.WIDTH/2-button_back.getWidth()/2,PreNovell.HEIGHT/2+button_back.getHeight());
        button_back.setWidth(780);
        stage2.addActor(button_back);

        button_test = new TextButton("Test",style_Button_Sec2);
        button_test.setPosition(PreNovell.WIDTH/2-button_test.getWidth()/2,PreNovell.HEIGHT/2-button_test.getHeight());
        button_test.setWidth(780);
        stage2.addActor(button_test);


        button_back.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Button Back Just toched");


                return super.touchDown(event, x, y, pointer, button);

            }
        });
        button_test.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Button Test Just toched");

                boolean isExtAvailable = Gdx.files.isExternalStorageAvailable();
                boolean isLocAvailable = Gdx.files.isLocalStorageAvailable();

                String extRoot = Gdx.files.getExternalStoragePath();
                String locRoot = Gdx.files.getLocalStoragePath();

                FileHandle handle = Gdx.files.internal("data/test.txt");

                String text = handle.readString();
                System.out.println(text);


                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    @Override
    protected void handleInput() {


    }

    @Override
    public void update(float dt) {

    }


    public void onBack_Pressed(){
        gsm.set(new MenuState(gsm));
    }

    @Override
    public void render(SpriteBatch sb) {
        camera.setToOrtho(false,800,480);
        sb.setProjectionMatrix(camera.combined);
        sb.begin();

        sb.end();
        stage2.draw();

    }

    @Override
    public void dispose() {

    }
}
