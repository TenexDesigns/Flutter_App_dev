To use SQLite database in Flutter, you can use the `sqflite` package. Here's a step-by-step guide on how to do it:

1. **Add the necessary dependencies to your `pubspec.yaml` file**:

```yaml
dependencies:
  flutter:
    sdk: flutter
  sqflite: ^2.0.0+4
  path_provider: ^2.0.5
```

2. **Create a model class**:

```dart
class Book {
  final int id;
  final String title;
  final int pages;

  Book({required this.id, required this.title, required this.pages});

  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'title': title,
      'pages': pages,
    };
  }

  static Book fromMap(Map<String, dynamic> map) {
    return Book(
      id: map['id'],
      title: map['title'],
      pages: map['pages'],
    );
  }
}
```

In this example, `Book` is a model class that represents a book with an `id`, `title`, and `pages`. The `toMap` method is used to convert a `Book` object to a `Map` object, and the `fromMap` method is used to convert a `Map` object to a `Book` object. This is necessary because SQLite in Flutter works with `Map` objects.

3. **Create a database helper class**:

```dart
import 'package:path/path.dart';
import 'package:sqflite/sqflite.dart';

class DatabaseHelper {
  static final _databaseName = "MyDatabase.db";
  static final _databaseVersion = 1;

  static final table = 'books';

  static final columnId = 'id';
  static final columnTitle = 'title';
  static final columnPages = 'pages';

  // make this a singleton class
  DatabaseHelper._privateConstructor();
  static final DatabaseHelper instance = DatabaseHelper._privateConstructor();

  // only have a single app-wide reference to the database
  static Database? _database;
  Future<Database> get database async {
    if (_database != null) return _database!;
    _database = await _initDatabase();
    return _database!;
  }

  // this opens the database (and creates it if it doesn't exist)
  _initDatabase() async {
    String path = join(await getDatabasesPath(), _databaseName);
    return await openDatabase(path,
        version: _databaseVersion,
        onCreate: _onCreate);
  }

  // SQL code to create the database table
  Future _onCreate(Database db, int version) async {
    await db.execute('''
          CREATE TABLE $table (
            $columnId INTEGER PRIMARY KEY,
            $columnTitle TEXT NOT NULL,
            $columnPages INTEGER NOT NULL
          )
          ''');
  }

  // Helper methods

  Future<int> insert(Book book) async {
    Database db = await instance.database;
    var res = await db.insert(table, book.toMap());
    return res;
  }

  Future<List<Book>> queryAllRows() async {
    Database db = await instance.database;
    var res = await db.query(table);
    List<Book> list =
        res.isNotEmpty ? res.map((c) => Book.fromMap(c)).toList() : [];
    return list;
  }

  Future<int> update(Book book) async {
    Database db = await instance.database;
    return await db.update(table, book.toMap(),
        where: '$columnId = ?', whereArgs: [book.id]);
  }

  Future<int> delete(int id) async {
    Database db = await instance.database;
    return await db.delete(table, where: '$columnId = ?', whereArgs: [id]);
  }
}
```

In this example, `DatabaseHelper` is a singleton class that provides methods to interact with the SQLite database. The `_initDatabase` method is used to open the database and create it if it doesn't exist. The `_onCreate` method is used to create the `books` table in the database. The `insert`, `queryAllRows`, `update`, and `delete` methods are used to perform CRUD operations on the `books` table.

4. **Connect to the UI**:

```dart
void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  final dbHelper = DatabaseHelper.instance;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('SQLite Example'),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              RaisedButton(
                child: Text('insert'),
                onPressed: () async {
                  // insert a book
                  int i = await dbHelper.insert(
                    Book(id: 0, title: 'Flutter in Action', pages
