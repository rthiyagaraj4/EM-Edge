<!DOCTYPE html>
<%--
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Name			:	WorkplaceRosterCriteria.jsp
*	Purpose 		:	
*	Modified By		:	Karabi S.
*	Modified On		:	10th Dec 2004.
* --%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<%
String function_id = request.getParameter( "function_id") ;
%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"></script> -->
<script language="javascript" src="../js/RSCommonFunction.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/WorkplaceRoster.js"></script>
<script language="javascript" src="../js/WorkplaceRosterArrows.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function viewWorkplace(obj,target)
{
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no"; 
			var arguments	= "" ;
			var sql="";
			var sql1="";
			var search_code="";
			var search_desc="";
			var retVal =    new String();
			var argumentArray=new Array(8);
           
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var tit="";				
			var locn_type="";				
			var facilityId = "";
			var locale = "";
			facilityId = document.forms[0].facilityId.value;
			locale = document.forms[0].locale.value;
			locn_type = document.forms[0].locn_type.value;
			if(locn_type=='')
			//sql= "select workplace_code code ,workplace_desc Description from rs_workplace where facility_id = '"+facilityId+"' and eff_status = 'E' and upper(workplace_code) like upper(?) and upper(workplace_desc) like upper(?) order by 2";
			sql= "select workplace_code code ,workplace_desc Description from rs_workplace_lang_vw where facility_id = '"+facilityId+"' and eff_status = 'E' and upper(workplace_code) like upper(?) and upper(workplace_desc) like upper(?) and language_id = '"+locale+"'order by 2";
			else
			//sql="select workplace_code code ,workplace_desc Description from rs_workplace where facility_id = '"+facilityId+"' and  locn_type = '"+locn_type+"' and eff_status = 'E'  and upper(workplace_code) like upper(?) and upper(workplace_desc) like upper(?) order by 2";
			sql="select workplace_code code ,workplace_desc Description from rs_workplace_lang_vw where facility_id = '"+facilityId+"' and  locn_type = '"+locn_type+"' and eff_status = 'E'  and upper(workplace_code) like upper(?) and upper(workplace_desc) like upper(?) and language_id = '"+locale+"' order by 2";
			
			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
			tit="Staff Workplace"
			
			
				argumentArray[0] =sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;
				retVal = await CommonLookup( tit, argumentArray );
		
		if(retVal != null && retVal != "" )
		{
			
			var ret1=unescape(retVal);
			var arr=ret1.split(",");
			
				document.forms[0].workplace_Id.value= arr[1];
				document.forms[0].workplace_code.value= arr[0];
		}
		else
		{	
			document.forms[0].workplace_Id.value= "";
		}
}
</script>
</head>
<body>
<%
Connection Con			= null;
PreparedStatement pstmt_currdate = null;
ResultSet rs_currdate		= null;
PreparedStatement pstmt_locn = null;
ResultSet rs_locn		= null;

String facility_id	=(String)session.getValue( "facility_id" ) ;

String currentdate="";
try
{
Con=ConnectionManager.getConnection(request);
pstmt_currdate=Con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy') d from dual ");
rs_currdate=pstmt_currdate.executeQuery();
rs_currdate.next();
currentdate = rs_currdate.getString("d");
%>
<form name='WorkplaceRosterCriteriaform' id='WorkplaceRosterCriteriaform' >
<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center>
<tr>
<td width="40%"  align=right class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp;</td>
<td align="left" class="label" width="20%">&nbsp;<select name="locn_type" id="locn_type" onchange="clearw_place();"><option value="" selected>&nbsp&nbsp--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>
<%
pstmt_locn =Con.prepareStatement("select locn_type,short_desc from am_care_locn_type order by short_desc");
rs_locn = pstmt_locn.executeQuery();
while(rs_locn!=null  && rs_locn.next())
{
out.println("<option value='"+rs_locn.getString(1)+"'>"+rs_locn.getString(2)+""); 
}
%>
</select>
<td align="left" class="label" width="15%">
<td class=label colspan='4'>&nbsp;&nbsp;</td>
</tr>
<tr>
<td width="40%"  align=right class="label"><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/>&nbsp;</td>
<td >&nbsp;<input type=text name="workplace_Id" id="workplace_Id" value="" readonly size="30" onBlur=''><input class='button' type=button name="workplacelookup_button" id="workplacelookup_button" value="?"  onClick='viewWorkplace(this,workplace_Id)'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
<!-- <input type='hidden' name='staff_id' id='staff_id' value=''> -->
<td  id='role_type_desc' align="left" class="label" width="15%">
<td class=label colspan='4'>&nbsp;&nbsp;</td>
</tr>
<tr>
<td width="40%"  align=right class="label"><fmt:message key="eRS.DurationFrom.label" bundle="${rs_labels}"/>&nbsp;</td>
<td>&nbsp;<input type=text name="from_date" id="from_date" id='id_from_date' value="" size="11" maxlength="10" onBlur='if(CheckDate(this))validate("FROM_DATE_LESS_SYSDATE");'><img  name='from_date_img' src='../../eCommon/images/CommonCalendar.gif' onclick="return showCal(from_date, 'id_from_date');">&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
<td width="20%"  align=right class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td>&nbsp;<input type=text name="to_date" id="to_date" id='id_to_date' value="" size="11" maxlength="10" onBlur='if(CheckDate(this))validate("TO_DT_GR_EQ_FM_DT");//getdate();'><img  name='to_date_img' src='../../eCommon/images/CommonCalendar.gif' onclick="return showCal(to_date, 'id_to_date');">&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
<input type='hidden' name='from_date1' id='from_date1' value=''>
<input type='hidden' name='to_date1' id='to_date1' value=''>
<td width="20%"  align=right class="label">&nbsp;&nbsp;</td>
<td align='center' colspan='1'>&nbsp;<input class='button' type=button name="Search" id="Search" value='<fmt:message key="Common.search.label"  bundle="${common_labels}"/>'onClick='WorkplaceDetails()'></td>
<td width="20%"  align=right class="label">&nbsp;&nbsp;</td>
</tr>
<tr>
<td colspan="7">&nbsp;</td>
</tr>
<%-------------------------datas returned frm skill modal window--------------------------------%>

<input type='hidden' name='WorkplaceID' id='WorkplaceID' value=''>
<input type='hidden' name='workplace_code' id='workplace_code' value=''>
<input type='hidden' name='funcVal' id='funcVal' value=''>
<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
<input type='hidden' name='db_action' id='db_action' value=''>
<input type='hidden' name='facilityId' id='facilityId' value='<%=facility_id%>'>
<input type='hidden' name='workplace_name' id='workplace_name' value=''>
<input type='hidden' name='workplace_type' id='workplace_type' value=''>
<input type='hidden' name='mode' id='mode' value=''>
<input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'>
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<input type='hidden' name='getFlag' id='getFlag' value='N'>
<%-------------------------datas returned frm skill modal window--------ends--------------------%>

</form>
</body>
<%	}
catch(Exception e){out.println(e.toString());}
finally
{
	if(rs_currdate !=null) rs_currdate.close();
	if(pstmt_currdate !=null) pstmt_currdate.close();
	if(rs_locn !=null) rs_locn.close();
	if(pstmt_locn !=null) pstmt_locn.close();
    ConnectionManager.returnConnection(Con,request);
}%>
</html>

