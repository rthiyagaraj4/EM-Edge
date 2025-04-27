<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,,webbeans.eCommon.ConnectionManager,eCommon.Common.*" %> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<title></title>
    <link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>   
	<script language='javascript' src='../../eMP/js/genPatWithNatIdCreate.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<%
        String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		request.setCharacterEncoding("UTF-8");
		String params = request.getQueryString() ;
        String source = url + params ;
		String facilityId = (String) session.getValue("facility_id");
		String locale			= (String)session.getAttribute("LOCALE");
        Connection con = ConnectionManager.getConnection(request);
		
        try  {
			HashMap ResultParamHashMap = new HashMap();
			HashMap sqlColumns = new HashMap();
			sqlColumns.put("patient_id_length","S");
			sqlColumns.put("nat_id_prompt","S");
			sqlColumns.put("nat_id_accept_alphanumeric_yn","S");
			sqlColumns.put("accept_national_id_no_yn","S");
			sqlColumns.put("nat_id_check_digit_id","S");
			sqlColumns.put("nat_id_length","S");
			sqlColumns.put("invoke_routine","S");
			sqlColumns.put("nat_data_source_id","S");
			sqlColumns.put("nat_id_pat_ser_grp","S");
			sqlColumns.put("nat_id_chk_len","S");
			String whereClause	= "where module_id='MP'";
			ResultParamHashMap = CommonBean.getParamDetails(sqlColumns,whereClause,"MP_PARAM",con);
			String patient_id_length				 = (String) ResultParamHashMap.get("patient_id_length");
			String nat_id_prompt					 = (String) ResultParamHashMap.get("nat_id_prompt");
			String nat_id_accept_alphanumeric_yn	 = (String) ResultParamHashMap.get("nat_id_accept_alphanumeric_yn");
			String accept_national_id_no_yn			 = (String) ResultParamHashMap.get("accept_national_id_no_yn");
			String invoke_routine					 = (String) ResultParamHashMap.get("invoke_routine");
			String invoke_routine_name				 = (String) ResultParamHashMap.get("nat_data_source_id");
			String nat_id_check_digit_id			 = (String) ResultParamHashMap.get("nat_id_check_digit_id");
			String nat_id_pat_ser_grp				 = (String) ResultParamHashMap.get("nat_id_pat_ser_grp");
			String nat_id_chk_len					 = (String) ResultParamHashMap.get("nat_id_chk_len");

	
			String nat_id_length					 = (String) ResultParamHashMap.get("nat_id_length");
			nat_id_prompt							 = (nat_id_prompt==null || nat_id_prompt.equals("")?"National Id No":nat_id_prompt);

			invoke_routine							 = (invoke_routine==null || invoke_routine.equals("")?"N":invoke_routine);
			invoke_routine_name						 = (invoke_routine_name==null || invoke_routine_name.equals("")?"":invoke_routine_name);
			nat_id_check_digit_id					 = (nat_id_check_digit_id==null || nat_id_check_digit_id.equals("")?"":nat_id_check_digit_id);
			nat_id_pat_ser_grp						 = (nat_id_pat_ser_grp==null || nat_id_pat_ser_grp.equals("")?"":nat_id_pat_ser_grp);
			nat_id_chk_len							 = (nat_id_chk_len==null || nat_id_chk_len.equals("")?"N":nat_id_chk_len);
		
			
			sqlColumns.clear();
			ResultParamHashMap.clear();
			if(accept_national_id_no_yn.equals("Y")){
				if(!nat_id_pat_ser_grp.equals("")){
			%>
				<iframe name='commontoolbarFrame' id='commontoolbarFrame'    src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
					<iframe name='f_query_add_mod' id='f_query_add_mod'   src='../../eMP/jsp/genPatWithNatIdCreate.jsp?patient_id_length=<%=patient_id_length%>&nat_id_prompt=<%=java.net.URLEncoder.encode(nat_id_prompt)%>&nat_id_accept_alphanumeric_yn=<%=nat_id_accept_alphanumeric_yn%>&nat_id_check_digit_id=<%=nat_id_check_digit_id%>&nat_id_length=<%=nat_id_length%>&invoke_routine=<%=invoke_routine%>&invoke_routine_name=<%=invoke_routine_name%>&nat_id_chk_len=<%=nat_id_chk_len%>' frameborder=0 style='height:83vh;width:100vw'></iframe>
					<iframe name='messageFrame' id='messageFrame'      src='../../eCommon/jsp/error.jsp?' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
			
			 <%
				}else{%>
					 <script>
						var ErrorMessage= getMessage('WITH_NATIONAL_ID_NOT_CONFIGURED','MP'); 
						alert(ErrorMessage);	
						document.location.href='../../eCommon/jsp/dmenu.jsp';
					</script>
			<%	}
			}else{%>
					<script>
						var ErrorMessage= getMessage('NATIONAL_ID_NOT_CONFIGURED','MP'); 
						alert(ErrorMessage);	
						document.location.href='../../eCommon/jsp/dmenu.jsp';
					</script>

			<%}
            
        } catch(Exception e ){
			out.println(e);e.printStackTrace();
		} finally {
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

