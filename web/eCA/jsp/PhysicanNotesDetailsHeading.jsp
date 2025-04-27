<!DOCTYPE html>
<%/*
-------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------
28/06/2018	IN065341		Prakash C		29/06/2018		Ramesh G 		MMS-DM-CRF-0115
---------------------------------------------------------------------------------------------------------
*/%>
<%@page import="java.util.*, eCA.*,eOR.*,eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCA.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eCA.Notescontent.label" bundle="${ca_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String accession_num=request.getParameter("accession_num"); 
String no_modal=request.getParameter("no_modal");
String sql			="";
Connection con		= null;
ResultSet rs		= null;
PreparedStatement stmt		= null;
String note_type_desc="";
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
//IN065341 starts
	String bean_id = "ca_CentralizedBean" ;
	String bean_name = "eCA.CentralizedBean";
	CentralizedBean bean = (CentralizedBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.clear() ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
String clob_data=request.getParameter("clob_data")==null?"":request.getParameter("clob_data");
//IN065341 ends
	try
	{
		con		= ConnectionManager.getConnection(request);
		rs					=null;
		stmt				=null;
		if(clob_data.equals("_CDR")){
			bean.executeCDR(con,patient_id,encounter_id,RepDb,"CA_ENCNTR_NOTE");
		}
		//IN065341 starts
		//sql="SELECT a.note_content,CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1') note_type_desc FROM ca_encntr_note a where a.accession_num=? ";
		sql="SELECT a.note_content,CA_GET_DESC.CA_NOTE_TYPE##REPDB##(a.note_type,?,'1') note_type_desc FROM ca_encntr_note##CLOB## a where a.accession_num=? ";
		sql=sql.replaceAll("##REPDB##",RepDb);
		sql=sql.replaceAll("##CLOB##",clob_data);
		//IN065341 starts
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,accession_num);
		rs=stmt.executeQuery();
		
		if(rs!=null)
		{
		if(rs.next())
		{

			note_type_desc=rs.getString("note_type_desc");

			}
			}//rs !=null
			
			
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}
			catch(Exception e){
			//out.println("Exception"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
			}
  			finally
			{
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}

	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src='../js/PhysicianNote.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

</head>
<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='heading' id='heading'>
<table border="0" width="100%" cellspacing='0' cellpadding='3' id='tb1'>
<%
if(no_modal !=null && no_modal.equals("Y")){
%>
<tr>
<td class='columnheader' align='left' width="94%"><b><%=note_type_desc%></b></td>
<td class='white' ><input type="button" class='Button' name="open_winodow" id="open_winodow" title='Zoom' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Zoom.label","ca_labels")%>" onClick="call_details('<%=accession_num%>')"></td>
</tr>
<%
}else{
%>
<tr>
<td class='columnheader' width="100%"><b><%=note_type_desc%></b></td> 
</tr>
<%
}
%>
</table>
</form>
</body>
</html>

<!--

For testing
update ca_encntr_note
set note_content='<HTML><HEAD><LINK rel='||''''||'stylesheet'||''''||'type='||
''''||'text/css'||''''||' 
'><body><table><tr wrap>For testing in Physican notes<For testing in Physican notesFor testing in Phy
where accession_num='01984'
/-->

