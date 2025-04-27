<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eOH/js/PerioCompareChart.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

</head>
</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form name="ChartingComponentsForm" id="ChartingComponentsForm" id="comp">
<table width="100%" cellpadding =0 cellspacing=0 border=1>
<th class="HEADERTITLE"><fmt:message key="Common.Components.label" bundle="${common_labels}"/></th>
<%
	String selected_val1=checkForNull(request.getParameter("selected_val1"));
	String selected_val2=checkForNull(request.getParameter("selected_val2"));
	String selected_val3=checkForNull(request.getParameter("selected_val3"));
	String no_of_charts=checkForNull(request.getParameter("no_of_charts"));
	String chart_code = checkForNull(request.getParameter("chart_code"));
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	StringBuilder sbr = new StringBuilder();
	//String SQL = "SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF from OH_PERDONTAL_CHRT_COMP_LANG_VW WHERE LANGUAGE_ID=? AND COMPONENT_CODE IN (SELECT COMPONENT_CODE FROM OH_PERIODONTAL_CHART_COMP WHERE FORMULA_YN = 'N')";
	String SQL="SELECT A.COMPONENT_CODE, B.COMPONENT_SHORT_DESC_USER_DEF FROM OH_PERIODONTAL_CHART_DEF_DTL A, OH_PERDONTAL_CHRT_COMP_LANG_VW B WHERE A.CHART_CODE=? AND B.LANGUAGE_ID=? AND A.COMPONENT_CODE=B.COMPONENT_CODE ORDER BY B.SURFACES_APPL_YN, B.COMPONENT_SHORT_DESC_USER_DEF";
	try{
			con=ConnectionManager.getConnection(request);
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1,chart_code);
			pstmt.setString(2,locale);
			rs=pstmt.executeQuery();
			int i=0;
			String qryval="";
			while(rs.next()){
			  ++i;
			  qryval=(i%2==0)?"QRYEVENSMALL":"QRYODDSMALL";	
			  sbr.append("<TR>");
			  sbr.append("<TD CLASS='"+qryval+"'>");
			  sbr.append("<INPUT TYPE='checkbox' name='"+rs.getString(2)+"' id='"+rs.getString(2)+"' value="+rs.getString(1)+" checked>");
			  sbr.append("&nbsp;");
			  sbr.append(rs.getString(2));
			  sbr.append("</TD>");
			  sbr.append("</TR>");
		 }

		 if(i>0){
			 sbr.append("<TR align='center'>");
			 sbr.append("<TD CLASS='"+qryval+"'>");
			 sbr.append("<INPUT TYPE='button' class='DIRDISPBUTTON2' name='btncompare' id='btncompare' value='Compare'  onClick='callChartDisplay();'>" );
			 sbr.append("</TD>");
			 sbr.append("</TR>");
			  sbr.append("<TR align='center'>");
			 sbr.append("<TD>");
			 //sbr.append("<A HREF='><img  align='center' src='../../eCA/images/graph.gif'>ViewGraph</A>" );
			 //sbr.append("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='showGraphDialog();' ><img  align='center' src='../../eCA/images/graph.gif'>ViewGraph</font>" );
			 //Commented by rajesh for CRF-474 as instructed by DR Archana on 12/03/2010
			 //sbr.append("<a href='javascript:showGraphDialog();'><img  align='center' src='../../eCA/images/graph.gif'>View Graph</a>" );
			 //sbr.append("</TD>");
			 //sbr.append("</TR>");
			 out.println(sbr.toString());
		 }
	}catch(Exception e){
		System.err.println("Err Msg From PerioCompareChartingComponents"+e.getMessage());
	}finally{
		try{
			 sbr.setLength(0);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		}catch(Exception es){es.printStackTrace();}
	}
%>
</TABLE>
	<input type = "hidden" name= "selected_val1" value = "<%=selected_val1%>">
	<input type = "hidden" name= "selected_val2" value = "<%=selected_val2%>">
	<input type = "hidden" name= "selected_val3" value = "<%=selected_val3%>">
	<input type = "hidden" name= "no_of_chart" value = "<%=no_of_charts%>">

</FORM>
</body>
</HTML>

