package com.example.sarthak.certificationproject.Model;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sarthak.certificationproject.R;
import com.squareup.picasso.Picasso;


/**
 * Created by Sarthak on 2/8/2016.
 */
public class MovieAdapter extends BaseAdapter{

    Context ctx;
    MovieModel model[];

    public MovieAdapter(Context ctx, MovieModel[] model) {
        this.ctx = ctx;
        this.model = model;
    }

    @Override
    public int getCount() {
        return model.length;
    }

    @Override
    public Object getItem(int position) {
        return model[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View myView= LayoutInflater.from(ctx).inflate(R.layout.list_row,parent,false);
        ImageView iv= (ImageView) myView.findViewById(R.id.FirstImageView);
        TextView txtName=(TextView)myView.findViewById(R.id.name);
        txtName.setText(model[position].movie.title);
        ProgressDialog dialog=new ProgressDialog(ctx);
        dialog.setMessage("Displaying Image...");
        dialog.setCancelable(false);
        dialog.show();
        Picasso.with(ctx).load(model[position].movie.images.poster.thumb).fit().into(iv);
        dialog.dismiss();
        return myView;
    }
}
