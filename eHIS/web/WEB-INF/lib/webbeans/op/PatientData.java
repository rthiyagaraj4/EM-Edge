/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package webbeans.op;

 import java.sql.*;
 import java.util.*;
 import webbeans.eCommon.*;

public class PatientData
{
   
	static String facility_id=""; 
	HashMap interface_values  =  new HashMap();
	public void setFacility_id(String fac_id) 
	{
		facility_id=fac_id;
	}

	public void setInterface_values(HashMap int_values) 
	{
		interface_values=int_values;
	}

	public HashMap getInterface_values() 
	{
		return(interface_values);
	}

    public PatientData(){}
    public static String CheckStatus(Connection con,String patientid)
	{
		Statement stmt=null;
        ResultSet rs=null;
		String bl_interface_yn ="";
		String bl_install_yn = "";
		String blacklisted_yn="";      
		String deceasedyn="";
        String generalalert="";
        String activeyn="";
        String suspendyn="";
		String locale="";
		String valid_patient_id="";
		//Class.forName( ecis_jdbc_driver ) ;
		try
		{
           Connection conn=con;			
			
			stmt = conn.createStatement();

			rs = stmt.executeQuery("select general_alert, active_yn, suspend_yn, deceased_yn, (case when (SELECT nvl(OPERATIONAL_YN,'N') FROM sm_modules_facility WHERE MODULE_ID = 'BL' AND FACILITY_ID = '"+facility_id+"') = 'Y' then (select blcommon.bl_patient_blacklisted_yn('"+patientid+"') from dual) else 'N' end) blacklisted from mp_patient where patient_id = '"+patientid+"'");	
					
            if( rs != null  && rs.next())  
			{
				deceasedyn=rs.getString("deceased_yn")==null?"N":rs.getString("deceased_yn");
				generalalert=(rs.getString("general_alert")==null)?"":rs.getString("general_alert");
				activeyn=rs.getString("active_yn")==null?"Y":rs.getString("active_yn");
                suspendyn=rs.getString("suspend_yn")==null?"N":rs.getString("suspend_yn");
				blacklisted_yn = rs.getString("blacklisted")==null?"N":rs.getString("blacklisted");		
								
				if(deceasedyn.equals("Y")) {
                    return "DECEASED";
				} else if(suspendyn.equals("Y")) {
					return "SUSPENDED";
                } else if(activeyn.equals("N")) {
					return "INACTIVE";
				} else if(!generalalert.equals("")) {
					return generalalert;
                } else if(blacklisted_yn.equals("Y")) {
					return "BLACKLISTED_PATIENT";
				}				
				
			}   /*-If no rows returned from mp_patient -*/ else {

				if (rs!=null)rs.close();

				rs = stmt.executeQuery("select valid_patient_id from dr_mp_patient where duplicate_patient_id = '"+patientid+"'");

				if( rs != null  && rs.next()) {
					valid_patient_id = rs.getString("valid_patient_id")==null?"":rs.getString("valid_patient_id");

					if(!valid_patient_id.equals("")) {
						String retval = "PATIENT_MERGED_VALID"+"$"+valid_patient_id;
						return retval;	
					} else {
						return "INVALID_PATIENT";	
					}
				} else {
					return "INVALID_PATIENT";	
				} 								
			}
		}  catch(SQLException e) {
			e.printStackTrace();
			
			return "INVALID_PATIENT";
        }
        finally
        {
            try
            {
                if (stmt!=null)stmt.close();
                if (rs!=null)rs.close();
            }
            catch(Exception e)
            {
				e.printStackTrace();
			}
        }
        return "";
	}

