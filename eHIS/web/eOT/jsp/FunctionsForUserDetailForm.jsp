<!DOCTYPE html>

<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

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
	<script language='JavaScript' src='../../eOT/js/FunctionsForUser.js'></script>
	<script language='javascript' src='../../eOT/js/Hashtable.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>


</script>
<BODY  class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
<form name="StatusDetailForm" id="StatusDetailForm">
<%
   String from = checkForNull(request.getParameter( "from" )) ;
   String to =   checkForNull(request.getParameter( "to" ) ) ;
   String user_id=checkForNull(request.getParameter("user_id"));
//   String mode =checkForNull(request.getParameter("mode"));
   String totalSelected= checkForNull(request.getParameter("totalSelected"));
  // out.println("totalSelected"+totalSelected);
   String allowVerify= checkForNull(request.getParameter("allowVerify"));
    //out.println("allowVerify="+allowVerify);
//   String verifSelected= checkForNull(request.getParameter("verifSelected"));
   String select_value="Y";
   String function_id="";
   String function_desc_user="";
   String sel="";
   String allow_verif="";
   String select_checked="";
   String verify_select_checked="";
   String verify_select_value="";
   int start = ( from.equals("") )?1:Integer.parseInt(from);
   int end =  ( to.equals("") )?14:Integer.parseInt(to);
   Connection conn = null;
   PreparedStatement pstmt = null;
   ResultSet rst=null;
   String strsql="SELECT A.FUNCTION_ID, A.FUNCTION_DESC_USER, nvl(B.ALLOW_VERIFICATION_YN,'N') ALLOW_VERIF, DECODE(B.FUNCTION_ID, A.FUNCTION_ID,'Y','N') SEL FROM OT_FUNCTIONS_LANG_VW A, OT_USER_FUNCTIONS B WHERE A.LANGUAGE_ID ='"+locale+"' AND A.FUNCTION_ID = B.FUNCTION_ID(+) AND B.USER_ID(+)= ? ORDER BY 1";
   int maxRecord = 0;
   int i=1;
   try{
 		conn  =  ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement(strsql);
		pstmt.setString(1,user_id);
		rst = pstmt.executeQuery();
		int total=0;
		while(rst.next()){
			total++;
		}
        maxRecord = total;
		
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			
		}
		pstmt=conn.prepareStatement(strsql);
		pstmt.setString(1,user_id);
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

	//out.println("<A HREF='../jsp/FunctionsForUserQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class='columnHeaderCenter' nowrap>
	<fmt:message key="eOT.FunctionID.Label" bundle="${ot_labels}"/>
</th>
<th class='columnHeaderCenter' nowrap>
	<fmt:message key="Common.description.label" bundle="${common_labels}"/>
</th>
<!-- Commented by rajesh according to vishwa's instruction on23/03/09 -->
<!-- <td class='columnHeaderCenter' nowrap>
	<fmt:message key="eOT.VerificationAllowed.Label" bundle="${ot_labels}"/>
</td> -->
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
			allow_verif=rst.getString(3);
			sel=rst.getString(4);
			out.println("<tr>");
		    out.println("<td class='" + classValue+"' nowrap>"+function_id+"</td>");
		    out.println("<td class='" + classValue+"' nowrap>"+function_desc_user+"</td>");
			if (allow_verif.equals("Y")){
				   verify_select_checked="checked";
				   verify_select_value="Y";
			       allow_verif = "Y";
					
			}else{
				verify_select_checked="";
				verify_select_value="N";
				allow_verif = "N";
			}
		//Commented by rajesh according to vishwa's instruction on23/03/09 
		/*out.println("<td class='"+classValue+"' nowrap><input type=checkbox name=allow_verif"+i+" value="+verify_select_value+" "+verify_select_checked+ " select_yn_1='"+verify_select_value+"' onClick='getCheckBoxValue("+ i +");' > </td>");

*/
			
			if (sel.equals("Y")){
				   select_checked="checked";
			       select_value="Y";
					k++;
			}else{
				select_checked="";
				select_value="N";
			}
			out.println("<td class='"+classValue+"' nowrap><input type=checkbox name=chk_select"+i+" value="+select_value+" "+select_checked+"  func_id='"+function_id+"' db_change='N' db_change_1='N' select_yn='"+select_value+"' allow_verif='"+allow_verif+"' onClick='validateCheckBox(this);'>");
			out.println("</td>");
		    out.println("</tr>");

			if (totalSelected.length()>0 && totalSelected.indexOf(""+i)>=0){
				out.println("<script>assignCheckBoxValue("+i+");</script>");
			}
			
						
			if (allowVerify.length()>0 && allowVerify.indexOf(""+i)>=0){
				out.println("<script>callAllowVerificationChkBox("+i+");</script>");
			}


			/*if(totalSelected.length()>0){
				String tokens[] = totalSelected.split(",");
				for(int p = 0;p<tokens.length;p++){
					if(Integer.parseInt(tokens[p])==i)
						out.println("<script>assignCheckBoxValue("+tokens[p]+");</script>");
				}
			}

			if(allowVerify.length()>0){
				String tokens[] = allowVerify.split(",");
				for(int s = 0;s<tokens.length;s++){
					if(Integer.parseInt(tokens[s])==i)
						out.println("<script>callAllowVerificationChkBox("+tokens[s]+");</script>");
				}
			}*/
   			i++;
		} 
	%>
</table>
</center>
<br><center>
<% 
   }catch(Exception e){
		e.printStackTrace();
		//out.println("FunctionForUserDetailForm : "+e);
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
<input type="hidden" name="user_id" id="user_id" value="<%=user_id%>" >
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

