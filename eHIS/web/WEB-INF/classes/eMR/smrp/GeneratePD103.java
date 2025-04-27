package eMR.smrp;
 
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import java.text.*;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
  

public class GeneratePD103 extends HttpServlet 
{ 
	// No MOD- based on feedback


	PrintWriter out;
	java.util.Properties p;

	/*This function will be invoked when Server Started- for this it has entry in web.xml*/
	public void init(ServletConfig config) throws ServletException	
	{

		super.init(config);
		//This gets called without user action. If this has to be called on specific intervals, the same has to be handled inside the main method.
		JobSchedulePD103 js =new JobSchedulePD103();
		// to call a sub routine which will call the main mathod based on preset intervals.
		js.main();

	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
	{
		try	
		{ 
			req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			doPost(req,res);
			
		}
		catch(Exception e)	{
			System.err.println("Exception in doGet function:"+e.toString());
			  e.printStackTrace();

			}
	}
				

	/* called when the report is generatede form application*/
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
	{
		try	
		{
			

			String from_date 	  = req.getParameter("rep_date");
			String to_date   	  = req.getParameter("rep_date");
			String facility_id    = req.getParameter("hmis_hospital");
			String locale    = req.getParameter("locale");
			
			
			String dir  		  = System.getProperty("user.dir");	

			req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html;charset=UTF-8");
			
		/*This will make call to createPD103 function which will create the JSON file*/
			GeneratePD103 Gjson= new GeneratePD103();

			String PD103_fileCreated_flag =Gjson.createPD103(facility_id,from_date,to_date);

			String error="";
			if(PD103_fileCreated_flag.equals("1")){
				error= "SMRP_FILE_GENERATED";
			}else if (PD103_fileCreated_flag.equals("0")){
				error= "SMRP_FILE_NOT_GENERATED";
			}else if (PD103_fileCreated_flag.equals("2")){
				error= "SMRP_FILE_PATH_NO_SPECIFY";
			}
			Hashtable hashtable1 = MessageManager.getMessage(locale, error,"MR");
			error = (String)hashtable1.get("message");
			
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + PD103_fileCreated_flag );
			
		}
		catch(Exception e)	{
			 System.err.println("Exception in doPost function:"+e.toString());
			  e.printStackTrace();
			}
	}

/*This function will Create the Json based on the Parameters*/
	public String createPD103(String facility_id,String start_date,String end_date)					
	{ 
		
		Connection con = null;
		ResultSet rset = null;
		ResultSet rset_1 = null;
		ResultSet rset_2 = null;
		PreparedStatement pstmt_1 =  null;
		PreparedStatement pstmt =  null;
		PreparedStatement pstmt_2 =  null;
		String filename ="";
		Statement stmt=null;
		

		String fileCreated = "0";
		
		int Count  				= 0;

		LogSMRP smrpLogger=new LogSMRP();

		try {			
		
			Date currentdate = new Date();
			SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
			int def_duration=0;
			
			//String dir="\\\\cscappche608\\eHIS\\WCHSMRP"; //This has to be read from the db.
			String dir=""; //This has to be read from the db.

			con =   ConnectionManager.getConnection();
			stmt =  con.createStatement();
			//System.out.println("");
			rset =  stmt.executeQuery("select VALUE_1 file_path, SITE_ID  from SM_FUNCTION_CONTROL where module_id='MR' and functionality_id='SMRP' and SITE_ID=(select customer_id from sm_site_param)");
			if(rset!= null && rset.next()){
				dir=rset.getString("file_path");				
			}

			rset.close(); 
			stmt.close();

			if(dir.equals("") && def_duration==0) {
				fileCreated="2";
   			    System.out.println(" No dir path --> "+dir +"or no def_duration "+def_duration+" -->"+filename);
			}else{
				
				def_duration=1;
				stmt =  con.createStatement();
				rset =  stmt.executeQuery("select DURATION def_duration from MR_SMRP_CONFIG where SMRP_ID='PD103'");

				if(rset!= null && rset.next()){
					def_duration=rset.getInt("def_duration");
					
				}

				rset.close();
				stmt.close();

				GregorianCalendar cal = new GregorianCalendar();
				cal.setTime(currentdate);
				cal.add(Calendar.DATE, - 1);
				currentdate=cal.getTime();
				cal.setTime(currentdate);
				cal.add(Calendar.DATE, - def_duration);
				Date pastdate = cal.getTime();


				/*when Date is not passed from Front end, it will consider Current Date and Current Date - 7*/
				String from_date 	  = start_date.equals("") ? ft.format(pastdate):start_date; 
				//String to_date   	   = end_date.equals("") ? ft.format(currentdate):end_date;
				String to_date   	   = end_date.equals("") ? ft.format(pastdate):end_date;

				start_date=from_date;
				end_date=to_date;

				
				/*The View which is created for this PD103Json purpose*/

				String mapped_fac_id=facility_id;

				stmt =  con.createStatement();
				rset =  stmt.executeQuery("SELECT ext_pk_id  FROM xh_oth_appl_data_skey WHERE table_id = 'SM_FACILITY_PARAM' AND pk_value ='"+facility_id+"' AND application_id = 'SMRP'");
				
				if(rset!=null && rset.next()){
					mapped_fac_id=rset.getString("EXT_PK_ID");
				}
				rset.close();
				stmt.close();

				filename       = mapped_fac_id+"_"+from_date.replaceAll("/","")+"_"+to_date.replaceAll("/",""); 
				String refServiceTypeCode="01";
					
				
				/*This query will return the service code for which JSON file need to be generated*/
				
				stmt =  con.createStatement();
				rset =  stmt.executeQuery("select EXT_PK_ID from  XH_OTH_APPL_DATA_SKEY WHERE table_id='AM_PATIENT_CLASS' and APPLICATION_ID='SMRP' and PK_VALUE='IP'");
				
				

			
				if(rset!=null && rset.next()){
					refServiceTypeCode=rset.getString("EXT_PK_ID");
				}
				rset.close();
				stmt.close();

				
			//		String  sqlQuery= "SELECT   A.SHORT_DESC nurs_unit_short_desc,'00' ward_class,A.NURSING_UNIT_CODE,A1.SPECIALTY_CODE,NVL ((SELECT ext_pk_id  FROM xh_oth_appl_data_skey WHERE table_id = 'AM_SPECIALITY' AND pk_value = a1.SPECIALTY_CODE AND application_id = 'SMRP'),             '00' ) map_SP_CD,DECODE(A1.SPECIALTY_CODE,A2.SPECIALITY_CODE,A2.SHORT_DESC ,'NOT DEFIEND') SPECIALITY,    NVL(C.START_OF_DAY,0) START_OF_DAY,    NVL(c.male,0) start_of_day_male,    NVL(c.female,0)  start_of_day_female,    NVL(c.unknown,0)  start_of_day_unknown,    NVL (d.tot_adm, 0) tot_adm,    NVL(d.a_male,0) a_male ,NVL(d.a_female,0) a_female, NVL(d.a_unknown,0) a_unknown, NVL(d.a_male,0)+  NVL(d.a_female,0) +  NVL(d.a_unknown,0) a_total,    NVL(d.c_male,0) c_male,NVL(d.c_female,0) c_female, NVL(d.c_unknown,0) c_unknown,NVL(d.c_male,0) + NVL(d.c_female,0) + NVL(d.c_unknown,0) c_total,    NVL(d.b_male,0) b_male,NVL(d.b_female,0) b_female, NVL(d.b_unknown,0) b_unknown,NVL(d.b_male,0) + NVL(d.b_female,0) + NVL(d.b_unknown,0) b_total ,    NVL (e.trans_in, 0) trans_in,    NVL (e.m_trans_in, 0) m_trans_in,    NVL (e.f_trans_in, 0) f_trans_in,    NVL (e.u_trans_in, 0) u_trans_in,    NVL(h.m_intra_in,0) m_intra_in,    NVL(h.f_intra_in,0) f_intra_in,    NVL(h.u_intra_in,0) u_intra_in,    NVL(h.tot_intra_in,0) tot_intra_in,    NVL(c.male,0)    +NVL(d.a_male,0)    +NVL(d.c_male,0)    +NVL(d.b_male,0)    +NVL (e.m_trans_in, 0)     +NVL(h.m_intra_in,0)   male_total_patient,    ( NVL(c.female,0)    +NVL(d.a_female,0)    +NVL(d.c_female,0)    +NVL(d.b_female,0)    +NVL (e.f_trans_in,0)     +NVL(h.f_intra_in,0) )female_total_patient,    ( NVL(c.unknown,0)    +NVL(d.a_unknown,0)    +NVL(d.c_unknown,0)    +NVL(d.b_unknown,0)    +NVL (e.u_trans_in,0)     +NVL(h.u_intra_in,0) )unknown_total_patient,         NVL(C.START_OF_DAY,0)+NVL (d.tot_adm, 0)+ NVL (e.trans_in, 0)+ NVL (h.trans_in, 0)     total_patient,       (NVL(c.start_of_day,0)+NVL(d.tot_adm,0)       +NVL(e.trans_in,0)-NVL(f.trans_out,0)       -NVL(g.tot_dis,0) )end_of_day,   ABS(   ((NVL(c.male,0)         +NVL(d.a_male,0)         +NVL(d.c_male,0)         +NVL(d.b_male,0)         +NVL (e.m_trans_in, 0)          +NVL(h.m_intra_in,0))-  (NVL(g.male_discharge,0)+NVL(f.m_trans_out, 0)+NVL(i.m_intra_OUT,0))))male_end_of_day,ABS(   ((NVL(c.female,0)         +NVL(d.a_female,0)         +NVL(d.c_female,0)         +NVL(d.b_female,0)         +NVL (e.f_trans_in, 0)          +NVL(h.f_intra_in,0))-  (NVL(g.female_discharge,0)+NVL(f.f_trans_out, 0)+NVL(i.f_intra_OUT,0))))female_end_of_day,ABS(   ((NVL(c.unknown,0)         +NVL(d.a_unknown,0)         +NVL(d.c_unknown,0)         +NVL(d.b_unknown,0)         +NVL (e.u_trans_in, 0)         +NVL(h.u_intra_in,0))-  (NVL(g.unknown_discharge,0)+NVL(f.u_trans_out, 0)+NVL(i.u_intra_OUT,0))))unknown_end_of_day,       NVL(g.tot_dis,0) tot_dis,       NVL(g.male_discharge,0) male_dis_charge,       NVL(g.female_discharge,0) female_dis_charge,       NVL(g.unknown_discharge,0) unknown_dis_charge,       NVL(m_home,0)m_home,       NVL(f_home,0) f_home,       NVL(u_home,0) u_home,       NVL(m_deceased,0) m_deceased,       NVL(f_deceased,0) f_deceased,       NVL(u_deceased,0) u_deceased,       NVL(m_absc,0) m_absc,       NVL(f_absc,0) f_abcs,       NVL(u_absc,0) u_abcs,       NVL(m_aor,0) m_aor,       NVL(f_aor,0) f_aor,       NVL(u_aor,0) u_aor,       NVL(m_tf,0) m_tf,       NVL(f_tf,0) f_tf,  NVL(u_tf,0) u_tf, NVL(g.tot_one_day_stay,0) tot_one_day_stay,       NVL(g.m_one_day_stay,0)m_one_day_stay,       NVL(g.f_one_day_stay,0)f_one_day_stay,       NVL(g.u_one_day_stay,0)u_one_day_stay,       NVL (f.trans_out, 0) trans_out,       NVL (f.m_trans_out, 0) m_trans_out,       NVL (f.f_trans_out, 0) f_trans_out,       NVL (f.u_trans_out, 0) u_trans_out,       NVL(i.m_intra_out,0) m_intra_out,       NVL(i.f_intra_out,0) f_intra_out,       NVL(i.u_intra_out,0) u_intra_out,       NVL(i.tot_intra_out,0) tot_intra_out   FROM IP_NURSING_UNIT A,AM_SPECIALITY A2,       (SELECT SPECIALTY_CODE,NURSING_UNIT_CODE,FACILITY_ID FROM  IP_NURS_UNIT_FOR_SPECIALTY                   WHERE NURSING_UNIT_CODE = NVL(null, NURSING_UNIT_CODE)               AND FACILITY_ID =?)A1,        (SELECT Q.FACILITY_ID, COUNT(*) TOT_BEDS,NVL(R.SPECIALTY_CODE,'X') SPECIALTY_CODE, Q.NURSING_UNIT_CODE        FROM IP_NURSING_UNIT_BED Q, IP_NURS_UNIT_FOR_SPECIALTY R        WHERE Q.facility_id=? AND Q.eff_status='E'    AND  Q.PSEUDO_BED_YN= 'N'        AND Q.NURSING_UNIT_CODE =NVL(null, Q.NURSING_UNIT_CODE)        AND TRUNC(Q.added_date) <= TRUNC(TO_DATE(?,'dd/mm/yyyy'))        and Q.NURSING_UNIT_CODE=R.NURSING_UNIT_CODE        and Q.facility_id=R.facility_id        GROUP BY Q.FACILITY_ID,R.SPECIALTY_CODE, Q.NURSING_UNIT_CODE)   B       ,(SELECT   facility_id, COUNT (*) start_of_day,                   NVL (SPECIALTY_CODE, 'X') SPECIALTY_CODE,                   nursing_unit_code,                   SUM (CASE WHEN sex = 'M' THEN 1 ELSE 0 END) male,                    SUM (CASE WHEN sex = 'F' THEN 1 ELSE 0 END) female,                   SUM (CASE WHEN sex = 'U' THEN 1 ELSE 0 END) unknown              FROM (SELECT facility_id, encounter_id, trn_type,                           to_nursing_unit nursing_unit_code, to_bed_no, sex,                           TO_SPECIALTY_CODE SPECIALTY_CODE,                           trn_date_time from_date,                           trn_to_date_time end_date                      FROM ip_adt_trn_census_vw x, mp_patient y                      WHERE facility_id = ?                      AND trn_type != 'R'                        AND adt_status != '09'                        AND x.patient_id = y.patient_id                       AND y.sex IN ('M', 'F','U')                        AND trn_date_time <=  TRUNC (TO_DATE (?, 'DD/MM/YYYY'))                       AND (trn_to_date_time >= TRUNC (TO_DATE (?, 'DD/MM/YYYY') )                               OR trn_to_date_time IS NULL) AND (DISCHARGE_DATE_TIME >= TRUNC (TO_DATE (?, 'DD/MM/YYYY') )   OR DISCHARGE_DATE_TIME IS NULL))               WHERE TRUNC (from_date) <= TRUNC (TO_DATE (?, 'DD/MM/YYYY'))  AND (   TRUNC (end_date) >=  TRUNC (TO_DATE (?, 'DD/MM/YYYY'))                      OR end_date IS NULL ) AND trn_type IN ('A', 'T', 'L') AND to_bed_no IS NOT NULL  AND nursing_unit_code = NVL(null, NURSING_UNIT_CODE) GROUP BY facility_id, SPECIALTY_CODE, nursing_unit_code) C  ,(SELECT FACILITY_ID,TO_NURSING_UNIT NURSING_UNIT_CODE,COUNT(*) TOT_ADM,NVL(TO_SPECIALTY_CODE,'X') SPECIALTY_CODE,       SUM(CASE WHEN  MONTHS_BETWEEN(X.ADMISSION_DATE_TIME,Z.date_of_birth)>144 AND Z.sex='M' THEN 1 ELSE 0 END)a_male,       SUM(CASE WHEN  MONTHS_BETWEEN(X.ADMISSION_DATE_TIME,Z.date_of_birth)>144 AND Z.sex='F' THEN 1 ELSE 0 END)a_female,       SUM(CASE WHEN  MONTHS_BETWEEN(X.ADMISSION_DATE_TIME,Z.date_of_birth)>144 AND Z.sex='U' THEN 1 ELSE 0 END)a_unknown,       SUM(CASE WHEN  (MONTHS_BETWEEN(X.ADMISSION_DATE_TIME,Z.date_of_birth) BETWEEN 12 AND 144) AND Z.sex='M' THEN 1 ELSE 0 END)c_male,       SUM(CASE WHEN  (MONTHS_BETWEEN(X.ADMISSION_DATE_TIME,Z.date_of_birth) BETWEEN 12 AND 144) AND Z.sex='F' THEN 1 ELSE 0 END)c_female,       SUM(CASE WHEN  (MONTHS_BETWEEN(X.ADMISSION_DATE_TIME,Z.date_of_birth) BETWEEN 12 AND 144) AND Z.sex='U' THEN 1 ELSE 0 END)c_unknown,       SUM(CASE WHEN  MONTHS_BETWEEN(X.ADMISSION_DATE_TIME,Z.date_of_birth)<12 AND Z.sex='M' THEN 1 ELSE 0 END)b_male,       SUM(CASE WHEN  MONTHS_BETWEEN(X.ADMISSION_DATE_TIME,Z.date_of_birth)<12 AND Z.sex='F' THEN 1 ELSE 0 END)b_female,           SUM(CASE WHEN  MONTHS_BETWEEN(X.ADMISSION_DATE_TIME,Z.date_of_birth)<12 AND Z.sex='U' THEN 1 ELSE 0 END)b_unknown         FROM IP_ADT_TRN_CENSUS_VW X ,MP_PATIENT Z        WHERE FACILITY_ID=?       AND TRN_TYPE='A'       AND X.PATIENT_ID = Z.PATIENT_ID      AND Z.SEX IN('M','F','U')   AND ADT_STATUS!='09'  AND to_NURSING_UNIT =NVL(null, to_NURSING_UNIT)         AND TO_BED_NO IS NOT NULL         AND TRN_DATE_TIME BETWEEN TRUNC(TO_DATE(?,'DD/MM/YYYY'))         AND TRUNC(TO_DATE(?,'DD/MM/YYYY')) + 0.99999         GROUP BY FACILITY_ID,TO_NURSING_UNIT,TO_SPECIALTY_CODE) D,            (SELECT FACILITY_ID,COUNT(*) TRANS_IN,NVL(TO_SPECIALTY_CODE,'X') SPECIALTY_CODE,         TO_NURSING_UNIT NURSING_UNIT_CODE,          SUM(CASE WHEN Z.sex='M' THEN 1 ELSE 0 END) m_trans_in,          SUM(CASE WHEN Z.sex='F' THEN 1 ELSE 0 END) f_trans_in,          SUM(CASE WHEN Z.sex='U' THEN 1 ELSE 0 END) u_trans_in        FROM IP_ADT_TRN_CENSUS_VW X,MP_PATIENT Z         WHERE FACILITY_ID=?         AND X.PATIENT_ID = Z.PATIENT_ID         AND Z.SEX IN ('M','F','U')         AND TRN_TYPE='T'         AND TO_NURSING_UNIT = NVL(null, TO_NURSING_UNIT)         AND FR_NURSING_UNIT_CODE!=TO_NURSING_UNIT         AND TO_NURSING_UNIT = NVL(null, TO_NURSING_UNIT)         AND ADT_STATUS!='09'         AND TRN_DATE_TIME BETWEEN TRUNC(TO_DATE(?,'DD/MM/YYYY'))                           AND TRUNC(TO_DATE(?,'DD/MM/YYYY')) + 0.99999        GROUP BY FACILITY_ID,TO_NURSING_UNIT,TO_SPECIALTY_CODE       ) E      ,(SELECT FACILITY_ID,COUNT(*) TRANS_OUT,NVL(FR_SPECIALTY_CODE,'X') SPECIALTY_CODE,               FR_NURSING_UNIT_CODE NURSING_UNIT_CODE,              SUM(CASE WHEN Z.sex='M' THEN 1 ELSE 0 END) m_trans_out,               SUM(CASE WHEN Z.sex='F' THEN 1 ELSE 0 END) f_trans_out,               SUM(CASE WHEN Z.sex='F' THEN 1 ELSE 0 END) u_trans_out        FROM IP_ADT_TRN_CENSUS_VW X,MP_PATIENT Z        WHERE FACILITY_ID=?         AND TRN_TYPE='T'       AND FR_NURSING_UNIT_CODE =NVL(null, FR_NURSING_UNIT_CODE)        AND X.PATIENT_ID = Z.PATIENT_ID        AND Z.SEX IN ('M','F','U')         AND TO_NURSING_UNIT!=FR_NURSING_UNIT_CODE         AND FR_NURSING_UNIT_CODE = NVL(null, FR_NURSING_UNIT_CODE)         AND ADT_STATUS!='09'        AND TRN_DATE_TIME BETWEEN TRUNC(TO_DATE(?,'DD/MM/YYYY'))         AND TRUNC(TO_DATE(?,'DD/MM/YYYY')) + 0.99999        GROUP BY FACILITY_ID,FR_NURSING_UNIT_CODE,FR_SPECIALTY_CODE       ) F     ,(SELECT FACILITY_ID,COUNT(*) TOT_DIS,NVL(FR_SPECIALTY_CODE,'X') SPECIALTY_CODE,       FR_NURSING_UNIT_CODE NURSING_UNIT_CODE,       SUM(CASE WHEN Z.sex ='M' THEN 1 ELSE 0 END) male_discharge,       SUM(CASE WHEN Z.sex ='F' THEN 1 ELSE 0 END) female_discharge,       SUM(CASE WHEN Z.sex ='U' THEN 1 ELSE 0 END) unknown_discharge,      SUM(DECODE(Y.DECEASED_YN,'Y',1,0)) TOT_DEATH,     SUM(CASE WHEN INDICATOR='ND' AND sex = 'M' THEN 1 ELSE 0 END)m_home,      SUM(CASE WHEN INDICATOR='ND' AND sex = 'F' THEN 1 ELSE 0 END)f_home,      SUM(CASE WHEN INDICATOR='ND' AND sex = 'U' THEN 1 ELSE 0 END)u_home,      SUM(CASE WHEN INDICATOR='DS' AND sex = 'M' THEN 1 ELSE 0 END)m_deceased,    SUM(CASE WHEN INDICATOR='DS' AND sex = 'F' THEN 1 ELSE 0 END)f_deceased,  SUM(CASE WHEN INDICATOR='DS' AND sex = 'U' THEN 1 ELSE 0 END)u_deceased,     SUM(CASE WHEN INDICATOR='AB' AND sex = 'M' THEN 1 ELSE 0 END)m_absc,    SUM(CASE WHEN INDICATOR='AB' AND sex = 'F' THEN 1 ELSE 0 END)f_absc,    SUM(CASE WHEN INDICATOR='AB' AND sex = 'U' THEN 1 ELSE 0 END)u_absc,    SUM(CASE WHEN INDICATOR='AO' AND sex = 'M' THEN 1 ELSE 0 END)m_aor,    SUM(CASE WHEN INDICATOR='AO' AND sex = 'F' THEN 1 ELSE 0 END)f_aor,    SUM(CASE WHEN INDICATOR='AO' AND sex = 'U' THEN 1 ELSE 0 END)u_aor,    SUM(CASE WHEN INDICATOR='ED' AND sex = 'M' THEN 1 ELSE 0 END)m_tf,    SUM(CASE WHEN INDICATOR='ED' AND sex = 'F' THEN 1 ELSE 0 END)f_tf,    SUM(CASE WHEN INDICATOR='ED' AND sex = 'U' THEN 1 ELSE 0 END)u_tf,     SUM(DECODE(TRUNC(ADMISSION_DATE_TIME),TRUNC(TRN_DATE_TIME),1,0)) TOT_ONE_DAY_STAY,     SUM(CASE WHEN (TRUNC(ADMISSION_DATE_TIME)- TRUNC(TRN_DATE_TIME))=0 AND SEX = 'M' THEN 1 ELSE 0 END) M_ONE_DAY_STAY,     SUM(CASE WHEN (TRUNC(ADMISSION_DATE_TIME)- TRUNC(TRN_DATE_TIME))=0 AND SEX = 'F' THEN 1 ELSE 0 END) F_ONE_DAY_STAY,     SUM(CASE WHEN (TRUNC(ADMISSION_DATE_TIME)- TRUNC(TRN_DATE_TIME))=0 AND SEX = 'U' THEN 1 ELSE 0 END) U_ONE_DAY_STAY      FROM IP_ADT_TRN_CENSUS_VW X , IP_DISCHARGE_TYPE Y,MP_PATIENT Z       WHERE FACILITY_ID=?      AND TRN_TYPE='D'        AND   FR_NURSING_UNIT_CODE =NVL(null, FR_NURSING_UNIT_CODE)        AND X.PATIENT_ID = Z.PATIENT_ID         AND Z.SEX IN ('M','F','U')        AND ADT_STATUS!='09'        AND INDICATOR IN ('ND','DS','AB','AO','ED')        AND TRN_DATE_TIME BETWEEN TRUNC(TO_DATE(?,'DD/MM/YYYY'))         AND TRUNC(TO_DATE(?,'DD/MM/YYYY')) + 0.99999        AND DISCHARGE_TYPE_CODE=TRN_CODE       GROUP BY FACILITY_ID,FR_NURSING_UNIT_CODE,FR_SPECIALTY_CODE       ) G , (SELECT X.FACILITY_ID,TO_NURSING_UNIT NURSING_UNIT_CODE,COUNT(*) TRANS_IN,NVL(TO_SPECIALTY_CODE,'X') SPECIALTY_CODE,         SUM(CASE WHEN Z.sex='M' THEN 1 ELSE 0 END) m_intra_in,         SUM(CASE WHEN Z.sex='F' THEN 1 ELSE 0 END) f_intra_in,          SUM(CASE WHEN Z.sex='U' THEN 1 ELSE 0 END) u_intra_in,          COUNT(*) TOT_INTRA_IN        FROM IP_ADT_TRN_CENSUS_VW X,MP_PATIENT Z,         IP_NURS_UNIT_FOR_SPECIALTY Y        WHERE X.FACILITY_ID=?         AND X.PATIENT_ID = Z.PATIENT_ID        AND Z.SEX IN ('M','F','U')        AND TRN_TYPE='T'        AND TO_NURSING_UNIT = NVL(null, TO_NURSING_UNIT)         AND FR_NURSING_UNIT_CODE=TO_NURSING_UNIT         AND TO_NURSING_UNIT = Y.NURSING_UNIT_CODE         AND X.FACILITY_ID = Y.FACILITY_ID         AND X.TO_SPECIALTY_CODE != X.FR_SPECIALTY_CODE         AND X.TO_SPECIALTY_CODE = Y.SPECIALTY_CODE         AND ADT_STATUS!='09'         AND TRN_DATE_TIME BETWEEN TRUNC(TO_DATE(?,'DD/MM/YYYY'))         AND TRUNC(TO_DATE(?,'DD/MM/YYYY')) + 0.99999        GROUP BY X.FACILITY_ID,TO_NURSING_UNIT,TO_SPECIALTY_CODE) H, (SELECT X.FACILITY_ID,TO_NURSING_UNIT NURSING_UNIT_CODE,COUNT(*) TRANS_IN,NVL(FR_SPECIALTY_CODE,'X') SPECIALTY_CODE,          SUM(CASE WHEN Z.sex='M' THEN 1 ELSE 0 END) m_intra_out,          SUM(CASE WHEN Z.sex='F' THEN 1 ELSE 0 END) f_intra_out,          SUM(CASE WHEN Z.sex='U' THEN 1 ELSE 0 END) u_intra_out,         COUNT(*) TOT_INTRA_OUT        FROM IP_ADT_TRN_CENSUS_VW X,MP_PATIENT Z,IP_NURS_UNIT_FOR_SPECIALTY  Y        WHERE X.FACILITY_ID=?         AND X.PATIENT_ID = Z.PATIENT_ID        AND Z.SEX IN ('M','F','U')        AND TRN_TYPE='T'        AND TO_NURSING_UNIT = NVL(null, TO_NURSING_UNIT)         AND FR_NURSING_UNIT_CODE=TO_NURSING_UNIT         AND TO_NURSING_UNIT = Y.NURSING_UNIT_CODE         AND X.FACILITY_ID = Y.FACILITY_ID         AND X.TO_SPECIALTY_CODE != X.FR_SPECIALTY_CODE         AND X.TO_SPECIALTY_CODE = Y.SPECIALTY_CODE         AND ADT_STATUS!='09'         AND  TRN_DATE_TIME BETWEEN TRUNC(TO_DATE(?,'DD/MM/YYYY'))         AND TRUNC(TO_DATE(?,'DD/MM/YYYY')) + 0.99999        GROUP BY X.FACILITY_ID,TO_NURSING_UNIT,FR_SPECIALTY_CODE) I     WHERE  A.facility_id = ? AND A.NURSING_UNIT_CODE =NVL(null, A.NURSING_UNIT_CODE)   AND A.EFF_STATUS='E' AND A.INCL_FOR_HOSP_OCCUP_CALC_YN = 'Y'   AND A1.SPECIALTY_CODE=A2.SPECIALITY_CODE AND A1.FACILITY_ID =A.FACILITY_ID AND A1.NURSING_UNIT_CODE = A.NURSING_UNIT_CODE   AND b.SPECIALTY_CODE(+)=A1.SPECIALTY_CODE   AND C.SPECIALTY_CODE(+)=A1.SPECIALTY_CODE AND D.SPECIALTY_CODE(+)=A1.SPECIALTY_CODE AND e.SPECIALTY_CODE(+)=A1.SPECIALTY_CODE AND f.SPECIALTY_CODE(+)=A1.SPECIALTY_CODE AND g.SPECIALTY_CODE(+)=A1.SPECIALTY_CODE AND h.SPECIALTY_CODE(+)=A1.SPECIALTY_CODE AND I.SPECIALTY_CODE(+)=A1.SPECIALTY_CODE   AND b.NURSING_UNIT_CODE(+)=A1.NURSING_UNIT_CODE   AND C.NURSING_UNIT_CODE(+)=A1.NURSING_UNIT_CODE AND D.NURSING_UNIT_CODE(+)=A1.NURSING_UNIT_CODE AND e.NURSING_UNIT_CODE(+)=A1.NURSING_UNIT_CODE AND f.NURSING_UNIT_CODE(+)=A1.NURSING_UNIT_CODE AND g.NURSING_UNIT_CODE(+)=A1.NURSING_UNIT_CODE AND h.NURSING_UNIT_CODE(+)=A1.NURSING_UNIT_CODE AND I.NURSING_UNIT_CODE(+)=A1.NURSING_UNIT_CODE   ORDER BY NURSING_UNIT_CODE,SPECIALTY_CODE";

			String  sqlQuery= "SELECT   a.short_desc nurs_unit_short_desc, '00' ward_class,          a.nursing_unit_code, a1.service_code,          NVL ((SELECT ext_pk_id                  FROM xh_oth_appl_data_skey                 WHERE table_id = 'AM_SERVICE'                   AND pk_value = a1.service_code                   AND application_id = 'SMRP'),               '00'              ) map_sp_cd,          DECODE (a1.service_code,                  a2.service_code, a2.short_desc,                  'NOT DEFIEND'                 ) service,          NVL (c.start_of_day, 0) start_of_day,          NVL (c.male, 0) start_of_day_male,          NVL (c.female, 0) start_of_day_female,          NVL (c.unknown, 0) start_of_day_unknown, NVL (d.tot_adm, 0) tot_adm,          NVL (d.a_male, 0) a_male, NVL (d.a_female, 0) a_female,          NVL (d.a_unknown, 0) a_unknown,          NVL (d.a_male, 0) + NVL (d.a_female, 0)          + NVL (d.a_unknown, 0) a_total, NVL (d.c_male, 0) c_male,          NVL (d.c_female, 0) c_female, NVL (d.c_unknown, 0) c_unknown,          NVL (d.c_male, 0) + NVL (d.c_female, 0)          + NVL (d.c_unknown, 0) c_total, NVL (d.b_male, 0) b_male,          NVL (d.b_female, 0) b_female, NVL (d.b_unknown, 0) b_unknown,          NVL (d.b_male, 0) + NVL (d.b_female, 0)          + NVL (d.b_unknown, 0) b_total, NVL (e.trans_in, 0) trans_in,          NVL (e.m_trans_in, 0) m_trans_in, NVL (e.f_trans_in, 0) f_trans_in,          NVL (e.u_trans_in, 0) u_trans_in, NVL (h.m_intra_in, 0) m_intra_in,          NVL (h.f_intra_in, 0) f_intra_in, NVL (h.u_intra_in, 0) u_intra_in,          NVL (h.tot_intra_in, 0) tot_intra_in,            NVL (c.male, 0)          + NVL (d.a_male, 0)          + NVL (d.c_male, 0)          + NVL (d.b_male, 0)          + NVL (e.m_trans_in, 0)          + NVL (h.m_intra_in, 0) male_total_patient,          (  NVL (c.female, 0)           + NVL (d.a_female, 0)           + NVL (d.c_female, 0)           + NVL (d.b_female, 0)           + NVL (e.f_trans_in, 0)           + NVL (h.f_intra_in, 0)          ) female_total_patient,          (  NVL (c.unknown, 0)           + NVL (d.a_unknown, 0)           + NVL (d.c_unknown, 0)           + NVL (d.b_unknown, 0)           + NVL (e.u_trans_in, 0)           + NVL (h.u_intra_in, 0)          ) unknown_total_patient,            NVL (c.start_of_day, 0)          + NVL (d.tot_adm, 0)          + NVL (e.trans_in, 0)          + NVL (h.trans_in, 0) total_patient,          (  NVL (c.start_of_day, 0)           + NVL (d.tot_adm, 0)           + NVL (e.trans_in, 0)           - NVL (f.trans_out, 0)           - NVL (g.tot_dis, 0)          ) end_of_day,          ABS ((  (  NVL (c.male, 0)                   + NVL (d.a_male, 0)                   + NVL (d.c_male, 0)                   + NVL (d.b_male, 0)                   + NVL (e.m_trans_in, 0)                   + NVL (h.m_intra_in, 0)                  )                - (  NVL (g.male_discharge, 0)                   + NVL (f.m_trans_out, 0)                   + NVL (i.m_intra_out, 0)                  )               )              ) male_end_of_day,          ABS ((  (  NVL (c.female, 0)                   + NVL (d.a_female, 0)                   + NVL (d.c_female, 0)                   + NVL (d.b_female, 0)                   + NVL (e.f_trans_in, 0)                   + NVL (h.f_intra_in, 0)                  )                - (  NVL (g.female_discharge, 0)                   + NVL (f.f_trans_out, 0)                   + NVL (i.f_intra_out, 0)                  )               )              ) female_end_of_day,          ABS ((  (  NVL (c.unknown, 0)                   + NVL (d.a_unknown, 0)                   + NVL (d.c_unknown, 0)                   + NVL (d.b_unknown, 0)                   + NVL (e.u_trans_in, 0)                   + NVL (h.u_intra_in, 0)                  )                - (  NVL (g.unknown_discharge, 0)                   + NVL (f.u_trans_out, 0)                   + NVL (i.u_intra_out, 0)                  )               )              ) unknown_end_of_day,          NVL (g.tot_dis, 0) tot_dis, NVL (g.male_discharge,                                           0) male_dis_charge,          NVL (g.female_discharge, 0) female_dis_charge,          NVL (g.unknown_discharge, 0) unknown_dis_charge,          NVL (m_home, 0) m_home, NVL (f_home, 0) f_home,          NVL (u_home, 0) u_home, NVL (m_deceased, 0) m_deceased,          NVL (f_deceased, 0) f_deceased, NVL (u_deceased, 0) u_deceased,          NVL (m_absc, 0) m_absc, NVL (f_absc, 0) f_abcs,          NVL (u_absc, 0) u_abcs, NVL (m_aor, 0) m_aor, NVL (f_aor, 0) f_aor,          NVL (u_aor, 0) u_aor, NVL (m_tf, 0) m_tf, NVL (f_tf, 0) f_tf,          NVL (u_tf, 0) u_tf, NVL (g.tot_one_day_stay, 0) tot_one_day_stay,          NVL (g.m_one_day_stay, 0) m_one_day_stay,          NVL (g.f_one_day_stay, 0) f_one_day_stay,          NVL (g.u_one_day_stay, 0) u_one_day_stay,          NVL (f.trans_out, 0) trans_out, NVL (f.m_trans_out, 0) m_trans_out,          NVL (f.f_trans_out, 0) f_trans_out,          NVL (f.u_trans_out, 0) u_trans_out,          NVL (i.m_intra_out, 0) m_intra_out,          NVL (i.f_intra_out, 0) f_intra_out,          NVL (i.u_intra_out, 0) u_intra_out,          NVL (i.tot_intra_out, 0) tot_intra_out     FROM ip_nursing_unit a,          am_service a2,          (SELECT service_code, nursing_unit_code, facility_id             FROM ip_nurs_unit_for_service            WHERE nursing_unit_code = NVL (NULL, nursing_unit_code)              AND facility_id = ?           UNION           SELECT service_code, nursing_unit_code, facility_id             FROM ip_nursing_unit            WHERE nursing_unit_code = NVL (NULL, nursing_unit_code)              AND facility_id = ?) a1,          (SELECT   q.facility_id, COUNT (*) tot_beds,                    NVL (r.service_code, 'X') service_code,                    q.nursing_unit_code               FROM ip_nursing_unit_bed q, ip_nurs_unit_for_service r              WHERE q.facility_id = ?                AND q.eff_status = 'E'                AND q.pseudo_bed_yn = 'N'                AND q.nursing_unit_code = NVL (NULL, q.nursing_unit_code)                AND TRUNC (q.added_date) <= TRUNC (TO_DATE (?, 'dd/mm/yyyy'))                AND q.nursing_unit_code = r.nursing_unit_code                AND q.facility_id = r.facility_id           GROUP BY q.facility_id, r.service_code, q.nursing_unit_code) b,          (SELECT   facility_id, COUNT (*) start_of_day,                    NVL (service_code, 'X') service_code, nursing_unit_code,                    SUM (CASE                            WHEN sex = 'M'                               THEN 1                            ELSE 0                         END) male, SUM (CASE                                            WHEN sex = 'F'                                               THEN 1                                            ELSE 0                                         END) female,                    SUM (CASE                            WHEN sex = 'U'                               THEN 1                            ELSE 0                         END) unknown               FROM (SELECT facility_id, encounter_id, trn_type,                            to_nursing_unit nursing_unit_code, to_bed_no, sex,                            to_service_code service_code,                            trn_date_time from_date, trn_to_date_time end_date                       FROM ip_adt_trn_census_vw x, mp_patient y                      WHERE facility_id = ?                        AND trn_type != 'R'                        AND adt_status != '09'                        AND x.patient_id = y.patient_id                        AND y.sex IN ('M', 'F', 'U')                        AND trn_date_time <= TRUNC (TO_DATE (?, 'DD/MM/YYYY'))                        AND (   trn_to_date_time >=                                              TRUNC (TO_DATE (?, 'DD/MM/YYYY'))                             OR trn_to_date_time IS NULL                            )                        AND (   discharge_date_time >=                                              TRUNC (TO_DATE (?, 'DD/MM/YYYY'))                             OR discharge_date_time IS NULL                            ))              WHERE TRUNC (from_date) <= TRUNC (TO_DATE (?, 'DD/MM/YYYY'))                AND (   TRUNC (end_date) >= TRUNC (TO_DATE (?, 'DD/MM/YYYY'))                     OR end_date IS NULL                    )                AND trn_type IN ('A', 'T', 'L')                AND to_bed_no IS NOT NULL                AND nursing_unit_code = NVL (NULL, nursing_unit_code)           GROUP BY facility_id, service_code, nursing_unit_code) c,          (SELECT   facility_id, to_nursing_unit nursing_unit_code,                    COUNT (*) tot_adm, NVL (to_service_code, 'X') service_code,                    SUM                       (CASE                           WHEN MONTHS_BETWEEN (x.admission_date_time,                                                z.date_of_birth                                               ) > 144                           AND z.sex = 'M'                              THEN 1                           ELSE 0                        END                       ) a_male,                    SUM                       (CASE                           WHEN MONTHS_BETWEEN (x.admission_date_time,                                                z.date_of_birth                                               ) > 144                           AND z.sex = 'F'                              THEN 1                           ELSE 0                        END                       ) a_female,                    SUM                       (CASE                           WHEN MONTHS_BETWEEN (x.admission_date_time,                                                z.date_of_birth                                               ) > 144                           AND z.sex = 'U'                              THEN 1                           ELSE 0                        END                       ) a_unknown,                    SUM                       (CASE                           WHEN (MONTHS_BETWEEN (x.admission_date_time,                                                 z.date_of_birth                                                ) BETWEEN 12 AND 144                                )                           AND z.sex = 'M'                              THEN 1                           ELSE 0                        END                       ) c_male,                    SUM                       (CASE                           WHEN (MONTHS_BETWEEN (x.admission_date_time,                                                 z.date_of_birth                                                ) BETWEEN 12 AND 144                                )                           AND z.sex = 'F'                              THEN 1                           ELSE 0                        END                       ) c_female,                    SUM                       (CASE                           WHEN (MONTHS_BETWEEN (x.admission_date_time,                                                 z.date_of_birth                                                ) BETWEEN 12 AND 144                                )                           AND z.sex = 'U'                              THEN 1                           ELSE 0                        END                       ) c_unknown,                    SUM                       (CASE                           WHEN MONTHS_BETWEEN (x.admission_date_time,                                                z.date_of_birth                                               ) < 12                           AND z.sex = 'M'                              THEN 1                           ELSE 0                        END                       ) b_male,                    SUM                       (CASE                           WHEN MONTHS_BETWEEN (x.admission_date_time,                                                z.date_of_birth                                               ) < 12                           AND z.sex = 'F'                              THEN 1                           ELSE 0                        END                       ) b_female,                    SUM                       (CASE                           WHEN MONTHS_BETWEEN (x.admission_date_time,                                                z.date_of_birth                                               ) < 12                           AND z.sex = 'U'                              THEN 1                           ELSE 0                        END                       ) b_unknown               FROM ip_adt_trn_census_vw x, mp_patient z              WHERE facility_id = ?                AND trn_type = 'A'                AND x.patient_id = z.patient_id                AND z.sex IN ('M', 'F', 'U')                AND adt_status != '09'                AND to_nursing_unit = NVL (NULL, to_nursing_unit)                AND to_bed_no IS NOT NULL                AND trn_date_time BETWEEN TRUNC (TO_DATE (?, 'DD/MM/YYYY'))                                      AND   TRUNC (TO_DATE (?, 'DD/MM/YYYY'))                                          + 0.99999           GROUP BY facility_id, to_nursing_unit, to_service_code) d,          (SELECT   facility_id, COUNT (*) trans_in,                    NVL (to_service_code, 'X') service_code,                    to_nursing_unit nursing_unit_code,                    SUM (CASE                            WHEN z.sex = 'M'                               THEN 1                            ELSE 0                         END) m_trans_in,                    SUM (CASE                            WHEN z.sex = 'F'                               THEN 1                            ELSE 0                         END) f_trans_in,                    SUM (CASE                            WHEN z.sex = 'U'                               THEN 1                            ELSE 0                         END) u_trans_in               FROM ip_adt_trn_census_vw x, mp_patient z              WHERE facility_id = ?                AND x.patient_id = z.patient_id                AND z.sex IN ('M', 'F', 'U')                AND trn_type = 'T'                AND to_nursing_unit = NVL (NULL, to_nursing_unit)                AND fr_nursing_unit_code != to_nursing_unit                AND to_nursing_unit = NVL (NULL, to_nursing_unit)                AND adt_status != '09'                AND trn_date_time BETWEEN TRUNC (TO_DATE (?, 'DD/MM/YYYY'))                                      AND   TRUNC (TO_DATE (?, 'DD/MM/YYYY'))                                          + 0.99999           GROUP BY facility_id, to_nursing_unit, to_service_code) e,          (SELECT   facility_id, COUNT (*) trans_out,                    NVL (fr_service_code, 'X') service_code,                    fr_nursing_unit_code nursing_unit_code,                    SUM (CASE                            WHEN z.sex = 'M'                               THEN 1                            ELSE 0                         END) m_trans_out,                    SUM (CASE                            WHEN z.sex = 'F'                               THEN 1                            ELSE 0                         END) f_trans_out,                    SUM (CASE                            WHEN z.sex = 'U'                               THEN 1                            ELSE 0                         END) u_trans_out               FROM ip_adt_trn_census_vw x, mp_patient z              WHERE facility_id = ?                AND trn_type = 'T'                AND fr_nursing_unit_code = NVL (NULL, fr_nursing_unit_code)                AND x.patient_id = z.patient_id                AND z.sex IN ('M', 'F', 'U')                AND to_nursing_unit != fr_nursing_unit_code                AND fr_nursing_unit_code = NVL (NULL, fr_nursing_unit_code)                AND adt_status != '09'                AND trn_date_time BETWEEN TRUNC (TO_DATE (?, 'DD/MM/YYYY'))                                      AND   TRUNC (TO_DATE (?, 'DD/MM/YYYY'))                                          + 0.99999           GROUP BY facility_id, fr_nursing_unit_code, fr_service_code) f,          (SELECT   facility_id, COUNT (*) tot_dis,                    NVL (fr_service_code, 'X') service_code,                    fr_nursing_unit_code nursing_unit_code,                    SUM (CASE                            WHEN z.sex = 'M'                               THEN 1                            ELSE 0                         END) male_discharge,                    SUM (CASE                            WHEN z.sex = 'F'                               THEN 1                            ELSE 0                         END) female_discharge,                    SUM (CASE                            WHEN z.sex = 'U'                               THEN 1                            ELSE 0                         END) unknown_discharge,                    SUM (DECODE (y.deceased_yn, 'Y', 1, 0)) tot_death,                    SUM (CASE                            WHEN INDICATOR = 'ND' AND sex = 'M'                               THEN 1                            ELSE 0                         END                        ) m_home,                    SUM (CASE                            WHEN INDICATOR = 'ND' AND sex = 'F'                               THEN 1                            ELSE 0                         END                        ) f_home,                    SUM (CASE                            WHEN INDICATOR = 'ND' AND sex = 'U'                               THEN 1                            ELSE 0                         END                        ) u_home,                    SUM (CASE                            WHEN INDICATOR = 'DS' AND sex = 'M'                               THEN 1                            ELSE 0                         END                        ) m_deceased,                    SUM (CASE                            WHEN INDICATOR = 'DS' AND sex = 'F'                               THEN 1                            ELSE 0                         END                        ) f_deceased,                    SUM (CASE                            WHEN INDICATOR = 'DS' AND sex = 'U'                               THEN 1                            ELSE 0                         END                        ) u_deceased,                    SUM (CASE                            WHEN INDICATOR = 'AB' AND sex = 'M'                               THEN 1                            ELSE 0                         END                        ) m_absc,                    SUM (CASE                            WHEN INDICATOR = 'AB' AND sex = 'F'                               THEN 1                            ELSE 0                         END                        ) f_absc,                    SUM (CASE                            WHEN INDICATOR = 'AB' AND sex = 'U'                               THEN 1                            ELSE 0                         END                        ) u_absc,                    SUM (CASE                            WHEN INDICATOR = 'AO' AND sex = 'M'                               THEN 1                            ELSE 0                         END                        ) m_aor,                    SUM (CASE                            WHEN INDICATOR = 'AO' AND sex = 'F'                               THEN 1                            ELSE 0                         END                        ) f_aor,                    SUM (CASE                            WHEN INDICATOR = 'AO' AND sex = 'U'                               THEN 1                            ELSE 0                         END                        ) u_aor,                    SUM (CASE                            WHEN INDICATOR = 'ED' AND sex = 'M'                               THEN 1                            ELSE 0                         END                        ) m_tf,                    SUM (CASE                            WHEN INDICATOR = 'ED' AND sex = 'F'                               THEN 1                            ELSE 0                         END                        ) f_tf,                    SUM (CASE                            WHEN INDICATOR = 'ED' AND sex = 'U'                               THEN 1                            ELSE 0                         END                        ) u_tf,                    SUM (DECODE (TRUNC (admission_date_time),                                 TRUNC (trn_date_time), 1,                                 0                                )                        ) tot_one_day_stay,                    SUM                       (CASE                           WHEN (  TRUNC (admission_date_time)                                 - TRUNC (trn_date_time)                                ) = 0                           AND sex = 'M'                              THEN 1                           ELSE 0                        END                       ) m_one_day_stay,                    SUM                       (CASE                           WHEN (  TRUNC (admission_date_time)                                 - TRUNC (trn_date_time)                                ) = 0                           AND sex = 'F'                              THEN 1                           ELSE 0                        END                       ) f_one_day_stay,                    SUM                       (CASE                           WHEN (  TRUNC (admission_date_time)                                 - TRUNC (trn_date_time)                                ) = 0                           AND sex = 'U'                              THEN 1                           ELSE 0                        END                       ) u_one_day_stay               FROM ip_adt_trn_census_vw x, ip_discharge_type y, mp_patient z              WHERE facility_id = ?                AND trn_type = 'D'                AND fr_nursing_unit_code = NVL (NULL, fr_nursing_unit_code)                AND x.patient_id = z.patient_id                AND z.sex IN ('M', 'F', 'U')                AND adt_status != '09'                AND INDICATOR IN ('ND', 'DS', 'AB', 'AO', 'ED')                AND trn_date_time BETWEEN TRUNC (TO_DATE (?, 'DD/MM/YYYY'))                                      AND   TRUNC (TO_DATE (?, 'DD/MM/YYYY'))                                          + 0.99999                AND discharge_type_code = trn_code           GROUP BY facility_id, fr_nursing_unit_code, fr_service_code) g,          (SELECT   x.facility_id, to_nursing_unit nursing_unit_code,                    COUNT (*) trans_in, NVL (to_service_code,                                             'X') service_code,                    SUM (CASE                            WHEN z.sex = 'M'                               THEN 1                            ELSE 0                         END) m_intra_in,                    SUM (CASE                            WHEN z.sex = 'F'                               THEN 1                            ELSE 0                         END) f_intra_in,                    SUM (CASE                            WHEN z.sex = 'U'                               THEN 1                            ELSE 0                         END) u_intra_in, COUNT (*) tot_intra_in               FROM ip_adt_trn_census_vw x,                    mp_patient z,                    ip_nurs_unit_for_service y              WHERE x.facility_id = ?                AND x.patient_id = z.patient_id                AND z.sex IN ('M', 'F', 'U')                AND trn_type = 'T'                AND to_nursing_unit = NVL (NULL, to_nursing_unit)                AND fr_nursing_unit_code = to_nursing_unit                AND to_nursing_unit = y.nursing_unit_code                AND x.facility_id = y.facility_id                AND x.to_service_code != x.fr_service_code                AND x.to_service_code = y.service_code                AND adt_status != '09'                AND trn_date_time BETWEEN TRUNC (TO_DATE (?, 'DD/MM/YYYY'))                                      AND   TRUNC (TO_DATE (?, 'DD/MM/YYYY'))                                          + 0.99999           GROUP BY x.facility_id, to_nursing_unit, to_service_code) h,          (SELECT   x.facility_id, to_nursing_unit nursing_unit_code,                    COUNT (*) trans_in, NVL (fr_service_code,                                             'X') service_code,                    SUM (CASE                            WHEN z.sex = 'M'                               THEN 1                            ELSE 0                         END) m_intra_out,                    SUM (CASE                            WHEN z.sex = 'F'                               THEN 1                            ELSE 0                         END) f_intra_out,                    SUM (CASE                            WHEN z.sex = 'U'                               THEN 1                            ELSE 0                         END) u_intra_out, COUNT (*) tot_intra_out               FROM ip_adt_trn_census_vw x,                    mp_patient z,                    ip_nurs_unit_for_service y              WHERE x.facility_id = ?                AND x.patient_id = z.patient_id                AND z.sex IN ('M', 'F', 'U')                AND trn_type = 'T'                AND to_nursing_unit = NVL (NULL, to_nursing_unit)                AND fr_nursing_unit_code = to_nursing_unit                AND to_nursing_unit = y.nursing_unit_code                AND x.facility_id = y.facility_id                AND x.to_service_code != x.fr_service_code                AND x.to_service_code = y.service_code                AND adt_status != '09'                AND trn_date_time BETWEEN TRUNC (TO_DATE (?, 'DD/MM/YYYY'))                                      AND   TRUNC (TO_DATE (?, 'DD/MM/YYYY'))                                          + 0.99999           GROUP BY x.facility_id, to_nursing_unit, fr_service_code) i    WHERE a.facility_id = ?      AND a.nursing_unit_code = NVL (NULL, a.nursing_unit_code)      AND a.eff_status = 'E'      AND a.incl_for_hosp_occup_calc_yn = 'Y'      AND a1.service_code = a2.service_code      AND a1.facility_id = a.facility_id      AND a1.nursing_unit_code = a.nursing_unit_code      AND b.service_code(+) = a1.service_code      AND c.service_code(+) = a1.service_code      AND d.service_code(+) = a1.service_code      AND e.service_code(+) = a1.service_code      AND f.service_code(+) = a1.service_code      AND g.service_code(+) = a1.service_code      AND h.service_code(+) = a1.service_code      AND i.service_code(+) = a1.service_code      AND b.nursing_unit_code(+) = a1.nursing_unit_code      AND c.nursing_unit_code(+) = a1.nursing_unit_code      AND d.nursing_unit_code(+) = a1.nursing_unit_code      AND e.nursing_unit_code(+) = a1.nursing_unit_code      AND f.nursing_unit_code(+) = a1.nursing_unit_code      AND g.nursing_unit_code(+) = a1.nursing_unit_code      AND h.nursing_unit_code(+) = a1.nursing_unit_code      AND i.nursing_unit_code(+) = a1.nursing_unit_code ORDER BY nursing_unit_code, service_code";
			
			
			
				

				//System.out.println("67");
				pstmt =  con.prepareStatement(sqlQuery);
				//System.out.println(sqlQuery);

				pstmt.setString(1,facility_id);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,facility_id);
				pstmt.setString(4,start_date);
				pstmt.setString(5,facility_id);
				pstmt.setString(6,start_date);
				pstmt.setString(7,start_date);
				pstmt.setString(8,start_date);
				pstmt.setString(9,start_date);
				pstmt.setString(10,start_date);
				pstmt.setString(11,facility_id);
				pstmt.setString(12,start_date);
				pstmt.setString(13,start_date);
				pstmt.setString(14,facility_id);
				pstmt.setString(15,start_date);
				pstmt.setString(16,start_date);
				pstmt.setString(17,facility_id);
				pstmt.setString(18,start_date);
				pstmt.setString(19,start_date);
				pstmt.setString(20,facility_id);
				pstmt.setString(21,start_date);
				pstmt.setString(22,start_date);
				pstmt.setString(23,facility_id);
				pstmt.setString(24,start_date);
				pstmt.setString(25,start_date);
				pstmt.setString(26,facility_id);
				pstmt.setString(27,start_date);
				pstmt.setString(28,start_date);
				pstmt.setString(29,facility_id);

				
				rset = pstmt.executeQuery();


				String[]  arr_from_dt = from_date.split("/");
				String[]  arr_to_dt = to_date.split("/");

				String fl_name=filename+"_PD103";
				
				System.out.println("filename-->"+filename);

				from_date=arr_from_dt[2]+"-"+arr_from_dt[1]+"-"+arr_from_dt[0];
				to_date=arr_to_dt[2]+"-"+arr_to_dt[1]+"-"+arr_to_dt[0];

				
				StringBuffer str_head=new StringBuffer("");
				str_head.append("{\"filename\": \""+fl_name+"\",\"refServiceTypeCode\": \""+refServiceTypeCode+"\",\"formType\": \"103\",\"facilityCode\": \""+mapped_fac_id+"\",");
				str_head.append("\"censusDateFrom\": \""+from_date+"\",\"censusDateTo\": \""+to_date+"\",\"dailyWardCensus\": [");
			

				StringBuffer str_foot=new StringBuffer("");
				
				String ward_code="";
				String speclty_code="";
				//boolean append=false;

				int i=0;
				//int no_of_babies=1;

				StringBuffer gener_ward= new StringBuffer("");
				StringBuffer gener_ward_hdr= new StringBuffer("");
				StringBuffer ward_hdr= new StringBuffer("");

				int overnightMale=0;
				int overnightFeMale=0;
				int overnightAmbiguous=0;
				StringBuffer discharges= new StringBuffer("");
				String old_ward_cd="";

				 while(rset!=null && rset.next()) 	{  	 // looping each ward /speciality stats

					
					//speclty_code=checkForNull(rset.getString("SERVICE_CODE"));


					//System.out.println("(rset.getString NURSING_UNIT_CODE-->"+rset.getString("NURSING_UNIT_CODE"));
					//System.out.println("old_ward_cd-->"+old_ward_cd);
					//if( i>0){						
						//System.out.println("i value -->"+ i);
						//ward_hdr.append(",");					
					//}
					
					if (!ward_code.equals(rset.getString("NURSING_UNIT_CODE"))){

						ward_code=checkForNull(rset.getString("NURSING_UNIT_CODE"));

						if(!old_ward_cd.equals("")){
							if(!old_ward_cd.equals(ward_code)){
											
								//str_head.append(ward_hdr.toString());
								
								gener_ward_hdr.append(gener_ward.toString());
								ward_hdr.append(gener_ward_hdr.toString());
								ward_hdr.append(discharges.toString());
								ward_hdr.append(" },");
								str_head.append(ward_hdr.toString());
								//str_head.append(discharges.toString());
								
								ward_hdr=new StringBuffer("");
								gener_ward_hdr=new StringBuffer("");
								gener_ward=new StringBuffer("");
								discharges=new StringBuffer("");
								

							}else{
								old_ward_cd=ward_code;
								gener_ward.append(gener_ward.toString());
							}
						}else{
							old_ward_cd=ward_code;
						}

						ward_hdr.append("{ \"wardCode\": \""+ward_code+"\",\"dateForCensus\": \""+from_date+"\" ,");
						speclty_code="";
						
						discharges= new StringBuffer("");
						discharges.append("] ,\"discharges\": [	");
						pstmt_1 =  con.prepareStatement("SELECT  encounter_id,to_char(VISIT_ADM_DATE_TIME,'yyyy-mm-dd HH24:mi:ss') admn_date,substr(TRANSLATE(adt_status_set_reason,' '|| chr(10)||chr(13),' '),0,150) disch_remarks,PATIENT_NAME from pr_encounter_vw where patient_class='IP' and trunc(DISCHARGE_DATE_TIME)=to_date(?,'dd/mm/yyyy') and ASSIGN_CARE_LOCN_CODE=? ");

						//System.out.println(start_date);
						//System.out.println(ward_code);

						pstmt_1.setString(1,start_date);
						pstmt_1.setString(2,ward_code);

						rset_1 = pstmt_1.executeQuery();

						int k=0;

						 while(rset_1!=null && rset_1.next()) 	{ 
							 if(k>0){
								 discharges.append(",");
							 }
							discharges.append("{");
							discharges.append("\"admissionDate\": \""+checkForNull(rset_1.getString("admn_date"))+"\",");
							discharges.append("\"rn\": \""+checkForNull(rset_1.getString("encounter_id"))+"\",");
							discharges.append("\"name\": \""+checkForNull(rset_1.getString("PATIENT_NAME"))+"\",");
							discharges.append("\"remark\": \""+checkForNull(rset_1.getString("disch_remarks"))+"\"");
							discharges.append("}");
							k++;
						 }

						 discharges.append("]");

						if (rset_1 !=null )			{
							rset_1.close();
						}
						if (pstmt_1 !=null )			{
							pstmt_1.close();
						}

						


					}
					
					

					if (! speclty_code.equals(rset.getString("SERVICE_CODE"))){
						if (speclty_code.equals("")){
							gener_ward_hdr.append("\"generals\": [	");							
						}else{
							gener_ward.append(",	");
						}
						speclty_code=checkForNull(rset.getString("SERVICE_CODE"));
										
					}

					

					gener_ward.append("{ \"refSpecialityCode\": \""+checkForNull(rset.getString("map_SP_CD"))+"\",");
					gener_ward.append("\"carryForwardMale\": \""+checkForNull(rset.getString("START_OF_DAY_MALE"))+"\",");
					gener_ward.append("\"carryForwardFemale\": \""+checkForNull(rset.getString("START_OF_DAY_FEMALE"))+"\",");
					gener_ward.append("\"carryForwardAmbiguous\": \""+checkForNull(rset.getString("START_OF_DAY_UNKNOWN"))+"\",");
					gener_ward.append("\"admissionAdultMale\": \""+checkForNull(rset.getString("A_MALE"))+"\",");
					gener_ward.append("\"admissionAdultFemale\": \""+checkForNull(rset.getString("A_FEMALE"))+"\",");
					gener_ward.append("\"admissionAdultAmbiguous\": \""+checkForNull(rset.getString("A_UNKNOWN"))+"\",");
					gener_ward.append("\"admissionChildMale\": \""+checkForNull(rset.getString("C_MALE"))+"\",");
					gener_ward.append("\"admissionChildFemale\": \""+checkForNull(rset.getString("C_FEMALE"))+"\",");
					gener_ward.append("\"admissionChildAmbiguous\": \""+checkForNull(rset.getString("C_UNKNOWN"))+"\",");
					gener_ward.append("\"admissionInfantMale\": \""+checkForNull(rset.getString("B_MALE"))+"\",");
					gener_ward.append("\"admissionInfantFemale\": \""+checkForNull(rset.getString("B_FEMALE"))+"\",");
					gener_ward.append("\"admissionInfantAmbiguous\": \""+checkForNull(rset.getString("B_UNKNOWN"))+"\",");
					gener_ward.append("\"otherWardTransferInMale\": \""+checkForNull(rset.getString("M_TRANS_IN"))+"\",");
					gener_ward.append("\"otherWardTransferInFemale\": \""+checkForNull(rset.getString("F_TRANS_IN"))+"\",");
					gener_ward.append("\"otherWardTransferInAmbiguous\": \""+checkForNull(rset.getString("U_TRANS_IN"))+"\",");
					gener_ward.append("\"sameWardTransferInMale\": \""+checkForNull(rset.getString("M_INTRA_IN"))+"\",");
					gener_ward.append("\"sameWardTransferInFemale\": \""+checkForNull(rset.getString("F_INTRA_IN"))+"\",");
					gener_ward.append("\"sameWardTransferInAmbiguous\": \""+checkForNull(rset.getString("U_INTRA_IN"))+"\",");
					gener_ward.append("\"dischargeHomeMale\": \""+checkForNull(rset.getString("M_HOME"))+"\",");
					gener_ward.append("\"dischargeHomeFemale\": \""+checkForNull(rset.getString("F_HOME"))+"\",");
					gener_ward.append("\"dischargeHomeAmbiguous\": \""+checkForNull(rset.getString("U_HOME"))+"\",");
					gener_ward.append("\"dischargeDeceasedMale\": \""+checkForNull(rset.getString("M_DECEASED"))+"\",");
					gener_ward.append("\"dischargeDeceasedFemale\": \""+checkForNull(rset.getString("F_DECEASED"))+"\",");
					gener_ward.append("\"dischargeDeceasedAmbiguous\": \""+checkForNull(rset.getString("U_DECEASED"))+"\",");
					gener_ward.append("\"dischargeAbscondedMale\": \""+checkForNull(rset.getString("M_ABSC"))+"\",");
					gener_ward.append("\"dischargeAbscondedFemale\": \""+checkForNull(rset.getString("F_ABCS"))+"\",");
					gener_ward.append("\"dischargeAbscondedAmbiguous\": \""+checkForNull(rset.getString("U_ABCS"))+"\",");
					gener_ward.append("\"dischargeAgainstMaMale\": \""+checkForNull(rset.getString("M_AOR"))+"\",");
					gener_ward.append("\"dischargeAgainstMaFemale\": \""+checkForNull(rset.getString("F_AOR"))+"\",");
					gener_ward.append("\"dischargeAgainstMaAmbiguous\": \""+checkForNull(rset.getString("U_AOR"))+"\",");
					gener_ward.append("\"dischargeChangeHospitalMale\": \""+checkForNull(rset.getString("M_TF"))+"\",");
					gener_ward.append("\"dischargeChangeHospitalFemale\": \""+checkForNull(rset.getString("F_TF"))+"\",");
					gener_ward.append("\"dischargeChangeHospitalAmbiguous\": \""+checkForNull(rset.getString("U_TF"))+"\",");
					gener_ward.append("\"transferOutOtherWardMale\": \""+checkForNull(rset.getString("M_TRANS_OUT"))+"\",");
					gener_ward.append("\"transferOutOtherWardFemale\": \""+checkForNull(rset.getString("F_TRANS_OUT"))+"\",");
					gener_ward.append("\"transferOutOtherWardAmbiguous\": \""+checkForNull(rset.getString("U_TRANS_OUT"))+"\",");
					gener_ward.append("\"transferOutSameWardMale\": \""+checkForNull(rset.getString("M_INTRA_OUT"))+"\",");
					gener_ward.append("\"transferOutSameWardFemale\": \""+checkForNull(rset.getString("F_INTRA_OUT"))+"\",");
					gener_ward.append("\"transferOutSameWardAmbiguous\": \""+checkForNull(rset.getString("U_INTRA_OUT"))+"\",");
					gener_ward.append("\"oneDayAdmissionMale\": \""+checkForNull(rset.getString("M_ONE_DAY_STAY"))+"\",");
					gener_ward.append("\"oneDayAdmissionFemale\": \""+checkForNull(rset.getString("F_ONE_DAY_STAY"))+"\",");
					gener_ward.append("\"oneDayAdmissionAmbiguous\": \""+checkForNull(rset.getString("U_ONE_DAY_STAY"))+"\",");

					StringBuffer overnights= new StringBuffer("");

                    overnights.append("\"overnights\": [");
                     pstmt_2 =  con.prepareStatement("select MR_PD103_OVRNT(?,?,?,?) OVRNT from dual");

						//System.out.println(start_date);
						//System.out.println(ward_code);

						pstmt_2.setString(1,facility_id);
						pstmt_2.setString(2,ward_code);
						pstmt_2.setString(3,rset.getString("SERVICE_CODE"));
						pstmt_2.setString(4,start_date);

						rset_2 = pstmt_2.executeQuery();
						
						while(rset_2!=null && rset_2.next()) 	{ 
						int ijk=0;
							StringTokenizer str_tok1=new StringTokenizer(checkForNull(rset_2.getString("OVRNT")),"&" );
							
							while (str_tok1.hasMoreTokens()){
								StringTokenizer str_tok2= new StringTokenizer(str_tok1.nextToken(),"*" );

								if(ijk>0){
										overnights.append(",");
								}
					
								while (str_tok2.hasMoreTokens()){								
									overnights.append("{\"refWardClassCode\": \""+str_tok2.nextToken()+"\",");
									overnights.append("\"overnightMale\": \""+str_tok2.nextToken()+"\",");
									overnights.append("\"overnightFemale\": \""+str_tok2.nextToken()+"\",");
									overnights.append("\"overnightAmbiguous\": \""+str_tok2.nextToken()+"\"}");					
								}
								ijk++;
							}
						}

			

						if (rset_2 !=null )			{
							rset_2.close();
						}
						if (pstmt_2 !=null )			{
							pstmt_2.close();
						}
					
					overnights.append("]");

					gener_ward.append (overnights.toString());

					gener_ward.append("}");
					
					
								

					i++;
				 }// while loop for encounter 

				 
				str_head.append(ward_hdr.toString());
				gener_ward_hdr.append(gener_ward.toString());
				str_head.append(gener_ward_hdr.toString());
				str_head.append(discharges.toString());
			 

				str_foot.append(" 	} ]	}");

				str_head.append(str_foot.toString());

				filename=filename+"_PD103.json";
				System.out.println(str_head.toString());

				if(i>0){
				
					try{
						
						System.out.println("dir-->"+dir);
						//FileWriter file = new FileWriter(dir+"\\"+filename+"_PD103.json");/*File is Created with Json object as data in specific folder*/
						
						System.out.println("filename-->"+filename);
						dir=dir+filename;
						System.out.println("dir-->"+dir);
						File PD103json = new File (dir);
						FileWriter file = new FileWriter(PD103json);/*File is Created with Json object as data in specific folder*/
						System.out.println("PD103json.getPath()-->"+PD103json.getPath());
						System.out.println("PD103json.getAbsolutePath()-->"+PD103json.getAbsolutePath());
						System.out.println("PD103json.getName()-->"+PD103json.getName());

						
						//str_head.append(str_foot.toString());

						System.out.println(str_head.toString());
						file.write(str_head.toString());
						fileCreated="1";
						System.out.println("fileCreated@746-->"+fileCreated);
						smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"PD103",PD103json.getAbsolutePath());
						file.flush();
						file.close();

						if(dir.equals("")){
							fileCreated="2";
							 System.out.println("Error while file obj  PD103 generation. No dir path-->"+filename);
							 smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"PD103","File creation path is not defined");
						}

					} catch (IOException e) {
						fileCreated="2";
						System.err.println("Exception in createPD103 function Inside try:"+e.toString());
						System.out.println("Error while file obj  PD103 generation-->"+filename+"-->"+e.toString());
						smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"PD103","IO Error. Unable to create File for PD103 generation");
						e.printStackTrace();
					}
				}else{ // no data for file generation
					System.out.println("No data for PD103 generation-->"+filename);
					fileCreated="0";
					smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"PD103","No data for PD103 generation");
				}
				
			}	 //check in function control				
		
		}catch (Exception e) {
			  System.err.println("Exception in createPD103 function outside try:"+e.toString());
			  smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"PD103",e.toString());
			  fileCreated="0";
			  e.printStackTrace();
		}finally{
			try{
				if (rset_1 !=null )			{
				rset_1.close();
				}
				if (pstmt_1 !=null )			{
					pstmt_1.close();
				}
				
				if (rset !=null )			{
					rset.close();
				}
				
				if (pstmt !=null )			{
					pstmt.close();
				}

				if (stmt !=null )			{
					stmt.close();
				}

				if (rset_2 !=null )			{
					rset_2.close();
				}
				if (pstmt_2 !=null )			{
					pstmt_2.close();
				}

				
				ConnectionManager.returnConnection(con);
			}catch(Exception ex){
			}
		}

		return fileCreated;
	}

	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	


