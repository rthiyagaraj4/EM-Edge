
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eOR.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
try
{    
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	boolean depend_flag = true;
	int seq=0;
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	if ( validate == null )validate="";
	String finalTest = request.getParameter("finalString");
	String seq1 = request.getParameter("seq");
	if(seq1 != null &&  !seq1.equals(""))
		seq=Integer.parseInt(seq1);
	String result = "";//String result1 = "";
	String from = "";//String result1 = "";
	result = finalTest;	
	OrderEntryFormats beanObj = (OrderEntryFormats)getBeanObject( bean_id , "eOR.OrderEntryFormats", request) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	if(hash.containsKey("from"))
		from = (String)hash.get("from");
	if(validate.equals("size"))
	{
		TreeMap formatFinalValues=beanObj.getFormatFinalValues();
		int size=formatFinalValues.size();
		out.println(size);
	}
	else if(validate.equals("createclear"))
	{
		TreeMap formatFinalValues=beanObj.getFormatFinalValues();
		formatFinalValues.clear();
	}
	else
	{
	if(depend_flag == true){
		if(hash.containsKey("seq_no"))
		{
			String seq_no = (String)hash.get("seq_no") ;		
			String level = request.getParameter("level");
			String order_category = request.getParameter("order_category");
			String order_catalog = request.getParameter("order_catalog");
			String order_type = request.getParameter("order_type");
			String mnemonic = request.getParameter("mnemonic");
			String dep_values="";
			//StringBuffer dep_values=new StringBuffer();
			ArrayList depend_values = new ArrayList();
			depend_values = beanObj.getDependency(level,order_category,order_type,order_catalog,seq_no,mnemonic);
			
			for(int k=0; k<depend_values.size(); k++){
				String[] record = (String [])depend_values.get(k);
				if(record[2] == null)
					record[2] = " ";
				if(record[3] == null)
					record[3] = " ";
				if(record[5] == null)
					record[5] = " ";
				if(record[7].equals("Y")){
					String value_seq_num = record[1];
					ArrayList mnemonic_values = new ArrayList();
					mnemonic_values = beanObj.getOthMnemonic(level,order_category,order_type,order_catalog,seq_no,mnemonic,value_seq_num);
					for(int i=0; i<mnemonic_values.size(); i++){
						String[] record1 = (String [])mnemonic_values.get(i);
						if(record1[4] == null)
							record1[4] = " ";
						if(record1[5] == null)
							record1[5] = " ";
						if(record1[6] == null)
							record1[6] = " ";
						if(record1[7] == null)
							record1[7] = "";
						if(record1[8] == null)
							record1[8] = "";
						record[7] = record1[0]+"^"+record1[1]+"^"+record1[2]+"^"+record1[3]+"^"+record1[4]+"^"+record1[5]+"^"+record1[6]+"^"+record1[7]+"^"+record1[8]+"!!";
					}
				}else if(record[7].equals("N"))
						record[7]=" ";
				dep_values =dep_values+ record[0]+","+record[1]+","+record[2]+","+record[3]+","+record[4]+","+record[5]+","+record[6]+","+record[7]+"||";
				//dep_values.append(record[0]+","+record[1]+","+record[2]+","+record[3]+","+record[4]+","+record[5]+","+record[6]+","+record[7]+"||");
				
			}out.println( "dependencyValues(\"" +dep_values+"\") ; " ) ;//out.println(dep_values);
		}if(hash.containsKey("value_seq_num"))
		{
			String value_seq_num = (String)hash.get("value_seq_num") ;
			String level = request.getParameter("level");
			String order_category = request.getParameter("order_category");
			String order_catalog = request.getParameter("order_catalog");
			String order_type = request.getParameter("order_type");
			String seq_no = request.getParameter("seq_no");
			String mnemonic = request.getParameter("mnemonic");
			String depend_finalString="";
			ArrayList mnemonic_values = new ArrayList();
			mnemonic_values = beanObj.getOthMnemonic(level,order_category,order_type,order_catalog,seq_no,mnemonic,value_seq_num);

			for(int i=0; i<mnemonic_values.size(); i++){
				String[] record = (String [])mnemonic_values.get(i);
				if(record[4] == null)
					record[4] = " ";
				if(record[5] == null)
					record[5] = " ";
				if(record[6] == null)
					record[6] = " ";
				if(record[7] == null)
					record[7] = "";
				if(record[8] == null)
					record[8] = "";
				depend_finalString = record[0]+"^"+record[1]+"^"+record[2]+"^"+record[3]+"^"+record[4]+"^"+record[5]+"^"+record[6]+"^"+record[7]+"^"+record[8]+"!!";
				
			}
			
			out.println( "othMnemonicValues(\"" + depend_finalString + "\") ; " ) ;
			//out.println(depend_finalString);
			
		}
		else{
		//beanObj.setFinalString(finalTest);
		if(from.equals("clear"))
		{
			beanObj.removeFormatFinalValues(seq);
		}
		else
		{
			beanObj.setFormatFinalValues(seq,finalTest);
		}
		//out.println(result);
		}
	}else
	{
		//beanObj.setFinalString(finalTest);
		beanObj.setFormatFinalValues(seq,finalTest);
		out.println(result);
	}
	}	

	putObjectInBean(bean_id,beanObj,request);
}
catch(Exception e ) { e.printStackTrace(); }

%>
