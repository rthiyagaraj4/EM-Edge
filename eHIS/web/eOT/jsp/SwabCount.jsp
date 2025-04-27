<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	/*
		NOTE: Currently First Count is Not Used. The Initial Count is renamed as First Count and the First_Count is being removed completely. But at Database level, it is not changed. 
		First_Count(earlier known as Initial_Count) at frontend --> is Initial_Count at database level
	*/
%>
<%@ page import ="java.sql.Connection,java.sql.CallableStatement,java.sql.PreparedStatement,java.sql.Types,java.lang.String,java.util.StringTokenizer,java.sql.ResultSet, webbeans.eCommon.*,java.util.*,eCommon.Common.*,eOT.*,java.sql.*,eCommon.Common.CommonBean,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>           
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>		
	<style>
	    th, td { white-space: nowrap; }
		div.dataTables_wrapper {
        width:95%;
        margin: 0 auto;
		}
	.thwrap{
			position: relative;
            top: expression(this.offsetParent.scrollTop);
			/*white-space:nowrap;*/
			/*color:#ff0000;*/
			font-size:12px;
			width:auto;		
			/*background: url("../images/headerSeparator.jpg") repeat-y;*/
			background-position:right;
			COLOR: white ;
			background-color:#83AAB4;
			border:0px;
			padding-left:3px;
			font-family: Verdana;
			font-size: 8pt;
			/*font-weight:bold;*/
			border-collapse:collapse; 
			/*position:absolute;*/
			left:0;
			top:auto;
			}
			.datawrap{
			/*align:center;*/
	}
</style>		
		<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eOT/js/SwabCount.js' language='javascript'></script> 
		<Script src="../../eXH/js/showModalDialog.js" language="JavaScript"></Script>
	</head>
<body onKeyDown = 'lockKey()' onload="scrollTo();">
<form name='SwabCountForm' id='SwabCountForm' method='POST' >
<%
		String classValue="";
		Connection connection  = null;
		CallableStatement cstmt= null;
		PreparedStatement pstmt=null;
		ResultSet rst1 =null;
		PreparedStatement pstmt1=null;
		ResultSet resultset =null;
		ResultSet resultset1 =null;
		String remarks_one = "";
		String remarks_two = "";
		String remarks_initial = "";
		String sql = "",templates	= "",final_count_remarks = "",second_count_remarks = "";
		String second_count_remarks_yn = "";
		String final_count_remarks_yn = "";
		StringBuffer append_str = new StringBuffer();
		StringBuffer append_templates = new StringBuffer();
		String oper_num = request.getParameter("oper_num");
		String swab_serial_number	= request.getParameter("swab_serial_number");
		swab_serial_number=swab_serial_number==null?"1":swab_serial_number;
		swab_serial_number=swab_serial_number.equalsIgnoreCase("null")?"1":swab_serial_number;
		String facility_id	= (String) session.getValue("facility_id");
		String login_user	= request.getParameter("slate_user_id");
		String initial_disabled_surg = "";
		String qry_mode = CommonBean.checkForNull(request.getParameter("qry_mode"));	
		
		if(qry_mode.equals("YES"))
			initial_disabled_surg="disabled";
		if(oper_num==null) 
			oper_num="";
		if(oper_num.equalsIgnoreCase("null")) 
			oper_num="";
		int allwdSwabCntsVal = 0;
		LinkedHashMap headerMap = new LinkedHashMap();
		LinkedHashMap dataMap = new LinkedHashMap();

		String first_cnt_cmpl_yn = "";
		String first_cnt_disabled = "";
		String add_during_op_cmpl_yn = "";
		String during_op_disabled = "";
		String second_cnt_cmpl_yn = "";
		String second_cnt_disabled = "";
		String add_aft_clcav_cmpl_yn = "";
		String after_cavity_disabled = "";
		String third_cnt_cmpl_yn = "";
		String third_cnt_disabled = "";
		String additions_after_3c_cmpl_yn = "";
		String additions_after_3c_cmpl_yn_disabled = "";
		String fourth_cnt_cmpl_yn = "";
		String fourth_cnt_disabled = "";
		String additions_after_4c_cmpl_yn = "";
		String additions_after_4c_cmpl_yn_disabled = "";
		String fifth_cnt_cmpl_yn = "";
		String fifth_cnt_disabled = "";
		String additions_after_5c_cmpl_yn = "";
		String additions_after_5c_cmpl_yn_disabled = "";
		String final_cnt_cmpl_yn = "";
		String final_cnt_disabled = "";
		String current_item = "";

		String error_text = "";
		String status = "";
		String lang_error_text = "";
		String template_id = "";
		String item_desc = "";
		String item_code = "";
		String initial_count = "0";
		String db_initial_count = "0";
		String total_count_during_op = "";
		String total_additions_during_op = "";
		String total_cavity_count = "";
		String total_second_val_count = "";
		String add_after_cavity_count="";
		String total_final_count  = "";
		String total_second_count = "";
		int i=0;
		int z = 0;
		
		String[] getKeyVal;
		String[] getDataMapKeyVal;
		String condStr = "";
		String valToChkColor = "";
		
		StringBuffer sqlBuffer = new StringBuffer();
		String valForFinalChkBox = "";
		String valToChkForFinalCount = "";

		String thirdCount = "";
		String addDuringThirdCount = "";
		String thirdCountRemarks = "";
		String thirdCountRemarksYn = "N";
		String addtDuringThirdCountRemarks = "";
		String totalThirdCount = "";
		boolean thirdCountRemarksFlag = false;
		boolean addtDuringThirdCountRemarksFlag = false;

		String fourthCount = "";
		String addDuringFourthCount = "";
		String fourthCountRemarks = "";
		String fourthCountRemarksYn = "N";
		String addtDuringFourthCountRemarks = "";
		String totalFourthCount = "";
		boolean fourthCountRemarksFlag = false;
		boolean addtDuringFourthCountRemarksFlag = false;

		String fifthCount = "";
		String addDuringFifthCount = "";
		String fifthCountRemarks = "";
		String fifthCountRemarksYn = "N";
		String addtDuringFifthCountRemarks = "";
		String totalFifthCount = "";
		boolean fifthCountRemarksFlag = false;
		boolean addtDuringFifthCountRemarksFlag = false;
		/* Added Start against PMG2017-MO-CRF-0001 [IN:063849] */
		String str_qry="";
		String swabcount="";
		int swab_count=0;
		String finalCountStyle = "";	
		int count= 0;
		/* Added End against PMG2017-MO-CRF-0001 [IN:063849] */
		try
		{
			connection = ConnectionManager.getConnection(request);
			/* Added Start against PMG2017-MO-CRF-0001 [IN:063849] */
				str_qry = "select NO_OF_SWAB_COUNT_REQD from ot_param_for_facility where operating_facility_id = '"+facility_id+"'";
				pstmt=connection.prepareStatement(str_qry);
				resultset = pstmt.executeQuery();
				if(resultset!= null && resultset.next())
				{
					swabcount = resultset.getString(1);
				}
				//System.err.println("SwabCount.jsp===swabcount=========================="+swabcount);				
				if(pstmt != null) pstmt.close();
				if(resultset!=null) resultset.close();				
			/* Added End against PMG2017-MO-CRF-0001 [IN:063849] */
				
			headerMap.put(2, "eOT.SecondCount.Label~eOT.AddtSecondCount.Label~CL");
			headerMap.put(3, "eOT.ThirdCount.Label~eOT.AddtThirdCount.Label~3C");
			headerMap.put(4, "eOT.FourthCount.Label~eOT.AddtFourthCount.Label~4C");
			headerMap.put(5, "eOT.FifthCount.Label~eOT.AddtFifthCount.Label~5C");
			allwdSwabCntsVal = Integer.parseInt(checkForNull((request.getParameter("allwdSwabCntsVal") == null || request.getParameter("allwdSwabCntsVal").equals("0")) ? "3" : checkForNull(request.getParameter("allwdSwabCntsVal"))));
			//System.err.println("203,=======allwdSwabCntsVal====SwabCount======"+allwdSwabCntsVal);
			swab_count = Integer.parseInt(checkForNull(swabcount));
			if(allwdSwabCntsVal == 0)
				allwdSwabCntsVal = 3;
			// Added against PMG2017-MO-CRF-0001 [IN:063849]	
			/* if(swab_count == 0)	
				swab_count = 2; */
				
			cstmt=connection.prepareCall("{call OT_SWAB_INSTR_TEMPLATES(?,?,?,?,?,null,null,?)}");
			cstmt.setString(1, facility_id);
			cstmt.setString(2, oper_num);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.VARCHAR);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.registerOutParameter(6, Types.VARCHAR);
			cstmt.execute();
			status = cstmt.getString(4);
			error_text = cstmt.getString(5);
			lang_error_text = cstmt.getString(6);
			templates = cstmt.getString(3);
			StringTokenizer strToken = new StringTokenizer(templates,"##");
			int starting_element = 0;
			while(strToken.hasMoreTokens())
			{
				template_id = strToken.nextToken().trim();
				if(starting_element > 0)
					append_templates = append_templates.append(",");
				append_templates = append_templates.append("'"+template_id.toUpperCase()+"' ");
				starting_element = 1;
			}
			if(starting_element == 0)
				append_str = append_str.append(" WHERE B.LANGUAGE_ID='"+locale+"' AND A.ITEM_CODE=B.ITEM_CODE ");
			else
			{
				append_str = append_str.append("WHERE B.LANGUAGE_ID='"+locale+"' AND TEMPLATE_ID IN (");
				append_str = append_str.append(append_templates);		
				append_str = append_str.append(") AND A.ITEM_CODE=B.ITEM_CODE ");
			}
			append_str = append_str.append("ORDER BY A.ITEM_SRL_NO");

			sql = "SELECT A.ITEM_CODE, B.DESCRIPTION,A.INITIAL_COUNT,TEMPLATE_ID FROM OT_SWAB_INSTR_TMPL_DTL A, OT_SWAB_INSTR_ITEMS_LANG_VW B "+append_str;
			//System.err.println("=====sql=====SwabCount===="+sql);
			pstmt = connection.prepareStatement(sql);
			resultset = pstmt.executeQuery();
