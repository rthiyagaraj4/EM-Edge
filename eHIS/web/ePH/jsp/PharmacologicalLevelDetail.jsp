<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<html>
<head>
<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../js/ATCClassification.js"></script>
<script language="JavaScript" src="../js/PhCommon.js"></script>
<!-- <script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 -->

</head>

<!-- <body topmargin="0" onMouseDown="CodeArrest()" style="overflow-x:hidden;overflow-y:scroll"> -->
<body topmargin="0" onMouseDown="CodeArrest()" style="overflow-x:hidden;overflow-y:scroll" onKeyDown="lockKey()">
<%
	String level_num	=	request.getParameter("level_num");
	String level_code	=	request.getParameter("level_code");
	String level_desc	=	request.getParameter("level_desc");
	String bean_id		=	"@ATCClassificationBean" ;
	String bean_name	=	"ePH.ATCClassificationBean";
	
	if(level_num==null) level_num ="1";
	if(level_code==null) level_code ="";
	if(level_desc==null) level_desc ="";
	
	ATCClassificationBean bean = (ATCClassificationBean)getBeanObject( bean_id, bean_name, request );
		bean.setLanguageId(locale);
	bean.setPharmaLevelCodes(level_num,level_code,level_desc);
	ArrayList result = bean.getPharmaLevelClassification(level_num);	
//	out.println(result);
%>
<table border="1" align="center" width="100%" cellpadding="0" cellspacing="0" id="desc_detail">
<%
	int index = 0;
	for (int i=0;i<result.size();i=i+2){
		String classvalue="";
		if ( index% 2 == 0 )
			classvalue = "ATCQRYODD" ;
		else
			classvalue = "ATCQRYEVEN" ;

		index++;
%>
<tr onClick="javascript:changeRowColor(this,'<%=index%>')">
	<td class="<%=classvalue%>">
		<label id="level_code_display<%=index%>" class="dtdvl"><%=result.get(i)%></label>
	</td>
	<td class="<%=classvalue%>">
		<input type="hidden" name="level_code<%=index%>" id="level_code<%=index%>" value="<%=result.get(i)%>">
		<label id="level_desc<%=index%>" class="dtdvl" style="cursor:pointer" onClick="showPhamacologicalLevelDetails('<%=level_num%>','<%=result.get(i)%>','<%=result.get(i+1)%>',this,'<%=index%>');"><%=result.get(i+1)%></label>
	</td>
</tr>
<%
	}
%>
</table>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="level_num" id="level_num" value="<%=level_num%>">
<input type="hidden" name="selected_drug" id="selected_drug" value="">
</form>
<% putObjectInBean(bean_id,bean,request ) ; %>
</body>
</html>

