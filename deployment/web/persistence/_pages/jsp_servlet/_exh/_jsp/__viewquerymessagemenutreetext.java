package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import eXH.XHReturnArray;
import eXH.XHDBAdapter;

public final class __viewquerymessagemenutreetext extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/exh/jsp/ViewQueryMessageMenuTreeText.jsp", 1743587236834L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'></link>\n</head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<body onload=\"load();\">\n<form name=\"menu_treetext1\" id=\"menu_treetext1\">\n<input type=\"hidden\" name=\"viewflag\" id=\"viewflag\"  value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"/>\n<input type=\"hidden\" name=\"replayflag\" id=\"replayflag\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/>\n<input type=\"hidden\" name=\"mode_insert\" id=\"mode_insert\"/>\n<input type=\"hidden\" name=\"application_id\" id=\"application_id\" value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' />\n<input type=\"hidden\" name=\"Facility_id\" id=\"Facility_id\" value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' />\n<input type=\"hidden\" name=\"eventype\" id=\"eventype\" value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' />\n<input type=\"hidden\" name=\"protocollinkid\" id=\"protocollinkid\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' />\n<input type=\"hidden\" name=msg_id id=msg_id value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' />\n\n\n<table cellspacing=0 cellpadding=3 width=\'100%\' border=0 align=center>\n<tr></tr>\n<tr></tr>\n<tr></tr>\n<tr><td class=\'fields\'><textarea name=msgtxt rows=41 cols=112 readonly>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</textarea></td></tr>\n<td><input class=\'button\' id=\"viewbtton\" type=\"button\" name=\'auditlog\' id=\'auditlog\' value=\'Audit Log\' onClick=\"goToAuditLog(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\t\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\')\"> <!--<input class=\'button\' id=\"replaybtton\" type=\"button\"  name=\'query\' id=\'query\' value=\'Query\' disabled  onClick=\'\'>--->\n<input class=\'button\' id=\"viewbtton1\" type=\"button\" name=\'views\' id=\'views\' value=\'View\'  onClick=\'goToView()\'  >\n<!--<input class=\'button\' id=\"replaybtton1\" type=\"button\"  name=\'replays\' id=\'replays\' value=\'Replay\'  onClick=\'replayMethod();\'>--> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n&nbsp;&nbsp;&nbsp;Status&nbsp;&nbsp;<input type=\"text\"  name=\"comm_client\" id=\"comm_client\" id=\"comm_client\" size=25 value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n</td>\n</table>\n</form name=menu_treetext1>\n</body>\n</html>\n\n<script>\n//**********************************************************************************************/\nvar dialogHeight = \"250\";\nvar dialogWidth  = \"250\";\nvar dialogTop    = \"230\";\nvar dialogLeft   = \"230\";\nvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n//*********************************************************************************************/\nfunction load()\n{\n\n\n/*if(this.document.forms[0].viewflag.value==\'Y\') this.document.forms[0].views.disabled=false;\nelse //this.document.forms[0].views.disabled=true;\n\n\n//if(this.document.forms[0].replayflag.value==\'Y\') this.document.forms[0].replays.disabled=false;\n//else this.document.forms[0].replays.disabled=true;*/\n}\n//**************************************************************************************************\nasync function goToAuditLog(applicationId,applicationName,facilityId,facilityName,msgId,eventType,eventName)\n{\n\tvar arguments  =new Array();\n\targuments[0]=\'L\';\n\targuments[1]=applicationId;\n\targuments[2]=applicationName;\n    arguments[3]=facilityId;\n\targuments[4]=facilityName;\n\targuments[5]=msgId;\n    arguments[6]=eventType;\n\targuments[7]=eventName;\n  await window.showModalDialog(\"../../eXH/jsp/ViewMessageAuditLogMain.jsp?applicationId=\"+document.forms[0].application_id.value+\"&applicationName=\"+applicationName+\"&facilityName=\"+facilityName+\"&facilityId=\"+document.forms[0].Facility_id.value+\"&eventName=\"+document.forms[0].eventype.value+\"&protocollinkid=\"+document.forms[0].protocollinkid.value+\"&msgId=\"+document.forms[0].msg_id.value,arguments,features);  \n}\n//**************************************************************************************************\nfunction replayMethod()\n{\n   this.document.menu_treetext1.mode_insert.value=\'R\';\n   this.document.menu_treetext1.action = \'../../eXH/jsp/ViewQueryMessageMenuTreeText.jsp\';\n   this.document.menu_treetext1.submit();\n}\n//********************************************************************************************************\n\nasync function goToView()\n{\n\tvar arguments  =new Array();\n\tvar dialogHeight = \"250\";\n\tvar dialogWidth  = \"250\";\n\tvar dialogTop    = \"230\";\n\tvar dialogLeft   = \"230\";\n\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n    arguments[0]=document.forms[0].application_id.value;\n\targuments[1]=document.forms[0].Facility_id.value;\n\targuments[2]=document.forms[0].eventype.value;\n\targuments[3]=document.forms[0].protocollinkid.valu;\n    arguments[4]=document.forms[0].msg_id.value;\n\n    var url=\"../../eXH/jsp/ViewSegmentsQueryTree.jsp?application_id=\"+document.forms[0].application_id.value+\"&Facility_Id=\"+document.forms[0].Facility_id.value+\"&eventype=\"+document.forms[0].eventype.value+\"&protocollinkid=\"+document.forms[0].protocollinkid.value+\"&msg_id=\"+document.forms[0].msg_id.value;\n\n\n\nawait window.showModalDialog(url,arguments,features);  \n// window.open(url,null,\"fullscreen=no,height=550,width=700,status=yes,toolbar=no,menubar=no,scrollbars=yes,location=no\");\n\n \n\n}\n//********************************************************************************************************\n</script>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block3Bytes, _wl_block3);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
 
