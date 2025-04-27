VERSION 5.00
Object = "{20C62CAE-15DA-101B-B9A8-444553540000}#1.1#0"; "MSMAPI32.OCX"
Begin VB.Form frmSMTMLSRV 
   BackColor       =   &H00800000&
   BorderStyle     =   1  'Fixed Single
   Caption         =   "MEDICOM Mail Manager"
   ClientHeight    =   1965
   ClientLeft      =   45
   ClientTop       =   330
   ClientWidth     =   4170
   ClipControls    =   0   'False
   Icon            =   "SMTMLSRV.frx":0000
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   ScaleHeight     =   1965
   ScaleWidth      =   4170
   StartUpPosition =   3  'Windows Default
   Begin MSMAPI.MAPISession MAPISession1 
      Left            =   2040
      Top             =   1200
      _ExtentX        =   1005
      _ExtentY        =   1005
      _Version        =   393216
      DownloadMail    =   -1  'True
      LogonUI         =   -1  'True
      NewSession      =   0   'False
   End
   Begin MSMAPI.MAPIMessages MAPIMessages1 
      Left            =   2880
      Top             =   1200
      _ExtentX        =   1005
      _ExtentY        =   1005
      _Version        =   393216
      AddressEditFieldCount=   1
      AddressModifiable=   0   'False
      AddressResolveUI=   0   'False
      FetchSorted     =   0   'False
      FetchUnreadOnly =   0   'False
   End
   Begin VB.TextBox ProgressBar 
      BackColor       =   &H0000C000&
      BorderStyle     =   0  'None
      Enabled         =   0   'False
      ForeColor       =   &H00FFFFFF&
      Height          =   375
      Left            =   250
      TabIndex        =   3
      Top             =   1200
      Width           =   255
   End
   Begin VB.Timer CurrTimer 
      Enabled         =   0   'False
      Interval        =   1000
      Left            =   1440
      Top             =   1560
   End
   Begin VB.Timer RequestTimer 
      Enabled         =   0   'False
      Interval        =   1
      Left            =   1920
      Top             =   1560
   End
   Begin VB.Label MsgText 
      BackColor       =   &H00800000&
      ForeColor       =   &H00FFFFFF&
      Height          =   255
      Left            =   240
      TabIndex        =   4
      Top             =   1650
      Width           =   3855
   End
   Begin VB.Label Label2 
      Alignment       =   2  'Center
      BackColor       =   &H00800000&
      Caption         =   "Ver 1.1"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   9.75
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FFFF00&
      Height          =   255
      Left            =   360
      TabIndex        =   2
      Top             =   720
      Width           =   3495
   End
   Begin VB.Label CurrTime 
      Alignment       =   1  'Right Justify
      BackColor       =   &H00800000&
      Caption         =   "CurrTime"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   9
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00E0E0E0&
      Height          =   255
      Left            =   2520
      TabIndex        =   1
      Top             =   0
      Width           =   1575
   End
   Begin VB.Label Label1 
      Alignment       =   2  'Center
      BackColor       =   &H00800000&
      Caption         =   "MEDICOM Mail Manager"
      BeginProperty Font 
         Name            =   "Book Antiqua"
         Size            =   14.25
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FFFFC0&
      Height          =   375
      Left            =   360
      TabIndex        =   0
      Top             =   360
      Width           =   3495
   End
End
Attribute VB_Name = "frmSMTMLSRV"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
' -------------------------------------------------------------------------------------------------------
' Revision History
' -------------------------------------------------------------------------------------------------------
' Date           Who         Version     Remarks
' -------------------------------------------------------------------------------------------------------
' Jun 06, 05     S. Sundar   1.0         Created.
' Jan 07, 06     S. Sundar   1.1         Salutation and footer added in Mail Body.
'                                        LIS File Conversion to PDF
'
' -------------------------------------------------------------------------------------------------------
Const RECIPTYPE_TO = 1
Const RECIPTYPE_CC = 2
Const RECIPTYPE_BCC = 3

Dim en As rdoEnvironment
Dim er As rdoError
Dim cn As rdoConnection
Dim rQry As rdoQuery
Private Sub CurrTime_DblClick()
    Call SpoolLog(False, True)
End Sub
Private Function GetFileName(PFileNameWithPath As String)
    For GCtR = Len(PFileNameWithPath) To 1 Step -1
        If Mid(PFileNameWithPath, GCtR, 1) = "\" Then
            Exit For
        End If
    Next
    
    GetFileName = Mid(PFileNameWithPath, GCtR + 1)
End Function
Private Sub CurrTimer_Timer()
    On Error GoTo err
    
    CurrTime = FormatDateTime(Now, vbShortDate) & " " & FormatDateTime(Now, vbShortTime)
    ProgressBar.Left = ProgressBar.Left + 50
    If ProgressBar.Left > 3500 Then
        ProgressBar.Left = 250
    End If
    
    Exit Sub
err:
    WriteLog ("Error at CurrTimer_Timer() : " & err.Description)
End Sub
Private Sub Form_Load()
    Call Initialize
