<!DOCTYPE html>
<%@ page import= "java.util.*" %>
<%@ page import="java.sql.Connection,java.util.HashMap,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHQueryRender,eXH.XHDBAdapter" %>
<%@ page import="eXH.XHUtil"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle = "IeStyle.css";
%>
<%
	String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));	

	if(isDebugYN.equals("Y"))
		System.out.println(" - - -  Inside EM_Card_Data.jsp  - - - ");

	String summary = "";

	String getTitleUsr = "", fullName = "", sex = "",  EID = "", Dob = "", Nationality = "", HomeAddress = "",  City = "", Mb = "", Visa = "", VisaExp = "", Country = "";

	String idType = "", CSN = "", idNumber = "", cardNumber = "",  issueDate = "", expDate = "";

	summary = request.getParameter("summary") == null ? "" : request.getParameter("summary");

	String delims = "$!^";
	StringTokenizer st = new StringTokenizer(summary,delims );

	ArrayList<String> cardData = new ArrayList<String>();

	while (st.hasMoreElements()) {
		cardData.add(st.nextToken().toString());			
	}

	if (cardData.size()>0)
	{
		if(isDebugYN.equals("Y"))
			System.out.println(" - - -  Card Data size ::: "+cardData.size());
		
		idType = cardData.get(1);
		CSN = cardData.get(2);
		idNumber = cardData.get(3);
		cardNumber = cardData.get(4);
		issueDate = cardData.get(5);
		expDate = cardData.get(6);

		getTitleUsr = "";
		fullName = cardData.get(7);
		sex = cardData.get(8);
		EID = cardData.get(10);
		Dob = cardData.get(11);
		HomeAddress = cardData.get(13);
		City = cardData.get(14);
		Mb = cardData.get(15);
		Visa = cardData.get(16);
		VisaExp = cardData.get(17);
		Country = cardData.get(18);
	}

	
	

%>
<html>
<head>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
</head>
<body align="center" style="font-size: 10px; font-style: verdana;">

    <table border="0" align="center" width="85%">        
        <tr>
            <td>
                <table width="100%" border1="1" margin1="0" cellpadding1="0"
                    cellspacing1="0"
                    style="background-color: #cfd8fd; border: solid 1px gray"
                    align="center">
                    <tr>
                        <td>
                            <table>
                                <tr>
                                    <td align="center"><APPLET style="border: solid 1px gray"
                                            id="EIDAWebComponent" name="EIDAWebComponent"
                                            CODE="emiratesid.ae.webcomponents.EIDAApplet"
                                            ARCHIVE="EIDA_IDCard_Applet.jar" WIDTH="130" HEIGHT="154">
                                            This browser does not support Applets. </APPLET>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <table>
                                            <tr>
                                                <td><span>ID Type:&nbsp;</span>
                                                </td>
                                                <td>"<%=idType%>" </td>
                                            </tr>
                                            <tr>
                                                <td><span>CSN:&nbsp;</span>
                                                </td>
                                                <td>"<%=CSN%>"
                                                </span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td><span>ID Number:&nbsp;</span>
                                                </td>
                                                <td>"<%=idNumber%>"
                                                </td>
                                            </tr>
                                            <tr>
                                                <td><span>Card Number:&nbsp;</span>
                                                </td>
                                                <td>"<%=cardNumber%>"
                                                </td>
                                            </tr>
                                            <tr>
                                                <td><span>Issue Date:&nbsp;</span>
                                                </td>
                                                <td>"<%=issueDate%>"
                                                </td>
                                            </tr>
                                            <tr>
                                                <td><span>Expiry Date:&nbsp;</span>
                                                </td>
                                                <td>"<%=expDate%>"
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                        <td>
                            <table>
                                <tr>
                                    <td><span>sex:&nbsp;</span>
                                    </td>
                                     <td>"<%=sex%>"
                                    </td>
                                </tr>
                                <tr>
                                    <td><span>Date of Birth:&nbsp;</span>
                                    </td>
                                    <td>"<%=Dob%>"
                                    </td>
                                </tr>
                                <tr>
                                    <td><span>Full Name (Ar):&nbsp;</span>
                                    </td>
                                    <td>"<%=fullName%>"
                                    </td>
                                </tr>
                                <tr>
                                    <td><span>Full Name:&nbsp;</span>
                                    </td>
                                    <td>
                                    </td>
                                </tr>
                                <tr>
                                    <td><span>Marital Status:&nbsp;</span>
                                    </td>
                                    <td>
                                    </td>
                                </tr>
                                <tr>
                                    <td><span>Occupation:&nbsp;</span>
                                    </td>
                                    <td>
                                    </td>
                                </tr>
                                <tr>
                                    <td><span>Title (Ar):&nbsp;</span>
                                    </td>
                                    <td>"<%=getTitleUsr%>"
                                    </td>
                                </tr>
                                <tr>
                                    <td><span>Title:&nbsp;</span>
                                    </td>
                                    <td>"<%=getTitleUsr%>"
                                    </td>
                                </tr>
                                <tr>
                                    <td><span>Nationality (Ar):&nbsp;</span>
                                    </td>
                                    <td>"<%=Nationality%>"
                                    </td>
                                </tr>
                                <tr>
                                    <td><span>Nationality:&nbsp;</span>
                                    </td>
                                    <td>"<%=Nationality%>"
                                    </td>
                                </tr>

                            </table>
                        </td>
                        <td>
                            <table>
                                <tr>
                                    <td><span>Mother First Name (Ar):&nbsp;</span>
                                    </td>
                                    <td><span id="ArabicMotherFirstName_PDLabel"><b>--</b>
                                    </span>
                                    </td>
                                </tr>
                                <tr>
                                    <td><span>Mother First Name:&nbsp;</span>
                                    </td>
                                    <td><span id="MotherFirstName_PDLabel"><b>--</b> </span>
                                    </td>
                                </tr>
                                <tr>
                                    <td><span>Familly ID:&nbsp;</span>
                                    </td>
                                    <td><span id="FamilyID_PDLabel"><b>--</b> </span>
                                    </td>
                                </tr>
                                <tr>
                                    <td><span>Husband IDN:&nbsp;</span>
                                    </td>
                                    <td><span id="HusbandIDN_PDLabel"><b>--</b> </span>
                                    </td>
                                </tr>
                                <tr>
                                    <td><span>Sponsor Type:&nbsp;</span>
                                    </td>
                                    <td><span id="SponsorType_PDLabel"><b>--</b> </span>
                                    </td>
                                </tr>
                                <tr>
                                    <td><span>Sponsor Number:&nbsp;</span>
                                    </td>
                                    <td><span id="SponsorNumber_PDLabel"><b>--</b> </span>
                                    </td>
                                </tr>
                                <tr>
                                    <td><span>Sponsor Name:&nbsp;</span>
                                    </td>
                                    <td><span id="SponsorName_PDLabel"><b>--</b> </span>
                                    </td>
                                </tr>
                                <tr>
                                    <td><span>Residency Type:&nbsp;</span>
                                    </td>
                                    <td><span id="ResidencyType_PDLabel"><b>--</b> </span>
                                    </td>
                                </tr>
                                <tr>
                                    <td><span>Residency Number:&nbsp;</span>
                                    </td>
                                    <td><span id="ResidencyNumber_PDLabel"><b>--</b> </span>
                                    </td>
                                </tr>
                                <tr>
                                    <td><span>Residency Expiry Date:&nbsp;</span>
                                    </td>
                                    <td><span id="ResidencyExpiryDate_PDLabel"><b>--</b>
                                    </span>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>         
    </table> 

</body>
</html>
