package com.example.neapp.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.neapp.model.ent.ClienteEntity;

import java.util.List;

@Dao
public interface ClienteDao {

    // Filtrar registros con estado "*"
    @Query("SELECT * FROM Cliente WHERE cliEstReg != '*'")
    LiveData<List<ClienteEntity>> getAllClientes();

    @Query("SELECT * FROM Cliente WHERE cliCod = :id")
    LiveData<ClienteEntity> getClienteById(int id);

    @Insert
    void insertCliente(ClienteEntity cliente);

    @Update
    void updateCliente(ClienteEntity cliente);

    @Delete
    void deleteCliente(ClienteEntity cliente);

    // Obtener solo nombres de clientes con estado "A" (Activos)
    @Query("SELECT cliNom FROM Cliente WHERE cliEstReg = 'A'")
    LiveData<List<String>> getNombresClientesActivos();

    // Obtener nombre del cliente por su código
    @Query("SELECT cliNom FROM Cliente WHERE cliCod = :codigo")
    LiveData<String> getNombreClienteByCodigo(int codigo);
}
