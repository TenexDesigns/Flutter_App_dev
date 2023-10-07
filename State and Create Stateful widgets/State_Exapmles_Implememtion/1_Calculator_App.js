This Flutter code represents a simple interest calculator app. It allows users to calculate the total returns on an investment based on the principal amount, rate of interest (ROI), and the investment term. Additionally, users can select the currency for the result. The code demonstrates how to use state in a Flutter app to manage and update the UI.

Here's a breakdown of the code with explanations and code samples:

1. **Main Function and App Initialization:**

   The `main()` function initializes the Flutter app. It sets up the app's title, theme, and the initial screen, which is an instance of `SIForm`.

   ```dart
   void main() {
     runApp(
       MaterialApp(
         debugShowCheckedModeBanner: false,
         title: 'Simple Interest Calculator App',
         home: SIForm(),
         theme: ThemeData(
           brightness: Brightness.dark,
           primaryColor: Colors.indigo,
           accentColor: Colors.indigoAccent,
         ),
       ),
     );
   }
   ```

2. **Stateful Widget: `SIForm`**

   `SIForm` is a stateful widget that represents the main form of the interest calculator app. It creates an instance of `_SIFormState`.

   ```dart
   class SIForm extends StatefulWidget {
     @override
     State<StatefulWidget> createState() {
       return _SIFormState();
     }
   }
   ```

3. **State Class: `_SIFormState`**

   `_SIFormState` is a private class that extends `State` and is responsible for managing the state of the `SIForm` widget. It includes the following:

   - `_currencies`: A list of currency options.
   - `_currentItemSelected`: The currently selected currency.
   - `TextEditingController` objects for handling user input.
   - `displayResult`: The result to be displayed.
   
   ```dart
   class _SIFormState extends State<SIForm> {
     var _currencies = ['Rupees', 'Dollars', 'Pounds'];
     final double _minimumPadding = 5.0;
     var _currentItemSelected = '';
     // ... (controllers and displayResult)
   }
   ```

4. **`initState()` Method:**

   The `initState()` method is called when the widget is initialized. It sets the initial currency selection to the first item in the `_currencies` list.

   ```dart
   @override
   void initState() {
     super.initState();
     _currentItemSelected = _currencies[0];
   }
   ```

5. **Build Method:**

   The `build` method defines the UI layout of the app. It includes input fields for principal, ROI, and term, as well as a dropdown for currency selection. Buttons for calculation and resetting are also provided.

   ```dart
   @override
   Widget build(BuildContext context) {
     // ... (UI layout)
   }
   ```

6. **Button Actions and State Management:**

   - The "Calculate" button's `onPressed` function calculates the total returns and updates the `displayResult`. It uses `setState()` to trigger a UI update.

     ```dart
     onPressed: () {
       setState(() {
         this.displayResult = _calculateTotalReturns();
       });
     },
     ```

   - The "Reset" button's `onPressed` function resets all input fields and clears the result.

     ```dart
     onPressed: () {
       setState(() {
         _reset();
       });
     },
     ```

7. **Helper Methods:**

   - `_onDropDownItemSelected()`: Updates the selected currency when the dropdown value changes.

   - `_calculateTotalReturns()`: Performs the interest calculation based on user input.

   - `_reset()`: Clears input fields and resets the result.

8. **Image Asset:**

   The `getImageAsset()` method displays an image in the app.

9. **Dropdown Menu Items:**

   The dropdown widget allows users to select a currency for the result.

10. **TextFields:**

    TextFields for principal, ROI, and term allow users to enter numeric values.

11. **Result Display:**

    The calculated result is displayed in a `Text` widget.

This code provides a basic example of how state management works in Flutter. The `setState()` method is used to trigger UI updates when the state changes. Users can enter values, calculate results, and reset the form using the provided buttons.






  ------------------------------------------------------------------------------------------------------------------------------------------------------------















import 'package:flutter/material.dart';

void main() {

	runApp(
		MaterialApp(
			debugShowCheckedModeBanner: false,
			title: 'Simple Interest Calculator App',
			home: SIForm(),
			theme: ThemeData(
				brightness: Brightness.dark,
				primaryColor: Colors.indigo,
				accentColor: Colors.indigoAccent
			),

		)
	);
}

class SIForm extends StatefulWidget {

	@override
  State<StatefulWidget> createState() {

    return _SIFormState();
  }
}

class _SIFormState extends State<SIForm> {

	var _currencies = ['Rupees', 'Dollars', 'Pounds'];
	final double  _minimumPadding = 5.0;

	var _currentItemSelected = '';

	@override
	void initState() {
		super.initState();
		_currentItemSelected = _currencies[0];
	}

