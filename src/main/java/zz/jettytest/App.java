package zz.jettytest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.log.Log;

public class App {
    public static void main(String[] args)throws Exception{
        Server server=new Server(7070);
        ServletContextHandler handler=new ServletContextHandler(server,"/");
        handler.addServlet(HelloProxyServlet.class,"/hello");
        handler.addServlet(HelloProxyServlet2.class,"/hello2");
        server.start();
    }

}
