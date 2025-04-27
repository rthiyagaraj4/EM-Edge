<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.* " %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.net.* ,java.text.*,eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<jsp:useBean id="BuildLibrary" class="webbeans.eCommon.RecordSet" scope="session"/>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
		<%
		//This file is saved on 18/10/2005.
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
      	<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
      	<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
		<SCRIPT language="javascript" src="../js/BuildLibrary.js"></SCRIPT> 
</HEAD>


<TITLE><fmt:message key="eCP.LOOKUP.label" bundle="${cp_labels}"/></TITLE>
<BODY onKeyDown = 'lockKey()'  OnMouseDown="CodeArrest()">
	<FORM name="formBuildLibraryShowDetails" id="formBuildLibraryShowDetails"action="../../servlet/eCP.BuildLibraryServlet" target="messageFrame" method="post">
	<script language='javascript'>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
String libraryid=request.getParameter("libraryid");
String versionno=request.getParameter("versionno");
String ATCERROR="ATCERROR";
String ATCTERMSETS="ATCTERMSET";
String termSet="";
String termCode="";
String termcodeStatus="";
String prevtermSet="";
String ATCTERMCODES="ATCTERMCODE";

String ATCGOALS="ATCGOAL";
String goalDesc="";
String goalStatus="";
String groupno="";
int maxgrpid=0;
boolean goalfound=false;


String ATCHEADS="ATCHEAD";
String ATCDETAILS="ATCDETAIL";
String interventionDesc="";
String interventionStatus="";
String interventiongrpid1="";
int interventiongrpid=0;
boolean interventionfound=false;


String outcomeDesc="";
String outcomeStatus="";
String outcomegrpid1="";

int outcomegrpid=0;
boolean outcomefound=false;



int finalResult=0;
ArrayList result=new ArrayList();
ArrayList Goal=null;
HashMap InterventionOutcome=null;
ArrayList Intervention=null;
ArrayList Outcome=null;


ArrayList sessionList		= (ArrayList)BuildLibrary.getRecordSetHandle();
ArrayList TermCodeList=null;
if(sessionList.size()>0)
{
	TermCodeList=(ArrayList)BuildLibrary.getObject(0);
}
//System.err.println("Termcodelist "+TermCodeList);
%>
 <TABLE border='1' cellpadding='0' cellspacing='0' align='center'  width='100%'> 
 <%
