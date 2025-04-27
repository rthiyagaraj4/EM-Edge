<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%
	request= new XSSRequestWrapper(request);
    	response.addHeader("X-XSS-Protection", "1; mode=block");
    	response.addHeader("X-Content-Type-Options", "nosniff");
	request.setCharacterEncoding("UTF-8");
	String  range_id = request.getParameter("range_id");
		if(range_id == null) range_id="";
	String range_type = request.getParameter("range_type");
		if(range_type == null || range_type.equals("")) range_type="";
	Connection conn = null;
	Statement stmt=null;
	PreparedStatement pstmt = null;
	ResultSet rset=null;
	String long_desc="",short_desc="" ,no_of_ranges="",eff_status="",textAttribute="",chkAttribute="",textAttribute1="";
	
try{
	
	if(!range_id.equals(""))
	{
	conn = ConnectionManager.getConnection(request);
	//String sql="select range_type,range_id,long_desc,short_desc ,no_of_ranges,eff_status from am_summ_range where range_id='"+range_id+"' and range_type='"+range_type+"'";
	//stmt = conn.createStatement();
	//rset = stmt.executeQuery(sql);
	
	String sql="select range_type,range_id,long_desc,short_desc ,no_of_ranges,eff_status from am_summ_range where range_id=? and range_type=?";	
	
	pstmt   = conn.prepareStatement(sql.toString());
	pstmt.setString	(	1,	range_id		);
	pstmt.setString	(	2,	range_type		);
	rset		 = pstmt.executeQuery();

	
	rset.next();
	range_type=rset.getString("range_type");
	if(range_type == null) range_type="";
	range_id=rset.getString("range_id");
	long_desc=rset.getString("long_desc");
	short_desc=rset.getString("short_desc");
	no_of_ranges=rset.getString("no_of_ranges");
	eff_status=rset.getString("eff_status");
	textAttribute1="readOnly";
	}
if(eff_status.equals("D"))
	{
	textAttribute="readOnly";
	chkAttribute="";
	}
	else
	{
	chkAttribute="CHECKED";
	eff_status="E";
	}


%>

 <html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eAM/js/AgeRange.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

function checkNoDecimal(fld,event)
{
	//alert("here");
	var retVal;
	if (document.agerange_form.range_type.value =="A")
	{
		//alert("a");
		fld.maxLength=3;
		retVal=allowValidNumber(fld,event,3, 0);
	}
	else if (document.agerange_form.range_type.value =="W")
	{
		//alert("w");
		fld.maxLength=6;
 		retVal==allowValidNumber(fld, event, 2,3);
	}
	return retVal;
}

	
	
	function func()
	{
		var rangeVal=agerange_form.no_of_ranges.value;
		var cnt;
		if(rangeVal != "")
		 cnt = parseInt(rangeVal)+1;
		for(cnt;cnt<= 25;cnt++)
		{
			var strFrom="parent.frames[1].document.agerange_form.range_"+cnt+"_fr_unit";
			var strTextFrom="parent.frames[1].document.agerange_form.range_"+cnt+"_fr";
			var strTo="parent.frames[1].document.agerange_form.range_"+cnt+"_to_unit";
			var strTextTo="parent.frames[1].document.agerange_form.range_"+cnt+"_to";
		
			eval(strTextFrom).value="";
			eval(strTextTo).value="";
			
			eval(strFrom).options[0].selected=true;
			eval(strTo).options[0].selected=true;
		}
		
		if (agerange_form.range_type.value == 'A')
		{
			if (agerange_form.no_of_ranges.value <1 || agerange_form.no_of_ranges.value >25)
			{
				if(agerange_form.no_of_ranges.value.length >0)
				{
					alert(getMessage("NO_OF_AGE_RANGE","AM"));
					agerange_form.no_of_ranges.focus();
					agerange_form.no_of_ranges.select();
				}
			}
			else
			{
				var cnt=parent.frames[0].agerange_form.no_of_ranges.value;
		
				for (var i=1;i<=cnt;i++)
				{
					var foc_val=(i+1)-i;
					//eval("parent.frames[1].document.agerange_form.range_"+foc_val+"_fr").focus();
					eval("parent.frames[1].document.agerange_form.range_"+i+"_fr").disabled=false;
					eval("parent.frames[1].document.agerange_form.range_"+i+"_to").disabled=false;
				    eval("parent.frames[1].document.agerange_form.range_"+foc_val+"_fr").focus();
				}	
				
			}
		}
		else if (agerange_form.range_type.value == 'W')
		{
			if (agerange_form.no_of_ranges.value <1 || agerange_form.no_of_ranges.value >25)
			{
				if(agerange_form.no_of_ranges.value.length >0)
				{
					alert(getMessage("NO_OF_WEIGHT_RANGE","AM"));
					agerange_form.no_of_ranges.focus();
					agerange_form.no_of_ranges.select();
				}
					
			}
			else
			{
				var cnt=parent.frames[0].agerange_form.no_of_ranges.value;
		
				for (var i=1;i<=cnt;i++)
				{
					var foc_val=(i+1)-i;
					eval("parent.frames[1].document.agerange_form.range_"+foc_val+"_fr").focus();
					eval("parent.frames[1].document.agerange_form.range_"+i+"_fr").disabled=false;
					eval("parent.frames[1].document.agerange_form.range_"+i+"_to").disabled=false;
				}
			}
				//parent.frames[1].document.forms[0].range_1_fr.focus();
		}
	}



function ageWeightOption(Obj)
{
for(j =1; j <= 25;j++)
	{
		if(document.agerange_form.range_type.value =="W")
		{
			var strFrom="parent.frames[1].document.agerange_form.range_"+j+"_fr_unit";
			var strTo="parent.frames[1].document.agerange_form.range_"+j+"_to_unit";
			var strFromText="parent.frames[1].document.agerange_form.range_"+j+"_fr";
			var strToText="parent.frames[1].document.agerange_form.range_"+j+"_to";
			
			eval(strFromText).value='';eval(strToText).value='';
			
			eval(strFrom).options[0]=null;
			eval(strFrom).options[1]=null;
			eval(strTo).options[0]=null;
			eval(strTo).options[1]=null;
			
			
			eval(strFrom).options[0] =new Option("Kgs","K");
			eval(strFrom).options[1] =new Option("Lbs","L");
			eval(strTo).options[0] =new Option("Kgs","K");
			eval(strTo).options[1] =new Option("Lbs","L");

		}

		if(document.agerange_form.range_type.value =="A")
		{
			var strFrom="parent.frames[1].document.agerange_form.range_"+j+"_fr_unit";
			var strTo="parent.frames[1].document.agerange_form.range_"+j+"_to_unit";
			var strFromText="parent.frames[1].document.agerange_form.range_"+j+"_fr";
			var strToText="parent.frames[1].document.agerange_form.range_"+j+"_to";
			
			eval(strFromText).value='';eval(strToText).value='';
			
			eval(strFrom).options[0]=null;
			eval(strFrom).options[1]=null;
			eval(strFrom).options[2]=null;
			
			eval(strTo).options[0]=null;
			eval(strTo).options[1]=null;
			eval(strTo).options[2]=null;
			
			eval(strFrom).options[0] =new Option("Days","D");
			eval(strFrom).options[1] =new Option("Months","M");
			eval(strFrom).options[2] =new Option("Years","Y");
			
			eval(strTo).options[0] =new Option("Days","D");
			eval(strTo).options[1] =new Option("Months","M");
			eval(strTo).options[2] =new Option("Years","Y");
			
		}
	}

}

</script>

</head>
<body  OnLoad="Focusing('range_id')" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="agerange_form" id="agerange_form" action="../../servlet/eAM.AgeRangeServlet" method="post" target="messageFrame">
<center>

<br><br>
  <table border="0" cellpadding="0" cellspacing="0" width="85%">
	  <tr>
		<td class="BORDER" width="100%">
			<table border='0' cellpadding='0' cellspacing='0' width='100%'>
			<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
			 	<tr>
					<td class="label"  width="40%"><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
					<td width="60%" colspan="3" class="fields">&nbsp;&nbsp;<% if(range_type.equals("")) { %>&nbsp;<select name="range_type" id="range_type" onChange="ageWeightOption(this);">
						<OPTION VALUE="A"><fmt:message key="Common.age.label" bundle="${common_labels}"/>
						<OPTION VALUE="W"><fmt:message key="Common.weight.label" bundle="${common_labels}"/>
					<% } else {  
						if(range_type.equals("A")) {
						%>
						<input type='text' name='range_type_desc' id='range_type_desc' size='6'  value='Age' readOnly ><input type='hidden' name='range_type' id='range_type' value='A'>
					<%
						}
						else
						{
					%>
						<input type='text' name='range_type_desc' id='range_type_desc'  size='6' value='Weight' readOnly ><input type='hidden' name='range_type' id='range_type' value='W'>
						<%}
						} 
					%>
						
						</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
	           	</tr>
	     		<tr>
	       			<td width="40%"  class="label"><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
	   	    	    <td width="60%"  colspan="3" class="fields">&nbsp;&nbsp;&nbsp;<input type="text"  value="<%=range_id%>" <%=textAttribute1%>  id="range_id" name="range_id" size="4" maxlength="4" onBlur="ChangeUpperCase(this);CheckSpecialChar(this);" onKeyPress="return CheckForSpecChars(event)">&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
	   	    	</tr>
	   	    	<tr>
					 <td width="40%" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
					 <td width="60%" colspan="3" class="fields">&nbsp;&nbsp; <input type="text"  value="<%=long_desc%>"  <%=textAttribute%>  id="long_desc" name="long_desc" size="30" maxlength="30" onBlur='makeValidString(this)'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
	   	    	</tr>
				<tr>
					 <td width="40%" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
					 <td width="60%" colspan="3" class="fields">&nbsp;&nbsp; <input type="text" value="<%=short_desc%>" <%=textAttribute%>  id="short_desc" name="short_desc" size="15" maxlength="15" onBlur='makeValidString(this)'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
	   	    	</tr>

			<tr>
					 <td width="40%"  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				     <td width="60%"  class="fields" colspan="3">&nbsp;&nbsp;&nbsp;<input type="checkbox" name="eff_status" id="eff_status" value="<%=eff_status%>" <%=chkAttribute%> >&nbsp;</td>
				 </tr>
				 <tr>
					 <td width="40%"  class="label"><fmt:message key="eAM.NoofRanges.label" bundle="${am_labels}"/></td>
					  <td width="60%" colspan="3" class="fields">&nbsp;&nbsp; <input type="text"  value= "<%=no_of_ranges%>"  <%=textAttribute%>  id="no_of_ranges" name="no_of_ranges" size="2" maxlength="2" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="func()" >&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
			   	 </tr>
			<tr><td>&nbsp;</td><td>&nbsp;</td></tr>

	      	</table>
   	  	</td>
   	</tr>
   	</table>


<input type="hidden" name="function" id="function" value="insert">
<input type="hidden" name="eff_date_from" id="eff_date_from" >
<input type="hidden" name="eff_date_to" id="eff_date_to" >
<input type='hidden' name='function_name' id='function_name' value='insert'>

</form>
</center>
</body>
</html>
<%
}
catch ( Exception e ){ 
	e.printStackTrace();
}

finally{

	if ( stmt != null ) stmt.close() ;
	if ( rset != null ) rset.close() ;
	ConnectionManager.returnConnection(conn,request);

	}
%>

