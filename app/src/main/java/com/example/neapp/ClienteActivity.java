package com.example.neapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.neapp.adapter.ClienteAdapter;
import com.example.neapp.model.database.AppDatabase;
import com.example.neapp.model.ent.ClienteEntity;
import com.example.neapp.viewmodel.ClienteViewModel;
import java.util.List;

import io.reactivex.annotations.NonNull;

public class ClienteActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ClienteAdapter adapter;
    private ClienteViewModel clienteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente); // Asegúrate de que este sea tu layout de ClienteActivity

        ImageView backButton = findViewById(R.id.backButton);
        recyclerView = findViewById(R.id.recyclerViewClientes); // El ID debe coincidir con el del layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Navegación al hacer clic en el botón de retroceso
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClienteActivity.this, HomeActivity.class);
                startActivity(intent);
                finish(); // Opcional: llama a finish() si quieres que esta actividad se cierre al regresar
            }
        });

        // Inicializar la base de datos
        AppDatabase database = AppDatabase.getInstance(this);

        // Inicializar el ViewModel
        clienteViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new ClienteViewModel(database);
            }
        }).get(ClienteViewModel.class);

        // Observar los cambios en la lista de clientes
        clienteViewModel.getAllClientes().observe(this, new Observer<List<ClienteEntity>>() {
            @Override
            public void onChanged(List<ClienteEntity> clientes) {
                // Actualiza el adaptador
                adapter = new ClienteAdapter(ClienteActivity.this, clientes);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