End Sub
Private Sub Initialize()
    Dim strArgs() As String
    Dim IsFormHidden As Boolean
    
    On Error GoTo err
    
    ' Read command line argument and decide whether the form is to be shown
    ' or hidden.
    GCommandStr = Command$
    GCmdStr = "SMTMLSRV " & GCommandStr
    strArgs = Split(Command$, " ")
    
    'Dispaly command line arguments.
    
    ' Read facility id. This is used to check whether the program is running
    ' or not.
    GFacilityIDArg = strArgs(3)
    
    IsFormHidden = False
    If UBound(strArgs) >= 0 Then
        If UCase(Right(GCommandStr, 1)) = "H" Then
            ' Hide the form.
            If GHideFormYN Then
                IsFormHidden = True
                Me.Hide
            End If
        End If
    Else
        ' Show the form.
        Me.Show
    End If
    
    If Not IsFormHidden Then
        ' Position objects
        Me.Left = 3500
        Me.Top = 2000
        ProgressBar.Left = 250
        ProgressBar.BackColor = &HFFFFFF 'Idle
    
        ' Display current time
        CurrTime = FormatDateTime(Now, vbShortDate) & " " & FormatDateTime(Now, vbShortTime)
    End If
    
    ' Open local database.
    Set GLocalDB = DBEngine.Workspaces(0).OpenDatabase("C:\MEDICOM\SMTMLSRV\SMTMLSRV.MDB")
    
    ' Purge log.
    GSQLText = "DELETE FROM Log;"
    GLocalDB.Execute GSQLText
    
    ' Get program PATH and timestamp.
    GTmpStr = App.Path & "\" & App.EXEName & ".EXE"
    
    ' Open audit log table (Log)
    Set GLogTable = GLocalDB.OpenRecordset("Log", dbOpenDynaset)
    WriteLog ("Program Start.")
    GTmpStr = App.Path & "\" & App.EXEName & ".EXE"
    WriteLog ("Program=[" & GTmpStr & "] TimeStamp=[" & FileDateTime(GTmpStr) & "]")
    WriteLog ("Args=[" & GCommandStr & "]")
    
    ' Read and validate parameters (Param table).
    GMEDICOMDBConnectString = ""
    GDSName = ""
    GTestingYN = False
    GRestartYN = False
    GControlDocument = ""
    GHideFormYN = 0
    GTestMailAddress = ""
    GTestMailCcAddress = ""
    GTestMailBccAddress = ""
    GTestMailSubject = ""
    GTestMailAttachment = ""
    GTestMailText = ""

    Set GParamTable = GLocalDB.OpenRecordset("Param", dbOpenDynaset)
    GParamTable.MoveFirst
    With GParamTable
        Do While Not .EOF
            If UCase(GParamTable!ID) = UCase("ConnectString") Then
                GMEDICOMDBConnectString = IIf(IsNull(GParamTable!Value), "", GParamTable!Value)
            ElseIf UCase(GParamTable!ID) = UCase("DSName") Then
                GDSName = IIf(IsNull(GParamTable!Value), "", GParamTable!Value)
            ElseIf UCase(GParamTable!ID) = UCase("HideFormYN") Then
                GHideFormYN = IIf(IsNull(GParamTable!Value), "", GParamTable!Value)
            ElseIf UCase(GParamTable!ID) = UCase("Restart") Then
                GRestartYN = IIf(IsNull(GParamTable!Value), "", GParamTable!Value)
            ElseIf UCase(GParamTable!ID) = UCase("ProfileName") Then
                GMailProfileName = IIf(IsNull(GParamTable!Value), "", GParamTable!Value)
            ElseIf UCase(GParamTable!ID) = UCase("TestMailID") Then
                GTestMailAddress = IIf(IsNull(GParamTable!Value), "", GParamTable!Value)
            ElseIf UCase(GParamTable!ID) = UCase("TestMailCcID") Then
                GTestMailCcAddress = IIf(IsNull(GParamTable!Value), "", GParamTable!Value)
            ElseIf UCase(GParamTable!ID) = UCase("TestMailBccID") Then
                GTestMailBccAddress = IIf(IsNull(GParamTable!Value), "", GParamTable!Value)
            ElseIf UCase(GParamTable!ID) = UCase("TestMailSubject") Then
                GTestMailSubject = IIf(IsNull(GParamTable!Value), "Test Mail", GParamTable!Value)
            ElseIf UCase(GParamTable!ID) = UCase("TestMailAttachment") Then
                GTestMailAttachment = IIf(IsNull(GParamTable!Value), "", GParamTable!Value)
            ElseIf UCase(GParamTable!ID) = UCase("TestMailText") Then
                GTestMailText = IIf(IsNull(GParamTable!Value), "", GParamTable!Value)
            ElseIf UCase(GParamTable!ID) = UCase("PCLConvertTool") Then
                GPCLConvertTool = IIf(IsNull(GParamTable!Value), "", GParamTable!Value)
            End If
            GParamTable.MoveNext
        Loop
    End With
    GParamTable.Close
    
    If GMEDICOMDBConnectString = "" Then
        Response = MsgBox("ReadParam() : Unable to read database connect string !!", vbCritical, "MEDICOM Mail Manager")
        GoTo Abort
    End If
    
    If GDSName = "" Then
        Response = MsgBox("ReadParam() : Unable to read data source name !!", vbCritical, "MEDICOM Mail Manager")
        GoTo Abort
    Else
        WriteLog ("Data Source=[" & GDSName & "]")
    End If
    
    ' Check test mail id is set.
    If GTestMailAddress = "" Then
        Response = MsgBox("ReadParam() : Test mail id is not set !!", vbCritical, "MEDICOM Mail Manager")
        GoTo Abort
    End If
    
    WriteLog ("Restart?=[" & GRestartYN & "]")
    
    GSuccessYN = True
    Call ODBCTesting
    If Not GSuccessYN Then
        GoTo Abort
    End If
    
    ' Enable timer control.
    RequestTimer.Enabled = True
    GMinutesElapsed = 0
    CurrTimer.Enabled = True
    
    ' Initialization complete.
    WriteLog ("Initialization Complete.")
    Exit Sub
