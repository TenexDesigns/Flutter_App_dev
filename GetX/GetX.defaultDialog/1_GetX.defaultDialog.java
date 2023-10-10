The `Get.defaultDialog()` method in GetX provides a simple way to show a dialog with a default design.
  It has several parameters that allow you to customize the appearance and behavior of the dialog.

Here's an example of how you can show a default dialog using GetX:

                       Get.defaultDialog(
                         title: "Dialogue Title",
                         titleStyle: TextStyle(fontSize: 25),
                         middleText: "This is th middle text",
                         middleTextStyle: TextStyle(fontSize: 20),
                         backgroundColor: Colors.amber,
                         radius: 80,
                         textCancel: "Cancel",
                         cancelTextColor: Colors.deepOrange,
                         textConfirm: "Confirm",
                         confirmTextColor: Colors.white,
                         onCancel: (){ Get.back() },
                         onConfirm: (){ print("Gacau");},)



In this example, we have a button that when pressed, shows a default dialog with a title of 'GetX Dialog', a middle text of 'This is a simple GetX dialog', a 'Cancel' button, a 'Confirm' button, and a custom button. The `onCancel` and `onConfirm` callbacks are called when the 'Cancel' and 'Confirm' buttons are pressed, respectively.

Here are the parameters for the `Get.defaultDialog()` method:

- `String title`: The title of the dialog.

- `String middleText`: The middle text of the dialog.

- `String textCancel`: The text of the cancel button.

- `String textConfirm`: The text of the confirm button.

- `Function onCancel`: The callback that is called when the cancel button is pressed.

- `Function onConfirm`: The callback that is called when the confirm button is pressed.

- `List<Widget> actions`: Additional custom actions that are displayed at the bottom of the dialog.

- `bool barrierDismissible`: Whether the dialog can be dismissed by tapping outside the dialog. Default is `true`.

- `Color backgroundColor`: The background color of the dialog.

- `double radius`: The border radius of the dialog.

- `TextStyle titleStyle`: The text style of the title.

- `TextStyle middleTextStyle`: The text style of the middle text.

- `TextStyle cancelTextStyle`: The text style of the cancel button.

- `TextStyle confirmTextStyle`: The text style of the confirm button.

- `Widget cancel`: A custom widget for the cancel button.

- `Widget confirm`: A custom widget for the confirm button.

- `Color buttonColor`: The color of the confirm button.

By using the `Get.defaultDialog()` method, you can easily show dialogs in your Flutter app with a consistent design and customizable options. This makes your code cleaner and easier to read.



CUSTOMISE THE CANCELE AND CONFIRM  BUTTON
------------------------------------------------------------------------------------------------------------------------------------------
   confirm: Text(
        "Confirm",
        style: TextStyle(color: Colors.white),
         ) ,
         cancel: Text(
           "Cancels",
                           style: TextStyle(color: Colors.white),
                         ),
  ....


  
ADD ACTION BUTTON S TO THE DIALOGUE
------------------------------------------------------------------------------------------------------------------------------------------

                           actions:[
                           ElevatedButton(
                               onPressed: (){ Get.back();},
                               child: Text("George")),

                           ElevatedButton(
                               onPressed: (){ print("George");},
                               child: Text("George")),



                         ],
                         barrierDismissible: false

