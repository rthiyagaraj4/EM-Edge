<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	Suresh.S
*	Created On		:	09 Dec 2004
--%>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script> -->
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonResult.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/WorkplaceRequirement.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function Modify(wrkplace_code,wrkplace_desc,loc_type,frm_dt,to_dt,reqd_id,reqd_desc,fac_id)
	{
		var mode = "2";
		parent.parent.frames[1].location.href="../../eRS/jsp/WorkPlaceRequirementModifyFrameset.jsp?mode="+mode+"&wrkplace_code="+wrkplace_code+"&wrkplace_desc="+wrkplace_desc+"&loc_type="+loc_type+"&frm_dt="+frm_dt+"&to_dt="+to_dt+"&reqd_id="+reqd_id+"&reqd_desc="+reqd_desc+"&facility_id="+fac_id;
	}
	</script>
</head>
<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='QueryForm' id='QueryForm'>
<%
	String classvalue = "";
	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;

        try{
		String facility_id		=(String)session.getAttribute( "facility_id" );
		String wrk_place_code	= request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
		String locn_type 		= request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
		String wrk_desc			= request.getParameter("workplace_desc")==null?"":request.getParameter("workplace_desc");
		String requirement = request.getParameter("requirement")==null?"":request.getParameter("requirement");
		String sql_select="";
		boolean searched	= request.getParameter( "searched" ) == null? false : true  ;
		//Common parameters.
		HashMap sqlMap = new HashMap();
		
		if(requirement.equals("F"))
			//sql_select="SELECT a.workplace_code wrk_code,b.workplace_desc workplace_desc,TO_CHAR(a.requirement_date_fm,'dd/mm/yyyy')frm_dt,TO_CHAR(a.requirement_date_to,'dd/mm/yyyy') to_dt,a.facility_id fac_id,a.requirement_id reqd_id,a.requirement_type reqd_type, (CASE WHEN ((SYSDATE between trunc(a.requirement_date_fm) and trunc(a.requirement_date_to)) or trunc(requirement_date_to)<=trunc(sysdate)) THEN 'G' ELSE 'L' END) flag,b.locn_type locn_type, a.requirement_desc reqd_desc FROM RS_WORKPLACE_REQUIREMENT a,rs_workplace b WHERE UPPER(a.workplace_code) LIKE UPPER(?)AND UPPER(b.locn_type) LIKE UPPER(?)AND UPPER(b.workplace_desc) LIKE UPPER(?) AND a.facility_id=? AND b.locn_type = NVL(?,b.locn_type) AND b.workplace_code=a.workplace_code AND b.facility_id=a.facility_id and (trunc(a.requirement_date_fm)>trunc(sysdate)  or a.requirement_type = 'C')";
			sql_select="SELECT a.workplace_code wrk_code,b.workplace_desc workplace_desc,TO_CHAR(a.requirement_date_fm,'dd/mm/yyyy')frm_dt,TO_CHAR(a.requirement_date_to,'dd/mm/yyyy') to_dt,a.facility_id fac_id,a.requirement_id reqd_id,a.requirement_type reqd_type, (CASE WHEN ((SYSDATE between trunc(a.requirement_date_fm) and trunc(a.requirement_date_to)) or trunc(requirement_date_to)<=trunc(sysdate)) THEN 'G' ELSE 'L' END) flag,b.locn_type locn_type, a.requirement_desc reqd_desc FROM RS_WORKPLACE_REQUIREMENT a,rs_workplace_lang_vw b WHERE UPPER(a.workplace_code) LIKE UPPER(?)AND UPPER(b.locn_type) LIKE UPPER(?)AND UPPER(b.workplace_desc) LIKE UPPER(?) AND a.facility_id=? AND b.locn_type = NVL(?,b.locn_type) AND b.workplace_code=a.workplace_code AND b.facility_id=a.facility_id and (trunc(a.requirement_date_fm)>trunc(sysdate)  or a.requirement_type = 'C') and b.language_id = ?";
		else
			//sql_select="SELECT a.workplace_code wrk_code,b.workplace_desc workplace_desc,TO_CHAR(a.requirement_date_fm,'dd/mm/yyyy')frm_dt,TO_CHAR(a.requirement_date_to,'dd/mm/yyyy') to_dt,a.facility_id fac_id,a.requirement_id reqd_id,a.requirement_type reqd_type, (CASE WHEN ((SYSDATE between trunc(a.requirement_date_fm) and trunc(a.requirement_date_to)) or trunc(requirement_date_to)<=trunc(sysdate)) THEN 'G' ELSE 'L' END) flag,b.locn_type locn_type, a.requirement_desc reqd_desc FROM RS_WORKPLACE_REQUIREMENT a,rs_workplace b WHERE UPPER(a.workplace_code) LIKE UPPER(?)AND UPPER(b.locn_type) LIKE UPPER(?)AND UPPER(b.workplace_desc) LIKE UPPER(?) AND a.facility_id=? AND b.locn_type = NVL(?,b.locn_type) AND b.workplace_code=a.workplace_code AND b.facility_id=a.facility_id";
			sql_select="SELECT a.workplace_code wrk_code,b.workplace_desc workplace_desc,TO_CHAR(a.requirement_date_fm,'dd/mm/yyyy')frm_dt,TO_CHAR(a.requirement_date_to,'dd/mm/yyyy') to_dt,a.facility_id fac_id,a.requirement_id reqd_id,a.requirement_type reqd_type, (CASE WHEN ((SYSDATE between trunc(a.requirement_date_fm) and trunc(a.requirement_date_to)) or trunc(requirement_date_to)<=trunc(sysdate)) THEN 'G' ELSE 'L' END) flag,b.locn_type locn_type, a.requirement_desc reqd_desc FROM RS_WORKPLACE_REQUIREMENT a,rs_workplace_lang_vw b WHERE UPPER(a.workplace_code) LIKE UPPER(?)AND UPPER(b.locn_type) LIKE UPPER(?)AND UPPER(b.workplace_desc) LIKE UPPER(?) AND a.facility_id=? AND b.locn_type = NVL(?,b.locn_type) AND b.workplace_code=a.workplace_code AND b.facility_id=a.facility_id and b.language_id = ?";
			
		sqlMap.put( "sqlData",sql_select);
		//The fields are going to be display
		ArrayList displayFields = new ArrayList();
		displayFields.add("wrk_code");
		displayFields.add("workplace_desc");
		displayFields.add("frm_dt");
		displayFields.add("to_dt");
		displayFields.add("fac_id");
		displayFields.add("reqd_id");
		displayFields.add("reqd_type");
		displayFields.add("flag");
		displayFields.add("locn_type"); 
		displayFields.add("reqd_desc"); 	

		//The fields are going to be in where condition * shld match with the qry//
		ArrayList chkFields = new ArrayList();
		chkFields.add( wrk_place_code+"%" );
		chkFields.add( locn_type+"%" );
		chkFields.add( wrk_desc+"%" );
		chkFields.add(facility_id);
		chkFields.add( locn_type);	
		chkFields.add( locale);	
	

		// Adding function related array list into the HashMap//
		HashMap funcMap = new HashMap();
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );
		
		//Calling the Result from Common Adaptor as a arraylist.//
		ArrayList result=new ArrayList();
		result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
		
		if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){

		Con=ConnectionManager.getConnection(request);
		
			pstmt=Con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy') d from dual ");
			rslRst=pstmt.executeQuery();
			rslRst.next();
			if(pstmt != null)
				pstmt.close();
			if(rslRst != null)
				rslRst.close();
			ConnectionManager.returnConnection(Con,request);
			
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

	<th width='3%'>&nbsp;</th>
	<th width="20%"><fmt:message key="eRS.WorkplaceCode.label" bundle="${rs_labels}"/></th>
	<th width="50%"><fmt:message key="eRS.WorkplaceDescription.label" bundle="${rs_labels}"/></th>
	<th width="27%" colspan='2'><fmt:message key="eRS.RequirementPeriod.label" bundle="${rs_labels}"/></th>
</tr>
<tr>
	<th width='3%'>&nbsp;</th>	
	<th colspan='2'>&nbsp;</th>
	<th width=""><fmt:message key="Common.from.label" bundle="${common_labels}"/></th>
	<th width=""><fmt:message key="Common.to.label" bundle="${common_labels}"/></th>
</tr>
<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		
		for(int recCount=2; recCount<result.size(); recCount++) {
			
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
			String link_columns = "1";
			
			records=(ArrayList) result.get( recCount );
			
			
			String wrkplace_code = (String)records.get(0)==null?"":(String)records.get(0);
			
			String wrkplace_desc = (String)records.get(1)==null?"":(String)records.get(1);
			//String wrkplace_desc = "";
						
			String frm_dt		 = (String)records.get(2)==null?"":(String)records.get(2);
			//String frm_dt		 = "";
						
			String to_dt		 = (String)records.get(3)==null?"":(String)records.get(3);			
			//String to_dt		 = "";			
			

			String fac_id		 = (String)records.get(4)==null?"":(String)records.get(4);
			//String fac_id		 = "";
			String reqd_id		 = (String)records.get(5)==null?"":(String)records.get(5);
			//String reqd_id		 = "";
			String flag			 = (String)records.get(7)==null?"":(String)records.get(7);
			//String flag			 = "";
			String loc_type		 = (String)records.get(8)==null?"":(String)records.get(8);
			//String loc_type		 = "";
			String reqd_desc	 = (String)records.get(9)==null?"":(String)records.get(9);
			//String reqd_desc	 = "";
			
%>				
		<tr> 
			<td class="<%=classvalue%>" align=center><A id='consent' href='javascript:displayReqdDetls("<%=wrkplace_code%>","<%=fac_id%>","<%=reqd_id%>")'>+</A>
			</td>
<%
		for(int colCount=0; colCount<4; colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 && (flag.equalsIgnoreCase("L")))	{
%>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onClick="Modify('<%=wrkplace_code%>','<%=wrkplace_desc%>','<%=loc_type%>','<%=frm_dt%>','<%=to_dt%>','<%=reqd_id%>','<%=reqd_desc%>','<%=fac_id%>');"> 	<font class='HYPERLINK'><%=(String)records.get(colCount)%></font></td>
<%
			}
			else{
				String str = (String)records.get(colCount);
				if(str!=null)
				{
					if(colCount==2||colCount==3)
						str=com.ehis.util.DateUtils.convertDate(str,"DMY","en",locale);	
				}
				if(str == null) str ="&nbsp;"; else str = str.trim();
%>
					<td class="<%=classvalue%>"><%=str%></td>
<%
				}
			}//end of for loop
%>
			</tr>
<%
		}//L00p for all records
%>
		</table>
<%
		out.flush();
	}
	else{
%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
<%
	}
	out.println(CommonBean.setForm(request ,"../../eRS/jsp/WorkPlaceRequirementQueryResult.jsp", searched));
}catch(Exception e ){
	out.println(e);
}
%>
</form>
</body>
</html>

