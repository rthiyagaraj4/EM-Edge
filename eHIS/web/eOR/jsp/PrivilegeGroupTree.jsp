<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
	<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="eOR.*, java.sql.*, java.util.*,java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../js/PrivilegeGroup.js"></script>
	<script language="JavaScript" src="../js/ORPrivilegeMenu.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

</head>


<%
	String bean_id = "privilegegroupbean" ;
	String bean_name = "eOR.PrivilegeGroupBean";
	String mode	= request.getParameter("mode");
	String currentview	= request.getParameter("currentview");
	//System.out.println("currentview==="+currentview);
	String executable_name		= "../../eOR/jsp/PrivilegeGroupMainAssociateFrame.jsp?";
	String workAreaFrame		= "DetailsOfNode";
	PrivilegeGroupBean bean = (PrivilegeGroupBean)getBeanObject( bean_id , bean_name, request) ;
	bean.setLanguageId(localeName);
	
	%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<FORM METHOD=POST ACTION="" name="frmMenu" id="frmMenu">
<script>
var obj;
obj = new dTree('obj');
var Pg=getLabel("eOR.PrivilegeGroup.label","OR");
obj.add(0,-1,getLabel("eOR.PrivilegeGroup.label","OR"),"<%=executable_name%>","Privilege Group","<%=workAreaFrame%>","","","","");
obj.add(1,0,getLabel("Common.all.label","common"),"<%=executable_name%>&mode=<%=mode%>&viewtype=ALL","ALL","<%=workAreaFrame%>","","","","");
obj.add(2,1,getLabel("Common.Ordering.label","COMMON"),"<%=executable_name%>&mode=<%=mode%>&viewtype=OR","Ordering","<%=workAreaFrame%>","","","","");
//obj.add(3,1,getLabel("eOR.Viewing.label","OR"),"<%=executable_name%>&mode=<%=mode%>&viewtype=VW","Viewing","<%=workAreaFrame%>","","","","");
obj.add(3,1,getLabel("eOR.Authorizing.label","OR"),"<%=executable_name%>&mode=<%=mode%>&viewtype=AU","Authorizing","<%=workAreaFrame%>","","","","");
//obj.add(5,1,getLabel("eOR.Spl-Approving.label","OR"),"<%=executable_name%>&mode=<%=mode%>&viewtype=SA","Spl-Approving","<%=workAreaFrame%>","","","","");
//obj.add(6,1,getLabel("eOR.Co-Signing.label","OR"),"<%=executable_name%>&mode=<%=mode%>&viewtype=CS","Co-Signing","<%=workAreaFrame%>","","","","");
//obj.add(7,1,getLabel("eOR.Resulting.label","OR"),"<%=executable_name%>&mode=<%=mode%>&viewtype=RR","Resulting","<%=workAreaFrame%>","","","","");
//obj.add(8,1,getLabel("Common.Consent.label","COMMON"),"<%=executable_name%>&mode=<%=mode%>&viewtype=CN","Consent","<%=workAreaFrame%>","","","","");
//obj.add(9,1,getLabel("eOR.Recording.label","OR"),"<%=executable_name%>&mode=<%=mode%>&viewtype=RC","Recording","<%=workAreaFrame%>","","","","");
</script>
<script>
document.write(obj);
obj.openAll();
/*if("<%=currentview%>"=="OR")*/
obj.openTo(2,true);
/*else if("<%=currentview%>"=="VW")
obj.openTo(3,true);
else if("<%=currentview%>"=="AU")
obj.openTo(4,true);
else if("<%=currentview%>"=="SA")
obj.openTo(5,true);
else if("<%=currentview%>"=="CS")
obj.openTo(6,true);
else if("<%=currentview%>"=="RR")
obj.openTo(7,true);
else if("<%=currentview%>"=="CN")
obj.openTo(8,true);
else if("<%=currentview%>"=="RC")
obj.openTo(9,true);*/
</script>
	<input type="hidden" name="txtNodePoistions" id="txtNodePoistions" value="">
 	<input type="hidden" name="txtCurrentPosition" id="txtCurrentPosition" value="">
	<input type="hidden" name="txtToolTips" id="txtToolTips" value="">
	<input type="hidden" name="query_string" id="query_string" value="<%=request.getQueryString()%>">
 </form>
</body>
</html>

