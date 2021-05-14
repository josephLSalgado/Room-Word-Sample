package com.example.roomwordsample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

// Clase abstracta que valida el SQL en tiempo de compilación y lo asocia con un método.
// Sirve para crear una API limpia para el código.
// Por defecto, todas las consultas se hacen en un hilo separado.
@Dao
public interface WordDao {
    // Permite la inserción de la misma palabra varias veces mediante la aprobación de una
    // estrategia de resolución de conflictos.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    // Elimina todas las palabras
    @Query("DELETE FROM word_table")
    void deleteAll();

    // Obtiene todas las palabras ordenadas alfabéticamente
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAlphabetizedWords();
    // Se agregó LiveData porque es un contenedor de datos observable, optimizado para ciclos de
    // vida
}
