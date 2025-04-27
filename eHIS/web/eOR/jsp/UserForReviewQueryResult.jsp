<% /*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

18/07/2023  40016           Ranjith P R       19/07/2023         Ramesh Goli        ML-MMOH-CRF-1823                 
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
<%@page import="java.util.*, eOR.Common.*,java.sql.*,webbeans.eCommon.*,eOR.*,java.text.*,com.ehis.util.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>



<HTML>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
	function Modify(obj){

		var resp_id			= obj.cells[0].innerText.trim();
		var resp_name		= obj.cells[1].innerText.trim();
		var pract_id		= obj.cells[2].innerText.trim();
		var pract_name		= obj.cells[3].innerText.trim();
		//alert("@@@@@="+resp_name);
		
		
		document.location.href="UserForReviewAddModify.jsp?mode=2&resp_id="+resp_id+"&pract_id="+pract_id+"&pract_name="+pract_name+"&resp_name="+resp_name+"&function_id="+parent.function_id;
		

}
</script>


<BODY class='CONTENT'   onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name=result_form >
 <%
	
	String classvalue = "";

	String enableGif ="<img src='../../eCommon/images/enabled.gif'></img>" ;
	String disableGif ="<img src='../../eCommon/images/RRnwd.gif'></img>" ;
	boolean siteQuotaLimitYN  = false;
   	Connection con = null;
   	try{
		con = ConnectionManager.getConnection();
		siteQuotaLimitYN = CommonBean.isSiteSpecific(con, "PH","PH_QUOTA_LIMIT_FOR_DRUG");
   	}catch(Exception e) {
           System.out.println("error:"+e.getMessage());
   		e.printStackTrace();
    }finally {
   		if(con != null)
   			con.close();
   	}

try{
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String resp_id			= CommonBean.checkForNull(request.getParameter("resp_id"));
	String resp_name		= CommonBean.checkForNull(request.getParameter("resp_name"));
//		out.println("<script>alert('resp_name="+resp_name+"###');</script>");
	String pract_id			= CommonBean.checkForNull(request.getParameter("pract_id"));
	String practitioner_name= CommonBean.checkForNull(request.getParameter("practitioner_name"));
//	out.println("<script>alert('practitioner_name="+practitioner_name+"####');</script>");
	String order_category	= CommonBean.checkForNull(request.getParameter("order_category"));
	String auth_yn			= CommonBean.checkForNull(request.getParameter("auth_yn"));
	String cosign_yn		= CommonBean.checkForNull(request.getParameter("cosign_yn"));
	String spl_appr_yn		= CommonBean.checkForNull(request.getParameter("spl_appr_yn"));
	/*System.out.println("########");
	System.out.println("resp_id="+resp_id);
	System.out.println("resp_name="+resp_name);
	System.out.println("pract_id="+pract_id);
	System.out.println("practitioner_name="+practitioner_name);
	System.out.println("order_category="+order_category);
	System.out.println("auth_yn="+auth_yn);
	System.out.println("cosign_yn="+cosign_yn);
	System.out.println("spl_appr_yn="+spl_appr_yn);*/
	boolean searched		= request.getParameter( "searched" ) == null? false : true  ;

