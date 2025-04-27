<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@page  contentType="text/html;charset=UTF-8"%>
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
	<script language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script language="JavaScript" src="../../eOT/js/PractitionerTypesForRoleTypes.js"></Script>
		<script language="JavaScript" src="../../eOT/js/Hashtable.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="PractitionerTypesForRoleTypesDetailForm" id="PractitionerTypesForRoleTypesDetailForm" OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
  
   String from = checkForNull(request.getParameter( "from" )) ;
   String to =   checkForNull(request.getParameter( "to" ) ) ;
   String role_type=checkForNull(request.getParameter("role_type"));
   String totalSelected= checkForNull(request.getParameter("totalSelected"));
   String select_value="Y";
   String practitioner_type="";
   String desc_userdef="";
   String sel="";
   String select_checked="";
   int start = ( from.equals("") )?1:Integer.parseInt(from);
   int end =  ( to.equals("") )?14:Integer.parseInt(to);
   Connection conn = null;
   PreparedStatement pstmt = null;
   ResultSet rst=null;
	String strsql="SELECT A.PRACT_TYPE, A.DESC_USERDEF, DECODE (B.PRACT_TYPE, A.PRACT_TYPE,'Y','N') SEL FROM AM_PRACT_TYPE_LANG_VW A, OT_PRACT_TYPES_FOR_ROLE_TYPE B WHERE A.LANGUAGE_ID= ? AND A.PRACT_TYPE 	= B.PRACT_TYPE (+) AND 	 B.ROLE_TYPE (+)=?";
	int maxRecord = 0;
	int i=1;
	 try{
   
		conn  =  ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement(strsql);
		pstmt.setString(1,locale);
		pstmt.setString(2,role_type);
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
		pstmt.setString(2,role_type);
		rst = pstmt.executeQuery();

		
	
%>
<P>
<table align='right'>
<tr>
<td>
<%
	if ( !(start <= 1) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous();'>Prev</font>");
	if ( !( (start+14) > maxRecord ) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<table calss='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class='columnHeaderCenter' nowrap>
	<fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/>
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
 			practitioner_type = rst.getString(1);
		    desc_userdef= rst.getString(2);
			sel=rst.getString(3);
 			out.println("<tr>");
		    out.println("<td class='" + classValue+"' nowrap>"+practitioner_type+"</td>");
		    out.println("<td class='" + classValue+"' nowrap>"+desc_userdef+"</td>");
   			if (sel.equals("Y")){
				   select_checked="checked";
			       select_value="Y";
					k++;
			}else{
				select_checked="";
				select_value="N";
			}
			out.println("<td class='" + classValue+"' nowrap><input type=checkbox name=chk_select"+i+" value="+select_value+" "+select_checked+" practitioner_type='"+practitioner_type+"' db_change='N' select_yn='"+select_value+"' onclick='validateCheckBox(this);'>");
			out.println("</td>");
		    out.println("</tr>");

			if(totalSelected.length()>0){
			String tokens[] = totalSelected.split(",");
			
			for(int p = 0;p<tokens.length;p++){
				if(Integer.parseInt(tokens[p])==i)
					out.println("<script>assingListItemValue("+tokens[p]+");</script>");
			}
			}
   			i++;
		} 
	%>
</table>
</center>
<br><center>
<% 
   }catch(Exception e){
		e.printStackTrace();
		//out.println("PractitionerTypesForRoleTypesDetailForm : "+e);
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
<input type="hidden" name="totalSelected" id="totalSelected" value="<%=totalSelected%>" >
<input type="hidden" name="role_type" id="role_type" value="<%=role_type%>" >
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

