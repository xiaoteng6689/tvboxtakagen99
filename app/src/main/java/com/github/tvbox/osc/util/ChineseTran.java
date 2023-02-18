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
    static public boolean check(){
        return Hawk.get(HawkConfig.HOME_LOCALE, 0) == 1;
    }
}
