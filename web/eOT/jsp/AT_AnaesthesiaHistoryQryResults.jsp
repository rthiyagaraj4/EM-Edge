<!DOCTYPE html>
<html>                   
<%@page  contentType="text/html;charset=UTF-8" import="java.util.ArrayList, webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="StyleSheet" type="text/css" href="../../eOT/html/AnaesthesiaHistoryStyle.css"></link>
<script language="JavaScript" src="../../eOT/js/AT_AnaesthesiaHistory.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<Script src="../../eXH/js/showModalDialog.js" language="JavaScript"></Script>
</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- Added against MMS-QH-CRF-0199-->
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<div name='tooltiplayer' id='tooltiplayer' style='position:absolute;width:20%; visibility:hidden;' bgcolor='blue'></div>
</div>
<form name="AnaesthesiaHistoryQryResultsForm" id="AnaesthesiaHistoryQryResultsForm">
<table class='grid' cellpadding="3" cellspacing="0" border="1" width="100%" >
<tr>
	<th class="columnHeader" nowrap></th>
	<th class="columnHeader" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
	<th class="columnHeader" nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
	<th class="columnHeader" nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
	<th class="columnHeader" nowrap><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></th>
	<th class="columnHeader" nowrap><fmt:message key="eOT.SurgeryDate.Label" bundle="${ot_labels}"/></th>
	<th class="columnHeader" nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
	<th class="columnHeader" nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></th>
	<th class="columnHeader" nowrap><fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/></th>
	<th class="columnHeader" nowrap><fmt:message key="Common.details.label" bundle="${common_labels}"/></th>
	<th class="columnHeader" nowrap><fmt:message key="Common.notes.label" bundle="${common_labels}"/></th>
</tr>
<% 
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String called_from = checkForNull(request.getParameter("called_from"));
	String SQL = checkForNull(request.getParameter("sql"));
	String patient_id="";
	String patient_name="";
	String patient_name1="";
	String oper_date="";
	String strTempOperation="";
	String status="";
	String src_order_id="";
	String oper_desc="";
	String speciality_desc="";
	String anaesthesia_srl_no="";
	String sex="";
	String accession_num="";
	String	qryVal="";
	String surgeon="";
	String anesthetist_name="";
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	ResultSet rst = null;
	ResultSet rset = null;
	String sql_proc="";
	String sql_anes_name="";
	try{

		con = ConnectionManager.getConnection(request);
		System.err.println(" SQL : "+SQL);
		pstmt = con.prepareStatement(SQL);
		rst = pstmt.executeQuery();
		int index=0;
		while(rst.next()){
			++index;
		   qryVal=(index%2==0)?"griddata":"griddata";
		   src_order_id = checkForNull(rst.getString(1));
		   status = checkForNull(rst.getString(2));
		   patient_id = checkForNull(rst.getString(3));
		   patient_name = checkForNull(rst.getString(4));
		   patient_name1=patient_name.replace("'","");//MMHADHOC
		   sex = checkForNull(rst.getString(5));
		   anaesthesia_srl_no=checkForNull(rst.getString(6));
		   oper_date = checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString(7),"DMY","en",locale));
		   speciality_desc = checkForNull(rst.getString(8));
		   oper_desc = checkForNull(rst.getString(9));
		   accession_num = checkForNull(rst.getString(10));
		   surgeon=checkForNull(rst.getString(11));
	if(!accession_num.equals(""))
	{
		sql_proc="SELECT B.LONG_DESC FROM OT_POST_OPER_DTLS A, OT_OPER_MAST_LANG_VW B WHERE B.LANGUAGE_ID=? AND A.OPERATING_FACILITY_ID = ? AND A.OPER_NUM  = ? AND A.OPER_CODE  = B.OPER_CODE ORDER BY 1";	
		pstmt1=con.prepareStatement(sql_proc);
		pstmt1.setString(1,locale);
		pstmt1.setString(2,facility_id);
		pstmt1.setString(3,accession_num);
		rset=pstmt1.executeQuery();
		strTempOperation=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels");
		while(rset.next())
		{
			strTempOperation=strTempOperation+"::"+rset.getString(1)+"::";
		}
	}
	else
	{
		sql_proc="SELECT B.LONG_DESC FROM OR_ORDER_LINE A, OT_OPER_MAST_LANG_VW B WHERE B.LANGUAGE_ID =? AND A.ORDER_ID = ? AND A.ORDER_CATALOG_CODE  = B.ORDER_CATALOG_CODE";	
		pstmt1=con.prepareStatement(sql_proc);
		pstmt1.setString(1,locale);
		pstmt1.setString(2,src_order_id);
		rset=pstmt1.executeQuery();
		strTempOperation=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels");
		while(rset.next())
		{
			strTempOperation=strTempOperation+"::"+rset.getString(1)+"::";
		}
	}
	 if(!src_order_id.equals("") || accession_num.equals("")){
		sql_anes_name="SELECT A.PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_VW A, OT_BOOKING_HDR B WHERE B.OPERATING_FACILITY_ID=? AND A.PRACTITIONER_ID=B.ANAESTHETIST1_CODE AND A.LANGUAGE_ID=? AND B.PATIENT_ID=?";	
		pstmt1=con.prepareStatement(sql_anes_name);
		pstmt1.setString(1,facility_id);
		pstmt1.setString(2,locale);
		pstmt1.setString(3,patient_id);
		rset=pstmt1.executeQuery();
		while(rset.next())
		{
			anesthetist_name=rset.getString(1);
		}
	 }else if(!accession_num.equals("") || src_order_id.equals("")){
		sql_anes_name="SELECT A.PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_VW A, OT_BOOKING_HDR B WHERE B.OPERATING_FACILITY_ID=? AND A.PRACTITIONER_ID=B.ANESTHETIST_CODE AND A.LANGUAGE_ID=? AND B.PATIENT_ID=?";	
		pstmt1=con.prepareStatement(sql_anes_name);
		pstmt1.setString(1,facility_id);
		pstmt1.setString(2,locale);
		pstmt1.setString(3,patient_id);
		rset=pstmt1.executeQuery();
		while(rset.next())
		{
			anesthetist_name=rset.getString(1);
		}	
	 }
	   	%>
