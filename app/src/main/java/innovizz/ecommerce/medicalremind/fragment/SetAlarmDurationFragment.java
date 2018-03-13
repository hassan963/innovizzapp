package innovizz.ecommerce.medicalremind.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import innovizz.ecommerce.medicalremind.R;
import innovizz.ecommerce.medicalremind.adapter.ProductBuyAdapter;
import innovizz.ecommerce.medicalremind.model.ProductMedicine;

/**
 * A simple {@link Fragment} subclass.
 */
public class SetAlarmDurationFragment extends Fragment {


    public SetAlarmDurationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_set_alarm_duration, container, false);

        initProductAdapter(view);

        return view;
    }

    /*
    * Initiating recyclerview adpater for Medicine product
    * */
    private void initProductAdapter(View view){
        RecyclerView mRecyclerView =  view.findViewById(R.id.medicineBuyRecyclerview);

        ArrayList<ProductMedicine> productMedicines = prepareProducts();
        ProductBuyAdapter mAdapter = new ProductBuyAdapter(getActivity(), productMedicines);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

    }

    /*
    * this method is used for preparing medicine products, this method is used in initProducttAdapter()
    * */
    private ArrayList<ProductMedicine> prepareProducts() {
        ArrayList<ProductMedicine> productMedicines = new ArrayList<>();
        productMedicines.add(new ProductMedicine("Seclo","340TK","http://www.healthprior21.com/files/product_files/SECLO-20.jpg"));
        productMedicines.add(new ProductMedicine("Napa","120TK","https://www.beximcopharma.com/images/sobipro/product-pic/napa-iv.jpg"));
        productMedicines.add(new ProductMedicine("Osatril","220TK","https://www.thespeedpharma.com/file/2017/07/Osartil-100mg.jpg"));
        productMedicines.add(new ProductMedicine("Seclo","340TK","http://www.healthprior21.com/files/product_files/SECLO-20.jpg"));
        productMedicines.add(new ProductMedicine("Seclo","340TK","http://www.healthprior21.com/files/product_files/SECLO-20.jpg"));
        productMedicines.add(new ProductMedicine("Seclo","340TK","http://www.healthprior21.com/files/product_files/SECLO-20.jpg"));
        productMedicines.add(new ProductMedicine("Seclo","340TK","http://www.healthprior21.com/files/product_files/SECLO-20.jpg"));
        productMedicines.add(new ProductMedicine("Seclo","340TK","http://www.healthprior21.com/files/product_files/SECLO-20.jpg"));
        productMedicines.add(new ProductMedicine("Seclo","340TK","http://www.healthprior21.com/files/product_files/SECLO-20.jpg"));
        productMedicines.add(new ProductMedicine("Seclo","340TK","http://www.healthprior21.com/files/product_files/SECLO-20.jpg"));
        productMedicines.add(new ProductMedicine("Seclo","340TK","http://www.healthprior21.com/files/product_files/SECLO-20.jpg"));

        return productMedicines;
    }
}
