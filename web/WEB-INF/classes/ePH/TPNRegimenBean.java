/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
25/04/2016	IN067051         Devindra							            Enhance TPN Ordering Functionality
--------------------------------------------------------------------------------------------------------------------
*/

package ePH;

import java.io.Serializable;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import ePH.Common.*;
import eCommon.Common.*;
import eOR.*;

/**
 *	TPNRegimenBean used to carry out necessary functionality associated with TPNRegimenAssesment.jsp.
 */
//saved on 22/10/2005
public class TPNRegimenBean extends PhAdapter implements Serializable,eOR.SceduleFreqeuncyInterface {
//	private String order_date			= "";
//	private String patient_class		= "";
//	private String patient_id			= "";
//	private String encounter_id			= "";
//	private String drugCodes			= "";
//	private String freqNature			= "";
//	private String repeat_value			= "";
//	private String int_value			= "";
//	private String infRate_srlNo		= "";
//	private String order_status			= "10";
//	private HashMap hashMapFreq			= new HashMap();
//	private HashMap hashMapDurn_value	= new HashMap();
//	private HashMap hashMapDurn_type	= new HashMap();
//	private int srlNo					= 0;
//	private ArrayList drugDetails		= new ArrayList();
	private ArrayList diagText			= new ArrayList(12);
	private HashMap scheduleFrequency	= new HashMap();
	private String debugString			= "";
	private String recoEnergy = "";
	private String recoEnergyUnit="";
	private String patientAge ="";
	private String patientAgeUnit ="";
	ArrayList proteinValue = null;
	ArrayList lipidValue = null;
	ArrayList energyVal = null;
	private String carbohydrate_Energy="";
	private String carbohydrate_Energy_Unit="";
	private String cabohydrate_Order_Quantity=""; 
	private String cabohydrate_Order_Quantity_Unit="";
	private String cabohydrate_Strength_Weight="";
	private String cabohydrate_Strength_Weight_Unit="";
	private String protein_Energy="";
	private String protein_Energy_Unit="";
	private String protein_Order_Quantity_Unit="";
	private String protein_Order_Quantity="";
	private String protein_Strength_Weight="";
	private String protein_Strength_Weight_Unit="";
	private String lipid_Energy="";
	private String lipid_Energy_Unit="";
	private String lipid_Order_Quantity="";
	private String lipid_Order_Quantity_Unit="";
	private String lipid_Strength_Weight="";
	private String lipid_Strength_Weight_Unit="";
	private HashMap hmAssesValues = null;
		private HashMap schdMap = null;



	public TPNRegimenBean() {
        try {
			int i=0;
			while (i < 12) {
				diagText.add("");
				i++;
			}
            doCommon();
        }catch(Exception e) {System.err.println(" Error on load" );}
	}
		public String getDebugString() {
		return this.debugString;
	}

	public void setCarbohydrateEnergy(ArrayList carboEnergy){
		try{
			
			if(carboEnergy.size()==2){
				carbohydrate_Energy = new String((String)carboEnergy.get(0));
				carbohydrate_Energy_Unit = new String((String)carboEnergy.get(1));
			}else{
				carbohydrate_Energy = new String((String)carboEnergy.get(0));
				for(int i = 1; i<carboEnergy.size();i++){
					carbohydrate_Energy_Unit += new String((String)carboEnergy.get(i));
				}
			}
		}catch(Exception e){
			System.err.println("In setCarbohydrateEnergy of ePH.TPNRegimenBean ="+e.toString());
		}
	}

	public void setCabohydrateOrderQuantity(ArrayList carboOrderQty){
		//System.err.println("Inside setProteinOrderquantity---97- bean" +carboOrderQty.size());
		try{
			
			if(carboOrderQty.size()==2){
				
				cabohydrate_Order_Quantity = new String((String)carboOrderQty.get(0));
				cabohydrate_Order_Quantity_Unit = new String((String)carboOrderQty.get(1));
				
			}else{
				cabohydrate_Order_Quantity_Unit="";//Added on 13/sept/2010 for the incident num:23718 by Sandhya
				//System.err.println("else cabohydrate_Order_Quantity---109-- bean"  +cabohydrate_Order_Quantity_Unit);
				cabohydrate_Order_Quantity = new String((String)carboOrderQty.get(0));
				
				//System.err.println("else cabohydrate_Order_Quantity_Unit---111-- bean"  +cabohydrate_Order_Quantity_Unit);
				for(int i = 1; i<carboOrderQty.size();i++){
					cabohydrate_Order_Quantity_Unit += new String((String)carboOrderQty.get(i));
					System.err.println("lop cabohydrate_Order_Quantity_Unit---115-- bean"  +cabohydrate_Order_Quantity_Unit);
				}
			}
		}catch(Exception e){
			System.err.println("In setCabohydrateOrderQuantity of ePH.TPNRegimenBean ="+e.toString());
		}
	}

