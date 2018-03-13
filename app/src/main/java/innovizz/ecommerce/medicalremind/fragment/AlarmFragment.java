package innovizz.ecommerce.medicalremind.fragment;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import innovizz.ecommerce.medicalremind.R;
import innovizz.ecommerce.medicalremind.adapter.TestNameSliderAdapter;

/**
 * Created by YTC on 2/28/2018.
 */

public class AlarmFragment extends Fragment {

    private RelativeLayout mMorningRelativeLayout;
    private RelativeLayout mAfternoonRelativeLayout;
    private RelativeLayout mNightRelativeLayout;

    private ViewPager mTestViewPager;
    private TestNameSliderAdapter mSliderAdapter;

    private Calendar mCalendar;

    private ImageView mAlarmMorningImageView;
    private ImageView mAlarmAfterNoonImageView;
    private ImageView mAlarmNightImageView;

    private CheckBox mSundayCheckBox;
    private CheckBox mMondayCheckBox;
    private CheckBox mTuesdayCheckBox;
    private CheckBox mWednesdayCheckBox;
    private CheckBox mThursdayCheckBox;
    private CheckBox mFridayCheckBox;
    private CheckBox mSaturdayCheckBox;
    private CheckBox mEverydayCheckBox;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View view = inflater.inflate(R.layout.alarm_layout,container,false);

        mMorningRelativeLayout = view.findViewById(R.id.relative_layout_morning);
        mAfternoonRelativeLayout = view.findViewById(R.id.relative_layout_afternoon);
        mNightRelativeLayout = view.findViewById(R.id.relative_layout_night);
        mTestViewPager = view.findViewById(R.id.view_pager_test);

        mSliderAdapter = new TestNameSliderAdapter(getContext());
        mTestViewPager.setAdapter(mSliderAdapter);

        mCalendar = Calendar.getInstance();

        mAlarmMorningImageView = view.findViewById(R.id.image_view_alarm_morning);
        mAlarmAfterNoonImageView = view.findViewById(R.id.image_view_alarm_afternoon);
        mAlarmNightImageView = view.findViewById(R.id.image_view_alarm_night);

        mSundayCheckBox = view.findViewById(R.id.check_box_sunday);
        mMondayCheckBox = view.findViewById(R.id.check_box_monday);
        mTuesdayCheckBox = view.findViewById(R.id.check_box_tuesday);
        mWednesdayCheckBox = view.findViewById(R.id.check_box_wednesday);
        mThursdayCheckBox = view.findViewById(R.id.check_box_thursday);
        mFridayCheckBox = view.findViewById(R.id.check_box_friday);
        mSaturdayCheckBox = view.findViewById(R.id.check_box_saturday);
        mEverydayCheckBox = view.findViewById(R.id.check_box_everyday);

        mMorningRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetAlarmDurationFragment alarmFragment = new SetAlarmDurationFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, alarmFragment)
                        .addToBackStack(null);
                transaction.commit();
            }
        });

        mAfternoonRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetAlarmDurationFragment alarmFragment = new SetAlarmDurationFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, alarmFragment)
                        .addToBackStack(null);
                transaction.commit();
            }
        });

        mNightRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetAlarmDurationFragment alarmFragment = new SetAlarmDurationFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, alarmFragment)
                        .addToBackStack(null);
                transaction.commit();
            }
        });

        mAlarmMorningImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTime();
            }
        });

        mAlarmAfterNoonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTime();
            }
        });

        mAlarmNightImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTime();
            }
        });

        mEverydayCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEverydayCheckBox.isChecked()) {
                    mSundayCheckBox.setChecked(true);
                    mMondayCheckBox.setChecked(true);
                    mTuesdayCheckBox.setChecked(true);
                    mWednesdayCheckBox.setChecked(true);
                    mThursdayCheckBox.setChecked(true);
                    mFridayCheckBox.setChecked(true);
                    mSaturdayCheckBox.setChecked(true);
                } else {
                    mSundayCheckBox.setChecked(false);
                    mMondayCheckBox.setChecked(false);
                    mTuesdayCheckBox.setChecked(false);
                    mWednesdayCheckBox.setChecked(false);
                    mThursdayCheckBox.setChecked(false);
                    mFridayCheckBox.setChecked(false);
                    mSaturdayCheckBox.setChecked(false);
                }
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.alarm_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                saveAlarm();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Saving alarm details for medicine and test
    private void saveAlarm() {
        Toast.makeText(getContext(), "Save is clicked", Toast.LENGTH_SHORT).show();
    }

    // Set the time for medicine alarm
    private void updateTime() {
        new TimePickerDialog(getActivity(), timeListener,
                mCalendar.get(Calendar.HOUR_OF_DAY),
                mCalendar.get(Calendar.MINUTE), false)
                .show();
    }

    TimePickerDialog.OnTimeSetListener timeListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
            String time = String.valueOf(hourOfDay) + ":" + String.valueOf(minute);
            Toast.makeText(getContext(), "" + time, Toast.LENGTH_SHORT).show();
        }
    };
}
