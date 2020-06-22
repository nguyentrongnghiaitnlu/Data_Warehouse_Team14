package model;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import connection.ConnectionDB;

public class Log {
	static String PATH = "D:\\HK6 2019 - 2020\\Data WAREHOUSE\\DIR";
	
	private int data_file_id;
	private String file_name;
	private String server_name;
	private int data_file_config_id;
	private String file_status;
	private String file_queue;
	private String file_extracted;
	private int staging_load_count;

	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private String sql;

	private List<Log> listLog;

	public Log() {
	}

	public Log(String file_name, String server_name, int data_file_config_id, String file_status, String file_queue,
			String file_extracted, int staging_load_count) {
		this.file_name = file_name;
		this.server_name = server_name;
		this.data_file_config_id = data_file_config_id;
		this.file_status = file_status;
		this.file_queue = file_queue;
		this.file_extracted = file_extracted;
		this.staging_load_count = staging_load_count;
	}

	public Log(int data_file_id, String file_name, String server_name, int data_file_config_id, String file_status,
			String file_queue, String file_extracted, int staging_load_count) {
		this.data_file_id = data_file_id;
		this.file_name = file_name;
		this.server_name = server_name;
		this.data_file_config_id = data_file_config_id;
		this.file_status = file_status;
		this.file_queue = file_queue;
		this.file_extracted = file_extracted;
		this.staging_load_count = staging_load_count;
	}

	public int getData_file_id() {
		return data_file_id;
	}

	public void setData_file_id(int data_file_id) {
		this.data_file_id = data_file_id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getServer_name() {
		return server_name;
	}

	public void setServer_name(String server_name) {
		this.server_name = server_name;
	}

	public int getData_file_config_id() {
		return data_file_config_id;
	}

	public void setData_file_config_id(int data_file_config_id) {
		this.data_file_config_id = data_file_config_id;
	}

	public String getFile_status() {
		return file_status;
	}

	public void setFile_status(String file_status) {
		this.file_status = file_status;
	}

	public String getFile_queue() {
		return file_queue;
	}

	public void setFile_queue(String file_queue) {
		this.file_queue = file_queue;
	}

	public String getFile_extracted() {
		return file_extracted;
	}

	public void setFile_extracted(String file_extracted) {
		this.file_extracted = file_extracted;
	}

	public int getStaging_load_count() {
		return staging_load_count;
	}

	public void setStaging_load_count(int staging_load_count) {
		this.staging_load_count = staging_load_count;
	}

	public void insertListLog() {
		List<Log> listLog = readDirectory(PATH);
		for (int i = 0; i < listLog.size(); i++) {
			insertLog(listLog.get(i));
		}
	}

	public List readDirectory(String path) {
		List<Log> listLog = new ArrayList<Log>();
		File dir = new File(path);
		File[] listFile = dir.listFiles();

		for (int i = 0; i < listFile.length; i++) {
			File file = listFile[i];
			Log log = new Log(file.getName(),
					file.getName().substring(
							file.getName().indexOf(".", (int) file.getName().length() - file.getName().length() - 4)),
					(i+1), "ER", null, null, 0);
			listLog.add(log);
		}
		return listLog;
	}

	public void insertLog(Log log) {
		sql = "insert into `log` (file_name,server_name,data_file_config_id,file_status,file_queue,file_extracted,staging_load_count) "
				+ "values (?,?,?,?,?,?,?)";
		try {

			pst = ConnectionDB.createConnection("controldb").prepareStatement(sql);
			pst.setString(1, log.getFile_name());
			pst.setString(2, log.getServer_name());
			pst.setInt(3, log.getData_file_config_id());
			pst.setString(4, log.getFile_status());
			pst.setString(5, log.getFile_queue());
			pst.setString(6, log.getFile_extracted());
			pst.setInt(7, log.getStaging_load_count());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Log().insertListLog();
		// String st = "sinhvien111.txt";
		// System.out.println(st.substring(st.indexOf(".", st.length() -
		// st.length() - 4)));
	}

}
