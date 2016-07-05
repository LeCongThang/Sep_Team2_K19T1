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
import java.util.List;

/**
 *
 * @author Administrator
 */
public class Tags_Bus {
    
    public boolean Create(Tags t) {
        try {
            PreparedStatement ps = ConnectDB.getConnection().prepareStatement("insert into Tags(TagName,\n"
                    + "Description,\n"
                    + "Status,\n"
                    + "Email_User) values(?,?,?,?)");
            
            ps.setString(1, t.getTagName());
            ps.setString(2, t.getDescription());
            ps.setBoolean(3, t.isStatus());
            ps.setString(4, t.getEndUser());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            
            return false;
        }
    }
    
    public boolean Update(Tags us) {
        try {
            PreparedStatement ps = ConnectDB.getConnection().prepareStatement("update Tags set TagName=?,Description=? where id=?");
            
            ps.setString(1, us.getTagName());
            ps.setString(2, us.getDescription());
            ps.setInt(3, us.getId());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            
            return false;
        }
    }
    
    public boolean delete(int id) {
        try {
            PreparedStatement ps = ConnectDB.getConnection().prepareStatement("delete\n"
                    + "from Tags\n"
                    + "where Id=?");
            
            ps.setInt(1, id);
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            return false;
        }
    }
    
    public Tags find(int id) {
        Tags t = null;
        try {
            PreparedStatement ps = ConnectDB.getConnection().prepareStatement("select *\n"
                    + "from Tags\n"
                    + "where Id=?");
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                t = new Tags();
                t.setId(rs.getInt("Id"));
                t.setTagName(rs.getString("TagName"));
                t.setDescription(rs.getString("Description"));
            }
            
        } catch (Exception e) {
            return null;
        }
        
        return t;
    }
    
    public int GetIdCbo(String name, String email) {
        Tags t = null;
        try {
            PreparedStatement ps = ConnectDB.getConnection().prepareStatement("select *\n"
                    + "from Tags\n"
                    + "where TagName=? and Email_User=?");
            
            ps.setString(1, name);
            ps.setString(2, email);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                t = new Tags();
                t.setId(rs.getInt("Id"));
                t.setTagName(rs.getString("TagName"));
                t.setDescription(rs.getString("Description"));
            }
            
        } catch (Exception e) {
            return 0;
        }
        
        return t.getId();
    }

    
    public List<Tags> findall(String email) {
        ArrayList<Tags> ts = new ArrayList<Tags>();
        try {
            PreparedStatement ps = ConnectDB.getConnection().prepareStatement("select *\n"
                    + "from Tags where Email_User=? order by Id Desc");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tags t = new Tags();
                t.setId(rs.getInt("Id"));
                t.setTagName(rs.getString("TagName"));
                t.setDescription(rs.getString("Description"));
                ts.add(t);
            }
            
        } catch (Exception e) {
            return ts = null;
        }
        
        return ts;
    }
}
