<!DOCTYPE html>
	<%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import="ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<% 
    request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//endss
	String locale			= (String)session.getAttribute("LOCALE");

	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
 
<script language="Javascript" src="../../eCommon/js/common.js"></script>
<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<!--<script language="Javascript" src="../../ePH/js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">

<form name="ApplicableUomForm" id="ApplicableUomForm">

<%
	String bean_id			= "UomForFormBean" ;
	String bean_name		= "ePH.UomForFormBean";
	String form_code		=	request.getParameter("form_code");
	String firstTime		=	request.getParameter("firstTime");
	String link				=	request.getParameter("link");
	String uom_code			=	"";
	String uom_desc			=	"";
	String uom_default		=	"";


	String uom_select		=	"";
	String default_status	=	"";
	String select_status	=	"";
	String classval			=	"";
	String style			=	"";
	String flag				=	"";
	String style_for_select	=	"";
	String tooltip			=	"";
	String code_found		=	"";


	ArrayList	UomValues	=	null;
	ArrayList	associatedUomValues	=	null;
	boolean forAssociate	=	false;

	boolean isAssociate			=	false;


	if(link!=null && link.equals("associate"))	
	forAssociate	=	true;

	

	/* Load values thru bean start */
	UomForFormBean bean = (UomForFormBean)
    getBeanObject(bean_id,bean_name ,request) ;
	bean.setLanguageId(locale);
	String mode	=	bean.getMode() ;
	if(mode==null || mode.equals(""))
	bean.setMode(CommonRepository.getCommonKeyValue("MODE_INSERT"));

	if(form_code!=null)
		bean.setFormCode(form_code);
	else
		form_code	= bean.getFormCode();

	if(firstTime.equals("Y"))	{
	bean.loadApplicableUom(locale);
	bean.loadAssociatedUom(form_code);
	}

	if (forAssociate)	{
	//	associatedUomValues	=	bean.getAssociatedUom();
	//	if(associatedUomValues!=null)	
	//		bean.getConsolidatedUom();
	
		UomValues			=	bean.getStoredUom();
		isAssociate			=	true;
		
	}
	else	{
		if(firstTime.equals("Y"))	{
		associatedUomValues	=	bean.getAssociatedUom();
		if(associatedUomValues!=null)	
			bean.getConsolidatedUom();
		}
		UomValues			=	bean.getApplicableUom();
		code_found			=	bean.getDefault();
		
	}
	/* Load values thru bean end */

	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	int start		= 0 ;
	int end			= 0 ;
	int i			= 1;
	int maxRecord	= 0;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

	maxRecord		=	UomValues.size();
