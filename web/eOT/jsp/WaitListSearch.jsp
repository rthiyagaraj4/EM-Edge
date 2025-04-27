<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,eOT.*,eCommon.XSSRequestWrapper,eOT.Common.OTRepository,eCommon.Common.*"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%	request.setCharacterEncoding("UTF-8");
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends
%>

<html>
<head>               
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	//Added against MO-CRF-20086-US1 Starts Here
	String bean_id = "OTCommonBean";
	String bean_name = "eOT.OTCommonBean";
	OTCommonBean bean = (OTCommonBean)mh.getBeanObject( bean_id, request, bean_name );
	ArrayList ORCategoryTypeList=bean.getORCategoryType();
	//Added against MO-CRF-20086-US1 Ends Here
%>
	<link rel='stylesheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
	<script language="JavaScript" src="../../eOT/js/Booking.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>	
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>	
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>



<script language='javascript'>

function funResetAll()
{
	var frmObj=document.forms[0];
	frmObj.SURGEON.value="";
	frmObj.SURGEON_CODE.value="";
	frmObj.SPECIALITY_CODE.value="";
	frmObj.SPECIALITY_DESC.value="";
	frmObj.patientid.value="";
	frmObj.patientName.value="";
	frmObj.orderid.value="";
	frmObj.from_date.value="";
	frmObj.to_date.value="";	
	frmObj.status.value="A";
}


function callPatientSearch()
{
	var patient_id	=	document.forms[0].patientid;
	var patient_name	=	document.forms[0].patientName;
	var return_value =	"";
     
	document.forms[0].patientName.value="";
	return_value	=	(patient_id.value.length>0)?patient_id.value:PatientSearch();
	if(return_value==null)  return;
	var obj=document.forms[0];
	if(return_value!=null)
	{
		obj.patientid.value	=	return_value;
	}
	else
	{
		obj.patientid.value	="";
	}
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=patient_search&patient_id="+return_value,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText); 
	if(retVal=="INVALID_PATIENT"){
			alert(getMessage("INVALID_PATIENT","MP"));
			patient_id.value="";
			patient_name.value="";
			patient_id.focus();
			return
	}
	
	if(retVal!="" ){
			var retVal_arr = retVal.split("##");
			patient_id.value		=return_value
			patient_name.value		= retVal_arr[0];
	}


document.forms[0].submit();
}
function clearDesc(){
	var formObj = document.forms[0];
	var pat_id=formObj.patientid.value;
	if(pat_id=="" || pat_id==null || pat_id=="null" || pat_id=="undefined")
	formObj.patientName.value="";
	
}
function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789/';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<body >
<%
	String facilityid=(String)session.getValue("facility_id");

	String sql="";
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String preferedDate="",strPatientId="",strSurgeonName="",strSpecialityDesc="",strPatientName="";	
	strPatientId=CommonBean.checkForNull(request.getParameter("patientid"));
	strSurgeonName=CommonBean.checkForNull(request.getParameter("SURGEON"));
	strSpecialityDesc=CommonBean.checkForNull(request.getParameter("SPECIALITY_DESC"));		String PatIDLen="";
    	String category="";//Added against MO-CRF-20086-US1
