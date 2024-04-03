package com.firdausdev.singlefighter.bfaa.myfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class OptionDialogFragment extends DialogFragment implements View.OnClickListener{
    private Button btnChoose, btnClose;
    private RadioGroup rgOptions;
    private RadioButton rbA, rbB,rbC,rbD;
    OnOptionDialogListener optionDialogListener;

    public OptionDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnChoose = view.findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(this);
        btnClose = view.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);
        rgOptions = view.findViewById(R.id.rg_options);
        rbA=view.findViewById(R.id.rb_a);
        rbB=view.findViewById(R.id.rb_b);
        rbC=view.findViewById(R.id.rb_c);
        rbD=view.findViewById(R.id.rb_d);

    }
    /*
    mengelola optionDialogListener ketika fragment dipanggil dan dimatikan
     */

    @Override
    public void onAttach( Context context) {
        super.onAttach(context);

        Fragment fragment = getParentFragment();

        if (fragment instanceof  DetailCategoryFragment){
            DetailCategoryFragment detailCategoryFragment = (DetailCategoryFragment) fragment;
            this.optionDialogListener = detailCategoryFragment.optionDialogListener;


        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.optionDialogListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_close:
                Objects.requireNonNull(getDialog()).cancel();
                break;

            case R.id.btn_choose:
                int checkedRadioButtonId = rgOptions.getCheckedRadioButtonId();
                if (checkedRadioButtonId != -1){
                    String coach = null;
                    switch (checkedRadioButtonId){
                        case R.id.rb_a:
                            coach = rbA.getText().toString().trim();
                            break;
                        case R.id.rb_b:
                            coach = rbB.getText().toString().trim();
                            break;
                        case R.id.rb_c:
                            coach = rbC.getText().toString().trim();
                            break;
                        case R.id.rb_d:
                            coach = rbD.getText().toString().trim();
                            break;
                    }
                     if (optionDialogListener != null){
                         optionDialogListener.onOptionChosen(coach);
                     }
                     Objects.requireNonNull(getDialog()).dismiss();
                }
                break;
        }
    }

    public interface OnOptionDialogListener{
        void onOptionChosen(String text);
    }
}
