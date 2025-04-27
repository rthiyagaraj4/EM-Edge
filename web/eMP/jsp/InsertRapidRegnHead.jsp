<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%
	request.setCharacterEncoding("UTF-8");
	String bl_install_yn=(String)session.getValue("mp_bl_oper_yn");
    Connection con=null;
    con = ConnectionManager.getConnection(request);
	request.setCharacterEncoding("UTF-8");	
	PreparedStatement pstmt = null;
	ResultSet rs=null ;
	ResultSet rs1=null ;
	String patient_id_length = "";
	
	String names_in_oth_lang_yn = "";
	String language_direction="";
	String cntLang="";
	String parameter="";
	int count=0;

	patient_id_length =request.getParameter("patient_id_length");
	names_in_oth_lang_yn = request.getParameter("names_in_oth_lang_yn");
	cntLang = request.getParameter("cntLang");
	count = Integer.parseInt(cntLang);
	parameter = request.getQueryString();
	
	StringBuffer OptionBuffer = null;
	OptionBuffer = new StringBuffer();

	//OptionBuffer.append("<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientInformation.label","mp_labels")+"</option>");
		

try
{	
		if ( count==1 ) 
		{
			 language_direction = "R" ;
		}else
		{
			 language_direction = "L" ;
		}


%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
    <head>
            <link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
			<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
            <Script src='../../eCommon/js/common.js' language='JavaScript'></Script>
            <Script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></Script>
            <Script src='../../eMP/js/RapidRegn.js' language='javascript'></Script>
            <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<Script>	
				function CheckForSpecChars(event)
				{
					var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*';
					var whichCode = (window.Event) ? event.which : event.keyCode;
					key = String.fromCharCode(whichCode);  // Get key value from key code
					if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
					if( (event.keyCode >= 97) && (event.keyCode <= 122) )
						return (event.keyCode -= 32);
					return true ;
				}
			</Script>
    </head>
    
    <body onKeyDown='lockKey();' onload="">
	<form name='regdRapidPatHeadForm' id='regdRapidPatHeadForm'>
    <table width='100%' cellpadding='5' cellspacing='0' border='0'>

	<tr>
        <td class='label' nowrap><fmt:message key="eMP.PopulateFrom.label" bundle="${mp_labels}"/></td>
		<td class='fields' colspan='4'><SELECT name='refrlAappt' id='refrlAappt' onChange='enbDsbRefIDVal(this);'>
		<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		<option value='P'><fmt:message key="eMP.PatientInformation.label" bundle="${mp_labels}"/></option></SELECT>&nbsp;&nbsp;
		<input type='text'  maxlength="<%=patient_id_length%>"  name='refIDValue' id='refIDValue' value="" onBlur="chkrefIDValue(this);" onkeypress="return CheckForSpecChars(event);" disabled><input type='button' class='button' name='refIDValueButton' id='refIDValueButton' value='?' onClick='PopAppRefDetails();' disabled><img id="phimg" src='../../eCommon/images/mandatory.gif' style="Visibility : 'Hidden';"></td>
	</tr>

        <tr>
            <td class = 'label' align = 'left' nowrap> <fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
            <%
            out.print("<td class='label' nowrap><input class='upper' name='patient_id' id='patient_id' value='' size='18' maxlength='"+ patient_id_length +"' onFocus='loadPatSeriesManual();' onblur='ChangeUpperCase(this);checkPatientId();' onKeyPress='return CheckForSpecChars(event);' readonly disabled ><!--<img src='../../eCommon/images/mandatory.gif'></img>--></td>");
			%>
			<!-- img commented and disabled added by mujafar for ML-MMOH-SCF-1039 -->
            <td class='fields'><input type='text' name='patient_name' id='patient_name' value='' maxlength='60' size='55' readonly value=""></td>
           <%
                if(names_in_oth_lang_yn.equals("Y"))
                {
			
				//out.println( "<td class='fields'><input name='patient_name_loc_lang' id='patient_name_loc_lang' size='55' maxlength='60' readonly style=\"text-align:left\" value=\"\" onBlur='makeValidString(this);'></td>" ) ;

				out.println( "<td class='fields'><input name='patient_name_loc_lang' id='patient_name_loc_lang' size='55' maxlength='60' readonly  value=\"\" onBlur='makeValidString(this);'" ) ;

				if(language_direction.equals("R"))
				{
				out.println("dir='RTL'" ) ;
				}
				else
				{
				out.println("style=\"text-align:left\"");
				}
				
				out.println(" ></td>" ) ;
				
				}
				else
				{
					out.println("<script>document.getElementById(\"patient_name\").size='60';</script>");
				}
			%>
        </tr>
	</table>
	   	<ul id="tablist" class="tablist" style="padding-left:0px">
			<li class="tablistitem" title="Demographic details">
				<a onclick="invokeRapidRegnTabs('demogrp_tab')" class="tabClicked" id="demogrp_tab" >
					<span class="tabSpanclicked" id="demogrp_tabspan"><fmt:message key="eMP.demographicdetails.label" bundle="${mp_labels}"/></span>
				</a> 	
			</li>
		
			<li class="tablistitem" title="Other details">
				<a onclick="invokeRapidRegnTabs('others_tab')" class="tabA" id="others_tab" >
					<span class="tabAspan" id="others_tabspan"><fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
				</a>
			</li>	

		<%if(bl_install_yn.equals("Y")){%>
				<li class="tablistitem" title="Financial details">
				<a onclick="invokeRapidRegnTabs('findtl_tab')" class="tabA" id="findtl_tab" >
					<span class="tabAspan" id="findtl_tabspan"><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>	
		<%}%>	
		</ul>
	<!-- The below line is required to change the select state of Demograph tab initially selected -->
	<script>prevTabObj='demogrp_tab'</script>

	<input type='hidden' name='sStyle' id='sStyle' value="<%=sStyle%>">
	<input type='hidden' name='RapidPatInfflag' id='RapidPatInfflag'>
	<input type='hidden' name='parameter' id='parameter' value = <%=parameter%>>
	</form>
	</body>
	<%
    }
    catch(Exception e)
    {
        out.println("Exception in main try"+e.getMessage());
    }
    finally
    {
		if(rs!=null) rs.close();
		if(pstmt != null) pstmt.close();
		if(rs1 != null) rs1.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);        
    }
%>
</html>
        
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