%>
				
			<table width="100%" border="0" cellpadding="0" cellspacing="0" id="example">
			<thead>
				<tr>
					<th class="thwrap" nowrap><fmt:message key="eOT.Items.label" bundle="${ot_labels}"/></th>
					<th class="thwrap" nowrap><fmt:message key="eOT.InCount.Label" bundle="${ot_labels}"/></th>
					<th class="thwrap" nowrap><fmt:message key="eOT.AdditionsduringOP.Label" bundle="${ot_labels}"/></th>
					<th class="thwrap" nowrap><fmt:message key="Common.TotalCount.label" bundle="${common_labels}"/></th>
<%
					if(allwdSwabCntsVal == 3)
					{
%>
						<th class="thwrap" nowrap><fmt:message key="eOT.SecondCount.Label" bundle="${ot_labels}"/></th>
						<th class="thwrap" nowrap><fmt:message key="eOT.AddnsafterCC.Label" bundle="${ot_labels}"/></th>
						<th class="thwrap" nowrap><fmt:message key="Common.TotalCount.label" bundle="${common_labels}"/></th>
<%
					}
					else
					{
						for(z=2; z<allwdSwabCntsVal; z++)
						{
							getKeyVal = ((String) headerMap.get(z)).split("~");
%>
							<th class="thwrap" nowrap><fmt:message key="<%=getKeyVal[0]%>" bundle="${ot_labels}"/></th>
							<th class="thwrap" nowrap><fmt:message key="<%=getKeyVal[1]%>" bundle="${ot_labels}"/></th>
							<th class="thwrap" nowrap><fmt:message key="Common.TotalCount.label" bundle="${common_labels}"/></th>
<%
						}
					}
%>
					<th class="thwrap" nowrap><fmt:message key="eOT.FinalCount.Label" bundle="${ot_labels}"/></th>
					<th class="thwrap" nowrap><fmt:message key="Common.view.label" bundle="${common_labels}"/></th>
<% 
					if(!CommonBean.checkForNull(request.getParameter("qry_mode")).equals("YES"))
					{
%>
						<th class="thwrap" nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th> 
<%
					}
%>
				</tr>	
				</thead>				
				<tbody>					
