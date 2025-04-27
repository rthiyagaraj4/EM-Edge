<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%	
	request.setCharacterEncoding("UTF-8");
	Connection con	= null;
	Statement stmt	= null;
	ResultSet rs	= null;
	String ID = "";
	String Desc = "";
	String called_from	= request.getParameter("called_from");	
	String function_id	= request.getParameter("function_id");	
	if(called_from.equals("1"))
	{
		ID = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomcubicleno.label","common_labels");
		Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RoomCubicle.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	}
	else if(called_from.equals("3"))
	{
		ID = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
		Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	}
	else if(called_from.equals("5"))
	{
		ID = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels");
		Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels");
	}
	else if(called_from.equals("6"))
	{
		ID = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
		Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	}
	
	String facility_id	= (String)session.getValue("facility_id");
	try
	{
		con=ConnectionManager.getConnection(request);
		String operating_facility_id="";
		operating_facility_id=(String) session.getValue("facility_id");
%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	
	<script src='../../eIP/js/NursUnitRoom.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

// Onchange of Dept .. clear Result Page...
function clearResultPage()
{
	parent.frames[1].location.href="../../eCommon/html/blank.html";
}


function CheckForSpecChars_local(event)
{
	var strCheck = document.forms[0].strCheck.value;
    //var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function enable_txt(obj)
{
	document.forms[0].search_txt.value = "";
 if(obj.value=="")
 {
	document.forms[0].search_txt.value = "";
	document.forms[0].search_txt.disabled = true;
 }
 else
 {
	document.forms[0].search_txt.disabled = false;
		if(obj.value=="ID")
			document.forms[0].strCheck.value = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*";
		else
			if(obj.value=="DESC")
				document.forms[0].strCheck.value = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ";
 }
}

function PopulateResult()
{
	temp='';
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
	var nursing_unit=document.forms[0].nursing_unit.value;
	var dept_code = document.forms[0].dept_code.value;
	var nursing_unit_type = document.forms[0].nursing_unit_type.value;
	var age_group = document.forms[0].age_group.value;
	var service = document.forms[0].service.value;
	var statusval = document.forms[0].statusval.value;
	
	//alert(nursing_unit_type);
	if(document.forms[0].search_by!=null)
	{
	  var search_by = document.forms[0].search_by.value;
	  var search_txt = document.forms[0].search_txt.value;
    }
	var called_from='<%=called_from%>';
	if(nursing_unit!="")
	{
		
		if(called_from==1)
		{
			
			//parent.frames[1].location.href='../../eIP/jsp/AddModifyNursUnitRoom.jsp?nursing_unit_code='+nursing_unit+'&search_by='+search_by+'&search_txt='+search_txt+'&fromSelect=fromSelect;
			//3-06-08
			parent.frames[1].location.href='../../eIP/jsp/AddModifyNursUnitRoom.jsp?function_id='+'<%=function_id%>'+'&nursing_unit_code='+nursing_unit+'&search_by='+search_by+'&search_txt='+search_txt+'&fromSelect=fromSelect&nursing_unit_type='+nursing_unit_type+'&age_group='+age_group+'&service='+service+'&dept_code='+dept_code;
			parent.frames[2].location.href='../../eIP/jsp/NursUnitRoomDynamicValues.jsp';
		}
		else if(called_from==3)
		{
		parent.frames[1].location.href='../../eIP/jsp/AddModifyNursUnitSpeciality.jsp?function_id='+'<%=function_id%>'+'&nursing_unit_code='+nursing_unit+'&search_by='+search_by+'&search_txt='+search_txt+'&fromSelect=fromSelect';
		parent.frames[2].location.href='../../eIP/jsp/NursUnitSpecialityDynamicValues.jsp';
		}
		else if(called_from==4)
		{
		document.forms[0].statusval.value='Y';
		parent.frames[1].location.href='../../eIP/jsp/addModifyNursingUnitBkgLt.jsp?nursing_unit_code='+nursing_unit+'&search_by='+search_by+'&search_txt='+search_txt+'&fromSelect=fromSelect';
		parent.frames[2].location.href='../../eIP/jsp/NursingUnitBkgLtDynamicValues.jsp';
		}
		else if(called_from==5)
		{
		parent.frames[1].location.href='../../eIP/jsp/AddModifyNursUnitService.jsp?function_id='+'<%=function_id%>'+'&nursing_unit_code='+nursing_unit+'&search_by='+search_by+'&search_txt='+search_txt+'&dept_code='+dept_code+'&fromSelect=fromSelect';
		parent.frames[2].location.href='../../eIP/jsp/NursUnitServiceDynamicValues.jsp';
		}
		else if(called_from==6)//call is made from day care unit for nursing unit
		{
		document.forms[0].statusval.value='Y';
		parent.frames[1].location.href='../../eIP/jsp/addModifyDayCareUnitLink.jsp?nursing_unit_code='+nursing_unit+'&search_by='+search_by+'&search_txt='+search_txt+'&dept_code='+dept_code+'&fromSelect=fromSelect';
		parent.frames[2].location.href='../../eIP/jsp/DayCareUnitPopulate.jsp';
		}
	}
	else
	{
		var err=getMessage("CAN_NOT_BE_BLANK","common");
		err= err.replace('$',getLabel('Common.nursingUnit.label','Common'));
		parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err
		
	}
}

// Added by Sridhar on 6 APR 2004
// This is fired on onClick of the button.... 
// Function will check for empty values & call CommonLookup only when the value in the textbox is empty..
function checkTxtVal(target_id,target)
{
	if(document.forms[0].nursing_unit_desc.value == "")
		Lookup(target_id,target);
}


// Added by Sridhar on 5 APR 2004
// Function will check for empty values before calling up the common lookup func..
function beforeGetNursingUnit(target_id,target)
{
	var called_from='<%=called_from%>';
	
	if(document.forms[0].nurs_desc_hid.value != document.forms[0].nursing_unit_desc.value)
	{
		if(document.forms[0].nursing_unit_desc.value != "")
			 Lookup(target_id,target);
		else
		if(document.forms[0].nursing_unit_desc.value == "")
			 {
			    document.forms[0].nurs_desc_hid.value = "";
				document.forms[0].nursing_unit.value = "";
				parent.frames[0].location.href="../../eIP/jsp/NursingUnitSearch.jsp?called_from="+called_from;
				parent.frames[1].location.href="../../eCommon/html/blank.html"
			 }
	}
}

/* Modified to CommonLookup on 06/02/04 by Sridhar */
async function Lookup(target_id,target)
{
	
	var facility_id = "<%=operating_facility_id%>";
	var title="";
	var called_from='<%=called_from%>';//if called_from ==6 its from DayCare Unit for Nursing Unit

	var argumentArray=new Array(8);
	
	if(target_id.name == "nursing_unit")
	{
		
		title=getLabel('Common.nursingUnit.label','common');
		
		argumentArray[0]="select NURSING_UNIT_CODE code, SHORT_DESC description from IP_NURSING_UNIT where EFF_STATUS ='E' and locn_type = 'N' and facility_id ='"+facility_id+"' and upper(NURSING_UNIT_CODE) like upper(nvl(?,NURSING_UNIT_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC)) ";
		if(called_from==6)//if called from Day Care unit for Nursing Unit
		{
			argumentArray[0]=argumentArray[0]+"AND APPL_PATIENT_CLASS LIKE 'DC' ";			
		}
		if(called_from==4)//if called from Day Care unit for Nursing Unit
		{
			argumentArray[0]=argumentArray[0]+"AND APPL_PATIENT_CLASS LIKE 'IP' ";			
		}

		argumentArray[1]=new Array();
		argumentArray[2]=new Array();
		argumentArray[3]=new Array();
		argumentArray[4]="1,2";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
}
			
	var retVal=await CommonLookup(title,argumentArray);
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].nursing_unit.value	=	arr[0];		
		document.forms[0].nursing_unit_desc.value	=	arr[1];
		document.forms[0].nurs_desc_hid.value = document.forms[0].nursing_unit_desc.value
		PopulateValues(target_id);
	}
	else
	{
		document.forms[0].nursing_unit.value	=	"";		
		document.forms[0].nursing_unit_desc.value	=	"";
	}


}