//out.println("==>"+resp_id+"<==>"+resp_name+"<==>"+pract_id+"<==>"+practitioner_name+"<==>"+order_category+"<==>"+auth_yn+"<==>"+cosign_yn+"<==>"+spl_appr_yn+"<==");
	//Common parameters.
	HashMap sqlMap = new HashMap();


	//include all the common parameters.
	//String tmpQry = "select distinct a.resp_name resp_name, c.practitioner_id pract_id, b.practitioner_name practitioner_name, c.resp_id resp_id, d.short_desc order_category,  c.auth_yn auth_yn, c.cosign_yn cosign_yn, c.spl_appr_yn spl_appr_yn  from sm_resp a, am_practitioner b, or_review_user_categories c, or_order_category d  where a.resp_id(+) = c.resp_id and b.practitioner_id(+) = c.practitioner_id and c.order_Category =d.order_Category and upper(nvl(c.resp_id,'XX') ) like upper(?) and upper(nvl(c.practitioner_id,'XXXX')) like upper(?) and upper(nvl(a.resp_name,'XXXX')) like (?) and upper(nvl(b.practitioner_name,'XXXX')) like  (?) and upper(c.order_category) like  (?) and c.auth_yn like (?) and c.cosign_yn like (?) and c.spl_appr_yn like (?)  ";

	//String tmp_Qry = "select distinct c.practitioner_id pract_id, b.practitioner_name practitioner_name, c.resp_id resp_id ,a.resp_name resp_name from	sm_resp a, 	am_practitioner b, or_review_user_categories c, or_order_category d  where	a.resp_id(+) = c.resp_id and b.practitioner_id(+) = c.practitioner_id 	and d.order_Category =c.order_category 	and upper(nvl(c.resp_id,'XX') ) like (?) 	and upper(nvl(c.practitioner_id,'XXXX')) like (?) and upper(nvl(a.resp_name,'XXXX')) like (?) 	and upper(nvl(b.practitioner_name,'XXXX')) like  (?) 	and upper(c.order_category) like  (?)	and c.auth_yn like (?) 	and c.cosign_yn like (?)	and c.spl_appr_yn like (?)";


	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();

	if(((!order_category.equals("")|| !auth_yn.equals("%"))&& (resp_id.equals("") && resp_name.equals("")&& pract_id.equals("") && practitioner_name.equals("")))|| (resp_id.equals("%") || resp_name.equals("%") || pract_id.equals("%") || practitioner_name.equals("%") )){
//		out.println("<script>alert('111111111111111');</script>");

		displayFields.add( "resp_id" );
		displayFields.add( "resp_name" );
		displayFields.add( "pract_id" );
		displayFields.add( "practitioner_name" );
		displayFields.add( "order_category" );
		displayFields.add( "auth_yn" );
		displayFields.add( "cosign_yn" );
		displayFields.add( "spl_appr_yn" );
		if(siteQuotaLimitYN)
			displayFields.add( "quota_limit_yn" );//40016
		sqlMap.put( "sqlData", OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_SELECT1_RSLT") );
	}else if(resp_id.equals("") && resp_name.equals("")&& pract_id.equals("") && practitioner_name.equals("") && order_category.equals("") && auth_yn.equals("%")){
//		out.println("<script>alert('2222222222222');</script>");

		displayFields.add( "resp_id" );
		displayFields.add( "resp_name" );
		displayFields.add( "pract_id" );
		displayFields.add( "practitioner_name" );
		sqlMap.put( "sqlData", OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_SELECT_RSLT") );
	}else if((!pract_id.equals("") && !pract_id.equals("%") ) || (!practitioner_name.equals("%") && !practitioner_name.equals(""))){
//		out.println("<script>alert('33333333333333333');</script>");
		displayFields.add( "pract_id" );
		displayFields.add( "practitioner_name" );
		displayFields.add( "order_category" );
		displayFields.add( "auth_yn" );
		displayFields.add( "cosign_yn" );
		displayFields.add( "spl_appr_yn" );
		if(siteQuotaLimitYN)
			displayFields.add( "quota_limit_yn" );//40016

		sqlMap.put( "sqlData", OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_SELECT1_RSLT") );
	}else if((!resp_id.equals("") && !resp_id.equals("%") )|| (!resp_name.equals("") && !resp_name.equals("%"))){
//		out.println("<script>alert('444444444444444');</script>");
		displayFields.add( "resp_id" );
		displayFields.add( "resp_name" );
		displayFields.add( "order_category" );
		displayFields.add( "auth_yn" );
		displayFields.add( "cosign_yn" );
		displayFields.add( "spl_appr_yn" );
		if(siteQuotaLimitYN)
			displayFields.add( "quota_limit_yn" );//40016
		sqlMap.put( "sqlData", OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_SELECT1_RSLT") );

	}


	chkFields.add( resp_id+"%" );
	chkFields.add( pract_id+"%" );
	chkFields.add( resp_name+"%" );
	chkFields.add( practitioner_name+"%" );
	chkFields.add( order_category+"%" );
	chkFields.add( auth_yn+"%" );
	chkFields.add( cosign_yn+"%" );
	chkFields.add( spl_appr_yn+"%");

	// Adding function related array list into the HashMap
	HashMap funcMap = new HashMap();
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	//out.println("result="+result);
    //int rowCount = 1;

	if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
	<table border=0 cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
		<td class=label></td>
		<td class=label>
	<%
		// For display the previous/next link
	     out.println(result.get(1));
		
	%>
				</td></tr>
	</table>
<%	if((!pract_id.equals("") && !pract_id.equals("%")) || (!practitioner_name.equals("") && !practitioner_name.equals("%"))){

//out.println("<script>alert('in pract,practitioner_name="+practitioner_name+"');</script>");%>

	<table class='grid' width='100%'>
		<tr>
			<td class=' COLUMNHEADER' width="20%"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
			<td class=' COLUMNHEADER' width="20%"><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></td>
			<td class=' COLUMNHEADER' width="20%"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			<td class=' COLUMNHEADER' width="10%"><fmt:message key="Common.AuthorizationReqd..label" bundle="${common_labels}"/></td>
			<td class=' COLUMNHEADER' width="15%"><fmt:message key="Common.CosignReqd.label" bundle="${common_labels}"/></td>
			<td class=' COLUMNHEADER' width="15%"><fmt:message key="eOR.Spl.ApprovalReqd.label" bundle="${or_labels}"/></td>
			<%if(siteQuotaLimitYN){%>
			<td class=' COLUMNHEADER' width="15%"><fmt:message key="eOR.Quota.ApprovalReqd.label" bundle="${or_labels}"/></td><!-- 40016-->
			<%}%>
		</tr>

		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
	%>
			<tr onClick="" >
	<%

		  records=(ArrayList) result.get( recCount );
			//out.println("pract="+records);
		  for(int colCount=0; colCount<records.size(); colCount++){
			
			String str = (String)records.get(colCount);	
			//out.println("str="+str);
			//if(records.get(colCount)!=null && (!str.equals("null"))){
			if(colCount == 3)
			str=eHISFormatter.chkReturn("Y",str,enableGif,disableGif);
			if(colCount == 4)
			str=eHISFormatter.chkReturn("Y",str,enableGif,disableGif);
			if(colCount == 5)
			str=eHISFormatter.chkReturn("Y",str,enableGif,disableGif); 
			//40016 starts
			if(siteQuotaLimitYN){
				if(colCount == 6)
					str=eHISFormatter.chkReturn("Y",str,enableGif,disableGif); 
			}
            //40016 ends
			%>

				<td class="<%=classvalue%>" onclick="disableClick(event);">
				<%=str%></td>
			<%//}
		 }%>

		</tr>
		<%}%>
	</table>
<%}else if((!resp_id.equals("") && !resp_id.equals("%"))|| (!resp_name.equals("")&& !resp_name.equals("%"))){
//		out.println("<script>alert('in resp,resp_name="+resp_name+"');</script>");%>

	<table class='grid' width='100%'>
		<tr>
			<td class=' COLUMNHEADER' width="20%"><fmt:message key="Common.ResponsibilityID.label" bundle="${common_labels}"/></td>
			<td class=' COLUMNHEADER' width="20%"><fmt:message key="Common.ResponsibilityName.label" bundle="${common_labels}"/></td>
			<td class=' COLUMNHEADER' width="20%"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			<td class=' COLUMNHEADER' width="10%"><fmt:message key="Common.AuthorizationReqd..label" bundle="${common_labels}"/></td>
			<td class=' COLUMNHEADER' width="15%"><fmt:message key="Common.CosignReqd.label" bundle="${common_labels}"/></td>
			<td class=' COLUMNHEADER' width="15%"><fmt:message key="eOR.Spl.ApprovalReqd.label" bundle="${or_labels}"/></td>
			<%if(siteQuotaLimitYN){%>
			<td class=' COLUMNHEADER' width="15%"><fmt:message key="eOR.Quota.ApprovalReqd.label" bundle="${or_labels}"/></td><!-- 40016-->
			<%}%>
		</tr>
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
	%>
			<tr onClick="" >
	<%		
			records=(ArrayList) result.get( recCount );
			//out.println("resp="+records);
			
	
		  for(int colCount=0; colCount<records.size(); colCount++){
			String str = (String)records.get(colCount);
			//out.println("str="+str);
			
			//out.println("colCount="+colCount+" , str="+str);
			if(colCount == 3)
			str=eHISFormatter.chkReturn("Y",str,enableGif,disableGif);
			if(colCount == 4)
			str=eHISFormatter.chkReturn("Y",str,enableGif,disableGif);
			if(colCount == 5)
			str=eHISFormatter.chkReturn("Y",str,enableGif,disableGif);
			//40016 starts
			if(siteQuotaLimitYN){
				if(colCount == 6)
					str=eHISFormatter.chkReturn("Y",str,enableGif,disableGif); 
			}
            //40016 ends
			%>

				<td class="<%=classvalue%>" onclick="disableClick(event);">
				<%=str%></td>
			<%

		 }%>

		</tr>
		<%}%>
	</table>
	

<%}else if(((!order_category.equals("")|| !auth_yn.equals("%"))&& (resp_id.equals("") && resp_name.equals("")&& pract_id.equals("") && practitioner_name.equals("")) )||(resp_id.equals("%") || resp_name.equals("%") || pract_id.equals("%") || practitioner_name.equals("%")) ){
//	out.println("<script>alert('############here###########');</script>");
		%>
	<table class='grid' width='100%'>
		<tr>
			<th class=' COLUMNHEADER' width="10%"><fmt:message key="Common.ResponsibilityID.label" bundle="${common_labels}"/></th>
			<th class=' COLUMNHEADER' width="10%"><fmt:message key="Common.ResponsibilityName.label" bundle="${common_labels}"/></th>
			<th class=' COLUMNHEADER' width="5%"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></th>
			<th class=' COLUMNHEADER' width="5%"><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></th>
			<th class=' COLUMNHEADER' width="5%"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th>
			<th class=' COLUMNHEADER' width="5%"><fmt:message key="Common.AuthorizationReqd..label" bundle="${common_labels}"/></th>
			<th class=' COLUMNHEADER' width="5%"><fmt:message key="Common.CosignReqd.label" bundle="${common_labels}"/></th>
			<th class=' COLUMNHEADER' width="5%"><fmt:message key="eOR.Spl.ApprovalReqd.label" bundle="${or_labels}"/></th>
			<%if(siteQuotaLimitYN){%>
			<td class=' COLUMNHEADER' width="5%"><fmt:message key="eOR.Quota.ApprovalReqd.label" bundle="${or_labels}"/></td><!-- 40016-->
			<%}%>
		</tr>
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
	%>
			<tr onClick="" >
	<%


		  records=(ArrayList) result.get( recCount );

		  for(int colCount=0; colCount<records.size(); colCount++){

			String str = (String)records.get(colCount);

			if(colCount ==0 || colCount ==1 || colCount ==2 || colCount ==3){
   				if(str==null){
					str = "&nbsp;";
				}
			}
			if(colCount == 5)
			str=eHISFormatter.chkReturn("Y",str,enableGif,disableGif);
			if(colCount == 6)
			str=eHISFormatter.chkReturn("Y",str,enableGif,disableGif);
			if(colCount == 7)
			str=eHISFormatter.chkReturn("Y",str,enableGif,disableGif);
			//40016 starts
			if(siteQuotaLimitYN){
				if(colCount == 8)
					str=eHISFormatter.chkReturn("Y",str,enableGif,disableGif); 
			}
			//40016 ends
			%>

				<td class="<%=classvalue%>" onclick="disableClick(event);">
				<%=str%></td>
			<%
		 }%>

		</tr>
		<%}%>
	</table>
<%}else  if(resp_id.equals("") && resp_name.equals("")&& pract_id.equals("") && practitioner_name.equals("") && order_category.equals("") && auth_yn.equals("%")){
		%>
	<table class='grid' width='100%'>
		<tr>
			<td class=' COLUMNHEADER' width="25%"><fmt:message key="Common.ResponsibilityID.label" bundle="${common_labels}"/></td>
			<td class=' COLUMNHEADER' width="25%"><fmt:message key="Common.ResponsibilityName.label" bundle="${common_labels}"/></td>
			<td class=' COLUMNHEADER' width="25%"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
			<td class=' COLUMNHEADER' width="25%"><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></td>
		</tr>
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
	%>
			<tr onClick="Modify(this);" >
	<%

		  String link_columns = "1,3";

		  records=(ArrayList) result.get( recCount );

		  for(int colCount=0; colCount<records.size(); colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
				String link_col = (String)records.get(colCount);
				if(link_col != null){
			%>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);"> 	 <a class='gridLink' href='#'><%=link_col%> 	   </a></td>
			<% }else{
				link_col = "&nbsp;";
			%>
			<td class="<%=classvalue%>"  onclick="disableClick(event);" > 	<%=link_col%> 	   </font></td>
			<%
			}
			}else{
			String str = (String)records.get(colCount);

			if(colCount ==1 || colCount ==2 || colCount ==3){
   				if(str==null){
					str = "&nbsp;";
				}
			}

			%>

				<td class="<%=classvalue%>" onclick="disableClick(event);">
				<%=str%></td>
			<%
			}
		 }%>

		</tr>
		<%}%>
	</table>
<%}
		%>			</form>
	<%
	out.flush();
	} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm(request ,"UserForReviewQueryResult.jsp", searched));

}catch(Exception e ){
	//out.println("here in catch"+e);//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}finally{
}
%>
</body>
</html>