<%
				first_cnt_cmpl_yn = request.getParameter("first_cnt_cmpl_yn");
				first_cnt_disabled = first_cnt_cmpl_yn.equals("N") ? "" : "disabled";
				add_during_op_cmpl_yn = request.getParameter("add_during_op_cmpl_yn");
				during_op_disabled = first_cnt_cmpl_yn.equals("N") ? "disabled" : "";
				during_op_disabled = add_during_op_cmpl_yn.equals("Y") ? "disabled" : during_op_disabled;

				second_cnt_cmpl_yn = request.getParameter("second_cnt_cmpl_yn");
				second_cnt_disabled = add_during_op_cmpl_yn.equals("N") ? "disabled" : "";
				second_cnt_disabled = second_cnt_cmpl_yn.equals("Y") ? "disabled" : second_cnt_disabled;
				add_aft_clcav_cmpl_yn = request.getParameter("add_aft_clcav_cmpl_yn");
				after_cavity_disabled	= second_cnt_cmpl_yn.equals("N") ? "disabled" : "";
				after_cavity_disabled	= add_aft_clcav_cmpl_yn.equals("Y") ? "disabled" : after_cavity_disabled;
				// 2nd add complete --> add_aft_clcav_cmpl_yn
				valForFinalChkBox = add_aft_clcav_cmpl_yn;

				if(allwdSwabCntsVal > 3)
				{
					third_cnt_cmpl_yn = request.getParameter("third_cnt_cmpl_yn");
					third_cnt_disabled = add_aft_clcav_cmpl_yn.equals("N") ? "disabled" : "";
					third_cnt_disabled = third_cnt_cmpl_yn.equals("Y") ? "disabled" : third_cnt_disabled;
					additions_after_3c_cmpl_yn = request.getParameter("additions_after_3c_cmpl_yn");
					additions_after_3c_cmpl_yn_disabled = third_cnt_cmpl_yn.equals("N") ? "disabled" : "";
					additions_after_3c_cmpl_yn_disabled = additions_after_3c_cmpl_yn.equals("Y") ? "disabled" : additions_after_3c_cmpl_yn_disabled;
					valForFinalChkBox = additions_after_3c_cmpl_yn;
				}

				if(allwdSwabCntsVal > 4)
				{
					fourth_cnt_cmpl_yn = request.getParameter("fourth_cnt_cmpl_yn");
					fourth_cnt_disabled = additions_after_3c_cmpl_yn.equals("N") ? "disabled" : "";
					fourth_cnt_disabled = fourth_cnt_cmpl_yn.equals("Y") ? "disabled" : fourth_cnt_disabled;
					additions_after_4c_cmpl_yn = request.getParameter("additions_after_4c_cmpl_yn");
					additions_after_4c_cmpl_yn_disabled = fourth_cnt_cmpl_yn.equals("N") ? "disabled" : "";
					additions_after_4c_cmpl_yn_disabled = additions_after_4c_cmpl_yn.equals("Y") ? "disabled" : additions_after_4c_cmpl_yn_disabled;
					valForFinalChkBox = additions_after_4c_cmpl_yn;
				}

				if(allwdSwabCntsVal > 5)
				{
					fifth_cnt_cmpl_yn = request.getParameter("fifth_cnt_cmpl_yn");
					fifth_cnt_disabled = additions_after_4c_cmpl_yn.equals("N") ? "disabled" : "";
					fifth_cnt_disabled = fifth_cnt_cmpl_yn.equals("Y") ? "disabled" : fifth_cnt_disabled;
					additions_after_5c_cmpl_yn = request.getParameter("additions_after_5c_cmpl_yn");
					additions_after_5c_cmpl_yn_disabled = fifth_cnt_cmpl_yn.equals("N") ? "disabled" : "";
					additions_after_5c_cmpl_yn_disabled = additions_after_5c_cmpl_yn.equals("Y") ? "disabled" : additions_after_5c_cmpl_yn_disabled;
					valForFinalChkBox = additions_after_5c_cmpl_yn;
				}

				final_cnt_cmpl_yn = request.getParameter("final_cnt_cmpl_yn");
				final_cnt_disabled = valForFinalChkBox.equals("N") ? "disabled" : "";
				final_cnt_disabled = final_cnt_cmpl_yn.equals("Y") ? "disabled" : final_cnt_disabled;
				second_cnt_disabled = final_cnt_cmpl_yn.equals("Y") ? "disabled" : second_cnt_disabled; //Added for CRF-001
				if(first_cnt_disabled.equals(""))
					current_item = "first_cnt_cmpl_yn";
				else if(during_op_disabled.equals(""))
					current_item = "add_during_op_cmpl_yn";
				else if(second_cnt_disabled.equals(""))
					current_item = "second_cnt_cmpl_yn";
				else if(after_cavity_disabled.equals(""))
					current_item = "add_aft_clcav_cmpl_yn";

				while(resultset.next())
				{
					initial_count = "";
					db_initial_count = "";  
					total_count_during_op = "";
					total_additions_during_op = "";
					total_cavity_count = "";
					total_final_count  = "";
					total_second_val_count = "";

					thirdCountRemarksFlag = false;
					addtDuringThirdCountRemarksFlag = false;
					fourthCountRemarksFlag = false;
					addtDuringFourthCountRemarksFlag = false;
					fifthCountRemarksFlag = false;
					addtDuringFifthCountRemarksFlag = false;

					i++;
					if((i%2) == 1)
						classValue = "gridData";
					else
						classValue = "gridData";			
					item_code = checkForNull(resultset.getString("ITEM_CODE"));
					item_desc = checkForNull(resultset.getString("DESCRIPTION"));
					initial_count = checkForNull(resultset.getString("INITIAL_COUNT")); 
					Boolean flag1 = true;
					template_id = resultset.getString("TEMPLATE_ID");
					total_count_during_op = initial_count;

					sql = "SELECT  NVL(ITEM_VALUE,0) TOTAL_COUNT, REMARKS FROM OT_OPER_SWAB_INSTR_CNT_DTL WHERE OPERATING_FACILITY_ID =? AND OPER_NUM = ? AND SWAB_SERIAL_NUMBER =? AND TEMPLATE_ID=? AND ITEM_CODE=? AND NVL(FIRST_COUNT_YN,'N')='Y' AND NVL(ADDITIONS_DURING,'ZZ')='ZZ'  AND NVL(SECOND_COUNT_YN,'N') ='N' AND NVL (third_count_yn, 'N') = 'N' AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N'  AND NVL(FINAL_COUNT_YN,'N')='N'";
					pstmt=connection.prepareStatement(sql);
					pstmt.setString(1, facility_id);
					pstmt.setString(2, oper_num);
					pstmt.setString(3, swab_serial_number);		
					pstmt.setString(4, template_id);
					pstmt.setString(5, item_code);
					resultset1 = pstmt.executeQuery();

					while(resultset1.next())
					{
						db_initial_count = checkForNull(resultset1.getString(1));
						remarks_initial = checkForNull(resultset1.getString("REMARKS"));
						flag1 = false;
					}

					if(db_initial_count == null || db_initial_count.trim().length() == 0)
						db_initial_count = initial_count;
					db_initial_count = db_initial_count.equals("0") ? "" : db_initial_count;
					if(!flag1)
						initial_count = db_initial_count;
					total_count_during_op = initial_count;
					sql = "SELECT NVL(ITEM_VALUE,0) TOTAL_COUNT, REMARKS FROM OT_OPER_SWAB_INSTR_CNT_DTL WHERE OPERATING_FACILITY_ID =? AND OPER_NUM = ? AND SWAB_SERIAL_NUMBER =? AND TEMPLATE_ID=? AND ITEM_CODE=? AND NVL(FIRST_COUNT_YN,'N')='N' AND NVL(ADDITIONS_DURING,'OP')='OP' AND NVL(SECOND_COUNT_YN,'N') ='N'  AND NVL (third_count_yn, 'N') = 'N' AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N' AND NVL(FINAL_COUNT_YN,'N')='N'";
					if(pstmt != null)
						pstmt.close();
					if(resultset1 != null)
						resultset1.close();
					pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, facility_id);
					pstmt.setString(2, oper_num);
					pstmt.setString(3, swab_serial_number);		
					pstmt.setString(4, template_id);
					pstmt.setString(5, item_code);
					resultset1 = pstmt.executeQuery();
					while(resultset1.next())
					{
						if(("").equals(total_additions_during_op))
							total_additions_during_op = checkForNull(resultset1.getString(1));
						else
							total_additions_during_op = Integer.toString(Integer.parseInt(total_additions_during_op) + Integer.parseInt(resultset1.getString(1)));
						remarks_two = checkForNull(resultset1.getString("REMARKS"));
						if(remarks_two == null || remarks_two.trim().length() == 0)
							remarks_two = "";
					}

					if(total_additions_during_op == null || total_additions_during_op.trim().length() == 0 || total_additions_during_op.equals("0"))
						total_additions_during_op = "";

					if(!initial_count.equals("") && total_additions_during_op.equals(""))
						total_count_during_op = (Integer.parseInt(initial_count))+"";
					if(initial_count.equals("") && !total_additions_during_op.equals(""))
						total_count_during_op = (Integer.parseInt(total_additions_during_op))+"";
					if(!initial_count.equals("") && !total_additions_during_op.equals(""))
						total_count_during_op = (Integer.parseInt(initial_count)+Integer.parseInt(total_additions_during_op))+"";

					if(pstmt != null)
						pstmt.close();		
					if(resultset1 != null)
						resultset1.close();
					sql = "SELECT NVL(ITEM_VALUE,0) TOTAL_COUNT, REMARKS FROM OT_OPER_SWAB_INSTR_CNT_DTL WHERE OPERATING_FACILITY_ID =? AND OPER_NUM=? AND SWAB_SERIAL_NUMBER =? AND TEMPLATE_ID=? AND ITEM_CODE=? AND NVL(FIRST_COUNT_YN,'N')='N' AND NVL(ADDITIONS_DURING,'CL')='CL' AND NVL(SECOND_COUNT_YN,'N') ='N' AND NVL (third_count_yn, 'N') = 'N' AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N' AND NVL(FINAL_COUNT_YN,'N')='N'";
					pstmt=connection.prepareStatement(sql);
					pstmt.setString(1, facility_id);
					pstmt.setString(2, oper_num);
					pstmt.setString(3, swab_serial_number);
					pstmt.setString(4, template_id);
					pstmt.setString(5, item_code);
					resultset1 = pstmt.executeQuery();
					while(resultset1.next())
					{
						if(("").equals(total_cavity_count))
							total_cavity_count = checkForNull(resultset1.getString("TOTAL_COUNT"));
						else
							total_cavity_count = Integer.toString(Integer.parseInt(total_cavity_count) + Integer.parseInt(resultset1.getString("TOTAL_COUNT")));
						remarks_one = checkForNull(resultset1.getString("REMARKS"));
					}
					if(remarks_one == null || remarks_one.trim().length() == 0)
						remarks_one = "";
					if(total_cavity_count == null || total_cavity_count.trim().length() == 0 || total_cavity_count.equals("0"))
						total_cavity_count = "";
					if(pstmt != null) 
						pstmt.close();		
					if(resultset1 != null) 
						resultset1.close();
					sql = "SELECT ITEM_VALUE TOTAL_COUNT,REMARKS FROM OT_OPER_SWAB_INSTR_CNT_DTL WHERE OPERATING_FACILITY_ID =? AND OPER_NUM=? AND SWAB_SERIAL_NUMBER =? AND TEMPLATE_ID=? AND ITEM_CODE=? AND NVL(FIRST_COUNT_YN,'N')='N' AND NVL(ADDITIONS_DURING,'ZZ')='ZZ'  AND NVL(SECOND_COUNT_YN,'N') ='Y' AND NVL (third_count_yn, 'N') = 'N' AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N' AND NVL(FINAL_COUNT_YN,'N')='N' ";
					pstmt=connection.prepareStatement(sql);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,oper_num);
					pstmt.setString(3,swab_serial_number);		
					pstmt.setString(4,template_id);
					pstmt.setString(5,item_code);
					resultset1=pstmt.executeQuery();
					while(resultset1.next())
					{
						total_second_count = checkForNull(resultset1.getString("TOTAL_COUNT"));
						second_count_remarks = checkForNull(resultset1.getString("REMARKS"));
					}
					if(total_second_count == null || total_second_count.trim().length() == 0)
						total_second_count = "";
					if(second_count_remarks == null || second_count_remarks.trim().length() == 0)
						second_count_remarks = "";
					if(second_count_remarks.length() > 0)
						second_count_remarks_yn="Y";
					else
						second_count_remarks_yn="N";

					String customer_id="";
					String sql1="Select customer_id from SM_SITE_PARAM where rownum = 1";
					pstmt1=connection.prepareStatement(sql1);
					rst1=pstmt1.executeQuery();
					if(rst1 !=null && rst1.next())
						customer_id=checkForNull(rst1.getString("customer_id"));
					if(rst1!=null)
						rst1.close();
					if(pstmt1!=null)
						pstmt1.close();
					if(customer_id.equalsIgnoreCase("MOHBR") && allwdSwabCntsVal == 3)
					{
						if(!total_cavity_count.equals("") && !total_count_during_op.equals(""))
							total_second_val_count = (Integer.parseInt(total_count_during_op) + Integer.parseInt(total_cavity_count)) + "";
						else
						{
							if(!total_count_during_op.equals("")) 
								total_second_val_count = total_count_during_op;
							else
								total_second_val_count = total_cavity_count; 
						}
					}
					else
					{
						if(!total_second_count.equals("") && !total_cavity_count.equals(""))
							total_second_val_count = (Integer.parseInt(total_second_count)+Integer.parseInt(total_cavity_count))+"";
						else
						{   
							if(!total_second_count.equals("")) 
								total_second_val_count = total_second_count;
							else
								total_second_val_count = total_cavity_count; 
						}
					}

					if(add_aft_clcav_cmpl_yn.equals("Y"))
					{
						if(pstmt!=null) 
							pstmt.close();		
						if(resultset1!=null) 
							resultset1.close();
						sql = "SELECT SUM(ITEM_VALUE) TOTAL_COUNT FROM OT_OPER_SWAB_INSTR_CNT_DTL WHERE OPERATING_FACILITY_ID =? AND OPER_NUM=? AND SWAB_SERIAL_NUMBER =? AND TEMPLATE_ID=? AND ITEM_CODE=? AND NVL(FIRST_COUNT_YN,'N')='N' AND NVL(ADDITIONS_DURING,'CL')='CL'  AND NVL(SECOND_COUNT_YN,'N') ='N' AND NVL (third_count_yn, 'N') = 'N' AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N' AND NVL(FINAL_COUNT_YN,'N')='N'";
						pstmt=connection.prepareStatement(sql);
						pstmt.setString(1,facility_id);
						pstmt.setString(2,oper_num);
						pstmt.setString(3,swab_serial_number);
						pstmt.setString(4,template_id);
						pstmt.setString(5,item_code);
						resultset1=pstmt.executeQuery();
						while(resultset1.next())
							add_after_cavity_count = checkForNull(resultset1.getString("TOTAL_COUNT"));
						if(add_after_cavity_count == null || add_after_cavity_count.trim().length() == 0 || add_after_cavity_count.equals("0"))
							add_after_cavity_count = "";
						if(pstmt!=null) 
							pstmt.close();		
						if(resultset1!=null) 
							resultset1.close();
					}
					valToChkForFinalCount = total_second_val_count;
					dataMap.put(2, "second_count_" + " ~ " + total_count_during_op + " ~ " + total_second_count + " ~ " + second_cnt_disabled + " ~ " + "item_after_close_cavity_" + " ~ " + add_after_cavity_count + " ~ " + after_cavity_disabled + " ~ " + add_aft_clcav_cmpl_yn + " ~ " + "total_cavity_count_" + " ~ " + total_second_val_count);

					if(allwdSwabCntsVal > 3)
					{
						sqlBuffer.delete(0, sqlBuffer.length());
						if(pstmt != null) 
							pstmt.close();		
						if(resultset1 != null)
							resultset1.close();
						sqlBuffer.append("	SELECT SUM (total_count) third_count, SUM (total_count1) addt_third_count,								");
						sqlBuffer.append("	(SUM (total_count) + SUM (total_count1)) total_third_count														");
						sqlBuffer.append("	FROM (SELECT CASE WHEN NVL (third_count_yn, 'N') = 'Y' THEN item_value ELSE 0 END total_count, 	");
						sqlBuffer.append("	CASE WHEN NVL (additions_during, 'ZZ') = '3C' THEN item_value ELSE 0 END total_count1					");
						sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl WHERE operating_facility_id = ? AND oper_num = ?				");
						sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?										");
						sqlBuffer.append("	AND NVL (first_count_yn, 'N') = 'N' AND NVL (second_count_yn, 'N') = 'N'									");
						sqlBuffer.append("	AND (NVL (third_count_yn, 'N') = 'Y' OR NVL (additions_during, 'ZZ') = '3C' )								");
						sqlBuffer.append("	AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N'									");
						sqlBuffer.append(" AND NVL (final_count_yn, 'N') = 'N')");
						pstmt = connection.prepareStatement(sqlBuffer.toString());
						pstmt.setString(1, facility_id);
						pstmt.setString(2, oper_num);
						pstmt.setString(3, swab_serial_number);		
						pstmt.setString(4, template_id);
						pstmt.setString(5, item_code);
						resultset1 = pstmt.executeQuery();
						while(resultset1.next())
						{
							thirdCount = checkForNull(resultset1.getString("third_count")).equals("0") ? "" : checkForNull(resultset1.getString("third_count"));
							addDuringThirdCount = additions_after_3c_cmpl_yn.equals("N") ? "" : (checkForNull(resultset1.getString("addt_third_count")).equals("0") ? "" : checkForNull(resultset1.getString("addt_third_count")));
							totalThirdCount = checkForNull(resultset1.getString("total_third_count")).equals("0") ? "" : checkForNull(resultset1.getString("total_third_count"));
						}
						valToChkForFinalCount = totalThirdCount;
						dataMap.put(3, "third_count_" + " ~ " + total_second_val_count + " ~ " + thirdCount + " ~ " + third_cnt_disabled + " ~ " + "add_after_third_count_" + " ~ " + addDuringThirdCount + " ~ " + additions_after_3c_cmpl_yn_disabled + " ~ " + additions_after_3c_cmpl_yn + " ~ " + "total_third_count_" + " ~ " + totalThirdCount);

						sqlBuffer.delete(0, sqlBuffer.length());
						if(pstmt != null) 
							pstmt.close();		
						if(resultset1 != null)
							resultset1.close();
						sqlBuffer.append("	SELECT CASE WHEN NVL (third_count_yn, 'N') = 'Y' THEN remarks END third_count_remarks,		");
						sqlBuffer.append("	CASE WHEN NVL (additions_during, 'ZZ') = '3C' THEN remarks END add_third_count_remarks		");
						sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl WHERE operating_facility_id = ? AND oper_num = ?				");
						sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?										");
						sqlBuffer.append("	AND NVL (first_count_yn, 'N') = 'N' AND NVL (second_count_yn, 'N') = 'N'									");
						sqlBuffer.append("	AND (NVL (third_count_yn, 'N') = 'Y' OR NVL (additions_during, 'ZZ') = '3C' )								");
						sqlBuffer.append("	AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N'									");
						sqlBuffer.append(" AND NVL (final_count_yn, 'N') = 'N' ");
						pstmt = connection.prepareStatement(sqlBuffer.toString());
						pstmt.setString(1, facility_id);
						pstmt.setString(2, oper_num);
						pstmt.setString(3, swab_serial_number);		
						pstmt.setString(4, template_id);
						pstmt.setString(5, item_code);
						resultset1 = pstmt.executeQuery();
						while(resultset1.next())
						{
							thirdCountRemarks = checkForNull(resultset1.getString("third_count_remarks"));
							addtDuringThirdCountRemarks = checkForNull(resultset1.getString("add_third_count_remarks"));
							if(thirdCountRemarks.trim().length() > 0)
							{
								thirdCountRemarksFlag = true;
								thirdCountRemarksYn = "Y";
							}
							if(addtDuringThirdCountRemarks.trim().length() > 0)
								addtDuringThirdCountRemarksFlag = true;
							if(thirdCountRemarksFlag && addtDuringThirdCountRemarksFlag)
								break;
						}
						if(third_cnt_disabled.equals("")){
							current_item = "third_cnt_cmpl_yn"; 
						}	
						else if(additions_after_3c_cmpl_yn_disabled.equals("")){
							current_item = "additions_after_3c_cmpl_yn"; 
						}
						 else if(final_cnt_cmpl_yn.equals("Y")){
							additions_after_3c_cmpl_yn_disabled = "disabled"; 
						} 
						
					}

					if(allwdSwabCntsVal > 4)
					{
						sqlBuffer.delete(0, sqlBuffer.length());
						if(pstmt != null) 
							pstmt.close();		
						if(resultset1 != null)
							resultset1.close();
						sqlBuffer.append("	SELECT SUM (total_count) fourth_count, SUM (total_count1) addt_fourth_count,							");
						sqlBuffer.append("	(SUM (total_count) + SUM (total_count1)) total_fourth_count														");
						sqlBuffer.append("	FROM (SELECT CASE WHEN NVL (fourth_count_yn, 'N') = 'Y' THEN item_value ELSE 0 END total_count, 	");
						sqlBuffer.append("	CASE WHEN NVL (additions_during, 'ZZ') = '4C' THEN item_value ELSE 0 END total_count1					");
						sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl WHERE operating_facility_id = ? AND oper_num = ?				");
						sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?										");
						sqlBuffer.append("	AND NVL (first_count_yn, 'N') = 'N' 																							");
						sqlBuffer.append("	AND NVL (second_count_yn, 'N') = 'N' AND NVL (third_count_yn, 'N') = 'N'									");
						sqlBuffer.append("	AND (NVL (fourth_count_yn, 'N') = 'Y' OR NVL (additions_during, 'ZZ') = '4C' )							");
						sqlBuffer.append("	AND NVL (fifth_count_yn, 'N') = 'N' AND NVL (final_count_yn, 'N') = 'N')										");
						pstmt = connection.prepareStatement(sqlBuffer.toString());
						pstmt.setString(1, facility_id);
						pstmt.setString(2, oper_num);
						pstmt.setString(3, swab_serial_number);		
						pstmt.setString(4, template_id);
						pstmt.setString(5, item_code);
						resultset1 = pstmt.executeQuery();
						while(resultset1.next())
						{
							fourthCount = checkForNull(resultset1.getString("fourth_count")).equals("0") ? "" : checkForNull(resultset1.getString("fourth_count"));
							addDuringFourthCount = additions_after_4c_cmpl_yn.equals("N") ? "" : (checkForNull(resultset1.getString("addt_fourth_count")).equals("0") ? "" : checkForNull(resultset1.getString("addt_fourth_count")));
							totalFourthCount = checkForNull(resultset1.getString("total_fourth_count")).equals("0") ? "" : checkForNull(resultset1.getString("total_fourth_count"));
						}
						valToChkForFinalCount = totalFourthCount;
						dataMap.put(4, "fourth_count_" + " ~ " + totalThirdCount + " ~ " + fourthCount + " ~ " + fourth_cnt_disabled + " ~ " + "add_after_fourth_count_" + " ~ " + addDuringFourthCount + " ~ " + additions_after_4c_cmpl_yn_disabled + " ~ " + additions_after_4c_cmpl_yn + " ~ " + "total_fourth_count_" + " ~ " + totalFourthCount);

						sqlBuffer.delete(0, sqlBuffer.length());
						if(pstmt != null) 
							pstmt.close();		
						if(resultset1 != null)
							resultset1.close();
						sqlBuffer.append("	SELECT CASE WHEN NVL (fourth_count_yn, 'N') = 'Y' THEN remarks END fourth_count_remarks,		");
						sqlBuffer.append("	CASE WHEN NVL (additions_during, 'ZZ') = '4C' THEN remarks END add_fourth_count_remarks		");
						sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl WHERE operating_facility_id = ? AND oper_num = ?					");
						sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?											");
						sqlBuffer.append("	AND NVL (first_count_yn, 'N') = 'N' 																								");
						sqlBuffer.append("	AND NVL (second_count_yn, 'N') = 'N' AND NVL (third_count_yn, 'N') = 'N'										");
						sqlBuffer.append("	AND (NVL (fourth_count_yn, 'N') = 'Y' OR NVL (additions_during, 'ZZ') = '4C' )								");
						sqlBuffer.append("	AND NVL (fifth_count_yn, 'N') = 'N' AND NVL (final_count_yn, 'N') = 'N'											");
						pstmt = connection.prepareStatement(sqlBuffer.toString());
						pstmt.setString(1, facility_id);
						pstmt.setString(2, oper_num);
						pstmt.setString(3, swab_serial_number);		
						pstmt.setString(4, template_id);
						pstmt.setString(5, item_code);
						resultset1 = pstmt.executeQuery();
						while(resultset1.next())
						{
							fourthCountRemarks = checkForNull(resultset1.getString("fourth_count_remarks"));
							addtDuringFourthCountRemarks = checkForNull(resultset1.getString("add_fourth_count_remarks"));
							if(fourthCountRemarks.trim().length() > 0)
							{
								fourthCountRemarksFlag = true;
								fourthCountRemarksYn = "Y";
							}
							if(addtDuringFourthCountRemarks.trim().length() > 0)
								addtDuringFourthCountRemarksFlag = true;
							if(fourthCountRemarksFlag && addtDuringFourthCountRemarksFlag)
								break;
						}
						if(fourth_cnt_disabled.equals(""))
							current_item = "fourth_cnt_cmpl_yn";
						else if(additions_after_4c_cmpl_yn_disabled.equals(""))
							current_item = "additions_after_4c_cmpl_yn";
					}

					if(allwdSwabCntsVal > 5)
					{
						sqlBuffer.delete(0, sqlBuffer.length());
						if(pstmt != null) 
							pstmt.close();		
						if(resultset1 != null)
							resultset1.close();
						sqlBuffer.append("	SELECT SUM (total_count) fifth_count, SUM (total_count1) addt_fifth_count,								");
						sqlBuffer.append("	(SUM (total_count) + SUM (total_count1)) total_fifth_count														");
						sqlBuffer.append("	FROM (SELECT CASE WHEN NVL (fifth_count_yn, 'N') = 'Y' THEN item_value ELSE 0 END total_count, 	");
						sqlBuffer.append("	CASE WHEN NVL (additions_during, 'ZZ') = '5C' THEN item_value ELSE 0 END total_count1				");
						sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl WHERE operating_facility_id = ? AND oper_num = ?			");
						sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?									");
						sqlBuffer.append("	AND NVL (first_count_yn, 'N') = 'N' AND NVL (second_count_yn, 'N') = 'N'								");
						sqlBuffer.append("	AND NVL (third_count_yn, 'N') = 'N' AND NVL (fourth_count_yn, 'N') = 'N'								");
						sqlBuffer.append("	AND (NVL (fifth_count_yn, 'N') = 'Y' OR NVL (additions_during, 'ZZ') = '5C')								");
						sqlBuffer.append("	AND NVL (final_count_yn, 'N') = 'N')																					");
						pstmt = connection.prepareStatement(sqlBuffer.toString());
						pstmt.setString(1, facility_id);
						pstmt.setString(2, oper_num);
						pstmt.setString(3, swab_serial_number);		
						pstmt.setString(4, template_id);
						pstmt.setString(5, item_code);
						resultset1 = pstmt.executeQuery();
						while(resultset1.next())
						{
							fifthCount = checkForNull(resultset1.getString("fifth_count")).equals("0") ? "" : checkForNull(resultset1.getString("fifth_count"));
							addDuringFifthCount = additions_after_5c_cmpl_yn.equals("N") ? "" : (checkForNull(resultset1.getString("addt_fifth_count")).equals("0") ? "" : checkForNull(resultset1.getString("addt_fifth_count")));
							totalFifthCount = checkForNull(resultset1.getString("total_fifth_count")).equals("0") ? "" : checkForNull(resultset1.getString("total_fifth_count"));
						}
						valToChkForFinalCount = totalFifthCount;
						dataMap.put(5, "fifth_count_" + " ~ " + totalFourthCount + " ~ " + fifthCount + " ~ " + fifth_cnt_disabled + " ~ " + "add_after_fifth_count_" + " ~ " + addDuringFifthCount + " ~ " + additions_after_5c_cmpl_yn_disabled + " ~ " + additions_after_5c_cmpl_yn + " ~ " + "total_fifth_count_" + " ~ " + totalFifthCount);

						sqlBuffer.delete(0, sqlBuffer.length());
						if(pstmt != null)
							pstmt.close();
						if(resultset1 != null)
							resultset1.close();
						sqlBuffer.append("	SELECT CASE WHEN NVL (fifth_count_yn, 'N') = 'Y' THEN remarks END fifth_count_remarks,		");
						sqlBuffer.append("	CASE WHEN NVL (additions_during, 'ZZ') = '5C' THEN remarks END add_fifth_count_remarks		");
						sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl WHERE operating_facility_id = ? AND oper_num = ?					");
						sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?											");
						sqlBuffer.append("	AND NVL (first_count_yn, 'N') = 'N' AND NVL (second_count_yn, 'N') = 'N'								");
						sqlBuffer.append("	AND NVL (third_count_yn, 'N') = 'N' AND NVL (fourth_count_yn, 'N') = 'N'								");
						sqlBuffer.append("	AND (NVL (fifth_count_yn, 'N') = 'Y' OR NVL (additions_during, 'ZZ') = '5C'								");
						sqlBuffer.append("	AND NVL (final_count_yn, 'N') = 'N')																					");
						pstmt = connection.prepareStatement(sqlBuffer.toString());
						pstmt.setString(1, facility_id);
						pstmt.setString(2, oper_num);
						pstmt.setString(3, swab_serial_number);		
						pstmt.setString(4, template_id);
						pstmt.setString(5, item_code);
						resultset1 = pstmt.executeQuery();
						while(resultset1.next())
						{
							fifthCountRemarks = checkForNull(resultset1.getString("fifth_count_remarks"));
							addtDuringFifthCountRemarks = checkForNull(resultset1.getString("add_fifth_count_remarks"));
							if(fifthCountRemarks.trim().length() > 0)
							{
								fifthCountRemarksFlag = true;
								fifthCountRemarksYn = "Y";
							}
							if(addtDuringFifthCountRemarks.trim().length() > 0)
								addtDuringFifthCountRemarksFlag = true;
							if(fifthCountRemarksFlag && addtDuringFifthCountRemarksFlag)
								break;
						}
						if(fifth_cnt_disabled.equals(""))
							current_item = "fifth_cnt_cmpl_yn";
						else if(additions_after_5c_cmpl_yn_disabled.equals(""))
							current_item = "additions_after_5c_cmpl_yn";
					}
					//System.err.println("764========final_cnt_disabled======="+final_cnt_disabled);	
					/* Commented against CRF-001
						if(final_cnt_disabled.equals("")){
						current_item = "final_cnt_cmpl_yn"; System.err.println("825,final_cnt_cmpl_yn==current_item==="+current_item);
					}	 */
					sql = "SELECT ITEM_VALUE TOTAL_COUNT ,REMARKS FROM OT_OPER_SWAB_INSTR_CNT_DTL WHERE OPERATING_FACILITY_ID =? AND OPER_NUM=? AND SWAB_SERIAL_NUMBER =? AND TEMPLATE_ID=? AND ITEM_CODE=? AND NVL(FIRST_COUNT_YN,'N')='N' AND NVL(ADDITIONS_DURING,'ZZ')='ZZ'  AND NVL(SECOND_COUNT_YN,'N') ='N' AND NVL(FINAL_COUNT_YN,'N')='Y' ";
					if(pstmt!=null) 
						pstmt.close();		
					if(resultset1!=null)
						resultset1.close();
					pstmt=connection.prepareStatement(sql);
					pstmt.setString(1, facility_id);
					pstmt.setString(2, oper_num);
					pstmt.setString(3, swab_serial_number);		
					pstmt.setString(4, template_id);
					pstmt.setString(5, item_code);
					resultset1=pstmt.executeQuery();
					while(resultset1.next())
					{
						total_final_count = checkForNull(resultset1.getString("TOTAL_COUNT"));
						final_count_remarks = checkForNull(resultset1.getString("REMARKS"));
					}
					if(total_final_count == null || total_final_count.trim().length() == 0 || total_final_count.equals("0"))
						total_final_count = "";
						
					if(final_count_remarks == null || final_count_remarks.trim().length() == 0)
						final_count_remarks = "";
						
					if(final_count_remarks.length() > 0)
						final_count_remarks_yn = "Y";
					else
						final_count_remarks_yn = "N";						
						
