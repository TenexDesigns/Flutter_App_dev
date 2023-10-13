In Flutter, you can create a Bottom Navigation Bar using the `BottomNavigationBar` widget. A Bottom Navigation Bar is typically used to switch between different screens or sections of an app. Here's how you can use it with code samples, including its parameters, handling active items, and determining the color of the active bar item:

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _selectedIndex = 0;

  // Define the pages or screens you want to switch between.
  final List<Widget> _pages = [
    FirstScreen(),
    SecondScreen(),
    ThirdScreen(),
  ];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Bottom Navigation Bar Example'),
      ),
      body: _pages[_selectedIndex],
      bottomNavigationBar: BottomNavigationBar(
        items: <BottomNavigationBarItem>[
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Home',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.business),
            label: 'Business',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.school),
            label: 'School',
          ),
        ],
        currentIndex: _selectedIndex,
        onTap: _onItemTapped,
        type: BottomNavigationBarType.fixed, // Use this for more than three items
        selectedItemColor: Colors.blue, // Color of the active item
        unselectedItemColor: Colors.grey, // Color of the inactive items
        showUnselectedLabels: true, // Show labels for inactive items
      ),
    );
  }
}

class FirstScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Text('Home Screen'),
    );
  }
}

class SecondScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Text('Business Screen'),
    );
  }
}

class ThirdScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Text('School Screen'),
    );
  }
}
```

In this code sample, we create a Flutter app with a Bottom Navigation Bar containing three items: Home, Business, and School. When you tap an item, the `_onItemTapped` function updates the `_selectedIndex`, which then switches the displayed screen using `_pages[_selectedIndex]`.

Key points to note:

- `_selectedIndex` is used to track the active item in the navigation bar.
- The `BottomNavigationBar` widget is defined with items, currentIndex, and a callback function for item selection (`onTap`).
- You can customize the appearance by setting `selectedItemColor`, `unselectedItemColor`, and other properties to control how the bar items look.

This code provides a basic example of a Bottom Navigation Bar in Flutter. You can customize it further to fit your specific app's needs.




  ....
