<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@ page import ="java.net.URLDecoder,java.lang.StringBuffer,java.text.ParseException,java.sql.Connection,java.sql.Timestamp,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<% 
//  File created By Yadav to Display Maxila prosthesis Details  conditions on 2/17/2010 for 476
request.setCharacterEncoding("UTF-8");	
java.util.Properties prop = null;
String client_ip_address="";
String facility_id = (String)session.getValue("facility_id") ;
String login_user=""; 
String locale = (String)session.getAttribute("LOCALE"); 
String title=checkForNull(request.getParameter("heading"));
String patient_id = request.getParameter("patient_id"); 
String chart_num = request.getParameter("chart_num"); 
String header_tab = request.getParameter("header_tab"); 
String oh_chart_level = request.getParameter("oh_chart_level"); 
String tooth_numbering_system = request.getParameter("tooth_numbering_system"); 

prop = (java.util.Properties) session.getValue( "jdbc" ) ;
client_ip_address = prop.getProperty( "client_ip_address" );
login_user = prop.getProperty( "login_user" );
Connection con=null;
PreparedStatement pstmt=null;
PreparedStatement pstmt1=null;
ResultSet rs=null;		
ResultSet rs1=null;		
String sql="";

String headerLabel="";
String CondnTrmtCategoryType="";
if(header_tab.equals("T"))
{
headerLabel= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Treatment.Label","OH");
CondnTrmtCategoryType = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentType.Label","OH");
}else if(header_tab.equals("C"))
{
headerLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Conditions.Label","OH");
CondnTrmtCategoryType = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ConditionType.Label","OH");
}


%>
<HTML>
<HEAD>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

