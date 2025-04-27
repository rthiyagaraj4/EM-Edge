<!DOCTYPE html>

<%--
Filename		: repWalkinWithoutApptform.jsp
Modified On		: 1-3-2005
Version			: 3
--%>

<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale=(String)session.getAttribute("LOCALE");
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src="../../eCommon/js/common.js" language='javascript'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

<%-- Code added/modified by Tushar .T. Bhat on 09-Feb-04 for incorporating enterable look-up --%>


async function searchCode(obj,target)
{
			var facilityid = document.forms[0].p_for_facility_id.value;
			var locale = document.forms[0].locale.value;
			var sql="";
			var tit="";
			
			target.value=trimString(target.value);

			if(target.value=="" && window.event.target == target)
				return;
			
			var argumentArray=new Array(8);

            if(obj.name=="toservice" || obj.name=="fromservice")
            {
                tit=getLabel("Common.service.label","Common");

				//SQL

                //argumentArray[0]="select SERVICE_CODE code, short_desc description from am_service where '1' like ? and upper(service_code) like upper(nvl(?,service_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

				argumentArray[0]="select SERVICE_CODE code, short_desc description from am_service_lang_vw where '1' like ? and language_id='"+locale+"' and upper(service_code) like upper(nvl(?,service_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
                
				argumentArray[1]=new Array("'1'");
				argumentArray[2]=new Array("1");
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;

			}
			else if(obj.name=="tospecialty" || obj.name=="fromspecialty")
            {
                tit=getLabel("Common.speciality.label","Common");

				//SQL

                //argumentArray[0]="select speciality_code code, short_desc description from am_speciality where '1' like ? and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

				argumentArray[0]="select speciality_code code, short_desc description from am_speciality_lang_vw where '1' like ? and language_id='"+locale+"' and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
                
				argumentArray[1]=new Array("'1'");
				argumentArray[2]=new Array("1");
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;

            }
			else if(obj.name=="tolocn" || obj.name=="fromlocn")
            {
                tit=getLabel("Common.Location.label","Common");

				//SQL
				
				//argumentArray[0]="select clinic_code code, short_desc description from op_clinic where facility_id like ? and language_id='"+locale+"' and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
                
				argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id like ? and language_id='"+locale+"' and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";
                
				argumentArray[1]=new Array("facility_id");
				argumentArray[2]=new Array(facilityid);
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;
               
            }
			
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
	
	<%-- Code added/modified by Tushar .T. Bhat on 09-Feb-04 ends --%>

function chmonth(obj)
{
    if(obj.value != "")
	{
		if(validDate(obj.value,'MM',localeName)==false)
		{
			var msg=getMessage("MONTH_IS_GR_12","COMMON");
			alert(msg);
			//obj.select();
            obj.value="";
			return false;
		}	
		else 
			return true;			
	}
}

function validateYear(obj)
	{
		if(obj.value!="")
		{
			if(validDate(obj.value,'YY',localeName)==false)
				{
				alert(getMessage("INVALID_YR_FORMAT", "SM"));
				//obj.select();
                obj.value="";	
				return false;
			}
			else
				return true;
		}
}

</script>


<%
    String p_module_id      = "OP" ;
    String p_report_id      = "OPBMTWPA" ;
	String p_facility_id    = (String) session.getValue( "facility_id" ) ;
    String p_user_name      = (String) session.getValue( "login_user" ) ;

    Connection con = null;
    Statement stmt=null;
    ResultSet rset=null ;
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
    <form name="repWalkinWithoutApptform" id="repWalkinWithoutApptform" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
    <BR><!--BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR-->
<table width='80%' align='center' valign='top'>
<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
</table>

<table width='80%' cellPadding="2" cellSpacing="0" align='center' border='0'>
<tr>
<td class="label" width='33%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td class='fields' colspan='2'>
<select name='p_for_facility_id' id='p_for_facility_id' >
<%
    stmt=con.createStatement();
    //rset=stmt.executeQuery("select facility_id,facility_name from  SM_FACILITY_FOR_USER_VW where appl_user_id='"+p_user_name+"' order by 2 ");
	
	rset=stmt.executeQuery("select facility_id,sm_get_desc.SM_FACILITY_PARAM(facility_id,'"+locale+"',1)facility_name from  SM_FACILITY_FOR_USER where appl_user_id='"+p_user_name+"' order by 2");

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
    <td width='33%'>&nbsp;</td>
    <td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
    <td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
</tr>
<tr>
    <td  class="label" ><fmt:message key="Common.month.label" bundle="${common_labels}"/>/<fmt:message key="Common.year.label" bundle="${common_labels}"/></td>
    <td  class='fields'>
               <input type=text  name='p_fm_mon' id='p_fm_mon' size="2" maxlength="2" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="chmonth(this);">
               /
               <input type=text  name='p_fm_year' id='p_fm_year' size="4" maxlength="4" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="validateYear(this);"><img src='../../eCommon/images/mandatory.gif'></img>
        </td>        
        <td class='fields'>
               <input type=text  name='p_to_mon' id='p_to_mon' size="2" maxlength="2" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="chmonth(this);">
               /
               <input type=text  name='p_to_year' id='p_to_year' size="4" maxlength="4" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="validateYear(this);"><img src='../../eCommon/images/mandatory.gif'></img>
        </td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="p_fm_locn_code" id="p_fm_locn_code" size="4" maxlength="4" onBlur='searchCode(fromlocn,this)'><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode(this, p_fm_locn_code)'>
	</td>
	<td class='fields'>
	    <input type="text" name="p_to_locn_code" id="p_to_locn_code" size="4" maxlength="4" onBlur='searchCode(tolocn,this)'><input type='button' name='tolocn' id='tolocn' value='?' class='button' onclick='searchCode(this, p_to_locn_code)'>
	</td>
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
<tr class='fields'>
	<td class="label"><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="p_fm_specialty_code" id="p_fm_specialty_code" size="4" maxlength="4" onBlur='searchCode(fromspecialty,this)'><input type='button' name='fromspecialty' id='fromspecialty' value='?' class='button' onclick='searchCode(this, p_fm_specialty_code)'>
	</td>
	<td class='fields'><input type="text" name="p_to_specialty_code" id="p_to_specialty_code" size="4" maxlength="4" onBlur='searchCode(tospecialty,this)'><input type='button' name='tospecialty' id='tospecialty' value='?' class='button' onclick='searchCode(this, p_to_specialty_code)'>
	</td>
</tr><%}%>
<tr>
	<td class="label"><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="p_fm_service_code" id="p_fm_service_code" size="4" maxlength="4" onBlur='searchCode(fromservice,this)'><input type='button' name='fromservice' id='fromservice' value='?' class='button' onclick='searchCode(this, p_fm_service_code)'>
	</td>	
	<td class='fields'><input type="text" name="p_to_service_code" id="p_to_service_code" size="4" maxlength="4" onBlur='searchCode(toservice,this)'><input type='button' name='toservice' id='toservice' value='?' class='button' onclick='searchCode(this, p_to_service_code)'>
	</td>
</tr>
</table>

   <br>
        <input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
        <input type="hidden" name="p_module_id" id="p_module_id"         value="<%= p_module_id %>">
        <input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
        <input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
		<input type="hidden" name="locale" id="locale"				value="<%=locale%>">
        <input type="hidden" name="p_fr_month" id="p_fr_month"          value="">
        <input type="hidden" name="p_to_month" id="p_to_month"          value="">

	<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>

    </form>
<% }
catch(Exception e) {out.println(e.toString());} 

finally
{
	try
	{
		if(stmt != null) stmt.close();
		if(rset != null) rset.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	if(con!=null)
    ConnectionManager.returnConnection(con,request);
}
%>
</center>
</br>
</html>

