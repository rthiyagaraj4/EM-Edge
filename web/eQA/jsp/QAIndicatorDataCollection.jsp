<!DOCTYPE html>
<html>
<%@ page import =" java.util.*,webbeans.eCommon.*"  %>

<%
String encounter_id=request.getParameter("encounter_id")==null?" ":request.getParameter("encounter_id");
//String clind_analysis_status=request.getParameter("clind_analysis_status").equals("")?"emty":request.getParameter("clind_analysis_status");
String qind_clind_id=request.getParameter("qind_clind_id")==null?" ":request.getParameter("qind_clind_id");
//String incl_diag_code=request.getParameter("incl_diag_code").equals("")?" ":request.getParameter("incl_diag_code");
//String incl_proc_code=request.getParameter("incl_proc_code").equals("")?" ":request.getParameter("incl_proc_code");
String incl_compl_code=request.getParameter("incl_compl_code").equals("")?" ":request.getParameter("incl_compl_code");
String incl_comments=request.getParameter("incl_comments").equals("")?" ":request.getParameter("incl_comments");
String patient_class=request.getParameter("patient_class")==null?" ":request.getParameter("patient_class");
String incl_yn=request.getParameter("incl_yn")==null?" ":request.getParameter("incl_yn");
String test=request.getParameter("test")==null?" ":request.getParameter("test");

String hashKey=encounter_id+"|"+qind_clind_id+"|"+patient_class;
String hashValue=encounter_id+"|"+qind_clind_id+"|"+incl_compl_code+"|"+incl_comments +"|"+incl_yn+"|"+patient_class;

System.out.println("hashKey "+hashKey);
System.out.println("hashValue "+hashValue);

HashMap collectData1;
ArrayList arr1;
if(session.getAttribute("collectData")!=null)
   {
        collectData1=(HashMap)session.getAttribute("collectData");
        arr1 =(ArrayList)session.getAttribute("arr");
   }
   else
	{
	  collectData1=new HashMap();
	 arr1=new ArrayList();
	 }


if(collectData1 != null)
	{   
		if(arr1!=null)
		{
		arr1.add(hashKey);
		}
		if(arr1.contains(hashKey))
		{
		collectData1.remove(hashKey);
		}
		collectData1.put(hashKey,hashValue);
  }
System.out.println("arrjsp"+arr1);
System.out.println("collectData"+collectData1);
/*session.putValue("arr",arr1);
session.putValue("collectData",collectData1); */


if(!test.equals("yes"))
{
session.setAttribute("arr",arr1);
session.setAttribute("collectData",collectData1); 
}
else
{
System.out.println("arrjsp"+session.getAttribute("arr"));
System.out.println("collectData"+session.getAttribute("collectData"));
}

//collectData.clear();
//arr.clear();
%>



</html>
