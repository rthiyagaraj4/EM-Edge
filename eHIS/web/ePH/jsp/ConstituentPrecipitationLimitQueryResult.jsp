<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="JavaScript" src="../../ePH/js/ConstituentPrecipitationLimit.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!-- <body onMouseDown="CodeArrest()" onKeyDown="lockKey()"> -->
<body onMouseDown="" onKeyDown="lockKey()">
<%
	//Search Criteria's from Query Criteria page
	//String CONST_GROUP_CODE	= request.getParameter( "constituent_group" );
	String CONST_GROUP_CODE	= request.getParameter( "constituent_group" );
	String constr_generic_frm_code			= request.getParameter( "constituent_gen_code_from" );
	String constr_generic_to_code		= request.getParameter( "constituent_gen_code_to" ) ;

	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
	try{
		String classvalue			= "";

		CONST_GROUP_CODE = CommonBean.checkForNull( CONST_GROUP_CODE.trim() );
		constr_generic_frm_code		   = CommonBean.checkForNull( constr_generic_frm_code.trim() );
		constr_generic_to_code   = CommonBean.checkForNull( constr_generic_to_code.trim() );
	
	//Common parameters.
	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", "SELECT DISTINCT b.CONST_GROUP_NAME constituent_Group_code, (SELECT const_generic_name FROM PH_TPN_CONST_GENERIC_NAME WHERE const_generic_code =a.constr_generic_frm_code) constituent_gen_code_from,(SELECT DESCRIPTION FROM PH_TPN_ELECT_MOL_FORMULA WHERE MOLECULE_CODE = a.MOLECULE_FRM_CODE) constituent_mole_desc_from,(SELECT const_generic_name FROM PH_TPN_CONST_GENERIC_NAME WHERE const_generic_code =a.constr_generic_to_code) constituent_gen_code_to, (SELECT DESCRIPTION FROM PH_TPN_ELECT_MOL_FORMULA WHERE MOLECULE_CODE = a.MOLECULE_TO_CODE) constituent_mole_desc_to,a.const_prec_message constituent_message,a.SRL_NO seq_no ,a.EFF_STATUS constituent_YN FROM PH_TPN_CONS_PREC_MOL a, PH_TPN_CONSTITUENT_GROUP b,PH_TPN_CONST_GENERIC_NAME c WHERE upper(b.CONST_GROUP_CODE) LIKE upper(?) and upper(a.constr_generic_frm_code) like upper(?) AND upper(a.constr_generic_to_code) like upper(?) AND UPPER(c.CONST_GROUP_CODE)=upper(b.CONST_GROUP_CODE) AND upper(c.CONST_GENERIC_CODE) IN (UPPER (a.constr_generic_frm_code), UPPER (a.constr_generic_to_code))");

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields that are going to be display
	ArrayList displayFields = new ArrayList();

	
	displayFields.add( "constituent_Group_code" );
	displayFields.add( "constituent_gen_code_from" );
	displayFields.add( "constituent_mole_desc_from" );
	displayFields.add( "constituent_gen_code_to" );
	displayFields.add( "constituent_mole_desc_to" );
	displayFields.add( "constituent_message" );
	//displayFields.add( "constituent_YN" );
	displayFields.add( "seq_no" );
	displayFields.add( "constituent_YN" );
	

	ArrayList chkFields = new ArrayList();
	chkFields.add( CONST_GROUP_CODE.trim() + "%" );
	chkFields.add( constr_generic_frm_code.trim() + "%" );
	chkFields.add( constr_generic_to_code.trim() + "%" );
	
	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
	

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
		out.println(result.get(1));
	%>
	</td></tr>
	</table>
	<table border="1" cellpadding="0" cellspacing="0" width="130%" align="center">
	<th >Constituent Group</th><th >Constituent From</th><th>Molecule From</th><th >Constituent To</th><th >Molecule To</th><th >Message</th><th style="display:none" ></th><th >Enable</th>
	   <%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();

		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
	%>
			<tr onClick="Modify(this);" >
	<%

			String link_columns = "1";
			records=(ArrayList) result.get( recCount );

			for(int colCount=0; colCount<records.size(); colCount++){
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){

	%>
			<td class="<%=classvalue%>" ><font class='HYPERLINK' onmouseover="changeCursor(this);">  <%=(String)records.get( colCount )%>    </font></td>
	<%
				}else{
	%>
					<td class="<%=classvalue%>" onclick="disableClick(event);"  value="<%=(String)records.get( colCount )%>"
	<%
					
					String dkVal = (String)records.get( colCount );
			
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";

					if((colCount==6)){
 						out.println("align=\"center\" style=\"display:none\">");
 						//out.println("align=\"center\">");
						out.println(dkVal);
						out.println("</td>");
					}else if((colCount==1)){
						out.println("align=\"left\">");
						out.println(dkVal);
						out.println("</td>");
					}else if((colCount==5)){
						out.println("align=\"left\" >");
						out.println(dkVal);
						out.println("</td>");
					}
					else if((colCount==7)){
						out.println("align=\"left\" >");
						out.println(getImage(dkVal));
						out.println("</td>");
					}else{
						out.println("align=\"left\">");
						out.println(dkVal);
						out.println("</td>");
					}
					dkVal = "";
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
		}else{
	%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
	}
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/ConstituentPrecipitationLimitQueryResult.jsp", searched) );
	} catch(Exception e) {
		out.print("Exception @ ConstituentPrecipitationLimitResult JSP :"+e.toString());
	}
%>
<%!
public String getImage(String value){
	//value="E";
	if(value.equalsIgnoreCase("E"))
		return "<img src=\"../../eCommon/images/enabled.gif\"><input type='hidden' value='E'>";
	else
		return "<img src=\"../../eCommon/images/disabled.gif\"><input type='hidden' value='D'>";
}
%>
</body>
</html>

