<!DOCTYPE html>
<!-- Created on 07 Dec 2009 =====Shyampriya==== -->

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*,java.util.*,java.text.SimpleDateFormat" %>
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
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
	(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/ExtProdLink.js"></script>	
	<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String drug_code			=	request.getParameter("drug_code");
	String drug_desc				=	request.getParameter("drug_desc");
	String product_id				=	request.getParameter("product_id");
	String ext_prod_drug_code		=	request.getParameter("ext_prod_drug_code");
	String eff_status				=	request.getParameter("eff_status");
	String type						=	"";

	String bean_id					=	"ExtProdLinkBean";
	String bean_name			=	"ePH.ExtProdLinkBean";
	ExtProdLinkBean bean		=	(ExtProdLinkBean) getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	boolean searched				=	(request.getParameter("searched") == null) ?false:true;
	String classvalue				=	"";

	try{

			drug_code	=	 CommonBean.checkForNull(drug_code)+"%";
			drug_desc			=	 CommonBean.checkForNull(drug_desc)+"%";
			ext_prod_drug_code			=	 CommonBean.checkForNull(ext_prod_drug_code)+"%";
			if(product_id.equals(" "))
				product_id = "%";
			
			HashMap sqlMap				=	 new HashMap();
			HashMap funcMap			=	 new HashMap();
			ArrayList displayFields		=	 new ArrayList();
			ArrayList chkFields			=	 new ArrayList();

			String sql = "Select a.DRUG_CODE, b.DRUG_DESC, a.PRODUCT_ID, a.EXT_PROD_DRUG_CODE, a.EFF_STATUS, A.TYPE from PH_DRUG_EXT_PROD_DRUG a, PH_DRUG_LANG_VW b where upper(a.drug_code) like upper(?) and upper(b.drug_desc) like upper(?) and upper(a.product_id) like upper(?) and upper(a.ext_prod_drug_code) like upper(?) and upper(a.eff_status) like upper(?) and a.drug_code = b.drug_code and upper(b.language_id)=upper(?)";

			sqlMap.put("sqlData",sql);

			displayFields.add("DRUG_CODE");
			displayFields.add("DRUG_DESC");
			displayFields.add("PRODUCT_ID");
			displayFields.add("Type");
			displayFields.add("EXT_PROD_DRUG_CODE");
			displayFields.add("EFF_STATUS");

			chkFields.add(drug_code);	
			chkFields.add(drug_desc);
			chkFields.add(product_id);
			chkFields.add(ext_prod_drug_code);
			chkFields.add(eff_status);
			chkFields.add(locale);

			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);

			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);	

			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
%>
				<form name="ExtProductLinkQueryResultForm" id="ExtProductLinkQueryResultForm">
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
						<th><fmt:message key="Common.DrugCode.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="ePH.ProductID.label" bundle="${ph_labels}"/></th>
						<th><fmt:message key="ePH.Type.label" bundle="${ph_labels}"/></th>
						<th><fmt:message key="ePH.ExternalDrugCode.label" bundle="${ph_labels}"/></th>
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
								 colVal = (String)records.get(colCount)==null?"-":(String)records.get(colCount);
								 if(colCount == 1) //drug description
									width = "35%";
								 if(colCount == 2) // product id
									{
										width = "20%";
										if(colVal.equals("FDB"))
											colVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FirstDataBank.label","ph_labels");
									}
									if(colCount ==3) // type
										width = "10%";
								 if(colCount ==4) // ext_prod_dug_code
										width = "25%";
								if(colCount == 5) // nature
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
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/ExtProdLinkQueryResult.jsp", searched) );
		} catch(Exception e) 
				{
					out.print("Exception @ Result JSP :"+e.toString());
				}
%>
</body>
</html>
					

