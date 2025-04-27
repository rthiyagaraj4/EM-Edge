<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
05/12/2012	  IN034470 		Karthi L	  		When creating new library setup, age groups not created completely and query back not displaying corresponding stored data
---------------------------------------------------------------------------------------------------------------
*/ %>
<%-- JSP Page specific attributes start --%>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.*, com.ehis.eslp.* ,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="LibrarySetupAgeGroup" class="webbeans.eCommon.RecordSet" scope="session"/>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- jsp:useBean id="mh" scope="session" class="CommonMultipleHandler" --%>
<%-- To call the Common MultipleHandler where the id will be as mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%-- Mandatory declarations end --%>

<HTML>
  <HEAD>
<%
//This file is saved on 19/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT language="JavaScript" src="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT language="javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT language="JavaScript" src="../../eCP/js/LibrarySetUp.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  </HEAD>
  <%
		Connection connection 			=		null;
		Statement stmt					=		null;
		PreparedStatement pstmt			=		null;
		ResultSet rs					=		null;

	  String mode						=		request.getParameter("mode");
	  int version_no					=		0;
	   int dependency_level				=		0;
	  String libraryid					=		"";
	  String shortdesc					=		"";
	  String longdesc					=		"";
	  String qstatus					=		"";
	  String eff_status					=		"";
	  String eff_status_checked			=		"Checked";
	  String readonly					=		"";
	  String disabled					=		"";
	  String versionQuery				=		"";
	  String patClassQuery				=		"";
	  String ageGrpQuery				=		"";
	  String patcode					=		"";
	  String agecode					=		"";
  	  String addbyid					=		"";
  	  String versionremarks				=		"";
	  String finalString				=		mode;
	  String status						=		"D";
	  String library_basis				=		"0";
	  String descQuery					=		"";
	  String basepatclassquery			=		"SELECT PATIENT_CLASS, SHORT_DESC FROM AM_PATIENT_CLASS ORDER BY 2";
	  String baseageGrpClassquery		=		"SELECT AGE_GROUP_CODE,SHORT_DESC FROM AM_AGE_GROUP WHERE EFF_STATUS='E' ORDER BY 2";
	  ArrayList basepatclass			=		new ArrayList();
	  ArrayList baseageGrpClass			=		new ArrayList();
	  ArrayList patclass				=		new ArrayList();
	  ArrayList ageGrpClass				=		new ArrayList();

	   // System.err.println("mode "+mode);
	//	System.err.println("in header  "+request.getQueryString());

		try{
			connection		 =		 ConnectionManager.getConnection(request);
			stmt			 =		 connection.createStatement();

			rs=stmt.executeQuery(basepatclassquery);
			if(rs!=null){
				while(rs.next()){
					basepatclass.add(rs.getString("PATIENT_CLASS"));

				}
			}
			//System.err.println("basepatclass  "+basepatclass);
			rs.close();

			rs=stmt.executeQuery(baseageGrpClassquery);
			if(rs!=null){
				while(rs.next()){
					baseageGrpClass.add(rs.getString("AGE_GROUP_CODE"));

				}
			}
			rs.close();
			//System.err.println("baseageGrpClass  "+baseageGrpClass);

			java.util.Collections.sort(baseageGrpClass); // added for IN034470
		}catch(Exception e){
		 // out.println("Error is--->"+e);//COMMON-ICN-0181
                   e.printStackTrace();//COMMON-ICN-0181

		}
	  if(mode.equals("2"))
	  {
		 
		  libraryid		=		request.getParameter("library_id");
		  eff_status	=		request.getParameter("eff_status");
		  version_no	=		Integer.parseInt((String)request.getParameter("version_no"));
		//  System.err.println("version_no "+version_no);
		  try{
			  	//descQuery		=		"SELECT SHORT_DESC,LONG_DESC FROM CP_LIBRARY WHERE LIBRARY_ID='"+libraryid+"' AND VERSION_NO='"+version_no+"'";//common-icn-0180
			  	descQuery		=		"SELECT SHORT_DESC,LONG_DESC FROM CP_LIBRARY WHERE LIBRARY_ID= ? AND VERSION_NO= ?";//common-icn-0180
			  	
			  	pstmt = connection.prepareStatement(descQuery);//common-icn-0180
			  	pstmt.setString(1,libraryid);//common-icn-0180
			  	pstmt.setInt(2,version_no);//common-icn-0180
			  	//rs=stmt.executeQuery(descQuery);//common-icn-0180
			  	rs=pstmt.executeQuery();//common-icn-0180
				if(rs!=null){
					rs.next();
					shortdesc=rs.getString("SHORT_DESC");
					longdesc=rs.getString("LONG_DESC");
				}
				rs.close();
				pstmt.close();//common-icn-0180
				//System.err.println("LONG_DESC "+longdesc);
				//System.err.println("SHORT_DESC "+shortdesc);

		  }catch(Exception e){
			 // out.println("Error is--->"+e);//COMMON-ICN-0181
                          e.printStackTrace();//COMMON-ICN-0181
		  }
		  if(eff_status.equals("E"))
		  eff_status_checked		=	"Checked";
		  else{
			  eff_status_checked	=	"";

		  %>
			  <SCRIPT>unload()</SCRIPT>

		<%
		  		  disabled				=	"Disabled";
		  }
			  
		  finalString	=	finalString+"||"+version_no;
		  	  readonly	=	"READONLY";
			 try
			{
				 patClassQuery="SELECT 'Y' SELECTED_YN,A.PATIENT_CLASS PATIENT_CLASS,SHORT_DESC PATIEND_CLASS_DESC FROM CP_PAT_CLASS_FOR_LIBRARY A,AM_PATIENT_CLASS B WHERE LIBRARY_ID=? AND VERSION_NO=? AND A.PATIENT_CLASS=B.PATIENT_CLASS UNION SELECT 'N' SELECT_YN,PATIENT_CLASS PATIENT_CLASS,SHORT_DESC PATIENT_CLASS_DESC FROM AM_PATIENT_CLASS A WHERE NOT EXISTS(SELECT ROWID FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=? AND VERSION_NO=? AND PATIENT_CLASS=A.PATIENT_CLASS)";

			    ageGrpQuery="SELECT 'Y' SELECT_YN,A.AGE_GROUP_CODE AGE_GROUP_CODE,SHORT_DESC AGER_GROUP_DESC,DECODE(GENDER,'M','Male','F','Female','All')SEX_SPECIFIC,MIN_AGE||'  '||DECODE(AGE_UNIT,'D','Days','M','Months','Y','Years')AGE_MIN_UNIT,MAX_AGE||' '|| DECODE(NVL(AGE_UNIT_MAX,AGE_UNIT),'D','Days','M','Months','Y','Years')AGE_MAX_UNIT FROM CP_AGE_GRP_FOR_LIBRARY A,AM_AGE_GROUP B WHERE LIBRARY_ID=? AND VERSION_NO=? AND A.AGE_GROUP_CODE=B.AGE_GROUP_CODE UNION SELECT 'N' SELECT_YN,AGE_GROUP_CODE AGE_GROUP_CODE,SHORT_DESC AGER_GROUP_DESC,DECODE(GENDER,'M','Male','F','Female','All')SEX_SPECIFIC,MIN_AGE||' '||DECODE(AGE_UNIT,'D','Days','M','Months','Y','Years')AGE_MIN_UNIT,MAX_AGE||' ' ||DECODE(NVL(AGE_UNIT_MAX,AGE_UNIT),'D','Days','M','Months','Y','Years')AGE_MAX_UNIT FROM AM_AGE_GROUP A WHERE NOT EXISTS(SELECT ROWID FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=? AND VERSION_NO=? AND AGE_GROUP_CODE=A.AGE_GROUP_CODE) ORDER BY 2";

				versionQuery="SELECT VERSION_NO, VERSION_REMARKS, STATUS, DEPENDENCY_LEVEL, LIBRARY_BASIS,ADDED_BY_ID FROM CP_LIBRARY WHERE LIBRARY_ID=? AND VERSION_NO=?";


			
				pstmt			 =		 connection.prepareStatement(patClassQuery);
				pstmt.setString(1,libraryid);
				pstmt.setInt(2,version_no);
				pstmt.setString(3,libraryid);
				pstmt.setInt(4,version_no);
				rs					=		pstmt.executeQuery();
				
				while(rs.next())
				{
					qstatus		=		(String)rs.getString("SELECTED_YN");
					if(qstatus.equals("Y")){
							patcode		=		(String)rs.getString("PATIENT_CLASS");
							patclass.add(patcode);
					}
					
				}
				rs.close();
				pstmt.close();

//				rs			=	null;
				pstmt	=	connection.prepareStatement(ageGrpQuery);
				pstmt.setString(1,libraryid);
				pstmt.setInt(2,version_no);
				pstmt.setString(3,libraryid);
				pstmt.setInt(4,version_no);
				rs			=	pstmt.executeQuery();

				while (rs.next()){
					qstatus	=	(String)rs.getString("SELECT_YN");
					if(qstatus.equals("Y")){
							agecode=(String)rs.getString("AGE_GROUP_CODE");
							ageGrpClass.add(agecode);					
																		
					}
				}
				rs.close();
				pstmt.close();
				java.util.Collections.sort(ageGrpClass); // IN034470

				//rs=null;
				pstmt = connection.prepareStatement(versionQuery);
				pstmt.setString(1,libraryid);
				pstmt.setInt(2,version_no);
				rs=pstmt.executeQuery();
				if(rs.next()){
					addbyid=rs.getString("ADDED_BY_ID");
					versionremarks=rs.getString("VERSION_REMARKS");
					status=rs.getString("STATUS");
					dependency_level=rs.getInt("DEPENDENCY_LEVEL");
					library_basis=rs.getString("LIBRARY_BASIS");
				}
				rs.close();
				pstmt.close();

			  }catch(Exception e){
				  System.err.println(e.toString());
					e.printStackTrace();

				 }
				 finally
				{

					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(stmt!=null)	  stmt.close();
					if(connection != null)
						ConnectionManager.returnConnection(connection,request);					
				}	
			finalString=finalString+"||"+addbyid;
	  }
	   %>
  <BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<FORM name="LibraryHeaderForm" id="LibraryHeaderForm" method="post" action="../../servlet/eCP.LibrarySetUpServlet" target="messageFrame" >
