<!DOCTYPE html>
<%--
	FileName	: DiscrMeasureNumericAddModify.jsp
	Version	    : 3	
	Modified On	: 22-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eAM/js/DiscrMeasure.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../js/DiscrMeasure.js' language='javascript'></script>

	<script language="JavaScript">
	<!--
			function doSelect(val)
			{
				if(val == 'S')
				{
					if(validateRefCritical() == true)
					{
						if(document.getElementById('default_val').value=='') document.getElementById('default_val').value=0;
	
						if(document.getElementById('sex').value == '' || document.getElementById('start_age').value == '' || document.getElementById('start_units').value == '' || document.getElementById('end_age').value == '' || document.getElementById('end_units').value == '' || document.getElementById('seq_no').value == '' || document.getElementById('ref_low').value == '' || document.getElementById('ref_high').value == '' || document.getElementById('critical_low').value == '' || document.getElementById('critical_high').value == '' || document.getElementById('unit_of_measure').value == '' || document.getElementById('default_val').value == '' )
							alert(parent.getMessage('MANDATORY_FIELDS','AM'));
						else if(seqnoChk() == false)
						{
							alert(parent.getMessage('UNIQUE_SEQUENCE_NUM','AM'));
							document.getElementById('seq_no').select();
							document.getElementById('seq_no').focus();
						}
						else if(overlapChk() == '1')
						{
							alert(parent.getMessage('START_AGE_GREATER_END_AGE','AM'));
							document.getElementById('start_age').focus();
						}
						else if(overlapChk() == '2')
						{
							alert(parent.getMessage('AGE_RANGE_EXITS','AM'));
							document.getElementById('start_age').focus();
						}
						else
						{
							var prevconvals = parent.frames[0].document.getElementById('prev_con_vals').value;
							var convals = document.getElementById('sex').value+"~"+document.getElementById('start_age').value+"~"+document.getElementById('start_units').value+"~"+document.getElementById('end_age').value+"~"+document.getElementById('end_units').value+"~"+document.getElementById('seq_no').value+"~"+document.getElementById('ref_low').value+"~"+document.getElementById('ref_high').value+"~"+document.getElementById('critical_low').value+"~"+document.getElementById('critical_high').value+"~"+document.getElementById('unit_of_measure').value+"~"+document.getElementById('default_val').value+"~"+"I"+"`";
	//	alert(document.getElementById('mode').value);
							if(document.getElementById('mode').value == 'insert')
							{
								convals = prevconvals+convals+"`";
	//	alert(convals);
								parent.frames[0].location.href = '../../eAM/jsp/DiscrMeasureAlphaInfoResult.jsp?from=N&con_vals='+convals+'&max_min_dec='+document.getElementById('max_min_dec').value
								clearFields('N');
							}
							else
							{
								var rownum = document.getElementById('row_num').value;
								var obj = eval(parent.frames[0].document.getElementById('sex_'+rownum));
								obj.innerHTML= "<a href=\"javascript:showDetails('"+convals+"','"+rownum+"')\">"+document.getElementById('sex').value+"</a>";
								obj = eval(parent.frames[0].document.getElementById('startage_'+rownum));
								obj.innerText= document.getElementById('start_age').value;
								obj = eval(parent.frames[0].document.getElementById('startunits_'+rownum));
								obj.innerText= document.getElementById('start_units').value;
								obj = eval(parent.frames[0].document.getElementById('endage_'+rownum));
								obj.innerText= document.getElementById('end_age').value
								obj = eval(parent.frames[0].document.getElementById('endunits_'+rownum));
								obj.innerText= document.getElementById('end_units').value
								obj = eval(parent.frames[0].document.getElementById('seqno_'+rownum));
								obj.innerText= document.getElementById('seq_no').value
								obj = eval(parent.frames[0].document.getElementById('reflow_'+rownum));
								obj.innerText= document.getElementById('ref_low').value
								obj = eval(parent.frames[0].document.getElementById('refhigh_'+rownum));
								obj.innerText= document.getElementById('ref_high').value
								obj = eval(parent.frames[0].document.getElementById('criticallow_'+rownum));
								obj.innerText= document.getElementById('critical_low').value
								obj = eval(parent.frames[0].document.getElementById('criticalhigh_'+rownum));
								obj.innerText= document.getElementById('critical_high').value
								obj = eval(parent.frames[0].document.getElementById('uom_'+rownum));
								obj.innerText= document.getElementById('unit_of_measure').value
								obj = eval(parent.frames[0].document.getElementById('def_'+rownum));
								obj.value= document.getElementById('default_val').value
								clearFields('N');
							}
						}
					}
				}
				else if(val=='O')
				{
					var n = parent.frames[0].document.getElementById('total_rows').value;
					var retdata = '';
					for(var i=0;i<n;i++)
					{
						var temp = eval(parent.frames[0].document.getElementById('sex_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('startage_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('startunits_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('endage_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('endunits_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('seqno_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('reflow_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('refhigh_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('criticallow_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('criticalhigh_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('uom_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('def_'+i).value)+"~"+eval(parent.frames[0].document.getElementById('insertyn_'+i).value)+"`";
//alert(temp);
						retdata +=temp;
					}
					parent.window.returnValue = retdata;
					parent.window.close();
				}
				else if(val =='CL')
				{

					clearFields('Y');
					document.getElementById('sex').value = getLabel("Common.all.label",'Common');
					document.getElementById('start_age').value = '';
					document.getElementById('start_units').value = getLabel("Common.days.label",'Common');
					document.getElementById('end_age').value = '';
					document.getElementById('end_units').value = getLabel("Common.days.label",'Common');
					document.getElementById('seq_no').value = '';
					document.getElementById('ref_low').value = '';
					document.getElementById('ref_high').value = '';
					document.getElementById('critical_low').value = '';
					document.getElementById('critical_high').value = '';
					document.getElementById('unit_of_measure').value = '';
					document.getElementById('default_val').value = '';
					document.getElementById('mode').value = 'insert'
					document.getElementById('seq_no').readOnly = false;
				}
				else
				{
					parent.window.close();
				}
			}

			function validateRefCritical()
			{
				var reflow = eval(document.getElementById('ref_low').value)==null?0:eval(document.getElementById('ref_low').value);
				var refhigh = eval(document.getElementById('ref_high').value)==null?0:eval(document.getElementById('ref_high').value);
				var critlow = eval(document.getElementById('critical_low').value)==null?0:eval(document.getElementById('critical_low').value);
				var crithigh = eval(document.getElementById('critical_high').value)==null?0:eval(document.getElementById('critical_high').value);
				if(reflow!=0 && refhigh!=0 && reflow > refhigh)
				{
					alert(parent.getMessage('REF_LOW_NOT_GREATER_HIGH','AM'));
					document.getElementById('ref_high').select();
					document.getElementById('ref_high').focus();
					return false;
				}
				else if(critlow!=0 && crithigh!=0 && critlow > crithigh)
				{
					alert(parent.getMessage('CRITICAL_LOW_NOT_GREATER_HIGH','AM'));
					document.getElementById('critical_high').select();
					document.getElementById('critical_high').focus();
					return false;
				}
				else
				{
					if(critlow!=0 && reflow!=0 && critlow > reflow)
					{
						alert(parent.getMessage('CRITICAL_LOW_LESS_REF_LOW','AM'));
						document.getElementById('critical_low').select();
						document.getElementById('critical_low').focus();
						return false;
					}
					else if(crithigh!=0 && refhigh!=0 && crithigh < refhigh)
					{
						alert(parent.getMessage('CRITICAL_HIGH_GREATER_REF_HIGH','AM'));
						document.getElementById('critical_high').select();
						document.getElementById('critical_high').focus();
						return false;
					}
					else return true;
				}
			}

			function clearFields(rfresh)
			{
				if(document.getElementById('mode').value == 'modify' && rfresh =='Y')				
				{
					var rownum = eval(document.getElementById('row_num').value);
					parent.frames[0].document.getElementById('myTable').deleteRow(rownum+2) 
					var retdata = '';
					var n = eval(parent.frames[0].document.getElementById('total_rows').value);
					for(var i=0;i<n;i++)
					{
						if(rownum!=i)
						{
							var temp = eval(parent.frames[0].document.getElementById('sex_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('startage_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('startunits_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('endage_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('endunits_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('seqno_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('reflow_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('refhigh_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('criticallow_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('criticalhigh_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('uom_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('def_'+i).value)+"~"+eval(parent.frames[0].document.getElementById('insertyn_'+i).value)+"`";
							retdata +=temp;
						}
					}
					parent.frames[0].location.href = '../../eAM/jsp/DiscrMeasureAlphaInfoResult.jsp?from=N&con_vals='+retdata+'&max_min_dec='+document.getElementById('max_min_dec').value
				}
				document.getElementById('sex').value = getLabel("Common.all.label",'Common');
				document.getElementById('start_age').value = '';
				document.getElementById('start_units').value = getLabel("Common.days.label",'Common');
				document.getElementById('end_age').value = '';
				document.getElementById('end_units').value = getLabel("Common.days.label",'Common');
				document.getElementById('seq_no').value = '';
				document.getElementById('ref_low').value = '';
				document.getElementById('ref_high').value = '';
				document.getElementById('critical_low').value = '';
				document.getElementById('critical_high').value = '';
				document.getElementById('unit_of_measure').value = '';
				document.getElementById('default_val').value = '';
				document.getElementById('mode').value = 'insert'
				document.getElementById('seq_no').readOnly = false;
			}

			function seqnoChk()
			{
				if(document.getElementById('mode').value == 'insert')
				{
					var rows = parent.frames[0].document.getElementById('total_rows').value;
					for(var n=0;n<rows;n++)
					{
						var obj = eval(parent.frames[0].document.getElementById('seqno_'+n));
						if(document.getElementById('seq_no').value == obj.innerText)
							return false;
					}
					return true;
				}
				else
					return true;
			}

			function overlapChk()
			{
				var startdays;
				var enddays;
				var currstartdays;
				var currenddays;

				var startunit = document.getElementById('start_units').value;
				if(startunit == 'Months')
					currstartdays = (eval(document.getElementById('start_age').value)*30)+1;
				else if(startunit == 'Years')
					currstartdays = (eval(document.getElementById('start_age').value)*365)+1;
				else
					currstartdays = eval(document.getElementById('start_age').value);

				var endunit = document.getElementById('end_units').value;
				if(endunit == 'Months')
					currenddays = (eval(document.getElementById('end_age').value)*30)-1;
				else if(endunit == 'Years')
					currenddays = (eval(document.getElementById('end_age').value)*365)-1;
				else
					currenddays = eval(document.getElementById('end_age').value);

				if(currstartdays>=currenddays)
					return '1';
				else
				{
					var rows = eval(parent.frames[0].document.getElementById('total_rows').value);
					for(var n=0;n<rows;n++)
					{
						var obj = eval(parent.frames[0].document.getElementById('sex_'+n));
						var sex = obj.innerText;

						obj = eval(parent.frames[0].document.getElementById('startage_'+n));
						var startage = obj.innerText;
						obj = eval(parent.frames[0].document.getElementById('startunits_'+n));
						var startunit = obj.innerText;
						if(startunit == 'Months')
							startdays = eval(startage)*30;
						else if(startunit == 'Years')
							startdays = eval(startage)*365;
						else
							startdays = eval(startage);

						var obj = eval(parent.frames[0].document.getElementById('endage_'+n));
						var endage = obj.innerText;
						obj = eval(parent.frames[0].document.getElementById('endunits_'+n));
						var endunit = obj.innerText;
						if(endunit == 'Months')
							enddays = eval(endage)*30;
						else if(endunit == 'Years')
							enddays = eval(endage)*365;
						else
							enddays = eval(endage);
						if(document.getElementById('mode').value == 'insert' || document.getElementById("callfn").value=='Y')
						{
							if(sex == document.getElementById('sex').value || sex == 'All' || document.getElementById('sex').value =='All') 
							{
//alert(document.getElementById("sex").value+"  "+sex+"  "+startdays+"  "+enddays+"  "+currstartdays+"  "+currenddays);								
								if((currenddays < startdays) || (currstartdays > enddays)){}
								else return '2';
							}
						}
					}
				}
				return '3';
			}
	//-->
	</script>
</head>

<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form id='DiscrMeasure_form' name='DiscrMeasure_form'>
<%
		request.setCharacterEncoding("UTF-8");
		String discrmeasure = request.getParameter("discr_measure")==null?"":request.getParameter("discr_measure");
		String convals = request.getParameter("con_vals")==null?"":request.getParameter("con_vals");
		String rownum = request.getParameter("row_num")==null?"":request.getParameter("row_num");
		String maxmindec = request.getParameter("max_min_dec")==null?"":request.getParameter("max_min_dec");
		String sex = "";
		String startage = "";
		String startunits = "";
		String endage = "";
		String endunits = "";
		String seqno = "";
		String reflow = "";
		String refhigh = "";
		String criticallow = "";
		String criticalhigh = "";
		String uom = "";
		String def = "";
		//String insertyn = "Y";
		String mode = "insert";
		String rd = "";
		String max = "";
		String min = "";
		String deci = "";
		String sel1 = "";
		String sel2 = "";
		String sel3 = "";
		String sel4 = "";

		try
		{
			java.util.StringTokenizer tok = new java.util.StringTokenizer(maxmindec,"$");
			while(tok.hasMoreTokens())
			{
				max = tok.nextToken();
				min = tok.nextToken();
				deci = tok.nextToken();
			}
//out.println(convals);
			if(!convals.equals(""))
			{
				java.util.StringTokenizer st = new java.util.StringTokenizer(convals,"~");
				while(st.hasMoreTokens())
				{
					mode = "modify";
					rd = "readonly";
					sex = st.nextToken();               
					startage = st.nextToken();      
					startunits = st.nextToken();    
					endage = st.nextToken();        
					endunits = st.nextToken();      
					seqno = st.nextToken();          
					reflow = st.nextToken();          
					refhigh = st.nextToken();         
					criticallow = st.nextToken();   
					criticalhigh = st.nextToken(); 
					uom = st.nextToken();             
					def = st.nextToken(); 
					//insertyn = st.nextToken();
				}
			}
		}catch(Exception e){out.println(e);}
%>
<br>
<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
<tr>
	<th rowspan=2>Sex</th>
	<th colspan=2><fmt:message key="Common.Start.label" bundle="${common_labels}"/></th>
	<th colspan=2>End</th>
	<th rowspan=2><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></th>
	<th colspan=2><fmt:message key="eMP.Reference.label" bundle="${mp_labels}"/></th>
	<th colspan=2><fmt:message key="Common.Critical.label" bundle="${common_labels}"/></th>
	<th rowspan=2><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>
	<th rowspan=2><fmt:message key="Common.Default.label" bundle="${common_labels}"/></th>
</tr>
<tr>
	<th><fmt:message key="Common.age.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.Units.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.age.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.Units.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.Low.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.High.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.Low.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.High.label" bundle="${common_labels}"/></th>
</tr>

<tr>
	<td>
		<%
			if(sex.equals("All")) sel1=" selected ";
			else if(sex.equals("Male")) sel2=" selected ";
			else if(sex.equals("Female")) sel3=" selected ";
			else if(sex.equals("Unknown")) sel4=" selected ";
		%>
		<select name=sex onChange="document.getElementById("callfn").value='Y'">
			<option value='All' <%=sel1%>><fmt:message key="Common.all.label" bundle="${common_labels}"/>
			<option value='Male' <%=sel2%>><fmt:message key="Common.male.label" bundle="${common_labels}"/>
			<option value='Female' <%=sel3%>><fmt:message key="Common.female.label" bundle="${common_labels}"/>
			<option value='Unknown' <%=sel4%>><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
		</select>
	</td>
	<td><input type="text" name="start_age" id="start_age" value="<%=startage%>" maxlength=3 size=3 onKeyPress='return(ChkNumberInput(this,event,0))' onChange="document.getElementById("callfn").value='Y'"></td>
	<td>
		<%
			sel1=sel2=sel3="";
			if(startunits.equals("Days")) sel1=" selected ";
			else if(startunits.equals("Months")) sel2=" selected ";
			else if(startunits.equals("Years")) sel3=" selected ";
		%>
		<select name=start_units  onChange="document.getElementById("callfn").value='Y'">
			<option value='Days' <%=sel1%>><fmt:message key="Common.days.label" bundle="${common_labels}"/>
			<option value='Months' <%=sel2%>><fmt:message key="Common.months.label" bundle="${common_labels}"/>
			<option value='Years' <%=sel3%>><fmt:message key="Common.Years.label" bundle="${common_labels}"/>
		</select>
	</td>
	<td><input type="text" name="end_age" id="end_age" value="<%=endage%>" maxlength=3 size=3 onKeyPress='return(ChkNumberInput(this,event,0))'  onChange="document.getElementById("callfn").value='Y'"></td>
	<td>
		<%
			sel1=sel2=sel3="";
			if(endunits.equals("Days")) sel1=" selected ";
			else if(endunits.equals("Months")) sel2=" selected ";
			else if(endunits.equals("Years")) sel3=" selected ";
		%>
		<select name=end_units  onChange="document.getElementById("callfn").value='Y'">
			<option value='Days' <%=sel1%>><fmt:message key="Common.days.label" bundle="${common_labels}"/>
			<option value='Months' <%=sel2%>><fmt:message key="Common.months.label" bundle="${common_labels}"/>
			<option value='Years' <%=sel3%>><fmt:message key="Common.Years.label" bundle="${common_labels}"/>
		</select>
	</td>
	<td><input type="text" name="seq_no" id="seq_no" value="<%=seqno%>" <%=rd%> maxlength=2 size=2 onKeyPress='return(ChkNumberInput(this,event,0))'    OnBlur="CheckPositiveNumberLocal(this)"></td>
	<td><input type="text" name="ref_low" id="ref_low" value="<%=reflow%>" size="3" onBlur="validateNumber(this)"></td>
	<td><input type="text" name="ref_high" id="ref_high" value="<%=refhigh%>" size="3" onBlur="validateNumber(this)"></td>
	<td><input type="text" name="critical_low" id="critical_low" value="<%=criticallow%>" size="3" onBlur="validateNumber(this)"></td>
	<td><input type="text" name="critical_high" id="critical_high" value="<%=criticalhigh%>" size="3" onBlur="validateNumber(this)"></td>
	<td><input type="text" name="unit_of_measure" id="unit_of_measure" value="<%=uom%>" maxlength="10" size="3"></td>
	<td><input type="text" name="default_val" id="default_val" value="<%=(def.equals("0")?"&nbsp;":def)%>" size="3" onBlur="validateNumber(this)"></td>
</tr>
</table>

<br>

<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
<tr>
	<td align=right class=BODYCOLORFILLED>
		<input type="button" class=BUTTON name='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' id='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' value="Select" onClick="doSelect('S')">
		<input type="button" class=BUTTON name="OK" id="OK" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="doSelect('O')">
		<input type="button" class=BUTTON name="Clear" id="Clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="doSelect('CL')">
		<input type="button" class=BUTTON name="Cancel" id="Cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="doSelect('CA')">
	</td>
</tr>
</table>
<input type="hidden" name=discr_measure value="<%=discrmeasure%>">
<input type="hidden" name=mode value="<%=mode%>">
<input type="hidden" name=row_num value="<%=rownum%>">
<input type="hidden" name=max value="<%=max%>">
<input type="hidden" name=min value="<%=min%>">
<input type="hidden" name=decimal value="<%=deci%>">
<input type="hidden" name="max_min_dec" id="max_min_dec" value="<%=maxmindec%>">
<input type="hidden" name="callfn" id="callfn" value="N">
</form>
</body>
</html>

