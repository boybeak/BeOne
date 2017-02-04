package com.nulldreams.beone.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.nulldreams.adapter.impl.DelegateImpl;
import com.nulldreams.base.fragment.AbsPagerFragment;
import com.nulldreams.beone.R;
import com.nulldreams.beone.adapter.ContentDelegate;
import com.nulldreams.beone.adapter.ImageDelegate;
import com.nulldreams.beone.adapter.MovieDelegate;
import com.nulldreams.beone.adapter.MusicDelegate;
import com.nulldreams.beone.module.Content;

/**
 * Created by gaoyunfei on 2017/1/29.
 */

public abstract class ContentFragment extends AbsPagerFragment {

    private static final String TAG = ContentFragment.class.getSimpleName();

    private RecyclerView mRv;

    public abstract RecyclerView.LayoutManager getLayoutManager ();

    public abstract RecyclerView.Adapter getAdapter ();

    public abstract void getContent();

    @Override
    public CharSequence getTitle(Context context, Bundle bundle) {
        return null;
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        Animation anim;
        if (enter) {

            anim = AnimationUtils.loadAnimation(getContext(), android.R.anim.fade_in);
        } else {
            anim = AnimationUtils.loadAnimation(getContext(), android.R.anim.fade_out);
        }
        anim.setDuration(getContext().getResources().getInteger(android.R.integer.config_shortAnimTime));
        return anim;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content, null, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRv = (RecyclerView)view.findViewById(R.id.content_rv);
        mRv.setLayoutManager(getLayoutManager());
        mRv.setAdapter(getAdapter());

        getContent();
    }

    public DelegateImpl dispatchContent (Content content) {
        Log.v(TAG, "dispatchContent title=" + content.title + " content_type=" + content.content_type);
        switch (content.content_type) {
            case Content.TYPE_IMAGE:
                return new ImageDelegate(content);
            /*case Content.TYPE_ARTICLE:
                return new ArticleDelegate(content);
            case Content.TYPE_ESSAY:
                return new EssayDelegate(content);
            case Content.TYPE_FAQ:
                return*/
            case Content.TYPE_MUSIC:
                return new MusicDelegate(content);
            case Content.TYPE_MOVIE:
                return new MovieDelegate(content);
        }
        return new ContentDelegate(content);
    }
}
