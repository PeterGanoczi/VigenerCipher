package sample;

import java.util.List;

public class Cipher {

    private String key;

    public Cipher(String key) {
        this.key = key;
    }

    public String encrypt(String text, String key){


        char msg[]=text.toCharArray();
        int msglen=text.length();
        int i,j;

        char keyword[]=new char[msglen];
        char msgEncrypted[]=new char[msglen];

        for (i=0, j=0; i<msglen; i++, j++){
            if (j==key.length()){
                j=0;
            } else{
                keyword[i]=key.charAt(j);
            }
        }
        for (i=0; i<keyword.length;i++){
            System.out.println(keyword[i]);
        }


        return null;
    }

}