String mode=(String)session.getAttribute("mode");
String applicationId="";
String applicationName=request.getParameter("applicationName");  
String QueryOption="";
String facilityId="";
String facilityName=request.getParameter("facilityname");
String msgId=XHDBAdapter.checkNull(request.getParameter("msgId"));
String eventType="";
String applicationid=request.getParameter("application_id");
String Facility_id=request.getParameter("Facility_id");
String eventtype=request.getParameter("eventype");
String eventName="";
String protocollinkid=request.getParameter("protocollinkid");

//System.out.println("applicationName :"+applicationName);
 QueryOption=XHDBAdapter.checkNull(request.getParameter("Query_Option"));

//XHReturnArray arr=new XHReturnArray();
/*if(mode!=null){        
if(mode.equalsIgnoreCase("A")){
 applicationName=request.getParameter("applicationName");
  facilityName=request.getParameter("facilityName");

 QueryOption=XHDBAdapter.checkNull(request.getParameter("Query_Option"));
}}
else{
  applicationName=request.getParameter("applicationName");
  facilityName=request.getParameter("facilityName");
 //msgId=request.getParameter("msgId");
 QueryOption=request.getParameter("Query_Option");
 }*/


String msgtext="";
String msgstatus="";
String int_msgstatus="";
String viewflag="";
String replayflag="";
String mode_insert = request.getParameter("mode_insert");
 Connection con = ConnectionManager.getConnection(request);
 try{

if(mode_insert!=null)
{
	CallableStatement ostmt = null; 
    String message_text2="";
    ostmt = con.prepareCall("{ call XHMSG.REPLAY(?,?,?,?,?) }" ); 
	ostmt.setString(1,facilityId);
	ostmt.setString(2,applicationId);
	ostmt.setString(3,msgId);
  	ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);
	ostmt.registerOutParameter(5,java.sql.Types.VARCHAR);
	ostmt.execute();
	message_text2 = ostmt.getString(4);	

	if(message_text2.equals("0"))
	{
		con.commit();
	 } else {
			con.rollback();
			}
    ostmt.close();
}
String sql="";
if(mode!=null){
if(mode.equalsIgnoreCase("A")){



if(QueryOption.equalsIgnoreCase("P"))
	{
sql="SELECT MESSAGE_TEXT,MESSAGE_STATUS FROM xh_application_message"
+ " WHERE APPLICATION_ID=NVL('"+applicationid+"',APPLICATION_ID) "
+ " AND QUERY_ID=NVL('"+msgId+"',QUERY_ID)";


}
     else if(QueryOption.equalsIgnoreCase("A"))
	{
sql="SELECT MESSAGE_TEXT,MESSAGE_STATUS FROM xh_application_message_ob"
+ " WHERE APPLICATION_ID=NVL('"+applicationid+"',APPLICATION_ID) "
+ " AND QUERY_ID=NVL('"+msgId+"',QUERY_ID)";
//System.out.println("2ndithula"+sql);
	}
	else
	{
		sql="SELECT MESSAGE_TEXT,MESSAGE_STATUS FROM xh_application_message"
+ " WHERE APPLICATION_ID=NVL('"+applicationid+"',APPLICATION_ID) "
+ " AND QUERY_ID=NVL('"+msgId+"',QUERY_ID)";


	}

	}

else if(mode.equalsIgnoreCase("D")){
if(QueryOption.equalsIgnoreCase("P"))
	{
sql="SELECT MESSAGE_TEXT,MESSAGE_STATUS FROM xh_application_message"
+ " WHERE APPLICATION_ID=NVL('"+applicationid+"',APPLICATION_ID) "
+ " AND QUERY_ID=NVL('"+msgId+"',QUERY_ID)";
}
     else if(QueryOption.equalsIgnoreCase("A"))
	{
sql="SELECT MESSAGE_TEXT,MESSAGE_STATUS FROM xh_application_message_ob"
+ " WHERE APPLICATION_ID=NVL('"+applicationid+"',APPLICATION_ID) "
+ " AND QUERY_ID=NVL('"+msgId+"',QUERY_ID)";

	}
	else if(QueryOption.equals(""))
	{
		sql="SELECT MESSAGE_TEXT,MESSAGE_STATUS FROM xh_application_message"
+ " WHERE APPLICATION_ID=NVL('"+applicationid+"',APPLICATION_ID) "
+ " AND QUERY_ID=NVL('"+msgId+"',QUERY_ID)";
	}

	}

}
else{

 /*sql="SELECT MESSAGE_TEXT,message_status FROM XH_APPLICATION_MESSAGE"
+ " WHERE APPLICATION_ID=NVL('"+applicationId+"',APPLICATION_ID) "
+ " AND MESSAGE_ID=NVL('"+msgId+"',MESSAGE_ID)"
+ " AND EVENT_TYPE=NVL('"+eventType+"',EVENT_TYPE) "
+ " AND FACILITY_ID=NVL('"+facilityId+"',FACILITY_ID )"; */
/*if((applicationId.equalsIgnoreCase("EPABXO"))||(applicationId.equalsIgnoreCase("EPABXI")))
	{	
	 sql="SELECT MESSAGE_TEXT,message_status FROM XP_EVENT"
+ " WHERE APPLICATION_ID=NVL('"+applicationId+"',APPLICATION_ID) "
+ " AND MESSAGE_ID=NVL('"+msgId+"',MESSAGE_ID)"
+ " AND EVENT_TYPE=NVL('"+eventType+"',EVENT_TYPE) "
+ " AND FACILITY_ID=NVL('"+facilityId+"',FACILITY_ID )";
	
	}
	else{

	sql="SELECT MESSAGE_TEXT,message_status FROM XH_APPLICATION_MESSAGE"
+ " WHERE APPLICATION_ID=NVL('"+applicationId+"',APPLICATION_ID) "
+ " AND MESSAGE_ID=NVL('"+msgId+"',MESSAGE_ID)"
+ " AND EVENT_TYPE=NVL('"+eventType+"',EVENT_TYPE) "
+ " AND FACILITY_ID=NVL('"+facilityId+"',FACILITY_ID )";
	
	}*/
}
//System.out.println("sql 152:"+sql);
String curr_user_id=(String)session.getValue("login_user");
String usrsql="Select VIEW_YN, REPLAY_YN from xh_authorized_user where LOGIN_NAME='"+curr_user_id+"'";
ResultSet rs=null;
Statement stmt=null;

