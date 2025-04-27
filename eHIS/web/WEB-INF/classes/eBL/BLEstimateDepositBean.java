package eBL;

import java.io.Serializable;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import webbeans.eCommon.ConnectionManager;

import eBL.Common.BlAdapter;

public class BLEstimateDepositBean extends BlAdapter implements Serializable {

	private String service_code = "";
	private String rate_charge = "";
	private String base_qty = "";
	private String base_rate = "";
	private String qty = "";
	private String charges = "";
	private String day_type = "";
	private String time_type = "";
	private String datetime= "";
	private String line = "";
	private String service_desc = "";
	private String service_indicator = "";
	private String esttotal="";
	
	
	public String getEsttotal() {
		return esttotal;
	}
	public void setEsttotal(String esttotal) {
		this.esttotal = esttotal;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getService_desc() {
		return service_desc;
	}
	public void setService_desc(String service_desc) {
		this.service_desc = service_desc;
	}
	public String getService_indicator() {
		return service_indicator;
	}
	public void setService_indicator(String service_indicator) {
		this.service_indicator = service_indicator;
	}
	List<BLEstimateDepositBean>	depositList	=	null;
	public String getService_code() {
		return service_code;
	}
	public void setService_code(String service_code) {
		this.service_code = service_code;
	}
	public String getRate_charge() {
		return rate_charge;
	}
	public void setRate_charge(String rate_charge) {
		this.rate_charge = rate_charge;
	}
	public String getBase_qty() {
		return base_qty;
	}
	public void setBase_qty(String base_qty) {
		this.base_qty = base_qty;
	}
	public String getBase_rate() {
		return base_rate;
	}
	public void setBase_rate(String base_rate) {
		this.base_rate = base_rate;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getCharges() {
		return charges;
	}
	public void setCharges(String charges) {
		this.charges = charges;
	}
	public String getDay_type() {
		return day_type;
	}
	public void setDay_type(String day_type) {
		this.day_type = day_type;
	}
	public String getTime_type() {
		return time_type;
	}
	public void setTime_type(String time_type) {
		this.time_type = time_type;
	}
	public List<BLEstimateDepositBean> getDepositList() {
		return depositList;
	}
	public void setDepositList(List<BLEstimateDepositBean> depositList) {
		this.depositList = depositList;
	}
	
	public void clearAll(){
	
		service_code = "";
		rate_charge = "";
		base_qty = "";
		base_rate = "";
		qty = "";
		charges = "";
		day_type = "";
		time_type = "";
		datetime= "";
		line = "";
		service_desc = "";
		service_indicator = "";
		esttotal="";
		depositList=null;
		
	}
	

}



