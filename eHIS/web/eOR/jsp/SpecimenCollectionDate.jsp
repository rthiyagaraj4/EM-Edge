<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
	<!--<title>Collection Date And Time</title>-->
<%	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
 	<script language="JavaScript" src="../../eOR/js/SpecimenOrder.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name="specimenDate" id="specimenDate">
<%
	String order_id				= "";
	String bean_id				= "";
	String bean_name			= "";
	String display_specimen_date_time="";

	int boolVal					= 0;

	String specimen_date_time 	= request.getParameter("specimen_date_time");
	String called_from 	= request.getParameter("called_from");
	//if(specimen_date_time==null)
		//specimen_date_time 		= "";
	String curr_sys_date 		= "";
	//request.getParameter("curr_sys_date");
	if(curr_sys_date==null)
		curr_sys_date 			= "";
	if(called_from==null)
		called_from 			= "";

	if(called_from.equalsIgnoreCase("New_List"))
	{
		display_specimen_date_time="readOnly";
	}
	else
	{
		display_specimen_date_time="";
	}
	if(specimen_date_time.equals(""))	specimen_date_time = curr_sys_date;

	String from_function		= request.getParameter("from_function");
	if (from_function==null) from_function = "";

	//String lb_module = "";

	bean_id				= request.getParameter("bean_id");
	if (bean_id==null)	bean_id = "";

	bean_name			= request.getParameter("bean_name");
	if (bean_name==null) bean_name = "";

	String order_type_code		= request.getParameter("order_type_code")==null?"":request.getParameter("order_type_code");
	String pat_name		= request.getParameter("pat_name")==null?"":request.getParameter("pat_name");	

	SpecimenOrder bean = (SpecimenOrder)getBeanObject( bean_id, bean_name, request  ) ;
	bean.setLanguageId(localeName);

	ArrayList sysdate = (ArrayList)bean.getSysDateTime();
	if (sysdate.size() == 3)
		curr_sys_date =  (String)sysdate.get(2);//bean.getSysDate();

	if (curr_sys_date.equals("null")|| curr_sys_date=="")curr_sys_date="";

	if ( !localeName.equals("en") )
	{ 
		curr_sys_date=com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMYHM","en",localeName);
	}

	int size = 0;
	String interval_test_yn = "N";
	if(specimen_date_time.equals(""))	specimen_date_time = curr_sys_date;	

	if (from_function.equals("SearchResult")) 
	{
		order_id				= request.getParameter("order_id");
		if(order_id==null)	order_id = "";
		String labchk=request.getParameter("labvalues");
		if(labchk==null)labchk="";
	
		//lb_module = bean.getLbInstall("RL");

  		//if(lb_module.equals("Y")) {changed on 7/16/2007 for lb_module
		if(labchk.equalsIgnoreCase("IBARL"))
		{
			interval_test_yn = bean.getIntervalTestYn(order_id);
			if (interval_test_yn == null) interval_test_yn = "N";

 			if (interval_test_yn.equalsIgnoreCase("Y")) 
			{
				ArrayList arrayVals = new ArrayList();
				arrayVals = bean.getIntervalSpecimenDetails(order_id);
				size = arrayVals.size();
 
				if (size == 0) 
				{
					size = -1;boolVal=0;
				} 
				else 
				{
                    boolVal = 1;
					String slClassValue = "";
				%>
				<Script>
					//specimenDate.size.value = <%=arrayVals.size()%>
					parent.dialogHeight = 17
				</Script>
				<table cellpadding=3 cellspacing=0 border='1' width='88%' class="grid">
                <td class='columnheader'><fmt:message key="Common.Test.label" bundle="${common_labels}"/></td><%--<Th>Specimen No</th>--%><td class='columnheader'><fmt:message key="eOR.CollectionDateTime.label" bundle="${or_labels}"/></td>
				<%
				for (int i=0; i < arrayVals.size();i++) 
				{
					slClassValue="gridData";
				%>
    				<TR>
						<TD class='<%=slClassValue%>'><%=(((String)(((ArrayList)arrayVals.get(i)).get(0)))==null)?"":((String)(((ArrayList)arrayVals.get(i)).get(0)))%></TD>
						<%--<TD class='<%=slClassValue%>'><%=(((String)(((ArrayList)arrayVals.get(i)).get(1)))==null)?"":((String)(((ArrayList)arrayVals.get(i)).get(1)))%></TD>--%>
						<TD class='<%=slClassValue%>'><input type="text" name="specimen_date_time<%=i%>" id="specimen_date_time<%=i%>" value="<%=(((String)(((ArrayList)arrayVals.get(i)).get(2)))==null)?curr_sys_date:((String)(((ArrayList)arrayVals.get(i)).get(2)))%>" size="16" maxLength="16"  onKeyPress="enterCheck();" <%=display_specimen_date_time%>><img src="../../eCommon/images/mandatory.gif"/></TD>  <%--onBlur="validateSpecimenDate(this);"--%>
					</TR>
					<Input type="hidden" name="seq_no<%=i%>" id="seq_no<%=i%>" value="<%=(((String)(((ArrayList)arrayVals.get(i)).get(3)))==null)?"":((String)(((ArrayList)arrayVals.get(i)).get(3)))%>"></Input>					
				<%
				}
			}
		}
		else
		{
			String neonate_spec_yn = bean.getNeonateSpecimenYN(order_id,order_type_code);
			boolVal = 0;

			if(neonate_spec_yn.equals("Y"))
			{
				boolVal = 1;
				String[] neonate_mother_dtl= bean.getNeonateMotherPatient(order_id,order_type_code);
				size = 2;
			%>
			<table cellpadding=3 cellspacing=0 border='1' width='88%'>
			
			<td class='columnheader' width='50%'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td><td class='columnheader' width='50%'><fmt:message key="eOR.CollectionDateTime.label" bundle="${or_labels}"/></td>
			<tr>
				<td class='gridData'><%=pat_name%></td>
				<!--Modified by Uma on 1/21/2010 for IN018402-->
				<td class='gridData'><input type="text" name="specimen_date_time0" id="specimen_date_time0" value="<%=curr_sys_date%>" size="16" maxLength="16"  onKeyPress="enterCheck();" <%=display_specimen_date_time%>><img src="../../eCommon/images/mandatory.gif" align="center"/></td> 
				<!-- Ends Here -->
			</tr> 
			<tr>
				<td class='gridData'><%=neonate_mother_dtl[1]%></td>
				
				<td class='gridData'><input type="text" name="specimen_date_time1" id="specimen_date_time1" value="<%=curr_sys_date%>" size="16" maxLength="16"  onKeyPress="enterCheck();" <%=display_specimen_date_time%>><img src="../../eCommon/images/mandatory.gif" align=center/></td>  
			</tr> 
			<Input type="hidden" name="seq_no0" id="seq_no0" value=""></Input>
			<Input type="hidden" name="seq_no1" id="seq_no1" value=""></Input>
			</table> 
			<%
			}			
		}
	  } 
	  else {boolVal=0;
    }
  } 
