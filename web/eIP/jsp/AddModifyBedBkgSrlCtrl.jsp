<!DOCTYPE html>
<!---/**** Master to Maintain the Bed Booking Serial Control ********/-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% 
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function checkNum()  
{
	if(document.forms[0].function_name.value=='insert')
	{
		var nxt = eval(document.forms[0].nxt_srl_no.value);
		var max = eval(document.forms[0].max_srl_no.value);
		if(max < nxt)
		{
			alert(parent.parent.parent.frames[0].getMessage("INVALID_NEXT_NUMBER","Common"));
			document.forms[0].max_srl_no.focus();
			return false;
		}
	}
	else if	(document.forms[0].function_name.value=='modify')
	{
		var nxt = eval(document.forms[0].max_srl_no.value);
		var prev_max = eval(document.forms[0].prev_max_srlno.value);
		
		if(prev_max > nxt)
		{
			alert(getMessage("MAX_NOT_LT_PREV_MAX","IP"));	
			document.forms[0].max_srl_no.focus();
			return false;
		}
	}
}

function zeroNotAllowed(obj)
{
	if(obj.value!="")
	{
		if(obj.value==0)
		{
			alert(getMessage("IP_VAL_NOT_LESS_ZERO","IP"));
			obj.value="";
			obj.focus();
		}
	}
}

function Change() 
{      
	document.bedbkg_form.nxt_srl_no.value='';	
	document.bedbkg_form.max_srl_no.value='';	

	 if (document.bedbkg_form.gen_srl_num.checked)
	 { 
		 document.bedbkg_form.mand1.style.visibility='visible';
		 document.bedbkg_form.mand2.style.visibility='visible';
		 document.bedbkg_form.nxt_srl_no.readOnly=false;	
		 document.bedbkg_form.max_srl_no.readOnly=false;	
		 document.bedbkg_form.gen_srl_num.value="Y";
	 }	 
	 else
	 {
		 document.bedbkg_form.mand1.style.visibility='hidden';
		 document.bedbkg_form.mand2.style.visibility='hidden';
		 document.bedbkg_form.gen_srl_num.value="N";
		 document.bedbkg_form.nxt_srl_no.readOnly=true;	
		 document.bedbkg_form.max_srl_no.readOnly=true;	
	 }	 
}

function ChkVal(obj)
{
	var val= obj.value;

	if ( eval(document.bedbkg_form.max_srl_no.value)  < eval(document.bedbkg_form.nxt_srl_no.value))
	{
		alert(getMessage("NEXT_NUM_GR_MAX_NUM","Common"));
		return false;
	}
	else
		return true;
}

function ChkGenSrlNo()
{    
	if ((document.bedbkg_form.gen_srl_num.value = "")||(document.bedbkg_form.gen_srl_num.value = "null" ))
	{        
		document.bedbkg_form.nxt_srl_no.readOnly=true;	
		document.bedbkg_form.max_srl_no.readOnly=true;	
	}     
}   

function focusTxt()
{
	document.bedbkg_form.booking_type.focus();
}	       

function ChkNumInput(fld, e, deci)
{
if (parseInt(deci)>0)   
   var strCheck = '0123456789';
	
var whichCode = (window.Event) ? e.which : e.keyCode;
if (whichCode == 13) return true;  // Enter

key = String.fromCharCode(whichCode);  // Get key value from key code

if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

if(key == "." && fld.value.indexOf(key) != -1) return false; // Not more than one '.' char

}
function validSplchars1(obj)
{	
	var val = obj.value.toUpperCase();			
	obj.value = val;	
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]="Serial No";
	if(SpecialCharCheck( fields, names,'',"A",''))
	{
		return true;
	}
	else
	{
		obj.select();
		obj.focus();
		return false;
	}
}
</script>
</head>
<% 
	boolean NewBedBkg    = true;
	String function_name="";
//	String otherTextAttribute1="";
//	String checkBoxAttribute1="";
//	String gen_srl_num="";
	String booking_type="";
	String nxt_srl_no="";
	String max_srl_no="";
	String sql;
//	String disabledAttrib="";
	String nxtsrlnoVal="";
	
	String facilityID=(String)session.getValue("facility_id");
	function_name= request.getParameter("function_name");
	booking_type = request.getParameter("booking_type");
	if(booking_type != null)
		function_name = "modify";
	else	
		function_name = "insert";

	Connection conn = null;
	Statement stmt=null;
	ResultSet rset=null;
	PreparedStatement pstmt = null;
	
	if(booking_type!=null)	
	{
		facilityID=(String)session.getValue("facility_id");
		try
		{
			conn = ConnectionManager.getConnection(request);
			stmt = conn.createStatement();
			sql = " select booking_type,gen_booking_srl_yn,next_booking_srl_no,max_booking_srl_no from ip_bed_booking_srl_ctrl where booking_type= ? and facility_id=?  ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, booking_type);
			pstmt.setString(2, facilityID);
			rset = pstmt.executeQuery();
/* 			rset = stmt.executeQuery(sql); */
			rset.next();

//			gen_srl_num= "Y";

			nxt_srl_no= rset.getString("next_booking_srl_no");
				if(nxt_srl_no == null )	nxt_srl_no="";


			if ((nxt_srl_no!=null)||(nxt_srl_no!=""))
				nxtsrlnoVal="READONLY";		 
			else
				nxtsrlnoVal="";

			max_srl_no = rset.getString("max_booking_srl_no");
				if(max_srl_no==null) max_srl_no="";

			if(rset!=null)    rset.close();
			if(stmt!=null)    stmt.close();
			if(pstmt!=null)    pstmt.close();

		}catch(Exception e){
			//e.toString();
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(conn,request);
		}

		NewBedBkg=false;
	}