err:
    Response = MsgBox("Error at Intitialize() : " & err.Description, vbCritical, "MEDICOM Mail Manager")
Abort:
    Call Terminate
End Sub
Private Sub Terminate()
    On Error Resume Next
    
    'Disable timers
    RequestTimer.Enabled = False
    CurrTimer.Enabled = False
    
    If GLogRecordCtr > 0 Then
        Call SpoolLog(True, False)
    End If
    
    ' Close local database.
    GLocalDB.Close
    
    'Restart new instance, if set.
    If GRestartYN = True Then
        GRetVal = Shell(GCmdStr, vbNormalFocus)
    End If
    
    'Close the form
    Unload Me
    End
End Sub
Private Sub Label2_Click()
    Call MailTesting
End Sub

Private Sub MsgText_DblClick()
    GLastLogDate = "About to start new instance ..."
    Response = MsgBox(GLastLogDate, vbInformation, "MEDICOM Mail Manager")
End Sub

Private Sub RequestTimer_Timer()
    On Error GoTo err

    ' Initialize
    ProgressBar.BackColor = &HFFFFFF ' Idle
    If RequestTimer.Interval <> 30000 Then
        RequestTimer.Interval = 30000
    End If
    
    ' Check if program running - backend.
    If Not CheckProgramRunning Then
        Response = MsgBox("MEDICOM Mail Manager is about to abort ...", vbDefaultButton1, "MEDICOM Mail Manager")
        GRestartYN = False
        Call Terminate
        Exit Sub
    End If

    Call Process
    Exit Sub
err:
    ' Reset progressbar attribute
    ProgressBar.BackColor = &HFFFFFF ' Idle
    
    ' Enable progressbar timer
    RequestTimer.Enabled = True
    WriteLog ("Error at RequestTimer_Timer() : " & err.Description)
