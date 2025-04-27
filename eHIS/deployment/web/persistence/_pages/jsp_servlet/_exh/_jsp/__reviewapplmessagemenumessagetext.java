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

public final class __reviewapplmessagemenumessagetext extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ReviewApplMessageMenuMessageText.jsp", 1743587112236L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'></link>\n</head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n<body onLoad=\"load()\">\n<form name=\"menu_treetext\" id=\"menu_treetext\" >\n<input type=\"hidden\" name=\"viewflag\" id=\"viewflag\"  value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"/>\n<input type=\"hidden\" name=\"replayflag\" id=\"replayflag\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/>\n<input type=\"hidden\" name=\"mode_insert\" id=\"mode_insert\"/>\n\n\n<input type=\"hidden\" name=\"appl_name\" id=\"appl_name\"  value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"/>\n<input type=\"hidden\" name=\"appdes\" id=\"appdes\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/>\n<input type=\"hidden\" name=\"facility_name\" id=\"facility_name\"  value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"/>\n<input type=\"hidden\" name=\"facdes\" id=\"facdes\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/>\n<input type=\"hidden\" name=\"msg_id\" id=\"msg_id\"  value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/>\n<input type=\"hidden\" name=\"event_type\" id=\"event_type\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"/>\n<input type=\"hidden\" name=\"eventdes\" id=\"eventdes\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"/>\n<input type=\"hidden\" name=\"msg_type\" id=\"msg_type\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"/>\n<input type=\"hidden\" name=\"msgdes\" id=\"msgdes\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/>\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"/>\n\n\n<table cellspacing=0 cellpadding=3 width=\'100%\' border=0 align=center>\n<tr></tr>\n<tr></tr>\n<tr><td class=\'fields\'><textarea rows=27 cols=92>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</textarea></td></tr>\n<tr>\n<td><input class=\'button\' id=\"Close\" type=\"button\" name=\'Close\' id=\'Close\' value=\'Close\' onClick=\"funClose()\">\n<td id=\"d1\" style=\"display:block\" ><input class=\'button\' id=\"viewbtton\" type=\"button\" name=\'auditlog\' id=\'auditlog\' value=\'Audit Log\' onClick=\"goToAuditLog(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\')\"><input class=\'button\' id=\"replaybtton\" type=\"button\"  name=\'query\' id=\'query\' value=\'Query\' disabled  onClick=\'\'><input class=\'button\'  id=\"viewbtton1\" type=\"button\" name=\'views\' id=\'views\' value=\'View\' onClick=\"goToView()\"><input class=\'button\' id=\"replaybtton1\" type=\"button\"  name=\'replays\' id=\'replays\' value=\'Replay\' onClick=\'replayMethod();\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Status &nbsp;&nbsp;<input type=\"text\"  name=\"message_status\" id=\"message_status\" id=\"message_status\" size=25 value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n<td id=\"d2\" style=\"display:none\" ><input class=\'button\' id=\"viewbtton\" type=\"button\" name=\'auditlog\' id=\'auditlog\' value=\'View\' onClick=\"goToView()\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Status&nbsp;&nbsp;<input type=\"text\"  name=\"message_status\" id=\"message_status\" id=\"message_status\" size=25 value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n</td>\n</tr>\n</table>\t\t\t\t    \n</form>\n</body>\n</html>\n<script>\n//**********************************************************************************************/\nvar dialogHeight = \"250\";\nvar dialogWidth  = \"250\";\nvar dialogTop    = \"230\";\nvar dialogLeft   = \"230\";\nvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n//*********************************************************************************************/\nfunction funClose()\n{\n\twindow.close();\n}\n\n\nfunction load()\n{\nalert()\nif(this.document.forms[0].viewflag.value==\'Y\') this.document.forms[0].views.disabled=false;\nelse this.document.forms[0].views.disabled=true;\n\n\nif(this.document.forms[0].replayflag.value==\'Y\') this.document.forms[0].replays.disabled=false;\nelse this.document.forms[0].replays.disabled=true;\n\nif(this.document.forms[0].mode.value==\'FT\')\n{\n var ww=document.getElementById(\"d1\");\n var www=document.getElementById(\"d2\");\n ww.style.display=\"none\";\n www.style.display=\"block\";\n}\n\n}\n//**************************************************************************************************\nasync function goToAuditLog(applicationId,applicationName,facilityId,facilityName,msgId,eventType,eventName)\n{\n\tvar arguments  =new Array();\n\targuments[0]=\'L\';\n\targuments[1]=applicationId;\n\targuments[2]=applicationName;\n    arguments[3]=facilityId;\n\targuments[4]=facilityName;\n\targuments[5]=msgId;\n    arguments[6]=eventType;\n\targuments[7]=eventName;\n    \n\tawait window.showModalDialog(\"../../eXH/jsp/ViewMessageAuditLogMain.jsp\",arguments,features);  \n}\n//**************************************************************************************************\nfunction replayMethod()\n{\n   this.document.menu_treetext.mode_insert.value=\'R\';\n   this.document.menu_treetext.action = \'../../eXH/jsp/ReviewApplMessageMenuMessageText.jsp\';\n   this.document.menu_treetext.submit();\n}\n//********************************************************************************************************\n\nfunction goToView()\n{\t \n\tvar dialogHeight = \"50\";\n\tvar dialogWidth  = \"50\";\n\tvar dialogTop    = \"50\";\n\tvar dialogLeft   = \"50\";\n\tvar features1     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n    var url=\"../../eXH/jsp/ViewSegments.jsp\";\n \twindow.open(url,null,\"fullscreen=no,height=550,width=700,status=yes,toolbar=no,menubar=no,scrollbars=yes,location=no\");\n\n\n\n}\n//********************************************************************************************************\n</script>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