%>
						<input type="hidden" name="second_count_remarks_yn_<%=i%>" id="second_count_remarks_yn_<%=i%>" value="<%=second_count_remarks_yn%>">
						<input type="hidden" name="third_count_remarks_yn_<%=i%>" id="third_count_remarks_yn_<%=i%>" value="<%=thirdCountRemarksYn%>">
						<input type="hidden" name="fourth_count_remarks_yn_<%=i%>" id="fourth_count_remarks_yn_<%=i%>" value="<%=fourthCountRemarksYn%>">
						<input type="hidden" name="fifth_count_remarks_yn_<%=i%>" id="fifth_count_remarks_yn_<%=i%>" value="<%=fifthCountRemarksYn%>">
						<input type="hidden" name="final_count_remarks_yn_<%=i%>" id="final_count_remarks_yn_<%=i%>" value="<%=final_count_remarks_yn%>">
						<input type="hidden" name="old_item_during_op_<%=i%>" id="old_item_during_op_<%=i%>" value="<%=total_count_during_op%>" >
						<input type="hidden" name="old_item_after_cc_<%=i%>" id="old_item_after_cc_<%=i%>" value="<%=total_second_val_count%>" >	
						<input type="hidden" name="initial_count_val_<%=i%>" id="initial_count_val_<%=i%>" value="<%=initial_count%>" >	
						<input type="hidden" name="old_item_after_3c_<%=i%>" id="old_item_after_3c_<%=i%>" value="<%=totalThirdCount%>" >	
						<input type="hidden" name="old_item_after_4c_<%=i%>" id="old_item_after_4c_<%=i%>" value="<%=totalFourthCount%>" >	
						<input type="hidden" name="old_item_after_5c_<%=i%>" id="old_item_after_5c_<%=i%>" value="<%=totalFifthCount%>" >	
