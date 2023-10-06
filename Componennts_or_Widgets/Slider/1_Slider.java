The `Slider` widget in Flutter allows users to select a value from a continuous range by sliding a thumb along a track. It's commonly used for settings screens, media player volume controls, and other scenarios where users need to specify a numeric value within a given range.

Here's how to use the `Slider` widget in Flutter, along with its key properties:

```dart
Slider(
  value: _sliderValue, // The current value of the slider.
  onChanged: (double newValue) {
    setState(() {
      _sliderValue = newValue; // Update the slider value when it changes.
    });
  },
  min: 0.0, // Minimum value of the slider.
  max: 100.0, // Maximum value of the slider.
  divisions: 10, // Number of discrete intervals or divisions.
  label: '$_sliderValue', // Displayed label (can be customized).
  activeColor: Colors.blue, // Color of the active part of the slider.
  inactiveColor: Colors.grey, // Color of the inactive part of the slider.
)
```

Here's a breakdown of the key properties of the `Slider` widget:

- **`value`**: A double that represents the current value of the slider. You typically maintain this value in the state of your widget and update it when the slider's value changes.

- **`onChanged`**: A callback function that gets called when the user interacts with the slider. It takes a double parameter representing the new value of the slider. You should use this callback to update the `value` in your widget's state.

- **`min`**: A double representing the minimum value of the slider.

- **`max`**: A double representing the maximum value of the slider.

- **`divisions`**: An optional integer that divides the slider into discrete intervals. If provided, the user can only select values at these intervals.

- **`label`**: An optional string that can display a label near the thumb of the slider. This is useful for displaying the current value.

- **`activeColor`**: The color of the active part of the slider (the part before the thumb).

- **`inactiveColor`**: The color of the inactive part of the slider (the part after the thumb).

Here's an example of a simple Flutter app that uses a `Slider` widget:

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
          title: Text('Slider Example'),
        ),
        body: Center(
          child: SliderDemo(),
        ),
      ),
    );
  }
}

class SliderDemo extends StatefulWidget {
  @override
  _SliderDemoState createState() => _SliderDemoState();
}

class _SliderDemoState extends State<SliderDemo> {
  double _sliderValue = 50.0;

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text('Value: $_sliderValue'),
        Slider(
          value: _sliderValue,
          onChanged: (double newValue) {
            setState(() {
              _sliderValue = newValue;
            });
          },
          min: 0.0,
          max: 100.0,
          divisions: 10,
          label: '$_sliderValue',
          activeColor: Colors.blue,
          inactiveColor: Colors.grey,
        ),
      ],
    );
  }
}
```

In this example, we've created a simple Flutter app with a slider that allows users to select a value between 0 and 100. The current slider value is displayed above the slider, and it updates when the slider thumb is moved.
