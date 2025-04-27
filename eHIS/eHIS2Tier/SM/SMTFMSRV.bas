Attribute VB_Name = "ModMEDFxMGR"
Global GWorkstatinID As String
Global GLastLogDate As String
Global GTmpStr As String
Global GCmdStr As String
Global GLogTable As Recordset
Global GLocalDB As Database
Global GRecordCtr As Integer
Global GCountSet As Recordset
Global GDBCurrentDateTime As String
Global GRequestTable As Recordset
Global GParamTable As Recordset
Global GAuditLogTable As Recordset
Global GSQLText As String
Global GMEDICOMDBConnectString As String
Global GDSName As String
Global GControlDocument As String
Global GHideFormYN As Integer
Global GLogFileName As String
Global GSuccessYN As Boolean
Global GFacilityIDArg As String
Global GRestartYN As Boolean        ' To restart the program.
Global GTestingYN As Boolean        ' To restart the program.
Global GCommandStr As String
Global GLogRecordCtr As Double
Global GMinutesElapsed As Double

' SM_REPORT_FAX_MAIL_REQUEST table data
Global GFacilityID As String
Global GModuleID As String
Global GReportID As String
Global GLocationType As String
Global GLocationCode As String
Global GRoutingMode As String
Global GReportPriority As String
Global GReportFileName As String
Global GUserID As String
Global GRequestDate As Date
Global GManualFaxYN As Boolean     ' Mail routing fetched or manual mail
Global GFaxAddress As String
Global GAltFaxAddress  As String

' appfaxmail.GET_FAXMAIL_ROUTING_PROPERTY stored procedure
Global GRoutingFound As Boolean
Global GFaxID As String
Global GErrorText As String

' appfaxmail.GET_FAXDETAILS stored procedure
Global GRecipientName As String
Global GFaxNumber As String
Global GAltFaxNumber As String
Global GFaxServiceID As String
Global GCompanyName As String
Global GPhoneNumber As String

' GET_FAX_SERVICE_DETAILS stored procedure
Global GFaxServiceName As String
Global GPrinterID As String

' appprint.get_queue_name
Global GPrinterQueueName As String


' New procedure for getting user name and contact details.
Global GFromUserName As String
Global GFromPhoneNumber As String
Global GFromFaxNumber As String
Function CheckFileExists(PFileName)
    If PFileName = "" Then
        CheckFileExists = False
        Exit Function
    Else
        Set fs = CreateObject("Scripting.FileSystemObject")
        If Not fs.FileExists(PFileName) Then
            CheckFileExists = False
            Exit Function
        End If
    End If
    CheckFileExists = True
End Function

