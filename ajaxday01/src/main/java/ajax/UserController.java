package ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ydy
 * @create 2019-03-25 19:22
 */
@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("login.do")
    @ResponseBody
    public ResponseResult handleLogin(String username, String password) {
        if ("root".equals(username)) {
            if ("root".equals(password)) {
                return new ResponseResult(1, "登入成功");
            } else {
                return new ResponseResult(2, "登入失败,密码有误");
            }
        }
        return new ResponseResult(3, "登入失败,账号不存在");
    }

    @RequestMapping("reg.do")
    @ResponseBody
    public ResponseResult handleReg(String username){
        if("root".equals(username)){
            return new ResponseResult(1,"该用户已经存在");
        }else{
            return new ResponseResult(2,"该用户可用");
        }
    }
}
