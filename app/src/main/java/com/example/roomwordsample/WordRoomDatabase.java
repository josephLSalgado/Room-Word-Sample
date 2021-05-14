package com.example.roomwordsample;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {
    // Instancia un objeto de la clase WordDao
    public abstract WordDao wordDao();

    // Previene tener múltiples instancias de la base de datos abierta al mismo tiempo
    private static volatile WordRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    // Ejecuta operaciones de base de datos de forma asincrónica en un subproceso de segundo plano
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    // Retorna una instancia única
    // Crea la base de datos la primera vez que se accede
    static WordRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class){
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
