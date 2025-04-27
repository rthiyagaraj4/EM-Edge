<!DOCTYPE html>
<%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eCommon.Common.*,ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	//Added  for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNConsLimits.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	

</HEAD>


<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">

<%
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "TPNConsLimitsBean" ;
	String bean_name = "ePH.TPNConsLimitsBean";
	String age_code			= request.getParameter( "age_code" ) ;
	String regimen_code	= request.getParameter( "regimen_code" ) ;
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;


	/* Initialize Function specific start */
	TPNConsLimitsBean bean = (TPNConsLimitsBean)getBeanObject( bean_id,bean_name,request) ;
	bean.clear();
	bean.setMode( mode ) ;
	
	ArrayList consResults=bean.getResult(regimen_code,age_code);//,infusion_line

	
	if (consResults.size()==1)
	{
		out.println(consResults.get(0));
		return;
	}
	String olddesc="";
	String classname="";
	String gName="";
	String genName="";
	String genCode="";
	String qUnit="";
	String qMax="";
	String qMin="";
	String qStd="";
	String fromdb="";
	String ord_unit="";
	String ord_unit_value="";
	String ceil="";
	String usgInd="";
	String remarks="";
	String prep_unit="";
	String ordering_limit_absolute="";
	String ordering_limit_weight="";
	String ordering_limit_volume="";


String qunit1="";
	int reccount=1;
	if  (consResults.size()==0)
	{
	out.println("NoTPN Params defined!!!"+age_code);
	return;
	}

%>

	<FORM name="FormTPNCons" id="FormTPNCons"  TARGET="messageFrame" >
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" style="border:1px solid">
	
	

