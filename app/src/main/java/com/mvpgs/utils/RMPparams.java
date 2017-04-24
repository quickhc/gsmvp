package com.mvpgs.utils;

import java.util.HashMap;
import java.util.Map;

/*********************************************
 ***       河南坚磐科技电子有限公司        ***
 ***                                       ***
 ***       Created by HC on 2017/4/24.       ***
 *********************************************/

public class RMPparams {

    private Map<String,String> params;

    public RMPparams(){
        params=new HashMap<String,String>();
    }

    public Map<String,String> getLogin(String username,String password){
        params.put("cityname",username);
        params.put("key",password);
        return params;
    }
}
