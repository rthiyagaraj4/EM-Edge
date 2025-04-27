<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String chart_code =checkForNull(request.getParameter( "chart_code" )) ;
	String perio_chart =checkForNull(request.getParameter( "perio_chart" )) ;

	chart_code=chart_code==null?perio_chart:chart_code;
	chart_code=chart_code.equals("null")?perio_chart:chart_code;
	chart_code=chart_code.equals("")?perio_chart:chart_code;
	String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
	String chart_line_num =checkForNull(request.getParameter( "chart_line_num" )) ;
	String called_from_BC_EV_yn =checkForNull(request.getParameter( "called_from_BC_EV_yn" )) ;
	called_from_BC_EV_yn=called_from_BC_EV_yn==null?"N":called_from_BC_EV_yn;
	called_from_BC_EV_yn=called_from_BC_EV_yn.equals("null")?"N":called_from_BC_EV_yn;
	called_from_BC_EV_yn=called_from_BC_EV_yn.equals("")?"N":called_from_BC_EV_yn;
	String index_desc = "" ;
	String index_code = "" ;
	String index_cut_off_value = "" ;
	String value = checkForNull(request.getParameter( "value" )) ;
	String tooth_nos = "";
	String teethwith_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TeethWith.Label","oh_labels");
	String display_index_desc="";

	HashMap tooth_map=new HashMap();
	StringBuffer component_display_text = new StringBuffer() ;
	%>
<title>
<fmt:message key="Common.Summary.label" bundle="${common_labels}"/>
</title>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eOH/js/OHSummary.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form >
			
