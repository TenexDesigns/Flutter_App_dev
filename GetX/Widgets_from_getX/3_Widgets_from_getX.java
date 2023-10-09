The following are some of the widgets that come from the GetX package:

* **Obx:** The `Obx` widget is used to listen to changes to observables. When an observable changes, the `Obx` widget will automatically rebuild itself.
* **GetBuilder:** The `GetBuilder` widget is similar to the `Obx` widget, but it is more flexible. The `GetBuilder` widget allows you to rebuild only the part of the widget that is affected by the change to the observable.
* **GetView:** The `GetView` widget is a wrapper widget that provides a number of features, including:
    * Automatic dependency injection
    * Automatic state management
    * Automatic routing
* **GetMaterialApp:** The `GetMaterialApp` widget is a wrapper widget for the `MaterialApp` widget. It provides all of the features of the `MaterialApp` widget, plus the additional features of the `GetView` widget.

These are just a few of the widgets that come from the GetX package. GetX also provides a number of other widgets, such as `GetText`, `GetImage`, and `GetCheckbox`.

To use a widget from the GetX package, you need to import the `package:get/get_widget.dart` package. Once you have imported the package, you can use the widgets in your code like any other widgets.

Here is a code sample that shows how to use the `Obx` widget:

```dart
import 'package:get/get.dart';

class MyController extends GetxController {
  final count = Observable(0);

  void increment() {
    count.value++;
  }
}

class MyWidget extends StatelessWidget {
  final MyController controller = Get.find();

  @override
  Widget build(BuildContext context) {
    return Obx(() {
      return Text('${controller.count}');
    });
  }
}
```

In this code sample, we are using the `Obx` widget to listen to changes to the `count` observable. When the `count` observable changes, the `Obx` widget will automatically rebuild itself and display the new value of the `count` variable.

GetX widgets are a powerful tool for creating Flutter apps. They provide a number of features that can make your code more efficient, maintainable, and reusable.



  
