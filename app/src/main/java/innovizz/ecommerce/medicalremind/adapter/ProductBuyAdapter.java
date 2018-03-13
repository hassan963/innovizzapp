package innovizz.ecommerce.medicalremind.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import innovizz.ecommerce.medicalremind.R;
import innovizz.ecommerce.medicalremind.model.ProductMedicine;

/**
 * Created by Ashraful Hassan on 3/12/2018.
 */

public class ProductBuyAdapter extends RecyclerView.Adapter<ProductBuyAdapter.ViewHolder> {

    private ArrayList<ProductMedicine> productMedicines;
    private Context mContext;

    public ProductBuyAdapter(Context context, ArrayList<ProductMedicine> productMedicines) {
        this.mContext = context;
        this.productMedicines = productMedicines;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_layout, parent, false);
        return new ViewHolder(view, productMedicines, mContext);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.medicineTitle.setText(productMedicines.get(position).getMedicineName());
        holder.medicinePrice.setText(productMedicines.get(position).getMedicinePrice());

        Glide.clear(holder.medicineImageView);
        Glide.with(mContext).load(productMedicines.get(position).getMedicineImage()).placeholder(R.drawable.profile).into(holder.medicineImageView);

    }

    @Override
    public int getItemCount() {
        return productMedicines.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView medicineTitle, medicinePrice;
        private Context context;
        private ImageView medicineImageView;

        public ViewHolder(View view, ArrayList<ProductMedicine> productMedicines, Context context) {
            super(view);

            medicineTitle = view.findViewById(R.id.medicineTitle); medicinePrice = view.findViewById(R.id.medicinePrice);
            medicineImageView = view.findViewById(R.id.medicineImageView);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

}
