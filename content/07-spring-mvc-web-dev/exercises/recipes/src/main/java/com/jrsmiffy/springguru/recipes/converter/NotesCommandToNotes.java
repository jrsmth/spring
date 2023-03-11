package com.jrsmiffy.springguru.recipes.converter;

import com.jrsmiffy.springguru.recipes.command.NotesCommand;
import com.jrsmiffy.springguru.recipes.model.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Synchronized @Nullable @Override
    public Notes convert(NotesCommand source) {
        if (source == null) return null;

        final Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setContent(source.getContent());
        return notes;
    }
}