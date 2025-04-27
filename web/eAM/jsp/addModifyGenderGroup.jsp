<!DOCTYPE html>
<%--
	FileName	: addModifyGenderGroup.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>


<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eAM/js/GenderGroup.js'  language ='javascript'></script></script>

<SCRIPT LANGUAGE="JavaScript">
<!--
function checkZero(obj)
{
	if(parseInt(obj.value)==0){
		alert(getMessage("INVALID_POSITIVE_NUMBER","Common"));
		//obj.select();
		obj.value="";
		obj.focus();
	}
}

function changeCase(Obj)
{
	Obj.value=Obj.value.toUpperCase();

}
function allowNumerics(fld, e, maxInt, deci)
{
    var count=fld.value.length;//ok
    var whichCode = (window.Event) ? e.which : e.keyCode;//ok

	var minusOccurance = fld.value.indexOf('-');
	if(minusOccurance != -1)
	{
		maxInt++;
	}
	if(whichCode == 45 && count>0)
	{
		return false
	}

    if(count>=maxInt)
    {
        if(count==maxInt)
        {
            var dotOccurance = fld.value.indexOf('.');
			//alert("dotOccurance : "+dotOccurance);

            if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt)&& deci>0)
            {
				if(whichCode!=46)
                {
                    fld.value = fld.value+".";
                    //alert("APP-0001 Reached Maximum Integer value");
                    //return false;
                }
            }
        }
        else if(count>maxInt)
        {
            var objectValue = fld.value;
            var dotOccurance = objectValue.indexOf('.');
            //alert(objectValue.charAt(maxInt));
            if((objectValue.charAt(maxInt))!='.')
            {
                if(dotOccurance==-1 && parseInt(deci)>0 )
                {
                    fld.value = objectValue.substring(0,maxInt)+".";
                    return false;
                }
            }
        }
    }
	//you donot require this just var strCheck = '.0123456789' for deci > 0
	//strCheck = '0123456789' for deci=0
	      var strCheck = '.0123456789-';

//	alert(e.getKeyCode())
    if (parseInt(deci)==0)//For Only Nos 0 - 9
        strCheck = '0123456789';

    var fldvalue=fld.value;
    var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;  // Enter
    var pointCount=0;

    for(var i=0;i<fldvalue.length;i++)
    {
        if(fldvalue.charAt(i)=='.') pointCount++;
    }

    if (pointCount>0 && whichCode == 46) return false;

    var fldValue    =   fld.value;
    var dotIndex    =   fldValue.indexOf(".");
    var fldLength   =   fldValue.length;
    if(dotIndex!=-1)
        if( fldLength > (dotIndex+deci) ) return false;


	key = String.fromCharCode(whichCode);  // Get key value from key code

	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	else if(key == "-" && fldValue.indexOf(key) != -1  )
	{
		if(fldValue.indexOf(key) != 1 )
			return false
	}
    return true;
}

