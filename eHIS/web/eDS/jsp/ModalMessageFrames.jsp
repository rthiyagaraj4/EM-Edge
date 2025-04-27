<!DOCTYPE html>
<html>
<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/eDS/js/MealPreparedServedComplaints.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><%=request.getParameter("title")%></title>
<script>
function reset()
{
	window.returnValue=true; 
	window.close();
}
</script>
	<iframe name="linenDeliver" id="linenDeliver" scrolling='no' src='../../eDS/jsp/MealPrepareServedRejectedItems.jsp?method=1&rejectedItem=Y&encounterId=<%=request.getParameter("encounterId")%>&mealType=<%=request.getParameter("mealType")%>&servingDate=<%=request.getParameter("servingDate")%>&languageId=<%=request.getParameter("languageId")%>&eventDate=<%=request.getParameter("eventDate")%>&sourceCode=<%=request.getParameter("sourceCode")%>&patientClass=<%=request.getParameter("patientClass")%>&kitchenCode=<%=request.getParameter("kitchenCode")%>&patientId=<%=request.getParameter("patientId")%>&dietType=<%=request.getParameter("dietType")%>&mealClass=<%=request.getParameter("mealClass")%>&complaintDesc=<%=request.getParameter("complaintDesc")%>&complaintCode=<%=request.getParameter("complaintCode")%>&status=<%=request.getParameter("status")%>&menuCode=<%=request.getParameter("menuCode")%>&mealCategory=<%=request.getParameter("mealCategory")%>&splFoodItemYn=<%=request.getParameter("splFoodItemYn")%>&fName=<%=request.getParameter("fName")%>&othersComp=<%=request.getParameter("othersComp")%>&isMealComplaints=<%=request.getParameter("isMealComplaints")%>' / style='height:91vh;width:97vw;border:4'></iframe>
		<!-- Added Against ML-MOH-CRF-1125(othersComp) -- >
		
		<iframe scrolling="no" name="messageFrame" id="messageFrame" src= "<%=request.getContextPath()%>/core/jsp/MessageFrame.jsp" / style="height:7vh;width:100vw;border:4"></iframe>
</html>

