package com.glory.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Main extends ApplicationAdapter {
	private final int WIDTH = 800, HEIGHT = 500, SIZE = 64;
	
	private Texture guyImg, coinImg;
	private Sound coinSound;
	private Music music;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Rectangle guy;
	private Array<Rectangle> coins;
	private long lastDrop;
	
	@Override
	public void create () {
		guyImg = new Texture("badlogic.jpg");
		coinImg = new Texture("coin.jpg");
		coinSound = Gdx.audio.newSound(Gdx.files.internal("coin.wav"));
		music = Gdx.audio.newMusic(Gdx.files.internal("TribeMusic.mp3"));
		camera = new OrthographicCamera();
		batch = new SpriteBatch();
		guy = new Rectangle(WIDTH/2 - SIZE/2, HEIGHT/2 - SIZE/2, SIZE, SIZE);
		coins = new Array<Rectangle>();
		
		music.setLooping(true);
		music.play();
		camera.setToOrtho(false, 800, 500);
		spawnCoin();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0.03f, 0.2f, 1);
		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		batch.draw(guyImg, guy.x, guy.y);
		for(Rectangle coin : coins)
			batch.draw(coinImg, coin.x, coin.y);
		batch.end();
		
//		Used for mobile or instant position movement
//		if(Gdx.input.isTouched()) {
//			Vector3 pos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
//			camera.unproject(pos);
//			guy.x = pos.x - SIZE/2;
//			guy.y = pos.y - SIZE/2;
//		}
//		
//		Used to update position of coins
//		for (ArrayIterator<Rectangle> coin = coins.iterator(); iter.hasNext(); ) {
//		      Rectangle raindrop = coin.next();
//		      raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
//		      if(raindrop.y + 64 < 0) iter.remove();
//		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) guy.x -= 200 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) guy.x += 200 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Input.Keys.UP)) guy.y += 200 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) guy.y -= 200 * Gdx.graphics.getDeltaTime();
		
		if(guy.x <= -SIZE/2) guy.x = WIDTH-64;
		if(guy.x >= HEIGHT+SIZE/2) guy.x = 0;
		if(guy.y <= -SIZE/2) guy.y = HEIGHT-64;
		if(guy.y >= HEIGHT+SIZE/2) guy.y = 0;
		
		if(TimeUtils.nanoTime() - lastDrop > 1000000000) spawnCoin();
		
		for(int i = 0; i < coins.size; i++)
			if(coins.get(i).overlaps(guy)) {
				coinSound.play();
				coins.removeIndex(i);
			}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		guyImg.dispose();
		coinImg.dispose();
		music.dispose();
		coinSound.dispose();
	}
	
	private void spawnCoin() {
		Rectangle coin = new Rectangle(MathUtils.random(0, WIDTH-SIZE),
									   MathUtils.random(0, HEIGHT-SIZE),
									   SIZE, SIZE);
		coins.add(coin);
		lastDrop = TimeUtils.nanoTime();
	}
}
