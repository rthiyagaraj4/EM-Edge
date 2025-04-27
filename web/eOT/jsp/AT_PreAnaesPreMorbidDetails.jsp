<!DOCTYPE html>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	%>
<html>
<head>

<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript">

	var code=new String();
	function sendparams(index)
	{
		var rows = parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows[index]; 
		var	pre_morbid_code=rows.pre_morbid_code;
		var	pre_morbid_desc=rows.pre_morbid_desc;
		var	remarks=rows.remarks;
		var temp_check=remarks.substring(0,1);
		var	recId = rows.recId;			   
		var mode = "U";
		var str =  pre_morbid_code+"::"+pre_morbid_desc+"::"+remarks+'::'+recId+'::'+mode;
		var frmObj = parent.frames[1];
		frmObj.splitString(str);
	}
	function openDialogWindow(index){
	var rows = parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows[index]; 
	var str = rows.remarks;
	//var remarks = str;
	var remarks=encodeURIComponent(str,"UTF-8");
	if(str==null || str=='undefined' || str=="")str="";
	 window.showModalDialog("../../eOT/jsp/AT_TextAreaRemarksNew.jsp?heading=Remarks&remarks="+remarks,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}
	/*function openDialogWindowNew(index){
	var rows = parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows[index]; 
	var str = rows.remarks;
//	var remarks = encodeURIComponent(str);
	var remarks = str;
	var temp_check=remarks.substring(0,1);
	if(str==null || str=='undefined' || str=="")str="";
	 window.showModalDialog("../../eOT/jsp/TextAreaRemarks.jsp?heading=Remarks&remarks="+remarks,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}*/

	function createTable()
	{    

		 var rows = parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows; 
		  var obj=document.getElementById("test");
		  var tab_data="";
		  var pre_morbid_code="";
		  var pre_morbid_desc = "";
		  var preMorbidStatus_label = getLabel("eOT.PreMorbidStatus.Label","OT");
		  var remarks_label = getLabel("Common.remarks.label","Common");
		  var remarks="";
		  var queryVal="";
		  var recId="";
		  var args="";
		  var preMorbidStatus  =getLabel("eOT.PreMorbidStatus.Label","OT");
		  var Remarks          =getLabel("Common.remarks.label","Common");
		  tab_data="<table border='1' cellpadding=3='3' cellspacing='0' width='100%'>"
		  tab_data+="<td class='COLUMNHEADERCENTER'>"+preMorbidStatus_label+"</td>"
		  tab_data+="<td class='COLUMNHEADERCENTER'>"+remarks_label+"</td>"
		  if(rows!=null && rows.length>0 ){
			for(var jj=0;jj<rows.length;jj++){
			  if(rows[jj]!=null &&  rows[jj].db_mode!='D'){
			   pre_morbid_code=rows[jj].pre_morbid_code;
			   pre_morbid_desc=rows[jj].pre_morbid_desc;
			   remarks=rows[jj].remarks;
			     if(remarks.length>0)
					strRemarks="<B>"+Remarks+"</B>";
			   else
				   strRemarks=""+Remarks+"";
			   recId = rows[jj].recId;			   
			   args = jj;
			   code+=pre_morbid_code+","; 
			   if(jj%2==0)
				 qryVal="QRYEVEN";
			   else
				 qryVal="QRYODD"; 
					tab_data+="<tr><td class="+qryVal+">";
					tab_data+="<a href=\"javascript:sendparams("+args+");\">"+pre_morbid_desc+"</a></td>";
					tab_data+="<td class="+qryVal+">";
					tab_data+="<a href=\"javascript:openDialogWindow("+args+");\">"+strRemarks+"</a></td>";
					tab_data+="</tr>"; 
				}
			  }//for Loop
		  }// end if 
		  tab_data+="</table>";

		  document.getElementById("test").innerHTML = tab_data;
		  document.getElementById("test").style.visibility="visible";
		 parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num= ';
		 //file comiteed
	}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="createTable();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<div id="test"></div>
<form name="pre_morbid_details_form" id="pre_morbid_details_form" >
</form>
</body>
</html>

