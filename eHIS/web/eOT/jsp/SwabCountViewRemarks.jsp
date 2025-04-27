<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" import="eOT.*, eOT.Common.*, eCommon.Common.*,webbeans.eCommon.*,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.util.*" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<html>
	<head>
<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eOT/js/SwabCount.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
		<title><%=request.getParameter("remarks_title")%></title>
	</head>
<%
		Connection connection  = null;
		PreparedStatement pstmt=null;
		ResultSet resultset =null;
		StringBuffer remarks_buf = new StringBuffer();
		String initial_remarks = "",add_dur_op_remarks = "",second_count_remarks = "",add_after_cc_remarks = "",final_count_remarks = "",remarks	= "",added_by = "",added_time = "",item_value = "",where_clause = "",sql = "", main_sql = "";

		LinkedHashMap labelNameMap = new LinkedHashMap();
		LinkedHashMap dataMap = new LinkedHashMap();
		String[] getKeyVal;
		String[] getDataMapKeyVal;
		int allwdSwabCntsVal = 0;
		StringBuffer sqlBuffer = new StringBuffer();
		String third_count_remarks = "";
		String add_after_3c_remarks = "";
		String fourth_count_remarks = "";
		String add_after_4c_remarks = "";
		String fifth_count_remarks = "";
		String add_after_5c_remarks = "";
		try
		{
			connection = ConnectionManager.getConnection(request);
			String oper_num = checkForNull(request.getParameter("oper_num"));
			String facility_id	= (String) session.getValue("facility_id");
			String template_id	= checkForNull(request.getParameter("template_id"));
			String item_code = checkForNull(request.getParameter("item_code"));
			String swab_serial_number	= checkForNull(request.getParameter("swab_serial_number"));
			if(swab_serial_number == null || swab_serial_number.trim().length() == 0)
				swab_serial_number = "1";

			allwdSwabCntsVal = Integer.parseInt(checkForNull((request.getParameter("allwdSwabCntsVal") == null || request.getParameter("allwdSwabCntsVal").equals("0")) ? "3" : checkForNull(request.getParameter("allwdSwabCntsVal"))));
			if(allwdSwabCntsVal == 0)
				allwdSwabCntsVal = 3;
			System.out.println("====allwdSwabCntsVal=====SwabCountViewRemarks====="+allwdSwabCntsVal);
			labelNameMap.put(2, "eOT.SecondCount.Label~second_count_remarks~eOT.AddtSecondCount.Label~add_after_cc_remarks");
			labelNameMap.put(3, "eOT.ThirdCount.Label~third_count_remarks~eOT.AddtThirdCount.Label~add_after_3c_remarks");
			labelNameMap.put(4, "eOT.FourthCount.Label~fourth_count_remarks~eOT.AddtFourthCount.Label~add_after_4c_remarks");
			labelNameMap.put(5, "eOT.FifthCount.Label~fifth_count_remarks~eOT.AddtFifthCount.Label~add_after_5c_remarks");


			main_sql = "SELECT ADDED_BY_ID, TO_CHAR(ADDED_DATE,'DD/MM/YYYY HH24:MI') ADDED_TIME, ITEM_VALUE, REMARKS FROM OT_OPER_SWAB_INSTR_CNT_DTL WHERE OPERATING_FACILITY_ID =? AND OPER_NUM = ? AND SWAB_SERIAL_NUMBER=? AND TEMPLATE_ID=? AND ITEM_CODE=?";
			for(int i = 1; i <= 6; i++)
			{
				remarks = "";
				remarks_buf.setLength(0);

				if(i == 1)
				{ // initial
					where_clause = " AND NVL(INITIAL_COUNT_YN,'N')='N' AND NVL(ADDITIONS_DURING,'ZZ') = 'ZZ' AND  NVL(FIRST_COUNT_YN,'N')='Y' AND NVL(SECOND_COUNT_YN,'N') ='N' AND NVL(FINAL_COUNT_YN,'N')='N'";
				}
				else if(i == 2)
				{ // additions during OP //Added order by Anitha
					where_clause = " AND NVL(INITIAL_COUNT_YN,'N')='N' AND NVL(ADDITIONS_DURING,'ZZ') = 'OP' AND  NVL(FIRST_COUNT_YN,'N')='N' AND NVL(SECOND_COUNT_YN,'N') ='N' AND NVL(FINAL_COUNT_YN,'N')='N' ORDER BY ADDED_DATE";
				}
				else if(i == 4)
				{ //second count
					where_clause = " AND NVL(INITIAL_COUNT_YN,'N')='N' AND NVL(ADDITIONS_DURING,'ZZ') = 'ZZ' AND  NVL(FIRST_COUNT_YN,'N')='N' AND NVL(SECOND_COUNT_YN,'N') ='Y' AND NVL(FINAL_COUNT_YN,'N')='N'";
				}
				else if(i == 5)
				{ //additions after closing the cavity //Added order by Anitha
					where_clause = " AND NVL(INITIAL_COUNT_YN,'N')='N' AND NVL(ADDITIONS_DURING,'ZZ') = 'CL' AND  NVL(FIRST_COUNT_YN,'N')='N' AND NVL(SECOND_COUNT_YN,'N') ='N' AND NVL(FINAL_COUNT_YN,'N')='N' ORDER BY ADDED_DATE";
				}
				else if(i == 6)
				{ // final count
					where_clause = " AND NVL(INITIAL_COUNT_YN,'N')='N' AND NVL(ADDITIONS_DURING,'ZZ') = 'ZZ' AND  NVL(FIRST_COUNT_YN,'N')='N' AND NVL(SECOND_COUNT_YN,'N') ='N' AND NVL(FINAL_COUNT_YN,'N')='Y'";
				}
				sql = "";
				sql = main_sql + where_clause;
				if(resultset != null) 
					resultset.close();
				if(pstmt != null) 
					pstmt.close();
				System.out.println("=========sql=====SwabCountViewRemarks========"+sql);
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, facility_id);
				pstmt.setString(2, oper_num);
				pstmt.setString(3, swab_serial_number);		
				pstmt.setString(4, template_id);
				pstmt.setString(5, item_code);
				resultset = pstmt.executeQuery();

				while(resultset.next())
				{
					added_by	= resultset.getString("ADDED_BY_ID");
					added_time = (com.ehis.util.DateUtils.convertDate(resultset.getString("ADDED_TIME"),"DMYHM","en",locale));
					item_value	= checkForNull(resultset.getString("ITEM_VALUE"));

					remarks = checkForNull(resultset.getString("REMARKS"));
					remarks = remarks.equals("\n") ? "" : remarks;

					if(item_value == null || item_value.trim().length() == 0)
						item_value = "0";

					if(Integer.parseInt(item_value) > 0)
						remarks_buf.append(added_by + " added "+ item_value + " number(s) on "+ added_time+"\n");
					else if(Integer.parseInt(item_value) < 0)
						remarks_buf.append(added_by + " deducted " + item_value + " number(s) on " + added_time+"\n");
					if(!remarks.equals(""))
						remarks_buf.append("Remarks: " + remarks + "\n\n");
				}

				if(i == 1) 
					initial_remarks = checkForNull(remarks_buf.toString());
				if(initial_remarks == null || initial_remarks.trim().length() == 0)
					initial_remarks = "";
				if(i == 2) 
					add_dur_op_remarks = checkForNull(remarks_buf.toString());
				if(add_dur_op_remarks == null || add_dur_op_remarks.trim().length() == 0)
					add_dur_op_remarks = "";
				if(i == 4) 
					second_count_remarks = checkForNull(remarks_buf.toString());
				if(second_count_remarks == null || second_count_remarks.trim().length() == 0)
					second_count_remarks = "";
				if(i == 5) 
					add_after_cc_remarks = checkForNull(remarks_buf.toString());
				if(add_after_cc_remarks == null || add_after_cc_remarks.trim().length() == 0)
					add_after_cc_remarks = "";
				if(i == 6) 
					final_count_remarks = checkForNull(remarks_buf.toString());
				if(final_count_remarks == null || final_count_remarks.trim().length() == 0)
					final_count_remarks = "";
			}
			dataMap.put(2, second_count_remarks + " ~ " + add_after_cc_remarks);

			if(allwdSwabCntsVal > 3)
			{
				sqlBuffer.delete(0, sqlBuffer.length());
				if(resultset!=null)
					resultset.close();
				if(pstmt!=null)
					pstmt.close();
				sqlBuffer.append("	SELECT added_by_id, TO_CHAR (added_date, 'DD/MM/YYYY HH24:MI') added_time, item_value, remarks		");
				sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl																	");
				sqlBuffer.append("	WHERE operating_facility_id = ? AND oper_num = ?											");
				sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?				");
				sqlBuffer.append("	AND NVL (additions_during, 'ZZ') = 'ZZ' AND NVL (first_count_yn, 'N') = 'N' 		");
				sqlBuffer.append("	AND NVL (second_count_yn, 'N') = 'N' AND NVL (third_count_yn, 'N') = 'Y' 		");
				sqlBuffer.append("	AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N' AND NVL (final_count_yn, 'N') = 'N'			");
				pstmt = connection.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1, facility_id);
				pstmt.setString(2, oper_num);
				pstmt.setString(3, swab_serial_number);		
				pstmt.setString(4, template_id);
				pstmt.setString(5, item_code);
				resultset = pstmt.executeQuery();
				while(resultset.next())
				{
					added_by	= resultset.getString("ADDED_BY_ID");
					added_time = (com.ehis.util.DateUtils.convertDate(resultset.getString("ADDED_TIME"),"DMYHM","en",locale));
					item_value	= checkForNull(resultset.getString("ITEM_VALUE"));
					if(item_value == null || item_value.trim().length() == 0)
						item_value = "0";
					remarks = checkForNull(resultset.getString("REMARKS"));
					remarks = remarks.equals("\n") ? "" : remarks;
					if(Integer.parseInt(item_value) > 0)
						remarks_buf.append(added_by + " added "+ item_value + " number(s) on "+ added_time+"\n");
					else if(Integer.parseInt(item_value) < 0)
						remarks_buf.append(added_by + " deducted " + item_value + " number(s) on " + added_time+"\n");
					if(!remarks.equals(""))
						remarks_buf.append("Remarks: " + remarks + "\n\n");
				}
				third_count_remarks = remarks_buf.toString();
				remarks_buf.setLength(0);
				sqlBuffer.delete(0, sqlBuffer.length());
				if(resultset!=null)
					resultset.close();
				if(pstmt!=null)
					pstmt.close();
				sqlBuffer.append("	SELECT added_by_id, TO_CHAR (added_date, 'DD/MM/YYYY HH24:MI') added_time, item_value, remarks		");
				sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl		");
				sqlBuffer.append("	WHERE operating_facility_id = ? AND oper_num = ?		");
				sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?		");
				sqlBuffer.append("	AND NVL (first_count_yn, 'N') = 'N' AND NVL (second_count_yn, 'N') = 'N'		");
				sqlBuffer.append("	AND NVL (third_count_yn, 'N') = 'N' AND NVL (additions_during, 'ZZ') = '3C'		");
				sqlBuffer.append("	AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N' AND NVL (final_count_yn, 'N') = 'N'		");
				sqlBuffer.append("	ORDER BY added_date		");
				pstmt = connection.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1, facility_id);
				pstmt.setString(2, oper_num);
				pstmt.setString(3, swab_serial_number);		
				pstmt.setString(4, template_id);
				pstmt.setString(5, item_code);
				resultset = pstmt.executeQuery();
				while(resultset.next())
				{
					added_by	= resultset.getString("ADDED_BY_ID");
					added_time = (com.ehis.util.DateUtils.convertDate(resultset.getString("ADDED_TIME"),"DMYHM","en",locale));
					item_value	= checkForNull(resultset.getString("ITEM_VALUE"));
					if(item_value == null || item_value.trim().length() == 0)
						item_value = "0";
					remarks = checkForNull(resultset.getString("REMARKS"));
					remarks = remarks.equals("\n") ? "" : remarks;
					if(Integer.parseInt(item_value) > 0)
						remarks_buf.append(added_by + " added "+ item_value + " number(s) on "+ added_time+"\n");
					else if(Integer.parseInt(item_value) < 0)
						remarks_buf.append(added_by + " deducted " + item_value + " number(s) on " + added_time+"\n");
					if(!remarks.equals(""))
						remarks_buf.append("Remarks: " + remarks + "\n\n");
				}
				add_after_3c_remarks = remarks_buf.toString();
				remarks_buf.setLength(0);
				dataMap.put(3, third_count_remarks + " ~ " + add_after_3c_remarks);
			}
			if(allwdSwabCntsVal > 4)
			{
				sqlBuffer.delete(0, sqlBuffer.length());
				if(resultset!=null)
					resultset.close();
				if(pstmt!=null)
					pstmt.close();
				sqlBuffer.append("	SELECT added_by_id, TO_CHAR (added_date, 'DD/MM/YYYY HH24:MI') added_time, item_value, remarks		");
				sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl		");
				sqlBuffer.append("	WHERE operating_facility_id = ? AND oper_num = ?		");
				sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?		");
				sqlBuffer.append("	AND NVL (additions_during, 'ZZ') = 'ZZ' AND NVL (first_count_yn, 'N') = 'N' 		");
				sqlBuffer.append("	AND NVL (second_count_yn, 'N') = 'N' AND NVL (third_count_yn, 'N') = 'N' 		");
				sqlBuffer.append("	AND NVL (fourth_count_yn, 'N') = 'Y' AND NVL (fifth_count_yn, 'N') = 'N' AND NVL (final_count_yn, 'N') = 'N'		");
				pstmt = connection.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1, facility_id);
				pstmt.setString(2, oper_num);
				pstmt.setString(3, swab_serial_number);		
				pstmt.setString(4, template_id);
				pstmt.setString(5, item_code);
				resultset = pstmt.executeQuery();
				while(resultset.next())
				{
					added_by	= resultset.getString("ADDED_BY_ID");
					added_time = (com.ehis.util.DateUtils.convertDate(resultset.getString("ADDED_TIME"),"DMYHM","en",locale));
					item_value	= checkForNull(resultset.getString("ITEM_VALUE"));
					if(item_value == null || item_value.trim().length() == 0)
						item_value = "0";
					remarks = checkForNull(resultset.getString("REMARKS"));
					remarks = remarks.equals("\n") ? "" : remarks;
					if(Integer.parseInt(item_value) > 0)
						remarks_buf.append(added_by + " added "+ item_value + " number(s) on "+ added_time+"\n");
					else if(Integer.parseInt(item_value) < 0)
						remarks_buf.append(added_by + " deducted " + item_value + " number(s) on " + added_time+"\n");
					if(!remarks.equals(""))
						remarks_buf.append("Remarks: " + remarks + "\n\n");
				}
				fourth_count_remarks = remarks_buf.toString();
				remarks_buf.setLength(0);
				sqlBuffer.delete(0, sqlBuffer.length());
				if(resultset!=null)
					resultset.close();
				if(pstmt!=null)
					pstmt.close();
				sqlBuffer.append("	SELECT added_by_id, TO_CHAR (added_date, 'DD/MM/YYYY HH24:MI') added_time, item_value, remarks		");
				sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl		");
				sqlBuffer.append("	WHERE operating_facility_id = ? AND oper_num = ?		");
				sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?		");
				sqlBuffer.append("	AND NVL (first_count_yn, 'N') = 'N' AND NVL (second_count_yn, 'N') = 'N'		");
				sqlBuffer.append("	AND NVL (third_count_yn, 'N') = 'N' AND NVL (additions_during, 'ZZ') = '4C'		");
				sqlBuffer.append("	AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N' AND NVL (final_count_yn, 'N') = 'N'		");
				sqlBuffer.append("	ORDER BY added_date		");
				pstmt = connection.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1, facility_id);
				pstmt.setString(2, oper_num);
				pstmt.setString(3, swab_serial_number);		
				pstmt.setString(4, template_id);
				pstmt.setString(5, item_code);
				resultset = pstmt.executeQuery();
				while(resultset.next())
				{
					added_by	= resultset.getString("ADDED_BY_ID");
					added_time = (com.ehis.util.DateUtils.convertDate(resultset.getString("ADDED_TIME"),"DMYHM","en",locale));
					item_value	= checkForNull(resultset.getString("ITEM_VALUE"));
					if(item_value == null || item_value.trim().length() == 0)
						item_value = "0";
					remarks = checkForNull(resultset.getString("REMARKS"));
					remarks = remarks.equals("\n") ? "" : remarks;
					if(Integer.parseInt(item_value) > 0)
						remarks_buf.append(added_by + " added "+ item_value + " number(s) on "+ added_time+"\n");
					else if(Integer.parseInt(item_value) < 0)
						remarks_buf.append(added_by + " deducted " + item_value + " number(s) on " + added_time+"\n");
					if(!remarks.equals(""))
						remarks_buf.append("Remarks: " + remarks + "\n\n");
				}
				add_after_4c_remarks = remarks_buf.toString();
				remarks_buf.setLength(0);
				dataMap.put(4, fourth_count_remarks + " ~ " + add_after_4c_remarks);
			}
			if(allwdSwabCntsVal > 5)
			{
				sqlBuffer.delete(0, sqlBuffer.length());
				if(resultset!=null)
					resultset.close();
				if(pstmt!=null)
					pstmt.close();
				sqlBuffer.append("	SELECT added_by_id, TO_CHAR (added_date, 'DD/MM/YYYY HH24:MI') added_time, item_value, remarks		");
				sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl		");
				sqlBuffer.append("	WHERE operating_facility_id = ? AND oper_num = ?		");
				sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?		");
				sqlBuffer.append("	AND NVL (additions_during, 'ZZ') = 'ZZ' AND NVL (first_count_yn, 'N') = 'N' 		");
				sqlBuffer.append("	AND NVL (second_count_yn, 'N') = 'N' AND NVL (third_count_yn, 'N') = 'N' 		");
				sqlBuffer.append("	AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'Y' AND NVL (final_count_yn, 'N') = 'N'		");
				pstmt = connection.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1, facility_id);
				pstmt.setString(2, oper_num);
				pstmt.setString(3, swab_serial_number);		
				pstmt.setString(4, template_id);
				pstmt.setString(5, item_code);
				resultset = pstmt.executeQuery();
				while(resultset.next())
				{
					added_by	= resultset.getString("ADDED_BY_ID");
					added_time = (com.ehis.util.DateUtils.convertDate(resultset.getString("ADDED_TIME"),"DMYHM","en",locale));
					item_value	= checkForNull(resultset.getString("ITEM_VALUE"));
					if(item_value == null || item_value.trim().length() == 0)
						item_value = "0";
					remarks = checkForNull(resultset.getString("REMARKS"));
					remarks = remarks.equals("\n") ? "" : remarks;
					if(Integer.parseInt(item_value) > 0)
						remarks_buf.append(added_by + " added "+ item_value + " number(s) on "+ added_time+"\n");
					else if(Integer.parseInt(item_value) < 0)
						remarks_buf.append(added_by + " deducted " + item_value + " number(s) on " + added_time+"\n");
					if(!remarks.equals(""))
						remarks_buf.append("Remarks: " + remarks + "\n\n");
				}
				fifth_count_remarks = remarks_buf.toString();
				remarks_buf.setLength(0);
				sqlBuffer.delete(0, sqlBuffer.length());
				if(resultset!=null)
					resultset.close();
				if(pstmt!=null)
					pstmt.close();
				sqlBuffer.append("	SELECT added_by_id, TO_CHAR (added_date, 'DD/MM/YYYY HH24:MI') added_time, item_value, remarks		");
				sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl		");
				sqlBuffer.append("	WHERE operating_facility_id = ? AND oper_num = ?		");
				sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?		");
				sqlBuffer.append("	AND NVL (first_count_yn, 'N') = 'N' AND NVL (second_count_yn, 'N') = 'N'		");
				sqlBuffer.append("	AND NVL (third_count_yn, 'N') = 'N' AND NVL (additions_during, 'ZZ') = '5C'		");
				sqlBuffer.append("	AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N' AND NVL (final_count_yn, 'N') = 'N'		");
				sqlBuffer.append("	ORDER BY added_date		");
				pstmt = connection.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1, facility_id);
				pstmt.setString(2, oper_num);
				pstmt.setString(3, swab_serial_number);		
				pstmt.setString(4, template_id);
				pstmt.setString(5, item_code);
				resultset = pstmt.executeQuery();
				while(resultset.next())
				{
					added_by	= resultset.getString("ADDED_BY_ID");
					added_time = (com.ehis.util.DateUtils.convertDate(resultset.getString("ADDED_TIME"),"DMYHM","en",locale));
					item_value	= checkForNull(resultset.getString("ITEM_VALUE"));
					if(item_value == null || item_value.trim().length() == 0)
						item_value = "0";
					remarks = checkForNull(resultset.getString("REMARKS"));
					remarks = remarks.equals("\n") ? "" : remarks;
					if(Integer.parseInt(item_value) > 0)
						remarks_buf.append(added_by + " added "+ item_value + " number(s) on "+ added_time+"\n");
					else if(Integer.parseInt(item_value) < 0)
						remarks_buf.append(added_by + " deducted " + item_value + " number(s) on " + added_time+"\n");
					if(!remarks.equals(""))
						remarks_buf.append("Remarks: " + remarks + "\n\n");
				}
				add_after_5c_remarks = remarks_buf.toString();
				remarks_buf.setLength(0);
				dataMap.put(5, fifth_count_remarks + " ~ " + add_after_5c_remarks);
			}
			if(resultset!=null)
				resultset.close();
			if(pstmt!=null)
				pstmt.close();
		}
		catch(Exception e)
		{
			System.err.println("196: Caught Exception in Swab Count Remarks"+e);
			e.printStackTrace();
		}
		finally
		{
			remarks_buf.setLength(0);
			if(resultset!=null)
				resultset.close();
			if(pstmt!=null)
				pstmt.close();
			ConnectionManager.returnConnection(connection,request);
		}
