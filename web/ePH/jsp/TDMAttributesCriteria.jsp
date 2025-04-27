<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>

<%@ page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<!-- <LINK rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");


String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<!-- import the calendar script -->
	<SCRIPT language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></SCRIPT>
	<SCRIPT language="JavaScript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT language="javascript" src="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT language="Javascript" src="../../ePH/js/TDMAttributes.js"></SCRIPT>
	<script language="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<FORM name="formTDMAtrributesCriteria" id="formTDMAtrributesCriteria">
<%
	String	bean_id									=	"TDMAttributes" ;
	String	bean_name								=	"ePH.TDMAttributesBean";
	String mode										=	request.getParameter("mode");
	/* Variable Declarations start */
	String readonly									=	"";
	String disabled									=	"";
	String drugDesc									=	"";
	String drugCode									=	"";
	String ageGroup									=	"";
	String ageGrpCode								=	"";
	String steadyStatevalue						    =	"";
	String selAgeGrp								=	"";
	String steadyStateType						    =	"";
	String selected1								=	"";
	String selected2								=	"";
	String selected3								=	"";
	String minAge									=	"";
	String maxAge									=	"";
	String gender									=	"";
	String ageUnit									=	"";
	String code										=	"";
	String desc										=	"";
	String sampleType								=	"";
	String gender_val								=	"";
	String  maxageunit								=	"";

	String sql_ph_TDM_select1						=	PhRepository.getPhKeyValue("SQL_PH_TDM_SELECT1");
	 HashMap getHeaderValues						=	new HashMap();
 	 HashMap	record								=	new HashMap();
	 ArrayList getValues							=	new ArrayList();
	 ArrayList arrListAgeGroupRelated				=	new ArrayList();
	/* Variable Declartions end*/
	/* Mandatory checks start */	
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
		/* Mandatory checks end */
		/* Initialize Function specific start */
	TDMAttributesBean bean	=	 (TDMAttributesBean)getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	bean.clear() ;
	bean.setMode(mode) ;
		/* Initialize Function specific end */
		//Loads the List of AgeGroups
	arrListAgeGroupRelated		=		bean.getAgeGroupRelatedInfo();	
		//If it in Modify Mode
	if(mode.equals("2"))
		{
			 drugCode					=		request.getParameter("drugCode");
			 ageGrpCode					=		request.getParameter("ageGrpCode");
			 readonly					=		"READONLY";
			 disabled					=		"DISABLED";
			 getHeaderValues			=		(HashMap)bean.loadHeaderValues(drugCode,ageGrpCode);
			 drugDesc					=		(String)getHeaderValues.get("drugDesc");
			 ageGroup					=		(String)getHeaderValues.get("ageGrpCode");
			 minAge						=		(String)getHeaderValues.get("minAge");
			 maxAge						=		(String)getHeaderValues.get("maxAge");
			 gender						=		(String)getHeaderValues.get("gender");
			 maxageunit					=		(String)getHeaderValues.get("maxageUnit");
			 if(gender==null){
				gender="";
			 }
			 ageUnit					=		(String)getHeaderValues.get("ageUnit");
			 steadyStatevalue			=		(String)getHeaderValues.get("steadyState");
			 steadyStateType			=		(String)getHeaderValues.get("steadyStateType");
             gender_val					=		gender;
			 if(gender.equals("F"))
				 gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			 else if(gender.equals("M"))
				 gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			 else if(gender.equals("U"))
				gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			 else
				gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");  

			 if(ageUnit.equals("Y"))
				 ageUnit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Years.label","common_labels");
			 else if(ageUnit.equals("M"))
				 ageUnit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.months.label","common_labels");
			 else if(ageUnit.equals("D"))
				 ageUnit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
			 else if(ageUnit.equals("W"))
				 ageUnit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weeks.label","common_labels");






			 if(maxageunit.equals("Y"))
				 maxageunit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Years.label","common_labels");
			 else if(maxageunit.equals("M"))
				 maxageunit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.months.label","common_labels");
			 else if(maxageunit.equals("D"))
				 maxageunit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
			 else if(maxageunit.equals("W"))
				 maxageunit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weeks.label","common_labels");

			  
			 
			 if(steadyStateType.equals("D"))
				 selected1="selected";
			 else if (steadyStateType.equals("H"))
				 selected2="selected";
			 else if (steadyStateType.equals("M"))
				 selected3="selected";
			 			 
		}

	
