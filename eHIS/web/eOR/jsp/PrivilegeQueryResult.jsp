<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>  

<%-- Mandatory declarations end --%>

<script>
	function Modify(obj){
		/*var appl_user_id = obj.cells[0].innerText;
		var facility_id = obj.cells[5].innerText;
		var reln_id = obj.cells[7].innerText;
		var resp_id = obj.cells[9].innerText;*/

		//var privilege_ctx_id = obj.cells[9].children[0].value;
		var privilege_ctx_id = obj.cells[8].innerText;
	
		//var privilege_ctx_id = obj.cells[12].innerText;
		//alert(privilege_ctx_id);
		//modified by Subhash.Y on 6th May 2004 actual value cells[12]
		//alert(privilege_ctx_id);
		//document.location.href="../../eOR/jsp/PrivilegeAddModify.jsp?mode=2&privilege_ctx_id="+privilege_ctx_id+"&function_id="+parent.function_id+"&appl_user_id="+appl_user_id+"&facility_id="+facility_id+"&reln_id="+reln_id+"&resp_id="+resp_id;
		document.location.href="../../eOR/jsp/PrivilegeAddModify.jsp?mode=2&privilege_ctx_id="+privilege_ctx_id+"&function_id="+parent.function_id;
}
</script>


<html>
	<head>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
		<title></title>
<%
	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		
		<!--<script language="JavaScript" src="../js/Privilege.js"></script>-->
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
 <%
	//Search Criteria's from Query Criteria page
	request.setCharacterEncoding("UTF-8");
 request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
 response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
 response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
	String privilege_value	= CommonBean.checkForNull(request.getParameter("privilege_value"));
	String privilege_ctx_id		= CommonBean.checkForNull(request.getParameter("privilege_ctx_id"));
	String privilege_ctx		= CommonBean.checkForNull(request.getParameter("privilege_ctx"));
	String privilege_id			= CommonBean.checkForNull(request.getParameter("privilege_id"));
	String facility_id			= CommonBean.checkForNull(request.getParameter("facility_id"));
	String facility_name		= CommonBean.checkForNull(request.getParameter("facility_name"));
	String appl_user_id 		= 
	CommonBean.checkForNull(request.getParameter("appl_user_id"));
	//out.println("appl_user_id"+appl_user_id);
	String appl_user_name		= CommonBean.checkForNull(request.getParameter("appl_user_name"));
	String reln_id				= 
	CommonBean.checkForNull(request.getParameter("reln_id"));
	String pract_reln_name		= CommonBean.checkForNull(request.getParameter("pract_reln_name"));
	String resp_id				=
	CommonBean.checkForNull(request.getParameter("resp_id"));
	String resp_name			=
	CommonBean.checkForNull(request.getParameter("resp_name"));
	//String active_yn			=
	//CommonBean.checkForNull(request.getParameter("active_yn"));
	
	String bean_id = "privilege" ;
	String bean_name = "eOR.PrivilegeBean";
	/*System.out.println("#####hashTemp values in privilegeQueryResult page");
	 System.out.println("#####privilege_value="+privilege_value);
	 System.out.println("#####privilege_ctx_id="+privilege_ctx_id);
	 System.out.println("#####privilege_ctx="+privilege_ctx);
	 System.out.println("#####privilege_id="+privilege_id); System.out.println("#####facility_id="+facility_id);
	 System.out.println("#####facility_name="+facility_name);
	 System.out.println("#####appl_user_id="+appl_user_id);
	 System.out.println("#####appl_user_name="+appl_user_name);
	 System.out.println("#####reln_id="+reln_id);
	 System.out.println("#####pract_reln_name="+pract_reln_name);
	 System.out.println("#####resp_id="+resp_id);
	 System.out.println("#####resp_name="+resp_name);*/
	  

	HashMap hashTemp = new HashMap();
	hashTemp.put("privilege_value",privilege_value +"%");
	hashTemp.put("privilege_ctx_id",privilege_ctx_id +"%");
	hashTemp.put("privilege_ctx",privilege_ctx +"%");
	hashTemp.put("privilege_id",privilege_id +"%");
	hashTemp.put("facility_id",facility_id +"%");
	hashTemp.put("facility_name",facility_name +"%");
	hashTemp.put("appl_user_id",appl_user_id +"%");
	hashTemp.put("appl_user_name",appl_user_name +"%");
	hashTemp.put("reln_id",reln_id +"%");
	hashTemp.put("pract_reln_name",pract_reln_name +"%");
	hashTemp.put("resp_id",resp_id +"%");
	hashTemp.put("resp_name",resp_name +"%");
	//hashTemp.put("active_yn",active_yn +"%");
	//out.println("#####hashTemp="+hashTemp);
	 
	  

	/* Required while Selecting sql and Formatting display*/
	//String enableGif ="<img src='../../eCommon/images/enabled.gif'></img>" ;
	//String disableGif ="<img src='../../eCommon/images/RRnwd.gif'></img>" ;
	//String valSource[]  ={"U","R","P"} ;
	//String descsource[]={"User Id","RelationShip","Responsibilty"} ;
	//String descsource[]={"Application User","Relationship","Responsibility"} ;
	//String valSourceVal[]  ={"S","M","A","N"} ;//modified by Kavitha.K 1/10/2005
	//String descsourceVal[]={"Allowed","Not Allowed","Allowed with Exception","Not Allowed with Exception"} ;//removed by Kavitha.K 1/10/2005
	//String valSourcePrivilege[]  ={"O"} ;
	//String descsourcePrivilege[]={"Order"} ;
	//String valSourcePrivilege[]  ={"O","C","A","H","D","U","S","P","V"} ;
	//String descsourcePrivilege[]={"Order","Cancel","Amend","Hold/Resume","Discontinue","Order Authorizaiton","Cosign","Special Approval","View"} ;
			
	//String ord[]				=request.getParameterValues("orderbycolumns");
	boolean searched			=request.getParameter( "searched" ) == null? false : true  ;
	
	 //String sql = OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_QUERYCRITERIA");	
	 //String sql1 = OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_DISTINCT_CTX_QUERY");	
	 
	
