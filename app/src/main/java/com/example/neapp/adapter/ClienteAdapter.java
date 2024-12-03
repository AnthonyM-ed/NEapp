package com.example.neapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.neapp.R;
import com.example.neapp.model.ent.ClienteEntity;
import java.util.List;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ClienteViewHolder> {
    private final List<ClienteEntity> clientes;
    private final Context context;

    public ClienteAdapter(Context context, List<ClienteEntity> clientes) {
        this.context = context;
        this.clientes = clientes;
    }

    @NonNull
    @Override
    public ClienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cliente, parent, false);
        return new ClienteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteViewHolder holder, int position) {
        ClienteEntity cliente = clientes.get(position);
        holder.itemCodigo.setText("CLI" + cliente.getCliCod()); // Ajusta este método según tu entidad
        holder.itemNombre.setText(cliente.getCliNom());
        holder.itemEstado.setText(cliente.getCliEstReg());

        // Cambiar el color del texto en función del estado
        if ("I".equals(cliente.getCliEstReg())) {
            holder.itemCodigo.setTextColor(context.getResources().getColor(R.color.gray));
            holder.itemNombre.setTextColor(context.getResources().getColor(R.color.gray)); // Cambia "gris" por el color que desees
            holder.itemEstado.setTextColor(context.getResources().getColor(R.color.gray)); // Cambia "gris" por el color que desees
        }
    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }

    static class ClienteViewHolder extends RecyclerView.ViewHolder {
        TextView itemCodigo;
        TextView itemNombre;
        TextView itemEstado;

        public ClienteViewHolder(@NonNull View itemView) {
            super(itemView);
            itemCodigo = itemView.findViewById(R.id.itemCodigo);
            itemNombre = itemView.findViewById(R.id.itemNombre);
            itemEstado = itemView.findViewById(R.id.itemEstado);
        }
    }
}
