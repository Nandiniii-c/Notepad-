package com.mycompany.notepadapp.controller;
import com.mycompany.notepadapp.model.NotepadModel;
import com.mycompany.notepadapp.view.NotepadView;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class NotepadController implements ActionListener {
    private final NotepadModel model;
    private final NotepadView view;

    public NotepadController(NotepadModel model, NotepadView view) {
        this.model = model;
        this.view = view;

        // Attach event listeners
        view.newItem.addActionListener(this);
        view.openItem.addActionListener(this);
        view.saveItem.addActionListener(this);
        view.exitItem.addActionListener(this);
        view.cutItem.addActionListener(this);
        view.copyItem.addActionListener(this);
        view.pasteItem.addActionListener(this);
        view.textArea.addCaretListener(this::updateStatusBar);
    }

    private void updateStatusBar(CaretEvent e) {
        String text = view.textArea.getText();
        model.setText(text);

        int wordCount = model.getWordCount();
        int lineCount = model.getLineCount();
        int charCount = model.getCharacterCount();
        int caretPos = view.textArea.getCaretPosition();
        int row = 1, col = 1;

        try {
            row = view.textArea.getLineOfOffset(caretPos) + 1;
            col = caretPos - view.textArea.getLineStartOffset(row - 1) + 1;
        } catch (Exception ignored) {}

        view.statusLabel.setText(" Words: " + wordCount +
                "  |  Lines: " + lineCount +
                "  |  Characters: " + charCount +
                "  |  Row: " + row + ", Col: " + col + " ");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "New":
                view.textArea.setText("");
                updateStatusBar(null);
                break;
            case "Open":
                int option = view.fileChooser.showOpenDialog(view);
                if (option == JFileChooser.APPROVE_OPTION) {
                    try {
                        model.openFile(view.fileChooser.getSelectedFile(), view.textArea);
                        updateStatusBar(null);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(view, "Error opening file", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            case "Save":
                int saveOption = view.fileChooser.showSaveDialog(view);
                if (saveOption == JFileChooser.APPROVE_OPTION) {
                    try {
                        model.saveFile(view.fileChooser.getSelectedFile(), view.textArea);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(view, "Error saving file", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            case "Exit":
                System.exit(0);
                break;
        }
    }
}

