package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __ot_slate_screenframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OT_slate_screenFrame.jsp", 1709117274000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HEAD>\n\n\t\t<script> \n\t\t\tfunction closeHelp()\n\t\t\t{  \n\t\t\t\tvar key = event.keyCode; \n\t\t\t\tif (key == 27)\n\t\t\t\t{\n\t\t\t\t\tif(parent.parent.opener != null)\n\t\t\t\t\t\tparent.parent.opener.closeDashboard();\n\t\t\t\t\telse\n\t\t\t\t\t\twindow.close();\t\n\t\t\t\t}\n\t\t\t} \t\n\t\t</script>\n\t\t\t\n</HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<title> Widget Selection </title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<frameset  border=\'0px\' rows=\'48px,*\' onkeypress=\"closeHelp()\">\n\t\t\t<frame name=\'header0\' src=\"../../eOT/jsp/OT_slate_screenHeader.jsp?";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" frameborder=0 noresize>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<frame  name=\'dateFilter0\' src=\"../../eOT/jsp/OT_slate_screen.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&class=columnone_slotone\" frameborder=0 noresize>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\t\t\n\t\t\t\t\t<frameset cols=\'50%,*\' border=\'2px\'>\n\t\t\t\t\t\t<frame name=\'dateFilter0\' src=\"../../eOT/jsp/OT_slate_screen.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&class=columntwo_slotone\" frameborder=0 noresize>\n\t\t\t\t\t\t<frame name=\'staffAssign0\' src=\"../../eOT/jsp/OTStaffAssignmentFrame.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" frameborder=0 noresize>\n\t\t\t\t\t</frameset>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</frameset>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<frameset border=\'0px\'  rows=\'48px,*\' onkeypress=\"closeHelp()\">\n\t\t\t<frame name=\'header0\' src=\"../../eOT/jsp/OT_slate_screenHeader.jsp?";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<frameset cols=\'50%,*\'>\n\t\t\t\t\t\t<frame name=\'dateFilter0\' src=\"../../eOT/jsp/OT_slate_screen.jsp?";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&class=columntwo_slotone\" frameborder=0 noresize>\n\t\t\t\t\t\t<frame name=\'dateFilter1\' src=\"../../eOT/jsp/OT_slate_screen.jsp?";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&class=columntwo_slotone\" frameborder=0 noresize>\n\t\t\t\t\t</frameset>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t<frameset cols=\'33%,*,*\'>\n\t\t\t\t\t\t<frame name=\'dateFilter0\' src=\"../../eOT/jsp/OT_slate_screen.jsp?";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&class=slotone\" frameborder=0 noresize>\n\t\t\t\t\t\t<frame name=\'dateFilter1\' src=\"../../eOT/jsp/OT_slate_screen.jsp?";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&class=slottwo\" frameborder=0 noresize>\n\t\t\t\t\t\t<frame name=\'staffAssign0\' src=\"../../eOT/jsp/OTStaffAssignmentFrame.jsp?";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" frameborder=0 noresize>\n\t\t\t<frameset cols=\'33%,*,*\'>\n\t\t\t\t<frame name=\'dateFilter0\' src=\"../../eOT/jsp/OT_slate_screen.jsp?";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&class=slotone\" frameborder=0 noresize>\n\t\t\t\t<frame name=\'dateFilter1\' src=\"../../eOT/jsp/OT_slate_screen.jsp?";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&class=slottwo\" frameborder=0 noresize>\n\t\t\t\t<frame name=\'dateFilter2\' src=\"../../eOT/jsp/OT_slate_screen.jsp?";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&class=slotthree\" frameborder=0 noresize>\n\t\t\t</frameset>\n\t\t</frameset>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t<frameset cols=\'33%,*,*\'>\n\t\t\t\t\t\t<frame name=\'dateFilter0\' src=\"../../eOT/jsp/OTSlateScreenMultiple.jsp?";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&class=slotone\" frameborder=0 noresize>\n\t\t\t\t\t\t<frame name=\'dateFilter1\' src=\"../../eOT/jsp/OTSlateScreenMultiple.jsp?";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&class=slottwo\" frameborder=0 noresize>\n\t\t\t\t\t\t<frame name=\'dateFilter2\' src=\"../../eOT/jsp/OTSlateScreenMultiple.jsp?";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&class=slotthree\" frameborder=0 noresize>\n\t\t\t\t\t</frameset>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<frameset border=\'0px\' rows=\'48px,*\'>\n\t\t\t<frame name=\'header0\' src=\"../../eOT/jsp/OT_slate_screenHeader.jsp?";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" frameborder=0 noresize>\n\t\t\t<frame name=\'staffAssign0\' src=\"../../eOT/jsp/OTStaffAssignmentFrame.jsp?";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" frameborder=0 noresize>\n\t\t</frameset>\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n</html>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
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
            _bw.write(_wl_block5Bytes, _wl_block5);

