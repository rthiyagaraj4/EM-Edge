<!DOCTYPE html>
<%@page import="oracle.sql.*"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.sql.Date,java.text.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html;charset=UTF-8"
	import="java.sql.*,eBL.Common.*,eCommon.Common.*,webbeans.eCommon.*"%>
<%@page import="org.json.simple.JSONObject"%>

<%! 
Integer toIntegerFormat(String number){	
	if(number==null || number.equals("")){
		return 0;
	}	
	Integer formattedNumber;		
	formattedNumber=Integer.parseInt(number);
	return formattedNumber;		
}

Double toDoubleFormat(String number){	
	if(number==null || number.equals("")){
		return 0.0;
	}	
	Double formattedNumber;		
	formattedNumber=Double.parseDouble(number);
	return formattedNumber;		
}

String toDateFormat(String date,int type) throws ParseException{	
	if(date==null || date.equals("")){
		return null;
	}	
	String formattedDate;	
    String oldFormat = "dd/MM/yyyy HH:mm";// 2013-10-08 17:15:33.0
	if(type==1){
		oldFormat = "dd/MM/yyyy HH:mm";
	}else if(type==2){
		oldFormat = "dd/MM/yyyy";
	}

    String newFormat = "yyyy-MM-dd hh:mm:ss";
    SimpleDateFormat sdfOld = new SimpleDateFormat(oldFormat);
    SimpleDateFormat sdfNew = new SimpleDateFormat(newFormat);    
	formattedDate=sdfNew.format(sdfOld.parse(date));	
	return formattedDate;		
}
%>

<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	CallableStatement statement = null;
	StringBuffer sb = new StringBuffer("") ;
	boolean insertable = true;
	String facilityId = request.getParameter("facilityId");
	String billCount = request.getParameter("billCount");
	String userId = request.getParameter("userId");
	System.out.println("USER: " + userId);
	String patientId = request.getParameter("patientId");
	String episodeType = request.getParameter("episodeType");
	String episodeId = request.getParameter("episodeId");
	String visitId = request.getParameter("visitId");
	String docTypeCode = request.getParameter("docTypeCode");
	String docNum = request.getParameter("docNum");
	String billTotAmt = request.getParameter("billTotAmt");
	String totOutStdAmt = request.getParameter("totOutStdAmt");
	String billDocDate = request.getParameter("billDocDate");
	//System.out.println("newArray: " + newArray);
	

	try {
		con = ConnectionManager.getConnection();
		
		String[] dataArray = {patientId, episodeType, episodeId, visitId, docTypeCode, docNum, billTotAmt, billDocDate,totOutStdAmt,"","","","","",""};
		StructDescriptor bill_doc_record_descriptor =  StructDescriptor.createDescriptor("IBAEHIS.BILL_DOC_NUMBERS",con);
		Object[] bill_doc_numbers_object   = new Object[15];  // to store object data
		
		bill_doc_numbers_object[0]=patientId;
	    bill_doc_numbers_object[1]=episodeType;
	    bill_doc_numbers_object[2]=toIntegerFormat(episodeId);
	    bill_doc_numbers_object[3]=toIntegerFormat(visitId);
	    bill_doc_numbers_object[4]=docTypeCode;
	    bill_doc_numbers_object[5]=toIntegerFormat(docNum);
	    bill_doc_numbers_object[6]=toDoubleFormat(billTotAmt);
	    bill_doc_numbers_object[7]=toDateFormat(billDocDate,1);
	    bill_doc_numbers_object[8]=toDoubleFormat(totOutStdAmt);
	    bill_doc_numbers_object[9]=toDoubleFormat("0");
	    System.err.println("bill_doc_numbers_object[9] ->"+bill_doc_numbers_object[9]);
	    bill_doc_numbers_object[10]="";
	    bill_doc_numbers_object[11]="";
	    bill_doc_numbers_object[12]="";
	    bill_doc_numbers_object[13]="";
	    bill_doc_numbers_object[14]="";
	    
		STRUCT bill_doc_numbers_record = new STRUCT(bill_doc_record_descriptor, con, bill_doc_numbers_object);
		ArrayDescriptor bill_doc_array_descriptor = ArrayDescriptor.createDescriptor("IBAEHIS.BILL_DTLS", con);
		Object[] bill_doc_numbers_record_array = new Object[1];
		bill_doc_numbers_record_array[0]=bill_doc_numbers_record;
		ARRAY bill_doc_numbers_parameter_array = new ARRAY(bill_doc_array_descriptor,con,bill_doc_numbers_record_array); 
		
		statement=con.prepareCall("{call PROC_MAX_BILL_REPRINT_COUNT(?,?,?,?,?)}");
		statement.setString(1, facilityId);
		statement.setArray(2, bill_doc_numbers_parameter_array);
		statement.setString(3, userId);
		statement.registerOutParameter(4,java.sql.Types.VARCHAR);
		statement.registerOutParameter(5,java.sql.Types.VARCHAR);
		statement.execute();
		String strErrNum = statement.getString(4);
		String strErrText = statement.getString(5);
		System.out.println(strErrNum + "..." + strErrText);
		if ("10".equals(strErrNum) && strErrText != null) {
			if (!(strErrNum.equals("")) || !(strErrText.equalsIgnoreCase("null") )) {
				insertable=false;
				sb.append("Exception while calling procedure proc_max_bill_reprint_count :"+strErrText);  
			}
			out.println(strErrNum+"::::"+strErrText);
		}else {
			out.println("true::::true");
		}
		statement.close();
	} catch(Exception e) {  
		insertable=false;
		sb.append("Exception while calling procedure proc_max_bill_reprint_count :"+e);  
		e.printStackTrace();
	}
		%>
