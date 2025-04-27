<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
19/06/2024	  62372			Twinkle Shah		19/04/2021	ML-MMOH-CRF-2149.1
--------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.text.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper,eCA.CAAccessCtrlCopyPreviousNotePractBean" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	webbeans.eCommon.RecordSet accRightForResRecSet = (webbeans.eCommon.RecordSet)getObjectFromBean("accRightForResRecSet","webbeans.eCommon.RecordSet",session);
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

<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='javascript' src='../../eCA/js/CAAccessCtrlCopyPreviousNotePract.js'></script>
</head>
<%
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
Connection con			= null;
PreparedStatement pstmt = null,pstmt1=null;
ResultSet rs			= null,rs1=null;
HashMap hMapRecords		= null; 

String practitionerId ="", practitionerName = "", access_from_date = "", access_to_date = "", accessRightsIU="", access_res_pract_yn="", classValue="";
int row_disp=14;
int start = 0 ;
int end = 0 ;
int chk_count=0;
String disb="";
String disbImg="";
String disbImg1="";
String disb1="";
String checkallDateEnable="";
int fm_disp=0, to_disp=0;
String curt_date="";
curt_date= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
String dispMode		=	request.getParameter("dispMode")==null?"": request.getParameter("dispMode");
String search_by = request.getParameter("search_by")==null?"":request.getParameter("search_by");
String search_txt = request.getParameter("search_txt")==null?"":request.getParameter("search_txt");
String facilityId = request.getParameter("facility_id1")==null?"":request.getParameter("facility_id1");
String from		=request.getParameter( "from" )==null?"1": request.getParameter( "from" );
String to		=request.getParameter( "to" )==null?String.valueOf(row_disp): request.getParameter( "to" );
start = Integer.parseInt( from ) ;
end = Integer.parseInt( to ) ;
String or_bean_id 						= "@CAAccessCtrlCopyPreviousNotePractBean";
String or_bean_name 					= "eCA.CAAccessCtrlCopyPreviousNotePractBean";
CAAccessCtrlCopyPreviousNotePractBean bean		= (CAAccessCtrlCopyPreviousNotePractBean)getBeanObject( or_bean_id, or_bean_name, request ) ;

