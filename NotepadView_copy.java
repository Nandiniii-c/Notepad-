
package com.mycompany.notepadapp.view;


import javax.swing.*;
import java.awt.*;

public class NotepadView extends JFrame {
    public JTextArea textArea;
    public JScrollPane scrollPane;
    public JFileChooser fileChooser;
    public JMenuBar menuBar;
    public JLabel statusLabel;

    public JMenuItem newItem, openItem, saveItem, exitItem;
    public JMenuItem cutItem, copyItem, pasteItem;

    public NotepadView() {
        // Frame Setup
        setTitle("Notepad - MVC");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create text area
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER);

        // Create menu bar
        menuBar = new JMenuBar();
        createMenu();
        setJMenuBar(menuBar);

        // Create status bar
        createStatusBar();

        // File Chooser
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Text Files (*.txt)", "txt"));

        setVisible(true);
    }

    private void createMenu() {
        JMenu fileMenu = new JMenu("File");
        newItem = new JMenuItem("New");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Edit");
        cutItem = new JMenuItem("Cut");
        copyItem = new JMenuItem("Copy");
        pasteItem = new JMenuItem("Paste");

        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
    }

    private void createStatusBar() {
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusLabel = new JLabel(" Words: 0  |  Lines: 1  |  Characters: 0  |  Row: 1, Col: 1 ");
        statusPanel.setBorder(BorderFactory.createEtchedBorder());
        statusPanel.add(statusLabel, BorderLayout.WEST);
        add(statusPanel, BorderLayout.SOUTH);
    }
}

