<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.util.*,java.util.HashMap,java.util.Properties, java.util.ArrayList, java.text.SimpleDateFormat, com.ehis.util.*, webbeans.eCommon.ConnectionManager,eCommon.Common.*,org.json.simple.*" contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
Properties p		= (java.util.Properties) session.getValue("jdbc");
String accept_national_id_no_yn			= checkForNull(request.getParameter("accept_national_id_no_yn"));
String mthr_nat_id_no			= checkForNull(request.getParameter("mthr_nat_id_no"));
String cd3			= checkForNull(request.getParameter("cd3"));
if(cd3.equals("")) cd3 = "National ID No";
String accept_oth_alt_id_yn			= checkForNull(request.getParameter("accept_oth_alt_id_yn"));
String mthr_oth_alt_id_No			= checkForNull(request.getParameter("mthr_oth_alt_id_No"));
String mthr_alt_id1_no			= checkForNull(request.getParameter("mthr_alt_id1_no"));
String alt_id1_type_desc			= checkForNull(request.getParameter("alt_id1_type_desc"));
String mthr_alt_id2_no			= checkForNull(request.getParameter("mthr_alt_id2_no"));
String alt_id2_type_desc			= checkForNull(request.getParameter("alt_id2_type_desc"));
String mthr_alt_id3_no			= checkForNull(request.getParameter("mthr_alt_id3_no"));
String alt_id3_type_desc			= checkForNull(request.getParameter("alt_id3_type_desc"));
String mthr_alt_id4_no			= checkForNull(request.getParameter("mthr_alt_id4_no"));
String alt_id4_type_desc			= checkForNull(request.getParameter("alt_id4_type_desc"));
String motherencounterid			= checkForNull(request.getParameter("motherencounterid"));
String mother_patient_id			= checkForNull(request.getParameter("mother_patient_id"));
String invoked_from			= checkForNull(request.getParameter("invoked_from"));
String race_required_yn			= checkForNull(request.getParameter("race_required_yn"));
String OtherAltNo			= checkForNull(request.getParameter("oth_alt_id_type"));
Map<String,String> hashMap					= new LinkedHashMap();
if(accept_national_id_no_yn.equals("Y") && !mthr_nat_id_no.equals("")){
hashMap.put(cd3,mthr_nat_id_no);
}
if(accept_oth_alt_id_yn.equals("Y") && !mthr_oth_alt_id_No.equals("")){
hashMap.put(OtherAltNo,mthr_oth_alt_id_No);
}
if(!mthr_alt_id1_no.equals("")){
hashMap.put(alt_id1_type_desc,mthr_alt_id1_no);
}
if(!mthr_alt_id2_no.equals("")){
hashMap.put(alt_id2_type_desc,mthr_alt_id2_no);
}
if(!mthr_alt_id3_no.equals("")){
hashMap.put(alt_id3_type_desc,mthr_alt_id3_no);
}
if(!mthr_alt_id4_no.equals("")){
hashMap.put(alt_id4_type_desc,mthr_alt_id4_no);
}
try{
int index=0;
for (Map.Entry<String,String> entry : hashMap.entrySet()) {
String key = entry.getKey();           
String value = entry.getValue();  
index++;
if(index == 1){
%>
<tr>
<td class='label' height="25"><%=key%> </td>
<td class='QUERYDATA' height="25"><%=value%>&nbsp;</td>
<td class='label' height="25"></td>
<td class='label' height="25" nowrap><a name='ViewPatChartSummary'   href="javascript:showPatChartSummary('<%=motherencounterid%>','<%=mother_patient_id%>','<%=request.getContextPath()%>');"><B><fmt:message key="Common.ViewPatChartSummary.label" bundle="${common_labels}"/></B></a></td>
</td>
</tr>
<%
}%>
<%if(index == 2 || index == 4 || index == 6){%>
<tr>
<%}%>
<%if(index!=1 && !value.equals("") ){%>
<td class='label' height="25"><%=key%> </td>
<td class='QUERYDATA' height="25"><%=value%>&nbsp;</td>
<%} if(index == 3 || index == 5 || index == 6){%>
</tr>
<%}}
if(hashMap.isEmpty()){
%>
<td class='label' height="25"></td>
<td class='label' height="25"></td>
<td class='label' height="25"></td>
<td class='label' height="25" nowrap><a name='ViewPatChartSummary'   href="javascript:showPatChartSummary('<%=motherencounterid%>','<%=mother_patient_id%>','<%=request.getContextPath()%>');"><B><fmt:message key="Common.ViewPatChartSummary.label" bundle="${common_labels}"/></B></a></td>
</td>
</tr>
<%}%>
<input type='hidden' name='mother_pmi_no' id='mother_pmi_no' value='<%=mthr_alt_id1_no%>'>
<input type='hidden' name='invoked_from' id='invoked_from' value = '<%=invoked_from%>'>
<input type='hidden' name='race_required_yn' id='race_required_yn' value = '<%=race_required_yn%>'>
<input type = 'hidden' name ='alt_id_type_desc' value='<%=alt_id1_type_desc%>'>
<%}catch(Exception e){e.printStackTrace();
}finally{} %>
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

