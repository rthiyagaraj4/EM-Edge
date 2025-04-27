<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>

<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<HTML>
	<head>
	<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eAM/js/MSpecialityLink.js'></script>
	<script language="JavaScript">
		function validateCheckBox(obj){
			var formObj = document.forms[0];
			formObj.modified_flag.value="false";
			if(obj.checked==true){
				obj.select_yn="Y";
			}else{
				obj.select_yn="N";
			}
			var arrObj = document.forms[0].elements;
			for(var i=0;i<arrObj.length;i++){
				if(arrObj[i].type=="checkbox"){
					if(arrObj[i].value==arrObj[i].select_yn){
						arrObj[i].db_change="N";
						continue;
					}else{
						formObj.modified_flag.value="true";
						arrObj[i].db_change="Y";
					}
				}
			}
		}

		function previous(){
			var frm=window.parent.frames[0].document.forms[0];
			var formObj = document.forms[0];
			var modified_flag=formObj.modified_flag.value;
			if(modified_flag=="true"){
			if(confirm(getMessage('WANT_TO_SAVE','common'))){
				document.forms[0].prevnext.value=14;
			parent.parent.apply();
			var speciality_module=frm.speciality_module.value;
			var start = formObj.start.value;
			formObj.start.value=start-14;
			var end = formObj.end.value;
			formObj.end.value=end-14;
			start = formObj.start.value;
			end = formObj.end.value;
		var search_by=document.forms[0].search_by.value;
		var search_txt=document.forms[0].search_txt.value;
	document.location.href="../../eAM/jsp/MSpecialityLinkDetailForm.jsp?from="+start+"&to="+end+"&speciality_module="+speciality_module+"&search_by="+search_by+"&search_txt="+search_txt;
				return;
		}else{
			var speciality_module=frm.speciality_module.value;
			var start = formObj.start.value;
			formObj.start.value=start-14;
			var end = formObj.end.value;
			formObj.end.value=end-14;
			start = formObj.start.value;
			end = formObj.end.value;	
			
		var search_by=document.forms[0].search_by.value;
		var search_txt=document.forms[0].search_txt.value;	document.location.href="../../eAM/jsp/MSpecialityLinkDetailForm.jsp?from="+start+"&to="+end+"&speciality_module="+speciality_module+"&search_by="+search_by+"&search_txt="+search_txt;
		}
		}else{

			var speciality_module=frm.speciality_module.value;
			var start = formObj.start.value;
			formObj.start.value=start-14;
			var end = formObj.end.value;
			formObj.end.value=end-14;
			start = formObj.start.value;
			end = formObj.end.value;	
			var search_by=document.forms[0].search_by.value;
			var search_txt=document.forms[0].search_txt.value;
		document.location.href="../../eAM/jsp/MSpecialityLinkDetailForm.jsp?from="+start+"&to="+end+"&speciality_module="+speciality_module+"&search_by="+search_by+"&search_txt="+search_txt;
		}
		}

		function next(){
			var frm=window.parent.frames[0].document.forms[0];    //.frames[0].document.forms[0];
			var formObj = document.forms[0];
			var modified_flag=formObj.modified_flag.value;
			if(modified_flag=="true"){
			if(confirm(getMessage('WANT_TO_SAVE','common'))){
			document.forms[0].prevnext.value=14;
			parent.parent.apply();	
			var speciality_module=frm.speciality_module.value;
			var start = formObj.start.value;
			var start1=parseInt(start)+14;
			start = formObj.start.value;
			var end = formObj.end.value;
			var end1=parseInt(end)+14;
			end = formObj.end.value;
			var masterFrame=window.parent.frames[0];
			var detailFrame=window.parent.frames[1];	
			var search_by=document.forms[0].search_by.value;
			var search_txt=document.forms[0].search_txt.value;
		document.location.href="../../eAM/jsp/MSpecialityLinkDetailForm.jsp?from="+start1+"&to="+end1+"&speciality_module="+speciality_module+"&search_by="+search_by+"&search_txt="+search_txt;	
			return;
		}else{
			var speciality_module=frm.speciality_module.value;
			var start = formObj.start.value;
			formObj.start.value=parseInt(start)+14;
			start = formObj.start.value;
			var end = formObj.end.value;
			formObj.end.value=parseInt(end)+14;
			end = formObj.end.value;
			var masterFrame=window.parent.frames[0];
			var detailFrame=window.parent.frames[1];	
			var search_by=document.forms[0].search_by.value;
			var search_txt=document.forms[0].search_txt.value;
		document.location.href="../../eAM/jsp/MSpecialityLinkDetailForm.jsp?from="+start+"&to="+end+"&speciality_module="+speciality_module+"&search_by="+search_by+"&search_txt="+search_txt;
		}
		}else{
			var speciality_module=frm.speciality_module.value;
			var start = formObj.start.value;
			formObj.start.value=parseInt(start)+14;
			start = formObj.start.value;
			var end = formObj.end.value;
			formObj.end.value=parseInt(end)+14;
			end = formObj.end.value;
			var masterFrame=window.parent.frames[0];
			var detailFrame=window.parent.frames[1];	
			var search_by=document.forms[0].search_by.value;
			var search_txt=document.forms[0].search_txt.value;
		document.location.href="../../eAM/jsp/MSpecialityLinkDetailForm.jsp?from="+start+"&to="+end+"&speciality_module="+speciality_module+"&search_by="+search_by+"&search_txt="+search_txt;
		}
		}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT'  onKeyDown = 'lockKey()'>
	<form name="MSpecialityLinkDetailForm" id="MSpecialityLinkDetailForm">
		
		<%
		   String from = checkForNull(request.getParameter( "from" )) ;
		   String to =   checkForNull(request.getParameter( "to" ) ) ;
		   String speciality_module=checkForNull(request.getParameter("speciality_module"));
		   String select_value="Y";
		   String speciality_code = "";
		   String speciality_desc = "";

			String search_by=request.getParameter("search_by");
			String search_txt=request.getParameter("search_txt");
			if(search_by == null) search_by="";
			if(search_txt == null) search_txt="";

			
			if(search_by.equals("01"))
			{
			   search_by="SPECIALITY_CODE";
			}
			else if(search_by.equals("02"))
			{
				search_by="LONG_DESC";
			}
		   
		  
		   String sel="";
		   String select_checked="";
		   int start = ( from.equals("") )?1:Integer.parseInt(from);
		   int end =  ( to.equals("") )?14:Integer.parseInt(to);
		   Connection conn = null;
		   PreparedStatement pstmt = null;
		   ResultSet rst=null;
		   
		 //  String strsql="SELECT A.SPECIALITY_CODE, B.SHORT_DESC, 'Y' CHECKBOX FROM AM_SPLTY_FOR_SPLTY_MODULES A, AM_SPECIALITY B WHERE A.MODULE_ID='"+speciality_module+"' AND A.SPECIALITY_CODE = B.SPECIALITY_CODE UNION SELECT SPECIALITY_CODE, SHORT_DESC, 'N' CHECKBOX FROM AM_SPECIALITY WHERE EFF_STATUS='E' AND  SPECIALITY_CODE NOT IN (SELECT SPECIALITY_CODE from AM_SPLTY_FOR_SPLTY_MODULES WHERE MODULE_ID='"+speciality_module+"') ORDER BY SHORT_DESC";

		  String strsql="SELECT A.SPECIALITY_CODE, B.LONG_DESC, 'Y' CHECKBOX FROM AM_SPLTY_FOR_SPLTY_MODULES A, AM_SPECIALITY B WHERE A.MODULE_ID='"+speciality_module+"' AND A.SPECIALITY_CODE = B.SPECIALITY_CODE";
		  
			  if(!search_by.equals("") && !search_txt.equals(""))
			  strsql = strsql +" and upper(B."+search_by+")  like upper('"+search_txt+"%')"; 
		  
		  
		  strsql = strsql +" UNION SELECT SPECIALITY_CODE, LONG_DESC, 'N' CHECKBOX FROM AM_SPECIALITY WHERE EFF_STATUS='E'";
		  
			   if(!search_by.equals("") && !search_txt.equals(""))
			  strsql = strsql +" and upper("+search_by+")  like upper('"+search_txt+"%')";

		  strsql = strsql +" AND  SPECIALITY_CODE NOT IN (SELECT SPECIALITY_CODE from AM_SPLTY_FOR_SPLTY_MODULES) ORDER BY LONG_DESC";

			int maxRecord = 0;
			int i=1;
			try{
		   		conn  =  ConnectionManager.getConnection(request);
				pstmt = conn.prepareStatement(strsql);
				rst = pstmt.executeQuery();
				int total=0;
				while(rst.next()){
					total++;
				}
				maxRecord = total;
				if(maxRecord == 0){
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));window.parent.frames[1].location.href='../../eCommon/html/blank.html';</script>");
				}
				pstmt=conn.prepareStatement(strsql);
				rst = pstmt.executeQuery();
		%>
		
		<table align='right' border=0>
			<tr>
				<td>
				<%
					if ( !(start <= 1) )
					out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous();'>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font>");
					if ( !( (start+14) > maxRecord ) )
					out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");
				%>
				</td>
			</tr>
		</table>
		<br><br>
		<table border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
			<tr>
				<td class='CAGROUPHEADING' colspan=3>
					<fmt:message key="eAM.AssociatedSpecialities.Label" bundle="${am_labels}"/>
				</td>
			</tr>
			<tr>
				<td class="columnHeader" width=''>
					<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
				</td>
				<td class="columnHeader" width=''>
					<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
				</td>
			</tr>
			<%
				if ( start != 1 )
				for( int j=1; j<start; i++,j++ )
				rst.next() ;
				String classValue= " ";
				int k=0;
				while ( rst.next() && i<=end  ){
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
					speciality_code = checkForNull(rst.getString(1));
					speciality_desc= checkForNull(rst.getString(2));
					sel=checkForNull(rst.getString(3));
					
					out.println("<tr>");
					out.println("<td class='" + classValue+"'>"+speciality_desc+"</td>");
					
					if (sel.equals("Y")){
						   select_checked="checked";
						   select_value="Y";
							k++;
					}else{
						select_checked="";
						select_value="N";
					}
					out.println("<td class='" + classValue+"'><input type=checkbox name=chk_select"+i+" value="+select_value+" "+select_checked+" speciality_code='"+speciality_code+"' db_change='N' select_yn='"+select_value+"' onclick='validateCheckBox(this);'>");
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
				out.println("MSpecialityLinkDetailForm : "+e);
				e.printStackTrace();
			}finally{
				try{
					if(rst!=null)	rst.close();
					if(pstmt!=null)	pstmt.close();
					ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		%>
		<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
		<input type="hidden" name="modified_flag" id="modified_flag" value="false" >
		<input type="hidden" name="execute_flag" id="execute_flag" value="YES" >
		<input type="hidden" name="start" id="start" value="<%=start%>" >
		<input type="hidden" name="end" id="end" value="<%=end%>" >
		<input type="hidden" name="prevnext" id="prevnext" value="" >
		<input type="hidden" name="sel" id="sel" value="<%=select_checked%>" >
		<input type="hidden" name="speciality_module" id="speciality_module" value="<%=speciality_module%>" >
		<input type="hidden" name="speciality_desc" id="speciality_desc" value="<%=speciality_desc%>" >
		<input type='hidden' name='search_by' id='search_by' value='<%=search_by%>'>
		<input type='hidden' name='search_txt' id='search_txt' value='<%=search_txt%>'>

		</center>
		<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	</form>
</BODY>
</HTML>

