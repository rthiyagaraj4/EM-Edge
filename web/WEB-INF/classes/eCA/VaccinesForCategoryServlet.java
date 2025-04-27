/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.*;
import eCA.VaccineForCategoryBean;

public class VaccinesForCategoryServlet extends javax.servlet.http.HttpServlet	{

	String client_ip_addr ="";
	String facilityId ="";
	String addedId ="";


/**
*	init	-	will initialise the servlet
*	@param	config - this is ServletConfig
*/
public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
/**
*	doPost	-	will be called when the method is of post
*	@param	req - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/
public  void doPost(HttpServletRequest req, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = req.getSession(false);

		PrintWriter out = null;
		Connection con = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		int arrayLength=0;
		String categoryId = "";
		String errorMsg = "";
		Hashtable tabdata = new Hashtable();
		Properties p;

		try
		{

			con = ConnectionManager.getConnection(req);
			out = response.getWriter();

			arrayLength = Integer.parseInt(req.getParameter("array_length"));

			if(arrayLength != 0)
			{

				insertModify(req,response,arrayLength,con);
			}
			else
			{   p = (java.util.Properties)session.getValue( "jdbc" ) ;
		        String locale = (String) p.getProperty("LOCALE");
				categoryId = req.getParameter("categoryId") == null ? "" : req.getParameter("categoryId");
				ps1 = con.prepareStatement("delete from CA_IM_VAC_FOR_CATEG where VACC_CATEG_ID = ? ");
				ps1.setString(1,categoryId);
				ps1.executeUpdate();
				tabdata = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
				errorMsg= (String) tabdata.get("message");
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg,"UTF-8")+"&err_value=1");

			}
			if(rs1 != null) rs1.close();
			if(ps1 != null) ps1.close();
		}
		catch(Exception ee)
			{
				//out.println("Exception raise by Vaccines For Category Servlet ...So Record Not inserted  : "+ee.toString());//common-icn-0181
				ee.printStackTrace();
			}
			finally
			{

					if(con != null) ConnectionManager.returnConnection(con);

			}

	}
/**
*	insertModify	-	will be called when the Modification of Data is to be Done
*	@param	req - this is HttpServletreq
*	@param	response - this is HttpServletResponse
*	@param
*	throws javax.servlet.ServletException,IOException
*/
	public void insertModify(HttpServletRequest req,HttpServletResponse response,int arrayLength,Connection con)
	{

		PrintWriter out = null;
		HttpSession session = req.getSession(false);
		Properties p;
		Hashtable tabdata = new Hashtable();
		PreparedStatement ps = null;
		PreparedStatement psUpdate = null,psDurDelete= null,psDurupdate=null;
		PreparedStatement psInsert = null,psDurInsert=null,psDurSelect;
		//Connection con = null;
		ResultSet rs = null,rsDuration=null;

		String errorMsg = "";
		String seq_num[] = new String[arrayLength];
		String vaccineCode[] =  new String[arrayLength];

		String num_of_doses[] =  new String[arrayLength];
		String default_site_name[] =  new String[arrayLength];
		String mandatoryYN[] =  new String[arrayLength];
		String prvAdmYN[] =  new String[arrayLength];
		String chk_dup_days[] =  new String[arrayLength];
		String chk_prv_action[] =  new String[arrayLength];
		String duration_s[] =  new String[arrayLength];
		String duration_type_s[] =  new String[arrayLength];
		String sqlDuration1 = "";
		String sqlUpdDuration1 = "";
		String sqlSelDuration1 = "";
		String sqlDelDuration1 = "";


		String freq_duration = req.getParameter("freq_duration_temp") == null ? "" : req.getParameter("freq_duration_temp");
		String adhocAgeSpecYN = req.getParameter("adhocAgeSpecYN") == null ? "" : req.getParameter("adhocAgeSpecYN");

		String sqlInsert = "";
	//	String sqlInsert1 = "";
		String sqlUpdate = "";

		String remove_value =  req.getParameter("remove_value")==null ? "" :req.getParameter("remove_value");
		VaccineForCategoryBean bean= new VaccineForCategoryBean();
		String categoryId = "";
		int rowCount =0;
		String sqlSelect = "";
		int index = 0;
		//int maxRecord = 0;
		long seqNo=0;
		int count =0;
		int rows=0;
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_addr=	p.getProperty("client_ip_address");
		addedId =  (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		for(index = 0;index < arrayLength;index++)
		{
			seq_num[index] = req.getParameter("seq_num"+index);
			vaccineCode[index] =  req.getParameter("vaccineCode"+index);
			num_of_doses[index]=  req.getParameter("num_of_doses"+index);
			default_site_name[index]=  req.getParameter("default_site_name"+index);

			mandatoryYN[index]=  req.getParameter("mandatoryYN"+index) == null ? "N" :req.getParameter("mandatoryYN"+index);

			prvAdmYN[index]=  req.getParameter("prvAdmYN"+index) == null ? "N" :req.getParameter("prvAdmYN"+index);

			chk_dup_days[index]=  req.getParameter("chk_dup_days"+index);
			chk_prv_action[index]=  req.getParameter("chk_prv_action"+index);

			duration_s[index] =  req.getParameter("duration_s"+index) == null ? "0" :req.getParameter("duration_s"+index).trim();
			

			duration_type_s[index] = req.getParameter("duration_type_s"+index) == null ? "" :req.getParameter("duration_type_s"+index).trim();
			


			/*Insert Code Here*/
		}
		try
		{
			out = response.getWriter();

			categoryId = req.getParameter("categoryId") == null ? "" : req.getParameter("categoryId");
			//con = ConnectionManager.getConnection(req);
			if(!remove_value.equals(""))
			{
			StringTokenizer token = new StringTokenizer(remove_value,"||");
			while(token.hasMoreTokens())
				{
					bean.deleteRow(token.nextToken(),con,categoryId,p);
				}
			}

			sqlInsert = "Insert into CA_IM_VAC_FOR_CATEG (VACC_CATEG_ID, VACCINE_ID, ORDER_SRL_NO,MANDATORY_YN,NO_OF_DOSE,DEFAULT_SITE_ID,CHECK_PREV_ADM_YN,PREV_CHECK_DAYS,PREV_CHECK_ACTION, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";

			sqlUpdate = "update CA_IM_VAC_FOR_CATEG set  ORDER_SRL_NO=?, MANDATORY_YN=?, NO_OF_DOSE=?, DEFAULT_SITE_ID=?, CHECK_PREV_ADM_YN=?, PREV_CHECK_DAYS=?, PREV_CHECK_ACTION=?, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where VACC_CATEG_ID= ? and  VACCINE_ID =?";

			sqlSelect = "select VACC_CATEG_ID, VACCINE_ID,ORDER_SRL_NO from CA_IM_VAC_FOR_CATEG where VACC_CATEG_ID=? and  VACCINE_ID=?";

			sqlDuration1 = "Insert into CA_IM_VAC_SCH_FOR_CATEG (VACC_CATEG_ID, VACCINE_ID, DOSE_NO,FREQ_DURATION,FREQ_DURATION_TYPE,MANDATORY_YN,DEFUALT_OPTION,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";

			sqlUpdDuration1 = "UPDATE CA_IM_VAC_SCH_FOR_CATEG SET FREQ_DURATION=?,FREQ_DURATION_TYPE=?,MANDATORY_YN=?,  MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE VACC_CATEG_ID=? AND VACCINE_ID=? ";

			sqlSelDuration1 = "SELECT COUNT(*) AS No_DOSES FROM CA_IM_VAC_SCH_FOR_CATEG WHERE VACC_CATEG_ID=? AND VACCINE_ID=? ";

			sqlDelDuration1 = "DELETE FROM CA_IM_VAC_SCH_FOR_CATEG WHERE VACC_CATEG_ID=? AND VACCINE_ID=? ";

			psUpdate = con.prepareStatement(sqlUpdate);
			psInsert = con.prepareStatement(sqlInsert);

			psDurDelete = con.prepareStatement(sqlDelDuration1);
			psDurInsert = con.prepareStatement(sqlDuration1);
			psDurSelect = con.prepareStatement(sqlSelDuration1);
			psDurupdate = con.prepareStatement(sqlUpdDuration1);





			for(rowCount = 0 ; rowCount < arrayLength;rowCount ++)
			{
				count = 0;
				ps = con.prepareStatement(sqlSelect);
				ps.setString(1,categoryId);
				ps.setString(2,vaccineCode[rowCount]);
				rs = ps.executeQuery();
				while(rs.next())
				{
					seqNo = Long.parseLong(rs.getString("ORDER_SRL_NO"));
					count ++;
				}

				if(count !=0)
				{
					psUpdate.setLong(1,Long.parseLong(seq_num[rowCount]));
					psUpdate.setString(2,mandatoryYN[rowCount]);
					psUpdate.setString(3,num_of_doses[rowCount]);
					psUpdate.setString(4,default_site_name[rowCount]);
					psUpdate.setString(5,prvAdmYN[rowCount]);
					psUpdate.setString(6,chk_dup_days[rowCount]);
					psUpdate.setString(7,chk_prv_action[rowCount]);
					psUpdate.setString(8,addedId);
					psUpdate.setString(9,client_ip_addr);
					psUpdate.setString(10,facilityId);
					psUpdate.setString(11,categoryId);
					psUpdate.setString(12,vaccineCode[rowCount]);
					rows =  psUpdate.executeUpdate();
				}
				else
				{

					psInsert.setString(1,categoryId);
					psInsert.setString(2,vaccineCode[rowCount]);
					psInsert.setLong(3,Long.parseLong(seq_num[rowCount]));
					psInsert.setString(4,mandatoryYN[rowCount]);
					psInsert.setString(5,num_of_doses[rowCount]);
					psInsert.setString(6,default_site_name[rowCount]);
					psInsert.setString(7,prvAdmYN[rowCount]);
					psInsert.setString(8,chk_dup_days[rowCount]);
					psInsert.setString(9,chk_prv_action[rowCount]);
					psInsert.setString(10,addedId);
					psInsert.setString(11,client_ip_addr);
					psInsert.setString(12,facilityId);
					psInsert.setString(13,addedId);
					psInsert.setString(14,client_ip_addr);
					psInsert.setString(15,facilityId);
					rows = rows + psInsert.executeUpdate();
				}
				if(rs != null) rs.close();
				if(ps != null) ps.close();

				int doses = 0, doseNo=1;

				psDurSelect.setString(1,categoryId);
				psDurSelect.setString(2,vaccineCode[rowCount]);
				rsDuration = psDurSelect.executeQuery();
				while(rsDuration.next())
				{
					doses = Integer.parseInt(rsDuration.getString("No_DOSES"));
				}
				if(rsDuration != null) rsDuration.close();

				if ((duration_s[rowCount].trim()).equals(""))
					{
						duration_s[rowCount] = "0";
					}

					if (doses >= 0 && Integer.parseInt(num_of_doses[rowCount]) == 1)
					{

							psDurDelete.setString(1,categoryId);
							psDurDelete.setString(2,vaccineCode[rowCount]);
							psDurDelete.execute();
							psDurInsert.setString(1,categoryId);
							psDurInsert.setString(2,vaccineCode[rowCount]);
							psDurInsert.setInt(3,doseNo);
							psDurInsert.setLong(4,Long.parseLong(duration_s[rowCount]));
							psDurInsert.setString(5,duration_type_s[rowCount]);
							psDurInsert.setString(6,mandatoryYN[rowCount]);
							psDurInsert.setString(7,"N");
							psDurInsert.setString(8,addedId);
							psDurInsert.setString(9,client_ip_addr);
							psDurInsert.setString(10,facilityId);
							psDurInsert.setString(11,addedId);
							psDurInsert.setString(12,client_ip_addr);
							psDurInsert.setString(13,facilityId);

							psDurInsert.executeUpdate();
					}
			}
			

			if (freq_duration != null && !freq_duration.equals(""))
			{
				insertFrequency(con,categoryId,freq_duration,out, adhocAgeSpecYN);

			}// if condition end

				con.commit();
				tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
				errorMsg= (String) tabdata.get("message");
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg,"UTF-8")+"&err_value=1");

				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(psUpdate != null)	psUpdate.close();
				if(psInsert != null)	psInsert.close();
				if(psDurDelete!= null)	psDurDelete.close();
				if(psDurInsert!= null)	psDurInsert.close();
				if(psDurSelect!= null)  psDurSelect.close();
				if(psDurupdate!= null)  psDurupdate.close();
		}
		catch(Exception ee)
		{
			try{
				con.rollback();
			}catch(Exception e){
				
				e.printStackTrace();
			}
			//out.println("Exception raise by Vaccines For Category Insert Modify Function Servlet ...So Record Not inserted  : "+ee.toString());//common-icn-0181
			ee.printStackTrace();
		}
		finally
		{
				try
			{
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(psUpdate != null)	 psUpdate.close();
				if(psInsert != null)	psInsert.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

				if(con != null) ConnectionManager.returnConnection(con);

		}

	}

