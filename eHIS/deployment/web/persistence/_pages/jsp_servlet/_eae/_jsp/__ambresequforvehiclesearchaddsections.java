package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.net.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __ambresequforvehiclesearchaddsections extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AMBResEquForVehicleSearchAddSections.jsp", 1709113868865L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title>Attached Sections For Note Type</title>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/messages.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/tableheaderscroll.js\" language=\"javascript\"></script>\n\t\t<script language=\'javascript\' src=\'../../eAE/js/AMBResEquForVehicle.js\'></script>\n\t\t<script>\n\t\tfunction fnOnLoad(){\n\t\t\tif(document.getElementById(\"dat1\")!=null){\n\t\t\t\tfxheaderInit(\'dat1\',190);\n\t\t\t}\n\t\t}\n\t\t\n\t\t</script>\n\t</head>\n\t<body onscroll=\'scrollTitle()\' onload=\"fnOnLoad();\" OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name = \'secForNoteTypeSearchSectionsForm\'>\n\t\t\t<table cellpadding=\'5\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t\t<tr id=\'trcoll\'>\n\t\t\t\t\t<th align=\'center\' colspan=\'3\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</th>\n\t\t\t\t</tr>\n\t\t\t\t<tr id=\'trcoll\'>\n\t\t\t\t\t<td class = \'label\' align=\'right\' width =\'35%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&nbsp;\n\t\t\t\t\t<select name =\'amb_res_type\' >\n\t\t\t\t\t<option value = \'\'>---Select----</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<option value = \'P\' ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =">Practitioner</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t\t\t\t\t<option value = \'E\' ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =">External Practitioner</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<option value = \'O\' ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =">Other Staff</option>\n\t\t\t\t\t</select></td>\n\t\t\t\t\t<td class = \'label\' align=\'right\' width=\'65%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp; <input type=\'text\' name=\'searchText\' id=\'searchText\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'></td>\n\t\t\t\t\t<td width=\'35%\'><input type=\'button\' name=\'searchBtn\' id=\'searchBtn\' class=\'button\' value = \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' onclick=\'loadSections()\'></td>\n\t\t\t\t</tr>\t\t\t\t\n\t\t\t</table>\n\t\t\t<!--<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\'><a style=\'visibility:hidden\' id=\'prevRecs\' href=\"javascript:loadPrevNextRecs(\'prev\')\">Prev</a>&nbsp;&nbsp;<a id=\'nextRecs\' href=\"javascript:loadPrevNextRecs(\'next\')\">Next</a></td>\n\t\t\t\t</tr>\n\t\t\t</table>-->\n\t\t\t<!--<table cellpadding=\'0\' cellspacing=\'0\' border=\'1\' width=\'100%\' align=\'center\'>\n\t\t\t\t<tr id=\'trcoll\'>\n\t\t\t\t\t<th align=\'center\' width = \'35%\'>Description</th>\n\t\t\t\t\t<th align=\'center\' width = \'15%\'>Position</th>\n\t\t\t\t\t<th align=\'center\' width = \'20%\'>Type</th>\n\t\t\t\t\t<th align=\'center\' width = \'10%\'>Select</th>\n\t\t\t\t</tr>-->\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t<P>\n\t\t\t\t\t\t\t<table align=\'right\' >\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t<td align =\'left\' id=\'prev\' ><A href=\"#\"  onclick=\"loadPrevNextRecs(\'prev\')\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</A>&nbsp;&nbsp;<td>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t<td align =\'right\' id=\'next\' style=\'visibility:hidden\'>\n\t\t\t\t\t\t\t<A href=\"#\" onclick=\"loadPrevNextRecs(\'next\')\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</A>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t<br><br>\n\t\t\t\t\t\t\t</P>\n\t\t\n\t\t<table id=\"dat1\" border=\"1\" width=\"100%\" style=\"border-spacing:0px ;border-collapse: collapse;\" >\n\t\t\t\t<tr >\n\t\t\t\t\t<th >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</th>\n\t\t\t\t\t<th >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</th>\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</th>\n\t\t\t\t\t</tr>\n\t\t\t\t\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tparent.parent.rowIDSectionForNoteType[";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="] = \'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\';\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t<script >\n\t\t\t\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\"next\").innerHTML=\"\";\n\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t\t<script >\n\t\t\t\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t//document.getElementById(\"nextRecs\").style.visibility = \'hidden\';\n\t\t\t\t\t\t\t\t\t//document.getElementById(\"prevRecs\").style.visibility = \'hidden\';\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\n\t\t\t\t</table>\n\t\t\t\t\n\t\t\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t<input type=\'hidden\' name=\'searchTextHidden\' id=\'searchTextHidden\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t<input type=\'hidden\' name=\'flag\' id=\'flag\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t<input type=\'hidden\' name=\'note_type\' id=\'note_type\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t<input type=\'hidden\' name=\'totalCount\' id=\'totalCount\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t\t<input type=\'hidden\' name=\'countForNext\' id=\'countForNext\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t</form>\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t<script>\n\t\t\tparent.sectionsFrame.location.href = \'../../eAE/jsp/AMBResEquForVehicleAMB.jsp?note_type=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\';\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t<script>\n\t\t\t/*var tempVar = ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" / 12;\n\t\t\tif(";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" == 0)\n\t\t\t\tdocument.getElementById(\"prevRecs\").style.visibility = \'hidden\';\n\t\t\telse\n\t\t\t\tdocument.getElementById(\"prevRecs\").style.visibility = \'visible\';\n\t\t\n\t\t\tif(";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" < 12 || ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" == tempVar)\n\t\t\t\tdocument.getElementById(\"nextRecs\").style.visibility = \'hidden\';\n\t\t\telse\n\t\t\t\tdocument.getElementById(\"nextRecs\").style.visibility = \'visible\';*/\n\t\t</script>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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

	eAE.AMBResEquVehicleBean resequBean = (eAE.AMBResEquVehicleBean)getObjectFromBean("resequBean","eAE.AMBResEquVehicleBean",session);

            _bw.write(_wl_block5Bytes, _wl_block5);

			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			String facilityId 	= (String) session.getValue( "facility_id" ) ;
			String searchText = request.getParameter("searchText") == null ? "" : request.getParameter("searchText");
			String strResType = request.getParameter("amb_res_type") == null ? "" : request.getParameter("amb_res_type");
			String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
			String flag = request.getParameter("flag") == null ? "1" : request.getParameter("flag");
			String flagTemp = request.getParameter("flagTemp") == null ? "1" : request.getParameter("flagTemp");
			String note_type = request.getParameter("note_type") == null ? "" : request.getParameter("note_type");
			//String startString =  request.getParameter("start") == null ? "0" : request.getParameter("start");
		//	String endString =  request.getParameter("end") == null ? "9" : request.getParameter("end");
			String loadFirst =  request.getParameter("loadFirst") == null ? "" : request.getParameter("loadFirst");
			String tempRowIds =  request.getParameter("tempRowIds") == null ? "" : request.getParameter("tempRowIds");
			String strSelected	=	"";
			String strResource	=	"";
			String strPosition	=	"";
			String strPosDisplay	=	"";
			String strBeanKey		=	"";
			int countForNext = request.getParameter("countForNext") == null ? 1 : Integer.parseInt(request.getParameter("countForNext"));
	
			if(tempRowIds.indexOf("^") != -1)
			{
				for(int y=0;y<tempRowIds.length();y++)
					tempRowIds = tempRowIds.replace('^','+');
			}

			if(!tempRowIds.equals(""))
				tempRowIds = tempRowIds.substring(0,tempRowIds.length()-1);

			

			int tempSeq = 0;
			int count = 0;
			int tempCount = 0;
			//Mahesh start
			String from = request.getParameter( "from" );
			String to = request.getParameter( "to" );
			int maxRecord=0;
			int start = 0;
			int end = 0;
	 int h=1;

	 if ( from == null )
		start = 1 ;
	 else
		start = Integer.parseInt( from ) ;

	 if ( to == null )
	  	end = 9;
	 else
		end = Integer.parseInt( to ) ;
		//End
	
			if(mode.equals("modify"))
				searchText = "";
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

							if(strResType.equals("P") )
								strSelected	=	"selected";
							else
								strSelected	=	"";
					
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strSelected));
            _bw.write(_wl_block11Bytes, _wl_block11);

							if(strResType.equals("E") )
								strSelected	=	"selected";
							else
								strSelected	=	"";
					
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strSelected));
            _bw.write(_wl_block13Bytes, _wl_block13);

							if(strResType.equals("O") )
								strSelected	=	"selected";
							else
								strSelected	=	"";
					
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strSelected));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(searchText));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block18Bytes, _wl_block18);

					Connection con = null;
					PreparedStatement pstmtNoteSections = null;
					ResultSet resNoteSections = null;
					PreparedStatement pstmtChk = null;
					ResultSet resChk = null;

					String sec_heading_code = "";
					String sec_heading_desc = "";
					String content_type = "";
					String chief_comp = "";
					StringBuffer sqlNoteSec = new StringBuffer();
					String classValue = "";
					String exist_yn = "";
					String chkSelBox = "";
					String rowID = "";

					int cnt = 0;

					if(!mode.equals("modify"))
					{
						ArrayList keySectionForChk = resequBean.retrieveRecords();
						try
						{
							con = ConnectionManager.getConnection(request);
							sqlNoteSec.append("SELECT A.PRACTITIONER_id || '~' || A.PRACT_SOURCE ROWIDEN , A.PRACTITIONER_ID  ,A.PRACTITIONER_NAME  , A.PRACT_SOURCE  ,NVL((    SELECT      'Y'     FROM      AE_AMB_VEHICLE_RESOURCE B    WHERE B.AMB_VEHICLE_ID=? and b.facility_id = '"+facilityId+"' AND B.AMB_RESOURCE_ID =A.PRACTITIONER_ID   AND B.AMB_RESOURCE_TYPE = A.PRACT_SOURCE    AND ROWNUM=1   )  ,'N' ) exist_yn,DECODE(A.PRACT_SOURCE,'P','Practitioner','E','External Practitioner','O','Other Staff') RESTYPE,NVL(A.POSITION_DESC,'AA') POSITION_DESC FROM AM_PRACT_FOR_AMB_VW  A WHERE 1=1 ");
							
							if(!searchText.equals(""))
							{
								sqlNoteSec.append(" and upper(PRACTITIONER_NAME) like upper(?)");
							}

							if(!tempRowIds.equals(""))
							{
								sqlNoteSec.append(" and A.PRACTITIONER_id ||'~'|| A.PRACT_SOURCE in ("+tempRowIds+") ");
							}

							if(!strResType.equals("") )
							{
								sqlNoteSec.append(" AND A.PRACT_SOURCE = ? ");
							}

							sqlNoteSec.append(" ORDER BY PRACTITIONER_NAME ");

							pstmtNoteSections = con.prepareStatement(sqlNoteSec.toString());
							
							int nCntA	=	0;
							pstmtNoteSections.setString(++nCntA,note_type);

							if(!searchText.equals(""))
							{
								pstmtNoteSections.setString(++nCntA,searchText+"%");
							}

							if(!strResType.equals("") )
							{
								pstmtNoteSections.setString(++nCntA,strResType);
							}
							resNoteSections = pstmtNoteSections.executeQuery();
							//Mahesh start
							if ( start != 1 )
							 for( int j=1; j<start; h++,j++ )
							  {
								resNoteSections.next() ;
							  }	
							 //End 
							while (resNoteSections!=null && h<=end && resNoteSections.next()) 
							//while(resNoteSections.next())
								{
								if(maxRecord == 0)
									{
								
            _bw.write(_wl_block19Bytes, _wl_block19);
if ( !(start <= 1) ){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

							}
								rowID				= resNoteSections.getString("ROWIDEN");
								sec_heading_code	= resNoteSections.getString("PRACTITIONER_ID");
								sec_heading_desc	= resNoteSections.getString("PRACTITIONER_NAME");
								content_type		= resNoteSections.getString("PRACT_SOURCE");
								exist_yn			= resNoteSections.getString("exist_yn");
								strResource			= resNoteSections.getString("RESTYPE");
								strPosition			= resNoteSections.getString("POSITION_DESC");

								if(strPosition == null || strPosition.equals("AA") )
								{
									strPosition = "AA";
									strPosDisplay  = "&nbsp;";
								}
								else
									strPosDisplay	=	strPosition;

								if(exist_yn.equals("Y"))
									chkSelBox = " checked ";
								else
									chkSelBox = "";

								if(content_type.equals("F") || content_type.equals("R"))
								{
									chief_comp = "N";
								}
								else
								{
									
									chief_comp = "Y";
								}

								//chief_comp = "N";

								if(keySectionForChk != null)
								{
									for(int n=0;n<keySectionForChk.size();n++)
									{
										if(((String) keySectionForChk.get(n)).equals(rowID))
										{
											chkSelBox = " checked ";
											tempSeq = n;											
											n = keySectionForChk.size();
										}
										else
											chkSelBox = "";										
									}
								}

								if(loadFirst.equals("Yes"))
								{
								
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rowID));
            _bw.write(_wl_block29Bytes, _wl_block29);

								}

								if(maxRecord < 9)
								{
						
									if(cnt%2 == 0)
										classValue = "QRYEVEN";
									else
										classValue = "QRYODD";
									out.println("<tr>");
									out.println("<td class='"+classValue+"' width = '36%'> "+sec_heading_desc+" </td>");
									out.println("<td class='"+classValue+"' width = '15%'> "+strPosDisplay+" </td>");
									out.println("<td class='"+classValue+"' width = '20%'> "+strResource+" </td>");
									out.println("<td class='"+classValue+"' style='text-align:center;' width = '10%' align='center'> <input type='checkbox' name='secChk"+cnt+"' id='secChk"+cnt+"' "+chkSelBox+" onclick=`loadSectionsPage(this,\""+rowID+"\",\""+sec_heading_desc+"\",\""+chief_comp+"\",\""+tempSeq+"\",\""+strResource+"\",\""+strPosition+"\")`> </td>");
									out.println("</tr>");
								}

								cnt++;
								h++;//Mahesh
								maxRecord++;//Mahesh
								resequBean.addFrameRecords(rowID,sec_heading_desc);						
							}
							count = cnt;
							if(loadFirst.equals("Yes"))
							{
								tempCount = cnt;
							}
							else
							{
								tempCount = request.getParameter("totalCount") == null ? 0 : Integer.parseInt(request.getParameter("totalCount"));
							}
							putObjectInBean("resequBean",resequBean,session);
							
							//Mahesh starts
							if ( maxRecord < 9 || (!resNoteSections.next()) )
								{
								
            _bw.write(_wl_block30Bytes, _wl_block30);
 
								}
								else
								{
            _bw.write(_wl_block31Bytes, _wl_block31);

								}
							//End	
							if(cnt == 0)
							{
								
            _bw.write(_wl_block32Bytes, _wl_block32);

								out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
								out.println("<script>document.forms[0].searchText.value = '';</script>");
							}
							if(resNoteSections != null) resNoteSections.close();
							if(pstmtNoteSections != null) pstmtNoteSections.close();

							if(pstmtChk != null) pstmtChk.close();
							if(resChk != null) resChk.close();
						}
						catch(Exception e)
						{
							//out.println("Exception "+e.toString());
							e.printStackTrace(System.err);
						}
						finally
						{
							if(con != null) ConnectionManager.returnConnection(con,request);
							
						}
					}
					else if(mode.equals("modify"))
					{
						String keyVal = "";
						String keyValSec = "";
						String heading_desc = "";
						String chk_sel = "";
						String codeList = "";

						int k = 0;
						int i = 0;
						ArrayList list = resequBean.retrieveArrayList();
						
						try
						{
							ArrayList keys = resequBean.retrieveHashRecords();
							ArrayList keySection = resequBean.retrieveRecords();
							//out.println("keySection --"+keySection+"--");
							HashMap recValues = resequBean.getHashRecordValues();
							for(i=0; i<keys.size(); i++)
							{
								keyVal = (String)keys.get(i);
								heading_desc = (String)recValues.get(keyVal);

								for(int j=0; j<keySection.size(); j++)
								{
									keyValSec = (String)keySection.get(j);

									if(keyVal.equals(keyValSec))
									{
										chk_sel = " checked ";
										for(k=0;k<list.size();k++)
										{
											codeList = (String) list.get(k);
											if(codeList.equals(keyVal))
											{
												tempSeq = k;
												k = list.size();
											}
										}
										 j = keySection.size();
									}
									else
										chk_sel = "";
								}

								if(i < 9)
								{
									if(i%2 ==0)
										classValue = "QRYEVEN";
									else
										classValue = "QRYODD";

									out.println("<tr>");
									out.println("<td class='"+classValue+"' > "+heading_desc+" </td>");
									out.println("<td class='"+classValue+"' style='text-align:center;' align='center'> <input type='checkbox'   "+chk_sel+" onclick=`loadSectionsPage(this,\""+keyVal+"\",\""+heading_desc+"\",\""+tempSeq+"\",\""+strResource+"\",\""+strPosition+"\")`> </td>");
									out.println("</tr>");
								}
							}
							count = i;
						}
						catch(Exception e)
						{
							//out.println("Exception  "+e.toString());
							e.printStackTrace(System.err);
						}
					}
				
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(start));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(end));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(searchText));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(tempCount));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(countForNext));
            _bw.write(_wl_block41Bytes, _wl_block41);

		if(!mode.equals("modify") && flag.equals("0") && !flagTemp.equals("temp"))
		{
		
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block43Bytes, _wl_block43);

		}
		
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(tempCount));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(start));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(count));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(countForNext));
            _bw.write(_wl_block48Bytes, _wl_block48);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.AvailableStaff.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StaffType.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.StaffStartsWith.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Position.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
