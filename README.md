# DialogBox

Java Application that consists of a frame with two panels where we can select different 
options to show in dialog box.

We can choose:
Type: type of dialog box ("Message", "Confirm", "Option", "Input").
Type Messages: type of message ("ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE") that changes the icon that is displayed.
Message: content of the message ("String" with the message "message", "Icon", "Component", "Other" which is a date, "Object" which is a combination of all the previous options).
Type Option: kind of confirmation when Type "Confirm" is selected ("DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION").
Option[]: kind of options when Type "Option" is selected ("String", "Icon", "Object").
Input: kind of input when Type "input" is selected ("Input Text", "Combo").
