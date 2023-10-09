In Flutter, the term "context" is used to refer to the current location of a widget within the widget tree. Each widget has its own context, which is a reference to the location of the widget in the widget tree. This context is passed around throughout the application and provides a handle to the parent widget and the underlying `RenderObject` [Source 8](https://www.flutterclutter.dev/flutter/basics/what-is-a-buildcontext/2021/71268/).

A `BuildContext` object belongs to a `Widget`. It's a handle for looking up inherited widgets. `BuildContext` is actually a reference to the location of a widget in the widget tree rather than to the widget itself. Widgets have a one-to-one relationship with `BuildContext` objects and can be used to lookup another widget in the tree, such as an inherited widget [Source 5](https://api.flutter.dev/flutter/widgets/BuildContext-class.html).

In Flutter, every function that builds a widget will have a `BuildContext` parameter:

```dart
Widget build(BuildContext context) {
  return Container();
}
```

This `context` parameter is used by the `build` function to interact with the Flutter framework. For example, you can use `context` to get the theme of your app:

```dart
Widget build(BuildContext context) {
  return Text(
    'Hello, World!',
    style: Theme.of(context).textTheme.headline4,
  );
}
```

This `Theme.of(context)` usage is an example of how `BuildContext` is used to access an inherited widget. It will walk up the widget tree until it finds the nearest `Theme` widget, and then return its data [Source 2](https://medium.com/flutter-community/a-pragmatic-guide-to-buildcontext-in-flutter-b5302aef277c).

