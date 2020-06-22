package table;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.*;

public class ConfigurationTable { // table name

	private String config_db_name; // config database name
	private String target_db_name; // config target database name
	private String table_name; // config table name

	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private String sql;

	public ConfigurationTable() {
	}

	public ConfigurationTable(String config_db_name, String target_db_name, String table_name) {
		this.config_db_name = config_db_name;
		this.target_db_name = target_db_name;
		this.table_name = table_name;
	}

	public String getConfig_db_name() {
		return config_db_name;
	}

	public void setConfig_db_name(String config_db_name) {
		this.config_db_name = config_db_name;
	}

	public String getTarget_db_name() {
		return target_db_name;
	}

	public void setTarget_db_name(String target_db_name) {
		this.target_db_name = target_db_name;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String selectField(String field, String conditon) {
		sql = "SELECT " + field + " FROM " + this.table_name + " WHERE config_name=?";
		try {
			pst = ConnectionDB.createConnection(this.config_db_name).prepareStatement(sql);
			pst.setString(1, conditon);
			rs = pst.executeQuery();
			rs.next();
			return rs.getString(field);
		} catch (Exception e) {
			return null;
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public boolean tableExist(String table_name) {
		try {
			DatabaseMetaData dbm = ConnectionDB.createConnection(this.target_db_name).getMetaData();
			ResultSet tables = dbm.getTables(null, null, table_name, null);
			try {
				if (tables.next()) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return false;
	}
}
