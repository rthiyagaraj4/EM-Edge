<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.Common.*,eOR.*,eCommon.XSSRequestWrapper " contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
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

		var PRIV_GRP_ID			= obj.cells[0].innerText;
		var PRIV_GRP_DESC		= obj.cells[1].innerText;
		var EFF_STATUS		= obj.cells[2].innerText;
		//alert("@@@@@="+PRIV_GRP_ID);
		//alert("@@@@@="+PRIV_GRP_DESC);
		//alert("@@@@@="+EFF_STATUS);
		
		document.location.href="PrivilegeGroupMain.jsp?mode=2&PRIV_GRP_ID="+PRIV_GRP_ID+"&PRIV_GRP_DESC="+PRIV_GRP_DESC+"&EFF_STATUS="+EFF_STATUS+"&function_id="+parent.function_id;
		

}
</script>


<BODY class='CONTENT'   onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
 <%
	String bean_id = "privilegegroupbean" ;
	String bean_name = "eOR.PrivilegeGroupBean";
	PrivilegeGroupBean bean = (PrivilegeGroupBean)getBeanObject( bean_id,  bean_name, request ) ;  
	bean.clear() ;
	bean.setLanguageId(localeName);
	bean.clearUpdateValues();
	String classvalue = "";

	
try{
	String enabledGif	= "<img src='../../eCommon/images/enabled.gif' align=center></img>";
	String disabledGif	= "<img src='../../eCommon/images/disabled.gif' align=center></img>";
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String PRIV_GRP_ID			= CommonBean.checkForNull(request.getParameter("Priv_group_id")).trim();
	String PRIV_GRP_DESC		= CommonBean.checkForNull(request.getParameter("priv_group_desc"));
	String EFF_STATUS		= CommonBean.checkForNull(request.getParameter("eff_status"));
	//System.out.println("########");
	//System.out.println("PRIV_GRP_ID="+PRIV_GRP_ID);
	//System.out.println("PRIV_GRP_DESC="+PRIV_GRP_DESC);
	//System.out.println("EFF_STATUS="+EFF_STATUS);
	/*System.out.println("pract_id="+pract_id);
	System.out.println("practitioner_name="+practitioner_name);
	System.out.println("order_category="+order_category);
	System.out.println("auth_yn="+auth_yn);
	System.out.println("cosign_yn="+cosign_yn);
	System.out.println("spl_appr_yn="+spl_appr_yn);*/
	boolean searched		= request.getParameter( "searched" ) == null? false : true  ;
	//out.println("=="+searched);
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


//		out.println("<script>alert('111111111111111');</script>");

		displayFields.add( "PRIV_GRP_ID" );
		displayFields.add( "PRIV_GRP_DESC" );
		displayFields.add( "EFF_STATUS" );
				
		sqlMap.put( "sqlData", OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_SEARCH") );

	chkFields.add( PRIV_GRP_ID+"%" );
	chkFields.add( PRIV_GRP_DESC+"%" );
	chkFields.add( EFF_STATUS +"%" );
	

	// Adding function related array list into the HashMap
	HashMap funcMap = new HashMap();
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	//System.out.println("pageContext"+pageContext+"sqlMap"+sqlMap+"funcMap"+funcMap+"request"+request);
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	//out.println("result="+result);
    //int rowCount = 1;
	//System.out.println("=="+result.size());
	//System.out.println("=="+( ((String) result.get(0))));
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

	<table class='grid' width='100%' border="1">
		<tr style='text-align: left;'>
			<th class=' COLUMNHEADER' width="20%"><fmt:message key="eOR.PrivilegeGroupID.label" bundle="${or_labels}"/></th>
			<th class=' COLUMNHEADER' width="20%"><fmt:message key="eOR.PrivilegeGroupDescription.label" bundle="${or_labels}"/></th>
			<th class=' COLUMNHEADER' width="20%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		
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
			<tr onClick="Modify(this);">
	<%
			String link_columns = "1";
		  records=(ArrayList) result.get( recCount );
			//out.println("pract="+records);
		  for(int colCount=0; colCount<records.size(); colCount++){
			  if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
			String link_col = (String)records.get(colCount);
				if(link_col != null){
			%>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);"> <a class='gridLink' href='#'><%=link_col%></a></td>
			<% }else{
				link_col = "&nbsp;";
			%>
			<td class="<%=classvalue%>"  onclick="disableClick(event);" > 	<%=link_col%> </font></td>
			<%}
			  }
			  else{
			String str = (String)records.get(colCount);

			if(colCount ==1){
   				if(str==null){
					str = "&nbsp;";
				}%>
				<td class="<%=classvalue%>" onclick="disableClick(event);">
				<%=str%></td>
			<%}
				else
					{
				 if(colCount == 2)//to display Yes/ No (Enabled / Disabled)
					str=eHISFormatter.chkReturn("E",str,enabledGif,disabledGif);
				
	%>
    		<td class="<%=classvalue%>"  onclick="disableClick(event);" ><%=str%></td>
			<% }
	
		
			}
					
		
		 }%>

		</tr>
		<%}%>
	</table>
		
	<%
	out.flush();
	} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm(request ,"PrivilegeGroupQueryResult.jsp", searched));

}catch(Exception e ){
	//out.println("here in catch"+e);//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
}finally{
}
%>
</body>
</html>

