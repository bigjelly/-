package com.bigjelly.shaddockvideoplayer.greendao;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.bigjelly.shaddockvideoplayer.model.VideoInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "VIDEO_INFO".
*/
public class VideoInfoDao extends AbstractDao<VideoInfo, Long> {

    public static final String TABLENAME = "VIDEO_INFO";

    /**
     * Properties of entity VideoInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property ID = new Property(0, Long.class, "ID", true, "_id");
        public final static Property FileID = new Property(1, Long.class, "fileID", false, "FILE_ID");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Path = new Property(3, String.class, "path", false, "PATH");
        public final static Property Time = new Property(4, String.class, "time", false, "TIME");
        public final static Property Size = new Property(5, String.class, "size", false, "SIZE");
    }

    private Query<VideoInfo> videoFile_VideoInfosQuery;

    public VideoInfoDao(DaoConfig config) {
        super(config);
    }
    
    public VideoInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"VIDEO_INFO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: ID
                "\"FILE_ID\" INTEGER," + // 1: fileID
                "\"NAME\" TEXT," + // 2: name
                "\"PATH\" TEXT UNIQUE ," + // 3: path
                "\"TIME\" TEXT," + // 4: time
                "\"SIZE\" TEXT);"); // 5: size
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"VIDEO_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, VideoInfo entity) {
        stmt.clearBindings();
 
        Long ID = entity.getID();
        if (ID != null) {
            stmt.bindLong(1, ID);
        }
 
        Long fileID = entity.getFileID();
        if (fileID != null) {
            stmt.bindLong(2, fileID);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String path = entity.getPath();
        if (path != null) {
            stmt.bindString(4, path);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(5, time);
        }
 
        String size = entity.getSize();
        if (size != null) {
            stmt.bindString(6, size);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, VideoInfo entity) {
        stmt.clearBindings();
 
        Long ID = entity.getID();
        if (ID != null) {
            stmt.bindLong(1, ID);
        }
 
        Long fileID = entity.getFileID();
        if (fileID != null) {
            stmt.bindLong(2, fileID);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String path = entity.getPath();
        if (path != null) {
            stmt.bindString(4, path);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(5, time);
        }
 
        String size = entity.getSize();
        if (size != null) {
            stmt.bindString(6, size);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public VideoInfo readEntity(Cursor cursor, int offset) {
        VideoInfo entity = new VideoInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // ID
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // fileID
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // path
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // time
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // size
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, VideoInfo entity, int offset) {
        entity.setID(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setFileID(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPath(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setTime(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setSize(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(VideoInfo entity, long rowId) {
        entity.setID(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(VideoInfo entity) {
        if(entity != null) {
            return entity.getID();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(VideoInfo entity) {
        return entity.getID() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "videoInfos" to-many relationship of VideoFile. */
    public List<VideoInfo> _queryVideoFile_VideoInfos(Long fileID) {
        synchronized (this) {
            if (videoFile_VideoInfosQuery == null) {
                QueryBuilder<VideoInfo> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.FileID.eq(null));
                queryBuilder.orderRaw("T.'NAME' ASC");
                videoFile_VideoInfosQuery = queryBuilder.build();
            }
        }
        Query<VideoInfo> query = videoFile_VideoInfosQuery.forCurrentThread();
        query.setParameter(0, fileID);
        return query.list();
    }

}