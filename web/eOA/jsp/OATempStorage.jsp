<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<body>
<%
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
 	String position			= checkForNull(request.getParameter("position"));
	String addtl_splty		= checkForNull(request.getParameter("addtl_splty"));
	String rule_appl_yn		= checkForNull(request.getParameter("rule_appl_yn"));
	String patient_id_temp	= checkForNull(request.getParameter("patient_id_temp"));
	String name_prefix_temp	= checkForNull(request.getParameter("name_prefix_temp"));
	String first_name_temp	= checkForNull(request.getParameter("first_name_temp"));
	String second_name_temp	= checkForNull(request.getParameter("second_name_temp"));
	String third_name_temp	= checkForNull(request.getParameter("third_name_temp"));
	String family_name_temp	= checkForNull(request.getParameter("family_name_temp"));
	String name_suffix_temp	=checkForNull(request.getParameter("name_suffix_temp"));	
	String name_prefix_oth_lang_temp	=checkForNull(request.getParameter("name_prefix_oth_lang_temp"));
	String first_name_oth_lang_temp	=checkForNull(request.getParameter("first_name_oth_lang_temp"));
	String second_name_oth_lang_temp	=checkForNull(request.getParameter("second_name_oth_lang_temp"));
	String third_name_oth_lang_temp	=checkForNull(request.getParameter("third_name_oth_lang_temp"));
	String family_name_oth_lang_temp	=checkForNull(request.getParameter("family_name_oth_lang_temp"));
	String name_suffix_oth_lang_temp	=checkForNull(request.getParameter("name_suffix_oth_lang_temp"));
	String gender_temp		= checkForNull(request.getParameter("gender_temp"));
	String contact_no_temp	= checkForNull(request.getParameter("contact_no_temp"));
	String nationality_code_temp	= checkForNull(request.getParameter("nationality_code_temp"));
	String language_code_temp	= checkForNull(request.getParameter("language_code_temp"));
	String term_set_id			= checkForNull(request.getParameter("term_set_id"));
	String linking_code			= checkForNull(request.getParameter("linking_code")); 	
	String apptrefno			= checkForNull(request.getParameter("apptrefno")); 	
	//System.out.println("name_suffix_temp OATempStorage.jsp:"+name_suffix_temp);
%>
	<form name='tempStorageForm' id='tempStorageForm'>
		<input type='hidden' name='position' id='position' value='<%=position%>'>
		<input type='hidden' name='addtl_splty' id='addtl_splty' value='<%=addtl_splty%>'>
		<input type="hidden" name='rule_appl_yn' id='rule_appl_yn' value='<%=rule_appl_yn%>'>
		<input type="hidden" name='patient_id_temp' id='patient_id_temp' value='<%=patient_id_temp%>'>
		<input type="hidden" name='name_prefix_temp' id='name_prefix_temp' value="<%=name_prefix_temp%>">
		<input type="hidden" name='first_name_temp' id='first_name_temp' value='<%=first_name_temp%>'>
		<input type="hidden" name='second_name_temp' id='second_name_temp' value='<%=second_name_temp%>'>
		<input type="hidden" name='third_name_temp' id='third_name_temp' value='<%=third_name_temp%>'>
		<input type="hidden" name='family_name_temp' id='family_name_temp' value='<%=family_name_temp%>'>
		<input type='hidden' name='name_suffix_temp' id='name_suffix_temp' value="<%=name_suffix_temp%>">
		<input type='hidden' name='name_prefix_oth_lang_temp' id='name_prefix_oth_lang_temp' value="<%=name_prefix_oth_lang_temp%>">
		<input type='hidden' name='first_name_oth_lang_temp' id='first_name_oth_lang_temp' value='<%=first_name_oth_lang_temp%>'>
		<input type='hidden' name='second_name_oth_lang_temp' id='second_name_oth_lang_temp' value='<%=second_name_oth_lang_temp%>'>
		<input type='hidden' name='third_name_oth_lang_temp' id='third_name_oth_lang_temp' value='<%=third_name_oth_lang_temp%>'>
		<input type='hidden' name='family_name_oth_lang_temp' id='family_name_oth_lang_temp' value='<%=family_name_oth_lang_temp%>'>
		<input type='hidden' name='name_suffix_oth_lang_temp' id='name_suffix_oth_lang_temp' value="<%=name_suffix_oth_lang_temp%>">
		<input type="hidden" name='gender_temp' id='gender_temp' value='<%=gender_temp%>'>
		<input type="hidden" name='contact_no_temp' id='contact_no_temp' value='<%=contact_no_temp%>'>
		<input type="hidden" name='nationality_code_temp' id='nationality_code_temp' value='<%=nationality_code_temp%>'>
		<input type="hidden" name='language_code_temp' id='language_code_temp' value='<%=language_code_temp%>'>
		<input type="hidden" name='term_set_id' id='term_set_id' value='<%=term_set_id%>'>
		<input type="hidden" name='linking_code' id='linking_code' value='<%=linking_code%>'>		
		<input type="hidden" name='apptrefno' id='apptrefno' value='<%=apptrefno%>'>		
	</form>
</body>
</html>
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

