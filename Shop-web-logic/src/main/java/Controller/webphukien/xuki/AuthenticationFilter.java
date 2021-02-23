package Controller.webphukien.xuki;

import common.loaisanphamCommon;
import common.webConstant;
import org.example.core.comon.utils.SessionUtil;
import org.example.core.dto.KhachHangDTO;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    private ServletContext context;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        if (url.startsWith("/admin")) {
            if (request.getSession().getAttribute(webConstant.idnhanvien) != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                response.sendRedirect(request.getContextPath() + "/LoginAdmin.py");
            }
        } else if (url.startsWith("/phukien")) {
            request.setAttribute(webConstant.loaisanpham,loaisanphamCommon.viewLSP());
            filterChain.doFilter(servletRequest, servletResponse);
        }else if (url.startsWith("/web")){
            request.setAttribute(webConstant.loaisanpham,loaisanphamCommon.viewslspxe());
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }


    public void destroy() {

    }
}
