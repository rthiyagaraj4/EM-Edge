/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMP.PatSearch;

import javax.ejb.*;
import java.sql.*;
import java.util.Properties;
import java.util.HashMap;
import java.text.*;
import java.rmi.*;
import com.ehis.util.*;

import webbeans.eCommon.*; 

/**
*
* @ejb.bean
*	name="PatSearch"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PatSearch"
*	local-jndi-name="PatSearch"
*	impl-class-name="eMP.PatSearch.PatSearchManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMP.PatSearch.PatSearchLocal"
*	remote-class="eMP.PatSearch.PatSearchRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMP.PatSearch.PatSearchLocalHome"
*	remote-class="eMP.PatSearch.PatSearchHome"
*	generate= "local,remote"
*
*
*/

public class PatSearchManager implements javax.ejb.SessionBean {
	
	private SessionContext ctx;
	private int threshold;

	String temp="";
	int mrns=0 ;

	//String patientList="";
	//String tableBuilt = "";
	
	private StringBuffer sbr_patientList=new StringBuffer();
	StringBuffer sbr_tableBuilt = new StringBuffer();

	public void ejbCreate()throws CreateException {	}
	
	public void ejbRemove() 
	{
		ctx = null;
		threshold = 0;
	}
	
	public void ejbActivate() {	}
	
	public void ejbPassivate() { }
	
