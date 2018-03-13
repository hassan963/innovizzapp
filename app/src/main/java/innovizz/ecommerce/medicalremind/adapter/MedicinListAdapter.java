package innovizz.ecommerce.medicalremind.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import innovizz.ecommerce.medicalremind.R;
import java.util.ArrayList;

import innovizz.ecommerce.medicalremind.model.AddMedicinItem;

/**
 * Created by asif on 04-Mar-18.
 */

public class MedicinListAdapter extends RecyclerView.Adapter<MedicinListAdapter.ViewHolder> {
    private ArrayList<AddMedicinItem> arrayList;
    private Context context;

    public MedicinListAdapter(ArrayList<AddMedicinItem> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MedicinListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_medicine_row_layout, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MedicinListAdapter.ViewHolder holder, int position) {
        holder.medicineName.setText(arrayList.get(position).getMadicineName());
        holder.medicineMorning.setText(arrayList.get(position).getMorning());
        holder.medicineAfternoon.setText(arrayList.get(position).getAfternoon());
        holder.medicineNight.setText(arrayList.get(position).getNight());
        holder.medicineMillInfo.setText(arrayList.get(position).getMill());

    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView medicineName;
        private TextView medicineMorning;
        private TextView medicineAfternoon;
        private TextView medicineNight;
        private TextView medicineMillInfo;

        public ViewHolder(View view) {
            super(view);

            medicineName=view.findViewById(R.id.Medicine_NameTV);
            medicineMorning=view.findViewById(R.id.MorningTV);
            medicineAfternoon=view.findViewById(R.id.AfternoonTV);
            medicineNight=view.findViewById(R.id.NightTV);
            medicineMillInfo=view.findViewById(R.id.MillTV);

        }
    }


}