function PopulateValues(obj)
{
	var called_from='<%=called_from%>';
	if(obj.value!="")
	{
		var nursing_unit=obj.value;
		var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='nursingunit' id='nursingunit' method='post' action='../../eIP/jsp/PopulateNursingUnitValues.jsp'><input type='hidden' name='nursing_unit' id='nursing_unit' value='"+nursing_unit+"'><input type='hidden' name='called_from' id='called_from' value='"+called_from+"'></form></body></html>";	
	
		parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.frames[2].document.forms[0].submit();
		
		if(document.forms[0].search_txt!=null)
		{
			document.forms[0].search_txt.value = "";
			document.forms[0].search_by.value  = "";
			document.forms[0].search_txt.disabled = true;
		}
	}
}

</script>

</head>

<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name='Search_form' id='Search_form'>
  <table border='0' cellpadding='0' cellspacing='0' width='90%' align='center'>
	<tr>
		<td class='label' width="20%" >&nbsp;</td>
		<td class='label' width="70%" >&nbsp;</td>
		<td class='label' width="2%" >&nbsp;</td>
		<td class='label' width="10%" >&nbsp;</td>
	</tr>
	 <tr>
	  	<td  class='label'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
		 <td align='left' class='querydata' id=td5>
		 <%
			//if(count>15) commented this condition and made true always to get through search and left the else part as it is for future modification.
			if(true)
			{	 
		 %>
				<!-- Modified to Common Lookup code on 06/02/04 by Sridhar -->
				<input type=text name='nursing_unit_desc' id='nursing_unit_desc' size=15 maxlength=15 onblur="beforeGetNursingUnit(document.forms[0].nursing_unit,this);"><input type=button class=button name='search_nur_unit' id='search_nur_unit' value='?' onclick="checkTxtVal(document.forms[0].nursing_unit,document.forms[0].nursing_unit_desc)"><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>

				<input type=hidden name = "nurs_desc_hid" id="nurs_desc_hid" value="">
				<input type=hidden name = "nursing_unit" id="nursing_unit" value="">
		<%
			}
			else
			{
		 %>
			 <select name=nursing_unit>
				<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<%
					try{
							String sqln="select NURSING_UNIT_CODE,SHORT_DESC from IP_NURSING_UNIT where  facility_id='"+facility_id+"' ";
							String id="";
							String dat="";
							stmt=con.createStatement();
							rs=stmt.executeQuery(sqln);
							if(rs!=null)
							{
								while(rs.next())
								{
									id=rs.getString(1);
									dat=rs.getString(2);
									out.println("<option value='"+id+"'>"+dat+"</option>");
								}
							}
							if(rs!=null)rs.close();
							if(stmt!=null)stmt.close();



						}
						catch(Exception e) {out.println(e);}
				%>
			 </select></td>
		<%
			}
		 %>
		<td class='label' >&nbsp;</td>
		<td class='label' >&nbsp;</td>