try{

		conn = ConnectionManager.getConnection(request);
	
		 String sqlLen ="SELECT PATIENT_ID_LENGTH,to_char(SYSDATE,'dd/mm/yyyy') SYSDATE1 FROM MP_PARAM ";
		 pstmt=conn.prepareStatement(sqlLen);
		 rs=pstmt.executeQuery();
		 if(rs.next() && rs!=null)
		{
		 PatIDLen   = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");
		  preferedDate=com.ehis.util.DateUtils.convertDate(rs.getString("SYSDATE1"),"DMY","en",locale);
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

	if(strPatientId.length()>0)
	{


	 sql="SELECT decode (?,'en',PATIENT_NAME, NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) SHORT_NAME1 FROM MP_PATIENT  WHERE PATIENT_ID =?";		 	 
	 	pstmt=conn.prepareCall(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,strPatientId);
		rs=pstmt.executeQuery();

	if(rs.next())
	{	    
   			strPatientName=rs.getString("SHORT_NAME1");
			strPatientName=strPatientName==null?"":strPatientName;

	}


}
}catch(Exception ee)
{
	ee.printStackTrace();
}
finally
{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
ConnectionManager.returnConnection(conn,request);

}
%>
<form name="VerificationSearchForm" id="VerificationSearchForm" >

<table cellpadding=2 cellspacing="0" width="100%" align="center" border="0">

<tr>
	<td class="label" width='25%' nowrap>
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
<td class="fields" width='25%' nowrap>
	<input name='SPECIALITY_DESC' id='SPECIALITY_DESC' maxlength='20' size='20' value= "<%=strSpecialityDesc%>" onBlur="if(this.value!='')return searchSpeciality(SPECIALITY_DESC); else SPECIALITY_CODE.value='' ">
	<input type='button' class='button' value='?' name='surButton' id='surButton'   onClick="return searchSpeciality(SPECIALITY_DESC);">
</td> 
<td class="label" width='25%' nowrap>
	<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
</td>
<td class="fields" width='25%' nowrap>
	<input name='SURGEON' id='SURGEON' maxlength='20' size='20' value= "<%=strSurgeonName%>"  onBlur="if(this.value!='') return searchSurgeon(SURGEON); else SURGEON_CODE.value='' " >
	<input type='button' class='button' value='?'  name='surButton' id='surButton' onClick="return searchSurgeon(SURGEON); " >
</td>
<tr>
	<td class="label" width='25%' nowrap>
		<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
	</td>
	<td class="fields" width='25%' nowrap>
		<input type='text' name='patientid' id='patientid' maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>' onkeypress="return CheckForSpecChars(event)" onBlur="if(this.value!='')callPatientSearch();else clearDesc();" value= "<%=strPatientId%>" >
		<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="callPatientSearch();">
	</td>
	<td class="label" width='25%' nowrap>
		<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
	</td>  
	<td class="fields" width='25%' nowrap>
		<input type='text' name='patientName' id='patientName' maxlength='30' size='30' value= "<%=strPatientName%>" >
	</td>
</tr>
<tr>
	<td class="label" width='25%' nowrap>
		<fmt:message key="Common.OrderID.label" bundle="${common_labels}"/>
	</td>
	<td class="fields" width='25%' nowrap>
		<input type='text' name='orderid' id='orderid' maxlength='20' size='20' value= "" onBlur="if(this.value!='')searchorderid(orderid);" >
		<input type='button' class='button' value='?' onClick="searchorderid(orderid);" >
	</td>
<td class='label' width='25%'>
	<fmt:message key="Common.status.label" bundle="${common_labels}"/>
</td>
<td class='fields' width='25%'>
	<select class='label' name='status' id='status' >
		<option  value='A'>
			<fmt:message key="Common.all.label" bundle="${common_labels}"/>
		</option>
		<option  value='S'>
			<fmt:message key="eOT.BookedCases.Label" bundle="${ot_labels}"/>
		</option>
		<option  value='U'>
			<fmt:message key="eOT.UnScheduledCases.Label" bundle="${ot_labels}"/>
		</option>
</select>
</td>

</tr>


<tr>

	<td align="left" class="label"  ><fmt:message key="eOT.PreferredSurgeryDate.Label" bundle="${ot_labels}"/> <fmt:message key="Common.from.label" bundle="${common_labels}"/>
</td>
	<td class="fields" width='25%' nowrap>
	
		<input type="text" name="from_date" id="from_date" size="10" value= "<%=preferedDate%>" maxlength='10'  Onblur="isValidDate(this);"  onkeypress="return checkForSpecCharsforID(event);">
		<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('from_date');">
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
<td class="label" width="25%" >
				<fmt:message key="Common.todate.label" bundle="${common_labels}"/>   
		</td>
		<td class="fields" width="25%" >
				<input type='text' class="fields" name='to_date' id='to_date' size='11' value=''  maxlength='10' Onblur='isValidDate(this);'  onkeypress="return checkForSpecCharsforID(event);"> 
				<img src="../../eCommon/images/CommonCalendar.gif" onblur='isValidDate(this);'	onClick="return showCalendar('to_date','dd/mm/y');">
		 </td>
</tr>
<!--Added against MO-CRF-20086-US1 Starts Here-->
<tr>
	<td align="left" class="label">Category Type
	</td>
	<td class="fields" width='25%' nowrap>	
	<select name="category" id="category" id="category">
	<option value="">select</option>
	<% 
		Iterator ORCategoryTypeItr=ORCategoryTypeList.iterator();
		 while(ORCategoryTypeItr.hasNext()) {
		 category=(String)ORCategoryTypeItr.next();
    	%>
		<option value="<%=category%>"><%=category%></option>
	<%	
      		}
	%>
	</select>
	</td>
	<td class="label" width="25%"><fmt:message key="Common.priority.label" bundle="${common_labels}"/>
	</td>
	<td class="fields" width="25%">
	<select class='label' name='priority' id='priority' id='priority' >
				<option  value=''><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<option  value='Priority-1'><fmt:message key="eOT.priority1.label" bundle="${ot_labels}"/></option>
				<option  value='Priority-2'><fmt:message key="eOT.priority2.label" bundle="${ot_labels}"/></option>
				<option  value='Priority-3'><fmt:message key="eOT.priority3.label" bundle="${ot_labels}"/></option>
	</select>
	</td>
</tr>
<!--Added against MO-CRF-20086-US1 Ends Here-->


<tr>
	<td colspan='4' align='right'>
	<input type="button" class="button" name="search" id="search" 
	value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="funWaitListSearch()">
	<input type="button" class="button" name="clear" id="clear"
	value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' 	onClick="funResetAll()">
	</td>
</tr>
</table>
   <!-- added by Rajesh for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->

<input type='hidden' name='SPECIALITY_CODE' id='SPECIALITY_CODE' value=''>
<input type='hidden' name='SURGEON_CODE' id='SURGEON_CODE' value=''>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facilityid%>'>
<input type='hidden' name='theatre_type_code' id='theatre_type_code' value=''>
<input type='hidden' name='sequence' id='sequence' value='N'>
<input type='hidden' name='room_code' id='room_code' value=''>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>

</body>
</html>