<BR>
<TABLE cellpadding=0 cellspacing='5' width="90%" align="center" border="0">
	<TR>
		<TD align="right"  class="label"><fmt:message key="Common.identification.label" bundle="${common_labels}"/></TD>
		<TD align="left">&nbsp;&nbsp;
			<INPUT type="Text" name="library_id" id="library_id" size="20" maxlength="20" <%=readonly%> value="<%=libraryid%>" onblur="ChangeUpperCase(this);"  onKeyPress="return CheckForSpecChars(event);" >
			<IMG src="../../eCommon/images/mandatory.gif"></IMG>
		</TD>
	</TR>
	<TR>
		<TD align="right"  class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></TD>
		<TD align="left">&nbsp;&nbsp;
			<INPUT type="Text" name="short_desc_chk" id="short_desc_chk" size="60"   maxlength="60" onblur="CheckMaxLength1(this,'60')" <%=disabled%> value="<%=shortdesc%>">
			<IMG src="../../eCommon/images/mandatory.gif"></IMG>
		</TD>
	</TR>
	<TR>
		<TD align="right"  class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></TD>
		<TD align="left">&nbsp;&nbsp;
			<!-- <TEXTAREA name="long_desc"  rows="3" cols="55" maxlength="400" <%=disabled%> onBlur='makeValidString(this)' ><%=longdesc%></TEXTAREA> -->
			<TEXTAREA name="long_desc_chk"  rows="2" cols="50" maxlength="400" onblur="CheckMaxLength1(this,'400');makeValidString(this)"><%=longdesc%></TEXTAREA>
			<IMG src="../../eCommon/images/mandatory.gif"></IMG>
		</TD>
	</TR>
	<TR>
		<TD align="right"  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></TD>
		<TD align="left">&nbsp;&nbsp;
			<INPUT type="checkbox" name="eff_status" id="eff_status"  <%=eff_status_checked%> onclick="allowUpdate(this)">
		</TD>
	</TR>
	
