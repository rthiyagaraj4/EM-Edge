<!DOCTYPE html>
<!-- Created on 05 Aug 2009 =====Shyampriya==== -->

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*,java.util.*,java.text.SimpleDateFormat,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>

<% 
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
	(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/ProductName.js"></script>	
	<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String product_code		=	request.getParameter("product_code");
	String long_desc				=	request.getParameter("long_desc");
	String short_desc				=	request.getParameter("short_desc");
	String admixture_type		=	request.getParameter("admixture_type");
	String eff_status				=	request.getParameter("eff_status");

	String bean_id					=	"ProductNameBean";
	String bean_name			=	"ePH.ProductNameBean";
	ProductNameBean bean		=	(ProductNameBean) getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	boolean searched				=	(request.getParameter("searched") == null) ?false:true;
	String classvalue				=	"";

	try{

			product_code	=	 CommonBean.checkForNull(product_code)+"%";
			long_desc			=	 CommonBean.checkForNull(long_desc)+"%";
			short_desc			=	 CommonBean.checkForNull(short_desc)+"%";
			if(admixture_type.equals(" "))
				admixture_type = "%";
			
			HashMap sqlMap				=	 new HashMap();
			HashMap funcMap			=	 new HashMap();
			ArrayList displayFields		=	 new ArrayList();
			ArrayList chkFields			=	 new ArrayList();

			String sql = "Select PRODUCT_CODE, LONG_DESC, SHORT_DESC, ADMIXTURE_TYPE, EFF_STATUS from PH_ADMIXTURE_PRODUCTS_LANG_VW where UPPER(PRODUCT_CODE) like UPPER(?) and UPPER(LONG_DESC) like UPPER(?) and UPPER(SHORT_DESC) like UPPER(?) and UPPER(ADMIXTURE_TYPE) like UPPER(?) and UPPER(EFF_STATUS) like UPPER(?) and UPPER(LANGUAGE_ID) like UPPER(?)";

			sqlMap.put("sqlData",sql);

			displayFields.add("PRODUCT_CODE");
			displayFields.add("LONG_DESC");
			displayFields.add("SHORT_DESC");
			displayFields.add("ADMIXTURE_TYPE");
			displayFields.add("EFF_STATUS");
				
			chkFields.add(product_code);	
			chkFields.add(long_desc);
			chkFields.add(short_desc);
			chkFields.add(admixture_type);
			chkFields.add(eff_status);
			chkFields.add(locale);
	
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);

			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);	
			
			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
%>
				<form name="ProductNameQueryResultForm" id="ProductNameQueryResultForm">
					<table cellpadding=0 cellspacing=0 width="97%" align="center">
						<tr>
							<td width="80%" class="white">&nbsp;</td>
							<td width="20%" class="white">&nbsp;
<%
		// For display the previous/next link
	     out.println(result.get(1));

%>
							</td>
						</tr>
					</table>

					<table  border="1" cellpadding="0" cellspacing="0" width="97%" align="center">
						<th><fmt:message key="ePH.ProductNameCode.label" bundle="${ph_labels}"/></th>
						<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="ePH.AdmixtureType.label" bundle="${ph_labels}"/></th>
						<th><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></th>
					
<%
		
					ArrayList records=new ArrayList();
					for(int recCount=2; recCount<result.size(); recCount++) 
					{
						if ( recCount % 2 == 0 )
							classvalue = "QRYEVEN" ;
						else
							classvalue = "QRYODD" ;
%>
						<tr onClick="ModifyRow(this);">
<%
						String link_columns = "0";
						String colVal = "";
						String width ="";
						records=(ArrayList) result.get( recCount );
						for(int colCount=0; colCount<records.size(); colCount++)
							{
								 colVal = (String)records.get(colCount);
								 if(colCount == 1) // long description
									width = "45%";
								 if(colCount == 2) // short description
									width = "20%";
								 if(colCount ==3) // Admixture type
								{
									width = "30%";
									if(colVal.equals("A"))
										colVal = "All";
									if(colVal.equals("CR"))
										colVal = "Compound Rx";
									if(colVal.equals("IV"))
										colVal = "IV Rx";
									if(colVal.equals("OA"))
										colVal = "Oncology Admixture";
								}
								if(colCount == 4) // nature
								{
									if(colVal.equals("E"))
										colVal="<img src=\"../../eCommon/images/enabled.gif\">";
									else
										colVal="<img src=\"../../eCommon/images/disabled.gif\">";
								}
								if( colCount == 0 )
									{
%>
										<td class="<%=classvalue%>" width = "15%" onmouseover="changeCursor(this);" ><font class='HYPERLINK'>  <%=colVal%></font></td>
<%
									}
								else
									{
%>
										<td class="<%=classvalue%>" width=<%=width%> onclick="disableClick(event);" >  <%=colVal%> </td>
<%
									}

								}
						
%>
					</tr>
				
<%
				    } // end for
%>
				</table>
<%
				out.flush();
			}

		else
			{
%>
				 <script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script> 
<%
			}
%>
			</form>
<%
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/ProductNameQueryResult.jsp", searched) );
		} catch(Exception e) 
				{
					out.print("Exception @ Result JSP :"+e.toString());
				}
%>
</body>
</html>

