package innovizz.ecommerce.medicalremind.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import innovizz.ecommerce.medicalremind.R;

/**
 * Created by YTC on 2/28/2018.
 */

public class TipsFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tips_layout,container,false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();

        return view;
    }
}
