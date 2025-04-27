<% /*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

26/04/2023  40016           Ranjith P R       27/04/2023         Ramesh Goli        ML-MMOH-CRF-1823                 
----------------------------------------------------------------------------------------------------------------------------------------------------------	
 */ %>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>

<%@ page import="java.sql.*,webbeans.eCommon.*,eOR.*,java.text.*,com.ehis.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%><!-- 40016-end-->
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>

<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/UserForReview.js"></script>
	<script language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 <body onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 
<%
	String readOnly = "" ;
	/* Mandatory checks start */
	   request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	

	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String pract_id			= request.getParameter("pract_id");
	String bean_id = "Or_UserForReview" ;
	String bean_name = "eOR.UserForReview";
	String disabled = "" ;
	String auth_disabled = "" ;
	String quotaDisabled="disabled";//40016
	
	/* Added by Uma on 8/22/2009 for PMG20089 CRF 641*/
	String allow_priv_to_authorise_yn ="";
	/* End Here*/
	//out.println("moddde : "+mode);
	mode = mode.trim();
	

//	if ( !(mode.equals( CommonInterface.MODE_MODIFY ) || mode.equals( CommonInterface.MODE_INSERT )) )
//		return ;

/* Mandatory checks end */
	
	/* Initialize Function specific start */
	UserForReview bean = (UserForReview)getBeanObject( bean_id, bean_name , request) ;  
	bean.clear() ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setMode( mode ) ;
	/* Added by Uma on 8/22/2009 for PMG20089 CRF 641*/
	allow_priv_to_authorise_yn = bean.getAuthorisationOrOrderingYn("AUT");
	/*End here*/
	ArrayList Category_Data = new ArrayList();
	String responsibility_id = (String)session.getValue("responsibility_id") ;
	/* Initialize Function specific end */
	String resp_id			= request.getParameter("resp_id");
	if(resp_id == null || resp_id.equals("null")|| resp_id.equals(" ")) resp_id = "";
	if(pract_id == null || pract_id.equals("null")||pract_id.equals(" ")) pract_id = "";
	/* Added by Uma on 8/22/2009 for PMG20089 CRF 641*/
	if(allow_priv_to_authorise_yn == null || allow_priv_to_authorise_yn.equals("null")||allow_priv_to_authorise_yn.equals(" ")) allow_priv_to_authorise_yn = "N";
	/* End here */
	resp_id = resp_id.trim();
	pract_id = pract_id.trim();
	bean.setResponsibility(resp_id);
	bean.setPractitioner(pract_id);
	//40016 start
   	boolean siteQuotaLimitYN  = false;
   	Connection con = null;
   	try{
   	con = ConnectionManager.getConnection();
   	siteQuotaLimitYN = CommonBean.isSiteSpecific(con, "PH","PH_QUOTA_LIMIT_FOR_DRUG");
   	}
   	 catch(Exception e) {
           System.out.println("error:"+e.getMessage());
   		e.printStackTrace();
       }
   	finally {
   		if(con != null)
   			con.close();
   	}
       //40016 end
	/* Added by Uma on 8/22/2009 for PMG20089 CRF 641*/
	if(allow_priv_to_authorise_yn.equalsIgnoreCase("Y"))
	{
		auth_disabled = "disabled";
	}
	else
	{
		auth_disabled = "";
	}
	/*End Here*/
	%>

