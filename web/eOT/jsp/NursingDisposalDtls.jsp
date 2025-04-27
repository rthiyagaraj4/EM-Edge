<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
String  nursing_doc_comp_yn = checkForNull(request.getParameter("nursing_doc_comp_yn") );
%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eOT/js/RecordNursing.js"></script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript">
var code=new String();
function sendparams(index){
	var rows = parent.parent.ObjectCollect.disposal_rows[index]; 
	var anatomical_code=rows.anatomical_code;
	var anatomical_desc=rows.anatomical_desc;
	var	disposal_code=rows.disposal_code;
	var	disposal_desc=rows.disposal_desc;
			   //Added replace for 26039 on 1/21/2011 by AnithaJ
	var given_by = decodeURIComponent(rows.given_by,"UTF-8").replace(/\+/g," ");
	var received_by = decodeURIComponent(rows.received_by,"UTF-8").replace(/\+/g," ");
	var recId = rows.recId;			   
	var mode = "U";
	var str = anatomical_code+'::'+anatomical_desc+'::'+disposal_code+'::'+disposal_desc+'::'+given_by+'::'+received_by+'::'+recId+'::'+mode;
	var frmObj = parent.parent.RecordFrame.RecordFrame;
	frmObj.splitString(str);
}

function createTable(){    
  var rows = parent.parent.ObjectCollect.disposal_rows; 
  var tab_data="";
  var queryVal="";
  var args="";
  tab_data="<table border='1' cellpadding=3 cellspacing='0' width='100%'>"
  tab_data+="<th class='columnHeaderCenter'><fmt:message key='eOT.DisposedItem.Label' bundle='${ot_labels}'/></th>"
  tab_data+="<th class='columnHeaderCenter'> <fmt:message key='eOT.DisposalDescription.Label' bundle='${ot_labels}'/></th>"
  tab_data+="<th class='columnHeaderCenter'> <fmt:message key='Common.givenby.label' bundle='${common_labels}'/></th>"
  tab_data+="<th class='columnHeaderCenter'> <fmt:message key='Common.ReceivedBy.label' bundle='${common_labels}'/></th>"
  	if(rows!=null) {
	  	 for(var jj=0;jj<rows.length;jj++){
		  	if(rows[jj]!=null && rows[jj].db_mode!='D'){
			    args = jj;
			   code+=rows[jj].anatomical_code+rows[jj].disposal_code+","; 
			   if(jj%2==0)
			     qryVal="gridData";
			   else
			    qryVal="gridData"; 	

  			  <% if( nursing_doc_comp_yn.equals("Y") ) { %>
			   tab_data+="<tr>";
			   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].anatomical_desc+"</td>";
			   tab_data+="<td nowrap class="+qryVal+">"+decodeURIComponent(rows[jj].disposal_desc)+"</td>";

			   //Added replace for 26039 on 1/21/2011 by AnithaJ

			  tab_data+="<td nowrap class="+qryVal+">"+decodeURIComponent(rows[jj].given_by,"UTF-8").replace(/\+/g," ")+"</td>";
			   tab_data+="<td nowrap class="+qryVal+">"+decodeURIComponent(rows[jj].received_by,"UTF-8").replace(/\+/g," ")+"</td>";

			   tab_data+="</tr>"; 
			  <% } else {%>
				tab_data+="<tr><td class="+qryVal+">";
				tab_data+="<a class='gridLink' href=\"javascript:sendparams("+args+");\">"+rows[jj].anatomical_desc+"</a></td>";
			   tab_data+="<td nowrap class="+qryVal+">"+decodeURIComponent(rows[jj].disposal_desc)+"</td>";
   			   //Added replace for 26039 on 1/21/2011 by AnithaJ

			   tab_data+="<td nowrap class="+qryVal+">"+decodeURIComponent(rows[jj].given_by,"UTF-8").replace(/\+/g," ")+"</td>";
			   tab_data+="<td nowrap class="+qryVal+">"+decodeURIComponent(rows[jj].received_by,"UTF-8").replace(/\+/g," ")+"</td>";
			   tab_data+="</tr>"; 
			  <% } %>
			}
	  }//end of for Loop
  }// end if 
  	
   tab_data+="</table>";
   document.getElementById("test").innerHTML = tab_data;
  document.getElementById("test").style.visibility="visible";
  parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onLoad="createTable();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div id="test"></div>
<form name="DisposalDetailsForm" id="DisposalDetailsForm" >
</form>
</body></html>

