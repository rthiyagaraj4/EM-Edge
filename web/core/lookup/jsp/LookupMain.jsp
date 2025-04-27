<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>
<script type="text/javascript">


	window.document.title=top.dialogArguments[6]

var reqStr;
if(dialogArguments["CODE"]!=undefined && dialogArguments["DESC"]!=undefined ){
	reqStr= "code="+dialogArguments["CODE"]+"&desc="+dialogArguments["DESC"]
}
	
		document.write('<iframe name="lookupCriteria" id="lookupCriteria"   scrolling="auto"/ style='height:11%;width:100vw'></iframe><iframe name="lookupResult" id="lookupResult"  / style='height:100vh;width:100vw'></iframe><iframe name="lookupCriteria" id="lookupCriteria" src="LookUpClose.jsp" / style='height:11%;width:100vw'></iframe>');
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</html>

