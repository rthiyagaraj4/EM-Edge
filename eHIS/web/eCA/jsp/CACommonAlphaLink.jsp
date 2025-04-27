<!DOCTYPE html>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script>
function changeAlphaColor(obj){
	if(obj=="celloth"){
		celloth.className="clicked";
			for(var i=0;i<=25;i++){
				var cell =eval("cell"+i);
				cell.className="normal";
			}
	}
	else{
		for(var i=0;i<=25;i++){
			var chk=eval(obj);
			var cell =eval("cell"+i);
				if(chk==cell){	
					chk.className="clicked";
				}
				else{
					cell.className="normal";
				}
		celloth.className="normal";
		}
	}
}
</script>
<table border="0" width="100%" cellspacing="0" cellpadding="0" align='center'>
	<tr>
		<%
		
		String splitLinkStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String linkStr="";
		
		for(int i=0; i<26; i++){
			String alphabet = String.valueOf(splitLinkStr.charAt(i)) ;
			//linkStr += "<td class='normal' align='center' id='cell"+i+"' width='3%'><a href=javascript:callOnAlphaLink('"+alphabet+"','cell"+i+"')  >"+alphabet+"</a></td>";
			linkStr =linkStr+ "<td class='normal' align='center' id='cell"+i+"' width='3%'><a href=javascript:callOnAlphaLink('"+alphabet+"','cell"+i+"')  >"+alphabet+"</a></td>";
		}

		if(!linkStr.equals(""))
			//linkStr += "<td class='normal' id='celloth'  align='center' width='7%'><a href=javascript:callOnAlphaLink('OTH','celloth') >Others</a></td>";
			linkStr =linkStr+ "<td class='normal' id='celloth'  align='center' width='7%'><a href=javascript:callOnAlphaLink('OTH','celloth') >Others</a></td>";
			out.println(linkStr);
		%>
	</tr>
</table>