	public void insertFrequency(Connection con,String categoryId,String inputString,PrintWriter out, String adhocAgeSpecYN)
	{
		
		String vaccine_id = "";
		String sqlDuration = "";
        String sqlDelDuration = "";

		StringTokenizer strTokens = null,strTokens1 = null,strTokens2=null,strTokens3=null;
		ArrayList orderList =  null;
		ArrayList durationList = null;
		ArrayList dTypeList = null;
		ArrayList mandatoryList = null;
		ArrayList defaultList = null;
		ArrayList vaccineList = new ArrayList();
		ArrayList vaccineDurList = new ArrayList();
		HashMap hashMap = new HashMap();
		ArrayList mstList = null;
		ArrayList mstList1 = null;
		/*
			added by kishore kumar N on 04/Nov/2009 for CRF 0691.1,
		*/
		ArrayList<String> dueBeforeLst = null;
		ArrayList<String> dueBeforeTypeLst = null;
		ArrayList<String> elapsedAfterLst = null;
		ArrayList<String> elapsedAfterTypeLst = null;
		ArrayList<String> yrsLst = null;
		ArrayList<String> monthsLst = null;
		ArrayList<String> daysLst = null;
		/* ends here. */

		PreparedStatement pstInsert = null,pstDelete=null;
       try
       {
		strTokens = new StringTokenizer(inputString,"$");
		
		

		if (strTokens.hasMoreTokens())
		{
			while (strTokens.hasMoreTokens())
			{
				strTokens2 = new StringTokenizer (strTokens.nextToken(),"!");
				while (strTokens2.hasMoreTokens())
				{

					vaccineDurList.add(strTokens2.nextToken());
					vaccineList.add(strTokens2.nextToken());
				}
			}
		 }else
		 {
			strTokens = new StringTokenizer(inputString,"!");
			
			
			/*orderList = new ArrayList();
			durationList = new ArrayList();
			dTypeList = new ArrayList();
			mandatoryList = new ArrayList();
			defaultList = new ArrayList();*/

			if (strTokens.hasMoreTokens())
			{
				/*while (strTokens.hasMoreTokens())
				{
					strTokens1 = new StringTokenizer(strTokens.nextToken(),"~");
					orderList.add(strTokens1.nextToken());
					durationList.add(strTokens1.nextToken());
					dTypeList.add(strTokens1.nextToken());
					mandatoryList.add(strTokens1.nextToken());
					defaultList.add(strTokens1.nextToken());
				}*/
					vaccineDurList.add(strTokens2.nextToken());
					vaccineList.add(strTokens2.nextToken());
			}

		  }
			
			
		 for (int j = 0;j<vaccineList.size();j++ )
		 {
			orderList = new ArrayList();
			durationList = new ArrayList();
			dTypeList = new ArrayList();
			mandatoryList = new ArrayList();
			defaultList = new ArrayList();
			mstList= new ArrayList();
			/*
				added by kishore kumar N on 04/Nov/2009 for CRF 0691.1,
			*/
			dueBeforeLst = new ArrayList<String>();
			dueBeforeTypeLst = new ArrayList<String>();
			elapsedAfterLst = new ArrayList<String>();
			elapsedAfterTypeLst = new ArrayList<String>();
			yrsLst = new ArrayList<String>();
			monthsLst = new ArrayList<String>();
		    daysLst = new ArrayList<String>();

			/*ends here.*/

			strTokens1 = new StringTokenizer((String)vaccineDurList.get(j),"|");

			while (strTokens1.hasMoreTokens())
			{
				strTokens3 = new StringTokenizer(strTokens1.nextToken(),"~");
				orderList.add(strTokens3.nextToken());
				durationList.add(strTokens3.nextToken());
				dTypeList.add(strTokens3.nextToken());
				mandatoryList.add(strTokens3.nextToken());
				defaultList.add(strTokens3.nextToken());

				/*
					added by kishore kumar N on 04/Nov/2009 for CRF 0691.1
				*/

				if (strTokens3.hasMoreTokens())
				{
					dueBeforeLst.add(strTokens3.nextToken());
					dueBeforeTypeLst.add(strTokens3.nextToken());
					elapsedAfterLst.add(strTokens3.nextToken());
					elapsedAfterTypeLst.add(strTokens3.nextToken());

				}
				if (adhocAgeSpecYN.equals("Y"))
				{
					yrsLst.add((strTokens3.nextToken()==null || (strTokens3.nextToken()).equals(""))?"0":strTokens3.nextToken());
					monthsLst.add((strTokens3.nextToken()==null || (strTokens3.nextToken()).equals(""))?"0":strTokens3.nextToken());
					daysLst.add((strTokens3.nextToken()==null || (strTokens3.nextToken()).equals(""))?"0":strTokens3.nextToken());
				}
				/* ends here.*/
			}

				mstList.add(orderList);
				mstList.add(durationList);
				mstList.add(dTypeList);
				mstList.add(mandatoryList);
				mstList.add(defaultList);
				/*
					added by kishore kumar N on 04/Nov/2009 for CRF 0691.1,
				*/
				mstList.add(dueBeforeLst);
				mstList.add(dueBeforeTypeLst);
				mstList.add(elapsedAfterLst);
				mstList.add(elapsedAfterTypeLst);

				/*ends here.*/

				hashMap.put(vaccineList.get(j),mstList);

		   }// for loop end

		   /*
				added by kishore kumar N on 04/Nov/2009 for CRF 0691.1,

				DUE_BEFORE, DUE_BEFORE_TYPE, ELAPSED_AFTER, ELAPSED_AFTER_TYPE, APPL_AGE_YEARS, APPL_AGE_MONTHS, APPL_AGE_DAYS columns added query.


			*/

			sqlDuration = "Insert into CA_IM_VAC_SCH_FOR_CATEG (VACC_CATEG_ID, VACCINE_ID, DOSE_NO,FREQ_DURATION,FREQ_DURATION_TYPE,MANDATORY_YN,DEFUALT_OPTION,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,DUE_BEFORE, DUE_BEFORE_TYPE, ELAPSED_AFTER, ELAPSED_AFTER_TYPE, APPL_AGE_YEARS, APPL_AGE_MONTHS, APPL_AGE_DAYS) values(?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?)";

			sqlDelDuration = "Delete from CA_IM_VAC_SCH_FOR_CATEG where VACC_CATEG_ID=? and VACCINE_ID=?";

			if (hashMap.size() > 0)
			{
				pstInsert = con.prepareStatement(sqlDuration);
				pstDelete = con.prepareStatement(sqlDelDuration);
				for (int i = 0;i< hashMap.size();i++ )
				{
					vaccine_id = (String)vaccineList.get(i);
					mstList1 = (ArrayList)hashMap.get(vaccineList.get(i));
					orderList = new ArrayList();
					durationList = new ArrayList();
					dTypeList = new ArrayList();
					mandatoryList = new ArrayList();
					defaultList = new ArrayList();
					mstList= new ArrayList();

					orderList=(ArrayList)mstList1.get(0);
					durationList=(ArrayList)mstList1.get(1);
					dTypeList=(ArrayList)mstList1.get(2);
					mandatoryList=(ArrayList)mstList1.get(3);
					defaultList=(ArrayList)mstList1.get(4);

					dueBeforeLst = (ArrayList)mstList1.get(5);
					dueBeforeTypeLst = (ArrayList)mstList1.get(6);
					elapsedAfterLst = (ArrayList)mstList1.get(7);
					elapsedAfterTypeLst = (ArrayList)mstList1.get(8);
					yrsLst = (ArrayList)mstList1.get(9);
					monthsLst = (ArrayList)mstList1.get(10);
					daysLst = (ArrayList)mstList1.get(11);


					pstDelete.setString(1,categoryId);
					pstDelete.setString(2,vaccine_id);
					pstDelete.executeUpdate();
					
					for (int x=0;x<orderList.size() ;x++ )
					{				
						pstInsert.setString(1, categoryId);
						pstInsert.setString(2, vaccine_id);
						pstInsert.setInt(3, Integer.parseInt((String)orderList.get(x)));
						pstInsert.setString(4,((String)durationList.get(x)).trim());
						pstInsert.setString(5,((String)dTypeList.get(x)).trim());
						pstInsert.setString(6,(String)mandatoryList.get(x));
						pstInsert.setString(7,(String)defaultList.get(x));
						pstInsert.setString(8, addedId);
						pstInsert.setString(9, client_ip_addr);
						pstInsert.setString(10, facilityId);
						pstInsert.setString(11, addedId);
						pstInsert.setString(12, client_ip_addr);
						pstInsert.setString(13, facilityId);
						pstInsert.setString(14, dueBeforeLst.get(x).trim());
						pstInsert.setString(15, dueBeforeTypeLst.get(x).trim());
						pstInsert.setString(16, elapsedAfterLst.get(x).trim());
						pstInsert.setString(17, elapsedAfterTypeLst.get(x).trim());
						pstInsert.setString(18, yrsLst.get(x).trim());
						pstInsert.setString(19, monthsLst.get(x).trim());
						pstInsert.setString(20, daysLst.get(x).trim());

						pstInsert.executeUpdate();
					}// inner for loop end

				}//outer for loop end
			}// if condition end

			if (pstInsert !=null) pstInsert.close();
			if (pstDelete !=null) pstDelete.close();

	   }
       catch (Exception e)
       {
		  // out.println("Exception raise by Vaccines For Category insertFrequency Function Servlet ...So Record Not inserted  : "+e.toString());//common-icn-0181
		   e.printStackTrace();
       }finally {
			try
			{
				if (pstInsert !=null) pstInsert.close();
				if (pstDelete !=null) pstDelete.close();
			}
			catch (Exception e)
			{
			}

	   }
	}
}
