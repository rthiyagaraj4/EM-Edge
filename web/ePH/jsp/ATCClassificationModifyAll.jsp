<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"  import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<html>
	<head>
<%

		request.setCharacterEncoding("UTF-8");
//added By Himanshu Start.
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
		String locale			= (String)session.getAttribute("LOCALE");
		
		String level_num	=	request.getParameter("level");
		String title		=	"";
		String classval		=	"";
		if(level_num.equals("1"))   
			title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AnatomicalClass.label","ph_labels");
		if(level_num.equals("2"))   
			title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TherapeuticClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MainClass.label","ph_labels")+")";
		if(level_num.equals("3"))   
			title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TherapeuticClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SubClass.label","common_labels")+")";
		if(level_num.equals("4"))   
			title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ChemicalClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MainClass.label","ph_labels")+")";
		if(level_num.equals("5"))   
			title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ChemicalClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SubClass.label","common_labels")+")";
%>
		<title><fmt:message key="Common.ATCClassification.label" bundle="${common_labels}"/> -<%=title%> </title>

<% 
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>

	<!-- <body topmargin="0"> -->
	<body onMouseDown="" topmargin="0">
		<form name="ATCClassification_ModifyAll" id="ATCClassification_ModifyAll">
<%
			/* Mandatory checks start */
			String mode	= request.getParameter( "mode" ) ;
			String bean_id = "PhATCClassification" ;
			String bean_name = "ePH.ATCClassificationBean";

			if ( mode == null || mode.equals("") )
				return ;
			if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
				return ;
			/* Mandatory checks end */

			/* Initialize Function specific start */
			ATCClassificationBean bean = (ATCClassificationBean)getBeanObject(bean_id,bean_name ,request);
			bean.setLanguageId(locale);
			bean.setMode( mode ) ;
			bean.setInnerMode("MODIFY_ALL");
			/* Initialize Function specific end */

			/* Variable Declarations Start*/
			Vector	values						=	null;
			Vector  records						=	null;
			Enumeration elem_values				=	null;
			Enumeration elem_records			=	null;
			String	title1						=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AnatomicalClass.label","ph_labels");
			String	title2						=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TherapeuticClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MainClass.label","ph_labels")+")";
			String	title3						=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TherapeuticClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SubClass.label","common_labels")+")";
			String	title4						=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ChemicalClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MainClass.label","ph_labels")+")";
			String	code						=	"";
			String	description					=	"";
			String	display_seqno				=	"";
			String	count						=	"";
			String  enabled						=	"";
			String  anatomical_class_code		=	"";
			String  anatomical_class_desc		=	"";
			String	therapeutic_class_code		=	"";
			String	therapeutic_class_desc		=	"";
			String	therapeutic_class_subcode	=	"";
			String	therapeutic_class_subdesc	=	"";
			String	chemical_class_code			=	"";
			String	chemical_class_desc			=	"";
			String	chemical_class_subcode		=	"";
			String	chemical_class_subdesc		=	"";
			boolean entered						= false;
			boolean enabled_status				= false;
			String	checked						= "";
			String	delete_status				= "";
			String	delete_all_status			= "";
			String checked_status				= "";
			String firstTime					= "";
			boolean del_status					= false;
			String	link						=	"";
			/* Variable Declarations End*/

			firstTime		=	request.getParameter("firstTime");
			link			=	request.getParameter("link");

			if(firstTime == null || firstTime.equals(""))
			firstTime		= "yes";



			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;

			int start		=	0 ;
			int end			=	0 ;
			int i			=	1;
			double maxRecord	= 0;

			if ( from == null )
				start = 1 ;
			else
				start = Integer.parseInt( from );

			if ( to == null )
				end = 14 ;
			else
				end = Integer.parseInt( to ) ;


			/******* Fetch Values from the bean ************/
			if(firstTime.equals("yes"))	{
				values			=	bean.loadLevelValues(level_num);
			//	if(!level_num.equals("1"))
				values			=	bean.getRecords(level_num);

				maxRecord		=	values.size();

			}
			else	{
				values			=	bean.getTempValues();
				maxRecord		=	values.size();
			}
			/***********************************************/
			//out.println("<script>alert('start:"+start+"');</script>");
			int pagenos	=	(int)java.lang.Math.ceil(maxRecord/14);

			if(level_num.equals("2")) {
				anatomical_class_code	=	title1;
				anatomical_class_desc	=	bean.getATCLev1Desc();
			}
			if(level_num.equals("3")) {
				anatomical_class_code		=	title1;
				anatomical_class_desc		=	bean.getATCLev1Desc();
				therapeutic_class_code		=	title2;
				therapeutic_class_desc		=	bean.getATCLev2Desc();
			}
			if(level_num.equals("4")) {
				anatomical_class_code		=	title1;
				anatomical_class_desc		=	bean.getATCLev1Desc();
				therapeutic_class_code		=	title2;
				therapeutic_class_desc		=	bean.getATCLev2Desc();
				therapeutic_class_subcode	=	title3;
				therapeutic_class_subdesc	=	bean.getATCLev3Desc();
			}
			if(level_num.equals("5")) {
				anatomical_class_code		=	title1;
				anatomical_class_desc		=	bean.getATCLev1Desc();
				therapeutic_class_code		=	title2;
				therapeutic_class_desc		=	bean.getATCLev2Desc();
				therapeutic_class_subcode	=	title3;
				therapeutic_class_subdesc	=	bean.getATCLev3Desc();
				chemical_class_code			=	title4;
				chemical_class_desc			=	bean.getATCLev4Desc();
			}
