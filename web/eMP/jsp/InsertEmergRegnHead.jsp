<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
request.setCharacterEncoding("UTF-8");

try{

	String patient_id_length = null;
	String names_in_oth_lang_yn = "";
	String language_direction="";	
	int count=0;
	String cntLang= request.getParameter("cntLang");
	patient_id_length= request.getParameter("patient_id_length");
	names_in_oth_lang_yn= request.getParameter("names_in_oth_lang_yn");	
	count = Integer.parseInt(cntLang);
	
%>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>

	<Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration3.js'></Script>
	<script language='javascript' src='../../eMP/js/EmergRegn.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<form name='InEmRegHeadForm' id='InEmRegHeadForm'>
	<%
	try
	{
		if ( count==1 ) {
			 language_direction = "R" ;
		}else{
			 language_direction = "L" ;
		}
	}
	catch(Exception e)
	{
		 out.println("Exception "+e);
		 e.printStackTrace();
	}

	%>
	<table width='100%' cellpadding='0' cellspacing='0' border='0'>
	<tr><td colspan='5' class='white'></td></tr>

	<tr>
	<td class = 'label' nowrap> <fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<%
	out.print("<td class='fields' nowrap><input class='upper' name='patient_id' id='patient_id' value='' size='18' maxlength='"+ patient_id_length +"' onFocus='loadPatSeriesManual();' onblur='ChangeUpperCase(this);checkPatientId()' readonly disabled onKeyPress='return CheckForSpecChars(event)'><!--<img src='../../eCommon/images/mandatory.gif'></img>--></td>");
	%>
	<!-- img commented and disabled added by mujafar for ML-MMOH-SCF-1039 -->
	<td class='fields'>&nbsp;&nbsp;<input type='text' name='patient_name' id='patient_name' value="" maxlength='60' size='55' readonly></td>
	<%

    if(names_in_oth_lang_yn.equals("Y"))
	{
		//out.println( "<td class='fields'>&nbsp;&nbsp;<input name='patient_name_loc_lang' id='patient_name_loc_lang' size='55' maxlength='60' readonly style=\"text-align:left\"  value=\"\" onBlur='makeValidString(this);'></td>" ) ;	
		
		out.println( "<td class='fields'>&nbsp;&nbsp;<input name='patient_name_loc_lang' id='patient_name_loc_lang' size='55' maxlength='60' readonly value=\"\" onBlur='makeValidString(this);'" ) ;

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
		out.println("<script>document.getElementById('patient_name').size='60';</script>");
		//out.println("<input type='hidden' name='patient_name_loc_lang' id='patient_name_loc_lang'></input><script>document.getElementById('patient_name').size='60';</script>");
	}
	%>
    </tr>   
    </table>
    <input type='hidden' name='sStyle' id='sStyle' value="<%=sStyle%>">         
	</form>
	<%
	}
	catch(Exception e) { out.println(e.toString()); e.printStackTrace();}
    finally
    {
  //      if(con != null) ConnectionManager.returnConnection(con,request);
    }

%>
    </body>	
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

