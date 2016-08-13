package com.example.android.miwok;

/**
 * Created by Shoshaa on 8/9/16.
 */

public class Word {

    private String mEnglishTranslation;
    private String mMiwokTranslation;

    public Word(String englishWord, String miwokWord){

        this.mEnglishTranslation = englishWord;
        this.mMiwokTranslation = miwokWord;

    }

    public String getEnglishTranslation() {
        return mEnglishTranslation;
    }

    public void setEnglishTranslation(String mEnglishTranslation) {
        this.mEnglishTranslation = mEnglishTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public void setMiwokTranslation(String miwokTranslation) {
        this.mMiwokTranslation = miwokTranslation;
    }
}
