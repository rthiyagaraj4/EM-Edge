<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.Common.CommonBean"  contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultset =null;
	String params = request.getQueryString();
	String tab_name = request.getParameter("swab_tab_name") ;
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num")) ;
	String qry_mode = CommonBean.checkForNull(request.getParameter("qry_mode")) ;
	String facility_id = CommonBean.checkForNull((String) session.getValue("facility_id"));
	String params1 = "";
	String first_cnt_cmpl_yn = "N", add_during_op_cmpl_yn = "N", second_cnt_cmpl_yn = "N", add_aft_clcav_cmpl_yn = "N", final_cnt_cmpl_yn = "N";
	String third_cnt_cmpl_yn = "N", additions_after_3c_cmpl_yn = "N", fourth_cnt_cmpl_yn = "N", additions_after_4c_cmpl_yn = "N", fifth_cnt_cmpl_yn = "N", additions_after_5c_cmpl_yn = "N";
	String reviewedBy = "", practitionerName = "";
	String sql = "";
	String swab_serial_number	= request.getParameter("swab_serial_number");
	swab_serial_number = swab_serial_number == null ? "1" : swab_serial_number;
	swab_serial_number = swab_serial_number.equalsIgnoreCase("null") ? "1" : swab_serial_number;
	System.out.println("========swab_serial_number=============="+swab_serial_number);
	StringBuffer sqlBuffer = new StringBuffer();
	int allwdSwabCntsVal = 0;
	int setIndex = 0;
	if(tab_name==null)
		tab_name="SLATE";
	if(tab_name!=null && tab_name.equals("null"))
		tab_name="SLATE";
	if(tab_name.equals("SWABCOUNT"))
	{
		//sql="SELECT  NVL(FIRST_CNT_CMPL_YN,'N'),NVL(ADDITIONS_DURING_OP_CMPL_YN,'N'), NVL(SECOND_CNT_CMPL_YN,'N'), NVL(ADDITIONS_AFT_CLCAV_CMPL_YN,'N'), NVL(FINAL_CNT_CMPL_YN,'N') FROM OT_OPER_SWAB_INSTR_CNT_HDR WHERE OPERATING_FACILITY_ID = ? AND OPER_NUM=? AND SWAB_SERIAL_NUMBER=?";

		sqlBuffer.append("		SELECT NVL (first_cnt_cmpl_yn, 'N') first_cnt_cmpl_yn,	");
		sqlBuffer.append("		NVL (additions_during_op_cmpl_yn, 'N') additions_during_op_cmpl_yn,	");
		sqlBuffer.append("		NVL (second_cnt_cmpl_yn, 'N') second_cnt_cmpl_yn,	");
		sqlBuffer.append("		NVL (additions_aft_clcav_cmpl_yn, 'N') additions_aft_clcav_cmpl_yn,	");
		sqlBuffer.append("		NVL (third_cnt_cmpl_yn, 'N') third_cnt_cmpl_yn,	");
		sqlBuffer.append("		NVL (additions_after_3c_cmpl_yn, 'N') additions_after_3c_cmpl_yn,	");
		sqlBuffer.append("		NVL (fourth_cnt_cmpl_yn, 'N') fourth_cnt_cmpl_yn,	");
		sqlBuffer.append("		NVL (additions_after_4c_cmpl_yn, 'N') additions_after_4c_cmpl_yn,	");
		sqlBuffer.append("		NVL (fifth_cnt_cmpl_yn, 'N') fifth_cnt_cmpl_yn,	");
		sqlBuffer.append("		NVL (additions_after_5c_cmpl_yn, 'N') additions_after_5c_cmpl_yn,	");
		sqlBuffer.append("		NVL (final_cnt_cmpl_yn, 'N') final_cnt_cmpl_yn,	");

		sqlBuffer.append("		reviewed_by, (SELECT practitioner_name	");
		sqlBuffer.append("		FROM am_practitioner b	");
		sqlBuffer.append("		WHERE b.practitioner_id = reviewed_by) practitioner_name,	");

		sqlBuffer.append("		nvl(no_of_swabs_to_disp, 0) allwd_swab_cnts	");
		sqlBuffer.append("		FROM ot_oper_swab_instr_cnt_hdr	");
		sqlBuffer.append("		WHERE operating_facility_id = ? AND oper_num = ? AND swab_serial_number = ?	");

		try
		{
		connection = ConnectionManager.getConnection(request);
		pstmt=connection.prepareStatement(sqlBuffer.toString());
		pstmt.setString(++setIndex, facility_id);
		pstmt.setString(++setIndex, oper_num);
		pstmt.setString(++setIndex, swab_serial_number);

		resultset = pstmt.executeQuery();
		if(resultset.isBeforeFirst())
		{
			while(resultset!=null && resultset.next())
			{
				first_cnt_cmpl_yn = resultset.getString("first_cnt_cmpl_yn");
				add_during_op_cmpl_yn	= resultset.getString("additions_during_op_cmpl_yn");

				second_cnt_cmpl_yn = resultset.getString("second_cnt_cmpl_yn");
				add_aft_clcav_cmpl_yn = resultset.getString("additions_aft_clcav_cmpl_yn");

				third_cnt_cmpl_yn = resultset.getString("third_cnt_cmpl_yn");
				additions_after_3c_cmpl_yn = resultset.getString("additions_after_3c_cmpl_yn");

				fourth_cnt_cmpl_yn = resultset.getString("fourth_cnt_cmpl_yn");
				additions_after_4c_cmpl_yn = resultset.getString("additions_after_4c_cmpl_yn");

				fifth_cnt_cmpl_yn = resultset.getString("fifth_cnt_cmpl_yn");
				additions_after_5c_cmpl_yn = resultset.getString("additions_after_5c_cmpl_yn");

				final_cnt_cmpl_yn = resultset.getString("final_cnt_cmpl_yn");
				
				reviewedBy = resultset.getString("reviewed_by");
				practitionerName = resultset.getString("practitioner_name");
				if(practitionerName != null && practitionerName.trim().length() > 0)
					practitionerName = java.net.URLEncoder.encode(resultset.getString("practitioner_name"), "UTF-8");

				allwdSwabCntsVal = Integer.parseInt(resultset.getString("allwd_swab_cnts"));
				System.out.println("========allwdSwabCntsVal==iff=====frames======="+allwdSwabCntsVal);
			}
		}
		System.out.println("========allwdSwabCntsVal==brfore iffff=====frames======="+allwdSwabCntsVal);
		if(allwdSwabCntsVal == 0)
		{
			if(resultset!=null)
				resultset.close();
			if(pstmt!=null)
				pstmt.close();
			setIndex = 0;
			sqlBuffer.delete(0, sqlBuffer.length());
			sqlBuffer.append("		SELECT NVL ((SELECT no_of_swabs_to_disp		");
			sqlBuffer.append("		FROM ot_oper_swab_instr_cnt_hdr	");
			sqlBuffer.append("		WHERE oper_num = ? AND swab_serial_number = '1'), NVL (allwd_swab_cnts, '3')) allwd_swab_cnts	");
			sqlBuffer.append("		FROM ot_param_for_facility	");
			sqlBuffer.append("		WHERE operating_facility_id = ?	");

			pstmt = connection.prepareStatement(sqlBuffer.toString());
			pstmt.setString(++setIndex, oper_num);
			pstmt.setString(++setIndex, facility_id);
			resultset = pstmt.executeQuery();
			while(resultset.next())
			{
				allwdSwabCntsVal = Integer.parseInt(resultset.getString("allwd_swab_cnts"));
				System.out.println("========allwdSwabCntsVal==elseeee=frames======="+allwdSwabCntsVal);
			}
		}
	}catch(Exception e){
		e.printStackTrace();
		System.err.println("46: Caught Exception in Swab Count Tab Frames"+e);
	}finally{
		if(resultset!=null) resultset.close();
		if(pstmt!=null) pstmt.close();	
		ConnectionManager.returnConnection(connection,request);
	}

	params = params+
					"&first_cnt_cmpl_yn="+first_cnt_cmpl_yn+
					"&add_during_op_cmpl_yn="+add_during_op_cmpl_yn+
					"&second_cnt_cmpl_yn="+second_cnt_cmpl_yn+
					"&add_aft_clcav_cmpl_yn="+add_aft_clcav_cmpl_yn+

					"&third_cnt_cmpl_yn="+third_cnt_cmpl_yn+
					"&additions_after_3c_cmpl_yn="+additions_after_3c_cmpl_yn+
					"&fourth_cnt_cmpl_yn="+fourth_cnt_cmpl_yn+
					"&additions_after_4c_cmpl_yn="+additions_after_4c_cmpl_yn+
					"&fifth_cnt_cmpl_yn="+fifth_cnt_cmpl_yn+
					"&additions_after_5c_cmpl_yn="+additions_after_5c_cmpl_yn+

					"&final_cnt_cmpl_yn="+final_cnt_cmpl_yn+
					"&reviewedBy="+reviewedBy+
					"&practitionerName="+practitionerName+
					"&swab_serial_number="+swab_serial_number+
					"&record_tab_name=SWABCOUNT"+
					"&qry_mode="+qry_mode+
					"&allwdSwabCntsVal="+allwdSwabCntsVal+
					"#scrollHere";

	params1 = "&oper_num="+oper_num+
	"&swab_serial_number="+swab_serial_number+
	"&facility_id="+facility_id+
	"&record_tab_name=SWABCOUNT"+
	"&qry_mode="+qry_mode+
	"&allwdSwabCntsVal="+allwdSwabCntsVal;

	System.out.println("========params=========="+params);
	System.out.println("========params1=========="+params1);
	if(CommonBean.checkForNull(request.getParameter("qry_mode")).equals("YES") )
	{
%>
	<frameset rows="80,0,*"> 
<%
}
else
{
%>
		<frameset rows="20%,0%,*,8%">
<%
}
%>
	<frame name="f_swab_count_confirm_item" frameborder="0" scrolling="yes" noresize src="../../eOT/jsp/SwabCountItemConfirm.jsp?<%=params%>">  
	<frame name="f_swab_count_hdr" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/SwabCountHeader.jsp?<%=params%>">  
	<frame name="f_swab_count_dtls" frameborder="0"  noresize src="../../eOT/jsp/SwabCount.jsp?<%=params%>"> 
<% 
	if(!CommonBean.checkForNull(request.getParameter("qry_mode")).equals("YES") ) 
	{
%>
	<frame name="f_swab_count_record" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/SwabCountRecordFrame.jsp?<%=params%>">
<%
	}
%>
</frameset>
<%
	}
	else if(tab_name.equals("VERIFY"))
	{
	params=params+"&record_tab_name=VERIFY";
%>


<% if(CommonBean.checkForNull(request.getParameter("qry_mode")).equals("YES") ) { %>
	<frameset rows="*"> 
	<frame name="f_verify_details" frameborder="0" scrolling="YES" noresize src="../../eOT/jsp/SwabCountVerify.jsp?<%=params%>">  
<%}else{%>
	<frameset rows="*,25"> 
	<frame name="f_verify_details" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/SwabCountVerify.jsp?<%=params%>">  
		<frame name="f_swab_count_record" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/SwabCountRecordFrame.jsp?<%=params%>">
	<%}%>
		
</frameset>
<%
	}
	else if(tab_name.equals("PERSONNELDTLS"))
	{
	params=params+"&record_tab_name=PERSONNELDTLS";
%>
	<FRAMESET rows='*,25' border='0'>
		<!--<FRAMESET rows='0,0' border='0'>
			<FRAME NAME='ObjectCollect' SRC='../../eOT/jsp/NursingObjectCollect.jsp?<%=params%>'  scrolling='no' noresize='no'>
			

			<FRAME name="tab_frame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html?<%=params%>">    	    
		</FRAMESET> -->
		<FRAME NAME='RecordFrame' SRC='../../eOT/jsp/SwabCountPersonnelFrames.jsp?<%=params%>'  scrolling='no' noresize='no'></FRAME> 
	<frame name="f_swab_count_record" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/SwabCountRecordFrame.jsp?<%=params%>">
	</FRAMESET>

	<%
	}