<%
					if(add_during_op_cmpl_yn.equals("N"))
						total_additions_during_op = "";
%>
					<tr>
						<td><%=item_desc%> </td>
						<td>
							<input type="text"  name="first_count_<%=i%>" id="first_count_<%=i%>" id="first_count_<%=i%>"  maxlength="3" size="3" value="<%=initial_count%>" <%=first_cnt_disabled%> <%=initial_disabled_surg%> onBlur="CheckNum(this);" >
						</td>
						<td align="center"  align="center">
							<input type="text" name="item_during_op_<%=i%>" id="item_during_op_<%=i%>"  maxlength="3" size="3" value="<%=total_additions_during_op%>" <%=during_op_disabled%> <%=initial_disabled_surg%>  onBlur="CheckSwabCountNumber(this,'OP','<%=i%>');">
						</td>
						<td align="center">
							<input type="text" style="font:bold"  name="total_count_during_op_<%=i%>" id="total_count_during_op_<%=i%>" maxlength="3" size="3" value=" <%=total_count_during_op%>" disabled >
						</td>
<%
						if(allwdSwabCntsVal == 3)
						{
							//System.err.println("854===total_second_count==="+total_second_count);
							//System.err.println("855===total_count_during_op==="+total_count_during_op);
							if(total_second_count.equals("") || total_count_during_op.equals(total_second_count))
								condStr = "";
							else if(!(total_second_count.equals("") && total_count_during_op.equals(total_second_count)))
							{
								if(second_cnt_disabled.equals(""))
									condStr = "style=\"color:#FF0033\"";
								else
									condStr = "style=\"color:blue;font:bold;background-color:#FF0033\"";
							}
							//Added against start PMG2017-MO-CRF-0001 [IN:063849]
							if(final_cnt_cmpl_yn.equals("Y")){
							after_cavity_disabled="disabled";
							}
							//Added against end PMG2017-MO-CRF-0001 [IN:063849]
%>
							<td align="center">
								<input type="text" name="second_count_<%=i%>" id="second_count_<%=i%>" maxlength="3" size="3" value="<%=total_second_count%>" <%=condStr%> <%=second_cnt_disabled%> <%=initial_disabled_surg%> onBlur="CheckNum(this); changeColor('<%=i%>',this, 'OP');checkBlank('<%=i%>',this);enable_disable(this)">
							</td>
							<td align="center">
								<input type="text" name="item_after_close_cavity_<%=i%>" id="item_after_close_cavity_<%=i%>" maxlength="3" size="3" value="<%=add_after_cavity_count%>" <%=after_cavity_disabled%> <%=initial_disabled_surg%> onBlur="CheckSwabCountNumber(this,'CL','<%=i%>');enable_disable(this)"> <!--PMG2017-MO-CRF-0001 [IN:063849] -->
							</td>
							<td align="center">
								<input type="text" style="font:bold" name="total_cavity_count_<%=i%>" id="total_cavity_count_<%=i%>" maxlength="3" size="3" value="<%=total_second_val_count%>" disabled>
							</td>
<%
					}
					else
					{
						for(z=2; z<allwdSwabCntsVal; z++)
						{
							//System.err.println("=933====dataMap======="+dataMap);
							getDataMapKeyVal = ((String) dataMap.get(z)).split("~");
							getKeyVal = ((String) headerMap.get(z)).split("~");
							
							//System.err.println("937=====getKeyVal======="+getKeyVal);
							
							if(z == 2)
								valToChkColor = "OP";
							else
								valToChkColor = ((String) headerMap.get(z-1)).split("~")[2];								
								
							//System.err.println("945=====valToChkColor======="+valToChkColor);
							if(getDataMapKeyVal[2].trim().length() == 0 || getDataMapKeyVal[1].trim().equals(getDataMapKeyVal[2].trim()))
								condStr = "";
							else if(!(getDataMapKeyVal[2].trim().length() == 0 && getDataMapKeyVal[1].trim().equals(getDataMapKeyVal[2].trim())))
							{
								if(getDataMapKeyVal[3].trim().length() == 0)
									condStr = "style=\"color:#FF0033\"";
								else
									condStr = "style=\"color:blue;font:bold;background-color:#FF0033\"";
							}
						 // Added Against Start PMG2017-MO-CRF-0001 [IN:063849]
									if(final_cnt_cmpl_yn.equals("Y")){
										getDataMapKeyVal[3]="disabled";								
										getDataMapKeyVal[6]="disabled";								
									}
						 // Added Against End PMG2017-MO-CRF-0001 [IN:063849]			
						
%>
							<td align="center">
								<input type="text" name="<%=getDataMapKeyVal[0].trim()%><%=i%>" id="<%=getDataMapKeyVal[0].trim()%><%=i%>" maxlength="3" size="3" value="<%=getDataMapKeyVal[2].trim()%>" <%=condStr%> <%=getDataMapKeyVal[3].trim()%> <%=initial_disabled_surg%> onBlur="CheckNum(this); changeColor('<%=i%>',this, '<%=valToChkColor%>'); checkBlank('<%=i%>',this);enable_disable(this)">
							</td>
							<td align="center">
								<input type="text" name="<%=getDataMapKeyVal[4].trim()%><%=i%>" id="<%=getDataMapKeyVal[4].trim()%><%=i%>" maxlength="3" size="3" value="<%=getDataMapKeyVal[5].trim()%>" <%=getDataMapKeyVal[6].trim()%>  <%=initial_disabled_surg%> onBlur="CheckSwabCountNumber(this,'<%=(String)getKeyVal[2]%>','<%=i%>');enable_disable(this)">
							</td>
							<td align="center">
								<input type="text" name="<%=getDataMapKeyVal[8].trim()%><%=i%>" id="<%=getDataMapKeyVal[8].trim()%><%=i%>" style="font:bold" maxlength="3" size="3" value="<%=getDataMapKeyVal[9].trim()%>" disabled>
																
							</td>
					<%
						}
					}
					if(total_final_count.equals(""))
						finalCountStyle = "";					
					else if(!(total_final_count.equals("") && total_cavity_count.equals(total_final_count)))
					{
						if(final_cnt_disabled.equals("") )
						{
							if(!total_final_count.equals(valToChkForFinalCount))
								finalCountStyle = "style=\"color:#FF0033\"";
							else
								finalCountStyle = "";							
						}
						else 
						{
							//valToChkForFinalCount="1";//total_count_during_op
							//System.err.println("1005========total_count_during_op======="+total_count_during_op);		
							// Added against start PMG2017-MO-CRF-0001 [IN:063849] (added logic for allowed count 3)
							  if(valToChkForFinalCount =="" || valToChkForFinalCount==null){
								valToChkForFinalCount = total_count_during_op;
								//System.err.println("1009========valToChkForFinalCount======="+valToChkForFinalCount);		
							} 
							// Added logic allowed count 4 2nd cout logic		
							if(total_second_val_count !="" && total_second_val_count !=null){
										valToChkForFinalCount = total_second_val_count;
							//System.err.println("1010========valToChkForFinalCount======="+valToChkForFinalCount);				
							
							} 
							// Added logic allowed count 4 third count logic		
							if(totalThirdCount !="" && totalThirdCount !=null){
										valToChkForFinalCount = totalThirdCount;
							//System.err.println("1023========valToChkForFinalCount======="+valToChkForFinalCount);				
							
							}
							// Added logic allowed count 5th fourth count logic
							if(totalFourthCount !="" && totalFourthCount !=null){
										valToChkForFinalCount = totalFourthCount;
							//System.err.println("1023========valToChkForFinalCount======="+valToChkForFinalCount);				
							
							}
							if(totalFifthCount !="" && totalFifthCount !=null){
										valToChkForFinalCount = totalFifthCount;
							//System.err.println("1023========valToChkForFinalCount======="+valToChkForFinalCount);				
							
							}
							// Added against end PMG2017-MO-CRF-0001 [IN:063849]
							if(!total_final_count.equals(valToChkForFinalCount) &&  final_cnt_cmpl_yn.equals("Y")){
								//System.err.println("1013========total_final_count======="+total_final_count);		
								//System.err.println("1014========valToChkForFinalCount======="+valToChkForFinalCount);		
								finalCountStyle = "style=\"color:blue;font:bold;background-color:#FF0033\"";
								//System.err.println("1016========finalCountStyle======="+finalCountStyle);		
								
							}	
							else {
								finalCountStyle = "";
								//System.err.println("1021========finalCountStyle======="+finalCountStyle);		
								}
						}
					}
				//	System.err.println("==========z========="+z);
					if(allwdSwabCntsVal == 3)
						valToChkColor = "CL";
					else
						valToChkColor = ((String) headerMap.get(z-1)).split("~")[2];
				
					/*added start PMG2017-MO-CRF-0001 [IN:063849]*/
					if(first_cnt_cmpl_yn.equals("Y") && add_during_op_cmpl_yn.equals("Y")){
						count++;
					}
					if(second_cnt_cmpl_yn.equals("Y") && add_aft_clcav_cmpl_yn.equals("Y")){
					count++;
					}	
					if(third_cnt_cmpl_yn.equals("Y")){
					count++;
					}
					if(fourth_cnt_cmpl_yn.equals("Y")){
					count++;
					}
					if(fifth_cnt_cmpl_yn.equals("Y")){
					count++;
					}
					
					if(swab_count == 2 && count >= 1 &&  final_cnt_cmpl_yn.equals("N"))
					{
						final_cnt_disabled = "";
					}
					if(final_cnt_cmpl_yn.equals("Y")){
							after_cavity_disabled="disabled";
					}
					/*added end PMG2017-MO-CRF-0001 [IN:063849]*/
					
