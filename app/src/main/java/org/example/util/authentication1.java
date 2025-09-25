package org.example.util;

import org.mindrot.jbcrypt.BCrypt;

public class authentication1 {

    public static String hash_password(String pass){

        return BCrypt.hashpw(pass, BCrypt.gensalt());

    }
    public static Boolean verify(String pass, String hash_password){
        return BCrypt.checkpw(pass,hash_password);
    }
}