<form name="user_for_review_dtl" id="user_for_review_dtl" method="post" target="messageFrame">
<table cellpadding=3 cellspacing=0 width="100%" align=center>
<tr>
	<td colspan=2>
		<table class='grid' width='100%'>
		<tr>
			<td class=' COLUMNHEADER' width='40%'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			<td class=' COLUMNHEADER' width='10%' ><fmt:message key="Common.Authorization.label" bundle="${common_labels}"/></td>
			<td class=' COLUMNHEADER' width='10%' ><fmt:message key="Common.Cosign.label" bundle="${common_labels}"/></td>
			<td class=' COLUMNHEADER' width='10%' ><fmt:message key="eOR.SplApproval.label" bundle="${or_labels}"/></td>
			<!-- 40016-start-->
			<%if(siteQuotaLimitYN){%>
			<td class=' COLUMNHEADER' width='10%' ><fmt:message key="eOR.Quotalimit.label" bundle="${or_labels}"/></td>
			<%} %>
			<!-- 40016-end-->
		</tr>	
		<%
			int ilRow=0;
			String slClassValue = "";
			String checked = "";
			String checked1 = "";
			String checked2 = "";
			String checked3 = "";//40016
			int flag = 0;
		
			Category_Data = bean.allOrderCategory() ;
			if(Category_Data.size() == 0)
			{
				Category_Data = bean.getAllOrderCategory() ;
				flag = 1;
			}
			else
			{
				mode = "2";
			}
			
			for(int i=0; i<Category_Data.size(); i++)
			{
				String[] record = (String [])Category_Data.get(i);			
				if(ilRow % 2 == 0)
				{
					slClassValue = "gridData";
				}
				else   
				{
					slClassValue = "gridData";
				}

		
				if ( flag != 1 &&  mode.equals("2") ) 
				{
					if(record[2].equals("Y"))
					{
						checked = " checked ";						
					}
					if(record[3].equals("Y"))
					{
						checked1 = " checked ";
					}
					if(record[4].equals("Y"))
					{
						checked2 = " checked ";
					}
					//40016 start
					if(record[5].equals("Y"))
					{
						checked3 = " checked ";
					}
					//40016 end
					
				}
				//40016 start
				if(siteQuotaLimitYN){
					if("PH".equals(record[0]))
					{
						quotaDisabled = "";
						
					}
					else
					{
						quotaDisabled = "disabled";
						
					}
				}
				//40016 end 
							
		%>
				<tr>
					<td  class='<%= slClassValue %>'><%=record[1]%> 
							<input type=hidden name=ordCat<%=i%> value=<%=record[0]%>>
					</td>	
					<td  class='<%= slClassValue %>'>
							<input type=checkbox name="auth<%=i%>" id="auth<%=i%>" <%=checked%> <%=readOnly%> <%=auth_disabled%> ></td>
					 <td  class='<%= slClassValue %>'><input type=checkbox name="co_sign<%=i%>" id="co_sign<%=i%>" <%=checked1%> <%=readOnly%> <%=disabled%> ></td>
					<td  class='<%= slClassValue %>'><input type=checkbox name=sp_appr<%=i%> <%=checked2%> <%=readOnly%> <%=disabled%> ></td>
					<!-- 40016 start -->
					<%if(siteQuotaLimitYN){ %>
					<td  class='<%= slClassValue %>'><input type=checkbox name=qu_appr<%=i%> <%=checked3%> <%=readOnly%> <%=quotaDisabled%> ></td><!--40016-->
					<% } %>
					<!-- 40016 end -->
				</tr>
			
			<%	ilRow++;
			checked = "";
			checked1 = "";
			checked2 = "";
			checked3 = "";//40016
			}
		%>

		</table> 
	</td>
</tr>
</table>
<input type=hidden name='responsibility' id='responsibility' value = "">
<input type=hidden name="resp_display" id="resp_display" value="" >
<input type=hidden name='practitioner' id='practitioner' value = "">
<input type='hidden' name="pract_display" id="pract_display" value="" >

<input type="hidden" name="totalSize" id="totalSize" value="<%=Category_Data.size()%>">
<input type="hidden" name="allOrderCats" id="allOrderCats" value="">
<input type="hidden" name="allFinalAuth" id="allFinalAuth" value="">
<input type="hidden" name="allFinalCo_sign" id="allFinalCo_sign" value="">
<input type="hidden" name="allFinalSp_appr" id="allFinalSp_appr" value="">
<input type="hidden" name="allFinalQu_appr" id="allFinalQu_appr" value=""><!--40016-->
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="responsibility_id" id="responsibility_id" value="<%=responsibility_id%>">
<input type="hidden" name="siteQuotaLimitYN" id="siteQuotaLimitYN" value="<%=siteQuotaLimitYN%>"><!--40016-->


</form></body>

</html>
<%
putObjectInBean( bean_id, bean , request) ;  
%>

