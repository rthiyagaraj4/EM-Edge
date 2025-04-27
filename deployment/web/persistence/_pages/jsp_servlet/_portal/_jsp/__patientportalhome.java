package jsp_servlet._portal._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import portalrefimpl.result.viewtestresult.svc.TestDetailsServiceInvoker;
import portalrefimpl.schedule.viewappointment.svc.AppointmentDetailsHelper;
import portalrefimpl.result.viewtestresult.response.TestDetails;
import portalrefimpl.common.serviceinvoker.ServiceInvoker;
import portalrefimpl.result.viewtestresult.response.TestDetailsResponse;
import portalrefimpl.result.viewtestresult.svc.TestDetailsSvcImpl;
import portalrefimpl.result.viewtestresult.request.TestDetailsRequest;
import portalrefimpl.schedule.viewappointment.response.AppointmentDetails;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.schedule.viewappointment.response.AppointmentDetailsResponse;
import portalrefimpl.schedule.viewappointment.svc.AppointmentSvcImpl;
import portalrefimpl.schedule.viewappointment.request.AppointmentDetailsRequest;
import portalrefimpl.homepage.HomePageInfoResponse;
import portalrefimpl.homepage.HomePageInfoHandler;
import portalrefimpl.homepage.HomePageInfoRequest;
import java.util.Date;
import java.util.List;