try{
	con = ConnectionManager.getConnection(request);
	if(dispMode.equals("")){
		accRightForResRecSet.clearAll();
		ArrayList  resArray = bean.getAccessRightsViewClinicalDataRestrictedPract(facilityId,practitionerId,search_by,search_txt,locale);
		row_count =resArray.size();
    	if (row_count >0 ){
    	for(int i = 0; i < row_count; i++){
    	ArrayList array = (ArrayList)resArray.get(i);		
		HashMap hMapRecs = new HashMap();
		hMapRecs.put("practitionerId"		, array.get(0));
		hMapRecs.put("practitionerName"		, array.get(1));
		hMapRecs.put("access_from_date"		, array.get(2));
		hMapRecs.put("access_to_date"		, array.get(3));
		hMapRecs.put("accessRightsIU"		, array.get(4));
		hMapRecs.put("access_res_pract_yn"	, array.get(5));
		accRightForResRecSet.putObject(hMapRecs);
		}
		row_count	=	accRightForResRecSet.getSize();
		fm_disp	=	0;
		to_disp	=	(row_disp-1);
		if(to_disp > (row_count-1))
			to_disp=(row_count-1);
		from = ""+(start - 1);
		to   = ""+(end - 1);
		}%>
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
			practitionerName	=	request.getParameter("practitionerName"+j)==null?"":request.getParameter("practitionerName"+j);
			access_from_date 	=	request.getParameter("access_from_date"+j)==null?"":request.getParameter("access_from_date"+j);
			access_to_date 		=	request.getParameter("access_to_date"+j)==null?"":request.getParameter("access_to_date"+j);
			accessRightsIU 		    =	request.getParameter("accessRightsIU"+j)==null?"":request.getParameter("accessRightsIU"+j);
			access_res_pract_yn 	=	request.getParameter("access_res_pract_yn"+j)==null?"N":request.getParameter("access_res_pract_yn"+j);
			
			HashMap hMapAlter = (java.util.HashMap)accRightForResRecSet.getObject(j);
			hMapAlter.put("practitionerId"	, practitionerId);
			hMapAlter.put("practitionerName"	, practitionerName);
			hMapAlter.put("access_from_date"	, access_from_date);
			hMapAlter.put("access_to_date"	, access_to_date);
			hMapAlter.put("accessRightsIU"	, accessRightsIU);
			hMapAlter.put("access_res_pract_yn"	, access_res_pract_yn);
			accRightForResRecSet.setObject(j, hMapAlter);
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
	
	putObjectInBean("accRightForResRecSet",accRightForResRecSet,session);
%>
<body  OnMouseDown="CodeArrest();"  class='CONTENT' onKeyDown = 'lockKey()'>
<form name='CAAccessRightsForViewRestrictPractResultform' id='CAAccessRightsForViewRestrictPractResultform' >
<table cellpadding='3' cellspacing='0' border='0' width='90%' align='center'>
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
	if ( !((start+row_disp) > row_count )){
	%>
		<td width='6%' class = 'label'><A class='gridLink' HREF='javascript:onClick=checkVal("Next");' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
		</td>
	<%
	}
%>
</tr>
</table> 
<table border='0' cellpadding='0' cellspacing='0' width='90%' align='center'>	

<tr height='19px'>
		<th rowspan="2"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
		<th colspan="2">Access Rights to Manage Copy Previous Note for Practitioners</th>
		<th rowspan="2"><input type="checkbox" id="allChecked" name="allChecked" id="allChecked"  onClick="selectAll(this);" />
		</th>		
</tr>  
<tr>
<th width='33%'><fmt:message key="eCA.DateFrom.label" bundle="${ca_labels}"/></th>
<th width='33%'><fmt:message key="eCA.DateTo.label" bundle="${ca_labels}"/></th>
</tr>     
<%
	for(int i=fm_disp; i<=to_disp; i++){
		classValue		=	( (i%2)==0 )? "gridData" : "gridData";
		java.sql.Date fromDate = null;
		java.sql.Date toDate = null;
		hMapRecords 	        =   (java.util.HashMap)accRightForResRecSet.getObject(i);
		practitionerId		    =	(String)hMapRecords.get("practitionerId");
		practitionerName		=	(String)hMapRecords.get("practitionerName");
		access_from_date		=	(String)hMapRecords.get("access_from_date");
		access_to_date		    =	(String)hMapRecords.get("access_to_date");	
		accessRightsIU		    =	(String)hMapRecords.get("accessRightsIU");
		access_res_pract_yn		=   (String)hMapRecords.get("access_res_pract_yn");
		
		if(access_from_date.equals(""))	
		{
			disb="disabled";
			disbImg="disabled";
		}
		else
		{
			disb="";
			disbImg="";
		}
		if(access_to_date.equals(""))	
		{
			disb1="disabled";
			disbImg1="disabled";
		}
		else
		{
			disb1="";
			disbImg1="";
		}  
		if(access_res_pract_yn.equals("Y"))
		{
			chk_count++;
		}
	%>
<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;<%=practitionerName%></td>
<input type="hidden" id="practitionerId<%=i%>" name="practitionerId<%=i%>" value="<%=practitionerId%>">
<input type="hidden" id="practitionerName<%=i%>" name="practitionerName<%=i%>" value="<%=practitionerName%>">
<input type="hidden" id="accessRightsIU<%=i%>" name="accessRightsIU<%=i%>" value="<%=accessRightsIU%>">
<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type='textbox' id='access_from_date<%=i%>' name='access_from_date<%=i%>' value='<%=access_from_date%>' <%=disb%> OnBlur='CheckDateTimefrom(this,"<%=i%>","<%=locale%>","<%=curt_date%>");' OnKeyPress='return CheckForNumsAndColon(event)' size='14' maxlength='16' >&nbsp;<img id='imgfromDate<%=i%>' <%=disbImg%> src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('access_from_date<%=i%>')"></img></td>
<td>
&nbsp;&nbsp;&nbsp;&nbsp;
<input type='textbox' id='access_to_date<%=i%>' name='access_to_date<%=i%>' value='<%=access_to_date%>' <%=disb1%> OnBlur='CheckDateTimeTo(this,"<%=i%>","<%=locale%>","<%=curt_date%>");' OnKeyPress='return CheckForNumsAndColon(event)'  size='14' maxlength='16' >&nbsp;<img <%=disbImg1%> id='imgToDate<%=i%>' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('access_to_date<%=i%>')"></img>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="javascript:showAccessRightsHistory('<%=facilityId%>','<%=practitionerId%>')">H</a>
</td>	
<td align="center"><input type="checkbox" id='access_res_pract_yn<%=i%>' name='access_res_pract_yn<%=i%>' onclick="selectChkBox(this,<%=i%>);enable_date('<%=i%>')" value="<%=access_res_pract_yn%>" <%if("Y".equals(access_res_pract_yn)){%> checked <%}%> /></td>
</tr>
<input type='hidden' id='checkallDateEnable' name='checkallDateEnable' id='checkallDateEnable' value="<%=i%>">	
<%
}
}
catch(Exception e)
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
	<input type='hidden' name='row_count' id='row_count' id='row_count' value="<%=row_count%>">
	<input type='hidden' name='fm_disp' id='fm_disp' value="<%=fm_disp%>">
	<input type='hidden' name='to_disp' id='to_disp' value="<%=to_disp%>">
	<input type="hidden" name="optionValStr" id="optionValStr" value=""/>
	<input type='hidden' name='fromStart' id='fromStart' value='<%=start%>'></input>
	<input type='hidden' name='chk_count' id='chk_count' id='chk_count' value="<%=chk_count%>">
	<input type="hidden" name="facility_id1" id="facility_id1" value="<%=facilityId%>"/>
	 
    
</form>
<script>
var checkallDateEnable=document.getElementsByName("checkallDateEnable").length;
var chk_count=parseInt(document.getElementById("chk_count").value);
if((checkallDateEnable == chk_count) && (!checkallDateEnable==0 && !chk_count==0))
document.forms[0].allChecked.checked = true; 
</script>
</body>
</html>

