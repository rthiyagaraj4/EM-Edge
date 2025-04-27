<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<script>
function ok()
{
  var retVal= new String();
 /* for(var i=0;i<14;i++){
		
	  if(eval(parent.frames[1].document.getElementById("chk"+i)).checked == true){
			
		  var pract_id = eval(parent.frames[1].document.getElementById("pract_id"+i)).value;	
		  var Name = eval(parent.frames[1].document.getElementById("pract_name"+i)).value;	
		  var tel_no = eval(parent.frames[1].document.getElementById("tel_no"+i)).value;	
		  var mobile_no = eval(parent.frames[1].document.getElementById("mobile_no"+i)).value;	
		  var pager_no = eval(parent.frames[1].document.getElementById("pager_no"+i)).value;	
		  var job_title = eval(parent.frames[1].document.getElementById("job_title_practDetails"+i)).value;	
		  var pract_type = eval(parent.frames[1].document.getElementById("pract_type"+i)).value;	
		  var pract_type_desc = eval(parent.frames[1].document.getElementById("pract_type_desc"+i)).value;
		  var position_code = eval(parent.frames[1].document.getElementById("job_code"+i)).value;	
		  var position_desc = eval(parent.frames[1].document.getElementById("job_title"+i)).value;	
		// alert(unescape(Name));
		  while(Name.indexOf("+")!=-1)
		  {
			Name=Name.replace('+'," ");
		  }
		   
		  while(pract_type_desc.indexOf("+")!=-1)
		  {
			pract_type_desc=pract_type_desc.replace('+'," ");
		  }
		  retVal +=pract_id+"~"+unescape(Name)+"~"+tel_no+"~"+mobile_no+"~"+pager_no+"~"+job_title+"~"+pract_type+"~"+pract_type_desc+"~"+position_code+"~"+position_desc+"||"

	  }

  }*/
  var pract_retval= eval(parent.frames[1].document.getElementById("pract_retval")).value;	
  
   for(var i=0;i<14;i++){
	   
	  if(eval(parent.frames[1].document.getElementById("chk"+i)).checked == true){
			
		  var pract_id = eval(parent.frames[1].document.getElementById("pract_id"+i)).value;	
		  var Name = eval(parent.frames[1].document.getElementById("pract_name"+i)).value;	
		  var tel_no = eval(parent.frames[1].document.getElementById("tel_no"+i)).value;	
		  var mobile_no = eval(parent.frames[1].document.getElementById("mobile_no"+i)).value;	
		  var pager_no = eval(parent.frames[1].document.getElementById("pager_no"+i)).value;	
		  var job_title = eval(parent.frames[1].document.getElementById("job_title_practDetails"+i)).value;	
		  var pract_type = eval(parent.frames[1].document.getElementById("pract_type"+i)).value;	
		  var pract_type_desc = eval(parent.frames[1].document.getElementById("pract_type_desc"+i)).value;
		  var position_code = eval(parent.frames[1].document.getElementById("job_code"+i)).value;	
		  var position_desc = eval(parent.frames[1].document.getElementById("job_title"+i)).value;	
		// alert(unescape(Name));
		  while(Name.indexOf("+")!=-1)
		  {
			Name=Name.replace('+'," ");
		  }
		   
		  while(pract_type_desc.indexOf("+")!=-1)
		  {
			pract_type_desc=pract_type_desc.replace('+'," ");
		  }
		  
		  if(pract_retval.indexOf(pract_id) == -1){
		  pract_retval += pract_id+"~"+unescape(Name)+"~"+tel_no+"~"+mobile_no+"~"+pager_no+"~"+job_title+"~"+pract_type+"~"+pract_type_desc+"~"+position_code+"~"+position_desc+"||";
		  }
		 // alert("==in if part==="+pract_retval);

	  }else{

			var pract_id = eval(parent.frames[1].document.getElementById("pract_id"+i)).value;
			if(pract_retval.indexOf(pract_id) != -1){
				var int_val= pract_retval.indexOf(pract_id);
				var tmp_retval="";
				if(int_val!=0){
					tmp_retval= pract_retval.substring(0,int_val);
					//alert("tmp_retval=="+tmp_retval+"==="+pract_retval);
					var tmp_retval1= pract_retval.substring(int_val,(pract_retval.length));
					//alert("tmp_retval1=="+unescape(tmp_retval1));
					var int_val1= unescape(tmp_retval1).indexOf("||");
					//alert(int_val);
					var tmp_retval2= unescape(tmp_retval1).substring((int_val+2),(tmp_retval1.length));
					//alert("tmp_retval1=="+tmp_retval+"==="+tmp_retval2);
					
					pract_retval = tmp_retval+tmp_retval2;
				}else{
					var int_val= unescape(pract_retval).indexOf("||");
					var tmp_retval2= unescape(pract_retval).substring((int_val+2),(pract_retval.length));
					//alert("tmp_retval2===="+tmp_retval2);
					pract_retval = tmp_retval2;
				}
				//alert("==in else part==="+pract_retval);
		   }

	  }

  }
  //alert(retVal);
  retVal = pract_retval.substring(0,(pract_retval.length-2));
 // alert("=="+retVal.length+"===");
  
  window.parent.parent.returnValue=retVal;
  window.parent.close();
}
function closew()
{
  
  window.parent.parent.returnValue=null;
  window.parent.close();
}
</script>
 
<body OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<div align='right'>
<table  cellpadding='0' cellspacing='0' >
			<tr>
			    <td class='button'>
					<input type='button' name='close' id='close' value='Ok' onClick='ok()' class='button'>
					<input type='button' name='close' id='close' value='Close' onClick='closew()' class='button'>
				</td>
			</tr>
</table>
</div>
</body>
</html>


