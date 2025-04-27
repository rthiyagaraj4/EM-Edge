<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="com.ehis.util.*,java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*, eCommon.Common.*" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCA/html/CAStyle.css"></link>
<script src='../../eMR/js/RecDiagnosisMain.js' language='javascript'></script>
<script src='../../eMR/js/RecDiagnosis.js' language='javascript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con		= null;
	PreparedStatement pstmt = null;
	ResultSet rset		= null;
	String locale			= (String)session.getAttribute("LOCALE");
	String drug_code = "";
	String drug_desc = "";
	String generic_id = "";
	String generic_name = "";
	String start_date= "";
	String end_date= "";
	String drugName = "" ;
	String restrictYN = "" ;
	String remarks = "" ;
	String retval = "";
	int i = 1;
	String diagdesc= request.getParameter("diagdesc")==null?"":request.getParameter("diagdesc");
	String diagset= request.getParameter("diagset")==null?"":request.getParameter("diagset");
	String diagcode= request.getParameter("diagcode")==null?"":request.getParameter("diagcode");
	String patient_id= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id= request.getParameter("Encounter_Id")==null?"":request.getParameter("Encounter_Id");
%>
	<form name='recDiagDurgIndicationForm' id='recDiagDurgIndicationForm' >
<%
	con = ConnectionManager.getConnection(request);
	String sql = "";
	String sql1 = "";
	String style = "";
	String restrict = "";

try
{
	sql1 = "SELECT a.drug_code drug_code, b.drug_desc drug_desc, a.generic_id generic_id, c.generic_name generic_name, TO_CHAR (a.start_date, 'DD/MM/YYYY hh24:mi') start_date, TO_CHAR (a.end_date, 'DD/MM/YYYY hh24:mi') end_date FROM ph_patient_drug_profile a, ph_drug_lang_vw b, ph_generic_name c WHERE a.patient_id = ? AND a.encounter_id = ? AND a.drug_code = b.drug_code AND a.generic_id = c.generic_id AND TO_DATE (a.end_date, 'dd/mm/yyyy hh24:mi') >= TO_DATE (SYSDATE, 'dd/mm/yyyy hh24:mi') AND TO_DATE (SYSDATE, 'DD/MM/RRRR HH24:MI') BETWEEN TO_DATE (a.start_date, 'DD/MM/RRRR HH24:MI') AND TO_DATE (a.end_date, 'DD/MM/RRRR HH24:MI') AND a.discont_date_time IS NULL AND a.on_hold_date_time IS NULL AND a.cancel_yn = 'N' AND a.stop_yn = 'N' AND b.language_id(+) = 'en'";

			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,encounter_id);
			rset = pstmt.executeQuery();
			ArrayList<String> arr1 = new ArrayList<String>(); 
			ArrayList<String> arr2 = new ArrayList<String>(); 
			HashMap<String, String> startMap = new HashMap<String, String>();
			HashMap<String, String> endMap = new HashMap<String, String>();
			while(rset!=null && rset.next()){
				drug_code = checkForNull(rset.getString("drug_code"));
				drug_desc = checkForNull(rset.getString("drug_desc"));
				generic_id = checkForNull(rset.getString("generic_id"));
				generic_name = checkForNull(rset.getString("generic_name"));
				start_date = checkForNull(rset.getString("start_date"));
				end_date = checkForNull(rset.getString("end_date"));
				arr1.add(generic_id); 
				arr2.add(drug_code);
				startMap.put(drug_desc,start_date);
				endMap.put(drug_desc,end_date);
			}
	sql ="SELECT ROW_NUMBER () OVER (PARTITION BY intr_type1 || intr_type2 || intr_code1 || intr_code2 ORDER BY ( form_code1 || form_code2) DESC) srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code, intr_code1 intr_code1, d1.generic_id generic_id1, DECODE (form_code1, '*A', 'All', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = b.form_code2 AND language_id = d1.language_id) ) form_desc, d1.generic_name intr_name2, b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks, 'I' drug_inter_type FROM ph_drug_interaction b, ph_generic_name_lang_vw d1 WHERE intr_type1 = 'G' AND intr_type2 = 'I' AND b.intr_code1 = d1.generic_id AND term_set_id = '"+diagset+"'  AND intr_code2 = '"+diagcode+"' AND intr_code1 IN ("+convertArray(arr1)+") AND d1.language_id = '"+locale+"' AND b.eff_status = 'E' UNION ALL SELECT ROW_NUMBER () OVER (PARTITION BY intr_type1 || intr_type2 || intr_code1 || intr_code2 ORDER BY ( form_code1 || form_code2) DESC) srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code, intr_code1 intr_code1, d1.drug_desc generic_id1, DECODE (form_code1, '*A', 'All', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = b.form_code2 AND language_id = d1.language_id) ) form_desc, d1.drug_desc intr_name2, b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks, 'I' drug_inter_type FROM ph_drug_interaction b, ph_drug_lang_vw d1 WHERE intr_type1 = 'D' AND intr_type2 = 'I' AND b.intr_code1 = d1.drug_code AND term_set_id = '"+diagset+"' AND intr_code2 = '"+diagcode+"' AND intr_code1 IN ("+convertArray(arr2)+") AND d1.language_id = '"+locale+"' AND b.eff_status = 'E' ";
		System.err.println("hi sql ==>"+sql.toString());
		pstmt = con.prepareStatement(sql);
		rset = pstmt.executeQuery();
		System.err.println("hi sql after ==>");%>
	<table cellpadding='0' cellspacing='0' border='1' width='100%'>
