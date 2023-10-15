To use custom fonts in Flutter, you need to add the font files to your project and define them in your `pubspec.yaml` file. Then, you can use these custom fonts in your Flutter app. Here's a step-by-step guide with code samples:

**1. Add Custom Fonts to Your Project:**

   First, you need to obtain the custom font files (e.g., `.ttf` or `.otf` files). Once you have the font files, add them to your Flutter project in a folder, typically named "fonts," located in the root of your project directory.

   Your project structure might look like this:

   ```
   my_flutter_project/
   ├── fonts/
   │   ├── custom_font_regular.ttf
   │   ├── custom_font_bold.ttf
   ├── lib/
   ├── ...
   ```

**2. Define Custom Fonts in `pubspec.yaml`:**

   Open your `pubspec.yaml` file, and inside the `flutter` section, define the custom fonts using the `fonts` attribute. Specify the path to the font files and assign them a family name.

   ```yaml
   flutter:
     fonts:
       - family: CustomFont
         fonts:
           - asset: fonts/custom_font_regular.ttf
           - asset: fonts/custom_font_bold.ttf
   ```

**3. Load Custom Fonts in Your Flutter App:**

   To load and use the custom fonts, you can define a text style with your custom font family. Here's an example:

   ```dart
   import 'package:flutter/material.dart';

   void main() {
     runApp(
       MaterialApp(
         home: Scaffold(
           appBar: AppBar(
             title: Text('Custom Fonts Example'),
           ),
           body: Center(
             child: Text(
               'Hello, Custom Fonts!',
               style: TextStyle(
                 fontFamily: 'CustomFont', // Use the defined font family
                 fontWeight: FontWeight.bold,
                 fontSize: 24.0,
               ),
             ),
           ),
         ),
       ),
     );
   }
   ```

In this example, the `TextStyle` specifies the `fontFamily` as 'CustomFont,' which matches the family name defined in the `pubspec.yaml` file. You can set the font weight, size, and other text style properties as needed.

**4. Hot Reload and Run:**

   After defining the custom fonts and their usage, save your code and run your Flutter app. You should see the custom font applied to the text.

By following these steps, you can use custom fonts in your Flutter app. Make sure to adjust the `fontFamily` value in the `TextStyle` to match the family name you defined in your `pubspec.yaml` file. This way, you can easily use your custom fonts for various text elements throughout your app.
