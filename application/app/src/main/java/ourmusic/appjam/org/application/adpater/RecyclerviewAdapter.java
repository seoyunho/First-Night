package ourmusic.appjam.org.application.adpater;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.JsonArray;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import ourmusic.appjam.org.application.R;
import ourmusic.appjam.org.application.activities.MusicPage;
import ourmusic.appjam.org.application.model.Music;
import retrofit2.Callback;

/**
 * Created by dsm2016 on 2017-08-12.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Music> arrayList;

    public RecyclerviewAdapter(Context context, ArrayList<Music> arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_item,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.titleTextView.setText(arrayList.get(position).getTitle());
        holder.singerTextView.setText(arrayList.get(position).getSinger());
        String uri=arrayList.get(position).getImgURL();
        //Glide.with(context).load(uri).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(arrayList.get(position).getUrl()));
                browserIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(browserIntent);*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView singerTextView;

        ImageView imageView;

        ViewHolder(View v) {
            super(v);

            titleTextView=(TextView)v.findViewById(R.id.title);
            singerTextView=(TextView)v.findViewById(R.id.singer);
            imageView=(ImageView)v.findViewById(R.id.item_image);
        }
    }

    public Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    } // Author: sile
}
