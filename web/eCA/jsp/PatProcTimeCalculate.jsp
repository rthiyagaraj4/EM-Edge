<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created 
20/01/2012		CHL-CRF [IN035950]	Ramesh G		CHL-CRF [IN035950]										
------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------
?			100				?           ?			?				created
30/07/2015	IN037505		Karthi L	?			?				[SRR20056-SCF-9373 ] - IN037471	After select Start Date/time and Duration, System doesn?t calculate and 																					display Ending date/time.							
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*"  contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	Connection con =null;
	ResultSet rs=null;
	PreparedStatement  stmt=null;

	try
	{
		con = ConnectionManager.getConnection(request);
		String startdate = request.getParameter("startdate")==null?"":request.getParameter("startdate");
		String enddate	 = request.getParameter("enddate")==null?"":request.getParameter("enddate");
		String hours	 = request.getParameter("hours")==null?"00":request.getParameter("hours");
		String minutes	 = request.getParameter("minutes")==null?"00":request.getParameter("minutes");
		String flag		 = request.getParameter("flag")==null?"":request.getParameter("flag");
		String modal_yn	 = request.getParameter("modal")==null?"N":request.getParameter("modal");
		String p_called_from_widget	 = request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget"); //CHL-CRF  [IN035950]
		String l_locale	 = request.getParameter("p_locale")==null?"":request.getParameter("p_locale"); //added p_locale for SRR20056-SCF-9395 [IN037505]
		String newDate = "";
		String sql = "";
		String hrs = "";
		String min = "";
		String a1con = "";
		float minu = 0;
		int finalMinutes = 0;
		String finalMinStr = "";
		//added p_locale for SRR20056-SCF-9395 [IN037505] - Start
		if(!"en".equals(l_locale))
		{
			startdate = com.ehis.util.DateUtils.convertDate(startdate,"DMYHM",l_locale,"en");
			enddate = com.ehis.util.DateUtils.convertDate(enddate,"DMYHM",l_locale,"en");
		}
		//added p_locale for SRR20056-SCF-9395 [IN037505] - End
		if (flag.equals("Hrs") || flag.equals("Min"))
		{
			sql = "select to_char(to_date(?,'dd/mm/yyyy hh24:mi')+(0"+hours+"/24)+(0"+minutes+"/1440),'dd/mm/yyyy hh24:mi') from dual";

			stmt = con.prepareStatement(sql);
			stmt.setString(1,startdate);
			
			rs = stmt.executeQuery();
			while(rs.next())
			{
				newDate = rs.getString(1) == null ? "" : rs.getString(1);
			}
			//added p_locale for SRR20056-SCF-9395 [IN037505] - Start
			if(!"en".equals(l_locale))
			{
				newDate = com.ehis.util.DateUtils.convertDate(newDate,"DMYHM","en",l_locale);
			}
			//added p_locale for SRR20056-SCF-9395 [IN037505] - End
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			
			if(modal_yn.equals("Y"))
			{
				a1con = "parent.frame2.document.forms[0].enddate.value=''; parent.frame2.document.forms[0].enddate.value='"+newDate+"';parent.frame2.document.forms[0].enddate.focus();";
			}
			else
			{
				//CHL-CRF Start. [IN035950]
				if(!"".equals(p_called_from_widget)){
					a1con = "parent.frame2.document.forms[0].enddate.value=''; parent.frame2.document.forms[0].enddate.value='"+newDate+"';parent.frame2.document.forms[0].enddate.focus();";
				}else{
				//CHL-CRF End. [IN035950]
					a1con = "top.content.workAreaFrame.frame2.document.forms[0].enddate.value=''; top.content.workAreaFrame.frame2.document.forms[0].enddate.value='"+newDate+"';top.content.workAreaFrame.frame2.document.forms[0].enddate.focus();";
				}//CHL-CRF  [IN035950]
			}
			out.println(a1con);
	    }
		else if (flag.equals("enddate") || flag.equals("date"))
		{
			sql="select round((to_date(?,'dd/mm/yyyy hh24:mi')-to_date(?,'dd/mm/yyyy hh24:mi'))*24,2) datemin from dual";
			stmt = con.prepareStatement(sql);
			stmt.setString(1,enddate);
			stmt.setString(2,startdate);

			rs = stmt.executeQuery();
			while(rs.next())
			{
				newDate = rs.getString(1) == null ? "" : rs.getString(1);
			}

			StringTokenizer str = new StringTokenizer(newDate,".");
			int i = newDate.indexOf(".");
			if (i != -1)
			{
				 if(i != 0)
				 {
					 hrs = str.nextToken();
					 min = str.nextToken();
				 }
				 else
				 {
					min = str.nextToken();
				 }
				 min = "."+min;
				 minu = Float.parseFloat(min);

				 minu = (minu*60);
				 finalMinutes = Math.round(minu);
				 if (finalMinutes < 10)
					finalMinStr = "0" + finalMinutes;
				 else
					finalMinStr = "" + finalMinutes;
			}
			else
			{
				hrs = newDate;
				finalMinStr = "0";
			}

			if(hrs.equals("")) hrs = "0";

			int hrsindex = hrs.indexOf("-");
			if(hrsindex != -1)
			{
				hrs = "";
				finalMinStr = "";
			}
			if(modal_yn.equals("Y"))
			{
				a1con = "parent.frame2.document.forms[0].Hrs.value='"+hrs+"'; 	parent.frame2.document.forms[0].Min.value='"+finalMinStr+"';";
			}
			else
			{
				//CHL-CRF Start. [IN035950]
				if(!"".equals(p_called_from_widget)){
					a1con = "parent.frame2.document.forms[0].Hrs.value='"+hrs+"'; 	parent.frame2.document.forms[0].Min.value='"+finalMinStr+"';";
				}else{
				//CHL-CRF End. [IN035950]				
					a1con = "top.content.workAreaFrame.frame2.document.forms[0].Hrs.value='"+hrs+"'; 	top.content.workAreaFrame.frame2.document.forms[0].Min.value='"+finalMinStr+"';";
				}//CHL-CRF  [IN035950]
			}
			out.println(a1con);
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();

	}
	catch(Exception e)
	{
		//out.println("Exception in patproctime : "+e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con);
	}
%>
