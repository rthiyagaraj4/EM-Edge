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
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<body BGCOLOR="#B2B6D7" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' CLASS="MESSAGE" >
<form > 
<% 
//int count_field=Integer.parseInt(request.getParameter("count_fields"));
MessageManager mm=new MessageManager();
Properties p;
p = (Properties) session.getValue("jdbc");										   
//String locale  = p.getProperty("LOCALE");					 
String msg="";
Statement s=null;
ResultSet r = null;
Statement stmt=null;
ResultSet reset = null;
Connection connection = null;
CallableStatement ostmt = null;
String message_text = "",status="0";
String Filter_group="";
//int Levelnumber=0;
//String FilterElement_Type="";
//String Filtersubtype_desc="";
//String FilterElement_Code="";
String	mode="";
String exceptions="";
//String FilterElement_Query="";
int Transaction_number=1;
String applicationID=request.getParameter("applicationID");
String facilityID=request.getParameter("facilityID"); 
String event_type=request.getParameter("event_type");
String protocol_link_id=request.getParameter("protocol_link");
int levelcount=0;
	p = (Properties) session.getValue("jdbc");	
    request.setCharacterEncoding("UTF-8");
   	response.setContentType("text/html;charset=UTF-8");

    try
    { 
 	
 mode=XHDBAdapter.checkNull(request.getParameter("actualmode"));
//System.out.println("ApplicationId"+ApplicationId+"FacilityId"+FacilityId+"Messagetype"+Messagetype+"EventType"+EventType+"Protocollink"+Protocollink+"FilterGroupcode"+FilterGroupcode+"totallevel"+totallevel+"filterGroupdesc"+filterGroupdesc);

    } 
	catch(Exception exp)
    {
       System.out.println("(FilterAndSchedulingRecord.jsp:Exc-1) :"+exp.toString());	
	   exp.printStackTrace(System.err);
    }
    try
    {																		 
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println(" (FilterAndSchedulingRecord.jsp:Exc-2) :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }     
    	
     try
     {

//XH_APPL_FILTER_RULE_DETAIL(	p_mode			      VARCHAR2,P_trx_no                      NUMBER,p_filter_level_no			NUMBER,							p_filter_group_code           VARCHAR2,							p_filter_level_type          VARCHAR2,							p_filter_level_subtype       VARCHAR2,							p_filter_level_code          VARCHAR2,							p_filter_level_value         VARCHAR2,p_errcd			OUT	VARCHAR2,p_errmsg		OUT	VARCHAR2)


Filter_group=request.getParameter("Filter_group_desc_id");
 s= connection.createStatement();
 r = s.executeQuery("select count(*) AS rowcount from XH_FILTER_LEVEL_CONFIG where filter_group_code='"+Filter_group+"'");
 r.next();
  levelcount= r.getInt("rowcount") ;
  /*if(levelcount==0)
		 {
	  mode="I";
		 }
		 else
		 {
			 mode="U";			  
		 }*/
r.close() ;
 s.close();
stmt= connection.createStatement();
 reset = stmt.executeQuery("select max(TRX_NO)  AS rowcount from XH_APPL_FILTER_RULE_DETAIL where filter_group_code='"+Filter_group+"'");
 
if(reset.next())
{
	 Transaction_number= reset.getInt("rowcount")+1 ;
}
else
{
	Transaction_number= 1 ;
} 
reset.close() ;
stmt.close();



		  //System.out.println("applicationID : "+applicationID);
  		  //System.out.println("facilityID : "+facilityID);
		  //System.out.println("event_type : "+event_type);
  		 // System.out.println("protocol_link_id : "+protocol_link_id);

 
//for(int j=1;j<count_field;j++)
 //{
       //   Levelnumber=Integer.parseInt(request.getParameter(j+"leval_number")); 		    
/*          FilterElement_Type=request.getParameter(j+"Filter_element_desc");
          Filtersubtype_desc=request.getParameter(j+"Filter_subtype_desc_combo");
          FilterElement_Code=request.getParameter("Element_code_Query"+j);
          FilterElement_Query=request.getParameter("Element_code_Querys"+j+j);*/

ostmt = connection.prepareCall("{ CALL xhgenericfilter.XH_APPL_FILTER_RULE_DETAIL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
	      ostmt.setString(1,mode);
  		  ostmt.setInt(2,Transaction_number);
		  ostmt.setString(3,Filter_group);
		  ostmt.setString(4,applicationID);
		  ostmt.setString(5,facilityID);
		  ostmt.setString(6,event_type);
		  ostmt.setString(7,protocol_link_id);
		  ostmt.setString(8,XHDBAdapter.checkNull(request.getParameter("1Filter_element_desc"))); 
				  //System.out.println("p_filter_level1_type : "+XHDBAdapter.checkNull(request.getParameter("1Filter_element_desc")));
          ostmt.setString(9,XHDBAdapter.checkNull(request.getParameter("1Filter_subtype_desc_combo"))); 
		  		//  System.out.println("p_filter_level1_subtype : "+XHDBAdapter.checkNull(request.getParameter("1Filter_subtype_desc_combo")));
//          ostmt.setString(10,XHDBAdapter.checkNull(request.getParameter("Element_code_Query1"))); 
		  ostmt.setString(10,request.getParameter("Element_code_Query1")==null?"*":request.getParameter("Element_code_Query1"));
		  		//  System.out.println("p_filter_level1_code : "+XHDBAdapter.checkNull(request.getParameter("Element_code_Query1")));
//          ostmt.setString(11,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys1")));   
		  ostmt.setString(11,request.getParameter("Element_code_Querys1")==null?"*":request.getParameter("Element_code_Querys1"));
//		  ostmt.setString(12,XHDBAdapter.checkNull(request.getParameter("2Filter_element_desc"))); 
		  ostmt.setString(12,request.getParameter("2Filter_element_desc")==null?"*":request.getParameter("2Filter_element_desc"));
//          ostmt.setString(13,XHDBAdapter.checkNull(request.getParameter("2Filter_subtype_desc_combo"))); 
		  ostmt.setString(13,request.getParameter("2Filter_subtype_desc_combo")==null?"*":request.getParameter("2Filter_subtype_desc_combo"));
//          ostmt.setString(14,XHDBAdapter.checkNull(request.getParameter("Element_code_Query2"))); 
		  ostmt.setString(14,request.getParameter("Element_code_Query2")==null?"*":request.getParameter("Element_code_Query2"));
//          ostmt.setString(15,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys2")));  
		  ostmt.setString(15,request.getParameter("Element_code_Querys2")==null?"*":request.getParameter("Element_code_Querys2"));
//		  ostmt.setString(16,XHDBAdapter.checkNull(request.getParameter("3Filter_element_desc"))); 
		  ostmt.setString(16,request.getParameter("3Filter_element_desc")==null?"*":request.getParameter("3Filter_element_desc"));
//          ostmt.setString(17,XHDBAdapter.checkNull(request.getParameter("3Filter_subtype_desc_combo"))); 
		  ostmt.setString(17,request.getParameter("3Filter_subtype_desc_combo")==null?"*":request.getParameter("3Filter_subtype_desc_combo"));
//          ostmt.setString(18,XHDBAdapter.checkNull(request.getParameter("Element_code_Query3"))); 
		  ostmt.setString(18,request.getParameter("Element_code_Query3")==null?"*":request.getParameter("Element_code_Query3"));
//          ostmt.setString(19,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys3")));   
		  ostmt.setString(19,request.getParameter("Element_code_Querys3")==null?"*":request.getParameter("Element_code_Querys3"));
//		  ostmt.setString(20,XHDBAdapter.checkNull(request.getParameter("4Filter_element_desc")));           
		  ostmt.setString(20,request.getParameter("4Filter_element_desc")==null?"*":request.getParameter("4Filter_element_desc"));
//ostmt.setString(21,XHDBAdapter.checkNull(request.getParameter("4Filter_subtype_desc_combo"))); 
		  ostmt.setString(21,request.getParameter("4Filter_subtype_desc_combo")==null?"*":request.getParameter("4Filter_subtype_desc_combo"));
//          ostmt.setString(22,XHDBAdapter.checkNull(request.getParameter("Element_code_Query4"))); 
		  ostmt.setString(22,request.getParameter("Element_code_Query4")==null?"*":request.getParameter("Element_code_Query4"));
//          ostmt.setString(23,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys4")));  
		  ostmt.setString(23,request.getParameter("Element_code_Querys4")==null?"*":request.getParameter("Element_code_Querys4"));
//    	  ostmt.setString(24,XHDBAdapter.checkNull(request.getParameter("5Filter_element_desc"))); 
		  ostmt.setString(24,request.getParameter("5Filter_element_desc")==null?"*":request.getParameter("5Filter_element_desc"));
//          ostmt.setString(25,XHDBAdapter.checkNull(request.getParameter("5Filter_subtype_desc_combo"))); 
		  ostmt.setString(25,XHDBAdapter.checkNull(request.getParameter("5Filter_subtype_desc_combo")==null?"*":request.getParameter("5Filter_subtype_desc_combo")));
//          ostmt.setString(26,XHDBAdapter.checkNull(request.getParameter("Element_code_Query5"))); 
		  ostmt.setString(26,XHDBAdapter.checkNull(request.getParameter("Element_code_Query5")==null?"*":request.getParameter("Element_code_Query5")));
//          ostmt.setString(27,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys5")));   
		  ostmt.setString(27,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys5")==null?"*":request.getParameter("Element_code_Querys5")));
//		  ostmt.setString(28,XHDBAdapter.checkNull(request.getParameter("6Filter_element_desc"))); 
		  ostmt.setString(28,XHDBAdapter.checkNull(request.getParameter("6Filter_element_desc")==null?"*":request.getParameter("6Filter_element_desc")));
//          ostmt.setString(29,XHDBAdapter.checkNull(request.getParameter("6Filter_subtype_desc_combo"))); 
		  ostmt.setString(29,XHDBAdapter.checkNull(request.getParameter("6Filter_subtype_desc_combo")==null?"*":request.getParameter("6Filter_subtype_desc_combo")));
//          ostmt.setString(30,XHDBAdapter.checkNull(request.getParameter("Element_code_Query6"))); 
		  ostmt.setString(30,XHDBAdapter.checkNull(request.getParameter("Element_code_Query6")==null?"*":request.getParameter("Element_code_Query6")));
//          ostmt.setString(31,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys6")));  
		  ostmt.setString(31,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys6")==null?"*":request.getParameter("Element_code_Querys6")));
//		  ostmt.setString(32,XHDBAdapter.checkNull(request.getParameter("7Filter_element_desc"))); 
		  ostmt.setString(32,XHDBAdapter.checkNull(request.getParameter("7Filter_element_desc")==null?"*":request.getParameter("7Filter_element_desc")));
//          ostmt.setString(33,XHDBAdapter.checkNull(request.getParameter("7Filter_subtype_desc_combo"))); 
		  ostmt.setString(33,XHDBAdapter.checkNull(request.getParameter("7Filter_subtype_desc_combo")==null?"*":request.getParameter("7Filter_subtype_desc_combo")));
//          ostmt.setString(34,XHDBAdapter.checkNull(request.getParameter("Element_code_Query7"))); 
		  ostmt.setString(34,XHDBAdapter.checkNull(request.getParameter("Element_code_Query7")==null?"*":request.getParameter("Element_code_Query7")));
//          ostmt.setString(35,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys7")));  
		  ostmt.setString(35,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys7")==null?"*":request.getParameter("Element_code_Querys7")));
//    	  ostmt.setString(36,XHDBAdapter.checkNull(request.getParameter("8Filter_element_desc"))); 
		  ostmt.setString(36,XHDBAdapter.checkNull(request.getParameter("8Filter_element_desc")==null?"*":request.getParameter("8Filter_element_desc")));
//          ostmt.setString(37,XHDBAdapter.checkNull(request.getParameter("8Filter_subtype_desc_combo"))); 
		  ostmt.setString(37,XHDBAdapter.checkNull(request.getParameter("8Filter_subtype_desc_combo")==null?"*":request.getParameter("8Filter_subtype_desc_combo")));
//          ostmt.setString(38,XHDBAdapter.checkNull(request.getParameter("Element_code_Query8"))); 
		  ostmt.setString(38,XHDBAdapter.checkNull(request.getParameter("Element_code_Query8")==null?"*":request.getParameter("Element_code_Query8")));
//          ostmt.setString(39,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys8")));   
		  ostmt.setString(39,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys8")==null?"*":request.getParameter("Element_code_Querys8")));
//		  ostmt.setString(40,XHDBAdapter.checkNull(request.getParameter("9Filter_element_desc"))); 
		  ostmt.setString(40,XHDBAdapter.checkNull(request.getParameter("9Filter_element_desc")==null?"*":request.getParameter("9Filter_element_desc")));
//          ostmt.setString(41,XHDBAdapter.checkNull(request.getParameter("9Filter_subtype_desc_combo"))); 
		  ostmt.setString(41,XHDBAdapter.checkNull(request.getParameter("9Filter_subtype_desc_combo")==null?"*":request.getParameter("9Filter_subtype_desc_combo")));
//          ostmt.setString(42,XHDBAdapter.checkNull(request.getParameter("Element_code_Query9"))); 
		  ostmt.setString(42,XHDBAdapter.checkNull(request.getParameter("Element_code_Query9")==null?"*":request.getParameter("Element_code_Query9")));
//          ostmt.setString(43,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys9")));  
		ostmt.setString(43,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys9")==null?"*":request.getParameter("Element_code_Querys9")));
    	  ostmt.registerOutParameter(44,java.sql.Types.VARCHAR);
          ostmt.registerOutParameter(45,java.sql.Types.VARCHAR);
		  ostmt.registerOutParameter(46,java.sql.Types.VARCHAR);
          ostmt.execute();
          status = ostmt.getString(45); 
		  //System.out.println("FilterAndSchedulingRecord.jsp status : "+status);
          message_text = ostmt.getString(46);
          out.println("<html><head></head><body bgcolor=#B2B6D7 >"); 
          out.println("</body></html>");
          if(ostmt!=null)ostmt.close();
 //}
	 
		if (status.equals("0"))  
        {
			connection.commit(); 
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
			// status = ((String) mesg.get("message")); 
			// final java.util.Hashtable mesg = mm.getMessage(connection, "XH1001") ;
			msg= ((String) mesg.get("message"));
			out.println(msg);
			out.println("<script>parent.frames[4].location.href='../../eCommon/html/blank.html';  </script>");
			mesg.clear();
		}
		else if (status.equals("2"))  
        {
			connection.commit(); 
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1024", "XH") ;
			// status = ((String) mesg.get("message")); 
			// final java.util.Hashtable mesg = mm.getMessage(connection, "XH1024") ;
			msg = ((String) mesg.get("message"));
			out.println(msg);
			out.println("<script>parent.frames[4].location.href='../../eCommon/html/blank.html';  </script>");	
			mesg.clear();
		}
		else														  
        {
      
			connection.rollback();
			// chkStat=containsSubstring(message_text,"APP-SY0127  Fatal Error ! Note and inform DBA:ORA-01410: invalid ROWID");
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1024", "XH") ;
			//final java.util.Hashtable mesg = mm.getMessage(connection, "XH1000") ;
			msg = ((String) mesg.get("message"));
			out.println(msg);
			mesg.clear();
		 }


      }
      catch(Exception e)
		 {
	      System.out.println("(Error in FilterAndSchedulingRecord.jsp:sqlExceptrion) :"+e.toString());
	      e.printStackTrace(System.err);
	  }
      try{
      ConnectionManager.returnConnection(connection);
	  }catch(Exception e)
		 {
	      System.out.println("Error in closing dbconnection in dooperate method of FilterAndSchedulingRecord.jsp :"+e.toString());
	      e.printStackTrace(System.err);
	  }
	  
	  %>
<input type=hidden name=filter_code id=filter_code value='<%=Filter_group%>'>

<script>
parent.frames[3].location.href="../../eXH/jsp/FilteringAndSchedulingApplicationLevel.jsp?Filter_group_code="+document.forms[0].filter_code.value;
</script>

	  </form>
	  </body>
	  </html>