stmt=con.createStatement();
rs=stmt.executeQuery(sql);
while(rs.next())
{ 
      msgtext= rs.getString(1);
	  msgstatus=rs.getString(2);
}
if(rs!=null) rs.close();
rs=stmt.executeQuery(usrsql);
while(rs.next())
{ 
      viewflag= rs.getString(1);
	  replayflag=rs.getString(2);
}
if(viewflag==null) viewflag="";
if(replayflag==null) replayflag="";
if(rs!=null) rs.close();
if(stmt!=null) stmt.close();
}	catch (Exception e) {
		out.println("error in tree"+e.toString()) ;
		e.printStackTrace(System.err) ;
	}
		finally {
			
			ConnectionManager.returnConnection(con) ;
		}
if(msgstatus==null) 
int_msgstatus="Pending";
if(msgstatus!=null){ 
if(msgstatus.equalsIgnoreCase("S")) int_msgstatus="Successful";
if(msgstatus.equalsIgnoreCase("R")) 
int_msgstatus="Rejected";
if(msgstatus.equalsIgnoreCase("F")) int_msgstatus="Failure";
if(msgstatus.equalsIgnoreCase("A")) 
int_msgstatus="All";
}

/*try
{
String segment[][]=null;
String segment1[][]=null;
String temp[][]=null;

HashMap hasmap=null;
System.out.println("LENGTH----- "+msgtext.length());
if(msgtext!=null) hasmap=arr.returnsSegmentArray(msgtext);

if(hasmap!=null){ segment=(String[][])hasmap.get("segment");
 if(segment!=null){
 temp=new String[segment.length][2];
for(int i=1;i<segment.length;i++)
{
    String segstr="";
	if(segment[i][0].toString().trim()==null)
	{
		segstr="";
	}
	else
	{
		 segstr=XHDBAdapter.checkNull(segment[i][0].toString());
	}

String segnextstr=XHDBAdapter.checkNull(segment[(i-1)][0].toString());
	System.out.println("segment[i][0] :"+segment[i][0]);
   if(segstr.equals(segnextstr))
	{
	  temp[i-1][0]=segment[i-1][0]+""+i+"";
	  temp[i-1][1]=segment[i-1][1];

	}

	else
	{
	  temp[i-1][0]=segment[i-1][0];
	  temp[i-1][1]=segment[i-1][1];

	}

}
if(segment.length!=0){
temp[segment.length-1][0]=segment[segment.length-1][0];
temp[segment.length-1][1]=segment[segment.length-1][1];
session.putValue("SegmentValues",temp);  
}
}
}
if(temp!=null){
}

if(segment!=null){
for(int i=0;i<temp.length;i++)
{
segment1=(String[][])hasmap.get("comp"+i);
session.putValue(temp[i][0],segment1);  
}
}
if(hasmap!=null) hasmap.clear();


}
catch(Exception e)
{
	System.out.println("Exception e :"+e);
}*/

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(viewflag));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(replayflag));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(applicationid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Facility_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(eventtype));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(protocollinkid));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(msgId));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(msgtext));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(applicationId));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(applicationName));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facilityId ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facilityName ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(msgId));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(eventType ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(eventName ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(int_msgstatus));
            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
