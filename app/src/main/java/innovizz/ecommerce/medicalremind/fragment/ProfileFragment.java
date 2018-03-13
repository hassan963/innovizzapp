package innovizz.ecommerce.medicalremind.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Handler;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import innovizz.ecommerce.medicalremind.R;
import innovizz.ecommerce.medicalremind.adapter.ProductBuyAdapter;
import innovizz.ecommerce.medicalremind.adapter.SlidingImage_Adapter;
import innovizz.ecommerce.medicalremind.adapter.TestADDAdapter;
import innovizz.ecommerce.medicalremind.model.ProductMedicine;
import innovizz.ecommerce.medicalremind.model.TestBTN;
import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

/**
 * Created by Hassan M Ashraful on 2/28/2018.
 * Hassan M Ashraful ID: 102015
 */



public class ProfileFragment extends Fragment {

    private ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES = {R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    private GraphView graphView;
    private TextView testTitleTextView, testDateTextView;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_layout,container,false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();

        graphView = view.findViewById(R.id.graph);  initialiseGraph();
        initTestAdapter(view);

        testTitleTextView = view.findViewById(R.id.testTitleTextView);
        testDateTextView = view.findViewById(R.id.testDateTextView);
        testTitleTextView.setText("Blood Pressure");
        testDateTextView.setText("Last Taken: 04.03.2018");

        TextView addMedicineText = view.findViewById(R.id.addMedicineButton);

        /*TextView tipsTextView = view.findViewById(R.id.tipsTextView);
        tipsTextView.setSelected(true);  // Set focus to the textview
        tipsTextView.setSingleLine(true);
        tipsTextView.setText("*** Try to walk to office ***  *** 7 days weight loss program ***");*/


        BannerSlider bannerSlider = (BannerSlider) view.findViewById(R.id.banner_slider1);
        List<Banner> banners=new ArrayList<>();
        //add banner using image url
        banners.add(new RemoteBanner("https://support.squarespace.com/hc/en-us/article_attachments/210462168/special-page-banner.jpg"));
        banners.add(new RemoteBanner("https://support.squarespace.com/hc/en-us/article_attachments/210462168/special-page-banner.jpg"));
        banners.add(new RemoteBanner("https://support.squarespace.com/hc/en-us/article_attachments/210462168/special-page-banner.jpg"));
        //add banner using resource drawable
        // banners.add(new DrawableBanner(R.drawable.profile)); banners.add(new DrawableBanner(R.drawable.profile));  banners.add(new DrawableBanner(R.drawable.profile));

        bannerSlider.setBanners(banners);

        addMedicineText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                AddMedicineFragment dialogFragment = new AddMedicineFragment(); // initialising the AddMedicineFragment dialogbox
                dialogFragment.show(fm, "Sample Fragment"); // will appear the dialog box

            }
        });

        initialiseTipsBanner(view);

        initProducttAdapter(view);


        return view;
    }

    /*
    * Initializing the tips banner, calling from oncreateview
    * */

    private void initialiseTipsBanner(View view) {

        Collections.addAll(ImagesArray, IMAGES);

        mPager = view.findViewById(R.id.tipspager);


        mPager.setAdapter(new SlidingImage_Adapter(getActivity(),ImagesArray));


        NUM_PAGES = IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };

        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 5000, 5000);


    }


    private void initialiseGraph(){

        LineGraphSeries<DataPoint> low = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(1, 80),
                new DataPoint(2, 70),
                new DataPoint(3, 65),
                new DataPoint(4, 90)
        });
        graphView.addSeries(low);

        LineGraphSeries<DataPoint> lowStandard = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(1, 80),
                new DataPoint(2, 80),
                new DataPoint(3, 80),
                new DataPoint(4, 80)
        });
        low.setColor(Color.GREEN);
        lowStandard.setColor(Color.GREEN);
        graphView.addSeries(lowStandard);

        LineGraphSeries<DataPoint> high = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(1, 130),
                new DataPoint(2, 150),
                new DataPoint(3, 190),
                new DataPoint(4, 125)
        });
        graphView.addSeries(high);

        LineGraphSeries<DataPoint> highStandard = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(1, 120),
                new DataPoint(2, 120),
                new DataPoint(3, 120),
                new DataPoint(4, 120)
        });
        high.setColor(Color.BLUE);
        highStandard.setColor(Color.BLUE);
        graphView.addSeries(highStandard);



    }




    /*
    * Initialising adapetr with arraylist data
    * This method is called from onCreateView()
    *
    * */

    private void initTestAdapter(View view){
        RecyclerView mRecyclerView =  view.findViewById(R.id.testRecyclerview);

        ArrayList<TestBTN> testBTNS = prepareData();
        TestADDAdapter mAdapter = new TestADDAdapter(getActivity(), testBTNS);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);




    }

    /*
    * This method returns static data for adapter
    * calling this method from initTestAdapter() mehtod
    * */

    private ArrayList<TestBTN> prepareData() {
        ArrayList<TestBTN> testBTNS = new ArrayList<>();
        testBTNS.add(new TestBTN(" ADD "));
        testBTNS.add(new TestBTN(" BD "));
        testBTNS.add(new TestBTN(" FG "));
        testBTNS.add(new TestBTN(" SW "));
        testBTNS.add(new TestBTN(" QR "));
        testBTNS.add(new TestBTN(" TR "));
        testBTNS.add(new TestBTN(" UI "));
        testBTNS.add(new TestBTN(" AB "));
        testBTNS.add(new TestBTN(" BD "));
        testBTNS.add(new TestBTN(" FG "));
        testBTNS.add(new TestBTN(" SW "));
        testBTNS.add(new TestBTN(" QR "));
        testBTNS.add(new TestBTN(" TR "));
        testBTNS.add(new TestBTN(" UI "));

        return testBTNS;
    }

    /*
    * Initiating recyclerview adpater for Medicine product
    * */
    private void initProducttAdapter(View view){
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
