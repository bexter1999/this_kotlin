package com.platina125.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SqliteHelper(context: Context, name: String, version: Int):
    SQLiteOpenHelper(context, name, null, version) {
    //Context, 데이터베이스명, 팩토리, 버전 정보
    override fun onCreate(db: SQLiteDatabase?) {
        val create = "create table memo (" +
                "no integer primary key, " +
                "content text, " +
                "datetime integer" +
                ")"

        db?.execSQL(create)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertMemo(memo: Memo) {
        val values = ContentValues()
        values.put("content", memo.content)
        values.put("datetime", memo.datetime)

        val wd = writableDatabase
        wd.insert("memo", null, values)
        wd.close()

    }

    fun selectMemo(): MutableList<Memo> {
        val list = mutableListOf<Memo>()
        //내가 조회한 리스트 결과값을 담을 변수
        val select = "select * from memo"
        val rd = readableDatabase
        val cursor = rd.rawQuery(select, null)
        while(cursor.moveToNext()){
            val noIdx = cursor.getColumnIndex("no")
            val contentIdx = cursor.getColumnIndex("content")
            //몇번째이냐를 리턴함 컨텐츠 내용을 리턴하는게 아님
            val dateIdx = cursor.getColumnIndex("datetime")

            val no = cursor.getLong(noIdx) //커서로 이동
            val content = cursor.getString(contentIdx)
            val datetime = cursor.getLong(dateIdx)

            list.add(Memo(no, content, datetime))
        }
        cursor.close()
        rd.close()
        return list
    }

    fun updateMemo(memo:Memo){
        val values = ContentValues()
        values.put("content", memo.content)
        values.put("datetime", memo.datetime)

        val wd = writableDatabase
        wd.update("memo", values, "no = ${memo.no}", null)
        wd.close()
    }

    fun deleteMemo(memo:Memo){
        val delete = "delete from memo where no = ${memo.no}"
        val db = writableDatabase
        db.execSQL(delete)
        db.close()
    }
}


    data class Memo(var no:Long?, var content: String, var datetime:Long)
