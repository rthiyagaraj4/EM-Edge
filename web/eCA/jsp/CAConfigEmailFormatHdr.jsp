<!DOCTYPE html>
<%@ page import="java.sql.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
	request.setCharacterEncoding("UTF-8");	
	    //String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	    //String params = request.getQueryString() ;
	    //String source = url + params ;
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		// added by Arvind @  08-12-08 
	    String imgUrl="";
	     if(sStyle.equals("IeStyle.css"))
	      {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	      }
	    //end
	
   %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCA/js/CAConfigEmailFormat.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown='lockKey()'>
		<form name='configEmailFrmtHdrForm' id='configEmailFrmtHdrForm'>
			<table  align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>
				<tr>					
					<td class='label' width='18%'>
					<fmt:message key='Common.report.label' bundle='${common_labels}'/>
					</td>
					<td class='fields' width='30%'> <input type="Text" name="txtconfigureEmailReport" id="txtconfigureEmailReport" value = "" size="25" OnKeyPress='return CheckForSpeChar(event)' Onblur='getData(this)'><input type="hidden" name ="configureEmailReport" value=""><input type='button' class='button' name='buttonCategory' id='buttonCategory' value='?' OnClick='populateReportsLookup()'><img src='../../eCommon/images/mandatory.gif'></img></td> 
				</tr>
				<tr>
					<td align='right' colspan='2'><input type='button' class='button' value="<fmt:message key='Common.search.label' bundle='${common_labels}'/>" onclick='loadReportNames()'>
					</td>
				</tr>
			</table>

			<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
			<%}%>

				<!-- end -->
		</form>
	</body>
</html>

