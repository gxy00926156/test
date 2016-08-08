package dao;

import java.util.List;
import java.util.Map;

import bean.Hospital;

public interface HospitalDao extends IDao<Hospital, String> {

	public List<Hospital> find();
	public Map<String,Hospital> select();
	public void rating();
}
