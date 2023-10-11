Using SQLite in a Flutter app involves several steps, from creating model classes to interacting with the database. Below is a step-by-step guide with code samples:

**Step 1: Add Dependencies**
You'll need to add the `sqflite` and `path_provider` packages to your `pubspec.yaml` file.

```yaml
dependencies:
  flutter:
    sdk: flutter
  sqflite: ^2.0.0
  path_provider: ^2.0.1
```

**Step 2: Create Model Class**
Define a model class for the data you want to store in the database. For example, let's create a `Book` class:

```dart
class Book {
  int? id;
  String title;
  int pages;

  Book({
    this.id,
    required this.title,
    required this.pages,
  });

  // Convert Book object to a Map
  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'title': title,
      'pages': pages,
    };
  }

  // Convert a Map to a Book object
  factory Book.fromMap(Map<String, dynamic> map) {
    return Book(
      id: map['id'],
      title: map['title'],
      pages: map['pages'],
    );
  }
}
```

**Step 3: Create a Database Helper Class**
Create a helper class to manage the database. This class will handle database creation, CRUD operations, and connection.

```dart
import 'package:sqflite/sqflite.dart';
import 'package:path_provider/path_provider.dart';

class DatabaseHelper {
  late Database _database;

  Future<void> open() async {
    final appDocumentDirectory = await getApplicationDocumentsDirectory();
    final databasePath = appDocumentDirectory.path + '/books.db';
    _database = await openDatabase(databasePath, version: 1, onCreate: _onCreate);
  }

  Future<void> _onCreate(Database db, int version) async {
    await db.execute('''
      CREATE TABLE books(
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        title TEXT,
        pages INTEGER
      )
    ''');
  }

  Future<int> insertBook(Book book) async {
    return await _database.insert('books', book.toMap());
  }

  Future<List<Book>> getBooks() async {
    final List<Map<String, dynamic>> maps = await _database.query('books');
    return List.generate(maps.length, (i) {
      return Book.fromMap(maps[i]);
    });
  }

  Future<int> updateBook(Book book) async {
    return await _database.update(
      'books',
      book.toMap(),
      where: 'id = ?',
      whereArgs: [book.id],
    );
  }

  Future<int> deleteBook(int id) async {
    return await _database.delete(
      'books',
      where: 'id = ?',
      whereArgs: [id],
    );
  }
}
```

**Step 4: UI Integration**
Now, you can integrate the database operations into your UI. Here's a simple example:

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text('SQLite Example')),
        body: BookList(),
      ),
    );
  }
}

class BookList extends StatefulWidget {
  @override
  _BookListState createState() => _BookListState();
}

class _BookListState extends State<BookList> {
  final dbHelper = DatabaseHelper();
  final List<Book> books = [];

  @override
  void initState() {
    super.initState();
    dbHelper.open();
    _refreshBookList();
  }

  Future<void> _refreshBookList() async {
    final list = await dbHelper.getBooks();
    setState(() {
      books.clear();
      books.addAll(list);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        ElevatedButton(
          onPressed: () async {
            final newBook = Book(title: 'Flutter Book', pages: 300);
            await dbHelper.insertBook(newBook);
            _refreshBookList();
          },
          child: Text('Add Book'),
        ),
        Expanded(
          child: ListView.builder(
            itemCount: books.length,
            itemBuilder: (context, index) {
              final book = books[index];
              return ListTile(
                title: Text(book.title),
                subtitle: Text('Pages: ${book.pages}'),
                trailing: IconButton(
                  icon: Icon(Icons.delete),
                  onPressed: () async {
                    await dbHelper.deleteBook(book.id!);
                    _refreshBookList();
                  },
                ),
              );
            },
          ),
        ),
      ],
    );
  }
}
```

In this code:

- We create a basic Flutter app with a list of books.
- We use the `DatabaseHelper` to manage database operations.
- When you press the "Add Book" button, a book is inserted into the database.
- The list of books is displayed in the UI, and you can delete books by pressing the delete button.

This code shows you how to create, read, update, and delete (CRUD) records in a SQLite database in a Flutter app. The `_refreshBookList` function retrieves books from the database and updates the UI.

Using the `toMap` and `fromMap` methods in the model class allows you to convert `Book` objects to maps that can be easily stored in the database and convert database records (maps) back to `Book` objects for use in your application. The `map` objects are used for serialization and deserialization of data to and from the database. This makes working with databases in Flutter more convenient.













  