%>
			<table border="0" cellpadding="0" cellspacing="0" width="99%"  align="center">
				<tr>
					<th align="left" class="th" width="22%"><fmt:message key="ePH.ATCClass.label" bundle="${ph_labels}"/></th>
					<th align="left" class="th" width="78%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				</tr>
				<tr>
					<td align="left" class="td" width="22%">&nbsp;<%=anatomical_class_code%></td>
					<td align="left" class="td" width="78%">&nbsp;<%=anatomical_class_desc%></td>
				</tr>
				<tr>
					<td align="left" class="td" width="22%">&nbsp;<%=therapeutic_class_code%></td>
					<td align="left" class="td" width="78%" >&nbsp;<%=therapeutic_class_desc%></td>
				</tr>
					<tr>
					<td align="left" class="td" width="22%" >&nbsp;<%=therapeutic_class_subcode%></td>
					<td align="left" class="td" width="78%" >&nbsp;<%=therapeutic_class_subdesc%></td>
				</tr>
				<tr>
					<td align="left" class="td" width="22%" >&nbsp;<%=chemical_class_code%></td>
					<td align="left" class="td" width="78%" >&nbsp;<%=chemical_class_desc%></td>
				</tr>
				<tr>
					<td align="left" class="td" width="22%" >&nbsp;<%=chemical_class_subcode%></td>
					<td align="left" class="td" width="78%" >&nbsp;<%=chemical_class_subdesc%></td>
				</tr>
			</table>

			<table border="0" cellpadding="0" cellspacing="0"  align="center">
			<tr><td colspan='3' class='white'>&nbsp;</td></tr>
				<tr>
				<td align='left' class='dtd'><fmt:message key="ePH.Modify/Delete.label" bundle="${ph_labels}"/> <%=title%> Details</td>
				<td align='right' class='dtd'><fmt:message key="ePH.PageNo.label" bundle="${ph_labels}"/>:</td>
				<%
				for(int pageno=1; pageno<=pagenos; pageno++)	{
				%>
				<td align='right' class='white'>
				<A  HREF='javascript:parent.navigation(document.ATCClassification_ModifyAll,"page","<%=pageno%>")' style="text-decoration='none'"><%=pageno%></A>
				</td>
				<%
				}
				%>
				</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0"  align="center">
				<tr>
					<th align="center" ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
					<th align="center" ><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
					<th align="center" ><fmt:message key="ePH.DisplaySequenceNo.label" bundle="${ph_labels}"/></th>
					<th align="center" ><fmt:message key="Common.delete.label" bundle="${common_labels}"/><input type="checkbox" name="del_all" id="del_all" title="Check all the enabled delete checkboxes" <%=checked%> onClick="parent.checkAllDelete()"></th>
				</tr>
