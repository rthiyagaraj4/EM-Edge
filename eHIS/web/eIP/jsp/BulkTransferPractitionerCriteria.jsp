<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale				= (String)session.getAttribute("LOCALE");
	Connection con					= null;
	
	try
			{
				String jsp_name			= checkForNull(request.getParameter("jsp_name"));
				String win_height		= checkForNull(request.getParameter("win_height"));
				String win_width		= checkForNull(request.getParameter("win_width"));
				String call_function	= checkForNull(request.getParameter("call_function"));
				String modal			= checkForNull(request.getParameter("modal"));
				String dialogTop		= checkForNull(request.getParameter("dialogTop"));
				String module			= checkForNull(request.getParameter("module"));
				String model_window		= checkForNull(request.getParameter("model_window"));
				String function_id		= checkForNull(request.getParameter("function_id"));
				String prog_id			= checkForNull(request.getParameter("prog_id"));
				String practitioner_id	= checkForNull(request.getParameter("practitioner_id"));
				String wherecondn		= checkForNull(request.getParameter("wherecondn"));
				String operstn			= checkForNull(request.getParameter("oper_stn_id"));
				String facilityID		= (String)session.getValue("facility_id");
				String loginUser		= (String)session.getValue("login_user");
				String routine_tfr_yn	= "";
				String frpractdesc		= "";
	
				try
					{
						con				= ConnectionManager.getConnection(request);	
						Statement stmt	= null;
						ResultSet rs	= null;
						if(rs != null)
							{
								 frpractdesc			    = checkForNull(rs.getString("practitioner_name"));
							}
	
			

		
%>	

	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eIP/js/BulkTransferPractitioner.js' language='javascript'></script>
		<script src='../../eIP/js/IPPractitionerComponent.js' language='javascript'></script>
		<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
		<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<Script>



async function submitPage()
		{
		
			var condition=""
				for(var i=0; i<document.forms[0].elements.length; i++){
						condition+= document.forms[0].elements[i].name +"="+ escape(document.forms[0].elements[i].value)+"&"}
						//document.forms[0].search.disabled=true;
			oper_stn = document.forms[0].operstn.value;
			routine_tfr_yn = document.forms[0].routine_tfr_yn.value;
			call_function =document.forms[0].call_function.value;
			nursing_unit =document.forms[0].nursing_unit.value;

			var Splcode=document.forms[0].Splcode.value;
			var practid_from=document.forms[0].practid_from.value;
			var practid_to=document.forms[0].practid_to.value;
			var fromdate=document.forms[0].admn_date_from.value;
			var todate=document.forms[0].admn_date_to.value;
			

			var trans_type=document.forms[0].transfer_type.value;
			//alert(trans_type);
			
			var frAttendingPractitioner = getLabel("Common.from.label","Common" ) + " " +(getLabel("Common.AttendingPractitioner.label","Common"));
			//alert(frAttendingPractitioner);

			var toAttendingPractitioner = getLabel("Common.to.label","Common" ) + " " +(getLabel("Common.AttendingPractitioner.label","Common"));
			//alert(toAttendingPractitioner);

			var fields=new Array(document.forms[0].practid_desc_from,
								 document.forms[0].transfer_type,
								 document.forms[0].practid_desc_to);
			
			
			/*var names = new Array(getLabel("Common.from.label","Common" ).concat(getLabel("Common.AttendingPractitioner.label","Common")),
				getLabel("eIP.TransferType.label","Ip"),
				getLabel("Common.to.label","Common")
				.concat(getLabel("Common.AttendingPractitioner.label","Common")));*/

				var names = new Array(frAttendingPractitioner,
				getLabel("eIP.TransferType.label","Ip"),
				toAttendingPractitioner);
			
			
			
				if(await checkFields( fields, names, parent.messageFrame))
				{
					if(practid_from == practid_to)
						{
						//alert("Both Practitioner can not be Same")
						alert(getMessage("TO_PRACT_FROM_PRACT","IP"));
						await clearAll();
						}
					else
						{
						document.forms[0].search.disabled=true;
						parent.frames[2].location.href= "../../eIP/jsp/BulkTransferPractitionerResult.jsp?nursing_unit="+nursing_unit+"&Splcode="+Splcode+"&practid_from="+practid_from+"&practid_to="+practid_to+"&fromdate="+fromdate+"&todate="+todate+"&trans_type="+trans_type;
						parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
						
						}
				}
				

}
			
		</Script>
	</head>
	<body onLoad= 'FocusFirstElement()' onSelect="codeArrestThruSelect()" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
		<form name='BulkTransferPractitioner_Form' id='BulkTransferPractitioner_Form' action='' target='result' >
			<table cellspacing=0 cellpadding=0 align='center'  width='100%' border='0' cellpadding=0 cellspacing=0>
				<tr>
					<td class="columnheader">
						<fmt:message key="Common.TransferFrom.label" bundle="${common_labels}"/>
					</td>				 
				</tr>
			</table>
			<table cellspacing=0 cellpadding=0 width='100%' border='0' align='center'>
 				<tr>
					<td class='label' width="25%">&nbsp;</td>
					<td class='label' width="25%">&nbsp;</td>
					<td class='label' width="25%">&nbsp;</td>
					<td class='label' width="25%">&nbsp;</td>
				</tr>
				<tr>
					<td class='label' >
						<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
					</td>
					<td class='fields' >
						<input type=text name=nursing_unit_desc id=nursing_unit_desc size=15 onblur="beforeGetNursingUnit(nursing_unit_desc, '<%=facilityID%>','<%=loginUser%>','<%=operstn%>');"><input type=button class=button name='nursing_unit_lookup' id='nursing_unit_lookup' value='?' onClick="getNursingUnit(nursing_unit_desc, '<%=facilityID%>','<%=loginUser%>','<%=operstn%>');">
						<input type="hidden" class=label name="nursing_unit" id="nursing_unit">
					</td>
					<!--<% if(modal.equals("")) 
						{ 
					%>	-->
				
					<td class='label'  nowrap width="25%"><fmt:message key="eIP.AdmDateFrom.label" bundle="${ip_labels}"/></td>
					
					<td  class='fields' width='25%'  nowrap>
						<input type='text' id="admn_date_from" maxlength='10' size='10' name='from_date' id='from_date'  value="" onBlur='compareDates(this);'>
						<input type="image"  src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].admn_date_from.focus();return showCalendar('admn_date_from');">
						<input type="hidden"  name="fromdate" id="fromdate" value=""> - <input type='text' id="admn_date_to" value="" maxlength='10' size='10' name='to_date' id='to_date' onBlur='compareDates(this);'>
						<input type ="image" src ='../../eCommon/images/CommonCalendar.gif' onClick = "document.forms[0].admn_date_to.focus();return showCalendar('admn_date_to');" >
						<input type="hidden"  name="todate" id="todate" value="">
					</td>
				
				
		<!--<% }%>-->
			
				</tr>
				<tr>
					<td  class='label' >
						<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
					</td>
					<td class='fields'>
						<input type=text name="specialty_desc" id="specialty_desc" size=15 onblur="beforeGetSpecialty(this, '<%=facilityID%>');"><input type="hidden" class=label name="Splcode" id="Splcode" size=15 readonly><input type=button class=button name='specialty_lookup' id='specialty_lookup' value='?' onClick="getSpecialty(specialty_desc, '<%=facilityID%>')">
					</td>

					<td  class='label' nowrap >
						<fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/> 
					</td>
					<td class='fields'>
						<input type='text' name='practid_desc_from' id='practid_desc_from' value="" size="30" maxlength="30" onblur="beforeGetPractitioner(practid_from,practid_desc_from, '<%=facilityID%>');" ><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="getPractitionerLocal(practid_from,practid_desc_from, '<%=facilityID%>');" ><img  src="../../eCommon/images/mandatory.gif">
						<input type='hidden' name='practid_from' id='practid_from' value="" size="15" maxlength="15">
						
					</td>
		
				</tr>
			
			</table>
			<table cellspacing=0 cellpadding=0 align='center'  width='100%' border='0' cellpadding=0 cellspacing=0>
				<tr>
					<td class="columnheader">
						<fmt:message key="Common.TransferTo.label"bundle="${common_labels}"/>
					</td>
				</tr>
			</table>
			
			<table cellspacing=0 cellpadding=0 align='center'  width='100%' border='0' cellpadding=0 cellspacing=0>
				<tr>
					<td class="label" width="25%">
						<fmt:message key="eIP.TransferType.label" bundle="${ip_labels}"/>
					</td>
					<td width="25%" class="fields">
						<select name="transfer_type" id="transfer_type">
							<option value="">
							-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
							<%
							stmt = con.createStatement();
							rs = stmt.executeQuery(" select transfer_type_code,short_desc from ip_transfer_type_lang_vw where language_id= '"+locale+"' and eff_status = 'E' order by short_desc ");
							while(rs.next())
							{
								String desc = rs.getString("short_desc");
								String code = rs.getString("transfer_type_code");

								out.print("<option value=\""+code+"\" >"+desc );
							}
							%>
						</select><img  src="../../eCommon/images/mandatory.gif">
					</td>
					<td class="label" width="25%">
						<fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/>
					</td>
					<td nowrap width="35%">
						<input type='hidden' name='practid_to' id='practid_to' value="" size="15" maxlength="15">
						<input type='text' name='practid_desc_to' id='practid_desc_to' value="" size='30' maxlength='30'width='15'  onblur="beforeGetPractitioner(practid_to,practid_desc_to, '<%=facilityID%>');"><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button'  onclick="getPractitionerLocal(practid_to,practid_desc_to,'<%=facilityID%>');"><img  src="../../eCommon/images/mandatory.gif">
					</td>
				</tr>
			</table>
			<table cellspacing=0 cellpadding=0 align='center'  width='100%' border='0' cellpadding=0 cellspacing=0>
				<tr>
					<td  align="right">
						<input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick='submitPage()'>
						<input type='button' class='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'  onclick='clearAll()'>
					</td>
				</tr>
			</table>
		<input type='hidden' name='jsp_name' id='jsp_name' value="<%=jsp_name%>" >
		<input type='hidden' name='win_height' id='win_height' value="<%=win_height%>" >
		<input type='hidden' name='win_width' id='win_width' value="<%=win_width%>" >
		<input type='hidden' name='param' id='param' value="<%=call_function%>" >	
		<input type='hidden' name='dialogTop' id='dialogTop' value="<%=dialogTop%>" >
		<input type='hidden' name='modal' id='modal' value="<%=modal%>" >
		<input type='hidden' name='module' id='module' value="<%=module%>" >
		<input type='hidden' name='model_window' id='model_window' value="<%=model_window%>" >
		<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>" >
		<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" >
		<input type='hidden' name='wherecondn' id='wherecondn' value="<%=wherecondn%>" >
		<input type='hidden' name='prog_id' id='prog_id' value="<%=prog_id%>" >
		<input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=practitioner_id%>" >
		<input type='hidden' name='operstn' id='operstn' value="<%=operstn%>" >
		<input type='hidden' name='loginUser' id='loginUser' value="<%=loginUser%>" >
		<input type='hidden' name='hid_facility_ID' id='hid_facility_ID' value="<%=facilityID%>" >
		<input type='hidden' name='locale' id='locale' value="<%=locale%>">  
		<input type='hidden' name='routine_tfr_yn' id='routine_tfr_yn' value="<%=routine_tfr_yn%>" >
	</form>
</body>
<% 
}
catch(Exception e)	
{
	out.println(e);
}
		}
		catch(Exception e)
		{
			out.println(e);
		}
finally
{
		ConnectionManager.returnConnection(con,request);	
		out.print("<script>if(parent.frames[1].document.forms[0] != null)");	out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
}
%>
</html>
<%!
	///  these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

