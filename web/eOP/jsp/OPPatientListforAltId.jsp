<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*" %>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

//String facility_id = (String) session.getValue("facility_id");

String altIdNo1 = request.getParameter("altIdNo1") == null?"":request.getParameter("altIdNo1");
/*Below line Added for this SCF  MMS-SCF-0071 [IN:042582]*/	
String altIdNo2 = request.getParameter("altIdNo2") == null?"":request.getParameter("altIdNo2");
String altIdNo3 = request.getParameter("altIdNo3") == null?"":request.getParameter("altIdNo3");
String altIdNo4 = request.getParameter("altIdNo4") == null?"":request.getParameter("altIdNo4");
String otheraltIdType = request.getParameter("otherAlternateIDType") == null?"":request.getParameter("otherAlternateIDType");
String otheraltIdNo = request.getParameter("otherAlternateIDNo") == null?"":request.getParameter("otherAlternateIDNo");

String titledesc="";
if(altIdNo1!=null && !altIdNo1.equals(""))titledesc=altIdNo1;
if(altIdNo2!=null && !altIdNo2.equals(""))titledesc=altIdNo2;
if(altIdNo3!=null && !altIdNo3.equals(""))titledesc=altIdNo3;
if(altIdNo4!=null && !altIdNo4.equals(""))titledesc=altIdNo4;
if(otheraltIdNo!=null && !otheraltIdNo.equals(""))titledesc=otheraltIdNo;

StringBuffer whereclause=new StringBuffer();

if(altIdNo1!=null && !altIdNo1.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and UPPER(ALT_ID1_NO) = UPPER('"+altIdNo1+"')"); // this line modified for this SCF MMS-SCF-0071 [IN:042582]
	}else{
		whereclause.append(" UPPER(ALT_ID1_NO) =UPPER('"+altIdNo1+"')");   // this line modified for this SCF MMS-SCF-0071 [IN:042582]
	}
}
if(altIdNo2!=null && !altIdNo2.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and UPPER(ALT_ID2_NO) =UPPER('"+altIdNo2+"')"); // this line modified for this SCF MMS-SCF-0071 [IN:042582]
	}else{
		whereclause.append(" UPPER(ALT_ID2_NO) =UPPER('"+altIdNo2+"')");  // this line modified for this SCF MMS-SCF-0071 [IN:042582]
	}
}
if(altIdNo3!=null && !altIdNo3.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and UPPER(ALT_ID3_NO)  =UPPER('"+altIdNo3+"')");  // this line modified for this SCF MMS-SCF-0071 [IN:042582]
	}else{
		whereclause.append(" UPPER(ALT_ID3_NO)  =UPPER('"+altIdNo3+"')"); // this line modified for this SCF MMS-SCF-0071 [IN:042582]
	}
}
if(altIdNo4!=null && !altIdNo4.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and UPPER(ALT_ID4_NO) =UPPER('"+altIdNo4+"')"); // this line modified for this SCF MMS-SCF-0071 [IN:042582]
	}else{
		whereclause.append(" UPPER(ALT_ID4_NO) =UPPER('"+altIdNo4+"')"); // this line modified for this SCF MMS-SCF-0071 [IN:042582]
	}
}
if(otheraltIdNo!=null && !otheraltIdNo.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and oth_alt_id_type = '"+otheraltIdType+"' and UPPER(oth_alt_id_no) = UPPER('"+otheraltIdNo+"') ");
		// this line modified for this SCF MMS-SCF-0071 [IN:042582]
	}else{
		whereclause.append(" oth_alt_id_type = '"+otheraltIdType+"' and UPPER(oth_alt_id_no) = UPPER('"+otheraltIdNo+"') ");
		// this line modified for this SCF MMS-SCF-0071 [IN:042582]
	}
}

