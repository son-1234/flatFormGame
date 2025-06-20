package son.flatformRPG.scene;

import com.badlogic.gdx.Gdx;                            //libGdx의 시스템 쿨랴스 입출력 해상동 같은거 다룸
import com.badlogic.gdx.InputAdapter;                   //사용자의 입력을 다루는 어쩌구
import com.badlogic.gdx.math.Rectangle;              // 사각형 영역을 나타내는 클래스 (충돌 체크 등에 사용)
import com.badlogic.gdx.graphics.Texture;               //딱봐도 텍스쳐 다루는거지 비융신아
import com.badlogic.gdx.graphics.g2d.SpriteBatch;       //2d그래픽 불러오는거
import com.badlogic.gdx.Game;                           //
import com.badlogic.gdx.math.Vector2;
import son.flatformRPG.Main;
import son.flatformRPG.scene.AbstractScreen;
import son.flatformRPG.scene.game;


public class start_Menu extends AbstractScreen {
    private Main game;
    private Texture Button;//화면에 띄울 이미지를 불러옴
    private SpriteBatch batch;// 이미지를 그림
    private Rectangle Button_Bound;//버튼이 차지하는 영역

    public start_Menu(Main main) {
        super(main);
        this.game = main;
    }

    @Override
    public void show() {
        //버튼 이미지 생성
        Button = new Texture(Gdx.files.internal("start_Game.png"));


        //이미지를 그리기 위한 SpriteBatct 객체 생성
        batch = new SpriteBatch();

        float x=(Gdx.graphics.getWidth() - Button.getWidth())/2f;//이건 임시 좌표로 맵중앙에 설치하도록 함
        float y=(Gdx.graphics.getWidth() - Button.getWidth())/2f;
        Button_Bound = new Rectangle((int) x, (int) y, Button.getWidth(),Button.getHeight());//나누기 2가 들어가서 float밖에 안되는데 원래 int밖에 못들어간단다 왜진 몰루

        //부모 클래스의 show() 매서드 호출
        super.show();

        //디버깅용 로그
        Gdx.app.log(Main.LOG, "menu");

        /**사용자 입력 처리
         * 기
         * **/
        Gdx.input.setInputProcessor(new InputAdapter(){//사용자가 화면을 클릭할시 호출되는 함수
            @Override
            public boolean touchDown(int screenX,int screenY,int pointer, int button){
                Vector2 touch = new Vector2(screenX, Gdx.graphics.getHeight() - screenY);//libgdx는 y축이 아래로향함 그래서 클릭 좌표를 보정해줘야함
                // 이미지 영역 안을 클릭했는지 확인
                if (Button_Bound.contains(touch)) {
                    // MainScreen으로 화면 전환
                    game.setScreen(new game(game));
                }

                return true; // 이벤트 처리 완료
            }


        });
    }
    @Override
    public void render(float delta) {
        batch.begin();                                      // 그리기 시작
        batch.draw(Button, Button_Bound.x, Button_Bound.y);       // 이미지 출력
        batch.end();                                        // 그리기 종료
    }
    @Override
    public void dispose() {
        batch.dispose();  // SpriteBatch 해제
        Button.dispose();   // 이미지(Texture) 해제
    }


}
