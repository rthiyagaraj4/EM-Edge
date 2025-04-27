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
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eAM/js/DiscrMsrComp.js' language='javascript'></script>
	<script language="JavaScript">
	<!--
    function invis()
	{
		
		document.getElementById('sco1').style.dispaly='none';
		document.getElementById('sco2').style.dispaly='none';
	}
	function checkSequence(objSequence)
	{
	var errorMessage =""
	
	 if(parseInt(objSequence.value) <= 0)
			{
				//errorMessage=messageArray["VALUE_SHOULD_BE_GR_ZERO"];
				//alert('APP-AM1032-Value should be greater than Zero');
				errorMessage= messageArray["VALUE_SHOULD_BE_GR_ZERO"];
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
					if(document.getElementById('desc').value == '' || document.getElementById('result').value == '')
					{
						//alert('APP-AM0115 All fields other than Default are mandatory');
					alert(getMessage("MANDATORY_FIELDS","AM"));
				/*	else if(sortOrderChk() == false)
					{
						alert(parent.getMessage('UNIQUIE_SORT_ORDER'));
						document.getElementById('sort_order').select();
						document.getElementById('sort_order').focus();
					} */
					}
					else if(oneDefaultChk() == false )
					{
                        
						//alert('APP-AM0120 Only one default value is allowed');
						alert(getMessage("ONE_DEFAULT","AM"));
						document.getElementById('default_yn').focus();
					}
					else
					{
						if(document.getElementById('numericval').value==""||document.getElementById('numericval').value==null)document.getElementById('numericval').value="";
						var prevconvals = parent.frames[0].document.getElementById('prev_con_vals').value;
						var convals =document.getElementById('ref_range_seq').value+"~"+document.getElementById('desc').value+"~"+document.getElementById('result').value+"~"+(document.getElementById('default_yn').checked==true?"Y":"N")+"~"+document.getElementById('numericval').value;
						
						if(document.getElementById('mode').value == 'insert')
						{							
                            if(!duplecateCheck(prevconvals,convals))
                            {
								alert('APP-AM1560- ID can not be duplicated');
                                document.getElementById('result').focus(); 
							}
							else
							{	
								if (prevconvals.trim().length>0)
									prevconvals = prevconvals + "`";
								
								convals = prevconvals+convals+"`";		
							
								document.forms[0].con_vals.value=convals;
								
								document.forms[0].submit();

								//	parent.frames[0].location.href = "../../eAM/jsp/DiscrMeasureAlphaInfoResult.jsp?from=A&con_vals="+escape(convals)
								clearFields();
							}
						}
						else
						{
							var rownum = document.getElementById("row_num").value;


//parent.frames[0].document.getElementById('sorder_0').innerText = '2'
							var obj = eval(parent.frames[0].document.getElementById('desc_'+rownum));
							str = "<a href='javascript:showDetails(\""+escape(convals)+"\",\""+rownum+"\",\"A\")'>"+ document.getElementById('desc').value + "</a>";
							obj.innerHTML= str;
                            obj = eval(parent.frames[0].document.getElementById('result_'+rownum));
							obj.innerText= document.getElementById('result').value;
							
							
							obj = eval(parent.frames[0].document.getElementById('numericval_'+rownum));
							obj.innerText= document.getElementById('numericval').value;
							
						//	obj = eval("parent.frames[0].document.getElementById('sorder_')"+rownum);
						//	obj.innerText= document.getElementById('sort_order').value;
							
							obj = eval(parent.frames[0].document.getElementById('def_'+rownum));
							obj.innerText= (document.getElementById('default_yn').checked==true?"Y":"N");
                            
							clearFields();
							formtable();
							
						}
					}
				}
				else if(val =='D')
				{
						if(document.getElementById('desc').value == '' || document.getElementById('result').value == '')
							alert(getMessage('CANNOT_DELETE','SM'));
						else
						{

							if(document.getElementById('numericval').value==""||document.getElementById('numericval').value==null)document.getElementById('numericval').value="";
							var prevconvals = parent.frames[0].document.getElementById('prev_con_vals').value;
							var convals =document.getElementById('ref_range_seq').value+"~"+document.getElementById('desc').value+"~"+document.getElementById('result').value+"~"+(document.getElementById('default_yn').checked==true?"Y":"N")+"~"+document.getElementById('numericval').value
						
							var splitval = convals.split('~');
							var checkval = splitval[2];
							
							var presplit = prevconvals.split('`')
							var finalval = "";
							for(var i=0;i<presplit.length-1;i++)
							{
								var prearr = presplit[i].split('~');
								if(checkval != prearr[2])
								{
									finalval += presplit[i]+"`";
								}
							}
			
							document.forms[0].con_vals.value=finalval;
							document.forms[0].submit();
							clearFields();
						}
				}
				else if(val=='O')
				{ 
					var n = parent.frames[0].document.getElementById('total_rows').value;
					var retdata='';
					
					for(var i=0;i<n;i++)
					{
                    	document.getElementById('ref_range_seq').value = i+1
 						var temp = document.getElementById('ref_range_seq').value+"~"+parent.frames[0].document.getElementById('desc_'+i).innerText+"~"+parent.frames[0].document.getElementById('result_'+i).innerText+"~"+parent.frames[0].document.getElementById('def_'+i).innerText+"~"+parent.frames[0].document.getElementById('numericval_'+i).innerText;
						if (i>0)
							retdata=retdata+"`";
						
						retdata=retdata+temp;
					}
					
					let dialogBody = parent.parent.document.getElementById('dialog-body');
					dialogBody.contentWindow.returnValue = retdata;
					const dialogTag = parent.parent.document.getElementById("dialog_tag");    
					dialogTag.close(); 
					//parent.window.returnValue = retdata;
					//alert(parent.window.returnValue+"returnval");
			
				    //parent.window.close();
				}
				else if(val =='CL')
				{
					clearFields();
				}
				else
				{
					//parent.window.close();
					parent.parent.document.getElementById("dialog_tag").close();
				}
			}

		/*	function sortOrderChk()
			{
				if(document.getElementById('mode').value == 'insert')
				{
					var rows = parent.frames[0].document.getElementById('total_rows').value;
					for(var n=0;n<rows;n++)
					{
						var obj = eval("parent.frames[0].document.getElementById('sorder_')"+n);
						if(document.getElementById('sort_order').value == obj.innerText)
							return false;
					}
					return true;
				}
				else
					return true;
			} */

			function oneDefaultChk()
			{
				var rows = eval(parent.frames[0].document.getElementById('total_rows').value);
				//alert(rows);
                var res=document.getElementById('result').value;
				//alert('in modify page'+res);
				for(var n=0;n<rows;n++)
				{
					var obj = eval(parent.frames[0].document.getElementById('def_'+n));	
					var listres=eval(parent.frames[0].document.getElementById('result_'+n).innerTextf);
					//alert('in result page'+listres);
					var temp = document.getElementById('default_yn').checked==true?"Y":"N"
                   // alert(obj.innerText); 

				
					if(listres != res && temp=='Y' && obj.innerText == 'Y') 
						return false;
				
				}
				return true;
			}


			function clearFields()
			{
				document.getElementById('desc').value = "";
				document.getElementById('result').value = "";
				if(document.getElementById('result').disabled == true)
                document.getElementById('result').disabled=false;
				document.getElementById('numericval').value = "";
				//document.getElementById('sort_order').value ="";
				document.getElementById('default_yn').checked = false;			
				document.getElementById('mode').value = "insert"
			}
	//-->
	        function formtable()
			{
			//	alert('in formtable');
				var n = parent.frames[0].document.getElementById('total_rows').value;
					
					var retdata='';
					for(var i=0;i<n;i++)
					{
                    document.getElementById('ref_range_seq').value = i+1
                   // alert(document.getElementById('ref_range_seq').value); 
 					var temp = document.getElementById('ref_range_seq').value+"~"+parent.frames[0].document.getElementById('desc_'+i).innerText+"~"+parent.frames[0].document.getElementById('result_'+i).innerText+"~"+parent.frames[0].document.getElementById('def_'+i).innerText+"~"+parent.frames[0].document.getElementById('numericval_'+i).innerText+"`";
					retdata +=temp;
					//	alert('retdata'+retdata);
					}
					//alert('modified'+retdata);
					parent.frames[0].document.getElementById('prev_con_vals').value=retdata;
			}

			function duplecateCheck(prev,current)
			{
            arr2=current.split("~");
            arr=prev.split("`");
			if(prev != ' ')
				{
				
			for(i=0;i<arr.length;i++)
				{
				temparr=arr[i].split("~");
				
				if(temparr[2] == arr2[2])
					{
					
					return false;
                    }                
                
				}
				
				}

             return true;

			}
			
			function CheckForListSpecChars(event){
					var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*#$%^()+,./:>?{}[]@\;-=<\| ';
					var whichCode = (window.Event) ? event.which : event.keyCode;
					key = String.fromCharCode(whichCode);  // Get key value from key code
					if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
					if( (event.keyCode >= 97) && (event.keyCode <= 122) )
						return (event.keyCode);
					return true ;
		}
	</script>
