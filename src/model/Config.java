package model;

public class Config {
	int config_id;
	String config_name;
	String config_des;
	String target_table;
	String file_type;
	String import_dir;
	String success_dir;
	String error_dir;
	String column_list;
	String delimmeter;
	
	public Config() {
	}

	public Config(int config_id, String config_name, String config_des, String target_table, String file_type,
			String import_dir, String success_dir, String error_dir, String column_list, String delimmeter) {
		this.config_id = config_id;
		this.config_name = config_name;
		this.config_des = config_des;
		this.target_table = target_table;
		this.file_type = file_type;
		this.import_dir = import_dir;
		this.success_dir = success_dir;
		this.error_dir = error_dir;
		this.column_list = column_list;
		this.delimmeter = delimmeter;
	}

	public int getConfig_id() {
		return config_id;
	}

	public void setConfig_id(int config_id) {
		this.config_id = config_id;
	}

	public String getConfig_name() {
		return config_name;
	}

	public void setConfig_name(String config_name) {
		this.config_name = config_name;
	}

	public String getConfig_des() {
		return config_des;
	}

	public void setConfig_des(String config_des) {
		this.config_des = config_des;
	}

	public String getTarget_table() {
		return target_table;
	}

	public void setTarget_table(String target_table) {
		this.target_table = target_table;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public String getImport_dir() {
		return import_dir;
	}

	public void setImport_dir(String import_dir) {
		this.import_dir = import_dir;
	}

	public String getSuccess_dir() {
		return success_dir;
	}

	public void setSuccess_dir(String success_dir) {
		this.success_dir = success_dir;
	}

	public String getError_dir() {
		return error_dir;
	}

	public void setError_dir(String error_dir) {
		this.error_dir = error_dir;
	}

	public String getColumn_list() {
		return column_list;
	}

	public void setColumn_list(String column_list) {
		this.column_list = column_list;
	}

	public String getDelimmeter() {
		return delimmeter;
	}

	public void setDelimmeter(String delimmeter) {
		this.delimmeter = delimmeter;
	}
	
	
}
