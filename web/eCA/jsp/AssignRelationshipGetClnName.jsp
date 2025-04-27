<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

 Properties p = (Properties)session.getValue("jdbc");
String locale	= (String) p.getProperty("LOCALE");

	Connection	con	=	null;
	

	String clinician_id = ""; 
	String clinician_name = "",limitPractList="",episode_type="",location_code="";
	String clinician_type = "";
	StringBuffer query_clinician_details = new StringBuffer();
	String modal = request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
	location_code = request.getParameter("episode_type")==null?"":request.getParameter("location_code");
	episode_type = request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
	limitPractList = request.getParameter("limitPractList")==null?"N":request.getParameter("limitPractList");
	String patient_id = request.getParameter("patient_id")==null?"N":request.getParameter("patient_id");
	String episode_id = request.getParameter("episode_id")==null?"N":request.getParameter("episode_id");

	String facility_id = (String) session.getValue("facility_id");


	out.println("<html><head>");
	out.println("<link rel='StyleSheet' href='../../eCommon/html/"+sStyle+"' type='text/css' />");
	out.println("<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>");
	out.println("<script language='javascript'> var frmref = '';  if('"+modal+"' == 'Y') frmref =parent ; else frmref = top.content.workAreaFrame;");

	try
	{
		PreparedStatement	pstmt	=	null;
		ResultSet			rs		=	null;
		
		//con				=	(Connection) session.getValue("connection");
		
		con = ConnectionManager.getConnection(request);
		
		clinician_type	=	request.getParameter("clinician_type");
		clinician_id  = (String)session.getValue("ca_practitioner_id");

		query_clinician_details = new StringBuffer();
		//query_clinician_details.append("select replace(PRACTITIONER_NAME,'''','') short_name, practitioner_id from am_pract_for_facility_vw where OPERATING_FACILITY_ID   = ? and pract_type = ? and practitioner_id != ? and PRACTITIONER_ID not in ( select PRACTITIONER_ID from  ca_encntr_pract_reln where PATIENT_ID =? and   sysdate between begin_date_time and nvl(end_date_time,sysdate)  and ENCOUNTER_ID = ? and facility_id=? ) ");

		query_clinician_details.append("select replace(b.practitioner_name,'''','') short_name, G.practitioner_id from am_pract_for_facility G, AM_PRACTITIONER_LANG_VW B  where G.FACILITY_ID   = ? and b.pract_type = ? and G.practitioner_id != ? and G.PRACTITIONER_ID=b.PRACTITIONER_ID  and b.language_id =  ? and G.PRACTITIONER_ID not in ( select PRACTITIONER_ID from  ca_encntr_pract_reln where PATIENT_ID =? and   sysdate between begin_date_time and nvl(end_date_time,sysdate)  and ENCOUNTER_ID = ? and facility_id=? ) ");
			
			//Limit Practitioner List to Access Location Checkbox checked	
			if(limitPractList.equals("Y")){
				query_clinician_details.append(" AND EXISTS(SELECT 1 FROM CA_PRACT_BY_LOCN A WHERE A.PRACTITIONER_ID=G.practitioner_id AND A.FACILITY_ID=FACILITY_ID ");

				if(episode_type.equals("O")){
					query_clinician_details.append(" AND (   (A.LOCN_TYPE='C' AND A.LOCN_CODE=?) OR 	(A.LOCN_TYPE='X') OR (A.LOCN_TYPE='Z') OR (A.LOCN_TYPE='P' AND EXISTS (SELECT 1 		FROM op_pract_for_clinic I WHERE I.FACILITY_ID=A.FACILITY_ID AND 					I.PRACTITIONER_ID=A.PRACTITIONER_ID AND I.CLINIC_CODE=?))) ");		
				}else if(episode_type.equals("I")){
					query_clinician_details.append(" AND (  (A.LOCN_TYPE='W' AND A.LOCN_CODE=?) OR (A.LOCN_TYPE='Y') OR (A.LOCN_TYPE='Z') OR (A.LOCN_TYPE='P' AND EXISTS (SELECT 1 FROM IP_NURSING_UNIT_FOR_PRACT  I WHERE I.FACILITY_ID=A.FACILITY_ID AND I.PRACTITIONER_ID=A.PRACTITIONER_ID AND I.NURSING_UNIT_CODE=?))) ");
   				}
				query_clinician_details.append(")");
			}
			query_clinician_details.append(" order by short_name");

		pstmt		=	con.prepareStatement(query_clinician_details.toString());
		
		
		pstmt.setString(1, facility_id);
		pstmt.setString(2, clinician_type);
		pstmt.setString(3, clinician_id);
		pstmt.setString(4, locale);
		pstmt.setString(5, patient_id);
		pstmt.setString(6, episode_id);
		pstmt.setString(7, facility_id);

		if(limitPractList.equals("Y")){
			pstmt.setString(8, location_code);
			pstmt.setString(9, location_code);
		}

		rs	=	pstmt.executeQuery();

		//out.println("alert('frame name : '+frmref.frames[0].name);");
		out.println("var opt=frmref.AssignRelationshipFrame.document.createElement('OPTION'); ");
		String strSele = com.ehis.util.BundleMessage.getBundleMessage(pageContext ,"Common.defaultSelect.label","common_labels");
		out.println("opt.text	=	'-----" +strSele+"----'");
		out.println("opt.value	=	'';");
		out.println("frmref.AssignRelationshipFrame.document.forms[0].clinician_id.add(opt); ");
		out.println("frmref.AssignRelationshipFrame.document.forms[0].clinician_id.disabled=false; ");
		while(rs.next())
		{
			clinician_id		=	rs.getString(2);
			clinician_name		=	rs.getString(1);
			out.println("var opt=frmref.AssignRelationshipFrame.document.createElement('OPTION'); ");
			out.println("opt.text	=	'"+clinician_name+"';");
			out.println("opt.value	=	'"+clinician_id+"';");
			out.println("frmref.AssignRelationshipFrame.document.forms[0].clinician_id.add(opt); ");
		}
	
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception in AssignRelationshipGetClnName.jsp"+e);//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		out.println("</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></head><body class='MESSAGE' onKeyDown='lockKey()'></body></html>");
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