</TABLE>
			<!-- 	VersionDetials hidden variables -->
			<INPUT type="hidden" name="version_remarks" id="version_remarks" value="<%=versionremarks%>">
			<INPUT type="hidden" name="Status" id="Status" value="<%=status%>">
			<INPUT type="hidden" name="dependency_level" id="dependency_level" value="<%=dependency_level%>">
			<INPUT type="hidden" name="libraryBasis" id="libraryBasis" value="<%=library_basis%>">
			<!-- End of version Details variables -->

			<!-- Patient Class hidden variables -->
<%	if(mode.equals("1")){
	//System.err.println("basepatclass  "+basepatclass.size());
		for(int k=0;k<basepatclass.size();k++){
		//	System.err.println("pat K "+k);
%>
		<INPUT type="hidden" name="patientchk_<%=k+1%>" id="patientchk_<%=k+1%>" value="<%=basepatclass.get(k)%>">

<%
		}
	}else{
		for(int k=0;k<basepatclass.size();k++){
			if(patclass.contains((String)basepatclass.get(k))){
%>
		<INPUT type="hidden" name="patientchk_<%=k+1%>" id="patientchk_<%=k+1%>" value="<%=basepatclass.get(k)%>">

<%
			}else{
%>
		<INPUT type="hidden" name="patientchk_<%=k+1%>" id="patientchk_<%=k+1%>" value="">
<%

			}
		}

	}