%>

<input type='hidden' name='locale' value="<%=locale%>">
<input tpe="hidden" name="allwdSwabCntsVal" id="allwdSwabCntsVal" value="<%=allwdSwabCntsVal%>">

<script>
		setTimeout("assignRepId()", 1000);
		function assignRepId()
		{
			var locale = '<%=locale%>';
			var allwdSwabCntsVal = '<%=allwdSwabCntsVal%>';
			var qry_mode = '<%=qry_mode%>';
			var pReportId = '';
			if(allwdSwabCntsVal == 3)
				pReportId = 'OTRSWCNT';
			else if(allwdSwabCntsVal > 3)
				pReportId = 'OTRSBSWC';
			if(qry_mode != '') //Surgery History
			{
				if(parent.frames[0].document.forms[0] == null)
				{
					assignRepId();
				}
				else
				{
					parent.frames[0].document.forms[0].p_report_id.value = pReportId;
					parent.frames[0].document.forms[0].P_NO_OF_SWAB_COUNT.value = allwdSwabCntsVal;
				}
			}
			else if(qry_mode == '') // Swabcount Form from menu
			{
				if(parent.frames[1].document.forms[0] == null)
				{
					assignRepId();
				}
				else
				{
					parent.frames[1].document.forms[0].p_report_id.value = pReportId;
					parent.frames[1].document.forms[0].P_NO_OF_SWAB_COUNT.value = allwdSwabCntsVal;
				}
			}
		}

</script>

