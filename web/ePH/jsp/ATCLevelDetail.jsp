<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>



<%-- Mandatory declarations end --%>

<html>
<head>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

		String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?

(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
<script language="Javascript" src="../../eCommon/js/common.js"></script>

<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/ATCClassification.js"></script>
<script language="JavaScript" src="../js/PhCommon.js"></script>
<!-- <script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 -->
<style type="text/css">
*
{
cursor:pointer;
}
</style> 
</head>

<!-- <body topmargin="0" onMouseDown="CodeArrest()" style="overflow-x:hidden;overflow-y:scroll"> -->
<body topmargin="0" onMouseDown="CodeArrest()" onKeyDown="lockKey()" style="overflow-x:hidden;overflow-y:scroll">
<%
	/* Mandatory checks start */
	String mode			=	request.getParameter( "mode" ) ;
	String levelNo		=	request.getParameter("level_num");
	String bean_id		=	"PhATCClassification" ;
	String bean_name	=	 "ePH.ATCClassificationBean";

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	ATCClassificationBean bean = (ATCClassificationBean)
getBeanObject(bean_id,bean_name ,request);
	if(levelNo.equals("1"))
	bean.clear() ;
	bean.setMode( mode ) ;
	/* Initialize Function specific end */

	/*Variable Declarations start*/
	bean.setLanguageId(locale);
	Vector	values				=	null;
	Vector  records				=	null;
	Enumeration elem_values		=	null;
	Enumeration elem_records	=	null;
	String		code			=	"";
	String		description		=	"";
	String		display_seqno	=	"";
	String		fullDesc		=	"";
	String		count			=	"0";
	String		classValue		=	"";
	String		symbol			=	"";
	String		title			=	"";
	String		prevLevelCode	=	"";
	String		prevLevelDesc	=	"";
	String		calling_func	=	"";
	int		row					=	1;
	int		recno				=	0;
	/*Variable Declarations end*/

	/* Bean method call start
	 Calls the corresponding beans method based on level number */
	prevLevelCode	=	request.getParameter("prev_lvl_code");
	prevLevelDesc	=	request.getParameter("prev_lvl_desc");
	calling_func	=	request.getParameter("called_from");
	if(levelNo.equals("1")) {
	values			=	bean.loadLevelValues(levelNo);
	elem_values	=	values.elements();
	}
	if(levelNo.equals("2") || levelNo.equals("3") || levelNo.equals("4") || levelNo.equals("5")) {
		if (mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) {
		bean.setLevelDetail(levelNo,prevLevelCode,prevLevelDesc); }

	values			=	bean.loadLevelValues(levelNo);
	elem_values		=	values.elements();
	}
/* Bean method calling ends */


	if(!calling_func.equals("generic_atc"))	{
	out.println("<script>showAddLink('"+levelNo+"');</script>");

		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) && values.size()==0) {
			out.println("<script>refreshPreviousLevel('"+levelNo+"','"+calling_func+"')</script>");
			return;
		}
	}
%>
<table border="1" align="center" width="100%" cellpadding="0" cellspacing="0" id="desc_detail">

<%
	if(elem_values !=null) {
	while(elem_values.hasMoreElements())
	{
		records			=	(Vector)elem_values.nextElement();

		elem_records	=	records.elements();

		if(elem_records.hasMoreElements())
		{
		code			=(String) elem_records.nextElement();
		description		=(String) elem_records.nextElement();
		display_seqno	=(String) elem_records.nextElement();

		if(! (levelNo.equals("5")) )
		count			=(String) elem_records.nextElement();
		fullDesc		=	description;
		if(description.length()>=40)
		description		=	description.substring(0,40);

		if(count.equals("0")){
				if(!levelNo.equals("5")) {
					symbol	=	"-";
					title	=(recno+1)+".  "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ClicktoaddChildRecords.label","ph_labels");
				}
				else	{
					symbol	= "-";
					title	=(recno+1)+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NoChildRecord.label","ph_labels");
				}
		}
		else {
				symbol	=	"+";
				title	=(recno+1)+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Clicktoview.label","ph_labels")+" "+ count+ " "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ChildRecords.label","ph_labels");
		}

		if ( row % 2 == 0 )
			{
			classValue = "ATCQRYEVEN" ;
			}
		else
			{
			classValue = "ATCQRYODD" ;
			}


	if(calling_func.equals("generic_atc") ) {
			if(count.equals("0") )	{
				symbol = "-";
				title	=(recno+1) +" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NoChildRecord.label","ph_labels");
			}
%>
	<tr>
<% }	else	{ %>


<tr onClick="javascript:changeRowColor(this,'<%=row%>')" >

<!-- Start - To Display + Symbol which has Child Records -->
	<%	}
	 if(symbol.equals("+") && !count.equals("0")) { %>

		<td class="<%=classValue%>" title="<%=title%>" onClick='hideToolTip(); showNextLevel("<%=levelNo%>","<%=java.net.URLEncoder.encode(code)%>","<%=java.net.URLEncoder.encode(fullDesc)%>","<%=calling_func%>");'><%=symbol%></td>
<!-- End -To Display + Symbol which has Child Records -->

<!-- Start - To display - symbol in red color which has no child Record-->
	<%	} else if(count.equals("0") && (!calling_func.equals("generic_atc")) && (!levelNo.equals("5"))){ %>
		<td class="<%=classValue%>" title="<%=title%>" style="color:red;" id='nochild' onClick='showNextLevel("<%=levelNo%>","<%=java.net.URLEncoder.encode(code)%>","<%=java.net.URLEncoder.encode(fullDesc)%>","<%=calling_func%>");'><%=symbol%></td>
<!-- End - to display - symbol in red color-->

<!-- Start -To display the symbol + in normal Color-->
	<%	}	else {%>
		<td class="<%=classValue%>" title="<%=title%>" onMouseOver="style.cursor='default'" onClick='showNextLevel("<%=levelNo%>","<%=java.net.URLEncoder.encode(code)%>","<%=java.net.URLEncoder.encode(fullDesc)%>","<%=calling_func%>");'><%=symbol%></td>
<!-- End -To display the symbol + in normal Color-->

<!-- Description based on calling function -->
	<%	}	if(calling_func.equals("generic_atc") ) {	%>

		<td class="<%=classValue%>" nowrap  title="<%=fullDesc%>" style="cursor:auto;font-size:9;color:navy;">&nbsp;<%=description%></td>

	<% }	else	{	%>

	<td class="<%=classValue%>" nowrap  onClick='displayToolTip("<%=levelNo%>","<%=java.net.URLEncoder.encode(code)%>","<%=java.net.URLEncoder.encode(fullDesc)%>","<%=display_seqno%>","<%=count%>","<%=calling_func%>")' title="<%=fullDesc%>" >&nbsp;
		<%=description%></td>
	<%	}	%>
<!----Description display ends -->
	</tr>
<%
		row++;
		recno++;
	}
}

}

putObjectInBean(bean_id,bean,request);
%>
</table>
<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:20%; visibility:hidden;" bgcolor="blue">
<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="auto" height="100%" align="center">
	<tr><td width="100%" id="t"></td></tr>
</table>
</div>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="level_no" id="level_no" value="<%=levelNo%>">
</form>
</body>
</html>