<!-- <td align=center><input type=button class=button value='Search' name='Search' id='Search' onclick='PopulateResult()' ></td> -->

   	</tr>
	<table border='0' cellpadding='0' cellspacing='0' width='90%' align='center' id=tab style='visibility:hidden'>
	
	<tr><td colspan='6' class='DEFAULTBLANKROW2PT'style='padding: 0; line-height: 0.5;'>&nbsp;</td></tr>
	<tr>
		<td class=label width='25%' nowrap><fmt:message key="eIP.NursingUnitType.label" bundle="${ip_labels}"/></td>
		<td align=left class='querydata' id=td1 width='30%'></td>
		<td class=label  width='15%' nowrap><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
		<td align=left class='querydata' id=td2 width='30%'></td><td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr><td colspan='6'  class='DEFAULTBLANKROW2PT' style='padding: 0; line-height: 0.5;'>&nbsp;</td></tr>

	<tr>
		<td class=label ><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/></td>
<%	if(called_from.equals("5")) //Department is open for [Services for Nursing Unit]...
	{	%>
		<td align=left class='querydata' id=td3>
			<select name="dept_code" id="dept_code" onchange="clearResultPage()"><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			<%	try
				{
					String deptSql = " SELECT DEPT_CODE, SHORT_DESC FROM AM_DEPT WHERE EFF_STATUS = 'E' ORDER BY 2 ";
					String id="";
					String dat="";
					stmt=con.createStatement();
					rs=stmt.executeQuery(deptSql);
					if(rs!=null)
					{
						while(rs.next())
						{
							id=rs.getString(1);
							dat=rs.getString(2);
							out.println("<option value='"+id+"'>"+dat+"</option>");
						}
					}
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();

				}catch(Exception e) 
				{
					out.println(e);
				}
			%>
			</select>
		</td>
<%	}
	else
	{	%>
			<td align=left class='querydata' id=td3>
<%	}	%>
			<td class=label ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		<td align=left class='querydata' id=td4></td>
		<td class='label' >&nbsp;</td>
		<td class='label' >&nbsp;</td>
	</tr>
	<tr>
 		<td class='label' colspan=6>&nbsp;</td>
	</tr>

