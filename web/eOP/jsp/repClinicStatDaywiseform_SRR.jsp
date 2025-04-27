<!DOCTYPE html>

<%--
Filename		: repClinicStatDaywiseform.jsp
Modified On		: 2-3-2005
Version			: 3
--%>

<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function searchCode(obj,target)
{
	var sql="";
	var sqlSecond="";
	var facilityid =document.forms[0].p_for_facility_id.value;	
	var tit="";
	/*var practitionerName="";
	var practitionerValue="";
	var practitionerTypevalue="";*/
	var locale = "<%=localeName%>";
		
	target.value=trimString(target.value);

	if(target.value=="" && window.event.target == target)
		return;
	
	var argumentArray=new Array(8);

	if(obj.name=="tolocn" || obj.name=="fromlocn")
    {
        tit=getLabel("Common.Location.label","Common");

		//SQL

        //argumentArray[0]="select clinic_code code, short_desc description from op_clinic where facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
		argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where language_id='"+locale+"' and facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";
                
		argumentArray[1]=new Array("facility_id");
		argumentArray[2]=new Array(facilityid);
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
     var retVal=CommonLookup(tit,argumentArray);

	if(retVal==null || retVal=="")
		target.value="";
	else
		target.value=retVal[0];          

}


function validate_dateTo(obj) {
		var from = obj.value;
		var to   = document.forms[0].CurrentDate.value;
		var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
		if (CheckDate(obj)){
			if(Date.parse(todt) < Date.parse(fromdt)) {//DATE_NOT_LESS_SYSDATE
					var invaldt = getMessage("TO_DT_NGE_CURR_DATE","SM") ;
					var visit_Date=getLabel('Common.to.label','common_labels')+" "+getLabel('Common.VisitDate.label','op_labels');
					invaldt = invaldt.replace('To date',visit_Date);
					alert(invaldt);
					document.forms[0].p_to_visit_date.select();
					document.forms[0].p_to_visit_date.focus();
				}
			}
		}
		function validate_dateFrom(obj){
			var from = obj.value;
			var to   = document.forms[0].CurrentDate.value;
			var fromarray;
			var toarray;
			fromarray  = from.split("/");
			toarray    = to.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
			var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
			if (CheckDate(obj)){
				if(Date.parse(todt) < Date.parse(fromdt)) {//DATE_NOT_LESS_SYSDATE
					var invaldtFrom = getMessage("FROM_DT_NGE_CURR_DATE","SM") ;
					var visit_fromDate=getLabel('Common.from.label','common_labels')+" "+getLabel('Common.VisitDate.label','op_labels');
					invaldtFrom = invaldtFrom.replace('From date',visit_fromDate);
					alert(invaldtFrom);
					document.forms[0].p_fm_visit_date.select();
					document.forms[0].p_fm_visit_date.focus();
					}
				}
		}


		

	function setValue()
{
				
if ( repClinicStatDaywiseform.sum_id.checked == true)
     {
	    repClinicStatDaywiseform.p_sum_yn.value="Y";			 
	  }              
	  if ( repClinicStatDaywiseform.detail_id.checked == true)
        {
	     repClinicStatDaywiseform.p_sum_yn.value="N";
		}             
}

function setDate(Object){ 
//var currentDate = new Date();
       if(Object.value!="")
	{
	   if (isBeforeNow(Object.value,"DMY",localeName))
        {
          return true;
        }
        else
        {
			alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
			Object.value="";
            Object.focus();            
        }
    }
	}
</script>
<%
    String p_module_id      = "OP" ;
    String p_report_id      = "OPBDYCST" ;
    String p_facility_id        = (String) session.getValue( "facility_id" ) ;
    String p_user_name      = (String) session.getValue( "login_user" ) ;
	String CurrentDate = "";
    Statement stmt=null;
    ResultSet rset=null ;
    Connection con=null;
    String ID="";
    String dat="";
    String en="";

    try{
		con=ConnectionManager.getConnection(request); 
%>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<center>
    <form name="repClinicStatDaywiseform" id="repClinicStatDaywiseform" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
    <BR>
    <table width='80%' align='center' valign='top'>
	<tr>
    <td class='columnheader'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
    </tr>
	</table>   
    <table width='80%' cellPadding="2" cellSpacing="0"  align='center' border='0'>        
		<tr>
				<td class="label" ><fmt:message key="Common.facility.label" 	 bundle="${common_labels}"/></td>				
				<td class='fields' colspan='2'><select name='p_for_facility_id' id='p_for_facility_id' >
					<%
					stmt=con.createStatement();
					rset=stmt.executeQuery("SELECT facility_id,sm_get_desc.SM_FACILITY_PARAM(facility_id,'"+localeName+"',1) facility_name,to_char(sysdate,'dd/mm/yyyy')CurrentDate FROM SM_FACILITY_FOR_USER WHERE appl_user_id='"+p_user_name+"' ORDER BY facility_name");
                    
					if(rset!=null)
					{
					while(rset.next())
					{
					dat=rset.getString("FACILITY_NAME");
					ID=rset.getString("FACILITY_ID");
					CurrentDate=rset.getString("CurrentDate");

					out.println("<option value='"+ID+ "' "+en+">"+dat+"</option>");
					}%>
					</select>
					<%  }

					%>
				</td>					
			</tr> 
			 <tr>
					<td >&nbsp;</td>
					<td class="querydata" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class="querydata" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>
					<!-- <td class="label"><fmt:message key="Common.VisitDate.label" bundle="${op_labels}"/></td> -->
					<td class="label"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type=text id='p_fm_visit_date'  name='p_fm_visit_date' id='p_fm_visit_date' size="10" maxlength="10" align="left" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_visit_date');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>	
					<td class='fields'><input type=text id='p_to_visit_date'  name='p_to_visit_date' id='p_to_visit_date' size="10" maxlength="10" align="left" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_visit_date');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>
					</td>
			</tr> 

			<tr class='fields'>
				<td class="label"><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" name="p_fm_specialty_code" id="p_fm_specialty_code" size="4" maxlength="4" onBlur='searchCode(fromspecialty,this)'><input type='button' name='fromspecialty' id='fromspecialty' value='?' class='button' onclick='searchCode(this, p_fm_specialty_code)'>
				</td>
				<td class='fields'><input type="text" name="p_to_specialty_code" id="p_to_specialty_code" size="4" maxlength="4" onBlur='searchCode(tospecialty,this)'><input type='button' name='tospecialty' id='tospecialty' value='?' class='button' onclick='searchCode(this, p_to_specialty_code)'>
				</td>
			</tr>

			<tr>
				<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" name="p_fm_locn_code" id="p_fm_locn_code" size="4" maxlength="4" onBlur='searchCode(fromlocn,this)'><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode(this, p_fm_locn_code)'>
				</td>
				<td class='fields'><input type="text" name="p_to_locn_code" id="p_to_locn_code" size="4" maxlength="4" onBlur='searchCode(tolocn,this)'><input type='button' name='tolocn' id='tolocn' value='?' class='button' onclick='searchCode(this, p_to_locn_code)'>
				</td>
			</tr>

			<!-- </table>
				<table width='80%' align='center' valign='top'>
				<tr> 
				<td align='right' width='23%' class="label"> -->
				<tr>
						<td class="label"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></td>
						<td class='fields'><input type='radio' id='sum_id' name='p_sum_yn' id='p_sum_yn' value = 'Y' onClick="setValue();">
						<!-- <td align='right' width='3%' class="label"> -->
						<fmt:message key="Common.Detail.label" bundle="${common_labels}"/>
						<input type='radio' id='detail_id' name='p_sum_yn' id='p_sum_yn' value = 'N' checked onClick="setValue();"></td>
                 </tr>   
               
	<!-- 			</tr>
        </table>     -->
        <input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
        <input type="hidden" name="p_module_id" id="p_module_id"         value="<%= p_module_id %>">
        <input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
        <input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
		<input type="hidden" name="CurrentDate" id="CurrentDate"		value="<%= CurrentDate %>">

<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>

        
    </form>
<% }
	catch(Exception e)
	{ out.println(e.toString());}
finally{
	try{
if(stmt != null) stmt.close();
if(rset != null) rset.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
 if( con !=null ) ConnectionManager.returnConnection(con,request);
}
%>
</center>
</body>
</html>

