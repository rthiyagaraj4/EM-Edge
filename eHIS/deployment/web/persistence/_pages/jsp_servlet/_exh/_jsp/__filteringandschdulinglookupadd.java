package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHDBAdapter;
import java.util.*;
import com.ehis.util.*;

public final class __filteringandschdulinglookupadd extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/FilteringAndSchdulingLookupAdd.jsp", 1743586693662L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'JavaScript\' src=\'../../eXH/js/DataElementCrossReference.js\'></script>\n<script language=\'JavaScript\' src=\'../../eXH/js/Validate.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script language=\'JavaScript\' src=\'../../eXH/js/DataElementCrossReferenceappltab.js\'></script>\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n\n\n\n<script language=\"JavaScript\">\nfunction checklength(event,obj)\n{\n    var bool=true;\n\t\n\t\t  if(obj.value.length<=10)\n\t\t{\n\t\t\tbool=true;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tbool=false;\n\t\t}\n\t\n\t\n\treturn bool;\n}\nfunction CheckForSpecCharsforID(event){\n\t\tvar strCheck = \'0123456789abcdefghijklmnopqrtsuvwxyzABCDEFGHIJKTLMNOPQRSUVWXYZ\';\n\t\t var whichCode = (window.Event) ? event.which : event.keyCode;\n\t\t key = String.fromCharCode(whichCode);  // Get key value from key code\n\t\t if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\t\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\t\treturn (event.keyCode -= 32);\n\t\treturn true ;\n\t}\nfunction checkEmptyChar(obj)\n{\nvar fields=obj.value;\nobj.value=fields.toUpperCase();\nif(fields.indexOf(\' \')!=-1)\n{\nalert(getMessage(\'XH0068\',\'XH\'));\nobj.focus();\n}\n\n}\nfunction  onSelectChange()\n{\n//parent.frames[2].document.location.href=\'../../eXH/jsp/FilteringAndSchdulingLookupAdd.jsp?Filter_group_code_combo=\'+this.value+//\'&Application_type_id=\'++\'&Filter_group_code=\'++\'&Filter_group_desc=\'++\'Protocol_Link_id=\'+;\n\tthis.document.forms[0].action=\'../../eXH/jsp/FilteringAndSchdulingLookupAdd.jsp\';\n   this.document.forms[0].target=\'\';\n   this.document.forms[0].submit();\n}\n\nfunction onSelectStandardType()\n{\n\n\n  /*var index\t\t= document.forms[0].Filter_group_code1.options.selectedIndex;\n\tdocument.forms[0].description_type.value= document.forms[0].Filter_group_code1.options[index].text;\ndocument.forms[0].Filter_group_desc.value= document.forms[0].Filter_group_code1.options[index].text;*/\n}\nasync function funPrev()\n{\n\tvar stnd_code=document.forms[0].Standardcode_combo.value;\n\t\tvar seg_type=document.forms[0].segment_type.value;\n\t\t\tvar appl =  this.document.forms[0].application.value; \n\t\tvar dialogHeight = \"90vh\";\nvar dialogWidth  = \"95vw\";\nvar dialogTop    = \"115\";\nvar dialogLeft   = \"115\";\nvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\nvar arguments  =new Array();\n\tvar url=\"../../eXH/jsp/DataElementCrossRefApplicationElementSetupPreview.jsp?applicationid=\"+appl+\"&segment_type_id=\"+seg_type+\"&standard_code=\"+stnd_code;; \n await window.showModalDialog(url,arguments,features);  \n} \n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</HEAD>\n\n<BODY  leftmargin=0 topmargin=0   onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' onLoad=\"\">\n\n<form name=\"application_element_setup_form\" id=\"application_element_setup_form\" action=\'../../eXH/jsp/FilterLayerGroupRecord.jsp\'>\n\n<table cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n<!--<tr>\n\t<td width=\'30%\'></td>\n\t<td width=\'10%\'></td>\n\t<td width=\'30%\'></td>\n\t<td width=\'30%\'></td> \n</tr>--->\n<tr>\n<td class=label>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td> \n<td class=\'fields\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n \n<select class=\'select\' name=\'Filter_group_code_combo\' id=\'Filter_group_code_combo\' onChange=\"location.href=\'../../eXH/jsp/FilteringAndSchdulingLookupAdd.jsp?Filter_group_code_combo=\'+this.value+\'&Application_type_id=&Filter_group_code=\'+this.document.forms[0].Filter_group_code.value+\'&Filter_group_desc=\'+this.document.forms[0].Filter_group_desc.value+\'&Protocol_Link_id=\';\" style=\"width:200\"> \n<option value=\'\' >-------";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="-------</option> \n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n       <option value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'  selected >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</option> \n ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t  \t<option value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'  >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option> \n               ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n            \n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n            </select>\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n</td>\n<td class=label>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td> \n<td class=\'fields\'>\n<select class=\'select\' name=\'Application_type_id\' id=\'Application_type_id\' style=\"width:200\" onChange=\"location.href=\'../../eXH/jsp/FilteringAndSchdulingLookupAdd.jsp?Filter_group_code_combo=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&Application_type_id=\'+this.value+\'&Filter_group_code=\'+this.document.forms[0].Filter_group_code.value+\'&Filter_group_desc=\'+this.document.forms[0].Filter_group_desc.value+\'&Protocol_Link_id=\';\" >\n            <option value=\'\' selected>-------";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="-------</option>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n<option value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</option>\n ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</option>\n\t\t   ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" \n   </select>\n   <img src=\'../../eCommon/images/mandatory.gif\' align=middle></td>\n<td class=label>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="<td>\n<td class=\'fields\'>\n<select class=\'select\' name=\'Protocol_Link_id\' id=\'Protocol_Link_id\' style=\"width:200\">\n<option value=\'\' selected>-------";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n                 <option value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n                  <option value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n\n\n</select>\n\n ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n<img src=\'../../eCommon/images/mandatory.gif\' align=middle> </td> \n\n\n<input type=\"hidden\" name=\"Facility__id\" id=\"Facility__id\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"> \n<input type=\"hidden\" name=\"Event__id\" id=\"Event__id\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n<input type=\"hidden\"   name =\'Message__id\' size=\'15\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'  >\n \n<input type=\"hidden\" name=Total_level id=Total_level value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'/>\n<input type=\"hidden\" name=version_no id=version_no value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'/>  \n  <input type=\"hidden\" name=code id=code value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'/>\n\n<input type=\"hidden\" name=function_name id=function_name value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'/>\n</tr>\n\n<TR>\n<td class=label>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n<td class=\'fields\'>\n<input type=\"text\"  name=\'Filter_group_code\' id=\'Filter_group_code\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' maxlength=10 style=\"width:200\" onKeyPress=\'return CheckForSpecCharsforID(event);return checklength(event,this);\' onBlur=\'checkEmptyChar(this);\'>\n<img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n\n</td>       \n\n<td class=label>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n<td class=\'fields\'>\n<input type=\"text\"  name=\'Filter_group_desc\' id=\'Filter_group_desc\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' maxlength=30  style=\"width:200\" >\n<img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n</td>       \n\t<td class=\'fields\'></td>\t\n\t\t<td class=\'fields\'></td>\n\t\t<td class=\'fields\'></td>\t\n\t\n</tr>\n<!---<tr>\n\t<td width=\'30%\'></td>\n\t<td width=\'10%\'></td>\n\t<td width=\'40%\'></td>\n\t<td width=\'20%\'></td>\n</tr>--->\n</table>\n\n<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0 align=\'center\'>\n  \n<td colspan=4 align=right><input class=\'button\' type=\"button\"  name=\'Preview\' id=\'Preview\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' onClick=\'funRecord()\'></td>\n\n   </tr>\n</table>\n           \n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n<input type=\"hidden\" name=actualmode id=actualmode value=\'I\'/>\n\n<input type=\"hidden\" name=code id=code value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'/>\n<input type=\"hidden\" name=function_name id=function_name value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'/>\n</form>\n<script>\nfunction funRecord()\n{\n\n \n\nvar fields = new Array (  document.forms[0].Filter_group_code_combo,\n\t\t\t\t\t\tdocument.forms[0].Application_type_id,document.forms[0].Protocol_Link_id,document.forms[0].Filter_group_code,document.forms[0].Filter_group_desc   \n\t\t\t\t\t   );\n\n\nvar names = new Array (getLabel(\"eXH.SysdefGroup.Label\",\"XH\"),\n\t\t\t\t\t\tgetLabel(\"Common.Application.label\",\"common\"),getLabel(\"eXH.Gateway.Label\",\"XH\"),getLabel(\"eXH.UsrdefGroupCode.Label\",\"XH\"),getLabel(\"Common.description.label\",\"common\"));\nif(!checkFieldsofMst( fields, names, parent.messageFrame,\'1\'))\n\t{\n\n\n\t}\n\telse\n\t{\n       document.forms[0].target=\'messageFrame\';\n       this.document.forms[0].submit();\n       parent.frames[1].document.location.href=\'FileteringAndSchdulingLookupQueryResult.jsp?\';\n     parent.frames[2].document.location.href=\'../../eXH/jsp/FilteringAndSchdulingLookupAdd.jsp?Filter_group_code_combo=&Application_type_id=&Filter_group_code=&Filter_group_desc=&Protocol_Link_id=\';\n\t}\n\n}\n \n</script>\n</BODY>\n</HTML> \n\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 //String locale = ((String)session.getAttribute("LOCALE"));	
            _bw.write(_wl_block5Bytes, _wl_block5);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
 