	public void setCabohydrateStrengthWeight(ArrayList carboStrengthWt){
		try{
			
			if(carboStrengthWt.size()==2){
				cabohydrate_Strength_Weight = new String((String)carboStrengthWt.get(0));
				cabohydrate_Strength_Weight_Unit = new String((String)carboStrengthWt.get(1));
			}else{
				cabohydrate_Strength_Weight = new String((String)carboStrengthWt.get(0));
				for(int i = 1; i<carboStrengthWt.size();i++){
					cabohydrate_Strength_Weight_Unit += new String((String)carboStrengthWt.get(i));
				}
			}
		}catch(Exception e){
			System.err.println("In setCabohydrateStrengthWeight of ePH.TPNRegimenBean ="+e.toString());
		}
	}

	public void setProteinEnergy(ArrayList proteinEnergy){
		try{
			
			if(proteinEnergy.size()==2){
				protein_Energy = new String((String)proteinEnergy.get(0));
				protein_Energy_Unit = new String((String)proteinEnergy.get(1));
			}else{
				protein_Energy = new String((String)proteinEnergy.get(0));
				for(int i = 1; i<proteinEnergy.size();i++){
					protein_Energy_Unit += new String((String)proteinEnergy.get(i));
				}
			}
		}catch(Exception e){
			System.err.println("In setProteinEnergy of ePH.TPNRegimenBean ="+e.toString());
		}
	}

	public void setProteinOrderQuantity(ArrayList proteinOrderQty){
		//System.err.println("Inside setProteinOrderquantity---146-- bean" +proteinOrderQty.size());
		try{
			
			if(proteinOrderQty.size()==2){
				protein_Order_Quantity = new String((String)proteinOrderQty.get(0));
				protein_Order_Quantity_Unit = new String((String)proteinOrderQty.get(1));
				

			}else{
				protein_Order_Quantity_Unit="";//Added on 13/sept/2010 for the incident num:23718 by Sandhya
				protein_Order_Quantity = new String((String)proteinOrderQty.get(0));
				
				for(int i = 1; i<proteinOrderQty.size();i++){
					
					protein_Order_Quantity_Unit += new String((String)proteinOrderQty.get(i));
					
					//System.err.println("else protein_Order_Quantity_Unit---166- bean"  +protein_Order_Quantity_Unit);
				}
			}
		}catch(Exception e){
			System.err.println("In setProteinOrderQuantity of ePH.TPNRegimenBean ="+e.toString());
		}
	}

	public void setProteinStrengthWeight(ArrayList proteinStrengthWt){
		try{
			
			if(proteinStrengthWt.size()==2){
				protein_Strength_Weight = new String((String)proteinStrengthWt.get(0));
				protein_Strength_Weight_Unit = new String((String)proteinStrengthWt.get(1));
			}else{
				protein_Strength_Weight = new String((String)proteinStrengthWt.get(0));
				for(int i = 1; i<proteinStrengthWt.size();i++){
					protein_Strength_Weight_Unit += new String((String)proteinStrengthWt.get(i));
				}
			}
		}catch(Exception e){
			System.err.println("In setProteinStrengthWeight of ePH.TPNRegimenBean ="+e.toString());
		}
	}

	public void setLipidEnergy(ArrayList lipidEnergy){
		try{
			
			if(lipidEnergy.size()==2){
				lipid_Energy = new String((String)lipidEnergy.get(0));
				lipid_Energy_Unit = new String((String)lipidEnergy.get(1));
			}else{
				lipid_Energy = new String((String)lipidEnergy.get(0));
				for(int i = 1; i<lipidEnergy.size();i++){
					lipid_Energy_Unit += new String((String)lipidEnergy.get(i));
				}
			}
		}catch(Exception e){
			System.err.println("In setLipidEnergy of ePH.TPNRegimenBean ="+e.toString());
		}
	}

	public void setLipidOrderQuantity(ArrayList lipidOrderQty){	
		try{
			
			if(lipidOrderQty.size()==2){
				lipid_Order_Quantity = new String((String)lipidOrderQty.get(0));
				lipid_Order_Quantity_Unit = new String((String)lipidOrderQty.get(1));
			}else{
				lipid_Order_Quantity_Unit=""; //Added on 13/sept/2010 for the incident num:23718 by Sandhya
				lipid_Order_Quantity = new String((String)lipidOrderQty.get(0));
				for(int i = 1; i<lipidOrderQty.size();i++){
					lipid_Order_Quantity_Unit += new String((String)lipidOrderQty.get(i));
				}
			}
		}catch(Exception e){
			System.err.println("In setLipidOrderQuantity of ePH.TPNRegimenBean ="+e.toString());
		}
	}

