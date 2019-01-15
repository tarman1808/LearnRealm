package com.rezita.armant.learnrealm;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MyViewHolder> {
    private List<MahasiswaModel> mahasiswaModels;
    Context context;

    public MahasiswaAdapter(Context context, List<MahasiswaModel> mahasiswaModels){
        this.context = context;
        this.mahasiswaModels = mahasiswaModels;
    }

    @Override
    public MahasiswaAdapter.MyViewHolder onCreateViewHolder(Viewgroup parent, int viewtype){

    }
}
