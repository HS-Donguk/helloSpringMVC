package kr.ac.hansung.cse.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")   // root이하의 모든 request를 가로채겠다. intercept하겠다.
public class TestFilter implements Filter {  // TestFilter가 Filter역할을 하기 위해선 implements Filter를 꼭 해줘야함.
    @Override   // 구현해줘야 할 것 1
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override   // 구현해줘야 할 것 2
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {  //
        System.out.println( ((HttpServletRequest) request).getRequestURL() );  // 사용자로부터 request url을 출력.

        // pass the request along the filter chain
        // 사용자로 부터 온 request를 filter chain에 던진다.
        chain.doFilter(request, response);   // chain filter 등록.
    }

    @Override   // 구현해줘야 할 것 3
    public void destroy() {

    }
}
