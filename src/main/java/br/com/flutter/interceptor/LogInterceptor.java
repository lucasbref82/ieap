package br.com.flutter.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
@Log
public class LogInterceptor implements HandlerInterceptor {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Instant inicio = Instant.now();
        String identificador = UUID.randomUUID().toString();
        request.setAttribute("identificador", identificador);
        request.setAttribute("inicio", inicio);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Instant inicio = Instant.ofEpochMilli((Long) request.getAttribute("inicio"));
        String identificador = (String) request.getAttribute("identificador");
        Instant fim = Instant.now();
        JSONObject obj = new JSONObject();
        obj.put("identificador", identificador);
        obj.put("uri", request.getRequestURI());
        obj.put("method", request.getMethod());
        obj.put("status", response.getStatus());
        obj.put("inicio", formatter.format(inicio));
        obj.put("fim", formatter.format(Instant.now()));
        obj.put("duracao", fim.toEpochMilli() - inicio.toEpochMilli());
        log.info(obj.toString());
    }
}
