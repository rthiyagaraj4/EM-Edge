<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.Statement,java.sql.PreparedStatement,org.json.simple.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	String locale				= (String)session.getAttribute("LOCALE");
	Connection con				= null;
	PreparedStatement pstmt		= null;
	ResultSet rset				= null;
	PreparedStatement dynstmt   = null;
	ResultSet dynrset			= null;	
	//Statement reqStmt			= null;
	PreparedStatement reqStmt=null;
	ResultSet reqRs				= null;
	int reqCount					 = 0;
%>
<HTML>

<HEAD>
<%@ include file="../../eMP/jsp/PatientAddressLegends.jsp" %>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eMR/js/Requestor.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function chkValidEmail(obj)
{
	if(obj.value != '')
	{
		var pattern = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+/;
		if(pattern.test(obj.value) == false)
		{  
			alert(getMessage("INVALID_EMAIL_ID","CA"));
			obj.focus();
			return false;
		}
	}
}
</script>

<%
  


	request.setCharacterEncoding("UTF-8");
	try
	{
		con = ConnectionManager.getConnection(request);
	}
	catch(Exception e)
	{
		out.println("Exception while fetching connection "+e.toString());
		e.printStackTrace();
	}
	//String Site="";
	String[] contact_col_names = null ;
	String[] contact_prompts = null ;
	String[] contact_fields = null ;
	Properties p		= (java.util.Properties) session.getValue("jdbc");
	ArrayList contact_addr = fetchContactAddresses(con, out,"parent.messageFrame",p) ;
	//Site = (String)contact_addr.get(0) ;
	if(contact_addr != null)
	{
		contact_col_names = (String[])contact_addr.get(1) ;
		contact_prompts   = (String[])contact_addr.get(2) ;
		contact_fields    = (String[])contact_addr.get(3) ;
	}	
	contact_addr = null;
