<!DOCTYPE html>

<%@ page import ="java.sql.*, java.util.*, webbeans.eCommon.*, eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	
%>

<%
  
Connection con =null;
Statement stmt = null;
PreparedStatement pstmt = null;
ResultSet rs=null;	
String	facilityId 					= (String) session.getValue( "facility_id" ) ;


try{
 
 con = ConnectionManager.getConnection(request);
	String entity="";
	String doctype="";
   String longdesc="";
   String shortdesc="";
   String flag="N";
   String sdocno="";	
   String ndocno="";
   String ent_sel=""; 
   String fac_sel ="";
   String check="";
   String pflag="N";
   String mode="O";
   String batchsel="";
   String onsel="";
   String icheck="";
   String operation="";
   
	
	
	operation		= request.getParameter("operation")==null?"":request.getParameter("operation");
   	  	
	
	
	
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eSM/js/DocumentType.js' language='javascript'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	


</head>
<body  OnMouseDown="CodeArrest()" onKeyDown='lockKey();' OnLoad='clickVal(document.forms[0].eff_status1);' >
<form name="documenttype_form" id="documenttype_form" method="post" target="messageFrame">

<%doctype=request.getParameter("DOC_TYPE_CODE")==null?"":request.getParameter("DOC_TYPE_CODE");


if(!doctype.equals("")){

String sql = "Select a.ENTITY_OR_FACILITY_BASED basedon, a.DOC_TYPE_CODE doctype, a.LONG_DESC longdescription, a.SHORT_DESC shortdescription, B.DOC_NUM_GEN_FLAG eff_status1, B.START_DOC_NO startdocnum, B.NEXT_DOC_NO nextdocno, B.DOC_PRINT_FLAG autoprint, B.DOC_ENTRY_MODE entitymode from SY_DOC_TYPE_MASTER A,SY_ACC_ENTITY_DOC_TYPE B WHERE A.DOC_TYPE_CODE =? AND A.DOC_TYPE_CODE=B.DOC_TYPE_CODE"; 

//		stmt = con.createStatement();
	//	rs = stmt.executeQuery(sql);
	
		pstmt   = con.prepareStatement(sql);
		pstmt.setString	(	1,	doctype		);
		rs		 = pstmt.executeQuery();
		rs.next();

		entity=rs.getString("basedon"); 
		doctype=rs.getString("doctype");
		
		longdesc=rs.getString("longdescription");
		shortdesc=rs.getString("shortdescription");
		flag =rs.getString("eff_status1")==null?"N":rs.getString("eff_status1");
		sdocno = rs.getString("startdocnum")==null?"":rs.getString("startdocnum");
		ndocno= rs.getString("nextdocno")==null?"":rs.getString("nextdocno");
		pflag=rs.getString("autoprint")==null?"N":rs.getString("autoprint");
		mode=rs.getString("entitymode")==null?"":rs.getString("entitymode");
}
		%>
		<%
		if(entity.equals("E"))
			ent_sel = "selected";
		else if(entity.equals("F"))
			fac_sel = "selected";
  %>
  <%
		if(flag.equals("Y"))
  check = "checked";
  else if(flag.equals("N"))
  check = "";
  else 
	 check = "";
  %>
  <%
		if(mode.equals("B"))
			batchsel = "selected";
		else if(mode.equals("O"))
			onsel = "selected";
  %>
  <%
		if(pflag.equals("Y"))
  icheck = "checked";
  else if(pflag.equals("N"))
  icheck = "";
  %>

<table border="0" cellpadding="0" cellspacing="0" width="95%" align='center'>
   
	 <tr><td colspan='4' class='label'>&nbsp;</td></tr>
<tr>
		<td class='label'><fmt:message key="Common.Basedon.label" bundle="${common_labels}"/></td>
		<td class='fields' width=''><select name='basedon' id='basedon' onChange='checkdeco(this);' <%if(operation.equals("modify")){%> disabled<%}%>>
			<option value="" >-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
			
			
			<option value="E" <%=ent_sel%> ><fmt:message key="eSM.AcctEntity.label" bundle="${common_labels}"/></option>
			<option value="F" <%=fac_sel%>  ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></option>
		</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
	  </td>
		<td class='label' colspan=2></td>
		<tr><td class="label" colspan=4></td></tr>
		<tr><td class="label" colspan=4></td></tr>
</tr>
<tr>
		<td class="label" ><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td class='QUERYDATA'><input type='text' name='doctype' id='doctype' size='6' maxlength='6' value='<%=doctype%>' OnBlur="ChangeUpperCase(this);CheckFac(this);SpeCharCheck(this)" onKeyPress="return CheckForSpecCharsone(event)" <%if(operation.equals("modify")){%> disabled<%}%>><img src='../../eCommon/images/mandatory.gif' align='center'></img>
	  </td></td>
		<td class="label" colspan=2></td>
	</tr>
	<tr><td class="label" colspan=4></td></tr>
	<tr><td class="label" colspan=4></td></tr>
<tr>
		<td class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class='QUERYDATA'><input type='text' name='longdescription' id='longdescription' size='30' maxlength='100' value='<%=longdesc%>' ><img src='../../eCommon/images/mandatory.gif' align='center'></img>
	  </td></td>
		<td class="label" colspan=2></td>			      
	</tr>
	<tr><td class="label" colspan=4></td></tr>
	<tr><td class="label" colspan=4></td></tr>
	<tr>
		<td class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td class='QUERYDATA'><input type='text' name='shortdescription' id='shortdescription' size='15' maxlength='40' value='<%=shortdesc%>' ><img src='../../eCommon/images/mandatory.gif' align='center'></img>
	  </td></td>
		<td class="label" colspan=2></td>
		</tr>
		<tr><td class="label" colspan=4></td></tr>

	<tr>
	<td class='label'><fmt:message key="eSM.SysGenDocNo.label" bundle="${common_labels}"/></td>
    <td class='fields'><input type='checkbox' name='eff_status1' id='eff_status1' value='<%=flag%>'  onClick='clickVal(this)' <%=check%>></td>
	<td class="label" colspan=2></td>
	  
      </tr>
	 <tr><td class="label" colspan=4></td></tr>
	  
		<tr>
		<td class="label"><fmt:message key="eSM.StartDocNo.label" bundle="${common_labels}"/></td>
		<td class='QUERYDATA'><input type='text' name='startdocnum' id='startdocnum' size='8' maxlength='8' value='<%=sdocno==null?"":sdocno%>' onKeyPress='return(ChkNumberInput(this,event,2));SpeIntCheck(this)' onblur='chkStDocNum(this);SpeIntCheck(this);' <%if(flag.equals("N")){%> disabled<%}%> <%if(operation.equals("modify")){%> disabled<%}%>> <img id = "giffrom" src='../../eCommon/images/mandatory.gif' align='center'> </td>
		<td class="label" ><fmt:message key="eSM.NextDocNo.label" bundle="${common_labels}"/></td>
		<td class='QUERYDATA'><input type='text' name='nextdoctype' id='nextdoctype' size='8' maxlength='8' value='<%=ndocno==null?"":ndocno%>' onblur='chkNxtNo(this,startdocnum);SpeIntCheck(this);' ' onKeyPress='return(ChkNumberInput(this,event,2));'  <%if(flag.equals("N")){%> disabled<%}%> ><img id = "gifto" src='../../eCommon/images/mandatory.gif'align='center'></td>	</tr>
		<tr><td class="label" colspan=4></td></tr>
<td class='label'><fmt:message key="eSM.AutoPrint.label" bundle="${common_labels}" /></td>
<td class='fields'>
<input type='checkbox' name='autoprint' id='autoprint' value='<%=pflag%>' onClick='clickVal(this)'<%=icheck%> ></td>
<td class="label" colspan=2></td>
</tr>
<tr><td class="label" colspan=4></td></tr>
<tr>
<td class="label" ><fmt:message key="eSM.EntryMode.label" bundle="${sm_labels}" /></td>
		<td class='fields'>&nbsp;<select name='entitymode' id='entitymode'>
			<option value="" >----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
			
			<option value="B" <%=batchsel%> ><fmt:message key="Common.Batch.label" bundle="${common_labels}"/></option>
			<option value="O" <%=onsel%> ><fmt:message key="eSM.Online.label" bundle="${sm_labels}"/></option>
		</select>
		</td>
		<td class="label" colspan=2></td>
 		</tr>
		<tr><td class="label" colspan=4></td></tr>
		</table>

		<tr><td class="label" colspan=4></td></tr>
		
	


<input type="hidden" name="sStyle" id="sStyle" value="<%=sStyle%>">
<input type="hidden" name="DOC_TYPE_CODE" id="DOC_TYPE_CODE" value="<%=doctype%>">
<input type='hidden' name='operation' id='operation' value='<%=operation%>'>

 

		
<input type='hidden' name='insert_vals' id='insert_vals' value="" >
		<input type='hidden' name='update_vals' id='update_vals' value="" >
		<input type='hidden' name='delete_vals' id='delete_vals' value="" >
		<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>" >
</form>
<%
}

catch(Exception e)
	{
	out.println(e.getMessage());
	e.printStackTrace();
	}


	finally
	{
	try
	{
	if (stmt != null) stmt.close();
	if (pstmt != null) pstmt.close();
	if (rs != null)   rs.close();
	ConnectionManager.returnConnection(con,request);
	}

	catch(Exception exp)
	{
		out.println(exp.toString());
	}
	}		

%>


</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>