End Sub
Private Sub Process()
    On Error GoTo err
    
    ' Search for new requests in sm_report_fax_mail_request.
    If Not AnyNewRequest Then
        GoTo Exit_sub
    End If
    
    ' Disable process timer.
    RequestTimer.Enabled = False
    
    ' Change progressbar attribute.
    ProgressBar.BackColor = &HC000& ' Processing
    
    MsgText = "Last request processed at " & CurrTime
    Me.Refresh
    
    ' Open a connection to MEDICOM database.
    Set en = rdoEnvironments(0)
    Set cn = en.OpenConnection(dsName:=GDSName, Prompt:=rdDriverNoPrompt, _
    Connect:=GMEDICOMDBConnectString)

    GSQLText = "SELECT * FROM sm_report_fax_mail_request "
    GSQLText = GSQLText & "WHERE submitted_yn IS NULL "
    GSQLText = GSQLText & "AND routing_mode = 'M'"                          ' Process only mail requests.
    Set GRequestTable = GLocalDB.OpenRecordset(GSQLText, dbOpenDynaset)

    With GRequestTable
        
        GRequestTable.MoveFirst
        
        Do Until GRequestTable.EOF
            
            ' Initialize.
            GFacilityID = ""
            GModuleID = ""
            GReportID = ""
            GLocationType = ""
            GLocationCode = ""
            GRoutingMode = ""
            GReportFileName = ""
            GUserID = ""
            GMailAddress = ""
            GMailCcAddress = ""
            GMailBccAddress = ""
            GMailSubject = ""
            GMailText = ""
            
            ' Store table data.
            GFacilityID = GRequestTable!operating_facility_id
            GModuleID = GRequestTable!module_id
            GReportID = GRequestTable!report_id
            GLocationType = GRequestTable!dest_locn_type
            GLocationCode = GRequestTable!dest_locn_code
            GRoutingMode = GRequestTable!routing_mode
            GReportFileName = IIf(IsNull(GRequestTable!report_file_name), "", GRequestTable!report_file_name)
            GRequestDate = GRequestTable!request_date
            GUserID = GRequestTable!user_id
            GTmpStr = "Facility=[" & GFacilityID & "] "
            GTmpStr = GTmpStr & " Module=[" & GModuleID & "] "
            GTmpStr = GTmpStr & " User=[" & GUserID & "] "
            GTmpStr = GTmpStr & " Report=[" & GReportID & "] "
            GTmpStr = GTmpStr & " LocnType=[" & GLocationType & "] "
            GTmpStr = GTmpStr & " LocnCode=[" & GLocationCode & "] "
            GTmpStr = GTmpStr & " Requested On=[" & GRequestDate & "] "
            GTmpStr = GTmpStr & " File=[" & GReportFileName & "] "
            WriteLog (GTmpStr)
            
            GMailSubject = IIf(IsNull(GRequestTable!subject), " ", GRequestTable!subject)
            ' If Subject is Blank, Put a single space.
            If LTrim(RTrim(GMailSubject)) = "" Then
                GMailSubject = " "
            End If
            GSalutation = IIf(IsNull(GRequestTable!salutation), " ", GRequestTable!salutation)
            GBody = IIf(IsNull(GRequestTable!body), " ", GRequestTable!body)
            GFooter = IIf(IsNull(GRequestTable!footer), " ", GRequestTable!footer)
            GTmpStr = "Subject=[" & GMailSubject & "] "
            GTmpStr = GTmpStr & " Salutation=[" & GSalutation & "] "
            GTmpStr = GTmpStr & " Footer=[" & GFooter & "] "
            WriteLog (GTmpStr)
            GMailText = GSalutation & vbCr & vbCr & GBody & vbCr & vbCr & GFooter
            
            If GLocationType = "@" And GLocationCode = "@" Then
                GManualMailYN = True
                GMailAddress = IIf(IsNull(GRequestTable!fax_mail_address), "", GRequestTable!fax_mail_address)
                GMailCcAddress = IIf(IsNull(GRequestTable!fax_mail_cc_address), "", GRequestTable!fax_mail_cc_address)
                GMailBccAddress = IIf(IsNull(GRequestTable!mail_bcc_address), "", GRequestTable!mail_bcc_address)
                GTmpStr = "Mail ID=[" & GMailAddress & "] "
                GTmpStr = GTmpStr & " Cc=[" & GMailCcAddress & "] "
                GTmpStr = GTmpStr & " Bc=[" & GMailBccAddress & "] "
                WriteLog (GTmpStr)
            Else
                GManualMailYN = False
            End If
            
            Do
                ' Check for file existence
                If Len(GReportFileName) > 0 Then
                    If CheckFileExists(GReportFileName) Then
                        ' Report file found. If file extension is LIS
                        If UCase(Right(GReportFileName, 3)) = "LIS" Then
                            ' If PCL Conversion Tool is defined in Parameter, then convert
                            If Len(GPCLConvertTool) > 0 Then
                                'Conversion tool is PCLXForm.
                                If InStr(UCase(GPCLConvertTool), "PCLXFORM") > 0 Then
                                    For GVCtr = 1 To Len(GReportFileName)
                                        If Mid(GReportFileName, GVCtr, 1) = "\" Then
                                            LVpos = GVCtr
                                        End If
                                    Next
                                    LVReportFileName = Mid(GReportFileName, LVpos + 1)
                                    GCmdStr = GPCLConvertTool & " C:\Medicom\SMTMLSRV\pclxform.tpt inf=" & GReportFileName & " outf=C:\Medicom\SMTMLSRV\" & Mid(LVReportFileName, 1, Len(LVReportFileName) - 3) & "PDF"
                                    WriteLog (GCmdStr)
                                    GRetVal = Shell(GCmdStr, vbNormalFocus)
                                    WriteLog ("After Conversion")
                                    GReportFileName = "C:\Medicom\SMTMLSRV\" & Mid(LVReportFileName, 1, Len(LVReportFileName) - 3) & "PDF"
                                End If
                            Else
                                ' PCL Conversion Parameters Not Defined.
                                WriteLog ("PCL Conversion Parameter Not Defined")
                            End If
                        End If
                    Else
                        ' Report file not found.
                        WriteLog (GReportFileName & " not exists !!")
                        GRequestTable.Edit
                        GRequestTable!submitted_yn = "N"
                        GRequestTable.Update
                        Exit Do
                    End If
                End If
                
                ' Get mail routing information for auto mailing requests.
                
                If Not GManualMailYN Then
                    ' Get mail routing information
                    ' Check if Mail ID is passed.
                    GMailID = IIf(IsNull(GRequestTable!fax_mail_id), "", GRequestTable!fax_mail_id)
                    If GMailID = "" Then
                        Call GetMailRouting
                        If Not GRoutingFound Then
                            ' Routing not found.
                            ' Update sm_report_fax_mail_request
                            GRequestTable.Edit
                            GRequestTable!submitted_yn = "N"
                            GRequestTable.Update
                            Exit Do
                        End If
                    End If
                    
                    ' Get mail details
                    Call GetMailDetails
                    If Not GSuccessYN Then
                        ' Fax details not found.
                        GRequestTable.Edit
                        GRequestTable!submitted_yn = "N"
                        GRequestTable.Update
                        Exit Do
                    End If
                End If
                
                ' Send mail.
                Call SendMail(GMailAddress, GMailCcAddress, GMailBccAddress, GMailSubject, GMailText, GReportFileName)
                
                ' Get DB current date time.
                GSQLText = "{call get_current_timestamp(?)}"
                Set rQry = cn.CreateQuery("", GSQLText)
                rQry.Execute
                GDBCurrentDateTime = rQry(0)
                
                ' Request is successfully submitted.
                ' Update sm_report_fax_mail_request
                GRequestTable.Edit
                If GSuccessYN Then
                    GRequestTable!submitted_yn = "Y"
                    If Not GManualMailYN Then
                        GRequestTable!fax_mail_address = GMailAddress
                        GRequestTable!fax_mail_cc_address = IIf(IsNull(GMailCcAddress), "", GMailCcAddress)
                        GRequestTable!mail_bcc_address = IIf(IsNull(GMailBccAddress), "", GMailBccAddress)
                    End If
                    WriteLog ("Process Success. Mail submitted At " & GDBCurrentDateTime)
                Else
                    GRequestTable!submitted_yn = "N"
                End If
                GRequestTable!submitted_date = GDBCurrentDateTime
                GRequestTable.Update
          
                Exit Do
                
            Loop Until True
            
            GRequestTable.MoveNext
            
        Loop
    End With
    GRequestTable.Close
    GoTo Terminate_Process