//-->
</SCRIPT>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<%@ page import ="java.sql.*, java.util.*, java.text.*" %>
<%
	request.setCharacterEncoding("UTF-8");
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//String datefr="";
	//String dateto="";
	String code="";
	String longdesc="";
	String shortdesc="";
	String gender="";
	String max_age="";
	String min_age="";
	String age_unit="";
	String age_unit1="";
	String eff_status="";
	//SimpleDateFormat formatter;
	String s="";
	String vval="";
	
	String rdonly="";
	String fnval="insert";
	String def="checked";
	//String facilityId = (String) session.getValue( "facility_id" ) ;

	//String age_unitCols1[]={"---Select---","Day","Month","Year","Hours","Minutes","Seconds"};
	String age_unitCols1[]={"---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.hours.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.month.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.year.label","common_labels")};
	//String age_unitCols[]={"---Select---","Day","Month","Year","Hours","Minutes","Seconds"};
	String age_unitCols[]={"---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.hours.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.month.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.year.label","common_labels")};

	//String age_unitVals1[]={"","D","M","Y","H","N","S"};
	String age_unitVals1[]={"","D","H","N","M","Y"};
	//String age_unitVals[]={"","D","M","Y","H","N","S"};
	String age_unitVals[]={"","D","H","N","M","Y"};

	//String genderCols[]={"---Select---","Unknown","Male","Female"};
	String genderCols[]={"---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")};
	//String genderVals[]={"","U","M","F"};
	String genderVals[]={"","F","M","U"};
	Connection conn = ConnectionManager.getConnection(request);
	Statement stmt=null;
	PreparedStatement pstmt = null;
	ResultSet rset=null;

	try
	{
	    code=request.getParameter("age_grp_code");
	    if(code!=null)
	    {
	    	
	    	stmt = conn.createStatement();

	    //	rset=stmt.executeQuery("select * from am_age_group where Age_Group_Code='"+code+"' and facility_id='"+facilityId+"'");
	    	String sql1 = "select * from am_age_group where Age_Group_Code=?";
			
			pstmt   = conn.prepareStatement(sql1);
			pstmt.setString	(	1,	code		);
			rset		 = pstmt.executeQuery();
			if(rset != null)
	    	{
	    		   rdonly="readonly";
	    		   fnval="modify";
			   rset.next();
			   code = rset.getString("Age_Group_Code");
			   longdesc = rset.getString("long_desc");
			   shortdesc = rset.getString("short_desc");
			   gender =rset.getString("gender");
			   max_age=String.valueOf(rset.getInt("max_age"));
			   min_age=String.valueOf(rset.getInt("min_age"));
			   age_unit=rset.getString("age_unit");
			   age_unit1=rset.getString("AGE_UNIT_MAX");
			   eff_status=rset.getString("eff_status");
			   if(eff_status.equals("D"))
			   	s="readonly";

   			}
    		}
			if(rset!=null)	rset.close();
			if(stmt!=null) stmt.close();
			if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		
		ConnectionManager.returnConnection(conn,request);
	}
	if(code==null)	code="";

