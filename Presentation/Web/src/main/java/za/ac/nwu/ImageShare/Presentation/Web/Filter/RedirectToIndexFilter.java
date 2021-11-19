package za.ac.nwu.ImageShare.Presentation.Web.Filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@Component
public class RedirectToIndexFilter implements Filter {

    private String[] redirectPaths = new String[]{"/login", "register"};

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        boolean shouldRedirect = false;

        HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();

        for (int i = 0; ((i < redirectPaths.length) && !shouldRedirect); i++) {
            if(requestURI.startsWith(redirectPaths[i])){
                shouldRedirect = true;
            }
        }

        if(shouldRedirect){
            request.getRequestDispatcher("/").forward(request, response);
        }else{
            chain.doFilter(request, response);
            return;
        }
    }
}
