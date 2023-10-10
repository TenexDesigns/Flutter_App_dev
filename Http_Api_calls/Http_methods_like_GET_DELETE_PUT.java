In Flutter, you can handle HTTP responses and make HTTP requests like GET, POST, DELETE, and PUT using the `http` package. Here's how you can handle HTTP responses and make HTTP requests for different HTTP methods:

### Handling HTTP Responses:

When you make an HTTP request using the `http` package, you get an `http.Response` object as a response. You can extract data and status information from this object.

Here's an example of how to handle an HTTP response:

```dart
import 'package:http/http.dart' as http;

Future<void> fetchData() async {
  final apiUrl = Uri.parse('https://api.example.com/data');

  final response = await http.get(apiUrl);

  if (response.statusCode == 200) {
    // Successful response, parse the data
    final responseData = jsonDecode(response.body);
    print('Data received: $responseData');
  } else {
    // Error response
    print('Failed to fetch data. Status code: ${response.statusCode}');
  }
}
```

In the above example, we use `http.get` to make a GET request. We check the response's status code using `response.statusCode` to determine if the request was successful. If successful (status code 200), we parse the response data using `jsonDecode(response.body)`. For other status codes, we handle errors.

### Making HTTP Requests:

You can use the `http` package to make various HTTP requests:

#### GET Request:

```dart
final response = await http.get(apiUrl);
```

#### POST Request:

```dart
final response = await http.post(
  apiUrl,
  headers: {'Content-Type': 'application/json'},
  body: jsonEncode(data), // data should be a Map or an object with a `toJson` method
);
```

#### PUT Request:

```dart
final response = await http.put(
  apiUrl,
  headers: {'Content-Type': 'application/json'},
  body: jsonEncode(data), // data should be a Map or an object with a `toJson` method
);
```

#### DELETE Request:

```dart
final response = await http.delete(apiUrl);
```

Make sure to replace `'https://api.example.com/data'` with the actual API endpoint you want to request or send data to.

The `http` package provides various methods for making HTTP requests and handling responses. You can adjust the request headers, pass data in the request body, and more, based on your specific API requirements.

Additionally, you may need to import the `dart:convert` library for working with JSON data, as shown in the examples.



..