%>
</HEAD>
<BODY onSelect="codeArrestThruSelect()" OnMouseDown="CodeArrest()"  onKeyDown = 'lockKey()' onload="effcheck(); ReqTypeValue();">
<!-- ReqTypeValue() method Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->
<%
	String facilityId = (String)session.getValue("facility_id");
	String funcname="insert";
	String requestorcode="";
	String longdesc="";
	String shortdesc="";
	int indicators=0;
	String addrline1="";
	String addrline2="";
	String addrline3="";
	String addrline4="";
	String contactno="";
	String othercontactno="";
	String email="";
	String towncode="";
	String towncodes="";
	String regioncode="";
	String regioncodes="";
	String postalcode="";
	String postalcodes="";
	String areacode="";
	String areacodes="";
	String countrycode="";
	String countrycodes="";
	String effstatus="";
	String check="checked";
	String readonly="";
	String code = request.getParameter("requestor_code");
	try{	
		if(code == null) 		
		{
			code = "";
		}
		else
		{

			check="";
			funcname  = "modify";
			readonly="readonly";
			pstmt=con.prepareStatement("select * from MR_REQUESTOR where requestor_code = ? and facility_id = ?");
			pstmt.setString(1,code);
			pstmt.setString(2,facilityId);
			rset=pstmt.executeQuery();
			if(rset != null && rset.next()) 
			{
	    		
				requestorcode = checkForNull(rset.getString("requestor_code"));

				longdesc = checkForNull(rset.getString("long_desc"));
				
				shortdesc= checkForNull(rset.getString("short_desc"));
				
				indicators=rset.getInt("indicator");
				
				addrline1=checkForNull(rset.getString("addr_line1"));
				addrline2=checkForNull(rset.getString("addr_line2"));
				addrline3=checkForNull(rset.getString("addr_line3"));
				addrline4=checkForNull(rset.getString("addr_line4"));

				towncode=checkForNull(rset.getString("town_code"));
				
				if (!towncode.equals(""))
				{
					dynstmt=con.prepareStatement("select long_desc from mp_res_town  where res_town_code='"+towncode+"'");
					dynrset=dynstmt.executeQuery();
					if(dynrset != null && dynrset.next())
						towncodes=checkForNull(dynrset.getString("long_desc"));
					if(dynstmt	 != null)	dynstmt.close();
					if(dynrset	 != null)	dynrset.close();
				}
				else
				{
					towncodes="";
				}
				areacode=checkForNull(rset.getString("area_code"));
				if (!areacode.equals(""))
				{
					dynstmt=con.prepareStatement("select long_desc from mp_res_area  where res_area_code='"+areacode+"'");
					dynrset=dynstmt.executeQuery();
					if(dynrset != null && dynrset.next())
						areacodes=checkForNull(dynrset.getString("long_desc"));
					if(dynstmt	 != null)	dynstmt.close();
					if(dynrset	 != null)	dynrset.close();
				}
				else
				{
					areacodes="";
				}
				regioncode=checkForNull(rset.getString("region_code"));
				if (!regioncode.equals(""))
				{
				   dynstmt=con.prepareStatement("select long_desc from mp_region  where region_code='"+regioncode+"'");
				   dynrset=dynstmt.executeQuery();
				   if(dynrset != null && dynrset.next())
					   regioncodes=checkForNull(dynrset.getString("long_desc"));
				   if(dynstmt	 != null)	dynstmt.close();
				   if(dynrset	 != null)	dynrset.close();
				}
				else
				{
					regioncodes="";
				}
				postalcode=checkForNull(rset.getString("postal_code"));
				

				if (!postalcode.equals(""))
				{
				   dynstmt=con.prepareStatement("select postal_code from mp_postal_code  where postal_code='"+postalcode+"'");
				   dynrset=dynstmt.executeQuery();
				   if(dynrset != null && dynrset.next())
					   postalcodes=checkForNull(dynrset.getString("postal_code"));
				   if(dynstmt	 != null)	dynstmt.close();
				   if(dynrset	 != null)	dynrset.close();
				}
				else
				{
					postalcodes="";
				}
				countrycode=checkForNull(rset.getString("country_code"));
				if (!countrycode.equals(""))
				{
				 dynstmt=con.prepareStatement("select long_name from mp_country  where country_code='"+countrycode+"'");
				 dynrset=dynstmt.executeQuery();
				 if(dynrset != null && dynrset.next())
					 countrycodes=checkForNull(dynrset.getString("long_name"));
				 if(dynstmt	 != null)	dynstmt.close();
				 if(dynrset	 != null)	dynrset.close();
				}
				else
				{
				 countrycodes="";
				}
				contactno= checkForNull(rset.getString("CONTACT1_NO"));
				othercontactno= checkForNull(rset.getString("CONTACT2_NO"));
				email=checkForNull(rset.getString("email_id"));
				effstatus=rset.getString("eff_status");
				if(effstatus.equals("E"))
					check="checked";
				else
					check="";
			}
		
		
			String reqSql	= " SELECT COUNT (*) FROM mr_report_request_hdr WHERE facility_id=? AND requestor_code =? ";

		//reqStmt	= con.createStatement();
		reqStmt = con.prepareStatement(reqSql);
		reqStmt.setString(1,facilityId);
		reqStmt.setString(2,code);
		reqRs	= reqStmt.executeQuery();
		
		if( reqRs != null && reqRs.next())
		{
			reqCount	= reqRs.getInt(1);
		}

		if(reqRs !=null) reqRs.close();
		if(reqStmt !=null) reqStmt.close();
	}

%>
<FORM METHOD=POST ACTION="../../servlet/eMR.RequestorServlet" name="Requestor" id="Requestor" target='dummyFrame'>
	<BR><BR><BR><BR>
      	
<table cellspacing= border='1' cellpadding=5 align=center width='auto'>


<tr>
	<td class='label' width='50%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td width='50%' class='fields'>
	<input type="text" Size='10' maxlength=10 value="<%=requestorcode%>" name="requestor_code" <%=readonly%> onkeypress="return CheckForSpecChars(event);">
	<img align='center' src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td class='fields'>
	<input type="text" Size='30' maxlength='30' value="<%=longdesc%>" name="long_desc">
	<img align='center' src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>&nbsp;</td>
	<td class='fields'>
	<input type="text" size='15' maxlength='15' value="<%=shortdesc%>" name="short_desc">
	<img align='center' src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

<!--Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->
<tr>
<td class='label' ><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
<td class='fields'>
<SELECT name="requestor_type" id="requestor_type">
	<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
		<%
			JSONArray RequestorTypeJsonArr = new JSONArray();
			RequestorTypeJsonArr  = eMR.MRCommonBean.getRequestorTypeForRequestor(con);

			for(int i = 0 ; i < RequestorTypeJsonArr.size() ; i++) 
			{
				JSONObject json	= (JSONObject)RequestorTypeJsonArr.get(i);
				String requestor_type_code  = (String) json.get("requestor_type_code");
				String long_desc  = (String) json.get("long_desc");
				out.println("<option value='"+requestor_type_code+ "'>"+long_desc+"</option>");	
			}		
		%>
</SELECT>
<img align='center' src='../../eCommon/images/mandatory.gif'></img>
</td>
</tr>

<tr>
	<td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class='fields'>
	<INPUT TYPE="checkbox" name="requestor_status" id="requestor_status" onclick="effcheck()" <%=check%>>
	</td>
</tr>
<tr>
<td colspan='2' class="COLUMNHEADER"><fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/></td>
</tr>
<%
	StringBuffer sb1 = new StringBuffer();
	StringBuffer fieldVal = new StringBuffer();

	for(int i=0;i<contact_col_names.length; i++)
	{
		out.println("<tr>") ;                                    
		out.println("<td class='label'>"+contact_prompts[i]+"</td>") ;
		String val  = contact_fields[i] ;

		if(sb1.length()>0) sb1.delete(0,sb1.length());
		if(fieldVal.length()>0) fieldVal.delete(0,fieldVal.length());
		
		sb1 = new StringBuffer(val);
		fieldVal = new StringBuffer("");
		
		for(int z=0;z<val.length();z++)
		{
			String tempVal=sb1.substring(z,z+1);
			if(tempVal.equals("@"))
			{
				fieldVal.append("");
			}
			else
			{
				fieldVal.append(tempVal);
			}
		}
		val = fieldVal.toString();
		val = val.replace("parent.messageFrame", "parent.parent.messageFrame");

		out.println(
		"<td class='fields' >"+val+"</td></tr>") ;


		val = contact_fields[i] ;

//		String old_val = "" ;
//		String new_val = "" ;

		if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
		 {
//			old_val = "r_addr_line1" ;
//			new_val = "m_addr_line1" ;
		 }
		 else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
		 {
//			old_val = "r_addr_line2" ;
//			new_val = "m_addr_line2" ;
		 }
		 else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
		 {
//			old_val = "r_addr_line3" ;
//			new_val = "m_addr_line3" ;
		 }
		 else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
		 {
//			old_val = "r_addr_line4" ;
//			new_val = "m_addr_line4" ;
		 }
		 else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
		 {
//			old_val = "r_town_code" ;
//			new_val = "m_town_code" ;
		}
		 else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
		 {
//			old_val = "r_region_code" ;
//			new_val = "m_region_code" ;
		 }
		 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
		 {
//			old_val = "r_area_code" ;
//			new_val = "m_area_code" ;
		 }                                     
		 else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
		 {
//			old_val = "r_postal_code" ;
//			new_val = "m_postal_code" ;
		 }
	}
%>
<tr>
	<td class='label' ><fmt:message key="Common.country.label" bundle="${common_labels}"/> </td>
	<td class='fields'>
	<input align='left' type='text' name='requestor_country' id='requestor_country' size='20' maxlength='20'  onblur='if(this.value !="")searchCountry(contry_code,requestor_country);'  value='<%=countrycodes%>'><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,requestor_country)'>
	<input type='hidden' name='req_country_code' id='req_country_code' value=''>
   </td>
