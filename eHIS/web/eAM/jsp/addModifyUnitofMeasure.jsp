<!DOCTYPE html>
<!--/**** Master for entering the Unit of Measure ******/-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import="java.sql.*, java.util.*, java.text.*, eCommon.XSSRequestWrapper, webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../js/UnitofMeasure.js' language='javascript'></script>

<script>
//Function for Enabled Check box

function CheckForSpecCharsAndSpace(event)
{
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}
function ChangeUpperCase(Object) {
    var objectfield = Object ;
    objectfield.value = objectfield.value.toUpperCase();
}



function Change1()
{
	if ( UnitOfMeasure_form.eff_status.checked == true)
	UnitOfMeasure_form.eff_status.value="E";
	else
	UnitOfMeasure_form.eff_status.value="D";
}
//End of the function Enabled check box
//Function for Quantity Check box to enabling or disabling Strength Check box
function Quantity()
{
	if ( UnitOfMeasure_form.quantityyn.checked == true)
	{
	UnitOfMeasure_form.quantityyn.value="Y";
	UnitOfMeasure_form.strengthyn.disabled = true;
	}
	else
	{
	UnitOfMeasure_form.quantityyn.value="N";
	UnitOfMeasure_form.strengthyn.disabled = false;
	}
}
//End of the function Quantity check box
//Function for Strength Check box to enabling or disabling Quantity Check box
function Strength()
{
	if ( UnitOfMeasure_form.strengthyn.checked == true)
	{
	UnitOfMeasure_form.strengthyn.value="Y";
	UnitOfMeasure_form.quantityyn.disabled = true;
	}
	else
	{
	UnitOfMeasure_form.strengthyn.value="N";
	UnitOfMeasure_form.quantityyn.disabled = false;
	}
}
//End of the function Strength check box

 </script>
</head>
<body onLoad = 'FocusFirstElement();' onKeyDown = 'lockKey()' OnMouseDown='CodeArrest()'>
 <%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet rset = null;
		 
    String facilityId = (String)session.getValue("facility_id");
	if(facilityId == null) facilityId="";
	
	//Declaration of variables used
	//String sql_charge="";
	String Code="";     
	String Purchase=""; 
	String Stock="";
	String Sale="";
	String Dosage="";
	String Strength="";
	String Quantity="";
	String longdesc="";
	String shortdesc="";
	String externaluom="";
	//String deposit_appl_yn="";
	//String addl_dep_yn="";
	//String effdatefrom="";
	//String effdateto="";
	String effstatus="";
	//String codeTextAttribute="";
	String otherTextAttribute="";
	String otherAttribute="";
	//String otherAttribute1="";
	//String checkBoxAttribute="";
	//String UncheckBoxAttribute="";
	//String eventFunctionForCase="";
	//String CheckValue="";
	//String CheckValue1="";
	boolean newSpeciality=false;
	String sql="";
//	String setup_bl_dtls_in_ip_yn="";
	String checkAttribute="";
	String checkAttribute1="";
	String checkAttribute2="";
	String checkAttribute3="";
	String checkAttribute4="";
	String checkAttribute5="";
	String checkAttribute6="";
	String dis="";
	String dis1="";
	String check="";