String frameCount = request.getParameter("frameCount") == null ? "0" : request.getParameter("frameCount");

            _bw.write(_wl_block6Bytes, _wl_block6);

	String param = request.getQueryString();
	String param0 = "";
	String param1 = "";
	String param2 = "";

	String staffAssignmentId = request.getParameter("staffAssignmentId") == null ? "" : request.getParameter("staffAssignmentId");

	if(param.indexOf("~~") == -1)
	{
		if(param.indexOf("~") != -1)
		{
			param0 = param.substring(0, param.indexOf("~"));
			param1 = param.substring(param.indexOf("~")+1, param.length());
			
		}
	}
	else if(param.indexOf("~~") != -1)
	{
		param0 = param.substring(0, param.indexOf("~"));
		param1 = param.substring(param.indexOf("~")+1, param.indexOf("~~"));
		param2 = param.substring(param.indexOf("~~")+2, param.length());
		
	}

            _bw.write(_wl_block2Bytes, _wl_block2);

	if(Integer.parseInt(frameCount) == 1)
	{

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(param0));
            _bw.write(_wl_block8Bytes, _wl_block8);

				if(staffAssignmentId != null && !staffAssignmentId.equals("Y"))
				{

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(param));
            _bw.write(_wl_block10Bytes, _wl_block10);
					
				}
				else
				{ 

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(param));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(param));
            _bw.write(_wl_block13Bytes, _wl_block13);

				}

            _bw.write(_wl_block14Bytes, _wl_block14);

	}
	else if(Integer.parseInt(frameCount) == 2)
	{

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(param0));
            _bw.write(_wl_block8Bytes, _wl_block8);

				if(staffAssignmentId != null && !staffAssignmentId.equals("Y"))
				{

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(param0));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(param1));
            _bw.write(_wl_block18Bytes, _wl_block18);

				}
				else
				{

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(param0));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(param1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(param));
            _bw.write(_wl_block13Bytes, _wl_block13);

				}

            _bw.write(_wl_block14Bytes, _wl_block14);

	}
	else if(Integer.parseInt(frameCount) == 3)
	{

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(param0));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(param0));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(param1));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(param2));
            _bw.write(_wl_block25Bytes, _wl_block25);

	}
	else if(Integer.parseInt(frameCount) > 3)
	{
		String roomParam0 = "";
		String roomParam1 = "";
		String roomParam2 = "";
		param0 = "";
		param1 = "";
		param2 = "";
		int roomCntProc = 0;
		int rc1, rc2, rc3 = 0;
		int roomDispCalc = 0;
		roomDispCalc = (staffAssignmentId != null && !staffAssignmentId.equals("Y")) ? 3 : 2;
		String chkedValues = request.getParameter("chkedValues") == null ? "" : request.getParameter("chkedValues");
		String[] chkedValuesArr = chkedValues.split(",");
		
		rc1 = chkedValuesArr.length / roomDispCalc;
		if(staffAssignmentId != null && staffAssignmentId.equals("Y"))
			rc2 = (chkedValuesArr.length / roomDispCalc) + (chkedValuesArr.length % roomDispCalc);
		else
		{
			rc2 = rc1;
			rc3 = chkedValuesArr.length - rc1 - rc2;
		}
		for(roomCntProc = 0; roomCntProc < rc1; roomCntProc++)
			param0 += chkedValuesArr[roomCntProc] + ",";
		if(staffAssignmentId != null && staffAssignmentId.equals("Y"))
		{
			for(int a=0; a<rc2; roomCntProc++,a++)
				param1 += chkedValuesArr[roomCntProc] + ",";
		}
		else
		{
			for(int a=0; a<rc2; roomCntProc++,a++)
				param1 += chkedValuesArr[roomCntProc] + ",";
			for(int a=0; a<rc3; roomCntProc++,a++)
				param2 += chkedValuesArr[roomCntProc] + ",";
		}
		if(param0 != null && param0.trim().length() > 0)
			param0 = param0.substring(0, param0.length()-1);
		if(param1 != null && param1.trim().length() > 0)
			param1 = param1.substring(0, param1.length()-1);
		if(param2 != null && param2.trim().length() > 0)
			param2 = param2.substring(0, param2.length()-1);
		roomParam0 = param + "&roomDispVals="+param0 + "&roomDispCalc="+roomDispCalc + "&frameName=room1";
		roomParam1 = param + "&roomDispVals="+param1 + "&roomDispCalc="+roomDispCalc + "&frameName=room2";
		roomParam2 = param + "&roomDispVals="+param2 + "&roomDispCalc="+roomDispCalc + "&frameName=room3";

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(param0));
            _bw.write(_wl_block8Bytes, _wl_block8);

				if(staffAssignmentId != null && !staffAssignmentId.equals("Y"))
				{

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(roomParam0));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(roomParam1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(roomParam2));
            _bw.write(_wl_block29Bytes, _wl_block29);

				}
				else
				{

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(roomParam0));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(roomParam1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(param));
            _bw.write(_wl_block13Bytes, _wl_block13);

				}

            _bw.write(_wl_block14Bytes, _wl_block14);

	}
	else
	{

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(param0));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(param));
            _bw.write(_wl_block32Bytes, _wl_block32);

	}

            _bw.write(_wl_block33Bytes, _wl_block33);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
