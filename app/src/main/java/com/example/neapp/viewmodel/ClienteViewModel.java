package com.example.neapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.neapp.model.database.AppDatabase;
import com.example.neapp.model.ent.ClienteEntity;
import java.util.List;

public class ClienteViewModel extends ViewModel {
    private final LiveData<List<ClienteEntity>> allClientes;

    public ClienteViewModel(AppDatabase database) {
        allClientes = database.clienteDao().getAllClientes(); // Obtiene la lista de clientes desde la base de datos
    }

    public LiveData<List<ClienteEntity>> getAllClientes() {
        return allClientes;
    }
}
