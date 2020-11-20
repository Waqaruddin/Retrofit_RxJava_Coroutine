package com.example.rxjavawithretrofit.coroutines


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavawithretrofit.R
import com.example.rxjavawithretrofit.model.Users
import kotlinx.android.synthetic.main.row_adapter_users.view.text_view_name


class UsersAdapter2(var mContext: Context, var mList:ArrayList<Users>):RecyclerView.Adapter<UsersAdapter2.MyViewHolder>(){


    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        fun bind(users: Users){

            itemView.text_view_name.text = users.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_adapter_coroutines, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var users = mList[position]
        holder.bind(users)
    }



    override fun getItemCount(): Int {
        return mList.size
    }

    fun setData(l:ArrayList<Users>){
        mList = l
        notifyDataSetChanged()
    }
}