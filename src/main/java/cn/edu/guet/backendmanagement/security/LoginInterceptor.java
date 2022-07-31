package cn.edu.guet.backendmanagement.security;

import cn.edu.guet.backendmanagement.bean.SysMenu;
import cn.edu.guet.backendmanagement.mapper.SysOrderMapper;
import cn.edu.guet.backendmanagement.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private SysOrderMapper sysOrderMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println(SecurityUtils.getAuthentication().getPrincipal() + "+++++++++++++++++++++++++++++++++");
        //获取当前登录的用户名
        String username = (String) SecurityUtils.getAuthentication().getPrincipal();
        //查询用户名对应的角色名
        List<SysMenu> sysMenus = sysOrderMapper.queryMenuNameByUserName(username);
        AtomicReference<Boolean> psssStatus = new AtomicReference<>(false);
        //获取当前请求URL
        String requestUrl = request.getRequestURI();
        //判断是否是对应订单权限所有者
        sysMenus.forEach(d -> {
            if (d.getUrl() != null)
                if (requestUrl.equals(d.getUrl()))
                    psssStatus.set(true);
                else if (d.getUrl().contains(";")) {
                    for (String s : d.getUrl().split(";")) {
                        if (s.equals(requestUrl))
                            psssStatus.set(true);
                    }
                }
        });
        return psssStatus.get();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println(request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println(request.getServletPath());
    }
}
