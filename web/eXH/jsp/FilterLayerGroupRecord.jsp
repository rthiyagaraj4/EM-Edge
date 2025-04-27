<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.lang.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eXH/js/FilterLayerReference.js' language='javascript'></script>
<script Language="JavaScript" >
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head> 
<body BGCOLOR="#B2B6D7" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' CLASS="MESSAGE" >
<form > 
<%  
	Connection connection = null; 
	CallableStatement ostmt = null;
CallableStatement ostmtleval = null;
	Statement segstmt=null;
	String message_text = "",status="0";
	ResultSet levelset=null;
	String ApplicationId="";
	String FacilityId="";
	String Messagetype="";
	String EventType="";
	String Protocollink="";
	String FilterGroupcode="";
	String filterGroupdesc="";
	String totallevel="";
	String oldcode="";
	String	mode="";
	String exceptions="";
		MessageManager mm=new MessageManager();
	Properties p;
	p = (Properties) session.getValue("jdbc");	
	String locale  = p.getProperty("LOCALE");
    request.setCharacterEncoding("UTF-8");
   	response.setContentType("text/html;charset=UTF-8");
  
    try
    { 
 	 mode=XHDBAdapter.checkNull(request.getParameter("actualmode"));
     //System.out.println("mode : "+mode);
 ApplicationId=request.getParameter("Application_type_id");
 FacilityId=request.getParameter("Facility__id");
 Messagetype=request.getParameter("Message__id");
 EventType=request.getParameter("Event__id");
 Protocollink=request.getParameter("Protocol_Link_id");
 FilterGroupcode=request.getParameter("Filter_group_code");
 filterGroupdesc=request.getParameter("Filter_group_desc"); 
 oldcode=request.getParameter("Filter_group_code_combo"); 



 totallevel=request.getParameter("Total_level");

	  //System.out.println(mode+"FilterGroupcode"+FilterGroupcode+"filterGroupdesc"+filterGroupdesc+"ApplicationId"+ApplicationId+"FacilityId"+FacilityId+"Messagetype"+Messagetype+"EventType"+EventType+"Protocollink"+Protocollink+"totallevel"+totallevel);

    }
	catch(Exception exp){
         System.out.println("Error in calling getconnection method ofFilterLayerGroupRecord.jsp:"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    try
    {
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of FilterLayerGroupRecord.jsp:"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
     try
     {


      ostmt = connection.prepareCall("{ CALL xhgenericfilter.XH_FILTER_GROUP(?,?,?,?,?,?,?,?,?,?,?) }" ); 
	
/*
      arrFilterInfo.add(mode);
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("rowid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("applicationid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("elementid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("derivation_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("cond_exprsn")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("expected_value")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("execution_order")));
*/
    		 

//System.out.println("usr_added_by_id"+usr_added_by_id+"usr_added_at_ws_no"+usr_added_at_ws_no+"usr_added_by_date"+usr_added_by_date);

		  ostmt.setString(1,mode);
		  ostmt.setString(2,FilterGroupcode);
		  ostmt.setString(3,filterGroupdesc);
		  ostmt.setString(4,ApplicationId);
		  ostmt.setString(5,FacilityId);
		  ostmt.setString(6,Messagetype);
		  ostmt.setString(7,EventType);
	      ostmt.setString(8,Protocollink);
		  ostmt.setString(9,totallevel);
		 
    	  ostmt.registerOutParameter(10,java.sql.Types.VARCHAR);
          ostmt.registerOutParameter(11,java.sql.Types.VARCHAR);
          ostmt.execute();
          status = ostmt.getString(10);
	        //System.out.println("status 112"+status); 
          message_text = ostmt.getString(11);
            if (status.equals("0"))
        {
          connection.commit(); 
		  //final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		 // status = ((String) mesg.get("message"));
         final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		 status = ((String) mesg.get("message"));
		 out.println(status);
           

       try 
     { 
		String level_number="";
		String type_query="";
		String subtype_query="";
		String lookup_query="";
        String filter_element_type="";
		String filter_element_type_desc="";

        String filter_subtype="";
		String filter_subtype_desc="";

		String element_code_name=""; 
		        String sqlquery="select B.LEVEL_NUMBER, B.FILTER_ELEMENT_TYPE, B.FILTER_ELEMENT_TYPE_DESC, B.TYPE_QUERY, B.FILTER_SUBTYPE_CODE, B.FILTER_SUBTYPE_DESC, B.SUBTYPE_QUERY, B.ELEMENT_CODE_NAME, B.LOOKUP_QUERY from XH_FILTER_GROUP A,XH_FILTER_LEVEL_CONFIG B where B.FILTER_GROUP_CODE=A.FILTER_GROUP_CODE and B.FILTER_GROUP_CODE='"+oldcode+"' ORDER BY 1";

		//System.out.println("sqlquery   140:"+sqlquery);
		segstmt = connection.createStatement();
         levelset = segstmt.executeQuery(sqlquery);
		  ostmtleval = connection.prepareCall("{ CALL xhgenericfilter.XH_FILTER_LEVEL_CONFIG(?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
	        while(levelset.next())
            {
	
				level_number=levelset.getString(1);
				filter_element_type=levelset.getString(2);
				filter_element_type_desc=levelset.getString(3);
                type_query=levelset.getString(4);
				filter_subtype=levelset.getString(5);
				filter_subtype_desc=levelset.getString(6);
				subtype_query=levelset.getString(7);  
                element_code_name=levelset.getString(8); 
			    lookup_query=levelset.getString(9);  
                 ostmtleval.setString(1,"I");

		  //System.out.println("FilterGroupcode :"+FilterGroupcode);
		  ostmtleval.setString(2,FilterGroupcode);
		  //System.out.println("level_number :"+level_number);
		  ostmtleval.setString(3,level_number);
         //  System.out.println("filter_element_type :"+filter_element_type); 
		  ostmtleval.setString(4,filter_element_type.trim());
         // System.out.println("filter_element_type_desc :"+filter_element_type_desc); 
		  ostmtleval.setString(5,filter_element_type_desc.trim());
//System.out.println("type_query :"+type_query); 
		  ostmtleval.setString(6,type_query.trim());
//System.out.println("filter_subtype :"+filter_subtype);
		  ostmtleval.setString(7,filter_subtype.trim());
           // System.out.println("filter_subtype_desc :"+filter_subtype_desc);
	      ostmtleval.setString(8,filter_subtype_desc.trim());
		  // System.out.println("subtype_query :"+subtype_query);
		  ostmtleval.setString(9,subtype_query.trim()); 
           // System.out.println("element_code_name :"+element_code_name);
		  ostmtleval.setString(10,element_code_name.trim()); 
         /// System.out.println("lookup_query :"+lookup_query);
          ostmtleval.setString(11,lookup_query.trim()); 
    	  ostmtleval.registerOutParameter(12,java.sql.Types.VARCHAR);
          ostmtleval.registerOutParameter(13,java.sql.Types.VARCHAR);
          ostmtleval.execute();
          String status1 = ostmtleval.getString(12); 
	     // System.out.println("status"+status1); 
          message_text = ostmtleval.getString(13);
                if (status1.equals("0"))   
        { 
          connection.commit(); 
		}


        else
        {
        
          connection.rollback();
		  
        }

 
		
			}
			if(ostmtleval!=null)ostmtleval.close();
       
      }
     catch(Exception exp){
         System.out.println("Error in calling getconnection method of  FilterLayarGroupRecord.jsp:"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
     finally
			{
              if(ostmtleval!=null)ostmtleval.close();
			}




    
        }
		else if(status.equals("2"))
		 {
			 final java.util.Hashtable mesg =  mm.getMessage(locale,"XH1024","XH") ;
	  	 status = ((String) mesg.get("message"));
	     out.println(status);
		 }
        else
        {
                 
          connection.rollback();
		 // chkStat=containsSubstring(message_text,"APP-SY0127  Fatal Error ! Note and inform DBA:ORA-01410: invalid ROWID");
			if(mode.equals("D"))
			 {
				status=message_text;
			 }
			 else
			{
			 final java.util.Hashtable mesg =  mm.getMessage(locale, "XH1000","XH") ;
			 status = ((String) mesg.get("message"));
			}

		 out.println(status);  
		  
        }

  
      
       if(ostmt!=null)ostmt.close();
  if(ostmtleval!=null)ostmtleval.close();


    




                   
      }
     catch(Exception exp){
         System.out.println("Error in calling getconnection method of  FilterLayarGroupRecord.jsp:"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
      try{
		    if(ostmtleval!=null)ostmtleval.close();
        if(levelset!=null)levelset.close();
        if(segstmt!=null)segstmt.close();
      ConnectionManager.returnConnection(connection);
	  }
	  catch(Exception exp){
         System.out.println("Error in calling getconnection method of FilterLayarGroupRecord.jsp:"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
	  %>



	  </form>
	  </body>
	  </html>
 

