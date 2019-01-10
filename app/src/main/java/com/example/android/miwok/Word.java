package com.example.android.miwok;

public class Word {
    private String mMiwokTranslate;
    private String mDefaultTranslate;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudioresourceid= NO_AUDIO;
    private static final int NO_AUDIO = -11;

    public Word(String miwokTr, String defaultTr){
        mMiwokTranslate = miwokTr;
        mDefaultTranslate = defaultTr;
    }

    public Word(String miwokTr, String defaultTr, int imageResourceId, int audioResourceId){
        mMiwokTranslate = miwokTr;
        mDefaultTranslate = defaultTr;
        mImageResourceId = imageResourceId;
        mAudioresourceid = audioResourceId;
    }

    public String getMiwokTranslate(){
        return  mMiwokTranslate;
    }

    public String getDefaultTranslate(){
        return  mDefaultTranslate;
    }

    public int getImageResourceId(){

        return mImageResourceId;
    }

    public boolean hasImage(){

        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getAudioresourceid(){
        return mAudioresourceid;
    }

    public boolean hasAudio(){
        return mAudioresourceid != NO_AUDIO;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mMiwokTranslate='" + mMiwokTranslate + '\'' +
                ", mDefaultTranslate='" + mDefaultTranslate + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioresourceid=" + mAudioresourceid +
                '}';
    }
}
