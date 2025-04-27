<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>



<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE");
request.setCharacterEncoding("UTF-8");
%>
<%
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	String strsql = "";
	String sql="";
	String params = request.getQueryString() ;
    String facility_id = (String)session.getValue( "facility_id" ) ;
	String tooth_numbering_system="";
	String chart_code=checkForNull(request.getParameter( "chart_code" )) ;
	String required_yn="";
	String oh_chart_level=checkForNull(request.getParameter( "oh_chart_level" )) ;

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
<body onLoad="parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=true;" OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form name="PerioToothApplicabilityDetails" id="PerioToothApplicabilityDetails" method="post">
<%   
     String select_value="Y";
	 String select_checked="";
	 String component_desc_user_def="";
	 String ns_tooth_no="";
     String classValue="";
     String from = checkForNull(request.getParameter( "from" )) ;
     String to =   checkForNull(request.getParameter( "to" ) ); 
     int start = ( from.equals("") )?1:Integer.parseInt(from);
     int end =  ( to.equals("") )?10:Integer.parseInt(to);
	 StringBuffer sbr = new StringBuffer();
	 String totalSelected=request.getParameter("totalSelected");
	 String tooth_range_count_for_order=request.getParameter("tooth_range_count_for_order");
	
     int i=1;
     try{
   		conn  =  ConnectionManager.getConnection(request);
		if(oh_chart_level.equals("E")){//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
			sql="SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM";
			pstmt = conn.prepareStatement(sql);
		}else{	 
			sql="SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,facility_id);
		}
	    rst = pstmt.executeQuery();
		while(rst.next()){
			tooth_numbering_system=rst.getString("TOOTH_NUMBERING_SYSTEM");
		}

        if(pstmt!=null) pstmt.close();
		if(rst!=null) rst.close();
	    strsql="SELECT A.COMPONENT_CODE,B.COMPONENT_DESC_USER_DEF, NS_TOOTH_NO,A.TOOTH_NO,REQUIRED_YN FROM OH_PERIODONTAL_CHART_DEF_DTL2 A, OH_PERIODONTAL_CHART_COMP B, (SELECT TO_CHAR(TOOTH_NO) TOOTH_NO, NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE NUMBERING_SYSTEM = ? UNION SELECT '*A', '*All Tooth' FROM DUAL) C WHERE A.CHART_CODE = ?  AND            A.COMPONENT_CODE  = B.COMPONENT_CODE AND   A.TOOTH_NO		= C.TOOTH_NO ORDER BY 2,3";

		pstmt = conn.prepareStatement(strsql);
		pstmt.setString(1,tooth_numbering_system);
		pstmt.setString(2,chart_code);

		rst = pstmt.executeQuery();
		
		int total=0;
	    int maxRecord  = 0;
		
		while(rst.next()){
			total++;
		}
		maxRecord = total;
		
		if(pstmt!=null) pstmt.close();
		if(rst!=null) rst.close();

		pstmt = conn.prepareStatement(strsql);
		pstmt.setString(1,tooth_numbering_system);
		pstmt.setString(2,chart_code);
		rst = pstmt.executeQuery();
%>
<p>
<table align='right' border=0>
<tr>
	<td>
	<% 
		if ( !(start <= 1) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous();'>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font>");
		if ( !( (start+10) > maxRecord ) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");
	%>
	</td>
</tr>
</table>
<br><br>
</p>
<table border="1" width="100%" cellspacing='0' cellpadding='2'  align='center'>
<br>
       <tr>
			<td class='columnHeader'  width="30%" align="center">
				<fmt:message key="Common.Component.label" bundle="${oh_labels}"/>
			</td>
			<td class="columnHeader" width='30%' align="center">
				<fmt:message key="eOH.ToothApplicable.Label" bundle="${oh_labels}"/>
			</td>
			<td class="columnHeader" width='30%' align="center">
				<fmt:message key="eOH.Required?.Label" bundle="${or_labels}"/>
			</td>
				
	  </tr>
     <% 
		   
		if(start != 1 )
			for(int j=1; j<start; i++,j++ )
				rst.next() ;
		
			while ( rst.next() && i<=end){
				classValue  = ( i % 2 == 0 )?"QRYEVENSMALL":"QRYODDSMALL" ;
				String component_code=rst.getString("COMPONENT_CODE");
				String tooth_no=rst.getString("TOOTH_NO");
				component_desc_user_def= rst.getString("COMPONENT_DESC_USER_DEF");
				ns_tooth_no= rst.getString("NS_TOOTH_NO");
				required_yn= rst.getString("REQUIRED_YN");
				
				if(required_yn.equals("Y")){
				 select_value="Y";
				 select_checked="checked";
				}
				else{
				 select_value="N";
				 select_checked="";
				}
        
				sbr.append("<tr>");
				
				sbr.append("<td  width='45%' class='"+classValue+"'><a href='../../eOH/jsp/PerioToothApplicabilityFooter.jsp?flag=1&component_desc_user_def="+component_desc_user_def+"&ns_tooth_no="+ns_tooth_no+"&select_checked="+select_checked+"&select_value="+select_value+"&component_code="+component_code+"&tooth_no="+tooth_no+"&tooth_numbering_system="+tooth_numbering_system+"&oh_chart_level="+oh_chart_level+"&chart_code="+chart_code+"' target='PerioToothApplicabilityFooter' >"+component_desc_user_def+"</a></td>");
				
				sbr.append("<td  width='40%' class='"+classValue+"'>"+ns_tooth_no+"</td>");
				sbr.append("<td  width='15%' class='" + classValue+"'>");
			
				if (rst.getString("REQUIRED_YN").equals("Y") || rst.getString("REQUIRED_YN").equals("null"))
				   sbr.append("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					sbr.append("<img src='../../eCommon/images/RRnwd.gif'></img>");

				//out.println("</td>");

				sbr.append("</td>");
				sbr.append("</tr>");
			
				i++;
			}

			out.println(sbr.toString());	
   %>

  
</table>
 <% 
   }catch(Exception e){
		e.printStackTrace() ;
	}finally{
		try{
			if(rst!=null)	rst.close();
			if(pstmt!=null)	pstmt.close();
			if(sbr!=null)   sbr.setLength(0);
			ConnectionManager.returnConnection(conn,request);
		}catch(Exception e){}
	}
   %>	
<input type="hidden" name="start" id="start" value="<%=start%>" >
<input type="hidden" name="end" id="end" value="<%=end%>" >
<input type="hidden" name="totalSelected" id="totalSelected" value="<%=totalSelected%>" >
<input type="hidden" name="params" id="params" value="<%=params%>">
<input type="hidden" name="tooth_range_count_for_order" id="tooth_range_count_for_order" value="<%=tooth_range_count_for_order%>" >
<input type="hidden" name="tooth_numbering_system" id="tooth_numbering_system" value="<%=tooth_numbering_system%>" >
<input type="hidden" name="component_desc_user_def" id="component_desc_user_def" value="<%=component_desc_user_def%>" >
<input type="hidden" name="ns_tooth_no" id="ns_tooth_no" value="<%=ns_tooth_no%>" >
<input type="hidden" name="required_yn" id="required_yn" value="<%=required_yn%>" >
<input type="hidden" name="chart_code" id="chart_code" value="<%=chart_code%>" >
<input type="hidden" name="locale" id="locale" value="<%=locale%>" >
<input type="hidden" name="oh_chart_level" id="oh_chart_level" value="<%=oh_chart_level%>" >

</form>
</body>
</html>

