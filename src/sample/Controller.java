package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;

public class Controller {

    public AnchorPane pane;
    public TextField fieldKey;
    public Button btnDecrypt;
    public Button btnEncrypt;
    public TextFlow txtFileContent;
    public Label lblFilePath;


    public void openFileChooser(){

        JFileChooser fileChooser = new JFileChooser("C:\\Users\\ledgo\\IdeaProjects\\VigenerCipher\\src\\sample");
        int status = fileChooser.showOpenDialog(null);

        if (status == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile.getParent());
            System.out.println(selectedFile.getName());
            lblFilePath.setText(selectedFile.getAbsolutePath());

            ReadFile readed=new ReadFile(selectedFile.getParent(),selectedFile.getName());
            String message=readed.loadFile(selectedFile.getAbsolutePath());
            Cipher cipher=new Cipher(fieldKey.getText());
            cipher.encrypt(message,fieldKey.getText());

        } else if (status == JFileChooser.CANCEL_OPTION) {
            System.out.println("canceled");
        }
    }

    public void encryptFile(ActionEvent event) {
    }

    public void decryptFile(ActionEvent event) {
    }

}
