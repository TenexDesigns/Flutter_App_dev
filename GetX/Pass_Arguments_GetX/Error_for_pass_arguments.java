The error you're encountering, "NoSuchMethodError: '[]', Dynamic Call of null," typically occurs when you're trying to access an element of a null object or map. In this case, it seems like `Get.arguments` is returning `null`, indicating that no arguments were passed when navigating to the "details" route.

To fix this issue, make sure you are passing the arguments correctly when using `Get.toNamed`. Here's how you can pass arguments to the named route correctly:

1. When navigating to the "details" route, ensure that you provide the arguments as a map:

   ```dart
   Get.toNamed('/details', arguments: {'id': 123}); // Pass arguments as a map
   ```

2. In the destination route ("details" route), access the arguments using `Get.arguments`. However, always check if `Get.arguments` is null or not before accessing its properties:

   ```dart
   class DetailsScreen extends StatelessWidget {
     @override
     Widget build(BuildContext context) {
       final arguments = Get.arguments;

       // Check if arguments is not null and contains the 'id' key
       if (arguments != null && arguments.containsKey('id')) {
         final id = arguments['id'];

         return Scaffold(
           appBar: AppBar(
             title: Text('Details Screen'),
           ),
           body: Center(
             child: Text('Item ID: $id'),
           ),
         );
       } else {
         // Handle the case when 'id' argument is missing or null
         return Scaffold(
           appBar: AppBar(
             title: Text('Details Screen'),
           ),
           body: Center(
             child: Text('Item ID is missing or null.'),
           ),
         );
       }
     }
   }
   ```

By adding the null check and verifying the presence of the "id" key in the arguments map, you can handle cases where arguments are missing or null more gracefully and avoid the `NoSuchMethodError`.
