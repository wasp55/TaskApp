package jp.techacademy.nanami.yeates.taskapp;

/**
 * Created by Nanami Yeates on 31/10/2016.
 */

import android.util.Log;

import java.io.Serializable;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Task extends RealmObject implements Serializable {

    private String title; // タイトル
    private String category;//カテゴリー

    private String contents; // 内容
    private Date date; // 日時


    // id をプライマリーキーとして設定
    @PrimaryKey
    private int id;


    public String getTitle() {
        try {
            return title;
        } catch (NullPointerException e) {
            Log.d("java", "発生した");
        } catch (RuntimeException e) {
            Log.d("javatest", "例外発生");
        } catch (Exception e) {
            Log.d("javatest", "例外発生");
        }
        return null;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}