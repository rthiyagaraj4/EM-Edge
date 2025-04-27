<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@page  contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>             

<%	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<html>
<head>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script>
<script language='JavaScript' src='../../eOT/js/OTMessages.js'></script> -->
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eOT/js/DrugNotification.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey();">
<%
	
		String from = checkForNull(request.getParameter( "from" ) ) ;
		String to =   checkForNull(request.getParameter( "to" ) ) ;
		String def_type = checkForNull(request.getParameter("def_type"),"S");
		String drug_desc = checkForNull(request.getParameter("drug_desc"));
		String status = checkForNull(request.getParameter("status"),"B");
		if(status.equals("E")) status = "Y";
		if(status.equals("D")) status = "N";
		String empty = "".intern();
		String whereClause = empty;
		//String notify_anesthesia_yn=empty;
		int start = ( from.equals("") )?1:Integer.parseInt(from);
		int end = ( from.equals("") )?14:Integer.parseInt(to);
		String sql = empty;
		switch(def_type.charAt(0)){
			case 'D' : sql ="SELECT 'Drug', A.DRUG_DESC,  DECODE(B.DRUG,NULL,'N',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N')) FROM PH_DRUG_LANG_VW A, OT_DRUGS_FOR_NOTIFICATION B WHERE A.LANGUAGE_ID='"+locale+"' AND A.DRUG_CODE = B.DRUG(+) AND B.DEFN_TYPE(+) = 'D'";
			whereClause=whereClause+( (drug_desc.length()>0)?" and UPPER(A.DRUG_DESC) LIKE UPPER('"+drug_desc+"%')":"");
			whereClause=whereClause+" AND DECODE(B.DRUG,NULL,'B',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N')) = DECODE(B.DRUG,NULL,'"+status+"',DECODE('"+status+"','B',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N'),'"+status+"')) ";
			sql=sql+whereClause;
			break;

			case 'G' : sql ="SELECT 'Generic', A. GENERIC_NAME,  DECODE(B.DRUG,NULL,'N',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N')) FROM  PH_GENERIC_NAME_LANG_VW A, OT_DRUGS_FOR_NOTIFICATION B WHERE A.LANGUAGE_ID='"+locale+"' AND A. GENERIC_ID = B.DRUG(+) AND B.DEFN_TYPE(+)	= 'G' ";
			whereClause=whereClause+( (drug_desc.length()>0)?" and UPPER(A.GENERIC_NAME) LIKE UPPER('"+drug_desc+"%')":"");
			whereClause=whereClause+" AND DECODE(B.DRUG,NULL,'B',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N')) = DECODE(B.DRUG,NULL,'"+status+"',DECODE('"+status+"','B',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N'),'"+status+"')) ";
			sql=sql+whereClause;
			break;

			case 'S' : 
			sql="SELECT 'Drug' DEFN_TYPE,A.DRUG_DESC DRUG,  DECODE(B.DRUG,NULL,'N',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N')) NOTIFY_PRE_ANESTHESIA_YN FROM PH_DRUG_LANG_VW A, OT_DRUGS_FOR_NOTIFICATION B WHERE A.LANGUAGE_ID='"+locale+"' AND A.DRUG_CODE = B.DRUG(+) AND B.DEFN_TYPE(+) = 'D'";
			whereClause=(drug_desc.length()>0)?" and UPPER(A.DRUG_DESC) LIKE UPPER('"+drug_desc+"%')":"";
			whereClause=whereClause+" AND DECODE(B.DRUG,NULL,'B',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N')) = DECODE(B.DRUG,NULL,'"+status+"',DECODE('"+status+"','B',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N'),'"+status+"')) ";
			sql=sql+whereClause;
			sql=sql+" UNION SELECT 'Generic' DEFN_TYPE,A.GENERIC_NAME,  DECODE(B.DRUG,NULL,'N',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N')) NOTIFY_PRE_ANESTHESIA_YN FROM   PH_GENERIC_NAME_LANG_VW A, OT_DRUGS_FOR_NOTIFICATION B WHERE A.LANGUAGE_ID='"+locale+"' AND  A. GENERIC_ID = B.DRUG(+) AND B.DEFN_TYPE(+) = 'G' ";
			whereClause= (drug_desc.length()>0)?" and UPPER(A.GENERIC_NAME) LIKE UPPER('"+drug_desc+"%')":"";
			whereClause=whereClause+" AND DECODE(B.DRUG,NULL,'B',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N')) = DECODE(B.DRUG,NULL,'"+status+"',DECODE('"+status+"','B',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N'),'"+status+"')) ";
			sql=sql+whereClause;
			break;
		}

	//appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");
    if (ord!=null && ord.length>0){
        sql=sql+" ORDER BY ";
        for ( int i=0;i < ord.length;i++ ){
		  sql=sql+((i==ord.length-1)?ord[i]:ord[i]+",");
		}
    }
    
    //out.println("Line-->71"+sql);
	   
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	int maxRecord = 0;
	int i=1;
	try{
		 conn  =  ConnectionManager.getConnection(request);
		 pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		 rst = pstmt.executeQuery();
		//move the pointer to last record to get the maxRecord
		rst.last();maxRecord=rst.getRow();
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		//move the resultset pointer to initial position.
		rst.beforeFirst();

%>
<form name='UpdateQueryResultForm' id='UpdateQueryResultForm'>
<P>
<table align='right'>
<center>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A href='../../eOT/jsp/DrugNotificationModify.jsp?from="+(start-14)+"&to="+(end-14)+"&status="+status+"&drug_desc="+drug_desc+"&def_type="+def_type+"'"+" text-decoration='none' target='f_query_add_mod'>Prev</A>");

if ( !( (start+14) > maxRecord ) )
	   out.println("<A href=../../eOT/jsp/DrugNotificationModify.jsp?from="+(start+14)+"&to="+(end+14)+"&status="+status+"&drug_desc="+drug_desc+"&def_type="+def_type+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	   //out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='nxt();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding=3  align='center'>
<th class="columnheadercenter" nowrap>  <!-- changed by yadav -->
	<fmt:message key="Common.DefinitionType.label" bundle="${common_labels}"/>
</th>
<th class="columnheadercenter" nowrap>  <!-- changed by yadav -->
	<fmt:message key="ePH.DrugDescription.label" bundle="${ph_labels}"/>
</th>
<th class="columnheadercenter" nowrap>  <!-- changed by yadav -->
	<fmt:message key="eOT.NotifyAtPreAnaesthesia.Label" bundle="${ot_labels}"/>
</th>
<%
	
   if ( start != 1 ) rst.absolute(start-1);
		i=start;
   	String classValue= "";
	String flag="";
	StringBuffer sbr = new StringBuffer();
	while (rst.next() && i<=end  ){
		classValue = ( i % 2 == 0 )?"gridData":"gridData" ; // changed by yadav
	     
	//String mode="modify";
	//out.println("<a href='../../eOT/jsp/BlockSlotsBySpecialityFrameForCreate.jsp?update_mode_yn="+mode+"&oper_room_code="+oper_room_code+"&wd_start_time="+rset.getString(3)+"&wd_end_time="+rset.getString(4)+"&hd_start_time="+rset.getString(5)+"&hd_end_time="+rset.getString(6)+"' target='f_query_add_mod' >");
    //out.println(oper_room_code+"</a></td>");
	sbr.append("<tr>");
	sbr.append("<td class='"+classValue+"'>"+rst.getString(1)+"</td>");
	sbr.append("<td class='"+classValue+"'>"+rst.getString(2)+"</td>");
	flag =(rst.getString(3).equals("Y"))?"enabled.gif":"RRnwd.gif"; 
	sbr.append("<td class='").append(classValue).append("'><img src='../../eCommon/images/"+flag+"'></img></td></tr>");
    i++;
  } 
out.println(sbr.toString());
sbr.setLength(0);
%>
</table>
</center>

<br><center>

<%
}catch(Exception e){
		e.printStackTrace();
		//out.println("Err Msg in DrugNotificationModify.jsp(OT)-->"+e);
}finally{
		try{
			if(pstmt!=null)	pstmt.close();
			if(rst!=null)	rst.close();
			ConnectionManager.returnConnection(conn,request);
		}catch(Exception e){e.printStackTrace();}
}

%>
</center>
<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>" >
<input type="hidden" name="start" id="start" value="<%=start%>" >
<input type="hidden" name="def_type" id="def_type" value="<%=def_type%>" >
<input type="hidden" name="end" id="end" value="<%=end%>" >

<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