XHReturnArray arr=new XHReturnArray();	  
    String appl_name = request.getParameter("appl_name");
	String appdes = request.getParameter("appdes");

	String facility_name = request.getParameter("facility_name");
	String facdes = request.getParameter("facdes");

	String msg_type = request.getParameter("msg_type");
	String msgdes = request.getParameter("msgdes");

	String event_type = request.getParameter("event_type");
	String eventdes = request.getParameter("eventdes");

	String msg_id = request.getParameter("msg_id");
	String msg_date = request.getParameter("msg_date");
	//	msg_status	patient_id
    String client_id = request.getParameter("client_id");
	String mode = request.getParameter("mode");

	String msg_status = request.getParameter("msg_status");
	//System.out.println("msg_status :"+msg_status);
	
	String patient_id = request.getParameter("patient_id");
	//System.out.println("patient_id :"+patient_id);


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
	ostmt.setString(1,facility_name);
	ostmt.setString(2,appl_name);
	ostmt.setString(3,msg_id);
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


String  msgsql="";

if(mode.equals("FT"))
{
	
 msgsql="SELECT  INBOUND_MESSAGE_TEXT ,MESSAGE_STATUS"+
" FROM xh_inbound_message "+
" WHERE APPLICATION_ID=NVL('"+appl_name+"',APPLICATION_ID)"+
" AND CLIENT_ID=NVL('"+client_id+"',CLIENT_ID)"+
" AND TO_CHAR(MESSAGE_RECEIVED_DATE,'DD/MM/YYYY') = NVL('"+msg_date+"', TO_CHAR(MESSAGE_RECEIVED_DATE,'DD/MM/YYYY')) "+
" AND MESSAGE_ID=NVL('"+msg_id+"',MESSAGE_ID)";
//" AND NVL(MESSAGE_STATUS,'')=NVL('"+msg_status+"',MESSAGE_STATUS)";
//" AND MESSAGE_STATUS=NVL('"+msg_status+"',MESSAGE_STATUS)";

}

else{
if (msg_status.equals("")){
msgsql="SELECT  MESSAGE_TEXT , message_status"+
" FROM xh_application_message_vw "+
" WHERE application_id = NVL('"+appl_name+"',application_id)"+
" AND facility_id = NVL('"+facility_name+"',facility_id)"+
" AND message_type= NVL('"+msg_type+"',message_type) "+
" AND event_type= NVL('"+event_type+"',event_type)"+
" AND message_id = NVL('"+msg_id+"',message_id) ";
//" AND message_status = NVL('A',message_status)";
}
else
	{

	   msgsql="SELECT  MESSAGE_TEXT , message_status"+
" FROM xh_application_message_vw "+
" WHERE application_id = NVL('"+appl_name+"',application_id)"+
" AND facility_id = NVL('"+facility_name+"',facility_id)"+
" AND message_type= NVL('"+msg_type+"',message_type) "+
" AND event_type= NVL('"+event_type+"',event_type)"+
" AND message_id = NVL('"+msg_id+"',message_id) "+
" AND message_status = NVL('"+msg_status+"',message_status)";
	
	}


	     

}

String curr_user_id=(String)session.getValue("login_user");
String usrsql="Select VIEW_YN, REPLAY_YN from xh_authorized_user where LOGIN_NAME='"+curr_user_id+"'";
ResultSet rs=null;
Statement stmt=null;
stmt=con.createStatement();
rs=stmt.executeQuery(msgsql);

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
if(rs!=null) rs.close();
if(stmt!=null) stmt.close();
if(viewflag==null) viewflag="";
if(replayflag==null) replayflag="";

}	catch (Exception e) {e.printStackTrace(System.err) ;}
    finally{ConnectionManager.returnConnection(con); }
	
if(msgstatus==null) 
//int_msgstatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Pending.label","common_labels");
int_msgstatus="Pending";
if(msgstatus!=null){ 
if(msgstatus.equalsIgnoreCase("S")) //int_msgstatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Sucessfull.Label","xh_labels");
int_msgstatus="Successful";
if(msgstatus.equalsIgnoreCase("R")) 
//int_msgstatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Rejected.Label","xh_labels");
int_msgstatus="Rejected";
if(msgstatus.equalsIgnoreCase("F")) //int_msgstatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Failure.Label","xh_labels");
int_msgstatus="Failure";
if(msgstatus.equalsIgnoreCase("A")) 
//int_msgstatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.All.Label","xh_labels");
int_msgstatus="All";
}

String segment[][]=null;
String segment1[][]=null;
String temp[][]=null;

HashMap hasmap=null;
if(msgtext!=null) hasmap=arr.returnsSegmentArray(msgtext);

if(hasmap!=null){ segment=(String[][])hasmap.get("segment");
 if(segment!=null){
 temp=new String[segment.length][2];
for(int i=1;i<segment.length;i++)
{
   if(segment[i][0].equals(segment[i-1][0]))
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
temp[segment.length-1][0]=segment[segment.length-1][0];
temp[segment.length-1][1]=segment[segment.length-1][1];
session.putValue("SegmentValues",temp);  
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

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(viewflag));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(replayflag));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(appl_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appdes));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(facdes));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(msg_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(event_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(eventdes));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(msg_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(msgdes));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(msgtext));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(appl_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(appdes));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(facility_name ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(facdes ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(msg_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(event_type ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(eventdes ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(int_msgstatus));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(int_msgstatus));
            _bw.write(_wl_block23Bytes, _wl_block23);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
