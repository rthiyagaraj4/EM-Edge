<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language="javascript">	

var code=new String();
var srl = new String();
var intra = new String();//Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 22/02/2013
function sendparams(index){
	var rows = window.parent.parent.frames[1].frames[1].rows[index];
	var checklist_item_code=rows.checklist_item_code;
	//alert(checklist_item_code);
	var checklist_item_srl_no=rows.checklist_item_srl_no;
	var intra_operative_sel_val= rows.intra_operative_sel_val;//Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 22/02/2013
	//alert(checklist_item_srl_no);
	var description=rows.description;
	//alert(description);
	var recId =rows.recId;
	var mode="U";
	var str = checklist_item_srl_no+"::"+checklist_item_code+"::"+description+"::"+recId+"::"+mode+"::"+intra_operative_sel_val;//Maheshwaran K Modified for the CHL-CRF-0043 [IN:035927] as on 22/02/2013
	var frmObj = window.parent.parent.frames[1].frames[3];
	//alert(window.parent.parent.frames[1].frames[3].name);//RecordFrame
	frmObj.splitString(str);
}
function createTable(){ 
	 var rows=window.parent.parent.frames[1].frames[1].rows;
	 //alert(rows.length);
	 var args="";
	 tab_data="<table border='1' cellpadding='3' cellspacing='0' width='100%'>";
	
	  tab_data+="<th class=ColumnHeader align='center'><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></th>"
	  tab_data+="<th class=ColumnHeader align='center'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>"
	  tab_data+="<th class=ColumnHeader align='center'><fmt:message key="eOT.ChecklistItemCode.Label" bundle="${ot_labels}"/></th>"
	//Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 22/02/2013
	//Start
	  tab_data+="<th class=ColumnHeader align='center'><fmt:message key="eOT.IntraOperativeApplicable.Label" bundle="${ot_labels}"/></th>"
	//End
	 if(rows!=null){
	  for(var jj=0;jj<rows.length;jj++){
		if( rows[jj]!=null&&rows[jj].mode!="D")	{
		   srl+=rows[jj].checklist_item_srl_no+","; 
		   code+=rows[jj].checklist_item_code+",";
		   intra+=rows[jj].intra_operative_sel+",";//Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 22/02/2013
		  	if(jj%2==0) qryVal="QRYEVEN";
			   else
				 qryVal="QRYODD"; 
	     	      args=jj;
			 
				   tab_data+="<tr><td class="+qryVal+">";
				   tab_data+="<a href=\"javascript:sendparams("+args+");\">"+rows[jj].checklist_item_srl_no+"</a></td>";
				   tab_data+="<td class="+qryVal+">"+rows[jj].description+"</td>";
				   tab_data+="<td class="+qryVal+">"+rows[jj].checklist_item_code+"</td>";
				   //Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 22/02/2013
					//Start
					tab_data+="<td class="+qryVal+">&nbsp;";
					if(rows[jj].intra_operative_sel!=null)
						{
						rows[jj].intra_operative_sel_val=rows[jj].intra_operative_sel;
						if(rows[jj].intra_operative_sel=='B')
						rows[jj].intra_operative_sel_name='Both';
						if(rows[jj].intra_operative_sel=='I')
						rows[jj].intra_operative_sel_name='Intra Operative';
						}
					if(rows[jj].intra_operative_sel_val=="N")
						{
						tab_data+="<input name=intra_operative_sel type=hidden value="+rows[jj].intra_operative_sel_val+" >";
						}
					else{
					tab_data+="<select name=intra_operative_sel onChange='SetIntra(this,"+jj+")'><option value="+rows[jj].intra_operative_sel_val+">"+rows[jj].intra_operative_sel_name+"</option>";
					if(rows[jj].intra_operative_sel_val=="B")
					tab_data+="<option value='I'>Intra Operative</option>";
					if(rows[jj].intra_operative_sel_val=="I")
					tab_data+="<option value='B'>Both</option>";
					tab_data+="</select>";}
					tab_data+="</td>";
				   //End
				   tab_data+="</tr>";
			  
		  }
	  }//end of for Loop
  }// end if 
  	
	tab_data+="</table>";

  //alert(tab_data);
  document.getElementById("test").innerHTML = tab_data;
  document.getElementById("test").style.visibility="visible";
 
  //window.parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
  
}
//Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 22/02/2013
//Start
function SetIntra(obj,index)
	{
	window.parent.parent.frames[1].frames[1].rows[index].intra_operative_sel_val=obj.value;
	}
//End	
</script>
</head>
<body onLoad="createTable();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div id="test"></div>
<form name="ChecklistsDetailForm" id="ChecklistsDetailForm" >


</form>
</body>

