<!DOCTYPE html>
<!-- developed by venkatesh.d on 5th may 2005 -->
<%
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------
Date       Edit History     Name           Rev.Date		  Rev.Name		Description
-------------------------------------------------------------------------------------------------------
07/08/2019	IN070957		Ramya Maddena	07/08/2019   Ramesh G
-------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eAM/js/DiscrMsrComp.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	

	<script language="JavaScript">
	<!--
			function doSelect(val)
			{
				if(val == 'S')
				{
					if(validateRefCritical() == true)
					{
						//if(document.getElementById('default_val').value=='') document.getElementById('default_val').value=0;// commented for IN070957
						//if(document.getElementById('sex').value == '' || document.getElementById('start_age').value == '' || document.getElementById('start_units').value == '' || document.getElementById('end_age').value == '' || document.getElementById('end_units').value == '' || document.getElementById('seq_no').value == '' || document.getElementById('ref_low').value == '' || document.getElementById('ref_high').value == '' || document.getElementById('critical_low').value == '' || document.getElementById('critical_high').value == '' || document.getElementById('unit_of_measure').value == '' || document.getElementById('default_val').value == '' )//commented for IN070957
						if(document.getElementById('sex').value == '' || document.getElementById('start_age').value == '' || document.getElementById('start_units').value == '' || document.getElementById('end_age').value == '' || document.getElementById('end_units').value == '' || document.getElementById('seq_no').value == '' || document.getElementById('ref_low').value == '' || document.getElementById('ref_high').value == '' || document.getElementById('critical_low').value == '' || document.getElementById('critical_high').value == '' || document.getElementById('unit_of_measure').value == '' )//added for IN070957
							//alert('APP-AM0115 All fields other than Default are mandatory');
						alert(getMessage("MANDATORY_FIELDS","AM"));
						else if(seqnoChk() == false)
						{
							//alert('APP-AM0116 Sequence Number should be unique');
							alert(getMessage("UNIQUE_SEQUENCE_NUM","AM"));
							//document.getElementById('seq_no').select();
							document.getElementById('seq_no').focus();
						}
						else if(overlapChk() == '1')
						{
							//alert('APP-AM0117 End Age should be greater than start age');
							alert(getMessage("START_AGE_GREATER_END_AGE","AM"));
							document.getElementById('start_age').focus();
						}
						else if(overlapChk() == '2')
						{
							//alert('APP-AM0118 Record for this age range exits');
							alert(getMessage("AGE_RANGE_EXITS","AM"));
							document.getElementById('start_age').focus();
						}
						else
						{
							
							var prevconvals = parent.frames[0].document.getElementById('prev_con_vals').value;
							//var convals = document.getElementById('sex').value+"~"+document.getElementById('start_age').value+"~"+document.getElementById('start_units').value+"~"+document.getElementById('end_age').value+"~"+document.getElementById('end_units').value+"~"+document.getElementById('seq_no').value+"~"+document.getElementById('ref_low').value+"~"+document.getElementById('ref_high').value+"~"+document.getElementById('critical_low').value+"~"+document.getElementById('critical_high').value+"~"+document.getElementById('unit_of_measure').value+"~ "+document.getElementById('default_val').value+"~"+"I"+"`";//commented for IN070957
							var convals = document.getElementById('sex').value+"~"+document.getElementById('start_age').value+"~"+document.getElementById('start_units').value+"~"+document.getElementById('end_age').value+"~"+document.getElementById('end_units').value+"~"+document.getElementById('seq_no').value+"~"+document.getElementById('ref_low').value+"~"+document.getElementById('ref_high').value+"~"+document.getElementById('critical_low').value+"~"+document.getElementById('critical_high').value+"~"+document.getElementById('unit_of_measure').value+"~ "+document.getElementById('default_val').value+"~"+"I"+"`";//added for IN070957
	//	alert(document.getElementById('mode').value);
							if(document.getElementById('mode').value == 'insert')
							{
								
								convals = prevconvals+convals+"`";
	//	alert(convals);         
								parent.frames[0].location.href = '../../eAM/jsp/DiscrMsrCompNumResult.jsp?from=N&con_vals='+escape(convals)+'&max_min_dec='+document.getElementById('max_min_dec').value
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
								
								
								obj.innerText= document.getElementById('default_val').value
									
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
						var defValue = parent.frames[0].document.getElementById('def_' + i).innerText;
						defValue = defValue.trim() === '' ? '0' : defValue;
						//var temp = eval("parent.frames[0].document.getElementById('sex_')"+i+".innerText")+"~"+eval("parent.frames[0].document.getElementById('startage_')"+i+".innerText")+"~"+eval("parent.frames[0].document.getElementById('startunits_')"+i+".innerText")+"~"+eval("parent.frames[0].document.getElementById('endage_')"+i+".innerText")+"~"+eval("parent.frames[0].document.getElementById('endunits_')"+i+".innerText")+"~"+eval("parent.frames[0].document.getElementById('seqno_')"+i+".innerText")+"~"+eval("parent.frames[0].document.getElementById('reflow_')"+i+".innerText")+"~"+eval("parent.frames[0].document.getElementById('refhigh_')"+i+".innerText")+"~"+eval("parent.frames[0].document.getElementById('criticallow_')"+i+".innerText")+"~"+eval("parent.frames[0].document.getElementById('criticalhigh_')"+i+".innerText")+"~"+eval("parent.frames[0].document.getElementById('uom_')"+i+".innerText")+"~"+eval("parent.frames[0].document.getElementById('def_')"+i+".innerText")+"~"+eval("parent.frames[0].document.getElementById('insertyn_')"+i+".value")+"`";//commented for IN070957
						var temp = parent.frames[0].document.getElementById('sex_'+i).innerText+"~"+parent.frames[0].document.getElementById('startage_'+i).innerText+"~"+parent.frames[0].document.getElementById('startunits_'+i).innerText+"~"+parent.frames[0].document.getElementById('endage_'+i).innerText+"~"+parent.frames[0].document.getElementById('endunits_'+i).innerText+"~"+parent.frames[0].document.getElementById('seqno_'+i).innerText+"~"+parent.frames[0].document.getElementById('reflow_'+i).innerText+"~"+parent.frames[0].document.getElementById('refhigh_'+i).innerText+"~"+parent.frames[0].document.getElementById('criticallow_'+i).innerText+"~"+parent.frames[0].document.getElementById('criticalhigh_'+i).innerText+"~"+parent.frames[0].document.getElementById('uom_'+i).innerText+"~"+defValue +"~"+parent.frames[0].document.getElementById('insertyn_'+i).value+"`";//added for IN070957
						//alert(temp);
						if (retdata.trim().length>0)
						{
							retdata +=temp+"$";
						}
						else
						{
						retdata +=temp;
						}
						if (retdata.endsWith('$'))
						{
							retdata = retdata.slice(0, -1);
						}
					}
					//parent.window.returnValue = retdata;
					//parent.window.close();
					toCloseTopShowModal(retdata);
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
					//parent.window.close();
					toCloseTopShowModal();
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
					//alert('APP-AM0112 Reference Low cannot be greater than Reference High');
					alert(getMessage("REF_LOW_NOT_GREATER_HIGH","AM"));
					document.getElementById('ref_high').select();
					document.getElementById('ref_high').focus();
					return false;
				}
				else if(critlow!=0 && crithigh!=0 && critlow > crithigh)
				{
					//alert('APP-AM0109 Critical Low cannot be greater than Critical High');
					alert(getMessage("CRITICAL_LOW_NOT_GREATER_HIGH","AM"));
					document.getElementById('critical_high').select();
					document.getElementById('critical_high').focus();
					return false;
				}
				else
				{
					if(critlow!=0 && reflow!=0 && critlow > reflow)
					{
						//alert('APP-AM0110 Critical Low should be less than Reference Low');
						alert(getMessage("CRITICAL_LOW_LESS_REF_LOW","AM"));
						document.getElementById('critical_low').select();
						document.getElementById('critical_low').focus();
						return false;
					}
					else if(crithigh!=0 && refhigh!=0 && crithigh < refhigh)
					{
						//alert('APP-AM0111 Critical High should be greater than Reference High');
						alert(getMessage("CRITICAL_HIGH_GREATER_REF_HIGH","AM"));
						//document.getElementById('critical_high').select();
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
					// code added for 21526  parent.frames[0].document.getElementById('myTable').deleteRow(rownum) 
					if(rownum!=3)
					parent.frames[0].document.getElementById('myTable').deleteRow(rownum) 
						else
							parent.frames[0].document.getElementById('myTable').deleteRow(rownum-1) 


					var retdata = '';
					var n = eval(parent.frames[0].document.getElementById('total_rows').value);
					
					for(var i=0;i<n;i++)
					{
						
						if(rownum!=i)
						{
							

							var temp = eval(parent.frames[0].document.getElementById('sex_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('startage_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('startunits_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('endage_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('endunits_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('seqno_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('reflow_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('refhigh_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('criticallow_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('criticalhigh_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('uom_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('def_'+i).innerText)+"~"+eval(parent.frames[0].document.getElementById('insertyn_'+i).value)+"`";
							
							retdata +=temp;
							
						}
					}
				
					parent.frames[0].location.href = '../../eAM/jsp/DiscrMsrCompNumResult.jsp?from=N&con_vals='+escape(retdata)+'&max_min_dec='+document.getElementById('max_min_dec').value
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
//alert(document.getElementById('sex').value+"  "+sex+"  "+startdays+"  "+enddays+"  "+currstartdays+"  "+currenddays);								
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
<form name='DiscrMeasure_form' id='DiscrMeasure_form'>
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
					st.nextToken();
					//IN070957 Starts
					if("Days".equals(startunits))
						startunits = "D";
					else if("Months".equals(startunits))
						startunits = "M";
					else if("Years".equals(startunits))
						startunits = "Y";
					
					
					if("Days".equals(endunits))
						endunits = "D";
					else if("Months".equals(endunits))
						endunits = "M";
					else if("Years".equals(endunits))
						endunits = "Y";
						//IN070957 ends
				}
			}
		}catch(Exception e){out.println(e);}
%>
<br>
<table border='1' cellpadding='0' cellspacing='0' width='98%' align='center'>
<tr><th nowrap colspan=16><b><font size='2' ><fmt:message key="eAM.AddModifyRange.label" bundle="${am_labels}"/></b></th></tr>
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
			if(sex.equals("A") || sex.equals("All")) sel1=" selected ";
			else if(sex.equals("M") || sex.equals("Male")) sel2=" selected ";
			else if(sex.equals("F") || sex.equals("Female")) sel3=" selected ";
			else if(sex.equals("U") || sex.equals("Unknown")) sel4=" selected ";
		%>
		<select name="sex" id="sex" onChange="document.getElementById('callfn').value='Y'">
			<option value='A' <%=sel1%>><fmt:message key="Common.all.label" bundle="${common_labels}"/>
			<option value='M' <%=sel2%>><fmt:message key="Common.male.label" bundle="${common_labels}"/>
			<option value='F' <%=sel3%>><fmt:message key="Common.female.label" bundle="${common_labels}"/>
			<option value='U' <%=sel4%>><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
		</select>
	</td>
	<td><input type="text" name="start_age" id="start_age" value="<%=startage%>" maxlength=3 size=3 onKeyPress='return(ChkNumberInput(this,event,0))' onChange="document.getElementById('callfn').value='Y'"></td>
	<td>
		<%
			sel1=sel2=sel3="";
			if(startunits.equals("D")) sel1=" selected ";
			else if(startunits.equals("M")) sel2=" selected ";
			else if(startunits.equals("Y")) sel3=" selected ";//added for IN070957
		%>
		<select name="start_units" id="start_units"  onChange="document.getElementById('callfn').value='Y'">
			<option value='Days' <%=sel1%>><fmt:message key="Common.days.label" bundle="${common_labels}"/>
			<option value='Months' <%=sel2%>><fmt:message key="Common.months.label" bundle="${common_labels}"/>
			<option value='Years' <%=sel3%>><fmt:message key="Common.Years.label" bundle="${common_labels}"/>
		</select>
	</td>
	<td><input type="text" name="end_age" id="end_age" value="<%=endage%>" maxlength=3 size=3 onKeyPress='return(ChkNumberInput(this,event,0))'  onChange="document.getElementById('callfn').value='Y'"></td>
	<td>
		<%
			sel1=sel2=sel3="";
			if(endunits.equals("D")) sel1=" selected ";
			else if(endunits.equals("M")) sel2=" selected ";
			else if(endunits.equals("Y")) sel3=" selected ";//added for IN070957
		%>
		<select name="end_units"  id="end_units"  onChange="document.getElementById('callfn').value='Y'">
			<option value='Days' <%=sel1%>><fmt:message key="Common.days.label" bundle="${common_labels}"/>
			<option value='Months' <%=sel2%>><fmt:message key="Common.months.label" bundle="${common_labels}"/>
			<option value='Years' <%=sel3%>><fmt:message key="Common.Years.label" bundle="${common_labels}"/>
		</select>
	</td>
	<td><input type="text" name="seq_no" id="seq_no" value="<%=seqno%>" <%=rd%> maxlength=2 size=11 onKeyPress='return(ChkNumberInput(this,event,0))'    OnBlur="CheckPositiveNumberLocal(this)"></td>
	<td><input type="text" name="ref_low" id="ref_low" value="<%=reflow%>" size="3" onBlur="validateNumber2(this,'Num')"></td>
	<td><input type="text" name="ref_high" id="ref_high" value="<%=refhigh%>" size="3" onBlur="validateNumber2(this,'Num')"></td>
	<td><input type="text" name="critical_low" id="critical_low" value="<%=criticallow%>" size="3" onBlur="validateNumber2(this,'Num')"></td>
	<td><input type="text" name="critical_high" id="critical_high" value="<%=criticalhigh%>" size="3" onBlur="validateNumber2(this,'Num')"></td>
	<td><input type="text" name="unit_of_measure" id="unit_of_measure" value="<%=uom%>" maxlength="10" size="3"></td>
	<td><input type="text" name="default_val" id="default_val" value="<%=def.trim()%>" size="3" onkeyPress=" return allowValidNumber(this,event,8,2);" onBlur="validateNumber2(this,'Num')"></td>
</tr>
</table>

<br>

<table border='0' cellpadding='0' cellspacing='0' width='97%' align='center'>
<tr>
	<td align=right class=BODYCOLORFILLED>
		<input type="button" class=BUTTON name="Select" id="Select" value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick="doSelect('S')">
		<input type="button" class=BUTTON name="OK" id="OK" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="doSelect('O')">
		<input type="button" class=BUTTON name="Clear" id="Clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="doSelect('CL')">
		<input type="button" class=BUTTON name="Cancel" id="Cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="doSelect('CA')">
	</td>
</tr>
</table>
<input type="hidden" name="discr_measure" id="discr_measure" value="<%=discrmeasure%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="row_num" id="row_num" value="<%=rownum%>">
<input type="hidden" name="max" id="max" value="<%=max%>">
<input type="hidden" name="min" id="min" value="<%=min%>">
<input type="hidden" name="decimal" id="decimal"  value="<%=deci%>">
<input type="hidden" name="max_min_dec" id="max_min_dec" value="<%=maxmindec%>">
<input type="hidden" name="callfn" id="callfn" value="N">
</form>
</body>
</html>