%>
<table border="0" cellpadding="0" cellspacing="0" width="90%" align="center">
<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;</td>
		<td align="right">
	<%
	if ( !(start <= 1) )
		out.println("<A HREF='javascript:parent.navigation(document.ApplicableUomForm,\"previous\")'  text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>&nbsp;&nbsp;");

	if ( !( (start+14) > maxRecord ) )
		out.println("<td align='right'><A HREF='javascript:parent.navigation(document.ApplicableUomForm,\"next\")'  text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	%>
	</td></tr>
</table>
<table border="1" width="90%" cellspacing="0" cellpadding="0" align="center">
	<tr>
	<th>&nbsp;</th>
	<th> <fmt:message key="ePH.ApplicableUOM.label" bundle="${ph_labels}"/>	</th>
	<th> <fmt:message key="ePH.DefaultUOM.label" bundle="${ph_labels}"/>	</th>
	<th> <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>			</th>
	</tr>
	<tr>
<%	
if ( start != 1)
for( int j=1; j<start; i++,j++ ){}

while(i<=end && i<=UomValues.size())	{
			
			select_status		=	"";
			style				=	"";

			default_status		=	"";
			style_for_select	=	"";
			tooltip				=	"";

			Hashtable record	=(Hashtable)UomValues.get((i-1));
			uom_code	=	(String)record.get("code");
			uom_desc	=	(String)record.get("desc");
			flag		=	(String)record.get("flag");

			if(record.get("default")!=null)	{
			uom_default	=	(String)record.get("default");

			if(uom_default.equals("Y")) 
					default_status	="checked";
			}

			if(record.get("select")!=null)	{
			uom_select	=	(String)record.get("select");

			if(uom_select.equals("Y")) 
					select_status	="checked";
			}


//out.println("<script>alert('entered in select with flag:"+flag+"');</script>");
				if(flag.equals("DB") || flag.equals("D") || flag.equals("U"))	{
					  style					=	"style='color:#FF5400'";
				}
				
				if(flag.equals("D")) {
						style_for_select	=	"DATACHANGE";
						tooltip				=	"Record has been Modified";
				}
				

		
		if(i%2==0) 
			classval="QRYODD";
		else
			classval="QRYEVEN";  
		if(style_for_select.equals(""))	style_for_select=classval;
%>
	<input type="hidden" name="UomCode_<%=i%>" id="UomCode_<%=i%>" value="<%=uom_code%>">
	<input type="hidden" name="UomDesc_<%=i%>" id="UomDesc_<%=i%>" value="<%=uom_desc%>">
	<input type="hidden" name="flag_<%=i%>" id="flag_<%=i%>" value="<%=flag%>">
	<input type="hidden" name="def_status_<%=i%>" id="def_status_<%=i%>" value="<%=default_status%>">
<% if( bean.findUomDetail(uom_code)) { %>
	<td class="<%=classval%>" width="2%"><a href="javascript:parent.showUOMDesc('<%=uom_code%>')">+</a></td>
<%	} else	{	%>
	<td  class="<%=classval%>" width="2%">&nbsp;</td>
<%	}	%>

	<td  class="<%=classval%>" <%=style%> width="80%"><%=uom_desc%> </td>
<%	if(code_found.equals("") && !flag.equals("DB") && !flag.equals("U")|| forAssociate)	{	%>
	<td  class="<%=classval%>" width="10%" id="td_<%=i%>"><input type="checkbox" name="default_<%=i%>" id="default_<%=i%>" <%=default_status%> onClick="parent.unCheckOthers('<%=i%>')"></td>
<%	} else if(!code_found.equals("") && code_found.equals(uom_code))	{	
		if(default_status.equals("") && !flag.equals("D")) {
			classval="DATACHANGE";
			tooltip =" Default UOM is changed ";
		}
%>
	<td class="<%=classval%>" width="10%" id="td_<%=i%>" ><input type="checkbox" name="default_<%=i%>" id="default_<%=i%>" <%=default_status%> onClick="parent.unCheckOthers('<%=i%>')"  title="<%=tooltip%>"></td>
<%	} else	{	
//out.println("<script>alert('here with "+default_status+"');</script>");
			if(default_status.equals("checked") || flag.equals("I"))	{
				if(default_status.equals("checked") && flag.equals("U")){
					classval="DATACHANGE";
					tooltip =" New Default UOM ";
				}
		%>
		<td class="<%=classval%>" width="10%" id="td_<%=i%>"><input type="checkbox" name="default_<%=i%>" id="default_<%=i%>" <%=default_status%> onClick="parent.unCheckOthers('<%=i%>')"   title="<%=tooltip%>"></td>
			<% } else { %>
	<td class="<%=classval%>" width="10%" id="td_<%=i%>"><input type="checkbox" name="default_<%=i%>" id="default_<%=i%>" <%=default_status%> onClick="parent.unCheckOthers('<%=i%>')"></td></td>
<%	}			}	%>
	<td class="<%=style_for_select%>" width="10%" title="<%=tooltip%>" id="sel_td_<%=i%>"><input type="checkbox" name="select_<%=i%>" id="select_<%=i%>" <%=select_status%> ></td></tr>  
<%
i++;	

}putObjectInBean(bean_id,bean,request);
%>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="start" id="start" value="<%=start%>">
<input type="hidden" name="end" id="end" value="<%=end%>">
<input type="hidden" name="frm_link" id="frm_link">
<input type="hidden" name="isAssociate" id="isAssociate" value="<%=isAssociate%>">
<input type="hidden" name="form_code" id="form_code" value="<%=form_code%>">
<input type="hidden" name="def_code" id="def_code" value="<%=bean.getDefault()%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
</table>
</form>
</body>
<script>parent.disableFormofDrug()</script>
</html>

