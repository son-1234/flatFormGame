package son.flatformRPG;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.FPSLogger;
import son.flatformRPG.scene.start_Menu;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    public static String LOG = Main.class.getSimpleName();
    /**
     *
     **/
    private SpriteBatch batch;
    private Texture image;



    @Override
    public void create() {
        Gdx.app.log(Main.LOG, "game");//확인용 로그
        //여기서 setscreen을 사용하면 menu나 game으로 이동 가능
        //

        this.setScreen(new start_Menu(this));
    }
    @Override
    public void resize(int widht, int height){
        super.resize(widht, height);
    }
    @Override
    public void render(){
        super.render();

    }
}