&nbsp;<TH><%=diagdesc%></th> 
  <tr>
    <td>
	&nbsp;
<%
		while(rset != null && rset.next()) 
		{  			
			drugName = rset.getString("intr_name2") == null ? "" : rset.getString("intr_name2");
			restrictYN	= rset.getString("intr_restrt_yn") == null ? "" : rset.getString("intr_restrt_yn");
			remarks	= rset.getString("intr_remarks") == null ? "" : rset.getString("intr_remarks");
			if(restrictYN.equals("Y"))
			{
			style = "color:red;" ;
			restrict = "Reject";
			}
			else
			{
			style = "" ;
			restrict = "Warning";
			}
		
	%>

      <table id=row<%=i%> border = '1'>
        <tr>
		<td name='drugName<%=i%>' id='drugName<%=i%>' style = "padding: 5px;" class="COLUMNHEADER"><fmt:message key="eMR.DrugName.label" bundle="${mr_labels}"/> : <%=drugName%>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		</tr>
      
	  <table border='0'>
	  <tr>
				<td width='20%' class='label'><fmt:message key="eMR.DrugStartDate.label" bundle="${mr_labels}"/> :</td>
				<td class='QUERYDATA' name='start_date<%=i%>' id='start_date<%=i%>' nowrap><%=startMap.get(drugName)%></td>
				<td colspan = '10'>&nbsp;</td>
				<td width='20%' class='label'><fmt:message key="eMR.DrugEndDate.label" bundle="${mr_labels}"/> :</td>
				<td class='QUERYDATA' name='end_date<%=i%>' id='end_date<%=i%>' nowrap><%=endMap.get(drugName)%></td>
				<td colspan = '10'>&nbsp;</td>
				<td width='20%' class='label' nowrap><fmt:message key="eMR.InteractionStatus.label" bundle="${mr_labels}"/> :</td>
				<td style=<%=style%> name='restrict<%=i%>' id='restrict<%=i%>' class='QUERYDATA'><%=restrict%></td>
	  </tr>
	  </table>
	  <table border='0'>
	  <tr>
				<td width='20%' class='label' nowrap><fmt:message key="eMR.InteractionDescription.label" bundle="${mr_labels}"/> :</td>
				<td style="word-break: break-all; width:100%" class='QUERYDATA' name='remarks<%=i%>' id='remarks<%=i%>' size='2000' length='2000'><%=remarks%></td>
	  </tr>
	  </table>
	  </table>
	  <%  
	  i++;
		  }%> 
    </td>
  </tr>
</table>

<table  cellpadding='0' cellspacing='0' width='100%'>
			<tr>
				<td colspan='6'>&nbsp;</td>
				<td class='button'>
				<input type='button' name='Cancel' id='Cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='closew()' class='button'>
				</td>
			</tr>
</table>

<script language='JavaScript'>
function closew()
{	
	window.returnValue="";
	window.parent.close();
}
</script>
<%	
}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	
	if(rset!=null) rset.close();
	if(pstmt!=null) pstmt.close();
	if(con != null)ConnectionManager.returnConnection(con,request);
}
%>
</form>


<%!

// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}

public static String convertArray(ArrayList array){
	String str="";
	if(array !=null || array.size()>0){
	for(int i=0;i<array.size();i++){
if(i==0){
str="'"+array.get(i)+"'";
} else {
str=str+",'"+array.get(i)+"'";
}
	}
		} 
		return str;

}
%>