public static class JobSchedulePD103 extends TimerTask {

 /*The main method will be invoked when Server is Started*/
  public  void main (String... arguments ) {
    TimerTask JobSchedulePD103 = new JobSchedulePD103();
   
    Timer timer = new Timer();
    /*After main mehtod is invoked, it will check for the time at which the run method has to be invoked */

	Connection con = null;
	ResultSet rset = null;
	Statement stmt =  null;
	int hr=0;
	int mn=0;
    
    con =   ConnectionManager.getConnection();
		
		try {
			stmt =  con.createStatement();
		
		/*for all the facility the job will run, if the facility has data it will create the Json file for that else it will not create file*/
		rset =  stmt.executeQuery("select nvl(to_char(LAG_TIME,'HH24'),'00') hr,nvl(to_char(LAG_TIME,'mi'),'00') min from MR_SMRP_CONFIG where SMRP_ID='PD103'");
		String hr_lag = "00";
		String min_lag = "00";
		if(rset!=null && rset.next()){
			hr_lag = rset.getString("hr");
			min_lag = rset.getString("min");
			hr=Integer.parseInt(hr_lag);  
			mn=Integer.parseInt(min_lag);
		}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			try {
				rset.close();
				stmt.close();
				ConnectionManager.returnConnection(con);
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}
    timer.scheduleAtFixedRate(JobSchedulePD103, getTomorrowMorning12am(hr,mn), fONCE_PER_DAY);
  }
  
  @Override public void run(){
    	
try
		{
    	Connection con = null;
		ResultSet rset = null;
		Statement stmt =  null;
		
    GeneratePD103 Gjson= new GeneratePD103();
    con =   ConnectionManager.getConnection();
		
		stmt =  con.createStatement();
		/*for all the facility the job will run, if the facility has data it will create the Json file for that else it will not create file*/
		rset =  stmt.executeQuery("select facility_id from sm_facility_param  where facility_id!='DF' and STATUS='E'	");
 while(rset!=null && rset.next())
		{  	
	
    Gjson.createPD103(rset.getString("facility_id"),"","");
    
}
		rset.close();
		stmt.close();
		ConnectionManager.returnConnection(con);
}
		catch (Exception e)	
		{
			  System.err.println("Exception in run method of JobSchedulePD103 Class:::"+e.toString());
			  e.printStackTrace();
		}
  }
  

	 private final static long fONCE_PER_DAY = 1000*60*60*24;
	 // private final static long fONCE_PER_DAY = 1000*60*60;

	  private final static int fONE_DAY = 1;
	  private final static int fZEROHOUR = 01;
	  private final static int fZERO_MINUTES = 45; 

	/*The function will retutn the time at which the process has to be run*/
	 // private  Date getTomorrowMorning12am(){
		 private  Date getTomorrowMorning12am(int fZEROHOUR,int fZERO_MINUTES){
		Calendar tomorrow = new GregorianCalendar();
		tomorrow.add(Calendar.DATE, fONE_DAY);
		Calendar result = new GregorianCalendar(
		  tomorrow.get(Calendar.YEAR),
		  tomorrow.get(Calendar.MONTH),
		  tomorrow.get(Calendar.DATE),
		  fZEROHOUR,
		  fZERO_MINUTES
		);
		return result.getTime(); 
	  }
}


	
	
	
}