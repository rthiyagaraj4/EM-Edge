<!DOCTYPE html>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*,eOR.*,eOR.Common.*,eXH.XHIdentify,java.util.*" contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
%>   
<html> 
<head>

	<%
	String sStyle ="IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />	

	<script src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js'></script>
	<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
	<script language="JavaScript" src='../../eXH/js/Validate.js'> </script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
    <script language="JavaScript" src="../../eXH/js/FilteringAndSchdulingLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  

</head>
<%
    String sql_query = "";
 	String from	= request.getParameter("from") ;
	String to	= request.getParameter("to") ;
	String checkedOnes	= "";
	String  req_start   =   "", req_end     =   "";
	String called_from = request.getParameter("called_from");

	if(called_from == null) called_from = "";
 	String search_by = request.getParameter("search_by");
	if(search_by == null || search_by == "null") search_by = "C";
 	String description_code=(request.getParameter("description_code")==null||request.getParameter("description_code").equals("null"))?"":request.getParameter("description_code");
	String long_desc=request.getParameter("search_text");
	if(long_desc==null || long_desc=="null") long_desc = "";
 	String facility_id = (String)session.getValue("facility_id");
	int counts=0;
	if(from==null)
	{
	}

    PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection con = null;
if(search_by.equals("C"))
{
	if(description_code.equals("S"))
	{
		sql_query="SELECT FILTER_GROUP_CODE code,FILTER_GROUP_DESC Description,APPLICATION_ID,PROTOCOL_LINK from XH_FILTER_GROUP WHERE UPPER(FILTER_GROUP_CODE) LIKE UPPER('"+long_desc+"%') AND UPPER(FILTER_GROUP_DESC) LIKE UPPER('%') ORDER BY 1";
	} 
   else if(description_code.equals("E"))
	{
         sql_query="SELECT FILTER_GROUP_CODE code,FILTER_GROUP_DESC Description,APPLICATION_ID,PROTOCOL_LINK from XH_FILTER_GROUP WHERE UPPER(FILTER_GROUP_CODE) LIKE UPPER('%"+long_desc+"') AND UPPER(FILTER_GROUP_DESC) LIKE UPPER('%') ORDER BY 1";
	}
	else
	{
	 sql_query="SELECT FILTER_GROUP_CODE code,FILTER_GROUP_DESC Description,APPLICATION_ID,PROTOCOL_LINK from XH_FILTER_GROUP WHERE UPPER(FILTER_GROUP_CODE) LIKE UPPER('%"+long_desc+"%') AND UPPER(FILTER_GROUP_DESC) LIKE UPPER('%') ORDER BY 1";
	}
 }
 else
 {
if(description_code.equals("S"))
	{
		sql_query="SELECT FILTER_GROUP_CODE code,FILTER_GROUP_DESC Description,APPLICATION_ID,PROTOCOL_LINK from XH_FILTER_GROUP WHERE UPPER(FILTER_GROUP_CODE) LIKE UPPER('%') AND UPPER(FILTER_GROUP_DESC) LIKE UPPER('"+long_desc+"%') ORDER BY 1";
	} 
   else if(description_code.equals("E"))
	{
         sql_query="SELECT FILTER_GROUP_CODE code,FILTER_GROUP_DESC Description,APPLICATION_ID,PROTOCOL_LINK from XH_FILTER_GROUP WHERE UPPER(FILTER_GROUP_CODE) LIKE UPPER('%') AND UPPER(FILTER_GROUP_DESC) LIKE UPPER('%"+long_desc+"') ORDER BY 1";
	}
	else
	{
	 sql_query="SELECT FILTER_GROUP_CODE code,FILTER_GROUP_DESC Description,APPLICATION_ID,PROTOCOL_LINK from XH_FILTER_GROUP WHERE UPPER(FILTER_GROUP_CODE) LIKE UPPER('%') AND UPPER(FILTER_GROUP_DESC) LIKE UPPER('%"+long_desc+"%') ORDER BY 1";
	}
 }

	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	
	int i=1;
	if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
	if (to == null){ end = 15 ; }   else {  end = Integer.parseInt( to ) ; }
	req_start       =   (request.getParameter("start")==null)   ?   "0" : request.getParameter("start");
	req_end         =   (request.getParameter("end")==null)     ?   "0" : request.getParameter("end");
	if(from != null && to != null) {
		int j=0;
		for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++){
			if(request.getParameter("chk"+(i-1)) != null) {
				checkedOnes = request.getParameter("chk"+(i-1));
				j++;
			}
		}
		out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
	}
   i = 1;
	try  
	{
		con = ConnectionManager.getConnection(request);
		String option_id	= "";
		String application_id="";
		String protocollink_id="";
		String short_desc	= "";
		int ilCkeckedYN = 0;
		int recordCount;
		StringBuffer sql = new StringBuffer();
		String classValue="";
		sql.append(sql_query);
		pstmt = con.prepareStatement(sql_query.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs = pstmt.executeQuery();
		rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();
%>
<%if(maxRecord==0){%><script>alert(getMessage("XH1021","XH"));parent.frames[1].document.location.href='../../eCommon/html/blank.html'</script><%}else{%>
<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
<form name='OrderableResult' id='OrderableResult' action="FileteringAndSchdulingLookupQueryResult.jsp?<%=request.getQueryString()%>"  method='post'>
	 <table border='0' width='100%'>
		<tr>
			<td width='65%'></td> 
			<td align='right' width='35%'>
	<%
		if ( !(start <= 1)) {
	%>
		<a class='gridLink' href='javascript:submitPrevNext(<%=(start-15)%>,<%=(end-15)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
		<input type=hidden name='whichPage' id='whichPage' value='prev'>
	<%
		}
		if ( !((start+15) > maxRecord )){
	%>
		<a class='gridLink' href='javascript:submitPrevNext(<%=(start+15)%>,<%=(end+15)%>)' text-decoration='none'>&nbsp;<fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
		<input type=hidden name='whichPage' id='whichPage' value='next'>
	<%
		}
	%>
			</td>
		</tr>
	 </table>
 
	<table cellspacing=0 cellpadding=3 width='100%' border=1 align=center>

	
		<td class='COLUMNHEADER'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="eXH.Gateway.Label" bundle="${xh_labels}"/></td>
		<!--<td class='columnHeadercenter'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>-->
	
		<%
			if (start != 0){
            for(int j=1; j<start; i++,j++){
                rs.next() ;  
             }
			 ilCkeckedYN+=start;
             --ilCkeckedYN ;   
			}
			recordCount			=	XHIdentify.getSize(con,sql_query); 
			while(rs.next()&& i<=end)
			{
				counts++;
				option_id = rs.getString(1)==null?"":rs.getString(1);
				short_desc = rs.getString(2)==null?"":rs.getString(2);
			    application_id = rs.getString(3)==null?"":rs.getString(3);
			    protocollink_id = rs.getString(4)==null?"":rs.getString(4);
				
				classValue			=	( (i%2)==0 )? "QRYODD" : "QRYEVEN";
				//classValue="gridData";
		%>
				<tr>
				<td class="<%=classValue%>" onmouseover="changeCursor(this);" onClick="funShow('<%=option_id%>','<%=short_desc%>')"><font class='HYPERLINK'><%=option_id%></font></td>
				
				<td class='<%=classValue%>'><%=short_desc%></td>
				<td class='<%=classValue%>' ><%=application_id%><input type="hidden" name="short_desc<%=counts%>" id="short_desc<%=counts%>" value="<%=short_desc%>"></td>
				<td class='<%=classValue%>' ><%=protocollink_id%></td></tr>
		<%
				ilCkeckedYN = ilCkeckedYN + 1;		
				i=i+1;
				//}
			}
			out.println("<input type=hidden name='count' id='count' value="+(ilCkeckedYN-1)+">");
 			out.println("<input type='hidden' name='recordCount' id='recordCount' value='"+ recordCount +"'>");
			out.println("<input type=hidden name=occurance id=occurance value='next'>");
			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		%>

		<input type=hidden name=from id=from value='<%=start%>'>
		<input type=hidden name=to id=to value='<%=end%>'>
		<input type=hidden name='start' id='start' value='<%=start%>'>
		<input type=hidden name='end' id='end' value='<%=end%>'>
		<input type=hidden name='called_from' id='called_from' value='<%=called_from%>'>
				<input type=hidden name='search_by' id='search_by' value='<%=search_by%>'>
		<input type=hidden name='description_code' id='description_code' value='<%=description_code%>'>
		<input type=hidden name='long_desc' id='long_desc' value='<%=long_desc%>'>
		<input type=hidden name='facility_id' id='facility_id' value='<%=facility_id%>'>
	
		
	 </table>
	
	 <table border='0' width='100%'> 
	 <tr><td class="button" align="right" nowrap ><input type="button" class="button" align="left" onClick="funAdd()" value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' width='25%' class="button">
	 <input type="button" class="button" align="left" onClick="funFresh()" value='<fmt:message key="Common.Refresh.label" bundle="${common_labels}"/>' width='25%' class="button"></td></tr></table>
	 <%}%>

	 <%   
		}
		catch(Exception e){
			out.println("Exception in OrderableResult.jsp"+e.toString());
		}finally{
		    if(con != null)ConnectionManager.returnConnection(con,request);
		}
	 %>

<%%>

</form>
</body>
<script>
function funFresh()
{
 document.OrderableResult.target = "refusal_resultframe1"
 document.OrderableResult.submit();
	 if(parent.frames[2].document.forms[0])
	{
	  parent.frames[2].document.forms[0].reset();
	  parent.frames[2].document.location.href='FilteringAndSchdulingLookupAdd.jsp?';
     parent.frames[3].document.location.href='../../eCommon/jsp/MstCodeError.jsp';
	}
}


	function submitPrevNext(from, to)
	{
		document.OrderableResult.from.value = from;
        document.OrderableResult.to.value = to; 
        document.OrderableResult.target = "refusal_resultframe1"
        document.OrderableResult.submit();
	}
	function funAdd()
	{		
		//window.close();
		var dialogTag = parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close();

		parent.frames[2].document.location.href='../../eXH/jsp/FilteringAndSchdulingLookupAdd.jsp';
          parent.frames[3].document.location.href="../../eCommon/jsp/MstCodeError.jsp";
	}
	function dummy()
	{
	}
	 function funShow(code,desc)
	{
	
 
		 
		// window.returnValue=code+","+desc;
		// window.close();
		var retVal = code+","+desc;
		let dialogBody = parent.parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = retVal;
		
		var dialogTag = parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close();
		}
</script>
</html>
  

