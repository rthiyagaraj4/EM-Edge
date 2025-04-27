<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@page  import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*,eCommon.Common.CommonBean"%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script type='text/javascript' src='../../eOT/js/Booking.js'></script>
<script type="text/javascript" src="../../eOT/js/OTCommon.js"></script>
<script language='javascript'>
function callPatientSearch(){
	var patient_id	=	document.forms[0].patient_id;
	var return_value =	"";
	return_value	=	PatientSearch();	
	if(return_value!=null && return_value !="undefined"){
		document.forms[0].patient_id.value=return_value;
	}else{
		document.forms[0].patient_id.value="";
	}
	document.forms[0].submit();
}
function funResetAll(){
	var frmObj=document.forms[0];
	frmObj.oper_date.value="";
	frmObj.patient_id.value="";
	frmObj.patientName.value="";
	frmObj.sex.value="";
	frmObj.oper_num.value="";
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="addlSearchCriteriaForm" id="addlSearchCriteriaForm" method='post' action="../../eOT/jsp/PickGenPatientDtl.jsp">

<%

String sql="";

String 	strFacilityId=(String)session.getValue("facility_id"); 	 

Connection con = ConnectionManager.getConnection(request);
PreparedStatement pstmt = null;
ResultSet rs=null;
String strPatientId="";
String strName="";
String strSex="";
String strAge="";
String strOperDate="";

try
{
strOperDate=CommonBean.checkForNull(request.getParameter("oper_date"));
strPatientId=CommonBean.checkForNull(request.getParameter("patient_id"));


  if(strPatientId!=null&&!strPatientId.equals(""))
	  {

sql=OTRepository.getOTKeyValue("SQL_OT_PICGENBYDTL_SELECT1");

/*sql="  SELECT SHORT_NAME SHORT_NAME1, DECODE(SEX,'M', 'Male', 'F', 'Female', 'Unknown') SEX1 , DATE_OF_BIRTH DATE_OF_BIRTH1  FROM MP_PATIENT_MAST  WHERE PATIENT_ID = ?";
*/

		 pstmt = con.prepareStatement(sql);
		 pstmt.setString(1,locale);
		 pstmt.setString(2,strPatientId);
		 rs=pstmt.executeQuery();
		 if(rs.next())
		  {
		 strName=CommonBean.checkForNull(rs.getString("SHORT_NAME1"));
		 strAge=CommonBean.checkForNull(rs.getString("DATE_OF_BIRTH1"));
		 strSex=CommonBean.checkForNull(rs.getString("SEX1"));
		  }
	   rs.close();	  
	  pstmt.close();
 }


%>

<table cellpadding=3  cellspacing="0" border="0" width="100%" align ="center" >
<tr>

<td class="label" width="25%" >
	<fmt:message key="eOT.OperationDate.Label" bundle="${ot_labels}"/>
</td>
<td  class="fields" width="25%" >
<input type='text' name='oper_date' id='oper_date' size='11'   value='<%=strOperDate%>'  maxlength='10' >	
<image src="../../eCommon/images/CommonCalendar.gif"	
onClick="return showCalendar('oper_date');">		
<img src='../../eCommon/images/mandatory.gif'></img>
</td>
<td colspan='2'></td>
</tr>


<tr>
<td class="label" align="right" >
	<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
</td>
<td  class="fields" width="25%" >
<input type='text' name='patient_id' id='patient_id' maxlength='20' size='20' value= "" readonly>
<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="callPatientSearch();">
</td>
<td class="label" width="25%" >
<input type='text' name='patientName' id='patientName' maxlength='60' size='45' value= "<%=strName%>" >
</td>
</tr>


<tr>
<td  class='label' width="25%">
	<fmt:message key="Common.gender.label" bundle="${common_labels}"/>	
</td>

<td class="fields" width="25%" >
<input type='text' name='sex' id='sex' value='<%=strSex%>'>
</td>

<td  class='label' width="25%" >
	<fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/>	
<input type='text' name='dob' id='dob' size='11'   value='<%=strAge%>'  maxlength='10' disabled>	</td>
<td  class='label' width="25%" >
<fmt:message key="eOT.OperationNo.Label" bundle="${ot_labels}"/>
<select name='oper_num' id='oper_num'>
	<option value=''>
	<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
	</option>
<%


strPatientId=CommonBean.checkForNull(request.getParameter("patient_id"));
if(strPatientId.length()>0 )
{

sql=OTRepository.getOTKeyValue("SQL_OT_PICGENBYDTL_SELECT2");

   
/*	sql="SELECT OPER_NUM  FROM OT_POST_OPER_HDR  WHERE OPERATING_FACILITY_ID = ?  AND OPER_DATE = ?  AND PATIENT_ID = NVL(?, PATIENT_ID)";
*/

pstmt=con.prepareCall(sql);
pstmt.setString(1,strFacilityId);
pstmt.setString(2,strOperDate);
pstmt.setString(3,strPatientId);
rs=pstmt.executeQuery();

String dumValue="";
while(rs.next())
	{
	dumValue=rs.getString(1);
	out.println("<option value='"+dumValue+"'>"+dumValue+"</option>");
	}
	rs.close();
	pstmt.close();
}
%>
</select>

</td>		
</tr>
<tr>
	<td class="fields" width="25%">
	<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="">
	<input type="button" class="button" name="clear" id="clear" value='fmt:message key="Common.clear.label" bundle="${common_labels}"/>'	onClick="funResetAll()"
	</td>
	</tr>

<% 	  
}catch(Exception ee){}
finally
{
if(rs!=null) rs.close();	
if(pstmt!=null)
pstmt.close();
ConnectionManager.returnConnection(con,request);
}

%>
</table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