%>
					<td align="center">
						<input type="text" name="final_count_<%=i%>" id="final_count_<%=i%>" maxlength="3" size="3" value="<%=total_final_count%>" <%=final_cnt_disabled%> <%=initial_disabled_surg%> <%=finalCountStyle%> onBlur="CheckNum(this); changeColor('<%=i%>',this, '<%=valToChkColor%>');checkBlank('<%=i%>',this);enable_disable(this)">
					</td>
<%
					if(remarks_initial.trim().length() > 0 || remarks_one.trim().length() > 0 || remarks_two.trim().length() > 0 || second_count_remarks.trim().length() > 0 || final_count_remarks.trim().length() > 0
						|| thirdCountRemarksFlag || addtDuringThirdCountRemarksFlag)
					{
%>
						<td align="center">
							<label style="color:DARKBLUE;cursor:pointer;font:bold" onClick="viewSwabCountRemarks('<%=i%>')">
							<fmt:message key="eOT.Addns.Label" bundle="${ot_labels}"/>..</label>
						</td>
<%
					}
					else
					{
%>
						<td align="center">
							<label style="color:blue;cursor:pointer"  onClick="viewSwabCountRemarks('<%=i%>')">
							<fmt:message key="eOT.Addns.Label" bundle="${ot_labels}"/>..</label>
						</td>
<%
					}
					if(!CommonBean.checkForNull(request.getParameter("qry_mode")).equals("YES"))
					{
						if(final_cnt_cmpl_yn.equals("Y"))
						{
%>
							<td align="center">
								<label style="color:blue;cursor:pointer" onClick="alert('Remarks Cannot be edited after completion of final count.');" >
									<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></label>
								</label>
							</td>
<%
						}
						else
						{
%>
							<td align="center">
								<label style="color:blue;cursor:pointer" onClick="openSwabCountRemarksWindow(document.SwabCountForm,'Remarks','<%=i%>',500)" >
									<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
								</label>
							</td>
<%
						}
					}
