<!DOCTYPE html>

<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8"); 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String p_facility_id		= (String) session.getValue( "facility_id" );
String p_user_name		= (String) session.getValue( "login_user" );
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js" language='javascript'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
async function searchCode(obj,target)
{
	var sql="";
	var sqlSecond="";
	var facilityid = "<%=p_facility_id%>";
	var tit="";
	var locale = "<%=localeName%>";
	target.value=trimString(target.value);
	if(target.value=="" && window.event.target == target)
	return;
	var argumentArray=new Array(8);
          tit=getLabel("Common.speciality.label","Common");
		argumentArray[0]="select speciality_code code, short_desc description from am_speciality_lang_vw where '1' like ? and language_id='"+locale+"' and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
                
				argumentArray[1]=new Array("'1'");
				argumentArray[2]=new Array("1");
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;
          var retVal=await CommonLookup(tit,argumentArray);

	    var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retVal==null || retVal=="")
				target.value="";
			else
				target.value=arr[0];
}


/*function validateDate(obj)
	{
		if(obj.value!="")
		{
			if(validDate(obj.value,'DMY',localeName)==false)
				{
				alert(getMessage("INVALID_DATE_FMT","SM"));
				obj.select();	
				return false;
			}
			else
				return true;
		}
	}*/
</script>

<%
    String p_module_id      = "OP" ;
    String p_report_id      = "OPBFPWLS" ;
  //  String p_facility_id        = (String) session.getValue( "facility_id" ) ;
    //String p_user_name      = (String) session.getValue( "login_user" ) ;
	String locale=(String)session.getAttribute("LOCALE");

    Connection con =null;
    ResultSet rset =null;
    Statement stmt=null;
    String ID="";
    String dat="";
    String en="";
	String isSpltyNurUnitToEnableYNAppl="";
    try{
		con = ConnectionManager.getConnection(request);
		isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
%>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<center>
    <form name="repFcywisePractWorkloadform" id="repFcywisePractWorkloadform" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
    <BR><!--BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR-->
<table width='80%' align='center' valign='top' border='0'>
<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
</table>
<table width='80%' cellPadding="2" cellSpacing="0" align='center' border='0'>
<tr>
<td class="label" width='33%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td class='fields' width='33%' colspan='2'>
<select name='p_for_facility_id' id='p_for_facility_id' >
<%
    stmt=con.createStatement();
	
	//rset=stmt.executeQuery("select facility_id,facility_name from  SM_FACILITY_FOR_USER_VW where appl_user_id='"+p_user_name+"' order by facility_name ");
    
	rset=stmt.executeQuery("select facility_id,sm_get_desc.SM_FACILITY_PARAM(facility_id,'"+locale+"',1)facility_name from  SM_FACILITY_FOR_USER where appl_user_id='"+p_user_name+"' order by facility_name ");
    
	if(rset!=null)
    {
       while(rset.next())
       {
            dat=rset.getString("FACILITY_NAME");
            ID=rset.getString("FACILITY_ID");
            
            out.println("<option value='"+ID+ "' "+en+">"+dat+"</option>");
       }%>
      </select>
<%  }
    
%>
</td>
</tr>
<tr>
    <td >&nbsp;</td>
    <td class="querydata"  style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
    <td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
</tr>

<tr>
    <td class="label"><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
    <td class='fields'><input type=text  id='mdsfrom' name='p_fm_dt' id='p_fm_dt' size="10" maxlength="10"  onBlur="validDateObj(this,'DMY',localeName);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsfrom');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>        
    <td class='fields'><input type=text  id='mdsto' name='p_to_dt' id='p_to_dt' size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsto');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>
</tr>
<!-- Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1 -->	
<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<tr>
					<jsp:include page="../../eIP/jsp/CommonSpecialityLookup.jsp">
					<jsp:param name="speciality_code_Appl" value="p_fm_specialty_code"/>
					<jsp:param name="speciality_to_code_Appl" value="p_to_specialty_code"/>
					</jsp:include>
					</tr>
<%}else{%>
<tr>
	<td class="label"><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="p_fm_specialty_code" id="p_fm_specialty_code" size="4" maxlength="4" onBlur='searchCode(this,p_fm_specialty_code)'><input type='button' name='fromspec' id='fromspec' value='?' class='button' onclick='searchCode(this, p_fm_specialty_code)'>
	</td>	
	<td class='fields'><input type="text" name="p_to_specialty_code" id="p_to_specialty_code" size="4" maxlength="4" onBlur='searchCode(this,p_to_specialty_code)'><input type='button' name='tospec' id='tospec' value='?' class='button' onclick='searchCode(this, p_to_specialty_code)'>
	</td>
</tr><%}%>
		
	</table>


  <br>
        <input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
        <input type="hidden" name="p_module_id" id="p_module_id"         value="<%= p_module_id %>">
        <input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
        <input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
        <input type="hidden" name="p_fr_date" id="p_fr_date"           value="">
        <input type="hidden" name="p_to_date" id="p_to_date"           value="">

	<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>

    </form>

<% }
catch(Exception e) {out.println(e.toString());}
finally{
if(stmt != null) stmt.close();
if(rset != null) rset.close();
if( con !=null ) ConnectionManager.returnConnection(con,request);
}

%>

</center>
</body>
</html>

