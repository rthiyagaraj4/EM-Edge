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
   
    String Filter_group="";
String Levelnumber="";
String FilterElement_Type="";
String FilterElement_desc="";
String Elementquery="";
String  Filtersubtype_Type="";
String Filtersubtype_desc="";
String Elementsubtype=""; 
String FilterElement_Code="";
String	mode="";
String exceptions="";

MessageManager mm=new MessageManager();
		String FilterElement_Query="";
	Properties p;
	p = (Properties) session.getValue("jdbc");	
	String locale  = p.getProperty("LOCALE");
    request.setCharacterEncoding("UTF-8");
   	response.setContentType("text/html;charset=UTF-8");
    
    try
    { 
 	 mode=XHDBAdapter.checkNull(request.getParameter("actualmode"));
     //System.out.println("mode : "+mode);
 Filter_group=request.getParameter("Filter_group_desc_id");
 Levelnumber=request.getParameter("Level_number");

FilterElement_Type=request.getParameter("Filter_Element_Type");
FilterElement_desc=request.getParameter("Filter_Element_desc");
Elementquery=request.getParameter("Element_query");
 Filtersubtype_Type=request.getParameter("Filter_subtype_Type");
Filtersubtype_desc=request.getParameter("Filter_subtype_desc");
Elementsubtype=request.getParameter("Element_subtype");
FilterElement_Code=request.getParameter("Filter_Element_Code");
FilterElement_Query=request.getParameter("Filter_Element_Query");
	  //System.out.println("ApplicationId"+ApplicationId+"FacilityId"+FacilityId+"Messagetype"+Messagetype+"EventType"+EventType+"Protocollink"+Protocollink+"FilterGroupcode"+FilterGroupcode+"totallevel"+totallevel+"filterGroupdesc"+filterGroupdesc);

    } 
	catch(Exception exp)
    {
       System.out.println("Error in dooperate method of FilterLayarGroupFilterRecord.jsp :"+exp.toString());	
	   exp.printStackTrace(System.err);
    }
    try
    {
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of FilterLayarGroupFilterRecord.jsp:"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
     try 
     {


      ostmt = connection.prepareCall("{ CALL xhgenericfilter.XH_FILTER_LEVEL_CONFIG(?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
	
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
		  ostmt.setString(2,Filter_group);
		  ostmt.setString(3,Levelnumber);
		  ostmt.setString(4,FilterElement_Type);
		  ostmt.setString(5,FilterElement_desc);
		  ostmt.setString(6,Elementquery);
		  ostmt.setString(7,Filtersubtype_Type);
	      ostmt.setString(8,Filtersubtype_desc);
		  ostmt.setString(9,Elementsubtype); 
		  ostmt.setString(10,FilterElement_Code); 
          ostmt.setString(11,FilterElement_Query); 
    	  ostmt.registerOutParameter(12,java.sql.Types.VARCHAR);
          ostmt.registerOutParameter(13,java.sql.Types.VARCHAR);
          ostmt.execute();
          status = ostmt.getString(12); 
	      //System.out.println("status"+status); 
          message_text = ostmt.getString(13);
                if (status.equals("0"))   
        { 
          connection.commit(); 
		  if(mode.equals("D"))
				 {
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1036", "XH") ;
	  		    status = ((String) mesg.get("message"));
out.println(status);
				 }
				 else
				 {
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
	  		    status = ((String) mesg.get("message"));
				out.println(status);
				 }


             }
        else
        {
        
          connection.rollback();
		 // chkStat=containsSubstring(message_text,"APP-SY0127  Fatal Error ! Note and inform DBA:ORA-01410: invalid ROWID");
		
		 out.println("AP-0001 operation failed");
		   
		  
        }


		
   
      
       if(ostmt!=null)ostmt.close();
                   
      }
     catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of FilterLayarGroupFilterRecord.jsp:"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
      try{
      ConnectionManager.returnConnection(connection);
	  }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of FilterLayarGroupFilterRecord.jsp:"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
	  %>

<script>

parent.frames[2].location.href='../../eXH/jsp/FilterLayerGroupFilterLevalSearch.jsp';
parent.frames[3].document.forms[0].reset();
</script>



	  </form>
	  </body>
	  </html>

