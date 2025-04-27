<!DOCTYPE html>
<%--
	FileName	: DiscrMeasureAddModify.jsp
	Version	    : 3	
	Modified On	: 22-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eAM/js/DiscrMeasure.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../js/DiscrMeasure.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>	
	
</head>

<body onLoad='FocusFirstElement();' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
   request.setCharacterEncoding("UTF-8");
   String code="";
   String longdesc="";
   String shortdesc="";
   String service="";
   String resulttype="";
   String referencerange = "";
   String numdigitsmax = "";
   String numdigitsmin = "";
   String numdigitsdec = "";
   String reflow = "";
   String refhigh = "";
   String criticallow = "";
   String criticalhigh = "";
   String uom = "";
   String def = "";
   String resulttemplateid = "";
   String effstatus = "";
   StringBuffer numericvalues =new StringBuffer();
   StringBuffer alphainfovalues =new StringBuffer();
   String resulttypecode[] = {"","C","G","D","E","A","F","L","N","Z","S","T","V"};
   String resulttypedesc[]={"&nbsp;----------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----------&nbsp;","Check Box",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ChartSection.label","am_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Formula.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.FreeText.label","am_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.List.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Numeric.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.PatientCarePanel.label","am_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Summary.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VitalSignsBattery.label","common_labels")};

   String sel = "";
   String rd = "";
   String allrd = "";
   String alldis = "";
   String chk = "checked";
   String mode = "insert";

   Connection con = null;
   Statement stmt=null;
   ResultSet rset=null;

   try
   {

    con = ConnectionManager.getConnection(request);
    stmt=con.createStatement();
	code=request.getParameter("discr_msr_id")==null?"":request.getParameter("discr_msr_id");
	String sql = " SELECT DISCR_MSR_ID,LONG_DESC,SHORT_DESC,SERVICE_CODE,RESULT_TYPE,NUM_DIGITS_MAX,NUM_DIGITS_MIN,RESULT_TEMPLATE_ID,NUM_DIGITS_DEC,REF_RANGE_TYPE,EFF_STATUS FROM AM_DISCR_MSR where DISCR_MSR_ID='"+code+"'";
	rset = stmt.executeQuery(sql);
	if(rset.next())
	{
		rd = "readonly";
		mode = "modify";
		longdesc = rset.getString("LONG_DESC");
		shortdesc=rset.getString("SHORT_DESC");
		service = rset.getString("SERVICE_CODE");
		resulttype = rset.getString("RESULT_TYPE");
		effstatus = rset.getString("EFF_STATUS");
		if(effstatus.equals("E")) chk = "checked"; else { chk=""; allrd = " readonly "; alldis = " disabled "; }

		if(resulttype.equals("N"))
		{
			referencerange = rset.getString("REF_RANGE_TYPE")==null?"":rset.getString("REF_RANGE_TYPE");
			numdigitsmax = rset.getString("NUM_DIGITS_MAX")==null?"":rset.getString("NUM_DIGITS_MAX");
			numdigitsmin = rset.getString("NUM_DIGITS_MIN")==null?"":rset.getString("NUM_DIGITS_MIN");
			numdigitsdec = rset.getString("NUM_DIGITS_DEC")==null?"":rset.getString("NUM_DIGITS_DEC");

			Statement stmt1=con.createStatement();
			ResultSet rset1=null;
			
			String sqlnum = " Select REF_RANGE_SEQ,decode(PATIENT_SEX,'A','All','M','Male','F','Female','U','Unknown') PATIENT_SEX,START_AGE,decode(START_AGE_UNITS,'D','Days','M','Months','Y','Years') START_AGE_UNITS,END_AGE,decode(END_AGE_UNITS ,'D','Days','M','Months','Y','Years') END_AGE_UNITS ,NUM_REF_LOW,NUM_REF_HIGH,NUM_CRIT_LOW,NUM_CRIT_HIGH,NUM_UOM,NUM_DFLT_RESULT from AM_DISCR_MSR_REF_RNG_NUM where DISCR_MSR_ID = '"+code+"' " ;
			rset1 = stmt1.executeQuery(sqlnum);
			while(rset1.next())
			{
				if(referencerange.equals("M"))
				{
					numericvalues.append(rset1.getString("PATIENT_SEX")+"~"+rset1.getString("START_AGE")+"~"+rset1.getString("START_AGE_UNITS")+"~"+rset1.getString("END_AGE")+"~"+rset1.getString("END_AGE_UNITS")+"~"+rset1.getString("REF_RANGE_SEQ")+"~"+rset1.getString("NUM_REF_LOW")+"~"+rset1.getString("NUM_REF_HIGH")+"~"+rset1.getString("NUM_CRIT_LOW")+"~"+rset1.getString("NUM_CRIT_HIGH")+"~"+rset1.getString("NUM_UOM")+"~"+rset1.getString("NUM_DFLT_RESULT")+"~"+"N"+"`");
				}
				else
				{
					reflow = rset1.getString("NUM_REF_LOW")==null?"":rset1.getString("NUM_REF_LOW");         
					refhigh = rset1.getString("NUM_REF_HIGH")==null?"":rset1.getString("NUM_REF_HIGH");        
					criticallow = rset1.getString("NUM_CRIT_LOW")==null?"":rset1.getString("NUM_CRIT_LOW");  
					criticalhigh = rset1.getString("NUM_CRIT_HIGH")==null?"":rset1.getString("NUM_CRIT_HIGH");
					uom = rset1.getString("NUM_UOM")==null?"":rset1.getString("NUM_UOM");            
					def = rset1.getString("NUM_DFLT_RESULT")==null?"":rset1.getString("NUM_DFLT_RESULT");               
					if(def.equals("0")) def="";
				}
			}
			
			if(stmt1!=null)  stmt1.close();
			if(rset1!=null) rset1.close();
		}
		else if(resulttype.equals("F"))
			resulttemplateid = rset.getString("RESULT_TEMPLATE_ID")==null?"":rset.getString("RESULT_TEMPLATE_ID");
		else if(resulttype.equals("L"))
		{
			Statement stmt1=con.createStatement();
			ResultSet rset1=null;
			
			String sqlalpha = " SELECT REF_RANGE_SEQ,SORT_ORDER,REF_RNG_DESC,RESULT_VALUE,DFLT_YN,NUMERIC_VALUE FROM AM_DISCR_MSR_REF_RNG_LIST WHERE DISCR_MSR_ID = '"+code+"' order by SORT_ORDER " ;
			rset1 = stmt1.executeQuery(sqlalpha);
			while(rset1.next())
			{
				alphainfovalues.append(rset1.getString("REF_RANGE_SEQ")+"~"+rset1.getString("REF_RNG_DESC")+"~"+rset1.getString("RESULT_VALUE")+"~"+rset1.getString("NUMERIC_VALUE")+"~"+rset1.getString("SORT_ORDER")+"~"+rset1.getString("DFLT_YN")+"`");
			}
			if(stmt1!=null)  stmt1.close();
			if(rset1!=null) rset1.close();
		}
	}
		

%>

<form name='DiscrMeasure_form' id='DiscrMeasure_form' action='../../servlet/eAM.DiscrMeasureServlet' method='post' target='messageFrame'>

<table border='0' cellpadding='0' cellspacing='0' width='80%' align='center'>
<br><br>
<tr>
	<td align='right'  class='label' width="40%"><fmt:message key="eAM.Discrete.label" bundle="${am_labels}"/> <fmt:message key="eAM.MeasureID.label" bundle="${am_labels}"/></td>
	<td>&nbsp;&nbsp;
	<input type='text' name="discr_measure_id" id="discr_measure_id" value="<%=code%>" onKeyPress="return CheckForSpecChars(event)"   <%=rd%> size='10' maxlength='10' onBlur="ChangeUpperCase(this)">
	<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
</tr>

<tr>
	<td  align='right' class='label' ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td  align='left'>&nbsp;&nbsp;
	<input type='text'  name='long_desc' id='long_desc' value="<%=longdesc%>" "<%=allrd%>" size="30" maxlength="30" onBlur="makeValidString(this)" >
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

<tr>
	<td  align='right' class='label' ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td  align='left'>&nbsp;&nbsp;
	<input type='text'  name='short_desc' id='short_desc' value="<%=shortdesc%>" "<%=allrd%>" size="15" maxlength="15"  onBlur="makeValidString(this)" >
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

<tr>
	 <td align='right' class='label'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
	<td>&nbsp;&nbsp;
		<select name="service" id="service" "<%=alldis%>">
			<option value=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
			<%
				String servicesql = " select service_code, SHORT_DESC from am_service where EFF_STATUS = 'E' order by 2 ";
				stmt=con.createStatement();
				rset = stmt.executeQuery(servicesql);
				while(rset.next())
				 {
					if(service.equals(rset.getString("service_code")))
						sel = "selected";
					else
						sel = "";
					out.println("<option value='"+rset.getString("service_code")+"' "+sel+">"+rset.getString("SHORT_DESC")+"");
				 }
                 if(rset!=null) 	rset.close();
	             if(stmt!=null) 	stmt.close();
			%>
		</select>
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

<tr>
	 <td align='right' class='label'><fmt:message key="Common.ResultType.label" bundle="${common_labels}"/></td>
	 <td  align='left'>&nbsp;&nbsp;
	<%
			if(mode.equals("modify"))
		   {
				for(int k=0;k<resulttypecode.length;k++)
				{
					if(resulttypecode[k].equals(resulttype))
						sel = resulttypedesc[k];
				}
				out.println("<input type='text' name='result_type_desc' id='result_type_desc' value='"+sel+"' readonly>");
				out.println("<input type='hidden' name='result_type' id='result_type' value='"+resulttype+"'>");
		   }
		   else
		   {
	%>
	 <select name='result_type' id='result_type' onChange="showHideFields(this.value,'Y')">
		<%
				for(int k=0;k<resulttypecode.length;k++)
				{
					if(resulttypecode[k].equals(resulttype))
						sel = "selected";
					else
						sel = "";
					out.println("<option value='"+resulttypecode[k]+"' "+sel+">"+resulttypedesc[k]);
				}
		%>
	 </select>
	 <img src='../../eCommon/images/mandatory.gif'></img>&nbsp;&nbsp;
	<%
		   }
	%>
	 <input type="button" class="button" id="alpha_info" value="Alpha Info" "<%=alldis%>" onClick="getAlphaInfo()">
	 </td>
</tr>

<tr>
	<td align='right' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td  align='left'>&nbsp;
		<input type="checkbox" name="eff_status" id="eff_status" value="E" <%=chk%>>
	</td>
</tr>

<tr id="free_text">
	<td align='right' class='label'><fmt:message key="eAM.FreeTextTemplate.label" bundle="${am_labels}"/></td>
	<td>&nbsp;&nbsp;
		<select name="free_text_template" id="free_text_template" "<%=alldis%>">
		<option value=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------- 
		<%
			String tempsql = "select result_template_id,result_template_name from am_result_template where eff_status='E' order by result_template_name ";
			stmt=con.createStatement();
			rset = stmt.executeQuery(tempsql);
			while(rset.next())
			 {
				if(rset.getString("result_template_id").equals(resulttemplateid))
					sel = "selected";
				else
					sel = "";
				out.println("<option value='"+rset.getString("result_template_id")+"' "+sel+">"+rset.getString("result_template_name")+"");
			 }
			 if(rset!=null) 	rset.close();
	         if(stmt!=null) 	stmt.close();
		%>
		</select>
	</td>
</tr>

<tr id="tr1">
	<td align='right' class='label'><fmt:message key="eAM.NumericMapDigits.label" bundle="${am_labels}"/></td>
	<td class='fields'>
		&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Max.label" bundle="${common_labels}"/>&nbsp;<input type="text" name="max" id="max" "<%=allrd%>" value="<%=numdigitsmax%>" maxlength="1" size="1" onKeyPress='return(ChkNumberInput(this,event,0))'   OnBlur="CheckPositiveNumberLocal(this)">

		&nbsp;&nbsp;&nbsp;<fmt:message key="Common.MIN.label" bundle="${common_labels}"/>&nbsp;<input type="text" name="min" id="min" "<%=allrd%>" value="<%=numdigitsmin%>" maxlength="1" size="1" onKeyPress='return(ChkNumberInput(this,event,0))'
		OnBlur="CheckPositiveNumberLocal(this);validateMinmax(this);" > 

		&nbsp;&nbsp;&nbsp;<fmt:message key="Common.DecimalNumeric.label" bundle="${common_labels}"/>&nbsp;<input type="text" name="decimal" id="decimal" "<%=allrd%>" value="<%=numdigitsdec%>" maxlength="2" size="2" onKeyPress='return(ChkNumberInput(this,event,0))' OnBlur="validateDeci(this)">
	</td>
</tr>

<tr id="tr2"><td align='right' class='label'><fmt:message key="eAM.ReferenceRanges.label" bundle="${am_labels}"/></td>
	<td>&nbsp;&nbsp;
	 
		<%
			if(mode.equals("modify"))
		   {
				if(referencerange.equals("S")) sel = "Single";
				else if(referencerange.equals("M")) sel = "Multiple";
				out.println("<input type='text' name='ref_ranges_desc' id='ref_ranges_desc' value='"+sel+"' readonly>");
				out.println("<input type='hidden' name='ref_ranges' id='ref_ranges' value='"+referencerange+"'>");
			}
			else
		   {
		%>
		<select name='ref_ranges' id='ref_ranges' onChange="setNumericFields(this.value)">
			<option value='S'><fmt:message key="Common.single.label" bundle="${common_labels}"/>
			<option value='M'><fmt:message key="Common.multiple.label" bundle="${common_labels}"/>
		</select>
		<%}%>
		<input type="button" class="button" name="numeric_details" id="numeric_details" value="Numeric Details" "<%=alldis%>" onClick="showNumericDetails()">
	</td>
</tr>

<tr id="tr3">
	<td align='right'>&nbsp;</td>
	<td class='fields'>
		&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Low.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<fmt:message key="Common.High.label" bundle="${common_labels}"/>
	</td>
</tr>

<tr id="tr4">
	<td align='right' class='label'><fmt:message key="eMP.Reference.label" bundle="${mp_labels}"/></td>
	<td>
		&nbsp;&nbsp;&nbsp;<input type="text" "<%=allrd%>"  value="<%=reflow%>" name="ref_low" id="ref_low"  size="3" onBlur="validateNumber(this)">
		&nbsp;&nbsp;&nbsp;<input type="text" "<%=allrd%>" value="<%=refhigh%>" name="ref_high" id="ref_high" size="3" onBlur="validateNumber(this)"> 
	</td>
</tr>

<tr id="tr5">
	<td align='right' class='label'><fmt:message key="Common.Critical.label" bundle="${common_labels}"/></td>
	<td>
		&nbsp;&nbsp;&nbsp;<input type="text" "<%=allrd%>" value="<%=criticallow%>" name="critical_low" size="3" onBlur="validateNumber(this)">
		&nbsp;&nbsp;&nbsp;<input type="text" "<%=allrd%>" value="<%=criticalhigh%>" name="critical_high" size="3" onBlur="validateNumber(this)"> 
	</td>
</tr>

<tr id="tr6">
	<td align='right' class='label'><fmt:message key="Common.UnitofMeasure.label" bundle="${common_labels}"/></td>
	<td>&nbsp;&nbsp;&nbsp;<input type="text" "<%=allrd%>" value="<%=uom%>" name="unit_of_measure" id="unit_of_measure" maxlength="10" size="10"></td>
</tr>

<tr id="tr7">
	<td align='right' class='label'><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
	<td>&nbsp;&nbsp;&nbsp;<input type="text" "<%=allrd%>" value="<%=def%>" name="default_val" id="default_val" size="3" onBlur="validateNumber(this)"></td>
</tr>
</table>

<input type='hidden' name='mode' id='mode' value="<%=mode%>">
<input type='hidden' name='alpha_info_values' id='alpha_info_values' value="<%=alphainfovalues%>">
<input type='hidden' name='numeric_details_values' id='numeric_details_values' value="<%=numericvalues.toString()%>">
<%
	if(mode.equals("modify"))
		out.println("<script>showHideFields('"+resulttype+"','N');setNumericFields('"+referencerange+"')</script>");
	else
		out.println("<script>initFields();</script>");
}
catch(Exception e)
{
	out.println(e.toString());
}	
finally
{
	try
	{
	if(rset!=null) 	rset.close();
	if(stmt!=null) 	stmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	ConnectionManager.returnConnection(con,request);
}
%>

</form>
</body>
</html>

