The `Radio` widget in Flutter is used to create a radio button, which allows users to select a single option from a group of options. Radio buttons are typically used when you have a list of mutually exclusive choices, and the user can select only one option.

Here are the key properties and parameters of the `Radio` widget:

- **`value` (required)**: Represents the value associated with the radio button. This value should be unique within the group of radio buttons. When a user selects a radio button, its `value` is passed to the `groupValue` property of a `RadioGroup` (typically a `RadioGroup<int>` for integer values) to indicate the selected option.

- **`groupValue` (required)**: Represents the currently selected value within the group of radio buttons. It should match the `value` of one of the radio buttons in the group. When a user selects a radio button, the `groupValue` is updated to match the `value` of the selected radio button.

- **`onChanged` (required)**: A callback function that is called when the radio button is tapped or selected. It typically updates the `groupValue` to match the `value` of the selected radio button.

- **`activeColor` (optional)**: The color of the radio button when it is selected.

Here's an example of how to use the `Radio` widget to create a group of radio buttons in Flutter:

```dart
import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  int selectedValue = 1; // Initially, the first radio button is selected.

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Radio Example'),
        ),
        body: Column(
          children: <Widget>[
            RadioListTile<int>(
              title: Text('Option 1'),
              value: 1,
              groupValue: selectedValue,
              onChanged: (value) {
                setState(() {
                  selectedValue = value;
                });
              },
            ),
            RadioListTile<int>(
              title: Text('Option 2'),
              value: 2,
              groupValue: selectedValue,
              onChanged: (value) {
                setState(() {
                  selectedValue = value;
                });
              },
            ),
            RadioListTile<int>(
              title: Text('Option 3'),
              value: 3,
              groupValue: selectedValue,
              onChanged: (value) {
                setState(() {
                  selectedValue = value;
                });
              },
            ),
          ],
        ),
      ),
    );
  }
}
```

In this example, we create a group of three radio buttons using `RadioListTile`, and we maintain the selected value in the `selectedValue` variable. When a user selects a radio button, the `onChanged` callback updates the `selectedValue`, and the selected radio button is highlighted based on the `groupValue`.



....