<%
				elem_values		=	values.elements();
				if(elem_values != null) {
					while(elem_values.hasMoreElements() && i<=end){

						if ( start != 1 && !entered)	{
							entered = true;
							for( int j=1; j<=start; j++ ){
								if(j!=start)
									i++;
									records			=	(Vector)elem_values.nextElement();
								}
						}
						else{
							records			=	(Vector)elem_values.nextElement();
						}

						elem_records	=	records.elements();



						if(elem_records.hasMoreElements()){
							code			=(String) elem_records.nextElement();
							description		=(String) elem_records.nextElement();
							display_seqno	=(String) elem_records.nextElement();

							if(! (level_num.equals("5")) )
								count				=(String) elem_records.nextElement();
							if(firstTime.equals("no"))	{
								if(elem_records.hasMoreElements())	{
									delete_status		=(String) elem_records.nextElement();
									if(delete_status.equals("Y"))
										checked_status	="checked";
									else
										checked_status	="";
								}

								if(elem_records.hasMoreElements())	{
									delete_all_status		=(String) elem_records.nextElement();
									if(delete_all_status.equals("Y"))
										delete_all_status	="checked";
									else
										delete_all_status	="";
								}

							}
							del_status	=	bean.getDeleteStatus(level_num,code);
							if(del_status==true)		{
								enabled				=	"enabled";
								enabled_status		=	true;
							}
							else
								enabled		=	"disabled";
							if(i%2==0)
								classval="QRYDATA";
							else
								classval="QRYEVEN";

	%>
							<tr>
								<td align="left"  class="<%=classval%>"><input type="text" name="code_<%=i%>" id="code_<%=i%>" maxlength="8" size="8" value="<%=code%>" readOnly></td>
								<td align="left"  class="<%=classval%>"><input type="text" name="desc_<%=i%>" id="desc_<%=i%>" maxlength="100" size="75" value="<%=description%>" onBlur="parent.changeColor(this)"></td>
								<td align="left"  class="<%=classval%>"><input type="text" name="seqno_<%=i%>" id="seqno_<%=i%>" maxlength="6" size="6" value="<%=display_seqno%>" style="text-align:right"  onBlur="parent.changeColor(this);parent.CheckPositiveNumber(this);parent.chkDecimal(this);parent.checkForZero(this)" onKeyPress="return(parent.ChkNumberInput(this,event,0))" ></td>
								<td align="left" class="<%=classval%>"><input type="checkbox" name="delete_<%=i%>" id="delete_<%=i%>" <%=enabled%>  onClick="parent.uncheckAllDelete(this);" <%=checked_status%>></td>
							</tr>
							<input type="hidden" name="count_<%=i%>" id="count_<%=i%>" value="<%=count%>">
<%
							i++;

						}
					}
				}
				if(enabled_status==true)	{
					out.println("<script>parent.enableDeleteAll()</script>");
				}
				else	{
					out.println("<script>parent.disableDeleteAll()</script>");
				}

				if(delete_all_status.equals("checked"))	{
					out.println("<script>parent.checkDeleteAll()</script>");
				}
%>
			</table>

			<input type="hidden" name="level_no" id="level_no" value="<%=level_num%>">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="delete_all" id="delete_all">
			<input type="hidden" name="start" id="start" value="<%=start%>">
			<input type="hidden" name="end" id="end" value="<%=end%>">
			<input type="hidden" name="recCount" id="recCount" value="<%=i%>">
			<input type="reset" name="resetButton" id="resetButton" style="visibility:hidden">
			<input type="hidden" name="resetStatus" id="resetStatus" value="">
			<input type="hidden" name="totalRecords" id="totalRecords" value="14">
		</form>
	</body>
<% if(link==null || link.equals("")) { %>
<script>
	 parent.validateAll()
</script>
<% } 

putObjectInBean(bean_id,bean,request);
%>
</html>

