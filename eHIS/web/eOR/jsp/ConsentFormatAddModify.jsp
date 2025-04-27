
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
-----------------------------------------------------------------------
Date			Edit History	Name        Description
-----------------------------------------------------------------------
?				100         	?     		created	
05/07/2012		IN029935      	Akbar S	 	Add NPB Request Form in query 
09/11/2012		IN030473		Ramesh G	Bru-HIMS-CRF-032 	
27/11/2012		IN036454		Ramesh G	1. Patient Instructions for Intervention is left blank->Apply->The Previous Instructions for Intervention  is saved
											2. Special Characters are allowed in Instruction Description, but we get message as Special characters not allowed
 								 
-----------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %> 
<%-- JSP Page specific attributes end --%>   

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085		
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ConsentFormat.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
  function putSometexttoClipBoard()
  {
	  //var text = window.clipboardData.getData("Text");
	  var text = "";
	  if(window.clipboardData && window.clipboardData.getData){
		  text = window.clipboardData.getData("Text");
	  }
	  if(text == "" || text == null)
	  {
		/* if(document.getElementById("clipTxtBtn")!=null)
		{
			var clipBoardVal=document.getElementById("clipTxtBtn").createTextRange();
			clipBoardVal.select(); 
			clipBoardVal.execCommand("copy","","");
			clipBoardVal.execCommand("Unselect","","");
		}
	  }*/
	  var clipBoardVal=document.getElementById("clipTxtBtn");
	  if (clipBoardVal != null) {
          /*clipBoardVal.select();
          try {
              var successful = document.execCommand("copy");
              if (successful) {
                  text = clipBoardVal.value;
                  clipBoardVal.setSelectionRange(0, 0);
              } else {
                  console.error('Copy command was unsuccessful');
              }
          } catch (err) {
              console.error('Failed to execute copy command: ', err);
          }
      }
  } */
  try {
      // Create a temporary textarea element
      var tempTextArea = document.createElement("textarea");
      tempTextArea.style.position = "fixed";
      tempTextArea.style.opacity = 0;
      tempTextArea.value = clipBoardVal.value;
      document.body.appendChild(tempTextArea);

      // Select and copy the text
      tempTextArea.select();
      document.execCommand("copy");

      // Remove the temporary textarea
      document.body.removeChild(tempTextArea);
  } catch (err) {
      console.error('Failed to execute copy command: ', err);
  }
}
}

	  FocusFirstElement();
  }
</script> 

</head>
<body onload='putSometexttoClipBoard()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" align='center'>

<%
	
	String readOnly = "" ;
	String readOnlyID = "";
	String checked = " checked ";
	String disabled	= "";
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_consent_format" ;
	String bean_name = "eOR.ConsentFormat";
	String style_auto= "display:none";
	//String style_auto="dispaly:inline";
 
	
 	String consent_type = request.getParameter("consent_type");
	String consent_form_id  = request.getParameter("consent_form_id");
	String consent_format   = request.getParameter("consent_format");
 	String effective_status = request.getParameter("effective_status"); 
	String consent_form_label = request.getParameter("consent_form_label");
	String test_status			= request.getParameter("test_status");
	
	// Consent changes - Murthy - 03-05-2007
	String index_value = request.getParameter("indexed");
	String index_checked = "unchecked";

	if(consent_format==null || consent_format=="null") consent_format = "";
	if(effective_status==null) effective_status = "D";
	if(consent_form_label==null) consent_form_label = "";
	if(consent_form_id==null) consent_form_id = "";
	if(consent_type==null) consent_type = "";
	


	//String Consent_form_label="";
	//IN029935 change starts
	//String valSourceLevel[] = {"C","R","Z"};
	//String descsourceLevel[] = {"Consent Form" , "Refusal Form","Referral Form"};
	// IN030473 Start.
	//String valSourceLevel[] = {"C","R","Z","N"};
	//String descsourceLevel[] = {"Consent Form" , "Refusal Form","Referral Form","NPB Request Form"};
	
	String valSourceLevel[] = {"C","I","R","Z","N"};
	String descsourceLevel[] = {"Consent Form","Patient Instructions for Interventions","Refusal Form","Referral Form","NPB Request Form"};
	
	// IN030473 End.
	//IN029935 change ends
	