err:
    GTmpStr = ""
    If err Then
        GTmpStr = err.Description
    Else
        For Each er In rdoErrors
           GTmpStr = GTmpStr & er.Description & ":" & er.Number & vbCr & Chr(10)
        Next er
    End If
    WriteLog ("Error at Process() " & GTmpStr)
    Call SpoolLog(False, False)
Terminate_Process:
    ' Reset progressbar attribute
    ProgressBar.BackColor = &HFFFFFF ' Idle
    
    ' Enable process timer.
    RequestTimer.Enabled = True
    
    ' Close database connection
    en.Close
    cn.Close
Exit_sub:
    ' Reset progressbar attribute
    ProgressBar.BackColor = &HFFFFFF ' Idle
    
    ' Enable process timer.
    RequestTimer.Enabled = True
    Exit Sub
End Sub
Private Function AnyNewRequest()
    Dim NewRequestCountSQLText As String
    
    On Error GoTo err
    
    WriteLog "Searching for new requests ... "
    
    NewRequestCountSQLText = "SELECT COUNT(*) FROM sm_report_fax_mail_request WHERE submitted_yn IS NULL AND routing_mode = 'M'"
   
    Set GCountSet = GLocalDB.OpenRecordset(NewRequestCountSQLText)
    GRecordCtr = GCountSet(0)
    If GRecordCtr > 0 Then
        AnyNewRequest = True
    Else
        AnyNewRequest = False
    End If
    
    Exit Function
err:
    GTmpStr = ""
    If err Then
        GTmpStr = err.Description
    Else
        For Each er In rdoErrors
           GTmpStr = GTmpStr & er.Description & ":" & er.Number & vbCr & Chr(10)
        Next er
    End If
    WriteLog ("Error at AnyNewRequest() : " & GTmpStr)
    Call SpoolLog(False, False)
End Function
Private Sub ODBCTesting()
    On Error GoTo err
    
    err.Clear
    
    WriteLog ("Validating ODBC ...")
    
    Set en = rdoEnvironments(0)
    Set cn = en.OpenConnection(dsName:=GDSName, Prompt:=rdDriverNoPrompt, _
        Connect:=GMEDICOMDBConnectString)
    
    GSQLText = "{call wrapprc(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"
    Set rQry = cn.CreateQuery("", GSQLText)
    
    rQry(0) = "workstation.get_workstation_id"  ' p_proc_name
    rQry(1) = ""                                ' p_in_1
    rQry(2) = ""                                ' p_in_2
    rQry(3) = ""                                ' p_in_3
    rQry(4) = ""                                ' p_in_4
    rQry(5) = ""                                ' p_in_5
    rQry(6) = ""                                ' p_in_6
    rQry(7) = ""                                ' p_in_7
    rQry(8) = ""                                ' p_in_8
    rQry(9) = ""                                ' p_in_9
    rQry(10) = ""                               ' p_in_10
    rQry.Execute
   
    GWorkstatinID = rQry(11)
    WriteLog ("Workstation ID=[" & GWorkstatinID & "]")
        
    GoTo Exit_sub
err:
    GSuccessYN = False
    GTmpStr = ""
    If err Then
        GTmpStr = err.Description
    Else
        For Each er In rdoErrors
           GTmpStr = GTmpStr & er.Description & ":" & er.Number & vbCr & Chr(10)
        Next er
    End If
    WriteLog ("Error at ODBCTesting() Error : " & GTmpStr)
    Response = MsgBox("Error at ODBCTesting() : " & GTmpStr, vbCritical, "MEDICOM Mail Manager")
Exit_sub:
    en.Close
    cn.Close