%>	
	
	<form name='bedbkg_form' id='bedbkg_form' action='../../servlet/eIP.BedBkgSrlCtrlServlet' method='post' target='messageFrame'> 
	
<%if(function_name.equals("modify"))
	{%>
	<body onLoad='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%}else{%><body onLoad='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()"'><%}%>
	<div>
	<br><br><br><br><br><br>
	<table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
	<tr>
	   <td width='10%'>&nbsp;</td>
	   <td>&nbsp;</td>
	   <td>&nbsp;</td>
	   <td width='10%'>&nbsp;</td>
	</tr>

<%	
     
    if(booking_type!=null)	
	{
%>
	<tr>
	   <td>&nbsp;</td>
	   <td align='right'  class='label'><fmt:message key="eIP.BookingType.label" bundle="${ip_labels}"/></td>
	   <td >&nbsp;	   
<%	
	booking_type= request.getParameter("booking_type");
	
	 String booktypeval="";
		   
	if(booking_type.equals("B"))
		booktypeval= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockBed.label","ip_labels");
	if(booking_type.equals("D"))
		booktypeval= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockBedonDischarge.label","ip_labels");
	if(booking_type.equals("T"))
		booktypeval= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.PatientTransfer.label","ip_labels");
	
%>	   
		<input type= "text" name = "booking_type1" size='24' length='24'  value='<%=booktypeval%>' READONLY>
		<input type="hidden" value='<%=booking_type%>' name = "booking_type"><img src='../../eCommon/images/mandatory.gif'align='center'></img>
		</td>
		<td>&nbsp;</td>
	</tr>
<%         
	}
	else
	{
	
%>	<tr>
	   <td>&nbsp;</td>
	   <td align='right'  class='label'><fmt:message key="eIP.BookingType.label" bundle="${ip_labels}"/></td>
	   <td >&nbsp;&nbsp;
	   <select name='booking_type' id='booking_type' >&nbsp;
	   <option value=''>&nbsp;&nbsp;---&nbsp; <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---&nbsp;&nbsp;</option>
	   <option value='B'><fmt:message key="eIP.BlockBed.label" bundle="${ip_labels}"/>
	   <option value='D'><fmt:message key="eIP.BlockBedonDischarge.label" bundle="${ip_labels}"/>
	   <option value='T'><fmt:message key="eIP.PatientTransfer.label" bundle="${ip_labels}"/>
	   </select><img src='../../eCommon/images/mandatory.gif'align='center'></img>
	   </td>
	   <td>&nbsp;</td>
	</tr>
<%
	}
%>
	<tr>
	   <td>&nbsp;</td>
	   <td>&nbsp;</td>
	   <td>&nbsp;</td>
	   <td>&nbsp;</td>
	</tr>

	<br><br>
	
	<tr><td colspan='4' CLASS='BODYCOLORFILLED'>&nbsp</td></tr>
	<tr>
	    <tr><th colspan='4' align='left' class='BODYCOLORFILLED'><fmt:message key="eIP.BookingSerialDetails.label" bundle="${ip_labels}"/></th></tr>
	</tr>	

	<tr>
	   <td>&nbsp;</td>
	   <td>&nbsp;</td>
	   <td>&nbsp;</td>
	   <td>&nbsp;</td>
       </tr>
         <input type='hidden' name='gen_srl_num' id='gen_srl_num' value='Y'>
	<tr>
	   <td>&nbsp;</td>
	   <td>&nbsp;</td>
	   <td>&nbsp;</td>
	   <td>&nbsp;</td>
	</tr>
	<tr>
	   <td>&nbsp;</td>
	   <%
			String rdOnlyNext="";
			if(function_name.equals("modify"))
				rdOnlyNext="readonly";
	   %>
	   <td  align='right' class='label'><fmt:message key="Common.nextsrlno.label" bundle="${common_labels}"/></td>
	   <td>&nbsp;&nbsp;
			<input type='text' name='nxt_srl_no' id='nxt_srl_no' value='<%=nxt_srl_no%>' <%=nxtsrlnoVal%>  size='6' maxlength='6' onKeyPress='return(ChkNumInput(this,event,2))' <%=rdOnlyNext%> onblur="return validSplchars1(this);zeroNotAllowed(this);"><img src='../../eCommon/images/mandatory.gif'align='center' ></img>
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
	   <td  align='right' class='label'><fmt:message key="Common.maxserialno.label" bundle="${common_labels}"/></td>
	   <td>&nbsp;&nbsp;
			<input type='text' name='max_srl_no' id='max_srl_no' value='<%=max_srl_no%>'  size='6' maxlength='6'  onKeyPress='return(ChkNumInput(this,event,2))' onblur="return validSplchars1(this);zeroNotAllowed(this);checkNum();"><img src='../../eCommon/images/mandatory.gif'align='center' ></img>
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
           <td  align='right' class='label'></td>
           <td  align='left' class='label'>&nbsp;&nbsp;</td>
           <td>&nbsp;</td>
        </tr>
 </table>

 </div>
 	   <input type='hidden' name='facility_id' id='facility_id' value='<%=facilityID%>' >
	   <input type='hidden' name='prev_max_srlno' id='prev_max_srlno' value='<%=max_srl_no%>'>
<%  if(NewBedBkg)
	{	%>
		<input type='hidden' name='function' id='function' value='insert'>
		<input type='hidden' name='function_name' id='function_name' value='insert'>
		<input type='hidden' name='eff_status' id='eff_status' value='E'>
<%	 }
	 else
	 {	%>	
		<input type='hidden' name='function' id='function' value='modify'>
		<input type='hidden' name='eff_status' id='eff_status' value='E'>
		<input type='hidden' name='function_name' id='function_name' value='modify'>
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facilityID%>' >
<%	}	%>

</form>
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

