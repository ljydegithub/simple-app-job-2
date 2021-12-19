package org.xyafu.app.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import org.xyafu.app.pojo.Admin;
import org.xyafu.app.pojo.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StunNmberOpenHelper extends SQLiteOpenHelper {
    SQLiteDatabase db;
    private Map<String,String> ad_map,map;
    private List<String> list;
    public StunNmberOpenHelper(@Nullable Context context) {
        super(context, "stu_account.db", null, 1);
        db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table admin(_id integer primary key autoincrement,ad_username char(20),ad_password char(20))");
        db.execSQL("create table student(_id integer primary key autoincrement,stu_number char(20),stu_name char(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean insert(String stu_number,String stu_name) {
        ContentValues values = new ContentValues();
        values.put("stu_number", stu_number);
        values.put("stu_name", stu_name);
        long num = db.insert("student", null, values);
        if (num != -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(String id) {
        int num=db.delete("student","_id=?",new String[]{id});
        if(num>0){
            return true;
        }else {
            return false;
        }
    }

    public boolean update(String stu_number,String stu_name){
        ContentValues values=new ContentValues();
        values.put("stu_number", stu_number);
        values.put("stu_name", stu_name);
        long num = db.update("student",values, "stu_name=?", new String[]{stu_name});
        if (num>0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean update(String id,String stu_name,String stu_number){
        ContentValues values=new ContentValues();
        values.put("stu_name", stu_name);
        values.put("stu_number", stu_number);
        long num = db.update("student",values, "_id=?", new String[]{id});
        if (num>0) {
            return true;
        } else {
            return false;
        }
    }

    public Map<String, String> query(){
        map=new TreeMap<>();
        Cursor cursor=db.query("student",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            Student stu=new Student();
            stu.setId(cursor.getString(cursor.getColumnIndex("_id")));
            stu.setNumber(cursor.getString(cursor.getColumnIndex("stu_number")));
            stu.setName(cursor.getString(cursor.getColumnIndex("stu_name")));
            map.put(stu.getNumber(),stu.getName());
        }
        cursor.close();
        return map;
    }
    public List<String> listQuery(){
        list=new ArrayList<>();
        Cursor cursor=db.query("student",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            Student stu=new Student();
            stu.setId(cursor.getString(cursor.getColumnIndex("_id")));
            stu.setNumber(cursor.getString(cursor.getColumnIndex("stu_number")));
            stu.setName(cursor.getString(cursor.getColumnIndex("stu_name")));
            list.add(stu.getId());
            list.add(stu.getName());
            list.add(stu.getNumber());
        }
        cursor.close();
        return list;
    }
//废弃
    public void ad_add(){
        ContentValues values = new ContentValues();
        values.put("ad_username", "admin");
        values.put("ad_password", "admin");
        db.insert("admin", null, values);
    }
//废弃
    public Map<String,String> admin_query(){
        ad_map=new TreeMap<>();
        Cursor cursor=db.query("admin",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            Admin admin=new Admin();
            admin.setId(cursor.getString(cursor.getColumnIndex("_id")));
            admin.setStu_username(cursor.getString(cursor.getColumnIndex("ad_username")));
            admin.setStu_password(cursor.getString(cursor.getColumnIndex("ad_password")));
            ad_map.put(admin.getStu_username(),admin.getStu_password());
        }
        cursor.close();
        return ad_map;
    }
}