/* Mandatory checks end */

	/* Initialize Function specific start */
 	ConsentFormat bean = (ConsentFormat)getBeanObject( bean_id, bean_name, request ) ; 

 	if(consent_type==null || consent_type.equals("")) { // First time entering clear, or in modify mode clear not when coming from the editor
		bean.clear() ;
	}
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setMode( mode ) ;
/* Initialize Function specific end */

	if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		try{
		//String consent_form_id			=	request.getParameter( "consent_form_id" ) ;
		//String consent_form_content		=	"";
		//System.out.println("consent_format==="+consent_format);
		
		consent_form_id = consent_form_id.trim();
		bean.setId(consent_form_id);
		String str[] = (String[])bean.getDescription(consent_form_id);
		//System.out.println("str[4]==="+str[4]);
		//System.out.println("str[0]==="+str[0]);
		String eff_status = str[1].trim();
 		if(consent_format.equals("")) {
 			consent_format = str[4];
		}
 		if(consent_format==null) consent_format="P";
		if(test_status==null || test_status.equals(""))
			bean.setDesc( str[0]);
		
		//consent_format!=null && !consent_format.equals("E") &&
		if( str[0]!=null){
			if(test_status==null || test_status.equals(""))
				bean.setDesc( str[0]);
		}
		bean.setEffectiveStatus( str[1].trim());
		consent_type = str[2];
		if(str[3]!=null)
			str[3] = str[3].trim();
		else 
			str[3] = "";	
		    if(!consent_form_label.trim().equals(""))
			{
				bean.setConsentFormLabel(java.net.URLEncoder.encode(consent_form_label.trim(),"UTF-8"));
			}
			else
			{
				bean.setConsentFormLabel(java.net.URLEncoder.encode(str[3],"UTF-8"));
			}
		
		if(str[5]!=null)
			str[5] = str[5].trim();
		else
			str[5] = "";
		
		if(index_value!=null)
		{
			bean.setIndexed(index_value);
		}
		else
		{
			bean.setIndexed(str[5]);
		}
			//System.out.println("=============encoded=============="+java.net.URLEncoder.encode(str[3],"UTF-8"));
			//if(consent_format!=null && consent_format.equals("E") && str[0]!=null && bean.getConsentValues().equals("")){

		if(str[0]!=null && bean.getConsentValues().equals("")){
			bean.setConsentValues(str[0]);
		}
		consent_form_id		= bean.getId();			
		//java.net.URLDecoder.decode(line_narration,"UTF-8")
		consent_form_label	=java.net.URLDecoder.decode(bean.getConsentFormLabel(),"UTF-8");
		index_value		= bean.getIndexed();
		if(index_value.equals("Y"))
		 index_checked = "checked";

		readOnlyID = "readonly";
		if(eff_status.equals("D")){
			readOnly = "readonly" ;
			checked = "";
			disabled = "DISABLED";
		}else{
			readOnly = "";
			checked = "checked";
			disabled = "";
		}
		if(consent_format!=null && consent_format.equals("E")) {
			disabled = "DISABLED";  //then disabled the list box 
		}
		
		str=null;

		}catch(Exception e){
			//out.println("Exception here :"+e);//common-icn-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
	} else {
		if(consent_format!=null && consent_format.equals("E")) {
			disabled = "DISABLED";  //then disabled the list box 
		}
	}

	if(index_value==null) index_value = "N";

	if(index_value.equals("Y"))
	 index_checked = "checked";
%>


<form name="consent_format" id="consent_format" method="post" target="messageFrame">

