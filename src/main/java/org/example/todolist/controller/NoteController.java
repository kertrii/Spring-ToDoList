package org.example.todolist.controller;

import jakarta.validation.Valid;
import org.example.todolist.model.Note;
import org.example.todolist.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/note")
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public List<Note> listNotes() {
        return noteService.listAll();
    }

    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable("id") long id) {
        noteService.deleteById(id);
        return "Note with id " + id + " deleted";
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable("id") long id) {
        return noteService.getById(id);
    }

    @PutMapping("/edit")
    public Note editNote(@Valid @RequestBody Note note) {
        noteService.update(note);
        return note;
    }

    @PostMapping("/create")
    public Note createNote(@Valid @RequestBody Note note) {
        noteService.add(note);
        return note;
    }
}
