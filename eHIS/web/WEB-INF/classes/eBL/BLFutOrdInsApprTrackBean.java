package eBL;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import eCommon.Common.CommonAdapter;
import webbeans.eCommon.ConnectionManager;
import java.io.*;
import java.util.*;
import java.sql.*;
import eBL.Common.*;
import webbeans.eCommon.*;
import java.text.*;

import eBL.Common.BlAdapter;
import eBL.Common.BlRepository;


public class BLFutOrdInsApprTrackBean extends BlAdapter implements Serializable {
	
		
	private String operating_facility_id;
	private String primary_key_module_id;
	private String primary_key_main;
	private String primary_key_line_no;
	private String serv_item_code;
	private String blng_serv_code;
	
	private String appr_info_to_pat_yn;
	private String appr_info_by_id;
	private String appr_info_date;
	private String appr_start_date;
	private String appr_expire_date;
	private String service_perform_date;
	private String service_status;
	private String service_remarks;
	private String follow_up_visit_appt_yn;
	private String appt_date_time;
	private String follow_up_vist_adm;
	
	HashMap<String, List<BLFutOrdInsApprTrackBean>> policyMap = null;
	List<BLFutOrdInsApprTrackBean> policyList = null;
	
	
	
	public String getOperating_facility_id() {
		return operating_facility_id;
	}
	public void setOperating_facility_id(String operating_facility_id) {
		this.operating_facility_id = operating_facility_id;
	}
	public String getPrimary_key_module_id() {
		return primary_key_module_id;
	}
	public void setPrimary_key_module_id(String primary_key_module_id) {
		this.primary_key_module_id = primary_key_module_id;
	}
	public String getPrimary_key_main() {
		return primary_key_main;
	}
	public void setPrimary_key_main(String primary_key_main) {
		this.primary_key_main = primary_key_main;
	}
	public String getPrimary_key_line_no() {
		return primary_key_line_no;
	}
	public void setPrimary_key_line_no(String primary_key_line_no) {
		this.primary_key_line_no = primary_key_line_no;
	}
	public String getServ_item_code() {
		return serv_item_code;
	}
	public void setServ_item_code(String serv_item_code) {
		this.serv_item_code = serv_item_code;
	}
	public String getBlng_serv_code() {
		return blng_serv_code;
	}
	public void setBlng_serv_code(String blng_serv_code) {
		this.blng_serv_code = blng_serv_code;
	}
	public String getAppr_info_to_pat_yn() {
		return appr_info_to_pat_yn;
	}
	public void setAppr_info_to_pat_yn(String appr_info_to_pat_yn) {
		this.appr_info_to_pat_yn = appr_info_to_pat_yn;
	}
	public String getAppr_info_by_id() {
		return appr_info_by_id;
	}
	public void setAppr_info_by_id(String appr_info_by_id) {
		this.appr_info_by_id = appr_info_by_id;
	}
	public String getAppr_info_date() {
		return appr_info_date;
	}
	public void setAppr_info_date(String appr_info_date) {
		this.appr_info_date = appr_info_date;
	}
	public String getAppr_start_date() {
		return appr_start_date;
	}
	public void setAppr_start_date(String appr_start_date) {
		this.appr_start_date = appr_start_date;
	}
	public String getAppr_expire_date() {
		return appr_expire_date;
	}
	public void setAppr_expire_date(String appr_expire_date) {
		this.appr_expire_date = appr_expire_date;
	}
	public String getService_perform_date() {
		return service_perform_date;
	}
	public void setService_perform_date(String service_perform_date) {
		this.service_perform_date = service_perform_date;
	}
	public String getService_status() {
		return service_status;
	}
	public void setService_status(String service_status) {
		this.service_status = service_status;
	}
	public String getService_remarks() {
		return service_remarks;
	}
	public void setService_remarks(String service_remarks) {
		this.service_remarks = service_remarks;
	}
	public String getFollow_up_visit_appt_yn() {
		return follow_up_visit_appt_yn;
	}
	public void setFollow_up_visit_appt_yn(String follow_up_visit_appt_yn) {
		this.follow_up_visit_appt_yn = follow_up_visit_appt_yn;
	}
	public String getAppt_date_time() {
		return appt_date_time;
	}
	public void setAppt_date_time(String appt_date_time) {
		this.appt_date_time = appt_date_time;
	}
	public String getFollow_up_vist_adm() {
		return follow_up_vist_adm;
	}
	public void setFollow_up_vist_adm(String follow_up_vist_adm) {
		this.follow_up_vist_adm = follow_up_vist_adm;
	}
	
	public HashMap<String, List<BLFutOrdInsApprTrackBean>> getPolicyMap() {
		return policyMap;
	}
	public void setPolicyMap(HashMap<String, List<BLFutOrdInsApprTrackBean>> policyMap) {
		this.policyMap = policyMap;
	}
	public List<BLFutOrdInsApprTrackBean> getPolicyList() {
		return policyList;
	}
	public void setPolicyList(List<BLFutOrdInsApprTrackBean> policyList) {
		this.policyList = policyList;
	}
	
	
}
