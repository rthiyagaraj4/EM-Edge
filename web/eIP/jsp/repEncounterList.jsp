<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<%
String sStyle	=   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>
<%@ page import ="java.util.*" %>
<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eMR/js/MRReports.js" language="javascript"></script>
 <script src="../../eCommon/js/DateUtils.js"></script>
 <script src="../../eCommon/js/CommonCalendar.js"></script>
   <script language='javascript' src='../../eCommon/js/dchk.js' ></script>
  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script> 
<script>

function callSearchScreen()
{
	var patientid = PatientSearch('','','','','','','Y','','','VIEW');
	if(patientid !=null)
	document.forms[0].p_patient_id.value = patientid; 
	document.forms[0].p_patient_id.focus();
}
function validate_date(obj) {
		var from = obj.value;
	
		var to   = document.forms[0].CurrentDate.value;

		var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if (CheckDate(obj)){
			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=(getLabel("Common.encounterdate.label","Common"));
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}
function ComparePeriodFromToTime(from,to)
{
	
	var frdt = from.value;
	
	var tdt = to.value;
	var greg_tdt = "";
	var greg_frdt = "";

	if(frdt !="" && validDate(frdt,"DMY","en"))
	{
		greg_frdt = convertDate(frdt,"DMY",localeName,"en");
		
	}

	if(to !="" && validDate(tdt,"DMY","en"))
	{
		greg_tdt = convertDate(tdt,"DMY",localeName,"en");
	}
       //alert("greg_frdt="+greg_frdt);
		//alert("greg_tdt="+greg_tdt);
	if(greg_frdt != "" && greg_tdt !="")
	{
		//alert("greg_frdt1="+greg_frdt);
		//alert("greg_tdt1="+greg_tdt);
	//alert(greg_tdt < greg_frdt);
		
		if(greg_tdt < greg_frdt)
		{
		
			alert( getMessage("TO_DT_GR_EQ_FM_DT",'SM') );
			document.forms[0].p_to_enc_date.focus();
			document.forms[0].p_to_enc_date.select();
		}
	}
}
/*function PatValidations(obj)
{

	if(document.forms[0].p_patient_id.value!='')
	{
	    var fields = new Array (document.forms[0].p_patient_id); 
	
        var names = new Array (getLabel("Common.patientId.label","Common"));
		var patient_id = document.forms[0].p_patient_id.value;
		var error_jsp="";
		var messageFrame="";
			
	    var HTMLVal = "<HTML><BODY><form name='valid_form' id='valid_form' method='post' action='../../eMR/jsp/MRPatientIDValidations.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'></form></BODY></HTML>";

	    parent.messageFrame.document.write(HTMLVal);
	    parent.messageFrame.valid_form.submit();
	}
}*/

</script>
<%@ page import="java.sql.*" %>
<%
	String p_module_id		= "MR" ;
	String p_report_id		= "MRBENLST";
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String resp_id=(String) session.getValue("responsibility_id");

    Connection con = null;
	ResultSet rset = null ;
	//ResultSet rset1 = null ;
	Statement stmt = null;
	//Statement stmt1 = null;
	String patient_id_length = "";
	ResultSet rs = null;

	con = ConnectionManager.getConnection(request);
try
{
	//con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();
	//rs = stmt.executeQuery("select patient_id_length from MP_PARAM");
	rs = stmt.executeQuery("select patient_id_length from MP_PARAM where MODULE_ID='MP'");

	if(rs != null && rs.next())
	{
		patient_id_length = rs.getString("patient_id_length");
	}
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
}catch(Exception e)
{
	//out.println("Exception @tryCatch : "+e.getMessage());
	e.printStackTrace();
}
%>
<%
stmt = con.createStatement();
String str = "select to_char(sysdate,'dd/mm/yyyy') from dual";
	String CurrentDate="";
	try{
		stmt=con.createStatement();
		rs = stmt.executeQuery(str);	
		while (rs.next())
			CurrentDate= rs.getString(1);

	}
	catch(Exception e)
	{}
	finally
	{
		if(stmt!=null) stmt.close();
		if(rs!=null)	rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
<html>
<HEAD>

</HEAD>
<BODY  onMouseDown="CodeArrest();" onKeyDown='lockKey()' onLoad="Focusing('p_all_facility_id')">
<br>
<br>
<form name="repencounterlist" id="repencounterlist" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='50%' align='center' valign='top' cellPadding='3' cellSpacing='0'>
<tr>
<td class='columnheader' colspan='8'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
</tr>
		<tr>
    	<td class='label' colspan='8'>&nbsp;</td>
		</tr>
	<tr>
		<td class="label" width='50%'> <fmt:message key="Common.facility.label" bundle="${common_labels}"/> </td>
		<td class='fields' width='50%' colspan='8'>
		<select name='p_all_facility_id' id='p_all_facility_id' >
		<option value='ALL' selected><fmt:message key="Common.AllAccessFacilities.label" bundle="${common_labels}"/></option>
		<%
		try
		{
			if(stmt != null) stmt.close();
			stmt=con.createStatement();
			//String sql_facility="select facility_id, facility_name  from SM_FACILITY_FOR_USER_VW where appl_user_id='"+p_user_name+"'";	
			
			String sql_facility="select facility_id, SM_GET_DESC.SM_FACILITY_PARAM(facility_id,'"+localeName+"','1') facility_name  from SM_FACILITY_FOR_USER where  appl_user_id='"+p_user_name+"'";

			rset=stmt.executeQuery(sql_facility);
			if(rset!=null)
			{
			   while(rset.next())
			   {
					String fid= rset.getString("facility_id");;
					String fname=rset.getString("facility_name");;
					if(fid == null) fid	=	"";
					if(fname == null) fname = "";
						out.println("<option value='"+fid+ "' >"+fname+"</option>");
			   }
			}
				if(rset != null)rset.close();
				if(stmt != null)stmt.close();
			}catch(Exception e)
			{
				//out.println(e);
				e.printStackTrace();
			}
			finally
			{ 
				ConnectionManager.returnConnection(con,request);
			}
		%>	
		</select>
		</td>
		 </tr>
		  <tr>
		 	 <td class="label"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/> </td>
			 <td class='fields'><input type=text  name='p_patient_class' id='p_patient_class' size="2" maxlength="3" align="center"  ><input type='hidden' name='patient_class1' id='patient_class1' value=''><input type='button' name='patient_class' id='patient_class' value='?' class='button' onclick='searchCoderepEnc(this,p_patient_class,this)'>
			 </td>
		 </tr>
  		  <tr> 
		 	<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>  </td>
			<td class='fields'><input type=text  onblur="ChangeUpperCase(this);" name='p_patient_id' id='p_patient_id' size="20" maxlength="<%=patient_id_length%>" align="center"><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen();//searchCoderepEnc(this,p_patient_id,p_patinet_class)'><img src='../../eCommon/images/mandatory.gif'></td>
		 </tr>
		 <tr>
		 <td class="label"><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/>  </td>
		 <td class='fields'>
               <input type='text' id='ecfrom' name='p_fr_enc_date' id='p_fr_enc_date' value='' size='10' maxlength='10' Onblur="validDateObj(this,'DMY','<%=localeName%>');validate_date(this);ComparePeriodFromToTime(this,p_to_enc_date)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('ecfrom');"></input><img src="../../eCommon/images/mandatory.gif"></img>
        </td>
        <td class="label" ><td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/>  </td>
         <td class='fields'> <input type='text' id='ecto' name='p_to_enc_date' id='p_to_enc_date' value='' size='10' maxlength='10'Onblur="validDateObj(this,'DMY','<%=localeName%>');validate_date(this);ComparePeriodFromToTime(p_fr_enc_date,this)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('ecto');"></input><img src="../../eCommon/images/mandatory.gif"></img>
	    </td>
		</tr>
		 <tr>
			<td class="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> </td> 
			<td class='fields'>
			<select name='p_order_by' id='p_order_by'>
				<option value='1'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
				<option value='2'><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/>
			</select>
			</td>
		 </tr>
		 <tr>
			<td class='label' colspan='2'>&nbsp;</td>
		 </tr>
	</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"	  value="<%=p_module_id%>">
	<input type="hidden" name="p_report_id" id="p_report_id"   value="<%=p_report_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	  value="<%=p_user_name%>">
	<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"	  value="<%=resp_id%>">
		<input type="hidden" name="CurrentDate" id="CurrentDate"			value="<%= CurrentDate %>">
</form>
</BODY>
</HTML>

