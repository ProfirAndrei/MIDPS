object FBarGraph: TFBarGraph
  Left = 213
  Top = 129
  Width = 346
  Height = 327
  Caption = 'MIDPS'
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  OldCreateOrder = False
  Position = poDesktopCenter
  OnClose = FormClose
  PixelsPerInch = 96
  TextHeight = 13
  object Label1: TLabel
    Left = 200
    Top = 16
    Width = 90
    Height = 13
    Caption = 'Data si ora curenta'
  end
  object Label2: TLabel
    Left = 32
    Top = 88
    Width = 282
    Height = 16
    Caption = 'Resurse grafice ale mediului C++ Builder'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = [fsBold]
    ParentFont = False
  end
  object PaintBox1: TPaintBox
    Left = 146
    Top = 112
    Width = 169
    Height = 169
    Hint = 'Grafic'
    Color = clCream
    DragMode = dmAutomatic
    ParentColor = False
    ParentShowHint = False
    ShowHint = True
    OnPaint = PaintBox1Paint
  end
  object btnStart: TButton
    Left = 8
    Top = 160
    Width = 75
    Height = 25
    Hint = 'Start'
    Caption = 'Start'
    ParentShowHint = False
    ShowHint = True
    TabOrder = 0
    OnClick = btnStartClick
  end
  object btnStop: TButton
    Left = 8
    Top = 208
    Width = 75
    Height = 25
    Hint = 'Stop'
    Caption = 'Stop'
    Enabled = False
    ParentShowHint = False
    ShowHint = True
    TabOrder = 1
    OnClick = btnStopClick
  end
  object btnExit: TButton
    Left = 8
    Top = 256
    Width = 75
    Height = 25
    Hint = 'Iesire'
    Caption = 'Exit'
    ParentShowHint = False
    ShowHint = True
    TabOrder = 2
    OnClick = btnExitClick
  end
  object Edit1: TEdit
    Left = 200
    Top = 32
    Width = 113
    Height = 21
    Hint = 'Ora si data curenta'
    ParentShowHint = False
    ShowHint = True
    TabOrder = 3
    Text = 'Edit1'
  end
  object Panel1: TPanel
    Left = 96
    Top = 112
    Width = 41
    Height = 169
    Hint = 'Graph Bar'
    Color = clBackground
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clMenuText
    Font.Height = -11
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
    ParentShowHint = False
    ShowHint = True
    TabOrder = 5
  end
  object Panel2: TPanel
    Left = 96
    Top = 112
    Width = 41
    Height = 50
    Hint = 'Graph Bar'
    Color = clTeal
    ParentShowHint = False
    ShowHint = True
    TabOrder = 4
  end
  object Timer1: TTimer
    OnTimer = Timer1Timer
    Left = 40
    Top = 8
  end
  object Timer2: TTimer
    Enabled = False
    Interval = 500
    OnTimer = Timer2Timer
    Left = 40
    Top = 40
  end
end