<tr>
	<%
	if(called_from.equals("1")||called_from.equals("3")||called_from.equals("5")||called_from.equals("6"))
	{
	%>
		<td class='label'  ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
		<td align=left colspan=3 class='fields' >
		<SELECT name="search_by" id="search_by" onchange="enable_txt(this)">
		<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
		<option value="ID"><%=ID%></option>
		<option value="DESC"><%=Desc%></option>
		</SELECT>&nbsp;&nbsp;<INPUT TYPE="text" name="search_txt" id="search_txt" disabled onKeyPress='return CheckForSpecChars_local(event)' size=15 maxlength=15></td>
		<%}else{%>
		<td align=left colspan=4 class='fields' >&nbsp;</td>
		<%}%>	
    	<td class='fields' ><input type=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' name='Search' onclick='PopulateResult()' ></td><td align=left><input type=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' name='Clear' onclick="parent.frames[1].location.href='../../eCommon/html/blank.html'" ></td>
		</tr> 

		<input type=hidden name=called_from value='<%=called_from%>'>
		<input type=hidden name=facility_id value='<%=facility_id%>'>
		<input type=hidden name=strCheck value="">
		<!--3-06-08-->
		<input type=hidden name=nursing_unit_type value=''>
		<input type=hidden name=age_group value=''>
		<input type=hidden name=department value=''>
		<input type=hidden name=service value=''>
		<!-- The New Hidden Vairables added on 5/6/2008  For passing Result Page-->
		<input type=hidden name=Criteria_nursing_unit value=''>
		<input type=hidden name=Criteria_nursing_unit_type value=''>
		<input type=hidden name=Criteria_age_group value=''>
		<input type=hidden name=Criteria_department value=''>
		<input type=hidden name=Criteria_service value=''>
		<input type='hidden' name='Criteria_from' id='Criteria_from' value=''>
		<input type='hidden' name='Criteria_to' id='Criteria_to' value=''>
		<input type='hidden' name='Criteria_start' id='Criteria_start' value=''>
		<input type='hidden' name='Criteria_end' id='Criteria_end' value=''>
		<input type='hidden' name='Criteria_searchby' id='Criteria_searchby' value=''>
		<input type='hidden' name='Criteria_searchcrt' id='Criteria_searchcrt' value=''>
		<input type='hidden' name='statusval' id='statusval' value=''>
		<!--3-06-08-->

<%	if(!called_from.equals("5"))
	{	%>
		<input type=hidden name=dept_code value=''>
<%	}	%>

		
		</form>
  <%
  }
   catch ( Exception e ){out.println(e.toString());}
   finally{
		if ( stmt != null ) stmt.close() ;
		if ( rs != null ) rs.close() ;
		ConnectionManager.returnConnection(con,request);
	}

%>
</body>
</html>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

