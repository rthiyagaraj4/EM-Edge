<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>


<html><head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<script language='javascript' src='../../eCA/js/RelatedPatientHist.js'></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/showModalDialog.js"></script>


<%
	Connection			conlCon		=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rslRst		=	null;

	String facilityid		= (request.getParameter("facilityid")==null)?"":request.getParameter("facilityid");
	String encounterid      = (request.getParameter("encounterid")==null)?"":request.getParameter("encounterid");
	String patientid        = (request.getParameter("patientid")==null)?"":request.getParameter("patientid");
	String accessnum="";
	int accnum=0;
	
	try	
		{
		conlCon				=	(Connection)	ConnectionManager.getConnection(request);

		String sql="select count(*) EXIST_COUNT from ca_encntr_note where FACILITY_ID=? and ENCOUNTER_ID=? and EVENT_STATUS in ('4','5') and note_type in (SELECT B.NOTE_TYPE FROM CA_NOTE_GROUP a,CA_NOTE_TYPE B WHERE A.APPL_TASK_ID='DISCHARGE_SUMMARY' AND B.NOTE_GROUP_ID=A.NOTE_GROUP )";
	
		pstmt = conlCon.prepareStatement(sql);
		pstmt.setString(1,facilityid);
        pstmt.setString(2,encounterid);
		rslRst = pstmt.executeQuery();
        
		while(rslRst.next()) {
					accessnum	=	(rslRst.getString("EXIST_COUNT")==null)?"":rslRst.getString("EXIST_COUNT");
		}
		accnum=Integer.parseInt(accessnum);
		if(accnum>0)
		{%>
       
        <script language='javascript'>callChart("<%=encounterid%>","<%=patientid%>");</script>

		<%
			}
           else
		{
			   out.println("<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));</script>");
			   // out.println("<script>window.close();</script>");
			   //out.println("<script>alert('CA-03000 There is no Summary Record found for this Encounter');</script>");
		}
		
			
		} 
		
	catch(Exception e){
		//out.println("Exception@1: "+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}finally{

		if(rslRst!=null) rslRst.close();
		if(pstmt!=null) pstmt.close();
		if(conlCon!=null) ConnectionManager.returnConnection(conlCon,request);
	}

%>

