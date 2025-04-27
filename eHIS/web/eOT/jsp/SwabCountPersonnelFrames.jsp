<!DOCTYPE html>

<% String params = request.getQueryString(); %>
<!--<iframe name='DetailFrame1' id='DetailFrame1' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no' style='height:0%;width:100vw'></iframe>
<iframe name='DetailFrame2' id='DetailFrame2' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no' style='height:0%;width:100vw'></iframe>
<iframe name='DetailFrame3' id='DetailFrame3' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no' style='height:0%;width:100vw'></iframe>
<iframe name='DetailFrame4' id='DetailFrame4' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no' style='height:0%;width:100vw'></iframe> -->

<!-- Modified by DhanasekarV against issue IN025925 on 21/01/2011 -->


<script language='javascript'>
var personnelrows1 = new Array();
var personnelrowLength1=0;

	
 function createXMLForPersonnel1(oper_num){
  var rows=parent.RecordFrame.personnelrows1;
  var table_name="OT_POST_OPER_PERSONNEL";
  var len = rows.length;
  var xmlString ="";
  for(var i=0;i<len;i++){
	 if(rows[i]!=null &&  rows[i].db_mode!='L'){
		xmlString+="<PER_DTL"+i+" ";
		xmlString+="oper_num=\""+oper_num+"\""+" ";
		xmlString+="speciality_code=\""+rows[i].speciality_code+"\""+" ";
		xmlString+="role_id=\""+rows[i].role_id+"\""+" ";
		xmlString+="role_type=\""+rows[i].role_type+"\""+" ";
		xmlString+="practitioner_id=\""+rows[i].practitioner_id+"\""+" ";
		xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		
	 }
  }
  return xmlString;
}

</script>

	
	    <iframe name='RecordFrame' id='RecordFrame' SRC='../../eOT/jsp/SwabCountPersonnelRecord.jsp?<%=params%>'  scrolling='no' noresize='no' style='height:30vh;width:100vw;border:0'></iframe> 
	<iframe name='DetailFrame' id='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no' style='height:70vh;width:100vw;border:0'></iframe>
 

