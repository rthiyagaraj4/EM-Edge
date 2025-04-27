<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	webbeans.eCommon.RecordSet NTRecordSet = (webbeans.eCommon.RecordSet)getObjectFromBean("NTRecordSet","webbeans.eCommon.RecordSet",session);

%>
<jsp:useBean id="getLincKey" scope="page" class="eCA._ca_license_rights"/>
<%!int row_count=0;%>
<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language=javascript src='../../eCommon/js/ValidateControl.js'></script>
</head>
<%
//String  code			= request.getParameter("code");
//String  grp_by_code		= request.getParameter("grp_by_code");
//String  group_by		= request.getParameter("group_by");
//String checkedOnes	= "";

String  rowCount	= request.getParameter("rowCount");
String  transcription_yn	= request.getParameter("transcription_yn")==null?"":request.getParameter("transcription_yn");
HashMap hMapRecords		= null;



int i;
row_count	=	NTRecordSet.getSize();
int total = Integer.parseInt(rowCount);
hMapRecords = (java.util.HashMap)NTRecordSet.getObject(total);
for(i=0; i<row_count; i++)
{
	hMapRecords = (java.util.HashMap)NTRecordSet.getObject(i);		
	if(total == i)
	{
		hMapRecords.put("dflt_transcription_yn"		  , transcription_yn);
	}
	else
	{
		String dflt_trans_yn = (String)hMapRecords.get("dflt_transcription_yn");
		if(dflt_trans_yn.equalsIgnoreCase("Y"))
		{
			hMapRecords.put("dflt_transcription_yn", "N");
			hMapRecords.put("associate", "Y");
			hMapRecords.put("insUpd", "U");
		}
	}						
	NTRecordSet.setObject(i, hMapRecords);
	
}
	putObjectInBean("NTRecordSet",NTRecordSet,session);


					
/*String	sql=" Select 'Y'  from ca_encntr_note a ,  ca_note_type_for_resp  b , sm_resp_for_user c  where  b.resp_id = c.resp_id and a.added_by_id = c.appl_user_id and a.event_status='1' and  b.resp_id = ? and  a.note_type = ? ";

String result="";
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
try{
	con		=	ConnectionManager.getConnection(request);
	pstmt	=	con.prepareStatement(sql);

	if(group_by.equals("NT")){
		pstmt.setString(1,code);
	}else if(group_by.equals("RS")){
		pstmt.setString(1,grp_by_code);
	}

	if(group_by.equals("NT")){
		pstmt.setString(2,grp_by_code);
	}else if(group_by.equals("RS")){
		pstmt.setString(2, code);  
	}

    if(!(group_by.equals("NT")))
	{
		for(i=0; i<= row_count; i++)
	   {

		checkedOnes = request.getParameter("transcription"+(i));
		}
	}


	rs=pstmt.executeQuery();

	if(rs!=null){
		while(rs.next()){
			result=rs.getString(1);
		}
	}
	if(result.equals("")||result==null)
		result="";
	else
		result=result.trim();*/
	/*if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
}
catch(Exception e)
	{
	out.println("Exception @ try "+e.toString());
	}		
finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}*/
		
	   
%>

<body class=message OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
</body>

