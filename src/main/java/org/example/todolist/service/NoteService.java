package org.example.todolist.service;

import org.example.todolist.model.Note;
import org.example.todolist.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public void add(Note note) {
        noteRepository.save(note);
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
       noteRepository.save(note);
    }

    public Note getById(long id) {
        return noteRepository.findById(id).orElse(null);
    }

}