<table align='center' cellpadding='3' cellspacing='0' border='0' width='100%'>
<%
		if(called_from_BC_EV_yn.equals("Y")){// In the Baseline/Evaluation Screen
%>
			<tr>
				<td class="CAGROUPHEADING" width="100%">
					<fmt:message key="Common.Summary.label" bundle="${common_labels}"/>
				</td>
			</tr>
<%
		}
	try{
		con=ConnectionManager.getConnection(request);
		// Query for Indexes
		pstmt=con.prepareStatement("SELECT A.INDEX_CODE, B.INDEX_DESC, B.INDEX_CUT_OFF_VALUE, A.VALUE FROM OH_PERIODONTAL_CHART_SUMMARY A, OH_INDEXES B WHERE  A.PATIENT_ID= ? AND A.CHART_NUM= ? AND A.CHART_CODE= ? AND	  A.CHART_LINE_NUM= ? AND A.INDEX_YN	= ? AND A.INDEX_CODE= B.INDEX_CODE");
		pstmt.setString(1,patient_id);
		pstmt.setString(2,chart_num);
		pstmt.setString(3,chart_code);
		pstmt.setString(4,chart_line_num);
		pstmt.setString(5,"Y");
		rs = pstmt.executeQuery();	  

		while(rs!= null && rs.next()){
			index_code = rs.getString("INDEX_CODE");		
			index_desc = rs.getString("INDEX_DESC"); 
			index_cut_off_value = rs.getString("INDEX_CUT_OFF_VALUE");		
			value = rs.getString("VALUE");	
			if(index_cut_off_value!=null && !index_cut_off_value.equals("null") && !index_cut_off_value.equals("")){
				if(index_code.equals("BLDIND") || index_code.equals("PLQIND") ||  index_code.equals("CALIND")|| index_code.equals("OHIIND") || index_code.equals("DEBIND")){

					display_index_desc = index_desc+"("+index_cut_off_value+"%)";
				}else{				
					display_index_desc = index_desc+"("+index_cut_off_value+")";
				}
			}else{
				display_index_desc = index_desc;
			}
			
			if(called_from_BC_EV_yn.equals("N")){// In the Summary tab
		%>			
				<tr>
					<td class="label" width='10%'></td>
					<td class="label" width='90%' style='text-align:left'>
						<%=display_index_desc%> <%=value%>
					</td>
				</tr>				
		<%			
			}else{ // In the Baseline/Evaluation chart display
		%>
				<tr>
					<td class="label" width='100%' style='text-align:left'>
						<%=display_index_desc%> <%=value%>
					</td>
				</tr>				
		<%
			}
		}
		%>
				<tr></tr>
				<tr></tr>
				<tr></tr>
		<%
		
		// Get All the NS Tooth Numbers
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

		pstmt=con.prepareStatement("SELECT TOOTH_NO,NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE NUMBERING_SYSTEM=? ORDER BY TOOTH_NO");
		pstmt.setString(1,tooth_numbering_system);
		rs=pstmt.executeQuery();
		while(rs.next()){
			tooth_map.put(rs.getString("TOOTH_NO"),rs.getString("NS_TOOTH_NO"));
		}
			
		// Query for Components
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

		pstmt=con.prepareStatement("SELECT A.COMPONENT_CODE, B.COMPONENT_SHORT_DESC_USER_DEF, B.CUT_OFF, A.TOOTH_NOS FROM OH_PERIODONTAL_CHART_SUMMARY A, OH_PERIODONTAL_CHART_COMP B WHERE  A.PATIENT_ID	= ? AND A.CHART_NUM= ? AND A.CHART_CODE= ? AND A.CHART_LINE_NUM= ? AND	 A.INDEX_YN= ? AND A.COMPONENT_CODE= B.COMPONENT_CODE ORDER BY COMPONENT_CODE");
		pstmt.setString(1,patient_id);
		pstmt.setString(2,chart_num);
		pstmt.setString(3,chart_code);
		pstmt.setString(4,chart_line_num);
		pstmt.setString(5,"N");
		rs = pstmt.executeQuery();

		String component_desc = "";
		String component_code = "";
		String cutt_off = "";
		String[] tooth_nos_arr = null;

	    while(rs!= null && rs.next()){
			component_display_text.setLength(0);
			component_code	= rs.getString("COMPONENT_CODE");	
			component_desc	= rs.getString("COMPONENT_SHORT_DESC_USER_DEF");
			cutt_off		= rs.getString("CUT_OFF");
			if(!component_code.equals("MITH") && !component_code.equals("FOI") && !component_code.equals("LOC") && !component_code.equals("BOP") && !component_code.equals("PLA") && !component_code.equals("SUP")){
				if(cutt_off!=null && !cutt_off.equals("null") && !cutt_off.equals("")){
					component_display_text.append(teethwith_legend);
					component_display_text.append(" ");
					component_display_text.append(component_desc);
					component_display_text.append(" >= (");
					component_display_text.append(cutt_off);
					component_display_text.append(")mm :   ");
				}else{
					component_display_text.append(teethwith_legend);
					component_display_text.append(" ");
					component_display_text.append(component_desc);
					component_display_text.append(" :   ");
				}
			}
			else{ //Legend for Missing tooth
				if(cutt_off!=null && !cutt_off.equals("null") && !cutt_off.equals("")){
					component_display_text.append(" ");
					component_display_text.append(component_desc);
					component_display_text.append(" : ");
				}else{
					component_display_text.append(component_desc);
					component_display_text.append(" : ");
				}
			}
			tooth_nos	= rs.getString("TOOTH_NOS");
			tooth_nos_arr = tooth_nos.split("#");
		
			int z=0;
			for(int i=0;i<tooth_nos_arr.length;i++){
				if(z==0){
					component_display_text.append((String)tooth_map.get(tooth_nos_arr[i]));
				}else{
					component_display_text.append(",");
					component_display_text.append((String)tooth_map.get(tooth_nos_arr[i]));
				}
				z++;
			}	
			if(called_from_BC_EV_yn.equals("N")){// In the Summary tab
		%>			
				<tr>
					<td class="label" width='10%'></td>
					<td class="label" width='90%' style='text-align:left'>
						<%=component_display_text.toString()%>
					</td>
				</tr>				
		<%			
			}else{ // In the Baseline/Evaluation chart display
		%>
				<tr>
					<td class="label" width='100%' style='text-align:left'>
						<%=component_display_text.toString()%>
					</td>
				</tr>				
		<%
			}
		}		
    %>

</table> 				 
</form>
</body>
</html>
<%
	}catch ( Exception e ) {
		e.printStackTrace() ;
	}finally {
		try{
			tooth_map.clear();
			component_display_text.setLength(0);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) 
				ConnectionManager.returnConnection(con,request);
		}catch(Exception es)
			{es.printStackTrace();}
	}
%>


