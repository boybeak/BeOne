package com.nulldreams.beone.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nulldreams.adapter.DelegateAdapter;
import com.nulldreams.adapter.DelegateParser;
import com.nulldreams.adapter.impl.DelegateImpl;
import com.nulldreams.beone.manager.OneManager;
import com.nulldreams.beone.adapter.ContentDelegate;
import com.nulldreams.beone.module.Content;
import com.nulldreams.beone.retrofit.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gaoyunfei on 2017/2/1.
 */

public class ReadingFragment extends ContentFragment {

    public static ReadingFragment newInstance () {
        return new ReadingFragment();
    }

    private DelegateAdapter mAdapter;

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        if (mAdapter == null) {
            mAdapter = new DelegateAdapter(getContext());
        }
        return mAdapter;
    }

    @Override
    public void getContent() {
        OneManager.getInstance(getContext()).getReadingList(0, new Callback<Result<List<Content>>>() {
            @Override
            public void onResponse(Call<Result<List<Content>>> call, Response<Result<List<Content>>> response) {
                mAdapter.addAll(response.body().data, new DelegateParser<Content>() {
                    @Override
                    public DelegateImpl parse(Content data) {
                        return dispatchContent(data);
                    }
                });
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Result<List<Content>>> call, Throwable t) {

            }
        });
    }
}
