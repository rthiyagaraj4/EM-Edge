<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
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
	String facility_id = (String)session.getValue( "facility_id" ) ;
	String tooth_numbering_system="";
    String chk_value="Y";
	String chk_checked="checked";
	String chart_code = checkForNull(request.getParameter( "chart_code" )) ; 
	String params = request.getQueryString() ;
	String flag=checkForNull(request.getParameter("flag"));
	String disable_flag="";
    String component_code="";
    String component_desc_user_def="";
    String ns_tooth_no="";
    String tooth_no="";
    String required_yn_hid="";
    int i = 0;
	
	//String oh_chart_level = "";//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level")); //Added by Sridevi Joshi on 12/24/2009 for IN017625
%>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eOH/js/PerioToothApplicability.js" language="javascript"></script>
		<script language="javascript" src="../../eOH/js/Hashtable.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
try{
	con=ConnectionManager.getConnection(request);
	
	if(oh_chart_level.equals("E")){//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
	    i=1;
		pstmt = con.prepareStatement("SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM");
	}else{
		i=1;
		pstmt = con.prepareStatement("SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?");
		pstmt.setString(1,facility_id);
	}

	rs = pstmt.executeQuery();

	while(rs.next()){
		tooth_numbering_system=rs.getString("TOOTH_NUMBERING_SYSTEM");
	}

	 component_desc_user_def=checkForNull(request.getParameter("component_desc_user_def"));
	 component_code=checkForNull(request.getParameter("component_code"));
	 ns_tooth_no=checkForNull(request.getParameter("ns_tooth_no"));
	 tooth_no=checkForNull(request.getParameter("tooth_no"));

	 if(flag.equals("1")){
		 String select_value=checkForNull(request.getParameter("select_value"));
		 String select_checked=checkForNull(request.getParameter("select_checked"));
		 chk_value=select_value;
		 chk_checked=select_checked;
		 disable_flag="disabled";

//added by parul on 06/01/2010 for 17712
		 sql="SELECT * FROM OH_PERIODONTAL_CHART_DEF_DTL2 WHERE COMPONENT_CODE=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,component_code);
			rs=pstmt.executeQuery();
				while(rs!=null && rs.next()){
					required_yn_hid=checkForNull(rs.getString("required_yn"));
				}
	
	}
%>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
<form name="PerioToothApplicabilityFooter" id="PerioToothApplicabilityFooter" method="post" action='../../servlet/eOH.PerioToothApplicabilityServlet' target='messageFrame'> 


<table width="65%"  cellpadding =10 cellspacing=0  align="center" >
   <tr>
   <td class=label width="25%" nowrap><fmt:message key="Common.Component.label" bundle="${common_labels}"/></td>
	    <td class="fields" width="25%"  align="left">
               <select name='component_code' id='component_code' onChange='clearMessageFrame();' <%=disable_flag%>> 
			   <%if(flag.equals("1")){ %>
			      <option value='<%=component_code%>'><%=component_desc_user_def%></option> 
				 <% } %>

			     <option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
				  <%          
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					sql="SELECT B.COMPONENT_CODE, A.COMPONENT_DESC_USER_DEF FROM OH_PERIODONTAL_CHART_COMP A, OH_PERIODONTAL_CHART_DEF_DTL B WHERE B.CHART_CODE = ? AND A.COMPONENT_CODE = B.COMPONENT_CODE AND A.FORMULA_YN = 'N' ORDER BY COMPONENT_DESC_USER_DEF";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,chart_code);
					rs=pstmt.executeQuery();
					while(rs.next()){
				 %>
						<option value='<%=rs.getString("COMPONENT_CODE")%>'><%=rs.getString("COMPONENT_DESC_USER_DEF")%></option>
				<%} %>
			   </select>
        </td>
   </tr>
   <tr>
   <td class=label width="25%" nowrap><fmt:message key="eOH.ToothApplicable.Label" bundle="${oh_labels}"/></td>
	    <td class="fields" width="25%"  align="left">
               <select name='tooth_no' id='tooth_no' onChange='' <%=disable_flag%> > 
			   <%if(flag.equals("1")){ %>
			     <option value='<%=tooth_no%>'><%=ns_tooth_no%></option> 
				 <% } %>
			     <option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
				  <%          
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					sql="SELECT LPAD(TO_CHAR(NS_TOOTH_NO),2,'0') NS_TOOTH_NO, TO_CHAR(TOOTH_NO) TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE NUMBERING_SYSTEM = ? AND  TOOTH_NO IN (SELECT TOOTH_NO FROM OH_TOOTH WHERE PERMANENT_DECIDUOUS = 'P') UNION SELECT '*All Tooth' NS_TOOTH_NO, '*A' TOOTH_NO FROM DUAL ORDER BY NS_TOOTH_NO";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,tooth_numbering_system);
					rs=pstmt.executeQuery();
					while(rs.next()){
				 %>
						<option value='<%=rs.getString("TOOTH_NO")%>'><%=rs.getString("NS_TOOTH_NO")%></option>
				<%} %>
			   </select>
        </td>
   </tr>
   <tr>
         <td class=label width="25%">
			<fmt:message key="eOH.Required?.Label" bundle="${oh_labels}"/>
	     </td>
	     
		 <td class="fields" width="25%" colspan="3">
		 <input type="checkbox" name="required_yn" id="required_yn" onClick='setCheckValue();' value='<%=chk_value%>'<%=chk_checked%> >
	     </td>
   </tr>
   <tr>
		<td width="25%" colspan="4" class="button" >
			<input type="button" class="button" name="record" id="record" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onclick ="insertRecords();" >&nbsp;
			<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick="clearvalues();">
			<!-- Added By Sridevi Joshi on 12/28/2009 for IN017625 to delete the component values selected. -->
			<%if(flag.equals("1")){ %> 
				<input type="button" class="button" name="delete" id="delete" value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' onclick="deleteSelectedCompValues();">
			<% } %>
		</td>
	</tr>
 </table>
 <input type="hidden" name="chart_code" id="chart_code" value="<%=chart_code%>" >
 <input type="hidden" name="component_code_hid" id="component_code_hid" value="<%=component_code%>" >
 <input type="hidden" name="tooth_no_hid" id="tooth_no_hid" value="<%=tooth_no%>" >  
 <input type="hidden" name="params" id="params" value="<%=params%>">
 <input type="hidden" name="chk_value" id="chk_value" value="<%=chk_value%>">
 <input type="hidden" name="chk_checked" id="chk_checked" value="<%=chk_checked%>">
 <input type="hidden" name="flag" id="flag" value="<%=flag%>">
 <input type="hidden" name="locale" id="locale" value="<%=locale%>">
 <input type="hidden" name="oh_chart_level" id="oh_chart_level" value="<%=oh_chart_level%>">
 <input type="hidden" name="tooth_numbering_system" id="tooth_numbering_system" value="<%=tooth_numbering_system%>">
<!--  added by parul on 07/01/2010 for 17712 -->
 <input type="hidden" name="required_yn_hid" id="required_yn_hid" value="<%=required_yn_hid%>">
 <input type="hidden" name="chk_recorded" id="chk_recorded" value=""> 

 
</form>
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

