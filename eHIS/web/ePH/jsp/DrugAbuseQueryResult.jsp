<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<HTML>
<HEAD>
	<TITLE></TITLE>
	<%
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	   <script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<!--<script language='javascript' src='../../eCommon/js/messages.js'></script>-->
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DrugAbuse.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</HEAD>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<form name='' id=''>

<%
	//String p_restriction_type	= request.getParameter( "p_restriction_type" ) ;
	String p_drug_class			= request.getParameter( "p_drug_class" ) ;
	String p_drug				= request.getParameter( "p_drug_code" ) ;
	String p_action_type		= request.getParameter( "p_action_type" ) ;
	String p_patient_id			= request.getParameter( "p_patient_id" ) ;
	String p_restriction_type=request.getParameter( "p_restriction_type" )==null?"":request.getParameter( "p_restriction_type" );
System.out.println("p_restriction_type"+p_restriction_type);
//System.err.println("p_restriction_type"+p_restriction_type+"p_drug_class"+p_drug_class+"==p_drug"+p_drug+"==p_action_type"+p_action_type+"==p_patient_id"+p_patient_id);
//	String facility_id			= (String) session.getValue( "facility_id" );

	String bean_id		= "DrugAbuseBean" ;
	String bean_name	= "ePH.DrugAbuseBean";
	DrugAbuseBean bean = (DrugAbuseBean)getBeanObject( bean_id,bean_name, request ) ;
	bean.setLanguageId(locale);


	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
	String ord[]				= request.getParameterValues("orderbycolumns");

	try {
		
			String classvalue		= "";

			p_restriction_type		= CommonBean.checkForNull( p_restriction_type );
			p_drug_class			= CommonBean.checkForNull( p_drug_class );
			p_drug					= CommonBean.checkForNull( p_drug );
			p_action_type			= CommonBean.checkForNull( p_action_type );
			p_patient_id			= CommonBean.checkForNull( p_patient_id );
 
			String sql = "SELECT  A.PATIENT_ID PATIENT_ID, DECODE(A.RESTRICTION_TYPE,'DC','Drug Class','DN','Drug Name',A.RESTRICTION_TYPE) RESTRICTION_TYPE_DESC, DECODE(A.DRUG_CLASS_OR_DRUG_CODE,'G','General','C','Controlled','N','Narcotics',(select drug_desc from ph_drug where drug_code=a.drug_class_or_drug_code)) DRUG_CLASS_OR_DRUG_CODE_DESC, NVL(A.RESTRICT_TRAN_TYPE,'N') RESTRICT_TRAN_TYPE, DECODE(A.ACTION_TYPE_FLAG,'B','Block','U','Unblock') ACTION_TYPE_FLAG,A.RESTRICTION_TYPE RESTRICTION_TYPE, A.DRUG_CLASS_OR_DRUG_CODE DRUG_CLASS_OR_DRUG_CODE,REMARKS FROM PH_DRUG_ABUSE_PAT_MST A  WHERE  UPPER(A.RESTRICTION_TYPE) 	LIKE UPPER(?) AND UPPER(A.PATIENT_ID) LIKE UPPER(?)  AND UPPER(A.ACTION_TYPE_FLAG)  LIKE UPPER(?) AND UPPER(A.DRUG_CLASS_OR_DRUG_CODE) LIKE UPPER(?) ";

			HashMap sqlMap = new HashMap();
			//sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_SELECT5"));
			sqlMap.put( "sqlData", sql);
		
			//The fields are going to be display
			ArrayList displayFields = new ArrayList();
			displayFields.add("RESTRICTION_TYPE_DESC" );
			displayFields.add("PATIENT_ID" );
			displayFields.add("DRUG_CLASS_OR_DRUG_CODE_DESC" );
			displayFields.add("ACTION_TYPE_FLAG" );
			displayFields.add("RESTRICT_TRAN_TYPE" );
			displayFields.add("REMARKS");
			displayFields.add("RESTRICTION_TYPE" );//for hidden field
			displayFields.add("DRUG_CLASS_OR_DRUG_CODE" );//for hidden field
 
  
			//The fields are going to be in where condition * should match with the query
			ArrayList chkFields = new ArrayList();
			chkFields.add( p_restriction_type.trim() );
			chkFields.add( p_patient_id.trim() + "%" );
			chkFields.add( p_action_type.trim() + "%" );
			if(p_restriction_type!=null && p_restriction_type.equalsIgnoreCase("DC"))
				chkFields.add( p_drug_class.trim() + "%" );
			else 
				chkFields.add( p_drug.trim() + "%" );			 
			// Adding function parameters related array list into the HashMap
			HashMap funcMap = new HashMap();
			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );

			//Calling the Result from Common Adaptor as a arraylist.
			//ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);

			

			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )) {
%>
<table  cellpadding=0 cellspacing=5  width="100%" align="center" >
			<tr>

				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;

		<%
//				 For display the previous/next link
				out.println(result.get(1));
		%>
				</td>
			</tr>
			</table>

		<TABLE BORDER="1" CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center">
		<TR>	
			<TH ><fmt:message key="ePH.RestrictionType.label" bundle="${ph_labels}"/></TH>
			<TH ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></TH>
			<%if(p_restriction_type.equals("DC")){ %>
			<TH >Restricted Class</TH>
			<%}else{ %>
			<TH ><fmt:message key="ePH.RestrictedDrug.label" bundle="${ph_labels}"/></TH>
			<%} %>
			<TH ><fmt:message key="Common.action.label" bundle="${common_labels}"/></TH>
			<TH ><fmt:message key="ePH.RestrictTransaction.label" bundle="${ph_labels}"/></TH>
			<TH >Remarks</TH>
 		</TR>
<%
		//Retriving the records from result arraylist
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYODD" ;
				else
					classvalue = "QRYEVEN" ;
%>

		<TR>

<%
				String link_columns = "2";
				records=(ArrayList) result.get( recCount );

				for(int colCount=0; colCount<records.size(); colCount++) {

					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
%>

			<TD CLASS="<%=classvalue%>" onMouseOver="changeCursor(this);" onClick="Modify('<%=(String)records.get(1)%>','<%=(String)records.get(6)%>','<%=(String)records.get(7)%>')"><FONT CLASS="HYPERLINK"><%=(String)records.get(1)%></FONT> 
			</TD>

<%
					}
					else {
						String dispValue = (String)records.get( colCount );
						if (dispValue == null || dispValue.equals(""))
							dispValue = "&nbsp" ;
						if ( colCount==0  ||  colCount==2 ||  colCount==3) {
%>

							<TD CLASS="<%=classvalue%>" onClick="disableClick(event);" VALUE="<%=(String)records.get( colCount )%>"><%=dispValue%>

<%
						}
					
						else if ( colCount==4 ) {  //others dont paint

%>

						<TD CLASS="<%=classvalue%>" onClick="disableClick(event);" VALUE="<%=(String)records.get( colCount )%>">

<%
							if( (dispValue.equalsIgnoreCase("E"))|| (dispValue.equalsIgnoreCase("Y")) ) {
%>

								<IMG SRC="../../eCommon/images/enabled.gif"></IMG>

<%
							}
							else {
%>

								<IMG SRC="../../eCommon/images/disabled.gif"></IMG>

<%
							}
%>

			</TD>

<%
						}
						
						else if(colCount==5){
							
							%>
							<TD CLASS="<%=classvalue%>" onClick="disableClick(event);" VALUE="<%=(String)records.get( colCount )%>"><%=dispValue%>
				<%	}
						
					}
				}
%>
				
		</TR>

<%
	}
%>

		</TABLE>
		</FORM>

<%
		out.flush();
		}
		else{
%>

	<SCRIPT>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</SCRIPT>

<%
		}
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/DrugAbuseQueryResult.jsp", searched) );
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>

</BODY>
</HTML>

