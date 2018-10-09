
import com.jit.demo.components.JacksonUtils;
import com.jit.demo.models.DeviceIsOnline;
import com.jit.demo.models.UserDeviceState;

import java.util.ArrayList;


/**
 * Created by 张先磊 on 2018/3/29.
 */
class LoginResponse{
    private int code;
    private ResBean bean;

    public void setCode(int code) {
        this.code = code;
    }

    public void setBean(ResBean bean) {
        this.bean = bean;
    }
    static class ResBean{
        private String token;
        // ......一些头像性别等等信息
    }
}


public class Test {
        public static void main(String[] args){
            UserDeviceState deviceState = new UserDeviceState();
            deviceState.setUserId(123);
            ArrayList<DeviceIsOnline> deviceIsOnlines = new ArrayList<DeviceIsOnline>();
            /* 问题出现在这啊 */
            deviceIsOnlines.add(new DeviceIsOnline("123",false));
            deviceState.setmDeviceStateLists(deviceIsOnlines);
            System.out.println(JacksonUtils.toJson(deviceState));
        }


        public void method() {
            // 客户端将数据传输过来了 如 username = x , password = y
            LoginResponse loginResponse = new LoginResponse();
            boolean disponseResult = true; // 模拟数据查询结果处理结果，即是否匹配,假设匹配了
            if (disponseResult){
                loginResponse.setCode(200);
                LoginResponse.ResBean bean = new LoginResponse.ResBean();
                // -------- 设置其他属性
                loginResponse.setBean(bean);
            }
            // 最后返回处理结果
            JacksonUtils.toJson(loginResponse);

        }
}

