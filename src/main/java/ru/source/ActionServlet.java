package ru.source;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

@WebServlet("/ActionServlet")
public class ActionServlet extends javax.servlet.http.HttpServlet {
    LocalClient localClient;
    @Override
    public void init() throws ServletException {
        try{
            localClient = new LocalClient();
        }catch (IOException e){
            e.printStackTrace();
        }
        super.init();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //JNIClass jniClass = new JNIClass();
        //jniClass.setBackground("C:/Users/pdai/Pictures/WallChanger/q.jpg");

        //JNA_Emulator.INSTANCE.LibInit();
        //JNA_Emulator.INSTANCE.TestConnect();

        String str = request.getParameter("Button");
        if(str.contains("Архиепископ")){
            localClient.sendToDevice((byte)0x10);
        }
        if(str.contains("Высший Друид")){

        }


        response.sendRedirect("/buff/");
        //getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }
}