%>
<%
	Code=request.getParameter("Code");
	if (Code==null) Code="";
	try
	{
		conn = ConnectionManager.getConnection(request);
	    stmt = conn.createStatement();
		//If Code Value is null it will be in insert mode		
		if(Code.equals(""))
		{
			Code="";     
			Purchase=""; 
			Stock="";
			Sale="";
			Dosage="";
			Strength="";
			Quantity="";
			longdesc="";
			shortdesc="";
			externaluom="";

			//deposit_appl_yn="";
			//addl_dep_yn="";
			effstatus="E";
			//codeTextAttribute="";
			otherTextAttribute="";
			//checkBoxAttribute="";
			//UncheckBoxAttribute="";
			newSpeciality=true;
			checkAttribute="CHECKED";
			checkAttribute1="";
			checkAttribute2="";
			checkAttribute3="";
			checkAttribute4="";
			checkAttribute5="";
			checkAttribute6="";
			dis="";
			dis1="";
			check="";
			//eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
		}
		//If Code is value is not null then it will be in modify mode and it will come to this loop
		else
		 {
			check="readonly";
			try
			{
				sql =  "SELECT UOM_CODE,LONG_DESC,SHORT_DESC,EFF_STATUS,PUR_UOM_YN,STOCK_UOM_YN,SALE_UOM_YN,DOSAGE_UOM_YN,STRENGTH_UOM_YN,QTY_UOM_YN,DRUG_DATABASE_UOM_CODE from AM_UOM  where UOM_CODE=?";
		
				
				pstmt   = conn.prepareStatement(sql);
				pstmt.setString	(	1,	Code		);
				rset		 = pstmt.executeQuery();
				//rset = stmt.executeQuery(sql);
				
				rset.next();
			  
				Code=rset.getString("UOM_CODE");
				longdesc=rset.getString("LONG_DESC");
				shortdesc=rset.getString("SHORT_DESC");
				externaluom=rset.getString("DRUG_DATABASE_UOM_CODE");
				effstatus=rset.getString("eff_status");
				Purchase=rset.getString("PUR_UOM_YN");
				Stock=rset.getString("STOCK_UOM_YN");
				Sale=rset.getString("SALE_UOM_YN");
				Dosage=rset.getString("DOSAGE_UOM_YN");
				Strength=rset.getString("STRENGTH_UOM_YN");
				Quantity=rset.getString("QTY_UOM_YN");
				
				if(externaluom==null || externaluom.equals(""))
				{
					externaluom="";
				}

				if(Purchase.equalsIgnoreCase("Y"))
				{
					checkAttribute1="CHECKED";
				}
				if(Quantity.equalsIgnoreCase("Y"))
				{
					checkAttribute2="CHECKED";
					dis = "disabled";
				}
		  		if(Sale.equalsIgnoreCase("Y"))
				{
					checkAttribute3="CHECKED";
				}
				if(Stock.equalsIgnoreCase("Y"))
				{
					checkAttribute4="CHECKED";
				}
				if(Dosage.equalsIgnoreCase("Y"))
				{
					checkAttribute5="CHECKED";
				}
				if(Strength.equalsIgnoreCase("Y"))
				{
					checkAttribute6="CHECKED";
					dis1="disabled";
				}
			  	if(effstatus.equals("D"))
				{
					otherTextAttribute="READONLY";
					checkAttribute="";
					otherAttribute="disabled";
				}
				else
				{
					otherTextAttribute="";
					checkAttribute="CHECKED";
					otherAttribute="";
				}
		
	     }//Inner try block
		 catch(Exception e){
			 //out.println(e.toString());
			 e.printStackTrace();
			 }
		 newSpeciality=false;
		 //eventFunctionForCase="";
	}

		if(rset!=null)    	rset.close();
		if(rs!=null)    	rs.close();
		if(stmt!=null)  	stmt.close();
}//Main try block
catch(Exception e) {
	//out.println(e.toString());
	e.printStackTrace();
	}
finally
{

	
	ConnectionManager.returnConnection(conn,request);
}
%>

<form name='UnitOfMeasure_form' id='UnitOfMeasure_form' action='../../servlet/eAM.UOMServlet' method='post' target='messageFrame'>
<div>

<br><br><br><br><br>

