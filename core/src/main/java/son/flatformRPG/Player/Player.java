package son.flatformRPG.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input;
    public class    Player {
    private final Texture texture;
    private float x, y;
    private float speed = 300f; // 초당 200 픽셀 이동
    private float speed_Shift = 300f;

    //6월 12일 추가 중력 코드
    private float speed_y;//플레이어 떨어지는 속도
    private final float gravity_y=-1000f;// 중력 가속도

    private final float ground =100f;//임시 바닥 -> 디버깅용



    public Player() {
        texture = new Texture("player.png"); // assets/player.png 필요
        x = 100;
        y = 100;
    }

    public void Move(float delta) {//delta-> 프레임 간 시간 ->libGdx 가 자동으로ㅓ 계산함

        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)&&Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x -= speed_Shift * delta;
        }if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)&&Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x += speed_Shift * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x -= speed * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x += speed * delta;
        }
        // 점프 (스페이스바)
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && isOnGround()) {
            speed_y = 400f; // 점프 속도
        }

        //중력 작용 처리
        speed_y += gravity_y * delta;//프레임당 떨어지는 속도를 곱한거
        y+= speed_y * delta;//떨어지는 속도를 플레이어 ycnr에 대입

        if (y < ground) {
            y = ground;
            speed_y = 0;
        }

    }
    private boolean isOnGround() {
        return y <= ground;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }

    public void dispose() {
        texture.dispose();
    }
}