</head>

<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name='DiscrMeasure_form' id='DiscrMeasure_form' method="post" action="DiscrMsrCompListResult.jsp?from=A" target="result">
<%
		request.setCharacterEncoding("UTF-8");
		String discrmeasure = request.getParameter("discr_measure")==null?"":request.getParameter("discr_measure");
		String convals = request.getParameter("con_vals")==null?"":request.getParameter("con_vals");
		String rownum = request.getParameter("row_num")==null?"":request.getParameter("row_num");
		String refrangeseq = "1";
		String description = "";
		String result = "";
		//String disab="";
		//String sortorder = "";
		String numericvalues="";
		String defaultval = "";
		String mode = "insert";
		String chk="";
		String status = request.getParameter("status")==null?"":request.getParameter("status");
        String del_disable = "";
		
		if(!convals.equals(""))
		{
			java.util.StringTokenizer st = new java.util.StringTokenizer(convals,"~");
			while(st.hasMoreTokens())
			{
				mode = "modify";
				
						
				refrangeseq = st.nextToken();
				
				description = st.nextToken().trim();
				
				result = st.nextToken();
			
			    defaultval = st.nextToken(); 
			    
				if(st.hasMoreElements()) 
				numericvalues=st.nextToken();
				
						
			}
		}
		if(numericvalues==null||numericvalues=="")numericvalues="";

