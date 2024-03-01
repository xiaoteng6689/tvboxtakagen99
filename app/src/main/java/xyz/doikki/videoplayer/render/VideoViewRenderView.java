package xyz.doikki.videoplayer.render;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;

import androidx.media3.ui.PlayerView;

import com.github.tvbox.osc.player.EXOmPlayer;
import com.lzy.okgo.utils.OkLogger;

import xyz.doikki.videoplayer.player.AbstractPlayer;


@SuppressLint("ViewConstructor")
public class VideoViewRenderView extends PlayerView implements IRenderView {

    public VideoViewRenderView(Context context) {
        super(context);
    }

    public VideoViewRenderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VideoViewRenderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setUseController(false);
    }

    @Override
    public void attachToPlayer(AbstractPlayer player) {
        if (player instanceof EXOmPlayer) {
            ((EXOmPlayer) player).setPlayerView(this);
        }
        OkLogger.d("attachToPlayer >>>  " + player);
    }

    @Override
    public void setVideoSize(int videoWidth, int videoHeight) {

    }

    @Override
    public void setVideoRotation(int degree) {


    }

    @Override
    public void setScaleType(int scaleType) {

    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public Bitmap doScreenShot() {
        return null;
    }

    @Override
    public void release() {
        setPlayer(null);
    }
}