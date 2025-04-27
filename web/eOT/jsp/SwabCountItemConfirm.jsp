<!DOCTYPE html>
<%
	/*
		NOTE: Currently First Count is Not Used. The Initial Count is renamed as First Count and the First_Count is being removed completely. But at Database level, it is not changed. 
		First_Count(earlier known as Initial_Count) at frontend --> is Initial_Count at database level
	*/
%>
<%@ page contentType="text/html;charset=UTF-8" 
				  import = "java.sql.Connection,
				  				 java.sql.PreparedStatement,
				  				 java.sql.ResultSet,
				  				 java.util.*,
				  				 webbeans.eCommon.ConnectionManager" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String)session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
		<script src='../../eOT/js/SwabCount.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
	<body  onKeyDown="lockKey()" onLoad="reviewedby()">
		<form name="SwabCountItemConfirmForm" id="SwabCountItemConfirmForm" >
<%
			Connection connection = null;
			PreparedStatement pstmt=null;
			ResultSet resultset =null;
			String add_during_op_cmpl_yn = "N";
			String first_cnt_cmpl_yn = "N";
			String second_cnt_cmpl_yn = "N";
			String add_aft_clcav_cmpl_yn = "N";
			String final_cnt_cmpl_yn = "N";
			String first_cnt_checked = "";
			String first_cnt_disabled = "";
			String qry_mode = "";
			String initial_disabled_surg = "";
			String second_cnt_checked = "";
			String second_cnt_disabled = "";
			String after_cavity_checked = "";
			String after_cavity_disabled	= "";
			String final_cnt_checked	= "";
			String final_cnt_disabled	= "";
			String during_op_checked	= "";
			String during_op_disabled	= "";
			String oper_num = "";
			String facility_id	= "";
			String swab_serial_number	= "";
			StringBuffer orderTypeQryBuffer = new StringBuffer();
			int allwdSwabCntsVal = 0;
			LinkedHashMap labelNameMap = new LinkedHashMap();
			LinkedHashMap dataMap = new LinkedHashMap();
			String[] getLabelNameMapKeyVal;
			String[] getDataMapKeyVal;

			String third_cnt_cmpl_yn = "N";
			String third_cnt_cmpl_yn_chked = "";
			String third_cnt_cmpl_yn_disabled = "";
			String additions_after_3c_cmpl_yn = "N";
			String additions_after_3c_cmpl_yn_chked = "";
			String additions_after_3c_cmpl_yn_disabled = "";

			String fourth_cnt_cmpl_yn = "N";
			String fourth_cnt_cmpl_yn_chked = "";
			String fourth_cnt_cmpl_yn_disabled = "";
			String additions_after_4c_cmpl_yn = "N";
			String additions_after_4c_cmpl_yn_chked = "";
			String additions_after_4c_cmpl_yn_disabled = "";

			String fifth_cnt_cmpl_yn = "N";
			String fifth_cnt_cmpl_yn_chked = "";
			String fifth_cnt_cmpl_yn_disabled = "";
			String additions_after_5c_cmpl_yn = "N";
			String additions_after_5c_cmpl_yn_chked = "";
			String additions_after_5c_cmpl_yn_disabled = "";

			String reviewed_by = "";
			String reviewed_by_name = "";
			
			String valForFinalChkBox = "";
			int j = 0;
			//Added below against PMG2017-MO-CRF-0001 [IN:063849]
			String swabcount = ""; 
			int swab_count = 0;
			int count= 0;
			
			try
			{
				facility_id	= (String) session.getValue("facility_id");
				connection = ConnectionManager.getConnection(request);
				/* Added Start against PMG2017-MO-CRF-0001 [IN:063849] */
				String str_qry = "select NO_OF_SWAB_COUNT_REQD from ot_param_for_facility where operating_facility_id = '"+facility_id+"'";
				pstmt=connection.prepareStatement(str_qry);
				resultset = pstmt.executeQuery();
				if(resultset!= null && resultset.next())
				{
					swabcount = resultset.getString(1);
				}
				if(pstmt != null) pstmt.close();
				if(resultset!=null) resultset.close();
				/* Added End against PMG2017-MO-CRF-0001 [IN:063849] */
				labelNameMap.put(2, "eOT.SecondCountComp.Label~second_cnt_cmpl_yn~eOT.AddtSecondCountComp.Label~add_aft_clcav_cmpl_yn");
				labelNameMap.put(3, "eOT.ThirdCountComp.Label~third_cnt_cmpl_yn~eOT.AddtThirdCountComp.Label~addt_third_cnt_cmpl_yn");
				labelNameMap.put(4, "eOT.FourthCountComp.Label~fourth_cnt_cmpl_yn~eOT.AddtFourthCountComp.Label~addt_fourth_cnt_cmpl_yn");
				labelNameMap.put(5, "eOT.FifthCountComp.Label~fifth_cnt_cmpl_yn~eOT.AddtFifthCountComp.Label~addt_fifth_cnt_cmpl_yn");
				oper_num = checkForNull(request.getParameter("oper_num"));
				allwdSwabCntsVal = Integer.parseInt(checkForNull((request.getParameter("allwdSwabCntsVal") == null || request.getParameter("allwdSwabCntsVal").equals("0")) ? "3" : checkForNull(request.getParameter("allwdSwabCntsVal"))));
				swab_count = Integer.parseInt(swabcount); // Added for PMG2017-MO-CRF-0001 [IN:063849]
				//System.err.println("98,=======swab_count=====SwabCountItemConfirm.jsp====="+swab_count);
				swab_serial_number = checkForNull(request.getParameter("swab_serial_number")) == "" ? "1" : checkForNull(request.getParameter("swab_serial_number"));
				if(allwdSwabCntsVal == 0)
					allwdSwabCntsVal = 3;
				if(resultset!=null)
					resultset.close();
				if(pstmt!=null)
					pstmt.close();

				first_cnt_cmpl_yn = checkForNull(request.getParameter("first_cnt_cmpl_yn"));
				add_during_op_cmpl_yn = checkForNull(request.getParameter("add_during_op_cmpl_yn"));
				
				second_cnt_cmpl_yn = checkForNull(request.getParameter("second_cnt_cmpl_yn"));
				add_aft_clcav_cmpl_yn = checkForNull(request.getParameter("add_aft_clcav_cmpl_yn"));

				third_cnt_cmpl_yn = checkForNull(request.getParameter("third_cnt_cmpl_yn"));
				additions_after_3c_cmpl_yn = checkForNull(request.getParameter("additions_after_3c_cmpl_yn"));

				fourth_cnt_cmpl_yn = checkForNull(request.getParameter("fourth_cnt_cmpl_yn"));
				additions_after_4c_cmpl_yn = checkForNull(request.getParameter("additions_after_4c_cmpl_yn"));

				fifth_cnt_cmpl_yn = checkForNull(request.getParameter("fifth_cnt_cmpl_yn"));
				additions_after_5c_cmpl_yn = checkForNull(request.getParameter("additions_after_5c_cmpl_yn"));

				final_cnt_cmpl_yn = checkForNull(request.getParameter("final_cnt_cmpl_yn"));
				reviewed_by = checkForNull(request.getParameter("reviewedBy"));
				reviewed_by_name = checkForNull(request.getParameter("practitionerName"));
			
			/* Added Start Against PMG2017-MO-CRF-0001 [IN:063849] */
				
				if(first_cnt_cmpl_yn.equals("Y") && add_during_op_cmpl_yn.equals("Y"))
				{
					count++;
					//System.err.println("====1st===count============"+count);
				}if(second_cnt_cmpl_yn.equals("Y") && add_aft_clcav_cmpl_yn.equals("Y"))	
				{
					count++;
					//System.err.println("==2nd=====count============"+count);
				}
				if(third_cnt_cmpl_yn.equals("Y") && additions_after_3c_cmpl_yn.equals("Y"))	
				{
					count++;
					//System.err.println("==3rd=====count============"+count);
				}
				if(fourth_cnt_cmpl_yn.equals("Y") && additions_after_4c_cmpl_yn.equals("Y"))	
				{
					count++;
					//System.err.println("==4th=====count============"+count);
				}
				if(fifth_cnt_cmpl_yn.equals("Y") && additions_after_5c_cmpl_yn.equals("Y"))	
				{
					count++;
					//System.err.println("=5th======count============"+count);
				}
				//System.err.println("===final======count============"+count);
				/* Added End for PMG2017-MO-CRF-0001 [IN:063849] */
/* 				System.err.println("=======first_cnt_cmpl_yn============"+first_cnt_cmpl_yn);
				System.err.println("=======add_during_op_cmpl_yn============"+add_during_op_cmpl_yn);
				System.err.println("=======second_cnt_cmpl_yn============"+second_cnt_cmpl_yn);
				System.err.println("=======add_aft_clcav_cmpl_yn============"+add_aft_clcav_cmpl_yn);
				System.err.println("=======third_cnt_cmpl_yn============"+third_cnt_cmpl_yn);
				System.err.println("=======additions_after_3c_cmpl_yn============"+additions_after_3c_cmpl_yn);
				System.err.println("=======fourth_cnt_cmpl_yn============"+fourth_cnt_cmpl_yn);
				System.err.println("=======additions_after_4c_cmpl_yn============"+additions_after_4c_cmpl_yn);
				System.err.println("=======fifth_cnt_cmpl_yn============"+fifth_cnt_cmpl_yn);
				System.err.println("=======additions_after_5c_cmpl_yn============"+additions_after_5c_cmpl_yn); */
				//System.err.println("=======final_cnt_cmpl_yn============"+final_cnt_cmpl_yn);
			//	System.err.println("=======reviewed_by============"+reviewed_by);
			//	System.err.println("=======reviewed_by_name============"+reviewed_by_name);

				first_cnt_checked = first_cnt_cmpl_yn.equals("N") ? "" : "checked";
				first_cnt_disabled = first_cnt_cmpl_yn.equals("N") ? "" : "disabled";
				during_op_checked = add_during_op_cmpl_yn.equals("N") ? "" : "checked";
				during_op_disabled = first_cnt_cmpl_yn.equals("N") ? "disabled" : "";
				if(add_during_op_cmpl_yn.equals("Y"))
				{
					during_op_checked = "checked";
					during_op_disabled = "disabled";
				}

				second_cnt_checked = second_cnt_cmpl_yn.equals("N") ? "" : "checked";
				second_cnt_disabled = add_during_op_cmpl_yn.equals("N") ? "disabled" : "";
				if(second_cnt_cmpl_yn.equals("Y"))
				{
					second_cnt_checked = "checked";
					second_cnt_disabled = "disabled";
				}
				after_cavity_checked = add_aft_clcav_cmpl_yn.equals("N") ? "" : "checked";
				after_cavity_disabled	= second_cnt_cmpl_yn.equals("N") ? "disabled" : "";
				if(add_aft_clcav_cmpl_yn.equals("Y"))
				{
					after_cavity_checked = "checked";
					after_cavity_disabled = "disabled";
				}
				valForFinalChkBox = add_aft_clcav_cmpl_yn;
				dataMap.put(2, second_cnt_cmpl_yn + " ~ " + second_cnt_checked + " ~ " + second_cnt_disabled + " ~ " + add_aft_clcav_cmpl_yn + " ~ " + after_cavity_checked + " ~ " + after_cavity_disabled);

				if(allwdSwabCntsVal > 3)
				{
					third_cnt_cmpl_yn_chked = third_cnt_cmpl_yn.equals("N") ? "" : "checked";
					third_cnt_cmpl_yn_disabled	= add_aft_clcav_cmpl_yn.equals("N") ? "disabled" : "";
					if(third_cnt_cmpl_yn.equals("Y"))
					{
						third_cnt_cmpl_yn_chked = "checked";
						third_cnt_cmpl_yn_disabled = "disabled";
					}
					additions_after_3c_cmpl_yn_chked = additions_after_3c_cmpl_yn.equals("N") ? "" : "checked";
					additions_after_3c_cmpl_yn_disabled	= third_cnt_cmpl_yn.equals("N") ? "disabled" : "";
					if(additions_after_3c_cmpl_yn.equals("Y"))
					{
						additions_after_3c_cmpl_yn_chked = "checked";
						additions_after_3c_cmpl_yn_disabled = "disabled";
					}
					if(final_cnt_cmpl_yn.equals("Y"))
					{	
						additions_after_3c_cmpl_yn_disabled = "disabled";
					}
					valForFinalChkBox = additions_after_3c_cmpl_yn;
					dataMap.put(3, third_cnt_cmpl_yn + " ~ " + third_cnt_cmpl_yn_chked + " ~ " + third_cnt_cmpl_yn_disabled + " ~ " + additions_after_3c_cmpl_yn + " ~ " + additions_after_3c_cmpl_yn_chked + " ~ " + additions_after_3c_cmpl_yn_disabled);
				}

				if(allwdSwabCntsVal > 4)
				{
					fourth_cnt_cmpl_yn_chked = fourth_cnt_cmpl_yn.equals("N") ? "" : "checked";
					fourth_cnt_cmpl_yn_disabled	= additions_after_3c_cmpl_yn.equals("N") ? "disabled" : "";
					if(fourth_cnt_cmpl_yn.equals("Y"))
					{
						fourth_cnt_cmpl_yn_chked = "checked";
						fourth_cnt_cmpl_yn_disabled = "disabled";
					}
					additions_after_4c_cmpl_yn_chked = additions_after_4c_cmpl_yn.equals("N") ? "" : "checked";
					additions_after_4c_cmpl_yn_disabled	= fourth_cnt_cmpl_yn.equals("N") ? "disabled" : "";
					if(additions_after_4c_cmpl_yn.equals("Y"))
					{
						additions_after_4c_cmpl_yn_chked = "checked";
						additions_after_4c_cmpl_yn_disabled = "disabled";
					}
					valForFinalChkBox = additions_after_4c_cmpl_yn;
					dataMap.put(4, fourth_cnt_cmpl_yn + " ~ " + fourth_cnt_cmpl_yn_chked + " ~ " + fourth_cnt_cmpl_yn_disabled + " ~ " + additions_after_4c_cmpl_yn + " ~ " + additions_after_4c_cmpl_yn_chked + " ~ " + additions_after_4c_cmpl_yn_disabled);
				}

				if(allwdSwabCntsVal > 5)
				{
					fifth_cnt_cmpl_yn_chked = fifth_cnt_cmpl_yn.equals("N") ? "" : "checked";
					fifth_cnt_cmpl_yn_disabled	= additions_after_4c_cmpl_yn.equals("N") ? "disabled" : "";
					if(fifth_cnt_cmpl_yn.equals("Y"))
					{
						fifth_cnt_cmpl_yn_chked = "checked";
						fifth_cnt_cmpl_yn_disabled = "disabled";
					}
					additions_after_5c_cmpl_yn_chked = additions_after_5c_cmpl_yn.equals("N") ? "" : "checked";
					additions_after_5c_cmpl_yn_disabled	= fifth_cnt_cmpl_yn.equals("N") ? "disabled" : "";
					if(additions_after_5c_cmpl_yn.equals("Y"))
					{
						additions_after_5c_cmpl_yn_chked = "checked";
						additions_after_5c_cmpl_yn_disabled = "disabled";
					}
					valForFinalChkBox = additions_after_5c_cmpl_yn;
					dataMap.put(5, fifth_cnt_cmpl_yn + " ~ " + fifth_cnt_cmpl_yn_chked + " ~ " + fifth_cnt_cmpl_yn_disabled + " ~ " + additions_after_5c_cmpl_yn + " ~ " + additions_after_5c_cmpl_yn_chked + " ~ " + additions_after_5c_cmpl_yn_disabled);
				}
				//System.err.println("275========valForFinalChkBox============"+valForFinalChkBox);
				final_cnt_checked = final_cnt_cmpl_yn.equals("N") ? "" : "checked";
				final_cnt_disabled = valForFinalChkBox.equals("N") ? "disabled" : "";
				if(final_cnt_cmpl_yn.equals("Y"))
				{
					final_cnt_checked="checked";
					final_cnt_disabled="disabled";
					//Added against start PMG2017-MO-CRF-0001 [IN:063849]
					first_cnt_cmpl_yn="disabled";
					during_op_disabled="disabled";
					second_cnt_disabled="disabled";
					after_cavity_disabled="disabled";
					third_cnt_cmpl_yn_disabled="disabled";
					additions_after_3c_cmpl_yn_disabled="disabled";
					fourth_cnt_cmpl_yn_disabled="disabled";
					additions_after_4c_cmpl_yn_disabled	="disabled";
					fifth_cnt_cmpl_yn_disabled="disabled";
					additions_after_5c_cmpl_yn_disabled="disabled";
					//Added against end PMG2017-MO-CRF-0001 [IN:063849]
				}

				qry_mode = checkForNull(request.getParameter("qry_mode"));
				if(qry_mode.equals("YES"))
					initial_disabled_surg = "disabled";
					
%>
				<table border='0' cellpadding="3"  cellspacing='0' align='center'  width='100%'>
					<tr>
						<td width="25%" class="label" ><fmt:message key="eOT.InCountCompleted.Label" bundle="${ot_labels}"/></td>
						<td width="25%" class="fields">
							<input type="checkbox" class="checkbox" name="first_cnt_cmpl_yn" id="first_cnt_cmpl_yn" value="<%=first_cnt_cmpl_yn%>" <%=first_cnt_checked%> <%=first_cnt_disabled%> <%=initial_disabled_surg%> onClick="assignCheckboxValue(this)">
						</td>
						<td width="25%" class="label"><fmt:message key="eOT.AdditionsDuringOPCompleted.Label" bundle="${ot_labels}"/></td>
						<td width="25%" class="fields">
							<input type="checkbox" class="checkbox" name="add_during_op_cmpl_yn" id="add_during_op_cmpl_yn" value="<%=add_during_op_cmpl_yn%>" <%=during_op_checked%> <%=during_op_disabled%> <%=initial_disabled_surg%> onClick="assignCheckboxValue(this)">
						</td>
					</tr>
<%
					if(allwdSwabCntsVal == 3)
					{
%>
							<tr>
								<td width="25%" class="label"><fmt:message key="eOT.SecondCountCompleted.Label" bundle="${ot_labels}"/> </td>
								<td width="25%" class="fields">
									<input type="checkbox" class="checkbox" id="second_cnt_cmpl_yn" name="second_cnt_cmpl_yn" id="second_cnt_cmpl_yn" value="<%=second_cnt_cmpl_yn%>" <%=second_cnt_checked%> <%=second_cnt_disabled%> <%=initial_disabled_surg%> onClick="assignCheckboxValue(this);control(1,this);">
								</td>
								<td width="25%" class="label"><fmt:message key="eOT.AdditionsafterClcavityCompl.Label" bundle="${ot_labels}"/></td>
								<td width="25%" class="fields">
									<input type="checkbox" class="checkbox" id="add_aft_clcav_cmpl_yn" name="add_aft_clcav_cmpl_yn" id="add_aft_clcav_cmpl_yn" value="<%=add_aft_clcav_cmpl_yn%>" <%=after_cavity_checked%> <%=after_cavity_disabled%> <%=initial_disabled_surg%> onClick="assignCheckboxValue(this);control(2,this);">
								</td>
							</tr>
<%
					}
					else if(allwdSwabCntsVal > 3)
					{
						for(int i=2; i<allwdSwabCntsVal; i++)
						{
							if(i < allwdSwabCntsVal - 1)
								j = i + 1;
							else
								j = 0;
							getLabelNameMapKeyVal = ((String) labelNameMap.get(i)).split("~");
							getDataMapKeyVal = ((String) dataMap.get(i)).split("~");
%>
							<tr>
								<td width="25%" class="label">
<%
									if(qry_mode.trim().length() == 0 && j > 0 && ((String) dataMap.get(j)).split("~")[2].trim().length() == 0)
									{
%>
										<A NAME="scrollHere">
											<fmt:message key='<%=getLabelNameMapKeyVal[0]%>' bundle='${ot_labels}'/>
										</A>
<%
									}
									else
									{
%>
										<fmt:message key='<%=getLabelNameMapKeyVal[0]%>' bundle='${ot_labels}'/>
<%
									}
%>
								</td>
								<%
									if(final_cnt_cmpl_yn.equals("Y")){
										getDataMapKeyVal[2]="disabled";								
									}
								%>
								<td width="25%" class="fields">
									<input type="checkbox" class="checkbox" id="<%=getLabelNameMapKeyVal[1]%>" name="<%=getLabelNameMapKeyVal[1]%>" value="<%=getDataMapKeyVal[0]%>" <%=getDataMapKeyVal[1]%> <%=getDataMapKeyVal[2]%> <%=initial_disabled_surg%> onClick="assignCheckboxValue(this);control(3,this);">
								</td>
								<td width="25%" class="label"> 
<%
									if(qry_mode.trim().length() == 0 && j > 0 && ((String) dataMap.get(j)).split("~")[5].trim().length() == 0)
									{
%>
										<A NAME="scrollHere">
											<fmt:message key='<%=getLabelNameMapKeyVal[2]%>' bundle='${ot_labels}'/>
										</A>
										</td>
<%
									}
									else
									{
%>
										<fmt:message key='<%=getLabelNameMapKeyVal[2]%>' bundle='${ot_labels}'/> 
<%
									}
%>
<%
								 	if(final_cnt_cmpl_yn.equals("Y")){
										getDataMapKeyVal[5]="disabled";								
									}
%>
								<td width="25%" class="fields">
									<input type="checkbox" class="checkbox" id="<%=getLabelNameMapKeyVal[3]%>" name="<%=getLabelNameMapKeyVal[3]%>" value="<%=getDataMapKeyVal[3]%>" <%=getDataMapKeyVal[4]%> <%=getDataMapKeyVal[5]%> <%=initial_disabled_surg%> onClick="assignCheckboxValue(this);control(4,this);">
								</td>
							</tr>
<%
						}
					}
%>
					<tr>
						<td width="25%" class="label"> 
<%
							if(qry_mode.trim().length() == 0 && final_cnt_disabled.trim().length() == 0)
							{
%>
								<A NAME="scrollHere">
									<fmt:message key="eOT.FinalCountCompleted.Label" bundle="${ot_labels}"/>
								</A>
<%
							}
							else
							{
%>
								<fmt:message key="eOT.FinalCountCompleted.Label" bundle="${ot_labels}"/>
<%
							}
%>
						</td>
<!--  Added Start Against PMG2017-MO-CRF-0001 [IN:063849]  -->
<%
		
		if(swab_count == 2 && count >= 1){
		
			final_cnt_disabled="";
		}
		else if(swab_count == 3 && count >= 2){
		
			final_cnt_disabled="";
		}
		else if(swab_count == 4 && count >= 3){
		
			final_cnt_disabled="";
		}else if(swab_count == 5 && count >= 4){
		
			final_cnt_disabled="";
		}else if(swab_count == 6 && count >= 5){
		
			final_cnt_disabled="";
		}
								
		if(final_cnt_cmpl_yn.equals("Y"))
		{
			second_cnt_disabled="disabled";
			third_cnt_cmpl_yn_disabled="disabled";
			final_cnt_checked="checked";
			final_cnt_disabled="disabled";
			additions_after_3c_cmpl_yn_disabled="disabled";
		}
%>
<!-- Added End Against PMG2017-MO-CRF-0001 [IN:063849] -->		 
						<td width="25%" class="fields" >
						<input type="checkbox" class="checkbox" id="final_cnt_cmpl_yn" name="final_cnt_cmpl_yn" id="final_cnt_cmpl_yn" value="<%=final_cnt_cmpl_yn%>" <%=final_cnt_checked%> <%=final_cnt_disabled%> <%=initial_disabled_surg%> onClick="assignCheckboxValue(this);reviwedbyCheckBoxvalue(this);control(9,this);">
						</td>
						<td width="25%" align="top" class="label"><fmt:message key="eOT.ReviewedBy.Label" bundle="${ot_labels}"/>&nbsp;</td>
						<td width="25%" class="fields">
							<select name="reviewed_by" id="reviewed_by">
<%
								orderTypeQryBuffer.append("	SELECT a.practitioner_id, b.role_type, d.practitioner_name	");
								orderTypeQryBuffer.append("	FROM ot_post_oper_personnel a, ot_roles b, am_practitioner d	");
								orderTypeQryBuffer.append("	WHERE operating_facility_id = ?	");
								orderTypeQryBuffer.append("	AND oper_num = ?	");
								orderTypeQryBuffer.append("	AND a.role_id = b.role_id	");
								orderTypeQryBuffer.append("	AND a.practitioner_id = d.practitioner_id	");
								orderTypeQryBuffer.append("	AND a.practitioner_id = NVL (?, a.practitioner_id)	");
								orderTypeQryBuffer.append("	AND b.role_type = 'OS'	");
								if(resultset!=null) 
									resultset.close();
								if(pstmt!=null) 
									pstmt.close();
								int cnt = 0;
								pstmt = connection.prepareStatement(orderTypeQryBuffer.toString());
								pstmt.setString(1, facility_id);
								pstmt.setString(2, oper_num);
								pstmt.setString(3, reviewed_by);
								resultset = pstmt.executeQuery();				
								if(reviewed_by.equals(""))
								{
%>
									<option value = "" selected>-----Select----</option>
<%
									while(resultset!=null && resultset.next())
									{
										cnt++;
%>
										<option value="<%=resultset.getString(1)%>" > <%= resultset.getString(3)%> </option>
<%
									}
								}
								else
								{
%>
									<option value="<%=reviewed_by%>" selected> <%=reviewed_by_name%> </option>
<%
								}
%>
							</select>
			<input type="hidden" name="cnt" id="cnt" value="<%=cnt%>">
			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<img id="img1" src='../../eCommon/images/Blank1.gif' ></td>
			<!-- Added Against below PMG2017-MO-CRF-0001 [IN:063849] -->
			<input type='hidden' name='second_cnt_disabled' id='second_cnt_disabled' value="<%=second_cnt_disabled%>">
			<input type='hidden' name='second_cnt_checked' id='second_cnt_checked' value="<%=second_cnt_checked%>">
			<input type='hidden' name='after_cavity_checked' id='after_cavity_checked' value="<%=after_cavity_checked%>">
			<input type='hidden' name='after_cavity_disabled' id='after_cavity_disabled' value="<%=after_cavity_disabled%>">
			<input type='hidden' name='final_cnt_disabled' id='final_cnt_disabled' value="<%=final_cnt_disabled%>">
			<input type='hidden' name='final_cnt_checked' id='final_cnt_checked' value="<%=final_cnt_checked%>">
			<input type='hidden' name='third_cnt_cmpl_yn_chked' id='third_cnt_cmpl_yn_chked' value="<%=third_cnt_cmpl_yn_chked%>">
			<input type='hidden' name='third_cnt_cmpl_yn_disabled' id='third_cnt_cmpl_yn_disabled' value="<%=third_cnt_cmpl_yn_disabled%>">
			<input type='hidden' name='additions_after_3c_cmpl_yn_chked' id='additions_after_3c_cmpl_yn_chked' value="<%=additions_after_3c_cmpl_yn_chked%>">
			<input type='hidden' name='additions_after_3c_cmpl_yn_disabled' id='additions_after_3c_cmpl_yn_disabled' value="<%=additions_after_3c_cmpl_yn_disabled%>">
			<input type='hidden' name='fourth_cnt_cmpl_yn_chked' id='fourth_cnt_cmpl_yn_chked' value="<%=fourth_cnt_cmpl_yn_chked%>">
			<input type='hidden' name='fourth_cnt_cmpl_yn_disabled' id='fourth_cnt_cmpl_yn_disabled' value="<%=fourth_cnt_cmpl_yn_disabled%>">
			<input type='hidden' name='additions_after_4c_cmpl_yn_chked' id='additions_after_4c_cmpl_yn_chked' value="<%=additions_after_4c_cmpl_yn_chked%>">
			<input type='hidden' name='additions_after_4c_cmpl_yn_disabled' id='additions_after_4c_cmpl_yn_disabled' value="<%=additions_after_4c_cmpl_yn_disabled%>">
			<input type='hidden' name='fifth_cnt_cmpl_yn_chked' id='fifth_cnt_cmpl_yn_chked' value="<%=fifth_cnt_cmpl_yn_chked%>">
			<input type='hidden' name='fifth_cnt_cmpl_yn_disabled' id='fifth_cnt_cmpl_yn_disabled' value="<%=fifth_cnt_cmpl_yn_disabled%>">
			<input type='hidden' name='additions_after_5c_cmpl_yn_chked' id='additions_after_5c_cmpl_yn_chked' value="<%=additions_after_5c_cmpl_yn_chked%>">
			<input type='hidden' name='additions_after_5c_cmpl_yn_disabled' id='additions_after_5c_cmpl_yn_disabled' value="<%=additions_after_5c_cmpl_yn_disabled%>">
						</td>
					</tr>
				</table>
<%
			}
			catch(Exception e)
			{
				System.err.println("280: Caught Exception in Swab Count Item Confirm"+e);
				e.printStackTrace();
			}
			finally
			{
				if(resultset!=null) 
					resultset.close();
				if(pstmt!=null) 
					pstmt.close();	
				try
				{
					ConnectionManager.returnConnection(connection,request);
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
%>
		</form>
	</body>
</html>

