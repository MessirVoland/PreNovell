package ru.asupd.prevovell.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import javafx.scene.web.WebView;
import ru.asupd.prevovell.PreNovell;

/**
 * Created by Asup.D on 20.06.2016.
 */
public class PlayState extends State {
    private Texture bg_1,bg_2,text_Start;
    BitmapFont font;
    GlyphLayout glyphLayout;
    Color clr2;

    Stage stage2;
    TextButton button_select_1,button_select_2;


  //  BitmapFont font1;
    private String active_Text;
    String text;
    private  int changer;
    int waiter,sizeofw;
 //   private float maxFrameTime;
    private float currentFrameTime;
    boolean not_all;


    public PlayState(GameStateManager gsm) {
        super(gsm);

        camera.setToOrtho(false,800,480);

        stage2 = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage2);


        bg_1=new Texture("bg_1.jpg");
        bg_2=new Texture("bg_2.jpg");
        text_Start=new Texture("text_start.png");
        font = new BitmapFont();
        glyphLayout = new GlyphLayout();


        final String FONT_CHARS = "абвгдежзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
        final String FONT_PATH = "a_OldTyperNr.ttf";
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(FONT_PATH));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = FONT_CHARS;
        parameter.size = 20;
        parameter.color = Color.WHITE;
        waiter = 0;
        currentFrameTime=0;

        font = generator.generateFont(parameter);
        generator.dispose();
        changer=0;
        not_all=true;
        active_Text="- Прочь с дороги, старик. \n" +
                "- Не злись, воин. Быть может, ты захочешь услышать то, что я скажу. \n" +
                "- Очередной безумный пророк, предрекающий погибель мира? \n" +
                "- Нет, лишь уставший странник. ";
    //    glyphLayout.setText(font,active_Text,Color.WHITE,780,Align.bottomLeft,true);

    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){
            waiter = 0;
            System.out.println("Just toched");
            if (not_all){not_all=false;}else {
                changer++;
                not_all=true;
            }
            if (changer==1){
              //  TextButton buttonSec,buttonSec2;
                TextButton.TextButtonStyle style_Button_Sec,style_Button_Sec2;
                BitmapFont font2= new BitmapFont();
                //font.setColor(Color.BLUE);
                style_Button_Sec = new TextButton.TextButtonStyle(null,null,null,font);
                style_Button_Sec2 = new TextButton.TextButtonStyle(null,null,null,font);
                style_Button_Sec.fontColor=Color.BLUE;
                style_Button_Sec.downFontColor=Color.GOLD;
                style_Button_Sec2.fontColor=Color.RED;
                style_Button_Sec2.downFontColor=Color.GOLD;


                button_select_1 = new TextButton("1) Ну что же, говори.",style_Button_Sec);
                button_select_2 = new TextButton("2) Меня не интересуют фальшивые предсказания. ",style_Button_Sec2);
                button_select_1.setTransform(true);
                button_select_2.setTransform(true);
                button_select_1.setPosition(PreNovell.WIDTH/2-button_select_2.getWidth()/2,PreNovell.HEIGHT/2+button_select_1.getHeight());
                button_select_2.setWidth(780);
                button_select_2.setPosition(PreNovell.WIDTH/2-button_select_2.getWidth()/2,PreNovell.HEIGHT/2-button_select_2.getHeight());
                stage2.addActor(button_select_1);
                button_select_1.addListener(new InputListener(){
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        System.out.println("Button 1 Just toched");
                        return super.touchDown(event, x, y, pointer, button);
                    }

                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                        super.touchUp(event, x, y, pointer, button);
                    }
                });
                button_select_2.addListener(new InputListener(){
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        System.out.println("Button 2 Just toched");
                        changer++;
                        return super.touchDown(event, x, y, pointer, button);
                    }

                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                        super.touchUp(event, x, y, pointer, button);
                    }
                });


                stage2.addActor(button_select_2);


                active_Text="" +
                            "";
              //  glyphLayout.setText(font,active_Text,Color.WHITE,780,Align.bottomLeft,true);

             }else
            if (changer==2){
                bg_1=bg_2;
               /* active_Text="- Многие преклоняются пред тобой, великий полководец. Воин и \n" +
                            "чародей, вестник крови и смерти. Проклятый и ненавидимый, ты\n" +
                            "лишишься всего. Никчёмная игрушка в руках того, кто мнит себя\n" +
                            "божеством, ты станешь первым из падших. Остановись, пока не \n" +
                            "поздно. Остановись и пойми, что ты лишь клинок в руках человека,\n" +
                            "поправшего законы мироздания.\n ";
                            */


                active_Text="- Многие преклоняются пред тобой, великий полководец. Воин и " +
                        "чародей, вестник крови и смерти. Проклятый и ненавидимый, ты" +
                        " лишишься всего. Никчёмная игрушка в руках того, кто мнит себя" +
                        " божеством, ты станешь первым из падших. Остановись, пока не " +
                        "поздно. Остановись и пойми, что ты лишь клинок в руках человека," +
                        " поправшего законы мироздания.";
                button_select_1.remove();
                button_select_2.remove();

             //   text = active_Text.substring(0,waiter);


                glyphLayout.setText(font,text,Color.WHITE,780, Align.bottomLeft,true);

            }else
            if (changer>=3){
                active_Text="Данный текст говорит о том что в программе текста больше не заложено";
                button_select_1.remove();
                button_select_2.remove();
                Color clr=Color.RED;
                glyphLayout.setText(font, active_Text,clr  ,780,Align.bottomLeft,true);
            }
        }
    }

    @Override
    public void update(float dt) {
        //  camera.update();
        currentFrameTime+=dt;
        if (not_all){
            if (currentFrameTime>0.025f){
                waiter++;
                currentFrameTime = 0;
              //  if (waiter-5<active_Text.length()) {
               //     waiter = active_Text.length() - 1;}

            }
            sizeofw=active_Text.length();
            if (waiter>=sizeofw){
                waiter=sizeofw;
                not_all=false;
            }
        }else{
            sizeofw=active_Text.length();
            waiter=sizeofw;
        }

        text = active_Text.substring(0, waiter);

       // clr2.set(1.0f,1.0f,1.0f,0.5f);

        Color clr=Color.RED;
        clr.set(1.0f,1.0f,1.0f,0.25f);

        glyphLayout.setText(font, text, clr, 780, Align.bottomLeft, true);

        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        camera.setToOrtho(false,800,480);
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        // sb.draw(text_Start,camera.position.x-text_Start.getWidth()/2,camera.position.y-text_Start.getHeight()/2+50);
        sb.draw(bg_1,0,480/2-bg_1.getHeight()/2);

        camera.setToOrtho(false,800,480);
        sb.setProjectionMatrix(camera.combined);
       // font.draw(sb,active_Text,25,150);
        font.draw(sb,glyphLayout,10,150);

        sb.end();
        stage2.draw();

    }

    @Override
    public void dispose() {
        font.dispose();
        bg_1.dispose();
        bg_2.dispose();

    }
}
