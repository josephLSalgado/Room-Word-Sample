package com.example.roomwordsample;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

// El Repositorio permite administra consultas y permite usar múltiples backends.
public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    // Room ejecuta todas las consultas en un hilo separado
    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    void insert(Word word) {
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
            mWordDao.insert(word);
        });
    }
}
