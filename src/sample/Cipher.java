package sample;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Cipher {

    public Cipher() {
    }

    public String encrypt(String key, String source) {
        if (key.equals("")) {
            return "Please enter the password";
        }
        StringBuilder output = new StringBuilder();
        String keyword = key.toLowerCase();
        int countKey = 0;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(source), StandardCharsets.UTF_8));
            int c;

            while ((c = reader.read()) != -1) {
                if (keyword.charAt(countKey) < 97) {
                    return "Wrong input";
                }
                if ((char) c >= 65 && (char) c <= 90) {
                    char ch = (char) (c + ((keyword.charAt(countKey)) - 97));
                    if ((int) ch > 90) {
                        ch -= 26;
                    }
                    output.append(ch);
                } else if ((char) c >= 97 && (char) c <= 122) {
                    char ch = (char) (c + (keyword.charAt(countKey)) - 97);
                    if ((int) ch > 122) {
                        ch -= 26;
                    }
                    output.append(ch);
                } else if ((char) c == 32) {
                    output.append((char) c);
                    countKey--;
                }
                countKey++;

                if (countKey >= keyword.length()) {
                    countKey = 0;
                }
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ledgo\\IdeaProjects\\VigenerCipher\\src\\sample\\data_encrypted.txt"));
            writer.write(output.toString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public String decrypt(String key, String source) {
        if (key.equals("")) {
            return "Please enter the password";
        }
        StringBuilder output = new StringBuilder();
        String keyword = key.toLowerCase();
        int countKey = 0;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(source), StandardCharsets.UTF_8));
            int c;
            while ((c = reader.read()) != -1) {
                if (keyword.charAt(countKey) < 97) {
                    return "Wrong input";
                }
                if ((char) c >= 65 && (char) c <= 90) {
                    char ch = (char) (c - ((keyword.charAt(countKey)) - 97));
                    if ((int) ch < 65) {
                        ch += 26;
                    }
                    output.append(ch);
                } else if ((char) c >= 97 && (char) c <= 122) {
                    char ch = (char) (c - ((keyword.charAt(countKey)) - 97));
                    if ((int) ch < 97) {
                        ch += 26;
                    }
                    output.append(ch);
                } else if ((char) c == 32) {
                    output.append((char) c);
                    countKey--;
                }
                countKey++;
                if (countKey >= keyword.length()) {
                    countKey = 0;
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ledgo\\IdeaProjects\\VigenerCipher\\src\\sample\\data_decrypted.txt"));
            writer.write(output.toString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();
    }
}