String function_name="Application Level";
String code="";
Connection con=null;  
Statement stmt = null;
ResultSet rs  = null;
ResultSet rs1  = null;
ResultSet standrs=null;
Statement standstmt=null;
Statement segstmt=null;
ResultSet segrs=null; 
String defaultval = "";
String code_yn="";
String version_no=""; 
Statement protocolstmt=null;
ResultSet protocolrs=null;
String application_id="";
String facility_id="";String message_type="";String event_type="";String total_levels="";
String procol_link="";

 code=XHDBAdapter.checkNull(request.getParameter("Filter_group_code_combo"));
application_id=XHDBAdapter.checkNull(request.getParameter("Application_type_id"));
String newcode=XHDBAdapter.checkNull(request.getParameter("Filter_group_code"));
String newdesc=XHDBAdapter.checkNull(request.getParameter("Filter_group_desc"));
procol_link=XHDBAdapter.checkNull(request.getParameter("Protocol_Link_id"));

//System.out.println("newcode ="+newcode);


            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

try
{
	con=ConnectionManager.getConnection();
    defaultval="";
	String qry = "SELECT FILTER_GROUP_CODE code,FILTER_GROUP_DESC Description,APPLICATION_ID from XH_FILTER_GROUP WHERE filter_group_code IN ('ADTFIL','SIUFIL')";
	standstmt = con.createStatement();
	standrs = standstmt.executeQuery(qry);

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

defaultval="";
//code="";
 //code=request.getParameter("code");
defaultval=code;

//System.out.println("defaultval  code:"+code);

	while(standrs.next())
            {
              if ((standrs.getString(1)+"").equalsIgnoreCase(defaultval))
              {
      
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(standrs.getString(1)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(standrs.getString(2)));
            _bw.write(_wl_block14Bytes, _wl_block14);
             }
              else
              {
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(standrs.getString(1)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(standrs.getString(2)));
            _bw.write(_wl_block17Bytes, _wl_block17);

              } 

            _bw.write(_wl_block18Bytes, _wl_block18);
 	}  
	if(standrs!=null)standrs.close();
			if(standstmt!=null)standstmt.close();


}catch(Exception e1)
{
	System.out.println("(FilteringAndSchdulingLookupAdd.jsp:Exception-1):"+e1.toString());
}


			
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(code));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

