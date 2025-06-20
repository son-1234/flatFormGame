package son.flatformRPG.scene;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import son.flatformRPG.Main;


public abstract class AbstractScreen implements Screen {
    protected Main game;

    public AbstractScreen(Main game) {
        this.game = game;
    }

    public AbstractScreen() {
        this.game = game;
    }

    /**
     * 해당 클래스 이름 스트링으로 반환하는 함수
     */
    protected String getName() {
        return getClass().getSimpleName();
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log(Main.LOG, "size " + getName() + " 이 " + width
            + " x " + height);
    }

    @Override
    public void show() {
        Gdx.app.log(Main.LOG, "show screen: " + getName());
    }

    @Override
    public void hide() {
        Gdx.app.log(Main.LOG, "hide screen: " + getName());
    }

    @Override
    public void pause() {
        Gdx.app.log(Main.LOG, "pause screen: " + getName());
    }

    @Override
    public void resume() {
        Gdx.app.log(Main.LOG, "resume screen: " + getName());
    }

    @Override
    public void dispose() {
        Gdx.app.log(Main.LOG, "dispose screen: " + getName());
    }
}
