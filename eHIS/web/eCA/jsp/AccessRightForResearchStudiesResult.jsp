<!DOCTYPE html>
<%@ page import ="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	webbeans.eCommon.RecordSet accRightForResStuRecSet = (webbeans.eCommon.RecordSet)getObjectFromBean("accRightForResStuRecSet","webbeans.eCommon.RecordSet",session);
%>

<%!int row_count=0;%>
<html>
<head>
<title> <fmt:message key="eCA.TaskForResponsibilityRelationship.label" bundle="${ca_labels}"/></title>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='javascript' src='../../eCA/js/AccessRightForResearchStudies.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String facilityId = (String)session.getValue( "facility_id" ) ;


Connection con			= null;
PreparedStatement pstmt = null,pstmt1=null;
ResultSet rs			= null,rs1=null;
HashMap hMapRecords		= null; 

	
String practitionerId ="", practitionerName = "", resFromDate = "", resToDate = "", resRecord = "", resUpdate = "", studyAllowedIU="", studyRightsIU="", classValue="";
int row_disp=14;
int start = 0 ;
int end = 0 ;
int fm_disp=0, to_disp=0;

String dispMode		=	request.getParameter("dispMode")==null?"": request.getParameter("dispMode");
String from			=	request.getParameter( "from" )==null?"1": request.getParameter( "from" );
String to				=	request.getParameter( "to" )==null?String.valueOf(row_disp): request.getParameter( "to" );
String resePatCategory = request.getParameter("resePatCategory")==null?"":(String)request.getParameter("resePatCategory");
String reseCategoryFact = request.getParameter("reseCategoryFact")==null?"":(String)request.getParameter("reseCategoryFact");
String search_by = request.getParameter("search_by")==null?"":request.getParameter("search_by");
String search_txt = request.getParameter("search_txt")==null?"":request.getParameter("search_txt");
start = Integer.parseInt( from ) ;
end = Integer.parseInt( to ) ;
StringBuffer sql_query = new StringBuffer();
sql_query.append("SELECT APLV.PRACTITIONER_ID ,APLV.PRACTITIONER_NAME, SM_CONVERT_DATE_2T(CRSA.RES_FROM_DATE,?) RES_FROM_DATE,SM_CONVERT_DATE_2T(CRSA.RES_TO_DATE,?) RES_TO_DATE ,(select CRSR.RES_RECORD  from CA_RES_STUDY_RIGHTS CRSR where CRSR.PRACTITIONER_ID =APLV.PRACTITIONER_ID AND CRSR.RESEARCH_CATEG_ID = ? AND CRSR.RESEARCH_CATEG_FACT_ID=? AND CRSR.FACILITY_ID=?) RES_RECORD,(select CRSR.RES_UPDATE  from CA_RES_STUDY_RIGHTS CRSR where CRSR.PRACTITIONER_ID =APLV.PRACTITIONER_ID  AND CRSR.RESEARCH_CATEG_ID = ? AND CRSR.RESEARCH_CATEG_FACT_ID=? AND CRSR.FACILITY_ID=?) RES_UPDATE,(SELECT 'U' FROM CA_RES_STUDY_ALLOWED WHERE PRACTITIONER_ID =APLV.PRACTITIONER_ID AND FACILITY_ID=?) PRACT_YN FROM AM_PRACTITIONER_LANG_VW APLV, CA_RES_STUDY_ALLOWED CRSA WHERE CRSA.PRACTITIONER_ID (+) =APLV.PRACTITIONER_ID AND /*(APLV.REPORTING_FACILITY_ID=? OR ALL_FACILITIES_YN='Y')*/ (? IN (SELECT sffu.facility_id FROM sm_facility_for_user_vw sffu,SM_APPL_USER sau WHERE sffu.appl_user_id =  sau.APPL_USER_ID AND sau.FUNC_ROLE_ID = aplv.practitioner_id) OR all_facilities_yn = 'Y') AND APLV.LANGUAGE_ID=? AND /*CRSA.FACILITY_ID (+) = NVL(APLV.REPORTING_FACILITY_ID,?)*/ CRSA.FACILITY_ID (+) =? ");
if("01".equals(search_by)){
	sql_query.append("AND  UPPER(APLV.PRACTITIONER_ID) LIKE UPPER(?)");
}else if("02".equals(search_by)){
	sql_query.append("AND UPPER(APLV.PRACTITIONER_NAME) LIKE UPPER(?)");
}
sql_query.append(" ORDER BY PRACTITIONER_NAME ASC  ");

