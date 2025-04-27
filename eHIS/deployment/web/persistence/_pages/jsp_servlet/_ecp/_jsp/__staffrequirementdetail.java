package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __staffrequirementdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/StaffRequirementDetail.jsp", 1709116620199L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n\n\n<head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link><script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/messages.js\' language=\'javascript\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\"JavaScript\" src=\"../../eCP/js/StaffRequirement.js\"></script>\n<script language=\"javascript\" src=\"../js/CpMessages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  \n<script>\n       \n\tfunction submitPrevNext(from, to){\n\t    document.forms[0].from.value = from;\n\t    document.forms[0].to.value = to; \n\t    document.forms[0].submit();\n\t}\n\nfunction selectAll(Obj,start,end)\n{\n\n\tif(Obj.checked)\n\t{\n\tfor(var i=start;i<=end;i++)\n\t\t{\n\t\tif(eval(\"document.forms[0].chk\"+i))\n\t\teval(\"document.forms[0].chk\"+i).checked=true;\n\t\t}\n\tvar workplace_code = document.forms[0].workplace_code.value;\n\tvar facility_id=document.forms[0].facility_id.value;\n\tvar shift_code=document.forms[0].shift_code.value;\n\tvar dependency_code=document.forms[0].dependency_code.value;\n\tvar HTMLVal = \"<HTML><BODY><form name=\'form1\' id=\'form1\' method=\'post\' action=\'StaffRequirementDynamicValues.jsp\'><input type=\'hidden\' name=\'clearAll\' id=\'clearAll\' value=\'notCleared\'><input type=\'hidden\' name=\'workplace_code\' id=\'workplace_code\' value=\'\"+workplace_code+\"\'><input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'\"+facility_id+\"\'><input type=\'hidden\' name=\'shift_code\' id=\'shift_code\' value=\'\"+shift_code+\"\'><input type=\'hidden\' name=\'dependency_code\' id=\'dependency_code\' value=\'\"+dependency_code+\"\'></form></BODY></HTML>\";\n\tparent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\tparent.frames[2].document.form1.submit();\n\t}\n\telse\n\t{\n\t\tfor(var i=start;i<=end;i++)\n\t\t\t{\n\t\t\tif(eval(\"document.forms[0].chk\"+i))\n\t\t\teval(\"document.forms[0].chk\"+i).checked=false;\n\t\t\t}\n\t\n\tvar HTMLVal = \"<HTML><BODY><form name=\'form1\' id=\'form1\' method=\'post\' action=\'StaffRequirementDynamicValues.jsp\'><input type=\'hidden\' name=\'clearAll\' id=\'clearAll\' value=\'clearAll\'></form></BODY></HTML>\";\n\tparent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\tparent.frames[2].document.form1.submit();\n\t}\n}\n\nfunction chkForSelectAll(start,end)\n{\n\tif(parent.frames[2].document.forms[0].E.value == \'selectAll\')\n\t{\n\tdocument.forms[0].chkAll.checked=true;\n\tselectAll(document.forms[0].chkAll,start,end)\n\t}\n\n}\n</script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<body  OnMouseDown=\"CodeArrest();\" onLoad=\'chkForSelectAll(";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =",";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =")\' class=\'CONTENT\' >\n<form name=\'facility_form_result\' id=\'facility_form_result\' action=\'../../eCP/jsp/StaffRequirementDetail.jsp\' method=\'post\' >\n\n<table  width=\'98%\' border=0 align=\'center\'>\n<tr>\n<td align=\'right\' class=\'NONURGENT\'>\n<input type=hidden name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n<input type=hidden name=\'workplace_code\' id=\'workplace_code\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t<input type=hidden name=\'shift_code\' id=\'shift_code\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t<input type=hidden name=\'dependency_code\' id=\'dependency_code\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t<input type=hidden name=\'maxRecord\' id=\'maxRecord\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=\'hidden\' name=\'finalSelectedValues\' id=\'finalSelectedValues\' value=\'\'>\n\n<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n<input type=\'hidden\' name=\'allValues\' id=\'allValues\' value=\'\'>\n\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n    <a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =")\' text-decoration=\'none\'>Previous</a>\n    <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =")\' text-decoration=\'none\'>Next</a>\n    <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</td>\n</tr>\n</table>\n\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'98%\' align=\'center\'>\n\t<tr>\n\t\t\t<th rowspan=\'2\'><fmt:message key=\"Common.Position.label\" bundle=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"/></th>\n\t\t\t<th colspan=\'3\'>Working Hours</th>\n\t\t\t<th  rowspan=\'2\' width=\'5%\'><fmt:message key=\"Common.selectall.label\" bundle=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"/> <br><input type=\'checkbox\' name=\'chkAll\' id=\'chkAll\' onClick=\'selectAll(this,";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =")\'></th>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t<th>WDay&nbsp;<img  src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></th> \n\t\t\t<th >NWDay&nbsp;<img  src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></th> \n\t\t\t<th >HDay&nbsp;<img  src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></th> \n\t\t\t\t</tr>\n\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' align=\'center\'><input type=\'text\' name=\'wday_hours";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'wday_hours";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' size=\'3\' maxlength=\'3\' onblur=\'CheckMin(this);check24(this);\' onkeypress=\"return allowPositiveNumber()\"  value=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="></td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' align=\'center\'><input type=\'text\' name=\'nwday_hours";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' id=\'nwday_hours";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="></td>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' align=\'center\'><input type=\'text\' name=\'hday_hours";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'hday_hours";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' size=\'3\' maxlength=\'3\' onblur=\'CheckMin(this);check24(this);\' onkeypress=\"return allowPositiveNumber();\"  value=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="></td>\n\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'><input type=\'checkbox\' ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" name=\'chk";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'  value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'> </td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\n</table>\n\n</form>\n</body>\n</html>\n\n\n\n\n\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet StaffRequirement= null;synchronized(session){
                StaffRequirement=(webbeans.eCommon.RecordSet)pageContext.getAttribute("StaffRequirement",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(StaffRequirement==null){
                    StaffRequirement=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("StaffRequirement",StaffRequirement,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);
            webbeans.eCommon.RecordSet StaffRequirementwday= null;synchronized(session){
                StaffRequirementwday=(webbeans.eCommon.RecordSet)pageContext.getAttribute("StaffRequirementwday",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(StaffRequirementwday==null){
                    StaffRequirementwday=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("StaffRequirementwday",StaffRequirementwday,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);
            webbeans.eCommon.RecordSet StaffRequirementnwday= null;synchronized(session){
                StaffRequirementnwday=(webbeans.eCommon.RecordSet)pageContext.getAttribute("StaffRequirementnwday",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(StaffRequirementnwday==null){
                    StaffRequirementnwday=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("StaffRequirementnwday",StaffRequirementnwday,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);
            webbeans.eCommon.RecordSet StaffRequirementhday= null;synchronized(session){
                StaffRequirementhday=(webbeans.eCommon.RecordSet)pageContext.getAttribute("StaffRequirementhday",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(StaffRequirementhday==null){
                    StaffRequirementhday=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("StaffRequirementhday",StaffRequirementhday,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block4Bytes, _wl_block4);

//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String spcode="";
	//String spname="";
	
	String  req_start   =   "", req_end     =   "";
	
        String  checkedOnes         =   "",checkedWday="",checkedNWday="",checkedHday="";
        String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;
        int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
        int i=1;

        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
       
       req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
       req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

	String effStatus="";
	Statement stmt3 = null;
	ResultSet rstlRs3 = null;
	PreparedStatement pstmt = null;//common-icn-0180

	effStatus=request.getParameter("effStatus");
	if(effStatus == null) effStatus="";
		Statement stmt=null;
		ResultSet rs=null ;

	Connection con = null;
	try{
			
	con = ConnectionManager.getConnection(request);

	
	//String dat="";
	//String facility="";
	//String pract="";
	//String en="";
	//String fnval="insert";
	//String id="";
	//String fname="";
	//String prname="";
	//String ps="";

	String facility_id=request.getParameter("facility_id");
	String workplace_code = request.getParameter("workplace_code");
	String shift_code = request.getParameter("shift_code");
	String dependency_code = request.getParameter("dependency_code");

	String flagSelect = request.getParameter("fromSearch");
	String wday_hours="" ;
	String nwday_hours="";
	String hday_hours="";


	        	if(flagSelect !=null)
	        	{
	        		StaffRequirement.clearAll();
					StaffRequirementwday.clearAll();
					StaffRequirementnwday.clearAll();
					StaffRequirementhday.clearAll();

	        		 //String sqlinsVals= "select position_code,wday_hours,nwday_hours,hday_hours from cp_staff_requirement where facility_id='"+facility_id+"' and workplace_code='"+workplace_code+"' and shift_code='"+shift_code+"'and dependency_code='"+dependency_code+"'";//common-icn-0180
	        		 String sqlinsVals= "select position_code,wday_hours,nwday_hours,hday_hours from cp_staff_requirement where facility_id= ? and workplace_code= ? and shift_code= ? and dependency_code= ?";//common-icn-0180
	 				
	        		//common-icn-0180 starts
				 //stmt3=con.createStatement();//common-icn-0180
				 pstmt=con.prepareStatement(sqlinsVals);
				 pstmt.setString(1, facility_id);
				 pstmt.setString(2, workplace_code);
				 pstmt.setString(3, shift_code);
				 pstmt.setString(4, dependency_code);
				 //rstlRs3 = stmt3.executeQuery(sqlinsVals);//common-icn-0180
				 rstlRs3 = pstmt.executeQuery();
				//common-icn-0180 ends
				if(rstlRs3 !=null)
				{
					 while(rstlRs3.next())
					 {
						StaffRequirement.putObject(rstlRs3.getString(1));
						 wday_hours = rstlRs3.getString("wday_hours");
						 nwday_hours=rstlRs3.getString("nwday_hours");
						 hday_hours=rstlRs3.getString("hday_hours");
						if(wday_hours == null) wday_hours="";
				    	StaffRequirementwday.putObject(wday_hours);
						if(nwday_hours == null) nwday_hours="";
				    	StaffRequirementnwday.putObject(nwday_hours);
						if(hday_hours == null) hday_hours="";
				    	StaffRequirementhday.putObject(hday_hours);
						
					 }
				}
	
	        	}

             if(from != null && to != null)
             {
                     int j=0;
                     for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
                     {
                         if(request.getParameter("chk"+(i)) != null || request.getParameter("wday_hours"+(i)) != null || request.getParameter("nwday_hours"+(i)) != null|| request.getParameter("hday_hours"+(i)) != null)
                         {
                             checkedOnes = request.getParameter("chk"+(i));
							 checkedWday=request.getParameter("wday_hours"+(i));
							 if(checkedWday == null) checkedWday="";
							 checkedNWday=request.getParameter("nwday_hours"+(i));
							if(checkedNWday == null) checkedNWday="";
							checkedHday=request.getParameter("hday_hours"+(i));
							if(checkedHday == null) checkedHday="";
                       
                             if(!(StaffRequirement.containsObject(checkedOnes) &&!StaffRequirementwday.containsObject(checkedWday)&&!StaffRequirementnwday.containsObject(checkedNWday)&&!StaffRequirementhday.containsObject(checkedHday) )) { 
								 
                                 StaffRequirement.putObject(checkedOnes);
								 StaffRequirementwday.putObject(checkedWday);
								StaffRequirementnwday.putObject(checkedNWday);
								   StaffRequirementhday.putObject(checkedHday);
							 }

                             j++;
                         }
                         
                     }
     
            
                 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
        i = 1 ;
     
			String classValue="";
			String chkAttribute="";
			//String eff_status="",selectyn="";
			

	

	//String sql=" select  position_code,position_desc,to_number(null) wday_hours,to_number(null) nwday_hours,to_number(null) hday_hours,'l' db_action from am_position where position_code not in(select position_code from cp_staff_requirement where facility_id='"+facility_id+"' and workplace_code= '"+workplace_code+"' and shift_code= '"+shift_code+"' and dependency_code='"+dependency_code+"')and role_type='P' and eff_status='E' and position_code in(select position_code from rs_shift_for_position where shift_code= '"+shift_code+"') union all select a.position_code,b.position_desc,wday_hours,nwday_hours,hday_hours,'U' db_action from cp_staff_requirement a,am_position b where a.facility_id= '"+facility_id+"' and a.workplace_code= '"+workplace_code+"' and a.shift_code= '"+shift_code+"'  and a.dependency_code='"+dependency_code+"' and b.position_code=a.position_code and b.role_type='P' order by 2 ";//common-icn-0180
	String sql=" select  position_code,position_desc,to_number(null) wday_hours,to_number(null) nwday_hours,to_number(null) hday_hours,'l' db_action from am_position where position_code not in(select position_code from cp_staff_requirement where facility_id=? and workplace_code= ? and shift_code= ? and dependency_code=?)and role_type='P' and eff_status='E' and position_code in(select position_code from rs_shift_for_position where shift_code= ?) union all select a.position_code,b.position_desc,wday_hours,nwday_hours,hday_hours,'U' db_action from cp_staff_requirement a,am_position b where a.facility_id= ? and a.workplace_code= ? and a.shift_code= ?  and a.dependency_code=? and b.position_code=a.position_code and b.role_type='P' order by 2 ";//common-icn-0180
	
				
		
try{
	//common-icn-0180 starts
	//stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//common-icn-0180
	 pstmt=con.prepareStatement(sql);
	 pstmt.setString(1, facility_id);
	 pstmt.setString(2, workplace_code);
	 pstmt.setString(3, shift_code);
	 pstmt.setString(4, dependency_code);
	 pstmt.setString(5, shift_code);
	 pstmt.setString(6, facility_id);
	 pstmt.setString(7, workplace_code);
	 pstmt.setString(8, shift_code);
	 pstmt.setString(9, dependency_code);
	//rs=stmt.executeQuery(sql);//common-icn-0180
	rs=pstmt.executeQuery();
	//common-icn-0180 ends
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();
	  }catch(Exception e){
		 // out.println(e);//COMMON-ICN-0181
             e.printStackTrace();//COMMON-ICN-0181
		  }


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(start));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(end));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(shift_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(dependency_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(start));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(end));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(start));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(end));
            _bw.write(_wl_block18Bytes, _wl_block18);

    if ( !(start <= 1)) {

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((start-12)));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf((end-12)));
            _bw.write(_wl_block20Bytes, _wl_block20);

    }
    if ( !((start+12) >= maxRecord )){

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((start+12)));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf((end+12)));
            _bw.write(_wl_block21Bytes, _wl_block21);

    }

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(start));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(end));
            _bw.write(_wl_block25Bytes, _wl_block25);
	 
		if (start != 0){
				    for(int j=1; j<=start; i++,j++){
					rs.next() ;
				     }
				    }
			while(rs.next() && i<=end){ 
			String position_code=rs.getString("position_code");
						
			String position_desc=rs.getString("position_desc");
			

			if(StaffRequirement.containsObject(position_code)) 
				{
				chkAttribute = "CHECKED";
			
				}
			else
				{
			chkAttribute="";
		
				}

			int recordIndex = StaffRequirement.indexOfObject(position_code);
			if(recordIndex!=-1)
			if(chkAttribute.equals("CHECKED"))    
				{
				StaffRequirement.removeObject(recordIndex);
				wday_hours=(String)StaffRequirementwday.getObject(recordIndex);
				System.err.println("wday_hours"+wday_hours);
				StaffRequirementwday.removeObject(recordIndex);
				nwday_hours=(String)StaffRequirementnwday.getObject(recordIndex);
				System.err.println("nwday_hours"+nwday_hours);

				StaffRequirementnwday.removeObject(recordIndex);

				hday_hours=(String)StaffRequirementhday.getObject(recordIndex);
				System.err.println("hday_hours"+hday_hours);

				
				StaffRequirementhday.removeObject(recordIndex);

				}
				else
				{
					wday_hours="";
					nwday_hours="";
					hday_hours="";
				}
	
	
				if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";
				
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(position_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(wday_hours));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(nwday_hours));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(hday_hours));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(position_code));
            _bw.write(_wl_block43Bytes, _wl_block43);

			i++;
				
				wday_hours="";
					nwday_hours="";
					hday_hours="";
				
			}		
			
			
			 }
			  catch(Exception e){out.print(e);}
			  finally
			  {
				  
							 if(rs != null){ rs.close(); }
							  if(rstlRs3 != null){ rstlRs3.close(); }
				            if(stmt != null){ stmt.close(); }
				            if(pstmt != null){ pstmt.close(); }//common-icn-0180
				   		    if(stmt3 != null){ stmt3.close(); }
					    

				ConnectionManager.returnConnection(con,request);
				session.setAttribute("StaffRequirement", StaffRequirement);
				session.setAttribute("StaffRequirementwday", StaffRequirementwday);
				session.setAttribute("StaffRequirementnwday", StaffRequirementnwday);
				session.setAttribute("StaffRequirementhday", StaffRequirementhday);

			  }
            _bw.write(_wl_block44Bytes, _wl_block44);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
