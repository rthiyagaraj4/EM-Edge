<!DOCTYPE html>

 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.* ,eCommon.XSSRequestWrapper" %>

<html>
<head>
 
	
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	
	<!-- Below Style For Fixed Header with scroll.... -->
	
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script><!-- Supporting Js File For Fixed Header with scroll.... -->
	<script type="text/javascript">
	window.onload = function () { 
		if(document.getElementById("Grp_appt_dtls")!=null){
			fxheaderInit('Grp_appt_dtls',350);
		}
	}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<script>
		function printOnlineReport(app_no,pat_id,fac_id,locale,loc_type,loc_code)
		{
			
			var dialogHeight	= '25' ;
		    var dialogWidth	    = '65' ;
		    var dialogTop		= 58;
		    var arguments		= ''; 
			var sql="select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = 'OA' AND REPORT_ID ='OARAPSL' and language_id ='"+locale+"'";
			var reportParamNames="p_appt_ref_no,p_facility_id";
			var reportParamValues=app_no+","+fac_id;
			var getUrl			= "../../eCommon/jsp/InternalReportsPrint.jsp?rep_id=RDRORNTF&step=1&sqlString="+ sql+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&Patient_ID="+pat_id+"&dest_locn_type="+loc_type+"&dest_locn_code="+loc_code+"&appt_no="+app_no+"";
			var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:'+dialogWidth +'; status=no;';
		   retVal=   window.showModalDialog(getUrl,arguments,features);
		}
	</script>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	
			<table border="1" width="100%" cellspacing='0' cellpadding='0' id="Grp_appt_dtls">
			<tr height="8%">
			<th width="15%" class='COLUMNHEADER' nowrap ><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></th>
			<th width="15%" class='COLUMNHEADER' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th width="50%" class='COLUMNHEADER' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>			
			<th width="20%" class='COLUMNHEADER' nowrap><fmt:message key="eOA.AppointmentSlips.label" bundle="${oa_labels}"/></th>	      
		</tr>

<%
		Connection con = null;
		Statement	stmt		=null;
		ResultSet	rs			=null;
		PreparedStatement pstmt=null;
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String group_id	= checkForNull(request.getParameter("group_id"));
		String app_date	=checkForNull( request.getParameter("app_date"));
		String prac_id	= checkForNull(request.getParameter("prac_id"));
		String loc_type	= checkForNull(request.getParameter("loc_type"));
		String loc_code	= checkForNull(request.getParameter("loc"));
		
		String slapfromTime=checkForNull(request.getParameter("fromTime"));
        String slaptoTime=checkForNull(request.getParameter("toTime"));
		
		
		String classValue="";
		String name	="";
		String pat_id	="";
		String app_no="";
		String fromTime	="";
		String toTime="";
		//String group_Name="";
		int i=0;
		String locale=(String)session.getAttribute("LOCALE");
		String fac_id    	= (String) session.getValue( "facility_id" ) ;
       try{
	   
	   //String sqlQuery="SELECT APPT_REF_NO,nvl(to_char(appt_slab_from_time,'hh24:mi'),' ') appt_slab_from_time,nvl(to_char(appt_slab_to_time,'hh24:mi'),' ') appt_slab_to_time,PATIENT_NAME,PATIENT_ID  FROM oa_appt where GROUP_ID='"+group_id+"' and practitioner_id='"+prac_id+"' AND ( TRUNC (appt_date) = TRUNC (to_date('"+app_date+"','dd/mm/yyyy'))) and TO_CHAR (appt_slab_from_time, 'HH24:mi')='"+slapfromTime+"' and TO_CHAR (appt_slab_to_time, 'HH24:mi')='"+slaptoTime+"'";
	   String sqlQuery="SELECT APPT_REF_NO,nvl(to_char(appt_slab_from_time,'hh24:mi'),' ') appt_slab_from_time,nvl(to_char(appt_slab_to_time,'hh24:mi'),' ') appt_slab_to_time,PATIENT_NAME,PATIENT_ID  FROM oa_appt where GROUP_ID=? and practitioner_id=? AND ( TRUNC (appt_date) = TRUNC (to_date(?,'dd/mm/yyyy'))) and TO_CHAR (appt_slab_from_time, 'HH24:mi')=? and TO_CHAR (appt_slab_to_time, 'HH24:mi')=?";

       con = ConnectionManager.getConnection(request);
	   //stmt=con.createStatement();
		//rs = stmt.executeQuery(sqlQuery);
		pstmt = con.prepareStatement(sqlQuery);
		pstmt.setString(1,group_id);
		pstmt.setString(2,prac_id);
		pstmt.setString(3,app_date);
		pstmt.setString(4,slapfromTime);
		pstmt.setString(5,slaptoTime);
		rs = pstmt.executeQuery();
			if ( rs != null )
			while(rs.next())
			{	
			if ( i % 2 == 0 )
			  classValue = "QRYEVEN" ;
		   else
			  classValue = "QRYODD" ;
			  
		        app_no=checkForNull(rs.getString("APPT_REF_NO"));
				name=checkForNull(rs.getString("PATIENT_NAME"));
				pat_id=checkForNull(rs.getString("PATIENT_ID"));
				fromTime=checkForNull(rs.getString("appt_slab_from_time"));
				toTime=checkForNull(rs.getString("appt_slab_to_time"));
			
		%>
	<tr>
		<td  class='<%=classValue%>' width="15%"><%=app_no%></td>
		<td  class='<%=classValue%>' width="15%"><%=pat_id%></td>
		<td  class='<%=classValue%>' width="50%" ><%=name%></td>		
		<td  class='<%=classValue%>' style='color:blue;cursor:pointer;' width='20%'><a href=javascript:printOnlineReport('<%=app_no%>','<%=pat_id%>','<%=fac_id%>','<%=locale%>','<%=loc_type%>','<%=loc_code%>')><fmt:message key="eOA.Print.label" bundle="${oa_labels}"/></a></td>
			</tr> 
	<%	
			i++;
		
	}//end of while
			
  //} 

  if(i == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
window.close();</script>
<%}
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
}
catch(Exception e)
	{
	//out.println("one L :" +e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</table>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}	
%>
</body>
</html> 

