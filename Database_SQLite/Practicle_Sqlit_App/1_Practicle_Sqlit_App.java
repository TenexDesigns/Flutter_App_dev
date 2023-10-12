
1_ Components folder
  
  BookUI.dart

  import 'package:cars2/model/Book.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import '../controllers/BookController.dart'; // Import the 'get' package



class BookList extends StatelessWidget { // Extend GetView instead of StatefulWidget


  final BookController bookController = Get.put(BookController());
  
  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        ElevatedButton(
          onPressed: () async {
            final newBook = Book(title: 'Flutter Book', pages: 300);
            bookController.insertBook(newBook); // Use GetX controller for the operation
          },
          child: Text('Add Book'),
        ),
        Expanded(
          child: FutureBuilder(
            future: bookController.getBooks(),
            builder: (context, snapshot) {
              if (snapshot.hasData) {

                return Obx(() => ListView.builder(
                  itemCount: bookController.books.length,
                  itemBuilder: (context, index) {
                    final book = bookController.books[index];
                    return ListTile(
                      title: Text(book.title),
                      subtitle: Text('Pages: ${book.pages}'),
                      trailing: IconButton(
                        icon: Icon(Icons.delete),
                        onPressed: () {
                          bookController.deleteBook(book.id!);
                        },
                      ),
                    );
                  },
                ));
              } else if (snapshot.hasError) {
                return Text('Error loading items: ${snapshot.error}');
              } else {
                return CircularProgressIndicator();
              }
            },
          )

        ),
      ],
    );
  }
}


2_controllers folder


  import 'package:get/get.dart';
import '../model/Book.dart';
import '../services/BookService.dart';



class BookController extends GetxController {
  final dbHelper = DatabaseHelper();
  final books = <Book>[].obs;



  @override
  void onInit() {
    dbHelper.open();
    _refreshBookList();
    super.onInit();
  }

  Future<void> _refreshBookList() async {
    final list = await dbHelper.getBooks();
    books.clear();
    books.addAll(list);
  }

  Future<List<Book>> getBooks() async{
    final list = await dbHelper.getBooks();
    books.clear();
    books.addAll(list);
    return books;

  }

  Future<void> insertBook(Book newBook) async {
    await dbHelper.insertBook(newBook);
    _refreshBookList();
  }

  Future<void> deleteBook(int id) async {
    await dbHelper.deleteBook(id);
    _refreshBookList();
  }
}



3_  model folder

  Book.dart


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







4_ services folder


  BookService.dart


  import 'package:path_provider/path_provider.dart';
import 'package:sqflite/sqflite.dart';

import '../model/Book.dart';

class DatabaseHelper {
  late Database _database;

  Future<void> open() async {
    final appDocumentDirectory = await getApplicationDocumentsDirectory();
    final databasePath = '${appDocumentDirectory.path}/books.db';
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

    return maps.map((json) => Book.fromMap(json)).toList();
    
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

  




5_ main file


  class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return GetMaterialApp( // Replace MaterialApp with GetMaterialApp
      home: Scaffold(
        appBar: AppBar(title: Text('SQLite Example')),
        body: BookList(),
      ),
    );
  }
}