%>
</head>

	<body OnMouseDown='CodeArrest()' onLoad="FocusFirstElement()"  onKeyDown = 'lockKey()'>
		<form name='gender_form' id='gender_form' action='../../servlet/eAM.GenderGroupServlet' method='post' target='messageFrame'>
			<div>
			<br><br><BR><br>
			<table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
			<tr>
			        <td width='10%'>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td width='10%'>&nbsp;</td>
				 <td>&nbsp;</td>
			</tr>
    				<tr>
    				     <td>&nbsp;</td>
    				     <td   class='label'><!--width='40%'--><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
    				     <td  class='fields' ><!--width='60%'colspan='2'-->&nbsp;&nbsp;
    				   <input type='text'  onBlur="makeValidString(this);changeCase(this)" onKeyPress="return CheckForSpecChars(event)"  name='gender_group_code' id='gender_group_code' value="<%=code%>" size='2' maxlength='2' <%=rdonly%> >&nbsp;<img src='../../eCommon/images/mandatory.gif'></img> </td>
    				   <td>&nbsp;</td>
    				   <td>&nbsp;</td>
    				</tr>
    				<tr>
    					<td>&nbsp;</td>
    					<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						 <td>&nbsp;</td>
				</tr>

    				<tr>
    				     <td>&nbsp;</td>
    				     <td   class='label'><!--width='40%'--><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      				     <td  class='fields'><!--colspan='2'width='60%'-->&nbsp;&nbsp;
                                        <input type='text' name='long_desc' id='long_desc' value="<%=longdesc%>" onBlur="makeValidString(this)"  size='30' maxlength='30' style='{ font-size: ;}'  <%out.print(s);%>>&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td>
                                     <td>&nbsp;</td>
									  <td>&nbsp;</td>
    			        </tr>
    			        <tr>
    			        	<td>&nbsp;</td>
    			        	<td>&nbsp;</td>
							 <td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
				</tr>

    				<tr>
    				     <td>&nbsp;</td>
      				     <td   class='label'><!--width='40%'--><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				     <td  class='fields'><!-- colspan="2"width='60%'-->&nbsp;&nbsp;
      				     <input type='text' name='short_desc' id='short_desc' value="<%=shortdesc%>" onBlur="makeValidString(this)"  size='15' maxlength='15' <%out.print(s);%>>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
      				     <td>&nbsp;</td>
						  <td>&nbsp;</td>
    				</tr>
                                <tr>
                                	<td>&nbsp;</td>
                                	<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					 <td>&nbsp;</td>
				</tr>

    				<tr>
    				     <td>&nbsp;</td>
    				     <td  class='label'><!--width='40%'--><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
    				     <td  class='fields'><!--colspan='2'width='60%'-->&nbsp;&nbsp;
    				      <%if(!s.equalsIgnoreCase("readonly"))
	  			       {%>
    				     	<select name='gender' id='gender'>
    				     	<%vval="";
    				     	for(int kk=0;kk<4;kk++)
    				     	{
    				     		if(fnval.equals("modify"))
    				     	  	{
    				     	  		if(genderVals[kk].equals(gender))
    				     				vval="selected";
    				     	  		else
    				     				vval="";
    				     		}
    				          out.print("<option value=\""+genderVals[kk]+"\" " +vval+ ">"+genderCols[kk]+"</option>");
    				        }
    				     %>
       				     </select><%}
       				     else
				    {   
				     	 for(int kk=0;kk<4;kk++)
				     	 {
				     	 	if(gender==null || gender.equals("")  )
				     	   	{
				     	   		vval="  ";%>
									<select name='gender' id='gender' value='' disabled>
									<option<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>select-----</option>
									</select>
									<%
				     	   		//out.print("<input type='text'  value=\""+vval+"\" size='10' maxlength='10' " +s+">");
				     	      		out.print("<input type=hidden name='gender' id='gender' value='"+genderVals[kk]+"'>");
				     	      		break;
				     	      	}
				     	   	if(genderVals[kk].equals(gender))
				     	   	  {
				     	   	  	vval=genderCols[kk];
				     	   	     	out.print("<input type='text' value=\""+vval+"\" size='10' maxlength='10' " +s+">");
				     	      		out.print("<input type=hidden name='gender' id='gender' value='"+genderVals[kk]+"'>");
				     	      		break;
				     	      	}
	      				}
	      			   }%>
       				 </td>
       				 <td>&nbsp;</td>
					  <td>&nbsp;</td>
    				</tr>
					<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					  <td>&nbsp;</td>
    				</tr>
    				
				<tr>
				     <td>&nbsp;</td>
				     <td   class='label'><!--width='40%'--><fmt:message key="Common.MinimumAge.label" bundle="${common_labels}"/></td>
				     <td  class='fields'><!--colspan='2'width='60%'-->&nbsp;&nbsp;
				     <!-- <input type="text" name='min_age' id='min_age' size="3"  maxlength='3' value='<%=min_age%>' onBlur='CheckNum(this);checkZero(this);' onKeyPress="return allowValidNumber(this, event, 3, 0);" <%out.print(s);%>>&nbsp<img src='../../eCommon/images/mandatory.gif'> -->
				      <!--  Modified for ML-BRU-SCF-1101 [IN:044463]  -->
				       <input type="text" name='min_age' id='min_age' size="6"  maxlength='6' value='<%=min_age%>' onBlur='CheckNum(this);checkZero(this);' onKeyPress="return allowNumerics(this, event, 5, 0);" <%out.print(s);%>>&nbsp<img src='../../eCommon/images/mandatory.gif'> 
				       <%if(!s.equals("readonly") )
					 {%>
						<select name='age_unit' id='age_unit'>
						<%vval="";
						for(int kk=0;kk<6;kk++)
						{
							if(fnval.equals("modify"))
							{
								if(age_unitVals[kk].equals(age_unit))
									vval="selected";
								else
									vval="";
							}
						         out.print("<option value='"+age_unitVals[kk]+"' " +vval+ ">"+age_unitCols[kk]+"</option>");
						}
				    	   %>
					   </select><%}
					    else
					      {
					      	for(int kk=0;kk<6;kk++)
					      	{
					      		if(age_unitVals[kk].equals(age_unit))
							{
							     	vval=age_unitCols[kk];
							  	out.print("<input type='text' SIZE='10' value="+vval+" " +s+">");
					      			out.print("<input type='hidden' name='age_unit' id='age_unit' value='"+age_unitVals[kk]+"'>");
					      		  }
					      	 }
					      }%>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td><td>&nbsp;</td><td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					 <td>&nbsp;</td>
				</tr>

    				<tr>
    				      <td>&nbsp;</td>
	  		         <td   class='label'><!--width='40%'--><fmt:message key="eAM.MaximumAge.label" bundle="${am_labels}"/></td>
	  			     <td  class='fields'><!-- colspan='2'width='60%'-->&nbsp;&nbsp;
	  			      <!-- <input type="text" name='max_age' id='max_age'  size="3" maxlength='3' value='<%=max_age%>' onBlur='CheckNum(this);checkZero(this);' onKeyPress="return allowValidNumber(this, event, 3, 0);" <%out.print(s);%> >&nbsp<img src='../../eCommon/images/mandatory.gif' <%out.print(s);%>> -->
	  			       <!--  Modified for ML-BRU-SCF-1101 [IN:044463]  -->
	  			       <input type="text" name='max_age' id='max_age'  size="6" maxlength='6' value='<%=max_age%>' onBlur='CheckNum(this);checkZero(this);' onKeyPress="return allowNumerics(this, event, 5, 0);" <%out.print(s);%> >&nbsp<img src='../../eCommon/images/mandatory.gif' <%out.print(s);%>>
	  			      
	  			       <%if(!s.equals("readonly") )
					     {%>
						<select name='age_unit1' id='age_unit1'>
						<%vval="";
						for(int gg=0;gg<6;gg++)
						{
							if(fnval.equals("modify"))
							{
								if(age_unitVals1[gg].equals(age_unit1))
									vval="selected";
								else
									vval="";
							}
						         out.print("<option value='"+age_unitVals1[gg]+"' " +vval+ ">"+age_unitCols1[gg]+"</option>");
						}
				    	   %>
					   </select><%}
					    else
					      {
					      	for(int gg=0;gg<6;gg++)
					      	{
					      		if(age_unitVals1[gg].equals(age_unit1))
							{
							     	vval=age_unitCols1[gg];
							  	out.print("<input type='text' SIZE='10' value="+vval+" " +s+">");
					      			out.print("<input type='hidden' name='age_unit1' id='age_unit1' value='"+age_unitVals1[gg]+"'>");
					      		  }
					      	 }
					      }%>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
	  			      <td>&nbsp;</td>
					   <td>&nbsp;</td>
					
    				</tr>
    				<tr>
    					<td>&nbsp;</td>
    					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					 <td>&nbsp;</td>
				</tr>

				<tr>
				    <td>&nbsp;</td>
				    <td class='label'><!-- width='40%'--><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				    <%
				    if(eff_status.equals("D"))
				    	def="";
				  %>
	   			 <input type='hidden' name='checked1' id='checked1'  value='<%=def%>'>
	   			  <td class='fields'><!--colspan='2' width='60%'-->&nbsp;&nbsp;<input type='checkbox' name='eff_status' id='eff_status' value='E'  <%=def%>>&nbsp;</td>
	   			  <td>&nbsp;</td> <td>&nbsp;</td>
	   			  <%   s="";%>
      				  </tr>
      				  <tr>
      				  	<td>&nbsp;</td>
      				  	<td>&nbsp;</td>
				  	<td>&nbsp;</td>
				  	<td>&nbsp;</td>
					 <td>&nbsp;</td>
				 </tr>
  			</table>
		</div>
		<input type='hidden' name='function' id='function' value='<%=fnval%>'>
		<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>

	</form>
</body>
</html>

