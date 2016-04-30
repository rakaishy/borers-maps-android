package com.main.android.borersmaps;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sandily on 30/04/16.
 */
public class routesRepository {

    public routesRepository() {
    }

    public List<Route> getRoutesByStopId(String id, SQLiteDatabaseHelper myDbHelper){
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("select distinct(routes._id), routes.route_name from routes_stops  inner join routes on routes._id=routes_stops.route_id where stop_id="+id, null);
        List<Route> routes = new ArrayList<Route>();
        if(c.moveToFirst()){
            do{
                String routeId = c.getString(0);
                String name = c.getString(1);
                Route route = new Route();
                route.setId(routeId);
                route.setName(name);
                Log.d("myApp", route.getId());
                Log.d("myApp", route.getName());
                routes.add(route);
            }while(c.moveToNext());

        }
        c.close();
        db.close();
        return routes;
    }

    public List<LatLng> getRouteLocationById(String id, SQLiteDatabaseHelper myDbHelper){
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("select stops.latitude, stops.longitude from routes_stops inner join stops on stops._id=routes_stops.stop_id where routes_stops.route_id="+id+ " order by routes_stops.stops_order", null);
        List<LatLng> locations = new ArrayList<LatLng>();
        if(c.moveToFirst()){
            do{
                Double latitude = c.getDouble(0);
                Double longitude = c.getDouble(0);
                LatLng location = new LatLng(latitude,longitude);
                locations.add(location);
            }while(c.moveToNext());
        }
        c.close();
        db.close();
        return  locations;
    }

}