public final class __patientportalhome extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/portal/jsp/PatientPortalHome.jsp", 1669269355891L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>Patient Portal</title>\r\n\r\n<style>\r\n.divheader {\r\n\theight: 74px;\r\n\twidth: 100%;\r\n\tbackground: #ffffff;\r\n}\r\n\r\n.header {\r\n\theight: 74px;\r\n\twidth: 188px;\r\n\tbottom-border: #004657 3px solid;\r\n\tbackground: #0a87b0; /* Old browsers */\r\n\t/* IE9 SVG, needs conditional override of \'filter\' to \'none\' */\r\n\tbackground:\r\n\t\turl(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMCUiIHgyPSIxMDAlIiB5Mj0iMCUiPgogICAgPHN0b3Agb2Zmc2V0PSIwJSIgc3RvcC1jb2xvcj0iIzBhODdiMCIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjEwMCUiIHN0b3AtY29sb3I9IiMwODYzN2MiIHN0b3Atb3BhY2l0eT0iMSIvPgogIDwvbGluZWFyR3JhZGllbnQ+CiAgPHJlY3QgeD0iMCIgeT0iMCIgd2lkdGg9IjEiIGhlaWdodD0iMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);\r\n\tbackground: -moz-linear-gradient(left, #0a87b0 0%, #08637c 100%);\r\n\t/* FF3.6+ */\r\n\tbackground: -webkit-gradient(linear, left top, right top, color-stop(0%, #0a87b0),\r\n\t\tcolor-stop(100%, #08637c) ); /* Chrome,Safari4+ */\r\n\tbackground: -webkit-linear-gradient(left, #0a87b0 0%, #08637c 100%);\r\n\t/* Chrome10+,Safari5.1+ */\r\n\tbackground: -o-linear-gradient(left, #0a87b0 0%, #08637c 100%);\r\n\t/* Opera 11.10+ */\r\n\tbackground: -ms-linear-gradient(left, #0a87b0 0%, #08637c 100%);\r\n\t/* IE10+ */\r\n\tbackground: linear-gradient(to right, #0a87b0 0%, #08637c 100%);\r\n\t/* W3C */\r\n\tfilter: progid:DXImageTransform.Microsoft.gradient(           startColorstr=\'#0a87b0\',\r\n\t\tendColorstr=\'#08637c\', GradientType=1 ); /* IE6-8 */\r\n}\r\n\r\n.centerheader {\r\n\theight: 74px;\r\n\twidth: 990px;\r\n\tbottom-border: #175766 3px solid;\r\n\tbackground: #0a87b0; /* Old browsers */\r\n\t/* IE9 SVG, needs conditional override of \'filter\' to \'none\' */\r\n\tbackground:\r\n\t\turl(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMCUiIHgyPSIxMDAlIiB5Mj0iMCUiPgogICAgPHN0b3Agb2Zmc2V0PSIwJSIgc3RvcC1jb2xvcj0iIzBhODdiMCIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjEwMCUiIHN0b3AtY29sb3I9IiMwODYzN2MiIHN0b3Atb3BhY2l0eT0iMSIvPgogIDwvbGluZWFyR3JhZGllbnQ+CiAgPHJlY3QgeD0iMCIgeT0iMCIgd2lkdGg9IjEiIGhlaWdodD0iMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);\r\n\tbackground: -moz-linear-gradient(left, #0a87b0 0%, #08637c 100%);\r\n\t/* FF3.6+ */\r\n\tbackground: -webkit-gradient(linear, left top, right top, color-stop(0%, #0a87b0),\r\n\t\tcolor-stop(100%, #08637c) ); /* Chrome,Safari4+ */\r\n\tbackground: -webkit-linear-gradient(left, #0a87b0 0%, #08637c 100%);\r\n\t/* Chrome10+,Safari5.1+ */\r\n\tbackground: -o-linear-gradient(left, #0a87b0 0%, #08637c 100%);\r\n\t/* Opera 11.10+ */\r\n\tbackground: -ms-linear-gradient(left, #0a87b0 0%, #08637c 100%);\r\n\t/* IE10+ */\r\n\tbackground: linear-gradient(to right, #0a87b0 0%, #08637c 100%);\r\n\t/* W3C */\r\n\tfilter: progid:DXImageTransform.Microsoft.gradient(        startColorstr=\'#0a87b0\',\r\n\t\tendColorstr=\'#08637c\', GradientType=1 ); /* IE6-8 */\r\n}\r\n\r\n.imgIcon {\r\n\theight: 65px;\r\n\twidth: 65px;\r\n}\r\n\r\n.homeIcon {\r\n\theight: 24px;\r\n\twidth: 24px;\r\n}\r\n\r\n.contentarea {\r\n\twidth: 100%;\r\n\theight: 509px;\r\n\t/* background: #f1f1f1; */\r\n}\r\n\r\n.footerleft {\r\n\twidth: 188px;\r\n\theight: 65px;\r\n\tbackground-color: #606060;\r\n}\r\n\r\n.contentleft {\r\n\twidth: 188px;\r\n\theight: 509px;\r\n\tbackground-color: #f1f1f1;\r\n}\r\n\r\n.footer {\r\n\twidth: 990px;\r\n\theight: 65px;\r\n\tbackground-color: #6e6e6e;\r\n}\r\n\r\n.dvfooter {\r\n\twidth: 100%;\r\n\theight: 65px;\r\n}\r\n\r\n.contentcenter {\r\n\twidth: 990px;\r\n\theight: 509px;\r\n\tbackground-color: #ffffff;\r\n}\r\n\r\n.contentareabox {\r\n\twidth: 982px;\r\n\t/* height:609px; */\r\n\tborder: #a4a4a4 1px solid;\r\n\tborder-top-left-radius: 10px;\r\n\tborder-top-right-radius: 10px;\r\n\tborder-bottom-left-radius: 10px;\r\n\tborder-bottom-right-radius: 10px;\r\n\tbackground-color: #ffffff;\r\n\tpadding-left: 4px;\r\n}\r\n\r\n.menuheader {\r\n\tborder-top-left-radius: 10px;\r\n\tborder-top-right-radius: 10px;\r\n\theight: 45px;\r\n\tborder: #6e6e6e 1px solid;\r\n\tbackground-color: #f1f1f1;\r\n}\r\n\r\n.menucontent {\r\n\theight: 424px;\r\n}\r\n\r\n.menuitemstyle {\r\n\tpadding: 5px;\r\n\tfont-family: Arial;\r\n\tfont-size: 14px;\r\n\tcolor: #000000;\r\n}\r\n\r\n.divmaincontent {\r\n\theight: 125px;\r\n\tpadding-left: 10px;\r\n\tpadding-right: 10px;\r\n}\r\n\r\n.div {\r\n\theight: 429px;\r\n\twidth: 982px;\r\n}\r\n\r\n.div1 {\r\n\twidth: 982px;\r\n}\r\n\r\n.nextappointmentsdiv {\r\n\tposition: relative; \r\n\tfloat: left;\r\n\twidth: 330px;\r\n\t\r\n}\r\n\r\n.resultsdiv {\r\n\tfloat: right;\r\n\twidth: 330px;\r\n\t\r\n}\r\n.appointheader{\r\nheight:30px;\r\nbackground-color: #1d758b;\r\nbox-shadow: 3px 3px 3px #b8b8b8; \r\nborder: #bacfd5 1px  solid;\r\nborder-top-left-radius: 5px;\r\nborder-top-right-radius: 5px;\r\n\r\n}\r\n.appointheaderstyle\r\n{\r\nfont: Arial;\r\nfont-size: 12px;\r\nfont-weight: bold;\r\ncolor: #ffffff;\r\n\r\n}\r\n.content\r\n{\r\nheight:210px;\r\nwidth:60%;\r\nbackground-color: #ffffff;\r\n\r\n\r\n\r\n}\r\n.contentstyle{\r\nwidth:100%;\r\nheight:70px;\r\n\r\n\r\n}\r\n.maincontent{\r\n\r\nwidth:100%;\r\n\r\n\r\n}\r\n.contentbottom\r\n{\r\nheight:65px;\r\nwidth:60%;\r\nborder:#bacfd5 1px solid;\r\n\r\n}\r\n.contentstyle\r\n{\r\nborder:#bacfd5 1px solid;\r\n}\r\n.newappoint{\r\n\r\nborder-radius:3px;\r\nbackground :-webkit-gradient(linear, left top, left bottom, from( #37b8d0  ), to( #3fa4b6 )); /* Saf4+, Chrome */\r\n    background :-webkit-linear-gradient( #37b8d0 , #3fa4b6 ); /* Chrome 10+, Saf5.1+ */\r\n   background :-moz-linear-gradient( #37b8d0 , #3fa4b6 ); /* FF3.6 */\r\nborder : 1px solid #006c7f;\r\npadding:2px;\r\n\r\n\r\n}\r\n.newappointstyle{\r\nfont :Arial;\r\nfont-size: 11px;\r\nfont-weight: bold;\r\ncolor: #ffffff;\r\n}\r\n\r\n.buttonStyle{\r\nfont-family: Arial;\r\nfont-size : 11px;\r\nfont-style : bold;\r\ncolor : #ffffff;\r\nbackground-color: #37b8d0;\r\nborder : 1px solid #006c7f;\r\npadding: 2px;\r\nborder-radius:3px;\r\n\r\n}\r\n\r\n.apptPractNameStyle{\r\nfont: Arial;\r\nfont-size: 14px;\r\ncolor: #0a84a2;\r\nmargin-left:5px;\r\n}\r\n\r\n.apptSpecialityStyle{\r\nfont: Arial;\r\nfont-size: 12px;\r\ncolor: #0a84a2 ;\r\n}\r\n\r\n.apptTimeStyle{\r\nfont: Arial;\r\nfont-size: 12px;\r\ncolor: #5e5e5e;\r\nmargin-left:5px;\r\n}\r\n\r\n.apptDateStyle{\r\nfont: Arial;\r\nfont-size: 24px;\r\ncolor: #e67418;\r\nfont-weight: bold;\r\n}\r\n\r\n.apptWeekDayStyle{\r\nfont: Arial;\r\nfont-size: 12px;\r\ncolor: #e67418;\r\n}\r\n\r\n.apptMonthYearStyle{\r\nfont: Arial;\r\nfont-size: 12px;\r\ncolor: #e67418;\r\n}\r\n\r\n\r\n.apptPractNameNormalStyle{\r\nfont: Arial;\r\nfont-size: 14px;\r\ncolor: #5e5e5e;\r\nmargin-left:5px;\r\n}\r\n\r\n.apptSpecialityNormalStyle{\r\nfont: Arial;\r\nfont-size: 12px;\r\ncolor: #5e5e5e ;\r\n}\r\n\r\n.apptTimeNormalStyle{\r\nfont: Arial;\r\nfont-size: 12px;\r\ncolor: #5e5e5e ;\r\nmargin-left:5px;\r\n}\r\n\r\n.apptDateNormalStyle{\r\nfont: Arial;\r\nfont-size: 24px;\r\ncolor: #5e5e5e;\r\nfont-weight: bold;\r\n}\r\n\r\n.apptWeekDayNormalStyle{\r\nfont: Arial;\r\nfont-size: 12px;\r\ncolor: #5e5e5e;\r\n}\r\n\r\n.apptMonthYearNormalStyle{\r\nfont: Arial;\r\nfont-size: 12px;\r\ncolor: #5e5e5e;\r\n}\r\n\r\n\r\n.resultCategoryStyle{\r\nfont: Arial;\r\nfont-size: 12px;\r\ncolor: #e67418;\r\nfont-style: bold;\r\n}\r\n\r\n.resultDateStyle{\r\nfont: Arial;\r\nfont-size: 12px;\r\ncolor: #e67418;\r\n}\r\n\r\n.resultCategoryNormalStyle{\r\nfont: Arial;\r\nfont-size: 12px;\r\ncolor: #0a84a2;\r\nfont-style: bold;\r\n}\r\n\r\n.resultDateNormalStyle{\r\nfont: Arial;\r\nfont-size: 12px;\r\ncolor: #5e5e5e;\r\n}\r\n\r\n</style>\r\n\r\n</head>\r\n<body>\r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n\t<div class=\"divheader\">\r\n\t\t<table border=\"0\" style=\"width: 100%; height: auto\" cellpadding=\"0\"\r\n\t\t\tcellspacing=\"0\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<div class=\"header\"></div>\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<div class=\"centerheader\">\r\n\t\t\t\t\t\t<table border=\"0\" style=\"width: 100%; height: auto\"\r\n\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t<td style=\"width: 4px;\">&nbsp;</td>\r\n\t\t\t\t\t\t\t\t<td style=\"width: 65px;\">\r\n\t\t\t\t\t\t\t\t\t<table border=\"0\" style=\"width: 100%; height: auto\"\r\n\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t<tr style=\"width: 65px; height: 65px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t<td><img\r\n\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"../images/Logo.png\"\r\n\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"margin-top: 4px; margin-left: 4px; margin-right: 10px;\"\r\n\t\t\t\t\t\t\t\t\t\t\t\tclass=\"imgIcon\"></img></td>\r\n\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td style=\"width: 917px; height: 74px;\">\r\n\t\t\t\t\t\t\t\t\t<table border=\"0\" style=\"width: 100%; height: auto\"\r\n\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\">\r\n\r\n\t\t\t\t\t\t\t\t\t\t<tr style=\"height: 40%;\">\r\n\t\t\t\t\t\t\t\t\t\t\t<td><span\r\n\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"font-family: Arial; font-size: 12px; color: #ffffff; font-weight: bold;\">PATIENT\r\n\t\t\t\t\t\t\t\t\t\t\t\t\tID : ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="</span></td>\r\n\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t<tr style=\"height: 40%;\">\r\n\t\t\t\t\t\t\t\t\t\t\t<td><span\r\n\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"font-family: Arial; font-size: 12px; color: #ffffff; font-weight: bold;\">NRIC\r\n\t\t\t\t\t\t\t\t\t\t\t\t\tID : ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</span></td>\r\n\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t<tr style=\"height: 20%;\">\r\n\t\t\t\t\t\t\t\t\t\t\t<td><span\r\n\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"font-family: Arial; font-size: 11px; color: #ffffff; font-style: italic;\">";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =", ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</span></td>\r\n\t\t\t\t\t\t\t\t\t\t</tr>\r\n\r\n\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td style=\"width: 4px;\">&nbsp;</td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t</table>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<div class=\"header\"></div>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t</div>\r\n\r\n\t<div class=\"contentarea\">\r\n\t\t<table border=\"0\" style=\"width: 100%; height: 100%\" cellpadding=\"0\"\r\n\t\t\tcellspacing=\"0\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<div class=\"contentleft\"></div>\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<div class=\"contentcenter\">\r\n\t\t\t\t\t\t<table border=\"0\" style=\"width: 990px; height: 509px\"\r\n\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t<tr style=\"width: 990px; height: 10px;\">\r\n\t\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t<tr style=\"width: 990px; height: 479px;\">\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t<table border=\"0\" style=\"width: 990px; height: 479px;\"\r\n\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"contentareabox\" align=\"center\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"menuheader\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" style=\"width: 982px; height: 45px;\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" style=\"width: 100px; height: 45px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" style=\"width: 100px; height: 45px;\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" style=\"width: 34px; height: 45px;\"><img\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"../images/Home.png\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"margin-top: 5px; margin-bottom: 5px; margin-right: 5px; margin-left: 5px;\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"homeIcon\"></img></td>\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" style=\"width: 66px; height: 45px;\"><span\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"menuitemstyle\">Home</span></td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: 1px; height: 45px; background-color: #c8c8c8\">&nbsp;</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" style=\"width: 150px; height: 45px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" style=\"width: 150px; height: 45px;\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" style=\"width: 34px; height: 45px;\"><img\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"../images/Appointments.png\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"margin-top: 5px; margin-bottom: 5px; margin-right: 5px; margin-left: 5px;\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"homeIcon\"></img></td>\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" style=\"width: 116px; height: 45px;\"><span\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"menuitemstyle\">Appointments</span></td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: 1px; height: 45px; background-color: #c8c8c8\">&nbsp;</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" style=\"width: 120px; height: 45px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" style=\"width: 120px; height: 45px;\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" style=\"width: 34px; height: 45px;\"><img\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"../images/Results.png\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"margin-top: 5px; margin-bottom: 5px; margin-right: 5px; margin-left: 5px;\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"homeIcon\"></img></td>\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" style=\"width: 86px; height: 45px;\"><span\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"menuitemstyle\">Results</span></td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: 1px; height: 45px; background-color: #c8c8c8\">&nbsp;</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" style=\"width: 120px; height: 45px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" style=\"width: 120px; height: 45px;\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" style=\"width: 34px; height: 45px;\"><img\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"../images/Settings.png\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"margin-top: 5px; margin-bottom: 5px; margin-right: 5px; margin-left: 5px;\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"homeIcon\"></img></td>\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" style=\"width: 86px; height: 45px;\"><span\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"menuitemstyle\">Settings</span></td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: 1px; height: 45px; background-color: #c8c8c8\">&nbsp;</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" style=\"width: 427px; height: 45px;\">&nbsp;</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: 1px; height: 45px; background-color: #c8c8c8\">&nbsp;</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" style=\"width: 120px; height: 45px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" style=\"width: 120px; height: 45px;\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" style=\"width: 34px; height: 45px;\"><img\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"D:/WebApplicationWorkspace/sample/WebContent/images/Exit.png\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"margin-top: 5px; margin-bottom: 5px; margin-right: 5px; margin-left: 5px;\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"homeIcon\"></img></td>\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" style=\"width: 86px; height: 45px;\"><span\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"menuitemstyle\">Exit</span></td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"menucontent\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"divmaincontent\">\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" style=\"width: 100%; height: 100%;\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"width: 100%; height: 49%;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" style=\"width: 100%; height: 100%;\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"width: 100%; height: 50%;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"font-family: Arial; font-size: 11px; color: #1d738b; font-weight: bold; font-style: italic;\">Hi\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" !\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"width: 100%; height: 50%;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"font-family: Arial; font-size: 11px; color: #5d5b5b;\">Welcome\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tto iCare Hospital Patient Portal,Your Patient ID\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" and NRIC ID ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =",\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"width: 100%; height: 2%;\">................................................................................................................................................................................................................................................\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"width: 100%; height: 49%;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" style=\"width: 100%; height: 100%;\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"width: 100%; height: 50%;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"font-family: Arial; font-size: 14px; color: #000000; font-weight: bold;\">Some\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tof the many things you can do in the patient portal\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tare..\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"width: 100%; height: 50%;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\"><span\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"font-family: Arial; font-size: 11px; color: #5d5b5b;\">Manage\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tyour appointments,view your lab and view your\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tradiology results</span></td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"verticalspacediv\" style=\"padding-bottom: 10px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"leftdiv\" class=\"div\" style=\"width:46%;padding-top: 10px;padding-left: 10px;padding-right:5px;padding-bottom:10px;float: left;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table style=\"width: 100%; height: 57%;border: 1px solid #bacfd5;border-top-left-radius: 5px;border-top-right-radius: 5px;border-bottom-left-radius:5px;border-bottom-right-radius:5px;\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\" align=\"left\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr height=\"15%\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  valign=\"top\" align=\"left\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class = \"appointheader\" valign=\"top\" border=\"1\" style=\"width: 100%; height: 100%;\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\" >\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  align=\"left\" style=\"padding-left: 10px;\"> \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"appointheaderstyle\" valign = \"middle\">Your Next Appointments</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\r\n\t\t\t\t\t\t\t\t\t\t<tr valign=\"top\" align=\"center\">\r\n\t\t\t\t\t\t\t\t\t\t\t<td valign=\"top\" align=\"center\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font: Arial;font-size: 12px;\">Could not obtain appointment details</span> \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</table>\t\r\n\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t</tr>\r\n\r\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\r\n\r\n\t\t\t\t\t\t\t\t\t\t\t\t<tr valign=\"top\" align=\"center\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td valign=\"top\" align=\"center\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font: Arial;font-size: 12px;\">Error while obtaining appointment details, Error Message = ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</span> \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\r\n\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t<tr valign=\"top\" align=\"center\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td valign=\"top\" align=\"center\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<table  width=\"100%\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font: Arial;font-size: 12px;\">Could not obtain appointment details</span> \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<table cellpadding=0 cellspacing=0  width=\"100%\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  style =\"width:25%;padding-left : 5px;\" align=\"left\"> \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" style=\"width: 100%;\" cellpadding=\"0\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"height: 40%;\" align = \"center\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"height: 25%;\" align = \"center\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"height: 35%;\" align = \"center\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t </table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  style =\"width:80%;padding-left : 5px;\" align=\"left\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td height=\"50%\"> \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" -</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td height=\"50%\"> <span class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" - ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr height=\"20%\" valign=\"center\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"padding-right: 10px;\" align=\"right\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" class=\"buttonStyle\" value=\"New appointment\"/>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" class=\"buttonStyle\" value=\"View more appointments\"/>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"rightdiv\" class=\"div\" style=\"width:50%;padding-top: 10px;padding-left: 5px;padding-right:10px;padding-bottom:10px;float: right;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table style=\"width: 100%; height: 57%;border: 1px solid #bacfd5;border-top-left-radius: 5px;border-top-right-radius: 5px;border-bottom-left-radius:5px;border-bottom-right-radius:5px;\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\" align=\"left\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr height=\"15%\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  valign=\"top\" align=\"left\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class = \"appointheader\" valign=\"top\" border=\"1\" style=\"width: 100%; height: 100%;\"\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\" >\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  align=\"left\" style=\"padding-left: 10px;\"> \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"appointheaderstyle\" valign = \"middle\">Your Test Results</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t<tr  valign=\"top\" align=\"center\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td  valign=\"top\" align=\"center\"> \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font: Arial;font-size: 12px;\">Could not obtain test results</span> \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t<tr  valign=\"top\" align=\"center\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td  valign=\"top\" align=\"center\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table  width=\"100%\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font: Arial;font-size: 12px;\">Error while obtaining test details, Error Message = ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</span> \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\t<tr  valign=\"top\" align=\"center\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td  valign=\"top\" align=\"center\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table  width=\"100%\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font: Arial;font-size: 12px;\">Could not obtain test details</span> \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\r\n\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<table  width=\"100%\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"40%\" align=\"left\" style=\"padding-left:15px;\" >\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table> \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  width=\"60%\" align=\"right\" style=\"padding-right: 20px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td> <input type=\"button\" class=\"buttonStyle\" value=\"View Result\"/>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\r\n\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr height=\"20%\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td valign=\"center\" align=\"right\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\" style=\"padding-right: 10px;\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" class=\"buttonStyle\" value=\"View more results\"/>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t</td>\t\r\n\t\t\t\t\t\t\t\t\t\t</tr>\t\r\n\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t</table>\r\n\t\t\t\t\t</div>\t\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<div class=\"contentleft\"></div>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\t\r\n\t</div>\t\t\r\n\t\r\n\r\n\r\n\r\n\r\n<div class=\"dvfooter\">\r\n\t\t<table border=\"0\" style=\"width: 100%; height: auto\" cellpadding=\"0\"\r\n\t\t\tcellspacing=\"0\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<div class=\"footerleft\"></div>\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<div class=\"footer\">\r\n\t\t\t\t\t\t<table border=\"0\" style=\"width: 100%; height: auto\"\r\n\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\">\r\n\t\t\t\t\t\t\t<tr style=\"height: 27px;\">\r\n\t\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t<tr>\r\n\r\n\t\t\t\t\t\t\t\t<td align=\"center\" style=\"height: 10px;\"><span\r\n\t\t\t\t\t\t\t\t\tstyle=\"font-family: Arial; font-size: 10px; color: #bcbcbc;\">Copyright\r\n\t\t\t\t\t\t\t\t\t\t2012 Computer Sciences Corporation - All rights reserved. </span></td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t<tr style=\"height: 28px;\">\r\n\t\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t</table>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<div class=\"footerleft\"></div>\r\n\t\t\t\t</td>\r\n\t\t</table>\r\n\t</div>\r\n\r\n\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);


	String useWebService = request.getParameter("useWebService");
	if (useWebService == null || useWebService.trim().equals("")) {
		useWebService = (String)getServletConfig().getServletContext().getAttribute("useWebService");
		if (useWebService == null || useWebService.trim().equals("")){
			useWebService = "N";	
		}
	}

	String patientId = request.getParameter("patientId");
	if (patientId == null) {
		patientId = (String)getServletConfig().getServletContext().getAttribute("patientId");
		if(patientId == null){
			patientId = "";	
		}
	}
	
	final int NUMROWS = 3;
	
	HomePageInfoRequest homePageInfoRequest = new HomePageInfoRequest();
	homePageInfoRequest.setPatientId(patientId);
	
	HomePageInfoHandler handler = new HomePageInfoHandler();
	HomePageInfoResponse homePageInfoResponse = handler.getHomePageInfo(homePageInfoRequest);
	
	// TODO
	// need to have logic to check for ErrorInfo and then set error message accordingly
	 
	String completePatientName = homePageInfoResponse.getCompletePatientName();
	String patientName = homePageInfoResponse.getPatientName();
	String sex = homePageInfoResponse.getSex();
	String age = homePageInfoResponse.getPatientAge();
	String nricId = homePageInfoResponse.getNricId();
	if(nricId == null){
		nricId = "";
	}
	

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(patientId ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(nricId ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(patientName ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sex ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(age ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(completePatientName ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(patientId ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(nricId ));
            _bw.write(_wl_block9Bytes, _wl_block9);

	AppointmentDetailsRequest appointmentDetailsRequest = new AppointmentDetailsRequest();
	appointmentDetailsRequest.setPatientId(patientId);

	AppointmentSvcImpl appointSvc = new AppointmentSvcImpl();
	appointSvc.registerService(appointmentDetailsRequest);

	AppointmentDetailsResponse appointmentDetailsResponse = null;

	if ("N".equalsIgnoreCase(useWebService)) {
		appointmentDetailsResponse = appointSvc
				.getAppointmentDetails(appointmentDetailsRequest);
	} else if ("Y".equalsIgnoreCase(useWebService)) {
		// need to call the service as a web service
		appointmentDetailsResponse = AppointmentDetailsHelper
				.getAppointmentDetail(appointmentDetailsRequest);
	}
	if (appointmentDetailsResponse == null) {

            _bw.write(_wl_block10Bytes, _wl_block10);

	}
	else{
		ErrorInfo errorInfo = appointmentDetailsResponse.getErrorInfo();
		int errorCode = errorInfo.getErrorCode();
		String errorMessage = errorInfo.getErrorMessage();
		if (ErrorInfo.SUCCESS_CODE != errorCode
				&& (errorMessage != null && errorMessage.trim().equals(""))) {

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(errorMessage));
            _bw.write(_wl_block12Bytes, _wl_block12);

										
										}else{
											
										
										List<AppointmentDetails> appointmentDetailsList = appointmentDetailsResponse
												.getAppointmentDetailsList();
										if (appointmentDetailsList == null
												|| appointmentDetailsList.isEmpty()) {
									
            _bw.write(_wl_block13Bytes, _wl_block13);

	
												}else{
											
										String appointmentDate = "";
										String practitioner = "";
										String speciality = "";
										String startTime = "";
										String endTime = "";
										int counter = 0;
										
										String dateStyle = "";
										String weekDayStyle = "";
										String monthYearStyle = "";
										String practNameStyle = "";
										String specialityStyle = "";
										String timeStyle = "";
										
										for (AppointmentDetails appointmentDetails : appointmentDetailsList) {
											if(counter >= NUMROWS){
												break;
											}
											counter++;
											
											dateStyle = "apptDateNormalStyle";
											weekDayStyle = "apptWeekDayNormalStyle";
											monthYearStyle = "apptMonthYearNormalStyle";
											practNameStyle = "apptPractNameNormalStyle";
											specialityStyle = "apptSpecialityNormalStyle";
											timeStyle = "apptTimeNormalStyle";
											
											if(counter == 1){
												dateStyle = "apptDateStyle";
												weekDayStyle = "apptWeekDayStyle";
												monthYearStyle = "apptMonthYearStyle";
												practNameStyle = "apptPractNameStyle";
												specialityStyle = "apptSpecialityStyle";
												timeStyle = "apptTimeStyle";
											}
											
											appointmentDate = appointmentDetails
													.getAppointmentDateAsString();
											practitioner = appointmentDetails.getPractitioner();
											speciality = appointmentDetails.getApptSpeciality();
											startTime = appointmentDetails.getApptStartTimeAsString();
											endTime = appointmentDetails.getApptEndTimeAsString();
											
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(dateStyle ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(appointmentDetails.getAppointmentDateAsInt() ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(weekDayStyle ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(appointmentDetails.getAppointmentDay() ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(monthYearStyle ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(appointmentDetails.getAppointmentMonthAndYear() ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(practNameStyle ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(practitioner));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(specialityStyle ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(timeStyle ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(startTime));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(endTime));
            _bw.write(_wl_block22Bytes, _wl_block22);

															}
														}
													}
	}
												
            _bw.write(_wl_block23Bytes, _wl_block23);

												TestDetailsRequest testDetailsRequest = new TestDetailsRequest();
												testDetailsRequest.setPatientId(patientId);
											
												TestDetailsSvcImpl testDetailSvc = new TestDetailsSvcImpl();
												testDetailSvc.registerService(testDetailsRequest);
											
												TestDetailsResponse testDetailsResponse = null;
											
												if ("N".equalsIgnoreCase(useWebService)) {
													testDetailsResponse = testDetailSvc
															.getTestDetails(testDetailsRequest);
												} else if ("Y".equalsIgnoreCase(useWebService)) {
													ServiceInvoker testDetailsServiceInvoker = new TestDetailsServiceInvoker();
													// need to call the service as a web service
													testDetailsResponse = (TestDetailsResponse)testDetailsServiceInvoker
															.getDataThroughWebService(testDetailsRequest);
												}
												
												if (testDetailsResponse == null) {
												
            _bw.write(_wl_block24Bytes, _wl_block24);

		
											} else{
											
											ErrorInfo errorInfo = testDetailsResponse.getErrorInfo();
											int errorCode = errorInfo.getErrorCode();
											String errorMessage = errorInfo.getErrorMessage();
											if (ErrorInfo.SUCCESS_CODE != errorCode
													&& (errorMessage != null && errorMessage.trim().equals(""))) {
											
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(errorMessage));
            _bw.write(_wl_block26Bytes, _wl_block26);

													
												}else{
													List<TestDetails> testDetailsList = testDetailsResponse
															.getTestDetailsList();
													if (testDetailsList == null
															|| testDetailsList.isEmpty()) {
												
            _bw.write(_wl_block27Bytes, _wl_block27);

												
												} else{
											
            _bw.write(_wl_block28Bytes, _wl_block28);

												//local vars used for processing
												String orderNo = null;
												String location = null;
												String practId = null;
												String practName = null;
												String status = null;
												String order = null;
												Date orderDate = null;
												String resultType = null;
												
												String orderDateStr = null;
												String orderCategoryStyle = "";
												String orderDateStyle = "";
												
												int counter = 0;
												for (TestDetails testDetail : testDetailsList) {
													if(counter >= NUMROWS){
														break;
													}
													counter++;
													
													orderCategoryStyle = "resultCategoryNormalStyle";
													orderDateStyle = "resultDateNormalStyle";
													if(counter == 1){
														orderCategoryStyle = "resultCategoryStyle";
														orderDateStyle = "resultDateStyle";
													}
													
													orderNo = testDetail.getOrderNo();
													location = testDetail.getLocation();
													resultType = testDetail.getResultType();
													order = testDetail.getOrder();
													orderDate = testDetail.getOrderDate();
													practName = testDetail.getPractName();
													practId = testDetail.getPractId();
													status = testDetail.getStatus();
													
													orderDateStr = testDetail.getOrderDateString();
											
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(orderCategoryStyle ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(order ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(orderDateStyle ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(orderDateStr ));
            _bw.write(_wl_block31Bytes, _wl_block31);

														}
													}
												}
											}
											
											
            _bw.write(_wl_block32Bytes, _wl_block32);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
