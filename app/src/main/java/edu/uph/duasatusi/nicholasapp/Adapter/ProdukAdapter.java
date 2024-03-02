package edu.uph.duasatusi.nicholasapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import edu.uph.duasatusi.nicholasapp.Model.Produk;
import edu.uph.duasatusi.nicholasapp.R;

public class ProdukAdapter extends ArrayAdapter<Produk> {
    private ArrayList<Produk> produkArrayList;
    Context context;

    public ProdukAdapter( ArrayList<Produk> produkArrayList, Context context) {
        super(context, R.layout.item_list_layout,produkArrayList);
        this.produkArrayList = produkArrayList;
        this.context = context;
    }

    private static class MyViewHolder{
        ImageView imageProduk;
        TextView txtNamaProduk;
        TextView txtHargaProduk;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Produk produk = getItem(position);
        final View result;

        MyViewHolder myViewHolder;
        myViewHolder = new MyViewHolder();
        LayoutInflater infLater = LayoutInflater.from(getContext());
        convertView = infLater.inflate(R.layout.item_list_layout,parent,false);

        myViewHolder.imageProduk = (ImageView) convertView.findViewById(R.id.imageProduct);
        myViewHolder.txtNamaProduk = (TextView) convertView.findViewById(R.id.txtNamaProduk);
        myViewHolder.txtHargaProduk = (TextView) convertView.findViewById(R.id.txtHargaProduk);

        convertView.setTag(myViewHolder);
        result = convertView;
        myViewHolder.imageProduk.setImageResource(produk.getGambarProduk());
        myViewHolder.txtHargaProduk.setText("IDR"+ produk.getHargaProduk());
        myViewHolder.txtNamaProduk.setText(produk.getNamaProduk());
        return result;
    }
}
