package com.main.android.borersmaps.dataLayer.repository;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.main.android.borersmaps.dataLayer.dto.routeEntity;
import com.main.android.borersmaps.dataSources.sqlLiteDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sandily on 30/04/16.
 */
public class routesRepository {

    public routesRepository() {
    }

    public List<routeEntity> getRoutesByStopId(String id, sqlLiteDatabaseHelper myDbHelper){
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("select distinct(routes._id), routes.route_name from routes_stops  inner join routes on routes._id=routes_stops.route_id where stop_id="+id, null);
        List<routeEntity> routeEntities = new ArrayList<routeEntity>();
        if(c.moveToFirst()){
            do{
                String routeId = c.getString(0);
                String name = c.getString(1);
                routeEntity routeEntity = new routeEntity();
                routeEntity.setId(routeId);
                routeEntity.setName(name);
                Log.d("myApp", routeEntity.getId());
                Log.d("myApp", routeEntity.getName());
                routeEntities.add(routeEntity);
            }while(c.moveToNext());

        }
        c.close();
        db.close();
        return routeEntities;
    }

    public List<LatLng> getRouteLocationById(String id, sqlLiteDatabaseHelper myDbHelper){
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("select stops.latitude, stops.longitude from routes_stops inner join stops on stops._id=routes_stops.stop_id where routes_stops.route_id="+id+ " order by routes_stops.stops_order", null);
        List<LatLng> locations = new ArrayList<LatLng>();
        if(c.moveToFirst()){
            do{
                Double latitude = c.getDouble(0);
                Double longitude = c.getDouble(1);
                LatLng location = new LatLng(latitude,longitude);
                locations.add(location);
            }while(c.moveToNext());
        }
        c.close();
        db.close();
        return  locations;
    }

}
