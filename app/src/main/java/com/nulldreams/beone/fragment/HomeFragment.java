package com.nulldreams.beone.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.nulldreams.adapter.DelegateAdapter;
import com.nulldreams.adapter.DelegateParser;
import com.nulldreams.adapter.impl.DelegateImpl;
import com.nulldreams.beone.manager.OneManager;
import com.nulldreams.beone.adapter.ContentDelegate;
import com.nulldreams.beone.module.Content;
import com.nulldreams.beone.module.OneList;
import com.nulldreams.beone.retrofit.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gaoyunfei on 2017/1/31.
 */

public class HomeFragment extends ContentFragment {

    private static final String TAG = HomeFragment.class.getSimpleName();

    public static HomeFragment newInstance () {
        HomeFragment fragment = new HomeFragment();
        return fragment;
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
        OneManager.getInstance(getContext()).getIdList(new Callback<Result<int[]>>() {
            @Override
            public void onResponse(Call<Result<int[]>> call, Response<Result<int[]>> response) {
                Log.v(TAG, "onResponse " + response.body().data.length);
                OneManager.getInstance(getContext()).getOneList(response.body().data[0], new Callback<Result<OneList>>() {
                    @Override
                    public void onResponse(Call<Result<OneList>> call, Response<Result<OneList>> response) {
                        Log.v(TAG, "onResponse " + response.body().data.content_list.length);
                        mAdapter.addAll(response.body().data.content_list, new DelegateParser<Content>() {
                            @Override
                            public DelegateImpl parse(Content data) {
                                return dispatchContent(data);
                            }
                        });
                        mAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<Result<OneList>> call, Throwable t) {
                        Log.v(TAG, "onFailure " + t.getLocalizedMessage());
                    }
                });
            }

            @Override
            public void onFailure(Call<Result<int[]>> call, Throwable t) {
                Log.v(TAG, "onFailure " + t.getLocalizedMessage());
            }
        });
    }
}
