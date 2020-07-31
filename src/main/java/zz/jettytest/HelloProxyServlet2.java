package zz.jettytest;

import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.proxy.ProxyServlet;
import org.eclipse.jetty.proxy.AsyncProxyServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import org.eclipse.jetty.client.HttpClient;

public class HelloProxyServlet2 extends AsyncProxyServlet {


    @Override
    protected URI rewriteURI(HttpServletRequest request) {
        URI uri=null;
        try {
        	
            uri=new URI("http://localhost:7777");
        }catch (Exception e){
            e.printStackTrace();
        }
        return uri;
    }

    
    @Override
    protected void onProxyResponseSuccess(HttpServletRequest request,HttpServletResponse response,Response proxyResponse){
        try {
            String query=request.getQueryString();
            System.out.println("**************************");
            System.out.println("thread name: " + Thread.currentThread().getName());
            System.out.println("query string = " + query);
            
            if("1".equals(query)){
                Thread.sleep(10000);
            }
            System.out.println("**************************");
            super.onProxyResponseSuccess(request,response,proxyResponse);
        }catch (Exception e){
            e.printStackTrace();
        }
    }




}