try
{
	
String qry = "SELECT APPLICATION_ID,APPLICATION_NAME FROM XH_APPLICATION_LANG_VW where IN_USE_YN='Y' and   LANGUAGE_ID='en' ";
	stmt = con.createStatement();
	rs = stmt.executeQuery(qry);

            _bw.write(_wl_block23Bytes, _wl_block23);

//application_id=XHDBAdapter.checkNull(request.getParameter("application_id"));
defaultval=application_id;

	while(rs.next())
            {
              if ((rs.getString(1)+"").equalsIgnoreCase(defaultval))
              {

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block25Bytes, _wl_block25);
             }
              else
              {
           
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block26Bytes, _wl_block26);

              }

			}
}
catch(Exception e)
{
	System.out.println("(FilteringAndSchdulingLookupAdd.jsp:Exception1) :"+e);
}

            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

try
{
	
String someqry = "SELECT PROTOCOL_LINK_ID, PROTOCOL_LINK_NAME  FROM xh_protocol_link where APPLICATION_ID=nvl('"+application_id+"',APPLICATION_ID)";


	protocolstmt = con.createStatement();
	protocolrs = protocolstmt.executeQuery(someqry);
 while(protocolrs.next())
            {
              if ((protocolrs.getString(1)+"").equalsIgnoreCase(procol_link))
              {

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(protocolrs.getString(1)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(protocolrs.getString(2)));
            _bw.write(_wl_block25Bytes, _wl_block25);
           }
			  else
			  {
           
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(protocolrs.getString(1)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(protocolrs.getString(2)));
            _bw.write(_wl_block26Bytes, _wl_block26);

              }
  			 }

			if(protocolstmt!=null)
	{
				protocolstmt.close();
	}
if(protocolrs!=null)
	{
protocolrs.close();
	}
      }
catch(Exception e)
{
	System.out.println("(FilteringAndSchdulingLookupAdd.jsp:Exception-2) :"+e);
}

            _bw.write(_wl_block31Bytes, _wl_block31);


 String somesql="SELECT distinct FACILITY_ID, MESSAGE_TYPE, EVENT_TYPE, PROTOCOL_LINK,"+ "TOTAL_LEVELS,ADDED_BY_ID,ADDED_DATE,MODIFIED_BY_ID, MODIFIED_DATE, ADDED_AT_WS_NO, MODIFIED_AT_WS_NO from XH_FILTER_GROUP where FILTER_GROUP_CODE='"+code+"' "; 
 segstmt = con.createStatement();
	segrs = segstmt.executeQuery(somesql);
	        while(segrs.next())
            {
				facility_id=segrs.getString(1); message_type=segrs.getString(2);event_type=segrs.getString(3);total_levels=segrs.getString(5);
			} 
 
 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(event_type));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(message_type));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(total_levels));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(version_no));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(code_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(newcode));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(newdesc));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

		if(rs!=null)rs.close();
		if(rs1!=null)rs1.close();
		if(stmt!=null)stmt.close();
        if(segstmt!=null)segstmt.close();
        if(segrs!=null)segrs.close();
		ConnectionManager.returnConnection(con);

            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(code_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(version_no));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block47Bytes, _wl_block47);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.SysdefGroup.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Application.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Gateway.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.UsrdefGroupCode.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.record.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }
}
