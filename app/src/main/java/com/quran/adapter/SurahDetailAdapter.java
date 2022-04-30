package com.quran.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.quran.databinding.ItemSurahDetailBinding;
import com.quran.model.SurahDetailModel;

import java.util.ArrayList;

public class SurahDetailAdapter extends RecyclerView.Adapter<SurahDetailAdapter.SurahDetailViewHolder>
{

    private ArrayList<SurahDetailModel> surahDetailModels;

    public SurahDetailAdapter(ArrayList<SurahDetailModel> surahDetailModels)
    {
        this.surahDetailModels = surahDetailModels;
    }

    @NonNull
    @Override
    public SurahDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new SurahDetailViewHolder(ItemSurahDetailBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SurahDetailViewHolder holder, int position)
    {
        SurahDetailModel model = surahDetailModels.get(position);
        holder.surahDetailBinding.itemTxtNumberAyahSurahDetails.setText(model.getAya());
        holder.surahDetailBinding.itemTxtArabicAyahSurahDetails.setText(model.getAyahArabicText());
        holder.surahDetailBinding.itemTxtTranlsationAyahSurahDetails.setText(model.getAyahTranslation());
    }

    @Override
    public int getItemCount()
    {
        return surahDetailModels.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void filter(ArrayList<SurahDetailModel> detailModels)
    {
        surahDetailModels = detailModels;
        notifyDataSetChanged();
    }

    public class SurahDetailViewHolder extends RecyclerView.ViewHolder
    {

        private ItemSurahDetailBinding surahDetailBinding;

        public SurahDetailViewHolder(@NonNull ItemSurahDetailBinding surahDetailBinding)
        {
            super(surahDetailBinding.getRoot());
            this.surahDetailBinding = surahDetailBinding;
        }
    }
}
