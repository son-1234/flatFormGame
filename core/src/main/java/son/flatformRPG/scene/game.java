package son.flatformRPG.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import son.flatformRPG.Main;
import son.flatformRPG.Player.Player;

public class game extends AbstractScreen {
    private Player player;
    //private Texture image;
    private SpriteBatch batch;
    public game(Main game) {
        super(game);
        batch = new SpriteBatch();
    }
    @Override
    public void show() {

        player = new Player();
        //image = new Texture(Gdx.files.internal("background.png")); // 실제 경로로 변경

    }

    @Override
    public void render(float delta) {
        player.Move(delta);
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        batch.begin();
        //batch.draw(image, 140, 210);
        player.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        //image.dispose();
        player.dispose();
        super.dispose();
    }
}