try{
	String classvalue			= "";
	
	//Common parameters.
	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_QUERYCRITERIA"));
//out.println(OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_QUERYCRITERIA"));
	//HashMap sqlMap1 = new HashMap();
	//include all the common parameters.
	//sqlMap.put( "sqlData",sql);

	//Function Parameters
	HashMap funcMap = new HashMap();
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	ArrayList chkFields = new ArrayList();

	PrivilegeBean bean = (PrivilegeBean)getBeanObject( bean_id,  bean_name, 	request ) ;  
	bean.clear() ;	
	
	//Vector privList = bean.getDistPrivilegeCtxID(hashTemp);
	//System.err.println("Vector @@@@@ " + privList);
	//System.err.println("Vector size @@@ " + privList.size());
	//System.out.println("#####privList.size()="+privList.size());
	//System.out.println("#####privList="+privList);
	/*if(privList.size() == 0)
	{*/
	%>
	<script>//alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
	<%
	//}	
	%>
		
	<%
		
	/*for(int i=0;i<privList.size();i++)
	{*/

	displayFields = new ArrayList();

	displayFields.add( "appl_user_id" );
	displayFields.add( "appl_user_name" );
	//displayFields.add( "privilege_ctx" );
	//displayFields.add( "privilege_id" );
	//displayFields.add( "privilege_value" );
	displayFields.add( "facility_id" );
	displayFields.add( "facility_name" );
	displayFields.add( "reln_id" );
	displayFields.add( "pract_reln_name" );
	displayFields.add( "resp_id" );
	displayFields.add( "resp_name" );
	//displayFields.add( "active_yn" );
	displayFields.add( "privilege_ctx_id" );

	//The fields are going to be in where condition * should match with the query
	//ArrayList 

	chkFields = new ArrayList();

	//chkFields.add( "%" );
	chkFields.add( privilege_ctx_id +"%");
	//chkFields.add( ((String)privList.get(i++)) +"%");
	//chkFields.add( privilege_id +"%" );
	//chkFields.add( privilege_ctx +"%" );
	chkFields.add( facility_id +"%" );
	chkFields.add( appl_user_id +"%");
	chkFields.add( reln_id  +"%");
	chkFields.add( resp_id +"%" );
	//chkFields.add( privilege_value +"%" );
	//chkFields.add( active_yn +"%" );
	chkFields.add( appl_user_name +"%");
	chkFields.add( resp_name +"%" );
	chkFields.add( facility_name +"%" );
	chkFields.add( pract_reln_name +"%");

		
/*	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%");
	chkFields.add( "%");
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%");
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%");
*/	
	
	
	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	//System.out.println("#####displayFields="+displayFields);
	//System.out.println("#####chkFields="+chkFields);
	//System.err.println("Before commonBean.query result @@@@@@@@@@@@");
	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	//System.err.println("After commonBean.query result @@@@@@@@@@@@");
	//System.out.println("#####result.size()="+result.size());
	//System.out.println("#####result="+result);
	
	if((result.size()>=3)  && ( !( ((String) result.get(0)).equals("0")) ) ){
	%>
		
		<table cellpadding=3 cellspacing=0 width="100%" align=center>
		<tr>
		<td class=label></td>
		<td class=label>  
	<%
		// For display the previous/next link
	     out.println(result.get(1));
		
	%>
		</td></tr>
		</table>  

		<table border="1" cellpadding=3 cellspacing=0 width="104%" align=center>
		<tr>
		<td class=columnheader><fmt:message key="Common.appluserid.label" bundle="${common_labels}"/></td>
		<td class=columnheader><fmt:message key="eOR.ApplicationUser.label" bundle="${or_labels}"/></td>
		<td class=columnheader><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></td>
		<td class=columnheader nowrap><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
		<td class=columnheader><fmt:message key="eOR.RelationId.label" bundle="${or_labels}"/></td>
		<td class=columnheader><fmt:message key="eOR.RelationName.label" bundle="${or_labels}"/></td> 
		<td class=columnheader><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></td>
		<td class=columnheader><fmt:message key="Common.ResponsibilityName.label" bundle="${common_labels}"/></td>
		</tr>

		
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		String str = "";
		String link_columns = "";
		String link_columns1="";
		String on_click="";
		//int recCount = 2;
		for(int recCount=2; recCount<result.size(); recCount++){
			if ( recCount % 2 == 0 )
			classvalue = "QRYEVEN" ;
			else
			classvalue = "QRYODD" ;
		%>
			<tr onClick="Modify(this);" >
			<%
			link_columns = "";
			//System.err.println("SSSSSS @@@@@ " + appl_user_id +" " + reln_id + " " + resp_id);
			/*if(appl_user_id != null && appl_user_id != "")
				link_columns = "1";
			else if(reln_id != null && reln_id != "")
					link_columns = "5";
				 else if(resp_id != null && resp_id != "")
					link_columns = "7";
			*/
			link_columns1 = "3";
			
			//records=(ArrayList) result.get( recCount );
			records=(ArrayList) result.get(recCount);
			//out.println(records);
			//out.println("records size  " + records.size());
			//System.err.println("Records   @@@@@@   " + records);  
			for(int colCount=0; colCount<records.size(); colCount++){
			//if(colCount == records.size()-1) // modified by Subhash.Y on 4th May 2004
			//	break;

			str = (String)records.get(colCount);	
			

		    //if(colCount == 2 )//to display Nurse Colllect
   			//str=eHISFormatter.chkReturn(valSource,str,descsource,"&nbsp;");

		//	if(colCount == 3 )//to display Nurse Colllect
		//	{
   				//str=eHISFormatter.chkReturn("O",str,"Order","&nbsp;");
				//System.err.println("valSourcePrivilege @@@@@@@@@@ " + valSourcePrivilege);
				//System.err.println("str @@@@@@@@@@ " + str);
				//System.err.println("descsourcePrivilege @@@@@@@@@@ " + descsourcePrivilege);

		//		str=eHISFormatter.chkReturn(valSourcePrivilege,str,descsourcePrivilege,"&nbsp;");
				//System.err.println("str @@@@@@@@@@ " + str);
		//	}

		//	if(colCount == 4 )//to display Nurse Colllect
   		//	str=eHISFormatter.chkReturn(valSourceVal,str,descsourceVal,"&nbsp;");

			//if(colCount == 11 )//to display Nurse Colllect
			//str=eHISFormatter.chkReturn("Y",str,enableGif,disableGif);
			   			
		//	if(colCount == 11 )
		//	{
   			%>
		<!--	<td class="<%//=classvalue%>" onclick="disableClick(event);" nowrap>
			<INPUT TYPE="hidden" value="<%//=str%>" name="privilege_ctx_id<%//=(recCount-2)%>"></td> 
			-->
			<%
		//	continue;}
			if(colCount == 0 && str != null && str != "")
				link_columns = "1";
			if(colCount == 4 && str != null && str != "")
				link_columns = "5";
			if(colCount == 6 && str != null && str != "")
				link_columns = "7";
			if(str == null){ 
				str = "&nbsp;" ;
				on_click="disableClick(event);";
			}else
				on_click= "";
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 || link_columns1.indexOf(String.valueOf(colCount+1)) != -1)
				{ 
				%>
				
			<td class="<%=classvalue%>" onclick="<%=on_click%>"  onmouseover="changeCursor(this);"><font class='HYPERLINK'><%=str%></font></td>
			<%}
			else
			{
				if(colCount != 8)
				{
				%>
			<td class="<%=classvalue%>" onclick="disableClick(event);" nowrap><%=str%></td>
			<% }
				else
				{
			%>
			<td width="0" style='visibility:hidden'><%=str %></td>
					<%
				}
			}
				//}//for records from result...
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
	//recCount++;
	//}//for loop of vector(distinct privilege ctx ids)//removed by Kavitha.K 1/27/2005

	  %>
			
	<%	
	out.println(CommonBean.setForm(request ,"../../eOR/jsp/PrivilegeQueryResult.jsp", searched));
putObjectInBean(bean_id,bean,request);
} catch(Exception e) {
	System.out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
</html>

