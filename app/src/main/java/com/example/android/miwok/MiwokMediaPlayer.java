package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

/**
 * Created by Shoshaa on 8/17/16.
 */

public class MiwokMediaPlayer {

    private MediaPlayer mMediaPlayer;
    private Context mContext;
    private AudioManager mAudioManager;
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    private AudioManager.OnAudioFocusChangeListener focusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                // Pause playback because your Audio Focus was
                // temporarily stolen, but will be back soon.
                // i.e. for a phone call
                mMediaPlayer.pause();
                //after pausing it's better for the user to hear the word again as a whole.
                //so we move the seeker to start position.
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // Stop playback, because you lost the Audio Focus.
                // i.e. the user started some other playback app
                // Remember to unregister your controls/buttons here.
                // And release the kra — Audio Focus!
                // You’re done.
                //and don't forget to clean up the resources, luckily we have our helper method.
                releaseMediaPlayer();
            } else if (focusChange ==
                    AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // Lower the volume, because something else is also
                // playing audio over you.
                // i.e. for notifications or navigation directions
                // Depending on your audio playback, you may prefer to
                // pause playback here instead. You do you.
                //or in case of Miwok app it's better to replay the word pronunciation again.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // Resume playback, because you hold the Audio Focus
                // again!
                // i.e. the phone call ended or the nav directions
                // are finished
                // If you implement ducking and lower the volume, be
                // sure to return it to normal here, as well.
                mMediaPlayer.start();
            }
        }
    };

    public MiwokMediaPlayer(Context context){
        this.mContext = context;
    }

    public void playWord(int resourceId){

        mAudioManager =(AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);

        /*
        release the media player before playing the audio, so in case the user clicked the list items quickly it will stop
        and release the mediaPlayer object.
        if the user clicks fast on list items then the onCompletion Listener will not complete.
         */
        releaseMediaPlayer();

        int requestResult = mAudioManager.requestAudioFocus(focusChangeListener,
                AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

        if(requestResult == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
            //mAudioManager.registerMediaButtonEventReceiver();
            mMediaPlayer = MediaPlayer.create(mContext, resourceId);


            mMediaPlayer.start();
            mMediaPlayer.setOnCompletionListener(onCompletionListener);
        }





    }

    /**
     * Clean up the media player by releasing its resources.
     */
    public void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
            //abondan AudioFocus after releasing the mediaPlayer
            mAudioManager.abandonAudioFocus(focusChangeListener);
        }
    }
}