<table align='center' cellpadding=3 cellspacing=0 border=0 width="100%" > 
 <%
	if(consent_format==null || !consent_format.equals("P")) { 
%>
		
<%	} %>
	<!--<tr>
		<td width="15%" ></td>
		<td width="80%"  colspan=""></td>
		<td></td>
	</tr>--> 
	<input type='button' name='clipTxtBtn' id='clipTxtBtn' style='display:none' value='Clip Text'>
	<tr><td class='label'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td> 
		<td class='fields'>
		<%
		 if(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")))
		 {
			 %>
		<input type=text readonly size="15" value="<%=eHISFormatter.chkReturn(valSourceLevel,consent_type,descsourceLevel,"")%>">
			<input type="hidden" name="consent_type" id="consent_type" value="<%=consent_type%>">
		<%
		 }
		else
		{
		%>
			<select name="consent_type" id="consent_type" onChange='selectformat()' onFocus='selecteditor()'>
			<option  value="C" <%if(consent_type==null || consent_type.equals("") || consent_type.equals("C")) { %> selected <% } %>><fmt:message key="Common.ConsentForm.label" bundle="${common_labels}"/></option>
			<!-- IN030473 Start. -->
			<option  value="I" <%if(consent_type!=null && consent_type.equals("I")) { %> selected <% } %>><fmt:message key="eOR.PatientInterventions.label" bundle="${or_labels}"/></option>
			<!-- IN030473 End. -->
			<option  value="R" <%if(consent_type!=null && consent_type.equals("R")) { %> selected <% } %>><fmt:message key="eOR.RefusalForm.label" bundle="${or_labels}"/></option>
			<option  value="Z" <%if(consent_type!=null && consent_type.equals("Z")) { %> selected <% } %>><fmt:message key="eOR.ReferralForm.label" bundle="${or_labels}"/></option>
			<!-- IN029935 changes starts -->
			<option  value="N" <%if(consent_type!=null && consent_type.equals("N")) { %> selected <% } %>><fmt:message key="eOR.NPBRequestForm.label" bundle="${or_labels}"/></option>
			<!-- IN029935 changes ends-->
			
			</select>
 		<%
		}
		%>
		</td>
		
		
	</tr>
	<!--<tr>
		<td width="15%" ></td>
		<td width="80%"  colspan=""></td>
		<td></td>
	</tr>-->
	<tr>
		<td class="label"><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td> 
		<td><input class='fields' type=text name="consent_form_id" id="consent_form_id" size=10 maxlength=10  value="<%=consent_form_id%>"  <%=readOnlyID%>  onBlur='ChangeUpperCase(this);' onkeypress="return CheckForSpecChars(event);" ><img src="../../eCommon/images/mandatory.gif" align=center ></td>
		
	</tr>
	<!--<tr>
		<td width="15%" ></td>
		<td width="80%"  colspan=""></td>
		<td></td>
	</tr>-->	
	 <tr>
	<td class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td> 
		<!-- IN036454 Start.
		<td class='fields'><input type=text name="Consent_form_label" id="Consent_form_label" size=30 maxlength=30  value="<%= consent_form_label%>"  <%= readOnly%>  <%--onBlur='ChangeUpperCase(this);' onkeypress="return //CheckForSpecChars(event);"--%> OnBlur="makeValidString(this)"><img src="../../eCommon/images/mandatory.gif" align=center></td>  <!--onkeypress="return CheckForSpecChars(event);"-->
		<td class='fields'><input type=text name="Consent_form_label" id="Consent_form_label" size=30 maxlength=30  value="<%= consent_form_label%>"  <%= readOnly%>  onkeypress="return CheckForSpecChars(event);" OnBlur="makeValidString(this)"><img src="../../eCommon/images/mandatory.gif" align=center></td>
		<!-- IN036454 End. -->
	</tr>
	
	<tr>

 	<td class="label"><fmt:message key="eOR.Text Type.label" bundle="${or_labels}"/></td> 

		<td class='fields'><select name="consent_format" id="consent_format" onChange='check()' disabled>
		
		//onChange="openConsentEditor(this)"<%=disabled%>>
	
					<option value="P" <%if(consent_format==null ||  (consent_format.equals("") || consent_format.equals("P") || consent_type.equals("Z"))){
					//&& mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ))  %> selected <% }%>><fmt:message key="eOR.Plain.label" bundle="${or_labels}"/></option>
	
					<option value="E" <%if(consent_format!=null && (consent_format.equals("E") || consent_type.equals("R") || consent_type.equals("C") || consent_type.equals("N"))) { %> selected <% }%>><fmt:message key="eOR.Editor.label" bundle="${or_labels}"/></option>
			    </select>
			
				
			
<%			//&&  !bean.getConsentValues().equals("")
			if(consent_format!=null && consent_format.equals("E")
				|| !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")))) { %>
				<input type="button" class="button" name="editor" id="editor" value="E" id='notreferral' onClick="openConsentEditor(document.consent_format.consent_format)">
<%		}
					%>
		</td>
		
	</tr>
	<%

 			String strDesc = "";
			strDesc = (bean.getDesc()).replace('\"','\n');
			style_auto				= "display:inline";
		%>	
	<%
	if(consent_format!=null && !consent_format.equals("E") && (mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY"))))
	{//&& (mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY"))) ) {
%>
	
	

		
		<tr id='referralrow' style="<%=style_auto%>">
		<td  class="label"><fmt:message key="Common.Text.label" bundle="${common_labels}"/></td> 


		<td class='fields'><TEXTAREA  NAME="consent_form_text" ROWS="11" COLS="75"    <%=readOnly%> onBlur='makeValidString(this);'><%=strDesc%></TEXTAREA>
		</td>
	
	</tr>
		<%	} else 
		{
		style_auto				= "display:none";
		%>
			<tr id='referralrow' style="<%=style_auto%>">
		<td  class="label"><fmt:message key="Common.Text.label" bundle="${common_labels}"/></td> 


		<td class='fields'><TEXTAREA  NAME="consent_form_text" ROWS="11" COLS="75"    <%=readOnly%> onBlur='makeValidString(this);'><%=strDesc%></TEXTAREA>
		</td>
	
	</tr>
<%  } %>
	<!--<tr>
		<td width="15%" ></td>
		<td width="80%"  colspan=""></td>
		<td></td>
	</tr>-->
	<%
	
	if(consent_type!=null && !consent_type.equals("N") && !consent_type.equals("R") && !consent_type.equals("Z")) //IN029935
	{
%>
		<tr id='indexrow'>
		<td width='15%' align='right' class='label'><fmt:message key="eOR.Index.label" bundle="${or_labels}"/></td>
		<td><INPUT TYPE='CHECKBOX' name='indexed' id='indexed' VALUE='<%=index_value%>' <%=index_checked%> <%=readOnlyID%> onclick=' if(this.checked)
			this.value="Y";
		else
			this.value="N";'/></td>
		</tr>
<%	} else {%>
			<input type="hidden" name="indexed" id="indexed" value="">
<%  } %>
	<tr>
		<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td> 
		<td class='fields'><INPUT TYPE="checkbox" name="effective_status" id="effective_status" value="E" <%=checked%> ></td>

	</tr>
	<!--<tr>
		<td width="15%" ></td>
		<td width="80%"  colspan=""></td>
		<td></td>
	</tr>-->

</table>


<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">

<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">


</form>
</body>

</html>


<%

		putObjectInBean(bean_id,bean,request);
 
%>

