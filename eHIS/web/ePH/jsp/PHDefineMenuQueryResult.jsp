<!DOCTYPE html>
<%@ page import ="java.util.*, ePH.Common.*, ePH.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />		
		<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../ePH/js/PHDefineMenu.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
		<form>
		<%

	 String user_id			= ((request.getParameter("user_id")	 == null) || (request.getParameter("user_id").trim()   == ""))  ? "%" : (request.getParameter("user_id").trim())+"%";		
	 String appl_user_name	= ((request.getParameter("appl_user_name")	 == null) || (request.getParameter("appl_user_name").trim()   == ""))  ? "%" : (request.getParameter("appl_user_name").trim())+"%";		
	 String desktop_id		= ((request.getParameter("desktop_id")	 == null) || (request.getParameter("desktop_id").trim()   == ""))  ? "%" : (request.getParameter("desktop_id").trim())+"%";		
	 String desktop_desc	= ((request.getParameter("desktop_desc") == null) || (request.getParameter("desktop_desc").trim() == ""))  ? "%" : (request.getParameter("desktop_desc").trim())+"%";		
	 String eff_status		= ((request.getParameter("eff_status")   == null) || (request.getParameter("eff_status").trim()   == ""))  ? "%" : (request.getParameter("eff_status").trim())+"%";		
	 boolean searched		= (request.getParameter("searched") == null) ?false:true;
	 String classvalue		= "";

	try{

	HashMap sqlMap          = new HashMap();
	HashMap funcMap         = new HashMap();
	ArrayList displayFields = new ArrayList();
	ArrayList chkFields     = new ArrayList();

	//sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_ST_DEFINE_MENU_QUERYCRIT"));	
	sqlMap.put( "sqlData", "SELECT PH.USER_ID USER_ID,SM.APPL_USER_NAME USER_NAME ,DESKTOP_ID,LEGEND_FOR_DESK_TOP DESKTOP_DESC,PH.EFF_STATUS FROM PH_ST_DESKTOP_FOR_USER PH, SM_APPL_USER_LANG_VW SM WHERE PH.USER_ID = SM.APPL_USER_ID AND SM.EFF_STATUS = 'E' AND SM.LANGUAGE_ID = ? AND UPPER(PH.USER_ID) LIKE UPPER(?) AND UPPER(SM.APPL_USER_NAME) LIKE UPPER(?) AND UPPER(DESKTOP_ID) LIKE UPPER(?) AND UPPER(LEGEND_FOR_DESK_TOP) LIKE UPPER(?) AND PH.EFF_STATUS LIKE UPPER(?)");	
	
	displayFields.add( "user_name" );
	displayFields.add( "user_id" );
	displayFields.add( "desktop_id" );
	displayFields.add( "desktop_desc"	);
	displayFields.add( "eff_status" );
	
	chkFields.add( locale);
	chkFields.add( user_id);
	chkFields.add( appl_user_name);
	chkFields.add( desktop_id);
	chkFields.add( desktop_desc);
	chkFields.add( eff_status);	
	
	
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	ArrayList result = (ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		
	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
			%>
			<table cellpadding=0 cellspacing=0 width="100%" align=center>
				<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
			<%
				// For display the previous/next link
				 out.println(result.get(1));

			%>
				</td></tr>
			</table>
									
			<table border="1" cellpadding=0 cellspacing=0 width='100%' align='center' >

					<th><fmt:message key="Common.user.label" bundle="${common_labels}"/></td>
					<th><fmt:message key="ePH.DesktopId.label" bundle="${ph_labels}"/></td>
					<th><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
					<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
					
	<%
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
	%>
			<tr onClick="Modify(this);" >
	<%

			String link_columns = "1";
			String link_columns1= "2";

			records=(ArrayList) result.get( recCount );
			for(int colCount=0; colCount<records.size(); colCount++){
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){

	%>
					<td class="<%=classvalue%>" onmouseover="changeCursor(this);" nowrap ><font class='HYPERLINK'>  <%=(String)records.get( colCount )%>    </font></td>
	<%
				}
				else if( link_columns1.indexOf(String.valueOf(colCount+1)) != -1 ){
	%>
					<td class='NODISPLAY' > <%=(String)records.get( colCount )%> </td>
	<%
				}
	
				else{
	%>
					<td class="<%=classvalue%>" onclick="disableClick(event);"
					<%
							if(colCount > 3 ) {
								if( ((String)records.get( colCount )).equals("E") || ((String)records.get( colCount )).equals("Y"))
									out.println(" align='center' ><img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println(" align='center' ><img src=\'../../eCommon/images/disabled.gif\'></img>");
							}
							else {
								out.println(">"+(String)records.get( colCount ));
							}
				    %>
				</td>

	<%
					}
				}
	%>
			</tr>
	<%
		}
	%>

		</table>

		<%
		out.flush();
		} else{
		%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eMM/jsp/ItemClassQueryResult.jsp", searched) );
	} catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
		</form>
	</body>
</html>

