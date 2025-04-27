<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>

<%@include file="../../eOT/jsp/StringUtil.jsp"%>

<HTML>
	<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language="JavaScript">
	
	
function validateCheckBox(obj){
	var formObj = document.forms[0];
	formObj.modified_flag.value="false";
	if(obj.checked==true){
			//obj.select_yn="Y";
			obj.setAttribute('select_yn',"Y");
	}else{
		   //obj.select_yn="N";
		   obj.setAttribute('select_yn',"N");
	}
	var arrObj = document.forms[0].elements;
	for(var i=0;i<arrObj.length;i++){
		if(arrObj[i].type=="checkbox"){
			if(arrObj[i].value==arrObj[i].getAttribute('select_yn')){
			  //arrObj[i].db_change="N";
			  arrObj[i].setAttribute('db_change','N');
			 
				  continue;
			}else{
				formObj.modified_flag.value="true";
				 //arrObj[i].db_change="Y";
				 arrObj[i].setAttribute('db_change','Y');
			}
		}
		
	}
}

function previous(){
	
	 var frm=window.parent.frames[0].document.forms[0];
	 var formObj = document.forms[0];
	 var modified_flag=formObj.modified_flag.value;
	 if(modified_flag=="true"){
		alert("Please apply Changes..!");
		return;
	}
	var status_code=frm.status_description.value;
	var start = formObj.start.value;
	formObj.start.value=start-14;
	var end = formObj.end.value;
	formObj.end.value=end-14;
	start = formObj.start.value;
	end = formObj.end.value;
	document.location.href="../../eOT/jsp/FunctionsForStatusDetailForm.jsp?from="+start+"&to="+end+"&status_code="+status_code;
	
		
}

  function next(){
	  
	 var frm=window.parent.frames[0].document.forms[0];    //.frames[0].document.forms[0];
	 var formObj = document.forms[0];
	 var modified_flag=formObj.modified_flag.value;
	 if(modified_flag=="true"){
		alert("Please apply Changes..!");
		return;
	}
	 var status_code=frm.status_description.value;
	 var start = formObj.start.value;
	 formObj.start.value=parseInt(start)+14;
	 start = formObj.start.value;
	 var end = formObj.end.value;
	 formObj.end.value=parseInt(end)+14;
	 end = formObj.end.value;
     var masterFrame=window.parent.frames[0];
	 var detailFrame=window.parent.frames[1];
document.location.href="../../eOT/jsp/FunctionsForStatusDetailForm.jsp?from="+start+"&to="+end+"&status_code="+status_code;
	 
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<form name="StatusDetailForm" id="StatusDetailForm" OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
  
   String from = checkForNull(request.getParameter( "from" )) ;
   String to =   checkForNull(request.getParameter( "to" ) ) ;
   String status_code=checkForNull(request.getParameter("status_code"));
   String select_value="Y";
   String function_id="";
   String function_desc_user="";
   String sel="";
   String select_checked="";
   int start = ( from.equals("") )?1:Integer.parseInt(from);
   int end =  ( to.equals("") )?14:Integer.parseInt(to);
   Connection conn = null;
   PreparedStatement pstmt = null;
   ResultSet rst=null;
	String strsql="SELECT A.FUNCTION_ID function_id, A.FUNCTION_DESC_USER function_desc_user, DECODE(B.FUNCTION_ID, A.FUNCTION_ID,'Y','N') SEL FROM OT_FUNCTIONS_LANG_VW A,OT_FUNCT_APPL_FOR_STATUS B WHERE A.LANGUAGE_ID = ?  AND A.FUNCTION_ID = B.FUNCTION_ID(+) AND B.STATUS_CODE(+) = ? ORDER BY 1";
	int maxRecord = 0;
	int i=1;
	try{
   
		conn  =  ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement(strsql);
		pstmt.setString(1,locale);
		pstmt.setString(2,status_code);
		rst = pstmt.executeQuery();
		int total=0;
		while(rst.next()){
			total++;
		}
        maxRecord = total;
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			//return;
			
		}
		pstmt=conn.prepareStatement(strsql);
		pstmt.setString(1,locale);
		pstmt.setString(2,status_code);
		rst = pstmt.executeQuery();

		
	
%>
<P>
<table align='right'>
<tr>
<td>
<%
	if ( !(start <= 1) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font>");
	if ( !( (start+14) > maxRecord ) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding=3  align='center'>
<th class='columnHeaderCenter' nowrap
	<fmt:message key="eOT.FunctionID.Label" bundle="${ot_labels}"/>
</th>
<th class='columnHeaderCenter' nowrap>
	<fmt:message key="Common.description.label" bundle="${common_labels}"/>
</th>
<th class='columnHeaderCenter' nowrap>
	<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
</th>
<%
		if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
		rst.next() ;
		String classValue= " ";
		int k=0;
		while ( rst.next() && i<=end  ){
		if ( i % 2 == 0 )
            classValue = "gridData" ;
        else
		    classValue = "gridData" ;
 			function_id = rst.getString(1);
		    function_desc_user= rst.getString(2);
			sel=rst.getString(3);
 			out.println("<tr>");
		    out.println("<td class='" + classValue+"' nowrap>"+function_id+"</td>");
		    out.println("<td class='" + classValue+"' nowrap>"+function_desc_user+"</td>");
   			if (sel.equals("Y")){
				   select_checked="checked";
			       select_value="Y";
					k++;
			}else{
				select_checked="";
				select_value="N";
			}
			out.println("<td class='" + classValue+"' nowrap><input type=checkbox name=chk_select"+i+" value="+select_value+" "+select_checked+" func_id='"+function_id+"' db_change='N' select_yn='"+select_value+"' onclick='validateCheckBox(this);'>");
			out.println("</td>");
		    out.println("</tr>");
   			i++;
		} 
	%>
</table>
</center>
<br><center>
<% 
   }catch(Exception e){
		e.printStackTrace();
		//out.println("FunctionForStatusDetailForm : "+e);
	}finally{
		try{
			if(rst!=null)	rst.close();
			if(pstmt!=null)	pstmt.close();
			ConnectionManager.returnConnection(conn,request);
		}catch(Exception e){e.printStackTrace();}
	}
%>
<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>" >
<input type="hidden" name="modified_flag" id="modified_flag" value="false" >
<input type="hidden" name="execute_flag" id="execute_flag" value="YES" >
<input type="hidden" name="start" id="start" value="<%=start%>" >
<input type="hidden" name="end" id="end" value="<%=end%>" >
<input type="hidden" name="sel" id="sel" value="<%=select_checked%>" >
<input type="hidden" name="status_code" id="status_code" value="<%=status_code%>" >
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

