<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>


<%
	 String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8");
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String patient_id=checkForNull(request.getParameter("patient_id"));
	String chart_num=checkForNull(request.getParameter("chart_num"));
	String chart_line_num=checkForNull(request.getParameter("chart_line_num"));
	String chart_code=checkForNull(request.getParameter("chart_code"));
	String perio_arch=checkForNull(request.getParameter("perio_arch"));
	String tooth_numbering_system=checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag=checkForNull(request.getParameter("permanent_deciduous_flag"));
	String comp_code="";

%>
<html>
	<head>
		<title><fmt:message key="eOH.PerioCustomGraph.label" bundle="${oh_labels}"/></title>
		
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="javascript" src="../../eOH/js/PerioChart.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>


		function storeVal(currad) {
				document.forms[0].radio_val.value=currad.value;
			}
			function getSelectedChkBox(arrObj) {
					var getstr = "";
					var cnt = 0;
					for (i=0; i<arrObj.length; i++) {
					   if (arrObj[i].type == "checkbox") {
						   if (arrObj[i].checked) {
								cnt++;
								if(cnt==1)
									getstr+= "'"+arrObj[i].value+"'";
								else
									getstr+= ",'"+arrObj[i].value+"'";
							}
					   }
					}
					return getstr;
			}
	
			function loadGraph(){
				var formObj = document.forms[0];
				var arrObj = document.getElementById('comp')?.elements;
				var getstr =getSelectedChkBox(arrObj);
				/*if(getstr.length==0){
					alert(getMessage("APP-OH00064",'OH'));
					return false
				}*/
				//var pd_val=formObj.pdVal.value;
				//var cal_val=formObj.calVal.value;
				//var cej_val=formObj.cejVal.value;
				var patient_id=formObj.patient_id.value;
				var sel_radio_val=formObj.radio_val.value
				if(sel_radio_val==""){
					sel_radio_val="PD"
				}
				var getstr="'"+sel_radio_val+"'";
				var chart_num=formObj.chart_num.value;
				var chart_line_num=formObj.chart_line_num.value;
				var chart_code=formObj.chart_code.value;
				var perio_arch=formObj.perio_arch.value;
				var tooth_numbering_system=formObj.tooth_numbering_system.value;
				var permanent_deciduous_flag=formObj.permanent_deciduous_flag.value;
				var load_flag="2";
				var temp_getstr="";	
				if(sel_radio_val=="CAL"){
					temp_getstr="'CEJ',"+getstr;
				}else if(sel_radio_val=="CEJ"){
					//temp_getstr="'CAL',"+getstr;
					temp_getstr=getstr+",'PD'";
				}else if(sel_radio_val=="PD"){
					temp_getstr=getstr+",'CAL'";
				}
				
				var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&chart_code="+chart_code+"&perio_arch="+perio_arch+"&tooth_numbering_system="+tooth_numbering_system+"&components="+temp_getstr+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&pd_val=PD&cal_val=CAL&cej_val=CEJ&load_flag="+load_flag+"&sel_radio_val="+sel_radio_val;
				var param = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&chart_code="+chart_code+"&perio_arch="+perio_arch+"&tooth_numbering_system="+tooth_numbering_system+"&components="+getstr+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&pd_val=PD&cal_val=CAL&cej_val=CEJ&load_flag="+load_flag+"&sel_radio_val="+sel_radio_val;
				parent.frames[2].document.location.href="../../eOH/jsp/PerioBuccalGraph.jsp?"+params;
				parent.frames[3].document.location.href="../../eOH/jsp/PerioGraphBuccalTableView.jsp?"+param;
				parent.frames[4].document.location.href="../../eOH/jsp/PerioPalatalGraph.jsp?"+params;
				parent.frames[5].document.location.href="../../eOH/jsp/PerioGraphPalatalTableView.jsp?"+param;
			}

		</script>
	</head>
	<body style='background-color:#E2E3F0;' OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
		<form id='comp' name='perioGraphDispForm' id='perioGraphDispForm'>
			<table cellpadding='0' cellspacing='0' border='1' width='100%'>
			<%
				Connection con=null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				StringBuilder sbr = new StringBuilder();
				String sql;
				try{
					con=ConnectionManager.getConnection(request);
					sql="SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF FROM OH_PERDONTAL_CHRT_COMP_LANG_VW WHERE COMPONENT_CODE IN  ('PD','CEJ','CAL') AND LANGUAGE_ID = ?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,locale);
					rs=pstmt.executeQuery();
					int i=0;
					String qryval="QRYODDSMALL";
					while(rs.next()){
					  ++i;
					  comp_code=rs.getString(1);
					  sbr.append("<TD CLASS='"+qryval+"'>");
					  if(comp_code.equals("PD")){
						  sbr.append("<INPUT TYPE='RADIO' name='base' id='base' value="+comp_code+"  onclick=storeVal(this) checked>");
					  }else{
						sbr.append("<INPUT TYPE='RADIO' name='base' id='base' value="+comp_code+"  onclick=storeVal(this)>");					  
					  }
	  				  sbr.append("&nbsp;");
					  sbr.append(rs.getString(2));
					  sbr.append("</TD>");
					 }
					 if(i>0){
					  sbr.append("<TD CLASS='"+qryval+"'>");
					  sbr.append("</TD>");
					  sbr.append("<TD CLASS='"+qryval+"'>");
					  sbr.append("<img  align='center' src='../../eCA/images/graph.gif' onclick='loadGraph()' title='Show Graph' value=''>&nbsp;&nbsp; Custom View");
					  sbr.append("&nbsp;");
					  sbr.append("</TD>");

						 out.println(sbr.toString());
					 }
		
				}catch(Exception e){
					System.err.println("Err Msg From PerioCompareGraphList.jsp : "+e.getMessage());
				}finally{
					try{
						 sbr.setLength(0);
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(con!=null) con.close();
					}catch(Exception es){es.printStackTrace();}
				}

			%>
			</table>
			<input type="hidden" name="patient_id" id="patient_id"	value="<%=patient_id%>" >
			<input type="hidden" name="chart_num" id="chart_num"	value="<%=chart_num%>" >
			<input type="hidden" name="chart_code" id="chart_code"	value="<%=chart_code%>" >
			<input type="hidden" name="chart_line_num" id="chart_line_num"	value="<%=chart_line_num%>" >
			<input type="hidden" name="perio_arch" id="perio_arch"	value="<%=perio_arch%>" >
			<input type="hidden" name="radio_val" id="radio_val"	value="" >
			<input type="hidden" name="tooth_numbering_system" id="tooth_numbering_system"	value="<%=tooth_numbering_system%>" >
			<input type="hidden" name="permanent_deciduous_flag" id="permanent_deciduous_flag"	value="<%=permanent_deciduous_flag%>" >
		</form>
	</body>
</html>


