<!DOCTYPE html>

<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.Common.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@page  contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% 	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<HTML>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/OrderTypesForSpeciality.js'></script>
<script language="JavaScript">
		
function validateCheckBox(obj){
	var formObj = document.forms[0];
	formObj.modified_flag.value="false";
	if(obj.checked==true){
			//obj.select_yn="Y";
			obj.setAttribute('select_yn','Y');
	}else{
		   //obj.select_yn="N";
		   obj.setAttribute('select_yn','N');
	}
	var arrObj = document.forms[0].elements;
	for(var i=0;i<arrObj.length;i++){
		if(arrObj[i].type=="checkbox"){
			if(arrObj[i].value==arrObj[i].select_yn){
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
	var speciality_code=frm.speciality_description.value;
	//var execute_flag=formObj.execute_flag.value
	var start = formObj.start.value;
	formObj.start.value=start-14;
	var end = formObj.end.value;
	formObj.end.value=end-14;
	start = formObj.start.value;
	end = formObj.end.value;
	document.location.href="../../eOT/jsp/OrderTypesForSpecialityDetailForm.jsp?from="+start+"&to="+end+"&speciality_code="+speciality_code;
		
}

  function next(){
	 var frm=window.parent.frames[0].document.forms[0];    //.frames[0].document.forms[0];
	 var formObj = document.forms[0];
	 var modified_flag=formObj.modified_flag.value;
	 if(modified_flag=="true"){
		alert("Please apply Changes..!");
		return;
	}
	 var speciality_code=frm.speciality_description.value;
	 var start = formObj.start.value;
	 formObj.start.value=parseInt(start)+14;
	 start = formObj.start.value;
	 var end = formObj.end.value;
	 formObj.end.value=parseInt(end)+14;
	 end = formObj.end.value;
     var masterFrame=window.parent.frames[0];
     var detailFrame=window.parent.frames[1];
	   document.location.href="../../eOT/jsp/OrderTypesForSpecialityDetailForm.jsp?from="+start+"&to="+end+"&speciality_code="+speciality_code;
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<BODY class='CONTENT' onload=""  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<form name="OrderTypesForSpecialityDetailForm" id="OrderTypesForSpecialityDetailForm">
<%
  //OnMouseDown='CodeArrest()' onKeyDown="lockKey()"
   String from = checkForNull(request.getParameter( "from" )) ;
   String to =   checkForNull(request.getParameter( "to" ) ) ;
   String speciality_code=checkForNull(request.getParameter("speciality_code"));
   String select_value="Y";
   String order_type_code="";
   String order_type_desc="";
   String sel="";
   String select_checked="";
   int start = ( from.equals("") )?1:Integer.parseInt(from);
   int end =  ( to.equals("") )?14:Integer.parseInt(to);
   Connection conn = null;
   PreparedStatement pstmt = null;
   ResultSet rst=null;
    String strsql="SELECT A.ORDER_TYPE_CODE, A.LONG_DESC, DECODE (B.ORDER_TYPE_CODE, A.ORDER_TYPE_CODE,'Y','N') SEL FROM OR_ORDER_TYPE_LANG_VW A, OT_SPECIALITY_ORDER_TYPES B WHERE A.LANGUAGE_ID= ? AND A.ORDER_CATEGORY = 'OT' AND A.ORDER_TYPE_CODE 	= B.ORDER_TYPE_CODE (+) AND B.SPECIALITY_CODE (+)= ? AND A.ORDER_TYPE_CODE NOT IN (SELECT ORDER_TYPE_CODE FROM OT_SPECIALITY_ORDER_TYPES WHERE SPECIALITY_CODE NOT IN ?) ORDER BY A.ORDER_TYPE_CODE";
    int maxRecord = 0;
    int i=1;
    try{
   
		conn  =  ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement(strsql);
		pstmt.setString(1,locale);
		pstmt.setString(2,speciality_code);
		pstmt.setString(3,speciality_code);
		rst = pstmt.executeQuery();
		int total=0;
		while(rst.next()){
			total++;
		}
        maxRecord = total;
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
			//return;
			
		}
		pstmt=conn.prepareStatement(strsql);
		pstmt.setString(1,locale);
		pstmt.setString(2,speciality_code);
		pstmt.setString(3,speciality_code);
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


<table border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class="columnHeader" NOWRAP >
	<fmt:message key="Common.OrderType.label" bundle="${common_labels}"/>
</th>
<th class="columnHeader"  NOWRAP >
	<fmt:message key="Common.description.label" bundle="${common_labels}"/>
</th>
<th class="columnHeader" NOWRAP >
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
 			order_type_code = rst.getString(1);
		    order_type_desc= rst.getString(2);
			sel=rst.getString(3);
 			out.println("<tr>");
		    out.println("<td class='" + classValue+"'>"+order_type_code+"</td>");
		    out.println("<td class='" + classValue+"'>"+order_type_desc+"</td>");
   			if (sel.equals("Y")){
				   select_checked="checked";
			       select_value="Y";
					k++;
			}else{
				select_checked="";
				select_value="N";
			}
			out.println("<td class='" + classValue+"'><input type=checkbox name=chk_select"+i+" id=chk_select"+i+" value="+select_value+" "+select_checked+" order_type_code='"+order_type_code+"' db_change='N' select_yn='"+select_value+"' onclick='validateCheckBox(this);'>");
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
	}finally{
		try{
			if(rst!=null)	rst.close();
			if(pstmt!=null)	pstmt.close();
			ConnectionManager.returnConnection(conn,request);
		}catch(Exception e){e.printStackTrace();}
	}
%>
<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
<input type="hidden" name="modified_flag" id="modified_flag" value="false" >
<input type="hidden" name="execute_flag" id="execute_flag" value="YES" >
<input type="hidden" name="start" id="start" value="<%=start%>" >
<input type="hidden" name="end" id="end" value="<%=end%>" >
<input type="hidden" name="sel" id="sel" value="<%=select_checked%>" >
<input type="hidden" name="speciality_code" id="speciality_code" value="<%=speciality_code%>" >

</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

