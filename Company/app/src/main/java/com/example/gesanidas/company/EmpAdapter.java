package com.example.gesanidas.company;

/**
 * Created by ΕΛΙΣΑΒΕΤ on 6/4/2017.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EmpAdapter extends RecyclerView.Adapter<EmpAdapter.EmpAdapterViewHolder>
{

    private Employee[] employees;
    private final ListItemClickListener  mOnClickListener;


    public interface ListItemClickListener
    {
        void onClick(Employee employee);
    }


    public EmpAdapter(Employee[] employees,ListItemClickListener listItemClickListener)
    {
        this.employees=employees;
        mOnClickListener=listItemClickListener;
    }

    @Override
    public EmpAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Context context=parent.getContext();
        int layoutIdForListItem = R.layout.item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        return new EmpAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmpAdapterViewHolder holder, int position)
    {
        Employee employee=employees[position];
        holder.textView.setText(employee.getName());
    }

    @Override
    public int getItemCount()
    {
        if (employees!=null)
            return employees.length;
        else
            return 0;
    }

    public void setEmployee(Employee[] employees)
    {
        this.employees=employees;
        notifyDataSetChanged();
    }



    public class EmpAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView textView;


        public EmpAdapterViewHolder(View view)
        {
            super(view);
            textView = (TextView) view.findViewById(R.id.data);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            Employee employee = employees[adapterPosition];
            mOnClickListener.onClick(employee);
        }
    }
}

