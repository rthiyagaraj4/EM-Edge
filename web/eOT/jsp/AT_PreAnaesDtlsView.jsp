<!DOCTYPE html>
<%@ page import= "eOT.*, eOT.Common.*, eCommon.Common.*,webbeans.eCommon.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,java.io.BufferedReader,java.sql.Clob" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	%>
<html>
<title>
	<fmt:message key="eOT.ViewPreAnaesthesiaEvaluationDetails.Label" bundle="${ot_labels}"/>
</title>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script> 
</head>

<% 
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String anesthesia_srl_no = CommonBean.checkForNull(request.getParameter("anesthesia_srl_no"));
	//String contr_mod_accession_num=facility_id+anesthesia_srl_no+"PRE%";//"LD187PRE";
	String contr_mod_accession_num=anesthesia_srl_no+"PRE%";//ML-BRU-SCF-1418 [IN:050757]
	String Sql="SELECT NOTE_CONTENT FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM LIKE ('%"+contr_mod_accession_num +"') and Event_Status <> '9'"; //ML-BRU-SCF-1418 [IN:050757] //added by Sanjay for Surgeon Notes against IN34391
	System.err.println("Sql in AT_PreAnaesDtlsView.jsp ===> "+Sql);
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	StringBuffer content  = new StringBuffer();
	BufferedReader bf_content_reader = null;
	String notes_content="";
	Clob clob_notes_content = null;
	int index=0;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(Sql);
	//	pstmt.setString(1,contr_mod_accession_num);
		rst=pstmt.executeQuery();
		while( rst.next() ){
			++index;
			clob_notes_content	= rst.getClob("note_content");
			if(clob_notes_content!=null){
				bf_content_reader = new java.io.BufferedReader(clob_notes_content.getCharacterStream());
				char[] arr_notes_content = new char[(int)clob_notes_content.length()];
				bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
				notes_content = new String(arr_notes_content);
				content.append(notes_content);
				bf_content_reader.close();
				out.println(content.toString());
			}
		}
		if(index==0){
		%>
		<script>
			var msg_1 = getMessage("APP-OT0088","OT");
			var msgArray = msg_1.split("#");
			var msg = msgArray[0]+(getLabel("eOT.PreAnaesthesiaNotes.Label","OT"))+(msgArray[1]);	
			alert(msg);	
			window.close();
		</script>
		<%
		}
	}catch(Exception e){
		 System.err.println("Err PreAnaesDtlView :"+e.getMessage());
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(bf_content_reader!=null) bf_content_reader.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
			content.setLength(0);
		}catch(Exception e){}
	}
	%> 
</html>

