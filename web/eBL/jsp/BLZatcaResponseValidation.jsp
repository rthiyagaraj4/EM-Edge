<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*,java.io.*,java.util.*,org.jdom.*,org.jdom.input.SAXBuilder, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>   


<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%!
private String checkForNull(String input){
	
	if(input == null || "null".equals(input)){
		input = "null";
	}
	return input;
}

private Hashtable parseXMLString1(String var1) {
      Hashtable var2 = new Hashtable();
      try {
		 Reader inputString = new StringReader(var1);
		 BufferedReader var3 = new BufferedReader(inputString);
         // BufferedReader var3 = var1.getReader();
         SAXBuilder var4 = new SAXBuilder();
         Document var5 = var4.build(var3);
         Element var6 = var5.getRootElement();
         ListIterator var7 = var6.getChildren().listIterator();

         while(var7.hasNext()) {
            Element var8 = (Element)var7.next();
            Hashtable var9 = new Hashtable();
            List var10 = var8.getAttributes();
            Iterator var11 = var10.iterator();
            while(var11.hasNext()) {
               Attribute var12 = (Attribute)var11.next();
               String var13 = var12.getValue().replace('"', '\n');
               var9.put(var12.getName(), var13);
            }
            var2.put(var8.getName(), var9);
         }
      } catch (Exception var14) {
		  System.err.println("error in parseXMLSStirng 1  "+var14.toString());
         var2.put("error", var14.toString());
      }
      return var2;
   }
%>
<%

Connection con = null;
try 
	{
		con = ConnectionManager.getConnection(request);
		System.err.println("BLZatcaResponseValidation.jsp...........................................................");
		request.setCharacterEncoding("UTF-8");
		String locale = (String) session.getAttribute("LOCALE");
		String xmlValues=checkForNull(request.getParameter("xmlStr"));
		System.err.println("Inside MaintainTreatValidation::::xmlValues  "+xmlValues);
		Hashtable hash				= (Hashtable)parseXMLString1( xmlValues ) ;
		System.err.println(" hash .... Inside BLZatcaResponseValidation:::: "+hash);
		hash = (Hashtable) hash.get("SEARCH");
		System.err.println(" hash .... Inside BLZatcaResponseValidation1:::: "+hash);
		
		
		String zatcaBillDtlsString="";
		
		ArrayList<String> zatcaResubmissionRecord = new ArrayList<String>();

		HashMap<String,ArrayList<String>>  zatcaResubmissionRecords=new HashMap<String,ArrayList<String>>();
		
		int totalRecords=Integer.parseInt((String)hash.get("totalRecords"));
	
		System.err.println("totalRecords..hdr.........."+totalRecords);
		
		for (int i = 1; i<=totalRecords; i++) 
		{
			 	 
			String selectedIndex=(String) hash.get("selectedIndex_"+i);
			if(selectedIndex.equals("") || selectedIndex.equals("null") || selectedIndex == null)
			{
				selectedIndex="N";
			}
			System.err.println("selectedIndex............"+selectedIndex);
			
			String doc_type_code = (String) hash.get("doc_type_code_"+i);
			if(doc_type_code.equals("") || doc_type_code.equals("null") || doc_type_code == null)
			{
				doc_type_code="null";
			}
			
			String doc_num = (String) hash.get("doc_num_"+i);
			if(doc_num.equals("") || doc_num.equals("null") || doc_num == null)
			{
				doc_num="null";
			}
			
			String oper_fac_id = (String) hash.get("oper_fac_id_"+i);
			if(oper_fac_id.equals("") || oper_fac_id.equals("null") || oper_fac_id == null)
			{
				oper_fac_id="null";
			}	
			
			String ACTIVE_FLAG_YN = (String) hash.get("ACTIVE_FLAG_YN_"+i);
			if(ACTIVE_FLAG_YN.equals("") || ACTIVE_FLAG_YN.equals("null") || ACTIVE_FLAG_YN == null)
			{
				oper_fac_id="Y";
			}			

			zatcaBillDtlsString=selectedIndex+"|"+doc_type_code+"|"+doc_num+"|"+oper_fac_id+"|"+ACTIVE_FLAG_YN;
					
			//System.err.println("zatcaBillDtlsString"+zatcaBillDtlsString);
				
			zatcaResubmissionRecord.add(zatcaBillDtlsString);
				
			//System.err.println("zatcaResubmissionRecord : : "+zatcaResubmissionRecord);			
		}
		zatcaResubmissionRecords.put("ZATCA",zatcaResubmissionRecord);

		session.setAttribute("ZATCARESUBMISSIONRECORDS", zatcaResubmissionRecords);

		System.err.println("zatcaResubmissionRecords"+zatcaResubmissionRecords);
	}
	catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception from BLZatcaResponseValidation.jsp :"+ e);
	}
%>