%>
		
				<!-- End of Patient Class variables -->


				<!-- Age Group class variables -->
<%	if(mode.equals("1")){
	//	System.err.println("agegrpclass  "+baseageGrpClass.size());

		for(int k=0;k<baseageGrpClass.size();k++){
		//				System.err.println("Age K "+k);

%>
			<INPUT type="hidden" name="AgeGrpChk<%=k+1%>" id="AgeGrpChk<%=k+1%>" value="">

<%		}
	}else{
		for(int k=0;k<baseageGrpClass.size();k++){
			if(ageGrpClass.contains((String)baseageGrpClass.get(k))){
%>
				<INPUT type="hidden" name="AgeGrpChk<%=k+1%>" id="AgeGrpChk<%=k+1%>" value="<%=baseageGrpClass.get(k)%>">

<%
			}else{
%>
				<INPUT type="hidden" name="AgeGrpChk<%=k+1%>" id="AgeGrpChk<%=k+1%>" value="">
<%			}
		}

	}

	for(int k=0;k<baseageGrpClass.size();k++){
	%>
		<INPUT type="hidden" name="BAgeGrpChk<%=k+1%>" id="BAgeGrpChk<%=k+1%>" value="<%=baseageGrpClass.get(k)%>">

	<%
	}
	%>
	<INPUT type="hidden" name="ege_grp_len" id="ege_grp_len" value="<%=baseageGrpClass.size()%>">
			

			<!-- Age Group class variables -->

			<INPUT type="hidden" name="eff_status_yn" id="eff_status_yn" value="<%=eff_status%>">
			<INPUT type="hidden" name="mode" id="mode" value="<%=mode%>">
			<INPUT type="hidden" name="version_no" id="version_no" value="<%=version_no%>">
			<INPUT type="hidden" name="long_desc" id="long_desc" value=""> 
			<INPUT type="hidden" name="libraryid" id="libraryid" value="<%=libraryid%>">
			<INPUT type="hidden" name="short_desc" id="short_desc" value=""> 
			<INPUT type="hidden" name="finalString" id="finalString" value="<%=finalString%>"> 
			<INPUT type="hidden" name="totPatClsRecords" id="totPatClsRecords" value="<%=basepatclass.size()%>"> 
			<INPUT type="hidden" name="totAgeGrpRecords" id="totAgeGrpRecords" value="<%=baseageGrpClass.size()%>">  <!-- added by IN034470 -->


			 <%if(mode.equals("2")){
					if(ageGrpClass.size()==baseageGrpClass.size()){%>
						<INPUT type="hidden" name="chkAll" id="chkAll" value="Y"> 
					<%}else{%>
						<INPUT type="hidden" name="chkAll" id="chkAll" value=""> 
					<%}
				 }else if(mode.equals("1")){%>
						<INPUT type="hidden" name="chkAll" id="chkAll" value=""> 
				 <%}%>


</FORM>
<%
	if(eff_status.equals("") || eff_status.equals("E")){%>
<SCRIPT> loadpage()</SCRIPT>
<%}%>
</BODY>
</HTML>

