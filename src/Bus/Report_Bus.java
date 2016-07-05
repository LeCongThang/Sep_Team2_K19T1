/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

import java.util.List;
import Entities.*;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Report_Bus {

    public List<Report> Data(String email, Date date, Date date1) {
        ArrayList<Report> ts = new ArrayList<Report>();
        try {
            CallableStatement cStmt = ConnectDB.getConnection().prepareCall("{CALL sp_Report(?,?,?)}");
            cStmt.setDate(1, date);
            cStmt.setDate(2, date1);
            cStmt.setString(3, email);
            cStmt.execute();
            ResultSet rs = cStmt.getResultSet();
            while (rs.next()) {
                Report t = new Report();
                t.setTagName(rs.getString("TagName"));
                t.setTimes(rs.getDouble("Time"));
                //t.setStartTime(rs.getTimestamp("StartTime"));
                ts.add(t);
            }

        } catch (Exception e) {
            return ts = null;
        }

        return ts;
    }
}
