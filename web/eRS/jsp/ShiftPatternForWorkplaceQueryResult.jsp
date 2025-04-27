<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	ShiftPatternForWorkplaceQueryResult.jsp
*	Purpose 		:
*	Created By		:	Subbulakshmy. K
*	Created On		:	20-11-2004
*/
%>

<%-- JSP Page specific attributes start --%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<!-- <%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
 -->
<%-- Mandatory declarations end --%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<HTML>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String classvalue = "";
	
	/*----- Required while Selecting sql and Formatting display------*/

	try{
		String facility_id          = (String)session.getAttribute("facility_id");
		String locn_type		    = request.getParameter("locn_type");
		String workplace_code		= request.getParameter("workplace_code");
		String workplace_desc		= request.getParameter("workplace_desc");
		String shift_pattern_id		= request.getParameter("shift_pattern_id");
		String short_desc           = request.getParameter("short_desc");

		boolean searched = request.getParameter( "searched" ) == null? false : true  ;	

		if(locn_type == null || locn_type.equals("null")) locn_type =" "; else locn_type = locn_type.trim();
		if(workplace_code == null || workplace_code.equals("null")) workplace_code =" "; else workplace_code = workplace_code.trim();
		if(workplace_desc == null || workplace_desc.equals("null")) workplace_desc =" "; else workplace_desc = workplace_desc.trim();
		if(shift_pattern_id == null || shift_pattern_id.equals("null")) shift_pattern_id =" "; else shift_pattern_id = shift_pattern_id.trim();
		if(short_desc == null || short_desc.equals("null")) short_desc =" "; else short_desc = short_desc.trim();

		//Common parameters.
		HashMap sqlMap = new HashMap();

		//String sql_shiftpatternforworkplace="SELECT b.short_desc locn_type, a.workplace_code, c.workplace_desc, a.shift_pattern_id, d.short_desc shift_pattern_desc  FROM rs_shift_pattern_for_workplace a, am_care_locn_type b, rs_workplace c, rs_shift_pattern d WHERE  (? is null or d.locn_type =?) and d.locn_type=b.locn_type(+) AND UPPER (a.workplace_code) LIKE UPPER (?) AND UPPER (c.workplace_desc) LIKE UPPER (?)  AND UPPER (a.shift_pattern_id) LIKE UPPER (?) AND UPPER (d.short_desc) LIKE UPPER (?) AND a.facility_id = ? and c.facility_id=? AND c.workplace_code = a.workplace_code AND d.shift_pattern_id = a.shift_pattern_id and a.eff_status='E'";
		String sql_shiftpatternforworkplace="SELECT b.short_desc locn_type, a.workplace_code, c.workplace_desc, a.shift_pattern_id, d.short_desc shift_pattern_desc  FROM rs_shift_pattern_for_workplace a, am_care_locn_type_lang_vw b, rs_workplace_lang_vw c, rs_shift_pattern_lang_vw d WHERE  (? is null or d.locn_type =?) and d.locn_type=b.locn_type(+) AND UPPER (a.workplace_code) LIKE UPPER (?) AND UPPER (c.workplace_desc) LIKE UPPER (?)  AND UPPER (a.shift_pattern_id) LIKE UPPER (?) AND UPPER (d.short_desc) LIKE UPPER (?) AND a.facility_id = ? and c.facility_id=? AND c.workplace_code = a.workplace_code AND d.shift_pattern_id = a.shift_pattern_id and a.eff_status='E' and b.language_id = ? and c.language_id = b.language_id and d.language_id = b.language_id";
		sqlMap.put( "sqlData",sql_shiftpatternforworkplace);
		
		//The fields are going to be display
		ArrayList displayFields = new ArrayList();
		
		displayFields.add("locn_type");
		displayFields.add("workplace_code");
		displayFields.add("workplace_desc");
		displayFields.add("shift_pattern_id");
		displayFields.add("shift_pattern_desc");
		
		//The fields are going to be in where condition * shld match with the qry//
		ArrayList chkFields = new ArrayList();

		chkFields.add( locn_type );
		chkFields.add( locn_type );
		chkFields.add( workplace_code+"%" );
		chkFields.add( workplace_desc+"%" );
		chkFields.add( shift_pattern_id+"%" );
		chkFields.add( short_desc+"%" );
		chkFields.add( facility_id );
		chkFields.add( facility_id );
		chkFields.add( locale );


		// Adding function related array list into the HashMap//
		HashMap funcMap = new HashMap();
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );
		
		//Calling the Result from Common Adaptor as a arraylist.//
		ArrayList result=new ArrayList();
		result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
		if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){

%>

			<table cellpadding=0 cellspacing=0 width="98%" align="center">
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

			<table cellpadding=0 cellspacing=0 border=1 width='98%'>
			<tr>
				<th width="15%"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
				<th width="15%"><fmt:message key="eRS.WorkplaceCode.label" bundle="${rs_labels}"/></th>
				<th width="35%"><fmt:message key="eRS.WorkplaceDescription.label" bundle="${rs_labels}"/></th>
				<th width="15%"><fmt:message key="eRS.ShiftPatternID.label" bundle="${rs_labels}"/></th>
				<th width="20%"><fmt:message key="eRS.ShiftPatternDescription.label" bundle="${rs_labels}"/></th>
			</tr>
<%
			//Retriving the records from result arraylist
			ArrayList records=new ArrayList();
			
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
				
				records=(ArrayList) result.get( recCount );
%>				
				<tr>   
<%
				for(int colCount=0; colCount<records.size(); colCount++){		
					String str = (String)records.get(colCount)==null?"":(String)records.get(colCount);
					if(str.equals("")){
%>
						<td class="<%=classvalue%>">&nbsp;</td>
<%
					}
					else {
%>
						<td class="<%=classvalue%>"><%=str%></td>
<%
					}
				}//end of for loop
%>
				</tr>
<%
			}//L00p for all records%>
			</table>
<%
			out.flush();
		}
		else{
%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
<%
		}
		out.println(CommonBean.setForm(request ,"../../eRS/jsp/ShiftPatternForWorkplaceQueryResult.jsp", searched));
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	}
%>
</body>
</html>  

