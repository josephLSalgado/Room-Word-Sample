package com.example.roomwordsample;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// La clase Word describe la Entidad (que representa la tabla SQLite) para las palabras.
// Cada propiedad en la clase representa una columna en la tabla.
@Entity(tableName = "word_table")
public class Word {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    // Constructor
    public Word(@NonNull String word) {this.mWord = word;}

    // Método getter
    public String getWord() {return this.mWord;}
}
