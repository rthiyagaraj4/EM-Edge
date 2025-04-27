<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,org.json.simple.parser.JSONParser,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<HTML><head>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<script>
function fnSetvalue(type){   
	if(type=="P"){
		document.forms[0].isPrevClicked.value="Y";
	}else if(type=="N"){
		document.forms[0].isNextClicked.value="Y";
	}
}
</script>


<BODY  class='CONTENT' onLoad='ClearMsg()' onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="PlaceOccurrenceForm" id="PlaceOccurrenceForm" >
<%
						request.setCharacterEncoding("UTF-8");
						request= new XSSRequestWrapper(request);
						response.addHeader("X-XSS-Protection", "1; mode=block");
						response.addHeader("X-Content-Type-Options", "nosniff");
						String classValue = "" ;
						String whereClause		= request.getParameter("whereclause");
						int currentPageNo 	= 1;
				if(request.getParameter("currentPageNo") != null)
					currentPageNo = Integer.parseInt(request.getParameter("currentPageNo"));
						
					String ord[] = request.getParameterValues("orderbycolumns");
					
		
		
		 String place_occurrence_type_code = (request.getParameter("place_occurrence_type_code")==null || request.getParameter("place_occurrence_type_code")=="")?"":request.getParameter("place_occurrence_type_code");
		 String long_desc = (request.getParameter("long_desc")==null || request.getParameter("long_desc")=="")?"":request.getParameter("long_desc");
		 String short_desc = (request.getParameter("short_desc")==null || request.getParameter("short_desc")=="")?"":request.getParameter("short_desc");
		 String enabled = (request.getParameter("eff_status")==null || request.getParameter("eff_status")=="")?"":request.getParameter("eff_status");
		
		 // Changing to Upper case and checking
		 place_occurrence_type_code			= place_occurrence_type_code.toUpperCase();
		 
		 JSONObject jsonObj 	= new JSONObject();
		 JSONArray pmbArr	= new JSONArray();
		 Connection con = null;
		 
		 try
	{
		
      con =  ConnectionManager.getConnection(request);
	  
	  
	

				
		jsonObj  = eAE.AECommonBean.getPlaceOfOccurrence(con,place_occurrence_type_code,long_desc,short_desc,enabled,ord,whereClause,currentPageNo);
		
		
	

				int curPageNo		= 0;
				curPageNo		= (Integer) jsonObj.get("currentPageNo");
					
				int noOfRecords		= 0;
				noOfRecords		= (Integer) jsonObj.get("noOfRecords");
				
				int noOfPages		= 0;
				noOfPages		= (Integer) jsonObj.get("noOfPages");
				
				int prevPageNo	= curPageNo - 1;		
				int nextPageNo	= curPageNo + 1;		

				if(noOfRecords == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
				}
		 
  
	
%>

<table align='right'>
					<tr>
					<% if ( curPageNo > 1 ){ %>
						<td align ='right' id='prev'><A HREF="../../eAE/jsp/PlaceOfOccurrenceQueryResult.jsp?place_occurrence_type_code=<%=place_occurrence_type_code%>&long_desc=<%=long_desc%>&short_desc=<%=short_desc%>&eff_status=<%=enabled%>&currentPageNo=<%=prevPageNo%>" text-decoration='none' onclick="fnSetvalue('P');" ><fmt:message key="Common.previous.label" bundle="${common_labels}" /></A></td>
					<%}
					if ( curPageNo >=1 && curPageNo != noOfPages ){%>
						<td align ='right' id='next'><A HREF="../../eAE/jsp/PlaceOfOccurrenceQueryResult.jsp?place_occurrence_type_code=<%=place_occurrence_type_code%>&long_desc=<%=long_desc%>&short_desc=<%=short_desc%>&eff_status=<%=enabled%>&currentPageNo=<%=nextPageNo%>" text-decoration='none' onclick="fnSetvalue('N');"><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
					<%}%>
					</tr>
				</table>
				<br><br>
				<table border='1' cellpadding='0' cellspacing='0'   width="100%"  id='pmb_table'>
					<tr>
						<th width='5%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
						<th width='52%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
						<th width='33%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th> 
						<th width='5%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
					</tr>
					<tr></tr>
					<%
						pmbArr = (JSONArray)jsonObj.get("PMBArray");
						for(int i = 0 ; i < pmbArr.size() ; i++) {	
							JSONObject pmbCodeListObj	= (JSONObject)pmbArr.get(i);
							String POCode  = (String) pmbCodeListObj.get("POCode");
							String POLDesc = (String) pmbCodeListObj.get("POLDesc");
							String POSDesc = (String) pmbCodeListObj.get("POSDesc");
							String POStatus = (String) pmbCodeListObj.get("POStatus");
							
							int j= i+1;
							if (j%2 == 0)
								classValue = "QRYEVEN" ;
							else
								classValue = "QRYODD" ;										
					%>
							<tr>
								
	<td align="left" valign="middle"  class="<%=classValue%>"><a href='../../eAE/jsp/AddModifyPlaceOfOccurrence.jsp?place_occurrence_type_code=<%=POCode%>' target='f_query_add_mod' ><%=POCode%></a></td>
								<td align="left" valign="middle"  class="<%=classValue%>"><%=POLDesc%></td>
								<td align="left" valign="middle"  class="<%=classValue%>"><%=POSDesc%></td>
								<%if(POStatus.equals("E")){%>
								<td align="left" valign="middle"  class="<%=classValue%>"><%out.println("<img src='../../eCommon/images/enabled.gif'></img>");%></td>
								<%}else{%>
								<td align="left" valign="middle"  class="<%=classValue%>"><%out.println("<img src='../../eCommon/images/disabled.gif'></img>");%></td>
								<%}%>
							</tr>

							<input type='hidden' name='isPrevClicked' id='isPrevClicked' value = ""></input>
							<input type='hidden' name='isNextClicked' id='isNextClicked' value = ""></input>

					
					<% } %>
				</table>
<%

 }catch(Exception e)
     {
			e.printStackTrace();
     }
	finally   
	{
		
		 ConnectionManager.returnConnection(con,request);
    }
%>
 </form>
</BODY>
</HTML>

