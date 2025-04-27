package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import eIPAD.*;
import eIPAD.HealthObjects.*;
import eCA.ChartRecording.*;
import javax.rmi.*;
import webbeans.eCommon.MessageManager;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public final class __notetype extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/NoteType.jsp", 1709116953332L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n      \t\t\t\t   <option value = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\">";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</option>\n      \t\t\t\t  ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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

request.setCharacterEncoding("UTF-8");

String locale = "en";
String facility_id= "";
String clinicianId = "" ;
String strPracType = "";
String strPostBack = "false";
String strInterval = "";
String strPatientId = "";
String strEncounterId = "";
String strChartType = "";
CreateNotesRequest oCreateNotesReq = new CreateNotesRequest();
oCreateNotesReq.setRequest(request);


String normalInd = "";
String strPatientClass = "";
String strFilterBy = "P";
String strNoteType = "";
if(request.getParameter("FilterBy") != null)
{
	strFilterBy = request.getParameter("FilterBy");
}


if(session.getValue("facility_id") != null )
{
	oCreateNotesReq.setFacilityId((String)session.getValue("facility_id"));
}
if(session.getValue("ca_practitioner_id") != null)
{
	oCreateNotesReq.setClinicianId((String)session.getValue("ca_practitioner_id"));
}
if(session.getValue("practitioner_type") != null )
{
	oCreateNotesReq.setPracType((String)session.getValue("practitioner_type"));
}
if(session.getValue("PatientID") != null)
{
	oCreateNotesReq.setPatientId((String)session.getValue("PatientID"));
}
if(session.getValue("EpisodeId") != null )
{
	oCreateNotesReq.setEncounterId((String)session.getValue("EpisodeId"));
}

if(session.getValue("responsibility_id") != null)
{
	oCreateNotesReq.setRespId((String)session.getValue("responsibility_id"));
}
oCreateNotesReq.setApplTaskID("CLINICAL_NOTES");
if(request.getParameter("patclass") != null )
{
	strPatientClass = request.getParameter("patclass");
	
}
if(request.getParameter("hdnPostBack") != null)
{
	strPostBack = request.getParameter("hdnPostBack");
}
/*
if(strPostBack != null && strPostBack.equals("true"))
{
	strPatientClass = request.getParameter("hdnPatientClass");
	strFilterBy = request.getParameter("hdnFilterBy");
	strNoteType = request.getParameter("hdnNoteType");
}
*/
oCreateNotesReq.setFilterBy(strFilterBy);
oCreateNotesReq.setPatientClass(strPatientClass);
oCreateNotesReq.setNoteType(strNoteType);
NoteTypeResponse oNoteTypeResponse = null;
List<NoteTypeHO> oNoteTypeList = null;
NoteTypeHO oNoteTypeHO = null;
NotesDetail bean = new NotesDetail();

int nLoopCount = 0;
int nListSize = 0;
try {
  	  oNoteTypeResponse = bean.getNoteType(oCreateNotesReq);
        if(oNoteTypeResponse != null && oNoteTypeResponse.getLstNoteType() != null)
        {
      	  oNoteTypeList = oNoteTypeResponse.getLstNoteType();
      	  if(oNoteTypeList != null)
      	  {
      		  nListSize = oNoteTypeList.size();
      	  }
      	  if(nListSize > 0)
      	  {
      		  for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
      		  {
      			  oNoteTypeHO = oNoteTypeList.get(nLoopCount);
      			  if(oNoteTypeHO != null)
      			  {
      				  
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(oNoteTypeHO.getNoteType()));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(oNoteTypeHO.getNoteTypeDesc()));
            _bw.write(_wl_block4Bytes, _wl_block4);
 
      			  }
      		  }
      	  }
        }
 }
catch ( Exception e ){
		out.println("Exception " + e);
		//out.println(sqlStr.toString());
		e.printStackTrace();
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