//End MMS-SCF-0071 [IN:042582]
String altId1Desc = request.getParameter("altId1Desc") == null?"":request.getParameter("altId1Desc");
String names_in_oth_lang_yn = request.getParameter("names_in_oth_lang_yn") == null?"N":request.getParameter("names_in_oth_lang_yn");
String locale	= (String)session.getAttribute("LOCALE");
int patientPos = 0;

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;


/*Below line Added for this incident [IN:001921]*/
StringBuffer assign=new StringBuffer();
String titlevaluassign="";
if(altIdNo1!=null && !altIdNo1.equals("") && assign.toString().equals("")){
assign.append(" UPPER(ALT_ID1_NO) =UPPER('"+altIdNo1+"')");
titlevaluassign="ALT_ID1_NO";
}if(altIdNo2!=null && !altIdNo2.equals("") && assign.toString().equals("")){
assign.append(" UPPER(ALT_ID2_NO) =UPPER('"+altIdNo2+"')");
titlevaluassign="ALT_ID2_NO";
}if(altIdNo3!=null && !altIdNo3.equals("") && assign.toString().equals("")){
assign.append(" UPPER(ALT_ID3_NO)  =UPPER('"+altIdNo3+"')");
titlevaluassign="ALT_ID3_NO";
}if(altIdNo4!=null && !altIdNo4.equals("") && assign.toString().equals("")){
assign.append(" UPPER(ALT_ID4_NO) =UPPER('"+altIdNo4+"')");
titlevaluassign="ALT_ID4_NO";
}
//End [IN:001921]

	try {

		con = ConnectionManager.getConnection(request);
	    String titledisply="SELECT mp_get_desc.mp_alternate_id_type (alt_id1_type, 'en', 2) alt_id1_type,  mp_get_desc.mp_alternate_id_type (alt_id2_type, 'en', 2) alt_id2_type, mp_get_desc.mp_alternate_id_type (alt_id3_type, 'en', 2) alt_id3_type, mp_get_desc.mp_alternate_id_type (alt_id4_type, 'en', 2) alt_id4_type   FROM mp_param";
		
		pstmt = con.prepareStatement(titledisply);	
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next()){			
		if(titlevaluassign.equals("ALT_ID1_NO")) titlevaluassign=rs.getString(1);
		if(titlevaluassign.equals("ALT_ID2_NO")) titlevaluassign=rs.getString(2);		
		if(titlevaluassign.equals("ALT_ID3_NO")) titlevaluassign=rs.getString(3);	
		if(titlevaluassign.equals("ALT_ID4_NO")) titlevaluassign=rs.getString(4);			 
		}		
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
	} catch (Exception e1) {
		e1.printStackTrace();
	}

//String temp_title = altId1Desc+" - "+altIdNo1;
//String temp_title = altId1Desc+" - "+titledesc;

String temp_title = titlevaluassign+" - "+titledesc;
String title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientListforAltIdNo1.label","mp_labels");
title = title.replace("$",temp_title);	

%>
<html>
<head>
<title>	
	<%=title%>
</title>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	async function viewPatientDetails(p_patient_id)
	{
		var title = getLabel("eMP.ViewPatientDetails.label","MP");
		var dialogHeight= "41vh" ;
		var dialogWidth	= "70vw" ;
		var dialogTop="";
		var dialogLeft="1";	
		var prev="prev";
		var display="display";
		var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;	
		retVal	=  await window.showModalDialog('../../eMP/jsp/ViewPatDetailsMain.jsp?display='+display+'&Patient_ID='+p_patient_id,arguments,features);
	} 
	function selectPatientId(patient_id) {
		
		window.returnValue = patient_id; 
		window.close();
	}
</script>
</head>

<body onKeyDown ='lockKey()'>

