package com.quran.surah;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.quran.R;
import com.quran.adapter.SurahAdapter;
import com.quran.common.Common;
import com.quran.databinding.SurahFragmentBinding;
import com.quran.listener.SurahListener;
import com.quran.model.SurahModel;
import com.quran.response.SurahResponse;
import java.util.ArrayList;

public class SurahFragment extends Fragment
{

    private SurahFragmentBinding binding;
    private SurahViewModel surahViewModel;

    private SurahAdapter surahAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        binding = SurahFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        surahViewModel = new ViewModelProvider(requireActivity()).get(SurahViewModel.class);

        binding.loadingSurah.setVisibility(View.VISIBLE);

        surahViewModel
                .getSurah()
                .observe(getViewLifecycleOwner(), new Observer<SurahResponse>()
                {
                    @Override
                    public void onChanged(SurahResponse surahResponse)
                    {
                        binding.loadingSurah.setVisibility(View.GONE);

                        ArrayList<SurahModel> surahModels = surahResponse.getSurahModels();
                        surahAdapter = new SurahAdapter(surahModels, new SurahListener()
                        {
                            @Override
                            public void onSurahListener(int position)
                            {
                                Bundle bundle = new Bundle();
                                bundle.putInt(Common.NUMBER_SURAH, surahModels.get(position).getSurahNumber());
                                bundle.putString(Common.NAME_SURAH, surahModels.get(position).getSurahName());
                                bundle.putInt(Common.TOTAL_AYA_OF_SURAH, surahModels.get(position).getSurahNumberOfAyahs());
                                bundle.putString(Common.TRANSLATION_SURAH, surahModels.get(position).getSurahEnglishNameTranslation());
                                bundle.putString(Common.TYPE_SURAH, surahModels.get(position).getSurahRevelationType());
                                Navigation.findNavController(view).navigate(R.id.action_surahFragment_to_surahDetailsFragment, bundle);
                            }
                        });
                        binding.rVSurah.setAdapter(surahAdapter);
                        binding.rVSurah.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false));
                    }
                });
    }
}