In Flutter, the `ElevatedButton` and `TextButton` widgets are commonly used for creating buttons in your app's user interface. Buttons are essential for user interaction and performing actions. Here's an overview of these button widgets, their properties, and examples of how to use them.

### `ElevatedButton` Widget

The `ElevatedButton` widget represents a Material Design elevated button. It typically has a raised appearance with a shadow to indicate that it's interactive.

**Properties/Parameters:**
- `onPressed`: A callback function that is called when the button is pressed.
- `style`: An optional `ButtonStyle` that allows you to customize the button's appearance, including its background color, text style, elevation, padding, and more.
- `child`: The widget to display as the button's label or content.

**Example:**

```dart
ElevatedButton(
  onPressed: () {
    // Callback when the button is pressed
    print("Button Pressed");
  },
  style: ElevatedButton.styleFrom(
    primary: Colors.blue, // Background color
    onPrimary: Colors.white, // Text color
    elevation: 3, // Shadow elevation
  ),
  child: Text("Elevated Button"),
)
```

### `TextButton` Widget

The `TextButton` widget represents a Material Design text button. It's typically used for less prominent actions and appears flat without elevation.

**Properties/Parameters:**
- `onPressed`: A callback function that is called when the button is pressed.
- `style`: An optional `ButtonStyle` that allows you to customize the button's appearance, including its text style, padding, and more.
- `child`: The widget to display as the button's label or content.

**Example:**

```dart
TextButton(
  onPressed: () {
    // Callback when the button is pressed
    print("Button Pressed");
  },
  style: TextButton.styleFrom(
    primary: Colors.blue, // Text color
  ),
  child: Text("Text Button"),
)
```

### Where to Use Button Widgets

Button widgets are used throughout your Flutter app's user interface wherever you need to trigger actions or navigate to different parts of your app. Common use cases include:

1. **Login and Sign-Up Forms:** Use buttons to submit forms or perform authentication actions.

2. **Navigation:** Buttons are often used for navigation, such as moving to another screen or page within the app.

3. **Dialogs and Modals:** Buttons can be used in dialogs or modals to confirm or dismiss actions.

4. **Actions in Lists:** Buttons can be placed within lists or item widgets to perform specific actions for each item.

5. **Floating Action Button (FAB):** The `FloatingActionButton` is a special button typically used for the primary action in a screen or view.

6. **Toolbar or AppBar:** Buttons are often placed in app bars for actions like searching or refreshing content.

Remember to customize the appearance of your buttons using the `style` parameter and the `ButtonStyle` class to match your app's design and branding.

Flutter also provides other types of buttons, including `OutlinedButton` and `IconButton`, which have similar usage patterns and customization options. You can choose the button type that best fits your app's design and functionality.



