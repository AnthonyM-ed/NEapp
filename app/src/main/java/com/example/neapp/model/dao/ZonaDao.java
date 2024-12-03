package com.example.neapp.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.neapp.model.ent.ZonaEntity;

import java.util.List;

@Dao
public interface ZonaDao {

    @Query("SELECT * FROM Zona")
    LiveData<List<ZonaEntity>> getAllZonas();

    @Query("SELECT * FROM Zona WHERE zonCod = :id")
    LiveData<ZonaEntity> getZonaById(int id);

    @Insert
    void insertZona(ZonaEntity zona);

    @Update
    void updateZona(ZonaEntity zona);

    @Delete
    void deleteZona(ZonaEntity zona);

    // Obtener solo nombres de zonas con estado "A" (Activos)
    @Query("SELECT zonNom FROM Zona WHERE zonEstReg = 'A'")
    LiveData<List<String>> getNombresZonasActivas();

    // Obtener nombre de la zona por su código
    @Query("SELECT zonNom FROM Zona WHERE zonCod = :codigo")
    LiveData<String> getNombreZonaByCodigo(int codigo);
}
