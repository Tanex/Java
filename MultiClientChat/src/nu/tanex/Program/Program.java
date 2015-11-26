package nu.tanex.Program;

import nu.tanex.comthreads.Client;
import nu.tanex.comthreads.MultiServer;

import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        try {
        if (args.length == 0){
            System.out.println("Clientmode");
            (new Client()).start();
        }
        else{
            (new MultiServer()).start();
            System.out.println("Servermode");
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