<script lanaguage='javascript'>
	function windowClosing()
	{
		 	window.close();	
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<TITLE><%=title%></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</HEAD>

<body topmargin='0' leftmargin='0' class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
<form>
<table width="100%">
<tr>
	<td class='MESSAGE' align='right'>
		
	<input type='button' class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="window.close()">
		
</td>
</tr></table>
<div id="listContentLayer" style="display:block;visibility:visible;overflow-y: scroll;height:200;width:900;border: 1px outset #9999FF" align="center">
<table align='center' cellpadding='4' cellspacing='' border='1' width='100%' class='grid' >
<tr >
		<td align="center" colspan="9" class='CAGROUPHEADING'><%=headerLabel%></td>	
		
</tr>
<tr > 
		<th><%=CondnTrmtCategoryType%></th>	
		<th><%=headerLabel%></th>	
		<% if(header_tab.equals("T"))
			{ %>
			<th><fmt:message key='Common.status.label' bundle='${common_labels}'/></td>
			<%}%>
		<% if(header_tab.equals("C"))
			{ %>
			<th><fmt:message key='eOH.Parts.Label' bundle='${oh_labels}'/></th>
			<th>Sub-<fmt:message key='eOH.Parts.Label' bundle='${oh_labels}'/></th>
			<th><fmt:message key="Common.Site.label" bundle="${common_labels}"/></th>
			<%}%>
		<th><fmt:message key='eOH.ToothNo.Label' bundle='${oh_labels}'/></th>	
		<th><fmt:message key='Common.remarks.label' bundle='${common_labels}'/></th>	
		<th><fmt:message key='eOH.RecordedBy.Label' bundle='${oh_labels}'/></th>	
		<th><fmt:message key='Common.date.label' bundle='${common_labels}'/></th>	
	
		
</tr>
 <%
 try{
	   String condnTrmt_type="";	
	   String condnTrmt_desc="";	
	   String tooth_no="";
	   String remark="";
	   String condn_date="";
	   String style="";
	   String status="";
	   String added_by="";
	   String organCode="";
	   String suborganCode="";
	   String siteType="";
	   String super_key_val="";
	  
	   int count=0;
	   con = ConnectionManager.getConnection(request);	
		 //The below code gets the CONDITION_TYPE and Treatment_type from OH_RESTORATIVE_CHART_DTL table based on Tab
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(header_tab.equals("C")){
			if(oh_chart_level.equals("E")){
				sql="SELECT  a.SUPER_KEY_NUM, c.CONDITION_TYPE_DESC,b.CONDITION_DESC,a.TOOTH_NO,TO_CHAR(a.TREATMENT_CONDITION_DATE,'DD/MM/YYYY HH24:MI') TREATMENT_CONDITION_DATE,a.REMARKS,a.ADDED_BY_ID,a.ORGAN_CODE,a.SUB_ORGAN_CODE, d.SITE_DESC FROM OH_RESTORATIVE_CHART_DTL a,OH_CONDITION_LANG_VW b,OH_CONDITION_TYPE_LANG_VW c,OH_SITE_TYPE_LANG d WHERE a.CONDITION_CODE = b.CONDITION_CODE and a.CONDITION_TYPE=b.CONDITION_TYPE and b.CONDITION_TYPE=c.CONDITION_TYPE and a.SITE_TYPE=d.SITE_TYPE and  a.PATIENT_ID=? AND a.CHART_NUM = ? AND a.CONDITION_TYPE IN('MALPOSN','MALOCLN','MXNTL') and b.LANGUAGE_ID = ? and b.LANGUAGE_ID=c.LANGUAGE_ID AND c.LANGUAGE_ID=d.LANGUAGE_ID and nvl(a.STATUS,'X')<>'E' order by  a.TREATMENT_CONDITION_DATE desc,a.TOOTH_NO desc";
			}else if(oh_chart_level.equals("F")){
				 sql="SELECT  a.SUPER_KEY_NUM, c.CONDITION_TYPE_DESC,b.CONDITION_DESC,a.TOOTH_NO,TO_CHAR(a.TREATMENT_CONDITION_DATE,'DD/MM/YYYY HH24:MI') TREATMENT_CONDITION_DATE,a.REMARKS,a.ADDED_BY_ID,a.ORGAN_CODE,a.SUB_ORGAN_CODE, d.SITE_DESC FROM OH_RESTORATIVE_CHART_DTL a,OH_CONDITION_LANG_VW b,OH_CONDITION_TYPE_LANG_VW c,OH_SITE_TYPE_LANG d WHERE a.CONDITION_CODE = b.CONDITION_CODE and a.CONDITION_TYPE=b.CONDITION_TYPE and b.CONDITION_TYPE=c.CONDITION_TYPE and a.SITE_TYPE=d.SITE_TYPE and  a.PATIENT_ID=? AND a.CHART_NUM = ? AND a.CONDITION_TYPE IN('MALPOSN','MALOCLN','MXNTL') and b.LANGUAGE_ID = ? and b.LANGUAGE_ID=c.LANGUAGE_ID AND c.LANGUAGE_ID=d.LANGUAGE_ID and a.OPERATING_FACILITY_ID=? and nvl(a.STATUS,'X')<>'E' order by  a.TREATMENT_CONDITION_DATE desc,a.TOOTH_NO desc";
			}
		}
		else if (header_tab.equals("T")){
			if(oh_chart_level.equals("E")){
				sql="SELECT a.SUPER_KEY_NUM, c.TRMT_CATEGORY_TYPE_DESC,b.TRMT_DESC,D.SHORT_DESC STATUS,a.TOOTH_NO,TO_CHAR(a.TREATMENT_CONDITION_DATE,'DD/MM/YYYY HH24:MI') TREATMENT_CONDITION_DATE, a.REMARKS,a.ADDED_BY_ID FROM OH_RESTORATIVE_CHART_DTL a, OH_TREATMENT_LANG_VW  b , OH_TRTMT_CATEGORY_TYPE_LANG_VW c ,OR_ORDER_STATUS_CODE_LANG_VW D WHERE a.TRMT_CODE=b.TRMT_CODE and a.TRMT_CATEGORY_CODE=b.TRMT_CATEGORY_CODE and b.TRMT_CATEGORY_CODE =b.TRMT_CATEGORY_CODE and a.TRMT_CATEGORY_TYPE =c.TRMT_CATEGORY_TYPE and b.LANGUAGE_ID = c.LANGUAGE_ID AND C.LANGUAGE_ID  = D.LANGUAGE_ID AND A.STATUS  = D.ORDER_STATUS_CODE AND a.PATIENT_ID= ? AND a.CHART_NUM = ? AND a.TRMT_CATEGORY_TYPE IN('MAXILLA')  and TREATMENT_INT_EXT ='I' and b.LANGUAGE_ID  = ?  and nvl(a.STATUS,'X')<>'E' order by  a.TREATMENT_CONDITION_DATE desc,a.TOOTH_NO desc";
			}else if(oh_chart_level.equals("F")){
				sql="SELECT a.SUPER_KEY_NUM, c.TRMT_CATEGORY_TYPE_DESC,b.TRMT_DESC,D.SHORT_DESC STATUS,a.TOOTH_NO,TO_CHAR(a.TREATMENT_CONDITION_DATE,'DD/MM/YYYY HH24:MI') TREATMENT_CONDITION_DATE, a.REMARKS,a.ADDED_BY_ID FROM OH_RESTORATIVE_CHART_DTL a, OH_TREATMENT_LANG_VW  b , OH_TRTMT_CATEGORY_TYPE_LANG_VW c ,OR_ORDER_STATUS_CODE_LANG_VW D WHERE a.TRMT_CODE=b.TRMT_CODE and a.TRMT_CATEGORY_CODE=b.TRMT_CATEGORY_CODE and b.TRMT_CATEGORY_CODE =b.TRMT_CATEGORY_CODE and a.TRMT_CATEGORY_TYPE =c.TRMT_CATEGORY_TYPE and b.LANGUAGE_ID = c.LANGUAGE_ID AND C.LANGUAGE_ID  = D.LANGUAGE_ID AND A.STATUS  = D.ORDER_STATUS_CODE AND a.PATIENT_ID= ? AND a.CHART_NUM = ? AND a.TRMT_CATEGORY_TYPE IN('MAXILLA')  and TREATMENT_INT_EXT ='I' and b.LANGUAGE_ID  = ? and a.OPERATING_FACILITY_ID=? and nvl(a.STATUS,'X')<>'E' order by  a.TREATMENT_CONDITION_DATE desc,a.TOOTH_NO desc";
			}
		}
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,chart_num);
		pstmt.setString(3,locale);
		if(oh_chart_level.equals("F")){
			pstmt.setString(4,facility_id);
		}
		rs=pstmt.executeQuery();
		Integer rowCount=0;
		 String toothCondition="";
		while(rs.next()){
			if(header_tab.equals("C"))
			{
			condnTrmt_type = checkForNull(rs.getString("CONDITION_TYPE_DESC"));
			condnTrmt_desc = checkForNull(rs.getString("CONDITION_DESC"));
			organCode = checkForNull(rs.getString("ORGAN_CODE"));
			suborganCode = checkForNull(rs.getString("SUB_ORGAN_CODE"));
			siteType = checkForNull(rs.getString("SITE_DESC"));

			}
			else if (header_tab.equals("T"))
			{
			condnTrmt_type = checkForNull(rs.getString("TRMT_CATEGORY_TYPE_DESC"));
			condnTrmt_desc = checkForNull(rs.getString("TRMT_DESC"));
			status = checkForNull(rs.getString("STATUS"));
			
			}
			toothCondition=checkForNull(rs.getString("TOOTH_NO"));
			
			super_key_val = checkForNull(rs.getString("SUPER_KEY_NUM"));
			
			
			pstmt1 = con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM = ? AND TOOTH_NO =? ");
			if(!toothCondition.equals("")){				
			pstmt1.setString(1,tooth_numbering_system);
			pstmt1.setString(2,toothCondition);
			rs1 = pstmt1.executeQuery();
			while(rs1.next()){
				tooth_no = rs1.getString("NS_TOOTH_NO");
			}
				
			if(!super_key_val.equals("") && !super_key_val.equals("null")){
				tooth_no = super_key_val+"["+tooth_no+"]";
			}
				
			}
			else
			{tooth_no="";}
			
			condn_date = checkForNull(rs.getString("TREATMENT_CONDITION_DATE"));
			remark = checkForNull(rs.getString("REMARKS"));
			added_by = checkForNull(rs.getString("ADDED_BY_ID"));
		    style =(rowCount.intValue()%2==0)?"QRYEVEN":"QRYODD";
			count++;
			%>
			
			<tr>
			<td class="<%=style %>"><%=condnTrmt_type%></td>
			<td class="<%=style %>"><%=condnTrmt_desc%></td>
			<% if(header_tab.equals("T"))
			{ %>
			<td class="<%=style %>"><%=status%></td>
			<%}%>
			<% if(header_tab.equals("C"))
			{ %>
			<td class="<%=style %>"><%=organCode%></td>
			<td class="<%=style %>"><%=suborganCode%></td>
			<td class="<%=style %>"><%=siteType%></td>
			<%}%>
			<td class="<%=style %>"><%=tooth_no%></td>
			<td class="<%=style %>"><%=remark%></td>
			<td class="<%=style %>"><%=added_by%></td>
			<td class="<%=style %>"><%=condn_date%></td>
			
		
			</tr>
			<tr><td></td><td></td></tr>
			<%
				
			}
			%>
</table>
</div>
<% if(header_tab.equals("C"))
			{ %>
<div id="listExtLayer1" style="display:block;visibility:visible;overflow-y: scroll;height:120;width:900;border: 1px outset #9999FF" align="center">
<table align='center' cellpadding='4' cellspacing='' border='1' width='100%' class='grid' >
<tr>
		<td align="center" colspan="7" class='CAGROUPHEADING'><fmt:message key='eOH.ExtTreatments.Label' bundle='${oh_labels}'/></td>	
		
</tr>
<tr>
	<th><fmt:message key='Common.TreatmentCategory.label' bundle='${common_labels}'/></th>
	<th><fmt:message key='eOH.ExtTreatments.Label' bundle='${oh_labels}'/></th>
	<th><fmt:message key='Common.status.label' bundle='${common_labels}'/></th>
	<th><fmt:message key='eOH.ToothNo.Label' bundle='${oh_labels}'/></th>	
	<th><fmt:message key='Common.Location.label' bundle='${common_labels}'/></th>	
	<th><fmt:message key='Common.remarks.label' bundle='${common_labels}'/></th>	
	<th><fmt:message key='eOH.RecordedBy.Label' bundle='${oh_labels}'/></th>	
	<th><fmt:message key='Common.PerformedDate.label' bundle='${common_labels}'/></th>	
	
</tr>
<%
String sql1="";	
if(rs != null) rs.close();
if(rs1 != null) rs1.close();
if(pstmt != null) pstmt.close();
if(pstmt1 != null) pstmt1.close();
 

String location="";
		//	if(oh_chart_level.equals("E")){
			 sql1="SELECT c.TRMT_CATEGORY_TYPE_DESC,b.TRMT_DESC,DECODE(A.STATUS,'C','Complete','I','Incomplete') status,a.TOOTH_NO,a.LOCATION,TO_CHAR(a.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, a.REMARKS,a.ADDED_BY_ID FROM OH_RESTORATIVE_CHART_DTL a, OH_TREATMENT_LANG_VW  b , OH_TRTMT_CATEGORY_TYPE_LANG_VW c WHERE a.TRMT_CODE=b.TRMT_CODE and a.TRMT_CATEGORY_CODE=b.TRMT_CATEGORY_CODE and b.TRMT_CATEGORY_CODE =b.TRMT_CATEGORY_CODE and a.TRMT_CATEGORY_TYPE =c.TRMT_CATEGORY_TYPE and b.LANGUAGE_ID = c.LANGUAGE_ID AND a.PATIENT_ID= ? AND a.CHART_NUM = ? AND a.TRMT_CATEGORY_TYPE IN('MAXILLA')  and a.TREATMENT_INT_EXT ='E' and nvl(a.STATUS,'X')<>'E' and b.LANGUAGE_ID  = ? order by  a.TREATMENT_CONDITION_DATE desc,a.TOOTH_NO desc";
		/*	}else if(oh_chart_level.equals("F")){
			 sql1="SELECT c.TRMT_CATEGORY_TYPE_DESC,b.TRMT_DESC,DECODE(A.STATUS,'C','Complete','I','Incomplete') status,a.TOOTH_NO,TO_CHAR(a.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, a.REMARKS,a.ADDED_BY_ID FROM OH_RESTORATIVE_CHART_DTL a, OH_TREATMENT_LANG_VW  b , OH_TRTMT_CATEGORY_TYPE_LANG_VW c WHERE a.TRMT_CODE=b.TRMT_CODE and a.TRMT_CATEGORY_CODE=b.TRMT_CATEGORY_CODE and b.TRMT_CATEGORY_CODE =b.TRMT_CATEGORY_CODE and a.TRMT_CATEGORY_TYPE =c.TRMT_CATEGORY_TYPE and b.LANGUAGE_ID = c.LANGUAGE_ID AND a.PATIENT_ID= ? AND a.CHART_NUM = ? AND a.TRMT_CATEGORY_TYPE IN('MAXILLA')  and TREATMENT_INT_EXT ='E'and b.LANGUAGE_ID  = ?  and a.OPERATING_FACILITY_ID=? order by  a.TREATMENT_CONDITION_DATE desc";
			} */

		
		pstmt=con.prepareStatement(sql1);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,chart_num);
		pstmt.setString(3,locale);
		if(oh_chart_level.equals("F")){
		pstmt.setString(4,facility_id);
		}
		rs=pstmt.executeQuery();
		
		while(rs.next()){
			String toothno="";
			condnTrmt_type = checkForNull(rs.getString("TRMT_CATEGORY_TYPE_DESC"));
			condnTrmt_desc = checkForNull(rs.getString("TRMT_DESC"));
			toothno = checkForNull(rs.getString("TOOTH_NO"));
           location= checkForNull(rs.getString("LOCATION"));
			status = checkForNull(rs.getString("status"));
			
			pstmt1 = con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM = ? AND TOOTH_NO =? ");
			if(!toothno.equals("")){
			pstmt1.setString(1,tooth_numbering_system);
			pstmt1.setString(2,toothno);
			rs1 = pstmt1.executeQuery();
			while(rs1.next()){
			toothno = checkForNull(rs1.getString("NS_TOOTH_NO"));
				}
			}else
			{toothno="";}
			 
			
			condn_date = checkForNull(rs.getString("TREATMENT_CONDITION_DATE"));
			remark = checkForNull(rs.getString("REMARKS"));
			added_by = checkForNull(rs.getString("ADDED_BY_ID"));
		  
			%>
	<tr>
			<td class="<%=style %>"><%=condnTrmt_type%></td>
			<td class="<%=style %>"><%=condnTrmt_desc%></td>
			<td class="<%=style %>"><%=status%></td>
			<td class="<%=style %>"><%=toothno%></td>
			<td class="<%=style %>"><%=location%></td>
			<td class="<%=style %>"><%=remark%></td>
			<td class="<%=style %>"><%=added_by%></td>
			<td class="<%=style %>"><%=condn_date%></td>

	</tr>

<%

}
%>
</table>
</div>
<%
}
	}catch ( Exception e ) {
		e.printStackTrace() ;
	}finally {
		try{
			if(rs!=null) rs.close();
			if(rs1!=null) rs1.close();
			if(pstmt!=null) pstmt.close();
			if(pstmt1!=null) pstmt1.close();
			if(con!=null) 
				ConnectionManager.returnConnection(con,request);
		   }catch(Exception es){es.printStackTrace();}
	}
%>

</form>
</body>
</HTML>

