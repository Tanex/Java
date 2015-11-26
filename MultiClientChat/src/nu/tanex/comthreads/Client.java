package nu.tanex.comthreads;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends Thread{

    private Socket sock;
    private BufferedReader inStream;
    private PrintWriter outStream;

    public Client() throws IOException {
        sock = new Socket(InetAddress.getLocalHost(), 2000);
    }

    @Override
    public void run() {
        ServerListener servListener = new ServerListener();
        try {
            inStream = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            outStream = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())),true);
            BufferedReader kbRdr = new BufferedReader(new InputStreamReader(System.in));
            servListener.start();

            while(true) {
                outStream.println(kbRdr.readLine());
            }

        } catch (IOException e) {
            System.out.println("Server closed");
            //e.printStackTrace();
        } finally{
            servListener.interrupt();
        }
    }

    private class ServerListener extends Thread{
        @Override
        public void run() {
            try {
                while(true) {
                    System.out.println(inStream.readLine());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