</tr>
<tr>
	<td class='label' ><fmt:message key="eMR.ContactNumber.label" bundle="${mr_labels}"/></td>
 	<td class='fields'>
<input align='left' type='text' maxlength='10' onKeyPress="return CheckForSpecCharsInReq(event)" value="<%=contactno%>" name='requestor_contactno' size='15'> / <input align='left' type='text' value="<%=othercontactno%>" name='requestor_othercontactno'size='15' onKeyPress="return CheckForSpecCharsInReq(event)"
	maxlength='10'> 
 </td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
	<td class='fields'>
	<input type='text' maxlength='50' onBlur="return chkValidEmail(this)"
	value="<%=email%>"name='requestor_emailid'size='15'> </td>
</tr>
</table>
<input type='hidden' name='r_area' id='r_area' value=''>
<input type='hidden' name='r_town' id='r_town' value=''>
<input type='hidden' name='r_region' id='r_region' value=''>
<input type='hidden' name='r_postal' id='r_postal' value=''>
<input type='hidden' name='r_postal_code' id='r_postal_code' value=''>
<input type="hidden" name="function_name" id="function_name" value= '<%=funcname%>'>
<input type='hidden' name='postal_code' id='postal_code'>
<input type='hidden' name='town_code' id='town_code'>
<input type='hidden' name='region_code' id='region_code'>
<input type='hidden' name='area_code' id='area_code'>