End Sub
Private Function CheckProgramRunning()
    On Error GoTo err
    
    Dim LRunningStatus As String
    
    err.Clear
    
    WriteLog ("Checking program status ...")
    
    Set en = rdoEnvironments(0)
    Set cn = en.OpenConnection(dsName:=GDSName, Prompt:=rdDriverNoPrompt, _
        Connect:=GMEDICOMDBConnectString)
    
    GSQLText = "{call check_program_running(?,?,?,?)}"
    Set rQry = cn.CreateQuery("", GSQLText)
    
    rQry(0) = GFacilityIDArg        ' p_facility_id
    rQry(1) = ""                    ' p_machine_name
    rQry(2) = "SMTMLSRV"            ' p_pgm_id
    'rQry(3) = ""                   ' p_running_status ('TRUE' or 'FALSE')
    rQry.Execute
   
    LRunningStatus = rQry(3)
    
    If UCase(LRunningStatus) = "TRUE" Then
        CheckProgramRunning = True
    Else
        CheckProgramRunning = False
        WriteLog ("Status= [" & LRunningStatus & "]")
    End If
    
    If GTestingYN = True Then
        CheckProgramRunning = True
    End If
    
    GoTo Exit_Function
err:
    GSuccessYN = False
    GTmpStr = ""
    If err Then
        GTmpStr = err.Description
    Else
        For Each er In rdoErrors
           GTmpStr = GTmpStr & er.Description & ":" & er.Number & vbCr & Chr(10)
        Next er
    End If
    WriteLog ("Error at CheckProgramRunning () : " & GTmpStr)
    Response = MsgBox("Error at CheckProgramRunning () : " & GTmpStr, vbCritical, "MEDICOM Mail Manager")
    Call SpoolLog(False, False)
Exit_Function:
    en.Close
    cn.Close
End Function
Sub GetMailRouting()
    On Error GoTo err
    
    err.Clear
    GRoutingFound = False
    
    GSQLText = "{call wrapprc(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"
    Set rQry = cn.CreateQuery("", GSQLText)
    
    rQry(0) = "appfaxmail.get_faxmail_routing_property"  ' p_proc_name
    rQry(1) = GFacilityID                                ' Arguments
    rQry(2) = GModuleID
    rQry(3) = GReportID
    rQry(4) = GLocationType
    rQry(5) = GLocationCode
    rQry(6) = GRoutingMode
    rQry(7) = ""
    rQry(8) = ""
    rQry(9) = ""
    rQry(10) = ""
    rQry.Execute
    
    If IsNull(rQry(11)) Then
        GMailID = ""
    Else
        GMailID = rQry(11)
    End If

    If IsNull(rQry(12)) Then
        GErrorText = ""
    Else
        GErrorText = LTrim(RTrim(rQry(12)))
    End If
    
    If Len(GMailID) > 0 And Len(GErrorText) = 0 Then
        GRoutingFound = True
        WriteLog ("GetMailRotuing() Mail ID=[" & GMailID & "]")
    End If
    
    GoTo Exit_sub
    
err:
    GSuccessYN = False
    GTmpStr = ""
    If err Then
        GTmpStr = err.Description
    Else
        For Each er In rdoErrors
           GTmpStr = GTmpStr & er.Description & ":" & er.Number & vbCr & Chr(10)
        Next er

    End If
    WriteLog ("Error at GetMailRotuing() : " & GTmpStr)
    Call SpoolLog(False, False)
Exit_sub:
    If Not GRoutingFound Then
        WriteLog ("GetMailRotuing() No routing found.")
    End If
    Exit Sub
End Sub
Sub GetMailDetails()
    On Error GoTo err
    
    err.Clear
    GSuccessYN = False
    
    GSQLText = "{call wrapprc(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"
    Set rQry = cn.CreateQuery("", GSQLText)
    
    rQry(0) = "appfaxmail.get_mail_details"           ' p_proc_name
    rQry(1) = GMailID                            ' Arguments
    rQry(2) = ""
    rQry(3) = ""
    rQry(4) = ""
    rQry(5) = ""
    rQry(6) = ""
    rQry(7) = ""
    rQry(8) = ""
    rQry(9) = ""
    rQry(10) = ""
    rQry.Execute

    If IsNull(rQry(11)) Then
        GMailAddress = ""
    Else
        GMailAddress = rQry(11)
    End If

    If IsNull(rQry(12)) Then
        GMailCcAddress = ""
    Else
        GMailCcAddress = rQry(12)
    End If

    If IsNull(rQry(13)) Then
        GMailBccAddress = ""
    Else
        GMailBccAddress = rQry(13)
    End If
    
    If Len(GMailAddress) > 0 And Len(GErrorText) = 0 Then
        GSuccessYN = True
        WriteLog ("GetMailDetails() Mail ID=[" & GMailAddress & "] " & " Cc=[" & GMailCcAddress & "] Bcc=[" & GMailBccAddress & "]")
    End If
    
    GoTo Exit_sub
err:
    GSuccessYN = False
    GTmpStr = ""
    If err Then
        GTmpStr = err.Description
    Else
        For Each er In rdoErrors
           GTmpStr = GTmpStr & er.Description & ":" & er.Number & vbCr & Chr(10)
        Next er
    End If
    WriteLog ("Error at GetMailDetails() : " & GTmpStr)
    Call SpoolLog(False, False)
Exit_sub:
    If Not GSuccessYN Then
        WriteLog ("GetMailDetails() " & GErrorText)
    End If
    Exit Sub