%>

<TABLE cellpadding=0 cellspacing=0 width="90%"  align="center" border="0" >

		<TR >
				<TD align="right" class="label"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></TD>
				<TD align="left" colspan="3" >&nbsp;&nbsp;<INPUT type="text" name="drugName" id="drugName" <%=readonly%> value="<%=drugDesc%>" maxlength="60" size="60" onblur="diplayResult()"><INPUT type="button" class="button" value="?" name="drug_name_search" id="drug_name_search" onclick="searchDrugName();" >&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align="center"></IMG>
				<INPUT type="hidden" name="drugCode" id="drugCode" value="<%=drugCode%>">
				</TD>	
		</TR>
		<TR><TD colspan="6">&nbsp;</TD></TR>
		<TR >
					<TD align="right" class="label"><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></TD>
					<TD align="left" colspan="3">&nbsp;&nbsp;<SELECT name="ageGrp" id="ageGrp" <%=disabled%> onchange="chkforoverlap();ageGroupInfo(this);checkforvalid(this);diplayResult()">
								<OPTION>&nbsp;&nbsp;  ---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---  &nbsp;&nbsp;</OPTION>
					<%
							for (int i=0;i<arrListAgeGroupRelated.size();i++){
							String[] strAgeGroupRelated=(String[])arrListAgeGroupRelated.get(i);
							if(ageGroup.equals(strAgeGroupRelated[0]))
								selAgeGrp="selected";
							else
								selAgeGrp="";


					%>
						<OPTION <%=selAgeGrp%> value="<%=strAgeGroupRelated[0]%>"><%=strAgeGroupRelated[1]%></OPTION>	
				<%
					}
				%>
								</SELECT>
								<IMG src="../../eCommon/images/mandatory.gif" align="center"></IMG>
					</TD>	
		</TR>
		<TR><TD colspan="6">&nbsp;</TD></TR>
		<SCRIPT>
				<%
					for (int i=0;i<arrListAgeGroupRelated.size();i++){
						String[] strAgeGroupRelated	= (String[])arrListAgeGroupRelated.get(i);
						String   ageunit			= strAgeGroupRelated[3];
						String   maxageUnit			= strAgeGroupRelated[6];
				
						
			 if(ageUnit.equals("Y"))
				 ageUnit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Years.label","common_labels");
			 else if(ageUnit.equals("M"))
				 ageUnit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.months.label","common_labels");
			 else if(ageUnit.equals("D"))
				 ageUnit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
			 else if(ageUnit.equals("W"))
				ageUnit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weeks.label","common_labels");
				
			 if(maxageunit.equals("Y"))
				 maxageunit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Years.label","common_labels");
			 else if(maxageunit.equals("M"))
				 maxageunit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.months.label","common_labels");
			 else if(maxageunit.equals("D"))
				 maxageunit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
			 else if(maxageunit.equals("W"))
				 maxageunit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weeks.label","common_labels");




				%>
						genderArray['<%=i%>']		=	 "<%=strAgeGroupRelated[2]%>";
						ageunitArray['<%=i%>']		=	 "<%=ageunit%>";
						minageArray['<%=i%>']		=	 "<%=strAgeGroupRelated[4]%>";
						maxageArray['<%=i%>']		=	 "<%=strAgeGroupRelated[5]%>";
						maxageunitArray['<%=i%>']	=	 "<%=maxageUnit%>";
				<%
					}
				%>
				</SCRIPT>
		<TR>
		<!-- <TD align="right" class="label">Gender</TD><TD align="left"  class="label">&nbsp;&nbsp;<INPUT type="text" name="gender" id="gender"  maxlength="6" size="6" value="<%=gender%>" readonly>&nbsp;&nbsp;&nbsp;&nbsp;Age Unit&nbsp;&nbsp;<INPUT type="text" name="ageUnit" id="ageUnit"  maxlength="6" size="6" value="<%=ageUnit%>" readonly></TD> -->
		<TD align="right" class="label"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></TD>&nbsp;&nbsp;<TD align="left"  class="label" id="gender" colspan='3'>&nbsp;&nbsp;<B><%=gender%></B></TD>
		</TR>					
		<TR><TD colspan="6">&nbsp;</TD></TR>															
		<TR >
