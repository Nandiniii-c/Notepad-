
package com.mycompany.notepadapp;

import com.mycompany.notepadapp.controller.NotepadController;
import com.mycompany.notepadapp.model.NotepadModel;
import com.mycompany.notepadapp.view.NotepadView;

public class main {
    public static void main(String[] args) {
        NotepadModel model = new NotepadModel();
        NotepadView view = new NotepadView();
        new NotepadController(model, view);
    }
}

