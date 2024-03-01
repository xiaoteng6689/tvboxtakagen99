package xyz.doikki.videoplayer.render;

import android.content.Context;

import com.github.tvbox.osc.R;

public class PlayerViewRenderViewFactory extends RenderViewFactory {
    int renderType;

    public PlayerViewRenderViewFactory(int renderType) {
        this.renderType = renderType;
    }

    public static PlayerViewRenderViewFactory create(int renderType) {
        return new PlayerViewRenderViewFactory(renderType);
    }

    @Override
    public IRenderView createRenderView(Context context) {
        return new VideoViewRenderView(context, null, renderType == 1 ? R.style.surfaceType_surface : R.style.surfaceType_texture);
    }
}
