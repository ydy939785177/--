package spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
	CharacterEncodingFilter f;
	@RequestMapping("info.do")
	public String showInfo() {
		return "info";
	}
	@RequestMapping("password.do")
	public String showPassword() {
		return "password";
	}

	@RequestMapping("reg.do")
	public String showReg(HttpSession session) {
		Object count = session.getAttribute("count");
		Integer c;
		if (count == null) {
			c = 1;
		} else {
			c = Integer.valueOf(count.toString());
			c++;
		}
		session.setAttribute("count", c);
		return "reg";
	}

	//	@RequestMapping("handle_reg.do")
//	public String handleReg() {
//		return "redirect:login.do";
//	}
	@RequestMapping("handle_reg.do")
	public String handleReg(User user) {
		System.out.println(user.toString());
		return "redirect:login.do";
	}

	@RequestMapping(value="login.do")
	public String showLogin() {
		return "login";
	}

	@RequestMapping(value="handle_login.do",method=RequestMethod.POST)
//	@RequestParam(value="uname",defaultValue="root")
	public String handleLogin( String username, String password, ModelMap modelMap,HttpSession session) {
		System.out.println("username:"+username+"password:"+password);
		String msg;
		if ("root".equals(username)) {
			if ("root".equals(password)) {
				System.out.println("登入成功");
				session.setAttribute("root", "root");
				return "info";
			} else {
				msg = "密码错误";
				modelMap.addAttribute("msg", msg);
				return "error";
			}
		} else {
			msg = "账号不存在";
			modelMap.addAttribute("msg", msg);
			return "error";
		}
	}
}
