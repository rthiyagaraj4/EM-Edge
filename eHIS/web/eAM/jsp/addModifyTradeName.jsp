<!DOCTYPE html>
<!--/**** Master for entering the Trade Name ******/-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ page  contentType="text/html;charset=UTF-8"%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import="java.sql.*, java.util.*, java.text.*, eCommon.XSSRequestWrapper, webbeans.eCommon.*" %>

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../js/TradeName.js' language='javascript'></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>

<script>
/* Developed by Mallikarjuna Reddy */
//function for Enabled check box
function ChangeUpperCase(Object) {
    var objectfield = Object ;
    objectfield.value = objectfield.value.toUpperCase();
}

function Change1()
{
	if ( TradeName_form.eff_status.checked == true)
	TradeName_form.eff_status.value="E";
	else
	TradeName_form.eff_status.value="D";
}
//End of the function for Enabled check box

//function for drug check box
function drugselect()
{
	if ( TradeName_form.drug.checked == true)
	TradeName_form.drug.value="Y";
	else
	TradeName_form.drug.value="N";
}
//End of the function for drug check box
 </script>
</head>

<body onLoad = 'FocusFirstElement();' onKeyDown = 'lockKey()' OnMouseDown='CodeArrest()'>

 <%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Declaration of Variables used
	Connection conn = null;
	Statement stmt =null;
	PreparedStatement pstmt = null;
	ResultSet rset=null;
	 
    String facilityId = (String)session.getValue("facility_id");
	if(facilityId == null) facilityId="";
	 	
	String tradeid="";     
	boolean newSpeciality=false;
	String sql="";
	String effstatus="";
	String longname="";
	String shortname="";
	String drug="";
	String Manufacturer="";
	String manufacturer_name = "";
	String otherTextAttribute="";
	String otherAttribute="";
	String checkdrug="";
	String checkstatus="";
	String red="";
	
	//getting the tradeid parameter from the request
	tradeid=request.getParameter("tradeid");
	if (tradeid==null) tradeid="";
	//Main try block
	try{
			conn = ConnectionManager.getConnection(request);
			stmt = conn.createStatement();
			//If tradeid is null it will be in insert mode		
			if(tradeid.equals(""))
			{
				tradeid="";     
				effstatus="E";
				longname="";
				shortname="";
				drug="";
				Manufacturer="";
				checkdrug="";
				checkstatus="CHECKED";
				newSpeciality=true;
				manufacturer_name="";
				red="";
			}
			else
			//If tradeid is having value it will come to this loop and will be in modify mode
			//Else part starts here
			{
				otherTextAttribute="READONLY";
				otherAttribute="disabled";
				//Inner try block
				try
				{
					sql =  "SELECT TRADE_ID,A.LONG_NAME TRADE_LONG_NAME,A.SHORT_NAME TRADE_SHORT_NAME ,A.EFF_STATUS,DRUG_YN,A.MANUFACTURER_ID, B.SHORT_NAME MANUFACTURER_NAME from AM_TRADE_NAME A, AM_MANUFACTURER B  where TRADE_ID=? AND A.MANUFACTURER_ID = B.MANUFACTURER_ID";
		
					//rset = stmt.executeQuery(sql);
					
					pstmt   = conn.prepareStatement(sql);
					pstmt.setString	(	1,	tradeid		);

					rset		 = pstmt.executeQuery();
					
					rset.next();
			  
					//Populating the values from the database
					tradeid=rset.getString("TRADE_ID");
					effstatus=rset.getString("EFF_STATUS");
					longname = rset.getString("TRADE_LONG_NAME");
					drug = rset.getString("DRUG_YN");
					Manufacturer = rset.getString("MANUFACTURER_ID");
					shortname = rset.getString("TRADE_SHORT_NAME");
					manufacturer_name = rset.getString("MANUFACTURER_NAME");

					if(drug.equalsIgnoreCase("Y"))
					{
						checkdrug="CHECKED";
					}
					if(effstatus.equalsIgnoreCase("E"))
					{
						checkstatus="CHECKED";
						red = "";
					}
					else
					{
						checkstatus="";
						red = "readonly";
					}
				}//Inner try block closes here
				catch(Exception e){e.printStackTrace();}
				newSpeciality=false;
			}//else part closes here
		}//Main try closes here
		catch(Exception e) {e.printStackTrace();}
		finally
		{
			if(rset!=null)    	rset.close();
	  		if(stmt!=null)  	stmt.close();
	  		if(pstmt!=null)  	pstmt.close();
			ConnectionManager.returnConnection(conn,request);	
		}
%>

<form name='TradeName_form' id='TradeName_form' action='../../servlet/eAM.TradeNameServlet' method='post' target='messageFrame'>
<div>

<br><br><br><br><br><br><br><br><br>

<table border='0' cellpadding='0' cellspacing='0' width='85%' align='center'>
	<tr>
		<td width='10%'>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td width='10%'>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td class='label'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type='text' name='tradeid' id='tradeid' value="<%=tradeid%>" <%=otherTextAttribute%> size='21' maxlength='20'   onKeyPress="return CheckForSpecChars(event)" onblur="return  ChangeUpperCase(this);">
		<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>

		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td class=label><fmt:message key="Common.longname.label" bundle="${common_labels}"/></td>
		<td  class='fields'>&nbsp;&nbsp;<input type='text' name='long_name' id='long_name' size='44' maxlength='40' value="<%=longname%>" <%=red%> onblur="return makeValidString(this);" >
		<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	 <tr>
		<td>&nbsp;</td>
		<td  class=label><fmt:message key="Common.shortname.label" bundle="${common_labels}"/></td>
		<td  class='fields'>&nbsp;&nbsp;<input type='text' name='short_name' id='short_name' size='21' maxlength='20' value="<%=shortname%>" <%=red%> onblur="return makeValidString(this);" >
		<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		<td>&nbsp;</td>
	</tr> 
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td class=label><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
		<td  class='fields'>&nbsp;<input type=checkbox name='drug' id='drug' value="Y"  <%=checkdrug%> <%=otherAttribute%> onclick="drugselect()" >
		</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td  class=label><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></td>
		<td  class='fields'>&nbsp;&nbsp;<input type='text' name='Manufacturer_desc' id='Manufacturer_desc' size='21' maxlength='20' onblur='makeValidString(this); callSearch(this,Manufacturer_desc,Manufacturer);' value="<%=manufacturer_name%>"  <%=otherTextAttribute%> <%=otherAttribute%> ><input type='hidden' name='Manufacturer' id='Manufacturer' value="<%=Manufacturer%>"><input type='button' name='manufacture_search' id='manufacture_search' class='BUTTON' value='?' onClick='callSearch(this,Manufacturer_desc,Manufacturer)' <%=otherAttribute%>>
		<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
		<tr>
		<td>&nbsp;</td>
		<td  class=label><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td  class='fields'>&nbsp;<input type=checkbox name='eff_status' id='eff_status' value="<%=effstatus%>"  <%=checkstatus%> onClick="Change1()"></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>

</table>
</div>
	<%
		if(newSpeciality)
		{
	%>
		<input type='hidden' name='function1' id='function1' value='insert'>
		<input type='hidden' name='function_name' id='function_name' value='insert'>
	<%  }
  		else
		{
	%>
		<input type='hidden' name='function1' id='function1' value='modify'>
		<input type='hidden' name='function_name' id='function_name' value='modify'>
	<%
		}

	%>
</form>
</body>
</html>

