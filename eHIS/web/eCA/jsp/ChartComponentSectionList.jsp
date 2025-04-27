<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eCA.ChartComponentFormulaBean,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<script src="../../eCommon/js/common.js" language='javascript'></script> 
		<script src="../../eCommon/js/ValidateControl.js" language='javascript'></script> 
		<script language="javascript" src="../js/ChartComponent.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		 <script>		
			

			function loadNextFrame(resultFrombean){
				if(i==0){
					var splitformulaVal = resultFrombean.split('~');
					for(j=1;j<splitformulaVal.length;j++){
						element = splitformulaVal[j-1];
						value = j+"|"+element;
						a[j] = value;
						i=i+1;
					}
				}
			}
		</script>
	
	<body onscroll='scrollTitle()' OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
	<form name=formulaComponentListForm>

	<%
		String sqlDisp = "";
		//String chart_id = "";
		String discr_msr_id = "";
		String panel_id = "'";
		String sec_desc = "";
		String discr_msr_desc = "";

		String formDefn = request.getParameter("formDefn")==null?"":request.getParameter("formDefn");
		String panel_desc_id = request.getParameter("panel_desc_id")==null?"":request.getParameter("panel_desc_id");
		StringTokenizer strDisp = new StringTokenizer(panel_desc_id,":");
		 strDisp.nextToken();
		panel_id = strDisp.nextToken();
		discr_msr_id = strDisp.nextToken();

		Connection con = null;
		PreparedStatement psDisp = null;
		ResultSet resDisp = null;

		
		try{
			con = ConnectionManager.getConnection(request);
			sqlDisp = "SELECT SECTION.short_desc sec_desc, discr_msr.short_desc discr_msr_desc FROM ca_chart_section a,am_discr_msr SECTION, am_discr_msr discr_msr WHERE a.panel_id = ? AND discr_msr.discr_msr_id = ? AND a.panel_id = SECTION.discr_msr_id";
			psDisp = con.prepareStatement(sqlDisp);
			psDisp.setString(1,panel_id);
			psDisp.setString(2,discr_msr_id);
			resDisp = psDisp.executeQuery();
			while(resDisp.next()){
				sec_desc = resDisp.getString("sec_desc");
				discr_msr_desc = resDisp.getString("discr_msr_desc");
			}
		/* modified}//end of try-1
		catch(Exception e){
			out.println("Exception in try-1 of ChartComponentSectionList.jsp"+e.toString());
		}
		finally{
			if(psDisp!=null) psDisp.close();
			if(resDisp!=null) resDisp.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		} */
	%>

	<div id='divDataTitle' style='postion:relative'> 
	<table border="1" id="finalDiv" cellpadding="3" cellspacing="0" width="100%" align="center">
	<tr>
		<td class='label' align="left"><font color='brown' size='2' style='font-weight:bold'><fmt:message key="eCA.DefineRedifineFormulaSection.label" bundle="${ca_labels}"/><%=sec_desc%> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.DiscreteMeasure.label" bundle="${common_labels}"/> :<%=discr_msr_desc%></font></td>
	</tr>
	 </table> 
	<!-- </div> 	
	<div id='divTableHeader' style='postion:relative'>  -->
	 <table border="1" cellpadding="3" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable"> 
	<tr>
		<th class='columnheader' width='40%' align="left"><fmt:message key="Common.PanelID.label" bundle="${common_labels}"/></th>
		<th class='columnheader' width='60%' align="left"><fmt:message key="Common.PanelDescription.label" bundle="${common_labels}"/></th>
	</tr>
	</table>
	</div>
	<table width='100%'>
	<%
	ChartComponentFormulaBean formulaBean  = (ChartComponentFormulaBean)session.getAttribute("formulaBean");

	String resultFrombean = "";	
	HashMap tabFormula = null;
	if(formulaBean != null)
	{
		tabFormula = formulaBean.returnFormulaTab();
		if(tabFormula != null)
			resultFrombean = ((String)tabFormula.get(panel_desc_id))==null ? "" :(String)formulaBean.fetchFormula(panel_desc_id) ;
		else
			resultFrombean = "";
	}
	//if (tabFormula!=null)
		//tabFormula.clear();
	%>
	<script>
		loadNextFrame("<%=resultFrombean%>");
	</script>
	<%
	PreparedStatement pstmtCompList = null;
	ResultSet resCompList = null;

	String sql = "";
	String panel_id_val = "";
	String display_order_seq = "";
	String panel_id_seq_no = "";
	String pa_disc_id_for_disp = "";

	/*modified try{ 
		con = ConnectionManager.getConnection(request);*/
		sql = "select a.panel_id||'_'||A.DISCR_MSR_ID, SECTION.short_desc||'-'||COMP.SHORT_DESC COMP_DESC from ca_chart_section_comp a, am_discr_msr SECTION, AM_DISCR_MSR COMP where a.chart_id = ? AND SECTION.DISCR_MSR_ID=A.PANEL_ID AND COMP.DISCR_MSR_ID=A.DISCR_MSR_ID AND (COMP.RESULT_TYPE IN ('N','I','A') or (COMP.RESULT_TYPE='L' and comp.ASSOCIATE_SCORE_YN='Y')) ORDER BY  A.PANEL_DISP_ORDER_SEQ, A.DISCR_DISP_ORDER_SEQ";	
		pstmtCompList = con.prepareStatement(sql);
		pstmtCompList.setString(1,formDefn);
		resCompList = pstmtCompList.executeQuery();
		while(resCompList.next()){
			panel_id_val = resCompList.getString(1)==null?"":resCompList.getString(1);
			display_order_seq = resCompList.getString(2)==null?"":resCompList.getString(2);
			panel_id_seq_no = panel_id_val+"!"+display_order_seq;	
			pa_disc_id_for_disp = panel_id + "_" + discr_msr_id;
			if(!(panel_id_val.equals(pa_disc_id_for_disp))){
	%>
			<tr>
				<td width='40%'><a href='javascript:onClickOfPID("<%=panel_id_seq_no%>")'><%=panel_id_val%></a></td>
				<td width='60%'><%=display_order_seq%></td>
			</tr>
		<%
			}
		}
		if(resCompList!=null) resCompList.close();
		if(pstmtCompList!=null) pstmtCompList.close();
	}//end of try-1
	catch(Exception e){
		//out.println("Exception in try of ChartComponentSectionList.jsp"+e.toString());//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
	}
	finally{
		if(resDisp!=null) resDisp.close();
		if(psDisp!=null) psDisp.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
		%>		
	</table>
	<input type='hidden' name='panel_desc_id' id='panel_desc_id' value='<%=panel_desc_id%>'>
	</form>
	<script>setTimeout("dummy()",300);</script>
	<!-- <script>
		function dummy(){
			parent.chartSectionFormulaConstructionFrame.document.location.href = '../../eCA/jsp/ChartComponentFormulaConstruction.jsp';
		}
	</script> -->
	</body>
</html>



