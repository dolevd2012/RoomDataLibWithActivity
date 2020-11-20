package com.example.dbroom;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MainDao_Impl implements MainDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MainData> __insertionAdapterOfMainData;

  private final EntityDeletionOrUpdateAdapter<MainData> __deletionAdapterOfMainData;

  private final SharedSQLiteStatement __preparedStmtOfUpdateString;

  private final SharedSQLiteStatement __preparedStmtOfUpdateNumber;

  public MainDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMainData = new EntityInsertionAdapter<MainData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `DataB` (`ID`,`STRING`,`INT`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MainData value) {
        stmt.bindLong(1, value.getID());
        if (value.getString() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getString());
        }
        stmt.bindLong(3, value.getNumber());
      }
    };
    this.__deletionAdapterOfMainData = new EntityDeletionOrUpdateAdapter<MainData>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `DataB` WHERE `ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MainData value) {
        stmt.bindLong(1, value.getID());
      }
    };
    this.__preparedStmtOfUpdateString = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE DataB SET STRING= ? WHERE ID= ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateNumber = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE DataB SET INT= ? WHERE ID= ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final MainData mainData) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMainData.insert(mainData);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final MainData mainData) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfMainData.handle(mainData);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(final List<MainData> mainData) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfMainData.handleMultiple(mainData);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateString(final int sID, final String newInfo) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateString.acquire();
    int _argIndex = 1;
    if (newInfo == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, newInfo);
    }
    _argIndex = 2;
    _stmt.bindLong(_argIndex, sID);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateString.release(_stmt);
    }
  }

  @Override
  public void updateNumber(final int sID, final int newInfo) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateNumber.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, newInfo);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, sID);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateNumber.release(_stmt);
    }
  }

  @Override
  public MainData getSpecificDataBysID(final int sID) {
    final String _sql = "SELECT * FROM DataB WHERE ID= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, sID);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfID = CursorUtil.getColumnIndexOrThrow(_cursor, "ID");
      final int _cursorIndexOfString = CursorUtil.getColumnIndexOrThrow(_cursor, "STRING");
      final int _cursorIndexOfNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "INT");
      final MainData _result;
      if(_cursor.moveToFirst()) {
        _result = new MainData();
        final int _tmpID;
        _tmpID = _cursor.getInt(_cursorIndexOfID);
        _result.setID(_tmpID);
        final String _tmpString;
        _tmpString = _cursor.getString(_cursorIndexOfString);
        _result.setString(_tmpString);
        final int _tmpNumber;
        _tmpNumber = _cursor.getInt(_cursorIndexOfNumber);
        _result.setNumber(_tmpNumber);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public MainData getSpecificDataBysString(final String string) {
    final String _sql = "SELECT * FROM DataB WHERE STRING= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (string == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, string);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfID = CursorUtil.getColumnIndexOrThrow(_cursor, "ID");
      final int _cursorIndexOfString = CursorUtil.getColumnIndexOrThrow(_cursor, "STRING");
      final int _cursorIndexOfNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "INT");
      final MainData _result;
      if(_cursor.moveToFirst()) {
        _result = new MainData();
        final int _tmpID;
        _tmpID = _cursor.getInt(_cursorIndexOfID);
        _result.setID(_tmpID);
        final String _tmpString;
        _tmpString = _cursor.getString(_cursorIndexOfString);
        _result.setString(_tmpString);
        final int _tmpNumber;
        _tmpNumber = _cursor.getInt(_cursorIndexOfNumber);
        _result.setNumber(_tmpNumber);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public MainData getSpecificDataBysNumber(final int num) {
    final String _sql = "SELECT * FROM DataB WHERE INT= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, num);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfID = CursorUtil.getColumnIndexOrThrow(_cursor, "ID");
      final int _cursorIndexOfString = CursorUtil.getColumnIndexOrThrow(_cursor, "STRING");
      final int _cursorIndexOfNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "INT");
      final MainData _result;
      if(_cursor.moveToFirst()) {
        _result = new MainData();
        final int _tmpID;
        _tmpID = _cursor.getInt(_cursorIndexOfID);
        _result.setID(_tmpID);
        final String _tmpString;
        _tmpString = _cursor.getString(_cursorIndexOfString);
        _result.setString(_tmpString);
        final int _tmpNumber;
        _tmpNumber = _cursor.getInt(_cursorIndexOfNumber);
        _result.setNumber(_tmpNumber);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MainData> getAll() {
    final String _sql = "SELECT * FROM DataB";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfID = CursorUtil.getColumnIndexOrThrow(_cursor, "ID");
      final int _cursorIndexOfString = CursorUtil.getColumnIndexOrThrow(_cursor, "STRING");
      final int _cursorIndexOfNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "INT");
      final List<MainData> _result = new ArrayList<MainData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MainData _item;
        _item = new MainData();
        final int _tmpID;
        _tmpID = _cursor.getInt(_cursorIndexOfID);
        _item.setID(_tmpID);
        final String _tmpString;
        _tmpString = _cursor.getString(_cursorIndexOfString);
        _item.setString(_tmpString);
        final int _tmpNumber;
        _tmpNumber = _cursor.getInt(_cursorIndexOfNumber);
        _item.setNumber(_tmpNumber);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
