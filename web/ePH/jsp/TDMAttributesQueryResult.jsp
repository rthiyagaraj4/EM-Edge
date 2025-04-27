<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import="ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
<%
    request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");

	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/CommonResult.js"></SCRIPT>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/TDMAttributes.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" style="overflow-y:hidden">
<%
	//Search Criteria's from Query Criteria page

	String drug_code		= request.getParameter("DRUG_CODE");
	String drug_desc		= request.getParameter("DRUG_DESC");
	String age_group_code	= request.getParameter("AGE_GROUP_CODE");
	//String ord[]			= request.getParameterValues("orderbycolumns");
	boolean searched		= request.getParameter( "searched" ) == null ? false : true  ;

	try{
			String classvalue			= "";
			drug_code = CommonBean.checkForNull( drug_code.trim() );
			drug_desc = CommonBean.checkForNull( drug_desc.trim() );
			age_group_code = CommonBean.checkForNull( age_group_code.trim() );

			//Common parameters.
			HashMap sqlMap = new HashMap();
			//include all the common parameters.
			sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_TDM_SELECT5"));

			//Function Parameters
			HashMap funcMap = new HashMap();
			//The fields are going to be display
			ArrayList displayFields = new ArrayList();

			displayFields.add( "DRUG_CODE" );
			displayFields.add( "DRUG_DESC" );
			displayFields.add( "AGE_GROUP_CODE" ); 
			displayFields.add( "SHORT_DESC" );
			displayFields.add( "MIN_AGE" );
			displayFields.add( "AGE_UNIT" );
			displayFields.add( "MAX_AGE" );
			displayFields.add( "AGE_UNIT_MAX" );			
			displayFields.add( "GENDER" );

			ArrayList chkFields = new ArrayList();
			chkFields.add( drug_code.trim() + "%");
			chkFields.add( drug_desc.trim() + "%");
			chkFields.add( age_group_code.trim()  + "%");
			chkFields.add( locale);

			// Adding function related array list into the HashMap
				funcMap.put( "displayFields", displayFields );
				funcMap.put( "chkFields", chkFields );

			//Calling the Result from Common Adaptor as a arraylist.
				ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
				if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
				
	%>
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center">
		<TR>
			<TD WIDTH="80%" CLASS="white">&nbsp;</TD>
			<TD WIDTH="20%" CLASS="white">&nbsp;
	<%
        // For display the previous/next link
         out.println(result.get(1));

    %>

			</TD>
		</TR>
	</TABLE>
	<TABLE BORDER="1" CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center">
		
		<TH><fmt:message key="Common.DrugCode.label" bundle="${common_labels}"/></TH>
		<TH NOWRAP><fmt:message key="ePH.DrugDescription.label" bundle="${ph_labels}"/></TH>
		<TH NOWRAP><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></TH>
		<TH ><fmt:message key="Common.MinAge.label" bundle="${common_labels}"/></TH>
		<TH ><fmt:message key="Common.AgeUnit.label" bundle="${common_labels}"/></TH>
        <TH ><fmt:message key="Common.MaxAge.label" bundle="${common_labels}"/></TH> 
		<TH ><fmt:message key="ePH.MaxAgeUnit.label" bundle="${ph_labels}"/></TH>		
		<TH ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></TH>
	<%
		//Retriving the records from result arraylist
			ArrayList records=new ArrayList();
			for(int i=2;i<result.size();i++)
			{
				if ( i % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
	%>
			<TR >
	<%
					String link_columns = "1";
					records=(ArrayList) result.get( i );

					String ageUnit;
					String ageUnitMax;
					String gender;
					for(int j=0;j<records.size();j++)
					{
						ageUnit=(String)records.get(5)==null?"":(String)records.get(5);
						if(ageUnit.equals("Y"))
						ageUnit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Years.label","ph_labels");
						else if(ageUnit.equals("M"))
						ageUnit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.months.label","common_labels");
						else if(ageUnit.equals("D"))
						ageUnit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
						else if(ageUnit.equals("W"))
						ageUnit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.weeks.label","ph_labels");
						records.set(5,ageUnit);

						ageUnitMax=(String)records.get(7)==null?"":(String)records.get(7);
						if(ageUnitMax.equals("Y"))
						ageUnitMax=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Years.label","ph_labels");
						else if(ageUnitMax.equals("M"))
						ageUnitMax=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.months.label","common_labels");
						else if(ageUnitMax.equals("D"))
						ageUnitMax=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
						else if(ageUnitMax.equals("W"))
						ageUnitMax=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.weeks.label","ph_labels");
						records.set(7,ageUnitMax);

						gender=(String)records.get(8)==null?"":(String)records.get(8);
						if(gender.equals("F"))
						gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						else if(gender.equals("M"))
						gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						else if(gender.equals("U"))
						gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						records.set(8,gender);

						if(j!=2){
							if( link_columns.indexOf(String.valueOf(j+1)) != -1 ){
	%>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onClick="ModifyRow('<%=(String)records.get(j)%>','<%=(String)records.get(j+2)%>');"><font class='HYPERLINK'><%=(String)records.get( j )%></font>
	<%
						}else{
	%>
			<TD class="<%=classvalue%>" value="<%=(String)records.get(j)%>" onclick="disableClick(event);" >
	<%		
								String dkVal = (String)records.get( j );
								if(dkVal == null)	dkVal = "" ;
								if(dkVal.equals("")) dkVal = "&nbsp;";

								if((j==4 || j==5 || j==6||j==8)){
							//		out.println("align=\"center\">");
									out.println(dkVal);
									out.println("</td>");
								}
								else{
							//		out.println("align=\"left\">");
									out.println(dkVal);
									out.println("</td>");
								}
								dkVal = "";
					}
			}
		}
	%>		</td>
			</TR>
	<%
	}
	%>
	</TABLE>
	<%
	}else
		{
		 %>
		 <script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script> 
		<%
		}
		 out.println(CommonBean.setForm ( request ,"../../ePH/jsp/TDMAttributesQueryResult.jsp", searched) );
	} catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
		}
%>
</BODY>
</HTML>

