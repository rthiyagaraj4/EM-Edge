<!DOCTYPE html>
<!-- 
Sr No        Version           Incident             SCF/CRF             Developer Name
--------------------------------------------------------------------------------------
1		     V210730           16777	      PMG2021-COMN-CRF-0076      Mohana Priya
 -->


<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*," contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser" />


<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = 	(String)session.getAttribute("LOCALE");
%>
<html>
<head>
<style>

body { font-family: sans-serif; }

#id_confrmdiv
{
    display: none;
    background-color: #eee;
    border-radius: 5px;
    border: 1px solid #aaa;
    position: fixed;
    width: 300px;
    left: 50%;
    margin-left: -150px;
    padding: 6px 8px 8px;
    box-sizing: border-box;
    text-align: center;
}

#id_confrmdiv button {
    background-color: #ccc;
    display: inline-block;
    border-radius: 3px;
    border: 1px solid #aaa;
    padding: 2px;
    text-align: center;
    width: 80px;
    cursor: pointer;
}

#id_confrmdiv .button:hover
{
    background-color: #ddd;
}

#confirmBox .message
{
    text-align: left;
    margin-bottom: 8px;
}

</style>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' /> 
	<link rel='stylesheet' type='text/css' href='../../eBL/images/style.css'></link>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language='javascript' src='../../eBL/js/json2.js'></script>
	
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eBL/js/MaintainTreamentPackage.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
    function doSomething(val){
		if(val=='1'){
			window.returnValue =true;
		}
		else{
			window.returnValue =false;
		}
			//window.returnValue =true;
			window.close();
			
	}	
	

/*
        document.getElementById('id_confrmdiv').style.display="block"; //this is the replace of this line

        document.getElementById('id_truebtn').onclick = function(){
           // Do your delete operation
            alert('true');
        };
        document.getElementById("id_falsebtn").onclick = function(){
             alert('false');
           return false;
        };
*/
    
</script>

	<%!private String checkForNull(String inputString) {
			return (inputString == null) ? "" : inputString;
		}%>
	<%
		//String patientId="004113"; //004113
		String params = request.getQueryString();
	System.out.println("params ::::::::::::::: "+params);
	String patient=checkForNull(request.getParameter("patid"));
	
	System.out.println("patient ::::::::::::::: "+patient);
	%>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
</head>

<body onKeyDown="lockKey();" onMouseDown="CodeArrest();"  onscroll='' onload="">

<center>
<table width="100%" border="0" cellspacing="0" cellpadding="4" class="BorderLight">
  <tr>
	<td colspan='2' style="text-align: center;">
		<font>Do you want to delete the record and recalculate</font>
	</td>
  </tr>
  <tr>
</tr>
  <tr>
</tr>
  <tr>
	<td class="label"  style="text-align: right;">
		<input type="button" class='Button' name="id_truebtn" id="id_truebtn" id="id_truebtn"  style="text-align: center;" value="Yes" onClick="doSomething(1)"  >
	</td> 
	<td class="label" style="text-align: left;">
		<input type="button" name="close_button" id="close_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")%>" class="button"  onClick="doSomething(2);" >
	</td>
  </tr>

  <!-- doSomething(2);
  
  <input type="button" class='Button' name="id_falsebtn" id="id_falsebtn" id="id_falsebtn" style="text-align: center;" value="No" onClick="window.close();"  >
		
  <tr>
	<td class="label" width="25%">
		<div id="id_confrmdiv">
			<input type="button" class='Button' name="id_truebtn" id="id_truebtn" id="id_truebtn"  style="text-align: center;" value="Yes" onClick="doSomething()"  >
			<input type="button" class='Button' name="id_falsebtn" id="id_falsebtn" id="id_falsebtn" style="text-align: center;" value="No" onClick="doSomething()"  >
		</div>
	</td> 
   </tr>
  
  
    <tr>
      <td class="pad4side Bg-yellow"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tbody>
          <tr>
            <td width="4%" rowspan="2"><img src="icon1.png" width="33" height="41" alt=""/></td>
            <td id='tdLin' nowrap class="BOLD">NARENDRA DAMODARDAS 67YRS 3M 14D 004113</td>
          </tr>
          <tr>
            <td>National ID: 33EE  Alt ID: </td>
          </tr>
        </tbody>
      </table></td>
    </tr>  
    <tr>
      <td class="pad4side"><table width="100%" border="0" cellspacing="0" cellpadding="4">
        <tr>
          <td class="CAGROUPHEADING">Package Details</td>
        </tr>
        </table>
        </td>
        </tr> 
 -->
        
    </table>
    </center>
    </body>
    </html>

