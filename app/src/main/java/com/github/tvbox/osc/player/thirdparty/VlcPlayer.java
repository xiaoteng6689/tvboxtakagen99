package com.github.tvbox.osc.player.thirdparty;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;

import com.github.tvbox.osc.base.App;
import java.net.URLEncoder;
import java.util.HashMap;
//import java.io.UnsupportedEncodingException;

public class VlcPlayer {
    public static final String TAG = "ThirdParty.VLC";

    private static final String PACKAGE_NAME = "org.videolan.vlc";
    private static final String PLAYBACK_ACTIVITY = "org.videolan.vlc.gui.video.VideoPlayerActivity";

    private static class VlcPackageInfo {
        final String packageName;
        final String activityName;

        VlcPackageInfo(String packageName, String activityName) {
            this.packageName = packageName;
            this.activityName = activityName;
        }
    }

    private static final VlcPackageInfo[] PACKAGES = {
            new VlcPackageInfo(PACKAGE_NAME, PLAYBACK_ACTIVITY),
    };

    public static VlcPackageInfo getPackageInfo() {
        for (VlcPackageInfo pkg : PACKAGES) {
            try {
                ApplicationInfo info = App.getInstance().getPackageManager().getApplicationInfo(pkg.packageName, 0);
                if (info.enabled)
                    return pkg;
                else
                    Log.v(TAG, "VLC Player package `" + pkg.packageName + "` is disabled.");
            } catch (PackageManager.NameNotFoundException ex) {
                Log.v(TAG, "VLC Player package `" + pkg.packageName + "` does not exist.");
            }
        }
        return null;
    }

    public static boolean run(Activity activity, String url, String title, String subtitle, HashMap<String, String> headers) {
        VlcPackageInfo packageInfo = getPackageInfo();
        if (packageInfo == null)
            return false;
		try {

            // https://wiki.videolan.org/Android_Player_Intents/
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setPackage(packageInfo.packageName);
            intent.setDataAndTypeAndNormalize(Uri.parse(url), "video/*");
            intent.putExtra("title", title);
		    // if (headers != null && headers.size() > 0) {
                // url = url + "|";
                // int idx = 0;
                // for (String hk : headers.keySet()) {
                    // try {
                        // url += hk + "=" + URLEncoder.encode(headers.get(hk), "UTF-8");
                    // } catch (UnsupportedEncodingException e) {
                        // e.printStackTrace();
                    // }
                    // if (idx < headers.keySet().size() -1) {
                        // url += "&";
                    // }
                    // idx ++;
                // }
            // }
		    
            if (subtitle != null && !subtitle.isEmpty()) {
                intent.putExtra("subtitles_location", subtitle);
            }
		    
            //if (progress > 0) {
            //    intent.putExtra("from_start", false);
            //    intent.putExtra("position", progress);
            //}
		    
            
            activity.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException ex) {
            Log.e(TAG, "Can't run VLC Player(Pro)", ex);
            return false;
        }
    }
}
