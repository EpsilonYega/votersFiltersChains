package api.configs;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class CustomFilter extends OncePerRequestFilter {
    private final RequestMatcher requestMatcher;

    public CustomFilter(RequestMatcher requestMatcher) {
        this.requestMatcher = requestMatcher;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (requestMatcher.matches(request)) {
            // Your filter logic here
            // For example, you can check for certain headers or parameters and perform actions accordingly
        }
        filterChain.doFilter(request, response);
    }
}
