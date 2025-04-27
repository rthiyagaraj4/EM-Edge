<!DOCTYPE html>
<!-- developed by venkatesh.d on 5th may 2005 -->
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
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eAM/js/DiscrMsrComp.js' language='javascript'></script>
	<script language="JavaScript">
	<!--

	function checkSequence(objSequence)
	{
	var errorMessage =""
	 if(parseInt(objSequence.value) < 0)
			{
				errorMessage=messageArray["VALUE_SHOULD_BE_GR_ZERO"];
				alert(errorMessage);
				objSequence.value=''
				objSequence.select()
				return false
			}
	 if(objSequence.value.charAt(0) == '-'||objSequence.value.charAt(1) == '-')
			{
				errorMessage= messageArray["VALUE_SHOULD_BE_GR_ZERO"];
				alert(errorMessage);
				objSequence.value=''
				objSequence.select()
				return false
			}

}
			function doSelect(val)
			{
				if(val == 'S')
				{
					//alert(document.getElementById('desc').value);
                      // alert(document.getElementById('result').value);
					if(document.getElementById('desc').value == '' || document.getElementById('result').value == '' || document.getElementById('sort_order').value == '' )
						//alert('APP-AM0115 All fields other than Default are mandatory');
					alert(getMessage("MANDATORY_FIELDS","AM"));
					else if(sortOrderChk() == false)
					{
						//alert('APP-AM0119 Sort Order Must be unique');
						alert(getMessage("UNIQUIE_SORT_ORDER","AM"));
						document.getElementById('sort_order').select();
						document.getElementById('sort_order').focus();
					}
					else if(oneDefaultChk() == false)
					{

						//alert('APP-AM0120 Only one default value is allowed');
						alert(getMessage("ONE_DEFAULT","AM"));
						document.getElementById('default_yn').focus();
					}
					else
					{
						if(document.getElementById('numericval').value==""||document.getElementById('numericval').value==null)document.getElementById('numericval').value="0";
						var prevconvals = parent.frames[0].document.getElementById('prev_con_vals').value;
						var convals =document.getElementById('ref_range_seq').value+"~"+document.getElementById('desc').value+"~"+document.getElementById('result').value+"~"+document.getElementById('numericval').value+"~"+document.getElementById('sort_order').value+"~"+(document.getElementById('default_yn').checked==true?"Y":"N");
						
						if(document.getElementById('mode').value == 'insert')
						{
							convals = prevconvals+convals+"`";		
							//alert('convals'+convals);
							document.forms[0].con_vals.value=convals;
						
							document.forms[0].submit();

						//	parent.frames[0].location.href = "../../eAM/jsp/DiscrMeasureAlphaInfoResult.jsp?from=A&con_vals="+escape(convals)
							clearFields();
						}
						else
						{
							
							var rownum = document.getElementById("row_num").value;
//parent.frames[0].document.getElementById('sorder_0').innerText = '2'
							var obj = eval("parent.frames[0].document.getElementById('desc_')"+rownum);
							str = "<a href='javascript:showDetails(\""+escape(convals)+"\",\""+rownum+"\",\"A\")'>"+ document.getElementById('desc').value + "</a>";
							obj.innerHTML= str;
                            obj = eval(parent.frames[0].document.getElementById("result_"+rownum));
							obj.innerText= document.getElementById("result").value;
							obj = eval(parent.frames[0].document.getElementById("numericval_"+rownum));
							obj.innerText= document.getElementById("numericval").value;
							
							
							
							obj = eval(parent.frames[0].document.getElementById("sorder_"+rownum));
							obj.innerText= document.getElementById("sort_order").value;
							
							obj = eval(parent.frames[0].document.getElementById("def_"+rownum));
							obj.innerText= (document.getElementById("default_yn").checked==true?"Y":"N");

							clearFields();
						}
					}
				}
				else if(val=='O')
				{
					var n = parent.frames[0].document.getElementById('total_rows').value;
					
					var retdata = '';
					for(var i=0;i<n;i++)
					{
						var temp = eval(parent.frames[0].document.getElementById("ref_range_seq_"+i).value)+"~"+eval(parent.frames[0].document.getElementById("desc_"+i).innerText)+"~"+eval(parent.frames[0].document.getElementById("result_"+i).innerText)+"~"+eval(parent.frames[0].document.getElementById("numericval_"+i).innerText)+"~"+eval(parent.frames[0].document.getElementById("sorder_"+i).innerText)+"~"+eval(parent.frames[0].document.getElementById("def_"+i).innerText)+"`";
						
						retdata +=temp;
					}
					parent.window.returnValue = retdata;
					parent.window.close();
				}
				else if(val =='CL')
				{
					clearFields();
				}
				else
				{
					parent.window.close();
				}
			}

			function sortOrderChk()
			{
				if(document.getElementById('mode').value == 'insert')
				{
					var rows = parent.frames[0].document.getElementById('total_rows').value;
					for(var n=0;n<rows;n++)
					{
						var obj = eval("parent.frames[0].document.getElementById("sorder_")"+n);
						if(document.getElementById("sort_order").value == obj.innerText)
							return false;
					}
					return true;
				}
				else
					return true;
			}

			function oneDefaultChk()
			{
				var rows = eval(parent.frames[0].document.getElementById('total_rows').value);

				for(var n=0;n<rows;n++)
				{
					var obj = eval(parent.frames[0].document.getElementById("def_"+n));	
					var temp = document.getElementById("default_yn").checked==true?"Y":"N"

//commented on 31-10-2003 by dhanasekaran
//					if(document.getElementById("row_num").value !=n && temp == 'Y' && obj.innerText == 'Y')
//					return false;
//end commnent

//added on 31-10-2003 by dhanasekaran
					if(temp == 'Y' && obj.innerText == 'Y') 
						return false;
//end addition						
				}
				return true;
			}

			function clearFields()
			{
				document.getElementById('desc').value = " ";
				document.getElementById('result').value = " ";
				document.getElementById('numericval').value = " ";
				document.getElementById('sort_order').value =" ";
				document.getElementById('default_yn').checked = false;			
				document.getElementById('mode').value = "insert"
			}
	//-->
	</script>