<table border='0' cellpadding='0' cellspacing='0' width='75%' align='center'>
	<tr>
		<td width='10%'>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td width='10%'>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td><td class='fields'>&nbsp;&nbsp;<input type='text' name='Code' id='Code' value="<%=Code%>" <%=check%> size='4' maxlength='4' onblur="return  ChangeUpperCase(this);"  onKeyPress="return CheckForSpecChars(event)">
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
		<td  class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type='text' name='long_desc' id='long_desc' size='32' maxlength='30' value="<%=longdesc%>" <%=otherTextAttribute%> onblur="return makeValidString(this);" >
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
		<td  class=label><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%> onblur="return makeValidString(this);" >
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
		<td  class=label><fmt:message key="Common.external.label" bundle="${common_labels}"/> <fmt:message key="Common.uom.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type='text' name='DRUG_DATABASE_UOM_CODE' id='DRUG_DATABASE_UOM_CODE' size='15' maxlength='20' value="<%=externaluom%>" <%=otherTextAttribute%> onblur="return makeValidString(this);" onKeyPress="return CheckForSpecCharsAndSpace(event)" >
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
		<td  class=label><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type=checkbox name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkAttribute%> onClick="Change1()"></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>

</table>
<BR>
  <table border="0" cellpadding="0" cellspacing="0" width="75%" align="center" >
    <tr>
        <th align="left"><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/> </th>
	</tr>
	<tr>	
		<td class="Border">
		  <table border="0" cellpadding="0" cellspacing="0" width="100%" >
			<tr>
				<td colspan='4'>&nbsp;</tr></td>
					<tr>
						<td  width='30%' class=label><fmt:message key="Common.Purchase.label" bundle="${common_labels}"/>&nbsp;</td>
						<td class='fields'><input type=checkbox name='purchaseyn' id='purchaseyn' value="Y" <%=checkAttribute1%> <%=otherAttribute%> <%=Purchase%> ></td>
						<td  width='25%' class=label><fmt:message key="Common.Stock.label" bundle="${common_labels}"/>&nbsp;</td>
						<td class='fields'><input type=checkbox name='stockyn' id='stockyn' value="Y" <%=checkAttribute4%> <%=otherAttribute%> <%=Stock%>></td>
						<td  width='25%' class=label><fmt:message key="Common.Sale.label" bundle="${common_labels}"/>&nbsp;</td>
						<td class='fields'><input type=checkbox name='saleyn' id='saleyn' value="Y" <%=checkAttribute3%> <%=otherAttribute%> <%=Sale%>></td>
						<td width='20%'>&nbsp;</td>
					</tr>
					<tr>
						<td  width='30%' class=label><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/>&nbsp;</td>
						<td class='fields'><input type=checkbox name='dosageyn' id='dosageyn' value="Y" <%=checkAttribute5%>  <%=otherAttribute%> <%=Dosage%>></td>
						<td  width='25%' class=label><fmt:message key="Common.Strength.label" bundle="${common_labels}"/>&nbsp;</td>
						<td class='fields'><input type=checkbox name='strengthyn' id='strengthyn' value="Y" <%=checkAttribute6%> <%=otherAttribute%> <%=dis%> <%=Strength%> onClick="Strength()"></td>
						<td  width='25%' class=label><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>&nbsp;</td>
						<td class='fields'><input type=checkbox name='quantityyn' id='quantityyn' value="Y" <%=checkAttribute2%> <%=otherAttribute%> <%=dis1%> <%=Quantity%> onClick="Quantity()"></td>
						<td width='20%'>&nbsp;</td>
					</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan='4'>&nbsp;</tr></td>
</table>

</table>

</div>
<%
	if(newSpeciality)
	{
%>
		<input type='hidden' name='function' id='function' value='insert'>
		<input type='hidden' name='function_name' id='function_name' value='insert'>

<%  }
  	else
	{
%>
		<input type='hidden' name='function' id='function' value='modify'>
		<input type='hidden' name='function_name' id='function_name' value='modify'>
<%
	}

%>		<input type="hidden" name="purchase" id="purchase" value="">
		<input type="hidden" name="stock" id="stock" value="">
		<input type="hidden" name="sale" id="sale" value="">
		<input type="hidden" name="dosage" id="dosage" value="">
		<input type="hidden" name="quantity" id="quantity" value="">
		<input type="hidden" name="strength" id="strength" value="">
</form>
</body>
</html>

