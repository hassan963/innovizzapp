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

public class HomeFragment extends Fragment {

    TextView textTV;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_layout,container,false);
       ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        textTV = view.findViewById(R.id.textTV);
        textTV.setText("Home");
        return view;
    }
}
