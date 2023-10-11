For responsive design in Flutter, you can use the Wrap widget in conjunction with the FractionallySizedBox widget. The FractionallySizedBox widget allows you to specify the width and height of a child as a fraction of the available space.

For example, the following code will create a Wrap widget that will wrap its children to the next line if there is not enough space to fit them on the current line. The FractionallySizedBox widget will ensure that the children are always displayed at 50% of the available width:

```dart
import 'package:flutter/material.dart';

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Wrap(
          children: <Widget>[
            FractionallySizedBox(
              widthFactor: 0.5,
              child: Text('Text 1'),
            ),
            FractionallySizedBox(
              widthFactor: 0.5,
              child: Text('Text 2'),
            ),
            FractionallySizedBox(
              widthFactor: 0.5,
              child: Text('Text 3'),
            ),
            FractionallySizedBox(
              widthFactor: 0.5,
              child: Text('Text 4'),
            ),
            FractionallySizedBox(
              widthFactor: 0.5,
              child: Text('Text 5'),
            ),
          ],
        ),
      ),
    );
  }
}
```

This code will create a simple app with a list of Text widgets. The Wrap widget will wrap the Text widgets to the next line if there is not enough space to fit them on the current line. The FractionallySizedBox widget will ensure that the Text widgets are always displayed at 50% of the available width.

You can also use the MediaQuery widget to get the current size and orientation of the screen. This information can be used to adjust the layout of your app based on the device that it is running on.

For example, the following code will adjust the layout of the Wrap widget based on the current orientation of the screen:

```dart
import 'package:flutter/material.dart';

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final orientation = MediaQuery.of(context).orientation;

    return MaterialApp(
      home: Scaffold(
        body: Wrap(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            FractionallySizedBox(
              widthFactor: orientation == Orientation.portrait ? 0.5 : 0.25,
              child: Text('Text 1'),
            ),
            FractionallySizedBox(
              widthFactor: orientation == Orientation.portrait ? 0.5 : 0.25,
              child: Text('Text 2'),
            ),
            FractionallySizedBox(
              widthFactor: orientation == Orientation.portrait ? 0.5 : 0.25,
              child: Text('Text 3'),
            ),
            FractionallySizedBox(
              widthFactor: orientation == Orientation.portrait ? 0.5 : 0.25,
              child: Text('Text 4'),
            ),
            FractionallySizedBox(
              widthFactor: orientation == Orientation.portrait ? 0.5 : 0.25,
              child: Text('Text 5'),
            ),
          ],
        ),
      ),
    );
  }
}
```

This code will display the Text widgets in two columns when the device is in landscape mode. When the device is in portrait mode, the Text widgets will be displayed in a single column.

The Wrap widget is a powerful tool for creating responsive layouts in Flutter. By using the Wrap widget in conjunction with the FractionallySizedBox and MediaQuery widgets, you can create layouts that will look good on all devices.