if(TermCodeList.size()>0){
	for(int i=0;i<TermCodeList.size();i=i+7){
		termSet=(String)TermCodeList.get(i);
		termCode=(String)TermCodeList.get(i+5);
		Goal=(ArrayList)TermCodeList.get(i+2);
		termcodeStatus=(String)TermCodeList.get(i+3);
		if(!termSet.equals(prevtermSet)){
				//print the termset			
%>
	<TR>
		<TD class="<%=ATCTERMSETS%>"><%=termSet%>
		</TD>
	</TR>
				
<%
		}
		//System.err.println("termcodeStatus "+termcodeStatus);
		if(termcodeStatus.equals("Y")){
			//print the termcode
%>
	<TR>
		<TD class="<%=ATCTERMCODES%>">&nbsp;&nbsp;<%=termCode%>
		</TD>
	</TR>
			
<%
			if(Goal.size()>0){
				for(int j=0;j<Goal.size();j=j+9){
					goalDesc=(String)Goal.get(j+7);
					InterventionOutcome=(HashMap)Goal.get(j+3);
					Intervention=(ArrayList)InterventionOutcome.get("I");
					Outcome=(ArrayList)InterventionOutcome.get("O");
					goalStatus=(String)Goal.get(j+4);
					groupno=(String)Goal.get(j+6);
//					System.err.println("groupno in temp goal"+groupno);
//					System.err.println("condition in temp goal"+(groupno!=null && groupno!="" && (!groupno.equals(""))));
					if(groupno!=null && groupno!="" && (!groupno.equals("")))
						maxgrpid=Integer.parseInt(groupno);
					else
						maxgrpid=0;
					
					if(goalStatus.equals("Y")){
						goalfound=true;
%>
	<TR>
		<TD class="<%=ATCGOALS%>">&nbsp;&nbsp;&nbsp;&nbsp;<%=goalDesc%>
		</TD>
	</TR>
<%			
					if(maxgrpid!=0){
						//print the goaldesc					
					for(int index=1;index<=maxgrpid;index++){
%>
	<TR>
		<TD class="<%=ATCHEADS%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Group.label" bundle="${common_labels}"/>  <%=index%>
		</TD>
	</TR>

<%
							//out.println("Intervention"+Intervention);
							if(Intervention.size()>0){
								for(int k=0;k<Intervention.size();k=k+13){
									interventionDesc=(String)Intervention.get(k+12);
									interventiongrpid1=(String)Intervention.get(k+1);
									//System.err.println("interventiongrpid1 "+interventiongrpid1);

									if(!(interventiongrpid1.equals("")) &&  interventiongrpid1!= null )
										interventiongrpid=Integer.parseInt((String)Intervention.get(k+1));
									else
										interventiongrpid=1;
									//System.err.println("interventiongrpid  "+interventiongrpid);
									interventionStatus=(String)Intervention.get(k+10);
									if(interventionStatus.equals("Y") && interventiongrpid==index){
												interventionfound=true;
												//print the intervetion desc
%>
	<TR>
		<TD class="<%=ATCDETAILS%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I <%=interventionDesc%>
		</TD>
	</TR>
<%
									}

								}
								
								if(!interventionfound){
								//	print"atleast one intervention shd be associated for each goal"
									result.add("0");
									
%>
	<TR>
		<TD class="<%=ATCERROR%>"><fmt:message key="eCP.Atleast1InterventionOutcomeexist.label" bundle="${cp_labels}"/></TD>
	</TR>
<%
								}
							}else{
							//print "atleast one intervention shd be associated for each goal"
								result.add("0");
%>
	<TR>
		<TD class="<%=ATCERROR%>"><fmt:message key="eCP.Atleast1InterventionOutcomeexist.label" bundle="${cp_labels}"/></TD>
	</TR>
<%
							}
							//System.err.println("term code "+termCode+"  outcome  "+Outcome);
							if(Outcome.size()>0){
								for(int k=0;k<Outcome.size();k=k+8){
									outcomeDesc=(String)Outcome.get(k+7);
									outcomeStatus=(String)Outcome.get(k+5);
									outcomegrpid1=(String)Outcome.get(k+1);
									//System.err.println("outcomegrpid1 "+outcomegrpid1);
									if(!(outcomegrpid1.equals("")) && outcomegrpid1!=null)
										outcomegrpid=Integer.parseInt((String)Outcome.get(k+1));
									else
										outcomegrpid=1;
									//outcomegrpid=Integer.parseInt((String)Outcome.get(k+1));
									if(outcomeStatus.equals("Y") && outcomegrpid==index){
										outcomefound=true;
										//out.println("desc   *"+outcomeDesc);
										//print the outcomedesc
%>
	<TR>
		<TD class="<%=ATCDETAILS%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O <%=outcomeDesc%>
		</TD>
	</TR>
<%
									}
								}
								if(!outcomefound){
									result.add("0");
									
									//print "atleast one oucome shd be associated for each goal"
%>
	<TR>
		<TD class="<%=ATCERROR%>"><fmt:message key="eCP.Atleast1InterventionOutcomeexist.label" bundle="${cp_labels}"/></TD>
	</TR>
<%
								}
							}else{
								result.add("0");
%>
	<TR>
		<TD class="<%=ATCERROR%>"><fmt:message key="eCP.Atleast1InterventionOutcomeexist.label" bundle="${cp_labels}"/></TD>
	</TR>
<%
								//print "Atleast one outcome shd be associated for each goal"
							}
							interventionfound=false;
							outcomefound=false;
						}	

					}else{
						result.add("0");
%>
	<TR>
		<TD class="<%=ATCERROR%>"><fmt:message key="eCP.Atleast1InterventionOutcomeassociated.label" bundle="${cp_labels}"/></TD>
	</TR>
<%
			
					}
				  }
				}
				if(!goalfound){
					result.add("0");
					//print "Atleast one goal to be associated"
%>
	<TR>
		<TD class="<%=ATCERROR%>"><fmt:message key="eCP.Atleast1Goalassociated.label" bundle="${cp_labels}"/></TD>
	</TR>
<%
				}
				
			}else{
				result.add("0");
				//print "atleast one goal to be associated"
%>
	<TR>
		<TD class="<%=ATCERROR%>"><fmt:message key="eCP.Atleast1Goalassociated.label" bundle="${cp_labels}"/></TD>
	</TR>
<%
			}
	
		}
		prevtermSet=termSet;
		
	}
}else{
	result.add("0");
	//print "atleast one termcode to be associated"
%>
	<TR>
		<TD class="<%=ATCERROR%>"><fmt:message key="eCP.Atleast1Terminologyassociated.label" bundle="${cp_labels}"/></TD>
	</TR>
<%
}
%>
 

 </TABLE> 
 <INPUT type="hidden" name="libraryid" id="libraryid" value="<%=libraryid%>">
 <INPUT type="hidden" name="versionno" id="versionno" value="<%=versionno%>">
<%
//out.println("res" +result);
 if(result.size()>0){
	finalResult=0;
}else
	finalResult=1;
 %>
</FORM>
	<SCRIPT>LoadClose('<%=finalResult%>');</SCRIPT>
</BODY>
</HTML>

