package com.example.lawyerfinderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lawyerfinderapp.models.Lawyer;
import com.example.lawyerfinderapp.models.User;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "lawyerfinderapp.db";
    private static final int DATABASE_VERSION = 3;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, firstname TEXT, lastname TEXT, email TEXT UNIQUE, password TEXT, role TEXT)");
        db.execSQL("CREATE TABLE lawyers (id INTEGER PRIMARY KEY AUTOINCREMENT, firstname TEXT, lastname TEXT, email TEXT UNIQUE, password TEXT, lawyerCategory TEXT, location TEXT)");
        db.execSQL("CREATE TABLE applications (id INTEGER PRIMARY KEY AUTOINCREMENT, firstname TEXT, lastname TEXT, email TEXT UNIQUE, password TEXT, lawyerCategory TEXT, location TEXT)");
        db.execSQL("CREATE TABLE admins (id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT UNIQUE, password TEXT)");
        addDefaultAdmin(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 3) {
            db.execSQL("CREATE TABLE IF NOT EXISTS applications (id INTEGER PRIMARY KEY AUTOINCREMENT, firstname TEXT, lastname TEXT, email TEXT UNIQUE, password TEXT, lawyerCategory TEXT, location TEXT)");
        }
    }

    // ✅ Get All Users
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users", null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String firstname = cursor.getString(cursor.getColumnIndexOrThrow("firstname"));
                String lastname = cursor.getString(cursor.getColumnIndexOrThrow("lastname"));
                String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
                String role = cursor.getString(cursor.getColumnIndexOrThrow("role"));

                userList.add(new User(id, firstname, lastname, email, role));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return userList;
    }

    // ✅ Register Client or Lawyer
    public boolean register(String firstname, String lastname, String email, String password, String role) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("firstname", firstname);
        values.put("lastname", lastname);
        values.put("email", email);
        values.put("password", password);
        values.put("role", role);

        long result = db.insert("users", null, values);
        db.close();

        return result != -1;
    }

    // ✅ Delete User by ID
    public boolean deleteUser(int userId) {
        SQLiteDatabase db = this.getWritableDatabase();
        int deletedRows = db.delete("users", "id=?", new String[]{String.valueOf(userId)});
        db.close();
        return deletedRows > 0; // Returns true if user deleted successfully
    }


    // ✅ Submit Lawyer Application (Pending Approval)
    public boolean submitLawyerApplication(String firstname, String lastname, String email, String password, String lawyerCategory, String location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("firstname", firstname);
        values.put("lastname", lastname);
        values.put("email", email);
        values.put("password", password);
        values.put("lawyerCategory", lawyerCategory);
        values.put("location", location);

        long result = db.insert("applications", null, values);
        db.close();

        return result != -1;
    }

    // ✅ Verify Lawyer (Move from Applications Table to Lawyers Table)
    public boolean verifyLawyer(int lawyerId) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM applications WHERE id=?", new String[]{String.valueOf(lawyerId)});

        if (cursor.moveToFirst()) {
            ContentValues values = new ContentValues();
            values.put("firstname", cursor.getString(cursor.getColumnIndexOrThrow("firstname")));
            values.put("lastname", cursor.getString(cursor.getColumnIndexOrThrow("lastname")));
            values.put("email", cursor.getString(cursor.getColumnIndexOrThrow("email")));
            values.put("password", cursor.getString(cursor.getColumnIndexOrThrow("password")));
            values.put("lawyerCategory", cursor.getString(cursor.getColumnIndexOrThrow("lawyerCategory")));
            values.put("location", cursor.getString(cursor.getColumnIndexOrThrow("location")));

            db.insert("lawyers", null, values);
            db.delete("applications", "id=?", new String[]{String.valueOf(lawyerId)});
            cursor.close();
            db.close();
            return true;
        }

        cursor.close();
        db.close();
        return false;
    }

    // ✅ Reject Lawyer (Delete from Applications Table)
    public boolean rejectLawyer(int lawyerId) {
        SQLiteDatabase db = this.getWritableDatabase();
        int deletedRows = db.delete("applications", "id=?", new String[]{String.valueOf(lawyerId)});
        db.close();
        return deletedRows > 0;
    }

    // ✅ Add Default Admin
    private void addDefaultAdmin(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put("email", "admin@lawyerfinder.com");
        values.put("password", "admin@123");
        db.insertWithOnConflict("admins", null, values, SQLiteDatabase.CONFLICT_IGNORE);
    }

    // 🔑 Check User Role for Login
    public String getUserRole(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String role = null;

        // 🔍 Check Users Table First
        Cursor cursor = db.rawQuery("SELECT role FROM users WHERE email = ? AND password = ?", new String[]{email, password});
        if (cursor.moveToFirst()) {
            role = cursor.getString(0); // If user is found
            cursor.close();
            db.close();
            return role;
        }
        cursor.close();

        // 🔍 Check Lawyers Table
        cursor = db.rawQuery("SELECT email FROM lawyers WHERE email = ? AND password = ?", new String[]{email, password});
        if (cursor.moveToFirst()) {
            role = "lawyer"; // If lawyer is found
            cursor.close();
            db.close();
            return role;
        }
        cursor.close();

        // 🔍 Check Admins Table
        cursor = db.rawQuery("SELECT email FROM admins WHERE email = ? AND password = ?", new String[]{email, password});
        if (cursor.moveToFirst()) {
            role = "admin"; // If admin is found
        }

        cursor.close();
        db.close();
        return role; // Will return "client", "lawyer", "admin", or null
    }
}
