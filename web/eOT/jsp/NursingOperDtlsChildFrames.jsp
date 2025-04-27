<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>

<%  
	String params = request.getQueryString(); 
	String trace = "0";
	String tab_id = "";
	String tab ="";
	String qry_mode_flag= "";
	String cols_value = "";
	String URL=""; 
	int choice=1;
try{
	tab_id = request.getParameter("tab_id").intern();
	trace="1";
	tab =request.getParameter("tab");
	tab=tab==null?"":tab;
	tab=tab.equals("null")?"":tab;
	if(!tab.equals("")){
		tab=tab.intern();
	}
	trace="2";
	qry_mode_flag= checkForNull(request.getParameter("qry_mode_flag"),"N");
	trace="3";
	cols_value = ("OperationsTab".equals(tab_id) || ("record_surgeon".equals(tab) && "ImplantsTab".equals(tab_id)) || "Y".equals(qry_mode_flag ))?"0%,*":"46%,*";
	trace="4";
    if("ImplantsTab".equals(tab_id) && "record_nursing".equals(tab))
	{
		cols_value="56%,*";
	}
	choice=(tab_id=="InstrumentsTab")?2:(tab_id=="EquipmentsTab")?3:(tab_id=="ConsumableTab")?4:(tab_id=="ImplantsTab")?5:1;
	trace="5";
	/*if(tab_id.equals("OperationsTab")){
		choice = 1;
	}else if(tab_id.equals("InstrumentsTab")){
		choice=2;
	}else if(tab_id.equals("EquipmentsTab")){
		choice=3;
	}else if(tab_id.equals("ConsumableTab")){
		choice=4;
	}else if(tab_id.equals("ImplantsTab")){
		choice=5;
	}*/
		
	switch(choice){
		case 1:
			     URL = "../../eOT/jsp/SurgeonOperationRecord.jsp?"+params;
				trace="6";
				 break;

		case 2:  URL = "../../eOT/jsp/InstrumentRecord.jsp?"+params;
				trace="7";
				 break;

		case 3:  URL = "../../eOT/jsp/EquipmentsRecord.jsp?"+params;
				trace="8";
				 break;

		case 4:  URL = "../../eOT/jsp/ConsumablePacksRecord.jsp?"+params;
				trace="9";
				 break;

		case 5:  URL = "../../eOT/jsp/ImplantsRecord.jsp?"+params;
				trace="10";
				 break;
		
		}
	}catch(Exception e){
		e.printStackTrace(); 
		//System.err.println("NursingOperDtlsChildFrames: Exception: 60, trace==="+trace);
		//System.err.println("NursingOperDtlsChildFrames: Exception: 61, choice==="+choice);
		//System.err.println("NursingOperDtlsChildFrames: Exception: 62, e==="+e);
	}
%>

<FRAMESET ROWS='<%=cols_value%>' border='0'>	
	 <FRAME name='RecordFrame' id='RecordFrame' SRC='<%=URL%>'  scrolling='no' noresize='no'></FRAME> 
	<FRAME name='ResultsFrame' id='ResultsFrame' SRC='../../eCommon/html/blank.html'   scrolling='auto' noresize='no'></FRAME>
</FRAMESET>




 