End Sub
Sub SendMail(PMailAddress As String, PMailCcAddress As String, PMailBccAddress As String, PMailSubject As String, PMailText As String, PMailAttachment As String)
    Dim LVErr As Integer
    
    On Error GoTo err
    
    'WriteLog ("Address=[" & PMailAddress & "] Cc=[" & PMailCcAddress & "] Bcc=[" & PMailBccAddress & "] Sub=[" & PMailSubject & "] Attach=[" & PMailAttachment & "]")
    
    err.Clear
    GSuccessYN = False
    
    ' Send the mail.
    'Sign on to the MAPI Session
    MAPISession1.UserName = GMailProfileName
    MAPISession1.SignOn
    MAPIMessages1.SessionID = MAPISession1.SessionID
    
    ' Tell the control that I am composing email.
    MAPIMessages1.Compose

    'Pass parameters for composing the mail.
    MAPIMessages1.RecipIndex = 0                                        'To recipient
    MAPIMessages1.RecipType = RECIPTYPE_TO
    MAPIMessages1.RecipDisplayName = PMailAddress
   
    ' Pass through the loop for adding multiple Cc addresses
    If Len(PMailCcAddress) > 0 Then
        TmpStr = ""
        For Ctr = 1 To Len(PMailCcAddress)
            CurrChar = Mid(PMailCcAddress, Ctr, 1)
            If CurrChar = ";" Then
                MAPIMessages1.RecipIndex = MAPIMessages1.RecipIndex + 1     ' Count
                MAPIMessages1.RecipType = RECIPTYPE_CC                      'Recipient in CC line
                MAPIMessages1.RecipDisplayName = TmpStr                     'e-mail name
                TmpStr = ""
            Else
                TmpStr = TmpStr + CurrChar
            End If
        Next Ctr
        MAPIMessages1.RecipIndex = MAPIMessages1.RecipIndex + 1     ' Count
        MAPIMessages1.RecipType = RECIPTYPE_CC                      'Recipient in CC line
        MAPIMessages1.RecipDisplayName = TmpStr                     'e-mail name
    End If
          
    If Len(PMailBccAddress) > 0 Then
        TmpStr = ""
        For Ctr = 1 To Len(PMailBccAddress)
            CurrChar = Mid(PMailBccAddress, Ctr, 1)
            If CurrChar = ";" Then
                MAPIMessages1.RecipIndex = MAPIMessages1.RecipIndex + 1     ' Count
                MAPIMessages1.RecipType = RECIPTYPE_BCC                      'Recipient in BCC line
                MAPIMessages1.RecipDisplayName = TmpStr                     'e-mail name
                TmpStr = ""
            Else
                TmpStr = TmpStr + CurrChar
            End If
        Next Ctr
        MAPIMessages1.RecipIndex = MAPIMessages1.RecipIndex + 1     ' Count
        MAPIMessages1.RecipType = RECIPTYPE_BCC                      'Recipient in BCC line
        MAPIMessages1.RecipDisplayName = TmpStr                     'e-mail name
    End If
   
    MAPIMessages1.MsgSubject = PMailSubject
    MAPIMessages1.MsgNoteText = IIf(IsNull(PMailText), Now, PMailText)
    
    If Len(PMailAttachment) > 0 Then
        MAPIMessages1.AttachmentPathName = PMailAttachment                  ' Actual attachment file name
        MAPIMessages1.AttachmentName = GetFileName(PMailAttachment)         ' Displayed name
    End If
    
    'Send the e-mail message to the Recipients
    MAPIMessages1.Send False
    
    GSuccessYN = True
    WriteLog ("Mail to " & PMailAddress & " is submitted.")
    
    ' Sign off session.
    MAPISession1.SignOff
    GoTo Exit_sub
err:
    MAPISession1.SignOff
    GSuccessYN = False
    GTmpStr = ""
    If err Then
        LVErr = err.Number
        GTmpStr = err.Number & " - " & err.Description
    Else
        LVErr = er.Number
        For Each er In rdoErrors
           GTmpStr = GTmpStr & er.Description & ":" & er.Number & vbCr & Chr(10)
        Next er
    End If

    WriteLog ("Mail not sent: " & GTmpStr)
    Exit Sub
    
Exit_sub:
    If Not GSuccessYN Then
        WriteLog ("SendMail() : Mail not sent. " & err.Description)
    End If
