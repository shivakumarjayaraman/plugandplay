package com.netgear.simplews;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static String dataDirectory = "./data";
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            dataDirectory = args[0];
        }
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8090);
        server.setConnectors(new Connector[] {connector});

        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);
        handler.addServletWithMapping(FrontController.class, "/");
        server.start();
    }
}
