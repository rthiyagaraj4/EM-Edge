VERSION 5.00
Begin VB.Form eHISPrint 
   BorderStyle     =   1  'Fixed Single
   Caption         =   "eHIS Print Manager (Version 10.5)"
   ClientHeight    =   2565
   ClientLeft      =   45
   ClientTop       =   330
   ClientWidth     =   6615
   Icon            =   "eHISPrint.frx":0000
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   2565
   ScaleWidth      =   6615
   StartUpPosition =   3  'Windows Default
   Begin VB.TextBox FPrinterPort 
      BackColor       =   &H8000000F&
      BorderStyle     =   0  'None
      BeginProperty Font 
         Name            =   "Verdana"
         Size            =   9
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00800000&
      Height          =   210
      Left            =   3120
      TabIndex        =   4
      Text            =   "FPrinterPort"
      Top             =   4680
      Width           =   3135
   End
   Begin VB.TextBox FDriverName 
      BackColor       =   &H8000000F&
      BorderStyle     =   0  'None
      BeginProperty Font 
         Name            =   "Verdana"
         Size            =   9
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00800000&
      Height          =   210
      Left            =   3120
      TabIndex        =   2
      Text            =   "FDriverName"
      Top             =   3915
      Width           =   3015
   End
   Begin VB.ListBox PrintersList 
      BeginProperty Font 
         Name            =   "Verdana"
         Size            =   9
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00800000&
      Height          =   2370
      Left            =   120
      TabIndex        =   0
      Top             =   3720
      Width           =   2895
   End
   Begin VB.Frame Frame1 
      Height          =   2295
      Left            =   120
      TabIndex        =   6
      Top             =   0
      Width           =   6375
      Begin VB.Timer Close_Timer 
         Left            =   5040
         Top             =   240
      End
      Begin VB.CommandButton Close_but 
         Caption         =   "Close"
         Height          =   375
         Left            =   5160
         TabIndex        =   18
         Top             =   1800
         Width           =   975
      End
      Begin VB.TextBox FFileStatus 
         BackColor       =   &H8000000F&
         BorderStyle     =   0  'None
         BeginProperty Font 
            Name            =   "Arial"
            Size            =   8.25
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         ForeColor       =   &H00FF0000&
         Height          =   210
         Left            =   1560
         TabIndex        =   16
         Text            =   "FFileStatus"
         Top             =   600
         Width           =   2220
      End
      Begin VB.TextBox FFileName 
         BackColor       =   &H8000000F&
         BorderStyle     =   0  'None
         BeginProperty Font 
            Name            =   "Verdana"
            Size            =   8.25
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         ForeColor       =   &H00FF0000&
         Height          =   210
         Left            =   840
         TabIndex        =   12
         Text            =   "FFileName"
         Top             =   360
         Width           =   4620
      End
      Begin VB.TextBox FPrinterName 
         BackColor       =   &H8000000F&
         BorderStyle     =   0  'None
         BeginProperty Font 
            Name            =   "Verdana"
            Size            =   8.25
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         ForeColor       =   &H00FF0000&
         Height          =   210
         Left            =   840
         TabIndex        =   11
         Text            =   "FPrinterName"
         Top             =   960
         Width           =   4500
      End
      Begin VB.TextBox FStatus 
         BackColor       =   &H8000000F&
         BorderStyle     =   0  'None
         BeginProperty Font 
            Name            =   "Arial"
            Size            =   9
            Charset         =   0
            Weight          =   700
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         ForeColor       =   &H000000C0&
         Height          =   495
         Left            =   120
         MultiLine       =   -1  'True
         TabIndex        =   10
         Top             =   1680
         Width           =   4965
      End
      Begin VB.TextBox FPrinterStatus 
         BackColor       =   &H8000000F&
         BorderStyle     =   0  'None
         BeginProperty Font 
            Name            =   "Verdana"
            Size            =   8.25
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         ForeColor       =   &H00FF0000&
         Height          =   200
         Left            =   840
         TabIndex        =   9
         Text            =   "FPrinterStatus"
         Top             =   1440
         Width           =   2500
      End
      Begin VB.TextBox FJobStatus 
         BackColor       =   &H8000000F&
         BorderStyle     =   0  'None
         BeginProperty Font 
            Name            =   "Verdana"
            Size            =   8.25
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         ForeColor       =   &H00FF0000&
         Height          =   200
         Left            =   3600
         TabIndex        =   8
         Text            =   "FJobStatus"
         Top             =   1440
         Width           =   2500
      End
      Begin VB.Image Image1 
         Height          =   510
         Left            =   5640
         Picture         =   "eHISPrint.frx":0BFA
         Top             =   240
         Width           =   420
      End
      Begin VB.Label Label4 
         Caption         =   "Status:"
         BeginProperty Font 
            Name            =   "Arial"
            Size            =   8.25
            Charset         =   0
            Weight          =   700
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         ForeColor       =   &H00800000&
         Height          =   200
         Left            =   840
         TabIndex        =   17
         Top             =   600
         Width           =   660
      End
      Begin VB.Label Label2 
         Caption         =   "Printer"
         BeginProperty Font 
            Name            =   "Verdana"
            Size            =   9
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   195
         Left            =   120
         TabIndex        =   15
         Top             =   960
         Width           =   780
      End
      Begin VB.Label Label7 
         Caption         =   "Printer Status:"
         BeginProperty Font 
            Name            =   "Arial"
            Size            =   8.25
            Charset         =   0
            Weight          =   700
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         ForeColor       =   &H00800000&
         Height          =   195
         Left            =   840
         TabIndex        =   14
         Top             =   1200
         Width           =   1860
      End
      Begin VB.Label Label8 
         Caption         =   "Job Status:"
         BeginProperty Font 
            Name            =   "Arial"
            Size            =   8.25
            Charset         =   0
            Weight          =   700
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         ForeColor       =   &H00800000&
         Height          =   195
         Left            =   3600
         TabIndex        =   13
         Top             =   1200
         Width           =   1020
      End
      Begin VB.Label Label1 
         Caption         =   "File"
         BeginProperty Font 
            Name            =   "Verdana"
            Size            =   9
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   195
         Left            =   120
         TabIndex        =   7
         Top             =   360
         Width           =   1500
      End
   End
   Begin VB.Label Label6 
      Caption         =   "Printer Port"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   9
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00800000&
      Height          =   195
      Left            =   3120
      TabIndex        =   5
      Top             =   4440
      Width           =   1500
   End
   Begin VB.Label Label5 
      Caption         =   "Driver Name"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   9
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00800000&
      Height          =   195
      Left            =   3120
      TabIndex        =   3
      Top             =   3675
      Width           =   1500
   End
   Begin VB.Label Label3 
      Caption         =   "List of printers"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   9
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00800000&
      Height          =   255
      Left            =   120
      TabIndex        =   1
      Top             =   3480
      Width           =   2175
   End