<tr>
	<td class='<%=status%>' width='4%'>
	</td>
	<td width='10%' nowrap id='orderctl<%=index%>' style='cursor:pointer' class='gridDataBlue' onClick="displayToolTip('<%=facility_id%>','<%=patient_id%>','<%=patient_name1%>','<%=sex%>','<%=anaesthesia_srl_no%>','<%=called_from%>','<%=surgeon%>','<%=anesthetist_name%>',this,'imgArrow<%=index%>');"  width='10%'  >
	<%=patient_id%><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow<%=index%>' id='imgArrow<%=index%>'></td>
	
	<td class='<%=qryVal%>' nowrap><%=patient_name%>
	</td>
	<td class='<%=qryVal%>' nowrap><%=sex%></td>
	
	<input type='hidden' name='reason<%=index%>' id='reason<%=index%>' value='<%=strTempOperation%>'>
	<!-- Modified against MMS-QH-CRF-0199 -->
	<td class="<%=qryVal%>"> <img src='../../eOT/images/drugInfo.gif'OnMouseOver="Tip(reasonToolTip('<%=index%>'),FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)"  onMouseOut='UnTip();' nowrap><%=oper_desc%></font></td>
	<td class='<%=qryVal%>' nowrap><%=oper_date%></td>
	
	<td class='<%=qryVal%>' nowrap><%=speciality_desc%></td>
	<td class='<%=qryVal%>' nowrap><%=surgeon%></td>
	<td class='<%=qryVal%>' nowrap><%=anesthetist_name%></td>
		
	<td class="<%=qryVal%>" nowrap><a href="javascript:callAnaesthesiaDetails('<%=facility_id%>','<%=anaesthesia_srl_no%>','<%=accession_num%>','<%=patient_id%>','<%=patient_name1%>','<%=oper_desc%>','<%=src_order_id%>');">
	<fmt:message key="Common.details.label"   bundle="${common_labels}"/>	
	
	
	</a>
	</td>
	
	<td class="<%=qryVal%>" nowrap><a href="javascript:callAnaesthesiaNotes('<%=facility_id%>','<%=anaesthesia_srl_no%>','<%=accession_num%>','<%=patient_id%>','<%=patient_name1%>');"> <!-- IN049924 -->
	<fmt:message key="Common.notes.label"  bundle="${common_labels}"/>	
	</a>
	</td>
</tr>
<%	}
    if(index==0){
		out.println("<script> callNoRecords();</script>");
	}
	}catch(Exception e){
		 System.err.println("Err Msg in AT_AnaesthesiaHistoryQryResults.jsp"+e.getMessage());
	}finally{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>
<input type='hidden' name='src_order_id' id='src_order_id' value="<%=src_order_id%>">
<input type='hidden' name='oper_num' id='oper_num' value="<%=accession_num%>">
<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
<input type='hidden' name='source_order_id' id='source_order_id' value="<%=src_order_id%>">
</table>
</form>
</body>
</html>

