package com.lecuong.userservice.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lecuong.userservice.modal.AccountInfo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Base64;

/**
 * author CuongLM
 */
@Data
@Component
@Order(1)
public class TransactionFilter implements Filter {

    private final ObjectMapper objectMapper;

    @Autowired
    AccountInfo accountInfo;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) req;

        //Get token from header
        String token = httpRequest.getHeader("Authorization");

        //Transform token to array by "."
        String[] chunks = token.split("\\.");

        Base64.Decoder decoder = Base64.getUrlDecoder();

        //Convert header and payload to json from token
        //Clear Bearber with substring(7)
        //String header = new String(decoder.decode(chunks[0].substring(7)));
        String payload = new String(decoder.decode(chunks[1]));

        //Parse json to object
        AccountInfo accountInfoObject = objectMapper.readValue(payload, AccountInfo.class);
        accountInfo.setName(accountInfoObject.getName());

        chain.doFilter(req, res);
    }
}
