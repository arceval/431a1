# 431a1

IP and port are hardcoded, will need to be changed on the Server.java/Client.java to the server's ip and whatever is free on both.

Copy code to two machines

Machine 1: Get IP from machine, edit HOSTIP in Server.java to this.
javac Server.java
java Server

Machine 2: Edit HOSTIP in Client.java.
javac Client.java
java Client

Should output Server time.

Runs on openjdk version "10.0.2"

Written by Rohm and Korban