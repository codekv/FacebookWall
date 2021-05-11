package com.example.facebookwall;

import android.content.Context;
import android.opengl.EGLImage;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import java.util.ArrayList;

//import static com.bumptech.glide.Glide.glide;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    Context context;
    ArrayList<Model> modelArray = new ArrayList<>();
    RequestManager glide;

    public Adapter(Context context,ArrayList<Model> modelArray){

        this.context = context;
        this.modelArray = modelArray;
        glide = Glide.with(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_page_row,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Model model = modelArray.get(position);

        holder.tv_name.setText(model.getName());
        holder.tv_time.setText(model.getTime());
        holder.tv_like.setText(String.valueOf(model.getLikes()));
        holder.tv_comments.setText(model.getComments()+" comments");
        holder.tv_status.setText(model.getStatus());


        glide.load(model.getProfilePic()).into(holder.img_profilePic);

        if(model.getPostPic()==0){
            holder.img_postPic.setVisibility(View.GONE);

        }else {
            holder.img_postPic.setVisibility(View.VISIBLE);
            glide.load(model.getPostPic()).into(holder.img_postPic);
        }

    }

    @Override
    public int getItemCount() {
        return modelArray.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name,tv_time,tv_like,tv_comments,tv_status;
        ImageView img_profilePic,img_postPic;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img_profilePic = (ImageView)itemView.findViewById(R.id.img_UserProfile);
            img_postPic = (ImageView)itemView.findViewById(R.id.img_Post);

            tv_name = itemView.findViewById(R.id.tv_username);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_like = itemView.findViewById(R.id.tv_like);
            tv_comments = itemView.findViewById(R.id.tv_comment);
            tv_status = itemView.findViewById(R.id.tv_status);



        }
    }

}
