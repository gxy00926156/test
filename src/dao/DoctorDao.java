package dao;

import java.util.List;

import bean.Doctor;

public interface DoctorDao extends IDao<Doctor, String> {
	public List<Doctor> getDoctorByDepart(String area,String department,boolean isde);
	public List<Doctor> getDoctorByDisease(String area,String disease,boolean isde);
	public void updateTitleId();
	public List<Doctor> SortList(List<Doctor> doctors,double[] w);
	public void CaRating();
}