%>
					</tr>
					<input type="hidden" name="item_code_<%=i%>" id="item_code_<%=i%>" value="<%=item_code%>" >
					<input type="hidden" name="item_desc_<%=i%>" id="item_desc_<%=i%>" value="<%=item_desc%>" >
					<input type="hidden" name="item_value_<%=i%>" id="item_value_<%=i%>" value="" >
					<input type="hidden" name="old_remarks_<%=i%>" id="old_remarks_<%=i%>" value="" >
					<input type="hidden" name="new_remarks_<%=i%>" id="new_remarks_<%=i%>" value="" >
					<input type="hidden" name="template_id_<%=i%>" id="template_id_<%=i%>" value="<%=template_id%>" >			
<%
				}
%>		
			</tbody>			
			</table>
				<input type='hidden' name='params' id='params' value="<%=request.getQueryString()%>" >
				<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>" >
				<input type='hidden' name='login_user' id='login_user' value="<%=login_user%>" >
				<input type='hidden' name='oper_num' id='oper_num' value="<%=oper_num%>" >
				<input type='hidden' name="swab_serial_number" id="swab_serial_number" value="<%=swab_serial_number%>" >
				<input type='hidden' name="reviewed_by" id="reviewed_by" value="" >
				<input type='hidden' name='no_of_records' id='no_of_records' value="<%=i%>" >
				<input type='hidden' name='rownum' id='rownum' value="" >
				<input type='hidden' name='additions_during_op_cmpl_yn_1' id='additions_during_op_cmpl_yn_1' value="" >
				<input type='hidden' name='first_cnt_cmpl_yn_1' id='first_cnt_cmpl_yn_1' value="" >
				<input type='hidden' name='second_cnt_cmpl_yn_1' id='second_cnt_cmpl_yn_1' value="" >
				<input type='hidden' name='second_cnt_cmpl_yn_22' id='second_cnt_cmpl_yn_22' value="" >
				<input type='hidden' name='second_cnt_cmpl_yn_33' id='second_cnt_cmpl_yn_33' value="" >
				<input type='hidden' name='final_cnt_cmpl_yn_1' id='final_cnt_cmpl_yn_1' value="" >
				<input type='hidden' name='additinal_cmpl_yn' id='additinal_cmpl_yn' value="" >
				<input type='hidden' name="current_item" id="current_item" value="<%=current_item%>" >
				<input type="hidden" name="additions_during_op" id="additions_during_op" value="" >
				<input type="hidden" name="item_stage" id="item_stage" value="" >
				<input type='hidden' name="first_count_yn" id="first_count_yn"	 value="N" >	
				<input type='hidden' name="second_count_yn" id="second_count_yn"  value="N" >	
				<input type='hidden' name="third_count_yn" id="third_count_yn"  value="N" >	
				<input type='hidden' name="fourth_count_yn" id="fourth_count_yn"  value="N" >	
				<input type='hidden' name="fifth_count_yn" id="fifth_count_yn"  value="N" >	
				<input type='hidden' name="final_count_yn" id="final_count_yn"	 value="N" >
				<input type='hidden' name='first_cnt_cmpl_yn' id='first_cnt_cmpl_yn' value="" >
				<input type='hidden' name='additions_during_op_cmpl_yn' id='additions_during_op_cmpl_yn' value="" >
				<input type='hidden' name='second_cnt_cmpl_yn' id='second_cnt_cmpl_yn' value="" >
				<input type='hidden' name='additions_aft_clcav_cmpl_yn' id='additions_aft_clcav_cmpl_yn' value="" >
				<input type='hidden' name='third_cnt_cmpl_yn' id='third_cnt_cmpl_yn' value="" >
				<input type='hidden' name='add_after_third_count' id='add_after_third_count' value="" >
				<input type='hidden' name='fourth_cnt_cmpl_yn' id='fourth_cnt_cmpl_yn' value="" >
				<input type='hidden' name='add_after_fourth_count' id='add_after_fourth_count' value="" >
				<input type='hidden' name='fifth_cnt_cmpl_yn' id='fifth_cnt_cmpl_yn' value="" >
				<input type='hidden' name='add_after_fifth_count' id='add_after_fifth_count' value="" >
				<input type='hidden' name='final_cnt_cmpl_yn' id='final_cnt_cmpl_yn' value="" >
				<input type='hidden' name='allwdSwabCntsVal' id='allwdSwabCntsVal' id="allwdSwabCntsVal" value="<%=allwdSwabCntsVal%>" >
				<input type='hidden' name='locale' id='locale' value="<%=locale%>">
				<!-- Added Against PMG2017-MO-CRF-0001 [IN:063849] -->
				<input type='hidden' name='count' id='count' value="<%=count%>">
				<input type='hidden' name='swab_count' id='swab_count' value="<%=swab_count%>">
				<input type='hidden' name='total_count_during_op' id='total_count_during_op' value="<%=total_count_during_op%>">
				<input type='hidden' name='total_second_val_count' id='total_second_val_count' value="<%=total_second_val_count%>">
				<input type='hidden' name='total_final_count' id='total_final_count' value="<%=total_final_count%>">
				<input type='hidden' name='totalThirdCount' id='totalThirdCount' value="<%=totalThirdCount%>">
				<input type='hidden' name='totalFourthCount' id='totalFourthCount' value="<%=totalFourthCount%>">
				<input type='hidden' name='totalFifthCount' id='totalFifthCount' value="<%=totalFifthCount%>">
<%	
			}
			catch(Exception e)
			{
				e.printStackTrace();
				//System.err.println("530: Caught Exception in Swab Count"+e); 
			}
			finally
			{
				if(resultset!=null) resultset.close();
				if(resultset1!=null) resultset1.close();
				if(pstmt!=null) pstmt.close();
				if(cstmt!=null) cstmt.close();
				ConnectionManager.returnConnection(connection,request);
			}
%>
		</form>
	</body>
</html>