<!-- 		<TD align="right" class="label">Min Age</TD>
		<TD align="left" class="label">&nbsp;&nbsp;<INPUT type="text" name="minAge" id="minAge"   maxlength="4" size="4" value="<%=minAge%>"readonly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Max Age&nbsp;&nbsp;<INPUT type="text" name="maxAge" id="maxAge"   maxlength="4" size="4" value="<%=maxAge%>" readonly></TD> -->

		<TD align="right" class="label" width="13%"><fmt:message key="Common.MinAge.label" bundle="${common_labels}"/></TD>
		<TD align="left" class="label" id='minAge'  width="12%">&nbsp;&nbsp;<B><%=minAge%>&nbsp;&nbsp;&nbsp;<%=ageUnit%></B></TD>
		<TD align="right" class="label" width="10%"><fmt:message key="Common.MaxAge.label" bundle="${common_labels}"/></TD>
		<TD align="left" class="label" id='maxAge' width="57%" >&nbsp;&nbsp;<B><%=maxAge%>&nbsp;&nbsp;&nbsp;<%=maxageunit%></B></TD>
		</TR>
		<TR><TD colspan="6">&nbsp;</TD></TR>
		<TR >
					<TD align="right" class="label"><fmt:message key="ePH.SteadyState.label" bundle="${ph_labels}"/></TD>
					<TD align="left" colspan="3">&nbsp;&nbsp;<INPUT type="text"  <%=readonly%> class="number" name="steadyState"  value="<%=steadyStatevalue%>" maxlength="2" size="1" onblur="diplayResult()">
					<SELECT name="steadyStateType" id="steadyStateType" <%=disabled%> >
						<OPTION <%=selected1%> value="D"><fmt:message key="Common.days.label" bundle="${common_labels}"/></OPTION>
						<OPTION <%=selected2%> value="H"><fmt:message key="Common.hours.label" bundle="${common_labels}"/></OPTION>
						<OPTION <%=selected3%> value="M"><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></OPTION>
					</SELECT>
					<IMG src="../../eCommon/images/mandatory.gif" align="center"></IMG>
					</TD>	
		</TR>
	
</TABLE>
<%
	if(mode.equals("2"))
	{
	
		getValues=bean.loadIntialValues(drugCode,ageGrpCode);
		for(int i=0;i<getValues.size();i++)
		{
			record					=		(HashMap)getValues.get(i);
			code					=		(String)record.get("orderCatalogCode");
			desc					=		(String)record.get("orderCatalogDesc");
			sampleType				=		(String)record.get("samplingType");

			bean.setSelectLabOrder(code,desc,"Y",sampleType);
			bean.setSelectLabOrderFinal(sampleType);
			bean.loadSampleDetails(drugCode,ageGrpCode);
		}
%>
	<script>loadResult();</script>

<%

	}
%>

			<INPUT type="hidden" name="sql_ph_TDM_select1" id="sql_ph_TDM_select1"	value="<%=sql_ph_TDM_select1%>">
			<INPUT type="hidden" name="mode" id="mode"				value="<%= mode %>">
			<INPUT type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
			<INPUT type="hidden" name="bean_name" id="bean_name"			value="<%=bean_name%>">
			<INPUT type="hidden" name="gender_val" id="gender_val"			value="<%=gender_val%>">
			<INPUT type="hidden" name="language_id" id="language_id"			value="<%=locale%>">
			
			
</FORM>
<% putObjectInBean(bean_id,bean,request); %>
</BODY>
</HTML>

