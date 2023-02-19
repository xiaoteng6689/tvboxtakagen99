package com.github.tvbox.osc.util;

import com.github.liuyueyi.quick.transfer.ChineseUtils;
import com.orhanobut.hawk.Hawk;

public class ChineseTran {
    static public String simToTran(String Input,boolean enabled){
        if(!enabled||Input == null) {
            return Input;
        }
            return ChineseUtils.s2t(Input);
    }
    // This is for when there is only one translate in a class
    static public String simToTran(String Input){
        if(Hawk.get(HawkConfig.HOME_LOCALE, 0) != 1 || Input == null) {
            return Input;
        }
        return ChineseUtils.s2t(Input);
    }
    static public boolean check(){
        return Hawk.get(HawkConfig.HOME_LOCALE, 0) == 1;
    }
}
