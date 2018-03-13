package innovizz.ecommerce.medicalremind.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.AlertDialog;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import innovizz.ecommerce.medicalremind.R;
import innovizz.ecommerce.medicalremind.model.TestBTN;

/**
 * Created by Hassan M Ashraful on 3/4/2018.
 */

public class TestADDAdapter extends RecyclerView.Adapter<TestADDAdapter.ViewHolder> {

    private ArrayList<TestBTN> arrayList;
    private Context mcontext;
    private List<Integer> colors;

    public String[] mColors = {"ffa000", "ff5722", "cddc39"};

    public TestADDAdapter(Context context, ArrayList<TestBTN> testBTNS) {
        this.arrayList = testBTNS;
        this.mcontext = context;
    }

    @Override
    public TestADDAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_test_add, parent, false);
        return new ViewHolder(view, arrayList, mcontext);

    }

    @Override
    public void onBindViewHolder(TestADDAdapter.ViewHolder holder, int position) {

        GradientDrawable draw = new GradientDrawable();
        draw.setShape(GradientDrawable.OVAL); draw.setSize(160, 250);
        draw.setColor(Color.parseColor("#"+mColors[new Random().nextInt(3)]));
        if (draw!=null)
        holder.textView.setBackground(draw);

        holder.textView.setText(arrayList.get(position).getTestName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;
        private ArrayList<TestBTN> testBTNS;
        private Context context;

        public ViewHolder(View v, ArrayList<TestBTN> testBTNS, Context context) {
            super(v);

            textView =  v.findViewById(R.id.testBTN); this.testBTNS = testBTNS; this.context = context;

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            final int position = getAdapterPosition();
            final TestBTN android = this.testBTNS.get(position);

            if (position == 0){
                //show dialog for first ADD item
                AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View dialogView = inflater.inflate(R.layout.custom_dialog, null);
                builder.setView(dialogView);

                final EditText edt = (EditText) dialogView.findViewById(R.id.editAlertDialog);

                builder.setTitle("Want to add Test..");
                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String testName = edt.getText().toString();
                        testBTNS.add(new TestBTN(testName));
                        notifyDataSetChanged();
                        Toast.makeText(context, testName, Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, "Canceled", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }else {
                Toast.makeText(context, android.getTestName(), Toast.LENGTH_SHORT).show();
            }

        }
    }




}
