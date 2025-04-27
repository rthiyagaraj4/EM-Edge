<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhCommon.js"></SCRIPT>
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script> -->	
 <script language="JavaScript" src="../../ePH/js/RegPrescriptions.js"></script>
  <style>
        body {
        	grid-gap: 15px;
            margin: 0;
            height: 100vh;
            display: grid;
            grid-template-columns: 24% 74%;
   
        }

        #left-sidebar {
            grid-row: span 2;
            background-color: #f0f0f0;
        }

        #content {
            display: grid;
            /* grid-template-rows: 7% 93%; */
        }

        #header {
            display: grid;
            /* grid-template-rows: 17% 83%; */
        }
        
        #header-patient-id-locator
        {
        	 height: 6vh;
        }
        
        #header-patient-id
        {
        	 height: 93vh;
        }

        #main {
            display: grid;
            /* grid-template-rows: 10% 38% 51%; */
        }

        #reg_prescriptions_header_patient_line {
            height: 10vh;
        }

        #reg_prescriptions_header_details {
            height: 38vh;
        }

        #footer {
            display: grid;
           /*  grid-template-rows: 87% 12%; */
        }

        #reg_prescriptions_footer_details {
            height: 43vh;
        }

        #reg_prescriptions_status {
            height: 5vh;
        }

        iframe {
            width: 100%;
            border: 0;
        }
    </style>
</head>

<body>
    <div id="left-sidebar">
      <div id="header">
            <iframe id="header-patient-id-locator" name="reg_prescriptions_header_patient_id_locator" src="../../eCommon/html/blank.html"></iframe>
            <iframe id="header-patient-id" name="reg_prescriptions_header_patient_id" src="../../eCommon/html/blank.html"></iframe>
        </div>
    </div>

    <div id="content">
        

        <div id="main">
            <iframe id="reg_prescriptions_header_patient_line" name="reg_prescriptions_header_patient_line" src="../../eCommon/html/blank.html"></iframe>
            <iframe id="reg_prescriptions_header_details" name="reg_prescriptions_header_details" src="../../eCommon/html/blank.html"></iframe>

            <div id="footer">
                <iframe id="reg_prescriptions_footer_details" name="reg_prescriptions_footer_details" src="../../ePH/jsp/RegPrescriptionsDetailFrame.jsp"></iframe>
                <iframe id="reg_prescriptions_status" name="reg_prescriptions_status" src="../../eCommon/html/blank.html"></iframe>
            </div>
        </div>
    </div>
</body>

</html>
