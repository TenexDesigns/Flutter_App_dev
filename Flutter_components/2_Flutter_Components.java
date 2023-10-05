Flutter components are the building blocks of Flutter apps. They are used to create the user interface, add functionality, and handle user interaction.

There are many different types of Flutter components, including:

* **Containers:** Containers are used to organize and layout other components. Common containers include the `Column`, `Row`, `Stack`, and `Card` widgets.
* **Inputs:** Inputs are used to allow users to interact with the app. Common input widgets include the `TextField`, `Checkbox`, and `Radio` widgets.
* **Buttons:** Buttons are used to allow users to trigger actions. Common button widgets include the `RaisedButton`, `FlatButton`, and `IconButton` widgets.
* **Text:** Text components are used to display text to the user. Common text widgets include the `Text`, `RichText`, and `TextFormField` widgets.
* **Images:** Image components are used to display images to the user. Common image widgets include the `Image` and `CachedImage` widgets.
* **Icons:** Icon components are used to display icons to the user. Common icon widgets include the `Icon` and `IconButton` widgets.
* **Progress indicators:** Progress indicators are used to show the user that the app is working on something. Common progress indicator widgets include the `CircularProgressIndicator` and `LinearProgressIndicator` widgets.
* **Dialogs:** Dialogs are used to display information to the user or to get input from the user. Common dialog widgets include the `AlertDialog`, `SimpleDialog`, and `BottomSheet` widgets.
* **Menus:** Menus are used to provide the user with a list of options. Common menu widgets include the `PopupMenuButton` and `AppBar` widgets.

In addition to the built-in Flutter components, there are also a number of third-party components available. These components can be used to add additional functionality to your Flutter apps.

To use a component in your Flutter app, you simply need to add it to your widget tree. The widget tree is the hierarchy of widgets that make up your app's user interface.

Here is an example of a simple Flutter app that uses a number of different components:

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('MyApp'),
        ),
        body: Column(
          children: <Widget>[
            Text('Hello, world!'),
            TextField(),
            RaisedButton(
              onPressed: () {},
              child: Text('Submit'),
            ),
          ],
        ),
      ),
    );
  }
}
```

This app uses the following components:

* `MaterialApp`: This component is the root of all Flutter apps. It provides a number of services, such as theme management and routing.
* `Scaffold`: This component provides a basic layout for Flutter apps. It includes an app bar, body, and bottom navigation bar.
* `AppBar`: This component provides a title bar for Flutter apps.
* `Column`: This component is used to arrange widgets vertically.
* `Text`: This component is used to display text.
* `TextField`: This component allows users to enter text.
* `RaisedButton`: This component is a raised button that can be used to trigger actions.

This is just a simple example of how to use Flutter components. For more information, please see the Flutter documentation: https://docs.flutter.dev/ui/widgets.