try{
	con = ConnectionManager.getConnection(request);
	if(dispMode.equals("")){
		accRightForResStuRecSet.clearAll();
		pstmt = con.prepareStatement(sql_query.toString());
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,resePatCategory);
		pstmt.setString(4,reseCategoryFact);
		pstmt.setString(5,facilityId);
		pstmt.setString(6,resePatCategory);
		pstmt.setString(7,reseCategoryFact);
		pstmt.setString(8,facilityId);
		pstmt.setString(9,facilityId);
		pstmt.setString(10,facilityId);
		pstmt.setString(11,locale);
		pstmt.setString(12,facilityId);
		if("01".equals(search_by)||"02".equals(search_by)){
		pstmt.setString(13,"%"+search_txt+"%");
		}
		rs = pstmt.executeQuery();
		while(rs.next()){
		practitionerId 		=	rs.getString("PRACTITIONER_ID")==null?"":(String)rs.getString("PRACTITIONER_ID");
		practitionerName		=	rs.getString("PRACTITIONER_NAME")==null?"":(String)rs.getString("PRACTITIONER_NAME");
		resFromDate 	=	rs.getString("RES_FROM_DATE")==null?"":(String)rs.getString("RES_FROM_DATE");
		resToDate 		=	rs.getString("RES_TO_DATE")==null?"":(String)rs.getString("RES_TO_DATE");
		resRecord 		=	rs.getString("RES_RECORD")==null?"N":(String)rs.getString("RES_RECORD");
		resUpdate 		=	rs.getString("RES_UPDATE")==null?"N":(String)rs.getString("RES_UPDATE");
		studyAllowedIU	=	rs.getString("PRACT_YN")==null?"I":(String)rs.getString("PRACT_YN");
		studyRightsIU	=	rs.getString("RES_RECORD")==null?"I":"U"; 
		
		HashMap hMapRecs = new HashMap();
		hMapRecs.put("practitionerId"		, practitionerId);
		hMapRecs.put("practitionerName"		, practitionerName);
		hMapRecs.put("resFromDate"		, resFromDate);
		hMapRecs.put("resToDate"		, resToDate);
		hMapRecs.put("resRecord"		, resRecord);
		hMapRecs.put("resUpdate"		, resUpdate);
		hMapRecs.put("studyAllowedIU"	, studyAllowedIU);
		hMapRecs.put("studyRightsIU"	, studyRightsIU);
		
		accRightForResStuRecSet.putObject(hMapRecs);
		}
		row_count	=	accRightForResStuRecSet.getSize();
		fm_disp	=	0;
		to_disp	=	(row_disp-1);
		if(to_disp > (row_count-1))
			to_disp=(row_count-1);

		from = ""+(start - 1);
		to   = ""+(end - 1);
		%>
		<script>
			if('<%=row_count%>' <= 0){
			var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common");	
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		}
		</script>
		<%
	}else{
		int from_val	= (Integer.parseInt(from));
		int to_val		= (Integer.parseInt(to));
		if(dispMode.equals("Next")){
			dispMode	="Next";
			from		= ""+(start + row_disp);
			to			= ""+(end + row_disp);
			
		}else if(dispMode.equals("Previous")){
			dispMode	="Previous";
			from		= ""+(start - row_disp);
			to			= ""+(end - row_disp);
		}
		
		if(to_val > (row_count-1))
			to_val=(row_count-1);

		
		for(int j=from_val; j<=to_val; j++){			
			practitionerId 		=	request.getParameter("practitionerId"+j)==null?"":request.getParameter("practitionerId"+j);
			practitionerName		=	request.getParameter("practitionerName"+j)==null?"":request.getParameter("practitionerName"+j);
			resFromDate 	=	request.getParameter("resFromDate"+j)==null?"":request.getParameter("resFromDate"+j);
			resToDate 		=	request.getParameter("resToDate"+j)==null?"":request.getParameter("resToDate"+j);
			resRecord 		=	request.getParameter("resRecord"+j)==null?"":request.getParameter("resRecord"+j);
			resUpdate 		=	request.getParameter("resUpdate"+j)==null?"":request.getParameter("resUpdate"+j);
			studyAllowedIU	=	request.getParameter("studyAllowedIU"+j)==null?"":request.getParameter("studyAllowedIU"+j);
			studyRightsIU	=	request.getParameter("studyRightsIU"+j)==null?"":request.getParameter ("studyRightsIU"+j);
			HashMap hMapAlter = (java.util.HashMap)accRightForResStuRecSet.getObject(j);
			hMapAlter.put("practitionerId"	, practitionerId);
			hMapAlter.put("practitionerName"	, practitionerName);
			hMapAlter.put("resFromDate"	, resFromDate);
			hMapAlter.put("resToDate"	, resToDate);
			hMapAlter.put("resRecord"	, resRecord);
			hMapAlter.put("resUpdate"	, resUpdate);
			hMapAlter.put("studyAllowedIU"	, studyAllowedIU);
			hMapAlter.put("studyRightsIU"	, studyRightsIU);
			accRightForResStuRecSet.setObject(j, hMapAlter);
		}
		fm_disp = Integer.parseInt(from);
		to_disp	= Integer.parseInt(to);

		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		start	= Integer.parseInt(from);
		end     = Integer.parseInt(to);
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	
	putObjectInBean("accRightForResStuRecSet",accRightForResStuRecSet,session);
%>
<body  OnMouseDown="CodeArrest();"  class='CONTENT' onKeyDown = 'lockKey()'>
<form name='formAccessRightForResearchStudiesResult' id='formAccessRightForResearchStudiesResult' >
<table cellpadding='3' cellspacing='0' border='0' width='85%' align='center'>
<tr  width='10%'>
<td class='white' width='89%'></td>
<%
	if ( (!(start <= 1)) && (start < row_count)){
	%>
		
		<td width='6%' class='label'>
		<A class='gridLink' HREF='javascript:onClick=checkVal("Previous");' text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
		</td>
	<%	
	}
	if ( !( (start+row_disp) >= row_count ) ){
	%>
		<td width='6%' class = 'label'><A class='gridLink' HREF='javascript:onClick=checkVal("Next");' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
		</td>
	<%
	}
%>
</tr>
</table> 
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>	
	<tr>
		<th rowspan="2">Practitioner</th>
		<th colspan="2">Access Rights for Clinical Studies Patient List</th>		
		<td>&nbsp;</td>
		<th colspan="2">Access Rights for Clinical Studies</th>
	</tr> 
	<tr>
		<th>Date From</th>
		<th>Date To</th>
		<td>&nbsp;</td>
		<th>Record</th>
		<th>Update</th>
	</tr> 
	
<%
	for(int i=fm_disp; i<=to_disp; i++){
		classValue		=	( (i%2)==0 )? "gridData" : "gridData";
		java.sql.Date fromDate = null;
		java.sql.Date toDate = null;
		hMapRecords 	= (java.util.HashMap)accRightForResStuRecSet.getObject(i);
		practitionerId		=	(String)	hMapRecords.get("practitionerId");
		practitionerName		=	(String)	hMapRecords.get("practitionerName");
		resFromDate		=	(String)	hMapRecords.get("resFromDate");
		resToDate		=	(String)	hMapRecords.get("resToDate");	
		resRecord		=	(String)	hMapRecords.get("resRecord");
		resUpdate		=	(String)	hMapRecords.get("resUpdate");
		studyAllowedIU	=	(String)	hMapRecords.get("studyAllowedIU");
		studyRightsIU	=	(String)	hMapRecords.get("studyRightsIU");			
	%>
	<TR>
		<TD>&nbsp;&nbsp;&nbsp;&nbsp;<%=practitionerName%></TD>
		<input type="hidden" name="practitionerId<%=i%>" id="practitionerId<%=i%>" value="<%=practitionerId%>">
		<input type="hidden" name="practitionerName<%=i%>" id="practitionerName<%=i%>" value="<%=practitionerName%>">
		<input type="hidden" name="studyAllowedIU<%=i%>" id="studyAllowedIU<%=i%>" value="<%=studyAllowedIU%>">
		<input type="hidden" name="studyRightsIU<%=i%>" id="studyRightsIU<%=i%>" value="<%=studyRightsIU%>">
		<TD>&nbsp;&nbsp;&nbsp;&nbsp;<input type='textbox' id='resFromDate<%=i%>' name='resFromDate<%=i%>' value='<%=resFromDate%>' size='14' maxlength='16' >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('resFromDate<%=i%>')"></img></TD>
		<TD>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<input type='textbox' id='resToDate<%=i%>' name='resToDate<%=i%>' value='<%=resToDate%>' size='14' maxlength='16' >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('resToDate<%=i%>')"></img>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:showAccessRightsHistory('<%=facilityId%>','<%=practitionerId%>','<%=practitionerName%>')">H</a>
		</TD>
		<TD>&nbsp;</TD>
		<TD align="center"><input type="checkbox" id='resRecord<%=i%>' name='resRecord<%=i%>' onclick="checkRecUpd('resRecord<%=i%>');" value="<%=resRecord%>" <%if("Y".equals(resRecord)){%> checked <%}%>  /></TD>
		<TD align="center"><input type="checkbox" id='resUpdate<%=i%>' name='resUpdate<%=i%>' onclick="checkRecUpd('resUpdate<%=i%>');" value="<%=resUpdate%>" <%if("Y".equals(resUpdate)){%> checked <%}%>  /></TD>
	</TR>
	<%
	}
}catch(Exception e)
{
		e.printStackTrace();
}
finally
{		
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
}	
%>	
 </table>
 <input type="hidden" name="dispMode" id="dispMode" value=<%=dispMode%> > 
	<input type="hidden" name="from" id="from" value="<%=from%>">
	<input type="hidden" name="to" id="to" value="<%=to%>">
	<input type='hidden' name='row_count' id='row_count' value="<%=row_count%>">
	<input type='hidden' name='fm_disp' id='fm_disp' value="<%=fm_disp%>">
	<input type='hidden' name='to_disp' id='to_disp' value="<%=to_disp%>">
	<input type="hidden" name="optionValStr" id="optionValStr" value=""/>
	<input type="hidden" name="resePatCategory" id="resePatCategory" value="<%=resePatCategory%>"/>
	<input type="hidden" name="reseCategoryFact" id="reseCategoryFact" value="<%=reseCategoryFact%>"/>
</form>
</body>
</html>

