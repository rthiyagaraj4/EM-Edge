<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.lang.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eXH/js/filterlayerrefrence.js' language='javascript'></script>
<script Language="JavaScript" >
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body BGCOLOR="#B2B6D7" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' CLASS="MESSAGE" >
<form > 
<% 
    Connection connection = null; 
    CallableStatement ostmt = null;
    String message_text = "",status="0";

    String ApplicationId="";
String FacilityId="";
String Messagetype="";
String EventType="";
String Protocollink="";
String FilterGroupcode="";
String filterGroupdesc="";
String totallevel="";
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
 totallevel=request.getParameter("Total_level");

	  //System.out.println(mode+"FilterGroupcode"+FilterGroupcode+"filterGroupdesc"+filterGroupdesc+"ApplicationId"+ApplicationId+"FacilityId"+FacilityId+"Messagetype"+Messagetype+"EventType"+EventType+"Protocollink"+Protocollink+"totallevel"+totallevel);

    }
	catch(Exception exp){
         System.out.println("Error in calling getconnection method of  FilterLayarGroupFilterRecord.jsp:"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    try
    {
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of FilterLayarGroupFilterRecord.jsp:"+exp.toString());
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
	      ///System.out.println("status"+status);
          message_text = ostmt.getString(11);
            if (status.equals("0"))
        {
          connection.commit(); 
		  //final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		 // status = ((String) mesg.get("message"));
                  if(mode.equals("D"))
				 {
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1036", "XH") ;
	  		    status = ((String) mesg.get("message"));
				 }
				 else
				 {
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
	  		    status = ((String) mesg.get("message"));
				 }

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
final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
	  		    status = ((String) mesg.get("message"));

			}

		 out.println(status);  
		  
        }

  
      
       if(ostmt!=null)ostmt.close();
                   
      }
     catch(Exception exp){
         System.out.println("Error in calling getconnection method of  FilterLayarGroupFilterRecord.jsp:"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
      try{
      ConnectionManager.returnConnection(connection);
	  }
	  catch(Exception exp){
         System.out.println("Error in calling getconnection method of FilterLayarGroupRecord.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
	  %>

<script>

parent.frames[2].location.href='../../eXH/jsp/FilterLayerGroupLevalSearch.jsp';
parent.frames[3].location.href='../../eXH/jsp/FilterLayerGroupLevalAdd.jsp';
</script>


	  </form>
	  </body>
	  </html>
 

