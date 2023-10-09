This tutorial provides an overview of various button types available in Flutter and provides code samples for each type. Here's an explanation of the different button types along with their corresponding code samples:



1. **Elevated Button:**
   - Elevated buttons have increased elevation, and their elevation increases when pressed.
   - You can style them using the `ElevatedButton.styleFrom` method.

   Example:
   ```dart
   ElevatedButton(
     onPressed: () {},
     style: ElevatedButton.styleFrom(
       elevation: 12.0,
       textStyle: const TextStyle(color: Colors.white),
     ),
     child: const Text('Elevated Button'),
   )
   ```

2. **Floating Action Button (FAB):**
   - Floating action buttons are small circular buttons that usually appear at the bottom-right corner of the screen.
   - Created using the `FloatingActionButton` widget.

   Example:
   ```dart
   FloatingActionButton(
     child: Icon(Icons.person),
     backgroundColor: Colors.green,
     foregroundColor: Colors.white,
     onPressed: () {},
   )
   ```

3. **Outlined Button:**
   - Outlined buttons have text in the center enclosed by a thin border.
   - Styling can be customized using properties provided by the Material package.

   Example:
   ```dart
   OutlinedButton(
     child: Text(
       'Outlined Button',
       style: TextStyle(color: Colors.green),
     ),
     onPressed: () {},
   )
   ```

4. **Icon Button:**
   - Icon buttons contain an icon and are often used to represent actions or options.
   - Created using the `IconButton` widget.

   Example:
   ```dart
   IconButton(
     splashColor: Colors.yellow,
     icon: Icon(Icons.code),
     color: Colors.green,
     onPressed: () {},
   )
   ```

5. **Text Button:**
   - Text buttons are simple text without any outline or boundary.
   - Created using the `TextButton` widget.

   Example:
   ```dart
   TextButton(
     child: Text(
       'Text Button',
       style: TextStyle(color: Colors.green),
     ),
     onPressed: () {},
   )
   ```

6. **Dropdown Button:**
   - Dropdown buttons provide a list of options that the user can choose from.
   - Implemented using the `DropdownButton` widget.

   Example:
   ```dart
   String dropdownValue = 'Profile';
   var items = ['Profile', 'Settings', 'Account', 'Go Premium', 'Logout'];

   DropdownButton(
     focusColor: Colors.green,
     value: dropdownValue,
     icon: Icon(Icons.keyboard_arrow_down),
     items: items.map((String item) {
       return DropdownMenuItem(
         value: item,
         child: Text(
           item,
           style: TextStyle(color: Colors.green),
         ),
       );
     }).toList(),
     onChanged: (String? newValue) {
       setState(() {
         dropdownValue = newValue!;
       });
     },
   )
   ```

7. **Pop Up Menu Button:**
   - Pop-up menu buttons are represented by three vertical dots.
   - They display a menu from which the user can select an option.
   - Implemented using the `PopupMenuButton` widget.

   Example:
   ```dart
   PopupMenuButton(
     itemBuilder: (context) => [
       PopupMenuItem(
         child: Text("Profile"),
         value: 1,
       ),
       // Add more menu items here
     ],
   )
   ```

These code samples demonstrate how to use different types of buttons in Flutter. You can choose the button type that best fits your app's design and functionality requirements.



  
