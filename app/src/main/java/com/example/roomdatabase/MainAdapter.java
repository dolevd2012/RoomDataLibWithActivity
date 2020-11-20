package com.example.roomdatabase;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dbroom.MainData;
import com.example.dbroom.RoomDB;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<MainData> dataList;
    private Activity context;
    private RoomDB database;

    public MainAdapter(List<MainData> dataList, Activity context) {
        this.dataList = dataList;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_main,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainData data = dataList.get(position);
        database = RoomDB.getInstance(context);
        holder.textView.setText(data.getString());
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainData d =dataList.get(holder.getAdapterPosition());
                int sID = d.getID();
                String sText = d.getString();

                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_update);

                int width = WindowManager.LayoutParams.MATCH_PARENT;
                int height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.getWindow().setLayout(width,height);
                dialog.show();


                EditText editText = dialog.findViewById(R.id.MainAdapter_ET_text);
                MaterialButton btnUpdate = dialog.findViewById(R.id.MainAdapter_BTN_update);

                editText.setText(sText);
                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        String uText =editText.getText().toString().trim();
                        database.mainDao().updateString(sID,uText);
                        dataList.clear();
                        dataList.addAll(database.mainDao().getAll());
                        notifyDataSetChanged();
                    }
                });
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainData d = dataList.get(holder.getAdapterPosition());
                database.mainDao().delete(d);
                int position = holder.getAdapterPosition();
                dataList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,dataList.size());
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView btnEdit,btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.listRowMain_TV_name);
            btnEdit = itemView.findViewById(R.id.listRowMain_IV_edit);
            btnDelete = itemView.findViewById(R.id.listRowMain_IV_delete);
        }
    }
}