<input type='hidden' name='h_r_addr_line1' id='h_r_addr_line1'>
<input type='hidden' name='h_r_addr_line2' id='h_r_addr_line2'>
<input type='hidden' name='h_r_addr_line3' id='h_r_addr_line3'>
<input type='hidden' name='h_r_addr_line4' id='h_r_addr_line4'>
<input type='hidden' name='h_r_area_code' id='h_r_area_code'>
<input type='hidden' name='h_r_region_code' id='h_r_region_code'>
<input type='hidden' name='h_r_town_code' id='h_r_town_code'>
<input type='hidden' name='h_r_postal_code1' id='h_r_postal_code1'>
<input type='hidden' name='requestorCodeCount' id='requestorCodeCount' value="<%=reqCount%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

<!--Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->
<input type='hidden' name='indicators' id='indicators' value="<%=indicators%>">

<script>
if ("<%=funcname%>" == "modify")
{
	if(document.Requestor.r_addr_line1)	document.Requestor.r_addr_line1.value = "<%=addrline1%>";
	if(document.Requestor.h_r_addr_line1)	document.Requestor.h_r_addr_line1.value = "<%=addrline1%>";

	if(document.Requestor.r_addr_line2)		document.Requestor.r_addr_line2.value = "<%=addrline2%>";
	if(document.Requestor.h_r_addr_line2)		document.Requestor.h_r_addr_line2.value = "<%=addrline2%>";

	if(document.Requestor.r_addr_line3)		document.Requestor.r_addr_line3.value = "<%=addrline3%>";
	if(document.Requestor.h_r_addr_line3)		document.Requestor.h_r_addr_line3.value = "<%=addrline3%>";

	if(document.Requestor.r_addr_line4)		document.Requestor.r_addr_line4.value = "<%=addrline4%>";
	if(document.Requestor.h_r_addr_line4)		document.Requestor.h_r_addr_line4.value = "<%=addrline4%>";

	if(document.Requestor.r_area_code)		document.Requestor.r_area_code.value = "<%=areacodes%>";
	if(document.Requestor.h_r_area_code)		document.Requestor.h_r_area_code.value = "<%=areacodes%>";

	if(document.Requestor.r_region_code)		document.Requestor.r_region_code.value = "<%=regioncodes%>";
	if(document.Requestor.h_r_region_code)		document.Requestor.h_r_region_code.value = "<%=regioncodes%>";

	if(document.Requestor.r_town_code)		document.Requestor.r_town_code.value = "<%=towncodes%>";
	if(document.Requestor.h_r_town_code)		document.Requestor.h_r_town_code.value = "<%=towncodes%>";

	if(document.Requestor.r_postal_code1)		document.Requestor.r_postal_code1.value = "<%=postalcodes%>";

	if(document.Requestor.r_postal_code)		document.Requestor.r_postal_code.value = "<%=postalcodes%>";
	if(document.Requestor.h_r_postal_code1)		document.Requestor.h_r_postal_code1.value = "<%=postalcodes%>";

	

	document.Requestor.r_area.value = "<%=areacode%>";
	document.Requestor.r_town.value = "<%=towncode%>";
	document.Requestor.r_region.value = "<%=regioncode%>";
	document.Requestor.r_postal.value = "<%=postalcode%>";
	document.Requestor.r_postal_code.value = "<%=postalcodes%>";

	if(document.Requestor.requestor_country.value == "")
		document.Requestor.req_country_code.value="";
	else
		document.Requestor.req_country_code.value="<%=countrycode%>";

}
</script>


<%
	if(funcname.equals("modify"))
	{
		if(reqCount > 0)
		{
			out.println("<script>document.Requestor.requestor_type.disabled=true;</script>");
		}

		if(!effstatus.equals("E"))
		{	%>
			<script>
				for(var i=0; i<document.Requestor.length;i++)
				{
					document.Requestor.elements(i).disabled = true;
				}
				document.Requestor.requestor_status.disabled = false;
			</script>
<%		}	
	}	%>

</FORM>
<%}catch(Exception e)
	{
		//out.println("Exception @ try"+e.toString());
		e.printStackTrace();
	}
finally
	{
		if(rset	 != null)   rset.close();
		if(pstmt != null)	pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
	}
%>
</BODY>
</HTML>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

