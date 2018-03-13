package innovizz.ecommerce.medicalremind.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;


import innovizz.ecommerce.medicalremind.R;
import innovizz.ecommerce.medicalremind.adapter.MedicinListAdapter;

import innovizz.ecommerce.medicalremind.model.AddMedicinItem;


public class AddMedicineFragment extends DialogFragment {


    private String morning="";
    private String afternoon="";
    private String night="";
    private String mill="";
    private CheckBox checkBoxM;
    private CheckBox checkBoxA;
    private CheckBox checkBoxN;
    private CheckBox checkBoxAfterMill;
    private CheckBox checkBoxBeforeMill;

    private EditText madicineNameET;
    private ArrayList<AddMedicinItem>selection;
    private MedicinListAdapter mAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Making dialogbox fullscreen
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;

            //DialogBox will take 90% of the screen
            dialog.getWindow().setLayout((int) (getScreenWidth(getActivity()) * .9), (int) (getScreenWidth(getActivity()) * .9));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView =inflater.inflate(R.layout.fragment_add_medicine, container, false);


        checkBoxM = mView.findViewById(R.id.C_Morning);
        checkBoxA = mView.findViewById(R.id.C_Afternoon);
        checkBoxN = mView.findViewById(R.id.C_Night);
        checkBoxAfterMill = mView.findViewById(R.id.C_After_Mil);
        checkBoxBeforeMill = mView.findViewById(R.id.C_Befor_Mill);

        Button addMedsbutton = mView.findViewById(R.id.Add_Medicine_BTN);
        madicineNameET = mView.findViewById(R.id.medicine_name_ET);


        selection= new ArrayList<>();

        RecyclerView mRecyclerView =mView.findViewById(R.id.AM_RecyclearView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MedicinListAdapter(selection, getActivity());
        mRecyclerView.setAdapter(mAdapter);


        addMedsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkSelectedItem();

                String medicineName;
                medicineName = madicineNameET.getText().toString();
                selection.add(new AddMedicinItem(medicineName,morning,afternoon,night,mill));

                //After intserting the data into arraylist, all the fileds will be null again
                checkBoxM.setChecked(false); checkBoxA.setChecked(false); checkBoxN.setChecked(false);
                checkBoxAfterMill.setChecked(false); checkBoxBeforeMill.setChecked(false);
                madicineNameET.setText("");
                morning="";
                afternoon="";
                night="";
                mill="";

                mAdapter.notifyDataSetChanged();
            }
        });

        return mView;
    }

    private void checkSelectedItem() {

        if (checkBoxM.isChecked()) {
            morning="Morning";
        }

        if (checkBoxA.isChecked()) {
            afternoon="Afternoon";
        }

        if (checkBoxN.isChecked()) {
            night="Night";
        }

        if (checkBoxBeforeMill.isChecked()) {
            mill="Before Mill";
        }

        if (checkBoxAfterMill.isChecked()) {
            mill="After Mill";
        }
    }

    /*
    * This method will return the size of the screen
    * */
    public static int getScreenWidth(Activity activity) {
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);
        return size.x;
    }


}
