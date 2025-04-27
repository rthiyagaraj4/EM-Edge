<!DOCTYPE html>


<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	%>

<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_RecordIntraAnesthesia.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOT/js/Booking.js"></script>
	<script language="javascript">
	var code=new String();

	function sendparams(index)
	{
		var rows = parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_rows[index]; 
		var	pract_type=rows.pract_type;
		var	desc_userdef=rows.desc_userdef;
		var	practitioner_id=rows.practitioner_id;
		var	practitioner_name=rows.practitioner_name;
		var	recId = rows.recId;			   
		var mode = "U";
		var str =  pract_type+"::"+desc_userdef+"::"+practitioner_id+"::"+practitioner_name+'::'+recId+'::'+mode;
		var frmObj = parent.frames[0];
		frmObj.splitString(str);
	}

	function createTable()
	{    
		 var rows = parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_rows;
 
		  var obj=document.getElementById("test");
		  var tab_data="";
		  var pract_type="";
		  var desc_userdef = "";
		  var practitioner_id="";
		  var practitioner_name = "";
		  var queryVal="";
		  var recId="";
		  var Role	=getLabel("Common.Role.label","Common");
		  var Name		=getLabel("Common.name.label","Common");
		  var Position =getLabel("Common.Position.label","Common");
			 
		  
		  var args="";
		  tab_data="<table border='1' cellpadding=3='3' cellspacing='0' width='100%'>"
		  tab_data+="<td class='COLUMNHEADERCENTER' align='center'>"+Role+"</td>";
		  tab_data+="<td class='COLUMNHEADERCENTER' align='center'>"+Name+"</td>";
		  tab_data+="<td class='COLUMNHEADERCENTER' align='center'>"+Position+"</td>";
		  if(rows!=null && rows.length>0 ){
			for(var jj=0;jj<rows.length;jj++){
						  
			  if(rows[jj]!=null &&  rows[jj].db_mode!='D'){
			   pract_type=rows[jj].pract_type;
			   desc_userdef=rows[jj].desc_userdef;
			   practitioner_id=rows[jj].practitioner_id;
			   practitioner_name=rows[jj].practitioner_name;
			  // d_mode=rows[jj].db_mode;
			   recId = rows[jj].recId;			   
			   args = jj;
			   code+=practitioner_id+","; 
			 //  d_mode+=d_mode+","; 
			   if(jj%2==0)
				 qryVal="QRYEVEN";
			   else
				 qryVal="QRYODD"; 
					tab_data+="<tr><td class="+qryVal+">";
					tab_data+="<a href=\"javascript:sendparams("+args+");\">"+desc_userdef+"</a></td>";
					tab_data+="<td class="+qryVal+">"+practitioner_name+"</td>";
					tab_data+="<td class="+qryVal+">"+rows[jj].position_desc+"</td>";
					tab_data+="</tr>"; 
				}
			  }//end of for Loop
		  }// end if 
			
			tab_data+="</table>";
		  document.getElementById("test").innerHTML = tab_data;
		  document.getElementById("test").style.visibility="visible";
		  parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num= ';//not req.
	}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onLoad="createTable();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div id="test"></div>
<form name="pre_morbid_details_form" id="pre_morbid_details_form" >
</form>
</body>
</html>