	public void setLipidStrengthWeight(ArrayList lipidStrengthWt){
		try{
			
			if(lipidStrengthWt.size()==2){
				lipid_Strength_Weight = new String((String)lipidStrengthWt.get(0));
				lipid_Strength_Weight_Unit = new String((String)lipidStrengthWt.get(1));
			}else{
				lipid_Strength_Weight = new String((String)lipidStrengthWt.get(0));
				for(int i = 1; i<lipidStrengthWt.size();i++){
					lipid_Strength_Weight_Unit += new String((String)lipidStrengthWt.get(i));
				}
			}
		}catch(Exception e){
			System.err.println("In setLipidStrengthWeight of ePH.TPNRegimenBean ="+e.toString());
		}
		
	}

	public String getCarbohydrateEnergy(){
		return carbohydrate_Energy;
	}

	public String getCabohydrateOrderQuantity(){
		return cabohydrate_Order_Quantity;
	}

	public String getCabohydrateStrengthWeight(){
		return cabohydrate_Strength_Weight;
	}

	public String getProteinEnergy(){
		return protein_Energy;
	}

	public String getProteinOrderQuantity(){
		return protein_Order_Quantity ;
	}

	public String getProteinStrengthWeight(){
		return  protein_Strength_Weight;
	}

	public String getLipidEnergy(){
		return lipid_Energy;
	}

	public String getLipidOrderQuantity(){
		return lipid_Order_Quantity;
	}

	public String getLipidStrengthWeight(){
		return lipid_Strength_Weight;
	}

	public String getCarbohydrateEnergyUnit(){
		return carbohydrate_Energy_Unit ;
	}

	public String getCabohydrateOrderQuantityUnit(){
		return cabohydrate_Order_Quantity_Unit;
	}

	public String getCabohydrateStrengthWeightUnit(){
		return cabohydrate_Strength_Weight_Unit;
	}

	public String getProteinEnergyUnit(){
		return protein_Energy_Unit;
	}

	public String getProteinOrderQuantityUnit(){
		return protein_Order_Quantity_Unit;
	}

	public String getProteinStrengthWeightUnit(){
		return  protein_Strength_Weight_Unit;
	}

	public String getLipidEnergyUnit(){

		return lipid_Energy_Unit;
	}

	public String getLipidOrderQuantityUnit(){
		return lipid_Order_Quantity_Unit;
	}

	public String getLipidStrengthWeightUnit(){
		return lipid_Strength_Weight_Unit;
	}

	public void setDebugString(String debugString) {
		this.debugString = debugString;
	}

	public String getRecommendedEnergy(){
		return this.recoEnergy;
	}

	public String getPatientAge(){
		return this.patientAge;
	}

	public String getRecommendedEnergyUnit(){
		return this.recoEnergyUnit;
	}

	public String getPatientAgeUnit(){
		return this.patientAgeUnit;
	}
	public String getLoggedInFacility()  
	{
		return login_facility_id;
	}

	public ArrayList getProteinValue() {
		return this.proteinValue;
	}

	public ArrayList getLipidValue() {
		return this.lipidValue;
	}

	public ArrayList getEnergyValue(){
		return this.energyVal;
	}

	public void setDiagText(ArrayList diagText) {
		this.diagText = new ArrayList();
		this.diagText = diagText;
	}

	public ArrayList getDiagText() {
		return this.diagText;
	}

	private void doCommon() throws Exception {
	}

	public void clear() {
		super.clear();
//		order_date			= "";
//		patient_class		= "";
//		patient_id			= "";
//		encounter_id		= "";
//		drugCodes			= "";
//		infRate_srlNo		= "";
//		freqNature			= "";
//		repeat_value		= "";
//		int_value			= "";
//		hashMapFreq			= new HashMap();
//		hashMapDurn_value	= new HashMap();
//		hashMapDurn_type	= new HashMap();
//		order_status		= "10";
//		srlNo				= 0;
//		drugDetails			= new ArrayList();
		diagText			= new ArrayList(12);
		scheduleFrequency = new HashMap();
		hmAssesValues = null;

		debugString = "";
		recoEnergy="";
		recoEnergyUnit="";
		patientAge="";
		patientAgeUnit="";
		proteinValue = new ArrayList();
		lipidValue = new ArrayList();
		energyVal = new ArrayList();
		carbohydrate_Energy="";
		carbohydrate_Energy="";                 
		carbohydrate_Energy_Unit="";            
		cabohydrate_Order_Quantity="";          
		cabohydrate_Order_Quantity_Unit="";     
		cabohydrate_Strength_Weight="";         
		cabohydrate_Strength_Weight_Unit="";    
		protein_Energy="";                      
		protein_Energy_Unit="";                 
		protein_Order_Quantity_Unit="";         
		protein_Order_Quantity="";              
		protein_Strength_Weight="";             
		protein_Strength_Weight_Unit="";        
		lipid_Energy="";                        
		lipid_Energy_Unit="";                   
		lipid_Order_Quantity="";                
		lipid_Order_Quantity_Unit="";           
		lipid_Strength_Weight="";               
		lipid_Strength_Weight_Unit=""; 
		schdMap = null;

		//System.out.println(" TPNRegimenBean cleared =====================");
	}

