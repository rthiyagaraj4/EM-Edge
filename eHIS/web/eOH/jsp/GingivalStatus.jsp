<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = "";
		String disabled = "";
		String selected = "";
		String gingival_recording_by = "";
		String title = "";
		String gs_OT_disable = "";
		
	    String facility_id = (String)session.getValue("facility_id") ;

		String called_from = checkForNull(request.getParameter("called_from"));
		if(called_from.equals("OT")){
			gs_OT_disable = "disabled";
		}

		String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
		String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
		String gs_dflt_tooth_no_q1 = checkForNull(request.getParameter("gs_dflt_tooth_no_Q1"));
		String gs_dflt_tooth_no_q2 = checkForNull(request.getParameter("gs_dflt_tooth_no_Q2"));
		String gs_dflt_tooth_no_q3 = checkForNull(request.getParameter("gs_dflt_tooth_no_Q3"));
		String gs_dflt_tooth_no_q4 = checkForNull(request.getParameter("gs_dflt_tooth_no_Q4"));
		String called_from_viewchart_yn = checkForNull(request.getParameter( "called_from_viewchart_yn" ));
		String called_from_viewchart_gingival = checkForNull(request.getParameter( "called_from_viewchart_gingival" ));

		String chart_num= checkForNull(request.getParameter("chart_num"));
		String patient_id= checkForNull(request.getParameter("patient_id"));
	    String ns_quadrant= checkForNull(request.getParameter("ns_quadrant"));
		//String params= checkForNull(request.getParameter( "params" ));
		String quadrant_sno= checkForNull(request.getParameter( "quadrant_sno" ));
		String tooth_no= checkForNull(request.getParameter( "tooth_no" ));
		String condition_type= checkForNull(request.getParameter( "condition_type" ));
		String gingival_status_code= checkForNull(request.getParameter( "gingival_status_code" ));
	    String encounter_id= checkForNull(request.getParameter("encounter_id"));
	    String patient_class= checkForNull(request.getParameter("patient_class"));
	    String mixed_dentition_YN= checkForNull(request.getParameter("mixed_dentition_YN"));
	    String show_new_active_yn= checkForNull(request.getParameter("show_new_active_yn"));
	    String val_tooth_no= checkForNull(request.getParameter("val_tooth_no"));

		//out.println("patient_id:="+patient_id);
	    
	    String quadrant_sno_hid= checkForNull(request.getParameter("quadrant_sno_hid"));
	    String tooth_no_hid= checkForNull(request.getParameter("tooth_no_hid"));
	    String condition_type_hid= checkForNull(request.getParameter("condition_type_hid"));
	    String gingival_status_code_hid= checkForNull(request.getParameter("gingival_status_code_hid"));
		String status_hid= checkForNull(request.getParameter("status_hid"));
	    //String status= checkForNull(request.getParameter("status"));
	
		String chart_type = checkForNull(request.getParameter( "chart_type" )) ;
		String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;

		String gs_dflt_tooth_no_s1 = checkForNull(request.getParameter("gs_dflt_tooth_no_s1"));
		String gs_dflt_tooth_no_s2 = checkForNull(request.getParameter("gs_dflt_tooth_no_s2"));
		String gs_dflt_tooth_no_s3 = checkForNull(request.getParameter("gs_dflt_tooth_no_s3"));
		String gs_dflt_tooth_no_s4 = checkForNull(request.getParameter("gs_dflt_tooth_no_s4"));
		String gs_dflt_tooth_no_s5 = checkForNull(request.getParameter("gs_dflt_tooth_no_s5"));
		String gs_dflt_tooth_no_s6 = checkForNull(request.getParameter("gs_dflt_tooth_no_s6"));
		String other_facilitychart_yn = checkForNull(request.getParameter("other_facilitychart_yn"));
		String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id"));
		String baseline_chart_yn = checkForNull(request.getParameter("baseline_chart_yn"));
		String status_disabled="";
		
		//Added by Sharon Crasta on 7/31/2009 for IN009739(SRR20056-CRF-0457)
		String chart_status_disabled="";
		String status_before_after =  checkForNull(request.getParameter("status_before_after"));
		String mapped_tooth_no = "";
		//
		if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
		other_chart_facility_id=facility_id;
		}
		//Added by Sharon Crasta on 1/11/2010 for IN017822
		//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
		String chart_disable_from_main = checkForNull(request.getParameter( "chart_disable_from_main" )) ;
		
		if(called_from_viewchart_yn .equals("Y") || baseline_chart_yn.equals("Y") || chart_disable_from_main.equals("Y")){//End
		
			disabled = "disabled";
		}
		//Added by Sharon Crasta on 7/31/2009 for IN009739(SRR20056-CRF-0457)
		if(chart_type.equals("RM") && (called_from_viewchart_yn .equals("Y") || baseline_chart_yn.equals("Y"))){
			chart_status_disabled = "disabled";
		}
		//End
		if(!other_chart_facility_id.equals(facility_id) ||baseline_chart_yn.equals("Y")){
		status_disabled = "disabled";	
		}

	
	try{
		con=ConnectionManager.getConnection(request);

		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
		if(oh_chart_level.equals("E")){
			pstmt = con.prepareStatement("SELECT GINGIVAL_RECORDING_BY FROM OH_PARAM");
		}else{//End
			pstmt = con.prepareStatement("SELECT GINGIVAL_RECORDING_BY FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?");
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,other_chart_facility_id);
		}
		rs = pstmt.executeQuery();
		while (rs != null && rs.next()){
			gingival_recording_by = checkForNull(rs.getString("GINGIVAL_RECORDING_BY"));
		}

		if(gingival_recording_by.equals("Q")){
			title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Quadrant.Label","oh_labels"); 
		}
		else{
			title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Sextant.Label","oh_labels"); 
		}
