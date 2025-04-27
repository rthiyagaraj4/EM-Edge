<HTML>
<%@ page import = "java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%

	String patientID = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String encounterID = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	String clearBean = request.getParameter("clearBean") == null ? "" : request.getParameter("clearBean");

	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patientID+encounterID,"eCA.PatientBannerGroupLine",session);

	String manageMailVal = request.getParameter("manageMailVal") == null ? "" :request.getParameter("manageMailVal");
	String valsToSort = request.getParameter("valsToSort") == null ? "" :request.getParameter("valsToSort");

	String rowNum = request.getParameter("rowNum") == null ? "" :request.getParameter("rowNum");
	String delete = request.getParameter("delete") == null ? "No" :request.getParameter("delete");
	String addRemove = request.getParameter("addRemove") == null ? "Add" :request.getParameter("addRemove");
	String valsToRemove = request.getParameter("valsToRemove") == null ? "" :request.getParameter("valsToRemove");

	ArrayList list = manageEmailBean.returnList1();
	ArrayList sortList = manageEmailBean.returnSortList();
	ArrayList keyList2 = manageEmailBean.returnList2();

/*	out.println("List 1="+list+"=<BR>");           
	out.println("List 2="+keyList2+"=<BR>");  
	out.println("sortList ="+sortList+"=<BR>");*/
	
/*	out.println("patientID ="+patientID+"=");
	out.println("encounterID ="+encounterID+"=");
	out.println("clearBean ="+clearBean+"=");*/
	//out.println("manageMailVal ="+manageMailVal+"=");
	//out.println("valsToSort ="+valsToSort+"=");
	//out.println("rowNum ="+rowNum+"=");
/*	out.println("delete ="+delete+"=");
	out.println("addRemove ="+addRemove+"=");
	out.println("valsToRemove ="+valsToRemove+"=");*/

	try
	{
		if(!clearBean.equals("Yes"))
		{
			if(rowNum.equals(""))
			{
				if(addRemove.equals("Add"))
				{
					if(!(list.contains(manageMailVal)))
						manageEmailBean.addRecordstoLine1(manageMailVal);
					if(!sortList.contains(valsToSort)) 
						manageEmailBean.addRecordsToSortList(valsToSort);
					if(!keyList2.contains(valsToRemove)) 
						manageEmailBean.addRecordstoLine2(valsToRemove);
				}
				else if(addRemove.equals("Remove"))
				{
					if((list.contains(manageMailVal)))
						list.remove(manageMailVal);
					if(sortList.contains(valsToSort)) 
						sortList.remove(valsToSort);
					if(keyList2.contains(valsToRemove))
						keyList2.remove(valsToRemove);
				}
			}
			else
			{
				if(delete.equals("Yes"))
				{
//					out.println("="+manageMailVal+"=<BR>");
	//				out.println("="+list.contains(manageMailVal)+"=<BR>");
					list.remove(manageMailVal);
					sortList.remove(valsToSort);
					keyList2.remove(valsToRemove);
				}
				else
				{
					if(!keyList2.contains(valsToRemove))
					{
//						manageEmailBean.addRecordstoLine1(manageMailVal);
						manageEmailBean.addRecordstoLine2(valsToRemove);
					}
					if(!sortList.contains(valsToSort))
						manageEmailBean.addRecordsToSortList(valsToSort);
				}
			}
		}
		else if(clearBean.equals("Yes"))
		{			
			manageEmailBean.clearBean();
		}
		putObjectInBean("manageEmailBean"+patientID+encounterID,manageEmailBean,session);
	}
	catch(Exception e)
	{
		
		out.println("Exception at try of EncountersManageEmail.jsp--"+e.toString());
		e.printStackTrace();
	}

	/*list = manageEmailBean.returnList1();            
	sortList = manageEmailBean.returnSortList(); 
	keyList2 = manageEmailBean.returnList2();

	out.println("Final List 1 ="+list+"=<BR>");
	out.println("Final List 2="+keyList2+"=<BR>");
	out.println("Final sortList ="+sortList+"=<BR>");*/

/*	for(int t=0;t<list.size();t++)
	{
		out.println("="+(String)list.get(t)+"=<BR>");
	}*/
%>
</HTML>
