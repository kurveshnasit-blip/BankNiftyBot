package com.example.tradingapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "Trading.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE users (email TEXT, password TEXT)")
        db.execSQL("CREATE TABLE settings (lot_size INTEGER, broker TEXT)")
        db.execSQL("CREATE TABLE trades (date TEXT, symbol TEXT, pnl REAL)")
    }
    override fun onUpgrade(db: SQLiteDatabase, old: Int, new: Int) {}
}
