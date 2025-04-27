<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script>
function changeAlphaColor(obj){
	if(obj=="celloth"){
		celloth.className="normal";
			for(var i=0;i<=25;i++){
				var cell =eval("cell"+i);
				cell.className="cagroup";
			}
	}
	else{
		for(var i=0;i<=25;i++){
			var chk=eval(obj);
			var cell =eval("cell"+i);
				if(chk==cell){	
					chk.className="normal";
				}
				else{
					cell.className="cagroup";
				}
		celloth.className="cagroup";
		}
	}
}
</script>
<table border="0" width="100%" cellspacing="0" cellpadding="0" align='center' style='background-color:#D5E2E5; color: white;'>
	<tr>
		<%
		
		String splitLinkStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String linkStr="";
		
		for(int i=0; i<26; i++){
			String alphabet = String.valueOf(splitLinkStr.charAt(i)) ;
			//linkStr += "<td class='normal' align='center' id='cell"+i+"' width='3%'><a href=javascript:callOnAlphaLink('"+alphabet+"','cell"+i+"')  >"+alphabet+"</a></td>";
			linkStr =linkStr+ "<td class='cagroup' align='center' id='cell"+i+"' width='3%'><a class='gridLink' href=javascript:callOnAlphaLink('"+alphabet+"','cell"+i+"')  >"+alphabet+"</a></td>";
		}

		if(!linkStr.equals(""))
			//linkStr += "<td class='normal' id='celloth'  align='center' width='7%'><a href=javascript:callOnAlphaLink('OTH','celloth') >Others</a></td>";
			linkStr =linkStr+ "<td class='cagroup' id='celloth'  align='center' width='7%'><a class='gridLink' href=javascript:callOnAlphaLink('OTH','celloth') >Others</a></td>";
			out.println(linkStr);
		%>
	</tr>
</table>


