import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;

public class Client{



  public static void main(String args[]){

    try{
      Scanner sc = new Scanner(System.in);
      String username;
      String domaine;
      String name;
      String desc;
      int prix;
      int id;
      String rep;
      int port;
      String cmd;
      Socket so = new Socket("localhost", 4450);
      BufferedReader br = new BufferedReader(new InputStreamReader(so.getInputStream()));
      PrintWriter pw = new PrintWriter(new OutputStreamWriter(so.getOutputStream()));
      so.setTcpNoDelay(true);
      String fst = br.readLine();
      System.out.print("->" +fst + "\n");
      System.out.println(">  : Command line ");
      System.out.println("-> : server responses ");
      while(true){
        System.out.print(">");
        cmd = sc.nextLine();
        //System.out.println(cmd);
        switch(cmd){
          case "SIGNUP" :
            pw.println(cmd);
            pw.flush();
            System.out.print("username : ");
            username = sc.nextLine();
            //System.out.println ("username = {" + username + "} + len = " + username.length());
            pw.println(username);
            pw.flush();
            System.out.print("udp port n° : ");
            
            port = Integer.parseInt(sc.nextLine());
            pw.println(port);
            pw.flush();
            pw.print("***\n");
            pw.flush();
            //System.out.println("on est al");
            rep = "";
            //System.out.println ("AZPOEIZAPOIEPOZAIEPOZA");
            while(!rep.equals("***")){
                rep = "";
                rep = br.readLine();
                if(!rep.equals("***")){
                  System.out.print("->" + rep + "\n");
                }
            }

            break;

          case "LOGIN" :
          pw.println(cmd);
          pw.flush();
          System.out.print("username : ");
          username = sc.nextLine();
          System.out.println ("username = {" + username + "} + len = " + username.length());
          pw.println(username);
          pw.flush();
          System.out.print("udp port n° : ");
          port = Integer.parseInt(sc.nextLine());
          pw.println(port);
          pw.flush();
          pw.print("***\n");
          pw.flush();
          //System.out.println("on est al");
          rep = "";
          //System.out.println ("AZPOEIZAPOIEPOZAIEPOZA");
          while(!rep.equals("***")){
              rep = "";
              rep = br.readLine();
              if(!rep.equals("***")){
                System.out.print("->" + rep + "\n");
              }
          }
          break;

          case "ADDARTICLE" :
            pw.println(cmd);
            pw.flush();
            pw.flush();
            System.out.print("domain : ");
            domaine = sc.nextLine();
            pw.println(domaine);
            pw.flush();
            System.out.print("name : ");
            name = sc.nextLine();
            pw.println(name);
            pw.flush();
            System.out.print("price : ");
            prix = Integer.parseInt(sc.nextLine());
            pw.println(prix);
            pw.flush();
            System.out.print("desc : ");
            desc = sc.nextLine();
            pw.println(desc);
            pw.flush();
            pw.println("***");
            pw.flush();
            rep = "";
            while(!rep.equals("***")){
              rep = "";
              rep += br.readLine();
              if(!rep.equals("***")){
                System.out.print("->" + rep + "\n");
              }
            }
            break;

          case "ASKARTICLES" :
            pw.println(cmd);
            pw.flush();
            System.out.print("domain : ");
            domaine = sc.nextLine();
            pw.println(domaine);
            pw.flush();
            pw.println("***");
            pw.flush();
            rep = "";
            while(!rep.equals("***")){
              rep = "";
              rep += br.readLine();
              if(!rep.equals("***")){
                System.out.print("->" + rep + "\n");
              }
            }
            break;

          case "ASKDOMAIN" :
            pw.println(cmd);
            pw.flush();
            pw.println("***");
            pw.flush();
            rep = "";
            while(!rep.equals("***")){
              rep = "";
              rep += br.readLine();
              if(!rep.equals("***")){
                System.out.print("->" + rep + "\n");
              }
            }
            break;

          case "ASKMYARTICLES" :
            pw.println(cmd);
            pw.flush();
            pw.println("***");
            pw.flush();
            rep = "";
            while(!rep.equals("***")){
              rep = "";
              rep += br.readLine();
              if(!rep.equals("***")){
                System.out.print("->" + rep + "\n");
              }
            }
            break;

          case "LOGOUT" :
            pw.println(cmd);
            pw.flush();
            pw.println("***");
            pw.flush();
            rep = "";
            while(!rep.equals("***")){
              rep = "";
              rep += br.readLine();
              if(!rep.equals("***")){
                System.out.print("->" + rep + "\n");
              }
            }
            break;

          case "DELARTICLE":
            pw.println(cmd);
            pw.flush();
            System.out.print("product id : ");
            id = Integer.parseInt(sc.nextLine());
            pw.println(id);
            pw.flush();
            pw.println("***");
            pw.flush();
            rep = "";
            while(!rep.equals("***")){
              rep = "";
              rep += br.readLine();
              System.out.print("->" + rep + "\n");

            }
            break;

          case "ADDDOMAIN":
            pw.println(cmd);
            pw.flush();
            pw.println("***");
            pw.flush();
            rep = "";
            while(!rep.equals("***")){
              rep = "";
              rep += br.readLine();
              System.out.print("->" + rep + "\n");

            }
            break;

          case "QUIT" :
            pw.println(cmd);
            pw.flush();
            pw.println("***");
            pw.flush();
            return;

          case "SPEAK":
            pw.println(cmd);
            pw.flush();
            System.out.print("product id : ");
            id = Integer.parseInt(sc.nextLine());
            pw.println(id);
            pw.flush();
            pw.println("***");
            pw.flush();
            rep = "";
            while(!rep.equals("***")){
              rep = "";
              rep += br.readLine();
              if(!rep.equals("***")){
                System.out.print("->" + rep + "\n");
              }
            }
            break;

          case "" : //Enter
            break;

          default :
            System.out.println ("UNKNOWN_COMMAND");
            System.out.print("SUPPORTED COMMANDS : ");
            System.out.print("SIGN UP -");
            System.out.print(" LOGIN -");
            System.out.print(" LOGOUT -");
            System.out.print(" ASKDOMAIN -");
            System.out.print(" ASKARTICLES -");
            System.out.print(" ASKMYARTICLES -");
            System.out.print(" ADDDOMAIN -");
            System.out.print(" ADDARTICLE -");
            System.out.print(" DELARTICLE -");
            System.out.print(" SPEAK \n");

            break;
    }
   }
  }catch(Exception e){e.printStackTrace();}

  }

}