<%			
try
{

				
		
				for (int i=0;i<consResults.size();i+=13)
				{
				

						gName=(String)consResults.get(i);
						genCode=(String)consResults.get(i+1);
						genName=(String)consResults.get(i+2);
				
						qUnit=(String)consResults.get(i+3);
				
						qMax=(String)consResults.get(i+4);
						qMin=(String)consResults.get(i+5);
						qStd=(String)consResults.get(i+6);
						ord_unit=(String)consResults.get(i+7);
						qunit1=(String)consResults.get(i+8);
						ceil  =(String)consResults.get(i+9);
						usgInd  =(String)consResults.get(i+10);
						remarks  =(String)consResults.get(i+11);
						prep_unit  =(String)consResults.get(i+12);
						if(prep_unit.equals("") || prep_unit==null)
					    {
							if(ord_unit.equals("A"))
								{
										ordering_limit_absolute="selected";
										ordering_limit_weight="";
										ordering_limit_volume="";
								}	
					         else if(ord_unit.equals("W"))
								{
										ordering_limit_absolute="";
										ordering_limit_weight="selected";
										ordering_limit_volume="";
								}
					         else if(ord_unit.equals("P"))
								{
										ordering_limit_absolute="";
										ordering_limit_weight="";
										ordering_limit_volume="selected";
								}
						}
						else
					    {
					          if(prep_unit.equals("A"))
								{
										ordering_limit_absolute="selected";
										ordering_limit_weight="";
										ordering_limit_volume="";
								}	
					         else if(prep_unit.equals("W"))
								{
										ordering_limit_absolute="";
										ordering_limit_weight="selected";
										ordering_limit_volume="";
								}
					        else if(prep_unit.equals("P"))
								{
										ordering_limit_absolute="";
										ordering_limit_weight="";
										ordering_limit_volume="selected";
								}
						}
						
						fromdb="Y";
						String fontcolor="RED";
						if ((qStd==null )||qStd.equals("0")||qStd.equals(""))
						{
							fromdb="N";
							fontcolor="BLACK";
						}
                         String style="";
						if(remarks=="")
							style="cursor:pointer;color:blue";
						else
							style="cursor:pointer;color:red";

					%><TR><%
					//This row is for the group header if necessary
					if ( (!olddesc.equals(gName))||(olddesc.equals("")))
					{
						%>
						<TH width="15%"><%=gName%></TH>
						<TH width="15%"><fmt:message key="Common.Unit.label" bundle="${common_labels}"/></TH>
						<TH width="13%"><fmt:message key="Common.Limit.label" bundle="${common_labels}"/></TH>
						 <TH width="5%"><fmt:message key="Common.Minimum.label" bundle="${common_labels}"/></TH>
						<TH width="5%"><fmt:message key="Common.maximum.label" bundle="${common_labels}"/></TH>
						<TH width="5%"><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></TH>
						<TH width="5%"><fmt:message key="ePH.Ceiling.label" bundle="${ph_labels}"/></TH>
						<TH width="10%"><fmt:message key="ePH.UsageIndicator.label" bundle="${ph_labels}"/></TH>
						<TH width="10%">&nbsp;</TH>
							<%
						
					}
					%>
					<tr>
		
					<%
					
 						if (reccount%2==0)
						{
							classname="QRYEVENNOBORDER";
						}
						else
						{
							classname="QRYODDNOBORDER";
						}
						 //This row is for the actual data
					 %>
 					<TR>
					 <!--Row Level Hidden Values start here -->
					<input type="hidden" name='<%="GCODE"+reccount%>' id='<%="GCODE"+reccount%>'  ID=name='<%="GCODE"+reccount%>'  value="<%=genCode%>">	
					<input type="hidden" name='<%="FROMDB"+reccount%>' id='<%="FROMDB"+reccount%>'  id='<%="FROMDB"+reccount%>' value='<%=fromdb%>'	 >
					<input type="hidden" name='<%="QTYUNIT"+reccount%>' id='<%="QTYUNIT"+reccount%>'  id='<%="QTYUNIT"+reccount%>' 
					 value='<%=qUnit%>'	>
					<TD class="<%=classname%>"   style="color:<%=fontcolor%>;font-size:8pt" >
					<%=genName%>
					</TD>
					<TD class="<%=classname%>"   style="color:<%=fontcolor%>;font-size:8pt" >
					<%=qunit1%>
					</TD>
						<!-- <TD class="<%=classname%>"   style="color:<%=fontcolor%>;font-size:8pt" >
						 <%=ord_unit_value%>
						</TD> -->
				
						<td class="<%=classname%>" width="17%">
							<select name="ordering_limit<%=reccount%>" id="ordering_limit<%=reccount%>">
			
							<option value="A" <%=ordering_limit_absolute%>><fmt:message key="ePH.ByAbsolute.label" bundle="${ph_labels}"/>       </option>
							<option value="W" <%=ordering_limit_weight%>><fmt:message key="ePH.ByWeight.label" bundle="${ph_labels}"/>           </option> 
<%                   if(!genCode.equals("FLUID") && !genCode.equals("CHO") && !genCode.equals("LIPID")                                && !genCode.equals("PROTEIN")){
								
%>
							<option value="P" <%=ordering_limit_volume%>><fmt:message key="ePH.PerLitre.label" bundle="${ph_labels}"/>       </option>
<% }%>
							</select>
									
						</td>
					<TD class="<%=classname%>"   style="color:<%=fontcolor%>;font-size:8pt" >
						<input type=text name="MIN<%=reccount%>" id="MIN<%=reccount%>" id="MIN<%=reccount%>" value="<%=qMin%>" size=5 maxlength=9 onKeyPress="return allowValidNumber(this,event,4,2);" onBlur='checkIsNotZero(this,"Minimum");'> 
					</TD>
					<TD class="<%=classname%>"   style="color:<%=fontcolor%>;font-size:8pt" >
						<input type=text name="MAX<%=reccount%>" id="MAX<%=reccount%>" id="MAX<%=reccount%>" value="<%=qMax%>" size=5 maxlength=9 onKeyPress="return allowValidNumber(this,event,4,2);" onBlur='checkIsNotZero(this,"Maximum");'>  
					</TD>
					<TD class="<%=classname%>"   style="color:<%=fontcolor%>;font-size:8pt" >
						<input type=text name="STD<%=reccount%>" id="STD<%=reccount%>" id="STD<%=reccount%>" value="<%=qStd%>" size=5 maxlength=9 onKeyPress="return allowValidNumber(this,event,4,2);" onBlur='checkIsNotZero(this,"Standard");'>  
					</TD>
					<TD class="<%=classname%>"   style="color:<%=fontcolor%>;font-size:8pt" >
						<input type=text name="CEIL<%=reccount%>" id="CEIL<%=reccount%>" id="CEIL<%=reccount%>" value="<%=ceil%>" size=5 maxlength=9 onKeyPress="return allowValidNumber(this,event,4,2);" onBlur='checkIsNotZero(this,"Ceiling");chkRange(FormTPNCons)'>  
					</TD>
					<%if(genCode.equals("CHO") || genCode.equals("FLUID")){%>
					<TD>&nbsp;
			<select name="Usage_Ind<%=reccount%>" id="Usage_Ind<%=reccount%>">
			 <% if(usgInd.equals("O")){%>
			        <option value="B"><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
			     	<option value="O" selected><fmt:message key="ePH.Tobeordered.label" bundle="${ph_labels}"/></option>
					<%} else {%>
					<option value="B"><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
					<option value="O" ><fmt:message key="ePH.Tobeordered.label" bundle="${ph_labels}"/></option>
					<%}%>
			
			</select>
			</TD>
			<%}else {%>
					<TD>&nbsp;
			<select name="Usage_Ind<%=reccount%>" id="Usage_Ind<%=reccount%>"><option value="B"><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
			 <% if(usgInd.equals("O")){%>
   					<option value="X"><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
					<option value="O" selected><fmt:message key="ePH.Tobeordered.label" bundle="${ph_labels}"/></option>
					<option value="N"><fmt:message key="ePH.Nottobeordered.label" bundle="${ph_labels}"/></option>
					<%} else if(usgInd.equals("N")){%>
					<option value="X" ><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
					<option value="O" ><fmt:message key="ePH.Tobeordered.label" bundle="${ph_labels}"/></option>
					<option value="N" selected><fmt:message key="ePH.Nottobeordered.label" bundle="${ph_labels}"/></option>
					<%} else if(usgInd.equals("X")){%>
					<option value="X" selected><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
					<option value="O" ><fmt:message key="ePH.Tobeordered.label" bundle="${ph_labels}"/></option>
					<option value="N"><fmt:message key="ePH.Nottobeordered.label" bundle="${ph_labels}"/></option>
                    <%} else {%>
					<option value="X"><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
					<option value="O"><fmt:message key="ePH.Tobeordered.label" bundle="${ph_labels}"/></option>
					<option value="N"><fmt:message key="ePH.Nottobeordered.label" bundle="${ph_labels}"/></option>
				 <% } %> 
			</select>
			</TD>
     <%}%>
			<Td   class="label" align="left" style="<%=style%>"  id="remarks<%=reccount%>" name="remarks<%=reccount%>" onClick="viewComments('<%=reccount%>','<%=genName%>')"> &nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></Td>
			<input type='hidden' name='hidden_remarks<%=reccount%>' id='hidden_remarks<%=reccount%>' value="<%=remarks%>">
				</TR>
					<%
					olddesc=gName;
					reccount++;

			}

putObjectInBean(bean_id,bean,request);
}
catch (Exception e)
{
	out.println(e);
}
	%>


<!--form level hidden values start here -->

<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
<INPUT TYPE="hidden" name="totalrows" id="totalrows"  value="<%=consResults.size()/13 %>">
<INPUT TYPE="hidden" name="AGEGROUP" id="AGEGROUP" value="<%=age_code%>">
<INPUT TYPE="hidden" name="regimen_code" id="regimen_code" value="<%=regimen_code%>">
<INPUT TYPE="hidden" name="infusion_line" id="infusion_line" value="C">
<INPUT TYPE="hidden" name="Max_Age1" id="Max_Age1" value="">
<INPUT TYPE="hidden" name="Min_Age1" id="Min_Age1" value="">
<INPUT TYPE="hidden" name="age_unit_code1" id="age_unit_code1" value="">
<INPUT TYPE="hidden" name="gender_val1" id="gender_val1" value="">
<INPUT TYPE="hidden" name="remarks1" id="remarks1" value="<%=remarks%>">

<script>document.FormTPNCons.MIN1.focus();</script>

</table>
</form>
</BODY>
</HTML>