End
Attribute VB_Name = "eHISPrint"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
'Public TMP_FONT_SIZE, FONT_SIZE As String
Public BStatus, UStatus As Boolean


Private Sub Close_but_Click()
    Unload Me
End Sub
Private Sub Close_Timer_Timer()
    Unload Me
End Sub

Private Sub Form_Load()
     
    '
    ' Declare variables
    '
    Dim LVOutFSO As FileSystemObject
    Dim LVErrFSO As FileSystemObject
    Dim LVErrFile As File
    Dim LVCmdSyntax As String
    Dim LVCtr As Integer
    Dim LVErrFileName As String
    Dim LVPrinterName As String
    Dim LVServerName As String
    Dim LVTmpStr As String
    Dim LVPos As Integer
    Dim LVDefaultPrinterName As String
    Dim LVDefaultDriverName As String
    Dim LVDefaultPrinterPort As String
    
    
    On Error Resume Next
    
    '
    ' Initialize.
    '
    FStatus = "Initializing ..."
    
    FFileName = ""
    FPrinterName = ""
    FDriverName = ""
    FPrinterPort = ""
    FPrinterStatus = ""
    FJobStatus = ""
    FStatus = ""
    FFileStatus = ""
    Close_Timer.Enabled = False
    Close_but.Visible = False
    Me.Left = 2500
    Me.Top = 2500
    Me.Height = 2850    '6735
    
    GVServerName = ""
    GVShareName = ""
    GVFunctionName = ""
    GVWorkingDir = ""
    GVCopies = ""
    GVReportType = ""
    GRetValStr = ""
    GVCmdLine = ""
    
    If GTestingYN Then
        '
        ' Set the values for testing.
        '
        Call Testing
    Else

        '
        ' Get command line arguments
        ' Argument 1 - Application Name
        ' Argument 2 - Function Name
        ' Argument 3 - Report File name
        ' Argument 4 - Printer name
        ' Argument 5 - Copies
        ' Argument 6 - Report Type (LOCAL  STANDARD)
        GetCommandLine
        'MsgBox "Command Line = " & GVCmdLine
        
        '
        ' Usage Statement
        '
        LVCmdSyntax = "Invalid Arguments!!!" & vbCrlf
        LVCmdSyntax = LVCmdSyntax & vbCrlf
        LVCmdSyntax = LVCmdSyntax & "Usage:" & vbCrlf
        LVCmdSyntax = LVCmdSyntax & "========" & vbCrlf
        LVCmdSyntax = LVCmdSyntax & "eHISPrint.EXE;Function Name;Report File Name;Printer Name;Num of Copies;Report Type" & vbCrlf
        LVCmdSyntax = LVCmdSyntax & "    Where Report Type=LOCAL for local language reports or STANDARD"
        LVCmdSyntax = LVCmdSyntax & vbCrlf
        LVCmdSyntax = LVCmdSyntax & "Example:" & vbCrlf
        LVCmdSyntax = LVCmdSyntax & "========" & vbCrlf
        LVCmdSyntax = LVCmdSyntax & "eHISPrint.EXE;MPRIDLBL;C:\eHIS\Reports;MPRIDLBL.LIS;\\MEDNET2\Cardialogy Lexmark;2;LOCAL" & vbCrlf & vbCrlf
        LVCmdSyntax = LVCmdSyntax & GVCmdLine
            
        '
        ' Get report method
        ' B = Batch Method
        ' O = Online Method (Default)
        '
        If Len(GVReportMethod) = 0 Then
            GVReportMethod = GArgArray(8)
            If Len(GVReportMethod) = 0 Then
                GVReportMethod = "O"
            End If
        End If
        
        If GVReportMethod = "B" Then
            Me.Visible = False
        End If
            
        '
        ' Get function name
        '
        If Len(GVFunctionName) = 0 Then
            GVFunctionName = GArgArray(2)
            If Len(GVFunctionName) = 0 Then
                MsgBox LVCmdSyntax, vbCritical, "eHIS Print Manager - FunctionName Missing"
                FStatus = "Invalid Command!!"
                GoTo Log_Error
            End If
        End If
        
        '
        ' Get reporrs dir path
        '
        If Len(GVWorkingDir) = 0 Then
            GVWorkingDir = GArgArray(3)
            If Len(GVWorkingDir) = 0 Then
                MsgBox LVCmdSyntax, vbCritical, "eHIS Print Manager - ReportsDir Missing"
                FStatus = "Invalid Command!!"
                GoTo Log_Error
            End If
        End If
        
        
        '
        ' Get report file name
        '
        If Len(FFileName) = 0 Then
            FFileName = GArgArray(4)
            GVFilename = FFileName 'Added by Anil on 18/02/10 for identifying zpl reports
            If Len(FFileName) = 0 Then
                MsgBox LVCmdSyntax, vbCritical, "eHIS Print Manager - FileName Missing"
                FStatus = "Invalid Command!!"
                GoTo Log_Error
            End If
        End If
        
        '
        ' Get printer name
        '
        If Len(FPrinterName) = 0 Then
            FPrinterName = GArgArray(5)
            If Len(FPrinterName) = 0 Then
                MsgBox LVCmdSyntax, vbCritical, "eHIS Print Manager - PrintName Missing"
                GoTo Log_Error
            End If
        End If
        
        '
        ' Get number of copies
        '
        If GVCopies = 0 Then
            GVCopies = GArgArray(6)
            If GVCopies = 0 Then
                GVCopies = 1
            End If
        End If
        
        '
        ' Get report type
        ' LOCAL=Local language report (Arabic)
        ' STANDARD=Standard report (Not containing local language)
        '
        If Len(GVReportType) = 0 Then
            GVReportType = GArgArray(7)
            If Len(GVReportType) = 0 Then
                MsgBox LVCmdSyntax, vbCritical, "eHIS Print Manager - PrintName Missing"
                GoTo Log_Error
            End If
        End If
        
    End If
    
    '
    ' In Working Dir,
    '   remove the "\" at end, if exists.
    '
    If Right(GVWorkingDir, 1) = "\" Then
        GVWorkingDir = Mid(GVWorkingDir, 1, Len(GVWorkingDir) - 1)
    End If
    
    '
    ' Remove error log file (FunctionName.Err) if exists.
    '
    Err.Clear
    LVErrFileName = GVWorkingDir & "\" & GVFunctionName & ".Err"
    Set LVErrFSO = New FileSystemObject
    Set LVErrFile = LVErrFSO.GetFile(LVErrFileName)
    LVErrFile.Delete
    
    '
    ' Open File
    '
    Err.Clear
    FStatus = "Opening file ..."
    FFileStatus = "OK"
    Close #1
    If InStr(FFileName, "\") = 0 Then ' If FileName is NOT with PATH.
        FFileName = GVWorkingDir & "\" & FFileName
    End If
    Open FFileName For Input As #1
    If Err Then
        FFileStatus = Err.Description
        FStatus = "Cannot open " & FFileName & ". " & FFileStatus
        GoTo Log_Error
    End If
    
    '
    ' Capture the default printer's attributes for later usage.
    '
    LVDefaultPrinterName = Printer.DeviceName
    LVDefaultDriverName = Printer.DriverName
    LVDefaultPrinterPort = Printer.Port
    
    '
    ' Validate Printer.
    '
    Err.Clear
    FStatus = "Validating printer ..."
    FStatus = ValidatePrinter
    If FStatus <> "Success" Then
        GoTo Log_Error
    End If
        
    '
    ' Set this printer default
    '
    SetDefaultPrinter FPrinterName, FDriverName, FPrinterPort
    
    '
    ' Manipulate printername if port name like "LPT%"
    '
    If InStr(1, FPrinterName, "\\") = 0 Then        '
        ' Get the computer (server) name and
        ' concatenate with printer share name.
        '
        LVPrinterName = FPrinterPort
        'Following lines has been comented by
        'Nanjayan on 14-04-2003
        'Since the local printer is not taking the
        '\\server name\share name

        'LVTmpStr = Mid(FPrinterName, 3)
        'LVPos = InStr(1, LVTmpStr, "\")
        'LVServerName = Left(LVTmpStr, LVPos - 1)
        'LVPrinterName = "\\" & LVServerName & "\" & GVShareName
    Else
        LVPrinterName = GVServerName & "\" & GVShareName
    End If
    'MsgBox LVPrinterName
    
    '
    ' Do printing.
    '
    FStatus = "Opening printer ... " & GVCopies
    Err.Clear
    For LVCtr = 1 To GVCopies
        FStatus = "Printing Copy(" & LVCtr & ") ..."
        'MsgBox FFileName & " " & LVPrinterName
        
        If UCase(GVReportType) = "LOCAL" Then
            '
            ' Local language report.
            ' Call PrintDocument function to read line by line and print
            '
            LVTmpStr = PrintDocument
        Else
            '
            ' Standard report (not containing any local language characters)
            ' Print directly to printer.
            '
            Set LVOutFSO = New FileSystemObject
            LVTmpStr = "Success"
            LVOutFSO.CopyFile FFileName, LVPrinterName
            If Err Then
                LVTmpStr = Err.Description
            End If
        End If
        
        If LVTmpStr <> "Success" Then
            FStatus = "Printing Failed!! - " & LVTmpStr
            GoTo Log_Error
        Else
            FStatus = "Printing Successful."
        End If
        
        '
        ' Re-open the file
        '
        LVOperation = "ReopenFile"
        Close #1
        Open FFileName For Input As #1

    Next LVCtr

    '
    ' Re-open the file
    '
    LVOperation = "CloseFile"
    Close #1
    
    '
    ' Reset the default printer.
    '
    SetDefaultPrinter LVDefaultPrinterName, LVDefaultDriverName, LVDefaultPrinterPort
    
    If GVReportMethod <> "B" Then
        '
        ' Enable "Close" timer.
        ' For 1 second, set the interval to 1000.
        ' Set the interval for 2 seconds.
        '
        Close_Timer.Enabled = True
        Close_Timer.Interval = 2000
    Else
        Close_Timer.Enabled = True
        Close_Timer.Interval = 1        ' To close the form immediately.
    End If
    
    '
    ' Exit Sub
    '
    Exit Sub
    
Log_Error:
    '
    ' Reset the default printer.
    '
    SetDefaultPrinter LVDefaultPrinterName, LVDefaultDriverName, LVDefaultPrinterPort
    
    '
    ' Write error message into error log file.
    '
    Close #9
    Open LVErrFileName For Output As #9
    Print #9, FStatus
    Close #9
    If GVReportMethod <> "B" Then

        '
        ' Show close button.
        '
        Close_but.Visible = True
        Close_but.Enabled = True
        
        '
        ' Exit Sub
        '
        Exit Sub
    Else
        Close_Timer.Enabled = True
        Close_Timer.Interval = 1        ' To close the form immediately.
    End If
End Sub
Private Function PrintDocument() As String
    
    '
    ' Declare variables.
    '
    Dim LVCtr As Long
    Dim LVCurrPos As Integer
    Dim LVCurrChar As String
    Dim LVAscOfCurrChar As String
    Dim LVOperation As String
    Dim LVTextLine As String
    Dim LVFormattedTextLine As String
    Dim LVSkipPageYN As Boolean
    Dim LVIsAControlCharacter As Boolean
    Dim LVControlCharSeqStartPos As Integer
    Dim BOLD, UBOLD, ULINE, RUNLINE, PITCH, UNPITCH As String
    Dim LVCtrlChar As String
    Dim TMP_FONT_SIZE, FONT_SIZE As String
    
    Dim tmp1, tmp2 As String
    
    Dim l_barcode_flag As String
    
    Dim l_zplprint As String
    
    On Error GoTo Err_PrintDocument
    
    '
    ' Initialize
    '
    LVOperation = "Initialize"
    PrintDocument = "Success"
    LVCtr = 0
    
    BOLD = "(s3B"
    UBOLD = "(s-3B"
    ULINE = "&d0D"
    RUNLINE = "&d@"
    PITCH = "(s"
    BStatus = False
    UStatus = False
    
    
    '
    ' Set printer properties.
    '
    LVOperation = "SetPrinter"
    Printer.Orientation = 1             ' Portrait
    Printer.Font = GVFontname
    Printer.FontSize = 9.14
    
    '
    ' Do printing.
    ' Read line by line and print.
    '
    LVOperation = "DoPrint"
    Do While Not EOF(1)
        ' Initialize
        
        LVCtr = LVCtr + 1               ' Increment line counter.
        LVSkipPageYN = False
        
        ' Read the line
        Line Input #1, LVTextLine
        
        'Added by anil on 17/02/10.
        l_zplprint = "N"
        If InStr(UCase(GVFilename), ".ZPL") > 0 Then
            l_zplprint = "E"
            If InStr(LVTextLine, "<STX>H") > 0 Or InStr(LVTextLine, "<STX>B") > 0 Then
                   
                l_zplprint = "Y"
                   
                If InStr(LVTextLine, "<STX>B") > 0 Then
                    'Printer.FontName = "Code 39"
                    'Printer.FontName = "Code128bWin"
                    'Modified by DhanasekarV as per Anil and srinvasRao instructions
                    Printer.FontName = "Code128bWinLarge"
                    Printer.FontSize = 14
                    'LVTextLine = code128b(LVTextLine)
                    l_barcode_flag = "Y"
                Else
                    Printer.FontName = GVLblFontname
                    Printer.FontSize = 8
                    'Printer.
                    
                    If InStr(LVTextLine, ";c26;") > 0 Then
                        Printer.FontBold = True
                    Else
                        Printer.FontBold = False
                    End If
                    l_barcode_flag = "N"
               End If
                
                
                tmp1 = Mid(LVTextLine, InStr(LVTextLine, ";d3,") + 4)
                
                If InStr(tmp1, "<ETX>") > 0 Then
                    tmp2 = Mid(tmp1, 1, InStr(tmp1, "<ETX>") - 1)
                Else
                    tmp2 = tmp1
                End If
                ' modified by DhanasekarV to trim * from  *specimen* on 07/02/2012
                If InStr(LVTextLine, "<STX>B") > 0 Then
                    tmp2 = Replace(tmp2, "*", " ")
                    tmp2 = Trim(tmp2)
                End If
                
                LVTextLine = tmp2
            End If
        End If
        
        
        If l_zplprint = "N" Or l_zplprint = "Y" Then
            
        '
        ' Interpret the control characters.
        ' Chr(27) = Start character of control characters sequence.
        '
        If InStr(1, LVTextLine, Chr(27)) > 0 Then
        
            '
            ' Check the layout (portrait / landscape) of the report.
            ' and set the layout accordingly.
            ' This check is required only for the first line
            ' of the report.
            ' &l1O=Landscape (ampersand el one Oh)
            ' &l0O=Portrait  (ampersand el zero Oh)
            '
            
            If LVCtr = 1 Then
                If InStr(1, LVTextLine, "&l1O") > 0 Then
                    Printer.Orientation = 2 ' Landscape
                End If
                If Printer.Orientation = 1 Then     ' Extra 2 blank lines for portait reports
                    Printer.Print vbCrlf
                    Printer.Print vbCrlf
                End If
                '
                ' Check the alignment (Left to Right / Right to Left).
                ' and set the alignment accordingly.
                ' This check is done on first line of the report.
                ' #$%R=Right To Left (Ash Dollar Percentage R-capital)
                ' Else Left To Right
                '
 
                If InStr(1, LVTextLine, "#$%R") > 0 Then
                   Printer.RightToLeft = True
                Else
                    Printer.RightToLeft = False
                End If
            End If
        
            '
            ' Check for PAGESKIP (chr(12)) character.
            '
            If InStr(1, LVTextLine, Chr(12)) > 0 And Not EOF(1) Then
                '
                ' We assume end of report is marked by string END OF REPORT.
                '
                ' If PAGESKIP is given at the end (END OF REPORT),
                '   Do not skip the page.
                ' Else
                '   Skip the page.
                '
                LVTmpStr = LVTextLine
                LVTmpStr = UCase(Replace(LVTmpStr, " ", "", 1))
                
                
                If InStr(1, LVTmpStr, "ENDOFREPORT") = 0 Then
                    LVSkipPageYN = True
                End If
            
            End If
        
            '
            ' Remove control characters.
            '
            
            LVFormattedTextLine = ""
            For pos = 1 To Len(LVTextLine)
                LVCurrChar = Mid(LVTextLine, pos, 1)
                LVAscOfCurrChar = Asc(LVCurrChar)
                
                If LVAscOfCurrChar = 27 Then
                    LVIsAControlCharacter = True
                    LVCtrlChar = ""
                    LVControlCharSeqStartPos = pos
                End If
                
                If Not LVIsAControlCharacter Then
                    LVFormattedTextLine = LVFormattedTextLine & LVCurrChar
                End If
                
                'MsgBox CurrChar & "  - " & Asc(CurrChar) & Chr(10) & "t = " & t & Chr(10) & "LVControlCharSeqStartPos = " & LVControlCharSeqStartPos
                If LVControlCharSeqStartPos > 0 Then
                    If LVAscOfCurrChar >= 64 And LVAscOfCurrChar < 91 Then
                        LVCtrlChar = LVCtrlChar & LVCurrChar
                        'This is for Setting Font Size
                        PITCH = PITCH & LVCurrChar
                      '  MsgBox LVCtrlChar
                      '  MsgBox BOLD
                        If LVCtrlChar = BOLD Then
                            LVFormattedTextLine = LVFormattedTextLine & Chr(18)
                            PITCH = "(s"
                            TMP_FONT_SIZE = ""
                        ElseIf LVCtrlChar = UBOLD Then
                            LVFormattedTextLine = LVFormattedTextLine & Chr(18)
                            PITCH = "(s"
                            TMP_FONT_SIZE = ""
'                        ElseIf LVCtrlChar = ULINE Then
'                            LVFormattedTextLine = LVFormattedTextLine & Chr(17)
'                            PITCH = "(s"
'                            TMP_FONT_SIZE = ""
'                        ElseIf LVCtrlChar = RUNLINE Then
'                            LVFormattedTextLine = LVFormattedTextLine & Chr(17)
'                            PITCH = "(s"
'                            TMP_FONT_SIZE = ""
                        ElseIf LVCtrlChar = PITCH Then
                            'MsgBox PITCH, , "Inside_Pitch"
                            FONT_SIZE = TMP_FONT_SIZE
                            TMP_FONT_SIZE = ""
                            LVFormattedTextLine = LVFormattedTextLine & Chr(14) & FONT_SIZE & Chr(15)
                            PITCH = "(s"
                        End If
                        
                        LVControlCharSeqStartPos = 0
                        LVIsAControlCharacter = False
                    Else
                        If LVAscOfCurrChar <> 27 Then
                            If LVAscOfCurrChar >= 48 And LVAscOfCurrChar <= 57 Then
                               'MsgBox PITCH, , "PICH_APPEND"
                               PITCH = PITCH & LVCurrChar
                               If Len(PITCH) > 2 Then
                                    TMP_FONT_SIZE = TMP_FONT_SIZE & LVCurrChar
                               End If
                            End If
                            LVCtrlChar = LVCtrlChar & LVCurrChar
                        End If
                    End If
                End If
            Next pos
            
           
        Else
            '
            ' There is no control character in the current line.
            ' Hence, just assign whatever is read, to formatted text line.
            '
            LVFormattedTextLine = LVTextLine
            
            '
            ' Check for PAGESKIP (chr(12)) character.
            '
            If InStr(1, LVTextLine, Chr(12)) > 0 And Not EOF(1) Then
                '
                ' We assume end of report is marked by string END OF REPORT.
                '
                ' If PAGESKIP is given at the end (END OF REPORT),
                '
                '   do not skip the page.
                ' else
                '   skip the page.
                '
                LVTmpStr = LVFormattedTextLine
                LVTmpStr = UCase(Replace(LVTmpStr, " ", "", 1))
                
                
                If InStr(1, LVTmpStr, "ENDOFREPORT") = 0 Then
                    LVSkipPageYN = True
                End If
                
            End If
        End If
        
        '
        ' Remove PAGESKIP (Chr(12)) from the formatted line.
        ' Otherwise Chr(12) (a box) will get printed.
        '
        LVFormattedTextLine = Replace(LVFormattedTextLine, Chr(12), "", 1)
        
        '
        ' Print the formatted line to the printer.
        '
        ' For Portrait reports, insert 6 spaces for each line.
        If Printer.Orientation = 1 Then
            'LVFormattedTextLine = "        " & LVFormattedTextLine
            
            If l_barcode_flag = "Y" Then
                'LVFormattedTextLine = Chr(32) + LVFormattedTextLine
                'LVFormattedTextLine = code128b(LVFormattedTextLine)
                LVFormattedTextLine = Chr(32) + code128b(LVFormattedTextLine)
                l_barcode_flag = "N"
            Else
                LVFormattedTextLine = Chr(32) + Chr(32) + LVFormattedTextLine
            End If
        End If
        
        'LVFormattedTextLine = Replace(LVFormattedTextLine, Chr(20), "", 1)
        'LVFormattedTextLine = ":" & LVFormattedTextLine
        
        'Printer.Print LVFormattedTextLine
        RemoveSplChr20AndPrint (LVFormattedTextLine)
        
        'MsgBox LVFormattedTextLine
        
        '
        ' Skip page.
        '
        If LVSkipPageYN And LVCtr <= 1 Then
            Printer.Print vbCrlf
            Printer.Print vbCrlf
        ElseIf LVSkipPageYN And LVCtr > 5 Then
            Printer.NewPage ' Skip the page.
            '
            ' Insert 2 blank lines (top margin).
            ' This should be removed during phase 2.
            ' That is, when we interpret all control characters
            ' and take action accordingly.
            '
            Printer.Print vbCrlf
            Printer.Print vbCrlf
            If Printer.Orientation = 1 Then     ' Extra 2 blank lines for portait reports
                Printer.Print vbCrlf
                Printer.Print vbCrlf
            End If
         End If
        End If
    Loop 'Do While Not EOF(1)
    
    'TstPrint
    '
    ' Inform printer that printing is over.
    '
    LVOperation = "EndPrint"
    Printer.EndDoc
    
    '
    ' Exit
    '
    Exit Function
    
Err_PrintDocument:
    PrintDocument = Err.Description
    Exit Function
End Function
'Private Sub RemoveSplChr20AndPrint(StrToPrint As String)
'Dim i, pos, start, bpos, bpod, min As Integer
'Dim print_str As String
'start = 1
'
'
'Do While Len(StrToPrint) > 0
'    pos = InStr(start, StrToPrint, Chr(20))
'    bpos = InStr(start, StrToPrint, Chr(19))
'    bpod = InStr(start, StrToPrint, Chr(18))
'
'    If pos < bpos Then
'       If pos < bpod Then
'        min = pos
'       End If
'    End If
'    If bpos < pos Then
'       If bpos < bpod Then
'        min = bpos
'       End If
'    End If
'    If bpod < bpos Then
'       If bpod < pos Then
'        min = bpod
'       End If
'    End If
'
'    If pos < bpos Then
'     print_str = Mid(StrToPrint, start, pos - start)
'     Printer.Print print_str; " "
'     start = pos + 1
'     StrToPrint = Mid(StrToPrint, start)
'    Else
'     print_str = Mid(StrToPrint, start, bpos - start)
'     Printer.Print print_str; " "
'     Printer.Font.BOLD = True
'     start = bpos + 1
'     StrToPrint = Mid(StrToPrint, start)
'    End If
'
'
'
'
'        If bpos <> 0 Then
'        Printer.Font.BOLD = True
'        End If
'    Printer.Print Mid(StrToPrint, start, pos - start); " ";
'    start = pos + 1
'    pos = InStr(start, StrToPrint, Chr(20))
'Loop
'FrmtPrintStr = FrmtPrintStr & Mid(StrToPrint, start)
'Printer.Print FrmtPrintStr
'Printer.Print ""
'
'End Sub

Private Sub RemoveSplChr20AndPrint(StrToPrint As String)
Dim i, pos, Start  As Integer
Dim FLAG, Pflag As Boolean
Dim FSIZE, FrmtPrintStr As String
Dim print_str As String

FLAG = False
Pflag = False
Start = 1

FrmtPrintStr = StrToPrint

pos = InStr(Start, StrToPrint, Chr(20))
Do While pos <> 0
    FrmtPrintStr = Mid(StrToPrint, Start, pos - Start)
    Strpitch (FrmtPrintStr)
    'Printer.Print FrmtPrintStr; " ";
    Start = pos + 1
    pos = InStr(Start, StrToPrint, Chr(20))
'MsgBox FrmtPrintStr
Loop
FrmtPrintStr = Mid(StrToPrint, Start)
Strpitch (FrmtPrintStr)
'Printer.Print FrmtPrintStr
Printer.Print ""

'For i = 1 To Len(FrmtPrintStr)
'    If Mid(FrmtPrintStr, i, 1) = Chr(20) Then
'            MsgBox print_str, , "Chr(20)"
'            Printer.Print print_str; " "
'            print_str = Chr(0)
'            Printer.Print vbCr
'    ElseIf Mid(FrmtPrintStr, i, 1) = Chr(18) Then
'            MsgBox print_str, , "Bold Start"
'            Printer.Print print_str
'            print_str = Chr(0)
'        Printer.Font.BOLD = True
'    ElseIf Mid(FrmtPrintStr, i, 1) = Chr(19) Then
'            MsgBox print_str, , "Bold End"
'            Printer.Print print_str
'            print_str = Chr(0)
'        Printer.Font.BOLD = False
'    ElseIf Mid(FrmtPrintStr, i, 1) = Chr(16) Then
'        Printer.Font.Underline = True
'    ElseIf Mid(FrmtPrintStr, i, 1) = Chr(17) Then
'        Printer.Font.Underline = False
'    ElseIf Mid(FrmtPrintStr, i, 1) = Chr(14) Then
'            If FLAG = False Then
'                FLAG = True
'            Else
'               FLAG = False
'            End If
'            If FLAG = False And Mid(FrmtPrintStr, i, 1) = Chr(14) Then
'                'Changing Font Size dynamically..
'                    MsgBox print_str, , "Char Compress"
'                    Printer.Print print_str
'                    print_str = Chr(0)
'                'Printer.FontSize = FSIZE
'                FSIZE = ""
'            End If
'     Else
'        If FLAG = True And Mid(FrmtPrintStr, i, 1) <> Chr(14) Then
'            FSIZE = FSIZE & Mid(FrmtPrintStr, i, 1)
'        End If
'        If FLAG = False Then
'                print_str = print_str & Mid(FrmtPrintStr, i, 1)
'            'Printer.Print Mid(FrmtPrintStr, i, 1);
'        End If
'    End If
'Next i
'    MsgBox print_str, , "End page"
'    Printer.Print print_str
''Printer.Print ""

End Sub
Private Sub Strpitch(StrToPitch As String)
Dim i, pos1, pos2, Start As Integer
Dim FrmtPrintStr, fntsize As String

Start = 1
pos1 = InStr(Start, StrToPitch, Chr(14))
Do While pos1 <> 0
    pos2 = InStr(Start, StrToPitch, Chr(15))
    'MsgBox StrToPitch
    fntsize = Mid(StrToPitch, pos1 + 1, pos2 - (pos1 + 1))
    FrmtPrintStr = Mid(StrToPitch, Start, pos1 - Start)
    
    If InStr(1, FrmtPrintStr, Chr(18)) <> 0 And InStr(1, FrmtPrintStr, Chr(17)) <> 0 Then
        StrBold (FrmtPrintStr)
    ElseIf InStr(1, FrmtPrintStr, Chr(18)) <> 0 Then
        StrBold (FrmtPrintStr)
    'ElseIf InStr(1, FrmtPrintStr, Chr(17)) Then
    '    StrUnderline (FrmtPrintStr)
    Else
        Printer.Print FrmtPrintStr; " ";
    End If

    If fntsize = "14" Then
       fntsize = "9"
    ElseIf fntsize = "12" Then
       fntsize = "10"
    ElseIf fntsize = "10" Then
       fntsize = "12"
    ElseIf fntsize = "8" Then
       fntsize = "14"
    End If
    
    Printer.FontSize = fntsize
    Start = pos2 + 1
    pos1 = InStr(Start, StrToPitch, Chr(14))
Loop
    FrmtPrintStr = Mid(StrToPitch, Start)
    If InStr(1, FrmtPrintStr, Chr(18)) <> 0 And InStr(1, FrmtPrintStr, Chr(17)) <> 0 Then
        StrBold (FrmtPrintStr)
    ElseIf InStr(1, FrmtPrintStr, Chr(18)) <> 0 Then
        StrBold (FrmtPrintStr)
    'ElseIf InStr(1, FrmtPrintStr, Chr(17)) Then
    '    StrUnderline (FrmtPrintStr)
    Else
        Printer.Print FrmtPrintStr; " ";
    End If
End Sub
Private Sub StrBold(StrToBold As String)
Dim i, pos1, pos2, Start As Integer
Dim FrmtPrintStr As String

Start = 1
pos1 = InStr(Start, StrToBold, Chr(18))
Do While pos1 <> 0
    'pos2 = InStr(Start, StrToBold, Chr(19))
    FrmtPrintStr = Mid(StrToBold, Start, pos1 - Start)
    If BStatus = False Then
            'If InStr(1, FrmtPrintStr, Chr(17)) <> 0 Then
            '    StrUnderline (FrmtPrintStr)
            'Else
                Printer.Print FrmtPrintStr; " ";
            'End If
        Printer.Font.BOLD = True
        BStatus = True
        'MsgBox BStatus
    Else
        Printer.Print FrmtPrintStr; " ";
        Printer.Font.BOLD = False
        BStatus = False
    End If
    Start = pos1 + 1
    pos1 = InStr(Start, StrToBold, Chr(18))
Loop
FrmtPrintStr = Mid(StrToBold, Start)
    'If InStr(1, FrmtPrintStr, Chr(17)) <> 0 Then
    '    StrUnderline (FrmtPrintStr)
    'Else
        Printer.Print FrmtPrintStr; " ";
    'End If
End Sub
Private Sub StrUnderline(StrToUnline As String)
Dim i, pos1, pos2, Start As Integer
Dim FrmtPrintStr As String

Start = 1
pos1 = InStr(Start, StrToUnline, Chr(17))
Do While pos1 <> 0
    'pos2 = InStr(Start, StrToUnline, Chr(17))
    FrmtPrintStr = Mid(StrToUnline, Start, pos1 - Start)
    If UStatus = False Then
        Printer.Print FrmtPrintStr; " ";
        Printer.Font.Underline = True
        UStatus = True
        'MsgBox BStatus
    Else
        Printer.Print FrmtPrintStr; " ";
        Printer.Font.Underline = False
        UStatus = False
    End If
    Start = pos1 + 1
    pos1 = InStr(Start, StrToUnline, Chr(17))
Loop
FrmtPrintStr = Mid(StrToUnline, Start)
Printer.Print FrmtPrintStr; " ";
End Sub

Private Sub TstPrint()
    Printer.Font.Size = 14
    Printer.Print "Testing with Arial size 14";
    Printer.Font.Size = 5
    Printer.Font.BOLD = True
    Printer.Print "Testing with Arial size 5";
    Printer.Font.Size = 14
    Printer.ForeColor = vbBlack
    Printer.Print "Black";
    Printer.ForeColor = vbWhite
    Printer.Print "White";
    Printer.ForeColor = vbBlack
    Printer.Print "Black"
End Sub

Private Sub PrintersList_Click()
   FPrinterName = PrintersList.Text
End Sub
Public Function ValidatePrinter() As String
   Dim hPrinter As Long
   Dim ByteBuf As Long
   Dim BytesNeeded As Long
   Dim PI2 As PRINTER_INFO_2
   Dim JI2 As JOB_INFO_2
   Dim PrinterInfo() As Byte
   Dim JobInfo() As Byte
   Dim result As Long
   Dim LastError As Long
   Dim tempStr As String
   Dim NumJI2 As Long
   Dim pDefaults As PRINTER_DEFAULTS
   Dim i As Integer
   
  
   'Set a default return value if no errors occur.
   ValidatePrinter = "Success"
   FPrinterStatus = ""
   FJobStatus = ""
   
   'Set desired access security setting.
   pDefaults.DesiredAccess = PRINTER_ACCESS_USE
   
   'Call API to get a handle to the printer.
   result = OpenPrinter(FPrinterName, hPrinter, pDefaults)
   If result = 0 Then
      'If an error occurred, display an error and exit sub.
      'sMsg = MessageText(Err.LastDllError)
      ValidatePrinter = "Cannot open printer " & FPrinterName & ". " & MessageText(Err.LastDllError)
      Exit Function
   End If

   'Init BytesNeeded
   BytesNeeded = 0

   'Clear the error object of any errors.
   Err.Clear

   'Determine the buffer size that is needed to get printer info.
   result = GetPrinter(hPrinter, 2, 0&, 0&, BytesNeeded)
   
   'Check for error calling GetPrinter.
   If Err.LastDllError <> ERROR_INSUFFICIENT_BUFFER Then
      'Display an error message, close printer, and exit sub.
      ValidatePrinter = "Couldn't allocate buffer for Printer Info"
      ClosePrinter hPrinter
      Exit Function
   End If
   
   ReDim PrinterInfo(1 To BytesNeeded)
   
   ByteBuf = BytesNeeded
   
   'Call GetPrinter to get the status.
   result = GetPrinter(hPrinter, 2, PrinterInfo(1), ByteBuf, BytesNeeded)
   
   'Check for errors.
   If result = 0 Then
      'Display error message, close printer, and exit sub.
      ValidatePrinter = "Couldn't get Printer Status! " & MessageText(Err.LastDllError)
      ClosePrinter hPrinter
      Exit Function
   End If

   'Copy contents of printer status byte array into a
   'PRINTER_INFO_2 structure to separate the individual elements.
   CopyMemory PI2, PrinterInfo(1), Len(PI2)
   
   'Check if printer is in ready state.
   FPrinterStatus = CheckPrinterStatus(PI2.Status)
   
   ' Assign DriverName and PortName
   FDriverName = GetString(PI2.pDriverName)
   FPrinterPort = GetString(PI2.pPortName)
   GVShareName = GetString(PI2.pShareName)
   GVServerName = GetString(PI2.pServerName)
   
   'Call API to get size of buffer that is needed.
   result = EnumJobs(hPrinter, 0&, &HFFFFFFFF, 2, ByVal 0&, 0&, BytesNeeded, NumJI2)
   
   'Check if there are no current jobs, and then display appropriate message.
   If BytesNeeded = 0 Then
      FJobStatus = "No Print Jobs!"
   Else
      FJobStatus = "Pending Print Jobs!"
   End If
   
   'Close the printer handle.
   ClosePrinter hPrinter
End Function

Private Sub SetDefaultPrinter(ByVal PrinterName As String, _
    ByVal DriverName As String, ByVal PrinterPort As String)
    Dim DeviceLine As String
    Dim r As Long
    Dim l As Long
    DeviceLine = PrinterName & "," & DriverName & "," & PrinterPort
    ' Store the new printer information in the [WINDOWS] section of
    ' the WIN.INI file for the DEVICE= item
    r = WriteProfileString("windows", "Device", DeviceLine)
    ' Cause all applications to reload the INI file:
    l = SendMessage(HWND_BROADCAST, WM_WININICHANGE, 0, "windows")
End Sub
Private Sub Testing()
    GVFunctionName = "MPRRLRGS"
   ' FFileName = "C:\eHIS\Reports\MPRRLRGS.LIS"
    FFileName = "C:\eHIS\Reports\RLRSPCLB.ZPL"
    FPrinterName = "\\CGanesan\HPLaserJ1200"
    FPrinterName = "\\HL7TEST\HPLaserJ"
    FPrinterName = "\\MEDNET2\Lexmark_Mktg"
    FPrinterName = "\\CHANDRA\NRGP6216"
    FPrinterName = "\\MEDNET2\Lexmark_VC"
    FPrinterName = "\\MEDNET2\Lexmark_R&D"
    FPrinterName = "\\CGANESAN\HP LaserJet 1200 Series PCL 6"
    GVCopies = 1
   
      
    '
    ' Add printers list for testing.
    '
    PrintersList.Clear
    PrintersList.AddItem "\\MEDNET2\Lexmark_R&D"
    PrintersList.AddItem "\\MEDNET2\Lexmark_110"
    PrintersList.AddItem "\\MEDNET2\Lexmark110"
    PrintersList.AddItem "\\MEDNET2\Lexmark_210"
    PrintersList.AddItem "\\MEDNET2\Lexmark460"
    PrintersList.AddItem "\\MEDNET2\Lexmark_VC"
  
End Sub