	public ArrayList getPatientActiveOrders(String patient_id,String patient_class,String order_date){
		Connection connection		= null;
		PreparedStatement pstmt		= null;
		ResultSet resultSet			= null;
		String start_date			= "";
		String end_date				= "";
		String drug_desc			= "";
		String strength				= "";
		String split_dose_prev		= "";
		String strength_uom_desc	= "";
		String form_desc			= "";
		String practitioner_name	= "";
		String facility_name		= "";
		String diag_text			= "";
		String location				= "";
		String order_id				= "";
		String order_line_no		= "";
		String freq_code			= "";
		String freq_desc			= "";
		String allergy_reason		= "";
		String dosage_reason		= "";
		String duplicate_reason		= "";

		ArrayList activeOrders		= new ArrayList();
		HashMap	record				= null;

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT51"));
			pstmt.setString(1, patient_id);
			pstmt.setString(2, getLanguageId());
			pstmt.setString(3, getLanguageId());
			pstmt.setString(4, getLanguageId());
			pstmt.setString(5, getLanguageId());
			
			resultSet	= pstmt.executeQuery();

			while (resultSet != null && resultSet.next()) {
				record	=	new HashMap();
				start_date			= resultSet.getString("START_DATE");
				end_date			= resultSet.getString("END_DATE");
				drug_desc			= resultSet.getString("DRUG_DESC");
				strength			= resultSet.getString("STRENGTH");
				split_dose_prev		= resultSet.getString("SPLIT_DOSE_PREVIEW");
				strength_uom_desc	= resultSet.getString("STRENGTH_UOM");
				form_desc			= resultSet.getString("FORM_CODE");
				practitioner_name	= resultSet.getString("PRACTITIONER_NAME");
				facility_name		= resultSet.getString("FACILITY_NAME");
				diag_text			= resultSet.getString("DIAG_TEXT");
				location			= resultSet.getString("LOCATION");
				order_id			= resultSet.getString("ORIG_ORDER_ID");
				order_line_no		= resultSet.getString("ORIG_ORDER_LINE_NO");
				freq_code			= resultSet.getString("FREQ_CODE");
				freq_desc			= resultSet.getString("FREQ_DESC");
				allergy_reason		= resultSet.getString("ALLERGY_OVERRIDE_REASON");
				dosage_reason		= resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON");
				duplicate_reason	= resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON");

				record.put("start_date",start_date);
				record.put("end_date",end_date);
				record.put("drug_desc",drug_desc);
				record.put("strength",strength);
				record.put("strength_uom_desc",strength_uom_desc);
				record.put("form_desc",form_desc);
				record.put("practitioner_name",practitioner_name);
				record.put("location",location);
				record.put("facility_name",facility_name);
				record.put("diag_text",diag_text);
				record.put("split_dose_prev",split_dose_prev);
				record.put("order_id",order_id);
				record.put("order_line_no",order_line_no);
				record.put("freq_code",freq_code);
				record.put("freq_desc",freq_desc);
				record.put("allergy_reason",allergy_reason);
				record.put("dosage_reason",dosage_reason);
				record.put("duplicate_reason",duplicate_reason);
				activeOrders.add(record);
			}
		}
		catch(Exception e) {
			activeOrders.add(e.toString());
		}
 	    finally {
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
			System.err.println("Error "+es);}
		}
		return activeOrders;
	}

	public boolean setScheduleFrequencyStr(Hashtable ht){
		try {
			String code 			= (String)ht.get("code");
			String duration_type 	= (String)ht.get("durationType");
			int repeat				= Integer.parseInt((String)ht.get("repeat"));
			String row_value		= (String)ht.get("row_value");
			scheduleFrequency		= new HashMap();
			ArrayList scheduleFrequencyDatas = new ArrayList();

			for(int j=1; j <= repeat; j++) {
				HashMap hashMap	= new HashMap();
				hashMap.put("admin_day_or_time","H");
				hashMap.put("duration_type",duration_type);
				hashMap.put("start_time_assign","");
				hashMap.put("repeat",String.valueOf(repeat));
				hashMap.put("row_value",row_value);
				hashMap.put("admin_time",(String)ht.get("time"+j));
				hashMap.put("admin_qty",(String)ht.get("qty"+j));
				scheduleFrequencyDatas.add(hashMap);
			}
			scheduleFrequency.put(code,scheduleFrequencyDatas);
			return true;
		}
		catch(Exception e) {
			System.err.println("Error when setting schedule");
			return false;
		}
	}

	public ArrayList getScheduleFrequencyStr(String code, String row_value) {
		Object scheduleFrequencyDatasObj = scheduleFrequency.get(code);

		if(scheduleFrequencyDatasObj == null)
			return new ArrayList();
		else
			return (ArrayList)scheduleFrequencyDatasObj;
	}
	public void  setScheduleDates(HashMap schdMap)
	{
		this.schdMap = schdMap;	
	}
	public HashMap getScheduleDates()
	{
		return this.schdMap;
	}
	public ArrayList populateStressFactorValues(){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList stressFactorValues = new ArrayList();
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_SELECT1"));
			pstmt.setString(1, getLanguageId());
			resultSet	= pstmt.executeQuery();
			while (resultSet.next()) {
				stressFactorValues.add(resultSet.getString("STRESS_RELATED_OPTION"));
				stressFactorValues.add(resultSet.getString("WEIGHTAGE"));
				stressFactorValues.add(resultSet.getString("DEFAULT_YN"));
			}
		}catch (Exception e) {
				System.err.println("Error loading StressFactor Values : " + e);
				e.printStackTrace();
			}finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}catch(Exception es) {System.err.println("Error loading StressFactor Values : " + es);}
		}
		return stressFactorValues;
	}

	public void calculateRecommendedEnergy(String weight, String height, String patient_id, String stressWeight){
		Connection connection		= null;
        CallableStatement cstmt		= null;
        ResultSet resultSet			= null;
	//	System.err.println("calculateRecommendedEnergy" + weight + " " + height);
		try {
			connection	= getConnection();
			cstmt=connection.prepareCall("{call Ph_Recommendedenergy(?,?,?,?,?,?,?,?)}");
			cstmt.setFloat(1, Float.parseFloat(weight));
			cstmt.setFloat(2, Float.parseFloat(height));
			cstmt.setString(3, patient_id);
			cstmt.setFloat(4, Float.parseFloat(stressWeight));
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.registerOutParameter(6, Types.VARCHAR);
			cstmt.registerOutParameter(7, Types.VARCHAR);
			cstmt.registerOutParameter(8, Types.VARCHAR);
			cstmt.execute();

			recoEnergy = cstmt.getString(5);
			recoEnergyUnit = cstmt.getString(6);
			patientAge = cstmt.getString(7);
			patientAgeUnit = cstmt.getString(8);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error loading Recommended Energy :"+e);
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(cstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error loading Recommended Energy :"+es);}
		}
	}

	public ArrayList getFluidRequired(String patient_id){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList fluidValue = new ArrayList();
		int ispresent=0;
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_SELECT2"));
			pstmt.setString(1, patient_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, patient_id);
			pstmt.setString(4, getLanguageId());
			resultSet	= pstmt.executeQuery();
			while (resultSet.next())
			{
				fluidValue.add(resultSet.getString("CONST_QTY_UNIT"));
				fluidValue.add(resultSet.getString("CONST_MIN_VAL"));
				fluidValue.add(resultSet.getString("CONST_MAX_VAL"));
				fluidValue.add(resultSet.getString("CONST_STD_VAL"));
				ispresent=1;
			}
			if(resultSet!=null) closeResultSet(resultSet);
			if (pstmt!=null)	closeStatement(pstmt);
			if (ispresent==0)
			{
				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_SELECT6"));
				resultSet	= pstmt.executeQuery();
				while (resultSet.next()){
					fluidValue.add(resultSet.getString("ORDERING_UNIT"));
					fluidValue.add("0");
					fluidValue.add("100000");
					fluidValue.add("0");
					ispresent=1;
				}
				if (ispresent==0)
				{
					fluidValue.add("  ");
					fluidValue.add("0");
					fluidValue.add("100000");
					fluidValue.add("0");

				}

			}//while


						
		}catch (Exception e) {
				System.err.println("Error loading Fluid Required: " + e);
				//e.printStackTrace();
			}finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}catch(Exception es) {System.err.println("Error loading Fluid Required: " + es);}
		}
		return fluidValue;
	}

	public ArrayList getPatientAgeGroupDetails(String patient_id){

		Connection connection		= null;
		PreparedStatement pstmt		= null;
		ResultSet resultSet			= null;
		String pat_gender		= "";
		String pat_age_in_days  = "";
		ArrayList PatientAgeDtls		= new ArrayList();
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_SELECT14"));
			pstmt.setString(1, patient_id);
			resultSet	= pstmt.executeQuery();

			if (resultSet != null && resultSet.next()) {
				pat_gender			= resultSet.getString("PAT_GENDER");
				pat_age_in_days		= resultSet.getString("PAT_AGE_IN_DAYS");
				PatientAgeDtls.add(pat_gender);
				PatientAgeDtls.add(pat_age_in_days);

			}
		}
		catch(Exception e) {
			PatientAgeDtls.add(e.toString());
		}
 	    finally {
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
			System.err.println("Error "+es);}
		}
		return PatientAgeDtls;

	}


	public void getProtienLipidValues(String pat_gender,String pat_age_in_days){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		proteinValue = new ArrayList();
		lipidValue = new ArrayList();
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_SELECT3"));
			pstmt.setString(1, pat_gender);
			pstmt.setString(2, pat_age_in_days);
			pstmt.setString(3, getLanguageId());
			
			resultSet	= pstmt.executeQuery();
			while (resultSet.next()){
				String tmp=resultSet.getString("CONST_GENERIC_CODE");
				if(tmp.equalsIgnoreCase("PROTEIN") && proteinValue.size()==0){
					proteinValue.add(resultSet.getString("CONST_QTY_UNIT"));
					proteinValue.add(resultSet.getString("CONST_MIN_VAL"));
					proteinValue.add(resultSet.getString("CONST_MAX_VAL"));
					proteinValue.add(resultSet.getString("CONST_STD_VAL"));
				}
				if(tmp.equalsIgnoreCase("LIPID")  && lipidValue.size()==0 ){
					lipidValue.add(resultSet.getString("CONST_QTY_UNIT"));
					lipidValue.add(resultSet.getString("CONST_MIN_VAL"));
					lipidValue.add(resultSet.getString("CONST_MAX_VAL"));
					lipidValue.add(resultSet.getString("CONST_STD_VAL"));
				}
			}
		}catch (Exception e) {
				System.err.println("Error Protein/Lipid Values : " + e);
				e.printStackTrace();
			}finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}catch(Exception es) {System.err.println("Error Protein/Lipid Values : " + es);
			}
		}
	}
	public String getEqvlValues(String constUnit){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String eqvlval = "";
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TPN_REGIMEN_SELECT7"));
			pstmt.setString(1, constUnit);
			pstmt.setString(2, constUnit);
			resultSet	= pstmt.executeQuery();
			while (resultSet.next()){
				eqvlval = resultSet.getString("EQVL_VALUE");

			}
		}catch (Exception e) {

				e.printStackTrace();
			}finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}catch(Exception es) {System.err.println("Error  Values : " + es);
			}
		}
		return eqvlval;
	}

	public void calculateMacroNutrients(String recoEnergy, String proteinVal, String lipidVal, String weight){
		Connection connection		= null;
        CallableStatement cstmt		= null;
        ResultSet resultSet			= null;

		energyVal = new ArrayList();
		try {
			connection	= getConnection();
			cstmt=connection.prepareCall("{call Ph_Energyforcons(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			cstmt.setFloat(1, Float.parseFloat(recoEnergy));
			cstmt.setFloat(2, Float.parseFloat(proteinVal));
			cstmt.setFloat(3, Float.parseFloat(lipidVal));
			cstmt.setFloat(4, Float.parseFloat(weight));


			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.registerOutParameter(6, Types.VARCHAR);
			cstmt.registerOutParameter(7, Types.VARCHAR);
			cstmt.registerOutParameter(8, Types.VARCHAR);
			cstmt.registerOutParameter(9, Types.VARCHAR);
			cstmt.registerOutParameter(10,Types.VARCHAR);
			cstmt.registerOutParameter(11,Types.VARCHAR);
			cstmt.registerOutParameter(12,Types.VARCHAR);
			cstmt.registerOutParameter(13,Types.VARCHAR);
			cstmt.registerOutParameter(14,Types.VARCHAR);
			cstmt.registerOutParameter(15,Types.VARCHAR);
			cstmt.registerOutParameter(16, Types.VARCHAR);

			cstmt.execute();	

			energyVal.add(cstmt.getString(5));
			energyVal.add(cstmt.getString(6));
			energyVal.add(cstmt.getString(7));
			energyVal.add(cstmt.getString(8));
			energyVal.add(cstmt.getString(9));
			energyVal.add(cstmt.getString(10));
			energyVal.add(cstmt.getString(11));
			energyVal.add(cstmt.getString(12));
			energyVal.add(cstmt.getString(13));
			energyVal.add(cstmt.getString(14));
			energyVal.add(cstmt.getString(15));
			energyVal.add(cstmt.getString(16));
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error loading Macro Nutrients :"+e);
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(cstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error loading Macro Nutrients :"+es);
			}
		}
	}

	public void calculateMacroNutrients(String recoEnergy, String proteinVal, String lipidVal, String carboVal, String weight){
		Connection connection		= null;
        CallableStatement cstmt		= null;
        ResultSet resultSet			= null;

		energyVal = new ArrayList();
		try {
			connection	= getConnection();
			cstmt=connection.prepareCall("{call Ph_Energybypatwt(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			cstmt.setFloat(1, Float.parseFloat(recoEnergy));
			cstmt.setFloat(2, Float.parseFloat(proteinVal));
			cstmt.setFloat(3, Float.parseFloat(lipidVal));
			cstmt.setFloat(4, Float.parseFloat(carboVal));
			cstmt.setFloat(5, Float.parseFloat(weight));


			cstmt.registerOutParameter(6, Types.VARCHAR);
			cstmt.registerOutParameter(7, Types.VARCHAR);
			cstmt.registerOutParameter(8, Types.VARCHAR);
			cstmt.registerOutParameter(9, Types.VARCHAR);
			cstmt.registerOutParameter(10, Types.VARCHAR);
			cstmt.registerOutParameter(11,Types.VARCHAR);
			cstmt.registerOutParameter(12,Types.VARCHAR);
			cstmt.registerOutParameter(13,Types.VARCHAR);
			cstmt.registerOutParameter(14,Types.VARCHAR);
			cstmt.registerOutParameter(15,Types.VARCHAR);
			cstmt.registerOutParameter(16,Types.VARCHAR);
			cstmt.registerOutParameter(17, Types.VARCHAR);

			cstmt.execute();	

			energyVal.add(cstmt.getString(6));
			energyVal.add(cstmt.getString(7));
			energyVal.add(cstmt.getString(8));
			energyVal.add(cstmt.getString(9));
			energyVal.add(cstmt.getString(10));
			energyVal.add(cstmt.getString(11));
			energyVal.add(cstmt.getString(12));
			energyVal.add(cstmt.getString(13));
			energyVal.add(cstmt.getString(14));
			energyVal.add(cstmt.getString(15));
			energyVal.add(cstmt.getString(16));
			energyVal.add(cstmt.getString(17));
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error loading Macro Nutrients (by Pat Wt):"+e);
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(cstmt);
				closeConnection(connection);
			}
			catch(Exception es) {System.err.println("Error loading Macro Nutrients(by Pat Wt) :"+es);
			}
		}
	}

	 public HashMap ChkScreeningDetails(String facility_id,String encounter_id,String note_type){
		//System.err.println("calling this method--->");
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String accession_num="";
		HashMap result			= new HashMap();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT91") );
			pstmt = connection.prepareStatement("SELECT ACCESSION_NUM FROM CA_ENCNTR_NOTE WHERE FACILITY_ID=? AND ENCOUNTER_ID =? AND NOTE_TYPE=?");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,note_type);
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
                 accession_num =resultSet.getString("ACCESSION_NUM");
			     result.put("ACCESSION_NUM",accession_num);
			 }
          }
		catch(Exception e){
			 e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		//System.err.println("result----->"+result);
		return result;
	}

   public HashMap ChkDiscrete(String facility_id,String encounter_id,String note_type){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String contr_module_id="PH";
		HashMap result			= new HashMap();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT91") );
			pstmt = connection.prepareStatement("SELECT  distinct to_char(TEST_OBSERV_DT_TM,'dd/mm/yyyy hh24:mi:ss') TEST_OBSERV_DT_TM FROM ca_encntr_discr_msr WHERE ? = facility_id(+) and encounter_id = ? and discr_msr_panel_or_form_id = ? and CONTR_MODULE_ID =? ");			
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,note_type);
			pstmt.setString(4,contr_module_id);
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
                
				 result.put("TEST_OBSERV_DT_TM",resultSet.getString("TEST_OBSERV_DT_TM"));
				
			}
          }
		catch(Exception e){
			 e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}

		//System.err.println("TEST_OBSERV_DT_TM---from bean----->"+result);
		return result;
	}
	
   public HashMap ChkAPatientAge(String patient_id){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		HashMap result			= new HashMap();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT91") );
			pstmt = connection.prepareStatement("SELECT TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH,SEX FROM MP_PATIENT WHERE PATIENT_ID=?");
			pstmt.setString(1,patient_id);
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
                
				 result.put("DATE_OF_BIRTH",resultSet.getString("DATE_OF_BIRTH"));
				 result.put("SEX",resultSet.getString("SEX"));

			}
          }
		catch(Exception e){
			 e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}

		//System.err.println("result---from bean----->"+result);
		return result;
	}

	public HashMap ChkAdMixture(){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String iv_admixture_appl_yn="";
		HashMap result			= new HashMap();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT91") );
			pstmt = connection.prepareStatement("select IV_ADMIXTURE_APPL_YN,ALERT_PRACTITIONER_YN,TPN_SCREENING_TYPE,TPN_SCREENING_FORM_ID from ph_facility_param where FACILITY_ID=?");
			pstmt.setString(1,getLoginFacilityId());
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next())
			{
                 iv_admixture_appl_yn =resultSet.getString("IV_ADMIXTURE_APPL_YN");
			     result.put("IV_ADMIXTURE_APPL_YN",iv_admixture_appl_yn);
				 result.put("ALERT_PRACTITIONER_YN",resultSet.getString("ALERT_PRACTITIONER_YN"));
				 result.put("TPN_SCREENING_TYPE",resultSet.getString("TPN_SCREENING_TYPE"));
				 result.put("TPN_SCREENING_FORM_ID",resultSet.getString("TPN_SCREENING_FORM_ID"));

			}
			if(resultSet!=null) closeResultSet( resultSet ) ;
			if(pstmt!=null)	closeStatement( pstmt ) ;
            if(iv_admixture_appl_yn.equals("Y"))
            {
			  pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT92") );
			  pstmt.setString(1,getLoginFacilityId());
			  resultSet = pstmt.executeQuery() ;
			
			   if (resultSet != null && resultSet.next()){
				result.put("time_flag",resultSet.getString(1));				
			   }

			   if(resultSet!=null) closeResultSet( resultSet ) ;
			   if(pstmt!=null) closeStatement( pstmt ) ;
			}
		}catch(Exception e){
//			System.out.println(e);
			e.printStackTrace();
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
				
		return result;
	}

	public void setHmAssesValues(int iFormulaSelected, int iWeightSelected, String sEnergy, boolean bActFactor, String sRecoEnergy, 
								String sCarboPercent, String sLipidPercent, String sProteinPercent, String sFluid, String sEnergyProvided,
								int iProtenLevel, int iLipidsLevel, int iStressFactor)
	{
		hmAssesValues = new HashMap();
		hmAssesValues.put("iFormulaSelected",iFormulaSelected );
		hmAssesValues.put("iWeightSelected",iWeightSelected);
		hmAssesValues.put("iStressFactor",iStressFactor);		
		hmAssesValues.put("sEnergy",sEnergy);
		hmAssesValues.put("bActFactor",bActFactor);
		hmAssesValues.put("sRecoEnergy",sRecoEnergy);
		hmAssesValues.put("sCarboPercent",sCarboPercent);
		hmAssesValues.put("sLipidPercent",sLipidPercent);
		hmAssesValues.put("sProteinPercent",sProteinPercent);
		hmAssesValues.put("sFluid",sFluid);
		hmAssesValues.put("sEnergyProvided",sEnergyProvided);
		hmAssesValues.put("iProtenLevel",iProtenLevel);
		hmAssesValues.put("iLipidsLevel",iLipidsLevel);
	}

	public HashMap getHmAssesValues()
	{
		return hmAssesValues;
	}
	
	public String chkAssesmentApplicableYn(){ // Added for ML-MMOH-CRF-1126 - Start
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String assesmentApplYn = "N";
	try{
		connection = getConnection() ;
		pstmt = connection.prepareStatement("SELECT ASSESMENT_REQ_YN FROM PH_FACILITY_PARAM WHERE FACILITY_ID=?");
		pstmt.setString(1,getLoginFacilityId());
		resultSet = pstmt.executeQuery() ;
		if (resultSet != null && resultSet.next()){
			assesmentApplYn=(String)resultSet.getString("ASSESMENT_REQ_YN")==null?"N":(String)resultSet.getString("ASSESMENT_REQ_YN"); 
		}
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}catch(Exception es){
			es.printStackTrace();
		}
	}
	    return assesmentApplYn;
   } 
	
	public boolean isSiteSpecific(String moduleId, String functionalityId){
		boolean site=false;
	    Connection con	= null;  
        try{
        	con =			getConnection();		
        	site = eCommon.Common.CommonBean.isSiteSpecific(con,moduleId,functionalityId);	
		}
        catch(Exception e){
            e.printStackTrace();
        }
		finally{
			try{
			closeConnection(con);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return site;
   } // Added for ML-MMOH-CRF-1126 - End
}  