%>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name="SwabCountViewRemarksForm" id="SwabCountViewRemarksForm" >
			<table cellpadding=3  cellspacing="0" width="100%" align='center'>
				<tr>
					<td class="label" width="25%" valign="top" colspan="4"> <b><fmt:message key="eOT.InCount.Label" bundle="${ot_labels}"/></b> </td>
					<td width="25%" class='fields' colspan="4">
						<textarea rows="5" cols="70" name="op_remarks" readOnly ><%=initial_remarks%></textarea>
					</td>
				</tr>
				<tr>
					<td class="label" colspan="4" valign="top" width="25%" > <b><fmt:message key="eOT.AdditionsduringOperation.Label" bundle="${ot_labels}"/> </td>
					<td width="25%" class='fields' colspan="4" >
						<textarea rows="5" cols="70" name="add_dur_op_remarks" readOnly ><%=add_dur_op_remarks%></textarea>
					</td>
				</tr>
<%
				if(allwdSwabCntsVal == 3)
				{
%>
					<tr>
						<td class="label" width="25%" colspan="4" valign="top"> <b><fmt:message key="eOT.SecondCount.Label" bundle="${ot_labels}"/> </td>
						<td width="25%" class='fields' colspan="4">
							<textarea rows="5" cols="70" name="second_count_remarks" readOnly ><%=second_count_remarks%></textarea>
						</td>
					</tr>
					<tr>
						<td class="label" colspan="4" width="25%" valign="top"> <b><fmt:message key="eOT.AdditionsafterClcavityCompl.Label" bundle="${ot_labels}"/></td> 
						<td width="25%" class='fields' colspan="4">
							<textarea rows="5" cols="70" name="add_after_cc_remarks" readOnly ><%=add_after_cc_remarks%></textarea>
						</td>
					</tr>
<%
				}
				else if(allwdSwabCntsVal > 3)
				{
					for(int i=2; i<allwdSwabCntsVal; i++)
					{
						getKeyVal = ((String) labelNameMap.get(i)).split("~");
						getDataMapKeyVal = ((String) dataMap.get(i)).split("~");
%>
							<tr>
								<td class="label" width="25%" colspan="4" valign="top"> <b><fmt:message key='<%=getKeyVal[0]%>' bundle="${ot_labels}"/> </td>
								<td width="25%" class='fields' colspan="4">
									<textarea rows="5" cols="70" name="<%=getKeyVal[1]%>" readOnly ><%=getDataMapKeyVal[0]%></textarea>
								</td>
							</tr>
							<tr>
								<td class="label" colspan="4" width="25%" valign="top"> <b><fmt:message key='<%=getKeyVal[2]%>' bundle="${ot_labels}"/></td> 
								<td width="25%" class='fields' colspan="4">
									<textarea rows="5" cols="70" name="<%=getKeyVal[3]%>" readOnly ><%=getDataMapKeyVal[1]%></textarea>
								</td>
							</tr>
<%
					}
				}
%>
				<tr>
					<td class="label" colspan="4" width="25%" valign="top"><b><fmt:message key="eOT.FinalCount.Label" bundle="${ot_labels}"/></td>
					<td width="25%" class='fields' colspan="4">
						<textarea rows="5" cols="70" name="final_count_remarks" readOnly ><%=final_count_remarks%></textarea>
					</td>
				</tr>
				<tr>
					<td width="25%" class='button' colspan="8" align='right'>
						<input  type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class="button"  onClick="let dialogBody =parent.document.getElementById('dialog-body'); dialogBody.contentWindow.returnValue ='';const dialogTag = parent.document.getElementById('dialog_tag'); dialogTag.close();">
					</td>
				</tr>
			</table>
			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
		</form>
	</body>
</html>

