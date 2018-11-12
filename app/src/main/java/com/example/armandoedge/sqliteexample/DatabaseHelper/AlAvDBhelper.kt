package com.example.armandoedge.sqliteexample.DatabaseHelper

import android.content.Context
import android.database.Cursor
import android.database.DatabaseErrorHandler
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.armandoedge.sqliteexample.DatabaseHelper.AlAvDBhelper.Companion.DATABASE_NAME
import com.example.armandoedge.sqliteexample.DatabaseHelper.AlAvDBhelper.Companion.DATABASE_VERSION
import java.security.AccessControlContext




class AlAvDBhelper(context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null, DATABASE_VERSION) {
    companion object {
        //si cambia la base de datos, debera incrementar la version
        val DATABASE_VERSION=1
        val DATABASE_NAME="tecnmroque.db"

        //otros tipos de datos text , float, integer,
        private val SQL_CREATE_ENTRIES=
        "CREATE TABLE alumno ("+
            "NoControl text ,"+
            "NomAlumno text ,"+
            "NIP char(4) text,"+
            "TelAlumno text,"+
            "Registrado int(11),"+
            "FechaReg` date)"+

        "CREATE TABLE aviso ("+
            "idAviso int(11) NOT NULL,"+
            "Titulo varchar(60) DEFAULT NULL,"+
            "Descripcion varchar(250) DEFAULT NULL,"+
            "FechaPub date DEFAULT NULL,"+
            "FechaFin date DEFAULT NULL,"+
            "usr varchar(32) DEFAULT NULL)"+

        "CREATE TABLE usuario ("+
            "usr varchar(32) NOT NULL,"+
            "NomUsr varchar(100) DEFAULT NULL,"+
            "Pwd varchar(60) DEFAULT NULL)"

        private val SQL_DELETE_ENTRIES= "DROP TABLE IF EXISTS alumno"

    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db,oldVersion, newVersion)
    }

    //rutina genereica para mandar ejecutar un insert unpdate o delete a la base de datos
    fun Ejecuta(sentencia:String):Int{
        try {
            val db=writableDatabase
            db.execSQL(sentencia)
            db.close()
            return (1);
        }catch (ex: Exception){
            return(0);
        }
    }

    fun Consulta(Select:String): Cursor?{
        try {
            val db=readableDatabase
            var cur: Cursor =db.rawQuery(Select,null)
            return cur
        }catch (ex:Exception){
            val cur: Cursor?=null
            return cur
        }
    }
}