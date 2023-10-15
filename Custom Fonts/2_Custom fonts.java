To use custom fonts in Flutter, you need to follow these steps:

1. Add your custom font files into your project. Usually, you would create a new directory, `fonts`, in the root of your project, and add the font files there.

2. Update the `pubspec.yaml` file to include the font files. Here's an example:

```yaml
flutter:
  fonts:
    - family: MyCustomFont
      fonts:
        - asset: fonts/MyCustomFont-Regular.ttf
        - asset: fonts/MyCustomFont-Bold.ttf
          weight: 700
```

In the above example, `MyCustomFont` is the name you'll use to reference the font in your code. The `asset` is the path to the font file. If you have different font styles (like bold, italic), you can specify them with the `weight` and `style` attributes.

3. Use the custom font in your widgets:

```dart
Text(
  'This is my custom font',
  style: TextStyle(
    fontFamily: 'MyCustomFont',
    fontSize: 30.0,
  ),
);
```

In the above example, we're using the `Text` widget with a `TextStyle` that specifies the `fontFamily` as `MyCustomFont`, which is the name we defined in the `pubspec.yaml` file.

Remember to run `flutter pub get` in your terminal after updating the `pubspec.yaml` file to fetch the necessary resources.

Sources:
- [Flutter Documentation: Using Custom Fonts](https://flutter.dev/docs/cookbook/design/fonts)
- [Flutter Cookbook: Use a custom font](https://flutter.dev/docs/cookbook/design/fonts)



                                        ....