</head>

<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name='DiscrMeasure_form' id='DiscrMeasure_form' method="post" action="DiscrMsrCompAlphaInfoResult.jsp?from=A" target="result">
<%
	request.setCharacterEncoding("UTF-8");
		String discrmeasure = request.getParameter("discr_measure")==null?"":request.getParameter("discr_measure");
		String convals = request.getParameter("con_vals")==null?"":request.getParameter("con_vals");
		String rownum = request.getParameter("row_num")==null?"":request.getParameter("row_num");
		String refrangeseq = "$";
		String description = "";
		String result = "";
		String sortorder = "";
		String numericvalues="";
		String defaultval = "";
		String mode = "insert";
		String chk=""; 

		if(!convals.equals(""))
		{
			java.util.StringTokenizer st = new java.util.StringTokenizer(convals,"~");
			while(st.hasMoreTokens())
			{
				mode = "modify";
				refrangeseq = st.nextToken();
				description = st.nextToken().trim();
				result = st.nextToken();
				numericvalues=st.nextToken();
				
				sortorder = st.nextToken();
				defaultval = st.nextToken();
			}
		}
		if(numericvalues==null||numericvalues=="")numericvalues="0";

if(numericvalues.equals("null")||numericvalues=="")
{
numericvalues="";
}
%>

<br>
<table border='0' cellpadding='0' cellspacing='0' width='80%' align='center'>

<tr>
	<td  align='right' class='label' ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td  align='left'>&nbsp;&nbsp;
	<input type='text'  name='desc' id='desc' size="15" maxlength="15" value="<%=description%>" onBlur="makeValidString(this)">
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td></td>
	<td></td>
</tr>

<tr>
	<td  align='right' class='label' ><fmt:message key="Common.Result.label" bundle="${common_labels}"/></td>
	<td  align='left'>&nbsp;&nbsp;
	<input type='text'  name='result' id='result' size="4" maxlength="4" value="<%=result%>" onBlur="ChangeUpperCase(this);makeValidString(this)">
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td  align='right' class='label' ><fmt:message key="eAM.NumericValue.label" bundle="${am_labels}"/></td>
	<td  align='left'>&nbsp;&nbsp;
	<input type='text'  name='numericval' id='numericval' size="11" maxlength="11" value="<%=numericvalues%>" onkeyPress=" return allowValidNumber(this,event,8,2);" OnBlur="checkSequence(this);">
	
	</td>
</tr>

<tr>
	<td  align='right' class='label' ><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/></td>
	<td  align='left'>&nbsp;&nbsp;
	<input type='text'  name='sort_order' id='sort_order' size="2" maxlength="2" value="<%=sortorder%>" onKeyPress='return(ChkNumberInput(this,event,0))'  OnBlur="CheckPositiveNumberLocal(this)">
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td></td>
	<td></td>

</tr>

<tr>
	<td align='right' class='label'><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
	<td  align='left'>&nbsp;
		<%if(defaultval.equals("Y")) chk="checked"; else chk="";%>
		<input type="checkbox" name="default_yn" id="default_yn" value="Y" <%=chk%> >
	</td>
 	<td></td>
	<td></td>

</tr>

<tr><td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
	<td align=right colspan=2>
		<input type="button" class=BUTTON name="Select" id="Select" value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick="doSelect('S')">
		<input type="button" class=BUTTON name="Ok" id="Ok" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="doSelect('O')">
		<input type="button" class=BUTTON name="Clear" id="Clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="doSelect('CL')">
		<input type="button" class=BUTTON name="Cancel" id="Cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="doSelect('CA')">
	</td>
	<td></td>
	<td></td>

</tr>
</table>
<input type="hidden" name="con_vals" id="con_vals" value="">
<input type="hidden" name="discr_measure" id="discr_measure" value="<%=discrmeasure%>">
<input type="hidden" name="ref_range_seq" id="ref_range_seq" value="<%=refrangeseq%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="row_num" id="row_num" value="<%=rownum%>">

</form>
</body>
</html>

