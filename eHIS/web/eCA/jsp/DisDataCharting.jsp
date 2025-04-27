<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
10/12/2012		IN036447		ChowminyaG		 Multiple Reference Range of integer numeric discrete measure do not display in Vital sign battery 
14/02/2013		IN036756		ChowminyaG		 Record Vital Signs->Defined Discrete Measure Components are not displayed 
18/06/2018		IN070732		Ramesh Goli		 SKR-SCF-1232
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String strTitle = "";
	String called_from = request.getParameter("called_from");
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
	<script src='../../eCA/js/DisDataCharting.js' language='javascript'></SCRIPT>
			
	<script language='javascript'>
		function onSuccess(){}

	</script>
<%
    Connection con =null;
    
	try
	{
		con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rset=null ;
    
		PreparedStatement pstmtCheck = null;
		String past_visit   = "";
		String patientline  = "";
		String dob		    = "";	//--[IN036447]
		String sex		    = "";			
		String qs = request.getQueryString();

		String qs1 = qs;
		String facilityid = (String) session.getValue("facility_id");
		String pat_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String episodeid = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
		String visitid = request.getParameter("visit_id")==null?"":request.getParameter("visit_id");
		String Patient_Id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String amendMode = request.getParameter("amendMode")==null?"":request.getParameter("amendMode");
		String replaceMode=request.getParameter("replaceMode") == null?"":request.getParameter("replaceMode");

		String amerepMode=request.getParameter("amerepMode")==null?"N":request.getParameter("amerepMode");
		String module_id = request.getParameter("module_id")==null?"":request.getParameter("module_id");
		if(visitid.equals("")) visitid="";
		
		//[IN036447] - Start //IN036756
			String strSqlPat = "Select sex, to_char(date_of_birth,'dd/mm/yyyy') date_of_birth from Pr_encounter a, Mp_patient b where a.ENCOUNTER_ID=? and facility_id=? and A.PATIENT_ID = b.PATIENT_ID";
			pstmt = con.prepareStatement(strSqlPat);
			
			pstmt.setString	(	1,	episodeid);
			pstmt.setString	(	2,	facilityid	);
			rset = pstmt.executeQuery();

			if(rset.next())
			{
				sex = rset.getString("sex");
				dob = rset.getString("date_of_birth");
			}
			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();
			//[IN036447] - End //IN036756
		
		if(called_from == null || called_from.equals("") )
			strTitle = " Vital Signs";
		else
		{
			String strSqlPatienLine = "select get_patient.get_line_detail(?,?,?) patient_line from dual";
			pstmt = con.prepareStatement(strSqlPatienLine);
			
			pstmt.setString	(	1,	facilityid	);
			pstmt.setString	(	2,	episodeid);
			pstmt.setString	(	3,	locale);

			rset = pstmt.executeQuery();

			if(rset.next())
				patientline = rset.getString("patient_line");

			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();

			strTitle = patientline;
		}
%>
		<title><%=strTitle%></title></head>
<%
		String retvalue = "";
		String lastrecorddate = "";
		boolean proceed = false;
		boolean func_appl_yn = true;
		    
		pstmtCheck = con.prepareStatement(" select ca_get_func_appl_past_visit(?,?,?,?,?) from dual");
		pstmtCheck.clearParameters();
		pstmtCheck.setString(1,facilityid);                // facid
		pstmtCheck.setString(2,"VITAL_SIGNS");              // p_function
		pstmtCheck.setString(3,episodeid);        // p_episode_id
		pstmtCheck.setString(4,pat_class);         // p_episode_type
		pstmtCheck.setString(5,Patient_Id);      // p_patient_id    
           
		rset = pstmtCheck.executeQuery();

		while(rset!=null && rset.next())
		{
			past_visit = rset.getString(1);
		}

		if(rset!=null) rset.close();
		if(pstmtCheck!=null) pstmtCheck.close();

        if(past_visit!=null && past_visit.equalsIgnoreCase("FALSE")) 
		{
			func_appl_yn = false;
%>	
		<script>
			alert(getMessage("CA_DIAG_PROCEDURE","CA"));
			//window.close();
			parent.document.getElementById('dialog_tag').close();
			proceed = false;
		</script> 
<%   
		}   

		if(func_appl_yn)
		{      
			String sqlstr="select CA_GET_BATTERY_ID(?,?,?) from dual";

			pstmt=con.prepareStatement(sqlstr);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,pat_class);
			pstmt.setString(3,episodeid);
			rset=pstmt.executeQuery();

			if(rset != null && rset.next())
			{
                retvalue = rset.getString(1)==null?"**":rset.getString(1);
				retvalue=retvalue.trim();  //retvalue trimed trim() by Arvind for ICN 18983 - REopen
                if(retvalue.indexOf("**") >=0)
                    out.println("<script>alert(getMessage('NO_VITAL_SIGN_BATTERY','CA'))</script>");
                else
				{
					qs=qs + "&battey_id="+retvalue;
                    qs1 = qs;
                    proceed = true;
                }
			}

			if (rset!=null) rset.close();
			if (pstmt!=null) pstmt.close();
	
			StringBuffer sql=new StringBuffer();
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" SELECT to_char(test_observ_dt_tm,'dd/mm/yyyy hh24:mi:ss')");
			sql.append(" test_observ_dt_tm FROM ca_encntr_discr_msr WHERE test_observ_dt_tm");
            sql.append(" =(SELECT MAX(test_observ_dt_tm) FROM ca_encntr_discr_msr");  
            //IN070732 Start.
			//sql.append(" WHERE facility_id = ? AND ENCOUNTER_ID = ?) and facility_id = ? AND ENCOUNTER_ID = ? AND ROWNUM=1");  
			sql.append(" WHERE facility_id = ? AND ENCOUNTER_ID = ?  AND DISCR_MSR_ID IN(SELECT DISTINCT DISCR_MSR_ID FROM AM_DISCR_MSR_BATTERY_VIEW WHERE DISCR_MSR_BATTERY_ID=?)) and facility_id = ? AND ENCOUNTER_ID = ?   AND ROWNUM=1");  
            //IN070732 End.
			
			pstmt=con.prepareStatement(sql.toString());
			//IN070732 Start.
			//pstmt.setString(1,facilityid);
			//pstmt.setString(2,episodeid);
			//pstmt.setString(3,facilityid);
			//pstmt.setString(4,episodeid);
			
			pstmt.setString(1,facilityid);
			pstmt.setString(2,episodeid); 
			pstmt.setString(3,retvalue);
			pstmt.setString(4,facilityid);
			pstmt.setString(5,episodeid);
			//IN070732 End.			
			rset=pstmt.executeQuery();
			
	        if(rset!=null && rset.next())
			{
				lastrecorddate = rset.getString("test_observ_dt_tm")==null?"":rset.getString("test_observ_dt_tm");
				//Date conversion added by Archana Dhal on 11/10/2010 related to incident no. IN024814.
				//lastrecorddate = com.ehis.util.DateUtils.convertDate(lastrecorddate,"DMYHMS","en",locale);
				//This is reverted back since the problem is comming in replace mode
	        }

			qs = qs+"&last_record_date="+lastrecorddate;
			qs = qs+"&dob="+dob+"&patsex="+sex;
			qs1 = qs; //--[IN036447] to clear the data on click on clear button
			//String frameSet = "7%,*,7%";
			String height1 = "7vh";  
			String height2 = "60vh";
			String height3 = "7vh";  
			String height4 = "6vh";
			if(amendMode != null && amendMode.equals("Y"))
				//frameSet = "11%,*,7%";
				height1 = "11vh";
			    height3 = "7vh";

			if(replaceMode != null && replaceMode.equals("Y"))
				//frameSet = "11%,*,7%";
				 height1 = "7vh";
		   		 height3 = "7vh";

			if(!module_id.equals(""))
			{
				//frameSet = "11%,*,7%,7%";
					height1 = "7vh";
					height2 = "78vh";
				    height3 = "7vh";
				    height4 = "7vh";
			}

			if(proceed &&  amerepMode.equals("N"))
			{ 
%>
				<%-- <frameset rows='<%=frameSet%>'  class='<%=request.getParameter("cname")%>' >
					<frame name='titleFrame'  border="1" marginwidth=0 marginheight=0  frameborder=NO  scrolling=NO src='../../eCA/jsp/DisDataChartingTitle.jsp?<%=qs%>'  noresize ></frame>
			        <frame name ='addModifyFrame' border="0" marginwidth=0 marginheight=0 frameborder=NO src='../../eCA/jsp/DisDataChartingRecord.jsp?<%=qs%>'  noresize > </frame>
					<frame name ='toolsFrame' border="0"  marginwidth=0 marginheight=0 frameborder=NO scrolling=NO src='../../eCA/jsp/DisDataChartingTools.jsp?<%=qs1%>'  noresize > </frame> --%>
				 <iframe name="titleFrame" src='../../eCA/jsp/DisDataChartingTitle.jsp?<%=qs%>' frameborder="1" scrolling="no" noresize style="height:<%=height1%>; width:98vw;"></iframe>
				 <iframe name="addModifyFrame" src='../../eCA/jsp/DisDataChartingRecord.jsp?<%=qs%>' frameborder="0" scrolling="auto" noresize style="height:<%=height2%>; width:98vw;"></iframe>
				 <iframe name="toolsFrame" src='../../eCA/jsp/DisDataChartingTools.jsp?<%=qs1%>' frameborder="0" scrolling="no" noresize style="height:<%=height3%>; width:98vw;"></iframe>
						
<%
				if(!module_id.equals(""))
				{
%>
<!-- 					<frame name ='messageFrame' border="0"  marginwidth=0 marginheight=0 frameborder=NO scrolling=NO src='../../eCommon/jsp/error.jsp'  noresize > </frame>
 -->
 				        <iframe name="messageFrame" src='../../eCommon/jsp/error.jsp' frameborder="0" scrolling="no" noresize style="height:<%=height4%>; width:98vw;"></iframe>
 				
 <%
				}
%>

<%   
			}
			else if(proceed &&  amerepMode.equals("Y"))
			{
%>
			<%-- <frameset rows='*,7%'  class='<%=request.getParameter("cname")%>' border=0 >
					<frameset cols='20%,*'>
						<frame name='titleFrame'  border="0" marginwidth=0 marginheight=0  frameborder=NO  scrolling=auto  src='../../eCA/jsp/DisDataChartingTitle.jsp?<%=qs%>'  noresize ></frame>			
						<frame name ='addModifyFrame' border="0" marginwidth=0 marginheight=0 frameborder=NO src='../../eCommon/html/blank.html?<%=qs%>'  noresize > </frame>
					</frameset>
						<frame name ='toolsFrame' border="0"  marginwidth=0 marginheight=0 frameborder=1 scrolling=NO src='../../eCA/jsp/DisDataChartingTools.jsp?<%=qs1%>'  noresize > </frame> --%>
					    <iframe name="titleFrame" src='../../eCA/jsp/DisDataChartingTitle.jsp?<%=qs%>' frameborder="0" scrolling="auto" noresize style="height:<%=height1%>; width:98vw;"></iframe>
						    <iframe name="addModifyFrame" src='../../eCommon/html/blank.html?<%=qs%>' frameborder="0" scrolling="no" noresize style="height:<%=height2%>; width:98vw;"></iframe>
						    <iframe name="toolsFrame" src='../../eCA/jsp/DisDataChartingTools.jsp?<%=qs1%>' frameborder="0" scrolling="no" noresize style="height:<%=height3%>; width:98vw;"></iframe>
							

<%
				if(!module_id.equals(""))
				{
%>
<!-- 					<frame name ='messageFrame' border="0"  marginwidth=0 marginheight=0 frameborder=1 scrolling=NO src='../../eCommon/jsp/error.jsp'  noresize > </frame>
 -->
 				        <iframe name="messageFrame" src='../../eCommon/jsp/error.jsp' frameborder="0" scrolling="no" noresize style="height:<%=height4%>; width:98vw;"></iframe>
 				
 <%
				}
%>
	      //  </frameset>
			
<%			}
		} 
%>
</html>
<%
		if(rset != null) rset.close();
		if(pstmt != null) pstmt.close();    
	}
	catch ( Exception e) { }
    finally
	{
		if(con != null)ConnectionManager.returnConnection(con,request);
	}
%>