<% 
	try {

		//con = ConnectionManager.getConnection(request);

		//String patientListSql = "SELECT a.PATIENT_ID, a.PATIENT_NAME, a.PATIENT_NAME_LOC_LANG, a.SEX, to_char(a.DATE_OF_BIRTH,'dd/mm/yyyy') date_of_birth, (select max(FILE_NO) from mr_pat_file_index b where b.patient_id = a.patient_id group by b.patient_id) FILE_NO FROM mp_patient a WHERE a.ALT_ID1_NO = ? ";
		
		/*Above line commented and below line added for this CRF  MMS-SCF-0071 [IN:042582]*/
			
		String patientListSql = "SELECT a.PATIENT_ID, a.PATIENT_NAME, a.PATIENT_NAME_LOC_LANG, a.SEX, to_char(a.DATE_OF_BIRTH,'dd/mm/yyyy') date_of_birth, (select max(FILE_NO) from mr_pat_file_index b where b.patient_id = a.patient_id group by b.patient_id) FILE_NO FROM mp_patient a where" + whereclause.toString();

		pstmt = con.prepareStatement(patientListSql);		

		rs = pstmt.executeQuery();

		if(rs!=null) {

			%>
			<table border = '1' cellpadding = '4' cellspacing = '0' width = '100%' align ='center'>
				<tr>
					<td class = 'columnheader' width = '5%'>&nbsp;+</td>
					<td class = 'columnheader' width = '20%'>&nbsp;<fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class = 'columnheader' width = '20%'>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
					<%
						if(names_in_oth_lang_yn.equals("Y")) {
					%>
					<td class = 'columnheader' width = '20%'>&nbsp;<fmt:message key="eMP.PatientNameInLocalLang.label" bundle="${mp_labels}"/></td>
					<%
						}
					%>
					<td class = 'columnheader' width = '15%'>&nbsp;<fmt:message key="Common.MRNo.label" bundle="${common_labels}"/></td>
					<td class = 'columnheader' width = '10%'>&nbsp;<fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
					<td class = 'columnheader' width = '10%'>&nbsp;<fmt:message key="Common.DOB.label" bundle="${common_labels}"/></td>
				</tr>
					
			<%

			while (rs.next()) {

				patientPos++;

				String patient_id =  rs.getString("PATIENT_ID") == null?"":rs.getString("PATIENT_ID");
				String patient_name =  rs.getString("PATIENT_NAME") == null?"&nbsp;":rs.getString("PATIENT_NAME");
				String patient_loc_name =  rs.getString("PATIENT_NAME_LOC_LANG") == null?"&nbsp;":rs.getString("PATIENT_NAME_LOC_LANG");
				String gender =  rs.getString("SEX") == null?"&nbsp;":rs.getString("SEX");
				String date_of_birth =  rs.getString("DATE_OF_BIRTH") == null?"":rs.getString("DATE_OF_BIRTH");
				String file_no =  rs.getString("FILE_NO") == null?"&nbsp;":rs.getString("FILE_NO"); 

			if(gender.equals("M"))
				gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else if(gender.equals("F"))
				gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			else if(gender.equals("U"))
				gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

			date_of_birth = DateUtils.convertDate(date_of_birth,"DMY","en",locale);

				%>
					<tr>
						<td class = 'label' onclick = "javascript:viewPatientDetails('<%=patient_id%>')" style='width:102;cursor:pointer;color:blue'>+</td>
						<td class = 'label' onClick = 'javascript:selectPatientId("<%=patient_id%>")' style='width:102;cursor:pointer;color:blue'><%=patient_id%>
						</td>
						<td class = 'querydata'>&nbsp;<%=patient_name%></td>
						<%
							if(names_in_oth_lang_yn.equals("Y")) {
						%>
						<td class = 'querydata'>&nbsp;<%=patient_loc_name%></td>
						<%
							}
						%>
						<td class = 'querydata'><%=file_no%></td>
						<td class = 'querydata'><%=gender%></td>
						<td class = 'querydata'><%=date_of_birth%></td>
					</tr>
				<%

			}

		}

		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}

%>

</body>
</html>

