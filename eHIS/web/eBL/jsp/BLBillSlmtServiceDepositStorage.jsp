
<%@ page import="java.sql.*,java.text.*,oracle.sql.*,oracle.jdbc.*,java.math.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*" %>
  <%@page contentType="text/html; charset=UTF-8"%>
  <%@page import="org.json.simple.JSONObject"%>
<%!

String toDateFormat(String date) throws ParseException{	
	
	if(date==null){
		return "";
	}
	
	String formattedDate;		
    String oldFormat = "dd/MM/yyyy HH:mm:ss";// 2013-10-08 17:15:33.0
    String newFormat = "yyyy-mm-dd hh:mm:ss";
    SimpleDateFormat sdfOld = new SimpleDateFormat(oldFormat);
    SimpleDateFormat sdfNew = new SimpleDateFormat(newFormat);    
	formattedDate=sdfNew.format(sdfOld.parse(date));		
	return formattedDate;	
} 
%>

<%

try{
//     Class.forName("oracle.jdbc.OracleDriver");          
//     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@130.78.62.59:1521:srdv","ibaehis","ibaehis");
    Connection con	=	ConnectionManager.getConnection(request);
    
    String record_count=request.getParameter("total_records");
    int total_records=Integer.parseInt(record_count);
    String checked_records=request.getParameter("checked_records");
    int total_checked_records=Integer.parseInt(checked_records);
    System.out.println("Selected Deposit records" + total_records );
    
    System.out.println(record_count);
       
    /* Array of DEPOSIT_DTLS is Constructed Here  */
	/* StructDescriptor deposit_record_descriptor =  StructDescriptor.createDescriptor("IBAEHIS.DEPOSIT_DTLS",con);
    ArrayDescriptor deposit_array_descriptor = ArrayDescriptor.createDescriptor("IBAEHIS.DEP_DTLS", con);
    */ //V231201
    StringBuffer depDocTypeStr =new StringBuffer();
    StringBuffer depdocNumStr =new StringBuffer();
    StringBuffer depSrlnoStr=new StringBuffer();
    StringBuffer depSlmtTypStr =new StringBuffer();
    StringBuffer depDepositStr =new StringBuffer();
    StringBuffer depAdjAmtStr =new StringBuffer();
    StringBuffer depremarkStr =new StringBuffer();
	Object[] deposit_record_array = new Object[total_records];  // to store n number of object data
    Object[] deposit_object   = new Object[7];  // to store object data
    
    for(int rec_count=0; rec_count<total_records ;rec_count++){
    	boolean checkedRecord=request.getParameter("adjustChk"+rec_count)==null?false:Boolean.parseBoolean(request.getParameter("adjustChk"+rec_count));
    	if(checkedRecord){
    		//depDocTypeStr=request.getParameter("docType"+rec_count);
    		if(!"".equals(request.getParameter("docType"+rec_count))){
    			depDocTypeStr.append(request.getParameter("docType"+rec_count)).append("|");
	    	}else{
	    		depDocTypeStr.append(" ").append("|");
	    	}
    		
    		if(!"".equals(request.getParameter("docNumber"+rec_count))){
    			depdocNumStr.append(Integer.parseInt(request.getParameter("docNumber"+rec_count))).append("|");
	    	}else{
	    		depdocNumStr.append(" ").append("|");
	    	}
    		
    		if(!"".equals(request.getParameter("docSrlNo"+rec_count))){
    			depSrlnoStr.append(Integer.parseInt(request.getParameter("docSrlNo"+rec_count))).append("|");
	    	}else{
	    		depSrlnoStr.append(" ").append("|");
	    	}
    		
    		if(!"".equals(request.getParameter("slmtType"+rec_count))){
    			depSlmtTypStr.append(request.getParameter("slmtType"+rec_count)).append("|");
	    	}else{
	    		depSlmtTypStr.append(" ").append("|");
	    	}
    		
    		if(!"".equals(request.getParameter("deposit"+rec_count))){
    			depDepositStr.append(Double.parseDouble(request.getParameter("deposit"+rec_count))).append("|");
	    	}else{
	    		depDepositStr.append(" ").append("|");
	    	}
    		
    		if(!"".equals(request.getParameter("adjustedAmt"+rec_count))){
    			depAdjAmtStr.append(Double.parseDouble(request.getParameter("adjustedAmt"+rec_count))).append("|");
	    	}else{
	    		depAdjAmtStr.append(" ").append("|");
	    	}
    		if(!"".equals(request.getParameter("remarks"+rec_count))){
    			depremarkStr.append(request.getParameter("remarks"+rec_count)).append("|");
	    	}else{
	    		depremarkStr.append(" ").append("|");
	    	}
    		/* deposit_object[0]=request.getParameter("docType"+rec_count);
	        deposit_object[1]=Integer.parseInt(request.getParameter("docNumber"+rec_count));
	        deposit_object[2]=Integer.parseInt(request.getParameter("docSrlNo"+rec_count));        
	        deposit_object[3]=request.getParameter("slmtType"+rec_count);
	    	deposit_object[4]=Double.parseDouble(request.getParameter("deposit"+rec_count));
	    	deposit_object[5]=Double.parseDouble(request.getParameter("adjustedAmt"+rec_count));
	    	deposit_object[6]=request.getParameter("remarks"+rec_count);
	        STRUCT deposit_record = new STRUCT(deposit_record_descriptor, con, deposit_object);     
	    	deposit_record_array[rec_count]=deposit_record; */
    	}
    }
    
    //ARRAY deposit_parameter_array = new ARRAY(deposit_array_descriptor,con,deposit_record_array);    
   // session.setAttribute("deposit_parameter_array_session",deposit_parameter_array);
   session.setAttribute("depDocTypeStr",depDocTypeStr.toString());
   session.setAttribute("depdocNumStr",depdocNumStr.toString());
   session.setAttribute("depSrlnoStr",depSrlnoStr.toString());
   session.setAttribute("depSlmtTypStr",depSlmtTypStr.toString());
   session.setAttribute("depDepositStr",depDepositStr.toString());
   session.setAttribute("depAdjAmtStr",depAdjAmtStr.toString());
   session.setAttribute("depremarkStr",depremarkStr.toString());
   System.out.println("BLBillSlmtServiceDepositStorage.jsp:"+depDocTypeStr+" "+depdocNumStr+" "+depSrlnoStr+" "+depSlmtTypStr+" "+depDepositStr+" "+depAdjAmtStr+" "+depremarkStr);
    session.setAttribute("deposit_adjusted_payable_amount",(String)request.getParameter("payableAmount"));
    
	//System.out.println(Arrays.asList(deposit_record_array));  
    
	JSONObject obj=new JSONObject();
    obj.put("flag","SUCCESS");    
    out.print(obj);
    out.flush();
     
} catch(Exception e) {
    System.out.println(e);
}
%>