	public static String CheckAlternateId(Connection con,String patientid,String locale){

            /*java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
            String sysDate = dateFormat.format( new java.util.Date() ) ;
            Date sDate = Date.valueOf( sysDate ) ;*/

            PreparedStatement pstmt=null;
            ResultSet rs=null;

			String Altid1expdate = "";
			String Altid1no = "";
            String gracePeriod="";
            String alt_id1_type="";
            String alt_id1_exp_warn_yn="";
            int alt_id1_exp_grace_days=0;
            java.util.Date alt_id1_exp_date;
            java.util.Date alt_id1_grace;
			String alt_id1_adv_alert_reqd_yn ="";
			int alt_id1_adv_alert_days = 0 ;
			int alt_id1_diff_days = 0 ;

            String alt_id2_type="";
            String alt_id2_exp_warn_yn="";
            int alt_id2_exp_grace_days=0;
            java.util.Date alt_id2_exp_date;
            java.util.Date alt_id2_grace;
			String alt_id2_adv_alert_reqd_yn ="";
			int alt_id2_adv_alert_days = 0 ;
			int alt_id2_diff_days = 0 ;

            String alt_id3_type="";
            String alt_id3_exp_warn_yn="";
            int alt_id3_exp_grace_days=0;
            java.util.Date alt_id3_exp_date;
            java.util.Date alt_id3_grace;
			String alt_id3_adv_alert_reqd_yn ="";
			int alt_id3_adv_alert_days = 0 ;
			int alt_id3_diff_days = 0 ;

            String alt_id4_type="";
            String alt_id4_exp_warn_yn="";
            int alt_id4_exp_grace_days=0;
            java.util.Date alt_id4_exp_date;
            java.util.Date alt_id4_grace;
			String alt_id4_adv_alert_reqd_yn ="";
			int alt_id4_adv_alert_days = 0 ;
			int alt_id4_diff_days = 0 ;
			int alt_diff_days = 0 ;
			String ALT_ID1_EXP_DATE_ACCEPT_YN="";
			String alt_id1_desc="";
			String alt_id2_desc="";
			String alt_id3_desc="";
			String alt_id4_desc="";

            //Class.forName( ecis_jdbc_driver ) ;

    try{
           Connection conn=con;		
            
			 			
			pstmt = conn.prepareStatement("SELECT   TRUNC(SYSDATE) systemdate  ,NVL(TRUNC(mp_patient.alt_id1_exp_date),TRUNC(SYSDATE))+NVL(mp_param.alt_id1_exp_grace_days,0) alt_id1_grace   ,NVL(mp_param.alt_id1_adv_alert_reqd_yn,'N') alt_id1_adv_alert_reqd_yn ,NVL(mp_param.alt_id1_adv_alert_days,0) alt_id1_adv_alert_days  ,NVL(TRUNC(mp_patient.alt_id2_exp_date),TRUNC(SYSDATE))+NVL(mp_param.alt_id2_exp_grace_days,0) alt_id2_grace  ,NVL(mp_param.alt_id2_adv_alert_reqd_yn,'N') alt_id2_adv_alert_reqd_yn  ,NVL(mp_param.alt_id2_adv_alert_days,0) alt_id2_adv_alert_days  ,NVL(TRUNC(mp_patient.alt_id3_exp_date),TRUNC(SYSDATE))+NVL(mp_param.alt_id3_exp_grace_days,0) alt_id3_grace  ,NVL(mp_param.alt_id3_adv_alert_reqd_yn,'N') alt_id3_adv_alert_reqd_yn  ,NVL(mp_param.alt_id3_adv_alert_days,0) alt_id3_adv_alert_days  ,NVL(TRUNC(mp_patient.alt_id4_exp_date),TRUNC(SYSDATE))+NVL(mp_param.alt_id4_exp_grace_days,0) alt_id4_grace  ,NVL(mp_param.alt_id4_adv_alert_reqd_yn,'N') alt_id4_adv_alert_reqd_yn  ,NVL(mp_param.alt_id4_adv_alert_days,0) alt_id4_adv_alert_days  ,mp_param.alt_id1_type , NVL(mp_param.alt_id1_exp_warn_yn,'N') alt_id1_exp_warn_yn , mp_param.alt_id1_exp_grace_days  , NVL(mp_patient.alt_id1_exp_date,'') alt_id1_exp_date  , mp_param.alt_id2_type  , NVL(mp_param.alt_id2_exp_warn_yn,'N') alt_id2_exp_warn_yn  ,mp_param.alt_id2_exp_grace_days  ,NVL(mp_patient.alt_id2_exp_date,'') alt_id2_exp_date  , mp_param.alt_id3_type  , NVL(mp_param.alt_id3_exp_warn_yn,'N') alt_id3_exp_warn_yn  , mp_param.alt_id3_exp_grace_days  ,NVL(mp_patient.alt_id3_exp_date,'') alt_id3_exp_date  , mp_param.alt_id4_type  ,NVL(mp_param.alt_id4_exp_warn_yn,'N') alt_id4_exp_warn_yn  , mp_param.alt_id4_exp_grace_days  , NVL(mp_patient.alt_id4_exp_date,'') alt_id4_exp_date  ,NVL(ABS(TRUNC(mp_patient.ALT_ID1_EXP_DATE)-TRUNC(SYSDATE)),0) alt_id1_diff_days,NVL(ABS(TRUNC(mp_patient.ALT_ID2_EXP_DATE)-TRUNC(SYSDATE)),0) alt_id2_diff_days  ,NVL(ABS(TRUNC(mp_patient.ALT_ID3_EXP_DATE)-TRUNC(SYSDATE)),0)alt_id3_diff_days,NVL(ABS(TRUNC(mp_patient.ALT_ID4_EXP_DATE)-TRUNC(SYSDATE)),0) alt_id4_diff_days  ,TRUNC(SYSDATE)-TRUNC(mp_patient.regn_date) alt_diff_days  , mp_patient.alt_id1_exp_date Altid1expdate  ,mp_patient.alt_id1_no Altid1no  ,mp_get_desc.MP_ALTERNATE_ID_TYPE(mp_param.ALT_ID1_TYPE,'"+locale+"',1) alt_id1_desc ,mp_get_desc.MP_ALTERNATE_ID_TYPE(mp_param.ALT_ID2_TYPE,'"+locale+"',1) alt_id2_desc,mp_get_desc.MP_ALTERNATE_ID_TYPE(mp_param.ALT_ID3_TYPE,'"+locale+"',1) alt_id3_desc,mp_get_desc.MP_ALTERNATE_ID_TYPE(mp_param.ALT_ID4_TYPE,'"+locale+"',1) alt_id4_desc FROM  mp_param   ,mp_patient   WHERE mp_patient.patient_id=?" ) ;
            
			
			//"select trunc(sysdate) systemdate,nvl(trunc(mp_patient.alt_id1_exp_date),trunc(sysdate))+nvl(mp_param.alt_id1_exp_grace_days,0) alt_id1_grace ,nvl(mp_param.alt_id1_adv_alert_reqd_yn,'N') alt_id1_adv_alert_reqd_yn,nvl(mp_param.alt_id1_adv_alert_days,0)  alt_id1_adv_alert_days,nvl(trunc(mp_patient.alt_id2_exp_date),trunc(sysdate))+nvl(mp_param.alt_id2_exp_grace_days,0) alt_id2_grace,nvl(mp_param.alt_id2_adv_alert_reqd_yn,'N') alt_id2_adv_alert_reqd_yn,nvl(mp_param.alt_id2_adv_alert_days,0)  alt_id2_adv_alert_days,nvl(trunc(mp_patient.alt_id3_exp_date),trunc(sysdate))+nvl(mp_param.alt_id3_exp_grace_days,0) alt_id3_grace,nvl(mp_param.alt_id3_adv_alert_reqd_yn,'N') alt_id3_adv_alert_reqd_yn,nvl(mp_param.alt_id3_adv_alert_days,0)  alt_id3_adv_alert_days,nvl(trunc(mp_patient.alt_id4_exp_date),trunc(sysdate))+nvl(mp_param.alt_id4_exp_grace_days,0) alt_id4_grace,nvl(mp_param.alt_id4_adv_alert_reqd_yn,'N') alt_id4_adv_alert_reqd_yn,nvl(mp_param.alt_id4_adv_alert_days,0)  alt_id4_adv_alert_days,mp_param.alt_id1_type, nvl(mp_param.alt_id1_exp_warn_yn,'N') alt_id1_exp_warn_yn, mp_param.alt_id1_exp_grace_days, nvl(mp_patient.alt_id1_exp_date,'') alt_id1_exp_date,  mp_param.alt_id2_type, nvl(mp_param.alt_id2_exp_warn_yn,'N') alt_id2_exp_warn_yn,mp_param.alt_id2_exp_grace_days,nvl(mp_patient.alt_id2_exp_date,'') alt_id2_exp_date, mp_param.alt_id3_type, nvl(mp_param.alt_id3_exp_warn_yn,'N') alt_id3_exp_warn_yn, mp_param.alt_id3_exp_grace_days,nvl(mp_patient.alt_id3_exp_date,'') alt_id3_exp_date, mp_param.alt_id4_type,nvl(mp_param.alt_id4_exp_warn_yn,'N') alt_id4_exp_warn_yn, mp_param.alt_id4_exp_grace_days, nvl(mp_patient.alt_id4_exp_date,'') alt_id4_exp_date,nvl(abs(trunc(mp_patient.ALT_ID1_EXP_DATE)-TRUNC(sysdate)),0) alt_id1_diff_days,nvl(abs(trunc(mp_patient.ALT_ID2_EXP_DATE)-TRUNC(sysdate)),0) alt_id2_diff_days,nvl(abs(trunc(mp_patient.ALT_ID3_EXP_DATE)-TRUNC(sysdate)),0) alt_id3_diff_days,nvl(abs(trunc(mp_patient.ALT_ID4_EXP_DATE)-TRUNC(sysdate)),0) alt_id4_diff_days,trunc(sysdate)-TRUNC(mp_patient.regn_date) alt_diff_days,			mp_patient.alt_id1_exp_date Altid1expdate,mp_patient.alt_id1_no Altid1no,alt1.long_desc alt_id1_desc,alt2.long_DESC alt_id2_desc,alt3.long_DESC alt_id3_desc,alt4.long_DESC alt_id4_desc from mp_param,mp_patient,MP_ALTERNATE_ID_TYPE ALT1,MP_ALTERNATE_ID_TYPE ALT2, MP_ALTERNATE_ID_TYPE ALT3, MP_ALTERNATE_ID_TYPE ALT4 where mp_patient.patient_id=? AND mp_param.alt_id1_type=alt1.ALT_ID_TYPE(+) and mp_param.alt_id2_type=alt2.ALT_ID_TYPE(+) AND mp_param.alt_id3_type=alt3.ALT_ID_TYPE(+) AND mp_param.alt_id4_type=alt4.ALT_ID_TYPE(+)"
			
			pstmt.setString(1,patientid);
            rs = pstmt.executeQuery() ;

            //Date sDate=sysDate;
            if( rs != null )
            {
                    while( rs.next() )
                    {
                        java.util.Date sysDate=rs.getDate("systemdate");

                        alt_id1_type=rs.getString("alt_id1_type");
                        alt_id1_exp_warn_yn=rs.getString("alt_id1_exp_warn_yn");
                        alt_id1_exp_grace_days=rs.getInt("alt_id1_exp_grace_days");
                        alt_id1_exp_date=rs.getDate("alt_id1_exp_date");
                        alt_id1_grace =rs.getDate("alt_id1_grace");
						alt_id1_adv_alert_reqd_yn =rs.getString("alt_id1_adv_alert_reqd_yn");
						alt_id1_adv_alert_days	  = rs.getInt("alt_id1_adv_alert_days");
						alt_id1_diff_days	      = rs.getInt("alt_id1_diff_days");
						alt_diff_days	          = rs.getInt("alt_diff_days");

                        alt_id2_type=rs.getString("alt_id2_type");
                        alt_id2_exp_warn_yn=rs.getString("alt_id2_exp_warn_yn");
                        alt_id2_exp_grace_days=rs.getInt("alt_id2_exp_grace_days");
                        alt_id2_exp_date=rs.getDate("alt_id2_exp_date");
                        alt_id2_grace =rs.getDate("alt_id2_grace");
						alt_id2_adv_alert_reqd_yn =rs.getString("alt_id2_adv_alert_reqd_yn");
						alt_id2_adv_alert_days	  = rs.getInt("alt_id2_adv_alert_days");
						alt_id2_diff_days	      = rs.getInt("alt_id2_diff_days");

                        alt_id3_type=rs.getString("alt_id3_type");
                        alt_id3_exp_warn_yn=rs.getString("alt_id3_exp_warn_yn");
                        alt_id3_exp_grace_days=rs.getInt("alt_id3_exp_grace_days");
                        alt_id3_exp_date=rs.getDate("alt_id3_exp_date");
                        alt_id3_grace =rs.getDate("alt_id3_grace");
						alt_id3_adv_alert_reqd_yn =rs.getString("alt_id3_adv_alert_reqd_yn");
						alt_id3_adv_alert_days	  = rs.getInt("alt_id3_adv_alert_days");
						alt_id3_diff_days	      = rs.getInt("alt_id3_diff_days");

                        alt_id4_type=rs.getString("alt_id4_type");
                        alt_id4_exp_warn_yn=rs.getString("alt_id4_exp_warn_yn");
                        alt_id4_exp_grace_days=rs.getInt("alt_id4_exp_grace_days");
                        alt_id4_exp_date=rs.getDate("alt_id4_exp_date");
                        alt_id4_grace =rs.getDate("alt_id4_grace");
						alt_id4_adv_alert_reqd_yn =rs.getString("alt_id4_adv_alert_reqd_yn");
						alt_id4_adv_alert_days	  = rs.getInt("alt_id4_adv_alert_days");
						alt_id4_diff_days	      = rs.getInt("alt_id4_diff_days");

						Altid1expdate = rs.getString("Altid1expdate");
						Altid1no = rs.getString("Altid1no");
						alt_id1_desc =rs.getString("alt_id1_desc");
						if(alt_id1_desc == null) alt_id1_desc="";
						alt_id2_desc =rs.getString("alt_id2_desc");
						if(alt_id2_desc == null) alt_id2_desc="";
						alt_id3_desc =rs.getString("alt_id3_desc");
						if(alt_id3_desc == null) alt_id3_desc="";
						alt_id4_desc =rs.getString("alt_id4_desc");
						if(alt_id4_desc == null) alt_id4_desc="";

						//ALT_ID1_EXP_DATE_ACCEPT_YN=rs.getString("ALT_ID1_EXP_DATE_ACCEPT_YN");

						/*if(Altid1no == null || Altid1no.equals("null"))
							return "ALT_ID1_NO_IS_NULL";
						if(ALT_ID1_EXP_DATE_ACCEPT_YN.equals("Y")){
						if(Altid1expdate == null || Altid1expdate.equals("null"))
							return "ALT_ID1_DATE_IS_NULL";
						}*/
						
						/*
							This function return alternated id messages. This message was appended with 2 flags. 
							FIRST:
								WARNING message with (Ok/Cancel) --- W.
								CANCEL message		---- C (WARN and NOT PROCEED further TRANSACTION).
								                    ---- L (WARN and Continue).
							SECOND:

								1 --- Alternate id1
								2 --- Alternate id2
								3 --- Alternate id3
								4 --- Alternate id4

						   4 types of messages/Conditions  Return:
						   ---------------------------------------
							1)  Alternate ID expired With Grace Days.
							2)  Alternate ID expired But with in the Grace period.
							3)  Alternate ID expired But Grace Days are not Associated.
							4)  Alternate ID will expire TODAY / Specified Days.


						*/					

                        if(alt_id1_type!=null && alt_id1_exp_warn_yn.equals("Y"))
                        {
							if(alt_id1_exp_date !=null)
							{
                            if(alt_id1_exp_date.before(sysDate))
                            {
							  if(alt_id1_exp_grace_days != 0)
								{
									if(alt_id1_grace.before(sysDate))
									{java.util.Hashtable message = MessageManager.getMessage(
							locale, "ALT_ID_EXPIRED", "MP");
										//java.util.Hashtable message = MessageManager.getMessage(conn,"ALT_ID_EXPIRED");
									    String msg = ((String) message.get("message"));
										String reqmsg=replaceFunc(msg,alt_id1_desc,"N");
										
										reqmsg=reqmsg.substring(0,reqmsg.length());
										
										reqmsg="C"+reqmsg;		
										
										return reqmsg;       // Error Condition.
									}
									else
									{
		                               // gracePeriod+="ALT_ID1_IN_GRACE"; // Give alert as  alternate id with in the grace period and continue.
                                //gracePeriod+="Alternate ID1 is in Grace period"+ "<br>";
										java.util.Hashtable message = MessageManager.getMessage(
							locale, "ALT_ID_EXP_WITH_GRACE", "MP");
										//java.util.Hashtable message = MessageManager.getMessage(conn,"ALT_ID_EXP_WITH_GRACE");
									    String msg = ((String) message.get("message"));
										String reqmsg=replaceFunc(msg,alt_id1_desc,"N");
										reqmsg=reqmsg.substring(0,reqmsg.length());
										reqmsg="L"+"1"+reqmsg;										
										return reqmsg;
									}
								}else
								{
									//return "ALT_ID1_WARN";  // Warnig msg 
									java.util.Hashtable message = MessageManager.getMessage(
							locale, "ALT_ID_EXPIRED", "MP");
								//	java.util.Hashtable message = MessageManager.getMessage(conn,"ALT_ID_EXPIRED");
									String msg = ((String) message.get("message"));
									String reqmsg=replaceFunc(msg,alt_id1_desc,"N");
									reqmsg=reqmsg.substring(0,reqmsg.length());
									reqmsg="W"+"1"+reqmsg;
									return reqmsg;
								}
                            }
							}
                        }
						
						if(alt_id2_type!=null && alt_id2_exp_warn_yn.equals("Y"))
                        {
							if(alt_id2_exp_date !=null)
							{
                            if(alt_id2_exp_date.before(sysDate))
                            {
							  if(alt_id2_exp_grace_days != 0)
							  {
								 if(alt_id2_grace.before(sysDate))
									{
										java.util.Hashtable message = MessageManager.getMessage(
							locale, "ALT_ID_EXPIRED", "MP");
										//java.util.Hashtable message = MessageManager.getMessage(conn,"ALT_ID_EXPIRED");
									    String msg = ((String) message.get("message"));										
										String reqmsg=replaceFunc(msg,alt_id2_desc,"N");
										reqmsg=reqmsg.substring(0,reqmsg.length());
										reqmsg="C"+reqmsg;										
										return reqmsg;       // Error Condition.
									}
	                             else
								  {
		                           // gracePeriod+="|ALT_ID2_IN_GRACE";
                                //gracePeriod+="Alternate ID2 is in Grace period"+ "<br>";
										java.util.Hashtable message = MessageManager.getMessage(
							locale, "ALT_ID_EXP_WITH_GRACE", "MP");
										//java.util.Hashtable message = MessageManager.getMessage(conn,"ALT_ID_EXP_WITH_GRACE");
									    String msg = ((String) message.get("message"));
										String reqmsg=replaceFunc(msg,alt_id2_desc,"N");
										reqmsg=reqmsg.substring(0,reqmsg.length());
										reqmsg="L"+"2"+reqmsg;										
										return reqmsg;
								  }
							  }else
							  {
									java.util.Hashtable message = MessageManager.getMessage(
							locale, "ALT_ID_EXPIRED", "MP");
									//java.util.Hashtable message = MessageManager.getMessage(conn,"ALT_ID_EXPIRED");
									String msg = ((String) message.get("message"));
									String reqmsg=replaceFunc(msg,alt_id2_desc,"N");
									reqmsg=reqmsg.substring(0,reqmsg.length());
									reqmsg="W"+"2"+reqmsg;
									return reqmsg;
							  }
                            }
						  }
                        }
						
						if(alt_id3_type!=null && alt_id3_exp_warn_yn.equals("Y"))
                        {
							if(alt_id3_exp_date !=null)
							{
                            if(alt_id3_exp_date.before(sysDate))
                            {
							  if(alt_id3_exp_grace_days != 0)
							  {
                               if(alt_id3_grace.before(sysDate))
                               {       java.util.Hashtable message = MessageManager.getMessage(
							locale, "ALT_ID_EXPIRED", "MP");
									//	java.util.Hashtable message = MessageManager.getMessage(conn,"ALT_ID_EXPIRED");
									    String msg = ((String) message.get("message"));										
										String reqmsg=replaceFunc(msg,alt_id3_desc,"N");
										reqmsg=reqmsg.substring(0,reqmsg.length());
										reqmsg="C"+reqmsg;										
										return reqmsg;       // Error Condition.
								}
                               else
								  {
                                //gracePeriod+="|ALT_ID3_IN_GRACE";
                                //gracePeriod+="Alternate ID3 is in Grace period"+"<br>";
										 java.util.Hashtable message = MessageManager.getMessage(
							locale, "ALT_ID_EXP_WITH_GRACE", "MP");
										//java.util.Hashtable message = MessageManager.getMessage(conn,"ALT_ID_EXP_WITH_GRACE");
									    String msg = ((String) message.get("message"));
										String reqmsg=replaceFunc(msg,alt_id3_desc,"N");
										reqmsg=reqmsg.substring(0,reqmsg.length());
										reqmsg="L"+"3"+reqmsg;										
										return reqmsg;
								  }
							  }else
							  {    java.util.Hashtable message = MessageManager.getMessage(
							locale, "ALT_ID_EXPIRED", "MP");
									//java.util.Hashtable message = MessageManager.getMessage(conn,"ALT_ID_EXPIRED");
									String msg = ((String) message.get("message"));
									String reqmsg=replaceFunc(msg,alt_id3_desc,"N");
									reqmsg=reqmsg.substring(0,reqmsg.length());
									reqmsg="W"+"3"+reqmsg;
									return reqmsg;
							  }
                            }
                        }
						}
						
						if(alt_id4_type!=null && alt_id4_exp_warn_yn.equals("Y"))
                        {
							if(alt_id4_exp_date !=null)
							{
                            if(alt_id4_exp_date.before(sysDate))
                            {
							  if(alt_id4_exp_grace_days != 0)
							  {
                               if(alt_id4_grace.before(sysDate))
                               {     java.util.Hashtable message = MessageManager.getMessage(
							locale, "ALT_ID_EXPIRED", "MP");
								//		java.util.Hashtable message = MessageManager.getMessage(conn,"ALT_ID_EXPIRED");
									    String msg = ((String) message.get("message"));										
										String reqmsg=replaceFunc(msg,alt_id4_desc,"N");
										reqmsg=reqmsg.substring(0,reqmsg.length());
										reqmsg="C"+reqmsg;										
										return reqmsg;       // Error Condition.
								}
                               else
								  {
	                            //   gracePeriod+="|ALT_ID4_IN_GRACE";
                                //gracePeriod+="Alternate ID4 is in Grace period"+ "<br>";
								java.util.Hashtable message = MessageManager.getMessage(
							locale, "ALT_ID_EXP_WITH_GRACE", "MP");
								//java.util.Hashtable message = MessageManager.getMessage(conn,"ALT_ID_EXP_WITH_GRACE");
									    String msg = ((String) message.get("message"));
										String reqmsg=replaceFunc(msg,alt_id4_desc,"N");
										reqmsg=reqmsg.substring(0,reqmsg.length());
										reqmsg="L"+"4"+reqmsg;										
										return reqmsg;
								  }
							  }else
							  {	java.util.Hashtable message = MessageManager.getMessage(
							locale, "ALT_ID_EXPIRED", "MP");
								  //java.util.Hashtable message = MessageManager.getMessage(conn,"ALT_ID_EXPIRED");
									String msg = ((String) message.get("message"));
									String reqmsg=replaceFunc(msg,alt_id4_desc,"N");
									reqmsg=reqmsg.substring(0,reqmsg.length());
									reqmsg="W"+"4"+reqmsg;
									return reqmsg;
							  }
                            }
                        }
						}
						
						if(alt_id1_adv_alert_reqd_yn.equals("Y"))
						 {								
							if(alt_id1_exp_date != null)
							{
								if(!(alt_id1_exp_date.before(sysDate)))
								{
								//commented by raj on 10/3/2003
								//if (alt_id1_diff_days > 0) 
								if (alt_id1_diff_days >= 0) 
									{
								
									if ( alt_id1_diff_days <= alt_id1_adv_alert_days)
										{										

										/* commented by Raj on 10/3/2003
										because The message card will expire within 
										was showing a negative number */
		                               //gracePeriod+="ALT_ID1_EXP_WITHIN"+"$"+(alt_id1_adv_alert_days-alt_diff_days)+"$";
									 //  ALT_ID_EXP_WITHIN
									//	gracePeriod+="ALT_ID1_EXP_WITHIN"+"$"+(alt_id1_diff_days)+"$";
                                         java.util.Hashtable message = MessageManager.getMessage(
							locale, "ALT_ID_EXP_WITHIN", "MP");
									//   java.util.Hashtable message = MessageManager.getMessage(conn,"ALT_ID_EXP_WITHIN");
									    String msg = ((String) message.get("message"));
										String reqmsg=replaceFunc(msg,alt_id1_desc,"N");
										reqmsg=reqmsg.substring(0,reqmsg.length());
										String repmsg="";
										if(alt_id1_diff_days != 0)
											reqmsg=reqmsg+" "+alt_id1_diff_days+""+" Days";
										else
											reqmsg=replaceFunc(reqmsg,repmsg,"Y")+""+" Today";

										reqmsg="L"+"1"+reqmsg;										
										return reqmsg;


										}
									}
								}
							}
						 }
						 
						 if(alt_id2_adv_alert_reqd_yn.equals("Y"))
						 {
							if(alt_id2_exp_date != null)
							{
								if(!(alt_id2_exp_date.before(sysDate)))
								{  //commented by raj on 10/3/2003
									//if (alt_id2_diff_days > 0) 
									if (alt_id2_diff_days >= 0) 
									{
										if ( alt_id2_diff_days <= alt_id2_adv_alert_days)
										{
										/* commented by Raj on 10/3/2003
										because The message card will expire within 
										was showing a negative number */
		                               //gracePeriod+="|ALT_ID2_EXP_WITHIN"+"$"+(alt_id2_adv_alert_days-alt_diff_days)+"$";
										//gracePeriod+="ALT_ID2_EXP_WITHIN"+"$"+(alt_id2_diff_days)+"$";
										   java.util.Hashtable message = MessageManager.getMessage(
							locale, "ALT_ID_EXP_WITHIN", "MP");
									//	java.util.Hashtable message = MessageManager.getMessage(conn,"ALT_ID_EXP_WITHIN");
									    String msg = ((String) message.get("message"));
										String reqmsg=replaceFunc(msg,alt_id2_desc,"N");
										reqmsg=reqmsg.substring(0,reqmsg.length());
										String repmsg="";
										if(alt_id2_diff_days != 0)
											reqmsg=reqmsg+" "+alt_id2_diff_days+""+" Days";
										else
											reqmsg=replaceFunc(reqmsg,repmsg,"Y")+""+" Today";

										reqmsg="L"+"2"+reqmsg;
										
										return reqmsg;
										}
									}
								}
							}
						 }
						 
						 if(alt_id3_adv_alert_reqd_yn.equals("Y"))
						 {
							if(alt_id3_exp_date != null)
							{
								if(!(alt_id3_exp_date.before(sysDate)))
								{ 	//commented by raj on 9/22/2003
									//if (alt_id3_diff_days > 0) 
									if (alt_id3_diff_days >= 0) 
									{
										if ( alt_id3_diff_days <= alt_id3_adv_alert_days)
										{
										/* commented by Raj on 10/3/2003
										because The message card will expire within 
										was showing a negative number */
		                               //gracePeriod+="|ALT_ID3_EXP_WITHIN"+"$"+(alt_id3_adv_alert_days-alt_diff_days)+"$";
									//	 gracePeriod+="ALT_ID3_EXP_WITHIN"+"$"+(alt_id3_diff_days)+"$";
										   java.util.Hashtable message = MessageManager.getMessage(
							locale, "ALT_ID_EXP_WITHIN", "MP");
									//	java.util.Hashtable message = MessageManager.getMessage(conn,"ALT_ID_EXP_WITHIN");
									    String msg = ((String) message.get("message"));
										String reqmsg=replaceFunc(msg,alt_id3_desc,"N");
										reqmsg=reqmsg.substring(0,reqmsg.length());
										String repmsg="";
										if(alt_id3_diff_days != 0)
											reqmsg=reqmsg+" "+alt_id3_diff_days+""+" Days";
										else
											reqmsg=replaceFunc(reqmsg,repmsg,"Y")+""+" Today";

										reqmsg="L"+"3"+reqmsg;										
										return reqmsg;
										}
									}
								}
							}
						 }
						 
						 if(alt_id4_adv_alert_reqd_yn.equals("Y"))
						 {
							if(alt_id4_exp_date != null)
							{
								if(!(alt_id4_exp_date.before(sysDate)))
								{ //commented by raj on 10/3/2003
									//if (alt_id4_diff_days > 0) 
									if (alt_id4_diff_days >= 0) 
									{
										if ( alt_id4_diff_days <= alt_id3_adv_alert_days)
										{
										/* commented by Raj on 10/3/2003
										because The message card will expire within 
										was showing a negative number */
		                              // gracePeriod+="|ALT_ID3_EXP_WITHIN"+"$"+(alt_id4_adv_alert_days-alt_diff_days)+"$";
									//	 gracePeriod+="ALT_ID4_EXP_WITHIN"+"$"+(alt_id4_diff_days)+"$";
									 
									   java.util.Hashtable message = MessageManager.getMessage(
							locale, "ALT_ID_EXP_WITHIN", "MP");
									 //java.util.Hashtable message = MessageManager.getMessage(conn,"ALT_ID_EXP_WITHIN");
									    String msg = ((String) message.get("message"));
										String reqmsg=replaceFunc(msg,alt_id4_desc,"N");
										reqmsg=reqmsg.substring(0,reqmsg.length());
										String repmsg="";
										if(alt_id4_diff_days != 0)
											reqmsg=reqmsg+" "+alt_id4_diff_days+""+" Days";
										else
											reqmsg=replaceFunc(reqmsg,repmsg,"Y")+""+" Today";

										reqmsg="L"+"4"+reqmsg;										
										return reqmsg;
										}
									}
								}
							}
						 }

					/*	if(gracePeriod != null)
                            return gracePeriod;
						else
						{
						gracePeriod="";
						return gracePeriod;
						}*/
                    }
            }
            else
                return "";
        }

        catch(SQLException e)
        {

          return e.getMessage();//"INVALID_PATIENT";
        }
        finally
                {
                    try
                    {
                        if (pstmt!=null)pstmt.close();
                        if (rs!=null)rs.close();
                    }
                    catch(Exception e)
                    {
						e.printStackTrace();
					}
                }

		return "";
} 

public static String replaceFunc(String msg,String addmsg,String flag)
{
	StringBuffer str=new StringBuffer(msg);
	int k=0;
	String reqmsg="";	
	try
	{
		if(flag.equals("Y"))
		{
			if(msg.indexOf("within") != -1)
			{
				k=msg.indexOf("within",k);
				str=str.replace(k,(k+"within".length()),addmsg);
				reqmsg=str.toString();
			}
		}else
		{
			if(msg.indexOf("$") != -1)
			{
				k=msg.indexOf("$",k);
				str=str.replace(k,(k+"$".length()),addmsg);
				reqmsg=str.toString();
			}
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return reqmsg;
}
//Check for Inpatient

public static String CheckInPatient(Connection con,String patientid,String gfacilityid){

            PreparedStatement pstmt=null;
            ResultSet			rs =null;
			int cnt			 = 0;
			String temp="";
    try{
			    Connection conn=con;
				pstmt = conn.prepareStatement( "select count(1) from ip_open_encounter where patient_id = ?") ;
				pstmt.setString(1,patientid);
				rs = pstmt.executeQuery();
				if( rs.next() )
				{ 
				 cnt = rs.getInt(1);  
				 if (cnt>0){
					 return "CURRENTLY_IN_PATIENT";
				 }else{
					
				if (pstmt!=null)pstmt.close(); if (rs!=null)rs.close();
				pstmt = conn.prepareStatement("select count(1) from pr_encounter where patient_id = ? and adt_status <'08'") ;
				pstmt.setString(1,patientid);
				rs = pstmt.executeQuery();
				if(rs.next() )
				{  
				   cnt = rs.getInt(1);
				 if (cnt>0){ 
					 return "CURRENTLY_IN_PATIENT";
				 }else{ 
					 return "CURRENTLY_NOT_IN_PATIENT"; 
				}	 
					                 				
				}				
			  }	
			}
                    
        }
        catch(SQLException e)
        {
          return "ERROR";
        }

        finally
        {
            try
            {
                if (pstmt!=null)pstmt.close();
                if (rs!=null)rs.close();
            }
                catch(Exception e)
                {
                e.printStackTrace();
				}
        }
        return "Y";
    }

	public String Validate_SS_UC_CG(Connection con, String patient_id,String facility_id,String locale)
	{
		PreparedStatement pstmt=null;
        ResultSet rs=null;
		String national_id="";
		String accept_national_id_no_yn="";
		String p_hosp_main="";
		String p_hosp_sub="";
		String p_card_id="";
		String p_expiry_date= "";
		String p_privl_type_code="";
		String p_all_services="";
		String p_status="";
		String p_error_text="";
		String return_value="";
		HashMap interface_values1  =  new HashMap();
		CallableStatement csstmt = null;

		try
		{
            Connection conn=con;		;	

			pstmt = conn.prepareStatement( "select accept_national_id_no_yn from mp_param") ;
            rs = pstmt.executeQuery() ;			
			if( rs != null  && rs.next())  
			{
				accept_national_id_no_yn=rs.getString("accept_national_id_no_yn");
				if(accept_national_id_no_yn == null)
				accept_national_id_no_yn="";
			}
			if(pstmt!=null)
				pstmt.close();
			if(rs!=null)
				rs.close();

			if(accept_national_id_no_yn.equals("Y"))
			{
				pstmt = conn.prepareStatement( "select national_id_no from mp_patient where  patient_id=?") ;
				pstmt.setString(1,patient_id);
				rs = pstmt.executeQuery() ;			
				if( rs != null  && rs.next())  
				{
					national_id=rs.getString("national_id_no");
					if(national_id == null)
					national_id="";
				}
				csstmt=conn.prepareCall("{call  xrregint.Validate_SS_UC_CG_Privilege(?,?,?,?,?,?,?,?,?,?,?)}");	
				csstmt.setString( 1, facility_id);
				csstmt.setString( 2, national_id);
				csstmt.setString( 3, locale);
				csstmt.registerOutParameter( 4, Types.VARCHAR);
				csstmt.registerOutParameter( 5, Types.VARCHAR);
				csstmt.registerOutParameter( 6, Types.VARCHAR);
				csstmt.registerOutParameter(7,Types.VARCHAR);
				csstmt.registerOutParameter(8,Types.VARCHAR);
				csstmt.registerOutParameter(9,Types.VARCHAR);
				csstmt.registerOutParameter(10,Types.VARCHAR);
				csstmt.registerOutParameter(11,Types.VARCHAR);
				csstmt.execute();
				p_hosp_main=csstmt.getString(4);
				p_hosp_sub=csstmt.getString(5);
				p_card_id=csstmt.getString(6);
				p_expiry_date=csstmt.getString(7);
				p_privl_type_code=csstmt.getString(8);
				p_all_services=csstmt.getString(9);
				p_status=csstmt.getString(10);
				p_error_text=csstmt.getString(11);
				
				if(p_expiry_date == null)
					p_expiry_date="";
									
				if(p_hosp_main==null)
					p_hosp_main="";

				if(p_hosp_sub==null)
					p_hosp_sub="";

				if(p_card_id==null)
					p_card_id="";

				if(p_privl_type_code==null)
					p_privl_type_code="";

				if(p_all_services==null)
					p_all_services="";

				if(p_status==null)
					p_status="";

				if(p_error_text==null)
					p_error_text="";
		
				if(p_status.equals("N") || p_status.equals(""))
				{
				return_value=p_error_text;
				}
				else
				{
					interface_values1.put("p_hosp_main",p_hosp_main);
					interface_values1.put("p_hosp_sub",p_hosp_sub);
					interface_values1.put("p_card_id",p_card_id);
					interface_values1.put("p_expiry_date",p_expiry_date);
					interface_values1.put("p_privl_type_code",p_privl_type_code);
					interface_values1.put("p_all_services",p_all_services);
					interface_values1.put("p_error_text",p_error_text);
					interface_values1.put("p_status",p_status);

					return_value="Yes";
					this.setInterface_values(interface_values1);
				}
			}
			else
			{
				interface_values1.put("p_hosp_main",p_hosp_main);
				interface_values1.put("p_hosp_sub",p_hosp_sub);
				interface_values1.put("p_card_id",p_card_id);
				interface_values1.put("p_expiry_date",p_expiry_date);
				interface_values1.put("p_privl_type_code",p_privl_type_code);
				interface_values1.put("p_all_services",p_all_services);
				interface_values1.put("p_error_text",p_error_text);
				interface_values1.put("p_status",p_status);
				return_value="Yes";
				this.setInterface_values(interface_values1);
			} 	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
            {
                if (pstmt!=null)pstmt.close();
                if (rs!=null)rs.close();
				csstmt.close();
            }
            catch(Exception e)
            {
				e.printStackTrace();
			}
		}
			
		return(return_value);

	}
	public static String checkPatientDisposeArchive(Connection con,String patientId){
		String sql ="SELECT COUNT (1) FROM MP_PATIENT_DISPOSE WHERE DISPOSE_PAT_ID = ?";
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		ResultSet  rs1=null;
		int count	= 0;
		String returnValue	= "";
		System.err.println("sql==>"+sql);
		System.err.println("patientId==>"+patientId);
		try{			
			pstmt=con.prepareStatement(sql);	
			pstmt.setString(1,patientId);
			rs=pstmt.executeQuery();		
			if(rs!=null && rs.next()){
				count	= rs.getInt(1);
				if(count > 0){
					returnValue	= "D";
				}
			} 
			if(pstmt !=null) pstmt.close();
			System.err.println("count==>"+count);
			System.err.println("returnValue==>"+returnValue);
			if(returnValue.equals("") && count==0){
				String sql1 ="SELECT COUNT (1) FROM MP_INACTIVE_PATIENT WHERE INACTIVE_PAT_ID = ?";
				System.err.println("sql1==>897==>"+sql1);
				System.err.println("patientId==>898==>"+patientId);
				try{			
					pstmt=con.prepareStatement(sql1);	
					pstmt.setString(1,patientId);
					rs1=pstmt.executeQuery();
					if(rs1!=null && rs1.next()){
						count	= rs1.getInt(1);
						if(count > 0){
							returnValue	= "I";
						}
					}
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
			System.err.println("count==>915==>"+count);
			System.err.println("returnValue==>916==>"+returnValue);
		}catch(Exception ex){
			System.err.println("Exception in checkPatientDisposeArchive ----> "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
				if(rs1 !=null) rs1.close();
			}
			catch(Exception fny){
			fny.printStackTrace();
			}
		}
		return returnValue;
	}
}
