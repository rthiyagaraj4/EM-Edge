<!DOCTYPE html>
 <!-- 
/*
 ------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------	
28/04/2020  IN:071537        B Haribabu                                         GHL-CRF-0614
-------------------------------------------------------------------------------------------------------------------------------
*/
 -->
<!-- Created on 23 Dec 2009 =====Shyampriya==== -->

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*,java.util.*,java.text.SimpleDateFormat,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %> <!--Modified for IN:071537 -->
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
	<script language="javascript" src="../../ePH/js/ExtGenericLink.js"></script>	
	<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String genericID			=	request.getParameter("generic_id");
	String genericName				=	request.getParameter("generic_name");
	String product_id				=	request.getParameter("product_id");
	String ext_generic_id		=	request.getParameter("ext_generic_id");
	String eff_status				=	request.getParameter("eff_status");

	String bean_id					=	"ExtGenericLinkBean";
	String bean_name			=	"ePH.ExtGenericLinkBean";
	ExtGenericLinkBean bean		=	(ExtGenericLinkBean) getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	boolean searched				=	(request.getParameter("searched") == null) ?false:true;
	String classvalue				=	"";
	
	//Added for IN:071537 start
	String type						=	bean.checkForNull(request.getParameter("type"));
			System.out.println("type >> "+type);
    Connection con				= null;
	 
    boolean type_appl=false;
    String type_appl_yn="N";
			
	try 
	{
		con						= ConnectionManager.getConnection(request);
		type_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_THIRDPARTY_TYPE_APPL");
	} 
	catch (Exception e) 
	{
		e.printStackTrace(System.err);
		System.out.println(" Error in Criteria Page " + e.getMessage());
	} 
	finally 
	{
		if (con != null) ConnectionManager.returnConnection(con, request);
	}
	
	//Added for IN:071537 end

	try{

			genericID	=	 CommonBean.checkForNull(genericID)+"%";
			genericName			=	 CommonBean.checkForNull(genericName)+"%";
			ext_generic_id			=	 CommonBean.checkForNull(ext_generic_id)+"%";
			if(product_id.equals(" "))
				product_id = "%";
			
			HashMap sqlMap				=	 new HashMap();
			HashMap funcMap			=	 new HashMap();
			ArrayList displayFields		=	 new ArrayList();
			ArrayList chkFields			=	 new ArrayList();
			
            //Modified for IN:071537 start
			String sql = "Select a.GENERIC_ID, b.GENERIC_NAME, a.PRODUCT_ID, a.EXT_PROD_GENERIC_ID, a.EFF_STATUS, NVL(a.THIRDPARTY_TYPE, 'Molecule') Type from PH_GENERIC_EXT_PROD_REF a, PH_GENERIC_NAME_LANG_VW b where upper(a.generic_id) like upper(?) and upper(b.generic_name) like upper(?) and upper(a.product_id) like upper(?) and upper(a.ext_prod_generic_id) like upper(?) and upper(a.eff_status) like upper(?) and a.generic_id = b.generic_id and upper(b.language_id)=upper(?)";
			if(type_appl){
				type_appl_yn="Y";
				sql=sql+ "AND UPPER (NVL(a.THIRDPARTY_TYPE, 'Molecule')) LIKE UPPER (?)";
			}
            //Modified for IN:071537 end
			sqlMap.put("sqlData",sql);

			displayFields.add("GENERIC_ID");
			displayFields.add("GENERIC_NAME");
			displayFields.add("PRODUCT_ID");
			//Modified for IN:071537 start
			if(type_appl){
			displayFields.add("Type");
			}
			//Modified for IN:071537 end
			displayFields.add("EXT_PROD_GENERIC_ID");
			displayFields.add("EFF_STATUS");

			chkFields.add(genericID);	
			chkFields.add(genericName);
			chkFields.add(product_id);
			chkFields.add(ext_generic_id);
			chkFields.add(eff_status);
			chkFields.add(locale);
			//Modified for IN:071537 start
			if(type_appl){
				chkFields.add(type);
			}
			//Modified for IN:071537 end
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);

			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);	

			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
%>
				<form name="ExtGenericLinkQueryResultForm" id="ExtGenericLinkQueryResultForm">
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
						<th><fmt:message key="ePH.GenericID.label" bundle="${ph_labels}"/></th>
						<th><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="ePH.ProductID.label" bundle="${ph_labels}"/></th>
						<!--Added for IN:071537 start-->
						<%if(type_appl){ %>
						<th><fmt:message key="ePH.Type.label" bundle="${ph_labels}"/></th>
						<%} %>
						<!--Added for IN:071537 end -->
						<th><fmt:message key="ePH.ExternalGenericID.label" bundle="${ph_labels}"/></th>
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
								 if(colCount == 1) //generic name
									width = "35%";
								 if(colCount == 2) // product id
									{
										width = "20%";
									//	if(colVal.equals("FDB"))
									//		colVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FirstDataBank.label","ph_labels");
									}
								//Modified for IN:071537	
								 if(type_appl){
									 
									 if(colCount ==3) // type
										 {
										width = "10%";
								 		if(colVal==null)
											colVal ="Molecule";
								 		if(colVal.equals("GenericItem"))
											colVal ="Generic Item";
								 		if(colVal.equals("SubstanceClass"))
											colVal ="Substance Class";
								 		if(colVal.equals("ActiveCompositionGroup"))
											colVal ="Active Composition Group";
								 		}
								
								 	  if(colCount ==4) // ext_prod_generic_id
											width = "25%";
									  if(colCount == 5) // nature
												{
												if(colVal.equals("E"))
													colVal="<img src=\"../../eCommon/images/enabled.gif\">";
												else
													colVal="<img src=\"../../eCommon/images/disabled.gif\">";
								}
								 }
								 else{
									 if(colCount ==3) // ext_prod_generic_id
											width = "25%";
									if(colCount == 4) // nature
									{
										if(colVal.equals("E"))
											colVal="<img src=\"../../eCommon/images/enabled.gif\">";
										else
											colVal="<img src=\"../../eCommon/images/disabled.gif\">";
									}
								 }
								 //Modified for IN:071537 end
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
<input type="hidden" name="type_appl_yn" id="type_appl_yn" value="<%=type_appl_yn%>"><!--Added for IN:071537 start-->
			</form>
<%
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/ExtGenericLinkQueryResult.jsp", searched) );//-Modified for IN:071537
		} catch(Exception e) 
				{
					out.print("Exception @ Result JSP :"+e.toString());
				}
%>
</body>
</html>
					

