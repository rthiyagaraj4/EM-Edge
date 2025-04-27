<!DOCTYPE html>
<% 
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
03/07/2015	IN052940		Ramesh G										In Clinical note there should be an option to auto fetch/Copy data from same template if filled up earlier for same patient in template format.
13/07/2015	IN056365		Ramesh G
16/07/2023       28796               hariharan                                Ramesh G                      NMC-JD-CRF0154    										For EMR Patients, Period Range is defaulted as 10 Days. It should be 30 Days
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- <%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper,eCA.*,eCommon.Common.*" " contentType="text/html;charset=UTF-8" %> --%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper,java.text.*,eCA.*,eCA.Common.*"  contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<html>
<head>
<title>Recorded Previous Notes Search Criteria</title>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		//String locale = (String)session.getAttribute("LOCALE");//28796
		String fac_id    	= (String) session.getValue( "facility_id" ) ;//28796
		
		String imgUrl="";

		if(sStyle.equals("IeStyle.css"))
				imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	

</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<center>
<form name='RecPreviousNotesSrchCriteriaForm' id='RecPreviousNotesSrchCriteriaForm'>
<%
	
		
	Connection			con		=	null;
	PreparedStatement	pstmt	=	null;
	ResultSet			rs		=	null;

	String	query_for_days		=	"";
	String	query_string		=	"";
	String	from_date_time		=	"";
	String	to_date_time		=	"";
	String	note_type_new		=	"";	
	String   note_type			=	"";
	String	note_type_desc		=	"";
	String	note_group_new		=	"";
	String	note_group			=	"";	
	String	note_group_desc		=	"";
	String	inc_oth_unsign_nt	=	"";
	String  facility ="";//28796
	int 	allowedDays 		= 	0;
	StringBuffer query_header_details = new StringBuffer();

	String patient_class				=	(request.getParameter("patient_class")==null)	?	""	:	request.getParameter("patient_class");
	/*String temPatientClass				=	"";
	if("EM".equals(patient_class))
		temPatientClass = "OP"; //IN056365 - changed from IP to OP
	else if("DC".equals(patient_class))
		temPatientClass = "IP"; //IN056365 - changed form OP to IP
	else
		temPatientClass = patient_class;
	*/	
	query_string = request.getQueryString();

	try
	{
		con				=	ConnectionManager.getConnection(request);		
		//query_for_days  = 	"SELECT DURN_VAL FROM OR_PAT_APPLICABLE_FUNC WHERE FUNCTION_ID='COPY_PREVIOUS_NOTE' AND PATIENT_CLASS = ?";//commented for code review
		//query_for_days  =  "SELECT DURN_VAL FROM OR_PAT_APPLICABLE_FUNC WHERE FUNCTION_ID='COPY_PREVIOUS_NOTE' AND PATIENT_CLASS = decode(?,'EM','OP','DC','IP',"+"'"+patient_class+"'"+")";//common-icn-0180
		query_for_days  =  "SELECT DURN_VAL FROM OR_PAT_APPLICABLE_FUNC WHERE FUNCTION_ID='COPY_PREVIOUS_NOTE' AND PATIENT_CLASS = decode(?,'EM','OP','DC','IP',?)";//common-icn-0180
		
		pstmt			=	con.prepareStatement(query_for_days);
		//pstmt.setString(1,temPatientClass);
		pstmt.setString(1,patient_class);
		pstmt.setString(2,patient_class);//common-icn-0180
		
		rs				=	pstmt.executeQuery();
		if(rs.next()){
			allowedDays = 	Integer.parseInt((String)rs.getString("DURN_VAL"));
		}
		to_date_time	=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		from_date_time	=	com.ehis.util.DateUtils.minusDate(to_date_time,"DMYHM",locale,allowedDays,"d");
	}catch(Exception e){
		System.out.println("Exception@1: "+e);
	}finally{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) con.close();
	}
%>
	<table border="0" cellpadding="3" cellspacing="0" width="100%" align='center'>
		<tr>
			<td class="LABEL"  width='20%' ><fmt:message key="Common.Period.label" bundle="${common_labels}"/>&nbsp;&nbsp;
			
				<input type='text' name='from_date_time' id='from_date_time' value="<%=from_date_time%>" size='14' maxLength='16'  onBlur=' CheckDateNew(this); checkPeriodFromTo(this,to_date_time, "DMYHM","<%=locale%>")'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('from_date_time');">
				&nbsp;&nbsp;-&nbsp;&nbsp;<input type='text' name='to_date_time' id='to_date_time' value="<%=to_date_time%>" size='14' maxLength='16'  onBlur='CheckDateNew(this);checkPeriodFromTo(from_date_time,this,"DMYHM","<%=locale%>")'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('to_date_time');">
			</td>
			 <!-- NMC-JD-CRF-0154 -->
		
			<td class='label' width='20%'> <fmt:message key="eCA.FacilityName.label" bundle="${ca_labels}"/>
	     			   
			  <select name='facility' id='facility' width="30%"  onChange=''>
			
			  	
	<%
	try
	{
		
		PreparedStatement stmt1=null;
		ResultSet rs1=null;
		con=ConnectionManager.getConnection(request);
		
		String facility_id = (String)session.getValue("facility_id");
		
	        String sql1="";
	       // String facility="";
			sql1=" select facility_id,facility_name from sm_facility_param order by facility_name";
			stmt1=con.prepareStatement(sql1);
			rs1=stmt1.executeQuery();
			if(rs1!=null)
			{
				while(rs1.next())
				{
					
					String id=rs1.getString(1);
					String name = rs1.getString(2);
					if(id.equals(fac_id))
					  {
					%>
		<option value=<%=id%> selected><%=name%></option>
		<%
					  }
					  else
					  {%>
		<option value=<%=id%> ><%=name%> </option> 
		<%	}
						
				}
			}

		if(rs1!=null)rs1.close();
		if(stmt1!=null)stmt1.close();
	
	}
	catch(Exception e){
		System.out.println("Exception@1: "+e);
		}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

              
			   </select>
		<!-- NMC-JD-CRF-0154 -->
	
			<td class="label" width='20%'><fmt:message key="eCA.RefNo.label" bundle="${ca_labels}"/>
			
				<input type="text" name="ref_no" id="ref_no" value="" width="25%" size="40" maxlength = '100' onkeyPress="if(event.keyCode == 39) return false;">
			
			<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='BUTTON' onClick="return showPreviousNotesSearchResults();"></td>
		</tr>	
	</table>
		<input type='hidden' name='query_string' id='query_string'	value="<%=query_string%>">	
		<%if(!imgUrl.equals("")){ %>
			 <img src='<%=imgUrl%>' width='100%' height='15'/> 
		<%}%>
</form>
</center>
</body>
</html>
<script language='javascript'>
//28796 STARTS
	var facility_id= document.forms[0].facility.value;
	parent.RecPreviousNotesSrchResultsFrame.location.href = "../../eCA/jsp/RecPreviousNotesSrchResults.jsp?<%=query_string%>&from_date_time=<%=from_date_time%>&to_date_time=<%=to_date_time%>&facility="+facility_id;
//28796 ENDS
</script>
		


