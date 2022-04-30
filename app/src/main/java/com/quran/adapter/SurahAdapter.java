package com.quran.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.quran.databinding.ItemSurahBinding;
import com.quran.listener.SurahListener;
import com.quran.model.SurahModel;

import java.util.ArrayList;

public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.SurahViewHolder>
{

    private ArrayList<SurahModel> surahModels;
    private SurahListener surahListener;

    public SurahAdapter(ArrayList<SurahModel> surahModels, SurahListener surahListener)
    {
        this.surahModels = surahModels;
        this.surahListener = surahListener;
    }

    @NonNull
    @Override
    public SurahViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new SurahViewHolder(ItemSurahBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false), surahListener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SurahViewHolder holder, int position)
    {
        SurahModel model = surahModels.get(position);
        holder.surahBinding.itemSurahTxtNumberAyah.setText(String.valueOf(model.getSurahNumber()));
        holder.surahBinding.itemSurahTxtTotalNumberAyah.setText("Aya: " + model.getSurahNumberOfAyahs());
        holder.surahBinding.itemSurahTxtEnglishName.setText(model.getSurahEnglishName());
        holder.surahBinding.itemSurahTxtArabicName.setText(model.getSurahName());
    }

    @Override
    public int getItemCount()
    {
        return surahModels.size();
    }

    public class SurahViewHolder extends RecyclerView.ViewHolder
    {

        private ItemSurahBinding surahBinding;
        private SurahListener surahListener;

        public SurahViewHolder(@NonNull ItemSurahBinding surahBinding, SurahListener surahListener)
        {
            super(surahBinding.getRoot());
            this.surahBinding = surahBinding;

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    surahListener.onSurahListener(getAdapterPosition());
                }
            });
        }
    }
}