else 
{
	boolVal=0;
}

if (boolVal == 0) 
{
%>
	<table cellpadding=2 cellspacing=0 border='0' width='106%'>			
	<tr><td class=label width='30%'><fmt:message key="eOR.CollectionDateAndTime.label" bundle="${or_labels}"/></td><td class='fields' width='50%'><input type="text" name="specimen_date_time0" id="specimen_date_time0" value="<%=specimen_date_time%>" size="20" maxLength="16" onKeyPress="enterCheck();" <%=display_specimen_date_time%>><img src="../../eCommon/images/mandatory.gif" align=center/></td>			
<%
}	
%>
	<input type="hidden" name="curr_sys_date0" id="curr_sys_date0" value="<%=curr_sys_date%>">
	<Input type='hidden' name='order_date_time0' id='order_date_time0' value='<%=request.getParameter("order_date_time")%>'>
	<Input type='hidden' name='size' id='size' value="<%=size%>"></Input>
	<Input type="hidden" name="interval_test_yn" id="interval_test_yn" value="<%=interval_test_yn%>"></Input>
	<Input type="hidden" name="localeName" id="localeName" value="<%=localeName%>"></Input>
	<Input type="hidden" name="called_from" id="called_from" value="<%=called_from%>"></Input>
</table>
<Script>
/*Added by Uma on 1/5/2011 for IN025732*/
if (parent.SpecimenCollectionDateButton.SpecimenCollectionBtn)
{
	parent.SpecimenCollectionDateButton.document.getElementById("collectBtn").disabled = false;
}
/*Ends Here*/
</Script>
</FORM>
<!--<table cellpadding=0 cellspacing=0 border='0' width='98%'>
	<tr><td align=right colspan=3><input type=button class=button name="ok" id="ok" Value="Ok" onclick="closeDate();"></td></tr>
	</Table>-->
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

