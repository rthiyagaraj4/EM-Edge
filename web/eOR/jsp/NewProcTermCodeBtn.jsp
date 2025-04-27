<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>
<head>
<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language="JavaScript" src="../../eOR/js/NewProcedureTermCode.js"></script>
<script language="javascript">
function ok() {

	var frmObj =parent.lookup_detail.document;
	if(parent.lookup_detail.document.forms[0] && parent.lookup_detail.document.forms[0].multiple_yn.value == "Y")
	{
		/*if(frmObj.term_code_associated != null)
		{
			retVal ="";
			retVal = frmObj.temp_term_code.value;
			var ret_term_code ="";
			ret_term_code = frmObj.term_code_associated.value;
			//alert(ret_term_code+"=="+retVal);
			var cnt = "";
			if ( parent.lookup_detail.document.getElementById("cnt") != null)
					cnt = parent.lookup_detail.document.getElementById("cnt").value;
			else
				cnt = 0;
	
			if ( cnt != 0 )    // If no records are selected or found, nothing should be returned from window.
			{
			  for(var i=2;i<cnt;i++)
			  { 
				if(eval("frmObj.term_chk"+i).checked){
					var code1=frmObj.result_tbl.rows(i-1).cells[0].innerText;
					var test_code1 = code1+"~";
					//alert(retVal+"=="+test_code1+"==="+ret_term_code);
					if(retVal.indexOf(test_code1) == -1 && ret_term_code.indexOf(code1) == -1){
						retVal += code1+"~";
						var code1=frmObj.result_tbl.rows(i-1).cells[0].innerText;
						var code2=frmObj.result_tbl.rows(i-1).cells[1].innerText;
						var code3=frmObj.result_tbl.rows(i-1).cells[2].innerText;
						var code4=frmObj.result_tbl.rows(i-1).cells[3].children(0).value;
						ret_term_code += code1 + "||" + code2 + "||" + code3 + "||" + code4 +"~";
						
						//alert("==="+ret_term_code);
					}
					
				}else{
					var code1=frmObj.result_tbl.rows(i-1).cells[0].innerText;
					
					if(retVal.indexOf(code1) != -1){
						var ind = retVal.indexOf(code1);
						var tmp_equ, tmp_equ1 ,tmp_equ2 ;
						
						if(ind != 0){
							tmp_equ = retVal.substring(0,ind);
							tmp_equ2= retVal.substring(ind , retVal.length);
							tmp_equ1= tmp_equ2.substring(0 , (tmp_equ2.indexOf("~")));
						}else{
							tmp_equ1 = retVal.substring(0,(retVal.indexOf("~")));
						}
						//alert("retVal==="+retVal+"code1=="+code1+"==tmp_equ1="+tmp_equ1+"==");
						if(code1 == tmp_equ1){
							var tmp="";var tmp1="";
							var tmp_desc_equ ="", tmp_desc_equ1="" ,tmp_desc_equ2="" ;
							if((retVal.indexOf(code1)) != 0){
								tmp=retVal.substring(0,(retVal.indexOf(code1)));
								var tmp_1= retVal.substring((retVal.indexOf(code1))+1,retVal.length);
								tmp1 = tmp_1.substring((tmp_1.indexOf("~"))+1,tmp_1.length );
								
								
								tmp_desc_equ =ret_term_code.substring(0,(ret_term_code.indexOf(code1)));
							//alert(tmp_desc_equ+"============="+ret_term_code+"===code1======="+code1);
								var tmp_desc = ret_term_code.substring((ret_term_code.indexOf(code1)),ret_term_code.length);
							//alert(tmp_desc+"============="+ret_term_code+"===code1======="+code1)
								tmp_desc_equ1 = tmp_desc.substring((tmp_desc.indexOf("~"))+1,tmp_desc.length );
								//alert(tmp_desc_equ1+"============="+ret_term_code+"===code1======="+code1)
							}else{
								tmp = retVal.substring((retVal.indexOf("~"))+1,retVal.length );
								tmp_desc_equ = ret_term_code.substring((ret_term_code.indexOf("~"))+1,ret_term_code.length );
							}
							retVal = tmp + tmp1;
							//alert(tmp_desc_equ+"="+tmp_desc_equ1+"===ret_term_code======="+ret_term_code)
							ret_term_code = tmp_desc_equ + tmp_desc_equ1;
						}
					}
				}
			}
			}
			var tmp_retArr = ret_term_code.split("~");
			//alert(ret_term_code+"=="+tmp_retArr.length+"===="+retVal+"===");
			if(tmp_retArr.length >11){
				alert("APP-MR0023 Only Ten Selections are allowed");
				return false;
			}
			
			top.window.returnValue = ret_term_code ;
		}*/
		retainCodeChk();
		top.window.returnValue = "C" ;
	    parent.window.close();
	}else if(parent.lookup_group.document.forms[0]){
		retainGrpChk()
		top.window.returnValue = "G" ;
		parent.window.close();
	}
}
function closew() {
	call("close_values","");
	top.window.returnValue = parent.lookup_head.document.CriteriaForm.tmp_radioval.value;
    parent.window.close();
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<% String mulitple_yn = request.getParameter("mulitple_yn")==null?"":request.getParameter("mulitple_yn");%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div align='right'>
<table  cellpadding='0' cellspacing='0' >
	<tr>
	<td >
	<%if(mulitple_yn.equals("Y")){%>
		<input type='button' name='ok' id='ok' value='Ok' onClick='ok()'  class='button'>
	<%}%>
		<input type='button' name='close' id='close' value='Close' onClick='closew()' class='button'>
		</td>
	</tr>
</table>
</div>
</body>
</html>

