/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

import Entities.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class LogTime_Bus {
    
    public List<Time> findall(String email) {
        ArrayList<Time> ts = new ArrayList<Time>();
        try {
            PreparedStatement ps = ConnectDB.getConnection().prepareStatement("select *\n"
                    + "from Time where Email_User=? order by Id Desc");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Time t = new Time();
                t.setId(rs.getInt("Id"));
                t.setStartTime(rs.getTimestamp("StartTime"));
                t.setFinishTime(rs.getTimestamp("FinishTime"));
                t.setTags(rs.getInt("Id_Tags"));
                t.setTimes(rs.getDouble("Times"));
                t.setDescription(rs.getString("Description"));
                ts.add(t);
            }
            
        } catch (Exception e) {
            return ts = null;
        }
        
        return ts;
    }

    public Time find(int id) {
        Time t = null;
        try {
            PreparedStatement ps = ConnectDB.getConnection().prepareStatement("select *\n"
                    + "from Time\n"
                    + "where Id=?");
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                t = new Time();
                t.setId(rs.getInt("Id"));
                t.setStartTime(rs.getTimestamp("StartTime"));
                t.setFinishTime(rs.getTimestamp("FinishTime"));
                t.setTags(rs.getInt("Id_Tags"));
                t.setTimes(rs.getDouble("Times"));
                t.setDescription(rs.getString("Description"));
            }
            
        } catch (Exception e) {
            return t = null;
        }
        
        return t;
    }

    public boolean Create(Time t) {
        try {
            PreparedStatement ps = ConnectDB.getConnection().prepareStatement("insert into Time(startTime,\n"
                    + "finishTime,\n"
                    + "times,\n"
                    + "Email_User,Id_tags,description) values(?,?,?,?,?,?)");
//            Calendar cal = Calendar.getInstance();
//            java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
            ps.setTimestamp(1, new java.sql.Timestamp(t.getStartTime().getTime()));
            //ps.setDate(1, new java.sql.Date(t.getStartTime().getTime()));
            ps.setTimestamp(2, new java.sql.Timestamp(t.getFinishTime().getTime()));
            ps.setDouble(3, t.getTimes());
            ps.setString(4, t.getEndUser());
            ps.setInt(5, t.getTags());
            ps.setString(6, t.getDescription());
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Update(Time t) {
        try {
            PreparedStatement ps = ConnectDB.getConnection().prepareStatement("update Time set startTime=?,\n"
                    + "finishTime=?,\n"
                    + "times=?,\n"
                    + "Email_User=?,Id_tags=?,description=? where id=?");
//            Calendar cal = Calendar.getInstance();
//            java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
            ps.setTimestamp(1, new java.sql.Timestamp(t.getStartTime().getTime()));
            //ps.setDate(1, new java.sql.Date(t.getStartTime().getTime()));
            ps.setTimestamp(2, new java.sql.Timestamp(t.getFinishTime().getTime()));
            ps.setDouble(3, t.getTimes());
            ps.setString(4, t.getEndUser());
            ps.setInt(5, t.getTags());
            ps.setString(6, t.getDescription());
            ps.setInt(7, t.getId());
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            return false;
        }
    }
    
}
