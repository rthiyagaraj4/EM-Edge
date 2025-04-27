<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.HashMap,java.util.ArrayList, eMM.Common.*, eMM.StoreBean,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%-- Mandatory declarations end --%>
 
<html>
	<head>
		<title></title>
		<%

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<!-- <script language="JavaScript" src="../js/MmMessages.js"></script> -->
		<script language="Javascript" src="../../eMM/js/MmCommon.js"></script>
		<script language="Javascript" src="../../eMM/js/Store.js"> </script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<body>
<%
	//Search Criteria's from Query Criteria page
	String store_code	= request.getParameter( "store_code" ) ;
	String short_desc	= request.getParameter( "short_desc" ) ;
	String dept_code	= request.getParameter( "dept_code" ) ;
	String external_yn	= request.getParameter( "external_yn" ) ;
	String eff_status	= request.getParameter( "nature" ) ;
	String store_group	= CommonBean.checkForNull((String)request.getParameter( "store_group" ))+'%' ; 
	//String ord[]		= request.getParameterValues("orderbycolumns");
	boolean searched	=(request.getParameter("searched") == null) ?false:true;
	
try{
	String bean_id								 =		"";
	String bean_name							 =		"";
	bean_id										 =		"storeBean" ;
	bean_name									 =		"eMM.StoreBean";
	StoreBean bean					 =		(StoreBean)getBeanObject( bean_id, bean_name, request );
	String classvalue			= "";
	String facility_id			="";
	String interface_to_external_po_yn			 =		"";
	int count=0;
		interface_to_external_po_yn=bean.getInterface_to_external_po_yn((String)session.getAttribute("ACC_ENTITY_ID"));
   
	facility_id					=(String) session.getAttribute("facility_id");

	store_code  = CommonBean.checkForNull( store_code )+'%';
	short_desc  = CommonBean.checkForNull( short_desc )+'%';
	eff_status  = CommonBean.checkForNull( eff_status )+'%';
	dept_code  = CommonBean.checkForNull( dept_code,"%" );
	external_yn = CommonBean.checkForNull( external_yn );

	//Common parameters.
	HashMap sqlMap = new HashMap();

	//include all the common parameters.
	if(interface_to_external_po_yn.equals("N")){
		//sqlMap.put( "sqlData", MmRepository.getMmKeyValue("SQL_MM_STORE_QUERYCRIT1"));
		sqlMap.put( "sqlData", "SELECT   po_dept_code, store_code, ms.long_desc, ms.short_desc, am_get_desc.am_dept (ad.dept_code, ?, '2') dept_code, external_yn, ms.eff_status, am.short_desc po_dept_desc, (CASE WHEN ms.store_group_code IS NOT NULL THEN (SELECT sg.short_desc FROM mm_store_group_lang_vw sg WHERE sg.store_group_code = ms.store_group_code AND sg.language_id = ?) END ) store_group_desc FROM mm_store_lang_vw ms, am_facility_dept_vw ad, am_dept_lang_vw am WHERE ms.dept_code = ad.dept_code(+) AND ms.facility_id = ad.operating_facility_id(+) AND UPPER (store_code) LIKE UPPER (?) AND UPPER (ms.short_desc) LIKE UPPER (?) AND ms.eff_status LIKE UPPER (?) AND UPPER (NVL (ms.dept_code, 'X')) LIKE UPPER (?) AND external_yn LIKE (?) AND ms.facility_id LIKE UPPER (?) AND am.dept_code(+) = ms.po_dept_code AND am.language_id(+) = ? AND nvl(MS.STORE_GROUP_CODE,'%') like ? and  ms.language_id = ? ");
		}else{
		//sqlMap.put( "sqlData", MmRepository.getMmKeyValue("SQL_MM_STORE_QUERYCRIT2"));
		sqlMap.put( "sqlData", "SELECT po_dept_code,store_code, ms.long_desc, ms.short_desc,am_get_desc.am_dept (ad.dept_code, ?, '2') dept_code, external_yn,ms.eff_status,decode(INTERFACE_TO_EXTERNAL_PO_YN,'Y',am.short_desc,'') po_dept_desc,(CASE WHEN ms.store_group_code IS NOT NULL THEN (SELECT sg.short_desc FROM mm_store_group_lang_vw sg WHERE sg.store_group_code = ms.store_group_code AND sg.language_id = ?) END ) store_group_desc FROM mm_store_lang_vw ms, am_facility_dept_vw ad,am_dept_lang_vw am,st_acc_entity_param stac WHERE ms.dept_code = ad.dept_code(+) AND ms.facility_id = ad.operating_facility_id(+) AND UPPER (store_code) LIKE UPPER (?) AND UPPER (ms.short_desc) LIKE UPPER (?) AND ms.eff_status LIKE UPPER (?) AND UPPER (NVL (ms.dept_code, 'X')) LIKE UPPER (?) AND external_yn LIKE (?) AND ms.facility_id LIKE UPPER (?) and am.dept_code(+) = ms.PO_DEPT_CODE and am.language_id(+) = ? and stac.ACC_ENTITY_ID = ? and nvl(MS.STORE_GROUP_CODE,'%') like ? and ms.language_id(+) = ?");
	}

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "store_code" );
	displayFields.add( "long_desc"	);
	displayFields.add( "short_desc" );
	displayFields.add( "dept_code"  );
	displayFields.add( "store_group_desc" );
	displayFields.add( "external_yn");
	displayFields.add( "eff_status" );
	displayFields.add( "po_dept_desc" );
	
	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();

	//SELECT store_code,long_desc, short_desc, am_get_desc.am_dept (ad.dept_code, ?, '2') dept_code, external_yn,ms.eff_status FROM mm_store ms , AM_FACILITY_DEPT_VW ad WHERE ms.dept_code=ad.dept_code(+) AND ms.FACILITY_ID =ad.OPERATING_FACILITY_ID(+) AND UPPER(store_code) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?)  AND ms.eff_status LIKE UPPER(?) AND UPPER(NVL(ms.dept_code,'X')) LIKE UPPER(?) AND external_yn LIKE (?) AND ms.facility_id LIKE UPPER(?)

	chkFields.add(locale);		
	chkFields.add(locale);
	chkFields.add(store_code);
	chkFields.add(short_desc);
	chkFields.add(eff_status);
	chkFields.add( dept_code);
	chkFields.add( external_yn);
	chkFields.add( facility_id);
	chkFields.add( locale);
	if(interface_to_external_po_yn.equals("Y")){
		chkFields.add( (String)session.getAttribute("ACC_ENTITY_ID"));
	}	
	chkFields.add( store_group);
	chkFields.add( locale);

	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	//out.println((String) result.get(0));
	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=0 cellspacing=0 width="100%" align=center >
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
	     out.println(result.get(1));

	%>
		</td></tr>
		</table>

		<table border="1" cellpadding="0" cellspacing="0" width="100%" align=center>
		<th><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/> </th><th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/> </th><th><fmt:message key="Common.department.label" bundle="${common_labels}"/></th><th><fmt:message key="eMM.StoreGroup.label" bundle="${mm_labels}"/></th><th><fmt:message key="Common.external.label" bundle="${common_labels}"/> </th><th> <fmt:message key="Common.Nature.label" bundle="${common_labels}"/></th>
		
		
	<%	if(interface_to_external_po_yn.equals("Y")){%>
				<th><fmt:message key="eMM.PODepartment.label" bundle="${mm_labels}"/> </th>
   				
			
	<%
			}
		//Retriving the records from result arraylist
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

			records=(ArrayList) result.get( recCount );
			if(interface_to_external_po_yn.equals("Y"))
				count=records.size();
			else
			count=records.size()-1;

			for(int colCount=0; colCount<count; colCount++){
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
	%>
					<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'>  <%=(String)records.get( colCount )%>    </font></td>
	<%
				}else{
	%>
					<td class="<%=classvalue%>" onclick="disableClick(event);"
					<%
							if(colCount == 6) {
								//out.println(" align=\'center\'>");
								if( ((String)records.get( colCount )).equals("E"))
									out.println("align='center' ><img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("align='center' ><img src=\'../../eCommon/images/disabled.gif\'></img>");
							}
							else if(colCount == 5) {
								//out.println(" align=\'center\'>");
								if( ((String)records.get( colCount )).equals("Y"))
									out.println("align='center' ><img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("align='center' ><img src=\'../../eCommon/images/disabled.gif\'></img>");
							}
							else {
								out.println(">"+CommonBean.checkForNull((String)records.get( colCount ),"&nbsp"));
							}
				//	out.println((String)records.get( colCount ));
				%></td>
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
	out.println(CommonBean.setForm ( request ,"../../eMM/jsp/StoreQueryResult.jsp", searched) );
} catch(Exception e) {
	//out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace(); // COMMON-ICN-0184
}
%>
</body>
</html>

