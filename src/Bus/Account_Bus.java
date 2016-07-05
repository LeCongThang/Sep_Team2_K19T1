/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

import java.sql.*;
import Entities.*;
import java.util.*;

/**
 *
 * @author Administrator
 */
public class Account_Bus {

    public boolean create(EndUser us) {
        try {
            PreparedStatement ps = ConnectDB.getConnection().prepareStatement("insert into EndUser(email,pass) values(?,?)");

            ps.setString(1, us.getEmail());
            ps.setString(2, us.getPass());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {

            return false;
        }
    }

    public boolean update(EndUser us) {
        try {
            PreparedStatement ps = ConnectDB.getConnection().prepareStatement("update EndUser set Pass=? where email=?");

            ps.setString(2, us.getEmail());
            ps.setString(1, us.getPass());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {

            return false;
        }
    }

    public EndUser find(String username, String password) {
        EndUser us = null;
        try {
            PreparedStatement ps = ConnectDB.getConnection().prepareStatement("select *\n"
                    + "from EndUser\n"
                    + "where email=? and pass=? ");

            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                us = new EndUser();
                us.setEmail(rs.getString("Email"));
                us.setPass(rs.getString("Pass"));

            }

        } catch (Exception e) {
            return us = null;
        }

        return us;
    }

    public List<EndUser> finllusername() {
        List<EndUser> listus = new ArrayList<EndUser>();
        try {
            PreparedStatement ps = ConnectDB.getConnection().prepareStatement("select email\n"
                    + "from EndUser");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EndUser us = new EndUser();
                us.setEmail(rs.getString("email"));
                listus.add(us);
            }
        } catch (Exception e) {
            return listus = null;
        }
        return listus;
    }

    public EndUser findusername(String username) {
        EndUser us = null;
        try {
            PreparedStatement ps = ConnectDB.getConnection().prepareStatement("select *\n"
                    + "from EndUser\n"
                    + "where email=? ");

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                us = new EndUser();
                us.setEmail(rs.getString("Email"));
                us.setPass(rs.getString("Pass"));
            }

        } catch (Exception e) {
            return us = null;
        }

        return us;
    }
    
}
