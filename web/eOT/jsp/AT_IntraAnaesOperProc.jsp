<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.XSSRequestWrapper,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js">
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id=request.getParameter("facility_id");
	String anesthesia_srl_no	=request.getParameter("anesthesia_srl_no");
	String accession_num	=checkForNull(request.getParameter("accession_num"));
	String classValue="";

	Connection connection   = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet     = null;
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="RecordPreAnesthesiaOrdersProcForm" id="RecordPreAnesthesiaOrdersProcForm" >
<table cellpadding=3  cellspacing="0" width="100%" align="center" border="1">
	<tr>
		<td width='30%'  class="columnHeader"  align='center'>
		<fmt:message key="Common.operation.label" bundle="${common_labels}"/>
		</td>

		<td width='30%' class="columnHeader" align='center'>
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>		
		</td>		

		<td width='30%' class="columnHeader" align='center'>
		<fmt:message key="eOT.SideApplicable.Label" bundle="${ot_labels}"/>
		</td>		 
	</tr>

	<%
	try{
		//Added against MMS-QH-CRF-0199
		String sql_oper_proc="SELECT a.order_catalog_code, c.long_desc,DECODE (NVL (a.right_left_flag, 'N'),'R', 'Right Side','L', 'Left Side','B', 'Bilateral','N', 'Not Applicable') right_left_flag_desc FROM at_anaesthesia_record_dtl a, or_order_catalog_lang_vw b, OT_OPER_MAST_LANG_VW c WHERE c.language_id = ? and  b.language_id = c.language_id AND operating_facility_id = ? AND a.anaesthesia_serial_num = ? AND a.order_catalog_code = b.order_catalog_code and a.ORDER_CATALOG_CODE = C.ORDER_CATALOG_CODE ";
		
		String sql_oper_proc_1="SELECT A.OPER_CODE, B.LONG_DESC,DECODE( NVL(A.RIGHT_LEFT_FLAG, 'N'), 'R', 'Right Side', 'L', 'Left Side', 'B','Bilateral', 'N', 'Not Applicable') RIGHT_LEFT_FLAG_DESC FROM OT_POST_OPER_DTLS A, OT_OPER_MAST_LANG_VW B	WHERE B.LANGUAGE_ID=? AND A.OPERATING_FACILITY_ID = ? AND A.OPER_NUM = ? AND  A.OPER_CODE= B.OPER_CODE and a.OPER_LINE_STATUS IS NULL"; //Modified Against ARYU-SCF-0099
		
		String sql = "".equals(accession_num)?sql_oper_proc:sql_oper_proc_1;
		connection	= ConnectionManager.getConnection(request);
		pstmt		= connection.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		if("".equals(accession_num))
			pstmt.setString(3,anesthesia_srl_no);
		else
			pstmt.setString(3,accession_num);
			resultSet			= pstmt.executeQuery();
		int i=0;
		while(resultSet!=null && resultSet.next()){
			i++;
			if((i%2)==0)	 
				classValue="gridData";
			else			 
				classValue="gridData";	
	%>

	<tr>
		<td class='<%=classValue%>' ><%=resultSet.getString(1)%></td>
		<td class='<%=classValue%>' ><%=resultSet.getString(2)%></td>
		<td class='<%=classValue%>' ><%=resultSet.getString(3)%></td>
	</tr>

	<%
	}
	}catch(Exception e){
      e.printStackTrace();
	}finally{
        try{					
		if(resultSet!=null) resultSet.close();
		if(pstmt!=null) pstmt.close();
		if(connection!=null) 
		ConnectionManager.returnConnection(connection,request);
            }catch(Exception es){
				es.printStackTrace();
				}
	}
%>
</table>
</form>
</body>
</html>

