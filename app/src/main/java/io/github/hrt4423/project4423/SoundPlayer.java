package io.github.hrt4423.project4423;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundPlayer {

    private static SoundPool soundPool;
    private static int hitSound;
    private static int overSound;
    private static int Myshot;
    private static int Enemyshot;
    private static int piriin;
    private static int coin;
    private static int newscore;

    public SoundPlayer(Context context) {

        soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);

        hitSound = soundPool.load(context, R.raw.bomb, 1);
        overSound = soundPool.load(context, R.raw.short_bomb, 1);
        Myshot = soundPool.load(context,R.raw.se_shot10,1);
        Enemyshot = soundPool.load(context,R.raw.se_shot09,1);
        piriin = soundPool.load(context,R.raw.se_piriin2,1);
        coin = soundPool.load(context,R.raw.coin04,1);
        newscore = soundPool.load(context,R.raw.powerup03,1);

    }

    public void playHitSound() {
        soundPool.play(hitSound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void playOverSound() {
        soundPool.play(overSound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void playMyCharShotSound() {
        soundPool.play(Myshot,1.0f,1.0f,1,0,1.0f);
    }

    public void playEnemyShotSound(){
        soundPool.play(Enemyshot,1.0f,1.0f,1,0,1.0f);
    }

    public void playPiriinSound() { soundPool.play(piriin,1.0f,1.0f,1,0,1.0f); }

    public void playCoinSound() { soundPool.play(coin,1.0f,1.0f,1,0,1.0f); }

    public void playNewScoreSound() { soundPool.play(newscore,1.0f,1.0f,1,0,1.0f); }

}
