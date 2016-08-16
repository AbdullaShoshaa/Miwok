package com.example.android.miwok;

/**
 * Created by Shoshaa on 8/9/16.
 */

public class Word {

    private String mEnglishTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId;

    public Word(String englishWord, String miwokWord){

        this.mEnglishTranslation = englishWord;
        this.mMiwokTranslation = miwokWord;

    }

    public Word(String englishWord, String miwokWord, int imageResourceId){

        this.mEnglishTranslation = englishWord;
        this.mMiwokTranslation = miwokWord;
        this.mImageResourceId = imageResourceId;
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

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public void setImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }
}
