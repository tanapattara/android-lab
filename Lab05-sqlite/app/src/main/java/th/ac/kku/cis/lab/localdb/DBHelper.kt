package th.ac.kku.cis.lab.localdb

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper (context: Context, factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_PRODUCTS_TABLE = ("CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_NAME + " TEXT" + ")")
        db.execSQL(CREATE_PRODUCTS_TABLE)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }
    fun addTask(task: Task): Long {
        val values = ContentValues()

        values.put(COLUMN_NAME, task.name)

        val db = this.writableDatabase

        val result = db.insert(TABLE_NAME, null, values)
        db.close()

        return result
    }
    fun getAllTask(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }
    fun deleteTask(id:Int): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_ID, id)
        val success = db.delete(TABLE_NAME,COLUMN_ID + "=" + id,null)
        db.close()
        return success
    }
    fun updateTask(task: Task):Int{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_ID, task.id)
        contentValues.put(COLUMN_NAME, task.name)

        val success = db.update(TABLE_NAME, contentValues,COLUMN_ID+"="+task.id,null)
        db.close()
        return success
    }
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "todoapp.db"
        val TABLE_NAME = "student"
        val COLUMN_ID = "_id"
        val COLUMN_NAME = "name"
    }
}