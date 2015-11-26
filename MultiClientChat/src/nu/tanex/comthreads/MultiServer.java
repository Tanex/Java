package nu.tanex.comthreads;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Vector;

public class MultiServer extends Thread {
    
    private ServerSocket servSock;
    private static Vector<ClientThread> clients = new Vector<ClientThread>();
    
    public MultiServer() throws IOException {
        servSock = new ServerSocket(2000);
    }
    
    @Override
    public void run() {
        while(true){
            try {
                (new ClientThread(servSock.accept())).start();
                System.out.println("Client connected");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ClientThread extends Thread{

        private Socket clientSock;
        private BufferedReader inStream;
        private PrintWriter outStream;


        public ClientThread(Socket clientSock){
            this.clientSock = clientSock;
            clients.add(this);
        }

        @Override
        public void run() {
            System.out.println("ClientThread started");
            try {
                inStream = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
                outStream = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSock.getOutputStream())),true);
                String buf = new String();

                while(true) {
                    buf = inStream.readLine();
                    System.out.println("Received: " + buf);
                    for (ClientThread client : clients){
                        if (client != this)
                            client.outStream.println(buf);
                    }
                }

            } catch (IOException e) {
                System.out.println("Client disconnected");
                //e.printStackTrace();
            }
            finally{
                clients.remove(this);
            }
        }
    }
}
