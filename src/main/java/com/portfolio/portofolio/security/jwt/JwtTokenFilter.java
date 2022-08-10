package com.portfolio.portofolio.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.portfolio.portofolio.security.service.UserDetailsServiceImplementation;

public class JwtTokenFilter extends OncePerRequestFilter{

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserDetailsServiceImplementation userDetailsServiceImplementation;

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                try {
                    String token = getToken(request);
                    if(token != null && jwtProvider.validateToken(token)){
                        String userName = jwtProvider.getEmailFromToken(token);
                        UserDetails userDetails = userDetailsServiceImplementation.loadUserByUsername(userName);
                        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        SecurityContextHolder.getContext().setAuthentication(auth);
                    }
                } catch (Exception e) {
                    logger.error("Error in method doFilter");
                }
                filterChain.doFilter(request, response);
        
    }

    private String getToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer"))
            return header.replace("Bearer", "");
        return null;
    }
    
}
