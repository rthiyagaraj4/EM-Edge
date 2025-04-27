<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) p.getProperty("LOCALE");
%>

<html>
<title><fmt:message key="eCA.ViewSpecialtyEventHistory.label" bundle="${ca_labels}"/></title>
<head> 
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link> 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCA/js/ViewSpecialtyEventHist.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	
	Connection con = null;
	PreparedStatement pstmtDt = null;
	ResultSet rsDt = null;
	
	//String disabled ="";
	String disablePrev = " disabled ";
	String disableNext = "";
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String module_id = request.getParameter("module_id")==null?"":request.getParameter("module_id");
	String cycle_no = request.getParameter("cycle_no")==null?"":request.getParameter("cycle_no");
	int nKey = 0;
	try
	{
		con = ConnectionManager.getConnection(request);
		//pstmtDt = con.prepareStatement("SELECT DISTINCT TO_CHAR(trans_date,'dd/mm/yyyy hh24:mi') trans_date 	FROM CA_SPLTY_DISCR_MSR WHERE patient_id="+"'"+patient_id+"'"+" AND module_id="+"'"+module_id+"'"+" AND cycle_no="+cycle_no+" ORDER BY TO_DATE(trans_date,'dd/mm/yyyy hh24:mi') desc");
		pstmtDt = con.prepareStatement("SELECT DISTINCT TO_CHAR(trans_date,'dd/mm/yyyy hh24:mi:ss') trans_date 	FROM CA_SPLTY_DISCR_MSR WHERE patient_id=? AND module_id=? AND cycle_no=? and TASK_CODE=? ORDER BY TO_DATE(trans_date,'dd/mm/yyyy hh24:mi:ss') desc");
		int nCtr = 0;
		try
		{
			pstmtDt.setString(1,patient_id);
			pstmtDt.setString(2,module_id);
			pstmtDt.setString(3,cycle_no);
			pstmtDt.setString(4,"MCT002");
			rsDt = pstmtDt.executeQuery();
	
			String strDateRecd = "";
			
			while (rsDt.next())
			{
				strDateRecd = rsDt.getString(1);

				if (nCtr%10 == 0)
				{
					%>
						<script>
						dtArr[<%=nKey%>] = "<%=strDateRecd%>";</script>
					<%

						nKey++;
				}
				nCtr++;
			}

			if(nCtr%10!=0)
			{%>
				<script>dtArr[<%=nKey%>] = "<%=strDateRecd%>";</script>
			<%}
			if(nKey == 0)
			{ 
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			}
		}
		catch (Exception ee1)
		{
			//out.println(ee1);//COMMON-ICN-0181
                        ee1.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(rsDt != null) rsDt.close();
			if(pstmtDt != null) pstmtDt.close();
		}
	}
	catch(Exception e)
	{
		//out.println(e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='controlsForm' id='controlsForm' >
<input type = hidden  name = idx_value		value = <%=nKey%> - 1>
<input type = hidden  name = cur_idx_value	value = "0">
<input type = hidden  name = queryString	value = "<%=request.getQueryString()%>">
</TABLE>
<table border=0 cellpadding=0 cellspacing=0 width="100%" align='right' id='tablePrevNext' style='display'>
	<tr>
		<td  width='85%'>&nbsp;</td>
		<td align='left' width='5%'><input type='button' id='prev' name='prev' id='prev' value='<' <%=disablePrev%> class='button' onclick='loadPrevNext(this)' align='right'></td>
		<td  align ='center' class = 'QRYEVEN'>
				<input type ='label' class="LABEL" name = 'label_cap'> 
		</td>
		<td align='left' width='5%'><input type='button' id='next' name='next' id='next' value='>' <%=disableNext%> class='button' onclick='loadPrevNext(this)' ></td>
	</tr>
</table>
<script>
function defaultPage()
{
	var idx_value	= document.forms[0].idx_value.value;
	var cur_idx_value = document.forms[0].cur_idx_value.value;

	var fromDateTime ="";
	var toDateTime ="";
	var displend = "";
	var displstart = 1;

	if(idx_value > 0)
	{
		fromDateTime	= dtArr[0];
		toDateTime		= dtArr[1];
		displend = eval(idx_value) ;
		parent.controlsFrame.document.forms[0].cur_idx_value.value = 0;
		parent.controlsFrame.document.forms[0].label_cap.value = displstart + " of " + displend;

		if(idx_value == 1)
		{
			parent.controlsFrame.document.forms[0].next.disabled = true;
			parent.controlsFrame.document.forms[0].prev.disabled = true;

		}
		populateControl();
		
	}
}
defaultPage();
</script>
</form>
</body>
</html>

