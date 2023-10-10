STEPS 1-----> MAKE CONTROLLER-Then make the item whose state will chage to be observable by adding ".obs"  e.g 10.obs

      class CounterController extends GetxController {
        var count = 0.obs; // "obs" makes it observable
      
        void increment() {
          count++;
        }
      }



STEP 2 ------> INSTANCIATE THE CONTROLLER ----> In the widget where the items whose state change , using Get.puy

class HomeScreen extends StatelessWidget {
  final CounterController counterController = Get.put(CounterController());



STEP 3 ---------> GetBuilder<CounterController>(
                      builder: (controller) {  }  to display the item whos state changes, put the widgets that willbe reduilt inside Obx

               GetBuilder<CounterController>(
                 builder: (controller) {
                   return Text(
                     'Count: ${controller.counter.value}',
                     style: TextStyle(fontSize: 24),
                   );
                 },
               ),


STEP 4 --------> USE THE CREATE CONTROLLER INSTANCE TO ACCESS THE METHODS TO CHANGE THE STATE---> use the counterController instance create in step 2 to access the methods to change the state


            ElevatedButton(
              onPressed: () {
                counterController.increment();
              },
              child: Text('Increment'),
            ),

























To use GetX for state management in Flutter, you can follow these steps:

1. Add the `get` package to your `pubspec.yaml` file and run `flutter pub get` to install it.

2. Import the necessary packages:
   ```dart
   import 'package:flutter/material.dart';
   import 'package:get/get.dart';
   ```

3. Create a controller class that extends `GetxController` and define your state variables and methods:
   ```dart
   class CounterController extends GetxController {
     RxInt counter = 0.obs;

     void increment() {
       counter.value++;
     }
   }
   ```

   In this example, the `CounterController` class extends `GetxController` and defines a single state variable `counter` of type `RxInt`. The `obs` extension is used to make the variable observable. The `increment` method is used to increment the value of `counter`.

4. In your widget, use `GetBuilder` or `GetX` widget to listen to changes in the state and update the UI accordingly:
   ```dart
   class CounterScreen extends StatelessWidget {
     final CounterController controller = Get.put(CounterController());

     @override
     Widget build(BuildContext context) {
       return Scaffold(
         appBar: AppBar(
           title: Text('Counter'),
         ),
         body: Center(
           child: Column(
             mainAxisAlignment: MainAxisAlignment.center,
             children: [
               GetBuilder<CounterController>(
                 builder: (controller) {
                   return Text(
                     'Count: ${controller.counter.value}',
                     style: TextStyle(fontSize: 24),
                   );
                 },
               ),
               SizedBox(height: 16),
               ElevatedButton(
                 onPressed: () {
                   controller.increment();
                 },
                 child: Text('Increment'),
               ),
             ],
           ),
         ),
       );
     }
   }
   ```

   In this example, the `CounterScreen` widget uses the `GetBuilder` widget to listen to changes in the `CounterController` state. The `builder` function is called whenever the state changes, and the UI is updated accordingly. The `controller.increment()` method is called when the button is pressed to increment the counter.

5. Run the app and observe the state changes in the UI.

By following these steps, you can use GetX for state management in Flutter. GetX provides a simple and reactive way to manage state in your app, allowing you to easily update the UI based on changes in the state variables.





     