	TextEditingController principalController = TextEditingController();
	TextEditingController roiController       = TextEditingController();
	TextEditingController termController      = TextEditingController();

	var displayResult = '';

	@override
  Widget build(BuildContext context) {

		TextStyle textStyle = Theme.of(context).textTheme.title;

    return Scaffold(
//			resizeToAvoidBottomPadding: false,
	    appBar: AppBar(
		    title: Text('Simple Interest Calculator'),
	    ),

	    body: Container(
		    margin: EdgeInsets.all(_minimumPadding * 2),
		    child: ListView(
			    children: <Widget>[

				    getImageAsset(),

				    Padding(
					    padding: EdgeInsets.only(top: _minimumPadding, bottom: _minimumPadding),
					    child: TextField(
					    keyboardType: TextInputType.number,
					    style: textStyle,
					    controller: principalController,
					    decoration: InputDecoration(
						    labelText: 'Principal',
						    hintText: 'Enter Principal e.g. 12000',
						    labelStyle: textStyle,
						    border: OutlineInputBorder(
							    borderRadius: BorderRadius.circular(5.0)
						    )
					    ),
				    )),

				    Padding(
					    padding: EdgeInsets.only(top: _minimumPadding, bottom: _minimumPadding),
					    child: TextField(
					    keyboardType: TextInputType.number,
					    style: textStyle,
					    controller: roiController,
					    decoration: InputDecoration(
							    labelText: 'Rate of Interest',
							    hintText: 'In percent',
							    labelStyle: textStyle,
							    border: OutlineInputBorder(
									    borderRadius: BorderRadius.circular(5.0)
							    )
					    ),
				    )),

				    Padding(
					    padding: EdgeInsets.only(top: _minimumPadding, bottom: _minimumPadding),
					    child: Row(
					    children: <Widget>[

						    Expanded(child: TextField(
							    keyboardType: TextInputType.number,
							    style: textStyle,
							    controller: termController,
							    decoration: InputDecoration(
									    labelText: 'Term',
									    hintText: 'Time in years',
									    labelStyle: textStyle,
									    border: OutlineInputBorder(
											    borderRadius: BorderRadius.circular(5.0)
									    )
							    ),
						    )),

						    Container(width: _minimumPadding * 5,),

						    Expanded(child: DropdownButton<String>(
							    items: _currencies.map((String value) {
							    	return DropdownMenuItem<String>(
									    value: value,
									    child: Text(value),
								    );
							    }).toList(),

							    value: _currentItemSelected,

							    onChanged: (String newValueSelected) {
							    	// Your code to execute, when a menu item is selected from dropdown
								    _onDropDownItemSelected(newValueSelected);
							    },

						    ))


					    ],
				    )),

				    Padding(
					    padding: EdgeInsets.only(bottom: _minimumPadding, top: _minimumPadding),
					    child: Row(children: <Widget>[
				    	Expanded(
						    child: RaisedButton(
							    color: Theme.of(context).accentColor,
							    textColor: Theme.of(context).primaryColorDark,
							    child: Text('Calculate', textScaleFactor: 1.5,),
							    onPressed: () {
										setState(() {
										  this.displayResult = _calculateTotalReturns();
										});
							    },
						    ),
					    ),

					    Expanded(
						    child: RaisedButton(
							    color: Theme.of(context).primaryColorDark,
							    textColor: Theme.of(context).primaryColorLight,
							    child: Text('Reset', textScaleFactor: 1.5,),
							    onPressed: () {
										setState(() {
										  _reset();
										});
							    },
						    ),
					    ),

				    ],)),

				    Padding(
					    padding: EdgeInsets.all(_minimumPadding * 2),
					    child: Text(this.displayResult, style: textStyle,),
				    )

			    ],
		    ),
	    ),
    );
  }

  Widget getImageAsset() {

		AssetImage assetImage = AssetImage('images/money.png');
		Image image = Image(image: assetImage, width: 125.0, height: 125.0,);

		return Container(child: image, margin: EdgeInsets.all(_minimumPadding * 10),);
  }

  void _onDropDownItemSelected(String newValueSelected) {
		setState(() {
		  this._currentItemSelected = newValueSelected;
		});
  }

  String _calculateTotalReturns() {

		double principal = double.parse(principalController.text);
		double roi = double.parse(roiController.text);
		double term = double.parse(termController.text);

		double totalAmountPayable = principal + (principal * roi * term) / 100;

		String result = 'After $term years, your investment will be worth $totalAmountPayable $_currentItemSelected';
		return result;
  }

  void _reset() {
		principalController.text = '';
		roiController.text = '';
		termController.text = '';
		displayResult = '';
		_currentItemSelected = _currencies[0];
  }
}





