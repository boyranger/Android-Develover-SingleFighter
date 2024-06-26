package com.firdausdev.singlefighter.bfaa.myfragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailCategoryFragment extends Fragment implements View.OnClickListener {
    private TextView tvCategoryName, tvCategoryDesc;

    static String EXTRA_NAME = "extra_name";
    public static String EXTRA_DESC = "extra_desc";
    private String desc;

    private String getDesc() {
        return desc;
    }

    void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvCategoryName=view.findViewById(R.id.tv_category_name);
        tvCategoryDesc=view.findViewById(R.id.tv_category_desc);
        Button btnProfile = view.findViewById(R.id.btn_profile);
        btnProfile.setOnClickListener(this);
        Button btnShowDialog = view.findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(this);
    }

    public DetailCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        assert getArguments() != null;
        String categoryName = getArguments().getString(EXTRA_NAME);
        tvCategoryName.setText(categoryName);
        tvCategoryDesc.setText(getDesc());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_profile:
                Intent mIntent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_show_dialog:
                OptionDialogFragment mOptionDialogFragment = new OptionDialogFragment();

                FragmentManager mFragmentManager = getChildFragmentManager();
                mOptionDialogFragment.show(mFragmentManager, OptionDialogFragment.class.getSimpleName());
                break;
        }
    }

    public  final OptionDialogFragment.OnOptionDialogListener optionDialogListener = new OptionDialogFragment.OnOptionDialogListener() {
        @Override
        public void onOptionChosen(String text) {
            Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
        }
    };
}