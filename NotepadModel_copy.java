
package com.mycompany.notepadapp.model;

import javax.swing.*;
import java.io.*;

public class NotepadModel {
    private String text;

    public NotepadModel() {
        this.text = "";
    }

    // Getter for text
    public String getText() {
        return text;
    }

    // Setter for text
    public void setText(String text) {
        this.text = text;
    }

    // Count words in the text
    public int getWordCount() {
        return text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;
    }

    // Count lines in the text
    public int getLineCount() {
        return text.split("\n").length;
    }

    // Count characters in the text
    public int getCharacterCount() {
        return text.length();
    }

    // Save file
    public void saveFile(File file, JTextArea textArea) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            textArea.write(writer);
        }
    }

    // Open file
    public void openFile(File file, JTextArea textArea) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            textArea.read(reader, null);
        }
    }
}

