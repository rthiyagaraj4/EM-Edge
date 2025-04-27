<!DOCTYPE html>

 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<html>
<head>
 
	
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
 <table border='1' cellpadding='0' cellspacing='0' width='102%' align='center' >

<%
		Connection con = null;
	    //Statement	stmt		=null;
		PreparedStatement pstmt=null;
		ResultSet	rs			=null;
		request.setCharacterEncoding("UTF-8");
		String group_id	= request.getParameter("group_id");
		String app_date	= request.getParameter("app_date");
		String prac_id	= request.getParameter("prac_id");
		String loc_type	= request.getParameter("loc_type");
		String loc_code	= request.getParameter("loc");
			
		String classValue="";
		String noof_appt="";
		String name	="";
		String pat_id	="";
		String app_no="";
		/*Below line added for this incident [44296]*/
		String fromTime	=request.getParameter("fromtime");if(fromTime==null) fromTime="";
		String toTime=request.getParameter("totime"); if(toTime==null) toTime="";
	//	String clinicType="";
	//	String clinicCode="";
		//String group_Name="";
		
		ecis.utils.OnlineReports onlineReports		=	null;
		ecis.utils.OnlineReport report2				=	null;
		String ReportOutput			=	"";	
		
		int i=0;int maxRecord=0;
		String locale=(String)session.getAttribute("LOCALE");
		String fac_id    	= (String) session.getValue( "facility_id" ) ;
       try{
       con = ConnectionManager.getConnection(request);
	  // stmt=con.createStatement();
	   
	   	/*Below  query modified for this incident [44296]*/
	   
	    String query="SELECT patient_id,appt_ref_no,patient_name,CARE_LOCN_TYPE_IND,CLINIC_CODE FROM oa_appt where GROUP_ID='"+group_id+"' and practitioner_id='"+prac_id+"'  AND ( TRUNC (appt_date) = TRUNC (to_date('"+app_date+"','dd/mm/yyyy'))) AND TO_DATE (TO_CHAR (APPT_SLAB_FROM_TIME, 'hh24:mi'), 'hh24:mi') = TO_DATE ('"+fromTime+"', 'hh24:mi') AND TO_DATE (TO_CHAR (APPT_SLAB_TO_TIME, 'hh24:mi'), 'hh24:mi') = TO_DATE ('"+toTime+"', 'hh24:mi')  group by appt_ref_no,patient_id,patient_name,CARE_LOCN_TYPE_IND,CLINIC_CODE";
	  
	 
	  
	      pstmt = con.prepareStatement(query.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);	  	   
	      //rs = stmt.executeQuery(query.toString());
	      rs = pstmt.executeQuery();
		  rs.last();
		  maxRecord = rs.getRow();
		  rs.beforeFirst(); 	   	
		while(rs.next()){			  
		        app_no=rs.getString("APPT_REF_NO");
				name=rs.getString("PATIENT_NAME");
				pat_id=rs.getString("PATIENT_ID");	
			//	clinicType=rs.getString("CARE_LOCN_TYPE_IND");	
			//	clinicCode=rs.getString("CLINIC_CODE");	
				
				onlineReports 	= new ecis.utils.OnlineReports() ;
				report2= new ecis.utils.OnlineReport((String)session.getValue( "facility_id" ), "OA", "OARAPSL",rs.getString("CARE_LOCN_TYPE_IND"),rs.getString("CLINIC_CODE")) ;				
				report2.addParameter("p_appt_ref_no", rs.getString("APPT_REF_NO")) ;
				//report2.addParameter("p_locn_code", rs.getString("CARE_LOCN_TYPE_IND")) ;
				//report2.addParameter("p_locncode",rs.getString("CLINIC_CODE")) ;
				report2.addParameter("P_FACILITY_ID",(String)session.getValue( "facility_id" )) ;
				report2.addParameter("p_language_id", locale) ;			
				onlineReports.add(report2) ;
				ReportOutput=onlineReports.execute(request, response );
					
			i++;			
		
	}//end of while
			
  

  if(i == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
window.close();</script>
<%}
	if (rs != null) rs.close();
	//if (stmt != null) stmt.close();
	if (pstmt != null) pstmt.close();
}
catch(Exception e)
	{
	e.printStackTrace() ;
	//out.println("one L :" +e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
<script>
if('<%=maxRecord%>'=='<%=i%>'&&parent.frames[1].document.forms[0].select)parent.frames[1].document.forms[0].select.onclick();
</script>
</table>
</body>
</html> 