%>

<html>
	<head>
	    <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css' ></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eOH/js/GingivalStatus.js"></script>
		<script language="javascript" src="../../eOH/js/OHDentalChart.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




	</head>

	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
	<form name="GingivalStatus" id="GingivalStatus" action="../../servlet/eOH.GingivalStatusServlet"  method="post" target="messageFrame">
		<table width="100%" cellpadding = 4 cellspacing=0>
			<tr>
				<td width="20%" class='LABEL' nowrap ><fmt:message key="Common.Site.label" bundle="${common_labels}"/></td>
				<td width="25%" class="field" ><input type="text"  name="oh_site" id="oh_site" value="<%=title%>" disabled></td>
				<td  width="15%" class='LABEL' nowrap><fmt:message key="Common.area.label" bundle="${common_labels}"/></td>
				<td width="15%" class="field" nowrap>
					<select name="oh_area" id="oh_area" onChange="getToothnumber(this);"<%=disabled%> <%=gs_OT_disable%>>
						<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
						<%
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							if(gingival_recording_by.equals("Q")){
								/* Commented by Parul  on 28/11/2008 to remove PERMANENT_DECIDUOUS  column reference from OH_QUADRANT_LANG_VW */
								//pstmt=con.prepareStatement("SELECT QUADRANT_SNO QUAD_SEXT_SNO, QUADRANT_DESC QUAD_SEXT_DESC FROM OH_QUADRANT_LANG_VW WHERE LANGUAGE_ID=? AND NUMBERING_SYSTEM = ? AND PERMANENT_DECIDUOUS = ? ORDER BY 2");
								pstmt=con.prepareStatement("SELECT QUADRANT_SNO QUAD_SEXT_SNO, QUADRANT_DESC QUAD_SEXT_DESC FROM OH_QUADRANT_LANG_VW WHERE LANGUAGE_ID=? AND NUMBERING_SYSTEM = ?  ORDER BY 2");
								pstmt.setString(1,locale);
								pstmt.setString(2,tooth_numbering_system);
								//pstmt.setString(3,permanent_deciduous_flag);
							}
							else{
								pstmt=con.prepareStatement("SELECT SEXTANT_SNO QUAD_SEXT_SNO, SEXTANT_DESC QUAD_SEXT_DESC FROM OH_SEXTANT_LANG_VW WHERE LANGUAGE_ID=? AND NUMBERING_SYSTEM = ? ORDER BY 1");
								pstmt.setString(1,locale);
								pstmt.setString(2,tooth_numbering_system);
							}
							
							rs=pstmt.executeQuery();
		
							while(rs.next()){
								if(quadrant_sno.equals(rs.getString("QUAD_SEXT_SNO"))){
									selected="selected";
								}
								else{
									selected="";
								}
						%>
			                    <option value=<%=rs.getString("QUAD_SEXT_SNO")%> <%=selected%>><%=rs.getString("QUAD_SEXT_DESC")%></option>
                        <%
							}
						%>
					</select>
					<% if(!called_from.equals("OT")){ %>
						<img src='../../eCommon/images/mandatory.gif'>
					<% } %>
				</td>
			</tr>
			<tr> 
				<td width="20%" class='LABEL' nowrap><fmt:message key="eOH.ToothNo.Label" bundle="${oh_labels}"/></td>
                <td width="15%" class="field"  align="left">
					<select name="oh_tooth" id="oh_tooth" <%=status_disabled%> onChange="checkMissingTooth(this);" <%=disabled%> <%=gs_OT_disable%>> 
						 <option value="" ><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
					</select>
					<% if(!called_from.equals("OT")){ %>
						<img src='../../eCommon/images/mandatory.gif'>
					<% } %>
                </td>
                <td  width="20%" class='LABEL' nowrap><fmt:message key="eOH.GingivalStatus.Label" bundle="${oh_labels}"/></td>
                <td width="15%" class="field"  align="left" nowrap>
					<select name="oh_status" id="oh_status" value="" <%=status_disabled%> <%=chart_status_disabled%> <%=gs_OT_disable%>>
						<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
						<%
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
								 
							sql="SELECT GINGIVAL_STATUS_CODE,GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW WHERE LANGUAGE_ID=?";
															   
							pstmt=con.prepareStatement(sql);
							pstmt.setString(1,locale);
							rs=pstmt.executeQuery();
							while(rs.next()){
								if(gingival_status_code.equals(rs.getString("GINGIVAL_STATUS_CODE"))){
									selected="selected";
								}
								else{
									selected="";
								}
						%>
								<option value=<%=rs.getString("GINGIVAL_STATUS_CODE")%> <%=selected%>><%=rs.getString("GINGIVAL_STATUS_DESC")%></option>
						<%
							}
						%>
                               
					</select>
					<% if(!called_from.equals("OT")){ %>
						<img src='../../eCommon/images/mandatory.gif'>
					<% } %>
				</td>
			</tr>
		    <%
				if(called_from_viewchart_yn.equals("Y")){
			%>
					<tr>
					<!--Commented by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457) -->
						<!-- <td width="25%" class='LABEL' nowrap id="status_legend"><fmt:message key="Common.status.label"  bundle="${common_labels}"/></td>
						<td width="15%" class="field"  id="status_show_yn"   align="left">
							<select name="status_mark" id="status_mark" <%=status_disabled%> >
								<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
								<option value="E"><fmt:message key="Common.MarkError.label" bundle="${common_labels}"/></option>
							</select>
						</td> -->
						<td></td>
						<td class="button" colspan=3 align="right">
							<input type="button"  class="button" name="save" id="save" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onclick ="actionToServlet()" <%=status_disabled%> <%=chart_status_disabled%> <%=gs_OT_disable%>>&nbsp;&nbsp;&nbsp;
							<input type="button" class="button"  name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onclick="GS_Tab_Reset_button(document.forms[0])"  <%=status_disabled%>>
						</td>
					</tr>

			<%
				}else{
			%>
					<!-- <td width="15%" class='LABEL' colspan="2"   align="left"></td> -->
					<tr>
						<td colspan="5" class="button"> 
							<input type="button"  class="button" name="save" id="save" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onclick ="actionToServlet()" <%=status_disabled%> <%=gs_OT_disable%>>
							&nbsp;
							<input type="button" class="button" name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onclick="GS_Tab_Reset_button(document.forms[0])" <%=status_disabled%> <%=gs_OT_disable%>>
						</td>
					</tr>
	          
			<%
				}
			%>
			
		</table>

		<input type = "hidden" name= "params" value = "<%=request.getQueryString()%>"> 
		<input type="hidden" name="called_from_viewchart_gingival" id="called_from_viewchart_gingival" value="<%=called_from_viewchart_gingival%>" > 
		<input type="hidden"  name= "tooth_numbering_system" value="<%=tooth_numbering_system%>">
		<input type="hidden" name="permanent_deciduous_flag" id="permanent_deciduous_flag" value="<%=permanent_deciduous_flag%>">
		<input type="hidden" name="gs_dflt_tooth_no_q1" id="gs_dflt_tooth_no_q1" value="<%=gs_dflt_tooth_no_q1%>">
		<input type="hidden" name="gs_dflt_tooth_no_q2" id="gs_dflt_tooth_no_q2" value="<%=gs_dflt_tooth_no_q2%>">
		<input type="hidden" name="gs_dflt_tooth_no_q3" id="gs_dflt_tooth_no_q3" value="<%=gs_dflt_tooth_no_q3%>">
		<input type="hidden" name="gs_dflt_tooth_no_q4" id="gs_dflt_tooth_no_q4" value="<%=gs_dflt_tooth_no_q4%>">
		<input type="hidden"  name= "chart_num" value="<%=chart_num%>">
		<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">
		<input type = "hidden" name= "ns_quadrant" value = "<%=ns_quadrant%>">
		<input type = "hidden" name= "quadrant_sno" value = "<%=quadrant_sno%>">
		<input type = "hidden" name= "tooth_no" value = "<%=tooth_no%>">
		<input type = "hidden" name= "condition_type" value = "<%=condition_type%>">
		<input type = "hidden" name= "gingival_status_code" value = "<%=gingival_status_code%>">
		<input type = "hidden" name= "called_from_viewchart_yn" value = "<%=called_from_viewchart_yn%>">
		<input type = "hidden" name= "encounter_id" value = "<%=encounter_id%>">
		<input type = "hidden" name= "patient_class" value = "<%=patient_class%>">
		<input type = "hidden" name= "mixed_dentition_YN" value = "<%=mixed_dentition_YN%>">
		<input type = "hidden" name= "show_new_active_yn" value = "<%=show_new_active_yn%>">
		<!-- <input type="hidden" name="status_mark" id="status_mark" value="" > -->

		<input type = "hidden" name= "quadrant_sno_hid" value = "<%=quadrant_sno_hid%>">
		<input type = "hidden" name= "tooth_no_hid" value = "<%=tooth_no_hid%>">
		<input type = "hidden" name= "condition_type_hid" value = "<%=condition_type_hid%>">
		<input type = "hidden" name= "gingival_status_code_hid" value = "<%=gingival_status_code_hid%>">
		<input type = "hidden" name= "status_hid" value = "<%=status_hid%>">
		<input type="hidden" name='chart_hdr_insert_yn' id='chart_hdr_insert_yn' value="" >

		<input type="hidden" name='clinical_group_code' id='clinical_group_code' value="" >
		<input type = "hidden" name= "clinical_group_hid" value = ""> 
		<input type = "hidden" name= "chart_type" value = "<%=chart_type%>">
		<input type = "hidden" name= "oh_chart_level" value = "<%=oh_chart_level%>">
		<input type = "hidden" name= "other_chart_facility_id" value = "<%=other_chart_facility_id%>">

		<input type="hidden" name= "gingival_recording_by" value = "<%=gingival_recording_by%>">
		<input type="hidden" name="gs_dflt_tooth_no_s1" id="gs_dflt_tooth_no_s1" value="<%=gs_dflt_tooth_no_s1%>">
		<input type="hidden" name="gs_dflt_tooth_no_s2" id="gs_dflt_tooth_no_s2" value="<%=gs_dflt_tooth_no_s2%>">
		<input type="hidden" name="gs_dflt_tooth_no_s3" id="gs_dflt_tooth_no_s3" value="<%=gs_dflt_tooth_no_s3%>">
		<input type="hidden" name="gs_dflt_tooth_no_s4" id="gs_dflt_tooth_no_s4" value="<%=gs_dflt_tooth_no_s4%>">
		<input type="hidden" name="gs_dflt_tooth_no_s5" id="gs_dflt_tooth_no_s5" value="<%=gs_dflt_tooth_no_s5%>">
		<input type="hidden" name="gs_dflt_tooth_no_s6" id="gs_dflt_tooth_no_s6" value="<%=gs_dflt_tooth_no_s6%>">
		<input type="hidden" name="other_facilitychart_yn" id="other_facilitychart_yn" value="<%=other_facilitychart_yn%>">
		<input type="hidden" name="baseline_chart_yn" id="baseline_chart_yn" value="<%=baseline_chart_yn%>">
		<!--Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457) -->
		<input type="hidden" name="status_before_after" id="status_before_after" value="<%=status_before_after%>">
		<input type="hidden" name="mapped_tooth_no" id="mapped_tooth_no" value="<%=mapped_tooth_no%>">
		<!-- -->
	</form>
			    
	<script>
	   loadToothNo('<%=val_tooth_no%>');
	</script>
			
</body>
</html>
 <%
   }catch ( Exception e ) {
	           e.printStackTrace() ;
    }finally {
	        try{
		         if(rs!=null) rs.close();
		         if(pstmt!=null) pstmt.close();
		          if(con!=null) 
			            ConnectionManager.returnConnection(con,request);
	                 }catch(Exception es){es.printStackTrace();}
      }
 %>