if(numericvalues.equals("null")||numericvalues=="")
{
numericvalues="";
}
String disbld="";
if(mode.equals("modify")){
	disbld="disabled";
	del_disable = "";
}
else
	del_disable = "disabled";


%>

<br>
<table border='0' cellpadding='2' cellspacing='0' width='90%' align='center'>
<tr>
	<td   class='label' ><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
	<td  align='left'>&nbsp;&nbsp;
	<input type='text' <%=disbld%> name='result' id='result' size="4" maxlength="4" value="<%=result%>" onBlur="ChangeUpperCase(this);makeValidString(this);CheckSpecialChar(this)" onkeypress="return CheckForSpecChars(event)">
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
 	
</tr>

<tr>
	<td  class='label' ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td  align='left'>&nbsp;&nbsp;
		<!--<input type='text'  name='desc' id='desc' size="45" maxlength="60" value="<%=description%>" onBlur="makeValidString(this)" OnKeyPress ="return CheckForListSpecChars(event)">--COMMENTED FOR IN061911-->
		<input type='text'  name='desc' id='desc' size="45" maxlength="100" value="<%=description%>" onBlur="makeValidString(this)" OnKeyPress ="return CheckForListSpecChars(event)"><!--IN061911-->
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td></td>
	<td></td>
</tr>

<tr id='score' style='display:none'>
<td id='sco1'   class='label' ><fmt:message key="Common.Score.label" bundle="${common_labels}"/></td>
	<td id='sco2' align='left'>&nbsp;&nbsp;
	<input type='text' name='numericval' id='numericval' size="11" maxlength="11" value="<%=numericvalues%>" onkeyPress=" return allowValidNumber(this,event,8,2);"  >
	
</td>
</tr>




<tr  style='display:none'>
	<td  align='right' class='label' >Sort Order</td>
	<td  align='left'>&nbsp;&nbsp;
	<input type='text'  name='sort_order' id='sort_order' size="2" maxlength="2" value="" onKeyPress='return(ChkNumberInput(this,event,0))'  OnBlur="CheckPositiveNumberLocal(this)">
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td></td>
	<td></td>

</tr>

<tr>
	<td  class='label'><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
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
		<input type="button" class=BUTTON name="Delete" id="Delete" value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>'  onClick="doSelect('D')" <%=del_disable%>>
		<input type="button" class=BUTTON name="Ok" id="Ok" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='doSelect("O");'>
		<input type="button" class=BUTTON name='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' id='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' value="Clear" onClick="doSelect('CL')">
		<input type="button" class=BUTTON name="Cancel" id="Cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  onClick="doSelect('CA')">
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
<input type="hidden" name="status" id="status" value="<%=status%>">

</form>
<%if(status.equals("Y"))
  {
	 // out.println("<script>invis();</script>");
	// disab = "disabled";
	%>
	<script>
	
	//document.getElementById('score').style.display='none';
	</script>
 <%}%>
</body>
</html>

