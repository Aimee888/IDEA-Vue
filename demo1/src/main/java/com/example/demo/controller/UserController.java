package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.impl.RoleServiceImpl;
import com.example.demo.service.impl.UserProfileServiceImpl;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
@SessionAttributes("User")
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
public class UserController {
    @Autowired
    private UserServiceImpl userServer;
    @Autowired
    private UserProfileServiceImpl userProfileServer;
    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/users")
    public List<User> getUserList()
    {
        return userServer.getUserList();
    }

    @GetMapping("/roles")
    @ResponseBody
    public ResultVo getRoleList()
    {
        List<Role> rolelist = roleService.getRoleList();
        return new ResultVo(200, "", new RoleVo(rolelist, rolelist.size()));
    }

    @GetMapping("/userprofile")
    public List<UserProfile> getUserProfileList()
    {
        return userProfileServer.getUserProfileList();
    }

    @PostMapping("/login")
    @ResponseBody
    public ResultVo loginStatus(HttpServletRequest req, Model model, HttpSession session)
    {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        List<User> userlist = userServer.getUserList();
        for (User us: userlist){
            if (us.user_account.equals(username) && us.user_password.equals(password)){
                model.addAttribute("User", us);
                return new ResultVo(200, "登录成功", new LoginVo(us));
            }
        }
        return new ResultVo(201, "用户名/密码错误", "");
    }

    @GetMapping("/Profile")
    @ResponseBody
    public ResultVo ShowProfile(@ModelAttribute("User") User user)
    {
        List<UserProfile> userprofilelist = userProfileServer.getUserProfileList();
        for(UserProfile up: userprofilelist){
            if (up.user_id.equals(user.getUser_num())){
                return new ResultVo(200, "", new UserProfileVo(user, up));
            }
        }
        return new ResultVo(201, "获取失败", "");
    }
}