	public void setSessionContext(javax.ejb.SessionContext ctx) {
		this.ctx = ctx;
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap getSearchTable(String func_act, String logged_facility, String query,int current,int totalpercent,String function_id,String search_in,String act_yn,String photo[],String alignment, String othlang,Properties props,int searchThreshold) 
	{
		Connection con = null;
	    Statement stmt  = null;
		ResultSet rs = null;

		 PreparedStatement pstmt = null;
		 //ResultSet rs1=null;

		 String language_direction="";

		 int count=0;

		String patientList="";
		String tableBuilt = "";
		
		 sbr_patientList=new StringBuffer();
		 sbr_tableBuilt = new StringBuffer();

		threshold = searchThreshold;
		
		
	    try
        {
            con = ConnectionManager.getConnection(props);
            stmt = con.createStatement(1005, 1007);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }

		String pfc				= "";
		String pfi				= "";		
		String dup_indicator	= "";
		int name_prefix_place = 0;
		int first_name_place = 0;
		int second_name_place = 0;
		int third_name_place = 0;
		int family_name_place = 0;
		int name_suffix_place = 0;
		int patient_name_place = 0;
		int date_of_birth_place = 0;
		int colCount = 0;
		int mrn_place = 0;
		int reg_mode = 0;
		int gender = 0;
		int file_no_place = 0;
		int facility_name_place = 0;
		int nationality_place = 0;
		int res_area_place = 0;
		int pref_facility_place = 0;
		String locale = props.getProperty("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;
		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
		java.util.ResourceBundle mp_labels = java.util.ResourceBundle.getBundle( "eMP.resources.Labels",loc);

		String patient = "";
		String curr_patient_class = "";
		String enc_facility_id = "";
		String curr_encounter_id = "";
		String enablemrnyn="";

		//int pos=0;
		//int pos1=0;

		patientList="";
		tableBuilt = "";
		sbr_tableBuilt=new StringBuffer();
		sbr_patientList=new StringBuffer();
		
		sbr_tableBuilt.append("<table border='1' width='" + totalpercent + "%' cellspacing='0' cellpadding='0'>");
		sbr_patientList.append("<table border='1' width='100%' cellspacing='0' cellpadding='0'><th nowrap class='label'>+</th>");
		
		try{
			pstmt = con.prepareStatement( "select count(*) as total from sm_language where language_direction='R'" ) ;
			rs = pstmt.executeQuery() ;
			if ( rs != null && rs.next()){
				count = rs.getInt("total");
			}

			if (count==1){
				language_direction = "R" ;
			}else{
				language_direction = "L" ;
			}


			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			Statement stmt11 = con.createStatement();		
			String sql="select count(*) from mp_pat_search_result where field_select='Y'";
			ResultSet rs2 = stmt11.executeQuery(sql);
			int totalHeaders = 0;
			if(rs2.next()){
				totalHeaders = rs2.getInt(1);
			}		
			rs2.close();	

			sql="select field_name,field_desc from mp_pat_search_result_lang_vw  where LANGUAGE_ID='"+locale+"' and field_select='Y' order by field_order ";
			ResultSet rs3 = stmt11.executeQuery(sql);
			
			int i=1;
			boolean	photo_display = false;
			while(rs3.next() && i<=totalHeaders){
				if(i==1){
					sbr_patientList.append("<th nowrap><b><a href=\"javascript:ordercols('"+rs3.getString(1)+"')\">"+rs3.getString(2)+"</a></b></th><th class='label'><b>"+ "S" + "</b></th><th class='label'><b>PC</b></th>");
				}else if(i!=1){ 
					if(rs3.getString(1).equals("File_No")){
						enablemrnyn="Y";
					}
					if(rs3.getString(1).equals("Pat_Photo")){
						photo_display=true;
						sbr_tableBuilt.append("<th nowrap>"+ rs3.getString(2) + "</th>");
					}else{
						if(language_direction.equals("R") && rs3.getString(1).equalsIgnoreCase("PATIENT_NAME_LOC_LANG")){
							sbr_tableBuilt.append("<th nowrap dir='RTL'><b><a href=\"javascript:ordercols('"+rs3.getString(1)+"')\">"+rs3.getString(2)+"</a></b></th>");
						}else{
							sbr_tableBuilt.append("<th nowrap><b><a href=\"javascript:ordercols('"+rs3.getString(1)+"')\">"+rs3.getString(2)+"</a></b></th>");
						}
					}
				}				
				i++;
			}
			rs3.close();
			stmt11.close();							
			rs = stmt.executeQuery(query);				
			if(current!=1) rs.absolute(current-1);
			ResultSetMetaData rsmd = rs.getMetaData();
			colCount = rsmd.getColumnCount();
			for(int zi=1;zi<=colCount;zi++){

				if((rsmd.getColumnName(zi)).equalsIgnoreCase("File_No")) mrn_place = zi;
				if((rsmd.getColumnName(zi)).equalsIgnoreCase("EMEG_REGN_YN")) reg_mode = zi;
				if((rsmd.getColumnName(zi)).equalsIgnoreCase("SEX")) gender = zi;
				if((rsmd.getColumnName(zi)).equalsIgnoreCase("Old_File_No")) file_no_place = zi;
				if((rsmd.getColumnName(zi)).equalsIgnoreCase("Facility_Id")) facility_name_place = zi;	//Added by kumar on 8/3/2002 for displaying res area desc and nationality desc in the search result
				if((rsmd.getColumnName(zi)).equalsIgnoreCase("Res_Area_Code")) 
					res_area_place = zi;
				if((rsmd.getColumnName(zi)).equalsIgnoreCase("Nationality_Code")) 
					nationality_place = zi;			
				if((rsmd.getColumnName(zi)).equalsIgnoreCase("Pref_Facility_Id")) 
					pref_facility_place = zi;	
				if((rsmd.getColumnName(zi)).equalsIgnoreCase("date_of_birth")) 				date_of_birth_place = zi;
				if(othlang.equals("Y")){
					if((rsmd.getColumnName(zi)).equalsIgnoreCase("name_prefix_loc_lang"))  				name_prefix_place = zi;
					if((rsmd.getColumnName(zi)).equalsIgnoreCase("first_name_loc_lang"))   				first_name_place = zi;
					if((rsmd.getColumnName(zi)).equalsIgnoreCase("second_name_loc_lang"))  				second_name_place = zi;
					if((rsmd.getColumnName(zi)).equalsIgnoreCase("third_name_loc_lang"))   				third_name_place = zi;
					if((rsmd.getColumnName(zi)).equalsIgnoreCase("family_name_loc_lang"))  				family_name_place = zi;
					if((rsmd.getColumnName(zi)).equalsIgnoreCase("name_suffix_loc_lang"))  				name_suffix_place = zi;
					if((rsmd.getColumnName(zi)).equalsIgnoreCase("patient_name_loc_lang")) 				patient_name_place = zi;	
				}
			}

			String classValue = "";
			i =0;
			while(rs.next() && i<threshold){
				if(i%2 == 0) classValue="AR_QRYEVEN" ;
				else classValue="AR_QRYODD" ;

				pfi=rs.getString("PREF_FACILITY_ID");
				if(pfi==null) pfi=logged_facility;

				if(!pfi.equals(logged_facility)) pfc="PREF_FACILITY";
				else pfc=classValue;
				sbr_patientList.append("<tr>");
				sbr_tableBuilt.append("<tr>");
				
				int o = 1;
				
				while(o <= totalHeaders){
					if(o == 1 ){
						patient=rs.getString(o);
						curr_patient_class=rs.getString("CURR_PATIENT_CLASS");
						enc_facility_id=rs.getString("enc_facility_id");
						curr_encounter_id=rs.getString("curr_encounter_id");
						if(patient==null) patient="";
						if(curr_patient_class==null) curr_patient_class="";
						if(enc_facility_id==null) enc_facility_id="";
						if(curr_encounter_id==null) curr_encounter_id="";
						if (search_in.equals("B") || search_in.equals("D"))
						{
							dup_indicator = rs.getString("dup_indicator");	
							if (dup_indicator==null) dup_indicator = "";
							dup_indicator = dup_indicator.trim();
						}
						if(function_id.equals("DR_UNMERGED_PATIENT_IDS")||((function_id.equals("")  || function_id.equals("NEWBORN_REG"))&&search_in.equals("B")))
						{
							if(rs.getString("dup_indicator").equals("D"))
							{
								sbr_patientList.append("<td nowrap class='"+ classValue +"' title='View Patient Details'  onClick=ViewPatDtlDup(\""+java.net.URLEncoder.encode(patient)+"\")><a href=\"javascript:callDummy();\">+</a></td>");			
							}
							else
							{
								sbr_patientList.append("<td nowrap class='"+classValue+"' title='View Patient Details' onClick=ViewPatDtl(\""+java.net.URLEncoder.encode(patient)+"\")><a href=\"javascript:callDummy();\">+</a></td>");
							}
						}
						else if((function_id.equals("") ||  function_id.equals("NEWBORN_REG"))&&search_in.equals("D"))
						{
							sbr_patientList.append("<td nowrap class='"+classValue+"' title='View Patient Details' onClick=ViewPatDtl(\""+java.net.URLEncoder.encode(patient)+"\")><a href=\"javascript:callDummy();\">+</a></td>");	
						}
						else
						{
							sbr_patientList.append("<td nowrap class='"+classValue+"' title='View Patient Details' onClick=ViewPatDtl(\""+java.net.URLEncoder.encode(patient)+"\")><a href=\"javascript:callDummy();\">+</a></td>");
						}
						if(act_yn.equals("Y"))
						{
							if(function_id.equals("DR_UNMERGED_PATIENT_IDS")||((function_id.equals("") ||  function_id.equals("NEWBORN_REG"))&&search_in.equals("B")))
							{
								if(dup_indicator.equalsIgnoreCase("V"))	
								{
									sbr_patientList.append("<td nowrap class="+classValue+" onClick=displayToolTip(\""+java.net.URLEncoder.encode(patient)+"\") onMouseOver=\"hideToolTip()\" ><a href=\"javascript:\">"+patient+"</a></td>");
								}
								else
								{	
									sbr_patientList.append("<td nowrap class="+classValue+" >&nbsp;&nbsp;&nbsp;&nbsp;"+patient+"</a></td>");
								}
							}
							else if ((function_id.equals("") ||  function_id.equals("NEWBORN_REG"))&&search_in.equals("D"))
							{
								sbr_patientList.append("<td nowrap class='"+classValue+"'>"+patient+"</a></td>");
							}
							else
							{
								String suspended=rs.getString("Suspend_Yn")==null ? "N" : rs.getString("Suspend_Yn");
								String deceased=rs.getString("Deceased_Yn")==null ? "N" : rs.getString("Deceased_Yn");
								String active=rs.getString("Active_Yn")==null ? "Y" : rs.getString("Active_Yn");
								if(func_act.equals("RECD"))
								{
									sbr_patientList.append("<td nowrap class="+classValue+" onClick=displayToolTip(\""+java.net.URLEncoder.encode(patient)+"\") onMouseOver=\"hideToolTip()\" ><a href=\"javascript:\">"+patient+"</a></td>");
								}
								else if(func_act.equals("SUSP"))
								{
									if(deceased.equals("N")&&active.equals("Y"))
									{
										sbr_patientList.append("<td nowrap class="+classValue+" onClick=displayToolTip(\""+java.net.URLEncoder.encode(patient)+"\") onMouseOver=\"hideToolTip()\" ><a href=\"javascript:\">"+patient+"</a></td>");
									}
									else
									{
										temp=rs.getString(o);
										if(temp==null) temp="&nbsp;";
										sbr_patientList.append("<td nowrap class='"+classValue+"'>" + temp + "</td>");
									}
								}
								else if(func_act.equals("ACTV"))
								{
									if(deceased.equals("N")&&suspended.equals("N"))		
									{
										sbr_patientList.append("<td nowrap class="+classValue+" onClick=displayToolTip(\""+java.net.URLEncoder.encode(patient)+"\") onMouseOver=\"hideToolTip()\" ><a href=\"javascript:\">"+patient+"</a></td>");
									}
									else
									{
										temp=rs.getString(o);
										if(temp==null) temp="&nbsp;";
										sbr_patientList.append("<td nowrap class='"+classValue+"'>" + temp + "</td>");
									}
								}
								else
								{
									sbr_patientList.append("<td nowrap class="+classValue+" onClick=displayToolTip(\""+java.net.URLEncoder.encode(patient)+"\") onMouseOver=\"hideToolTip()\" ><a href=\"javascript:\">"+patient+"</a></td>");
								}
							} 
						}
						else
						{				
							String suspended=rs.getString("Suspend_Yn")==null ? "N" : rs.getString("Suspend_Yn");
							String deceased=rs.getString("Deceased_Yn")==null ? "N" : rs.getString("Deceased_Yn");
							String active=rs.getString("Active_Yn")==null ? "Y" : rs.getString("Active_Yn");
							String restricted=rs.getString("restrict_reinstate_yn")==null ? "N" : rs.getString("restrict_reinstate_yn");
							//Added by Ajay Hatwate for MMS-DM-CRF-0210.1
							if(!func_act.equals("VIEW"))
							{
								if(deceased.equals("Y") && func_act.equals("CHG_PAT_DTLS")) 
								{
									temp=rs.getString(o);
									if(temp==null) temp="&nbsp;";
									sbr_patientList.append("<td nowrap class="+classValue+" onClick=displayToolTip(\""+java.net.URLEncoder.encode(temp)+"\") onMouseOver=\"hideToolTip()\" ><a href=\"javascript:\">"+temp+"</a></td>");
									
								}
								else if(deceased.equals("Y")) 
								{
									temp=rs.getString(o);
									if(temp==null) temp="&nbsp;";
									sbr_patientList.append("<td nowrap class='"+classValue+"'>" + temp + "</td>");
									
								}
								else if(suspended.equals("Y"))
								{
									temp=rs.getString(o);
									if(temp==null) temp="&nbsp;";
									sbr_patientList.append("<td nowrap class='"+classValue+"'>" + 			temp + "</td>");
								}
								else if(active.equals("N"))
								{
									temp=rs.getString(o);
									if(temp==null) temp="&nbsp;";
									sbr_patientList.append("<td nowrap class='"+classValue+"'>" + temp + "</td>");
								}else if(restricted.equals("Y"))//Added by Ajay Hatwate for MMS-DM-CRF-0210.1
								{
									temp=rs.getString(o);
									if(temp==null) temp="&nbsp;";
									sbr_patientList.append("<td nowrap class='"+classValue+"'>" + temp + "</td>");
								}
								else if (function_id.equals("") ||  function_id.equals("NEWBORN_REG"))
								{
									if(search_in.equals("B"))
									{
										if(dup_indicator.equalsIgnoreCase("V"))	
										{
											sbr_patientList.append("<td nowrap class="+classValue+" onClick=displayToolTip(\""+java.net.URLEncoder.encode(patient)+"\") onMouseOver=\"hideToolTip()\" ><a href=\"javascript:\">"+patient+"</a></td>");
										}
										else
										{	
											sbr_patientList.append("<td nowrap class="+classValue+" >&nbsp;&nbsp;&nbsp;&nbsp;"+patient+"</a></td>");
										}
									}
									else if (search_in.equals("D"))
									{
									  	sbr_patientList.append("<td nowrap class='"+classValue+"'>"+patient+"</a></td>");
									}
									else if(func_act.equals("Patreg") ||func_act.equals("RPDRG") || func_act.equals("EMERG"))
									{
										sbr_patientList.append("<td nowrap class="+classValue+">"+patient+"</td>");
									}else
									{
										sbr_patientList.append("<td nowrap class="+classValue+" onClick=displayToolTip(\""+java.net.URLEncoder.encode(patient)+"\") onMouseOver=\"hideToolTip()\" ><a href=\"javascript:\">"+patient+"</a></td>");
									}
								}
								else
								{
									sbr_patientList.append("<td nowrap class="+classValue+" onClick=displayToolTip(\""+java.net.URLEncoder.encode(patient)+"\") onMouseOver=\"hideToolTip()\" ><a href=\"javascript:\">"+patient+"</a></td>");
								}
							}
							else
							{
								sbr_patientList.append("<td nowrap class="+classValue+" onClick=displayToolTip(\""+java.net.URLEncoder.encode(patient)+"\") onMouseOver=\"hideToolTip()\" ><a href=\"javascript:\">"+patient+"</a></td>");
							}
						}
					}else if( o == totalHeaders && photo_display){						
						boolean yes=false;
						if (photo != null)
						{
							for(int z=0;z<photo.length;z++) 
							{
								if(photo[z].equals(patient) ) 
								{
									yes=true;
									break;
								}
							}
						}
						if(yes)
						{
							sbr_tableBuilt.append("<td nowrap align='center' class='"+ classValue +"' onClick=modelPhoto(\""+java.net.URLEncoder.encode(patient)+"\")><a href=\"javascript:callDummy()\"><img src='../../eCommon/images/photo.gif'></a></td>");
						}
						else
						{
							sbr_tableBuilt.append("<td nowrap align='center' class='" + classValue + "'>&nbsp;</td>");
						}
					}else{							
						String mr_file_no = "";
						String mr_old_file_num = "";
						String mr_fac_name = "";
						if(enablemrnyn.equals("Y")){
							mrns= rs.getInt(colCount);

							mr_file_no = rs.getString("File_No")==null?"&nbsp;":rs.getString("File_No");

							if(file_no_place==0){
							}else{
								mr_old_file_num = rs.getString("Old_File_No")==null?"&nbsp;":rs.getString("Old_File_No");
							}
							
						}else{
							if(file_no_place==0){
							}else{
								mr_old_file_num = rs.getString("Old_File_No")==null?"&nbsp;":rs.getString("Old_File_No");
							}
						}
						String suspended=rs.getString("Suspend_Yn")==null ? "N" : rs.getString("Suspend_Yn");
						String deceased=rs.getString("Deceased_Yn")==null ? "N" : rs.getString("Deceased_Yn");
						String active=rs.getString("Active_Yn")==null ? "Y" : rs.getString("Active_Yn");
						String restricted=rs.getString("restrict_reinstate_yn")==null ? "N" : rs.getString("restrict_reinstate_yn");
						//Added by Ajay Hatwate for MMS-DM-CRF-0210.1
						String cls_val = "";
						if(deceased.equals("Y")){
							cls_val = "DECEASED";
						}else if(suspended.equals("Y")){
							cls_val = "SUSPENDED";
						}else if(active.equals("N")){
							cls_val = "INACTIVE";
						}else if(restricted.equals("Y")){
							cls_val = "RESTRICTED";
						}					
						if(o == 2 )  cls_val = cls_val; else cls_val = classValue;
						if ((deceased.equals("Y")) || (suspended.equals("Y")) || (active.equals("N")) || (restricted.equals("Y"))){
							if (o != mrn_place){
								if ((o != file_no_place)&&(o != facility_name_place)&&(o != res_area_place)&&(o != nationality_place)&&(o != pref_facility_place)){
									if (o==2){
										sbr_patientList.append("<td nowrap class='" + cls_val + "' align = '"+alignment+"'>" + "&nbsp;" + "</td>");
										if(curr_patient_class.equals("")){
											curr_patient_class="&nbsp;";
											sbr_patientList.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'>" + curr_patient_class + "</td>");
										}else{
											sbr_patientList.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'><a href='#' onclick=\"encounterDetails('"+enc_facility_id+"','"+curr_encounter_id+"','"+patient+"','"+curr_patient_class+"')\">" + curr_patient_class + "</a></td>");
										}
										//sbr_patientList.append("<td nowrap class='" + cls_val + "' align = '"+alignment+"'>" + " 123  " + "</td>");
									}
									if (othlang.equals("Y")){
										if (o==name_prefix_place || o==name_suffix_place || o==first_name_place || o==second_name_place || o==third_name_place || o==family_name_place || o==patient_name_place){
											String locClassValue = "";
										    if ( i%2 == 0 )	locClassValue ="QRYEVENOTHLANG" ;
										    else locClassValue = "QRYODDOTHLANG" ;
											temp=rs.getString(o);
											if(temp==null) temp="&nbsp;";
											if(!language_direction.equals("R") && !(rsmd.getColumnName(o)).equalsIgnoreCase("patient_name_loc_lang")){	
												sbr_tableBuilt.append("<td nowrap class='" + locClassValue + "' align = 'right'>" + temp + "</td>");
											}else{
												sbr_tableBuilt.append("<td nowrap class='" + locClassValue + "' dir='RTL'" + temp + "</td>");
											}											
										}else{
											temp=rs.getString(o);
											if(temp==null) temp="&nbsp;";											
											if(!language_direction.equals("R") && !(rsmd.getColumnName(o)).equalsIgnoreCase("patient_name_loc_lang")){	
												sbr_tableBuilt.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'>" + temp + "</td>");
											}else{
												sbr_tableBuilt.append("<td nowrap class='" + classValue + "' dir='RTL'>" + temp + "</td>");
											}											
										}
									}else if(o==reg_mode){
										temp=rs.getString(o);
										if(temp==null) temp="&nbsp;";
										if(temp.equals("Y")){
											temp=common_labels.getString("Common.emergency.label");	
										}else if(temp.equals("N")){		
											temp=common_labels.getString("Common.Normal.label");	
										}else{
											temp=mp_labels.getString("eMP.Rapid.label");	
										}
										sbr_tableBuilt.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'>" + temp + "</td>");
									}else if(o==gender){
										temp=rs.getString(o);
										if(temp==null) temp="&nbsp;";
										if(temp.equals("M")){
											temp=common_labels.getString("Common.male.label");	
										}else if(temp.equals("F")){		
											temp=common_labels.getString("Common.female.label");	
										}else if(temp.equals("U")){		
											temp=common_labels.getString("Common.unknown.label");	
										}
										sbr_tableBuilt.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'>" + temp + "</td>");
									}else if(o==date_of_birth_place){
										temp=rs.getString(o);
										if(temp!=null){
											temp=DateUtils.convertDate(temp,"DMY","en",locale);
										}else{
											temp="&nbsp;";
										}
										sbr_tableBuilt.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'>" + temp + "</td>");
									}else{
										temp=rs.getString(o);
										if(temp==null) temp="&nbsp;";										
										if(language_direction.equals("R")&&(rsmd.getColumnName(o)).equalsIgnoreCase("patient_name_loc_lang")){
											sbr_tableBuilt.append("<td nowrap class='" + classValue + "' dir='RTL'>" + temp + "</td>");
										}else{
											sbr_tableBuilt.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'>" + temp + "</td>");
										}
									}
								}else if ((o!=facility_name_place)&&(o != res_area_place)&&(o != nationality_place)&&(o != pref_facility_place)){
									if (mrns > 1){
										sbr_tableBuilt.append("<td nowrap class='" + cls_val + "' align = '"+alignment+"'>" + "&nbsp;" + "</td>");									
									}else{
										sbr_tableBuilt.append("<td nowrap class='" + cls_val + "' align = '"+alignment+"'>" + mr_old_file_num + "</td>");
									}
								}else if ((o != res_area_place)&&(o != nationality_place)&&(o != pref_facility_place)){
									sbr_tableBuilt.append("<td nowrap class='" + cls_val + "' align = '"+alignment+"'>" + mr_fac_name + "</td>");
								}else if ((o != res_area_place) &&(o != pref_facility_place)){
									String Nationality_Desc = rs.getString("Nationality_Desc");
									if (Nationality_Desc==null) Nationality_Desc="&nbsp;";
									sbr_tableBuilt.append("<td nowrap class='" + cls_val + "' align = '"+alignment+"'>" + Nationality_Desc + "</td>");
								}else if (o != pref_facility_place){
									String Res_Area_Desc = rs.getString("Res_Area_Desc");
									if (Res_Area_Desc==null) Res_Area_Desc="&nbsp;";
									sbr_tableBuilt.append("<td nowrap class='" + cls_val + "' align = '"+alignment+"'>" + Res_Area_Desc + "</td>");
								}else{
									String Pref_Fac_Name = rs.getString("Pref_Fac_Name");
									if (Pref_Fac_Name==null) Pref_Fac_Name="&nbsp;";
									sbr_tableBuilt.append("<td nowrap class='" + pfc + "' align = '"+alignment+"'>" + Pref_Fac_Name + "</td>");
								}
							}else{
								if (mrns < 2){
									sbr_tableBuilt.append("<td nowrap class='" + cls_val + "' align = '"+alignment+"'>" + mr_file_no + "</td>");
								}else{
									sbr_tableBuilt.append("<td nowrap class='" + cls_val + "' align = '"+alignment+"' onClick=showMRNS(\""+java.net.URLEncoder.encode(patient)+"\")>" + "<a href=\"javascript:callDummy()\">"+"Multiple MRNs"+"</a> 	"+ "</td>");
								}
							}
						}else{/*Not Deceased Not Suspended and Active patients */							
							if (o != mrn_place){							
								if ((o != file_no_place)&&(o != facility_name_place)&&(o != res_area_place)&&(o != nationality_place)&&(o != pref_facility_place)){
									if (o==2){
										sbr_patientList.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'>" + "&nbsp;" + "</td>");
										if(curr_patient_class.equals("")){
											curr_patient_class="&nbsp;";
											sbr_patientList.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'>" + curr_patient_class + "</td>");
										}else{
											sbr_patientList.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'><a href='#' onclick=\"encounterDetails('"+enc_facility_id+"','"+curr_encounter_id+"','"+patient+"','"+curr_patient_class+"')\">" + curr_patient_class + "</a></td>");
										}
									}
									if (othlang.equals("Y")){
										if (o==name_prefix_place || o==name_suffix_place || o==first_name_place || o==second_name_place || o==third_name_place || o==family_name_place || o==patient_name_place){
											String locClassValue = "";
											if ( i%2 == 0 )	locClassValue ="QRYEVENOTHLANG" ;
											else locClassValue = "QRYODDOTHLANG" ;
											temp=rs.getString(o);
											if(temp==null) temp="&nbsp;";

											if(!language_direction.equals("R") && !(rsmd.getColumnName(o)).equalsIgnoreCase("patient_name_loc_lang")){
											sbr_tableBuilt.append("<td nowrap class='" + locClassValue + "' align = 'right'>" + temp + "</td>");
											}else{
												sbr_tableBuilt.append("<td nowrap class='" + locClassValue + "' dir='RTL'>" + temp + "</td>");
											}											
										}else{
											temp=rs.getString(o);
											if(temp==null) temp="&nbsp;";
											
											if(!language_direction.equals("R") && !(rsmd.getColumnName(o)).equalsIgnoreCase("patient_name_loc_lang")){
												sbr_tableBuilt.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'>" + temp + "</td>");
											}else{
												sbr_tableBuilt.append("<td nowrap class='" + classValue + "' dir='RTL'>" + temp + "</td>");
											}											
										}
									}else if(o==date_of_birth_place){
										temp=rs.getString(o);
										if(temp!=null){
											temp=DateUtils.convertDate(temp,"DMY","en",locale);

										}else{
											temp="&nbsp;";
										}
										sbr_tableBuilt.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'>" + temp + "</td>");
									}
									else if(o==reg_mode){
										temp=rs.getString(o);
										if(temp==null) temp="";
										if(temp.equals("Y")){
										temp=common_labels.getString("Common.emergency.label");	
									}else if(temp.equals("N")){		
										temp=common_labels.getString("Common.Normal.label");	
									}else{
										temp=mp_labels.getString("eMP.Rapid.label");	
									}
										sbr_tableBuilt.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'>" + temp + "</td>");
									}
									else if(o==gender){
										temp=rs.getString(o);
										if(temp==null) temp="";
										if(temp.equals("M")){
											temp=common_labels.getString("Common.male.label");	
										}else if(temp.equals("F")){		
											temp=common_labels.getString("Common.female.label");	
										}else if(temp.equals("U")){		
											temp=common_labels.getString("Common.unknown.label");	
										}
										sbr_tableBuilt.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'>" + temp + "</td>");
									}else{										
										temp=rs.getString(o);
										if(temp==null) temp="&nbsp;";
										if(language_direction.equals("R") && (rsmd.getColumnName(o)).equalsIgnoreCase("patient_name_loc_lang")){
											sbr_tableBuilt.append("<td nowrap class='" + classValue + "' dir='RTL'>" + temp + "</td>");
										}else{
											sbr_tableBuilt.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'>" + temp + "</td>");
										}
									}
								}
								else if ((o!=facility_name_place)&&(o != res_area_place)&&(o != nationality_place)&&(o != pref_facility_place))
								{
									if (mrns > 1)
									{
										sbr_tableBuilt.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'>" + "&nbsp;" + "</td>");
									}
									else
									{
										sbr_tableBuilt.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'>" + mr_old_file_num + "</td>");
									}
								}
								else if ((o != res_area_place)&&(o != nationality_place)&&(o != pref_facility_place))
								{
									sbr_tableBuilt.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'>" + mr_fac_name + "</td>");
								}
								else if ((o != res_area_place)&&(o != pref_facility_place))
								{
									String Nationality_Desc = rs.getString("Nationality_Desc");
									if(Nationality_Desc==null) Nationality_Desc="&nbsp;";
									sbr_tableBuilt.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'>" + Nationality_Desc + "</td>");
								}
								else if (o != pref_facility_place)
								{
									String Res_Area_Desc = rs.getString("Res_Area_Desc");
									if (Res_Area_Desc==null) Res_Area_Desc="&nbsp;";
									sbr_tableBuilt.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'>" + Res_Area_Desc + "</td>");
								}else{
									String Pref_Fac_Name = rs.getString("Pref_Fac_Name");
									if (Pref_Fac_Name==null) Pref_Fac_Name="&nbsp;";
									sbr_tableBuilt.append("<td nowrap class='" + pfc + "' align = '"+alignment+"'>" + Pref_Fac_Name + "</td>");
								}
							}else{
								if (mrns < 2){
								sbr_tableBuilt.append("<td nowrap class='" + classValue + "' align = '"+alignment+"'>" + mr_file_no + "</td>");
							}else{
								sbr_tableBuilt.append("<td nowrap class='" + classValue + "' align = '"+alignment+"' onClick=showMRNS(\""+java.net.URLEncoder.encode(patient)+"\")>" + "<a href=\"javascript:callDummy()\">"+"Multiple MRNs"+"</a> "+ "</td>");
							}
						}
					}
				}
				o++;
			}
			sbr_tableBuilt.append("</tr>");
			sbr_patientList.append("</tr>");
			i++;							
		}
		sbr_tableBuilt.append("</table>");
		sbr_patientList.append("</table>");
		
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	finally
	{
		try
		{
			if(rs != null)rs.close();
			if (stmt != null)stmt.close();
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		if (con != null) ConnectionManager.returnConnection(con,props);			
	}


	java.util.HashMap searchtab = new java.util.HashMap(); 
	searchtab.put("PAT_ID",this.sbr_patientList.toString());
	searchtab.put("PAT_DTLS",this.sbr_tableBuilt.toString());
	return searchtab;
}
} 
