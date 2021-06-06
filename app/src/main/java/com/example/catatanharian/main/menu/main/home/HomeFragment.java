package com.example.catatanharian.main.menu.main.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.catatanharian.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private OnboardingAdapter onboardingAdapter;
    ViewPager2 viewPager;
    LinearLayout layoutOnboardIndicators;

    private void setupOnboardingItems(){

        List<OnboardingItem> onboardingItems = new ArrayList<>();

        OnboardingItem first = new OnboardingItem();
        first.setTitle("Selamat datang di aplikasi catatan harian");
        first.setImage(R.drawable.view1);

        OnboardingItem second = new OnboardingItem();
        second.setTitle("Klik catatan harian yang ada dibawah untuk memulainya");
        second.setImage(R.drawable.notes);

        OnboardingItem third = new OnboardingItem();
        third.setTitle("Selamat mencoba");
        third.setImage(R.drawable.view2);

        onboardingItems.add(first);
        onboardingItems.add(second);
        onboardingItems.add(third);

        onboardingAdapter = new OnboardingAdapter(onboardingItems);
    }

    private void setupOnboardingIndicators(){
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8,0,8,0);
        for (int i = 0; i < indicators.length; i++){
            indicators[i] = new ImageView(getActivity());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getActivity(),
                    R.drawable.onboarding_indicator_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnboardIndicators.addView(indicators[i]);
        }
    }

    private void setCurrentOnboardIndicator(int index){
        int childCount = layoutOnboardIndicators.getChildCount();
        for (int i = 0; i < childCount; i++){
            ImageView imageView = (ImageView) layoutOnboardIndicators.getChildAt(i);
            if (i == index){
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getActivity(), R.drawable.onboarding_indicator_active)
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getActivity(), R.drawable.onboarding_indicator_inactive)
                );
            }
        }
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Nullable
    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState){

        layoutOnboardIndicators = view.findViewById(R.id.layoutOnboardIndicators);

        setupOnboardingItems();

        viewPager = view.findViewById(R.id.onboardingViewPager);
        viewPager.setAdapter(onboardingAdapter);

        setupOnboardingIndicators();
        setCurrentOnboardIndicator(0);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardIndicator(position);
            }
        });
    }


}