End Sub
Private Sub WriteLog(PMsg As String)

    Dim CurrentDate As String
    Dim CurrentTime As String
    Dim LCountSet As Recordset
    
    On Error GoTo err
    
    '
    ' Purge logs daily morning 12:00.
    ' Change following line. Restart testing hourly.
    '
    CurrentDate = Format(Now, "mmm-dd-yy")
    If GLastLogDate <> CurrentDate Then
        If PMsg <> "Program Start." Then
            Call SpoolLog(True, False)
        End If
        
        GSQLText = "DELETE FROM Log;"
        GLocalDB.Execute GSQLText
        GLogRecordCtr = 0
        
        '
        ' Restart the program unless the program is started just now.
        '
        If PMsg <> "Program Start." Then
            If GRestartYN = True Then
                Call Terminate
                Exit Sub
            End If
        End If
    End If
    
    If LTrim(RTrim(PMsg)) <> "" Then
        '
        ' Get maximum seq no.
        '
        On Error Resume Next
        GSQLText = "SELECT MAX(SEQNO) AS GLogRecordCtr FROM Log"
        Set LCountSet = GLocalDB.OpenRecordset(GSQLText)
        If err Then
            GLogRecordCtr = 0
        Else
            GLogRecordCtr = CInt(LCountSet("GLogRecordCtr"))
        End If
        On Error GoTo err
        
        '
        ' Write into log table.
        '
        CurrentTime = Format(Now, "mmm dd, yyyy hh:mm:ss AMPM")
        GLogTable.AddNew
        GLogTable("SeqNo") = GLogRecordCtr + 1
        GLogTable("TimeStamp") = CurrentTime
        GLogTable("Message") = Left(PMsg, 200)
        GLogTable.Update
    End If
    
    GLastLogDate = CurrentDate
    
Exit_WriteLog:
    Exit Sub
err:
    Response = MsgBox("WriteLog() : " & err.Description, vbCritical, "MEDICOM Mail Manager")
    Resume Exit_WriteLog
End Sub
Private Sub SpoolLog(UniqueTimeYN As Boolean, ViewYN As Boolean)
    
    On Error GoTo err
    
    '
    ' Close log table.
    '
    GLogTable.Close
    
    '
    ' Build log name: SMTMLSRV-<DD-MON-YY-HH24-MI-SS>.Log>
    '
    If UniqueTimeYN = True Then
        GLogFileName = "C:\MEDICOM\SMTMLSRV\SMTMLSRV-" & Format(Now, "dd-Mmm-yy-hh-mm-ss-AMPM") & ".Log"
    Else
        GLogFileName = "C:\MEDICOM\SMTMLSRV\SMTMLSRV-" & Format(Now, "dd-Mmm-yy") & ".Log"
    End If
    
    '
    ' Open log file
    '
    Close #1
    Open GLogFileName For Output As 1
    Print #1,
    Print #1, "MEDICOM Solutions Middle East llc"
    Print #1,
    Print #1, Format(Now, "mmm dd, yyyy hh:mm:ss AMPM")
    Print #1,
    Print #1, "                                MEDICOM Mail Manager"
    Print #1,
    Print #1, "----------------------------------------------------------------------------------------------------------------------------------------"
    Print #1, "Time"; Tab(27); "Message"
    Print #1, "----------------------------------------------------------------------------------------------------------------------------------------"
    Print #1,
    
    '
    ' Read log table and spool to file.
    '
    Set GLogTable = GLocalDB.OpenRecordset("Log", dbOpenDynaset)
    GLogTable.MoveFirst
    With GLogTable
        .Sort = "SeqNo"
        Do While Not .EOF
            Print #1, Format(GLogTable!TimeStamp, "mmm dd, yyyy hh:mm:ss AMPM"); Tab(27); GLogTable!Message
            GLogTable.MoveNext
        Loop
    End With
    
    Print #1,
    Print #1, "----------------------------------------------------------------------------------------------------------------------------------------"
    Print #1,
    Print #1, "End of log."
    Close #1
    
    If ViewYN Then
        GRetVal = Shell("C:\PROGRAM FILES\WINDOWS NT\ACCESSORIES\WORDPAD.EXE " & GLogFileName, vbMaximizedFocus)
    End If
    
Exit_SpoolLog:
    Exit Sub
err:
    Exit Sub
End Sub
Private Sub MailTesting()
    Dim LvStr As String
    On Error GoTo err
    
    LvStr = FormatDateTime(Now, vbShortDate) & " " & FormatDateTime(Now, vbShortTime) & ": " & GTestMailSubject
    Call SendMail(GTestMailAddress, GTestMailCcAddress, GTestMailBccAddress, LvStr, GTestMailText, GTestMailAttachment)
    Exit Sub
err:
    If GSuccessYN = False Then
        Response = MsgBox("MailTesting() : " & err.Description, vbCritical, "MEDICOM Mail Manager")
    End If
End Sub
Function GetToken(p_text, p_delimiter, p_token_number)
    l_text = p_text
    For Ctr = 1 To p_token_number
        'MsgBox ("l_text = " & l_text)
        SpacePos = InStr(l_text, p_delimiter)
        tabpos = InStr(l_text, Chr(9))
        delimiterpos = SpacePos
        
        If delimiterpos = 0 Or tabpos < delimiterpos Then
            If tabpos > 0 Then
                delimiterpos = tabpos
            End If
        End If
       
        If delimiterpos = 0 Then
            'Returning the last token
            l_token = l_text
            Exit For
        End If
            
        l_token = Mid(l_text, 1, delimiterpos - 1)
        l_text = Mid(l_text, delimiterpos + 1)
        'MsgBox ("Ctr = " & ctr & Chr(9) & "Token = " & l_token & Chr(9) & "Text = " & l_text)
    Next Ctr
    
    GetToken = l_token
    'MsgBox (GetToken)
   
End Function

