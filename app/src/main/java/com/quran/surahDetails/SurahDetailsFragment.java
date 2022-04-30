package com.quran.surahDetails;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.quran.adapter.SurahDetailAdapter;
import com.quran.common.Common;
import com.quran.databinding.SurahDetailsFragmentBinding;
import com.quran.model.SurahDetailModel;
import com.quran.response.SurahDetailsResponse;

import java.util.ArrayList;

public class SurahDetailsFragment extends Fragment
{

    private SurahDetailsFragmentBinding binding;
    private SurahDetailsViewModel surahDetailsViewModel;

    private int no;

    private SurahDetailAdapter surahDetailAdapter;

    private String englishSaheeh = "english_saheeh";
    private String spanishGarcia = "spanish_garcia";
    private String chineseMakin = "chinese_makin";
    private String turkishShaban = "turkish_shaban";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        binding = SurahDetailsFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @SuppressLint({"SetTextI18n", "ClickableViewAccessibility"})
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        surahDetailsViewModel = new ViewModelProvider(requireActivity()).get(SurahDetailsViewModel.class);

        binding.loadingSurahDetail.setVisibility(View.VISIBLE);

        no = getArguments().getInt(Common.NUMBER_SURAH, 0);

        binding.surahTxtEnglishName.setText(getArguments().getString(Common.NAME_SURAH));
        binding.surahTxtType.setText(getArguments().getString(Common.TYPE_SURAH) + " " + getArguments().getInt(Common.TOTAL_AYA_OF_SURAH) + " Aya");
        binding.surahTxtTranslation.setText(getArguments().getString(Common.TRANSLATION_SURAH));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(requireActivity(), android.R.layout.simple_list_item_1, Common.LANGUAGES);
        binding.edtNameLanguage.setAdapter(adapter);

        binding.imgBtnTranslate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String nameLanguage = binding.edtNameLanguage.getText().toString();

                if (TextUtils.isEmpty(nameLanguage))
                {
                    Toast.makeText(requireContext(), "Please enter name language", Toast.LENGTH_SHORT).show();
                    binding.edtNameLanguage.requestFocus();
                    binding.rVSurahDetails.setAdapter(null);
                    binding.loadingSurahDetail.setVisibility(View.VISIBLE);
                    return;
                }

                if (nameLanguage.equals("English") || nameLanguage.equals("english"))
                {
                    surahDetailsViewModel
                            .getSurahDetails(englishSaheeh, no)
                            .observe(getViewLifecycleOwner(), new Observer<SurahDetailsResponse>()
                            {
                                @Override
                                public void onChanged(SurahDetailsResponse surahDetailsResponse)
                                {
                                    binding.loadingSurahDetail.setVisibility(View.GONE);

                                    ArrayList<SurahDetailModel> surahDetailModels = surahDetailsResponse.getSurahDetailModels();
                                    surahDetailAdapter = new SurahDetailAdapter(surahDetailModels);
                                    binding.rVSurahDetails.setAdapter(surahDetailAdapter);
                                    binding.rVSurahDetails.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false));
                                }
                            });
                }

                if (nameLanguage.equals("Spanish") || nameLanguage.equals("spanish"))
                {
                    surahDetailsViewModel
                            .getSurahDetails(spanishGarcia, no)
                            .observe(getViewLifecycleOwner(), new Observer<SurahDetailsResponse>()
                            {
                                @Override
                                public void onChanged(SurahDetailsResponse surahDetailsResponse)
                                {
                                    binding.loadingSurahDetail.setVisibility(View.GONE);

                                    ArrayList<SurahDetailModel> surahDetailModels = surahDetailsResponse.getSurahDetailModels();
                                    surahDetailAdapter = new SurahDetailAdapter(surahDetailModels);
                                    binding.rVSurahDetails.setAdapter(surahDetailAdapter);
                                    binding.rVSurahDetails.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false));
                                }
                            });
                }

                if (nameLanguage.equals("Chinese") || nameLanguage.equals("chinese"))
                {
                    surahDetailsViewModel
                            .getSurahDetails(chineseMakin, no)
                            .observe(getViewLifecycleOwner(), new Observer<SurahDetailsResponse>()
                            {
                                @Override
                                public void onChanged(SurahDetailsResponse surahDetailsResponse)
                                {
                                    binding.loadingSurahDetail.setVisibility(View.GONE);

                                    ArrayList<SurahDetailModel> surahDetailModels = surahDetailsResponse.getSurahDetailModels();
                                    surahDetailAdapter = new SurahDetailAdapter(surahDetailModels);
                                    binding.rVSurahDetails.setAdapter(surahDetailAdapter);
                                    binding.rVSurahDetails.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false));
                                }
                            });
                }

                if (nameLanguage.equals("Turkish") || nameLanguage.equals("turkish"))
                {
                    surahDetailsViewModel
                            .getSurahDetails(turkishShaban, no)
                            .observe(getViewLifecycleOwner(), new Observer<SurahDetailsResponse>()
                            {
                                @Override
                                public void onChanged(SurahDetailsResponse surahDetailsResponse)
                                {
                                    binding.loadingSurahDetail.setVisibility(View.GONE);

                                    ArrayList<SurahDetailModel> surahDetailModels = surahDetailsResponse.getSurahDetailModels();
                                    surahDetailAdapter = new SurahDetailAdapter(surahDetailModels);
                                    binding.rVSurahDetails.setAdapter(surahDetailAdapter);
                                    binding.rVSurahDetails.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false));
                                }
                            });
                }
            }
        });
    }
}