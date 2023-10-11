package com.server.lace.global.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.lace.domain.member.exception.MemberNotFoundException;
import com.server.lace.global.exception.enums.ErrorCode;
import com.server.lace.global.exception.response.ErrorResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ExceptionHandlerFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            setErrorResponse(ErrorCode.EXPIRED_TOKEN, response);
        } catch (JwtException | IllegalArgumentException e) {
            setErrorResponse(ErrorCode.TOKEN_NOT_VALID, response);
        } catch (MemberNotFoundException e) {
            setErrorResponse(ErrorCode.MEMBER_NOT_FOUND, response);
        }
    }

    public void setErrorResponse(ErrorCode errorCode, HttpServletResponse response) throws IOException {
        response.setStatus(errorCode.getStatus());
        response.setContentType("application/json; charset=utf-8");
        ErrorResponse errorResponse = new ErrorResponse(errorCode);
        String errorResponseEntityToJson = objectMapper.writeValueAsString(errorResponse);
        response.getWriter().write(errorResponseEntityToJson);
    }
}
