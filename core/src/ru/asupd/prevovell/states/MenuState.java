package ru.asupd.prevovell.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


import ru.asupd.prevovell.PreNovell;

/**
 * Created by Asup.D on 20.06.2016.
 */
public class MenuState extends State {
    // SpriteBatch batch;
    private Texture text_Load,text_Donate,text_Options;
    private Texture text_Start,text_Save,man,carr,fish,carr2,fish2;

    ///Для Кнопки
    public static TextureAtlas texaGraphics;
    public static Skin skinUI,skinUI2;
    public static ImageButton.ImageButtonStyle style_Button_Start,style_Button_Load,style_Button_Donate,style_Button_Options;
    //уровень
    Stage stage;
    private ImageButton	button_Start,button_Load,button_Donate,button_Options;


    public MenuState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, PreNovell.WIDTH,PreNovell.HEIGHT);

   //     text_Start=new Texture("text_start.png");
        text_Save=new Texture("hero_1.png");
   //     text_Load=new Texture("text_load.png");
   //     text_Options = new Texture("text_options.png");
   //     text_Donate = new Texture("text_donate.png");

        man=new Texture("test_0/man.png");
        //уровень
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        //кнопка

    //   texaGraphics = new TextureAtlas("output_folder/atlas_first.atlas");
      //  texaGraphics = new TextureAtlas("button_cross_0.png");
      //  texaGraphics = Assets.manager.get("mainmenu/mainMenu.atlas", TextureAtlas.class);//если есть менеджер ассетов
        // - загрузите ваш атлас с изображениями
      //  skinUI = new Skin();
      //  skinUI.addRegions(texaGraphics);

/*
        style_Button_Start = new ImageButton.ImageButtonStyle();
       // style_Button_Start.up = skinUI.getDrawable("button_go_0");
       // style_Button_Start.down = skinUI.getDrawable("button_go_1");
        carr= new Texture("text_start.png");
        fish=new Texture("fish.png");
        style_Button_Start.up = new TextureRegionDrawable(new TextureRegion(carr)) ;
        style_Button_Start.down = new TextureRegionDrawable(new TextureRegion(fish)) ;
        button_Start = new ImageButton(style_Button_Start);
        button_Start.setPosition(10,PreNovell.HEIGHT-150);
        button_Start.setTransform(true);
        button_Start.setScale(0.3f,0.3f);*/
/*
        style_Button_Load = new ImageButton.ImageButtonStyle();
        carr2= new Texture("text_load.png");
        fish2=new Texture("carrot.png");
        style_Button_Load.up = new TextureRegionDrawable(new TextureRegion(carr2)) ;
        style_Button_Load.down = new TextureRegionDrawable(new TextureRegion(fish2)) ;
        button_Load = new ImageButton(style_Button_Load);
        button_Load.setPosition(10,PreNovell.HEIGHT-250);
        button_Load.setTransform(true);
        button_Load.setScale(0.3f,0.3f);

        style_Button_Options = new ImageButton.ImageButtonStyle();
        carr2= new Texture("text_options.png");
        fish2=new Texture("carrot.png");
        style_Button_Options.up = new TextureRegionDrawable(new TextureRegion(carr2)) ;
        style_Button_Options.down = new TextureRegionDrawable(new TextureRegion(fish2)) ;
        button_Options = new ImageButton(style_Button_Options);
        button_Options.setPosition(10,PreNovell.HEIGHT-350);
        button_Options.setTransform(true);
        button_Options.setScale(0.3f,0.3f);

        style_Button_Donate = new ImageButton.ImageButtonStyle();
        carr2= new Texture("text_donate.png");
        fish2=new Texture("carrot.png");
        style_Button_Donate.up = new TextureRegionDrawable(new TextureRegion(carr2)) ;
        style_Button_Donate.down = new TextureRegionDrawable(new TextureRegion(fish2)) ;
        button_Donate = new ImageButton(style_Button_Donate);
        button_Donate.setPosition(10,PreNovell.HEIGHT-450);
        button_Donate.setTransform(true);
        button_Donate.setScale(0.3f,0.3f);
        */
       // carr2= new Texture("text_donate.png");
       // fish2=new Texture("carrot.png");

        button_Start=create_button("text_start.png","fish.png",3);
        stage.addActor(button_Start);

        stage.addActor(create_button("text_load.png","carrot.png",2));

        button_Options=create_button("text_options.png","carrot.png",1);
        stage.addActor(button_Options);

        stage.addActor(create_button("text_donate.png","carrot.png",0));


        button_Start.addListener(new InputListener()
        {

            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button)
            {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button)
            {
                onStartPress();
            }

        });
        button_Options.addListener(new InputListener()
        {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button)
            {
                return true;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button)
            {
                onOptionsPress();
            }
        });
                //  stage.addActor(button_Start);
      //  stage.addActor(button_Load);
      //  stage.addActor(button_Options);
       // stage.addActor(button_Donate);
       // stage.addActor(text_Start);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){
          //  gsm.set(new PlayState(gsm));
        }

    }
    protected void act_game(){
        gsm.set(new PlayState(gsm));
    }

    public void onStartPress(){
        System.out.println("Just right");
        act_game();
    }
    public void onOptionsPress(){
        gsm.set(new OptionsState(gsm));
        System.out.println("Just Options pressed");

    }

    @Override
    public void update(float dt) {
        stage.act(dt);
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        camera.setToOrtho(false,800,480);
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
      //  sb.draw(stage.getBatch());

       // stage.getBatch();
     //   sb.draw(text_Start,camera.position.x-text_Start.getWidth()/2-125,camera.position.y-text_Start.getHeight()/2+25);
        sb.draw(text_Save,camera.position.x-text_Save.getWidth()/2-125,camera.position.y-text_Save.getHeight()/2-175);
        sb.draw(man,camera.position.x-man.getWidth()/2+250,camera.position.y-man.getHeight()/2-25);

        sb.end();
        stage.draw();
    }
    public ImageButton create_button(String text_up,String text_down,int position_Y){
        ImageButton button;
        ImageButton.ImageButtonStyle style_Button;

        TextButton buttonSec;
        TextButton.ButtonStyle style_Button_Sec;

       // camera.setToOrtho(false,PreNovell.WIDTH,PreNovell.HEIGHT);


        style_Button = new ImageButton.ImageButtonStyle();
        Texture up= new Texture(text_up);
        Texture down=new Texture(text_down);
        style_Button.up = new TextureRegionDrawable(new TextureRegion(up)) ;
        style_Button.down = new TextureRegionDrawable(new TextureRegion(down)) ;

      //  NinePatch patch = new NinePatch(new Texture(Gdx.files.internal("knob.png")), 12, 12, 12, 12);
        // Создание нового TextButtonStyle
    //   TextButtonStyle style = new TextButtonStyle(patch, patch, patch, 0, 0, 0, 0, new BitmapFont(), new Color(0.3f, 0.2f, 0.8f, 1f), new Color(0, 0, 0, 1f), new Color(0, 0, 0, 1f));
      //  style_Button_Sec=new TextButton.TextButtonStyle(patch,patch,pa);

        button = new ImageButton(style_Button);
        button.setPosition(10,(PreNovell.HEIGHT/4-10)*position_Y);
        button.setTransform(true);
        button.setSize(PreNovell.WIDTH/4,PreNovell.HEIGHT/4-10);
       // button.setScale(0.3f,0.3f);
        return  button;
    }

    @Override
    public void dispose() {
        stage.dispose();
        text_Save.dispose();
        man.dispose();
        System.out.println("All disposed");
    }
}
