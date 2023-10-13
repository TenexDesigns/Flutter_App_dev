To clear the text from the `TextFormField` after pressing the submit button, you can reset the controllers' text values to empty strings in the `_submitForm` method. Here's how you can modify your `_submitForm` method to clear the text fields:

```dart
void _submitForm() {
  if (_formKey.currentState!.validate()) {
    // Form is valid, perform submission logic here
    String name = _nameController.text;
    String email = _emailController.text;
    print("The name is $name, and my email is $email");

    // Clear the text in the controllers
    _nameController.clear();
    _emailController.clear();

    // Show a snackbar for successful completion
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(content: Text('Form submitted successfully')),
    );
  }
}
```

In this modified `_submitForm` method, after processing the form data and displaying the success snackbar, we call the `clear()` method on both `_nameController` and `_emailController` to clear their text values, effectively resetting the `TextFormField` widgets.

This way, after the user presses the submit button, the text fields will be cleared, and the form is ready for the user to input new data.



---------------------------------------------------------------------------------------------------------------------------------------------




To remove the text from the text field after pressing the submit button, you can use the `controller.clear()` method.

Here is an example:

```dart
class MyForm2 extends StatefulWidget {
  const MyForm2({super.key});

  @override
  State<MyForm2> createState() => _MyForm2State();
}

class _MyForm2State extends State<MyForm2> {

  final _formKey = GlobalKey<FormState>();
  final _nameController = TextEditingController();
  final _emailController = TextEditingController();

  @override
  void dispose() {
    _nameController.dispose();
    _emailController.dispose();
    super.dispose();
  }

  void _submitForm() {
    if (_formKey.currentState!.validate()) {
      // Form is valid, perform submission logic here
      String name = _nameController.text;
      String email = _emailController.text;
      print("The name is$name, and my email is $email");

      // Clear the text fields
      _nameController.clear();
      _emailController.clear();

      // Show a snackbar for successful completion
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Form submitted successfully')),
      );
    }
  }


  @override
  Widget build(BuildContext context) {
    return Form(
      key: _formKey,
      child: Column(
        children: [
          TextFormField(
            controller: _nameController,
            decoration: InputDecoration(labelText: 'Name'),
            validator: (value) {
              if (value == null || value.isEmpty) {
                return 'Please enter your name';
              }
              return null;
            },
          ),
          TextFormField(
            controller: _emailController,
            decoration: InputDecoration(labelText: 'Email'),
            validator: (value) {
              if (value == null || value.isEmpty) {
                return 'Please enter your email';
              }
              if (!value.contains('@')) {
                return 'Please enter a valid email';
              }
              return null;
            },
          ),
          ElevatedButton(
            onPressed: _submitForm,
            child: Text('Submit'),
          ),
        ],
      ),
    );
  }
}
```

This will clear the text fields after the form is submitted, and show a snackbar to indicate that the form was submitted successfully.
























