<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<html>
	<head>
		<title><fmt:message key="eOH.PerioCustomGraph.label" bundle="${oh_labels}"/></title>
		<%


		request.setCharacterEncoding("UTF-8");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale = (String)session.getAttribute("LOCALE"); 
		String patient_id=checkForNull(request.getParameter("patient_id"));
		String chart_num=checkForNull(request.getParameter("chart_num1"));
		String chart_num2=checkForNull(request.getParameter("chart_num2"));
		String chart_num3=checkForNull(request.getParameter("chart_num3"));
		String chart_line_num="";
		String chart_line_num2="";
		String chart_line_num3="";
		String chart_code=checkForNull(request.getParameter("chart_code"));
		String val_type=checkForNull(request.getParameter("val_type"));
		String tooth_numbering_system=checkForNull(request.getParameter("tooth_numbering_system"));
		String permanent_deciduous_flag=checkForNull(request.getParameter("permanent_deciduous_flag"));
		String perio_arch=checkForNull(request.getParameter("perio_arch"));
		String eval_chart_date1=checkForNull(request.getParameter("eval_chart_date1"));
		String eval_chart_date2=checkForNull(request.getParameter("eval_chart_date2"));
		String eval_type=checkForNull(request.getParameter("eval_type"));
		String no_of_charts=checkForNull(request.getParameter("no_of_charts"));
		String quadrant=checkForNull(request.getParameter("quadrant"));
		if(eval_type.equals("BB")){
			chart_line_num="1";
			chart_line_num2="1";
			chart_line_num3="1";
		}else{
			chart_line_num=checkForNull(request.getParameter("chart_line_num1"));	
			chart_line_num2=checkForNull(request.getParameter("chart_line_num2"));
			chart_line_num3=checkForNull(request.getParameter("chart_line_num3"));
		}
	
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="javascript" src="../../eOH/js/PerioChart.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script>

function loadGraph(){
		var formObj = document.forms[0];
		var comp_code=formObj.component_code.value;
		if(comp_code==""){
			alert(getMessage("APP-OH00064",'OH'));
			return false
		}else{
				var comp_code_arr=comp_code.split("##");
				var patient_id=formObj.patient_id.value;
				var chart_num1=formObj.chart_num1.value;
				var chart_num2=formObj.chart_num2.value;
				var chart_num3=formObj.chart_num3.value;
				var chart_line_num1=formObj.chart_line_num1.value;
				var chart_line_num2=formObj.chart_line_num2.value;
				var chart_line_num3=formObj.chart_line_num3.value;
				var chart_code=formObj.chart_code.value;
				var val_type=formObj.val_type.value;
				var perio_arch=formObj.perio_arch.value;
				var tooth_numbering_system=formObj.tooth_numbering_system.value;
				var permanent_deciduous_flag=formObj.permanent_deciduous_flag.value;
				var eval_type=formObj.eval_type.value;
				var eval_chart_date1=formObj.eval_chart_date1.value;
				var eval_chart_date2=formObj.eval_chart_date2.value;
				var no_of_charts=formObj.no_of_charts.value;
				var quadrant=formObj.quadrant.value;
				var params = "patient_id="+patient_id+"&chart_num1="+chart_num1+"&chart_num2="+chart_num2+"&chart_num3="+chart_num3+"&chart_line_num1="+chart_line_num1+"&chart_line_num2="+chart_line_num2+"&chart_line_num3="+chart_line_num3+"&chart_code="+chart_code+"&perio_arch="+perio_arch+"&tooth_numbering_system="+tooth_numbering_system+"&components="+comp_code_arr[0]+"&val_type="+val_type+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&eval_chart_date1="+eval_chart_date1+"&eval_chart_date2="+eval_chart_date2+"&eval_type="+eval_type+"&surfface_appl_yn="+comp_code_arr[1]+"&no_of_charts="+no_of_charts+"&quadrant="+quadrant;
				if(comp_code_arr[1]=="N"){
					parent.frames[2].document.location.href="../../eOH/jsp/PerioCompareBuccalGraph.jsp?"+params;
					parent.frames[3].document.location.href="../../eOH/jsp/PerioCompareGraphBuccalTableView.jsp?"+params;
					parent.frames[4].document.location.href="../../eCommon/html/blank.html?"+params;
					parent.frames[5].document.location.href="../../eCommon/html/blank.html?"+params;
				}else{
					parent.frames[2].document.location.href="../../eOH/jsp/PerioCompareBuccalGraph.jsp?"+params;
					parent.frames[3].document.location.href="../../eOH/jsp/PerioCompareGraphBuccalTableView.jsp?"+params;
					parent.frames[4].document.location.href="../../eOH/jsp/PerioComparePalatalGraph.jsp?"+params;
					parent.frames[5].document.location.href="../../eOH/jsp/PerioCompareGraphPalatalTableView.jsp?"+params;
				}
			}
		}
