package com.jrsmiffy.springguru.recipes.converter;

import com.jrsmiffy.springguru.recipes.command.NotesCommand;
import com.jrsmiffy.springguru.recipes.model.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Synchronized @Nullable @Override
    public NotesCommand convert(Notes source) {
        if (source == null) return null;

        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(source.getId());
        notesCommand.setContent(source.getContent());
        return notesCommand;
    }
}