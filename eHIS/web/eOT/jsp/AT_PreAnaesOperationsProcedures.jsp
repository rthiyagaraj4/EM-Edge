<!DOCTYPE html>

<%@page  contentType="text/html;charset=UTF-8" import="eCommon.Common.*,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,eCommon.XSSRequestWrapper,webbeans.eCommon.*" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<html>
<head>

<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id=request.getParameter("facility_id");
	String tab_name=request.getParameter("tab_name");
	String accession_num=checkForNull(request.getParameter("accession_num"));
	String anesthesia_srl_no="";
	if(!tab_name.equalsIgnoreCase("AnesthesiaDetails"))
	{
		 anesthesia_srl_no	=request.getParameter("generated_anesthesia_srl_no");
	}
	else
	{
		anesthesia_srl_no	=request.getParameter("anesthesia_srl_no");
	}

	String order_catalog_code	= "";
	String operation_desc		= "";
	String side_applicable      = "";
	String classValue="";
	
	Connection connection   = null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet     = null ;
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="PreAnaesOperProcForm" id="PreAnaesOperProcForm" >
<table cellpadding=3  cellspacing="0" width="100%" align="center" border="1">
	<tr> 
		<td  colspan=4 class='CAGROUPHEADING'>
		<fmt:message key="eOT.OperationsProcedures.Label"  bundle="${ot_labels}"/> 
		</td>
	</tr>
	<tr>
		<td  class="COLUMNHEADER" align='center' width='20%'>
		<fmt:message key="Common.operation.label" bundle="${common_labels}"/> 
		</td>	
		<td  class="COLUMNHEADER" align='center'width='50%'>
		<fmt:message key="Common.description.label" bundle="${common_labels}"/> 
		</td>
		<td  class="COLUMNHEADER" align='center'width='30%'>
		<fmt:message key="eOT.SideApplicable.Label" bundle="${ot_labels}"/> 
		</td>		 
	</tr>
<%
String sql_oper_proc="";
String sql_oper_proc_1="";
String sql="";
try{


	//Commented against MMS-QH-CRF-0199
	/*sql_oper_proc="SELECT A.ORDER_CATALOG_CODE, B.LONG_DESC, DECODE(NVL(A.RIGHT_LEFT_FLAG,'N'), 'R', 'Right Side', 'L', 'Left Side', 'B', 'Bilateral', 'N', 'Not Applicable') RIGHT_LEFT_FLAG_DESC FROM	 AT_ANAESTHESIA_RECORD_DTL A, OR_ORDER_CATALOG_LANG_VW B WHERE B.LANGUAGE_ID=? AND OPERATING_FACILITY_ID = ? AND	A.ANAESTHESIA_SERIAL_NUM = ? AND	A.ORDER_CATALOG_CODE = B.ORDER_CATALOG_CODE";*/
	//Added against MMS-QH-CRF-0199
	sql_oper_proc="SELECT a.order_catalog_code, c.long_desc,DECODE (NVL (a.right_left_flag, 'N'),'R', 'Right Side','L', 'Left Side','B', 'Bilateral','N', 'Not Applicable') right_left_flag_desc FROM at_anaesthesia_record_dtl a, or_order_catalog_lang_vw b, OT_OPER_MAST_LANG_VW c WHERE c.language_id = ? and  b.language_id = c.language_id AND operating_facility_id = ? AND a.anaesthesia_serial_num = ? AND a.order_catalog_code = b.order_catalog_code and a.ORDER_CATALOG_CODE = C.ORDER_CATALOG_CODE ";
	
	sql_oper_proc_1="SELECT A.OPER_CODE, B.LONG_DESC,DECODE( NVL(A.RIGHT_LEFT_FLAG, 'N'), 'R', 'Right Side', 'L', 'Left Side', 'B','Bilateral', 'N', 'Not Applicable') RIGHT_LEFT_FLAG_DESC FROM OT_POST_OPER_DTLS A, OT_OPER_MAST_LANG_VW B	WHERE B.LANGUAGE_ID=? AND A.OPERATING_FACILITY_ID = ? AND A.OPER_NUM = ? AND  A.OPER_CODE= B.OPER_CODE";
	
	sql = "".equals(accession_num)?sql_oper_proc:sql_oper_proc_1;

	connection	= ConnectionManager.getConnection(request);
	pstmt			= connection.prepareStatement(sql) ;
	pstmt.setString(1,locale);
	pstmt.setString(2,facility_id);
	if( "".equals(accession_num) )
		pstmt.setString(3,anesthesia_srl_no);
	else
		pstmt.setString(3,accession_num);
	resultSet			= pstmt.executeQuery();
	int i=0;
	while(resultSet!=null && resultSet.next()){
	 	i++;
		order_catalog_code = resultSet.getString(1);//ORDER_CATALOG_CODE
		operation_desc = resultSet.getString(2);//LONG_DESC
		side_applicable = resultSet.getString("RIGHT_LEFT_FLAG_DESC");//RIGHT_LEFT_FLAG_DESC
		classValue=(i%2==0)?"gridData":"gridData";
	%>

	<tr>
		<td class='<%=classValue%>' width='20%' ><%=order_catalog_code%></td>
		<td class='<%=classValue%>' width='50%' ><%=operation_desc%></td>
		<td class='<%=classValue%>' width='30%' ><%=side_applicable%></td>
	</tr>
	<%
	    }
	}catch ( Exception e ) {
		System.err.println("Caught exception in AT_PreAnaesOperationsProcedures.jsp: "+e);
            e.printStackTrace() ;
	}finally {
        try{	
				if(resultSet!=null) resultSet.close();
				if(pstmt!=null) pstmt.close();
				if(connection!=null) 
					ConnectionManager.returnConnection(connection,request);
            }catch(Exception es){es.printStackTrace();}
	}
%>

</table>
</form>
</body>
</html>