</script>
</head>
	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
		<form id='comp' name='perioCompareListForm' id='perioCompareListForm'>
<table cellpadding='0' cellspacing='0' border='0' width='100%' style="background-color:#F5BDFF">
<tr style="background-color:#F5BDFF">
	<td class=label style="background-color:#F5BDFF"><fmt:message key="Common.Component.label" bundle="${common_labels}"/></td>
	<td><select name="component_code" id="component_code"> 
	<option value='' selected>----------
		<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
   
<% 
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="";
	String comp_code="";
	String comp_desc="";
	String surface_appl_yn="";
try
      {
        con=ConnectionManager.getConnection(request);
		
		sql="SELECT A.COMPONENT_CODE, B.COMPONENT_SHORT_DESC_USER_DEF, B.SURFACES_APPL_YN FROM OH_PERIODONTAL_CHART_DEF_DTL A, OH_PERDONTAL_CHRT_COMP_LANG_VW B WHERE A.CHART_CODE	=? AND B.LANGUAGE_ID=? AND A.COMPONENT_CODE	=B.COMPONENT_CODE ORDER BY B.COMPONENT_SHORT_DESC_USER_DEF";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,chart_code);
		pstmt.setString(2,locale);
		rs = pstmt.executeQuery();
		if(rs!=null)
		{
		   while(rs.next())
		        {
			        comp_code=rs.getString(1);
			        comp_desc=rs.getString(2);
			        surface_appl_yn=rs.getString(3);
					comp_code=comp_code+"##"+surface_appl_yn;
                    %>	
	               <option value="<%=comp_code%>"><%=comp_desc%>
            <%  }
	  }
	 }catch(Exception e){out.println("exp"+e);}

	  finally{
	try{
		
	 if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(con);
	}catch(Exception e)
		{
		out.println("exp"+e);
		}
}
%>

</td>
<td><img  align='center' src='../../eCA/images/graph.gif' onclick='loadGraph()' title='Show Graph' value=''>&nbsp;&nbsp; Custom View</td>
<td>&nbsp;</td>
</tr>
</table>
<input type="hidden" name="patient_id" id="patient_id"	value="<%=patient_id%>" >
<input type="hidden" name="chart_num1" id="chart_num1"	value="<%=chart_num%>" >
<input type="hidden" name="chart_num2" id="chart_num2"	value="<%=chart_num2%>" >
<input type="hidden" name="chart_num3" id="chart_num3"	value="<%=chart_num3%>" >
<input type="hidden" name="chart_code" id="chart_code"	value="<%=chart_code%>" >
<input type="hidden" name="quadrant" id="quadrant"	value="<%=quadrant%>" >
<input type="hidden" name="chart_line_num1" id="chart_line_num1"	value="<%=chart_line_num%>" >
<input type="hidden" name="chart_line_num2" id="chart_line_num2"	value="<%=chart_line_num2%>" >
<input type="hidden" name="chart_line_num3" id="chart_line_num3"	value="<%=chart_line_num3%>" >
<input type="hidden" name="eval_chart_date1" id="eval_chart_date1"	value="<%=eval_chart_date1%>" >
<input type="hidden" name="eval_chart_date2" id="eval_chart_date2"	value="<%=eval_chart_date2%>" >
<input type="hidden" name="perio_arch" id="perio_arch"	value="<%=perio_arch%>" >
<input type="hidden" name="val_type" id="val_type"	value="<%=val_type%>" >
<input type="hidden" name="eval_type" id="eval_type"	value="<%=eval_type%>" >
<input type="hidden" name="no_of_charts" id="no_of_charts"	value="<%=no_of_charts%>" >
<input type="hidden" name="tooth_numbering_system" id="tooth_numbering_system"	value="<%=tooth_numbering_system%>" >
<input type="hidden" name="permanent_deciduous_flag" id="permanent_deciduous_flag"	value="<%=permanent_deciduous_flag%>" >

</form>
</body>
</html>


